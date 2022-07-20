package com.xubowen.service;

import com.xubowen.staticproxy.pojo.Account;

/**
 * @author XuBowen
 * @date 2022/2/13 20:57
 */
public interface AccountService {
    // 校验转账账户信息
    Account accountOutInfoService(String outId,String outPwd);

    // 校验金额
    Account accountMoneyInfoService(String outId,String pwd,Double money);

    // 校验入账账户信息
    Account accountInInfoService(String inId,String inName);

    // 转账
    int transferService(String outId,String inId,Double money);
}
