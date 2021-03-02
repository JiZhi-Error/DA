package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.abz;

public final class z extends i {
    private View qkH;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        boolean z;
        AppMethodBeat.i(113719);
        if (this.qkH == null) {
            this.qkH = ((ViewStub) findViewById(R.id.apc)).inflate();
        }
        abz abz = this.qjX.cvq().csR().Lcw;
        if (this.qkH != null) {
            ((TextView) this.qkH.findViewById(R.id.ilc)).setText(abz.title);
            ((TextView) this.qkH.findViewById(R.id.ilb)).setText(abz.pRY);
            if (!this.qjX.cvv().cwq() || !this.qjX.cvv().cwr()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ((LinearLayout.LayoutParams) ((LinearLayout) this.qkH).getLayoutParams()).bottomMargin = 0;
                AppMethodBeat.o(113719);
                return;
            }
            ((LinearLayout.LayoutParams) ((LinearLayout) this.qkH).getLayoutParams()).bottomMargin = this.qjX.cvt().getResources().getDimensionPixelSize(R.dimen.jv);
        }
        AppMethodBeat.o(113719);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113720);
        if (this.qkH != null) {
            this.qkH.setVisibility(8);
        }
        AppMethodBeat.o(113720);
    }
}
