package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Looper;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.g;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AppBrandRuntimeContainer<RUNTIME extends AppBrandRuntime> extends o implements ak {
    private Application.ActivityLifecycleCallbacks cVK;
    public final LinkedList<RUNTIME> kCb;
    final HashMap<String, RUNTIME> kCc;
    public k kCd;
    private Class<? extends RUNTIME> kCe;
    private boolean kCf = false;
    protected boolean kCg = false;
    public n kCh;
    public FrameLayout mContentView;

    static /* synthetic */ void b(AppBrandRuntimeContainer appBrandRuntimeContainer) {
        AppMethodBeat.i(177593);
        appBrandRuntimeContainer.bsb();
        AppMethodBeat.o(177593);
    }

    static /* synthetic */ void b(AppBrandRuntimeContainer appBrandRuntimeContainer, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(176535);
        appBrandRuntimeContainer.z(appBrandRuntime);
        AppMethodBeat.o(176535);
    }

    static /* synthetic */ void c(AppBrandRuntimeContainer appBrandRuntimeContainer, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219230);
        appBrandRuntimeContainer.a(appBrandRuntime, true);
        AppMethodBeat.o(219230);
    }

    static /* synthetic */ void d(AppBrandRuntimeContainer appBrandRuntimeContainer, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(178518);
        appBrandRuntimeContainer.x(appBrandRuntime);
        AppMethodBeat.o(178518);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public /* bridge */ /* synthetic */ c getWindowAndroid() {
        return this;
    }

    public AppBrandRuntimeContainer(k kVar, Class<? extends RUNTIME> cls) {
        AppMethodBeat.i(134545);
        super.aG(kVar.getContext());
        this.kCb = new LinkedList<>();
        this.kCc = new HashMap<>();
        this.mContentView = kVar.bWl();
        this.kCd = kVar;
        this.kCe = cls;
        this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass1 */

            public final void onSystemUiVisibilityChange(int i2) {
                Activity castActivityOrNull;
                boolean z;
                int i3;
                AppMethodBeat.i(176524);
                if (AppBrandRuntimeContainer.this.mContentView.isShown() && u.aD(AppBrandRuntimeContainer.this.mContentView) && Build.VERSION.SDK_INT >= 26 && (AppBrandRuntimeContainer.this.mContentView.getWindowSystemUiVisibility() & 2) == 0 && (castActivityOrNull = AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.getContext())) != null && castActivityOrNull.getWindow() != null) {
                    boolean aln = ar.aln(castActivityOrNull.getWindow().getNavigationBarColor());
                    Window window = castActivityOrNull.getWindow();
                    if (!aln) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (window == null || window.getDecorView() == null) {
                        AppMethodBeat.o(176524);
                        return;
                    } else if (Build.VERSION.SDK_INT >= 26) {
                        View decorView = window.getDecorView();
                        int systemUiVisibility = decorView.getSystemUiVisibility();
                        if (z) {
                            i3 = systemUiVisibility | 16;
                        } else {
                            i3 = systemUiVisibility & -17;
                        }
                        decorView.setSystemUiVisibility(i3);
                    }
                }
                AppMethodBeat.o(176524);
            }
        });
        g E = g.E(AndroidContextUtil.castActivityOrNull(this.mContext));
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        synchronized (E) {
            try {
                E.mFinished = false;
            } catch (Throwable th) {
                AppMethodBeat.o(134545);
                throw th;
            }
        }
        AnonymousClass4 r1 = new a() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityResumed(Activity activity) {
                AppMethodBeat.i(176526);
                if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == activity) {
                    Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityResumed %s", activity.getLocalClassName());
                    AppBrandRuntimeContainer.this.kCf = true;
                    AppBrandRuntimeContainer.this.kCg = false;
                    AppBrandRuntimeContainer.this.bTY().onResume();
                }
                AppMethodBeat.o(176526);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityPaused(Activity activity) {
                AppMethodBeat.i(176527);
                if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == activity) {
                    Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityPaused %s", activity.getLocalClassName());
                    AppBrandRuntimeContainer.this.kCf = false;
                    AppBrandRuntimeContainer.this.kCg = true;
                    AppBrandRuntimeContainer.this.bTY().onPause();
                }
                AppMethodBeat.o(176527);
            }

            @Override // com.tencent.mm.plugin.appbrand.ac.a
            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(176528);
                if (AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext) == activity) {
                    Log.i("MicroMsg.AppBrandRuntimeContainer", "onActivityDestroyed %s", activity.getLocalClassName());
                    AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this);
                }
                AppMethodBeat.o(176528);
            }
        };
        this.cVK = r1;
        ((Application) getContext().getApplicationContext()).registerActivityLifecycleCallbacks(r1);
        AppMethodBeat.o(134545);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o
    public final boolean bsa() {
        return true;
    }

    private void bsb() {
        AppMethodBeat.i(177591);
        if (this.cVK != null) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.cVK);
            this.cVK = null;
        }
        bTY().release();
        this.kCd = null;
        AppMethodBeat.o(177591);
    }

    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(219221);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            AppMethodBeat.o(219221);
        } else if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
            AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(runnable);
            AppMethodBeat.o(219221);
        } else {
            Log.e("MicroMsg.AppBrandRuntimeContainer", "runOnUiThread getActivity()==null");
            new MMHandler(Looper.getMainLooper()).post(runnable);
            AppMethodBeat.o(219221);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean bsc() {
        AppMethodBeat.i(176530);
        boolean bsc = this.kCd.bsc();
        AppMethodBeat.o(176530);
        return bsc;
    }

    public final boolean bsd() {
        return this.kCf;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void a(final AppBrandRuntime appBrandRuntime, final AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(219222);
        if (appBrandInitConfig == null) {
            AppMethodBeat.o(219222);
            return;
        }
        AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass5 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer */
            /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(219220);
                n.J(AndroidContextUtil.castActivityOrNull(AppBrandRuntimeContainer.this.mContext));
                if (appBrandRuntime == null) {
                    AppBrandRuntimeContainer.this.Ui(appBrandInitConfig.appId);
                }
                AppBrandRuntime Uh = AppBrandRuntimeContainer.this.Uh(appBrandInitConfig.appId);
                if (Uh == null) {
                    AppBrandRuntimeContainer.this.a(appBrandRuntime, AppBrandRuntimeContainer.this.e(appBrandInitConfig), appBrandInitConfig);
                    AppMethodBeat.o(219220);
                    return;
                }
                AppBrandRuntimeContainer.this.b(appBrandRuntime, Uh, appBrandInitConfig);
                AppMethodBeat.o(219220);
            }
        });
        AppMethodBeat.o(219222);
    }

    public RUNTIME e(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(134547);
        RUNTIME runtime = (RUNTIME) ((AppBrandRuntime) org.a.a.bF(this.kCe).ak(this).object);
        AppMethodBeat.o(134547);
        return runtime;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void a(final AppBrandRuntime appBrandRuntime, final Object obj) {
        AppMethodBeat.i(176531);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(176531);
            return;
        }
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        if (castActivityOrNull == null) {
            AppMethodBeat.o(176531);
            return;
        }
        castActivityOrNull.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass6 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                String str;
                AppMethodBeat.i(134539);
                if (!AppBrandRuntimeContainer.this.y(appBrandRuntime)) {
                    Log.e("MicroMsg.AppBrandRuntimeContainer", "close with appId(%s), not top of stack, ignore", appBrandRuntime.mAppId);
                    AppMethodBeat.o(134539);
                    return;
                }
                final AppBrandRuntime u = AppBrandRuntimeContainer.this.u(appBrandRuntime);
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
                objArr[2] = Boolean.valueOf(AppBrandRuntimeContainer.this.kCf);
                Log.i("MicroMsg.AppBrandRuntimeContainer", "close before run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", objArr);
                AppBrandRuntimeContainer.this.b(u, appBrandRuntime, new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        String str;
                        AppMethodBeat.i(176529);
                        appBrandRuntime.kAt.setVisibility(8);
                        AppBrandRuntimeContainer.this.kCb.remove(appBrandRuntime);
                        AppBrandRuntimeContainer.this.kCc.put(appBrandRuntime.mAppId, appBrandRuntime);
                        if (u != null) {
                            AppBrandRuntimeContainer.a(AppBrandRuntimeContainer.this, u);
                            AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, u);
                        }
                        appBrandRuntime.dispatchPause();
                        if (AppBrandRuntimeContainer.this.kCf && u != null) {
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
                        objArr[2] = Boolean.valueOf(AppBrandRuntimeContainer.this.kCf);
                        Log.i("MicroMsg.AppBrandRuntimeContainer", "close run(), out.appId[%s], willAppear.appId[%s], mIsActivityResumed[%b]", objArr);
                        AppMethodBeat.o(176529);
                    }
                });
                AppMethodBeat.o(134539);
            }
        });
        AppMethodBeat.o(176531);
    }

    public void b(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
        String str;
        AppMethodBeat.i(134550);
        Object[] objArr = new Object[2];
        if (appBrandRuntime == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = appBrandRuntime.mAppId;
        }
        objArr[0] = str;
        objArr[1] = appBrandRuntime2.mAppId;
        Log.i("MicroMsg.AppBrandRuntimeContainer", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", objArr);
        runnable.run();
        AppMethodBeat.o(134550);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public RUNTIME getActiveRuntime() {
        AppMethodBeat.i(134551);
        RUNTIME peek = this.kCb.peek();
        AppMethodBeat.o(134551);
        return peek;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final RUNTIME u(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134552);
        if (appBrandRuntime == null) {
            NullPointerException nullPointerException = new NullPointerException("Null runtime");
            AppMethodBeat.o(134552);
            throw nullPointerException;
        }
        ListIterator<RUNTIME> listIterator = this.kCb.listIterator();
        boolean z = false;
        while (listIterator.hasNext()) {
            RUNTIME next = listIterator.next();
            if (next == appBrandRuntime) {
                z = true;
            } else if (z) {
                AppMethodBeat.o(134552);
                return next;
            }
        }
        if (!z) {
            IllegalAccessError illegalAccessError = new IllegalAccessError(String.format("Runtime not in stack %s", appBrandRuntime.mAppId));
            AppMethodBeat.o(134552);
            throw illegalAccessError;
        }
        AppMethodBeat.o(134552);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public int getStackSize() {
        AppMethodBeat.i(185921);
        int size = this.kCb.size();
        AppMethodBeat.o(185921);
        return size;
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final boolean v(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134554);
        boolean contains = this.kCb.contains(appBrandRuntime);
        AppMethodBeat.o(134554);
        return contains;
    }

    public final RUNTIME Uh(String str) {
        AppMethodBeat.i(219223);
        Iterator<RUNTIME> it = this.kCb.iterator();
        while (it.hasNext()) {
            RUNTIME next = it.next();
            if (next.mAppId.equals(str)) {
                AppMethodBeat.o(219223);
                return next;
            }
        }
        RUNTIME runtime = this.kCc.get(str);
        AppMethodBeat.o(219223);
        return runtime;
    }

    public final void onResume() {
        AppMethodBeat.i(134555);
        Log.i("MicroMsg.AppBrandRuntimeContainer", "onResume tid = %d", Long.valueOf(Thread.currentThread().getId()));
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(134541);
                try {
                    AppBrandRuntime activeRuntime = AppBrandRuntimeContainer.this.getActiveRuntime();
                    if (activeRuntime != null) {
                        AppBrandRuntimeContainer.c(AppBrandRuntimeContainer.this, activeRuntime);
                        AppBrandRuntimeContainer.b(AppBrandRuntimeContainer.this, activeRuntime);
                        activeRuntime.dispatchResume();
                    }
                    AppMethodBeat.o(134541);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandRuntimeContainer", "doOnResume e=%s", e2);
                    AppMethodBeat.o(134541);
                }
            }
        });
        AppMethodBeat.o(134555);
    }

    public void onBackPressed() {
        AppMethodBeat.i(134556);
        RUNTIME activeRuntime = getActiveRuntime();
        if (activeRuntime != null) {
            try {
                activeRuntime.onBackPressed();
                AppMethodBeat.o(134556);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandRuntimeContainer", "onBackPressed e = %s", e2);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(134542);
                        Exception exc = e2;
                        AppMethodBeat.o(134542);
                        throw exc;
                    }
                });
            }
        }
        AppMethodBeat.o(134556);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(134557);
        if (this.kCb != null) {
            Iterator<RUNTIME> it = this.kCb.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
        AppMethodBeat.o(134557);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void w(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134558);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(134558);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(134543);
                AppBrandRuntimeContainer.d(AppBrandRuntimeContainer.this, appBrandRuntime);
                AppMethodBeat.o(134543);
            }
        });
        AppMethodBeat.o(134558);
    }

    private void x(final RUNTIME runtime) {
        AppMethodBeat.i(219224);
        Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl entered appId[%s]", runtime.mAppId);
        final AnonymousClass11 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(134544);
                Log.i("MicroMsg.AppBrandRuntimeContainer", "dl: removeImpl, cleanupOut.run(), appId[%s]", runtime.mAppId);
                runtime.dispatchDestroy();
                AppBrandRuntimeContainer.this.mContentView.removeView(runtime.kAt);
                AppBrandRuntimeContainer.this.kCc.remove(runtime.mAppId);
                AppBrandRuntimeContainer.this.kCb.remove(runtime);
                AppMethodBeat.o(134544);
            }
        };
        if (!v(runtime)) {
            Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl appId[%s], not in runtime stack, just cleanup", runtime.mAppId);
            r0.run();
            AppMethodBeat.o(219224);
            return;
        }
        final RUNTIME u = u(runtime);
        b(u, runtime, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                String str;
                AppMethodBeat.i(176525);
                boolean y = AppBrandRuntimeContainer.this.y(runtime);
                if (u != null) {
                    u.b(runtime.OU(), (Object) null);
                }
                r0.run();
                if (y && u != null && AppBrandRuntimeContainer.this.kCf) {
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
                objArr[2] = Boolean.valueOf(AppBrandRuntimeContainer.this.kCf);
                Log.i("MicroMsg.AppBrandRuntimeContainer", "removeImpl closeTask.run(), outIsTopOfStackBefore[%b], below.appId[%s], mIsActivityResumed[%b]", objArr);
                AppMethodBeat.o(176525);
            }
        });
        AppMethodBeat.o(219224);
    }

    public void cleanup() {
        AppMethodBeat.i(134563);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.kCb);
        linkedList.addAll(this.kCc.values());
        Ui(null);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AppBrandRuntime appBrandRuntime = (AppBrandRuntime) it.next();
            appBrandRuntime.kAO = false;
            w(appBrandRuntime);
        }
        Log.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
        bsb();
        AppMethodBeat.o(134563);
    }

    /* access modifiers changed from: protected */
    public final boolean y(RUNTIME runtime) {
        AppMethodBeat.i(134560);
        if (this.kCb.peekFirst() == runtime) {
            AppMethodBeat.o(134560);
            return true;
        }
        AppMethodBeat.o(134560);
        return false;
    }

    private void z(RUNTIME runtime) {
        AppMethodBeat.i(134561);
        this.kCb.remove(runtime);
        this.kCb.push(runtime);
        runtime.kAt.setVisibility(0);
        g(runtime.kAt);
        AppMethodBeat.o(134561);
    }

    private void a(RUNTIME runtime, boolean z) {
        AppMethodBeat.i(219225);
        if (!this.kCb.contains(runtime) || z) {
            this.kCb.remove(runtime);
            this.kCb.push(runtime);
            if (this.mContentView.indexOfChild(runtime.kAt) == -1) {
                a(runtime.kAt);
            }
            this.kCc.remove(runtime.mAppId);
            AppMethodBeat.o(219225);
            return;
        }
        AppMethodBeat.o(219225);
    }

    public final void Ui(String str) {
        AppMethodBeat.i(219226);
        Iterator<RUNTIME> it = this.kCb.iterator();
        while (it.hasNext()) {
            RUNTIME next = it.next();
            if (str == null || !str.equals(next.mAppId)) {
                it.remove();
                next.kAt.setVisibility(8);
                this.kCc.put(next.mAppId, next);
                next.brH();
                if (!next.mInitialized) {
                    Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).initialized()=false, just destroy", next.mAppId);
                    x(next);
                } else if (next.mResumed) {
                    Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, rt(%s).isResumed()=true, make it pause", next.mAppId);
                    next.dispatchPause();
                }
            } else {
                Log.i("MicroMsg.AppBrandRuntimeContainer", "detachCurrentStack, exclude appId(%s)", str);
            }
        }
        AppMethodBeat.o(219226);
    }

    @Override // com.tencent.mm.plugin.appbrand.ak
    public final void A(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134564);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(134564);
            return;
        }
        this.kCb.remove(appBrandRuntime);
        AppMethodBeat.o(134564);
    }

    /* access modifiers changed from: protected */
    public final void B(RUNTIME runtime) {
        AppMethodBeat.i(219227);
        if (runtime == null) {
            AppMethodBeat.o(219227);
            return;
        }
        this.kCb.remove(runtime);
        if (Build.VERSION.SDK_INT >= 24) {
            this.kCc.remove(runtime.mAppId, runtime);
            AppMethodBeat.o(219227);
            return;
        }
        this.kCc.remove(runtime.mAppId);
        AppMethodBeat.o(219227);
    }

    /* access modifiers changed from: protected */
    public final LinkedList<RUNTIME> bse() {
        AppMethodBeat.i(134565);
        LinkedList<RUNTIME> linkedList = new LinkedList<>(this.kCb);
        AppMethodBeat.o(134565);
        return linkedList;
    }

    private void a(com.tencent.mm.plugin.appbrand.widget.c cVar) {
        int i2;
        AppMethodBeat.i(178511);
        int childCount = this.mContentView.getChildCount();
        if (!bsg() || !bsf()) {
            i2 = 0;
        } else {
            i2 = childCount - 1;
        }
        Log.i("MicroMsg.AppBrandRuntimeContainer", "attachRtViewToTree: name = [%s], index = [%d]", (String) cVar.getTag(), Integer.valueOf(i2));
        if (cVar.getParent() != null) {
            if (BuildInfo.DEBUG) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("runtimeLayout's parent should be null");
                AppMethodBeat.o(178511);
                throw illegalArgumentException;
            }
            ((ViewGroup) cVar.getParent()).removeAllViews();
        }
        this.mContentView.addView(cVar, i2);
        if (this.kCh != null && this.kCh.getParent() == null) {
            this.mContentView.addView(this.kCh);
            this.mContentView.bringChildToFront(this.kCh);
        }
        getActiveRuntime().a(4, 1, new al() {
            /* class com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.al
            public final boolean c(KeyEvent keyEvent) {
                AppMethodBeat.i(219219);
                boolean z = false;
                if (AppBrandRuntimeContainer.this.kCh != null) {
                    z = AppBrandRuntimeContainer.this.kCh.d(keyEvent);
                }
                AppMethodBeat.o(219219);
                return z;
            }
        });
        AppMethodBeat.o(178511);
    }

    private boolean bsf() {
        AppMethodBeat.i(178513);
        int childCount = this.mContentView.getChildCount();
        if (childCount > 1 || (childCount == 1 && this.kCh != null)) {
            AppMethodBeat.o(178513);
            return true;
        }
        AppMethodBeat.o(178513);
        return false;
    }

    private boolean bsg() {
        return this.kCh != null;
    }

    private void g(ViewGroup viewGroup) {
        AppMethodBeat.i(219228);
        if (this.mContentView.indexOfChild(viewGroup) == -1) {
            Log.w("MicroMsg.AppBrandRuntimeContainer", "bringRtViewToTop: such runtime view does not exist");
            AppMethodBeat.o(219228);
            return;
        }
        this.mContentView.bringChildToFront(viewGroup);
        if (bsg()) {
            this.mContentView.bringChildToFront(this.kCh);
        }
        AppMethodBeat.o(219228);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final DisplayMetrics getVDisplayMetrics() {
        AppMethodBeat.i(178516);
        DisplayMetrics vDisplayMetrics = super.getVDisplayMetrics();
        if (this.mContentView.isLaidOut()) {
            vDisplayMetrics.widthPixels = this.mContentView.getMeasuredWidth();
            vDisplayMetrics.heightPixels = this.mContentView.getMeasuredHeight();
        }
        AppMethodBeat.o(178516);
        return vDisplayMetrics;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.o, com.tencent.mm.plugin.appbrand.platform.window.c
    public void a(int i2, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219229);
        super.a(i2, appBrandRuntime);
        View view = (View) appBrandRuntime.kAt.getParent();
        if (view != null) {
            view.setBackgroundColor(i2);
        }
        AppMethodBeat.o(219229);
    }

    public void a(RUNTIME runtime, RUNTIME runtime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(134546);
        runtime2.kAp = runtime;
        runtime2.c(appBrandInitConfig);
        this.kCb.push(runtime2);
        a(runtime2.kAt);
        if (runtime != null) {
            runtime.dispatchPause();
        }
        runtime2.brd();
        AppMethodBeat.o(134546);
    }

    public void b(RUNTIME runtime, RUNTIME runtime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(134548);
        a((AppBrandRuntime) runtime2, false);
        z(runtime2);
        runtime2.kAp = runtime;
        runtime2.d(appBrandInitConfig);
        if (runtime != null) {
            runtime.dispatchPause();
            runtime2.dispatchResume();
        }
        AppMethodBeat.o(134548);
    }

    static /* synthetic */ void a(AppBrandRuntimeContainer appBrandRuntimeContainer, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(176534);
        appBrandRuntimeContainer.a(appBrandRuntime, false);
        AppMethodBeat.o(176534);
    }
}
