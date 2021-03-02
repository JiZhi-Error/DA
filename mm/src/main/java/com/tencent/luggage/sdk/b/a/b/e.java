package com.tencent.luggage.sdk.b.a.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private int cAA;
    public final Map<String, Object> cAB = new HashMap();
    public boolean cAC = false;
    private final aa cAD = new aa();
    public boolean cAy = false;
    private int cAz;
    public final ac cwK;
    public boolean foreground = false;

    public e(ac acVar) {
        AppMethodBeat.i(146782);
        this.cwK = acVar;
        AppMethodBeat.o(146782);
    }

    private Map<String, Object> Od() {
        AppMethodBeat.i(146783);
        HashMap hashMap = new HashMap(this.cAB);
        this.cAB.clear();
        AppMethodBeat.o(146783);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends aa {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAppRouteResized";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private boolean bT(int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(146785);
        e.b aeE = e.b.aeE(this.cwK.bRx());
        if (aeE == null) {
            aeE = e.b.PORTRAIT;
        }
        if (org.apache.commons.b.a.contains(e.b.nEs, aeE)) {
            if (i2 > i3) {
                AppMethodBeat.o(146785);
                return true;
            }
            AppMethodBeat.o(146785);
            return false;
        } else if (e.b.PORTRAIT == aeE) {
            if (i3 > i2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(146785);
                return true;
            }
            if (this.cwK.kEb instanceof o ? Build.VERSION.SDK_INT >= 24 && this.cwK.getActivity() != null && this.cwK.getActivity().isInMultiWindowMode() : false) {
                if (this.cwK.kEb.getOrientationHandler().btm() == e.b.PORTRAIT || this.cwK.getActivity().getRequestedOrientation() == 1) {
                    if (i2 > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((i3 > 0) && z3) {
                        z2 = true;
                        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
                        AppMethodBeat.o(146785);
                        return z2;
                    }
                }
                z2 = false;
                Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
                AppMethodBeat.o(146785);
                return z2;
            }
            AppMethodBeat.o(146785);
            return false;
        } else {
            AppMethodBeat.o(146785);
            return true;
        }
    }

    public final void Oe() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(185218);
        int width = this.cwK.noq.getWidth();
        int height = this.cwK.noq.getHeight();
        if (width <= 0 || height <= 0) {
            Log.e("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", Integer.valueOf(width), Integer.valueOf(height), this.cwK.getAppId(), this.cwK.lBI);
            AppMethodBeat.o(185218);
            return;
        }
        boolean z4 = (width == this.cAz && height == this.cAA) ? false : true;
        this.cAz = width;
        this.cAA = height;
        int[] f2 = ai.f(this.cwK);
        if (!bT(width, height) || !bT(f2[0], f2[1])) {
            z = false;
        } else {
            z = true;
        }
        if (this.cAz == 0 || this.cAA == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", this.cwK.getAppId(), this.cwK.lBI, Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z), Boolean.valueOf(this.foreground), Boolean.valueOf(this.cAy));
        if ((!z2 || !z4 || !z) && (!this.cAC || !z)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            this.cAy = false;
            AppMethodBeat.o(185218);
        } else if (this.foreground) {
            Of();
            AppMethodBeat.o(185218);
        } else {
            this.cAy = true;
            AppMethodBeat.o(185218);
        }
    }

    public final void Of() {
        AppMethodBeat.i(146786);
        if (!this.cwK.isRunning()) {
            AppMethodBeat.o(146786);
        } else if (this.cAC) {
            a(new a((byte) 0));
            this.cAC = false;
            Log.i("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", this.cwK.getAppId(), this.cwK.lBI, this.cwK.bRx());
            AppMethodBeat.o(146786);
        } else {
            a(this.cAD);
            AppMethodBeat.o(146786);
        }
    }

    private <EVENT extends aa> void a(EVENT event) {
        AppMethodBeat.i(146787);
        b.d pageConfig = this.cwK.getPageConfig();
        if (pageConfig == null) {
            AppMethodBeat.o(146787);
            return;
        }
        int[] f2 = ai.f(this.cwK.NY());
        Map<String, Object> Od = Od();
        Od.put("originalPageOrientation", pageConfig.lcB);
        Od.put("lastPageOrientation", this.cwK.bRx());
        event.a(this.cwK, this.cwK.getComponentId(), this.cwK.noq.getWidth(), this.cwK.noq.getHeight(), f2[0], f2[1], this.cwK.kEb.getOrientationHandler().btm(), Od);
        AppMethodBeat.o(146787);
    }
}
