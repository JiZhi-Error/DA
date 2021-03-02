package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.b.a;

public final class b extends a {
    k EBv;
    public TextView EUL;
    public TextView EUM;
    public View EUN;
    public Button EUO;
    public Button EUP;
    public View EUQ;
    public ImageView EUR;
    public MaskImageView EUS;
    public SnsCardAdTagListView EUT;
    public View EUU;
    public View EUV;
    public View EUW;
    public View EUX;
    private PromotionBarLayout EUY;
    private int EUZ;
    private av EVa;
    private ax EVb;
    private LivingDescBarLayout EVc;
    private ViewGroup EVd;
    private c EVe;
    private boolean EVf = false;
    private Context context;
    private a pqr;

    public b(TimeLineObject timeLineObject, SnsInfo snsInfo, com.tencent.mm.plugin.sns.ui.d.c cVar, k kVar) {
        this.timeLineObject = timeLineObject;
        this.DsC = snsInfo;
        this.Dyw = cVar;
        this.EBv = kVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x041a A[Catch:{ Throwable -> 0x0550 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0543  */
    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(android.view.View r12, android.view.View r13) {
        /*
        // Method dump skipped, instructions count: 1363
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.c.a.b.n(android.view.View, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x015e A[Catch:{ Throwable -> 0x04f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x04d8  */
    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refreshView() {
        /*
        // Method dump skipped, instructions count: 1279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.c.a.b.refreshView():void");
    }

    @Override // com.tencent.mm.plugin.sns.ui.c.a.a
    public final void onPause() {
        AppMethodBeat.i(203888);
        try {
            Log.i("MicroMsg.CardAdDetailItemView", "onPause, hasPlayedVideo=" + this.EVf);
            if (!(!this.EVf || this.EUK == null || this.EUK.Ews == null)) {
                this.EUK.Ews.pause();
                if (!(this.EBv == null || this.DsC == null)) {
                    this.EBv.IU(this.DsC.field_snsId);
                }
            }
            AppMethodBeat.o(203888);
        } catch (Throwable th) {
            Log.e("MicroMsg.CardAdDetailItemView", "onPause, exp=" + th.toString());
            AppMethodBeat.o(203888);
        }
    }

    private void aa(SnsInfo snsInfo) {
        int kN;
        boolean z = false;
        AppMethodBeat.i(100011);
        if (snsInfo == null || !snsInfo.isCardAd()) {
            AppMethodBeat.o(100011);
            return;
        }
        int color = this.context.getResources().getColor(R.color.fx);
        int color2 = this.context.getResources().getColor(R.color.BW_0_Alpha_0_2);
        if (this.EUO == null || this.EUP == null) {
            AppMethodBeat.o(100011);
            return;
        }
        this.EUO.setOnClickListener(this.Dyw.Fbb);
        this.EUP.setOnClickListener(this.Dyw.Fbc);
        if (!snsInfo.getAdXml().hasVoteInfo() || (kN = y.kN(snsInfo.getAdXml().adVoteInfo.DWX, snsInfo.getUxinfo())) <= 0 || kN > 2) {
            z = true;
        } else if (kN == 1) {
            this.EUP.setTextColor(color2);
            this.EUP.setText(snsInfo.getAdXml().adVoteInfo.YS(1));
            this.EUO.setTextColor(color);
            this.EUO.setText(snsInfo.getAdXml().adVoteInfo.YR(0));
        } else if (kN == 2) {
            this.EUO.setTextColor(color2);
            this.EUO.setText(snsInfo.getAdXml().adVoteInfo.YS(0));
            this.EUP.setTextColor(color);
            this.EUP.setText(snsInfo.getAdXml().adVoteInfo.YR(1));
        }
        if (z) {
            this.EUO.setTextColor(color);
            this.EUP.setTextColor(color);
            this.EUO.setText(snsInfo.getAdXml().getCardSelectLeftTitle());
            this.EUP.setText(snsInfo.getAdXml().getCardSelectRightTitle());
        }
        AppMethodBeat.o(100011);
    }
}
