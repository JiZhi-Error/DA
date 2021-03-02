package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.aa;

public class LaunchAAByPersonNameAmountRow extends LinearLayout {
    private TextView hXv;
    private TextView jUP;
    private View jWr;

    public LaunchAAByPersonNameAmountRow(Context context) {
        super(context);
        AppMethodBeat.i(63615);
        init(context);
        AppMethodBeat.o(63615);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63616);
        init(context);
        AppMethodBeat.o(63616);
    }

    public LaunchAAByPersonNameAmountRow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63617);
        init(context);
        AppMethodBeat.o(63617);
    }

    private void init(Context context) {
        AppMethodBeat.i(63618);
        aa.jQ(context).inflate(R.layout.ay9, (ViewGroup) this, true);
        this.hXv = (TextView) findViewById(R.id.j1t);
        this.jUP = (TextView) findViewById(R.id.m6);
        this.jWr = findViewById(R.id.brt);
        AppMethodBeat.o(63618);
    }

    public final void a(String str, String str2, double d2) {
        AppMethodBeat.i(63619);
        this.hXv.setText(l.b(getContext(), ((b) g.af(b.class)).getDisplayName(str, str2), this.hXv.getTextSize()));
        this.jUP.setText(getContext().getString(R.string.k, Double.valueOf(d2)));
        AppMethodBeat.o(63619);
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.i(63620);
        this.jWr.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(63620);
    }
}
