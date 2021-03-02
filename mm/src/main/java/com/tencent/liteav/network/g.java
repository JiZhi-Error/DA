package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f953a = 5;

    /* renamed from: b  reason: collision with root package name */
    private final int f954b = 2;

    /* renamed from: c  reason: collision with root package name */
    private String f955c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f956d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f957e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f958f = "";

    /* renamed from: g  reason: collision with root package name */
    private Handler f959g;

    public interface a {
        void a(int i2, String str, Vector<e> vector);
    }

    static /* synthetic */ long a(g gVar) {
        AppMethodBeat.i(15420);
        long e2 = gVar.e();
        AppMethodBeat.o(15420);
        return e2;
    }

    static /* synthetic */ boolean a(g gVar, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(15419);
        boolean a2 = gVar.a(z, str, str2, str3);
        AppMethodBeat.o(15419);
        return a2;
    }

    public g(Context context) {
        AppMethodBeat.i(15413);
        if (context != null) {
            this.f959g = new Handler(context.getMainLooper());
        }
        AppMethodBeat.o(15413);
    }

    public String a() {
        return this.f955c;
    }

    public String b() {
        return this.f956d;
    }

    public int c() {
        return this.f957e;
    }

    public String d() {
        return this.f958f;
    }

    public int a(String str, int i2, final a aVar) {
        boolean z;
        AppMethodBeat.i(15414);
        this.f955c = "";
        this.f956d = "";
        this.f957e = 0;
        this.f958f = "";
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(15414);
            return -1;
        }
        final String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(str);
        if (streamIDByStreamUrl == null || streamIDByStreamUrl.isEmpty()) {
            AppMethodBeat.o(15414);
            return -2;
        }
        final String a2 = a("bizid", str);
        final String a3 = a("txSecret", str);
        final String a4 = a("txTime", str);
        if (e() <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!a(z, a2, a4, a3)) {
            AppMethodBeat.o(15414);
            return -3;
        }
        a(streamIDByStreamUrl, a2, a3, a4, i2, new a() {
            /* class com.tencent.liteav.network.g.AnonymousClass1 */

            @Override // com.tencent.liteav.network.g.a
            public void a(int i2, String str, Vector<e> vector) {
                AppMethodBeat.i(15422);
                g.this.f955c = streamIDByStreamUrl;
                g.this.f956d = a2;
                g.this.f957e = i2;
                g.this.f958f = str;
                if (vector == null || vector.isEmpty()) {
                    if (aVar != null) {
                        aVar.a(i2, str, null);
                    }
                    AppMethodBeat.o(15422);
                    return;
                }
                Vector<e> vector2 = new Vector<>();
                Iterator<e> it = vector.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    String str2 = next.f951a;
                    if (str2.indexOf("?") != -1) {
                        str2 = str2.substring(0, str2.indexOf("?"));
                    }
                    vector2.add(new e(str2 + "?txSecret=" + a3 + "&txTime=" + a4 + "&bizid=" + a2, next.f952b));
                }
                if (aVar != null) {
                    Iterator<e> it2 = vector2.iterator();
                    while (it2.hasNext()) {
                        e next2 = it2.next();
                        TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + next2.f951a + " quic = " + next2.f952b);
                    }
                    aVar.a(i2, str, vector2);
                }
                AppMethodBeat.o(15422);
            }
        });
        AppMethodBeat.o(15414);
        return 0;
    }

    private boolean a(boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(15415);
        if (z) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                AppMethodBeat.o(15415);
                return false;
            }
            AppMethodBeat.o(15415);
            return true;
        } else if (str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(15415);
            return false;
        } else {
            AppMethodBeat.o(15415);
            return true;
        }
    }

    private long e() {
        AppMethodBeat.i(15416);
        long a2 = c.a().a("Network", "AccRetryCountWithoutSecret");
        AppMethodBeat.o(15416);
        return a2;
    }

    private void a(final String str, final String str2, final String str3, final String str4, final int i2, final a aVar) {
        AppMethodBeat.i(15417);
        new Thread("getRTMPAccUrl") {
            /* class com.tencent.liteav.network.g.AnonymousClass2 */

            public void run() {
                int i2;
                String str;
                AppMethodBeat.i(15454);
                final int i3 = -1;
                int intValue = (str2 == null || str2.isEmpty()) ? 0 : Integer.valueOf(str2).intValue();
                int i4 = 5;
                if (g.a(g.this, true, str2, str4, str3) || (i4 = (int) g.a(g.this)) > 0) {
                    i2 = 2;
                } else {
                    i4 = 1;
                    i2 = 1;
                }
                final String str2 = "";
                for (int i5 = i4 + i2; i5 > 0; i5--) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bizid", intValue);
                        jSONObject.put("stream_id", str);
                        jSONObject.put("txSecret", str3);
                        jSONObject.put("txTime", str4);
                        jSONObject.put("type", 1);
                        String jSONObject2 = jSONObject.toString();
                        if (i5 > i2) {
                            str = "https://livepull.myqcloud.com/getpulladdr";
                        } else {
                            str = "https://livepullipv6.myqcloud.com/getpulladdr";
                        }
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setConnectTimeout(5000);
                        httpsURLConnection.setReadTimeout(5000);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setRequestProperty("Charsert", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        httpsURLConnection.setRequestProperty("Content-Type", "text/plain;");
                        httpsURLConnection.setRequestProperty("Content-Length", String.valueOf(jSONObject2.length()));
                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: sendHttpRequest[ " + jSONObject2 + "] retryIndex = " + i5);
                        new DataOutputStream(httpsURLConnection.getOutputStream()).write(jSONObject2.getBytes());
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                        String str3 = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str3 = str3 + readLine;
                        }
                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: receive response, strResponse = ".concat(String.valueOf(str3)));
                        JSONObject jSONObject3 = (JSONObject) new JSONTokener(str3).nextValue();
                        if (jSONObject3.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                            i3 = jSONObject3.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                        }
                        if (i3 != 0) {
                            if (jSONObject3.has("message")) {
                                str2 = jSONObject3.getString("message");
                            }
                            TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: errorCode = " + i3 + " errorMessage = " + str2);
                        }
                        if (jSONObject3.has("pull_addr")) {
                            final Vector vector = new Vector();
                            final Vector vector2 = new Vector();
                            JSONArray jSONArray = jSONObject3.getJSONArray("pull_addr");
                            if (jSONArray == null || jSONArray.length() == 0) {
                                TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: no pull_addr");
                            } else {
                                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                    JSONObject jSONObject4 = (JSONObject) jSONArray.get(i6);
                                    if (jSONObject4 != null) {
                                        String string = jSONObject4.getString("rtmp_url");
                                        boolean z = jSONObject4.getInt("proto") == 1;
                                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl: streamUrl = " + string + " Q channel = " + z);
                                        String streamIDByStreamUrl = TXCCommonUtil.getStreamIDByStreamUrl(string);
                                        if (streamIDByStreamUrl != null && streamIDByStreamUrl.equalsIgnoreCase(str)) {
                                            if (z) {
                                                vector.add(new e(string, z));
                                            } else {
                                                vector2.add(new e(string, z));
                                            }
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                                if (vector2.size() > 0) {
                                    g.this.f959g.post(new Runnable() {
                                        /* class com.tencent.liteav.network.g.AnonymousClass2.AnonymousClass1 */

                                        public void run() {
                                            AppMethodBeat.i(15399);
                                            if (aVar != null) {
                                                aVar.a(0, "Success", vector2);
                                            }
                                            AppMethodBeat.o(15399);
                                        }
                                    });
                                    AppMethodBeat.o(15454);
                                    return;
                                }
                            } else if (i2 != 2) {
                                Iterator it = vector2.iterator();
                                while (it.hasNext()) {
                                    vector.add((e) it.next());
                                }
                                if (vector.size() > 0) {
                                    g.this.f959g.post(new Runnable() {
                                        /* class com.tencent.liteav.network.g.AnonymousClass2.AnonymousClass3 */

                                        public void run() {
                                            AppMethodBeat.i(15308);
                                            if (aVar != null) {
                                                aVar.a(0, "Success", vector);
                                            }
                                            AppMethodBeat.o(15308);
                                        }
                                    });
                                    AppMethodBeat.o(15454);
                                    return;
                                }
                            } else if (vector.size() > 0) {
                                g.this.f959g.post(new Runnable() {
                                    /* class com.tencent.liteav.network.g.AnonymousClass2.AnonymousClass2 */

                                    public void run() {
                                        AppMethodBeat.i(15309);
                                        if (aVar != null) {
                                            aVar.a(0, "Success", vector);
                                        }
                                        AppMethodBeat.o(15309);
                                    }
                                });
                                AppMethodBeat.o(15454);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception:" + e2.toString());
                    }
                    try {
                        sleep(1000, 0);
                    } catch (Exception e3) {
                        TXCLog.e("TXRTMPAccUrlFetcher", "getAccelerateStreamPlayUrl exception sleep");
                    }
                }
                g.this.f959g.post(new Runnable() {
                    /* class com.tencent.liteav.network.g.AnonymousClass2.AnonymousClass4 */

                    public void run() {
                        AppMethodBeat.i(15398);
                        if (aVar != null) {
                            aVar.a(i3, str2, null);
                        }
                        AppMethodBeat.o(15398);
                    }
                });
                AppMethodBeat.o(15454);
            }
        }.start();
        AppMethodBeat.o(15417);
    }

    private String a(String str, String str2) {
        AppMethodBeat.i(15418);
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            AppMethodBeat.o(15418);
            return null;
        }
        String lowerCase = str.toLowerCase();
        String[] split = str2.split("[?&]");
        for (String str3 : split) {
            if (str3.indexOf("=") != -1) {
                String[] split2 = str3.split("[=]");
                if (split2.length == 2) {
                    String str4 = split2[0];
                    String str5 = split2[1];
                    if (str4 != null && str4.toLowerCase().equalsIgnoreCase(lowerCase)) {
                        AppMethodBeat.o(15418);
                        return str5;
                    }
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.o(15418);
        return "";
    }
}
