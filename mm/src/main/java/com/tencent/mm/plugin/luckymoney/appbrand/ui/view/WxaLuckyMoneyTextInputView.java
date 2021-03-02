package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView extends LinearLayout implements d {
    private TextView mPa;
    private h yPY;
    private MMEditText yRw;

    public WxaLuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65025);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ccy, (ViewGroup) this, true);
        this.yRw = (MMEditText) inflate.findViewById(R.id.f4t);
        this.mPa = (TextView) inflate.findViewById(R.id.f4u);
        this.yRw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView.AnonymousClass1 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(65024);
                if (WxaLuckyMoneyTextInputView.this.yPY != null) {
                    h hVar = WxaLuckyMoneyTextInputView.this.yPY;
                    WxaLuckyMoneyTextInputView.this.getInputViewId();
                    hVar.eeI();
                }
                AppMethodBeat.o(65024);
            }
        });
        c.f(this.yRw).lv(0, 24).CN(false).a((c.a) null);
        AppMethodBeat.o(65025);
    }

    public void setOnInputValidChangerListener(h hVar) {
        this.yPY = hVar;
    }

    public String getInput() {
        AppMethodBeat.i(65026);
        String obj = this.yRw.getText().toString();
        AppMethodBeat.o(65026);
        return obj;
    }

    public void setHintText(String str) {
        AppMethodBeat.i(65027);
        this.yRw.setHint(str);
        AppMethodBeat.o(65027);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(65028);
        this.mPa.setText(str);
        AppMethodBeat.o(65028);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final int eeH() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void restore() {
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void onError() {
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public int getInputViewId() {
        AppMethodBeat.i(65029);
        int id = getId();
        AppMethodBeat.o(65029);
        return id;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final String PA(int i2) {
        return null;
    }
}
