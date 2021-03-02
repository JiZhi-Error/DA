package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;

public class BankRemitDetailItemView extends LinearLayout {
    private boolean Cku;
    private TextView jVn;
    private TextView mPa;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(67501);
        this.Cku = false;
        this.Cku = z;
        init();
        AppMethodBeat.o(67501);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67502);
        this.Cku = false;
        init();
        AppMethodBeat.o(67502);
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(67503);
        this.Cku = false;
        init();
        AppMethodBeat.o(67503);
    }

    private void init() {
        AppMethodBeat.i(67504);
        if (this.Cku) {
            inflate(getContext(), R.layout.ib, this);
        } else {
            inflate(getContext(), R.layout.ia, this);
        }
        this.mPa = (TextView) findViewById(R.id.acf);
        this.jVn = (TextView) findViewById(R.id.ace);
        AppMethodBeat.o(67504);
    }

    public final void a(String str, CharSequence charSequence, boolean z) {
        AppMethodBeat.i(67505);
        this.mPa.setText(str);
        if (z) {
            this.jVn.setText(l.b(getContext(), charSequence, this.jVn.getTextSize()));
            AppMethodBeat.o(67505);
            return;
        }
        this.jVn.setText(charSequence);
        AppMethodBeat.o(67505);
    }

    public final void b(int i2, CharSequence charSequence) {
        AppMethodBeat.i(67506);
        a(getContext().getString(i2), charSequence, false);
        AppMethodBeat.o(67506);
    }
}
