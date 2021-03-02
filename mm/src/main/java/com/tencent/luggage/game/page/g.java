package com.tencent.luggage.game.page;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.page.a.b;
import com.tencent.mm.plugin.appbrand.page.a.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements b, d, e.a {
    private final ac cwK;
    private String cwU;
    private boolean cwV = false;
    private boolean mDestroyed = false;

    g(ac acVar, String str) {
        this.cwK = acVar;
        this.cwU = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final boolean MY() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final void dx(String str) {
        AppMethodBeat.i(130646);
        Log.e("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "setRequestedOrientation not support for game, appId[%s]", this.cwK.getAppId());
        AppMethodBeat.o(130646);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final void a(final e.a aVar) {
        AppMethodBeat.i(177442);
        if (this.mDestroyed) {
            Log.w("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s", this.cwK.getAppId());
            AppMethodBeat.o(177442);
        } else if (this.cwK.kEb == null || this.cwK.kEb.getOrientationHandler() == null) {
            if (aVar != null) {
                aVar.a(null, false);
            }
            AppMethodBeat.o(177442);
        } else if (this.cwK.getRuntime().brM()) {
            Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, game is showing launch ad, ignore changing orientation", new Object[0]);
            if (aVar != null) {
                aVar.a(null, false);
            }
            AppMethodBeat.o(177442);
        } else {
            e.b aeE = e.b.aeE(this.cwU);
            Log.printInfoStack("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, appId[%s], orientation[%s]", this.cwK.getAppId(), aeE);
            if (aeE != null) {
                this.cwK.kEb.getOrientationHandler().a(aeE, new e.a() {
                    /* class com.tencent.luggage.game.page.g.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                    public final void a(e.b bVar, boolean z) {
                        AppMethodBeat.i(177441);
                        g.this.a(bVar, z);
                        if (aVar != null) {
                            aVar.a(bVar, z);
                        }
                        AppMethodBeat.o(177441);
                    }
                });
            }
            AppMethodBeat.o(177442);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final String MZ() {
        return this.cwU;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
    public final void a(e.b bVar, boolean z) {
        String name;
        AppMethodBeat.i(177443);
        Object[] objArr = new Object[2];
        if (bVar == null) {
            name = BuildConfig.COMMAND;
        } else {
            name = bVar.name();
        }
        objArr[0] = name;
        objArr[1] = Boolean.valueOf(z);
        Log.i("Luggage.WAGamePageViewOrientationExtensionImpl[AppBrandSplashAd]", "onOrientationChanged requested[%s], success[%b]", objArr);
        AppMethodBeat.o(177443);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onForeground() {
        AppMethodBeat.i(130649);
        this.cwV = true;
        if (this.cwK.getFullscreenImpl() == null || !this.cwK.getFullscreenImpl().bTK()) {
            a((e.a) null);
        } else {
            this.cwK.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b() {
                /* class com.tencent.luggage.game.page.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.b
                public final void Na() {
                    AppMethodBeat.i(222888);
                    g.this.cwK.getFullscreenImpl().b(this);
                    if (!g.this.mDestroyed && g.this.cwV) {
                        g.this.a((e.a) null);
                    }
                    AppMethodBeat.o(222888);
                }
            });
        }
        a((e.a) null);
        AppMethodBeat.o(130649);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onBackground() {
        this.cwV = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onDestroy() {
        this.cwV = false;
        this.mDestroyed = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
    }
}
