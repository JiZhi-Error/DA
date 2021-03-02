package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMLoadScrollView extends ScrollView {
    private a QCS;

    public interface a {
        void cIe();
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MMLoadScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(143362);
        if (z2 && i3 > 0 && this.QCS != null) {
            this.QCS.cIe();
        }
        super.onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(143362);
    }

    public void setOnTopOrBottomListerner(a aVar) {
        this.QCS = aVar;
    }
}
