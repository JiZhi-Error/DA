package com.tencent.mm.plugin.luckymoney.appbrand.ui;

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
import com.tencent.mm.plugin.luckymoney.appbrand.a.h;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.plugin.luckymoney.ui.d;
import com.tencent.mm.plugin.luckymoney.ui.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView extends LinearLayout implements d {
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView.AnonymousClass1 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(64891);
            if (WxaLuckyMoneyMoneyInputView.this.yPY != null) {
                h hVar = WxaLuckyMoneyMoneyInputView.this.yPY;
                WxaLuckyMoneyMoneyInputView.this.getInputViewId();
                hVar.eeI();
            }
            AppMethodBeat.o(64891);
        }
    };
    private TextView mPa;
    private TenpaySecureEditText yPV;
    private TextView yPW;
    private View yPX;
    private h yPY;
    private o yPZ;
    private double yQa;
    private double yQb;
    public h.a yQc;

    public void setHint(String str) {
        AppMethodBeat.i(64892);
        this.yPV.setHint(str);
        AppMethodBeat.o(64892);
    }

    public WxaLuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(64893);
        a.eex();
        this.yPZ = a.eey().efe();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ccv, (ViewGroup) this, true);
        this.yPV = (TenpaySecureEditText) inflate.findViewById(R.id.f0o);
        this.yPV.addTextChangedListener(this.aws);
        this.mPa = (TextView) inflate.findViewById(R.id.f1q);
        this.yPX = inflate.findViewById(R.id.f1p);
        this.yPW = (TextView) inflate.findViewById(R.id.exz);
        AppMethodBeat.o(64893);
    }

    public void setType(h.a aVar) {
        this.yQc = aVar;
    }

    public double getInput() {
        AppMethodBeat.i(64894);
        double d2 = Util.getDouble(this.yPV.getText().toString(), 0.0d);
        AppMethodBeat.o(64894);
        return d2;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(64895);
        this.mPa.setText(str);
        AppMethodBeat.o(64895);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.i(64896);
        if (z) {
            this.yPX.setVisibility(0);
            AppMethodBeat.o(64896);
            return;
        }
        this.yPX.setVisibility(8);
        AppMethodBeat.o(64896);
    }

    public void setOnInputValidChangerListener(com.tencent.mm.plugin.luckymoney.ui.h hVar) {
        this.yPY = hVar;
    }

    public void setMaxLen(int i2) {
        AppMethodBeat.i(64897);
        this.yPV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        AppMethodBeat.o(64897);
    }

    public void setAmount(String str) {
        AppMethodBeat.i(64898);
        this.yPV.setText(str);
        AppMethodBeat.o(64898);
    }

    public void setMaxAmount(double d2) {
        this.yQa = d2;
    }

    public void setMinAmount(double d2) {
        this.yQb = d2;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final int eeH() {
        AppMethodBeat.i(64899);
        if (Util.isNullOrNil(this.yPV.getText().toString())) {
            AppMethodBeat.o(64899);
            return 0;
        }
        double d2 = Util.getDouble(this.yPV.getText().toString(), -1.0d);
        if (d2 < 0.0d) {
            AppMethodBeat.o(64899);
            return 3;
        } else if (d2 > this.yQa && this.yQa > 0.0d) {
            AppMethodBeat.o(64899);
            return 1;
        } else if (d2 >= this.yQb || d2 <= 0.0d) {
            AppMethodBeat.o(64899);
            return 0;
        } else {
            AppMethodBeat.o(64899);
            return 2;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void restore() {
        AppMethodBeat.i(64900);
        this.mPa.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.yPV.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.yPW.setTextColor(getContext().getResources().getColor(R.color.a2x));
        AppMethodBeat.o(64900);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void onError() {
        AppMethodBeat.i(64901);
        this.mPa.setTextColor(af.gt(getContext()));
        this.yPV.setTextColor(af.gt(getContext()));
        this.yPW.setTextColor(af.gt(getContext()));
        AppMethodBeat.o(64901);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public int getInputViewId() {
        AppMethodBeat.i(64902);
        int id = getId();
        AppMethodBeat.o(64902);
        return id;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final String PA(int i2) {
        AppMethodBeat.i(64903);
        a.eex();
        this.yPZ = a.eey().efe();
        if (i2 == 1) {
            if (this.yQc == h.a.RANDOM_LUCK) {
                String string = getContext().getString(R.string.esj, new StringBuilder().append(Math.round(this.yQa)).toString(), Util.nullAs(this.yPZ.yPB, ""));
                AppMethodBeat.o(64903);
                return string;
            }
            String string2 = getContext().getString(R.string.enw, new StringBuilder().append(Math.round(this.yQa)).toString(), Util.nullAs(this.yPZ.yPB, ""));
            AppMethodBeat.o(64903);
            return string2;
        } else if (i2 == 2) {
            String string3 = getContext().getString(R.string.eny, f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, ""));
            AppMethodBeat.o(64903);
            return string3;
        } else {
            AppMethodBeat.o(64903);
            return null;
        }
    }
}
