package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private int HIJ;
    private String HIK;
    private int HIL;
    private TextView HMo;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(69843);
        this.HIJ = -1;
        this.HIK = "";
        this.HIL = 8;
        setLayoutResource(R.layout.ba0);
        AppMethodBeat.o(69843);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(69844);
        super.onBindView(view);
        this.HMo = (TextView) view.findViewById(R.id.iou);
        fZ(this.HIK, this.HIJ);
        aez(this.HIL);
        AppMethodBeat.o(69844);
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void fZ(String str, int i2) {
        AppMethodBeat.i(69845);
        this.HIJ = i2;
        this.HIK = str;
        if (this.HMo != null) {
            if (this.HIJ > 0) {
                this.HMo.setBackgroundResource(this.HIJ);
            }
            if (!TextUtils.isEmpty(this.HIK)) {
                this.HMo.setText(this.HIK);
            }
        }
        AppMethodBeat.o(69845);
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void aez(int i2) {
        AppMethodBeat.i(69846);
        this.HIL = i2;
        if (this.HMo != null) {
            this.HMo.setVisibility(i2);
        }
        AppMethodBeat.o(69846);
    }
}
