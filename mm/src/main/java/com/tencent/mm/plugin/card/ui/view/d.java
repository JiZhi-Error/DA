package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

public final class d extends i {
    private TextView pWY;
    private View qjM;
    private TextView qjN;
    private TextView qjO;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113665);
        this.qjM = findViewById(R.id.i5);
        this.qjN = (TextView) findViewById(R.id.i6);
        this.pWY = (TextView) findViewById(R.id.hpb);
        this.qjO = (TextView) findViewById(R.id.aon);
        this.qjN.setOnClickListener(this.qjX.cvu());
        this.qjM.setVisibility(8);
        AppMethodBeat.o(113665);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113667);
        this.qjM.setVisibility(8);
        AppMethodBeat.o(113667);
    }

    public final void ajU(String str) {
        AppMethodBeat.i(113668);
        this.qjO.setText(str);
        AppMethodBeat.o(113668);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113666);
        b cvq = this.qjX.cvq();
        MMActivity cvt = this.qjX.cvt();
        this.qjM.setVisibility(0);
        if (!TextUtils.isEmpty(cvq.csQ().LeL)) {
            this.qjN.setVisibility(0);
            this.qjN.setText(cvq.csQ().LeL);
            if (cvq.csw() || (cvq.csv() && cvq.csy())) {
                this.qjN.setTextColor(cvt.getResources().getColor(R.color.ag2));
            } else if (!cvq.csv() || !cvq.csx()) {
                this.qjN.setTextColor(cvt.getResources().getColor(R.color.ag2));
            } else {
                this.qjN.setTextColor(cvt.getResources().getColor(R.color.hj));
                this.qjM.setBackgroundColor(cvt.getResources().getColor(R.color.afz));
            }
        } else {
            this.qjN.setVisibility(8);
        }
        View findViewById = this.qjM.findViewById(R.id.ap3);
        if (this.qjX.cvv().cwU()) {
            findViewById.setVisibility(0);
            this.qjO.setText(cvt.getString(R.string.asl));
            this.qjO.setTextColor(cvt.getResources().getColor(R.color.ag2));
            int dimensionPixelOffset = cvt.getResources().getDimensionPixelOffset(R.dimen.ir);
            Button button = (Button) this.qjM.findViewById(R.id.aol);
            ShapeDrawable e2 = l.e(cvt, cvt.getResources().getColor(R.color.afz), dimensionPixelOffset);
            ShapeDrawable fi = l.fi(cvt.getResources().getColor(R.color.afz), dimensionPixelOffset);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, fi);
            stateListDrawable.addState(new int[0], e2);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = {l.ake(cvq.csQ().ixw), cvt.getResources().getColor(R.color.afz)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.qjX.cvu());
            View findViewById2 = this.qjM.findViewById(R.id.fek);
            View findViewById3 = this.qjM.findViewById(R.id.an2);
            if (cvq.csQ().LeZ == 1) {
                findViewById2.setVisibility(0);
                findViewById3.setVisibility(0);
                AppMethodBeat.o(113666);
                return;
            }
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            AppMethodBeat.o(113666);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(113666);
    }
}
