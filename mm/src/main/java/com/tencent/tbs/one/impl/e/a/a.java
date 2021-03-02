package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.ConfigurationKeys;
import com.tencent.tbs.one.impl.common.b;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.tbs.one.impl.a.a<e<File>> {

    /* renamed from: b  reason: collision with root package name */
    Context f2629b;

    /* renamed from: c  reason: collision with root package name */
    String f2630c;

    /* renamed from: d  reason: collision with root package name */
    String[] f2631d;

    /* renamed from: e  reason: collision with root package name */
    String f2632e;

    /* renamed from: f  reason: collision with root package name */
    String f2633f;

    /* renamed from: g  reason: collision with root package name */
    int f2634g;

    /* renamed from: h  reason: collision with root package name */
    File f2635h;

    /* renamed from: i  reason: collision with root package name */
    File f2636i;

    /* renamed from: j  reason: collision with root package name */
    com.tencent.tbs.one.impl.d.a f2637j;
    int k;
    JSONObject l;
    int m;
    String n;
    long o = -1;
    Bundle p;
    d.a q;

    public a(Context context, String str, String str2, String[] strArr, d.a aVar, File file, Bundle bundle) {
        AppMethodBeat.i(188011);
        this.f2629b = context;
        this.f2630c = str;
        this.f2631d = strArr;
        String str3 = aVar.f2561d;
        this.f2632e = !TextUtils.isEmpty(str3) ? str3 : str2;
        this.f2633f = aVar.f2558a;
        this.f2634g = aVar.f2560c;
        this.f2635h = file;
        this.p = bundle;
        this.q = aVar;
        this.f2636i = f.a(this.f2629b, this.f2629b, str, aVar.f2558a, aVar.f2560c);
        AppMethodBeat.o(188011);
    }

    static /* synthetic */ void a(a aVar, Context context, String str, String str2, int i2, String str3, final int i3) {
        AppMethodBeat.i(174062);
        JSONObject jSONObject = new JSONObject();
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "PROTV", 1);
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "FUNC", 1);
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "ABI", Build.CPU_ABI);
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "NAME", str2);
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "REQV", Integer.valueOf(i2));
        com.tencent.tbs.one.impl.a.e.a(jSONObject, "LOCV", Integer.valueOf(i3));
        if (aVar.p != null ? aVar.p.getBoolean(ConfigurationKeys.IS_IGNORE_FLOW_CONTROL, false) : false) {
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "FORCE", 1);
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Requesting component info from %s, post data: %s", str, str2, str3, jSONObject);
        aVar.f2637j = new com.tencent.tbs.one.impl.d.a(context, str3, "POST", null, jSONObject.toString().getBytes(b.f2545a));
        aVar.f2637j.f2621f = new a.AbstractC2197a() {
            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass3 */

            @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
            public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
                AppMethodBeat.i(174049);
                a aVar = a.this;
                int i3 = i3;
                Context context = aVar.f2629b;
                String str = aVar.f2630c;
                String str2 = aVar.f2632e;
                String str3 = aVar.f2633f;
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component information response: [%d] %s", str, str3, Integer.valueOf(i2), map);
                if (i2 != 200 || inputStream == null) {
                    aVar.a(216, "Invalid component information stream, url: " + str2 + ", statusCode: " + i2, null);
                    AppMethodBeat.o(174049);
                    return;
                }
                try {
                    String a2 = c.a(inputStream, ProtocolPackage.ServerEncoding);
                    try {
                        JSONObject jSONObject = new JSONObject(a2);
                        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component information data %s", str, str3, jSONObject);
                        int optInt = jSONObject.optInt("CODE", -1);
                        if (optInt != 0) {
                            aVar.a(TbsListener.ErrorCode.RENAME_EXCEPTION, "Failed to request component " + str3 + " information, url: " + str2 + ", response code: " + optInt + ", message: " + jSONObject.optString("MSG"), null);
                            AppMethodBeat.o(174049);
                            return;
                        }
                        int optInt2 = jSONObject.optInt("TYPE");
                        if (optInt2 == 1) {
                            TBSOneManager.getInstance(context, aVar.f2630c).loadComponentAsync(ShareConstants.MEDIA_EXTENSION, null);
                        }
                        aVar.m = optInt2;
                        aVar.n = jSONObject.optString("MD5");
                        aVar.o = jSONObject.optLong("BYTE");
                        aVar.l = jSONObject;
                        String optString = jSONObject.optString("URL");
                        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Downloading component from %s", aVar.f2630c, aVar.f2633f, optString);
                        h.a("TBSOneAction", 1005, null);
                        aVar.f2637j = new com.tencent.tbs.one.impl.d.a(aVar.f2629b, optString);
                        if (!(aVar.p != null ? aVar.p.getBoolean(ConfigurationKeys.IS_IGNORE_WIFI_STATE, false) : false)) {
                            aVar.f2637j.f2622g = true;
                        }
                        aVar.f2637j.f2621f = new a.AbstractC2197a(optString, i3) {
                            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass5 */

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ String f2651a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ int f2652b;

                            {
                                this.f2651a = r2;
                                this.f2652b = r3;
                            }

                            @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
                            public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
                                File file;
                                AppMethodBeat.i(174066);
                                a aVar = a.this;
                                String str = this.f2651a;
                                int i3 = this.f2652b;
                                Context context = aVar.f2629b;
                                String str2 = aVar.f2630c;
                                String str3 = aVar.f2633f;
                                int i4 = aVar.f2634g;
                                File file2 = aVar.f2635h;
                                if (aVar.f2636i == null) {
                                    file = null;
                                } else {
                                    if (!aVar.f2636i.exists()) {
                                        aVar.f2636i.mkdirs();
                                    }
                                    file = new File(aVar.f2636i, aVar.q.f2558a + ".tbs");
                                }
                                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component download response: [%d] %s", str2, str3, Integer.valueOf(i2), map);
                                if (i2 != 200 || inputStream == null) {
                                    aVar.a(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, "Invalid component download stream, url: " + str + ", statusCode: " + i2, null);
                                    AppMethodBeat.o(174066);
                                    return;
                                }
                                if (aVar.m == 1) {
                                    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Asking runtime extension to intercept download stream", str2, str3);
                                    try {
                                        TBSOneRuntimeExtension a2 = com.tencent.tbs.one.impl.common.a.a(context, str2);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("localVersion", Integer.valueOf(i3));
                                        hashMap.put("localVersionDirectory", new File(f.b(f.a(context.getDir("tbs", 0), str2), str3), String.valueOf(i3)).getAbsolutePath());
                                        hashMap.put("controlMessage", aVar.l);
                                        int shouldInterceptComponentResponse = a2.shouldInterceptComponentResponse(str2, str3, i4, hashMap, inputStream, file2, new TBSOneCallback<Void>(str2, str3, file2, context, i4) {
                                            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass7 */

                                            /* renamed from: a  reason: collision with root package name */
                                            final /* synthetic */ String f2655a;

                                            /* renamed from: b  reason: collision with root package name */
                                            final /* synthetic */ String f2656b;

                                            /* renamed from: c  reason: collision with root package name */
                                            final /* synthetic */ File f2657c;

                                            /* renamed from: d  reason: collision with root package name */
                                            final /* synthetic */ Context f2658d;

                                            /* renamed from: e  reason: collision with root package name */
                                            final /* synthetic */ int f2659e;

                                            {
                                                this.f2655a = r2;
                                                this.f2656b = r3;
                                                this.f2657c = r4;
                                                this.f2658d = r5;
                                                this.f2659e = r6;
                                            }

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final /* synthetic */ void onCompleted(Void r7) {
                                                AppMethodBeat.i(174052);
                                                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished intercepting component download stream by runtime extension", this.f2655a, this.f2656b);
                                                a.this.k = 0;
                                                a.this.a(e.a(e.a.EXTENSION, this.f2657c));
                                                AppMethodBeat.o(174052);
                                            }

                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final void onError(int i2, String str) {
                                                AppMethodBeat.i(174051);
                                                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Failed to intercept component download stream by runtime extension: [%d] %s", this.f2655a, this.f2656b, Integer.valueOf(i2), str);
                                                a.this.k = 0;
                                                a.a(a.this, this.f2658d, this.f2655a, this.f2656b, this.f2659e, a.this.f2632e, -1);
                                                AppMethodBeat.o(174051);
                                            }

                                            @Override // com.tencent.tbs.one.TBSOneCallback
                                            public final void onProgressChanged(int i2, int i3) {
                                                AppMethodBeat.i(174050);
                                                a.this.a(com.tencent.tbs.one.impl.e.f.a(i3, 70, 100));
                                                AppMethodBeat.o(174050);
                                            }
                                        });
                                        if (shouldInterceptComponentResponse != 0) {
                                            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", str2, str3);
                                            aVar.k = shouldInterceptComponentResponse;
                                            AppMethodBeat.o(174066);
                                            return;
                                        }
                                    } catch (TBSOneException e2) {
                                        aVar.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                                        AppMethodBeat.o(174066);
                                        return;
                                    }
                                }
                                try {
                                    com.tencent.tbs.one.impl.e.f.a(inputStream, aVar.n, aVar.o, file2, file, new k.a() {
                                        /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass8 */

                                        @Override // com.tencent.tbs.one.impl.a.k.a
                                        public final void a(int i2) {
                                            AppMethodBeat.i(174048);
                                            a.this.a(i2);
                                            AppMethodBeat.o(174048);
                                        }

                                        @Override // com.tencent.tbs.one.impl.a.k.a
                                        public final boolean a() {
                                            return !a.this.f2326a;
                                        }
                                    });
                                    com.tencent.tbs.one.impl.e.f.a(file2, file2);
                                    com.tencent.tbs.one.impl.e.f.a(file2, i4);
                                    com.tencent.tbs.one.impl.e.f.a(aVar.f2629b.getDir("tbs", 0));
                                    com.tencent.tbs.one.impl.e.f.b(file2);
                                    e a3 = e.a(e.a.ONLINE, file2);
                                    a3.f2730c = aVar.l;
                                    aVar.a(a3);
                                    AppMethodBeat.o(174066);
                                } catch (TBSOneException e3) {
                                    aVar.a(e3.getErrorCode(), e3.getMessage(), e3.getCause());
                                    AppMethodBeat.o(174066);
                                }
                            }
                        };
                        aVar.f2637j.a((l) new l<Integer>() {
                            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass6 */

                            @Override // com.tencent.tbs.one.impl.a.l
                            public final void a(int i2, int i3) {
                                AppMethodBeat.i(174030);
                                a.this.a(com.tencent.tbs.one.impl.e.f.a(i3, 40, 100));
                                AppMethodBeat.o(174030);
                            }

                            @Override // com.tencent.tbs.one.impl.a.l
                            public final void a(int i2, String str, Throwable th) {
                                AppMethodBeat.i(174031);
                                a.this.a(i2, str, th);
                                h.a("TBSOneAction", 1006, null);
                                AppMethodBeat.o(174031);
                            }
                        });
                        AppMethodBeat.o(174049);
                    } catch (JSONException e2) {
                        aVar.a(218, "Failed to parse component " + str3 + " information " + a2 + ", url: " + str2, e2);
                        AppMethodBeat.o(174049);
                    }
                } catch (IOException e3) {
                    aVar.a(217, "Failed to read component " + str3 + " information, url: " + str2, e3);
                    AppMethodBeat.o(174049);
                }
            }
        };
        aVar.f2637j.a((l) new l<Integer>() {
            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass4 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(174035);
                a.this.a(com.tencent.tbs.one.impl.e.f.a(i3, 0, 40));
                AppMethodBeat.o(174035);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(174036);
                a.this.a(i2, str, th);
                h.a("TBSOneAction", 1006, null);
                AppMethodBeat.o(174036);
            }
        });
        AppMethodBeat.o(174062);
    }

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(174061);
        super.a(214, str, null);
        AppMethodBeat.o(174061);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        int shouldOverrideInstallationJob;
        AppMethodBeat.i(174057);
        final Context context = this.f2629b;
        final String str = this.f2630c;
        final String str2 = this.f2633f;
        final int i2 = this.f2634g;
        final File file = this.f2635h;
        TBSOneRuntimeExtension b2 = com.tencent.tbs.one.impl.common.a.b(context, str);
        if (b2 == null || (shouldOverrideInstallationJob = b2.shouldOverrideInstallationJob(str, str2, i2, null, file, new TBSOneCallback<Void>() {
            /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r7) {
                AppMethodBeat.i(174065);
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished intercepting component installation job by runtime extension", str, str2);
                a.this.k = 0;
                a.this.a(e.a(e.a.EXTENSION, file));
                AppMethodBeat.o(174065);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174064);
                a.this.k = 0;
                a.this.a(i2, str, null);
                AppMethodBeat.o(174064);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, int i3) {
                AppMethodBeat.i(174063);
                a.this.a(i3);
                AppMethodBeat.o(174063);
            }
        })) == 0) {
            if (file.exists()) {
                c.a(file);
            }
            m.d(new Runnable() {
                /* class com.tencent.tbs.one.impl.e.a.a.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
                /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 246
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.e.a.a.AnonymousClass2.run():void");
                }
            });
            AppMethodBeat.o(174057);
            return;
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component installation job by runtime extension", str, str2);
        this.k = shouldOverrideInstallationJob;
        AppMethodBeat.o(174057);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(174059);
        h.a("TBSOneAction", 1004, null);
        com.tencent.tbs.one.impl.e.f.a(this.f2635h, System.currentTimeMillis());
        super.a(i2, str, th);
        AppMethodBeat.o(174059);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        AppMethodBeat.i(174060);
        Context context = this.f2629b;
        String str2 = this.f2630c;
        String str3 = this.f2633f;
        int i2 = this.f2634g;
        File file = this.f2635h;
        try {
            File a2 = f.a(f.a(context.createPackageContext(str, 2).getDir("tbs", 0), str2), str3, i2);
            if (a2.exists() && com.tencent.tbs.one.impl.e.f.g(a2)) {
                c.b(a2, file);
                com.tencent.tbs.one.impl.e.f.a(file, i2);
                com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Finished copy component from %s", str2, str3, str);
                AppMethodBeat.o(174060);
                return true;
            }
        } catch (Exception e2) {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Failed copy component from %s,exception is", str2, str3, str, e2.toString());
            c.a(file);
        }
        AppMethodBeat.o(174060);
        return false;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        TBSOneRuntimeExtension b2;
        AppMethodBeat.i(174058);
        super.b();
        if (this.f2637j != null) {
            this.f2637j.b();
        }
        if (!(this.k == 0 || (b2 = com.tencent.tbs.one.impl.common.a.b(this.f2629b, this.f2630c)) == null)) {
            b2.cancel(this.k);
        }
        AppMethodBeat.o(174058);
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str) {
        AppMethodBeat.i(188012);
        try {
            Context createPackageContext = this.f2629b.createPackageContext(str, 2);
            if (createPackageContext != null) {
                File a2 = f.a(this.f2629b, createPackageContext, this.f2630c, this.q.f2558a, this.q.f2560c);
                com.tencent.tbs.one.impl.a.f.a("installFromSdcardPkg,backup dir=%s", a2);
                if (a2 == null) {
                    AppMethodBeat.o(188012);
                    return false;
                }
                File file = new File(a2, this.q.f2558a + ".tbs");
                if (!file.exists() || !file.isFile()) {
                    com.tencent.tbs.one.impl.a.f.a("installFromSdcardPkg,pkgname=%s,backup file %s not exist", str, file);
                    AppMethodBeat.o(188012);
                    return false;
                } else if (!com.tencent.tbs.one.impl.e.f.j(file)) {
                    AppMethodBeat.o(188012);
                    return false;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        c.a(fileInputStream, this.f2635h, (File) null);
                        c.a(fileInputStream);
                        com.tencent.tbs.one.impl.e.f.a(this.f2635h, this.f2635h);
                        com.tencent.tbs.one.impl.e.f.a(this.f2635h, this.q.f2560c);
                        AppMethodBeat.o(188012);
                        return true;
                    } catch (TBSOneException | IOException e2) {
                        com.tencent.tbs.one.impl.a.f.a("installFromSdcardPkg failed,packageName=%s,exception=%s", str, Log.getStackTraceString(e2));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
        }
        AppMethodBeat.o(188012);
        return false;
    }
}
