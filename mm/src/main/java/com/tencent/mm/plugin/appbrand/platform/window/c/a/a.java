package com.tencent.mm.plugin.appbrand.platform.window.c.a;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class a implements c {
    private static final e.b[] kEN = e.b.nEs;
    @Deprecated
    public static final C0788a nFA = new C0788a((byte) 0);
    private final com.tencent.mm.plugin.appbrand.platform.window.c nFz;

    public a(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        p.h(cVar, "window");
        AppMethodBeat.i(219783);
        this.nFz = cVar;
        AppMethodBeat.o(219783);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a(\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0014\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler$Companion;", "", "()V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "kotlin.jvm.PlatformType", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "TAG", "", "luggage-wxa-app_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.platform.window.c.a.a$a  reason: collision with other inner class name */
    static final class C0788a {
        private C0788a() {
        }

        public /* synthetic */ C0788a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(219784);
        AppMethodBeat.o(219784);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final void a(e.b bVar, e.a aVar) {
        boolean z = true;
        AppMethodBeat.i(219781);
        if (bVar == null) {
            new b(aVar).invoke();
            AppMethodBeat.o(219781);
            return;
        }
        Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + bVar.nEr + ',' + bVar.name());
        if (bVar == e.b.PORTRAIT) {
            this.nFz.setSoftOrientation("portrait");
            if (aVar != null) {
                e.b btm = btm();
                if (btm() != bVar) {
                    z = false;
                }
                aVar.a(btm, z);
                AppMethodBeat.o(219781);
                return;
            }
            AppMethodBeat.o(219781);
            return;
        }
        e.b[] bVarArr = kEN;
        p.g(bVarArr, "LANDSCAPE_ENUMS");
        if (kotlin.a.e.contains(bVarArr, bVar)) {
            this.nFz.setSoftOrientation("landscape");
            if (aVar != null) {
                e.b btm2 = btm();
                e.b[] bVarArr2 = kEN;
                p.g(bVarArr2, "LANDSCAPE_ENUMS");
                aVar.a(btm2, kotlin.a.e.contains(bVarArr2, btm()));
                AppMethodBeat.o(219781);
                return;
            }
            AppMethodBeat.o(219781);
        } else if (bVar == e.b.UNSPECIFIED) {
            this.nFz.setSoftOrientation("auto");
            if (aVar != null) {
                aVar.a(btm(), true);
                AppMethodBeat.o(219781);
                return;
            }
            AppMethodBeat.o(219781);
        } else {
            this.nFz.setSoftOrientation("portrait");
            if (aVar != null) {
                e.b btm3 = btm();
                if (btm() != bVar) {
                    z = false;
                }
                aVar.a(btm3, z);
                AppMethodBeat.o(219781);
                return;
            }
            AppMethodBeat.o(219781);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final e.b btm() {
        AppMethodBeat.i(219782);
        DisplayMetrics vDisplayMetrics = this.nFz.getVDisplayMetrics();
        if (vDisplayMetrics.heightPixels >= vDisplayMetrics.widthPixels) {
            Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
            e.b bVar = e.b.PORTRAIT;
            AppMethodBeat.o(219782);
            return bVar;
        }
        Log.i("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
        e.b bVar2 = e.b.LANDSCAPE_SENSOR;
        AppMethodBeat.o(219782);
        return bVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e.a kEO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e.a aVar) {
            super(0);
            this.kEO = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(219780);
            e.a aVar = this.kEO;
            if (aVar != null) {
                aVar.a(null, false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(219780);
            return xVar;
        }
    }
}
