package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class f extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean qXt = false;
    public boolean qXu = true;
    public boolean qXv = false;
    public boolean qXw = true;
    private List<String> qXx = new LinkedList();

    public f(Context context) {
        super(context);
        AppMethodBeat.i(179051);
        AppMethodBeat.o(179051);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final a d(Context context, View view) {
        AppMethodBeat.i(108323);
        a aVar = new a(context, view);
        aVar.a(this.qYa);
        AppMethodBeat.o(108323);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void clear() {
        AppMethodBeat.i(108324);
        super.clear();
        AppMethodBeat.o(108324);
    }

    public final void df(List<String> list) {
        AppMethodBeat.i(179052);
        this.qXx.clear();
        if (list != null) {
            this.qXx.addAll(list);
        }
        AppMethodBeat.o(179052);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public View b(int i2, View view, ViewGroup viewGroup) {
        EmotionSummary emotionSummary;
        boolean z = true;
        int i3 = 0;
        AppMethodBeat.i(108325);
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f FN = getItem(i2);
        if (this.qXv) {
            FN.qYr = true;
            FN.qYp = false;
            FN.qYq = false;
        }
        if (!(aVar == null || FN == null)) {
            FN.qYq = this.qXw;
            EmotionBannerSet emotionBannerSet = FN.qYm;
            if (emotionBannerSet == null) {
                aVar.FJ(0);
                z = false;
            } else {
                aVar.setTitle(emotionBannerSet.Title);
                aVar.alZ(emotionBannerSet.Desc);
                if (!Util.isNullOrNil(emotionBannerSet.IconUrl)) {
                    q.bcV().a(emotionBannerSet.IconUrl, aVar.cEX(), e.fQ("", emotionBannerSet.IconUrl));
                }
                if (!Util.isNullOrNil(emotionBannerSet.TagUrl)) {
                    q.bcV().a(emotionBannerSet.TagUrl, aVar.cEZ(), e.fQ("", emotionBannerSet.TagUrl));
                    aVar.FI(0);
                } else {
                    aVar.FI(8);
                }
                aVar.FJ(8);
            }
            if (!z && (emotionSummary = FN.qYl) != null) {
                aVar.setTitle(emotionSummary.PackName);
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    q.bcV().loadImage("", aVar.cEX());
                    aVar.cEY();
                } else {
                    q.bcV().a(emotionSummary.IconUrl, aVar.cEX(), e.fQ(emotionSummary.ProductID, emotionSummary.IconUrl));
                }
                boolean fA = com.tencent.mm.plugin.emoji.a.a.e.fA(emotionSummary.PackType, 2);
                if (!TextUtils.isEmpty(emotionSummary.TagUri)) {
                    aVar.cEZ().setImageDrawable(null);
                    aVar.cEZ().setVisibility(0);
                    q.bcV().a(emotionSummary.TagUri, aVar.cEZ(), e.fQ("", emotionSummary.TagUri));
                } else if (fA) {
                    aVar.FI(0);
                    aVar.cFa();
                } else {
                    aVar.FI(8);
                }
                View view2 = aVar.qWO;
                if (!this.qXx.contains(emotionSummary.ProductID)) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
                aVar.alZ(!Util.isNullOrNil(emotionSummary.ExptDesc) ? emotionSummary.ExptDesc : emotionSummary.Introduce);
                if (this.qXt && aVar.qWL != null) {
                    aVar.qWL.setBackgroundResource(R.drawable.qd);
                }
            }
        }
        AppMethodBeat.o(108325);
        return view;
    }

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final void cET() {
            AppMethodBeat.i(108319);
            this.qWN.setVisibility(8);
            cFb();
            this.qWR.setVisibility(8);
            this.qWV.setVisibility(8);
            this.qWW.setVisibility(8);
            this.qWM.setVisibility(0);
            this.mPa.setVisibility(0);
            this.qWT.setVisibility(0);
            this.qWS.setVisibility(0);
            this.qWU.setVisibility(0);
            AppMethodBeat.o(108319);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final boolean cFe() {
            AppMethodBeat.i(108322);
            boolean z = f.this.qXu;
            AppMethodBeat.o(108322);
            return z;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int[] cEU() {
            AppMethodBeat.i(108320);
            int aG = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a2p);
            int[] iArr = {aG, aG};
            AppMethodBeat.o(108320);
            return iArr;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int cEV() {
            AppMethodBeat.i(108321);
            int aG = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a2o);
            AppMethodBeat.o(108321);
            return aG;
        }
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public int cFk() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public void FK(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public int cFl() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public void FL(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public int cFm() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public void FM(int i2) {
    }
}
