package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class OnLayoutChangedLinearLayout extends DrawnCallBackLinearLayout {
    public a OWo;

    public interface a {
        void gJw();
    }

    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public OnLayoutChangedLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnChattingLayoutChangedListener(a aVar) {
        this.OWo = aVar;
    }

    @Override // com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142450);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.OWo != null) {
            this.OWo.gJw();
        }
        AppMethodBeat.o(142450);
    }
}
