package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;

public final class a extends CardLayoutManager.d {
    private final int DBD;
    private final int DBE;
    private CardLayoutManager.f DBF;

    public a(int i2, int i3) {
        this.DBD = i2;
        this.DBE = i3;
    }

    private static float a(int i2, float f2, int i3) {
        if (i3 == 0) {
            return ((float) i2) - f2;
        }
        return (((float) i2) - (2.0f * f2)) + 1.0f;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.d
    public final boolean Yf(int i2) {
        AppMethodBeat.i(202487);
        CardLayoutManager cardLayoutManager = this.DBz;
        if (cardLayoutManager == null) {
            AppMethodBeat.o(202487);
            return false;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.DBF == null) {
            this.DBF = new CardLayoutManager.f();
        }
        this.DBF.width = size - (this.DBD * 2);
        this.DBF.height = (int) ((((float) this.DBF.width) * 0.75f) + 0.5f);
        cardLayoutManager.setMeasuredDimension(size, this.DBF.height);
        AppMethodBeat.o(202487);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.d
    public final void fe(View view) {
        AppMethodBeat.i(202488);
        CardLayoutManager cardLayoutManager = this.DBz;
        CardLayoutManager.f fVar = this.DBF;
        if (cardLayoutManager == null || view == null || view.getTag(R.id.huu) != null) {
            AppMethodBeat.o(202488);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || fVar == null) {
            AppMethodBeat.o(202488);
            return;
        }
        layoutParams.width = fVar.width;
        layoutParams.height = fVar.height;
        view.setLayoutParams(layoutParams);
        view.setTag(R.id.huu, Boolean.TRUE);
        AppMethodBeat.o(202488);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.d
    public final void a(int i2, float f2, View view, int i3, int i4) {
        int i5;
        boolean z = false;
        AppMethodBeat.i(202489);
        CardLayoutManager cardLayoutManager = this.DBz;
        if (cardLayoutManager == null || this.DBy <= 0 || this.DBx <= 0) {
            AppMethodBeat.o(202489);
        } else if (i3 == 0) {
            if (this.DBx == 0 || this.DBy == 0) {
                i5 = 0;
            } else if (i2 >= 0) {
                i5 = (-i2) % this.DBx;
            } else if (i2 % this.DBx == 0) {
                i5 = 0;
            } else {
                i5 = ((-i2) % this.DBx) - this.DBx;
            }
            cardLayoutManager.layoutDecorated(view, i5, 0, i5 + this.DBx, this.DBy + 0);
            AppMethodBeat.o(202489);
        } else {
            if (i4 == 0 || f2 >= 0.5f) {
                z = true;
            }
            if (z) {
                int round = Math.round(((float) this.DBD) * a(i3, f2, i4));
                int round2 = Math.round(((float) this.DBE) * a(i3, f2, i4));
                cardLayoutManager.layoutDecorated(view, round, round2, round + this.DBx, round2 + this.DBy);
            }
            AppMethodBeat.o(202489);
        }
    }
}
