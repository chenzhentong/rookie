package per.wkz.rookie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wkz.rookie.utils.UrlUtils;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@RestController
public class EmailController {


    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @GetMapping("/mail/send")
    private void send(HttpServletRequest request) throws Exception {

        long endTimes = System.currentTimeMillis()+3600*1000; //设置一小时有效时间。。

        String para = "chenzhentong"+";"+"1765770246@qq.com"+";"+endTimes;

        System.out.println("原文"+para);

        String encode = UrlUtils.enCryptAndEncode(para);

        System.out.println("加密"+encode); //http://www.cnblogs.com/haha12/p/4345070.html

        String old = UrlUtils.deCryptAndDecode(encode);

        System.out.println("解密："+old);

        String[] split = old.split(";");

        for (String string : split) {
            System.out.println(string);

        }
//        SimpleMailMessage message = new SimpleMailMessage();
//        // 发件人
//        message.setFrom(username);
//        // 收件人
//        message.setTo("1322533645@qq.com");
//        // 邮件标题
//        message.setSubject("重置密码");
//        // 邮件内容
//
//        String subject = "";
//
//        StringBuilder url =new StringBuilder();
//        url.append(request.getRequestURL());
//        url.append("/user/"+encode);
//
//        StringBuilder builder = new StringBuilder();
//        builder.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" </head><body>");
//        builder.append("请点击下方链接激活您的邮箱，完成激活邮箱的操作!");
//        builder.append("<br/><br/>");
//        builder.append("<a href=\"" + url + "\">");
//        builder.append(url);
//        builder.append("</a>");
//        builder.append("</body></html>");
//
//        System.out.println(builder.toString());
//        message.setText(builder.toString());
//        // 抄送人
//        message.setCc("1765770246@qq.com");
//        message.setSubject("邮箱地址激活");
//        mailSender.send(message);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("标题");
        messageHelper.setFrom("1765770246@qq.com");
        messageHelper.setTo("120217953@qq.com");
        messageHelper.setText("<h1>标题</h1><br/><p>这是内容</p>", true);
        mailSender.send(mimeMessage);

    }


}
