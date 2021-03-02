package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.view.m;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class e implements View.OnClickListener, t {
    public static final a GHf = new a((byte) 0);
    public v GDT;
    private VideoCompositionPlayView GGK;
    private final LinkedList<b> GGL;
    public com.tencent.mm.plugin.vlog.ui.report.a GGM;
    public CropLayout.c GGN;
    public int GGO;
    private TextView GGP;
    private String GGQ;
    public Rect GGR;
    public boolean GGS;
    public final AbstractC1868e GGT;
    public AbstractC1868e GGU;
    public long GGV;
    public long GGW;
    private final aa GGX;
    private final w GGY;
    private z GGZ;
    public int GHa;
    private final n GHb;
    private long GHc;
    public MultiEditCropLayout GHd;
    public MultiEditCropOperationLayout GHe;
    boolean Gna;
    public ac GxA;
    public final RectF GyG;
    private final Context context = this.GHd.getContext();
    private int pXO;
    public final ViewGroup parent;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private long xmD;
    final RectF xmU;
    private WxCropOperationLayout.j xmW;
    private long xna;

    public interface b {
    }

    public interface c extends b {
        void a(AbstractC1868e eVar);

        void onProgress(long j2);
    }

    public interface d extends b {
        void a(ac acVar, long j2, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.e$e */
    public interface AbstractC1868e {
        void Lb(long j2);

        void pause();

        void resume();
    }

    static {
        AppMethodBeat.i(191272);
        AppMethodBeat.o(191272);
    }

    public static final class h extends q implements kotlin.g.a.b<Matrix, Boolean> {
        final /* synthetic */ boolean GHh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(boolean z) {
            super(1);
            this.GHh = z;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(191230);
            p.h(matrix, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(this.GHh);
            AppMethodBeat.o(191230);
            return valueOf;
        }
    }

    public e(MultiEditCropLayout multiEditCropLayout, MultiEditCropOperationLayout multiEditCropOperationLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(multiEditCropLayout, "layout");
        p.h(multiEditCropOperationLayout, "operationLayout");
        p.h(dVar, "status");
        AppMethodBeat.i(191271);
        this.GHd = multiEditCropLayout;
        this.GHe = multiEditCropOperationLayout;
        this.wgr = dVar;
        ViewParent parent2 = this.GHd.getParent();
        if (parent2 == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(191271);
            throw tVar;
        }
        this.parent = (ViewGroup) parent2;
        this.GyG = new RectF();
        this.GGL = new LinkedList<>();
        this.GGM = new com.tencent.mm.plugin.vlog.ui.report.a();
        this.xmD = -1;
        this.xmU = new RectF();
        this.GGP = new TextView(this.parent.getContext());
        this.GGQ = "";
        this.GGR = new Rect();
        this.xmW = WxCropOperationLayout.j.RECT_ADJUST;
        this.GGT = new l(this);
        this.GHa = -1;
        this.GHb = new n();
        MultiEditCropLayout multiEditCropLayout2 = this.GHd;
        multiEditCropLayout2.setHasBorder(false);
        multiEditCropLayout2.setEnableScale(true);
        multiEditCropLayout2.setEnableFling(true);
        multiEditCropLayout2.setEnableTouch(true);
        multiEditCropLayout2.setEnableOverScroll(false);
        this.GHd.setBackgroundColor(0);
        this.GGX = new aa(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.e.AnonymousClass1 */
            final /* synthetic */ e GHg;

            {
                this.GHg = r1;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final ViewGroup fDf() {
                AppMethodBeat.i(191219);
                ViewGroup viewGroup = this.GHg.parent;
                AppMethodBeat.o(191219);
                return viewGroup;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final CropLayout fDg() {
                return this.GHg.GHd;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final WxCropOperationLayout getOperationLayout() {
                return this.GHg.GHe;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final VideoCompositionPlayView fCU() {
                AppMethodBeat.i(191220);
                e.i(this.GHg);
                VideoCompositionPlayView videoCompositionPlayView = this.GHg.GGK;
                if (videoCompositionPlayView == null) {
                    p.hyc();
                }
                AppMethodBeat.o(191220);
                return videoCompositionPlayView;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final void fDh() {
                AppMethodBeat.i(191221);
                d.b.a(this.GHg.wgr, d.c.BVs);
                AppMethodBeat.o(191221);
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.aa
            public final TextView fDi() {
                AppMethodBeat.i(191222);
                TextView textView = this.GHg.GGP;
                AppMethodBeat.o(191222);
                return textView;
            }
        };
        this.GGY = new w(this.GGX);
        a(this.GGY);
        this.GHe.BZh = false;
        this.GHe.setVisibility(8);
        this.GHe.setBlockOutsideTouch(true);
        AppMethodBeat.o(191271);
    }

    public static final /* synthetic */ boolean a(e eVar, long j2) {
        AppMethodBeat.i(191274);
        boolean GF = eVar.GF(j2);
        AppMethodBeat.o(191274);
        return GF;
    }

    public static final /* synthetic */ void i(e eVar) {
        AppMethodBeat.i(191275);
        eVar.fDb();
        AppMethodBeat.o(191275);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191273);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191273);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class l implements AbstractC1868e {
        final /* synthetic */ e GHg;

        l(e eVar) {
            this.GHg = eVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void Lb(long j2) {
            AppMethodBeat.i(191238);
            com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
            com.tencent.mm.plugin.vlog.model.report.b.report(0);
            VideoCompositionPlayView videoCompositionPlayView = this.GHg.GGK;
            if (videoCompositionPlayView != null) {
                videoCompositionPlayView.seekTo(j2);
                AppMethodBeat.o(191238);
                return;
            }
            AppMethodBeat.o(191238);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void pause() {
            AppMethodBeat.i(191239);
            d.b.a(this.GHg.wgr, d.c.BVr);
            AppMethodBeat.o(191239);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.AbstractC1868e
        public final void resume() {
            AppMethodBeat.i(191240);
            d.b.a(this.GHg.wgr, d.c.BVs);
            AppMethodBeat.o(191240);
        }
    }

    public static /* synthetic */ void a(e eVar, boolean z, int i2) {
        AppMethodBeat.i(191242);
        if ((i2 & 2) != 0) {
            z = false;
        }
        eVar.aA(z, false);
        AppMethodBeat.o(191242);
    }

    public final void aA(boolean z, boolean z2) {
        AppMethodBeat.i(191241);
        Point az = ao.az(this.context);
        int i2 = az.x;
        int i3 = az.y;
        Size size = new Size(i2, i3);
        if (!z2 || this.GDT == null) {
            com.tencent.mm.plugin.vlog.util.a aVar = com.tencent.mm.plugin.vlog.util.a.GQC;
            float fEA = com.tencent.mm.plugin.vlog.util.a.fEA() * ((float) i2);
            float f2 = 0.5625f * ((float) i2);
            int aG = com.tencent.mm.cb.a.aG(this.context, R.dimen.bx);
            int aG2 = com.tencent.mm.cb.a.aG(this.context, R.dimen.c4);
            if (z) {
                aG2 = com.tencent.mm.cb.a.fromDPToPix(this.context, (int) TbsListener.ErrorCode.EXCEED_INCR_UPDATE) + com.tencent.mm.cb.a.aG(this.context, R.dimen.ce);
            }
            int aD = (((ao.az(this.context).y - aG) - aG2) + 0) - au.aD(this.context);
            Log.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + fEA + " ,validHeight:" + aD);
            float min = Math.min(fEA, ((float) aD) * 1.0f);
            this.GHe.setLimitMaxHeight(min);
            this.GHe.setLimitMinHeight(f2);
            this.GHe.eLF();
            float f3 = 0.0f;
            if (min < fEA) {
                f3 = ((1.0f - (min / fEA)) * ((float) i2)) / 2.0f;
            }
            float f4 = ((float) aG) + ((((float) aD) - min) / 2.0f);
            this.GyG.set(f3, f4, ((float) i2) - f3, f4 + min);
        } else {
            v vVar = this.GDT;
            if (vVar == null) {
                p.hyc();
            }
            float fBk = vVar.fBk();
            float f5 = ((float) i2) / ((float) i3);
            com.tencent.mm.plugin.vlog.util.a aVar2 = com.tencent.mm.plugin.vlog.util.a.GQC;
            float fEB = 0.01f + (1.0f / com.tencent.mm.plugin.vlog.util.a.fEB());
            com.tencent.mm.plugin.vlog.util.a aVar3 = com.tencent.mm.plugin.vlog.util.a.GQC;
            float fEA2 = 1.0f / com.tencent.mm.plugin.vlog.util.a.fEA();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
            p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            boolean isDisablePostHalfScreen = ((aj) ah).isDisablePostHalfScreen();
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(aj.class);
            p.g(ah2, "MMKernel.plugin(IPluginFinder::class.java)");
            boolean isAllowEditFillingFullScreen = ((aj) ah2).isAllowEditFillingFullScreen();
            Log.i("MicroMsg.EditMultiPreviewPlugin", "updateValidArea, isDisablePostHalfScreen:" + isDisablePostHalfScreen + ", isAllowEditFillingFullScreen:" + isAllowEditFillingFullScreen);
            RectF rectF = new RectF();
            this.GHe.setVisibility(8);
            if (fBk <= f5) {
                v vVar2 = this.GDT;
                if (vVar2 == null) {
                    p.hyc();
                }
                vVar2.a(true, size);
                float f6 = ((float) i2) / fEA2;
                float f7 = (((float) i3) - f6) / 2.0f;
                rectF.set(0.0f, f7, (float) i2, f6 + f7);
                this.GyG.set(0.0f, 0.0f, (float) i2, (float) i3);
                this.GHe.GQm = false;
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar = this.wgr;
                d.c cVar = d.c.BVA;
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_1_INT", isDisablePostHalfScreen ? 3 : 1);
                x xVar = x.SXb;
                dVar.a(cVar, bundle);
            } else if (fBk <= fEB) {
                if (isAllowEditFillingFullScreen) {
                    v vVar3 = this.GDT;
                    if (vVar3 == null) {
                        p.hyc();
                    }
                    vVar3.a(false, size);
                } else {
                    v vVar4 = this.GDT;
                    if (vVar4 == null) {
                        p.hyc();
                    }
                    vVar4.a(true, size);
                }
                float f8 = ((float) i2) / fEA2;
                float f9 = (((float) i3) - f8) / 2.0f;
                rectF.set(0.0f, f9, (float) i2, f8 + f9);
                if (isAllowEditFillingFullScreen) {
                    this.GyG.set(0.0f, 0.0f, (float) i2, (float) i3);
                } else {
                    RectF rectF2 = this.GyG;
                    v vVar5 = this.GDT;
                    if (vVar5 == null) {
                        p.hyc();
                    }
                    rectF2.set(vVar5.fBl());
                }
                this.GHe.GQm = false;
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar2 = this.wgr;
                d.c cVar2 = d.c.BVA;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("PARAM_1_INT", isDisablePostHalfScreen ? 3 : 1);
                x xVar2 = x.SXb;
                dVar2.a(cVar2, bundle2);
            } else if (fBk <= fEA2) {
                v vVar6 = this.GDT;
                if (vVar6 == null) {
                    p.hyc();
                }
                vVar6.a(true, size);
                float f10 = ((float) i2) / fEA2;
                float f11 = (((float) i3) - f10) / 2.0f;
                rectF.set(0.0f, f11, (float) i2, f10 + f11);
                RectF rectF3 = this.GyG;
                v vVar7 = this.GDT;
                if (vVar7 == null) {
                    p.hyc();
                }
                rectF3.set(vVar7.fBl());
                this.GHe.GQm = false;
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar3 = this.wgr;
                d.c cVar3 = d.c.BVA;
                Bundle bundle3 = new Bundle();
                bundle3.putInt("PARAM_1_INT", isDisablePostHalfScreen ? 3 : 1);
                x xVar3 = x.SXb;
                dVar3.a(cVar3, bundle3);
            } else if (fBk <= 1.7777778f) {
                v vVar8 = this.GDT;
                if (vVar8 == null) {
                    p.hyc();
                }
                vVar8.a(true, size);
                v vVar9 = this.GDT;
                if (vVar9 == null) {
                    p.hyc();
                }
                rectF.set(vVar9.fBl());
                RectF rectF4 = this.GyG;
                v vVar10 = this.GDT;
                if (vVar10 == null) {
                    p.hyc();
                }
                rectF4.set(vVar10.fBl());
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar4 = this.wgr;
                d.c cVar4 = d.c.BVA;
                Bundle bundle4 = new Bundle();
                bundle4.putInt("PARAM_1_INT", 3);
                x xVar4 = x.SXb;
                dVar4.a(cVar4, bundle4);
            } else {
                v vVar11 = this.GDT;
                if (vVar11 == null) {
                    p.hyc();
                }
                vVar11.a(true, size);
                v vVar12 = this.GDT;
                if (vVar12 == null) {
                    p.hyc();
                }
                Rect fBl = vVar12.fBl();
                float height = ((float) fBl.height()) * 1.7777778f;
                int i4 = fBl.top;
                int i5 = fBl.bottom;
                float centerX = ((float) fBl.centerX()) - (height / 2.0f);
                rectF.set(centerX, (float) i4, height + centerX, (float) i5);
                this.GyG.set(fBl);
                ViewGroup viewGroup = this.parent;
                if (!(viewGroup instanceof CropOperationContainer)) {
                    viewGroup = null;
                }
                CropOperationContainer cropOperationContainer = (CropOperationContainer) viewGroup;
                if (cropOperationContainer != null) {
                    cropOperationContainer.setEditorItemFirstTouch(true);
                    x xVar5 = x.SXb;
                }
                this.GHe.setVisibility(0);
                this.GHe.GQm = true;
                com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar5 = this.wgr;
                d.c cVar5 = d.c.BVA;
                Bundle bundle5 = new Bundle();
                bundle5.putInt("PARAM_1_INT", 4);
                x xVar6 = x.SXb;
                dVar5.a(cVar5, bundle5);
            }
            this.GHd.setEnableTouch(true);
            this.GHd.setEnableScale(false);
            this.GHd.setEnableFling(false);
            this.GHd.setEnableScroll(false);
            this.GHe.setLimitMaxHeight(rectF.height());
            this.GHe.setLimitMinHeight(rectF.height());
            this.GHe.getVisibilityRect().set(rectF);
            this.GHe.getMaxVisibilityRect().set(this.GyG);
            this.GHe.postInvalidate();
            this.GHe.BZh = true;
            rectF.round(this.GGR);
            this.GGR.offset(-((int) this.GyG.left), -((int) this.GyG.top));
            v vVar13 = this.GDT;
            if (vVar13 == null) {
                p.hyc();
            }
            vVar13.g(this.GyG);
            CropLayout.a(this.GHd, rectF);
            fCT();
        }
        this.GGY.i(this.GyG);
        v vVar14 = this.GDT;
        if (vVar14 != null) {
            vVar14.jr((int) this.GyG.width(), (int) this.GyG.height());
            x xVar7 = x.SXb;
            AppMethodBeat.o(191241);
            return;
        }
        AppMethodBeat.o(191241);
    }

    private void fCT() {
        this.Gna = true;
        this.GHd.Gna = true;
        this.GHe.Gna = true;
        this.GGY.Gna = true;
    }

    public final void h(RectF rectF) {
        AppMethodBeat.i(191243);
        p.h(rectF, "rect");
        this.GGY.h(rectF);
        this.xmU.set(rectF);
        if (!this.Gna) {
            this.GHe.getVisibilityRect().set(rectF);
            this.GHe.postInvalidate();
            this.GHe.setVisibility(0);
        }
        AppMethodBeat.o(191243);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(191244);
        p.h(bVar, "callback");
        if (!this.GGL.contains(bVar)) {
            this.GGL.add(bVar);
        }
        AppMethodBeat.o(191244);
    }

    public final VideoCompositionPlayView fCU() {
        AppMethodBeat.i(191245);
        fDb();
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView == null) {
            p.hyc();
        }
        AppMethodBeat.o(191245);
        return videoCompositionPlayView;
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(191246);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.at(j2, j3);
            AppMethodBeat.o(191246);
            return;
        }
        AppMethodBeat.o(191246);
    }

    public final com.tencent.mm.plugin.vlog.model.j a(m mVar, String str) {
        ad adVar;
        long j2;
        LinkedList<ad> linkedList;
        T t;
        AppMethodBeat.i(191247);
        p.h(mVar, "drawingView");
        p.h(str, "mediaPath");
        this.GGZ = null;
        v vVar = this.GDT;
        if (vVar == null || (linkedList = vVar.Gyx) == null) {
            adVar = null;
        } else {
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (p.j(next.path, str)) {
                    t = next;
                    break;
                }
            }
            adVar = t;
        }
        this.GGQ = str;
        if (adVar != null) {
            j2 = (long) adVar.id;
        } else {
            j2 = 0;
        }
        if (adVar == null) {
            com.tencent.mm.plugin.vlog.model.j aUk = aUk(str);
            AppMethodBeat.o(191247);
            return aUk;
        }
        this.xmD = j2;
        this.pXO = 1;
        Log.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
        this.GHd.De(true);
        if (!this.Gna) {
            this.GHd.setEnableScale(true);
        }
        WxCropOperationLayout.a(this.GHe);
        int i2 = adVar.Gzu;
        int i3 = adVar.Gzv;
        this.GHd.getVisibilityRect().set(this.xmU);
        if (!this.Gna) {
            this.GHe.getVisibilityRect().set(this.xmU);
        }
        if (0 == this.xna) {
            this.xna = j2;
        }
        if (GF(j2)) {
            this.GHe.setStyle(this.xmW);
        } else {
            this.GHe.setStyle(WxCropOperationLayout.j.RECT_HARD);
        }
        this.GHd.setMaxScaleValue(adVar.Gzx.aXt);
        this.GHd.setMinScaleValue(adVar.Gzx.aXu);
        this.GHd.a(mVar, i2, i3, adVar.Gzx.gT, CropLayout.e.CENTER_CROP, new h(this.GHd.getContentRect().isEmpty()));
        if (adVar.Gzx.xnf > 0.0f) {
            com.tencent.mm.bt.b presenter = mVar.getPresenter();
            p.g(presenter, "drawingView.presenter");
            presenter.setInitScale(1.0f / adVar.Gzx.xnf);
        }
        this.GHe.setOnOperationCallback(new i(this, j2, adVar));
        this.GHd.setOnChangeListener(new j(this, adVar, mVar));
        this.GHd.setClickListener(this);
        if (!this.Gna) {
            this.GHe.setVisibility(0);
        }
        fCY();
        fCZ();
        com.tencent.mm.plugin.vlog.model.j jVar = adVar.Gzx;
        AppMethodBeat.o(191247);
        return jVar;
    }

    public static final class i implements WxCropOperationLayout.i {
        final /* synthetic */ ad GAL;
        final /* synthetic */ e GHg;
        private boolean GHi = true;
        final /* synthetic */ long xnk;

        i(e eVar, long j2, ad adVar) {
            this.GHg = eVar;
            this.xnk = j2;
            this.GAL = adVar;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pA(boolean z) {
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void e(RectF rectF) {
            LinkedList<ad> linkedList;
            float centerY;
            float f2;
            float f3;
            AppMethodBeat.i(191231);
            p.h(rectF, "rectF");
            if (e.a(this.GHg, this.xnk)) {
                this.GHg.xmU.set(rectF);
            }
            v vVar = this.GHg.GDT;
            if (!(vVar == null || (linkedList = vVar.Gyx) == null)) {
                for (T t : linkedList) {
                    com.tencent.mm.plugin.vlog.model.j jVar = t.Gzx;
                    rectF.round(jVar.iiw);
                    if (!p.j(this.GAL, t) && !this.GHg.Gna) {
                        int i2 = jVar.iiw.bottom - jVar.rwL.bottom;
                        int i3 = jVar.iiw.top - jVar.rwL.top;
                        if (i2 > 0 || i3 < 0) {
                            Matrix matrix = new Matrix();
                            RectF rectF2 = new RectF(jVar.rwL);
                            float height = rectF.height() / rectF2.height();
                            if (height < 1.0f) {
                                if (i3 < 0) {
                                    f3 = (float) i3;
                                } else {
                                    f3 = (float) i2;
                                }
                                f2 = 1.0f;
                                centerY = f3;
                            } else {
                                centerY = rectF.centerY() - rectF2.centerY();
                                f2 = height;
                            }
                            matrix.postTranslate(0.0f, centerY);
                            matrix.postScale(f2, f2, rectF.centerX(), rectF.centerY());
                            matrix.mapRect(rectF2);
                            rectF2.round(jVar.rwL);
                            jVar.gT.postConcat(matrix);
                        }
                    }
                }
            }
            this.GHg.GHd.b(rectF, false);
            CropLayout.c cVar = this.GHg.GGN;
            if (cVar != null) {
                cVar.onChange();
            }
            if (!this.GHi) {
                this.GHg.GGO++;
            }
            this.GHi = true;
            AppMethodBeat.o(191231);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pz(boolean z) {
            this.GHi = false;
        }
    }

    public static final class j implements CropLayout.d {
        private float CIE = 1.0f;
        final /* synthetic */ ad GAL;
        final /* synthetic */ e GHg;
        final /* synthetic */ m GHj;

        j(e eVar, ad adVar, m mVar) {
            this.GHg = eVar;
            this.GAL = adVar;
            this.GHj = mVar;
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.c
        public final void onChange() {
            AppMethodBeat.i(191232);
            if (this.GAL.Gzx.getScale() > 0.0f) {
                com.tencent.mm.bt.b presenter = this.GHj.getPresenter();
                p.g(presenter, "drawingView.presenter");
                presenter.setInitScale(1.0f / this.GAL.Gzx.getScale());
            }
            if (!this.GHg.Gna) {
                this.GAL.Gzx.rwL.set(this.GHg.GHd.getContentRect());
            }
            AppMethodBeat.o(191232);
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.d
        public final void fDj() {
            AppMethodBeat.i(191233);
            this.CIE = com.tencent.mm.plugin.vlog.model.t.e(this.GAL.Gzx.gT);
            AppMethodBeat.o(191233);
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.d
        public final void fDk() {
            AppMethodBeat.i(191234);
            ad adVar = this.GAL;
            if (this.CIE != com.tencent.mm.plugin.vlog.model.t.e(adVar.Gzx.gT)) {
                adVar.Gzz.scaleCount++;
                AppMethodBeat.o(191234);
                return;
            }
            adVar.Gzz.dragCount++;
            AppMethodBeat.o(191234);
        }
    }

    public final void stopPreview() {
        AppMethodBeat.i(191248);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.stop();
            AppMethodBeat.o(191248);
            return;
        }
        AppMethodBeat.o(191248);
    }

    public final void fCV() {
        AppMethodBeat.i(191249);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.pause();
            AppMethodBeat.o(191249);
            return;
        }
        AppMethodBeat.o(191249);
    }

    public final void fCW() {
        AppMethodBeat.i(191250);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.setVisibility(8);
            AppMethodBeat.o(191250);
            return;
        }
        AppMethodBeat.o(191250);
    }

    public final void fCX() {
        AppMethodBeat.i(191251);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.setVisibility(0);
            AppMethodBeat.o(191251);
            return;
        }
        AppMethodBeat.o(191251);
    }

    public final void setMuteOrigin(boolean z) {
        AppMethodBeat.i(191252);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.DB(z);
            AppMethodBeat.o(191252);
            return;
        }
        AppMethodBeat.o(191252);
    }

    public final void bLe() {
        AppMethodBeat.i(191253);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.bLe();
            AppMethodBeat.o(191253);
            return;
        }
        AppMethodBeat.o(191253);
    }

    public final void wE(boolean z) {
        AppMethodBeat.i(191254);
        a(this, z, true, 0, 12);
        AppMethodBeat.o(191254);
    }

    public static /* synthetic */ void a(e eVar, boolean z, boolean z2, long j2, int i2) {
        AppMethodBeat.i(191256);
        eVar.a((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, false, (i2 & 8) != 0 ? -1 : j2);
        AppMethodBeat.o(191256);
    }

    public final void a(boolean z, boolean z2, boolean z3, long j2) {
        AbstractC1868e eVar;
        CropLayout.c cVar = null;
        AppMethodBeat.i(191255);
        Log.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + z2 + ", seekToOriginPosition:" + z3 + ", seekTo:" + j2);
        this.pXO = 2;
        this.GGQ = "";
        fDb();
        this.xmD = -1;
        v vVar = this.GDT;
        this.GxA = vVar != null ? vVar.GxA : null;
        ac acVar = this.GxA;
        if (acVar != null) {
            acVar.wB(!z);
        }
        ac acVar2 = this.GxA;
        if (acVar2 != null) {
            for (T t : this.GGL) {
                if (t instanceof d) {
                    t.a(acVar2, j2, z3);
                }
            }
        }
        z zVar = this.GGZ;
        if (zVar != null) {
            zVar.wH(false);
        }
        this.GGZ = this.GGY;
        v vVar2 = this.GDT;
        if (vVar2 != null) {
            Size fBn = vVar2.fBn();
            z zVar2 = this.GGZ;
            if (zVar2 != null) {
                zVar2.a(fBn);
            }
        }
        this.GGY.GGU = this.GGU;
        z zVar3 = this.GGZ;
        if (zVar3 != null) {
            zVar3.wH(true);
        }
        this.GHe.setOnOperationCallback(new k(this));
        this.GHd.setClickListener(this);
        MultiEditCropLayout multiEditCropLayout = this.GHd;
        z zVar4 = this.GGZ;
        if (zVar4 != null) {
            cVar = zVar4.fDH();
        }
        multiEditCropLayout.setOnChangeListener(cVar);
        ac acVar3 = this.GxA;
        if (acVar3 != null) {
            acVar3.acz(this.GHa);
        }
        z zVar5 = this.GGZ;
        if (zVar5 != null) {
            ac acVar4 = this.GxA;
            if (acVar4 == null) {
                p.hyc();
            }
            zVar5.a(acVar4, z2, z3, j2);
        }
        if (!this.Gna) {
            this.GHe.setVisibility(0);
        }
        if (z2 && (eVar = this.GGU) != null) {
            eVar.resume();
        }
        fCY();
        AppMethodBeat.o(191255);
    }

    public static final class k implements WxCropOperationLayout.i {
        final /* synthetic */ e GHg;
        private boolean GHi = true;

        k(e eVar) {
            this.GHg = eVar;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void e(RectF rectF) {
            WxCropOperationLayout.i fDI;
            AppMethodBeat.i(191235);
            p.h(rectF, "rectF");
            z zVar = this.GHg.GGZ;
            if (!(zVar == null || (fDI = zVar.fDI()) == null)) {
                fDI.e(rectF);
            }
            CropLayout.c cVar = this.GHg.GGN;
            if (cVar != null) {
                cVar.onChange();
            }
            if (!this.GHi) {
                this.GHg.GGO++;
            }
            this.GHi = true;
            AppMethodBeat.o(191235);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pz(boolean z) {
            WxCropOperationLayout.i fDI;
            AppMethodBeat.i(191236);
            z zVar = this.GHg.GGZ;
            if (!(zVar == null || (fDI = zVar.fDI()) == null)) {
                fDI.pz(z);
            }
            this.GHi = false;
            AppMethodBeat.o(191236);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pA(boolean z) {
            WxCropOperationLayout.i fDI;
            AppMethodBeat.i(191237);
            z zVar = this.GHg.GGZ;
            if (zVar == null || (fDI = zVar.fDI()) == null) {
                AppMethodBeat.o(191237);
                return;
            }
            fDI.pA(z);
            AppMethodBeat.o(191237);
        }
    }

    private final void fCY() {
        AppMethodBeat.i(191257);
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b bVar = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
        if (com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.fEc() && (!p.j(this.GGP.getParent(), this.parent))) {
            this.GGP.setTextColor(-65536);
            Context context2 = this.parent.getContext();
            p.g(context2, "parent.context");
            int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.cb);
            this.GGP.setTextSize((float) dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ((int) this.GyG.top) + dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            this.parent.addView(this.GGP, 1, layoutParams);
        }
        AppMethodBeat.o(191257);
    }

    public final void fCZ() {
        AppMethodBeat.i(191258);
        z zVar = this.GGZ;
        if (zVar != null) {
            zVar.fDK();
            AppMethodBeat.o(191258);
            return;
        }
        e eVar = this;
        if (eVar.GGQ.length() > 0) {
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            int aUc = com.tencent.mm.plugin.vlog.model.local.a.aUc(eVar.GGQ);
            TextView textView = eVar.GGP;
            com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b bVar = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
            textView.setText(com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(aUc));
        }
        AppMethodBeat.o(191258);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(191259);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        d.b.a(this.wgr, d.c.BWv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191259);
    }

    public final Rect fDa() {
        AppMethodBeat.i(191260);
        z zVar = this.GGZ;
        Rect fDa = zVar != null ? zVar.fDa() : null;
        if (fDa != null) {
            AppMethodBeat.o(191260);
            return fDa;
        }
        Rect contentRect = this.GHd.getContentRect();
        RectF visibilityRect = this.GHd.getVisibilityRect();
        Rect rect = new Rect();
        visibilityRect.round(rect);
        Rect a2 = a(contentRect, this.GHd.getContentOriginalRect(), rect);
        AppMethodBeat.o(191260);
        return a2;
    }

    private static Rect a(Rect rect, Rect rect2, Rect rect3) {
        AppMethodBeat.i(191261);
        float width = (1.0f * ((float) rect.width())) / ((float) rect2.width());
        int i2 = rect3.left - rect.left;
        int i3 = rect3.top - rect.top;
        Rect rect4 = new Rect((int) (((float) i2) / width), (int) (((float) i3) / width), (int) (((float) (rect3.width() + i2)) / width), (int) (((float) (rect3.height() + i3)) / width));
        AppMethodBeat.o(191261);
        return rect4;
    }

    private final void fDb() {
        AppMethodBeat.i(191262);
        if (this.GGK == null) {
            this.GGK = new VideoCompositionPlayView(this.context);
            VideoCompositionPlayView videoCompositionPlayView = this.GGK;
            if (videoCompositionPlayView != null) {
                videoCompositionPlayView.setPlayerCallback(new f(this));
            }
            VideoCompositionPlayView videoCompositionPlayView2 = this.GGK;
            if (videoCompositionPlayView2 != null) {
                videoCompositionPlayView2.setPlayerProfileCallback(new g(this));
                AppMethodBeat.o(191262);
                return;
            }
        }
        AppMethodBeat.o(191262);
    }

    public static final class f implements a.C2159a.b {
        final /* synthetic */ e GHg;

        f(e eVar) {
            this.GHg = eVar;
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dER() {
            long playStart;
            AppMethodBeat.i(191223);
            for (b bVar : this.GHg.GGL) {
                if (bVar instanceof c) {
                    ((c) bVar).a(this.GHg.GGT);
                }
            }
            VideoCompositionPlayView videoCompositionPlayView = this.GHg.GGK;
            if (videoCompositionPlayView != null) {
                playStart = videoCompositionPlayView.getPosition();
            } else {
                ac acVar = this.GHg.GxA;
                playStart = 0 - ((acVar != null ? acVar.Gez.getPlayStart() : 0) / 1000);
            }
            AbstractC1868e eVar = this.GHg.GGU;
            if (eVar != null) {
                eVar.Lb(playStart + this.GHg.GGV);
                AppMethodBeat.o(191223);
                return;
            }
            AppMethodBeat.o(191223);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dES() {
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dET() {
            AppMethodBeat.i(191224);
            Iterator it = this.GHg.GGL.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(191224);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void Go(long j2) {
            AppMethodBeat.i(191225);
            Log.d("MicroMsg.EditMultiPreviewPlugin", "onPlayProgress timeMs:".concat(String.valueOf(j2)));
            for (b bVar : this.GHg.GGL) {
                if (bVar instanceof c) {
                    ((c) bVar).onProgress(j2);
                }
            }
            AppMethodBeat.o(191225);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEU() {
            AppMethodBeat.i(191226);
            VideoCompositionPlayView videoCompositionPlayView = this.GHg.GGK;
            if (videoCompositionPlayView == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(191226);
                throw tVar;
            }
            videoCompositionPlayView.setAlpha(1.0f);
            d.b.a(this.GHg.wgr, d.c.BVx);
            AppMethodBeat.o(191226);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.b
        public final void dEW() {
            AppMethodBeat.i(191227);
            VideoCompositionPlayView videoCompositionPlayView = this.GHg.GGK;
            if (videoCompositionPlayView == null) {
                AppMethodBeat.o(191227);
            } else if (!videoCompositionPlayView.isPlaying()) {
                AppMethodBeat.o(191227);
            } else {
                if (this.GHg.GHc == 0) {
                    this.GHg.GHc = Util.currentTicks();
                }
                n nVar = this.GHg.GHb;
                if (nVar.jkM == 0) {
                    nVar.jkM = Util.currentTicks();
                } else {
                    nVar.frames++;
                }
                if (Util.ticksToNow(this.GHg.GHc) >= 1000) {
                    Log.d("MicroMsg.EditMultiPreviewPlugin", "onFrame: fps " + this.GHg.GHb.getFps());
                    com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
                    int fps = this.GHg.GHb.getFps();
                    if (fps > 60) {
                        com.tencent.mm.plugin.vlog.model.report.b.report(21);
                    } else if (fps > 40) {
                        com.tencent.mm.plugin.vlog.model.report.b.report(22);
                    } else if (fps > 30) {
                        com.tencent.mm.plugin.vlog.model.report.b.report(23);
                    } else if (fps > 20) {
                        com.tencent.mm.plugin.vlog.model.report.b.report(24);
                    } else if (fps > 10) {
                        com.tencent.mm.plugin.vlog.model.report.b.report(25);
                    } else {
                        com.tencent.mm.plugin.vlog.model.report.b.report(26);
                    }
                    this.GHg.GHc = 0;
                    this.GHg.GHb.reset();
                }
                AppMethodBeat.o(191227);
            }
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.AbstractC2160a
        public final void dEV() {
        }
    }

    public static final class g implements a.C2159a.c {
        final /* synthetic */ e GHg;

        g(e eVar) {
            this.GHg = eVar;
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.c
        public final void Lc(long j2) {
            AppMethodBeat.i(191228);
            Log.d("MicroMsg.EditMultiPreviewPlugin", "onUpdateComposition: ".concat(String.valueOf(j2)));
            com.tencent.mm.plugin.vlog.ui.report.a aVar = this.GHg.GGM;
            if (aVar.GOC.size() < aVar.GOA) {
                aVar.GOC.add(Long.valueOf(j2));
            }
            com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
            com.tencent.mm.plugin.vlog.model.report.b.report(11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1468, 12, j2);
            AppMethodBeat.o(191228);
        }

        @Override // com.tencent.mm.videocomposition.play.a.C2159a.c
        public final void Ld(long j2) {
            AppMethodBeat.i(191229);
            Log.d("MicroMsg.EditMultiPreviewPlugin", "onSeek: ".concat(String.valueOf(j2)));
            com.tencent.mm.plugin.vlog.ui.report.a aVar = this.GHg.GGM;
            if (aVar.GOB.size() < aVar.GOA) {
                aVar.GOB.add(Long.valueOf(j2));
            }
            com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
            com.tencent.mm.plugin.vlog.model.report.b.report(1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1468, 2, j2);
            if (j2 <= 30) {
                com.tencent.mm.plugin.vlog.model.report.b.report(4);
                AppMethodBeat.o(191229);
            } else if (j2 <= 100) {
                com.tencent.mm.plugin.vlog.model.report.b.report(5);
                AppMethodBeat.o(191229);
            } else if (j2 <= 500) {
                com.tencent.mm.plugin.vlog.model.report.b.report(6);
                AppMethodBeat.o(191229);
            } else if (j2 <= 1000) {
                com.tencent.mm.plugin.vlog.model.report.b.report(7);
                AppMethodBeat.o(191229);
            } else {
                com.tencent.mm.plugin.vlog.model.report.b.report(8);
                AppMethodBeat.o(191229);
            }
        }
    }

    private final boolean GF(long j2) {
        return this.xna == j2 || this.xna == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r0 != null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.vlog.model.j aUk(java.lang.String r5) {
        /*
            r4 = this;
            r3 = 191263(0x2eb1f, float:2.68017E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.lang.String r0 = "path"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.mm.plugin.vlog.model.v r0 = r4.GDT
            if (r0 == 0) goto L_0x003a
            java.util.LinkedList<com.tencent.mm.plugin.vlog.model.ad> r0 = r0.Gyx
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x003a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r2 = r0.iterator()
        L_0x001c:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r1 = r2.next()
            r0 = r1
            com.tencent.mm.plugin.vlog.model.ad r0 = (com.tencent.mm.plugin.vlog.model.ad) r0
            java.lang.String r0 = r0.path
            boolean r0 = kotlin.g.b.p.j(r0, r5)
            if (r0 == 0) goto L_0x001c
            r0 = r1
        L_0x0032:
            com.tencent.mm.plugin.vlog.model.ad r0 = (com.tencent.mm.plugin.vlog.model.ad) r0
            if (r0 == 0) goto L_0x003a
            com.tencent.mm.plugin.vlog.model.j r0 = r0.Gzx
            if (r0 != 0) goto L_0x003f
        L_0x003a:
            com.tencent.mm.plugin.vlog.model.j r0 = new com.tencent.mm.plugin.vlog.model.j
            r0.<init>()
        L_0x003f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        L_0x0043:
            r0 = 0
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.e.aUk(java.lang.String):com.tencent.mm.plugin.vlog.model.j");
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(191264);
        this.xna = 0;
        this.GHd.De(true);
        AppMethodBeat.o(191264);
    }

    public final void seek(long j2) {
        AppMethodBeat.i(191265);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.seekTo(j2);
        }
        com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
        com.tencent.mm.plugin.vlog.model.report.b.report(0);
        AppMethodBeat.o(191265);
    }

    public final void fDc() {
        VideoCompositionPlayView videoCompositionPlayView;
        AppMethodBeat.i(191266);
        if (!(this.GGK == null || (videoCompositionPlayView = this.GGK) == null)) {
            videoCompositionPlayView.resume();
        }
        this.GHb.reset();
        this.GHc = 0;
        AppMethodBeat.o(191266);
    }

    public final void fDd() {
        VideoCompositionPlayView videoCompositionPlayView;
        AppMethodBeat.i(191267);
        if (this.GGK == null || (videoCompositionPlayView = this.GGK) == null) {
            AppMethodBeat.o(191267);
            return;
        }
        videoCompositionPlayView.pause();
        AppMethodBeat.o(191267);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(191268);
        VideoCompositionPlayView videoCompositionPlayView = this.GGK;
        if (videoCompositionPlayView != null) {
            videoCompositionPlayView.setAlpha(0.0f);
            AppMethodBeat.o(191268);
            return;
        }
        AppMethodBeat.o(191268);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191269);
        fDe();
        this.GGL.clear();
        AppMethodBeat.o(191269);
    }

    public final void fDe() {
        AppMethodBeat.i(191270);
        if (this.GGK != null) {
            VideoCompositionPlayView videoCompositionPlayView = this.GGK;
            if (videoCompositionPlayView != null) {
                videoCompositionPlayView.release();
            }
            this.GGK = null;
        }
        AppMethodBeat.o(191270);
    }
}
