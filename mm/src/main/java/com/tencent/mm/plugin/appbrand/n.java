package com.tencent.mm.plugin.appbrand;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class n<RUNTIME extends AppBrandRuntime> extends FrameLayout implements ak, c {
    private Context context;
    final LinkedList<RUNTIME> kCb;
    final Class<? extends RUNTIME> kCe;
    private boolean kCq;
    private final com.tencent.mm.plugin.appbrand.widget.input.n kCr;
    final Map<String, RUNTIME> kCs;
    private e kCt;
    n<RUNTIME>.a kCu;
    private final FrameLayout mContentView;
    private boolean mResumed;

    /* access modifiers changed from: package-private */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final int f1501b;
        public final int l;
        public final int r;
        public final int t;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c cVar) {
        return this == cVar ? 0 : -1;
    }

    static /* synthetic */ void a(n nVar, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219263);
        nVar.C(appBrandRuntime);
        AppMethodBeat.o(219263);
    }

    static /* synthetic */ void b(n nVar, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219264);
        nVar.z(appBrandRuntime);
        AppMethodBeat.o(219264);
    }

    static /* synthetic */ void f(n nVar) {
        AppMethodBeat.i(219265);
        nVar.bsh();
        AppMethodBeat.o(219265);
    }

    private void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(219239);
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(219239);
            return;
        }
        post(runnable);
        AppMethodBeat.o(219239);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppBrandRuntime activeRuntime;
        AppMethodBeat.i(219240);
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 4 || (activeRuntime = getActiveRuntime()) == null || activeRuntime.isDestroyed()) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(219240);
            return dispatchKeyEvent;
        }
        activeRuntime.onBackPressed();
        AppMethodBeat.o(219240);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public c getWindowAndroid() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void a(final AppBrandRuntime appBrandRuntime, final AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(219241);
        if (appBrandInitConfig == null) {
            AppMethodBeat.o(219241);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.tencent.mm.plugin.appbrand.n */
            /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.tencent.mm.plugin.appbrand.n */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                RUNTIME runtime;
                AppMethodBeat.i(219231);
                n.this.kCr.cbu();
                if (appBrandRuntime == null) {
                    n nVar = n.this;
                    Iterator<RUNTIME> it = nVar.kCb.iterator();
                    while (it.hasNext()) {
                        RUNTIME next = it.next();
                        next.kAt.setVisibility(8);
                        nVar.kCs.put(next.mAppId, next);
                        next.brH();
                    }
                    nVar.kCb.clear();
                }
                n nVar2 = n.this;
                String str = appBrandInitConfig.appId;
                Iterator<RUNTIME> it2 = nVar2.kCb.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        runtime = nVar2.kCs.get(str);
                        break;
                    }
                    runtime = it2.next();
                    if (runtime.mAppId.equals(str)) {
                        break;
                    }
                }
                if (runtime == null) {
                    n nVar3 = n.this;
                    n nVar4 = n.this;
                    AppBrandRuntime appBrandRuntime = appBrandRuntime;
                    nVar4.a(appBrandRuntime, (AppBrandRuntime) org.a.a.bF(nVar3.kCe).ak(nVar3).object, appBrandInitConfig);
                    AppMethodBeat.o(219231);
                    return;
                }
                n.this.b(appBrandRuntime, runtime, appBrandInitConfig);
                AppMethodBeat.o(219231);
            }
        });
        AppMethodBeat.o(219241);
    }

    /* access modifiers changed from: protected */
    public final void b(RUNTIME runtime, RUNTIME runtime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(219243);
        C(runtime2);
        z(runtime2);
        runtime2.kAp = runtime;
        runtime2.d(appBrandInitConfig);
        if (runtime != null) {
            runtime.dispatchPause();
            runtime2.dispatchResume();
        }
        AppMethodBeat.o(219243);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void a(final AppBrandRuntime appBrandRuntime, final Object obj) {
        AppMethodBeat.i(219244);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(219244);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.appbrand.n */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                String str;
                AppMethodBeat.i(219233);
                if (!n.this.y(appBrandRuntime)) {
                    Log.e("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close with appId(%s), not top of stack, ignore", appBrandRuntime.mAppId);
                    AppMethodBeat.o(219233);
                    return;
                }
                final AppBrandRuntime u = n.this.u(appBrandRuntime);
                if (u != null) {
                    u.b(appBrandRuntime.OU(), obj);
                }
                Object[] objArr = new Object[3];
                objArr[0] = appBrandRuntime.mAppId;
                if (u == null) {
                    str = BuildConfig.COMMAND;
                } else {
                    str = u.mAppId;
                }
                objArr[1] = str;
                objArr[2] = Boolean.valueOf(n.this.mResumed);
                Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close before run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", objArr);
                n.this.b(u, appBrandRuntime, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        String str;
                        AppMethodBeat.i(219232);
                        if (u != null) {
                            appBrandRuntime.kAt.setVisibility(8);
                            n.this.kCb.remove(appBrandRuntime);
                            n.this.kCs.put(appBrandRuntime.mAppId, appBrandRuntime);
                            n.a(n.this, u);
                            n.b(n.this, u);
                        }
                        appBrandRuntime.dispatchPause();
                        if (n.this.mResumed && u != null) {
                            u.dispatchResume();
                        }
                        Object[] objArr = new Object[3];
                        objArr[0] = appBrandRuntime.mAppId;
                        if (u == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = u.mAppId;
                        }
                        objArr[1] = str;
                        objArr[2] = Boolean.valueOf(n.this.mResumed);
                        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "close run(), out.appId[%s], willAppear.appId[%s], mResumed[%b]", objArr);
                        AppMethodBeat.o(219232);
                    }
                });
                AppMethodBeat.o(219233);
            }
        });
        AppMethodBeat.o(219244);
    }

    /* access modifiers changed from: protected */
    public void b(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
    }

    public final Activity getActivity() {
        AppMethodBeat.i(219245);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.context);
        AppMethodBeat.o(219245);
        return castActivityOrNull;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void w(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219246);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(219246);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(219236);
                Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl entered appId[%s]", appBrandRuntime.mAppId);
                final AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(219234);
                        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl, cleanupOut.run(), appId[%s]", appBrandRuntime.mAppId);
                        if (appBrandRuntime.mResumed) {
                            appBrandRuntime.dispatchPause();
                        }
                        appBrandRuntime.dispatchDestroy();
                        n.this.mContentView.removeView(appBrandRuntime.kAt);
                        n.this.kCs.remove(appBrandRuntime.mAppId);
                        n.this.kCb.remove(appBrandRuntime);
                        AppMethodBeat.o(219234);
                    }
                };
                if (!n.this.v(appBrandRuntime)) {
                    Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl appId[%s], not in runtime stack, just cleanup", appBrandRuntime.mAppId);
                    r0.run();
                    AppMethodBeat.o(219236);
                    return;
                }
                final AppBrandRuntime u = n.this.u(appBrandRuntime);
                n.this.b(u, appBrandRuntime, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass3.AnonymousClass2 */

                    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.appbrand.n */
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void run() {
                        String str;
                        AppMethodBeat.i(219235);
                        boolean y = n.this.y(appBrandRuntime);
                        if (u != null) {
                            u.b(appBrandRuntime.OU(), (Object) null);
                        }
                        r0.run();
                        if (y && u != null && n.this.mResumed) {
                            u.dispatchResume();
                        }
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(y);
                        if (u == null) {
                            str = BuildConfig.COMMAND;
                        } else {
                            str = u.mAppId;
                        }
                        objArr[1] = str;
                        objArr[2] = Boolean.valueOf(n.this.mResumed);
                        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", objArr);
                        AppMethodBeat.o(219235);
                    }
                });
                AppMethodBeat.o(219236);
            }
        });
        AppMethodBeat.o(219246);
    }

    /* access modifiers changed from: protected */
    public final boolean y(RUNTIME runtime) {
        AppMethodBeat.i(219247);
        if (this.kCb.peekFirst() == runtime) {
            AppMethodBeat.o(219247);
            return true;
        }
        AppMethodBeat.o(219247);
        return false;
    }

    private void z(RUNTIME runtime) {
        AppMethodBeat.i(219248);
        this.kCb.remove(runtime);
        this.kCb.push(runtime);
        runtime.kAt.setVisibility(0);
        b(runtime.kAt);
        AppMethodBeat.o(219248);
    }

    private void b(com.tencent.mm.plugin.appbrand.widget.c cVar) {
        AppMethodBeat.i(219249);
        if (this.mContentView.indexOfChild(cVar) == -1) {
            Log.w("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "bringRtViewToTop: such runtime view does not exist");
            AppMethodBeat.o(219249);
            return;
        }
        this.mContentView.bringChildToFront(cVar);
        if (bsg()) {
            this.mContentView.bringChildToFront(this.kCr);
        }
        bsh();
        bsi();
        AppMethodBeat.o(219249);
    }

    private void bsh() {
        AppMethodBeat.i(219250);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(219237);
                    n.f(n.this);
                    AppMethodBeat.o(219237);
                }
            });
            AppMethodBeat.o(219250);
            return;
        }
        if (this.kCq) {
            this.mContentView.setPadding(0, 0, 0, 0);
        }
        n<RUNTIME>.a aVar = this.kCu;
        this.mContentView.setPadding(aVar.l, aVar.t, aVar.r, aVar.f1501b);
        AppMethodBeat.o(219250);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OD() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public float getScale() {
        return 1.0f;
    }

    private void bsi() {
        AppMethodBeat.i(219251);
        this.mContentView.setBackgroundColor(getResources().getColor(R.color.f3046d));
        AppMethodBeat.o(219251);
    }

    private boolean bsg() {
        return this.kCr != null;
    }

    private void a(com.tencent.mm.plugin.appbrand.widget.c cVar) {
        int i2;
        AppMethodBeat.i(219252);
        int childCount = this.mContentView.getChildCount();
        if (!bsg() || !bsf()) {
            i2 = 0;
        } else {
            i2 = childCount - 1;
        }
        Log.i("Luggage.WXA.AppBrandRuntimeContainerViewImpl", "loadNewRtContentView: name = [%s], index = [%d]", cVar.getTag(), Integer.valueOf(i2));
        this.mContentView.addView(cVar, i2);
        bsi();
        bsh();
        getActiveRuntime().a(4, 1, new al() {
            /* class com.tencent.mm.plugin.appbrand.n.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.al
            public final boolean c(KeyEvent keyEvent) {
                AppMethodBeat.i(219238);
                boolean z = false;
                if (n.this.kCr != null) {
                    z = n.this.kCr.d(keyEvent);
                }
                AppMethodBeat.o(219238);
                return z;
            }
        });
        AppMethodBeat.o(219252);
    }

    private boolean bsf() {
        AppMethodBeat.i(219253);
        int childCount = this.mContentView.getChildCount();
        if (childCount > 1 || (childCount == 1 && this.kCr != null)) {
            AppMethodBeat.o(219253);
            return true;
        }
        AppMethodBeat.o(219253);
        return false;
    }

    private void C(RUNTIME runtime) {
        AppMethodBeat.i(219254);
        if (this.kCb.contains(runtime)) {
            AppMethodBeat.o(219254);
            return;
        }
        this.kCb.push(runtime);
        if (this.mContentView.indexOfChild(runtime.kAt) == -1) {
            a(runtime.kAt);
        }
        this.kCs.remove(runtime.mAppId);
        AppMethodBeat.o(219254);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void A(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219255);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(219255);
            return;
        }
        this.kCb.remove(appBrandRuntime);
        AppMethodBeat.o(219255);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public int getStackSize() {
        AppMethodBeat.i(219256);
        int size = this.kCb.size();
        AppMethodBeat.o(219256);
        return size;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final boolean v(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219257);
        boolean contains = this.kCb.contains(appBrandRuntime);
        AppMethodBeat.o(219257);
        return contains;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final RUNTIME u(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219258);
        if (appBrandRuntime == null) {
            NullPointerException nullPointerException = new NullPointerException("Null runtime");
            AppMethodBeat.o(219258);
            throw nullPointerException;
        }
        ListIterator<RUNTIME> listIterator = this.kCb.listIterator();
        boolean z = false;
        while (listIterator.hasNext()) {
            RUNTIME next = listIterator.next();
            if (next == appBrandRuntime) {
                z = true;
            } else if (z) {
                AppMethodBeat.o(219258);
                return next;
            }
        }
        if (!z) {
            IllegalAccessError illegalAccessError = new IllegalAccessError(String.format("Runtime not in stack %s", appBrandRuntime.mAppId));
            AppMethodBeat.o(219258);
            throw illegalAccessError;
        }
        AppMethodBeat.o(219258);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public AppBrandRuntime getActiveRuntime() {
        AppMethodBeat.i(219259);
        RUNTIME peek = this.kCb.peek();
        AppMethodBeat.o(219259);
        return peek;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean bsc() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public DisplayMetrics getVDisplayMetrics() {
        AppMethodBeat.i(219260);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        n<RUNTIME>.a windowCompatInfo = getWindowCompatInfo();
        displayMetrics2.widthPixels = (getWidth() - windowCompatInfo.l) - windowCompatInfo.r;
        displayMetrics2.heightPixels = (getHeight() - windowCompatInfo.t) - windowCompatInfo.f1501b;
        AppMethodBeat.o(219260);
        return displayMetrics2;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean bsj() {
        return false;
    }

    public n<RUNTIME>.a getWindowCompatInfo() {
        return this.kCu;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean isInMultiWindowMode() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public e getOrientationHandler() {
        AppMethodBeat.i(219261);
        if (this.kCt == null) {
            this.kCt = new ad(this);
        }
        e eVar = this.kCt;
        AppMethodBeat.o(219261);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public void setSoftOrientation(String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public c.C0789c getStatusBar() {
        return null;
    }

    public c.b getNavigationBar() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public Rect getSafeAreaInsets() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public void setWindowDescription(c.a aVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final void a(WxaWindowLayoutParams wxaWindowLayoutParams, AppBrandRuntime appBrandRuntime) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final void a(int i2, AppBrandRuntime appBrandRuntime) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public boolean OG() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(RUNTIME runtime, RUNTIME runtime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(219242);
        runtime2.kAp = runtime;
        runtime2.c(appBrandInitConfig);
        this.kCb.push(runtime2);
        a(runtime2.kAt);
        if (runtime != null) {
            runtime.dispatchPause();
        }
        runtime2.brd();
        AppMethodBeat.o(219242);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final d a(d.b bVar) {
        AppMethodBeat.i(219262);
        d dVar = (d) m.g("Luggage.WXA.WindowFullscreenHandler.Dummy", d.class);
        AppMethodBeat.o(219262);
        return dVar;
    }
}
