package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Data
//@JsonIgnoreProperties(value = {"bookId"})
public class Book {

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增
        public static interface Add {
        }

        // 修改
        public static interface Edit {
        }
    }

    @NotNull(message = "书本id不能为空",groups = {ValidateGroups.Edit.class})
    private Integer bookId;

    @NotBlank(message = "书本名字不能为空",groups = {ValidateGroups.Add.class,ValidateGroups.Edit.class})
    @JsonProperty("name")
    private String bookName;

    @NotNull(message = "书本价格不能为空",groups = {ValidateGroups.Add.class,ValidateGroups.Edit.class})
    @Range(max = 100,min = 20,message = "书本价格必须在20-100之间")
    private Float price;

    @JsonIgnore
    private Long img;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createDate;

    public Book(Integer bookId, String bookName, Float price, Long img) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.img = img;
    }

    public Book() {
        super();
    }

//    public Integer getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(Integer bookId) {
//        this.bookId = bookId;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public Float getPrice() {
//        return price;
//    }
//
//    public void setPrice(Float price) {
//        this.price = price;
//    }
//
//    public Long getImg() {
//        return img;
//    }
//
//    public void setImg(Long img) {
//        this.img = img;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "bookId=" + bookId +
//                ", bookName='" + bookName + '\'' +
//                ", price=" + price +
//                ", img=" + img +
//                '}';
//    }
}