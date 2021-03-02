package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.MMActivity;

public final class a extends i {
    private View qjE;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        AppMethodBeat.i(113655);
        this.qjE = findViewById(R.id.ajx);
        AppMethodBeat.o(113655);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113656);
        g cvv = this.qjX.cvv();
        b cvq = this.qjX.cvq();
        MMActivity cvt = this.qjX.cvt();
        e.a cvx = this.qjX.cvx();
        f cvy = this.qjX.cvy();
        if (cvv.cwH()) {
            this.qjE.setVisibility(0);
            findViewById(R.id.bb).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.id.ba);
            TextView textView = (TextView) findViewById(R.id.bc);
            TextView textView2 = (TextView) findViewById(R.id.bg);
            if (cvx.pZc != null) {
                textView.setText(l.b(cvt, ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(cvx.pZc).arI(), textView.getTextSize()));
            }
            if (cvx.gwE == 23) {
                if (!TextUtils.isEmpty(cvq.csQ().Lfa)) {
                    textView2.setText(cvq.csQ().Lfa);
                } else if (!TextUtils.isEmpty(cvq.csQ().pTn)) {
                    textView2.setText(cvt.getString(R.string.arw, new Object[]{cvq.csQ().pTn}));
                } else {
                    textView2.setText(cvt.getString(R.string.arw, new Object[]{cvy.getTitle()}));
                }
            } else if (cvq.csS() != null && !TextUtils.isEmpty(cvq.csS().MXq)) {
                textView2.setText(cvq.csS().MXq);
            } else if (!TextUtils.isEmpty(cvq.csQ().pTn)) {
                if (cvq.csB()) {
                    textView2.setText(cvt.getString(R.string.aqm, new Object[]{cvq.csQ().pTn}));
                } else {
                    textView2.setText(cvt.getString(R.string.api, new Object[]{cvq.csQ().pTn}));
                }
            } else if (cvq.csB()) {
                textView2.setText(cvt.getString(R.string.aqm, new Object[]{cvy.getTitle()}));
            } else {
                textView2.setText(cvt.getString(R.string.api, new Object[]{cvy.getTitle()}));
            }
            a.b.a(imageView, cvx.pZc, 0.15f, false);
            imageView.setOnClickListener(this.qjX.cvu());
            AppMethodBeat.o(113656);
        } else if (!cvv.cwI()) {
            cxw();
            AppMethodBeat.o(113656);
        } else if (!TextUtils.isEmpty(cvq.csQ().Lfa)) {
            this.qjE.setVisibility(0);
            findViewById(R.id.bb).setVisibility(8);
            ((TextView) findViewById(R.id.bg)).setText(cvq.csQ().Lfa);
            AppMethodBeat.o(113656);
        } else {
            this.qjE.setVisibility(8);
            AppMethodBeat.o(113656);
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113657);
        this.qjE.setVisibility(8);
        AppMethodBeat.o(113657);
    }
}
