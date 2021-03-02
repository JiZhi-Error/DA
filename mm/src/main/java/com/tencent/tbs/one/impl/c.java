package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a;
import com.tencent.tbs.one.impl.e.h;
import java.io.File;

public final class c extends TBSOneManager {

    /* renamed from: a  reason: collision with root package name */
    private String f2397a;

    /* renamed from: b  reason: collision with root package name */
    private h f2398b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f2399c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2400d;

    public c(Context context, String str) {
        AppMethodBeat.i(173797);
        a.a(context);
        f.a("[%s] Initializing %s (%s)", str, "0.0.1", "20201221152306");
        this.f2397a = str;
        this.f2398b = a.a(context, str);
        AppMethodBeat.o(173797);
    }

    private void a() {
        synchronized (this.f2399c) {
            this.f2400d = true;
        }
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void configure(String str, Object obj) {
        AppMethodBeat.i(173801);
        f.a("[%s] Configuring %s = %s", this.f2397a, str, obj);
        this.f2398b.a(str, obj);
        AppMethodBeat.o(173801);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneDebugger getDebugger() {
        AppMethodBeat.i(173803);
        TBSOneDebugger d2 = this.f2398b.d();
        AppMethodBeat.o(173803);
        return d2;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final int[] getInstalledVersionCodesOfComponent(String str) {
        AppMethodBeat.i(173805);
        int[] c2 = this.f2398b.c(str);
        AppMethodBeat.o(173805);
        return c2;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent getLoadedComponent(String str) {
        AppMethodBeat.i(173809);
        a e2 = this.f2398b.e(str);
        AppMethodBeat.o(173809);
        return e2;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneOnlineService getOnlineService() {
        AppMethodBeat.i(173802);
        a();
        TBSOneOnlineService c2 = this.f2398b.c();
        AppMethodBeat.o(173802);
        return c2;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void installComponent(final String str, final Bundle bundle, final TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(188033);
        f.a("[%s] Installing component %s,Options %s", this.f2397a, str, bundle);
        a();
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(173885);
                c.this.f2398b.b(str, bundle, tBSOneCallback);
                AppMethodBeat.o(173885);
            }
        });
        AppMethodBeat.o(188033);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void installComponent(String str, TBSOneCallback<File> tBSOneCallback) {
        AppMethodBeat.i(173806);
        installComponent(str, null, tBSOneCallback);
        AppMethodBeat.o(173806);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final boolean isComponentInstalled(String str) {
        AppMethodBeat.i(173804);
        boolean b2 = this.f2398b.b(str);
        AppMethodBeat.o(173804);
        return b2;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void loadComponentAsync(final String str, final Bundle bundle, final TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        AppMethodBeat.i(188034);
        f.a("[%s] Loading component %s asynchronously", this.f2397a, str);
        a();
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(174259);
                c.this.f2398b.a(str, bundle, tBSOneCallback);
                AppMethodBeat.o(174259);
            }
        });
        AppMethodBeat.o(188034);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void loadComponentAsync(String str, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        AppMethodBeat.i(173807);
        loadComponentAsync(str, null, tBSOneCallback);
        AppMethodBeat.o(173807);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent loadComponentSync(String str) {
        AppMethodBeat.i(173808);
        TBSOneComponent loadComponentSync = loadComponentSync(str, null);
        AppMethodBeat.o(173808);
        return loadComponentSync;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final TBSOneComponent loadComponentSync(final String str, final Bundle bundle) {
        AppMethodBeat.i(188035);
        f.a("[%s] Loading component %s synchronously", this.f2397a, str);
        if (m.b()) {
            RuntimeException runtimeException = new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
            AppMethodBeat.o(188035);
            throw runtimeException;
        }
        a();
        final b bVar = new b();
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(174176);
                c.this.f2398b.a(str, bundle, bVar);
                AppMethodBeat.o(174176);
            }
        });
        bVar.a();
        if (bVar.f2379b != 0) {
            TBSOneException tBSOneException = new TBSOneException(bVar.f2379b, bVar.f2380c);
            AppMethodBeat.o(188035);
            throw tBSOneException;
        }
        T t = bVar.f2378a;
        AppMethodBeat.o(188035);
        return t;
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setAutoUpdateEnabled(boolean z) {
        AppMethodBeat.i(173799);
        Object[] objArr = new Object[2];
        objArr[0] = this.f2397a;
        objArr[1] = z ? "Enabling" : "Disabling";
        f.a("[%s] %s auto update", objArr);
        this.f2398b.a(z);
        AppMethodBeat.o(173799);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setDelegate(final TBSOneDelegate tBSOneDelegate) {
        AppMethodBeat.i(173800);
        f.a("[%s] Setting delegate %s", this.f2397a, tBSOneDelegate);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(173796);
                c.this.f2398b.f2758f = tBSOneDelegate;
                AppMethodBeat.o(173796);
            }
        });
        AppMethodBeat.o(173800);
    }

    @Override // com.tencent.tbs.one.TBSOneManager
    public final void setPolicy(TBSOneManager.Policy policy) {
        AppMethodBeat.i(173798);
        f.a("[%s] Setting policy %s", this.f2397a, policy);
        synchronized (this.f2399c) {
            try {
                if (this.f2400d) {
                    Log.println(5, "TBSOne", Log.getStackTraceString(new Throwable("TBSOneManager.setPolicy should be called before doing any other operations.")));
                    return;
                }
                this.f2398b.f2756d = policy;
                AppMethodBeat.o(173798);
            } finally {
                AppMethodBeat.o(173798);
            }
        }
    }
}
