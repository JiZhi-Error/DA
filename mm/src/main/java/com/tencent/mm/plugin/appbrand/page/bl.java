package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.b.a.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.b;
import com.tencent.mm.plugin.appbrand.page.a.d;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ConcurrentModificationException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class bl implements b, d {
    private final ac cwK;
    volatile String cwU;
    private boolean cwV = false;
    private boolean mDestroyed = false;
    private Configuration ntA;
    private a ntB;
    final e ntx;
    private boolean nty = false;
    private boolean ntz = false;

    static /* synthetic */ void e(bl blVar) {
        AppMethodBeat.i(185222);
        blVar.bSd();
        AppMethodBeat.o(185222);
    }

    static /* synthetic */ void h(bl blVar) {
        AppMethodBeat.i(185224);
        blVar.ik(false);
        AppMethodBeat.o(185224);
    }

    bl(ac acVar) {
        AppMethodBeat.i(147449);
        this.cwK = acVar;
        this.ntx = new e(acVar);
        this.cwK.noq.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass1 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(147445);
                if (TextUtils.isEmpty(bl.this.cwK.lBI)) {
                    AppMethodBeat.o(147445);
                } else if (bl.this.mDestroyed) {
                    try {
                        bl.this.cwK.noq.removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(147445);
                    } catch (ConcurrentModificationException e2) {
                        bl.this.cwK.post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(147444);
                                bl.this.cwK.noq.removeOnLayoutChangeListener(this);
                                AppMethodBeat.o(147444);
                            }
                        });
                        AppMethodBeat.o(147445);
                    }
                } else {
                    Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "pageArea onLayoutChange appId[%s], url[%s], frozen[%b]", bl.this.cwK.getAppId(), bl.this.cwK.lBI, Boolean.valueOf(bl.this.nty));
                    if (bl.this.nty) {
                        bl.this.ntz = true;
                        AppMethodBeat.o(147445);
                        return;
                    }
                    bl.e(bl.this);
                    AppMethodBeat.o(147445);
                }
            }
        });
        AppMethodBeat.o(147449);
    }

    private void ik(boolean z) {
        AppMethodBeat.i(185220);
        this.nty = z;
        if (!this.nty && this.ntz) {
            Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "emitPageLayout after mPageLayoutFrozen reset false, appId[%s] url[%s] mDestroyed[%b]", this.cwK.getAppId(), this.cwK.lBI, Boolean.valueOf(this.mDestroyed));
            bSd();
            this.ntz = false;
        }
        AppMethodBeat.o(185220);
    }

    private void bSd() {
        AppMethodBeat.i(185221);
        if (this.cwK.NY() == null) {
            AppMethodBeat.o(185221);
        } else if (this.mDestroyed) {
            AppMethodBeat.o(185221);
        } else {
            this.ntx.Oe();
            AppMethodBeat.o(185221);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final void dx(String str) {
        AppMethodBeat.i(147451);
        this.cwU = str;
        a((e.a) null);
        AppMethodBeat.o(147451);
    }

    public final void r(final String str, final Map<String, Object> map) {
        AppMethodBeat.i(147452);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.cwK.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(147446);
                    bl.this.r(str, map);
                    AppMethodBeat.o(147446);
                }
            });
            AppMethodBeat.o(147452);
            return;
        }
        com.tencent.luggage.sdk.b.a.b.e eVar = this.ntx;
        if (map != null) {
            eVar.cAB.putAll(map);
        }
        dx(str);
        AppMethodBeat.o(147452);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final String MZ() {
        return this.cwU;
    }

    private com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler() {
        AppMethodBeat.i(169507);
        com.tencent.mm.plugin.appbrand.platform.window.e orientationHandler = this.cwK.kEb.getOrientationHandler();
        AppMethodBeat.o(169507);
        return orientationHandler;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final void a(final e.a aVar) {
        AppMethodBeat.i(169508);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.cwK.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(147447);
                    bl.this.a(aVar);
                    AppMethodBeat.o(147447);
                }
            });
            AppMethodBeat.o(169508);
        } else if (this.mDestroyed) {
            Log.w("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation but destroyed, appId:%s url:%s", this.cwK.getAppId(), this.cwK.lBI);
            AppMethodBeat.o(169508);
        } else {
            ik(true);
            AnonymousClass4 r5 = new e.a() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                public final void a(e.b bVar, boolean z) {
                    AppMethodBeat.i(169506);
                    Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", bl.f(bl.this), bl.g(bl.this), bVar, Boolean.valueOf(z));
                    if (aVar != null) {
                        aVar.a(bVar, z);
                    }
                    bl.h(bl.this);
                    AppMethodBeat.o(169506);
                }
            };
            boolean z = this.cwK.kEb instanceof o;
            if (e.b.c(getOrientationHandler().btm()) && z && ((com.tencent.luggage.sdk.config.a) this.cwK.av(com.tencent.luggage.sdk.config.a.class)).cyg) {
                Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation appId[%s], url[%s], tabletLandscapeCompatible", this.cwK.getAppId(), this.cwK.lBI);
                r5.a(null, false);
                AppMethodBeat.o(169508);
            } else if (this.cwK.getRuntime().brM()) {
                Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, wxa is showing launch ad, ignore changing orientation", new Object[0]);
                r5.a(null, false);
                AppMethodBeat.o(169508);
            } else {
                Log.printInfoStack("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, before trigger, appId[%s] url[%s] orientation[%s]", this.cwK.getAppId(), this.cwK.lBI, this.cwU);
                String nullAs = Util.nullAs(this.cwU, "portrait");
                char c2 = 65535;
                switch (nullAs.hashCode()) {
                    case -2022952606:
                        if (nullAs.equals("landscapeLeft")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3005871:
                        if (nullAs.equals("auto")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 729267099:
                        if (nullAs.equals("portrait")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1430647483:
                        if (nullAs.equals("landscape")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        getOrientationHandler().a(e.b.UNSPECIFIED, r5);
                        AppMethodBeat.o(169508);
                        return;
                    case 1:
                        getOrientationHandler().a(e.b.LANDSCAPE_SENSOR, r5);
                        AppMethodBeat.o(169508);
                        return;
                    case 2:
                        getOrientationHandler().a(e.b.PORTRAIT, r5);
                        AppMethodBeat.o(169508);
                        return;
                    case 3:
                        getOrientationHandler().a(e.b.LANDSCAPE_LEFT, r5);
                        AppMethodBeat.o(169508);
                        return;
                    default:
                        String format = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", this.cwK.getAppId(), this.cwK.lBI, this.cwU);
                        if (this.cwK.kAU) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(format);
                            AppMethodBeat.o(169508);
                            throw illegalArgumentException;
                        }
                        Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", format);
                        r5.a(null, false);
                        AppMethodBeat.o(169508);
                        return;
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onForeground() {
        AppMethodBeat.i(147454);
        if (this.ntA == null) {
            this.ntA = new Configuration(((t) Objects.requireNonNull(this.cwK.nqU)).getResources().getConfiguration());
        }
        this.cwV = true;
        if (this.cwK.getFullscreenImpl() == null || !this.cwK.getFullscreenImpl().bTK()) {
            a((e.a) null);
        } else {
            this.cwK.getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.b
                public final void Na() {
                    AppMethodBeat.i(229946);
                    bl.this.cwK.getFullscreenImpl().b(this);
                    if (!bl.this.mDestroyed && bl.this.cwV) {
                        bl.this.a((e.a) null);
                    }
                    AppMethodBeat.o(229946);
                }
            });
        }
        com.tencent.luggage.sdk.b.a.b.e eVar = this.ntx;
        if (eVar.cAy) {
            Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", eVar.cwK.getAppId(), eVar.cwK.lBI);
            eVar.Of();
            eVar.cAy = false;
        }
        eVar.foreground = true;
        AppMethodBeat.o(147454);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onBackground() {
        this.cwV = false;
        this.ntx.foreground = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onDestroy() {
        AppMethodBeat.i(229951);
        this.cwV = false;
        this.mDestroyed = true;
        if (this.ntB != null) {
            a aVar = this.ntB;
            aVar.dS();
            aVar.afv = null;
            aVar.ntI = null;
        }
        AppMethodBeat.o(229951);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(229952);
        if (this.cwV && !this.mDestroyed && this.ntA != null && this.ntA.orientation != configuration.orientation) {
            this.ntA = new Configuration(configuration);
            if (this.ntB == null) {
                this.ntB = new a(this, (byte) 0);
            }
            a aVar = this.ntB;
            bl.this.ik(true);
            aVar.dS();
            View view = (View) Objects.requireNonNull(bl.this.cwK.getContentView());
            view.postDelayed(aVar.ntI, 100);
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            a.AnonymousClass2 r2 = new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.a.AnonymousClass2 */
                private int count;

                public final void onGlobalLayout() {
                    AppMethodBeat.i(229948);
                    if (a.this.ntI == null) {
                        a.this.dS();
                        AppMethodBeat.o(229948);
                        return;
                    }
                    int i2 = this.count + 1;
                    this.count = i2;
                    if (i2 == 2) {
                        a.this.dS();
                        a.this.ntI.run();
                    }
                    AppMethodBeat.o(229948);
                }
            };
            aVar.afv = r2;
            viewTreeObserver.addOnGlobalLayoutListener(r2);
        }
        AppMethodBeat.o(229952);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
    }

    class a {
        ViewTreeObserver.OnGlobalLayoutListener afv;
        Runnable ntI;

        private a() {
            AppMethodBeat.i(229949);
            this.ntI = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.bl.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(229947);
                    bl.h(bl.this);
                    AppMethodBeat.o(229947);
                }
            };
            AppMethodBeat.o(229949);
        }

        /* synthetic */ a(bl blVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void dS() {
            AppMethodBeat.i(229950);
            View contentView = bl.this.cwK.getContentView();
            if (contentView != null) {
                contentView.removeCallbacks(this.ntI);
                if (this.afv != null) {
                    contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.afv);
                }
            }
            AppMethodBeat.o(229950);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.d
    public final boolean MY() {
        boolean z;
        e.b bVar;
        AppMethodBeat.i(147450);
        com.tencent.mm.plugin.appbrand.platform.window.e orientationHandler = this.cwK.kEb == null ? null : this.cwK.kEb.getOrientationHandler();
        if (orientationHandler == null || (orientationHandler instanceof com.tencent.mm.plugin.appbrand.platform.window.c.a.a)) {
            Log.e("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "__willResize NULL orientationHandler, appId:%s, url:%s", this.cwK.getAppId(), this.cwK.lBI);
        } else {
            e.b btm = orientationHandler.btm();
            e.b aeE = e.b.aeE(this.cwU);
            Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s] current[%s], desire[%s]", this.cwK.getAppId(), this.cwK.lBI, btm, aeE);
            if (e.b.UNSPECIFIED != aeE) {
                if (!this.cwK.kEb.OD() && j.cDv.Pj() && ai.et(this.cwK.getContext())) {
                    Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], huawei tabletLandscapeCompatible", this.cwK.getAppId(), this.cwK.lBI);
                } else if (!e.b.c(getOrientationHandler().btm()) || !((com.tencent.luggage.sdk.config.a) this.cwK.av(com.tencent.luggage.sdk.config.a.class)).cyg) {
                    if (aeE == null) {
                        bVar = e.b.PORTRAIT;
                    } else {
                        bVar = aeE;
                    }
                    if (!btm.b(bVar)) {
                        z = true;
                        this.ntx.cAC = z;
                        AppMethodBeat.o(147450);
                        return z;
                    }
                } else {
                    Log.i("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "willResizeByOrientation appId[%s], url[%s], tabletLandscapeCompatible", this.cwK.getAppId(), this.cwK.lBI);
                }
            }
        }
        z = false;
        this.ntx.cAC = z;
        AppMethodBeat.o(147450);
        return z;
    }

    static /* synthetic */ String f(bl blVar) {
        AppMethodBeat.i(185223);
        String appId = blVar.cwK.getAppId();
        AppMethodBeat.o(185223);
        return appId;
    }

    static /* synthetic */ String g(bl blVar) {
        return blVar.cwK.lBI;
    }
}
