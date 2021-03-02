package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;

public final class c extends i {
    private View qjK;
    private TextView qjL;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113663);
        if (this.qjK == null) {
            this.qjK = ((ViewStub) findViewById(R.id.ak7)).inflate();
            this.qjL = (TextView) this.qjK.findViewById(R.id.ak8);
        }
        this.qjK.setVisibility(0);
        this.qjK.setOnClickListener(this.qjX.cvu());
        b cvq = this.qjX.cvq();
        if (!TextUtils.isEmpty(cvq.csQ().LeS.LqC)) {
            this.qjL.setText(cvq.csQ().LeS.LqC);
            AppMethodBeat.o(113663);
            return;
        }
        this.qjL.setText(getString(R.string.arb));
        AppMethodBeat.o(113663);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113664);
        if (this.qjK != null) {
            this.qjK.setVisibility(8);
        }
        AppMethodBeat.o(113664);
    }
}
