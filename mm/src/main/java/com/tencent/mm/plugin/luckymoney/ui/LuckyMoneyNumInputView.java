package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements d {
    private int UYp = 0;
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView.AnonymousClass1 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(65765);
            if (LuckyMoneyNumInputView.this.yPY != null) {
                h hVar = LuckyMoneyNumInputView.this.yPY;
                LuckyMoneyNumInputView.this.getInputViewId();
                hVar.eeI();
            }
            AppMethodBeat.o(65765);
        }
    };
    private TextView mPa;
    private h yPY;
    private o yPZ;
    private TenpaySecureEditText zgm;
    private TextView zgn;
    private int zgo = 1;
    private int zgp = Integer.MAX_VALUE;
    private int zgq = 1;

    public void setHint(String str) {
        AppMethodBeat.i(65766);
        this.zgm.setHint(str);
        AppMethodBeat.o(65766);
    }

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65767);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b46, (ViewGroup) this, true);
        this.mPa = (TextView) inflate.findViewById(R.id.f39);
        this.zgm = (TenpaySecureEditText) inflate.findViewById(R.id.f0o);
        this.zgn = (TextView) inflate.findViewById(R.id.f3_);
        this.zgm.setText(new StringBuilder().append(this.zgo).toString());
        this.zgm.addTextChangedListener(this.aws);
        AppMethodBeat.o(65767);
    }

    public void setMaxNum(int i2) {
        int i3 = 3;
        AppMethodBeat.i(65768);
        this.zgp = i2;
        int i4 = 0;
        while (i2 > 0) {
            i4++;
            i2 /= 10;
        }
        if (i4 > 3) {
            i3 = i4;
        }
        this.zgm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        AppMethodBeat.o(65768);
    }

    public void setMinNum(int i2) {
        this.zgq = i2;
    }

    public int getInput() {
        AppMethodBeat.i(65769);
        try {
            int parseInt = Integer.parseInt(this.zgm.getText().toString(), 10);
            AppMethodBeat.o(65769);
            return parseInt;
        } catch (Exception e2) {
            AppMethodBeat.o(65769);
            return 0;
        }
    }

    public void setNum(String str) {
        AppMethodBeat.i(65770);
        this.zgm.setText(str);
        this.zgm.setSelection(this.zgm.getText().length());
        this.zgo = Util.getInt(str, 0);
        AppMethodBeat.o(65770);
    }

    public void setOnInputValidChangerListener(h hVar) {
        this.yPY = hVar;
    }

    public void setRtxLuckyMoney(int i2) {
        this.UYp = i2;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final int eeH() {
        AppMethodBeat.i(65771);
        if (Util.isNullOrNil(this.zgm.getText().toString())) {
            AppMethodBeat.o(65771);
            return 0;
        }
        int i2 = Util.getInt(this.zgm.getText().toString(), -1);
        if (i2 < 0) {
            AppMethodBeat.o(65771);
            return 3;
        } else if (i2 > this.zgp && this.zgp > 0) {
            AppMethodBeat.o(65771);
            return 1;
        } else if (i2 >= this.zgq || this.zgq <= 0) {
            AppMethodBeat.o(65771);
            return 0;
        } else {
            AppMethodBeat.o(65771);
            return 2;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void restore() {
        AppMethodBeat.i(65772);
        this.mPa.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.zgm.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.zgn.setTextColor(getContext().getResources().getColor(R.color.a2x));
        AppMethodBeat.o(65772);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void onError() {
        AppMethodBeat.i(65773);
        this.mPa.setTextColor(af.gt(getContext()));
        this.zgm.setTextColor(af.gt(getContext()));
        this.zgn.setTextColor(af.gt(getContext()));
        AppMethodBeat.o(65773);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public int getInputViewId() {
        AppMethodBeat.i(65774);
        int id = getId();
        AppMethodBeat.o(65774);
        return id;
    }

    private boolean egl() {
        AppMethodBeat.i(65775);
        if (this.yPZ == null || Util.isNullOrNil(this.yPZ.yUV)) {
            AppMethodBeat.o(65775);
            return false;
        }
        AppMethodBeat.o(65775);
        return true;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final String PA(int i2) {
        AppMethodBeat.i(65776);
        if (this.UYp == 1) {
            a.eex();
            this.yPZ = a.eez().efe();
        } else if (this.UYp == 2) {
            a.eex();
            this.yPZ = a.hWa().efe();
        } else {
            a.eex();
            this.yPZ = a.eey().efe();
        }
        if (i2 == 1) {
            if (egl()) {
                String string = getContext().getString(R.string.equ, Integer.valueOf(this.zgp), this.yPZ.yUV);
                AppMethodBeat.o(65776);
                return string;
            }
            String string2 = getContext().getString(R.string.eqt, Integer.valueOf(this.zgp));
            AppMethodBeat.o(65776);
            return string2;
        } else if (i2 != 2) {
            AppMethodBeat.o(65776);
            return null;
        } else if (egl()) {
            String string3 = getContext().getString(R.string.eqs, Integer.valueOf(this.zgq), this.yPZ.yUV);
            AppMethodBeat.o(65776);
            return string3;
        } else {
            String string4 = getContext().getString(R.string.eqr);
            AppMethodBeat.o(65776);
            return string4;
        }
    }
}
