package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog jZH;

    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final View b(int i2, View view, ViewGroup viewGroup) {
        EmotionSummary emotionSummary;
        AppMethodBeat.i(108304);
        a aVar = (a) view.getTag();
        f FN = getItem(i2);
        if (!(aVar == null || FN == null || (emotionSummary = FN.qYl) == null)) {
            if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                aVar.cEW();
                aVar.cEY();
            } else {
                if (!Util.isNullOrNil(emotionSummary.PackName)) {
                    aVar.setTitle(emotionSummary.PackName);
                } else {
                    aVar.setTitle(emotionSummary.ProductID);
                }
                if (!Util.isNullOrNil(emotionSummary.IconUrl)) {
                    q.bcV().a(emotionSummary.IconUrl, aVar.cEX(), e.fQ(emotionSummary.ProductID, emotionSummary.IconUrl));
                } else {
                    Log.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    aVar.cEX().setImageDrawable(null);
                }
            }
            if (i2 + 1 == getCount()) {
                aVar.qWL.setBackgroundResource(R.drawable.qd);
            }
        }
        AppMethodBeat.o(108304);
        return view;
    }

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final void cET() {
            AppMethodBeat.i(108298);
            this.qWN.setVisibility(8);
            this.qWO.setVisibility(8);
            cFb();
            this.qWR.setVisibility(8);
            this.qWV.setVisibility(8);
            this.qWW.setVisibility(8);
            this.qWM.setVisibility(0);
            this.mPa.setVisibility(0);
            this.qWT.setVisibility(0);
            this.qWS.setVisibility(0);
            this.qWU.setVisibility(0);
            AppMethodBeat.o(108298);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final boolean a(j.a aVar, View view) {
            AppMethodBeat.i(108299);
            cFc();
            boolean a2 = super.a(aVar, view);
            AppMethodBeat.o(108299);
            return a2;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final void b(j.a aVar, View view) {
            int i2;
            AppMethodBeat.i(108300);
            super.b(aVar, view);
            if (com.tencent.mm.plugin.emoji.h.a.ang(getProductId())) {
                dp dpVar = new dp();
                dpVar.dGC.productId = getProductId();
                dp.a aVar2 = dpVar.dGC;
                if (com.tencent.mm.plugin.emoji.h.a.cHz()) {
                    i2 = 7;
                } else {
                    i2 = 3;
                }
                aVar2.status = i2;
                dpVar.dGC.progress = getProgress();
                dpVar.dGC.dGD = this.qWK.qYo;
                EventCenter.instance.publish(dpVar);
            }
            AppMethodBeat.o(108300);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int cEV() {
            return -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final boolean cFe() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.emoji.a.a
        public final int[] cEU() {
            AppMethodBeat.i(108301);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.f3064i);
            int[] iArr = {dimensionPixelSize, dimensionPixelSize};
            AppMethodBeat.o(108301);
            return iArr;
        }

        @Override // com.tencent.mm.plugin.emoji.a.a
        public final void cFh() {
            AppMethodBeat.i(108302);
            if (this.qWK == null) {
                AppMethodBeat.o(108302);
                return;
            }
            switch (cFc()) {
                case 0:
                case 3:
                    this.qWR.setVisibility(8);
                    this.qWS.setBackgroundResource(R.drawable.k7);
                    this.qWS.setVisibility(0);
                    this.qWU.setVisibility(0);
                    this.qWU.setText(R.string.bu7);
                    this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
                    this.qWV.setVisibility(4);
                    this.qWV.setImageResource(R.drawable.emoji_download);
                    this.qWW.setVisibility(4);
                    AppMethodBeat.o(108302);
                    return;
                case 6:
                    cFf();
                    AppMethodBeat.o(108302);
                    return;
                default:
                    this.qWR.setVisibility(8);
                    this.qWS.setBackgroundResource(R.drawable.kd);
                    this.qWS.setVisibility(0);
                    this.qWU.setVisibility(0);
                    this.qWU.setText(R.string.bw0);
                    this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.fu));
                    this.qWV.setVisibility(4);
                    this.qWV.setImageResource(R.drawable.emoji_download);
                    this.qWW.setVisibility(4);
                    AppMethodBeat.o(108302);
                    return;
            }
        }
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final a d(Context context, View view) {
        AppMethodBeat.i(108305);
        a aVar = new a(context, view);
        aVar.a(this.qYa);
        AppMethodBeat.o(108305);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final com.tencent.mm.plugin.emoji.a.a.c a(g gVar) {
        AppMethodBeat.i(108306);
        d dVar = new d(gVar);
        AppMethodBeat.o(108306);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void dc(String str, int i2) {
        AppMethodBeat.i(108307);
        if (i2 == 7) {
            super.dc(str, i2);
        }
        AppMethodBeat.o(108307);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void cFj() {
        AppMethodBeat.i(108309);
        super.cFj();
        AppMethodBeat.o(108309);
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

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(108303);
        if (this.qXZ == null) {
            this.qXZ = a((g) null);
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(108303);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.a
    public final void clear() {
        AppMethodBeat.i(108308);
        if (this.jZH != null) {
            this.jZH.cancel();
        }
        super.clear();
        AppMethodBeat.o(108308);
    }
}
