package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;

public final class f {
    View jBN;
    private MMActivity pQZ;
    b pXs;
    ImageView pXw;
    TextView pXx;
    TextView pXy;

    public f(MMActivity mMActivity, View view) {
        this.pQZ = mMActivity;
        this.jBN = view;
    }

    public final void updateView() {
        AppMethodBeat.i(113091);
        this.pXx.setVisibility(0);
        this.pXw.setImageDrawable(this.pQZ.getResources().getDrawable(R.drawable.c1v));
        this.pXx.setText(R.string.asb);
        this.pXy.setText(R.string.asa);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pXw.getLayoutParams();
        layoutParams.topMargin = this.pQZ.getResources().getDimensionPixelOffset(R.dimen.vw);
        this.pXw.setLayoutParams(layoutParams);
        this.pXw.invalidate();
        AppMethodBeat.o(113091);
    }
}
