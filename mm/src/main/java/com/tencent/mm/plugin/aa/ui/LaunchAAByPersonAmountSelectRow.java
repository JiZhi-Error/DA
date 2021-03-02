package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView gyr;
    private TextView hXv;
    private WalletFormView jWq;
    private View jWr;
    private TextWatcher jWs = null;
    private String username;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(63580);
        init(context);
        AppMethodBeat.o(63580);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(63581);
        init(context);
        AppMethodBeat.o(63581);
    }

    private void init(Context context) {
        AppMethodBeat.i(63582);
        aa.jQ(context).inflate(R.layout.ay7, (ViewGroup) this, true);
        this.gyr = (ImageView) findViewById(R.id.wm);
        this.hXv = (TextView) findViewById(R.id.j1t);
        this.jWq = (WalletFormView) findViewById(R.id.fjd);
        this.jWr = findViewById(R.id.brt);
        AppMethodBeat.o(63582);
    }

    public void setTextWatcher(TextWatcher textWatcher) {
        AppMethodBeat.i(63583);
        this.jWs = textWatcher;
        this.jWq.a(textWatcher);
        AppMethodBeat.o(63583);
    }

    public WalletFormView getMoneyEdit() {
        return this.jWq;
    }

    public String getUsername() {
        return this.username;
    }

    public double getAmount() {
        AppMethodBeat.i(63584);
        String str = this.jWq.getText().toString();
        if (Util.isNullOrNil(str) || "".equals(str)) {
            AppMethodBeat.o(63584);
            return 0.0d;
        }
        double d2 = Util.getDouble(str, 0.0d);
        AppMethodBeat.o(63584);
        return d2;
    }

    public void setDividerVisible(boolean z) {
        AppMethodBeat.i(63585);
        this.jWr.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(63585);
    }
}
