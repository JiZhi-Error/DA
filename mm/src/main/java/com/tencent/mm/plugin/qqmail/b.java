package com.tencent.mm.plugin.qqmail;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public final class b extends c {
    public static final String USER_AGENT = ("weixin/" + d.ics + "/0x" + Integer.toHexString(d.KyO));
    private HttpClient client = null;
    private HttpRequestBase httpRequest = null;
    private HttpResponse httpResponse = null;
    private boolean isCancelled = false;
    private int result = 0;

    static {
        AppMethodBeat.i(198564);
        AppMethodBeat.o(198564);
    }

    @Override // com.tencent.mm.plugin.qqmail.c
    public final c.f a(String str, String str2, c.e eVar, c.d dVar) {
        String str3;
        boolean z;
        GZIPInputStream gZIPInputStream;
        OutputStream byteArrayOutputStream;
        String str4;
        int read;
        AppMethodBeat.i(198561);
        Log.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + eVar);
        try {
            this.isCancelled = false;
            this.client = new DefaultHttpClient();
            if (eVar.method == 0) {
                this.httpRequest = new HttpGet(d(str, str2, eVar.params));
            } else {
                this.httpRequest = new HttpPost(d(str, str2, null));
            }
            this.httpRequest.addHeader("User-Agent", USER_AGENT);
            System.setProperty("http.keepAlive", "false");
            this.httpRequest.addHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.httpRequest.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.httpRequest.addHeader("Content-Type", "text/html");
            this.httpRequest.addHeader("Cookie", getCookie(eVar.cookie));
            if (eVar.method == 1) {
                a(eVar, this.httpRequest);
            }
            this.httpResponse = this.client.execute(this.httpRequest);
            this.result = this.httpResponse.getStatusLine().getStatusCode();
            String str5 = null;
            String str6 = null;
            String str7 = null;
            if (this.httpResponse.getFirstHeader("set-cookie") != null) {
                str3 = this.httpResponse.getFirstHeader("set-cookie").getValue();
            } else {
                str3 = null;
            }
            if (this.httpResponse.getFirstHeader("Content-Encoding") != null) {
                str5 = this.httpResponse.getFirstHeader("Content-Encoding").getValue();
            }
            if (this.httpResponse.getFirstHeader("Content-Disposition") != null) {
                str6 = this.httpResponse.getFirstHeader("Content-Disposition").getValue();
            }
            if (str6 == null || !str6.contains("attachment;") || !str2.contains("download")) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (this.httpResponse.getFirstHeader("Content-Length") != null) {
                    str7 = this.httpResponse.getFirstHeader("Content-Length").getValue();
                }
                if (!TextUtils.isEmpty(str7) && ((long) Util.getInt(str7, 0)) > 5242880) {
                    c.f fVar = new c.f(-10000, null, "mail content to large");
                    if (this.client != null) {
                        this.client.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(198561);
                    return fVar;
                }
            }
            HttpEntity entity = this.httpResponse.getEntity();
            entity.getContentLength();
            InputStream content = entity.getContent();
            if (str5 == null || !str5.contains("gzip")) {
                gZIPInputStream = content;
            } else {
                gZIPInputStream = new GZIPInputStream(content);
            }
            if (z) {
                byteArrayOutputStream = s.d(new o(BqJ, new StringBuilder().append(eVar.params.get("default_attach_name") == null ? Long.valueOf(System.currentTimeMillis()) : eVar.params.get("default_attach_name")).toString()), true);
            } else {
                byteArrayOutputStream = new ByteArrayOutputStream();
            }
            byte[] bArr = new byte[1024];
            while (!this.isCancelled && (read = gZIPInputStream.read(bArr)) > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
                dVar.eGj();
            }
            if (this.isCancelled) {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                if (this.client != null) {
                    this.client.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(198561);
                return null;
            }
            int i2 = this.result;
            Map<String, String> parseCookie = parseCookie(str3);
            if (z) {
                str4 = "";
            } else {
                str4 = new String(((ByteArrayOutputStream) byteArrayOutputStream).toByteArray());
            }
            c.f fVar2 = new c.f(i2, parseCookie, str4);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            entity.consumeContent();
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            Log.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + fVar2);
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar2;
        } catch (UnsupportedEncodingException e2) {
            c.f fVar3 = new c.f(-10001, null, "unsupported ecoding");
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar3;
        } catch (UnknownHostException e3) {
            c.f fVar4 = new c.f(HttpClientWrapper.RET_CODE_UNKOWN_HOST, null, "unknow host");
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar4;
        } catch (ClientProtocolException e4) {
            c.f fVar5 = new c.f(HttpClientWrapper.RET_CODE_PROTOCOL, null, "client protocol error");
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar5;
        } catch (IllegalStateException e5) {
            c.f fVar6 = new c.f(HttpClientWrapper.RET_CODE_ILLEGAL_STATE, null, "illegal state");
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar6;
        } catch (FileNotFoundException e6) {
            c.f fVar7 = new c.f(HttpClientWrapper.RET_CODE_FILE_NOT_FOUND, null, "output file not found");
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar7;
        } catch (Exception e7) {
            Log.printErrStackTrace("MicroMsg.HttpClientUtil", e7, "http unavailable", new Object[0]);
            c.f fVar8 = new c.f(this.result == 0 ? 503 : this.result, null, null);
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar8;
        } catch (OutOfMemoryError e8) {
            Log.printErrStackTrace("MicroMsg.HttpClientUtil", e8, "http unavailable", new Object[0]);
            c.f fVar9 = new c.f(this.result == 0 ? 503 : this.result, null, null);
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            return fVar9;
        } catch (Throwable th) {
            if (this.client != null) {
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(198561);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.qqmail.c
    public final void cancel() {
        AppMethodBeat.i(198562);
        Log.d("MicroMsg.HttpClientUtil", "cancel conection.");
        this.isCancelled = true;
        if (this.httpRequest != null && !this.httpRequest.isAborted()) {
            this.httpRequest.abort();
        }
        if (this.client != null) {
            this.client.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(198562);
    }

    private static void a(c.e eVar, HttpRequestBase httpRequestBase) {
        AppMethodBeat.i(198563);
        if (eVar.params == null) {
            AppMethodBeat.o(198563);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : eVar.params.keySet()) {
            arrayList.add(new BasicNameValuePair(str, eVar.params.get(str)));
        }
        ((HttpPost) httpRequestBase).setEntity(new UrlEncodedFormEntity(arrayList, ProtocolPackage.ServerEncoding));
        AppMethodBeat.o(198563);
    }
}
