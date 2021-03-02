package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class F2fDynamicCodeItemLayout extends LinearLayout {
    TextView Cqw;
    TextView qWU;

    public F2fDynamicCodeItemLayout(Context context) {
        super(context);
        AppMethodBeat.i(67917);
        init();
        AppMethodBeat.o(67917);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67918);
        init();
        AppMethodBeat.o(67918);
    }

    public F2fDynamicCodeItemLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(67919);
        init();
        AppMethodBeat.o(67919);
    }

    private void init() {
        AppMethodBeat.i(67920);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bmr, this);
        this.Cqw = (TextView) inflate.findViewById(R.id.h6g);
        this.qWU = (TextView) inflate.findViewById(R.id.h6h);
        AppMethodBeat.o(67920);
    }
}
