package com.sinosoft.one.mvc.web.instruction.reply.transport;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.sinosoft.one.mvc.util.MvcObjectUtils;
import org.springframework.stereotype.Component;

import com.google.common.io.ByteStreams;

/**
 * @author Dhanji R. Prasanna (dhanji@gmail.com)
 */
@Component
class SimpleTextTransport extends Text {

    public <T> void out(OutputStream out, T data) {
      try {
        String dataStr = String.valueOf(data);
        if(!MvcObjectUtils.isJsonStr(dataStr)) {
            if(dataStr.charAt(0) != '"') {
                dataStr = '"' + dataStr;
            }
            if(dataStr.charAt(dataStr.length() - 1) != '"') {
                dataStr = dataStr + '"';
            }
        }
        ByteStreams.copy(new ByteArrayInputStream(dataStr.getBytes(Charsets.UTF_8)), out);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public static void main(String[] args) {
        Map<String, String> strMap = new HashMap<String, String>();
        strMap.put("aaa", "aaa");
        System.out.println(JSON.toJSONString(strMap));
    }
}
