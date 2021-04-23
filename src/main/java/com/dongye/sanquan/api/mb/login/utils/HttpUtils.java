package com.dongye.sanquan.api.mb.login.utils;


import com.dongye.sanquan.api.mb.login.pojo.WechatResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**该工具类用于获取微信openId
 * @author 冉翔
 * @date 2021/04/18
 */
public class HttpUtils {
    /**
     * GET https://api.weixin.qq.com/sns/jscode2session?
     * appid=APPID&secret=SECRET&js_code=JSCODE\
     * &grant_type=authorization_code
     */

    private final static String APPID = "wxca1198a0459d891b";
    private final static String SECRET = "51f3ea750ea1eca02807d71e5ec48479";
    private final static String GRANT_TYPE = "authorization_code";
    private final static String URL = "https://api.weixin.qq.com/sns/jscode2session";


    public static String getResponse(String code){
        URIBuilder builder;
        URI uri;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            builder = new URIBuilder(URL);
            if (code != null && code.length() > 0){
                builder.addParameter("appid",APPID);
                builder.addParameter("secret",SECRET);
                builder.addParameter("grant_type",GRANT_TYPE);
                builder.addParameter("js_code",code);
            }
            uri = builder.build();
            System.out.println(uri);
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {//释放资源
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String result = null;
        if (response != null){
            if (response.getStatusLine().getStatusCode() == 200){
                try {
                    result = EntityUtils.toString(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        WechatResponse wechatResponse = JsonUtils.string2Obj(result, WechatResponse.class);
        if (wechatResponse != null && wechatResponse.getErrcode() == 0){
            return wechatResponse.getOpenid();
        }
        System.out.println(wechatResponse);
        return null;
    }
}
