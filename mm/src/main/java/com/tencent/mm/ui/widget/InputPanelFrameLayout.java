package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b;

public class InputPanelFrameLayout extends FrameLayout implements b.a {
    private b QBN;
    private b.a QBO;

    public InputPanelFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPanelFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143322);
        this.QBN = new b(this, this);
        AppMethodBeat.o(143322);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public void f(boolean z, int i2) {
        AppMethodBeat.i(143323);
        if (this.QBO != null) {
            this.QBO.f(z, i2);
        }
        AppMethodBeat.o(143323);
    }

    public b getInputPanelHelper() {
        return this.QBN;
    }

    public void setExternalListener(b.a aVar) {
        this.QBO = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143324);
        this.QBN.aou(i3);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(143324);
    }
}
