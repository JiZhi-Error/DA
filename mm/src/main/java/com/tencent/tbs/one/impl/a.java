package com.tencent.tbs.one.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.a.b;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.tbs.one.impl.e.i;
import java.io.File;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2323a = {"com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_DEMO};

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2324b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2325c;

    static {
        AppMethodBeat.i(174175);
        AppMethodBeat.o(174175);
    }

    public static com.tencent.tbs.one.impl.a.a<e<d>> a(i iVar, int i2, File file, Bundle bundle) {
        AppMethodBeat.i(188036);
        b bVar = new b(iVar.f2753a, iVar.f2754b, iVar.f(), iVar.e(), i2, file, bundle);
        AppMethodBeat.o(188036);
        return bVar;
    }

    public static com.tencent.tbs.one.impl.a.a<e<File>> a(i iVar, d.a aVar, File file, Bundle bundle) {
        AppMethodBeat.i(188037);
        com.tencent.tbs.one.impl.e.a.a aVar2 = new com.tencent.tbs.one.impl.e.a.a(iVar.f2753a, iVar.f2754b, iVar.f(), iVar.e(), aVar, file, bundle);
        AppMethodBeat.o(188037);
        return aVar2;
    }

    public static h a(Context context, String str) {
        AppMethodBeat.i(174172);
        File file = new File(new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "tencent"), "tbs"), context.getPackageName()), str), "debug.conf");
        String str2 = file.exists() ? "https://tbsone.sparta.html5.qq.com" : "https://tbsone.imtt.qq.com";
        StatisticReport.shiftRepService(file.exists());
        i iVar = new i(context, str, "/android_asset/", str2, f2323a);
        if (BuildConfig.KINDA_DEFAULT.equals(str)) {
            SharedPreferences sharedPreferences = iVar.m;
            if (!sharedPreferences.contains("in_use_component_names")) {
                try {
                    Set<String> keySet = com.tencent.tbs.b.a.RSp.keySet();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putStringSet("in_use_component_names", keySet);
                    edit.apply();
                } catch (Throwable th) {
                    f.c("[%s] Failed to preset in-use component names", str, th);
                }
            }
        }
        AppMethodBeat.o(174172);
        return iVar;
    }

    public static void a(Context context) {
        AppMethodBeat.i(174171);
        synchronized (f2324b) {
            try {
                if (!f2325c) {
                    com.tencent.tbs.a.e.cV(context.getApplicationContext(), "onelog");
                    f.a(new f.b() {
                        /* class com.tencent.tbs.one.impl.a.AnonymousClass1 */

                        @Override // com.tencent.tbs.one.impl.a.f.b
                        public final void a(int i2, String str) {
                            AppMethodBeat.i(173887);
                            com.tencent.tbs.a.e.a(i2, "TBSOne", str);
                            AppMethodBeat.o(173887);
                        }
                    });
                    StatisticReport.initialize(context.getApplicationContext());
                    com.tencent.tbs.one.impl.common.h.f2579a = new h.a() {
                        /* class com.tencent.tbs.one.impl.a.AnonymousClass2 */

                        @Override // com.tencent.tbs.one.impl.common.h.a
                        public final void a(String str, int i2, Map map) {
                            AppMethodBeat.i(173886);
                            if ("TBSOneAction".equals(str)) {
                                StatisticReport.create(str, i2).report();
                                AppMethodBeat.o(173886);
                            } else if (i2 == 201 || i2 == 209 || i2 == 214 || i2 == 506) {
                                AppMethodBeat.o(173886);
                            } else {
                                StatisticReport create = StatisticReport.create(str, i2);
                                if (map != null) {
                                    if (map.containsKey("DEPS_VERSION_CODE")) {
                                        create.setDEPSCode(((Integer) map.get("DEPS_VERSION_CODE")).intValue());
                                    }
                                    String str2 = map.containsKey("COMPONENT_NAME") ? (String) map.get("COMPONENT_NAME") : "";
                                    int i3 = -1;
                                    if (map.containsKey("COMPONENT_VERSION_CODE")) {
                                        i3 = ((Integer) map.get("COMPONENT_VERSION_CODE")).intValue();
                                    }
                                    create.setComponent(str2, i3);
                                    String str3 = map.containsKey(ShareConstants.DESCRIPTION) ? (String) map.get(ShareConstants.DESCRIPTION) : "";
                                    Throwable th = null;
                                    if (map.containsKey("THROWABLE")) {
                                        th = (Throwable) map.get("THROWABLE");
                                    }
                                    create.setDescription(str3, th);
                                }
                                create.report();
                                AppMethodBeat.o(173886);
                            }
                        }
                    };
                    Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(context.getDir("tbs", 0)));
                    f2325c = true;
                }
            } finally {
                AppMethodBeat.o(174171);
            }
        }
    }
}
