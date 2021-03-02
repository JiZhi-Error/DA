package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.b;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class a extends BaseTimeLineItem implements com.tencent.mm.plugin.sns.ui.video.a {
    private SnsInfo DqO;
    private String Dzk = "";
    private C1738a EXR;
    private av EXS;
    private ax EXT;
    private c EXU;
    private boolean EXV = false;

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.a$a  reason: collision with other inner class name */
    public static class C1738a extends BaseTimeLineItem.BaseViewHolder {
        public View EUN;
        public ImageView EUR;
        public View EUU;
        public View EUX;
        public PromotionBarLayout EUY;
        public LivingDescBarLayout EVc;
        public ViewGroup EVd;
        public MaskImageView EVm;
        public ViewGroup EXY;
        public Button EXZ;
        public Button EYa;
        public ImageView EYb;
        public TextView EYc;
        public SnsCardAdTagListView EYd;
        public View EYe;
        public ImageView EYf;
        public TextView EYg;
        public TextView EYh;
        public boolean EYi;
        public ViewGroup EYj;
        public boolean EYk;
        public TextView Vbc;
        public ViewGroup jLx;
        public ViewGroup qVR;
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(203917);
        aVar.fkq();
        AppMethodBeat.o(203917);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(final BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100064);
        this.EXR = (C1738a) baseViewHolder;
        if (baseViewHolder.EWD != null) {
            baseViewHolder.EWD.setLayoutResource(R.layout.btu);
            if (!baseViewHolder.EWE) {
                this.EXR.jLx = (ViewGroup) baseViewHolder.EWD.inflate();
                baseViewHolder.EWE = true;
            }
        } else if (!baseViewHolder.EWE) {
            this.EXR.jLx = (ViewGroup) baseViewHolder.convertView.findViewById(R.id.fg);
            baseViewHolder.EWE = true;
        }
        this.EXR.qVR = (ViewGroup) this.EXR.jLx.findViewById(R.id.fbg);
        if (this.EXR.qVR instanceof RoundedCornerFrameLayout) {
            ((RoundedCornerFrameLayout) this.EXR.qVR).setRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) this.mActivity, 4));
        }
        this.EXR.EXY = (ViewGroup) this.EXR.jLx.findViewById(R.id.g7c);
        this.EXR.EVm = (MaskImageView) this.EXR.jLx.findViewById(R.id.hwv);
        this.EXR.EVm.setOnClickListener(this.DQX.DQs.Erh);
        this.DQX.fiV().c(this.EXR.EVm, this.DQX.DQs.FaF, this.DQX.DQs.Far);
        this.EXR.EYh = (TextView) this.EXR.jLx.findViewById(R.id.bmx);
        this.EXR.EYh.setClickable(false);
        this.EXR.EYh.setLongClickable(false);
        this.EXR.EYg = (TextView) this.EXR.jLx.findViewById(R.id.bmw);
        this.EXR.EYg.setClickable(false);
        this.EXR.EYg.setLongClickable(false);
        this.EXR.EUK = new at();
        this.EXR.EUK.Ewu = this.EXR.jLx.findViewById(R.id.hwx);
        this.EXR.EUK.Ewr = this.EXR.EUK.Ewu;
        this.EXR.EUK.Ewu.setOnClickListener(this.DQX.DQs.FaQ);
        this.EXR.EUK.Ews = (VideoSightView) this.EXR.EUK.Ewu.findViewById(R.id.dup);
        this.EXR.EUK.Ews.setMute(true);
        this.EXR.EUK.EeS = (ImageView) this.EXR.EUK.Ewu.findViewById(R.id.i59);
        this.EXR.EUK.Ewv = (MMPinProgressBtn) this.EXR.EUK.Ewu.findViewById(R.id.gl7);
        this.EXR.EUK.Eww = (TextView) this.EXR.EUK.Ewu.findViewById(R.id.c3v);
        this.EXR.EUK.EeT = (TextView) this.EXR.EUK.Ewu.findViewById(R.id.c4k);
        this.EXR.EUU = this.EXR.jLx.findViewById(R.id.hu1);
        this.EXR.EYb = (ImageView) this.EXR.jLx.findViewById(R.id.hu0);
        this.EXR.EYc = (TextView) this.EXR.jLx.findViewById(R.id.hu2);
        this.EXR.EYe = this.EXR.jLx.findViewById(R.id.apq);
        this.EXR.EUR = (ImageView) this.EXR.jLx.findViewById(R.id.jk4);
        this.EXR.EYf = (ImageView) this.EXR.jLx.findViewById(R.id.jk6);
        this.EXR.Vbc = (TextView) this.EXR.jLx.findViewById(R.id.k3g);
        this.EXR.EUN = this.EXR.jLx.findViewById(R.id.akw);
        this.EXR.EXZ = (Button) this.EXR.jLx.findViewById(R.id.akx);
        this.EXR.EYa = (Button) this.EXR.jLx.findViewById(R.id.aky);
        this.EXR.EXZ.setOnClickListener(this.DQX.DQs.Fbb);
        this.EXR.EYa.setOnClickListener(this.DQX.DQs.Fbc);
        this.EXR.EYd = (SnsCardAdTagListView) this.EXR.jLx.findViewById(R.id.ak4);
        this.EXR.EYd.setActivityContext(this.mActivity);
        this.EXR.EYj = (ViewGroup) this.EXR.jLx.findViewById(R.id.hww);
        this.EXR.EUX = this.EXR.jLx.findViewById(R.id.cl);
        this.EXR.EUY = (PromotionBarLayout) this.EXR.jLx.findViewById(R.id.fz);
        this.EXS = new av(this.mActivity, this.EXR.jLx, 0, this.DQX.EKl.EoE, new av.b() {
            /* class com.tencent.mm.plugin.sns.ui.item.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.av.b
            public final void fgP() {
                AppMethodBeat.i(100060);
                a.this.DQX.DQs.a(baseViewHolder, (Bundle) null);
                AppMethodBeat.o(100060);
            }
        });
        this.EXT = new ax(this.mActivity, this.EXR.jLx, this.DQX.DQs);
        this.EXR.EVd = (ViewGroup) this.EXR.jLx.findViewById(R.id.fy);
        this.EXR.EVc = (LivingDescBarLayout) this.EXR.jLx.findViewById(R.id.fv);
        this.EXU = new c(this.EXR.EVd, this.EXR.EVc, this.EXS);
        AppMethodBeat.o(100064);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x059e A[Catch:{ Throwable -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x05f1 A[SYNTHETIC, Splitter:B:116:0x05f1] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0602 A[Catch:{ Throwable -> 0x0d48 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0d05  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0d20  */
    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder r22, int r23, final com.tencent.mm.plugin.sns.ui.bl r24, com.tencent.mm.protocal.protobuf.TimeLineObject r25, int r26, final com.tencent.mm.plugin.sns.ui.bk r27) {
        /*
        // Method dump skipped, instructions count: 3403
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.item.a.a(com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder, int, com.tencent.mm.plugin.sns.ui.bl, com.tencent.mm.protocal.protobuf.TimeLineObject, int, com.tencent.mm.plugin.sns.ui.bk):void");
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2) {
        boolean z;
        AppMethodBeat.i(176412);
        if (baseViewHolder.timeLineObject.ContentObj.LoU == 5 || baseViewHolder.timeLineObject.ContentObj.LoU == 15) {
            Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", this, Integer.valueOf(i2));
            if (baseViewHolder instanceof C1738a) {
                z = ((C1738a) baseViewHolder).EYk;
            } else {
                z = false;
            }
            Log.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(z)));
            if (!z) {
                d.fkS().cXa();
                b.fkM().a(this);
                baseViewHolder.EUK.Ews.start();
            } else {
                b.fkM().pause();
                Log.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", this, Integer.valueOf(i2));
                SnsInfo snsInfo = this.DqO;
                cnb a2 = g.a(baseViewHolder);
                String c2 = g.c(baseViewHolder);
                k a3 = g.a(this.DQX);
                ViewGroup viewGroup = ((C1738a) baseViewHolder).EYj;
                String str = baseViewHolder.dHp;
                if (!(snsInfo == null || a2 == null || viewGroup == null)) {
                    Log.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + snsInfo + " the media is " + a2);
                    com.tencent.mm.plugin.sns.ad.timeline.video.online.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.video.online.d("MiroMsg.CardAdTimeLineItem");
                    dVar.mContainer = viewGroup;
                    dVar.DzV = a2;
                    dVar.DqO = snsInfo;
                    dVar.rzs = str;
                    dVar.Dzk = c2;
                    dVar.DzW = a3;
                    dVar.a(3, new SnsTimelineVideoView.b() {
                        /* class com.tencent.mm.plugin.sns.ui.item.a.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b
                        public final void Zl(String str) {
                            AppMethodBeat.i(203915);
                            Log.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + str + ", the timelineId is " + a.this.Dzk);
                            if (!Util.isNullOrNil(str) && str.equals(a.this.Dzk)) {
                                a.this.EXV = false;
                                a.c(a.this);
                            }
                            AppMethodBeat.o(203915);
                        }
                    });
                }
            }
            Log.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
            if (!(this.EXR == null || this.EXR.EUK == null)) {
                Log.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
                this.EXR.EUK.EeS.setVisibility(8);
                this.EXR.EUK.Ewv.setVisibility(8);
            }
            this.EXV = true;
            if (baseViewHolder instanceof C1738a) {
                ((C1738a) baseViewHolder).EYi = false;
            }
        }
        AppMethodBeat.o(176412);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void pause() {
        AppMethodBeat.i(176413);
        Log.i("MiroMsg.CardAdTimeLineItem", "pause");
        if (fkp()) {
            fkq();
        }
        AppMethodBeat.o(176413);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void onUIPause() {
        AppMethodBeat.i(177692);
        Log.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
        fkp();
        AppMethodBeat.o(177692);
    }

    private boolean fkp() {
        AppMethodBeat.i(177693);
        if (this.EXR.timeLineObject.ContentObj.LoU == 5 || this.EXR.timeLineObject.ContentObj.LoU == 15) {
            Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", this);
            if (!(this.EXR == null || this.EXR.EUK == null)) {
                this.EXR.EUK.Ews.pause();
                ab(this.DqO);
            }
            this.EXV = false;
            AppMethodBeat.o(177693);
            return true;
        }
        AppMethodBeat.o(177693);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final void stop() {
        AppMethodBeat.i(176414);
        Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", this);
        if (!(this.EXR == null || this.EXR.EUK == null)) {
            this.EXR.EUK.Ews.Dnr.clear();
        }
        this.EXV = false;
        AppMethodBeat.o(176414);
    }

    private void fkq() {
        AppMethodBeat.i(176415);
        Log.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
        if (!(this.EXR == null || this.EXR.EUK == null || this.EXV)) {
            Log.i("MiroMsg.CardAdTimeLineItem", "show play btn");
            this.EXR.EUK.EeS.setVisibility(0);
            this.EXR.EUK.Ewv.setVisibility(8);
            this.EXR.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, R.raw.shortvideo_play_btn));
            this.EXR.EUK.EeS.setContentDescription(this.mActivity.getString(R.string.fn7));
        }
        AppMethodBeat.o(176415);
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a
    public final Rect getDisplayRect() {
        AppMethodBeat.i(176416);
        if (this.EXR == null || this.EXR.qVR == null) {
            AppMethodBeat.o(176416);
            return null;
        }
        int[] iArr = new int[2];
        this.EXR.qVR.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        Rect rect = new Rect(i2, i3, this.EXR.qVR.getMeasuredWidth() + i2, this.EXR.qVR.getMeasuredHeight() + i3);
        AppMethodBeat.o(176416);
        return rect;
    }

    private void ab(SnsInfo snsInfo) {
        AppMethodBeat.i(203916);
        if (!(this.DQX == null || this.DQX.EKl == null || this.DQX.EKl.EoE == null || snsInfo == null)) {
            this.DQX.EKl.EoE.IU(snsInfo.field_snsId);
        }
        AppMethodBeat.o(203916);
    }
}
