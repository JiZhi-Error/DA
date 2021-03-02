package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.RangeWidget
    public int getLayoutResource() {
        return R.layout.bt0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.RangeWidget
    public int getMaxTagNameLen() {
        return 10;
    }

    @Override // com.tencent.mm.plugin.sns.ui.RangeWidget
    public final boolean a(int i2, int i3, Intent intent, AtContactWidget atContactWidget) {
        AppMethodBeat.i(98271);
        super.a(i2, i3, intent, atContactWidget);
        if (atContactWidget != null) {
            if (getLabelRange() == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.ffm();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        AppMethodBeat.o(98271);
        return true;
    }
}
