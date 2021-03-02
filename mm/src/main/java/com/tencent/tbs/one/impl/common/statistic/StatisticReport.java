package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tbs.a.e;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StatisticReport {

    /* renamed from: a  reason: collision with root package name */
    private static String f2580a = "https://tbsone.imtt.qq.com";

    /* renamed from: h  reason: collision with root package name */
    private static WeakReference<Context> f2581h;

    /* renamed from: i  reason: collision with root package name */
    private static String f2582i = "log.lock";

    /* renamed from: b  reason: collision with root package name */
    private String f2583b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f2584c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f2585d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f2586e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f2587f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f2588g = "";

    private StatisticReport(String str, int i2) {
        AppMethodBeat.i(174205);
        this.f2583b = str;
        this.f2584c = String.valueOf(i2);
        AppMethodBeat.o(174205);
    }

    private static int a() {
        AppMethodBeat.i(174211);
        File file = new File(e.a(), f2582i);
        if (file.exists()) {
            try {
                String a2 = c.a(new FileInputStream(file), ProtocolPackage.ServerEncoding);
                if (TextUtils.isEmpty(a2)) {
                    AppMethodBeat.o(174211);
                    return -1;
                }
                int parseInt = Integer.parseInt(a2);
                AppMethodBeat.o(174211);
                return parseInt;
            } catch (Exception e2) {
                AppMethodBeat.o(174211);
                return -1;
            }
        } else {
            AppMethodBeat.o(174211);
            return -1;
        }
    }

    static /* synthetic */ void a(Context context) {
        AppMethodBeat.i(174213);
        try {
            File file = new File(e.a(), f2582i);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    new Object[1][0] = file.getAbsolutePath();
                } else {
                    f.c("Create log upload lock failed!", new Object[0]);
                }
            }
            c.a(new StringBuilder().append(c.c(context)).toString(), ProtocolPackage.ServerEncoding, file);
            AppMethodBeat.o(174213);
        } catch (IOException e2) {
            f.c("Exception when write log upload lock:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(174213);
        }
    }

    public static StatisticReport create(String str, int i2) {
        AppMethodBeat.i(174206);
        StatisticReport statisticReport = new StatisticReport(str, i2);
        AppMethodBeat.o(174206);
        return statisticReport;
    }

    public static void initialize(Context context) {
        AppMethodBeat.i(174203);
        f2581h = new WeakReference<>(context);
        AppMethodBeat.o(174203);
    }

    public static synchronized void reportLog() {
        synchronized (StatisticReport.class) {
            AppMethodBeat.i(174212);
            final Context context = f2581h.get();
            if (context == null) {
                f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Throwable("Null context!"));
                AppMethodBeat.o(174212);
            } else {
                int a2 = a();
                if (a2 <= 0 || a2 != c.c(context)) {
                    b.a();
                    b.a(new Runnable() {
                        /* class com.tencent.tbs.one.impl.common.statistic.StatisticReport.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(174214);
                            new Object[1][0] = e.a();
                            new a(e.a()).a((l) new l<byte[]>() {
                                /* class com.tencent.tbs.one.impl.common.statistic.StatisticReport.AnonymousClass3.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.tbs.one.impl.a.l
                                public final /* synthetic */ void a(byte[] bArr) {
                                    AppMethodBeat.i(174229);
                                    byte[] bArr2 = bArr;
                                    if (bArr2.length <= 1048576 || c.a(context) == 3) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("Content-Type", "application/octet-stream");
                                        hashMap.put("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                        hashMap.put("Content-length", new StringBuilder().append(bArr2.length).toString());
                                        hashMap.put("q-proxy-log", "tbsonelog");
                                        hashMap.put("q-guid", c.d(context));
                                        hashMap.put("q-params", "");
                                        hashMap.put("openrandom", "tbsonelog");
                                        hashMap.put("openmode", c.b());
                                        new a(context, "https://qprostat.imtt.qq.com", "POST", hashMap, bArr2).a((l) new l<Integer>() {
                                            /* class com.tencent.tbs.one.impl.common.statistic.StatisticReport.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                            @Override // com.tencent.tbs.one.impl.a.l
                                            public final /* bridge */ /* synthetic */ void a(Integer num) {
                                                AppMethodBeat.i(174235);
                                                Object[] objArr = {num};
                                                StatisticReport.a(context);
                                                AppMethodBeat.o(174235);
                                            }
                                        });
                                        AppMethodBeat.o(174229);
                                        return;
                                    }
                                    f.b("Log size greater than 1MB, and current network is not WI-FI, log report halt!", new Object[0]);
                                    AppMethodBeat.o(174229);
                                }
                            });
                            AppMethodBeat.o(174214);
                        }
                    });
                    AppMethodBeat.o(174212);
                } else {
                    f.a("Detected logs have been uploaded in this version, log report ignored.", new Object[0]);
                    AppMethodBeat.o(174212);
                }
            }
        }
    }

    public static void shiftRepService(boolean z) {
        AppMethodBeat.i(174204);
        f2580a = z ? "https://tbsone.sparta.html5.qq.com" : "https://tbsone.imtt.qq.com";
        new StringBuilder("Shifting to report server: ").append(f2580a);
        AppMethodBeat.o(174204);
    }

    public void report() {
        AppMethodBeat.i(174210);
        Context context = f2581h.get();
        if (context == null) {
            f.c("Null context! Have you initialized Statistic with null context or haven't initialized Statistic?", new Throwable("Null context!"));
            AppMethodBeat.o(174210);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("PROTV", 1);
        hashMap.put("FUNC", 2);
        hashMap.put("EVENT", this.f2583b);
        hashMap.put("CODE", this.f2584c);
        hashMap.put(ShareConstants.DESCRIPTION, !TextUtils.isEmpty(this.f2585d) ? this.f2585d.replaceAll("\r\n|\r|\n", "") : "");
        hashMap.put("IMEI", c.e(context));
        hashMap.put("DEVMODEL", c.b());
        hashMap.put("CPUABI", c.a());
        hashMap.put("APPVERCODE", new StringBuilder().append(c.c(context)).toString());
        hashMap.put("APPVERNAME", c.b(context));
        hashMap.put("APPPKG", context.getPackageName());
        hashMap.put("CREATETIME", new StringBuilder().append(System.currentTimeMillis()).toString());
        hashMap.put("APNTYPE", new StringBuilder().append(c.a(context)).toString());
        hashMap.put("ANDROIDID", c.f(context));
        hashMap.put("ONECODE", "1");
        hashMap.put("ONENAME", "1.0.0");
        hashMap.put("COMPNAME", this.f2586e);
        hashMap.put("COMPCODE", this.f2587f);
        hashMap.put("DEPSCODE", this.f2588g);
        hashMap.put("SDKCODE", c.c());
        hashMap.put("MODEL", Build.MODEL);
        hashMap.put("ADV", Build.VERSION.RELEASE);
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            AppMethodBeat.o(174210);
            return;
        }
        a aVar = new a(context, f2580a, "POST", null, jSONObject.getBytes());
        aVar.f2621f = new a.AbstractC2197a() {
            /* class com.tencent.tbs.one.impl.common.statistic.StatisticReport.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
            public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
                AppMethodBeat.i(174215);
                if (inputStream == null) {
                    AppMethodBeat.o(174215);
                    return;
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.close();
                    inputStream.close();
                    String str = new String(byteArrayOutputStream.toByteArray());
                    f.c(str, new Object[0]);
                    try {
                        int i3 = new JSONObject(str).getInt("CODE");
                        if (i3 == 0) {
                            f.a("Statistic report successfully!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1001) {
                            f.c("Statistic report error! Not post method!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1002) {
                            f.c("Statistic report error! Params not valid!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1003) {
                            f.c("Statistic report error! Server exception!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1004) {
                            f.c("Statistic report error! Server over charge!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1005) {
                            f.c("Statistic report error! DB exception!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else if (i3 == -1006) {
                            f.c("Statistic report error! DB exception!", new Object[0]);
                            AppMethodBeat.o(174215);
                        } else {
                            if (i3 == -1007) {
                                f.c("Statistic report error! Config not hit!", new Object[0]);
                            }
                            AppMethodBeat.o(174215);
                        }
                    } catch (JSONException e2) {
                        AppMethodBeat.o(174215);
                    }
                } catch (IOException e3) {
                    AppMethodBeat.o(174215);
                }
            }
        };
        aVar.a((l) new l<Integer>() {
            /* class com.tencent.tbs.one.impl.common.statistic.StatisticReport.AnonymousClass2 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174201);
                f.c(str, th);
                AppMethodBeat.o(174201);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l
            public final /* bridge */ /* synthetic */ void a(Integer num) {
                AppMethodBeat.i(174202);
                f.a("Statistic upload complete with http response code: %d", num);
                AppMethodBeat.o(174202);
            }
        });
        AppMethodBeat.o(174210);
    }

    public StatisticReport setComponent(String str, int i2) {
        AppMethodBeat.i(174208);
        this.f2586e = str;
        this.f2587f = String.valueOf(i2);
        AppMethodBeat.o(174208);
        return this;
    }

    public StatisticReport setDEPSCode(int i2) {
        AppMethodBeat.i(174209);
        this.f2588g = String.valueOf(i2);
        AppMethodBeat.o(174209);
        return this;
    }

    public StatisticReport setDescription(String str) {
        this.f2585d = str;
        return this;
    }

    public StatisticReport setDescription(String str, Throwable th) {
        AppMethodBeat.i(174207);
        this.f2585d = str + "@" + (th != null ? Log.getStackTraceString(th) : "");
        AppMethodBeat.o(174207);
        return this;
    }
}
