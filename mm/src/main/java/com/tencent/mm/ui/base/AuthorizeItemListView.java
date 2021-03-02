package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthorizeItemListView extends ListView {
    public int akb;

    public AuthorizeItemListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public AuthorizeItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(131596);
        if (this.akb <= 5) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            AppMethodBeat.o(131596);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(131596);
    }
}
