package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.item.e;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.List;

public final class c extends a {
    k EBv;
    private View.OnClickListener EVA = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(176409);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
            try {
                c.this.Dyw.FaQ.onClick(view);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick, exp=" + e2.toString());
            }
            if (c.this.EVs) {
                SnsAdCardVideoEndView.i(c.this.DsC, 2);
            }
            a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(176409);
        }
    };
    protected SnsAdTouchProgressView.a EVB = new SnsAdTouchProgressView.a() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onStart() {
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onCancel() {
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onClick(View view) {
            AppMethodBeat.i(203891);
            try {
                Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
                c.this.EUK.Ewr.performClick();
                AppMethodBeat.o(203891);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + e2.toString());
                AppMethodBeat.o(203891);
            }
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onFinish() {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(203892);
            Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
            try {
                c.this.Dyw.a(c.this, (Bundle) null);
                r.e(new long[]{20, 100});
                if (c.this.context instanceof SnsCommentDetailUI) {
                    i3 = ((SnsCommentDetailUI) c.this.context).getSource();
                }
                if (i3 == 2) {
                    i2 = 16;
                } else {
                    i2 = 2;
                }
                e.a(c.this.context, c.this.contentView, c.this.DsC, i2);
                SnsAdClick snsAdClick = new SnsAdClick(1, 2, r.aOw(c.this.DsC.getTimeLine().Id), 28, 21);
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, c.this.DsC, 28);
                r.a(snsAdClick);
                AppMethodBeat.o(203892);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + e2.toString());
                AppMethodBeat.o(203892);
            }
        }
    };
    protected TwistCoverView.a EVC = new TwistCoverView.a() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a
        public final void eYQ() {
            int i2;
            int i3;
            AppMethodBeat.i(203889);
            if (c.this.context instanceof SnsCommentDetailUI) {
                i2 = ((SnsCommentDetailUI) c.this.context).getSource();
            } else {
                i2 = 1;
            }
            if (i2 == 2) {
                i3 = 16;
            } else {
                i3 = 2;
            }
            if (c.this.DsC == null) {
                AppMethodBeat.o(203889);
                return;
            }
            ADXml.k kVar = c.this.DsC.getAdXml().adTwistInfo;
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromTwist", true);
            if (kVar != null) {
                bundle.putBoolean("isSimpleTwistAnim", kVar.DWW);
                bundle.putBoolean("isTwistClockwise", kVar.DWV);
                if (kVar.DWW) {
                    r.e(new long[]{0, 80});
                }
            }
            c.this.Dyw.a(c.this, bundle);
            e.a(c.this.context, c.this.contentView, c.this.DsC, i3);
            try {
                SnsAdClick snsAdClick = new SnsAdClick(1, 2, r.aOw(c.this.DsC.getTimeLine().Id), 29, 21);
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, c.this.DsC, 29);
                r.a(snsAdClick);
                Log.i("MicroMsg.FullCardAdDetailItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
                AppMethodBeat.o(203889);
            } catch (Throwable th) {
                Log.e("MicroMsg.FullCardAdDetailItem", "twist click report exp=" + th.toString());
                AppMethodBeat.o(203889);
            }
        }
    };
    private boolean EVf = false;
    public View EVh;
    private TextView EVi;
    private TextView EVj;
    private TextView EVk;
    public View EVl;
    public MaskImageView EVm;
    SnsDrawGestureView EVn;
    ADXml.g EVo;
    ImageView EVp;
    ImageView EVq;
    SnsAdCardVideoEndView EVr;
    boolean EVs = false;
    private SnsAdSphereAnimView EVt;
    ba EVu;
    private boolean EVv = false;
    private boolean EVw = false;
    boolean EVx = false;
    public TwistCoverView EVy;
    private View.OnClickListener EVz = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(176408);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
            try {
                c.this.Dyw.Fbd.onClick(view);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick, exp=" + e2.toString());
            }
            if (c.this.EVs) {
                SnsAdCardVideoEndView.i(c.this.DsC, 2);
            }
            a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(176408);
        }
    };
    public View ExX;
    Context context;
    boolean mIsPaused = false;
    private TextView uXS;
    public View wnX;

    public c(TimeLineObject timeLineObject, SnsInfo snsInfo, com.tencent.mm.plugin.sns.ui.d.c cVar, k kVar) {
        AppMethodBeat.i(176410);
        this.timeLineObject = timeLineObject;
        this.DsC = snsInfo;
        this.Dyw = cVar;
        this.EBv = kVar;
        AppMethodBeat.o(176410);
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void n(View view, View view2) {
        AppMethodBeat.i(100020);
        this.contentView = view;
        this.EAV = view2;
        this.context = view.getContext();
        this.ExX = view.findViewById(R.id.dbj);
        this.wnX = view.findViewById(R.id.isy);
        this.EVh = view.findViewById(R.id.aan);
        this.uXS = (TextView) view.findViewById(R.id.it0);
        this.EVi = (TextView) view.findViewById(R.id.isz);
        this.EVj = (TextView) view.findViewById(R.id.aap);
        this.EVk = (TextView) view.findViewById(R.id.aao);
        this.EVl = view.findViewById(R.id.aaw);
        this.EVm = (MaskImageView) view.findViewById(R.id.dbk);
        this.EVn = (SnsDrawGestureView) view.findViewById(R.id.hxo);
        this.EVm.setScaleType(QImageView.a.CENTER_CROP);
        this.EVp = (ImageView) view.findViewById(R.id.db6);
        this.EVq = (ImageView) view.findViewById(R.id.c3p);
        this.EVy = (TwistCoverView) view.findViewById(R.id.i1d);
        this.EVy.setTwistActionListener(this.EVC);
        this.EUK = new at();
        this.EUK.Ewu = view.findViewById(R.id.dbm);
        this.EUK.Ewr = this.EUK.Ewu;
        this.EUK.Ewu.setOnClickListener(this.EVA);
        this.EUK.Ews = (VideoSightView) this.EUK.Ewu.findViewById(R.id.dup);
        this.EUK.Ewt = (SnsAdTimelineVideoView) this.EUK.Ewu.findViewById(R.id.g3g);
        this.EUK.Ews.setMute(true);
        this.EUK.Ewt.setMute(true);
        this.EUK.EeS = (ImageView) view.findViewById(R.id.dbl);
        this.EUK.Ewv = (MMPinProgressBtn) this.EUK.Ewu.findViewById(R.id.gl7);
        this.EUK.Eww = (TextView) this.EUK.Ewu.findViewById(R.id.c3v);
        this.EUK.EeT = (TextView) this.EUK.Ewu.findViewById(R.id.c4k);
        this.EUK.Ews.Dnz = true;
        this.EUK.Ews.setScaleType(QImageView.a.CENTER_CROP);
        this.EVr = (SnsAdCardVideoEndView) view.findViewById(R.id.hxr);
        if (this.EVt == null) {
            this.EVt = (SnsAdSphereAnimView) ((ViewStub) this.lJI.findViewById(R.id.hwd)).inflate();
        } else {
            Log.e("MicroMsg.FullCardAdDetailItem", "initView many times");
        }
        this.EVt.setVisibility(8);
        this.EVv = e.fkr();
        AppMethodBeat.o(100020);
    }

    public final void d(FrameLayout frameLayout) {
        AppMethodBeat.i(203893);
        try {
            Log.i("MicroMsg.FullCardAdDetailItem", "initLongPressView");
            SnsAdTouchProgressView snsAdTouchProgressView = (SnsAdTouchProgressView) frameLayout.findViewById(R.id.hwb);
            snsAdTouchProgressView.setVisibility(8);
            this.EVu = new ba(this.context, snsAdTouchProgressView, this.EVt, this.EUK, frameLayout);
            this.EVu.EzC = this.EVB;
            AppMethodBeat.o(203893);
        } catch (Exception e2) {
            Log.e("MicroMsg.FullCardAdDetailItem", "initLongPressView exp=" + android.util.Log.getStackTraceString(e2));
            AppMethodBeat.o(203893);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void refreshView() {
        String str;
        ViewGroup.LayoutParams layoutParams;
        cnb cnb;
        boolean eVz;
        ViewGroup.LayoutParams layoutParams2;
        AppMethodBeat.i(100021);
        this.DsC = f.aQl(this.DsC.getSnsId());
        this.EVo = null;
        if (!(this.DsC == null || this.DsC.getAdXml() == null)) {
            this.EVo = this.DsC.getAdXml().adFullCardInfo;
        }
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        this.wnX.setVisibility(8);
        this.uXS.setVisibility(8);
        this.EVi.setVisibility(8);
        this.EVh.setVisibility(8);
        this.EVj.setVisibility(8);
        this.EVk.setVisibility(8);
        this.EVl.setVisibility(8);
        this.EVf = false;
        this.mIsPaused = false;
        int aG = com.tencent.mm.cb.a.aG(this.context, R.dimen.ajw);
        int aG2 = com.tencent.mm.cb.a.aG(this.context, R.dimen.bt);
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.ir);
        if (this.EVo != null) {
            int i2 = (((min - aG) - aG2) - dimensionPixelSize) - dimensionPixelSize;
            if (this.EVo.DWw == 0) {
                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                layoutParams2.width = i2;
                layoutParams2.height = (int) (((float) layoutParams2.width) * 0.75f);
            } else if (this.EVo.DWw == 1) {
                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                layoutParams2.width = i2;
                layoutParams2.height = layoutParams2.width;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                ViewGroup.LayoutParams layoutParams3 = this.contentView.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                this.contentView.setLayoutParams(layoutParams3);
                ((RoundedCornerFrameLayout) this.contentView).setRadius((float) com.tencent.mm.cb.a.fromDPToPix(this.context, 8));
                ViewGroup.LayoutParams layoutParams4 = this.EVm.getLayoutParams();
                layoutParams4.width = layoutParams2.width;
                layoutParams4.height = layoutParams2.height;
                this.EVm.setLayoutParams(layoutParams4);
                ViewGroup.LayoutParams layoutParams5 = this.EUK.Ewr.getLayoutParams();
                layoutParams5.width = layoutParams2.width;
                layoutParams5.height = layoutParams2.height;
                this.EUK.Ewr.setLayoutParams(layoutParams5);
                this.EUK.Ews.im(layoutParams2.width, layoutParams2.height);
                ViewGroup.LayoutParams layoutParams6 = this.EUK.Ewt.getLayoutParams();
                layoutParams6.width = layoutParams2.width;
                layoutParams6.height = layoutParams2.height;
                this.EUK.Ewt.setLayoutParams(layoutParams6);
                ViewGroup.LayoutParams layoutParams7 = this.EVp.getLayoutParams();
                layoutParams7.width = layoutParams2.width;
                layoutParams7.height = layoutParams2.height;
                this.EVp.setLayoutParams(layoutParams7);
                ViewGroup.LayoutParams layoutParams8 = this.EVq.getLayoutParams();
                layoutParams8.width = layoutParams2.width;
                layoutParams8.height = layoutParams2.height;
                this.EVq.setLayoutParams(layoutParams8);
                ViewGroup.LayoutParams layoutParams9 = this.EVr.getLayoutParams();
                layoutParams9.width = layoutParams2.width;
                layoutParams9.height = layoutParams2.height;
                this.EVr.setLayoutParams(layoutParams9);
            } else {
                Log.e("MicroMsg.FullCardAdDetailItem", "mediaLayout==null, snsId=" + (this.DsC == null ? "" : Long.valueOf(this.DsC.field_snsId)));
            }
            if (this.EVo.DWy == 0) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) this.EVo.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                this.wnX.setBackground(gradientDrawable);
                if (!Util.isNullOrNil(this.EVo.title) || !Util.isNullOrNil(this.EVo.description)) {
                    this.wnX.setVisibility(0);
                }
                this.EVh.setVisibility(8);
                if (!Util.isNullOrNil(this.EVo.title)) {
                    this.uXS.setVisibility(0);
                    this.uXS.setText(g.gxZ().a(this.uXS.getContext(), this.EVo.title, this.uXS.getTextSize()));
                }
                if (!Util.isNullOrNil(this.EVo.description)) {
                    this.EVi.setVisibility(0);
                    this.EVi.setText(g.gxZ().a(this.EVi.getContext(), this.EVo.description, this.EVi.getTextSize()));
                }
            } else if (this.EVo.DWy == 1) {
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.EVo.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable2.setGradientType(0);
                this.wnX.setVisibility(8);
                this.EVh.setBackground(gradientDrawable2);
                if (!Util.isNullOrNil(this.EVo.title) || !Util.isNullOrNil(this.EVo.description)) {
                    this.EVh.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.EVl.getLayoutParams();
                    layoutParams10.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 4);
                    this.EVl.setLayoutParams(layoutParams10);
                }
                if (!Util.isNullOrNil(this.EVo.title)) {
                    this.EVj.setVisibility(0);
                    this.EVj.setText(g.gxZ().a(this.EVj.getContext(), this.EVo.title, this.EVj.getTextSize()));
                }
                if (!Util.isNullOrNil(this.EVo.description)) {
                    this.EVk.setVisibility(0);
                    this.EVk.setText(g.gxZ().a(this.EVk.getContext(), this.EVo.description, this.EVk.getTextSize()));
                }
            }
            if (this.DsC.getAdInfo().isWeapp()) {
                GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) this.EVo.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable3.setGradientType(0);
                this.EVh.setVisibility(0);
                this.EVh.setBackground(gradientDrawable3);
                this.EVl.setVisibility(0);
            }
            layoutParams = layoutParams2;
        } else {
            Log.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
            String Jb = this.DsC == null ? "" : r.Jb(this.DsC.field_snsId);
            int i3 = 0;
            if (this.DsC != null) {
                int i4 = this.DsC.isFullCardAd() ? 1 : 0;
                str = this.DsC.getUxinfo();
                i3 = i4;
            } else {
                str = "";
            }
            j.b(j.DDX, Jb, 0, i3, str);
            layoutParams = null;
        }
        if (this.timeLineObject.ContentObj == null || this.timeLineObject.ContentObj.LoV.size() <= 0) {
            cnb = null;
        } else {
            cnb = this.timeLineObject.ContentObj.LoV.get(0);
        }
        this.EUK.a(this.timeLineObject, 0, this.DsC.getLocalid(), true);
        this.EUK.EeT.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g faL = aj.faL();
        if (cnb != null) {
            this.EVr.a(this.EVo.DWE, 2);
            if (this.EVr.ac(this.DsC)) {
                this.EVs = false;
            }
            if (this.EUK.Ews != null) {
                this.EUK.Ews.setIsForbidLoopAnim(this.EVo.DWE != null);
            }
            if (this.EVu != null) {
                this.EVw = this.EVu.a(this.DsC, this.EVo.DWF, new Rect(aG + aG2, aG, min - dimensionPixelSize, (layoutParams != null ? layoutParams.height : 0) + aG));
            }
            this.EVy.a(this.DsC, this.DsC.getAdXml().adTwistInfo, 2);
            if (this.DsC.isTwistAd()) {
                this.EUK.Ewt.setTimerInterval(300);
            } else {
                this.EUK.Ewt.setTimerInterval(1000);
                this.EVy.clear();
            }
            this.EVx = this.EVv || this.EVw;
            this.EUK.EwA = this.EVx;
            Log.i("MicroMsg.FullCardAdDetailItem", "refreshView, isExptUseNewPlayer=" + this.EVv + ", isLongPressGestureAd=" + this.EVw + ", hash=" + hashCode() + ", snsId=" + (this.DsC == null ? "" : Long.valueOf(this.DsC.field_snsId)));
            final long j2 = this.DsC.field_snsId;
            if (this.timeLineObject.ContentObj.LoU == 1) {
                this.EVm.setVisibility(0);
                this.EVm.setTag(this);
                this.EVm.setOnClickListener(this.EVz);
                MaskImageView maskImageView = this.EVm;
                int hashCode = this.context.hashCode();
                bp gCU = bp.gCU();
                gCU.hXs = this.timeLineObject.CreateTime;
                faL.a(cnb, maskImageView, -1, hashCode, gCU, 3);
                AppMethodBeat.o(100021);
                return;
            }
            if (this.timeLineObject.ContentObj.LoU == 15 || this.timeLineObject.ContentObj.LoU == 5) {
                if (this.EVx) {
                    com.tencent.mm.plugin.sns.ad.e.b.a(this.DsC, cnb);
                } else {
                    com.tencent.mm.plugin.sns.ad.e.b.a(cnb, false);
                }
                long nanoTime = System.nanoTime();
                boolean u = com.tencent.mm.plugin.sns.model.g.u(cnb);
                Log.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", Boolean.valueOf(u), Long.valueOf(System.nanoTime() - nanoTime));
                if (this.EVx) {
                    this.EUK.Ewt.setVisibility(0);
                    this.EUK.Ews.setVisibility(8);
                    this.EUK.Ewt.setVideoCallback(new OfflineVideoView.a() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                        public final boolean a(PString pString) {
                            AppMethodBeat.i(179334);
                            Log.i("MicroMsg.FullCardAdDetailItem", "downloadVideo");
                            AppMethodBeat.o(179334);
                            return false;
                        }

                        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                        public final void onStart(int i2) {
                            AppMethodBeat.i(179335);
                            Log.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(i2)));
                            AppMethodBeat.o(179335);
                        }

                        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                        public final void onCompletion() {
                            boolean z;
                            AppMethodBeat.i(179336);
                            Log.i("MicroMsg.FullCardAdDetailItem", "onCompletion");
                            if (c.this.EVu != null) {
                                z = c.this.EVu.fhx();
                            } else {
                                z = false;
                            }
                            if (c.this.EVo.DWE == null && !z) {
                                c.this.EUK.Ewt.restart();
                            }
                            c.this.EBv.I(j2, false);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(176407);
                                    c.this.fkm();
                                    AppMethodBeat.o(176407);
                                }
                            });
                            AppMethodBeat.o(179336);
                        }

                        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                        public final void xv(int i2) {
                            AppMethodBeat.i(179337);
                            int i3 = i2 / 1000;
                            Log.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", Integer.valueOf(i3));
                            if (c.this.EBv != null) {
                                if (c.this.DsC != null) {
                                    c.this.EBv.IT(c.this.DsC.field_snsId);
                                    c.this.EBv.ao(c.this.DsC.field_snsId, (long) i2);
                                }
                                if (!c.this.EBv.IQ(j2)) {
                                    int durationMs = c.this.EUK.Ewt.getDurationMs() / 1000;
                                    Log.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(durationMs)));
                                    c.this.EBv.c(j2, Util.currentTicks(), false);
                                    c.this.EBv.e(j2, durationMs, false);
                                    c.this.EBv.an(j2, j2);
                                }
                            }
                            c.a(c.this, c.this.EVo, c.this.DsC, i3 * 1000);
                            e.a(c.this.EVo, i3 * 1000, c.this.EVp, c.this.EVq);
                            if (c.this.DsC != null && c.this.DsC.isTwistAd()) {
                                c.this.EVy.IW((long) (i3 * 1000));
                            }
                            if (c.this.EVu != null) {
                                c.this.EVu.a(c.this.EBv, (long) i2, j2);
                            }
                            AppMethodBeat.o(179337);
                        }
                    });
                } else {
                    this.EUK.Ewt.setVisibility(8);
                    this.EUK.Ews.setVisibility(0);
                    this.EUK.Ews.setOnCompletionListener(new b.e() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.sight.decode.a.b.e
                        public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i2) {
                            AppMethodBeat.i(179341);
                            Log.i("MicroMsg.FullCardAdDetailItem", "sight play completed, retCode=" + i2 + ", snsId=" + (c.this.DsC == null ? "" : Long.valueOf(c.this.DsC.field_snsId)));
                            if (i2 != -1) {
                                c.this.EBv.I(j2, false);
                            }
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(179340);
                                    c.this.fkm();
                                    AppMethodBeat.o(179340);
                                }
                            });
                            AppMethodBeat.o(179341);
                        }
                    });
                    this.EUK.Ews.setOnDecodeDurationListener(new b.f() {
                        /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                        public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j2) {
                            AppMethodBeat.i(179342);
                            Log.d("MicroMsg.FullCardAdDetailItem", "sight play %d", Long.valueOf(j2));
                            if (c.this.EBv != null) {
                                if (c.this.DsC != null) {
                                    c.this.EBv.IT(c.this.DsC.field_snsId);
                                    c.this.EBv.ao(c.this.DsC.field_snsId, 1000 * j2);
                                }
                                if (!c.this.EBv.IQ(j2)) {
                                    int eVC = (int) bVar.eVC();
                                    Log.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(eVC)));
                                    c.this.EBv.c(j2, Util.currentTicks(), false);
                                    c.this.EBv.e(j2, eVC, false);
                                    c.this.EBv.an(j2, j2);
                                }
                            }
                            int i2 = (int) j2;
                            c.a(c.this, c.this.EVo, c.this.DsC, i2 * 1000);
                            e.a(c.this.EVo, i2 * 1000, c.this.EVp, c.this.EVq);
                            if (c.this.DsC != null && c.this.DsC.isTwistAd()) {
                                c.this.EVy.IW((long) (i2 * 1000));
                            }
                            AppMethodBeat.o(179342);
                        }
                    });
                }
                e.a(this.EVo, 0, this.EVp, this.EVq);
                if (u) {
                    if (faL.v(cnb)) {
                        this.EUK.EeS.setVisibility(0);
                        this.EUK.Ewv.setVisibility(8);
                        this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.shortvideo_play_btn));
                        this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                    } else if (faL.w(cnb)) {
                        this.EUK.EeS.setVisibility(8);
                        this.EUK.Ewv.setVisibility(8);
                    } else if (faL.b(this.DsC, (int[]) null) <= 5) {
                        this.EUK.EeS.setVisibility(8);
                        this.EUK.Ewv.setVisibility(8);
                    } else {
                        faL.z(cnb);
                        this.EUK.EeS.setVisibility(0);
                        this.EUK.Ewv.setVisibility(8);
                        this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.shortvideo_play_btn));
                        this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                    }
                    if (this.EVx) {
                        eVz = this.EUK.Ewt.isError();
                    } else {
                        eVz = this.EUK.Ews.Dnr.eVz();
                    }
                    if (eVz) {
                        Log.d("MicroMsg.FullCardAdDetailItem", "play video error " + cnb.Id + " " + cnb.Url + " " + cnb.Msz);
                        faL.z(cnb);
                        this.EUK.EeS.setVisibility(0);
                        this.EUK.Ewv.setVisibility(8);
                        this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.shortvideo_play_btn));
                        this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                    }
                } else if (faL.x(cnb)) {
                    this.EUK.EeS.setVisibility(8);
                    this.EUK.Ewv.setVisibility(0);
                    this.EUK.Ewv.gYN();
                } else if (faL.b(this.DsC, (int[]) null) == 5) {
                    faL.B(cnb);
                    this.EUK.EeS.setVisibility(8);
                    this.EUK.Ewv.setVisibility(0);
                    this.EUK.Ewv.gYN();
                } else if (faL.y(cnb)) {
                    this.EUK.Ewv.setVisibility(8);
                    this.EUK.EeS.setImageResource(R.raw.shortvideo_play_icon_err);
                    this.EUK.EeS.setVisibility(0);
                } else {
                    faL.z(cnb);
                    this.EUK.EeS.setVisibility(0);
                    this.EUK.Ewv.setVisibility(8);
                    this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.shortvideo_play_btn));
                    this.EUK.EeS.setContentDescription(this.context.getString(R.string.fn7));
                    if (faL.b(this.DsC, (int[]) null) == 4) {
                        this.EUK.EeT.setVisibility(0);
                    }
                }
                this.EUK.Ewr.setVisibility(0);
                this.EUK.Ews.setTagObject(this.EUK);
                this.EUK.Ewt.setTag(this.EUK);
                this.EUK.Ewu.setTag(this);
                this.EUK.Ewr.setOnClickListener(this.EVz);
                if (this.EVx) {
                    SnsInfo snsInfo = this.DsC;
                    SnsAdTimelineVideoView snsAdTimelineVideoView = this.EUK.Ewt;
                    int hashCode2 = this.context.hashCode();
                    bp gCU2 = bp.gCU();
                    gCU2.hXs = this.timeLineObject.CreateTime;
                    faL.a(snsInfo, cnb, snsAdTimelineVideoView, hashCode2, gCU2, true);
                    this.EUK.Ewt.start();
                    this.EUK.Ewt.setShouldPlayWhenPrepared(true);
                } else {
                    SnsInfo snsInfo2 = this.DsC;
                    VideoSightView videoSightView = this.EUK.Ews;
                    int hashCode3 = this.context.hashCode();
                    bp gCU3 = bp.gCU();
                    gCU3.hXs = this.timeLineObject.CreateTime;
                    faL.a(snsInfo2, cnb, videoSightView, hashCode3, 0, gCU3, true, true);
                    this.EUK.Ews.start();
                }
                this.EVf = true;
                String str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
                if (this.EBv != null) {
                    if (s.YS(str2)) {
                        this.EBv.f(j2, (int) cnb.MsT, true);
                        if (com.tencent.mm.plugin.sns.ad.e.b.KB()) {
                            Log.i("MicroMsg.FullCardAdDetailItem", "AdH265Helper, fileExists, isH265File=" + com.tencent.mm.modelvideo.r.isH265Video(str2) + ", path=" + str2);
                        }
                    } else {
                        this.EBv.f(j2, (int) cnb.MsT, false);
                    }
                    this.EBv.d(j2, aj.faL().b(this.DsC, null) == 5, false);
                }
            }
            AppMethodBeat.o(100021);
            return;
        }
        faL.a(this.EUK.Ews, this.context.hashCode(), 0);
        faL.a(this.EUK.Ewt, this.context.hashCode());
        this.EUK.Eww.setVisibility(8);
        this.EUK.Ews.setOnSightCompletionAction(null);
        this.EUK.Ews.setOnCompletionListener(null);
        this.EUK.Ews.setOnDecodeDurationListener(null);
        this.EUK.Ewt.setVideoCallback(null);
        AppMethodBeat.o(100021);
    }

    private void fkl() {
        AppMethodBeat.i(176411);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(100019);
                c.this.EVn.setVisibility(8);
                c.this.EVn.setBackgroundColor(0);
                c.this.EVn.flk();
                c.this.EVn.setOnGestureListener(null);
                AppMethodBeat.o(100019);
            }
        });
        AppMethodBeat.o(176411);
    }

    public final void fkm() {
        AppMethodBeat.i(179349);
        try {
            if (this.EVo == null || this.EVo.DWE == null) {
                this.EVr.eQ(false);
                AppMethodBeat.o(179349);
                return;
            }
            if (this.EVx) {
                this.EVr.setBlurBkg(this.EUK.Ewt.getInnerVideoView());
            } else {
                this.EVr.setBlurBkg(this.contentView);
            }
            this.EVr.bpn();
            this.EVr.fkZ();
            this.EVs = true;
            if (this.EVx) {
                this.EUK.Ewt.setShouldPlayWhenPrepared(false);
                this.EUK.Ewt.pause();
            } else {
                this.EUK.Ews.pause();
            }
            fkl();
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(203890);
                    if (!(c.this.context instanceof Activity) || ((Activity) c.this.context).isFinishing()) {
                        Log.e("MicroMsg.FullCardAdDetailItem", "onCompletion, postDelayed-run activity isFinished");
                        AppMethodBeat.o(203890);
                        return;
                    }
                    c.this.EVr.eQ(true);
                    c.this.EVs = false;
                    if (c.this.mIsPaused) {
                        Log.e("MicroMsg.FullCardAdDetailItem", "activity isPaused");
                        AppMethodBeat.o(203890);
                    } else if (c.this.EVx) {
                        c.this.EUK.Ewt.restart();
                        AppMethodBeat.o(203890);
                    } else {
                        c.this.EUK.Ews.start();
                        AppMethodBeat.o(203890);
                    }
                }
            }, (long) this.EVo.DWE.duration);
            AppMethodBeat.o(179349);
        } catch (Exception e2) {
            Log.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + e2.toString());
            AppMethodBeat.o(179349);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void onPause() {
        AppMethodBeat.i(179350);
        Log.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.EVf);
        this.mIsPaused = true;
        try {
            if (!(!this.EVf || this.EUK == null || this.EUK.Ews == null)) {
                if (this.EVx) {
                    this.EUK.Ewt.pause();
                    this.EUK.Ewt.setShouldPlayWhenPrepared(false);
                    if (this.EVu != null) {
                        this.EVu.fhy();
                    }
                } else {
                    this.EUK.Ews.pause();
                }
                if (!(this.EBv == null || this.DsC == null)) {
                    this.EBv.IU(this.DsC.field_snsId);
                }
                if (this.DsC != null && this.DsC.isTwistAd()) {
                    this.EVy.onPlayerPaused();
                }
            }
            AppMethodBeat.o(179350);
        } catch (Exception e2) {
            Log.e("MicroMsg.FullCardAdDetailItem", "onPause, exp=" + e2.toString());
            AppMethodBeat.o(179350);
        }
    }

    static /* synthetic */ void a(c cVar, ADXml.g gVar, final SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(203894);
        final ADXml.g.a aVar = gVar.DWz;
        if (!Util.isNullOrNil(snsInfo.getAdXml().getGestureCanvasInfo()) && aVar != null && aVar.startTime >= 0 && aVar.endTime > aVar.startTime) {
            Log.i("MicroMsg.FullCardAdDetailItem", "%d-%d,%d", Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime), Integer.valueOf(i2));
            if (aVar.startTime > ((long) i2) || aVar.endTime < ((long) i2)) {
                cVar.fkl();
            } else if (cVar.EVn.getOnGestureListener() == null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(100018);
                        c.this.EVn.setVisibility(0);
                        c.this.EVn.flk();
                        c.this.EVn.setPaintColor(aVar.color);
                        c.this.EVn.setOnGestureListener(new SnsDrawGestureView.a() {
                            /* class com.tencent.mm.plugin.sns.ui.c.a.c.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void fkn() {
                                AppMethodBeat.i(100015);
                                r.uN(false);
                                c.this.EVn.setBackgroundColor(c.this.context.getResources().getColor(R.color.a8_));
                                AppMethodBeat.o(100015);
                            }

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void hi(List<PointF> list) {
                                int i2;
                                int i3 = 1;
                                AppMethodBeat.i(100016);
                                r.uN(true);
                                List<PointF> aOy = r.aOy(aVar.DWH);
                                c.this.EVn.setBackgroundColor(0);
                                if (aOy.size() <= 0 || list.size() <= 0) {
                                    AppMethodBeat.o(100016);
                                    return;
                                }
                                try {
                                    List<PointF> jX = com.tencent.mm.ui.tools.a.a.jX(list);
                                    double E = com.tencent.mm.ui.tools.a.a.E(aOy, jX);
                                    Collections.reverse(aOy);
                                    double E2 = com.tencent.mm.ui.tools.a.a.E(aOy, jX);
                                    float min = (float) Math.min(E, E2);
                                    Log.i("MicroMsg.FullCardAdDetailItem", "similarity: %f,%f, distance:%f", Double.valueOf(E), Double.valueOf(E2), Float.valueOf(min));
                                    if (min <= aVar.DWG) {
                                        c.this.Dyw.a(c.this, (Bundle) null);
                                        r.e(new long[]{20, 100});
                                        if (c.this.context instanceof SnsCommentDetailUI) {
                                            i3 = ((SnsCommentDetailUI) c.this.context).getSource();
                                        }
                                        if (i3 == 2) {
                                            i2 = 16;
                                        } else {
                                            i2 = 2;
                                        }
                                        e.a(c.this.context, c.this.contentView, snsInfo, i2);
                                        SnsAdClick snsAdClick = new SnsAdClick(1, 2, r.aOw(snsInfo.getTimeLine().Id), 25, 21);
                                        com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, snsInfo, 25);
                                        r.a(snsAdClick);
                                        i3 = 2;
                                    }
                                    h.INSTANCE.a(16552, snsInfo.getTimeLine().Id, r.gO(aOy), r.gO(com.tencent.mm.ui.tools.a.a.jV(jX)), Integer.valueOf((int) (100.0f * min)), Integer.valueOf(i3), Long.valueOf(Util.safeParseLong(snsInfo.getAid())), snsInfo.getAdInfo().uxInfo);
                                    e.a(i3, min, aVar.DWG, snsInfo.getAdInfo().uxInfo, snsInfo.getTimeLine().Id, 2);
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.FullCardAdDetailItem", e2, "recog gesture error!", new Object[0]);
                                } finally {
                                    c.this.EVn.flk();
                                    AppMethodBeat.o(100016);
                                }
                            }

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void onClick() {
                                AppMethodBeat.i(100017);
                                r.uN(true);
                                c.this.EVn.setBackgroundColor(0);
                                c.this.EUK.Ewr.performClick();
                                AppMethodBeat.o(100017);
                            }
                        });
                        AppMethodBeat.o(100018);
                    }
                });
                AppMethodBeat.o(203894);
                return;
            }
        }
        AppMethodBeat.o(203894);
    }
}
