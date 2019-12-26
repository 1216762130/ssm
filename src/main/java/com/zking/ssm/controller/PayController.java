package com.zking.ssm.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/pay")
public class PayController {

        private final String APP_ID = "2016101500692597";
        private final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC1cQws8nkpnP1oAY1zT47o5h0uhhAaM7E8y4xDAX945wbLZsyxV5/NKplSj2ucClKFEVinnC5XtzBBX2eRhQRUxyjMl92nhPZAodyu522Yn+aDyCdsPf3oWx0iE6rNmvvtsfdNNrQ/95T1DfrEq37ZPknax/rEcZm/BLl1++5U/MS9wj06LLm4ORy8UZLdYt/T25xL6cEvZlrfCfbhDeb/XSvQbezwkgi8uj5LCtBhFAAFiRERkXGT/qxXBFQSMvt0IFoXj3BrJxQfEEwDQ9JSqM5qVNtScSUelDmJfMBQKJJwEnbQ2/I+EwoK81pirB8EVgrm74mDVskJ/WuAKyVFAgMBAAECggEAW8p0MWz9tPqyDGL0r4hpMRPxYW77SHYsTShgrilc1spx2ocIOROuSXoqlOTvuMJUGvO6mRjfLQsFA52DZNAZb9ZNoquVvED835fDcEyuWk9SrAqfPxhhkqI9q9atS1UD7K1jAhIRwGa9WfgXjFWCV982N9OB3s3lzQhT1wd7/EwFea1hkqT1vytYKNZUOpdxjAbLM2eqrtSNvfWzyu5O5QA94aXNiJBylgogQ9SPFdDJsUIyuKMvECBlvNcxnrZTnZYJ68+anN8bvvJT0OJK1uWvJNOiavKXfsNQo1Mj8d0oFtJUI0koCA5I30aeMRSgOqSN/QLSKXnujn7jr9gE5QKBgQDox/qXYpEp1C0RXNkRXO9Y+jpiI8j6M5yWVUNthWz8ouSFD5+tks187eOvF4d7ydP5HsnvHVDeJVzQpzqm2Oe/pNs4D3jdMMP9e+sZ7X50RQ2DBeo2SXc5Y2kok7c/3t9AUtmyFVHrzOEg4Kajx3REsCQfzdEHGRRHqgS+cs86SwKBgQDHih9t8JMC9eHwBcyk+1aj6NSWasmArVxqBG7NHYCMkW5CaGofuLWgnPXvucPH5eCOiJQQNjlOA+Oq/I23liaX7uomGhUex4L3BpxSY62adJrWsD3WBbPM2dLDI8bZ0wmS8ULYWQFZCwgpiJC6CXLxDu+/5J2huQI5p/QmXxdkrwKBgHwV9f/yu/z3LJr/ynpV9wSQRsT/3Gd7UbJVex8Lq+A0GOrRPEYzZjR9Pwyb103mdYdroStEjlIMyqAzNLGyGD9xaqZEoSIPl7os71Mf5XOnR5+bbJFJsjM2Sd0meN2kOY+5WnByqvuueCeleU7+yHzBBFCrzwwgk03sVKEM5GhnAoGAHGm6l/kNtfo1Nexde5CegbCBtPl3v+7vndkLvgFZcKq0vJgJpIK0ui4fhwc4rZo6I5GnI7fU6Rr8rDhSJbYnwLKwfMRyBXP7Xhl+4Ox4p+m6sp9d7r/ZHm5V6JuLkTDPyDC6h/wEiR1dCCz+Dr+RsmmiEf0HxSOHAZa82UnpFtkCgYAtmW3xxa6LKiRvvGXBF4IFWJCNhMn18iPgWxPZz+eUxtco40oGXTSprKmuB7Ht9TQR2oa8bftYS8w2v2Ql3gP4V0w1qy6cV2n0NFG4nsVdwLBIaLhCSPaB6IquXW4GzovWGafhoLX+jfbwMckqHRW4KfIXLGeRZZ41qiXFKUyK+A==";
        private final String CHARSET = "UTF-8";
        private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq0dgQi7VVLKtmj1y4FsE8onVOghERbfCSF6jItdMPIxy16d0mrpWUweK/mO5rUVF1WqDocc6hw1SI78um43B5SVtMBd8W95kx7qmvt3nvoIVDrAL3sB02sQDAthj5wCBQ9Ia3ViVngwBrCkeU3ZzDI77lse1/xsiTOpTAUazfDcTTOStdAl9UpF5rdqeVSpEnzYdVOA5yUa1rXhL5QnnzChBdTU3qsrOrmuQFvcDm81OtrL4MdFEr4pCDmWzSm+1Yq5/4wD11vsyYsoEf0XB2Gts6Eh5xD4FEm7cCIMdL2V3FDrNi6WhO2PEnMCiqXcdKXkmz7k0R81JMeOugWVtswIDAQAB";
        //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
        private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
        private final String FORMAT = "JSON";
        //签名方式
        private final String SIGN_TYPE = "RSA2";
        //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
        private final String NOTIFY_URL = "http://localhost:8080/ssm/";
        //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
        private final String RETURN_URL = "http://localhost:8080/ssm/";

    @RequestMapping("alipay")
    public void alipay(HttpServletResponse httpResponse) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(r.nextInt(999999)+10000);
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }



    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态

//            payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }

}



