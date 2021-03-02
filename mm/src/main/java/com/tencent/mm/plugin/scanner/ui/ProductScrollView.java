package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProductScrollView extends ScrollView {
    private a CLb;

    public interface a {
        void cLT();
    }

    public ProductScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProductScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnScrollListener(a aVar) {
        this.CLb = aVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(51848);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.CLb != null) {
            this.CLb.cLT();
        }
        AppMethodBeat.o(51848);
    }
}
