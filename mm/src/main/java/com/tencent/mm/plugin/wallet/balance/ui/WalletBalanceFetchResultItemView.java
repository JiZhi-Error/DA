package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public class WalletBalanceFetchResultItemView extends LinearLayout {
    private boolean Cku;
    private TextView jVn;
    private TextView mPa;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        AppMethodBeat.i(68563);
        this.Cku = false;
        this.Cku = z;
        init();
        AppMethodBeat.o(68563);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(68564);
        this.Cku = false;
        init();
        AppMethodBeat.o(68564);
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(68565);
        this.Cku = false;
        init();
        AppMethodBeat.o(68565);
    }

    private void init() {
        AppMethodBeat.i(68566);
        if (this.Cku) {
            inflate(getContext(), R.layout.ib, this);
        } else {
            inflate(getContext(), R.layout.ia, this);
        }
        this.mPa = (TextView) findViewById(R.id.acf);
        this.jVn = (TextView) findViewById(R.id.ace);
        AppMethodBeat.o(68566);
    }

    public final void a(String str, CharSequence charSequence, String str2, String str3, boolean z) {
        AppMethodBeat.i(68567);
        this.mPa.setText(str);
        if (!Util.isNullOrNil(str2)) {
            this.mPa.setTextColor(g.cI(str2, true));
        }
        if (z) {
            this.jVn.setText(l.b(getContext(), charSequence, this.jVn.getTextSize()));
        } else {
            this.jVn.setText(charSequence);
        }
        if (!Util.isNullOrNil(str3)) {
            this.jVn.setTextColor(g.cI(str3, true));
        }
        AppMethodBeat.o(68567);
    }

    public final void b(int i2, CharSequence charSequence) {
        AppMethodBeat.i(68568);
        a(getContext().getString(i2), charSequence, "", "", false);
        AppMethodBeat.o(68568);
    }
}
