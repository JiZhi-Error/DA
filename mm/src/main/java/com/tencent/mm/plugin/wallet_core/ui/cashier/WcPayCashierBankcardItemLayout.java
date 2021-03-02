package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierBankcardItemLayout extends LinearLayout {
    public FavourLayout Iga;
    public TextView Ild;
    public TextView Ile;
    public RadioButton Ilf;
    public CdnImageView qgQ;

    public WcPayCashierBankcardItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(71320);
        init();
        AppMethodBeat.o(71320);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71321);
        init();
        AppMethodBeat.o(71321);
    }

    public WcPayCashierBankcardItemLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71322);
        init();
        AppMethodBeat.o(71322);
    }

    private void init() {
        AppMethodBeat.i(71323);
        View.inflate(getContext(), R.layout.caq, this);
        this.qgQ = (CdnImageView) findViewById(R.id.joz);
        this.Ild = (TextView) findViewById(R.id.jp1);
        this.Ile = (TextView) findViewById(R.id.jp2);
        this.Ilf = (RadioButton) findViewById(R.id.jp6);
        this.Iga = (FavourLayout) findViewById(R.id.jp4);
        AppMethodBeat.o(71323);
    }
}
