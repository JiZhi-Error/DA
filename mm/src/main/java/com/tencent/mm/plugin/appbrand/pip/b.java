package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.f;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public final String cDW = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    public final ac cwK;
    final AppBrandPipContainerView kAR;
    volatile boolean mJZ = false;
    int mScreenHeight;
    int mScreenWidth;
    final View nBY;
    public final g nBZ;
    int nCA = AppBrandPipContainerView.oks;
    int nCB = AppBrandPipContainerView.okt;
    private int nCC;
    private int nCD;
    private int nCE;
    private int nCF;
    private int nCG;
    private int nCH;
    private int nCI;
    private int nCJ;
    private int nCK;
    private int nCL;
    private int nCM;
    private int nCN;
    final i nCa;
    final z nCb;
    public volatile boolean nCc = false;
    a nCd = null;
    int nCe;
    int nCf;
    int nCg;
    int nCh;
    int nCi;
    int nCj;
    int nCk;
    int nCl;
    int nCm;
    int nCn;
    int nCo;
    int nCp;
    int nCq;
    int nCr;
    int nCs;
    int nCt;
    int nCu;
    int nCv;
    private int nCw = AppBrandPipContainerView.okp;
    private int nCx = AppBrandPipContainerView.oko;
    private int nCy = AppBrandPipContainerView.okq;
    int nCz = AppBrandPipContainerView.okr;

    b(ac acVar, AppBrandPipContainerView appBrandPipContainerView, View view, g gVar, i iVar, z zVar) {
        AppMethodBeat.i(219501);
        this.cwK = acVar;
        this.kAR = appBrandPipContainerView;
        this.nBY = view;
        this.nBZ = gVar;
        this.nCa = iVar;
        this.nCb = zVar;
        AppMethodBeat.o(219501);
    }

    /* access modifiers changed from: package-private */
    public final void aR(float f2) {
        AppMethodBeat.i(219502);
        if (!this.nCc) {
            Log.w(this.cDW, "handleVideoTransferProgress, false == mHandleStarted");
            AppMethodBeat.o(219502);
            return;
        }
        this.nCC = this.nCe + ((int) ((f2 / 100.0f) * ((float) (this.nCq - this.nCe))));
        this.nCD = this.nCf + ((int) ((f2 / 100.0f) * ((float) (this.nCr - this.nCf))));
        this.nCE = this.nCg + ((int) ((f2 / 100.0f) * ((float) (this.nCs - this.nCg))));
        this.nCF = this.nCh + ((int) ((f2 / 100.0f) * ((float) (this.nCt - this.nCh))));
        this.nCG = this.nCi + ((int) ((f2 / 100.0f) * ((float) (this.nCu - this.nCi))));
        this.nCH = this.nCj + ((int) ((f2 / 100.0f) * ((float) (this.nCv - this.nCj))));
        this.nCI = (int) Math.ceil((double) (0.5f * ((float) (this.nCC - this.nCG))));
        this.nCJ = (int) Math.ceil((double) (0.4f * ((float) (this.nCD - this.nCH))));
        this.nCK = (int) Math.ceil((double) (0.6f * ((float) (this.nCD - this.nCH))));
        this.nCL = this.nCn + ((int) ((f2 / 100.0f) * ((float) (this.nCz - this.nCn))));
        this.nCM = this.nCo + ((int) ((f2 / 100.0f) * ((float) (this.nCA - this.nCo))));
        this.nCN = this.nCp + ((int) ((f2 / 100.0f) * ((float) (this.nCB - this.nCp))));
        a(f2, this.nCC, this.nCD, this.nCE, this.nCF, this.nCG, this.nCH, this.nCI, this.nCJ, this.nCK, this.nCL, this.nCM, this.nCN);
        AppMethodBeat.o(219502);
    }

    /* access modifiers changed from: package-private */
    public final void bTE() {
        AppMethodBeat.i(219503);
        Log.i(this.cDW, "handleVideoPage2PipEnd");
        if (!this.nCc) {
            iw(false);
        }
        a(100.0f, this.nCq, this.nCr, this.nCs, this.nCt, this.nCu, this.nCv, this.nCw, this.nCx, this.nCy, this.nCz, this.nCA, this.nCB);
        AppMethodBeat.o(219503);
    }

    /* access modifiers changed from: package-private */
    public final boolean iw(boolean z) {
        AppMethodBeat.i(219504);
        final int videoWidth = this.nCa.getVideoWidth();
        final int videoHeight = this.nCa.getVideoHeight();
        if (videoWidth == 0 || videoHeight == 0) {
            Log.w(this.cDW, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
            AppMethodBeat.o(219504);
            return false;
        }
        final Point bTF = bTF();
        if (bTF == null) {
            Log.w(this.cDW, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
            AppMethodBeat.o(219504);
            return false;
        }
        final Point point = new Point();
        final AnonymousClass2 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.pip.b.AnonymousClass2 */

            public final void run() {
                boolean z;
                e eVar;
                AppMethodBeat.i(219498);
                if (b.this.nCc) {
                    Log.i(b.this.cDW, "handleVideoPage2PipStart, true == mHandleStarted");
                    AppMethodBeat.o(219498);
                    return;
                }
                int bIp = b.this.nBZ.bIp();
                int bIq = b.this.nBZ.bIq();
                Log.i(b.this.cDW, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(point.x + bTF.x), Integer.valueOf(point.y + bTF.y));
                b.this.kAR.a(b.a(b.this, point.x, point.y, bTF));
                b bVar = b.this;
                int i2 = videoWidth;
                int i3 = videoHeight;
                if ((-1 == i2 || -1 == i3) ? false : true) {
                    if (i2 >= i3) {
                        z = true;
                    }
                    z = false;
                } else {
                    if (bIp >= bIq) {
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    bVar.nCq = AppBrandPipContainerView.oka;
                    bVar.nCr = AppBrandPipContainerView.okb;
                } else {
                    bVar.nCq = AppBrandPipContainerView.oke;
                    bVar.nCr = AppBrandPipContainerView.okf;
                }
                if (bVar.nBY instanceof f) {
                    f fVar = (f) bVar.nBY;
                    if (z) {
                        eVar = e.LANDSCAPE;
                    } else {
                        eVar = e.PORTRAIT;
                    }
                    fVar.a(eVar);
                }
                AppBrandPipContainerView appBrandPipContainerView = b.this.kAR;
                int i4 = b.this.nCq;
                int i5 = b.this.nCr;
                appBrandPipContainerView.eA(appBrandPipContainerView.okF, i4);
                appBrandPipContainerView.eB(appBrandPipContainerView.okG, i5);
                Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + appBrandPipContainerView.okF + ", mStablePosY: " + appBrandPipContainerView.okG);
                appBrandPipContainerView.eC(appBrandPipContainerView.okF, appBrandPipContainerView.okG);
                b.this.a(0.0f, b.this.nCe, b.this.nCf, b.this.nCg, b.this.nCh, b.this.nCi, b.this.nCj, b.this.nCk, b.this.nCl, b.this.nCm, b.this.nCn, b.this.nCo, b.this.nCp);
                b.this.nCc = true;
                if (b.this.nCb != null) {
                    Log.i(b.this.cDW, "handleVideoPage2PipStart, run afterStartTask");
                    b.this.nCb.bZv();
                }
                AppMethodBeat.o(219498);
            }
        };
        if (z) {
            this.nBZ.a(this.cwK, new g.a() {
                /* class com.tencent.mm.plugin.appbrand.pip.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g.a
                public final void ef(int i2, int i3) {
                    AppMethodBeat.i(219499);
                    if (b.this.mJZ) {
                        Log.i(b.this.cDW, "handleVideoPage2PipStart, onVideoPositionGot, released");
                        AppMethodBeat.o(219499);
                        return;
                    }
                    point.x = i2;
                    point.y = i3;
                    r0.run();
                    AppMethodBeat.o(219499);
                }
            });
        } else {
            Point bIr = this.nBZ.bIr();
            point.x = bIr.x;
            point.y = bIr.y;
            r0.run();
        }
        AppMethodBeat.o(219504);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Point bTF() {
        AppMethodBeat.i(219505);
        bb bbVar = this.cwK.nmX;
        if (bbVar == null) {
            Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
            AppMethodBeat.o(219505);
            return null;
        }
        View contentView = bbVar.getContentView();
        if (contentView == null) {
            Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, null == webView");
            AppMethodBeat.o(219505);
            return null;
        }
        ViewParent parent = this.kAR.getParent();
        if (!(parent instanceof ViewGroup)) {
            Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
            AppMethodBeat.o(219505);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.mScreenWidth = viewGroup.getWidth();
        this.mScreenHeight = viewGroup.getHeight();
        Log.d(this.cDW, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight));
        ViewParent parent2 = contentView.getParent();
        int i2 = 0;
        int i3 = 0;
        while (parent2 != null) {
            if (!(parent2 instanceof ViewGroup)) {
                Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
                AppMethodBeat.o(219505);
                return null;
            }
            i3 = (int) (((float) i3) + contentView.getX());
            i2 = (int) (contentView.getY() + ((float) i2));
            if (parent2 == viewGroup) {
                Log.d(this.cDW, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", Integer.valueOf(i3), Integer.valueOf(i2));
                Point point = new Point(i3, i2);
                AppMethodBeat.o(219505);
                return point;
            }
            contentView = (View) parent2;
            parent2 = contentView.getParent();
        }
        AppMethodBeat.o(219505);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        AppMethodBeat.i(219506);
        int i14 = (int) ((f2 / 100.0f) * ((float) i8));
        int i15 = (int) ((f2 / 100.0f) * ((float) i9));
        int i16 = (int) ((f2 / 100.0f) * ((float) i10));
        int i17 = (i14 * 2) + i6;
        int i18 = i7 + i15 + i16;
        ViewGroup.LayoutParams layoutParams = this.kAR.getLayoutParams();
        layoutParams.width = i17;
        layoutParams.height = i18;
        this.kAR.setLayoutParams(layoutParams);
        this.kAR.setX((float) (i4 + ((i2 - i17) / 2)));
        this.kAR.setY((float) (i5 + ((i3 - i18) / 2)));
        ViewGroup.LayoutParams layoutParams2 = this.nBY.getLayoutParams();
        layoutParams2.width = i6;
        layoutParams2.height = i7;
        this.nBY.setLayoutParams(layoutParams2);
        this.kAR.b(i6, i14, i15, i16, (int) ((f2 / 100.0f) * ((float) i11)), (int) ((f2 / 100.0f) * ((float) i12)), (int) ((f2 / 100.0f) * ((float) i13)));
        AppMethodBeat.o(219506);
    }

    /* access modifiers changed from: package-private */
    public class a implements AppBrandPipContainerView.a {
        int cEH;
        int cEI;
        Point nCU;

        private a() {
            this.nCU = null;
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a
        public final void ev(int i2, int i3) {
            int i4;
            int i5;
            AppMethodBeat.i(219500);
            Log.d(b.this.cDW, "MyOnStablePositionChangeListener, onStablePositionChange");
            if (b.this.mJZ) {
                Log.i(b.this.cDW, "onStablePositionChange, onVideoPositionGot, released");
                AppMethodBeat.o(219500);
                return;
            }
            int videoWidth = b.this.nCa.getVideoWidth();
            int videoHeight = b.this.nCa.getVideoHeight();
            if (videoWidth == 0 || videoHeight == 0) {
                Log.w(b.this.cDW, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
                AppMethodBeat.o(219500);
                return;
            }
            int bIp = b.this.nBZ.bIp();
            int bIq = b.this.nBZ.bIq();
            if (this.nCU == null) {
                this.nCU = b.this.bTF();
            }
            if (this.nCU == null) {
                Log.w(b.this.cDW, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
                AppMethodBeat.o(219500);
                return;
            }
            int i6 = this.cEH;
            int i7 = this.cEI + this.nCU.y;
            Log.i(b.this.cDW, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(i6), Integer.valueOf(i7));
            b bVar = b.this;
            boolean z = (-1 == videoWidth || -1 == videoHeight) ? false : true;
            boolean z2 = false;
            if (z) {
                if (videoWidth >= videoHeight) {
                    z2 = true;
                }
            } else if (bIp >= bIq) {
                z2 = true;
            }
            if (z2) {
                bVar.nCq = AppBrandPipContainerView.oka;
                bVar.nCr = AppBrandPipContainerView.okb;
                i4 = AppBrandPipContainerView.okc;
                i5 = AppBrandPipContainerView.okd;
            } else {
                bVar.nCq = AppBrandPipContainerView.oke;
                bVar.nCr = AppBrandPipContainerView.okf;
                i4 = AppBrandPipContainerView.okg;
                i5 = AppBrandPipContainerView.okh;
            }
            int stablePosX = bVar.kAR.getStablePosX();
            int stablePosY = bVar.kAR.getStablePosY();
            Log.i(bVar.cDW, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", Integer.valueOf(stablePosX), Integer.valueOf(stablePosY));
            bVar.nCs = Math.min(Math.max(0, stablePosX), bVar.mScreenWidth - bVar.nCq);
            bVar.nCt = Math.min(Math.max(0, stablePosY), bVar.mScreenHeight - bVar.nCr);
            Log.i(bVar.cDW, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", Integer.valueOf(bVar.nCs), Integer.valueOf(bVar.nCt));
            if (!z) {
                videoHeight = bIq;
                videoWidth = bIp;
            }
            float f2 = (((float) i4) + 0.0f) / ((float) videoWidth);
            float f3 = (((float) i5) + 0.0f) / ((float) videoHeight);
            if (f2 >= f3) {
                bVar.nCu = i4;
                bVar.nCv = (int) Math.ceil((double) (((float) videoHeight) * f2));
            } else {
                bVar.nCu = (int) Math.ceil((double) (((float) videoWidth) * f3));
                bVar.nCv = i5;
            }
            bVar.nCi = bIp;
            bVar.nCj = bIq;
            Log.d(bVar.cDW, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", Integer.valueOf(bVar.nCi), Integer.valueOf(bVar.nCj));
            bVar.nCf = (int) (((((float) bVar.nCr) + 0.0f) / ((float) bVar.nCv)) * ((float) bVar.nCj));
            bVar.nCe = (int) (((((float) bVar.nCq) + 0.0f) / ((float) bVar.nCu)) * ((float) bVar.nCi));
            Log.d(bVar.cDW, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", Integer.valueOf(bVar.nCe), Integer.valueOf(bVar.nCf));
            bVar.nCu = i4;
            bVar.nCv = i5;
            float f4 = (((float) bVar.nCe) + 0.0f) / ((float) bVar.nCq);
            float f5 = (((float) bVar.nCf) + 0.0f) / ((float) bVar.nCr);
            Log.d(bVar.cDW, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", Float.valueOf(f4), Float.valueOf(f5));
            int min = Math.min(Math.max(i6, -bVar.nCe), bVar.mScreenWidth);
            int min2 = Math.min(Math.max(i7, -bVar.nCf), bVar.mScreenHeight);
            Log.d(bVar.cDW, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(min), Integer.valueOf(min2));
            if (z) {
                bVar.nCg = min - ((int) ((((float) (bVar.nCq - i4)) * f4) / 2.0f));
                bVar.nCh = min2 - ((int) ((((float) (bVar.nCr - i5)) * f5) / 2.0f));
            } else {
                bVar.nCg = (((bIp - bVar.nCi) / 2) + min) - ((bVar.nCe - bVar.nCi) / 2);
                bVar.nCh = (((bIq - bVar.nCj) / 2) + min2) - ((bVar.nCf - bVar.nCj) / 2);
            }
            bVar.nCk = (int) Math.ceil((double) (0.5f * ((float) (bVar.nCe - bVar.nCi))));
            bVar.nCl = (int) Math.ceil((double) (0.4f * ((float) (bVar.nCf - bVar.nCj))));
            bVar.nCm = (int) Math.ceil((double) (0.6f * ((float) (bVar.nCf - bVar.nCj))));
            bVar.nCn = (int) (((float) bVar.nCz) * f5);
            bVar.nCo = (int) (((float) bVar.nCA) * f5);
            bVar.nCp = (int) (((float) bVar.nCB) * f5);
            AppMethodBeat.o(219500);
        }
    }

    static /* synthetic */ AppBrandPipContainerView.a a(b bVar, int i2, int i3, Point point) {
        AppMethodBeat.i(219507);
        if (bVar.nCd == null) {
            bVar.nCd = new a(bVar, (byte) 0);
        }
        bVar.nCd.cEH = i2;
        bVar.nCd.cEI = i3;
        bVar.nCd.nCU = point;
        a aVar = bVar.nCd;
        AppMethodBeat.o(219507);
        return aVar;
    }
}
