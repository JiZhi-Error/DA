package com.pay.http;

import com.pay.tool.APMidasTools;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.HashMap;

public abstract class APBaseHttpReq extends Thread {
    protected IAPHttpAns httpAns;
    public APBaseHttpParam httpParam = new APBaseHttpParam();
    protected HttpURLConnection httpURLConnection;
    private boolean isStop = false;
    private byte[] resultContent;

    public APBaseHttpReq() {
        this.httpParam.reqParam = new HashMap<>();
        this.httpParam.domain = APMidasTools.getSysServerDomain();
    }

    /* access modifiers changed from: protected */
    public void preCreateConnection() {
    }

    /* access modifiers changed from: protected */
    public void setHeader() {
    }

    /* access modifiers changed from: protected */
    public void setBody() {
    }

    public void startRequest() {
        start();
    }

    public void stopRequest() {
        this.isStop = true;
        this.httpAns.onStop(this);
    }

    public void run() {
        requestProgress();
        super.run();
    }

    public void requestAgain() {
        requestProgress();
    }

    /* access modifiers changed from: protected */
    public void setUrl(String str, String str2, String str3, String str4) {
        this.httpParam.setUrl(str, str2, str3, str4);
    }

    /* access modifiers changed from: protected */
    public void setReportUrl(String str, String str2, String str3) {
        this.httpParam.setReportUrl(str, str2, str3);
    }

    public void constructParam() {
    }

    private void initRequest() {
        constructParam();
        this.httpParam.constructUrl();
        preCreateConnection();
        createConnection();
        closeOutput();
        setHeader();
        setBody();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void requestProgress() {
        /*
        // Method dump skipped, instructions count: 794
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pay.http.APBaseHttpReq.requestProgress():void");
    }

    private void createConnection() {
        URL url;
        try {
            url = new URL(this.httpParam.url);
        } catch (MalformedURLException e2) {
            url = null;
        }
        if (APMidasPayAPI.env.equals(APMidasPayAPI.ENV_TESTING)) {
            APLog.i("APHttp Request", "URL = " + this.httpParam.url);
        } else {
            APLog.i("APHttp Request", "URL = " + this.httpParam.url + " HOST = " + this.httpParam.defaultDomain);
        }
        this.httpAns.onStart(this);
        try {
            this.httpURLConnection = (HttpURLConnection) url.openConnection();
            this.httpURLConnection.setConnectTimeout(this.httpParam.connectTimeout);
            this.httpURLConnection.setReadTimeout(this.httpParam.readTimeout);
            this.httpURLConnection.setRequestProperty("Host", this.httpParam.defaultDomain);
            this.httpURLConnection.setUseCaches(false);
        } catch (Exception e3) {
            APLog.i("createConnection", e3.toString());
        }
    }

    private void closeOutput() {
        try {
            if (this.httpURLConnection.getDoOutput()) {
                try {
                    this.httpURLConnection.getOutputStream().flush();
                    this.httpURLConnection.getOutputStream().close();
                } catch (Throwable th) {
                }
            }
        } catch (Exception e2) {
            APLog.i("closeOutput", e2.toString());
        }
    }

    private void closeStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e2) {
                return;
            }
        }
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
        this.httpURLConnection.disconnect();
    }

    public byte[] getContent() {
        return this.resultContent;
    }

    public void setContent(byte[] bArr) {
        this.resultContent = bArr;
    }

    public IAPHttpAns getHttpAns() {
        return this.httpAns;
    }

    public void setHttpAns(IAPHttpAns iAPHttpAns) {
        this.httpAns = iAPHttpAns;
    }

    private void tryAgain(int i2, int i3, Exception exc, String str) {
        sendReportData(i2, i3);
        APLog.i("APBaseHttpReq", getClass().getName() + " tryAgain reqTimes = " + this.httpParam.requestTimes + " tryTimes = " + this.httpParam.reTryTimes);
        try {
            if (this.httpParam.requestTimes < this.httpParam.reTryTimes) {
                this.httpParam.constructReTryUrl();
                requestProgress();
                return;
            }
            try {
                if (this.httpParam.reqType.equals(HttpWrapperBase.PROTOCAL_HTTPS)) {
                    for (Exception exc2 = exc; exc2 != null; exc2 = exc2.getCause()) {
                        if ((exc2 instanceof CertificateExpiredException) || (exc2 instanceof CertificateNotYetValidException)) {
                            APLog.e("APBaseHttpReq", "您的设备系统时间不正确，请更改");
                            this.httpAns.onError(this, 1100, str);
                            return;
                        }
                    }
                }
                this.httpAns.onError(this, 1000, str);
                APLog.i("APBaseHttpReq", str);
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
    }

    private void sendReportData(int i2, int i3) {
        if (this.httpParam.urlName.endsWith("log_data")) {
        }
    }
}
