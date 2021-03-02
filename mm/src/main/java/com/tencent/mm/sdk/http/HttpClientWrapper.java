package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.t;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientWrapper extends HttpWrapperBase {
    public static final String DEF_ATTACH_NAME = "default_attach_name";
    private static final int MAX_CONTENT_LENGTH = 5242880;
    public static final int RET_CODE_CONTENT_TOO_LARGE = -10000;
    public static final int RET_CODE_FILE_NOT_FOUND = -10004;
    public static final int RET_CODE_ILLEGAL_STATE = -10003;
    public static final int RET_CODE_PROTOCOL = -10002;
    public static final int RET_CODE_UNKOWN_HOST = -10005;
    public static final int RET_CODE_UNSUPPORT_ENCODE = -10001;
    public static final int RET_NETWORK_UNAVAILABLE = -10006;
    public static final int RET_SDCARD_UNAVAILABLE = -10007;
    private static final String TAG = "MicroMsg.HttpClientWrapper";
    private HttpClient client = null;
    private HttpRequestBase httpRequest = null;
    private HttpResponse httpResponse = null;
    private boolean isCancelled = false;
    private int result = 0;

    public HttpClientWrapper(HttpClient httpClient) {
        this.client = httpClient;
    }

    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    public void send(HttpWrapperBase.Request request, HttpWrapperBase.Response response) {
        String str;
        InputStream inputStream;
        OutputStream byteArrayOutputStream;
        String str2;
        int read;
        String str3 = null;
        int i2 = 503;
        AppMethodBeat.i(230274);
        Log.d(TAG, "request: %s", request);
        try {
            this.isCancelled = false;
            if (request.method == 0) {
                this.httpRequest = new HttpGet(request.getUrl());
            } else {
                this.httpRequest = new HttpPost(request.getUrl());
            }
            this.httpRequest.addHeader("User-Agent", "weixin/android");
            this.httpRequest.addHeader("Host", request.host);
            System.setProperty("http.keepAlive", "false");
            this.httpRequest.addHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.httpRequest.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.httpRequest.addHeader("Content-Type", "text/html");
            this.httpRequest.addHeader("Cookie", getCookie(request.cookie));
            if (request.method == 1) {
                writePostStringContent(request, this.httpRequest);
            }
            this.httpResponse = this.client.execute(this.httpRequest);
            this.result = this.httpResponse.getStatusLine().getStatusCode();
            if (this.httpResponse.getFirstHeader("set-cookie") != null) {
                str = this.httpResponse.getFirstHeader("set-cookie").getValue();
            } else {
                str = null;
            }
            if (this.httpResponse.getFirstHeader("Content-Encoding") != null) {
                str3 = this.httpResponse.getFirstHeader("Content-Encoding").getValue();
            }
            if (this.httpResponse.getFirstHeader("Content-Disposition") != null) {
                this.httpResponse.getFirstHeader("Content-Disposition").getValue();
            }
            HttpEntity entity = this.httpResponse.getEntity();
            long contentLength = entity.getContentLength();
            InputStream content = entity.getContent();
            if (str3 == null || !str3.contains("gzip")) {
                inputStream = content;
            } else {
                inputStream = new GZIPInputStream(content);
            }
            if (response.attachment == null || Util.isNullOrNil(response.attachment.filePath)) {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } else {
                byteArrayOutputStream = s.d(new o(response.attachment.filePath), true);
            }
            byte[] bArr = new byte[1024];
            while (!this.isCancelled && (read = inputStream.read(bArr)) > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
            if (this.isCancelled) {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                if (this.client != null) {
                    this.client.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(230274);
                return;
            }
            response.status = this.result;
            response.cookie = parseCookie(str);
            if (byteArrayOutputStream instanceof t) {
                str2 = "";
            } else {
                str2 = new String(((ByteArrayOutputStream) byteArrayOutputStream).toByteArray());
            }
            response.content = str2;
            response.contentLength = contentLength;
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            entity.consumeContent();
            Log.d(TAG, "response:%s", response);
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
                return;
            }
            AppMethodBeat.o(230274);
        } catch (UnsupportedEncodingException e2) {
            response.status = -10001;
            response.content = "unsupported ecoding";
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (UnknownHostException e3) {
            response.status = RET_CODE_UNKOWN_HOST;
            response.content = "unknow host";
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (ClientProtocolException e4) {
            response.status = RET_CODE_PROTOCOL;
            response.content = "client protocol error";
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (IllegalStateException e5) {
            response.status = RET_CODE_ILLEGAL_STATE;
            response.content = "illegal state";
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (FileNotFoundException e6) {
            response.status = RET_CODE_FILE_NOT_FOUND;
            response.content = "output file not found";
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (Exception e7) {
            Log.printErrStackTrace(TAG, e7, "http unavailable", new Object[0]);
            if (this.result != 0) {
                i2 = this.result;
            }
            response.status = i2;
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (OutOfMemoryError e8) {
            Log.printErrStackTrace(TAG, e8, "http unavailable", new Object[0]);
            response.status = this.result == 0 ? 503 : this.result;
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
                AppMethodBeat.o(230274);
            }
        } catch (Throwable th) {
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(230274);
            throw th;
        }
    }

    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    public void cancel() {
        AppMethodBeat.i(230275);
        Log.d(TAG, "cancel conection.");
        this.isCancelled = true;
        if (this.httpRequest != null && !this.httpRequest.isAborted()) {
            this.httpRequest.abort();
        }
        if (this.client != null) {
            this.client.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(230275);
    }

    private void writePostStringContent(HttpWrapperBase.Request request, HttpRequestBase httpRequestBase) {
        AppMethodBeat.i(230276);
        if (request.params == null) {
            AppMethodBeat.o(230276);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : request.params.keySet()) {
            arrayList.add(new BasicNameValuePair(str, request.params.get(str)));
        }
        ((HttpPost) httpRequestBase).setEntity(new UrlEncodedFormEntity(arrayList, ProtocolPackage.ServerEncoding));
        AppMethodBeat.o(230276);
    }
}
