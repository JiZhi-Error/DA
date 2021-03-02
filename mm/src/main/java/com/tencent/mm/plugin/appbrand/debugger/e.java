package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.network.d;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public final class e implements be.c, DebuggerShell.a {
    @Override // com.tencent.mm.plugin.appbrand.appcache.be.c
    public final void l(String str, Map<String, String> map) {
        AppMethodBeat.i(226510);
        if (DebuggerShell.bAx()) {
            Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", str);
            final String str2 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            final String str3 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            final int i2 = Util.getInt(map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            final int i3 = Util.getInt(map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            final String str4 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            final String str5 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            final String str6 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            final String str7 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
            map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
            map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
            if (i2 < 0) {
                AppMethodBeat.o(226510);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                int i4 = Util.getInt(map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.setEnableDebug"), -1);
                if (i4 == 1) {
                    m.an(str2, true);
                } else if (i4 == 0 && !m.Xd(str2)) {
                    m.an(str2, false);
                }
            }
            if (i2 != 0) {
                if (n.buL() == null) {
                    AppMethodBeat.o(226510);
                    return;
                } else if (Util.isNullOrNil(str5) || Util.isNullOrNil(str6)) {
                    if (i2 == 1) {
                        AppMethodBeat.o(226510);
                        return;
                    } else if (i2 == 2) {
                    }
                } else if (n.buL().a(str2, i2, str5, str6, Util.nowSecond(), Util.nowSecond() + 432000)) {
                    h.bWb().cl(str2, i2);
                }
            }
            Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", str3, str2, Integer.valueOf(i2));
            final g gVar = new g();
            final k kVar = new k(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44947);
                    if (j.a.sE(i2) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                        n.buL().a(str2, i2, str5, str6, 0, 0);
                    }
                    if (j.a.sE(i2) && !TextUtils.isEmpty(str7)) {
                        ((t) n.W(t.class)).A(str2, i2, str7);
                    }
                    gVar.appId = str2;
                    gVar.username = str3;
                    gVar.iOo = i2;
                    gVar.kHw = str4;
                    gVar.version = i3;
                    gVar.scene = 1030;
                    ((r) com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
                    AppMethodBeat.o(44947);
                }
            }, 2);
            String str8 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needjs");
            if (TextUtils.isEmpty(str8)) {
                kVar.countDown();
            } else {
                a(str2, "Needjs", str8, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.debugger.e.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(226507);
                        kVar.countDown();
                        AppMethodBeat.o(226507);
                    }
                });
            }
            String str9 = map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needwebviewjs");
            if (TextUtils.isEmpty(str9)) {
                kVar.countDown();
                AppMethodBeat.o(226510);
                return;
            }
            a(str2, "Needwebviewjs", str9, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.debugger.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(226508);
                    kVar.countDown();
                    AppMethodBeat.o(226508);
                }
            });
        }
        AppMethodBeat.o(226510);
    }

    private static void a(final String str, final String str2, final String str3, final Runnable runnable) {
        AppMethodBeat.i(226511);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.debugger.e.AnonymousClass4 */

            public final void run() {
                InputStream inputStream;
                OutputStream outputStream;
                Throwable th;
                Exception e2;
                AppMethodBeat.i(226509);
                String str = b.aKP() + str + "-" + str2 + "-" + Util.nowMilliSecond() + ".js";
                try {
                    x a2 = d.a(str3, null);
                    a2.setConnectTimeout(10000);
                    a2.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
                    a2.setRequestMethod("GET");
                    a2.getResponseCode();
                    inputStream = a2.getInputStream();
                    if (inputStream != null) {
                        try {
                            outputStream = s.dw(str, false);
                            try {
                                org.apache.commons.a.e.copy(inputStream, outputStream);
                                outputStream.flush();
                            } catch (Exception e3) {
                                e2 = e3;
                                try {
                                    Log.e("MicroMsg.AppBrand.ForceOpenAppNotify", "try download autoTestInjectJs appId:%s, name:%s, url:%s, failed, exception=%s", str, str2, str3, e2);
                                    org.apache.commons.a.e.W(inputStream);
                                    org.apache.commons.a.e.e(outputStream);
                                    runnable.run();
                                    AppMethodBeat.o(226509);
                                } catch (Throwable th2) {
                                    th = th2;
                                    org.apache.commons.a.e.W(inputStream);
                                    org.apache.commons.a.e.e(outputStream);
                                    runnable.run();
                                    AppMethodBeat.o(226509);
                                    throw th;
                                }
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            outputStream = null;
                            Log.e("MicroMsg.AppBrand.ForceOpenAppNotify", "try download autoTestInjectJs appId:%s, name:%s, url:%s, failed, exception=%s", str, str2, str3, e2);
                            org.apache.commons.a.e.W(inputStream);
                            org.apache.commons.a.e.e(outputStream);
                            runnable.run();
                            AppMethodBeat.o(226509);
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = null;
                            org.apache.commons.a.e.W(inputStream);
                            org.apache.commons.a.e.e(outputStream);
                            runnable.run();
                            AppMethodBeat.o(226509);
                            throw th;
                        }
                    } else {
                        outputStream = null;
                    }
                    String str2 = str;
                    String str3 = str2;
                    Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "setWxAutoTestJsFilePath appId:%s, name:%s, path:%s, md5:%s", str2, str3, str, WxaPkgWrappingInfo.n(new o(str)));
                    MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).putString(str2 + "-" + str3, str).commit();
                    org.apache.commons.a.e.W(inputStream);
                    org.apache.commons.a.e.e(outputStream);
                    runnable.run();
                    AppMethodBeat.o(226509);
                } catch (Exception e5) {
                    e2 = e5;
                    outputStream = null;
                    inputStream = null;
                    Log.e("MicroMsg.AppBrand.ForceOpenAppNotify", "try download autoTestInjectJs appId:%s, name:%s, url:%s, failed, exception=%s", str, str2, str3, e2);
                    org.apache.commons.a.e.W(inputStream);
                    org.apache.commons.a.e.e(outputStream);
                    runnable.run();
                    AppMethodBeat.o(226509);
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    inputStream = null;
                    org.apache.commons.a.e.W(inputStream);
                    org.apache.commons.a.e.e(outputStream);
                    runnable.run();
                    AppMethodBeat.o(226509);
                    throw th;
                }
            }
        });
        AppMethodBeat.o(226511);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final String name() {
        return "ForceOpenAppNotify";
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final void A(Intent intent) {
        AppMethodBeat.i(44949);
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a((Context) null, (String) null, stringExtra, intExtra, 0, (String) null, appBrandStatObject);
        AppMethodBeat.o(44949);
    }

    public static String cU(String str, String str2) {
        AppMethodBeat.i(226512);
        String string = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString(str + "-" + str2, null);
        AppMethodBeat.o(226512);
        return string;
    }
}
