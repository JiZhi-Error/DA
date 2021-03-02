package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.video.d;
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

public final class f extends BaseTimeLineItem implements com.tencent.mm.plugin.sns.ui.video.a {
    Handler DAC = new Handler(Looper.getMainLooper());
    private SnsInfo DqO;
    private View.OnClickListener EVA = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(176421);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
            try {
                f.this.DQX.DQs.FaQ.onClick(view);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + e2.toString());
            }
            if (f.this.EVs) {
                SnsAdCardVideoEndView.i(f.this.DqO, 1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(176421);
        }
    };
    protected SnsAdTouchProgressView.a EVB = new SnsAdTouchProgressView.a() {
        /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass11 */

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onStart() {
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onCancel() {
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onClick(View view) {
            AppMethodBeat.i(203923);
            try {
                Log.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
                f.this.EYE.EUK.Ewr.performClick();
                AppMethodBeat.o(203923);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + e2.toString());
                AppMethodBeat.o(203923);
            }
        }

        @Override // com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a
        public final void onFinish() {
            AppMethodBeat.i(203924);
            f.this.DQX.EKl.EoV.a(f.this.EYE, (Bundle) null);
            r.e(new long[]{20, 100});
            e.a(f.this.mActivity, f.this.EYE.ExX, f.this.DqO, 1);
            if (f.this.DqO != null) {
                SnsAdClick snsAdClick = new SnsAdClick(1, 1, r.aOw(f.this.DqO.getTimeLine().Id), 28, 21);
                if (f.this.mActivity instanceof SnsTimeLineUI) {
                    k.a(snsAdClick, ((SnsTimeLineUI) f.this.mActivity).fjf(), f.this.DqO, 28);
                }
                r.a(snsAdClick);
                Log.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
                AppMethodBeat.o(203924);
                return;
            }
            Log.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
            AppMethodBeat.o(203924);
        }
    };
    protected TwistCoverView.a EVC = new TwistCoverView.a() {
        /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a
        public final void eYQ() {
            AppMethodBeat.i(203921);
            f.this.EYE.EYi = true;
            if (f.this.DqO == null) {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "onTwist, mSnsInfo==null");
                AppMethodBeat.o(203921);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromTwist", true);
            ADXml.k kVar = f.this.DqO.getAdXml().adTwistInfo;
            if (kVar != null) {
                bundle.putBoolean("isSimpleTwistAnim", kVar.DWW);
                bundle.putBoolean("isTwistClockwise", kVar.DWV);
                if (kVar.DWW) {
                    r.e(new long[]{0, 80});
                }
            }
            f.this.DQX.EKl.EoV.a(f.this.EYE, bundle);
            e.a(f.this.mActivity, f.this.EYE.ExX, f.this.DqO, 1);
            try {
                SnsAdClick snsAdClick = new SnsAdClick(1, 1, r.aOw(f.this.DqO.getTimeLine().Id), 29, 21);
                if (f.this.mActivity instanceof SnsTimeLineUI) {
                    k.a(snsAdClick, ((SnsTimeLineUI) f.this.mActivity).fjf(), f.this.DqO, 29);
                }
                r.a(snsAdClick);
                Log.i("MicroMsg.FullCardAdTimeLineItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
                AppMethodBeat.o(203921);
            } catch (Throwable th) {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "twist click report exp=" + th.toString());
                AppMethodBeat.o(203921);
            }
        }
    };
    boolean EVs = false;
    private View.OnClickListener EVz = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(176420);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
            try {
                f.this.DQX.DQs.Fbd.onClick(view);
            } catch (Exception e2) {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + e2.toString());
            }
            if (f.this.EVs) {
                SnsAdCardVideoEndView.i(f.this.DqO, 1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(176420);
        }
    };
    volatile boolean EXV = false;
    a EYE;
    private ba EYF;
    private boolean EYG = false;
    private boolean EYH = false;
    boolean EYI = false;

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        public View EVh;
        public TextView EVi;
        public TextView EVj;
        public TextView EVk;
        public View EVl;
        public MaskImageView EVm;
        private SnsDrawGestureView EVn;
        public ImageView EVp;
        public ImageView EVq;
        public SnsAdCardVideoEndView EVr;
        public SnsAdSphereAnimView EVt;
        public TwistCoverView EVy;
        public SnsAdTouchProgressView EYN;
        public boolean EYi = false;
        public View ExX;
        public TextView uXS;
        public View wnX;
    }

    public f() {
        AppMethodBeat.i(176422);
        AppMethodBeat.o(176422);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100081);
        this.EYE = (a) baseViewHolder;
        if (baseViewHolder.EWD != null) {
            baseViewHolder.EWD.setLayoutResource(R.layout.bxl);
            if (!baseViewHolder.EWE) {
                this.EYE.ExX = baseViewHolder.EWD.inflate();
                baseViewHolder.EWE = true;
            }
        } else if (!baseViewHolder.EWE) {
            this.EYE.ExX = baseViewHolder.convertView.findViewById(R.id.dbj);
            baseViewHolder.EWE = true;
        }
        this.EYE.wnX = this.EYE.convertView.findViewById(R.id.isy);
        this.EYE.EVh = this.EYE.convertView.findViewById(R.id.aan);
        this.EYE.uXS = (TextView) this.EYE.convertView.findViewById(R.id.it0);
        this.EYE.EVi = (TextView) this.EYE.convertView.findViewById(R.id.isz);
        this.EYE.EVj = (TextView) this.EYE.convertView.findViewById(R.id.aap);
        this.EYE.EVk = (TextView) this.EYE.convertView.findViewById(R.id.aao);
        this.EYE.EVm = (MaskImageView) this.EYE.convertView.findViewById(R.id.dbk);
        this.EYE.EVl = this.EYE.convertView.findViewById(R.id.aaw);
        this.EYE.EVm.setScaleType(QImageView.a.CENTER_CROP);
        this.EYE.EUK = new at();
        this.EYE.EUK.Ewu = this.EYE.ExX.findViewById(R.id.dbm);
        this.EYE.EUK.Ewr = this.EYE.EUK.Ewu;
        this.EYE.EUK.Ewu.setOnClickListener(this.EVA);
        this.EYE.EUK.Ews = (VideoSightView) this.EYE.EUK.Ewu.findViewById(R.id.dup);
        this.EYE.EUK.Ewt = (SnsAdTimelineVideoView) this.EYE.EUK.Ewu.findViewById(R.id.g3g);
        baseViewHolder.EUK.Ews.setMute(true);
        baseViewHolder.EUK.Ewt.setMute(true);
        this.EYE.EUK.EeS = (ImageView) this.EYE.ExX.findViewById(R.id.dbl);
        this.EYE.EUK.Ewv = (MMPinProgressBtn) this.EYE.EUK.Ewu.findViewById(R.id.gl7);
        this.EYE.EUK.Eww = (TextView) this.EYE.EUK.Ewu.findViewById(R.id.c3v);
        this.EYE.EUK.EeT = (TextView) this.EYE.EUK.Ewu.findViewById(R.id.c4k);
        this.EYE.EUK.Ews.Dnz = true;
        this.EYE.EUK.Ews.setScaleType(QImageView.a.CENTER_CROP);
        this.EYE.EVn = (SnsDrawGestureView) this.EYE.convertView.findViewById(R.id.hxo);
        this.EYE.EVp = (ImageView) this.EYE.convertView.findViewById(R.id.db6);
        this.EYE.EVq = (ImageView) this.EYE.convertView.findViewById(R.id.c3p);
        this.EYE.EVr = (SnsAdCardVideoEndView) this.EYE.convertView.findViewById(R.id.hxr);
        this.EYE.EVy = (TwistCoverView) this.EYE.convertView.findViewById(R.id.i1d);
        this.EYE.EVy.setTwistActionListener(this.EVC);
        if (this.EYE.EVt == null) {
            View inflate = ((ViewStub) this.EYE.EXE.findViewById(R.id.hwd)).inflate();
            this.EYE.EVt = (SnsAdSphereAnimView) inflate.findViewById(R.id.hwc);
            this.EYE.EYN = (SnsAdTouchProgressView) inflate.findViewById(R.id.hwb);
        } else {
            Log.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
        }
        this.EYE.EVt.setVisibility(8);
        this.EYE.EYN.setVisibility(8);
        this.EYF = new ba(this.mActivity, this.EYE, this.EYE.EXE);
        this.EYF.EzC = this.EVB;
        this.EYG = e.fkr();
        AppMethodBeat.o(100081);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, final bl blVar, TimeLineObject timeLineObject, int i3, final bk bkVar) {
        String str;
        cnb cnb;
        boolean eVz;
        AppMethodBeat.i(100082);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "ad fillItem, fullCardAd, pos=" + i2 + ", snsId=" + timeLineObject.Id + ", hash=" + hashCode());
        if (baseViewHolder.hho) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
            AppMethodBeat.o(100082);
            return;
        }
        final a aVar = (a) baseViewHolder;
        final SnsInfo snsInfo = blVar.DqO;
        this.DqO = snsInfo;
        final ADXml.g gVar = null;
        if (!(snsInfo == null || snsInfo.getAdXml() == null)) {
            gVar = snsInfo.getAdXml().adFullCardInfo;
        }
        WindowManager windowManager = (WindowManager) this.mActivity.getSystemService("window");
        int min = Math.min(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        ViewGroup.LayoutParams layoutParams = null;
        aVar.wnX.setVisibility(8);
        aVar.uXS.setVisibility(8);
        aVar.EVi.setVisibility(8);
        aVar.EVh.setVisibility(8);
        aVar.EVj.setVisibility(8);
        aVar.EVk.setVisibility(8);
        aVar.EVl.setVisibility(8);
        aVar.EVn.setVisibility(8);
        aVar.EYN.setVisibility(8);
        aVar.EVt.setVisibility(8);
        aVar.EUK.Ews.setOnCompletionListener(null);
        aVar.EUK.Ews.setOnDecodeDurationListener(null);
        aVar.EUK.Ewt.setVideoCallback(null);
        a(aVar);
        if (gVar != null) {
            aVar.EVr.a(gVar.DWE, 1);
            if (snsInfo != null && aVar.EVr.ac(snsInfo)) {
                this.DAC.removeCallbacksAndMessages(null);
                this.EVs = false;
            }
            aVar.EUK.Ews.setIsForbidLoopAnim(gVar.DWE != null);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 56);
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.i2);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.ir);
            int i4 = ((min - fromDPToPix) - dimensionPixelSize) - dimensionPixelSize2;
            if (gVar.DWw == 0) {
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                layoutParams2.width = i4;
                layoutParams2.height = (int) (((float) layoutParams2.width) * 0.75f);
                layoutParams = layoutParams2;
            } else if (gVar.DWw == 1) {
                ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                layoutParams3.width = i4;
                layoutParams3.height = layoutParams3.width;
                layoutParams = layoutParams3;
            }
            this.EYH = this.EYF.a(this.DqO, gVar.DWF, new Rect(dimensionPixelSize + fromDPToPix, fromDPToPix - dimensionPixelSize2, min - dimensionPixelSize2, (layoutParams != null ? layoutParams.height : 0) + (fromDPToPix - dimensionPixelSize2)));
            this.EYI = this.EYG || this.EYH;
            aVar.EUK.EwA = this.EYI;
            Log.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, isExptUseNewPlayer=" + this.EYG + ", isLongPressGestureAd=" + this.EYH + ", hash=" + hashCode() + ", snsId=" + (snsInfo == null ? "" : Long.valueOf(snsInfo.field_snsId)));
            if (snsInfo != null) {
                aVar.EVy.a(snsInfo, snsInfo.getAdXml().adTwistInfo, 1);
                if (snsInfo.isTwistAd()) {
                    aVar.EUK.Ewt.setTimerInterval(300);
                } else {
                    aVar.EUK.Ewt.setTimerInterval(1000);
                    aVar.EVy.clear();
                }
            }
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams4 = aVar.ExX.getLayoutParams();
                layoutParams4.width = layoutParams.width;
                layoutParams4.height = layoutParams.height;
                aVar.ExX.setLayoutParams(layoutParams4);
                ((RoundedCornerFrameLayout) aVar.ExX).setRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 8));
                ViewGroup.LayoutParams layoutParams5 = aVar.EVm.getLayoutParams();
                layoutParams5.width = layoutParams.width;
                layoutParams5.height = layoutParams.height;
                aVar.EVm.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = aVar.EUK.Ewr.getLayoutParams();
                layoutParams6.width = layoutParams.width;
                layoutParams6.height = layoutParams.height;
                aVar.EUK.Ewr.setLayoutParams(layoutParams6);
                aVar.EUK.Ews.im(layoutParams.width, layoutParams.height);
                ViewGroup.LayoutParams layoutParams7 = aVar.EUK.Ewt.getLayoutParams();
                layoutParams7.width = layoutParams.width;
                layoutParams7.height = layoutParams.height;
                aVar.EUK.Ewt.setLayoutParams(layoutParams7);
                ViewGroup.LayoutParams layoutParams8 = aVar.EVp.getLayoutParams();
                layoutParams8.width = layoutParams.width;
                layoutParams8.height = layoutParams.height;
                aVar.EVp.setLayoutParams(layoutParams8);
                ViewGroup.LayoutParams layoutParams9 = aVar.EVq.getLayoutParams();
                layoutParams9.width = layoutParams.width;
                layoutParams9.height = layoutParams.height;
                aVar.EVq.setLayoutParams(layoutParams9);
                ViewGroup.LayoutParams layoutParams10 = aVar.EVr.getLayoutParams();
                layoutParams10.width = layoutParams.width;
                layoutParams10.height = layoutParams.height;
                aVar.EVr.setLayoutParams(layoutParams10);
            } else {
                Log.e("MicroMsg.FullCardAdTimeLineItem", "mediaLayout==null, snsId=" + (this.DqO == null ? "" : Long.valueOf(this.DqO.field_snsId)));
            }
            if (gVar.DWy == 0) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb((int) (((float) gVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable.setGradientType(0);
                aVar.wnX.setBackground(gradientDrawable);
                if (!Util.isNullOrNil(gVar.title) || !Util.isNullOrNil(gVar.description)) {
                    aVar.wnX.setVisibility(0);
                }
                if (!Util.isNullOrNil(gVar.title)) {
                    aVar.uXS.setVisibility(0);
                    aVar.uXS.setText(g.gxZ().a(aVar.uXS.getContext(), gVar.title, aVar.uXS.getTextSize()));
                }
                if (!Util.isNullOrNil(gVar.description)) {
                    aVar.EVi.setVisibility(0);
                    aVar.EVi.setText(g.gxZ().a(aVar.EVi.getContext(), gVar.description, aVar.EVi.getTextSize()));
                }
            } else if (gVar.DWy == 1) {
                GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) gVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable2.setGradientType(0);
                aVar.EVh.setBackground(gradientDrawable2);
                if (!Util.isNullOrNil(gVar.title) || !Util.isNullOrNil(gVar.description)) {
                    aVar.EVh.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) aVar.EVl.getLayoutParams();
                    layoutParams11.topMargin = com.tencent.mm.cb.a.fromDPToPix(aVar.ExX.getContext(), 4);
                    aVar.EVl.setLayoutParams(layoutParams11);
                }
                if (!Util.isNullOrNil(gVar.title)) {
                    aVar.EVj.setVisibility(0);
                    aVar.EVj.setText(g.gxZ().a(aVar.EVj.getContext(), gVar.title, aVar.EVj.getTextSize()));
                }
                if (!Util.isNullOrNil(gVar.description)) {
                    aVar.EVk.setVisibility(0);
                    aVar.EVk.setText(g.gxZ().a(aVar.EVk.getContext(), gVar.description, aVar.EVk.getTextSize()));
                }
            }
            if (snsInfo.getAdInfo().isWeapp()) {
                GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb((int) (((float) gVar.DWx) * 2.55f), 0, 0, 0), Color.argb(0, 0, 0, 0)});
                gradientDrawable3.setGradientType(0);
                aVar.EVh.setVisibility(0);
                aVar.EVh.setBackground(gradientDrawable3);
                aVar.EVl.setVisibility(0);
            }
        } else {
            Log.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
            String Jb = this.DqO == null ? "" : r.Jb(this.DqO.field_snsId);
            int i5 = 0;
            if (snsInfo != null) {
                int i6 = snsInfo.isFullCardAd() ? 1 : 0;
                str = snsInfo.getUxinfo();
                i5 = i6;
            } else {
                str = "";
            }
            j.b(j.DDX, Jb, 1, i5, str);
        }
        if (timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV.size() <= 0) {
            cnb = null;
        } else {
            cnb = timeLineObject.ContentObj.LoV.get(0);
        }
        com.tencent.mm.plugin.sns.model.g faL = aj.faL();
        if (baseViewHolder.EUK.Ewq != null && !Util.isEqual(baseViewHolder.EUK.Ewq.Id, timeLineObject.Id)) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", baseViewHolder.EUK.Ewq.Id);
            faL.a(baseViewHolder.EUK.Ews, this.mActivity.hashCode(), i2);
            faL.a(baseViewHolder.EUK.Ewt, this.mActivity.hashCode());
        }
        baseViewHolder.EUK.a(timeLineObject, i2, blVar.Eql, blVar.Eoq);
        baseViewHolder.EUK.EeT.setVisibility(8);
        if (cnb == null) {
            faL.a(baseViewHolder.EUK.Ews, this.mActivity.hashCode(), i2);
            faL.a(baseViewHolder.EUK.Ewt, this.mActivity.hashCode());
            baseViewHolder.EUK.Eww.setVisibility(8);
            baseViewHolder.EUK.Ews.setOnSightCompletionAction(null);
            baseViewHolder.EUK.Ews.setOnCompletionListener(null);
            baseViewHolder.EUK.Ews.setOnDecodeDurationListener(null);
            baseViewHolder.EUK.Ewt.setVideoCallback(null);
        } else if (timeLineObject.ContentObj.LoU == 1) {
            aVar.EVm.setVisibility(0);
            aVar.EUK.Ewr.setVisibility(4);
            MaskImageView maskImageView = aVar.EVm;
            int hashCode = this.mActivity.hashCode();
            bp gCU = bp.gCU();
            gCU.hXs = timeLineObject.CreateTime;
            faL.b(cnb, maskImageView, -1, hashCode, gCU);
            aVar.EVm.setTag(baseViewHolder);
            aVar.EVm.setOnClickListener(this.EVz);
            aVar.EYi = false;
            AppMethodBeat.o(100082);
            return;
        } else if (timeLineObject.ContentObj.LoU == 15 || timeLineObject.ContentObj.LoU == 5) {
            if (this.EYI) {
                aVar.EUK.Ewt.setVisibility(0);
                aVar.EUK.Ews.setVisibility(8);
                aVar.EUK.Ewt.setVideoCallback(new OfflineVideoView.a() {
                    /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final boolean a(PString pString) {
                        AppMethodBeat.i(179355);
                        Log.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
                        AppMethodBeat.o(179355);
                        return false;
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void onStart(int i2) {
                        AppMethodBeat.i(179356);
                        Log.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(i2)));
                        AppMethodBeat.o(179356);
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void onCompletion() {
                        AppMethodBeat.i(179357);
                        Log.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
                        boolean fhx = f.this.EYF.fhx();
                        if (f.this.EXV && gVar != null && gVar.DWE == null && !fhx) {
                            aVar.EUK.Ewt.restart();
                        }
                        f.this.a(bkVar, blVar, gVar, 0);
                        AppMethodBeat.o(179357);
                    }

                    @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
                    public final void xv(int i2) {
                        AppMethodBeat.i(179358);
                        f.this.a(blVar, gVar, snsInfo, (long) i2, aVar.EUK.Ewt.getDurationMs() / 1000);
                        com.tencent.mm.plugin.sns.ad.g.k kVar = null;
                        if (!(bkVar == null || bkVar.EKl == null)) {
                            kVar = bkVar.EKl.EoE;
                        }
                        f.this.EYF.a(kVar, (long) i2, blVar.ENp);
                        AppMethodBeat.o(179358);
                    }
                });
            } else {
                aVar.EUK.Ewt.setVisibility(8);
                aVar.EUK.Ews.setVisibility(0);
                aVar.EUK.Ews.setOnCompletionListener(new b.e() {
                    /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.sight.decode.a.b.e
                    public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i2) {
                        AppMethodBeat.i(179362);
                        Log.i("MicroMsg.FullCardAdTimeLineItem", "sight play completed, retCode=" + i2 + ", snsId=" + (snsInfo == null ? "" : Long.valueOf(snsInfo.field_snsId)));
                        f.this.a(bkVar, blVar, gVar, i2);
                        AppMethodBeat.o(179362);
                    }
                });
                aVar.EUK.Ews.setOnDecodeDurationListener(new b.f() {
                    /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                    public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j2) {
                        AppMethodBeat.i(179363);
                        Log.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", Long.valueOf(j2));
                        f.this.a(blVar, gVar, snsInfo, 1000 * j2, (int) bVar.eVC());
                        AppMethodBeat.o(179363);
                    }
                });
            }
            if (gVar != null) {
                e.l(gVar.DWA, aVar.EVp);
                e.l(gVar.DWC, aVar.EVq);
            }
            if (this.EYI) {
                com.tencent.mm.plugin.sns.ad.e.b.a(snsInfo, cnb);
            } else {
                com.tencent.mm.plugin.sns.ad.e.b.a(cnb, false);
            }
            long nanoTime = System.nanoTime();
            boolean u = com.tencent.mm.plugin.sns.model.g.u(cnb);
            Log.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(u), Long.valueOf(System.nanoTime() - nanoTime));
            at atVar = aVar.EUK;
            if (u) {
                if (faL.v(cnb)) {
                    atVar.EeS.setVisibility(0);
                    atVar.Ewv.setVisibility(8);
                    atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                } else if (faL.w(cnb)) {
                    atVar.EeS.setVisibility(8);
                    atVar.Ewv.setVisibility(8);
                } else if (faL.b(snsInfo, (int[]) null) > 5) {
                    faL.z(cnb);
                    atVar.EeS.setVisibility(0);
                    atVar.Ewv.setVisibility(8);
                    atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                } else if (!aVar.EYi) {
                    Log.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
                    fkq();
                }
                if (this.EYI) {
                    eVz = atVar.Ewt.isError();
                } else {
                    eVz = atVar.Ews.Dnr.eVz();
                }
                if (eVz) {
                    Log.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + cnb.Id + " " + cnb.Url + " " + cnb.Msz + " " + i2);
                    faL.z(cnb);
                    atVar.EeS.setVisibility(0);
                    atVar.Ewv.setVisibility(8);
                    atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                    atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                }
            } else if (faL.x(cnb)) {
                atVar.EeS.setVisibility(8);
                atVar.Ewv.setVisibility(0);
                atVar.Ewv.gYN();
            } else if (faL.b(snsInfo, (int[]) null) == 5) {
                faL.B(cnb);
                atVar.EeS.setVisibility(8);
                atVar.Ewv.setVisibility(0);
                atVar.Ewv.gYN();
            } else if (faL.y(cnb)) {
                atVar.Ewv.setVisibility(8);
                atVar.EeS.setImageResource(R.raw.shortvideo_play_icon_err);
                atVar.EeS.setVisibility(0);
            } else {
                faL.z(cnb);
                atVar.EeS.setVisibility(0);
                atVar.Ewv.setVisibility(8);
                atVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
                atVar.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
                if (faL.b(snsInfo, (int[]) null) == 4) {
                    atVar.EeT.setVisibility(0);
                }
            }
            aVar.EUK.Ewr.setVisibility(0);
            aVar.EVm.setVisibility(4);
            atVar.Ews.setTagObject(atVar);
            atVar.Ewt.setTag(atVar);
            atVar.Ewu.setTag(baseViewHolder);
            aVar.EUK.Ewr.setOnClickListener(this.EVz);
            if (this.EYI) {
                SnsAdTimelineVideoView snsAdTimelineVideoView = atVar.Ewt;
                int hashCode2 = this.mActivity.hashCode();
                bp gCU2 = bp.gCU();
                gCU2.hXs = timeLineObject.CreateTime;
                faL.a(snsInfo, cnb, snsAdTimelineVideoView, hashCode2, gCU2, blVar.Eoq);
            } else {
                VideoSightView videoSightView = atVar.Ews;
                int hashCode3 = this.mActivity.hashCode();
                bp gCU3 = bp.gCU();
                gCU3.hXs = timeLineObject.CreateTime;
                faL.a(snsInfo, cnb, videoSightView, hashCode3, i2, gCU3, blVar.Eoq, true);
            }
            e.a(gVar, 0, aVar.EVp, aVar.EVq);
            String str2 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
            if (s.YS(str2)) {
                bkVar.EKl.EoE.f(blVar.ENp, (int) cnb.MsT, true);
                if (com.tencent.mm.plugin.sns.ad.e.b.KB()) {
                    Log.i("MicroMsg.FullCardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + com.tencent.mm.modelvideo.r.isH265Video(str2) + ", path=" + str2);
                }
            } else {
                bkVar.EKl.EoE.f(blVar.ENp, (int) cnb.MsT, false);
            }
            bkVar.EKl.EoE.d(blVar.ENp, aj.faL().b(snsInfo, null) == 5, false);
            AppMethodBeat.o(100082);
            return;
        }
        AppMethodBeat.o(100082);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2) {
        AppMethodBeat.i(176423);
        if (baseViewHolder.timeLineObject.ContentObj.LoU == 5 || baseViewHolder.timeLineObject.ContentObj.LoU == 15) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + i2 + ", isEndViewShow=" + this.EVs + ", isPlayingSight=" + this.EXV);
            d.fkS().cXa();
            com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
            if (!this.EVs) {
                if (this.EYI) {
                    baseViewHolder.EUK.Ewt.setShouldPlayWhenPrepared(true);
                    baseViewHolder.EUK.Ewt.start();
                } else {
                    baseViewHolder.EUK.Ews.start();
                }
            }
            Log.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
            if (!(this.EYE == null || this.EYE.EUK == null)) {
                Log.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
                this.EYE.EUK.EeS.setVisibility(8);
                this.EYE.EUK.Ewv.setVisibility(8);
            }
            this.EXV = true;
            if (baseViewHolder instanceof a) {
                ((a) baseViewHolder).EYi = false;
            }
            if (!this.EVs && this.EYE.EVr.getVisibility() == 0) {
                this.EYE.EVr.eQ(true);
            }
        }
        AppMethodBeat.o(176423);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void pause() {
        AppMethodBeat.i(176424);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "pause");
        if (fkp()) {
            fkq();
        }
        AppMethodBeat.o(176424);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void onUIPause() {
        AppMethodBeat.i(177694);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
        fkp();
        AppMethodBeat.o(177694);
    }

    private boolean fkp() {
        AppMethodBeat.i(177695);
        if (this.EYE.timeLineObject.ContentObj.LoU == 5 || this.EYE.timeLineObject.ContentObj.LoU == 15) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", this);
            if (!(this.EYE == null || this.EYE.EUK == null)) {
                if (this.EYI) {
                    this.EYE.EUK.Ewt.pause();
                    this.EYE.EUK.Ewt.setShouldPlayWhenPrepared(false);
                    this.EYF.fhy();
                } else {
                    this.EYE.EUK.Ews.pause();
                }
                ab(this.DqO);
                if (this.DqO != null && this.DqO.isTwistAd()) {
                    this.EYE.EVy.onPlayerPaused();
                }
            }
            this.EXV = false;
            AppMethodBeat.o(177695);
            return true;
        }
        AppMethodBeat.o(177695);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void stop() {
        AppMethodBeat.i(176425);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", this);
        if (!(this.EYE == null || this.EYE.EUK == null)) {
            if (this.EYI) {
                this.EYE.EUK.Ewt.clear();
            } else {
                this.EYE.EUK.Ews.Dnr.clear();
            }
            this.EYE.EVy.setSensorEnabled(false);
        }
        this.EXV = false;
        AppMethodBeat.o(176425);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final Rect getDisplayRect() {
        AppMethodBeat.i(176426);
        if (this.EYE == null || this.EYE.ExX == null) {
            AppMethodBeat.o(176426);
            return null;
        }
        int[] iArr = new int[2];
        this.EYE.ExX.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        Rect rect = new Rect(i2, i3, this.EYE.ExX.getMeasuredWidth() + i2, this.EYE.ExX.getMeasuredHeight() + i3);
        AppMethodBeat.o(176426);
        return rect;
    }

    private void fkq() {
        AppMethodBeat.i(176427);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
        if (!(this.EYE == null || this.EYE.EUK == null || this.EXV)) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
            this.EYE.EUK.EeS.setVisibility(0);
            this.EYE.EUK.Ewv.setVisibility(8);
            this.EYE.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
            this.EYE.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
        }
        AppMethodBeat.o(176427);
    }

    /* access modifiers changed from: package-private */
    public final void a(final a aVar) {
        AppMethodBeat.i(100083);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(100080);
                aVar.EVn.setVisibility(8);
                aVar.EVn.setBackgroundColor(0);
                aVar.EVn.flk();
                aVar.EVn.setOnGestureListener(null);
                AppMethodBeat.o(100080);
            }
        });
        AppMethodBeat.o(100083);
    }

    /* access modifiers changed from: protected */
    public final void a(bk bkVar, bl blVar, final ADXml.g gVar, int i2) {
        AppMethodBeat.i(179370);
        Log.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(i2)));
        if (i2 != -1) {
            if (bkVar == null || bkVar.EKl == null || bkVar.EKl.EoE == null) {
                AppMethodBeat.o(179370);
                return;
            }
            bkVar.EKl.EoE.I(blVar.ENp, false);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(179361);
                f fVar = f.this;
                ADXml.g gVar = gVar;
                if (gVar != null) {
                    try {
                        if (gVar.DWE != null && fVar.EXV) {
                            if (fVar.EYI) {
                                fVar.EYE.EVr.setBlurBkg(fVar.EYE.EUK.Ewt.getInnerVideoView());
                            } else {
                                fVar.EYE.EVr.setBlurBkg(fVar.EYE.ExX);
                            }
                            fVar.EYE.EVr.bpn();
                            fVar.EYE.EVr.fkZ();
                            fVar.EVs = true;
                            if (fVar.EYI) {
                                fVar.EYE.EUK.Ewt.setShouldPlayWhenPrepared(false);
                                fVar.EYE.EUK.Ewt.pause();
                            } else {
                                fVar.EYE.EUK.Ews.pause();
                            }
                            fVar.a(fVar.EYE);
                            fVar.DAC.postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass10 */

                                public final void run() {
                                    AppMethodBeat.i(203922);
                                    if (f.this.mActivity == null || f.this.mActivity.isFinishing()) {
                                        Log.e("MicroMsg.FullCardAdTimeLineItem", "onCompletion, postDelayed-run activity isFinished");
                                    } else {
                                        f.this.EVs = false;
                                        if (f.this.EXV) {
                                            f.this.EYE.EVr.eQ(true);
                                            if (f.this.EYI) {
                                                f.this.EYE.EUK.Ewt.restart();
                                                AppMethodBeat.o(203922);
                                                return;
                                            }
                                            f.this.EYE.EUK.Ews.start();
                                            AppMethodBeat.o(203922);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.o(203922);
                                }
                            }, (long) gVar.DWE.duration);
                            AppMethodBeat.o(179361);
                            return;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + e2.toString());
                        AppMethodBeat.o(179361);
                        return;
                    }
                }
                fVar.EYE.EVr.eQ(false);
                AppMethodBeat.o(179361);
            }
        });
        AppMethodBeat.o(179370);
    }

    /* access modifiers changed from: protected */
    public final void a(bl blVar, ADXml.g gVar, final SnsInfo snsInfo, long j2, int i2) {
        AppMethodBeat.i(179371);
        if (this.DQX == null || this.DQX.EKl == null || this.DQX.EKl.EoE == null || snsInfo == null) {
            AppMethodBeat.o(179371);
            return;
        }
        if ((gVar == null || gVar.DWE == null) && this.EYE.EVr.getVisibility() == 0) {
            this.EYE.EVr.eQ(false);
        }
        this.DQX.EKl.EoE.IT(snsInfo.field_snsId);
        this.DQX.EKl.EoE.ao(snsInfo.field_snsId, j2);
        if (!this.DQX.EKl.EoE.IQ(blVar.ENp)) {
            this.DQX.EKl.EoE.c(blVar.ENp, Util.currentTicks(), false);
            this.DQX.EKl.EoE.e(blVar.ENp, i2, false);
            this.DQX.EKl.EoE.an(blVar.ENp, blVar.ENp);
        }
        Log.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + j2 + ", duration=" + i2);
        final a aVar = this.EYE;
        int i3 = (int) j2;
        final ADXml.g.a aVar2 = gVar == null ? null : gVar.DWz;
        if (!Util.isNullOrNil(snsInfo.getAdXml().getGestureCanvasInfo()) && aVar2 != null && aVar2.startTime >= 0 && aVar2.endTime > aVar2.startTime) {
            Log.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", Long.valueOf(aVar2.startTime), Long.valueOf(aVar2.endTime), Integer.valueOf(i3));
            if (aVar2.startTime > ((long) i3) || aVar2.endTime < ((long) i3)) {
                a(aVar);
            } else if (aVar.EVn.getOnGestureListener() == null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(100079);
                        aVar.EVn.setVisibility(0);
                        aVar.EVn.flk();
                        aVar.EVn.setPaintColor(aVar2.color);
                        aVar.EVn.setOnGestureListener(new SnsDrawGestureView.a() {
                            /* class com.tencent.mm.plugin.sns.ui.item.f.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void fkn() {
                                AppMethodBeat.i(100076);
                                r.uN(false);
                                aVar.EVn.setBackgroundColor(f.this.mActivity.getResources().getColor(R.color.a8_));
                                AppMethodBeat.o(100076);
                            }

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void hi(List<PointF> list) {
                                int i2 = 1;
                                AppMethodBeat.i(100077);
                                r.uN(true);
                                List<PointF> aOy = r.aOy(aVar2.DWH);
                                aVar.EVn.setBackgroundColor(0);
                                if (aOy.size() <= 0 || list.size() <= 0) {
                                    AppMethodBeat.o(100077);
                                    return;
                                }
                                try {
                                    List<PointF> jX = com.tencent.mm.ui.tools.a.a.jX(list);
                                    double E = com.tencent.mm.ui.tools.a.a.E(aOy, jX);
                                    String gO = r.gO(aOy);
                                    Collections.reverse(aOy);
                                    double E2 = com.tencent.mm.ui.tools.a.a.E(aOy, jX);
                                    float min = (float) Math.min(E, E2);
                                    Log.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", Double.valueOf(E), Double.valueOf(E2), Float.valueOf(min));
                                    if (min <= aVar2.DWG) {
                                        f.this.DQX.EKl.EoV.a(aVar, (Bundle) null);
                                        r.e(new long[]{20, 100});
                                        e.a(f.this.mActivity, aVar.ExX, snsInfo, 1);
                                        SnsAdClick snsAdClick = new SnsAdClick(1, 1, r.aOw(snsInfo.getTimeLine().Id), 25, 21);
                                        if (f.this.mActivity instanceof SnsTimeLineUI) {
                                            k.a(snsAdClick, ((SnsTimeLineUI) f.this.mActivity).fjf(), snsInfo, 25);
                                        }
                                        r.a(snsAdClick);
                                        i2 = 2;
                                    }
                                    h.INSTANCE.a(16552, snsInfo.getTimeLine().Id, gO, r.gO(com.tencent.mm.ui.tools.a.a.jV(jX)), Integer.valueOf((int) (100.0f * min)), Integer.valueOf(i2), Long.valueOf(Util.safeParseLong(snsInfo.getAid())), snsInfo.getAdInfo().uxInfo);
                                    e.a(i2, min, aVar2.DWG, snsInfo.getAdInfo().uxInfo, snsInfo.getTimeLine().Id, 1);
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", e2, "recog gesture error!", new Object[0]);
                                } finally {
                                    aVar.EVn.flk();
                                    AppMethodBeat.o(100077);
                                }
                            }

                            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a
                            public final void onClick() {
                                AppMethodBeat.i(100078);
                                r.uN(true);
                                aVar.EVn.setBackgroundColor(0);
                                aVar.EUK.Ewr.performClick();
                                AppMethodBeat.o(100078);
                            }
                        });
                        AppMethodBeat.o(100079);
                    }
                });
            }
        }
        e.a(gVar, (int) j2, this.EYE.EVp, this.EYE.EVq);
        if (snsInfo.isTwistAd()) {
            this.EYE.EVy.IW(j2);
        }
        AppMethodBeat.o(179371);
    }

    private void ab(SnsInfo snsInfo) {
        AppMethodBeat.i(203925);
        if (!(this.DQX == null || this.DQX.EKl == null || this.DQX.EKl.EoE == null || snsInfo == null)) {
            this.DQX.EKl.EoE.IU(snsInfo.field_snsId);
        }
        AppMethodBeat.o(203925);
    }
}
