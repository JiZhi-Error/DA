package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.xweb.c;
import com.tencent.xweb.d;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ay<T extends a> extends br<T> {
    private static TrustManager IWq = new X509TrustManager() {
        /* class com.tencent.mm.plugin.webview.luggage.jsapi.ay.AnonymousClass2 */

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            AppMethodBeat.i(210951);
            Log.i("MicroMsg.JsApiRequest", "checkClientTrusted");
            AppMethodBeat.o(210951);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            AppMethodBeat.i(210952);
            Log.i("MicroMsg.JsApiRequest", "checkServerTrusted");
            AppMethodBeat.o(210952);
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<T>.a aVar) {
        AppMethodBeat.i(210953);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.ay.AnonymousClass1 */

            public final void run() {
                FilterInputStream bufferedInputStream;
                AppMethodBeat.i(210950);
                String optString = aVar.ctb.csi.optString("url");
                JSONObject optJSONObject = aVar.ctb.csi.optJSONObject(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                String optString2 = aVar.ctb.csi.optString(FirebaseAnalytics.b.METHOD);
                String optString3 = aVar.ctb.csi.optString("body");
                JSONObject jSONObject = new JSONObject();
                if (Util.isNullOrNil(optString)) {
                    try {
                        jSONObject.put("errMsg", "url is null");
                    } catch (JSONException e2) {
                    }
                    aVar.c("fail", jSONObject);
                    AppMethodBeat.o(210950);
                } else if (Util.isNullOrNil(optString2) || (!optString2.equalsIgnoreCase("GET") && !optString2.equalsIgnoreCase("POST"))) {
                    try {
                        jSONObject.put("errMsg", "method is valid");
                    } catch (JSONException e3) {
                    }
                    aVar.c("fail", jSONObject);
                    AppMethodBeat.o(210950);
                } else {
                    try {
                        URL url = new URL(optString);
                        d.lA(MMApplicationContext.getContext());
                        String cookie = c.hsp().getCookie("." + url.getHost());
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                httpURLConnection.addRequestProperty(next, optJSONObject.optString(next));
                            }
                        }
                        httpURLConnection.addRequestProperty("user-agent", aVar.cta.Lc().getUserAgent());
                        if (cookie != null) {
                            httpURLConnection.addRequestProperty("cookie", cookie);
                        }
                        if (optString2.equalsIgnoreCase("GET")) {
                            httpURLConnection.setRequestMethod("GET");
                        } else if (optString2.equalsIgnoreCase("POST")) {
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                            bufferedWriter.write(optString3);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        String responseMessage = httpURLConnection.getResponseMessage();
                        if (responseCode == 200 || responseCode == 206) {
                            String contentEncoding = httpURLConnection.getContentEncoding();
                            InputStream inputStream = httpURLConnection.getInputStream();
                            if (contentEncoding == null || !contentEncoding.toLowerCase().contains("gzip")) {
                                bufferedInputStream = new BufferedInputStream(inputStream);
                            } else {
                                bufferedInputStream = new GZIPInputStream(inputStream);
                            }
                            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
                            char[] cArr = new char[4096];
                            StringWriter stringWriter = new StringWriter();
                            while (true) {
                                try {
                                    int read = inputStreamReader.read(cArr);
                                    if (-1 != read) {
                                        stringWriter.write(cArr, 0, read);
                                    } else {
                                        return;
                                    }
                                } catch (Exception e4) {
                                    Log.e("MicroMsg.JsApiRequest", "convertStreamToString: read, %s", e4.getMessage());
                                    jSONObject.put("errMsg", e4.getMessage());
                                    aVar.c("fail", jSONObject);
                                    return;
                                } finally {
                                    Util.qualityClose(inputStreamReader);
                                    Util.qualityClose(bufferedInputStream);
                                    jSONObject.put("responseMsg", responseMessage);
                                    jSONObject.put("data", stringWriter.toString());
                                    aVar.c("", jSONObject);
                                    AppMethodBeat.o(210950);
                                }
                            }
                        } else {
                            jSONObject.put("responseMsg", responseMessage);
                            aVar.c("fail", jSONObject);
                            AppMethodBeat.o(210950);
                        }
                    } catch (Exception e5) {
                        Log.e("MicroMsg.JsApiRequest", e5.getMessage());
                        try {
                            jSONObject.put("errMsg", e5.getMessage());
                        } catch (JSONException e6) {
                        }
                        aVar.c("fail", jSONObject);
                        AppMethodBeat.o(210950);
                    }
                }
            }
        });
        AppMethodBeat.o(210953);
    }

    static {
        AppMethodBeat.i(210954);
        AppMethodBeat.o(210954);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
