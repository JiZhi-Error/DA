package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonRow extends LinearLayout {
    private ImageView jWS;
    private TextView jWT;
    private TextView jWU;
    private WalletFormView jWV;
    private TextView jWW;
    private String username;

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63622);
        init();
        AppMethodBeat.o(63622);
    }

    public LaunchAAByPersonRow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63623);
        init();
        AppMethodBeat.o(63623);
    }

    private void init() {
        AppMethodBeat.i(63624);
        inflate(getContext(), R.layout.ay_, this);
        this.jWS = (ImageView) findViewById(R.id.a7);
        this.jWT = (TextView) findViewById(R.id.aw);
        this.jWV = (WalletFormView) findViewById(R.id.e83);
        this.jWU = (TextView) findViewById(R.id.e84);
        this.jWW = (TextView) findViewById(R.id.ft5);
        AppMethodBeat.o(63624);
    }

    public double getMoneyAmount() {
        AppMethodBeat.i(63625);
        String str = this.jWV.getText().toString();
        if (Util.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.o(63625);
            return 0.0d;
        }
        double d2 = Util.getDouble(str, 0.0d);
        AppMethodBeat.o(63625);
        return d2;
    }

    public void setAmountTextChangeWatcher(TextWatcher textWatcher) {
        AppMethodBeat.i(63626);
        if (textWatcher != null) {
            this.jWV.a(textWatcher);
        }
        AppMethodBeat.o(63626);
    }

    public WalletFormView getAmountEditView() {
        return this.jWV;
    }

    public String getUsername() {
        return this.username;
    }
}
