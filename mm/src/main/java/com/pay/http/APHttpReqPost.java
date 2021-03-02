package com.pay.http;

import com.tencent.mm.sdk.system.MimeTypeUtil;

public abstract class APHttpReqPost extends APBaseHttpReq {
    public APHttpReqPost() {
        this.httpParam.setReqWithHttps();
        this.httpParam.setSendWithPost();
    }

    /* access modifiers changed from: protected */
    @Override // com.pay.http.APBaseHttpReq
    public void setHeader() {
        setPostMothod();
    }

    /* access modifiers changed from: protected */
    @Override // com.pay.http.APBaseHttpReq
    public void setBody() {
        super.setBody();
    }

    private void setPostMothod() {
        try {
            this.httpURLConnection.setRequestMethod("POST");
            this.httpURLConnection.setRequestProperty("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            this.httpURLConnection.setDoInput(true);
            this.httpURLConnection.setDoOutput(true);
            this.httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.httpParam.urlParams.getBytes().length));
            this.httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } catch (Exception e2) {
        }
    }
}
