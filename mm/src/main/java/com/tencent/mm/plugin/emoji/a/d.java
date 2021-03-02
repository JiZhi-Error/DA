package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.protocal.protobuf.EmotionSummary;

public final class d extends com.tencent.mm.plugin.emoji.a.a.a {
    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final a d(Context context, View view) {
        AppMethodBeat.i(108313);
        a aVar = new a(context, view);
        aVar.a(this.qYa);
        AppMethodBeat.o(108313);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final View b(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(108314);
        a aVar = (a) view.getTag();
        f FN = getItem(i2);
        if (!(aVar == null || FN == null)) {
            FN.qYp = false;
            FN.qYq = false;
            EmotionSummary emotionSummary = FN.qYl;
            if (emotionSummary != null) {
                aVar.setTitle(emotionSummary.PackName);
                q.bcV().a(emotionSummary.IconUrl, aVar.cEX(), e.fQ(emotionSummary.ProductID, emotionSummary.IconUrl));
                aVar.alY(com.tencent.mm.pluginsdk.i.f.bQ("yyyy-MM-dd", ((long) emotionSummary.Timestamp) * 1000));
            }
        }
        AppMethodBeat.o(108314);
        return view;
    }

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final void cET() {
            AppMethodBeat.i(108310);
            this.qWN.setVisibility(8);
            this.qWQ.setVisibility(8);
            this.qWP.setVisibility(0);
            this.qWR.setVisibility(8);
            this.qWV.setVisibility(8);
            this.qWW.setVisibility(8);
            this.qWM.setVisibility(0);
            this.mPa.setVisibility(0);
            this.qWT.setVisibility(0);
            this.qWS.setVisibility(0);
            this.qWS.setBackgroundDrawable(null);
            this.qWU.setVisibility(0);
            AppMethodBeat.o(108310);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final boolean cFe() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int[] cEU() {
            AppMethodBeat.i(108311);
            int aG = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a2t);
            int[] iArr = {aG, aG};
            AppMethodBeat.o(108311);
            return iArr;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int cEV() {
            AppMethodBeat.i(108312);
            int aG = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.a2u);
            AppMethodBeat.o(108312);
            return aG;
        }
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFk() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FK(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFl() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FL(int i2) {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final int cFm() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void FM(int i2) {
    }
}
