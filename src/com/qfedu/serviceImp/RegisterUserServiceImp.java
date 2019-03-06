package com.qfedu.serviceImp;

import com.qfedu.dao.RegisterUserDao;
import com.qfedu.daoImp.RegisterUserDaoImp;
import com.qfedu.domain.RegisterUser;
import com.qfedu.service.RegisterUserService;
import com.qfedu.util.EmailUtil;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.UUID;

public class RegisterUserServiceImp implements RegisterUserService {
    private RegisterUserDaoImp registerUserDaoImp;

    public RegisterUserDaoImp getRegisterUserDaoImp() {
        return registerUserDaoImp;
    }

    public void setRegisterUserDaoImp(RegisterUserDaoImp registerUserDaoImp) {
        this.registerUserDaoImp = registerUserDaoImp;
    }

    @Override
    public void userRegister(String username, String password, String email) {
        RegisterUser registerUser = new RegisterUser();

        // 填充属性
        registerUser.setUsername(username);
        registerUser.setPassword(password);
        registerUser.setEmail(email);

        // 获取UUID
        String uuid = UUID.randomUUID().toString().replace("-","");
        registerUser.setLinsence(uuid);

        // 构建Properties对象
        Properties properties = System.getProperties();
        try {
            properties.load(new FileInputStream("E:\\anzhuangbao\\java\\IdeaProject\\StudentManager\\src\\com\\qfedu\\util\\Email.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        EmailUtil emailUtil = new EmailUtil(properties.getProperty("mail.smtp"), properties.getProperty("mail.port"),
                properties.getProperty("mail.username"), properties.getProperty("mail.password"));

        String theme = "这是一封来自JavaEE的激活邮件";

        String content = "这里你看到的是一封激活邮件,请点击超链接激活...";
        emailUtil.sendMail(properties.getProperty("mail.username"), email, theme, content);
        registerUserDaoImp.insertUser(registerUser);

    }

    @Override
    public void userActive(String linsenceCode) {

    }




}
