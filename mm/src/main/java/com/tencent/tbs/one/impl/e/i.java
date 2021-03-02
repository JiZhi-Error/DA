package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.d;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.b.b;
import com.tencent.tbs.one.impl.common.ConfigurationKeys;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class i extends h {
    public SharedPreferences m;
    g n;
    private Set<String> o;
    private final Object p = new Object();
    private final Object q = new Object();
    private b r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String[] w;
    private String[] x;
    private final Runnable y = new Runnable() {
        /* class com.tencent.tbs.one.impl.e.i.AnonymousClass1 */

        public final void run() {
            boolean z;
            AppMethodBeat.i(174074);
            String str = i.this.f2754b;
            f.a("[%s] Running idle task", str);
            if (i.this.n != null) {
                if (i.this.n.f2741a != null) {
                    f.a("[%s] %s in updating", str, "Early out for idle task,");
                    i.this.j();
                    AppMethodBeat.o(174074);
                    return;
                }
            }
            for (com.tencent.tbs.one.impl.c.b bVar : i.this.f2762j.values()) {
                if (!bVar.f2494e || bVar.k != null) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    f.a("[%s] %s in loading component", str, "Early out for idle task,");
                    i.this.j();
                    AppMethodBeat.o(174074);
                    return;
                }
            }
            f.a(i.this.f2753a);
            f.d(i.this.f2755c);
            if (!i.this.f2757e) {
                f.a("[%s] %s disabled", str, "Early out for auto update,");
                AppMethodBeat.o(174074);
            } else if (!i.this.a()) {
                f.a("[%s] %s not use online service", str, "Early out for auto update,");
                AppMethodBeat.o(174074);
            } else {
                long j2 = i.this.m.getLong("last_update_time", 0);
                if (System.currentTimeMillis() - j2 < Util.MILLSECONDS_OF_DAY) {
                    f.a("[%s] %s the interval is not reached, last update time: %s", str, "Early out for auto update,", d.a(j2));
                    AppMethodBeat.o(174074);
                    return;
                }
                i.this.c().update(null, new TBSOneCallback<Void>() {
                    /* class com.tencent.tbs.one.impl.e.i.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final /* synthetic */ void onCompleted(Void r3) {
                        AppMethodBeat.i(174073);
                        i.this.k();
                        AppMethodBeat.o(174073);
                    }

                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final void onError(int i2, String str) {
                        AppMethodBeat.i(174072);
                        i.this.k();
                        AppMethodBeat.o(174072);
                    }
                });
                AppMethodBeat.o(174074);
            }
        }
    };

    public i(Context context, String str, String str2, String str3, String[] strArr) {
        super(context, str);
        AppMethodBeat.i(174076);
        this.s = str2;
        this.u = str3;
        this.w = strArr;
        this.m = context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", str), 4);
        if (!this.m.contains("last_update_time")) {
            k();
        }
        this.o = this.m.getStringSet("disabled_component_names", new HashSet());
        f.a("[%s] Disabled components {%s} from preferences", str, TextUtils.join(", ", this.o));
        j();
        AppMethodBeat.o(174076);
    }

    private a<e<File>> a(TBSOneManager.Policy policy, d.a aVar, final File file, Bundle bundle) {
        AppMethodBeat.i(188032);
        final Context context = this.f2753a;
        String str = this.f2754b;
        a<e<File>> aVar2 = null;
        switch (policy) {
            case BUILTIN_ONLY:
                aVar2 = new com.tencent.tbs.one.impl.e.b.a(context, str, aVar, file, bundle);
                break;
            case LOCAL_ONLY:
                final String m2 = m();
                final String str2 = aVar.f2561d;
                final int i2 = aVar.f2560c;
                aVar2 = new a<e<File>>() {
                    /* class com.tencent.tbs.one.impl.e.i.AnonymousClass4 */

                    @Override // com.tencent.tbs.one.impl.a.a
                    public final void a() {
                        InputStream inputStream = null;
                        AppMethodBeat.i(174027);
                        try {
                            inputStream = c.a(context, m2, str2);
                            c.a(inputStream, file, (File) null);
                            c.a(inputStream);
                            try {
                                f.a(file, file);
                                f.a(file, i2);
                                a(e.a(e.a.LOCAL, file));
                                AppMethodBeat.o(174027);
                            } catch (TBSOneException e2) {
                                a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                                AppMethodBeat.o(174027);
                            }
                        } catch (IOException e3) {
                            a(313, "Failed to unzip local component from " + str2 + " to " + file.getAbsolutePath() + ", localRepository: " + m2, e3);
                            c.a(inputStream);
                            AppMethodBeat.o(174027);
                        } catch (Throwable th) {
                            c.a(inputStream);
                            AppMethodBeat.o(174027);
                            throw th;
                        }
                    }
                };
                break;
            case ONLINE:
                aVar2 = new com.tencent.tbs.one.impl.e.c.a(context, str, aVar, file, bundle);
                break;
            case AUTO:
                aVar2 = com.tencent.tbs.one.impl.a.a(this, aVar, file, bundle);
                break;
        }
        AppMethodBeat.o(188032);
        return aVar2;
    }

    private boolean a(String str, TBSOneCallback tBSOneCallback) {
        AppMethodBeat.i(188025);
        if (this.o.contains(str)) {
            if (tBSOneCallback != null) {
                tBSOneCallback.onError(501, "The component has disabled");
            }
            AppMethodBeat.o(188025);
            return false;
        }
        AppMethodBeat.o(188025);
        return true;
    }

    private void f(String str) {
        AppMethodBeat.i(174099);
        File d2 = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.f2753a.getDir("tbs", 0), Process.myPid()), this.f2754b);
        c.d(d2.getParentFile());
        if (!d2.exists()) {
            c.b(d2);
        }
        HashSet hashSet = new HashSet(Arrays.asList(l()));
        hashSet.add(str);
        SharedPreferences.Editor edit = this.m.edit();
        edit.putStringSet("in_use_component_names", hashSet);
        edit.apply();
        AppMethodBeat.o(174099);
    }

    private String m() {
        AppMethodBeat.i(174091);
        if (this.t == null) {
            TBSOneDelegate tBSOneDelegate = this.f2758f;
            if (tBSOneDelegate != null) {
                String shouldOverrideLocalRepositoryPath = tBSOneDelegate.shouldOverrideLocalRepositoryPath(this.f2754b, this.s);
                if (shouldOverrideLocalRepositoryPath != null) {
                    this.t = shouldOverrideLocalRepositoryPath;
                } else {
                    this.t = this.s;
                }
            } else {
                this.t = this.s;
            }
        }
        String str = this.t;
        AppMethodBeat.o(174091);
        return str;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final a<e<com.tencent.tbs.one.impl.common.d>> a(Bundle bundle, l<e<com.tencent.tbs.one.impl.common.d>> lVar) {
        boolean z;
        AppMethodBeat.i(188029);
        TBSOneManager.Policy policy = this.f2756d;
        if (policy == TBSOneManager.Policy.BUILTIN_ONLY) {
            a<e<com.tencent.tbs.one.impl.common.d>> a2 = super.a(bundle, lVar);
            AppMethodBeat.o(188029);
            return a2;
        }
        String str = this.f2754b;
        f.a("[%s] Installing DEPS, policy: %s", str, policy);
        File b2 = com.tencent.tbs.one.impl.common.f.b(this.f2755c);
        if (h()) {
            f.a("[%s] Applying the last update", str);
            Context context = this.f2753a;
            f.a(context);
            j i2 = i();
            if (i2 != null) {
                j a3 = j.a(com.tencent.tbs.one.impl.common.f.e(b2, ".lock"));
                if (a3 != null) {
                    if (h()) {
                        File[] listFiles = com.tencent.tbs.one.impl.common.f.b(context).listFiles();
                        if (listFiles != null) {
                            int length = listFiles.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                File file = listFiles[i3];
                                if (!file.getName().equals(String.valueOf(Process.myPid())) && com.tencent.tbs.one.impl.common.f.d(file, str).exists()) {
                                    f.a("[%s] The category is being used by process %s", str, file.getName());
                                    z = true;
                                    break;
                                }
                                i3++;
                            }
                        }
                        z = false;
                        if (!z) {
                            try {
                                c.c(com.tencent.tbs.one.impl.common.f.c(this.f2755c), b2);
                            } catch (IOException e2) {
                                f.c("[%s] Failed to apply the last update", str, e2);
                            }
                        } else {
                            f.a("[%s] %s the category is being used by other processes", str, "Early out for applying the last update,");
                        }
                    } else {
                        f.a("[%s] %s the last update has applied by another process", str, "Early out for applying the last update,");
                    }
                    a3.a();
                } else {
                    f.a("[%s] %s the DEPS installation lock is busy", str, "Early out for applying the last update,");
                }
                i2.a();
            } else {
                f.a("[%s] %s the update lock is busy", str, "Early out for applying the last update,");
            }
        }
        Object obj = this.f2759g.get(ConfigurationKeys.PERMANENT_VERSION);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
        d dVar = new d(policy == TBSOneManager.Policy.AUTO ? a(TBSOneManager.Policy.AUTO, intValue, b2, bundle) : policy == TBSOneManager.Policy.LOCAL_ONLY ? a(TBSOneManager.Policy.LOCAL_ONLY, intValue, b2, bundle) : policy == TBSOneManager.Policy.ONLINE ? a(TBSOneManager.Policy.ONLINE, intValue, b2, bundle) : policy == TBSOneManager.Policy.BUILTIN_FIRST ? new g<>(new a[]{a(TBSOneManager.Policy.BUILTIN_ONLY, intValue, b2, bundle), a(TBSOneManager.Policy.AUTO, intValue, b2, bundle)}) : policy == TBSOneManager.Policy.LOCAL_FIRST ? new g<>(new a[]{a(TBSOneManager.Policy.LOCAL_ONLY, intValue, b2, bundle), a(TBSOneManager.Policy.AUTO, intValue, b2, bundle)}) : null, b2);
        dVar.a((l) new l<e<com.tencent.tbs.one.impl.common.d>>() {
            /* class com.tencent.tbs.one.impl.e.i.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.impl.a.l
            public final /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                AppMethodBeat.i(174115);
                i.this.b(eVar);
                AppMethodBeat.o(174115);
            }
        });
        dVar.a((l) lVar);
        AppMethodBeat.o(188029);
        return dVar;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final a<e<File>> a(Bundle bundle, d.a aVar, l<e<File>> lVar) {
        AppMethodBeat.i(188030);
        TBSOneManager.Policy policy = this.f2756d;
        if (policy == TBSOneManager.Policy.BUILTIN_ONLY) {
            a<e<File>> a2 = super.a(bundle, aVar, lVar);
            AppMethodBeat.o(188030);
            return a2;
        }
        f.a("[%s] Installing component %s, version: %d, policy: %s", this.f2754b, aVar.f2558a, Integer.valueOf(aVar.f2560c), policy);
        File a3 = a(aVar.f2558a, aVar.f2560c);
        c.d(a3.getParentFile());
        a<e<File>> aVar2 = null;
        if (policy == TBSOneManager.Policy.AUTO) {
            aVar2 = a(TBSOneManager.Policy.AUTO, aVar, a3, bundle);
        } else if (policy == TBSOneManager.Policy.LOCAL_ONLY) {
            aVar2 = a(TBSOneManager.Policy.LOCAL_ONLY, aVar, a3, bundle);
        } else if (policy == TBSOneManager.Policy.ONLINE) {
            aVar2 = a(TBSOneManager.Policy.ONLINE, aVar, a3, bundle);
        } else if (policy == TBSOneManager.Policy.BUILTIN_FIRST) {
            aVar2 = new g<>(new a[]{a(TBSOneManager.Policy.BUILTIN_ONLY, aVar, a3, bundle), a(TBSOneManager.Policy.AUTO, aVar, a3, bundle)});
        } else if (policy == TBSOneManager.Policy.LOCAL_FIRST) {
            aVar2 = new g<>(new a[]{a(TBSOneManager.Policy.LOCAL_ONLY, aVar, a3, bundle), a(TBSOneManager.Policy.AUTO, aVar, a3, bundle)});
        }
        c cVar = new c(aVar, aVar2, a3);
        cVar.a((l) lVar);
        AppMethodBeat.o(188030);
        return cVar;
    }

    public final a<e<com.tencent.tbs.one.impl.common.d>> a(TBSOneManager.Policy policy, int i2, final File file, Bundle bundle) {
        AppMethodBeat.i(188031);
        final Context context = this.f2753a;
        String str = this.f2754b;
        a<e<com.tencent.tbs.one.impl.common.d>> aVar = null;
        switch (policy) {
            case BUILTIN_ONLY:
                aVar = new com.tencent.tbs.one.impl.e.b.b(context, str, file);
                break;
            case LOCAL_ONLY:
                final String m2 = m();
                aVar = new a<e<com.tencent.tbs.one.impl.common.d>>() {
                    /* class com.tencent.tbs.one.impl.e.i.AnonymousClass3 */

                    @Override // com.tencent.tbs.one.impl.a.a
                    public final void a() {
                        AppMethodBeat.i(173977);
                        InputStream inputStream = null;
                        try {
                            inputStream = c.a(context, m2, "DEPS");
                            com.tencent.tbs.one.impl.common.d a2 = com.tencent.tbs.one.impl.common.d.a(c.a(inputStream, ProtocolPackage.ServerEncoding, file));
                            c.a(inputStream);
                            a(e.a(e.a.LOCAL, a2));
                            AppMethodBeat.o(173977);
                        } catch (IOException e2) {
                            a(303, "Failed to copy local DEPS from " + m2 + " to " + file.getAbsolutePath(), e2);
                            c.a(inputStream);
                            AppMethodBeat.o(173977);
                        } catch (TBSOneException e3) {
                            a(e3.getErrorCode(), e3.getMessage(), e3.getCause());
                            c.a(inputStream);
                            AppMethodBeat.o(173977);
                        } catch (Throwable th) {
                            c.a(inputStream);
                            AppMethodBeat.o(173977);
                            throw th;
                        }
                    }
                };
                break;
            case ONLINE:
                aVar = new com.tencent.tbs.one.impl.e.c.b(context, str, f(), file);
                break;
            case AUTO:
                aVar = com.tencent.tbs.one.impl.a.a(this, i2, file, bundle);
                break;
        }
        AppMethodBeat.o(188031);
        return aVar;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(Bundle bundle, String str, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188028);
        if (a(str, (TBSOneCallback) tBSOneCallback)) {
            super.a(bundle, str, tBSOneCallback);
        }
        AppMethodBeat.o(188028);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        AppMethodBeat.i(174102);
        super.a(eVar);
        SharedPreferences.Editor edit = this.m.edit();
        edit.putInt("in_use_deps_version", eVar.f2729b.f2555a);
        edit.apply();
        AppMethodBeat.o(174102);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        AppMethodBeat.i(188026);
        f(str);
        if (a(str, (TBSOneCallback) tBSOneCallback)) {
            super.a(str, bundle, tBSOneCallback);
        }
        AppMethodBeat.o(188026);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(String str, Object obj) {
        AppMethodBeat.i(174077);
        super.a(str, obj);
        if (str.equals(ConfigurationKeys.PERMANENT_VERSION)) {
            a(false);
        }
        AppMethodBeat.o(174077);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(boolean z) {
        AppMethodBeat.i(174078);
        super.a(z);
        if (z) {
            j();
        }
        AppMethodBeat.o(174078);
    }

    public final void b(e<com.tencent.tbs.one.impl.common.d> eVar) {
        AppMethodBeat.i(174101);
        if (eVar.f2728a != e.a.ONLINE) {
            AppMethodBeat.o(174101);
            return;
        }
        HashSet hashSet = new HashSet();
        if (eVar.f2730c instanceof JSONObject) {
            String str = this.f2754b;
            JSONObject jSONObject = (JSONObject) eVar.f2730c;
            JSONObject optJSONObject = jSONObject.optJSONObject("SWITCH");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (optJSONObject.optInt(next, 0) == 1) {
                        hashSet.add(next);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("RESET");
            if (optJSONObject2 != null) {
                T t2 = eVar.f2729b;
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (optJSONObject2.optInt(next2, 0) == 1) {
                        d.a b2 = t2.b(next2);
                        if (b2 != null) {
                            File a2 = a(next2, b2.f2560c);
                            if (a2.exists()) {
                                f.e(a2);
                                f.a("[%s] Reset component %s", str, a2.getAbsolutePath());
                            } else {
                                f.c("[%s] Failed to reset component, %s does not exist", str, a2.getAbsolutePath());
                            }
                        } else {
                            f.c("[%s] Failed to reset component %s, no component config", str, next2);
                        }
                    }
                }
            }
            if (jSONObject.optInt("ULOG") == 1) {
                StatisticReport.reportLog();
            }
        }
        this.o = hashSet;
        f.a("[%s] Disabled components {%s} from server", this.f2754b, TextUtils.join(", ", this.o));
        SharedPreferences.Editor edit = this.m.edit();
        edit.putStringSet("disabled_component_names", hashSet);
        edit.apply();
        AppMethodBeat.o(174101);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void b(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188027);
        f(str);
        if (a(str, (TBSOneCallback) tBSOneCallback)) {
            super.b(str, bundle, tBSOneCallback);
        }
        AppMethodBeat.o(188027);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final boolean b(String str) {
        AppMethodBeat.i(174081);
        File a2 = a(str);
        if (!a2.exists()) {
            AppMethodBeat.o(174081);
            return false;
        }
        File[] listFiles = a2.listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(174081);
            return false;
        }
        for (File file : listFiles) {
            if (file.isDirectory() && f.g(file)) {
                AppMethodBeat.o(174081);
                return true;
            }
        }
        AppMethodBeat.o(174081);
        return false;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final TBSOneOnlineService c() {
        g gVar;
        AppMethodBeat.i(174079);
        if (!a()) {
            AppMethodBeat.o(174079);
            return null;
        }
        synchronized (this.p) {
            try {
                if (this.n == null) {
                    this.n = new g(this);
                }
                gVar = this.n;
            } finally {
                AppMethodBeat.o(174079);
            }
        }
        return gVar;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final int[] c(String str) {
        File[] listFiles;
        int i2;
        AppMethodBeat.i(174082);
        File a2 = a(str);
        if (!a2.exists() || (listFiles = a2.listFiles()) == null) {
            int[] iArr = new int[0];
            AppMethodBeat.o(174082);
            return iArr;
        }
        int[] iArr2 = new int[listFiles.length];
        int length = listFiles.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            File file = listFiles[i3];
            if (!file.isDirectory() || !f.g(file)) {
                i2 = i4;
            } else {
                try {
                    i2 = i4 + 1;
                    try {
                        iArr2[i4] = Integer.parseInt(file.getName());
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    i2 = i4;
                    f.c("[%s] Failed to parse installed version from path %s", this.f2754b, file.getAbsolutePath());
                    i3++;
                    i4 = i2;
                }
            }
            i3++;
            i4 = i2;
        }
        int[] copyOfRange = Arrays.copyOfRange(iArr2, 0, i4);
        AppMethodBeat.o(174082);
        return copyOfRange;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final TBSOneDebugger d() {
        b bVar;
        AppMethodBeat.i(174080);
        synchronized (this.q) {
            try {
                if (this.r == null) {
                    this.r = new b(this.f2754b);
                }
                bVar = this.r;
            } finally {
                AppMethodBeat.o(174080);
            }
        }
        return bVar;
    }

    public final String[] e() {
        AppMethodBeat.i(174092);
        if (this.x == null) {
            TBSOneDelegate tBSOneDelegate = this.f2758f;
            if (tBSOneDelegate != null) {
                String[] shouldOverrideSharableApplicationPackages = tBSOneDelegate.shouldOverrideSharableApplicationPackages(this.f2754b, this.w);
                if (shouldOverrideSharableApplicationPackages != null) {
                    this.x = shouldOverrideSharableApplicationPackages;
                } else {
                    this.x = this.w;
                }
            } else {
                this.x = this.w;
            }
        }
        String[] strArr = this.x;
        AppMethodBeat.o(174092);
        return strArr;
    }

    public final String f() {
        AppMethodBeat.i(174093);
        if (this.v == null) {
            TBSOneDelegate tBSOneDelegate = this.f2758f;
            if (tBSOneDelegate != null) {
                String shouldOverrideOnlineServiceUrl = tBSOneDelegate.shouldOverrideOnlineServiceUrl(this.f2754b, this.u);
                if (shouldOverrideOnlineServiceUrl != null) {
                    this.v = shouldOverrideOnlineServiceUrl;
                } else {
                    this.v = this.u;
                }
            } else {
                this.v = this.u;
            }
        }
        String str = this.v;
        AppMethodBeat.o(174093);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final File g() {
        AppMethodBeat.i(174094);
        File file = new File(this.f2755c, "incomplete-update");
        AppMethodBeat.o(174094);
        return file;
    }

    public final boolean h() {
        AppMethodBeat.i(174095);
        boolean exists = com.tencent.tbs.one.impl.common.f.c(this.f2755c).exists();
        boolean z = !g().exists();
        f.a("[%s] Checking update availability, exists: %b, complete: %b", this.f2754b, Boolean.valueOf(exists), Boolean.valueOf(z));
        if (!exists || !z) {
            AppMethodBeat.o(174095);
            return false;
        }
        AppMethodBeat.o(174095);
        return true;
    }

    public final j i() {
        AppMethodBeat.i(174096);
        j a2 = j.a(com.tencent.tbs.one.impl.common.f.e(com.tencent.tbs.one.impl.common.f.c(this.f2755c), ".lock"));
        AppMethodBeat.o(174096);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        AppMethodBeat.i(174097);
        Handler a2 = m.a();
        a2.removeCallbacks(this.y);
        a2.postDelayed(this.y, 10000);
        AppMethodBeat.o(174097);
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        AppMethodBeat.i(174098);
        SharedPreferences.Editor edit = this.m.edit();
        edit.putLong("last_update_time", System.currentTimeMillis());
        edit.apply();
        AppMethodBeat.o(174098);
    }

    public final String[] l() {
        AppMethodBeat.i(174100);
        String[] strArr = (String[]) this.m.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
        AppMethodBeat.o(174100);
        return strArr;
    }
}
