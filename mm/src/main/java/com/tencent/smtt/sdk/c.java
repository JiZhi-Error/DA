package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.a.a;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.sdk.a.e;
import com.tencent.smtt.sdk.a.g;
import com.tencent.smtt.sdk.f;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f2005a = "EmergencyManager";

    /* renamed from: b  reason: collision with root package name */
    private static int f2006b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f2007c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static int f2008d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static int f2009e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static int f2010f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static int f2011g = 5;

    /* renamed from: h  reason: collision with root package name */
    private static c f2012h;

    /* renamed from: i  reason: collision with root package name */
    private long f2013i = Util.MILLSECONDS_OF_MINUTE;

    /* renamed from: j  reason: collision with root package name */
    private long f2014j = Util.MILLSECONDS_OF_DAY;
    private boolean k = false;

    static /* synthetic */ void a(c cVar, Context context, int i2, List list) {
        AppMethodBeat.i(188301);
        cVar.a(context, i2, list);
        AppMethodBeat.o(188301);
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(188295);
            if (f2012h == null) {
                f2012h = new c();
            }
            cVar = f2012h;
            AppMethodBeat.o(188295);
        }
        return cVar;
    }

    public void a(Context context, Integer num, Map<Integer, String> map) {
        AppMethodBeat.i(188296);
        g a2 = g.a(true);
        if (a2 == null) {
            AppMethodBeat.o(188296);
            return;
        }
        TbsWizard a3 = a2.a();
        if (a3 == null) {
            AppMethodBeat.o(188296);
            return;
        }
        DexLoader dexLoader = a3.dexLoader();
        if (dexLoader != null) {
            TbsLog.e(f2005a, "Dispatch emergency commands on tbs shell");
            dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "dispatchEmergencyCommand", new Class[]{Integer.class, Map.class}, num, map);
            AppMethodBeat.o(188296);
            return;
        }
        TbsLog.e(f2005a, "Dex loader is null, cancel commands dispatching of tbs shell");
        AppMethodBeat.o(188296);
    }

    public void a(Context context) {
        AppMethodBeat.i(188297);
        if (!this.k) {
            this.k = true;
            g a2 = g.a();
            if (!a2.b()) {
                a2.a(context);
                try {
                    long b2 = g.a().b(context, "emergence_timestamp");
                    long b3 = g.a().b(context, "emergence_req_interval");
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = currentTimeMillis - b2;
                    long min = Math.min(Math.max(this.f2013i, b3), this.f2014j);
                    if (j2 > min) {
                        TbsLog.d(f2005a, "Emergency configuration is out of date, attempt to query again, " + (j2 / 1000) + " seconds has past");
                        g.a().a(context, "emergence_timestamp", currentTimeMillis);
                        b(context);
                    } else {
                        a(context, f2007c, new ArrayList());
                        TbsLog.d(f2005a, "Emergency configuration is up to date, " + (j2 / 1000) + " seconds has past, need " + (Math.abs(j2 - min) / 1000) + " more seconds for an another request");
                    }
                    return;
                } catch (Exception e2) {
                    a(context, f2011g, new ArrayList());
                    TbsLog.d(f2005a, "Unexpected exception happened when query emergency configuration: " + e2.getMessage());
                    return;
                } finally {
                    g.a().c();
                    AppMethodBeat.o(188297);
                }
            } else {
                a(context, f2010f, new ArrayList());
                TbsLog.d(f2005a, "Emergency preference is locked by another process");
            }
        }
        AppMethodBeat.o(188297);
    }

    private void b(final Context context) {
        String[] a2;
        AppMethodBeat.i(188298);
        com.tencent.smtt.sdk.a.c cVar = new com.tencent.smtt.sdk.a.c();
        cVar.a(b.a(context));
        cVar.b(b.c(context));
        cVar.a(Integer.valueOf(b.b(context)));
        cVar.c(b.a());
        ArrayList arrayList = new ArrayList();
        for (String str : g.a().a(context, "emergence_ids")) {
            try {
                if (!TextUtils.isEmpty(str) && (a2 = g.a(str)) != null && a2.length == 2) {
                    int parseInt = Integer.parseInt(a2[0]);
                    if (System.currentTimeMillis() < Long.parseLong(a2[1])) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e2) {
            }
        }
        cVar.a(arrayList);
        new e(context, n.a(context).g(), cVar.a()).a(new e.a() {
            /* class com.tencent.smtt.sdk.c.AnonymousClass1 */

            @Override // com.tencent.smtt.sdk.a.e.a
            public void a(String str) {
                AppMethodBeat.i(188345);
                TbsLog.d(c.f2005a, "Request emergency configuration finished: ".concat(String.valueOf(str)));
                d a2 = d.a(str);
                if (a2 == null || a2.a() != 0) {
                    TbsLog.d(c.f2005a, "Request emergency bad request");
                    c.a(c.this, context, c.f2009e, new ArrayList());
                    AppMethodBeat.o(188345);
                    return;
                }
                g.a().a(context, "emergence_req_interval", a2.b());
                List<com.tencent.smtt.sdk.a.b> c2 = a2.c();
                if (c2 != null) {
                    TbsLog.d(c.f2005a, "Request emergency ok");
                    c.a(c.this, context, c.f2006b, c2);
                    AppMethodBeat.o(188345);
                    return;
                }
                TbsLog.d(c.f2005a, "Request emergency no configuration");
                c.a(c.this, context, c.f2008d, new ArrayList());
                AppMethodBeat.o(188345);
            }
        });
        AppMethodBeat.o(188298);
    }

    private void a(Context context, int i2, List<com.tencent.smtt.sdk.a.b> list) {
        AppMethodBeat.i(188299);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g a2 = g.a();
        List<String> a3 = a2.a(context, "emergence_ids");
        HashSet hashSet = new HashSet();
        if (a3 != null && !a3.isEmpty()) {
            for (String str : a3) {
                String[] a4 = g.a(str);
                if (a4 != null && a4.length == 2) {
                    hashSet.add(Integer.valueOf(Integer.parseInt(a4[0])));
                }
            }
        }
        for (com.tencent.smtt.sdk.a.b bVar : list) {
            int b2 = bVar.b();
            int a5 = bVar.a();
            if (hashSet.contains(Integer.valueOf(a5))) {
                TbsLog.d(f2005a, "Command has been executed: " + bVar.toString() + ", ignored");
            } else if (bVar.e()) {
                TbsLog.d(f2005a, "Command is out of date: " + bVar.toString() + ", now: " + a.a(System.currentTimeMillis()));
            } else {
                linkedHashMap.put(Integer.valueOf(b2), bVar.c());
                TbsLog.d(f2005a, "Emergence command: " + bVar.toString());
                a2.a(context, "emergence_ids", g.a(new String[]{String.valueOf(a5), String.valueOf(bVar.d())}));
            }
        }
        a(context, i2, linkedHashMap);
        a(context, Integer.valueOf(i2), linkedHashMap);
        AppMethodBeat.o(188299);
    }

    private void a(final Context context, int i2, Map<Integer, String> map) {
        AppMethodBeat.i(188300);
        f a2 = f.a();
        a2.a(i2, map);
        a2.a(1000, new f.a() {
            /* class com.tencent.smtt.sdk.c.AnonymousClass2 */

            @Override // com.tencent.smtt.sdk.f.a
            public void a(String str) {
                AppMethodBeat.i(188065);
                new StringBuilder("Execute command [1000](").append(str).append("), force tbs downloader request");
                SharedPreferences.Editor edit = TbsDownloadConfig.getInstance(context).mPreferences.edit();
                edit.putLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0);
                edit.apply();
                edit.commit();
                AppMethodBeat.o(188065);
            }
        });
        AppMethodBeat.o(188300);
    }
}
