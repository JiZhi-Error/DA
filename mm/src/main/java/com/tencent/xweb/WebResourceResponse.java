package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse {
    public boolean SAc;
    public String mEncoding;
    public InputStream mInputStream;
    public String mMimeType;
    public String mReasonPhrase;
    public Map<String, String> mResponseHeaders;
    public int mStatusCode;

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.mStatusCode = 200;
        this.SAc = false;
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mInputStream = inputStream;
        this.SAc = false;
    }

    public WebResourceResponse(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        AppMethodBeat.i(156796);
        this.mStatusCode = i2;
        this.mReasonPhrase = str3;
        this.mResponseHeaders = map;
        this.SAc = true;
        AppMethodBeat.o(156796);
    }

    public final String getMimeType() {
        return this.mMimeType;
    }

    public final int getStatusCode() {
        return this.mStatusCode;
    }

    public final String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public final void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public final Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }
}
