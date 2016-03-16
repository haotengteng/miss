package com.haoteng.miss4.resource;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haoteng.miss4.md.module.Account;
import com.haoteng.miss4.md.module.AccountDto;
import com.haoteng.miss4.md.service.AccountSrvice;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 *
 * Created by Administrator on 2016/3/15.
 */
@RestController
public class hello {
    Logger logger = (Logger) LoggerFactory.getLogger(hello.class);

    @Autowired
    AccountSrvice accountSrvice;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {
        logger.info("logback:hello");
        return "hello";
    }

    @RequestMapping(value = "callhello", method = RequestMethod.GET)
    public String callHello() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8088/hello").build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.code() + response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @RequestMapping(value = "openbank")
    public Object depositBank(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        boolean result = accountSrvice.AddAccount(account);
        JSONObject json = new JSONObject();
        json.put("result",result);
        return JSON.toJSONString(json);
    }
}
