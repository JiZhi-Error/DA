package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/WindowFullscreenHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/AbsWindowFullscreenHandler;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "containerProvider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "lastActivityOrientation", "", "lastWindowOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getWindowAndroid", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "enterFullscreen", "", "view", "Landroid/view/View;", TencentLocation.EXTRA_DIRECTION, "exitFullscreen", "isFullScreen", "release", "setRequestedFullscreenDirection", "luggage-wxa-app_release"})
public final class be extends a {
    private Activity activity;
    private e.b kGe = e.b.PORTRAIT;
    private int kGf = 1;
    public boolean kGg;
    private final c kGh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public be(c cVar, d.b bVar, Activity activity2) {
        super(cVar, bVar);
        p.h(cVar, "windowAndroid");
        AppMethodBeat.i(219652);
        this.kGh = cVar;
        this.activity = activity2;
        AppMethodBeat.o(219652);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final void vH(int i2) {
        String str;
        AppMethodBeat.i(219648);
        this.nEi = true;
        if (i2 == 90 || i2 == -90) {
            str = "landscape";
        } else {
            str = "portrait";
        }
        e orientationHandler = this.kGh.getOrientationHandler();
        p.g(orientationHandler, "windowAndroid.orientationHandler");
        e.b btm = orientationHandler.btm();
        p.g(btm, "windowAndroid.orientatio…andler.currentOrientation");
        this.kGe = btm;
        this.kGh.setSoftOrientation(str);
        if (this.activity != null && p.j(str, "landscape")) {
            Activity activity2 = this.activity;
            if (activity2 == null) {
                p.hyc();
            }
            if (!e.b.c(e.b.yZ(activity2.getRequestedOrientation()))) {
                Activity activity3 = this.activity;
                if (activity3 == null) {
                    p.hyc();
                }
                this.kGf = activity3.getRequestedOrientation();
                Activity activity4 = this.activity;
                if (activity4 == null) {
                    p.hyc();
                }
                activity4.setRequestedOrientation(6);
            }
        }
        AppMethodBeat.o(219648);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a, com.tencent.mm.plugin.appbrand.platform.window.d
    public final void N(View view, int i2) {
        AppMethodBeat.i(219649);
        p.h(view, "view");
        super.N(view, i2);
        vH(i2);
        bTL();
        this.kGg = true;
        AppMethodBeat.o(219649);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a, com.tencent.mm.plugin.appbrand.platform.window.d
    public final void release() {
        AppMethodBeat.i(219650);
        super.release();
        this.activity = null;
        AppMethodBeat.o(219650);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a, com.tencent.mm.plugin.appbrand.platform.window.d
    public final boolean btC() {
        AppMethodBeat.i(219651);
        boolean z = this.nEi;
        if (z) {
            this.kGg = false;
        }
        if (super.btC()) {
            if (e.b.c(this.kGe)) {
                this.kGh.setSoftOrientation("landscape");
            } else {
                this.kGh.setSoftOrientation("portrait");
            }
            if (this.activity != null) {
                Activity activity2 = this.activity;
                if (activity2 == null) {
                    p.hyc();
                }
                activity2.setRequestedOrientation(this.kGf);
            }
            bTM();
            AppMethodBeat.o(219651);
            return true;
        } else if (z) {
            this.nEi = false;
            bTM();
            AppMethodBeat.o(219651);
            return true;
        } else {
            AppMethodBeat.o(219651);
            return false;
        }
    }
}
