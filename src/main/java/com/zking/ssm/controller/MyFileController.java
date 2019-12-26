package com.zking.ssm.controller;


import com.zking.ssm.dto.MyFileDto;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.MyFile;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.service.IMyFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping(value = "/myFile")
public class MyFileController {

    @Autowired
    private IMyFileService myFileService;

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/upload")
    public String upload(MyFileDto myFileDto, HttpServletRequest request) {
        System.out.println("upload...");
        Integer bookId = myFileDto.getBookId();
        MultipartFile file = myFileDto.getFile();
        System.out.println(bookId);
        System.out.println(file);

        String targetPath = "/upload" + File.separator + file.getOriginalFilename();
        System.out.println(targetPath);
        String realPath = request.getServletContext().getRealPath(targetPath);
        System.out.println(realPath);
        try {
            file.transferTo(new File(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //新增一条文件上传记录
        MyFile myFile = new MyFile();
        long fileId = System.currentTimeMillis();
        myFile.setFileId(fileId);
        myFile.setRealName(file.getOriginalFilename());
        myFile.setContentType(file.getContentType());
        myFile.setFilePath(targetPath);

        //修改图书本表的img字段
        Book book = new Book();
        book.setBookId(myFileDto.getBookId());
        book.setImg(fileId);
        bookService.updImg(book,myFile);
        return "redirect:/book/listBook";
    }


    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(@RequestParam Long fileId,HttpServletRequest request){

        //先根据文件id查询对应图片信息
        MyFile myFile = myFileService.selectByPrimaryKey(fileId);

        String targetPath = myFile.getFilePath();//虚拟路径
        String realPath = request.getServletContext().getRealPath(targetPath);//真实路径

        //下载关键代码
        File file=new File(realPath);//真实路径
        HttpHeaders headers = new HttpHeaders();//http头信息
//        String downloadFileName = new String(myFile.getRealName().getBytes("UTF-8"),"iso-8859-1");//设置编码
//        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
