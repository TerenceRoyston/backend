package com.xubowen.mapper;

import com.xubowen.staticproxy.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author XuBowen
 * @date 2022/2/13 16:25
 */
public interface AccountMapper {

    // 转账账户信息查询
    @Select("select * from t_account where aid=#{outId} and apwd=#{outPwd}")
    Account accountOutInfoMapper(@Param("outId") String outId,@Param("outPwd") String outPwd);

    // 校验余额
    @Select("select * from t_account where aid=#{outId} and apwd=#{outPwd} and money >=#{money}")
    Account accountMoneyInfoMapper(@Param("outId") String outId,@Param("outPwd") String outPwd ,@Param("money")Double money);

    // 校验入账账户信息
    @Select("select a.*\n" +
            "from t_account a\n" +
            "join t_user u\n" +
            "on a.uid=u.uid\n" +
            "where a.aid=#{inId} and u.uname=#{inName}")
    Account accountInInfoMapper(@Param("inId") String inId,@Param("inName") String inName);

    // 转账
    @Update("update t_account set money =money-#{money} where aid=#{outId}")
    int transferOutMapper(@Param("outId") String outId , @Param("money") Double money);

    // 入账
    @Update("update t_account set money =money+#{money} where aid=#{inId}")
    int transferInMapper(@Param("inId") String inId , @Param("money") Double money);

}
