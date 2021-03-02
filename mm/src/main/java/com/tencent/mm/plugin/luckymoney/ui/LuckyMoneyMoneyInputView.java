package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements d {
    private int UYp = 0;
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView.AnonymousClass1 */

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(65616);
            if (LuckyMoneyMoneyInputView.this.yPY != null) {
                h hVar = LuckyMoneyMoneyInputView.this.yPY;
                LuckyMoneyMoneyInputView.this.getInputViewId();
                hVar.eeI();
            }
            AppMethodBeat.o(65616);
        }
    };
    private TextView mPa;
    public int mType;
    private TenpaySecureEditText yPV;
    private TextView yPW;
    private h yPY;
    private o yPZ;
    private double yQa;
    private double yQb;
    private ImageView yQv;

    public void setHint(String str) {
        AppMethodBeat.i(65617);
        this.yPV.setHint(str);
        AppMethodBeat.o(65617);
    }

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65618);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.b3z, (ViewGroup) this, true);
        this.yPV = (TenpaySecureEditText) inflate.findViewById(R.id.f0o);
        this.yPV.setTypeface(f.aS(context, 3));
        this.yPV.addTextChangedListener(this.aws);
        this.mPa = (TextView) inflate.findViewById(R.id.f1q);
        this.yQv = (ImageView) inflate.findViewById(R.id.f1p);
        this.yPW = (TextView) inflate.findViewById(R.id.exz);
        AppMethodBeat.o(65618);
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public double getInput() {
        AppMethodBeat.i(65619);
        double d2 = Util.getDouble(this.yPV.getText().toString(), 0.0d);
        AppMethodBeat.o(65619);
        return d2;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(65620);
        this.mPa.setText(str);
        AppMethodBeat.o(65620);
    }

    public void setShowGroupIcon(boolean z) {
        AppMethodBeat.i(65621);
        if (z) {
            this.yQv.setVisibility(0);
            AppMethodBeat.o(65621);
            return;
        }
        this.yQv.setVisibility(8);
        AppMethodBeat.o(65621);
    }

    public void setGroupIconIv(int i2) {
        AppMethodBeat.i(65622);
        this.yQv.setImageResource(i2);
        AppMethodBeat.o(65622);
    }

    public void setOnInputValidChangerListener(h hVar) {
        this.yPY = hVar;
    }

    public void setMaxLen(int i2) {
        AppMethodBeat.i(65623);
        this.yPV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        AppMethodBeat.o(65623);
    }

    public void setAmount(String str) {
        AppMethodBeat.i(65624);
        this.yPV.setText(str);
        this.yPV.setSelection(str.length());
        AppMethodBeat.o(65624);
    }

    public void setMaxAmount(double d2) {
        this.yQa = d2;
    }

    public void setMinAmount(double d2) {
        this.yQb = d2;
    }

    public void setRtxLuckyMoney(int i2) {
        this.UYp = i2;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final int eeH() {
        AppMethodBeat.i(65625);
        if (Util.isNullOrNil(this.yPV.getText().toString())) {
            AppMethodBeat.o(65625);
            return 0;
        }
        double d2 = Util.getDouble(this.yPV.getText().toString(), -1.0d);
        if (d2 < 0.0d) {
            AppMethodBeat.o(65625);
            return 3;
        } else if (d2 > this.yQa && this.yQa > 0.0d) {
            AppMethodBeat.o(65625);
            return 1;
        } else if (d2 >= this.yQb || d2 <= 0.0d) {
            AppMethodBeat.o(65625);
            return 0;
        } else {
            AppMethodBeat.o(65625);
            return 2;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void restore() {
        AppMethodBeat.i(65626);
        this.mPa.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.yPV.setTextColor(getContext().getResources().getColor(R.color.a2x));
        this.yPW.setTextColor(getContext().getResources().getColor(R.color.a2x));
        AppMethodBeat.o(65626);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final void onError() {
        AppMethodBeat.i(65627);
        this.mPa.setTextColor(af.gt(getContext()));
        this.yPV.setTextColor(af.gt(getContext()));
        this.yPW.setTextColor(af.gt(getContext()));
        AppMethodBeat.o(65627);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public int getInputViewId() {
        AppMethodBeat.i(65628);
        int id = getId();
        AppMethodBeat.o(65628);
        return id;
    }

    private boolean egl() {
        AppMethodBeat.i(65629);
        if (this.yPZ == null || Util.isNullOrNil(this.yPZ.yUV)) {
            AppMethodBeat.o(65629);
            return false;
        }
        AppMethodBeat.o(65629);
        return true;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.d
    public final String PA(int i2) {
        AppMethodBeat.i(65630);
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
            if (this.mType == 1) {
                String string = getContext().getString(R.string.esj, new StringBuilder().append(Math.round(this.yQa)).toString(), Util.nullAs(this.yPZ.yPB, ""));
                AppMethodBeat.o(65630);
                return string;
            } else if (egl()) {
                String string2 = getContext().getString(R.string.enx, this.yPZ.yUV, new StringBuilder().append(Math.round(this.yQa)).toString(), Util.nullAs(this.yPZ.yPB, ""));
                AppMethodBeat.o(65630);
                return string2;
            } else {
                String string3 = getContext().getString(R.string.enw, new StringBuilder().append(Math.round(this.yQa)).toString(), Util.nullAs(this.yPZ.yPB, ""));
                AppMethodBeat.o(65630);
                return string3;
            }
        } else if (i2 != 2) {
            AppMethodBeat.o(65630);
            return null;
        } else if (egl()) {
            String string4 = getContext().getString(R.string.enz, this.yPZ.yUV, f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, ""));
            AppMethodBeat.o(65630);
            return string4;
        } else {
            String string5 = getContext().getString(R.string.eny, f.formatMoney2f(this.yQb), Util.nullAs(this.yPZ.yPB, ""));
            AppMethodBeat.o(65630);
            return string5;
        }
    }
}
