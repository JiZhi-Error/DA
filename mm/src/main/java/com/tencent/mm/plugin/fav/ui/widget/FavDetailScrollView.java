package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavDetailScrollView extends MMLoadScrollView {
    private a tmr;

    public interface a {
        void cWs();

        void cWt();
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public FavDetailScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnScrollChangeListener(a aVar) {
        this.tmr = aVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(107511);
        super.onScrollChanged(i2, i3, i4, i5);
        if (getScrollY() != 0 || this.tmr == null) {
            if (this.tmr != null) {
                this.tmr.cWs();
            }
            AppMethodBeat.o(107511);
            return;
        }
        this.tmr.cWt();
        AppMethodBeat.o(107511);
    }
}
