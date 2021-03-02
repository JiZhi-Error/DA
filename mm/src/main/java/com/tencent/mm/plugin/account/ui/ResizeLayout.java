package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResizeLayout extends LinearLayout {
    private a ksa = null;

    public interface a {
        void bpj();
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChanged(a aVar) {
        this.ksa = aVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(128726);
        if (this.ksa != null) {
            this.ksa.bpj();
        }
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(128726);
    }
}
