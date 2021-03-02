package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.ConfigurationKeys;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a<e<d>> implements a.AbstractC2197a {

    /* renamed from: b  reason: collision with root package name */
    int f2662b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2663c;

    /* renamed from: d  reason: collision with root package name */
    private String f2664d;

    /* renamed from: e  reason: collision with root package name */
    private String f2665e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f2666f;

    /* renamed from: g  reason: collision with root package name */
    private int f2667g;

    /* renamed from: h  reason: collision with root package name */
    private File f2668h;

    /* renamed from: i  reason: collision with root package name */
    private com.tencent.tbs.one.impl.d.a f2669i;

    /* renamed from: j  reason: collision with root package name */
    private Bundle f2670j;

    public b(Context context, String str, String str2, String[] strArr, int i2, File file, Bundle bundle) {
        this.f2663c = context;
        this.f2664d = str;
        this.f2665e = str2;
        this.f2666f = strArr;
        this.f2667g = i2;
        this.f2668h = file;
        this.f2670j = bundle;
    }

    private static int a(Context context, String str) {
        AppMethodBeat.i(174046);
        int i2 = context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", str), 4).getInt("in_use_deps_version", -1);
        AppMethodBeat.o(174046);
        return i2;
    }

    private JSONObject c() {
        AppMethodBeat.i(174044);
        try {
            JSONObject a2 = com.tencent.tbs.one.impl.a.e.a(com.tencent.tbs.b.a.RSp);
            AppMethodBeat.o(174044);
            return a2;
        } catch (Throwable th) {
            f.c("[%s] Failed to get component sdk versions", this.f2664d, th);
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(174044);
            return jSONObject;
        }
    }

    private JSONObject d() {
        AppMethodBeat.i(174045);
        File[] listFiles = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.f2663c.getDir("tbs", 0), this.f2664d)).listFiles();
        JSONObject jSONObject = new JSONObject();
        if (listFiles != null) {
            for (File file : listFiles) {
                com.tencent.tbs.one.impl.a.e.a(jSONObject, file.getName(), Integer.valueOf(com.tencent.tbs.one.impl.e.f.c(file)));
            }
        }
        AppMethodBeat.o(174045);
        return jSONObject;
    }

    private JSONArray e() {
        AppMethodBeat.i(174047);
        JSONArray jSONArray = new JSONArray();
        Context context = this.f2663c;
        String str = this.f2664d;
        String[] strArr = this.f2666f;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!str2.equals(context.getPackageName())) {
                    try {
                        int a2 = a(context.createPackageContext(str2, 2), str);
                        if (a2 != -1) {
                            jSONArray.put(a2);
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                    }
                }
            }
        }
        AppMethodBeat.o(174047);
        return jSONArray;
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        Object obj;
        int shouldOverrideInstallationJob;
        AppMethodBeat.i(174040);
        Context context = this.f2663c;
        final String str = this.f2664d;
        String str2 = this.f2665e;
        final File file = this.f2668h;
        TBSOneRuntimeExtension b2 = com.tencent.tbs.one.impl.common.a.b(context, str);
        if (b2 == null || (shouldOverrideInstallationJob = b2.shouldOverrideInstallationJob(str, "DEPS", -1, null, file, new TBSOneCallback<Void>() {
            /* class com.tencent.tbs.one.impl.e.a.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r6) {
                AppMethodBeat.i(174039);
                f.a("[%s] Finished intercepting DEPS installation job by runtime extension", str);
                b.this.f2662b = 0;
                try {
                    b.this.a(e.a(e.a.EXTENSION, d.a(file)));
                    AppMethodBeat.o(174039);
                } catch (TBSOneException e2) {
                    b.this.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                    AppMethodBeat.o(174039);
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174038);
                b.this.f2662b = 0;
                b.this.a(i2, str, (Throwable) null);
                AppMethodBeat.o(174038);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, int i3) {
                AppMethodBeat.i(174037);
                b.this.a(i3);
                AppMethodBeat.o(174037);
            }
        })) == 0) {
            if (!(this.f2670j != null ? this.f2670j.getBoolean(ConfigurationKeys.IS_IGNORE_FREQUENCY_LIMITATION, false) : false)) {
                long h2 = com.tencent.tbs.one.impl.e.f.h(file);
                if (System.currentTimeMillis() - h2 < Util.MILLSECONDS_OF_DAY) {
                    super.a(209, "Too many DEPS requests, last request time: " + com.tencent.tbs.one.impl.a.d.a(h2), (Throwable) null);
                    AppMethodBeat.o(174040);
                    return;
                }
                com.tencent.tbs.one.impl.e.f.i(file);
            }
            h.a("TBSOneAction", 1001, null);
            JSONObject jSONObject = new JSONObject();
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "ONEV", 1);
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "DEPSV", Integer.valueOf(a(context, str)));
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "HSTV", e());
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "SDKV", c());
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "LOCV", d());
            if (this.f2667g != -1) {
                com.tencent.tbs.one.impl.a.e.a(jSONObject, "REQV", Integer.valueOf(this.f2667g));
            }
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "PROTV", 1);
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "FUNC", 0);
            String packageName = context.getPackageName();
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "PN", packageName);
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                com.tencent.tbs.one.impl.a.e.a(jSONObject, "PPVN", packageInfo.versionName);
                com.tencent.tbs.one.impl.a.e.a(jSONObject, "PPVC", Integer.valueOf(packageInfo.versionCode));
            } catch (PackageManager.NameNotFoundException e2) {
                f.c("Failed to get package info for %s", packageName, e2);
            }
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            } catch (Exception e3) {
                f.c("Failed to get application info for %s", packageName, e3);
            }
            if (applicationInfo != null) {
                com.tencent.tbs.one.impl.a.e.a(jSONObject, "TAPI", Integer.valueOf(applicationInfo.targetSdkVersion));
                if (!(applicationInfo.metaData == null || (obj = applicationInfo.metaData.get(TbsDownloader.TBS_METADATA)) == null)) {
                    try {
                        com.tencent.tbs.one.impl.a.e.a(jSONObject, "META", Integer.toHexString(Integer.parseInt(String.valueOf(obj))));
                    } catch (Exception e4) {
                        f.c("Failed to parse meta data %s", obj, e4);
                    }
                }
            }
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "BVR", Build.VERSION.RELEASE);
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "ABI", Build.CPU_ABI);
            if (TextUtils.isEmpty(com.tencent.tbs.one.impl.a.d.f2353a) && context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                com.tencent.tbs.one.impl.a.d.f2353a = telephonyManager.getDeviceId();
                com.tencent.tbs.one.impl.a.d.f2354b = telephonyManager.getSubscriberId();
            }
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "IMEI", com.tencent.tbs.one.impl.a.d.f2353a);
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "GUID", "");
            if (TextUtils.isEmpty(com.tencent.tbs.one.impl.a.d.f2355c)) {
                com.tencent.tbs.one.impl.a.d.f2355c = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "ADRID", com.tencent.tbs.one.impl.a.d.f2355c);
            com.tencent.tbs.one.impl.a.e.a(jSONObject, "UA", com.tencent.tbs.one.impl.a.d.a());
            f.a("[%s] Requesting DEPS from %s, post data: %s", str, str2, jSONObject);
            this.f2669i = new com.tencent.tbs.one.impl.d.a(context, str2, "POST", null, jSONObject.toString().getBytes(com.tencent.tbs.one.impl.common.b.f2545a));
            this.f2669i.f2621f = this;
            this.f2669i.a((l) new l<Integer>() {
                /* class com.tencent.tbs.one.impl.e.a.b.AnonymousClass2 */

                @Override // com.tencent.tbs.one.impl.a.l
                public final void a(int i2, int i3) {
                    AppMethodBeat.i(174054);
                    b.this.a(i3);
                    AppMethodBeat.o(174054);
                }

                @Override // com.tencent.tbs.one.impl.a.l
                public final void a(int i2, String str, Throwable th) {
                    AppMethodBeat.i(174055);
                    b.this.a(i2, str, th);
                    h.a("TBSOneAction", 1002, null);
                    AppMethodBeat.o(174055);
                }
            });
            AppMethodBeat.o(174040);
            return;
        }
        f.a("[%s] Intercepted DEPS installation job by runtime extension", str);
        this.f2662b = shouldOverrideInstallationJob;
        AppMethodBeat.o(174040);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void a(int i2, String str, Throwable th) {
        AppMethodBeat.i(174042);
        com.tencent.tbs.one.impl.e.f.a(this.f2668h, System.currentTimeMillis());
        super.a(i2, str, th);
        AppMethodBeat.o(174042);
    }

    @Override // com.tencent.tbs.one.impl.d.a.AbstractC2197a
    public final void a(int i2, Map<String, List<String>> map, InputStream inputStream) {
        int shouldInterceptDEPSResponse;
        AppMethodBeat.i(174043);
        Context context = this.f2663c;
        final String str = this.f2664d;
        String str2 = this.f2665e;
        final File file = this.f2668h;
        f.a("[%s] Receiving DEPS response: [%d] %s", str, Integer.valueOf(i2), map);
        if (i2 != 200 || inputStream == null) {
            a(210, "Invalid DEPS response stream, url: " + str2 + ", statusCode: " + i2, (Throwable) null);
            AppMethodBeat.o(174043);
            return;
        }
        TBSOneRuntimeExtension b2 = com.tencent.tbs.one.impl.common.a.b(context, str);
        if (b2 == null || (shouldInterceptDEPSResponse = b2.shouldInterceptDEPSResponse(str, null, inputStream, file, new TBSOneCallback<Void>() {
            /* class com.tencent.tbs.one.impl.e.a.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r6) {
                AppMethodBeat.i(174034);
                f.a("[%s] Finished intercepting DEPS response stream by runtime extension", str);
                b.this.f2662b = 0;
                try {
                    b.this.a(e.a(e.a.EXTENSION, d.a(file)));
                    AppMethodBeat.o(174034);
                } catch (TBSOneException e2) {
                    b.this.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                    AppMethodBeat.o(174034);
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174033);
                b.this.f2662b = 0;
                b.this.a(i2, str, (Throwable) null);
                AppMethodBeat.o(174033);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, int i3) {
                AppMethodBeat.i(174032);
                b.this.a(com.tencent.tbs.one.impl.e.f.a(i3, 50, 100));
                AppMethodBeat.o(174032);
            }
        })) == 0) {
            try {
                String a2 = c.a(inputStream, ProtocolPackage.ServerEncoding);
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    f.a("[%s] Receiving DEPS data %s", str, jSONObject);
                    int optInt = jSONObject.optInt("CODE", -1);
                    if (optInt != 0) {
                        a(213, "Failed to request DEPS, url: " + str2 + ", response code: " + optInt + ", message: " + jSONObject.optString("MSG"), (Throwable) null);
                        AppMethodBeat.o(174043);
                        return;
                    }
                    String optString = jSONObject.optString("DEPS");
                    try {
                        d a3 = d.a(optString);
                        c.a(optString, ProtocolPackage.ServerEncoding, file);
                        e a4 = e.a(e.a.ONLINE, a3);
                        a4.f2730c = jSONObject;
                        a(a4);
                        AppMethodBeat.o(174043);
                    } catch (TBSOneException e2) {
                        a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                        AppMethodBeat.o(174043);
                    } catch (IOException e3) {
                        a(305, "Failed to save online DEPS to " + file.getAbsolutePath(), e3);
                        AppMethodBeat.o(174043);
                    }
                } catch (JSONException e4) {
                    a(212, "Failed to parse DEPS response " + a2 + ", url: " + str2, e4);
                    AppMethodBeat.o(174043);
                }
            } catch (IOException e5) {
                a(211, "Failed to read DEPS response, url:".concat(String.valueOf(str2)), e5);
                AppMethodBeat.o(174043);
            }
        } else {
            f.a("[%s] Intercepted DEPS response stream by runtime extension", str);
            this.f2662b = shouldInterceptDEPSResponse;
            AppMethodBeat.o(174043);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        TBSOneRuntimeExtension b2;
        AppMethodBeat.i(174041);
        super.b();
        if (this.f2669i != null) {
            this.f2669i.b();
        }
        if (!(this.f2662b == 0 || (b2 = com.tencent.tbs.one.impl.common.a.b(this.f2663c, this.f2664d)) == null)) {
            b2.cancel(this.f2662b);
        }
        AppMethodBeat.o(174041);
    }
}
