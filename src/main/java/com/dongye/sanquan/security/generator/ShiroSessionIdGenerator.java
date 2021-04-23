package com.dongye.sanquan.security.generator;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * SessionId生成器
 * @author 章卜
 * @version 1.0
 * @date 2021/04/04 13:25
 */
public class ShiroSessionIdGenerator implements SessionIdGenerator {

    /**
     *实现SessionId生成
     * @param session
     * @return
     */
    @Override
    public Serializable generateId(Session session) {
        Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", sessionId);
    }
}
