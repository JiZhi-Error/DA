package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.MMActivity;

public final class o extends i {
    private View qko;
    private ImageView qkp;
    private TextView qkq;
    private TextView qkr;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113699);
        this.qko = findViewById(R.id.db3);
        this.qkp = (ImageView) findViewById(R.id.db1);
        this.qkq = (TextView) findViewById(R.id.db5);
        this.qkr = (TextView) findViewById(R.id.db4);
        this.qko.setVisibility(8);
        AppMethodBeat.o(113699);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113700);
        b cvq = this.qjX.cvq();
        MMActivity cvt = this.qjX.cvt();
        e.a cvx = this.qjX.cvx();
        this.qko.setVisibility(0);
        this.qkq.setText(l.b(cvt, ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(cvx.pZc).arI(), this.qkq.getTextSize()));
        if (cvq.csS() != null && !TextUtils.isEmpty(cvq.csS().MXq)) {
            this.qkr.setText(l.b(cvt, cvq.csS().MXq, this.qkr.getTextSize()));
        } else if (!TextUtils.isEmpty(cvq.csQ().pTn)) {
            if (cvq.csB()) {
                this.qkr.setText(cvt.getString(R.string.aqm, new Object[]{cvq.csQ().pTn}));
            } else {
                this.qkr.setText(cvt.getString(R.string.api, new Object[]{cvq.csQ().pTn}));
            }
        } else if (cvq.csB()) {
            this.qkr.setText(cvt.getString(R.string.aqm, new Object[]{this.qjX.cvy().getTitle()}));
        } else {
            this.qkr.setText(cvt.getString(R.string.api, new Object[]{this.qjX.cvy().getTitle()}));
        }
        a.b.c(this.qkp, cvx.pZc);
        this.qkp.setOnClickListener(this.qjX.cvu());
        AppMethodBeat.o(113700);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113701);
        this.qko.setVisibility(8);
        AppMethodBeat.o(113701);
    }
}
