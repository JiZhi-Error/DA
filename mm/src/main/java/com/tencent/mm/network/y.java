package com.tencent.mm.network;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface y {
    void RU(String str);

    String bjP();

    int bjQ();

    void disconnect();

    int getContentLength();

    String getContentType();

    String getHeaderField(String str);

    int getHeaderFieldInt(String str, int i2);

    Map<String, List<String>> getHeaderFields();

    String getHost();

    InputStream getInputStream();

    int getResponseCode();

    void setConnectTimeout(int i2);

    void setReadTimeout(int i2);

    void setRequestMethod(String str);

    void setRequestProperty(String str, String str2);

    void setUseCaches(boolean z);
}
