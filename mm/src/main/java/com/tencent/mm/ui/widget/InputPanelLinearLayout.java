package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b;

public class InputPanelLinearLayout extends LinearLayout implements b.a {
    private b QBN;
    private b.a QBO;

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143334);
        this.QBN = new b(this, this);
        AppMethodBeat.o(143334);
    }

    public b getInputPanelHelper() {
        return this.QBN;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143335);
        this.QBN.aou(i3);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(143335);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public void f(boolean z, int i2) {
        AppMethodBeat.i(182572);
        if (this.QBO != null) {
            this.QBO.f(z, i2);
        }
        AppMethodBeat.o(182572);
    }

    public void setExternalListener(b.a aVar) {
        this.QBO = aVar;
    }
}
