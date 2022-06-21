package com.lyh.admin_template.back.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @program: back
 * @description: 333
 * @packagename: com.lyh.admin_template.back.common.utils
 * @author: 姚泽宇
 * @date: 2022-06-21 21:31
 **/
@Slf4j
public class ExceptionUtil {
    public static String getMessage(Exception e) {
        String message = null;
        try(StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            message = sw.toString();
        }catch (IOException io) {
            io.printStackTrace();
            log.error(io.getMessage());
        }
        return message;
    }
}
