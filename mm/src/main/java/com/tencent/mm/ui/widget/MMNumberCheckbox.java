package com.tencent.mm.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMNumberCheckbox extends AppCompatCheckBox {
    private int HA;

    public MMNumberCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMNumberCheckbox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setNumber(int i2) {
        if (this.HA > 0) {
            this.HA = i2;
        }
    }

    public int getNumber() {
        return this.HA;
    }

    public void setChecked(boolean z) {
        AppMethodBeat.i(143377);
        super.setChecked(z);
        if (z && this.HA > 0 && !String.valueOf(this.HA).contentEquals(getText())) {
            setText(String.valueOf(this.HA));
        }
        if (!z) {
            this.HA = 0;
            setText("");
        }
        AppMethodBeat.o(143377);
    }

    public void setCheckedNumber(int i2) {
        AppMethodBeat.i(143378);
        if (i2 > 0 && i2 != this.HA) {
            this.HA = i2;
            setText(String.valueOf(i2));
            setChecked(true);
        }
        AppMethodBeat.o(143378);
    }
}
