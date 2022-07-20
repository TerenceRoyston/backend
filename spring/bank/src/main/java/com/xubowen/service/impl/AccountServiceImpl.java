package com.xubowen.service.impl;

import com.xubowen.mapper.AccountMapper;
import com.xubowen.staticproxy.pojo.Account;
import com.xubowen.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/13 21:17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountServiceImpl implements AccountService {

    private AccountMapper accountMapper;

    // 校验转账转账账户信息
    @Override
    public Account accountOutInfoService(String outId, String outPwd) {
        return accountMapper.accountOutInfoMapper(outId, outPwd);
    }

    // 校验金额信息
    @Override
    public Account accountMoneyInfoService(String outId, String pwd, Double money) {
        return accountMapper.accountMoneyInfoMapper(outId, pwd, money);
    }

    // 校验入账账户信息
    @Override
    public Account accountInInfoService(String inId, String inName) {
        return accountMapper.accountInInfoMapper(inId, inName);
    }

    // 转账
    @Override
    public int transferService(String outId, String inId, Double money) {
        int i = accountMapper.transferOutMapper(outId, money);
        i += accountMapper.transferInMapper(inId, money);
        return i;
    }
}
