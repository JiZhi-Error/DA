package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.f;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "windowActivity", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "handler", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "handler$delegate", "Lkotlin/Lazy;", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class d implements c {
    @Deprecated
    public static final a nEF = new a((byte) 0);
    final Activity activity = this.nEE.getActivity();
    private final f lhN = g.ah(new b(this));
    private final o nEE;

    static {
        AppMethodBeat.i(176483);
        AppMethodBeat.o(176483);
    }

    private final c bTO() {
        AppMethodBeat.i(177601);
        c cVar = (c) this.lhN.getValue();
        AppMethodBeat.o(177601);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(o oVar) {
        p.h(oVar, "windowActivity");
        AppMethodBeat.i(177602);
        this.nEE = oVar;
        AppMethodBeat.o(177602);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final void a(e.b bVar, e.a aVar) {
        View view;
        ViewTreeObserver viewTreeObserver;
        String str = null;
        AppMethodBeat.i(176476);
        if (this.activity == null) {
            new c(this, aVar).invoke();
            AppMethodBeat.o(176476);
        } else if (this.activity.isFinishing() || this.activity.isDestroyed()) {
            Log.e("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation but activity(" + this.activity + ") destroyed");
            if (aVar != null) {
                aVar.a(bTO().btm(), false);
                AppMethodBeat.o(176476);
                return;
            }
            AppMethodBeat.o(176476);
        } else if (Build.VERSION.SDK_INT < 26 || !this.activity.isInPictureInPictureMode()) {
            Window window = this.activity.getWindow();
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
                bTO().a(bVar, aVar);
                AppMethodBeat.o(176476);
                return;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            o oVar = this.nEE;
            if (bVar != null) {
                str = bVar.name();
            }
            oVar.setSoftOrientation(str);
            bTO().a(bVar, new C0787d(this, aVar, atomicBoolean, view));
            atomicBoolean.set(false);
            AppMethodBeat.o(176476);
        } else {
            o oVar2 = this.nEE;
            if (bVar != null) {
                str = bVar.name();
            }
            oVar2.setSoftOrientation(str);
            if (bVar != null) {
                switch (e.$EnumSwitchMapping$0[bVar.ordinal()]) {
                    case 1:
                        this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(9, 16)).build());
                        if (aVar != null) {
                            aVar.a(bVar, true);
                            AppMethodBeat.o(176476);
                            return;
                        }
                        AppMethodBeat.o(176476);
                        return;
                    default:
                        this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(16, 9)).build());
                        if (aVar != null) {
                            aVar.a(bVar, true);
                            AppMethodBeat.o(176476);
                            return;
                        }
                        AppMethodBeat.o(176476);
                        return;
                }
            } else if (aVar != null) {
                aVar.a(bTO().btm(), false);
                AppMethodBeat.o(176476);
            } else {
                AppMethodBeat.o(176476);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "orientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
    /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.a.d$d  reason: collision with other inner class name */
    public static final class C0787d implements e.a {
        final /* synthetic */ e.a kEO;
        final /* synthetic */ d nEG;
        final /* synthetic */ AtomicBoolean nEH;
        final /* synthetic */ View nEI;

        C0787d(d dVar, e.a aVar, AtomicBoolean atomicBoolean, View view) {
            this.nEG = dVar;
            this.kEO = aVar;
            this.nEH = atomicBoolean;
            this.nEI = view;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
        public final void a(e.b bVar, boolean z) {
            AppMethodBeat.i(176475);
            a unused = d.nEF;
            Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:" + bVar + ", success:" + z);
            final a aVar = new a(this, bVar, z);
            if (!z || this.nEH.get()) {
                aVar.invoke("syncReturn");
                AppMethodBeat.o(176475);
                return;
            }
            View view = this.nEI;
            z.d dVar = new z.d();
            dVar.SYE = 0;
            view.getViewTreeObserver().addOnGlobalLayoutListener(new f.a(view, dVar, new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.appbrand.platform.window.a.d.C0787d.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* bridge */ /* synthetic */ x invoke() {
                    AppMethodBeat.i(219775);
                    aVar.invoke("globalLayout x2");
                    x xVar = x.SXb;
                    AppMethodBeat.o(219775);
                    return xVar;
                }
            }));
            this.nEI.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.platform.window.a.d.C0787d.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(219776);
                    aVar.invoke("timeout");
                    AppMethodBeat.o(219776);
                }
            }, 100);
            AppMethodBeat.o(176475);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$requestDeviceOrientation$2$callback$1", "Lkotlin/Function1;", "", "", "antiReentryGuard", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "reason", "luggage-wxa-app_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.a.d$d$a */
        public static final class a implements kotlin.g.a.b<String, x> {
            final /* synthetic */ boolean $success;
            private final AtomicBoolean nEK = new AtomicBoolean(true);
            final /* synthetic */ C0787d nEL;
            final /* synthetic */ e.b nEM;

            a(C0787d dVar, e.b bVar, boolean z) {
                this.nEL = dVar;
                this.nEM = bVar;
                this.$success = z;
                AppMethodBeat.i(219779);
                AppMethodBeat.o(219779);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* bridge */ /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(219778);
                invoke(str);
                x xVar = x.SXb;
                AppMethodBeat.o(219778);
                return xVar;
            }

            public final void invoke(String str) {
                AppMethodBeat.i(219777);
                p.h(str, "reason");
                if (this.nEK.getAndSet(false)) {
                    a unused = d.nEF;
                    Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, will invoke outer listener reason:[" + str + "], orientation:" + this.nEM + " success:" + this.$success);
                    e.a aVar = this.nEL.kEO;
                    if (aVar != null) {
                        aVar.a(this.nEM, this.$success);
                    }
                    o oVar = this.nEL.nEG.nEE;
                    e.b bVar = this.nEM;
                    oVar.setSoftOrientation(bVar != null ? bVar.name() : null);
                }
                AppMethodBeat.o(219777);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(176477);
        bTO().onConfigurationChanged(configuration);
        AppMethodBeat.o(176477);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onResume() {
        AppMethodBeat.i(176478);
        bTO().onResume();
        AppMethodBeat.o(176478);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onPause() {
        AppMethodBeat.i(176479);
        bTO().onPause();
        AppMethodBeat.o(176479);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void release() {
        AppMethodBeat.i(176480);
        if (this.activity == null || this.activity.isDestroyed() || this.activity.isFinishing()) {
            bTO().release();
        }
        if (p.j(this.nEE.nFw, this)) {
            this.nEE.nFw = null;
        }
        AppMethodBeat.o(176480);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final e.b btm() {
        Display defaultDisplay;
        AppMethodBeat.i(176481);
        if (this.activity != null) {
            e.b btm = bTO().btm();
            AppMethodBeat.o(176481);
            return btm;
        }
        WindowManager bTX = this.nEE.bTX();
        Integer valueOf = (bTX == null || (defaultDisplay = bTX.getDefaultDisplay()) == null) ? null : Integer.valueOf(defaultDisplay.getRotation());
        if ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 2)) {
            e.b bVar = e.b.PORTRAIT;
            AppMethodBeat.o(176481);
            return bVar;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            e.b bVar2 = e.b.LANDSCAPE_LEFT;
            AppMethodBeat.o(176481);
            return bVar2;
        } else if (valueOf != null && valueOf.intValue() == 3) {
            e.b bVar3 = e.b.LANDSCAPE_RIGHT;
            AppMethodBeat.o(176481);
            return bVar3;
        } else {
            AppMethodBeat.o(176481);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<c> {
        final /* synthetic */ d nEG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.nEG = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(177600);
            if (this.nEG.activity != null) {
                g E = g.E(this.nEG.activity);
                AppMethodBeat.o(177600);
                return E;
            }
            c cVar = (c) m.g("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl.Dummy", c.class);
            AppMethodBeat.o(177600);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e.a kEO;
        final /* synthetic */ d nEG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar, e.a aVar) {
            super(0);
            this.nEG = dVar;
            this.kEO = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(176473);
            e.a aVar = this.kEO;
            if (aVar != null) {
                aVar.a(this.nEG.btm(), false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(176473);
            return xVar;
        }
    }
}
