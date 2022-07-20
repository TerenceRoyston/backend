package com.xubowen.controller;

import com.xubowen.staticproxy.pojo.Account;
import com.xubowen.service.AccountService;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2022/2/13 22:04
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        accountService = (AccountService) ac.getBean("account");
    }

    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String methodName = req.getParameter("methodName");
        if (methodName.equals("outMethod")){
            this.outMethod(req,resp);
        }else if (methodName.equals("moneyMethod")){
            this.moneyMethod(req,resp);
        }else if (methodName.equals("inMethod")){
            this.inMethod(req,resp);
        }else if (methodName.equals("transferMethod")){
            this.transferMethod(req,resp);
        }

    }

    // 校验转账账户信息
    public void outMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String outId = req.getParameter("outId");
        String outPwd = req.getParameter("outPwd");
        Account account = accountService.accountOutInfoService(outId, outPwd);
        resp.getWriter().write((account!=null)+"");
    }


    // 校验金额
    public void moneyMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String outId = req.getParameter("outId");
        String outPwd = req.getParameter("outPwd");
        Double money = Double.valueOf(req.getParameter("money"));
        Account account = accountService.accountMoneyInfoService(outId, outPwd,money);
        resp.getWriter().write((account!=null)+"");
    }

    // 校验入账账户信息
    public void inMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String inId = req.getParameter("inId");
        String inName = req.getParameter("inName");
        Account account = accountService.accountInInfoService(inId, inName);
        resp.getWriter().write((account!=null)+"");
    }

    // 转账
    public void transferMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        String outId = req.getParameter("outId");
        String inId = req.getParameter("inId");
        Double money = Double.valueOf(req.getParameter("money"));

        int i = accountService.transferService(outId, inId, money);

        resp.getWriter().write((i==2)+"");
    }
}
