package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.c.b;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.common.g;
import com.tencent.tbs.one.impl.e.e;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f2753a;

    /* renamed from: b  reason: collision with root package name */
    public String f2754b;

    /* renamed from: c  reason: collision with root package name */
    File f2755c;

    /* renamed from: d  reason: collision with root package name */
    public volatile TBSOneManager.Policy f2756d = TBSOneManager.Policy.AUTO;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f2757e = false;

    /* renamed from: f  reason: collision with root package name */
    public TBSOneDelegate f2758f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f2759g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    public d f2760h;

    /* renamed from: i  reason: collision with root package name */
    public a<d> f2761i;

    /* renamed from: j  reason: collision with root package name */
    Map<String, b> f2762j = new ConcurrentHashMap();
    public Map<String, List<g>> k = new ConcurrentHashMap();
    public b l = new b(this);

    public h(Context context, String str) {
        AppMethodBeat.i(174116);
        if (context.getApplicationContext() != null) {
            this.f2753a = context.getApplicationContext();
        } else {
            this.f2753a = context;
        }
        this.f2754b = str;
        this.f2755c = f.a(context.getDir("tbs", 0), str);
        c.d(this.f2755c);
        c.d(f.d(this.f2755c));
        AppMethodBeat.o(174116);
    }

    private b f(String str) {
        AppMethodBeat.i(174120);
        b bVar = this.f2762j.get(str);
        if (bVar == null) {
            bVar = new b(this, str);
            this.f2762j.put(str, bVar);
        }
        AppMethodBeat.o(174120);
        return bVar;
    }

    public a<e<d>> a(Bundle bundle, l<e<d>> lVar) {
        String shouldOverrideFilePath;
        AppMethodBeat.i(188009);
        String str = this.f2754b;
        com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS", str);
        File file = (this.f2758f == null || (shouldOverrideFilePath = this.f2758f.shouldOverrideFilePath(str, null, -1, "DEPS")) == null) ? null : new File(shouldOverrideFilePath);
        if (file == null) {
            file = f.c(f.a(this.f2753a), str);
        }
        if (!file.exists()) {
            lVar.a(105, "Failed to find DEPS file " + file.getAbsolutePath(), null);
            AppMethodBeat.o(188009);
        } else {
            try {
                lVar.a(e.a(e.a.BUILTIN, d.a(file)));
                AppMethodBeat.o(188009);
            } catch (TBSOneException e2) {
                lVar.a(e2.getErrorCode(), e2.getMessage(), e2.getCause());
                AppMethodBeat.o(188009);
            }
        }
        return null;
    }

    public a<e<File>> a(Bundle bundle, d.a aVar, l<e<File>> lVar) {
        AppMethodBeat.i(188010);
        com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d", this.f2754b, aVar.f2558a, Integer.valueOf(aVar.f2560c));
        File a2 = a(aVar.f2558a, aVar.f2560c);
        c.d(a2);
        lVar.a(e.a(e.a.BUILTIN, a2));
        AppMethodBeat.o(188010);
        return null;
    }

    public final File a(String str) {
        AppMethodBeat.i(174117);
        File b2 = f.b(this.f2755c, str);
        AppMethodBeat.o(174117);
        return b2;
    }

    public final File a(String str, int i2) {
        AppMethodBeat.i(174118);
        File a2 = f.a(this.f2755c, str, i2);
        AppMethodBeat.o(174118);
        return a2;
    }

    public void a(Bundle bundle, String str, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188008);
        f(str).a(bundle, tBSOneCallback);
        AppMethodBeat.o(188008);
    }

    /* access modifiers changed from: protected */
    public void a(e<d> eVar) {
        AppMethodBeat.i(174119);
        com.tencent.tbs.one.impl.a.f.a("[%s] Finished loading DEPS#%d from %s", this.f2754b, Integer.valueOf(eVar.f2729b.f2555a), eVar.f2728a);
        this.f2760h = eVar.f2729b;
        AppMethodBeat.o(174119);
    }

    public void a(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        AppMethodBeat.i(188006);
        b f2 = f(str);
        if (f2.l != null) {
            com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loaded component %s", f2.f2491b.f2754b, f2.f2490a, f2.l);
            if (tBSOneCallback != null) {
                tBSOneCallback.onProgressChanged(0, 100);
                tBSOneCallback.onCompleted(f2.l);
            }
            AppMethodBeat.o(188006);
            return;
        }
        if (tBSOneCallback != null) {
            tBSOneCallback.onProgressChanged(0, f2.f2496g);
            f2.f2493d.add(tBSOneCallback);
        }
        if (f2.k != null) {
            f2.b();
            AppMethodBeat.o(188006);
            return;
        }
        f2.a(bundle);
        AppMethodBeat.o(188006);
    }

    public void a(String str, Object obj) {
        AppMethodBeat.i(174126);
        this.f2759g.put(str, obj);
        AppMethodBeat.o(174126);
    }

    public void a(boolean z) {
        this.f2757e = z;
    }

    public final boolean a() {
        return (this.f2756d == TBSOneManager.Policy.BUILTIN_ONLY || this.f2756d == TBSOneManager.Policy.LOCAL_ONLY) ? false : true;
    }

    public void b(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188007);
        f(str).a(bundle, tBSOneCallback);
        AppMethodBeat.o(188007);
    }

    public final boolean b() {
        return this.f2756d == TBSOneManager.Policy.BUILTIN_ONLY;
    }

    public boolean b(String str) {
        return true;
    }

    public TBSOneOnlineService c() {
        return null;
    }

    public int[] c(String str) {
        return new int[]{-1};
    }

    public TBSOneDebugger d() {
        return null;
    }

    public final b d(String str) {
        AppMethodBeat.i(174124);
        b bVar = this.f2762j.get(str);
        AppMethodBeat.o(174124);
        return bVar;
    }

    public final com.tencent.tbs.one.impl.c.a e(String str) {
        AppMethodBeat.i(174125);
        b bVar = this.f2762j.get(str);
        if (bVar == null) {
            AppMethodBeat.o(174125);
            return null;
        }
        com.tencent.tbs.one.impl.c.a aVar = bVar.l;
        AppMethodBeat.o(174125);
        return aVar;
    }
}
