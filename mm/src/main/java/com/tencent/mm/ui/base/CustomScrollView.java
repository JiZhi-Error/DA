package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomScrollView extends ScrollView {
    private a OOb;

    public interface a {
        void a(ScrollView scrollView, int i2, int i3);
    }

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnScrollChangeListener(a aVar) {
        this.OOb = aVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159150);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.OOb != null) {
            this.OOb.a(this, i3, i5);
        }
        AppMethodBeat.o(159150);
    }
}
