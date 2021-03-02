package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse() {
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        AppMethodBeat.i(53224);
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
        AppMethodBeat.o(53224);
    }

    public WebResourceResponse(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        AppMethodBeat.i(53225);
        setStatusCodeAndReasonPhrase(i2, str3);
        setResponseHeaders(map);
        AppMethodBeat.o(53225);
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public void setStatusCodeAndReasonPhrase(int i2, String str) {
        this.mStatusCode = i2;
        this.mReasonPhrase = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public void setData(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public InputStream getData() {
        return this.mInputStream;
    }
}
