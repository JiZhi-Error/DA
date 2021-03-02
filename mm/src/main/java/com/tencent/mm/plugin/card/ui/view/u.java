package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.ui.MMActivity;

public final class u extends i {
    private View qks;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113707);
        if (this.qks == null) {
            this.qks = ((ViewStub) findViewById(R.id.aob)).inflate();
        }
        b cvq = this.qjX.cvq();
        MMActivity cvt = this.qjX.cvt();
        abz abz = cvq.csR().Lcz;
        if (this.qks != null) {
            TextView textView = (TextView) this.qks.findViewById(R.id.aoc);
            textView.setText(abz.title);
            textView.setTextColor(l.ake(cvq.csQ().ixw));
            TextView textView2 = (TextView) this.qks.findViewById(R.id.aoa);
            LinearLayout linearLayout = (LinearLayout) this.qks.findViewById(R.id.apt);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            if (cvq.csx()) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                if (!TextUtils.isEmpty(abz.pRZ)) {
                    textView2.setText(abz.pRZ);
                    textView2.setVisibility(0);
                    layoutParams.height = cvt.getResources().getDimensionPixelOffset(R.dimen.vj);
                    layoutParams2.bottomMargin = cvt.getResources().getDimensionPixelSize(R.dimen.f3062g);
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = cvt.getResources().getDimensionPixelSize(R.dimen.f3062g);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                } else {
                    textView2.setVisibility(8);
                    layoutParams.height = cvt.getResources().getDimensionPixelOffset(R.dimen.vk);
                }
                layoutParams2.height = cvt.getResources().getDimensionPixelSize(R.dimen.vl);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.h(cvt, cvq.csQ().ixw, cvt.getResources().getDimensionPixelSize(R.dimen.vn)));
                textView.setTextColor(l.ap(cvt, cvq.csQ().ixw));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.qjX.cvu());
            } else {
                if (!TextUtils.isEmpty(abz.pRZ)) {
                    textView2.setText(abz.pRZ);
                    textView2.setVisibility(0);
                    layoutParams.height = cvt.getResources().getDimensionPixelOffset(R.dimen.vx);
                } else {
                    textView2.setVisibility(8);
                    layoutParams.height = cvt.getResources().getDimensionPixelOffset(R.dimen.vy);
                }
                linearLayout.setOnClickListener(this.qjX.cvu());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.qks.invalidate();
            if (cvq.csx()) {
                linearLayout.getLayoutParams();
            }
        }
        AppMethodBeat.o(113707);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113708);
        if (this.qks != null) {
            this.qks.setVisibility(8);
        }
        AppMethodBeat.o(113708);
    }
}
