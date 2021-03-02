package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class BigIconSummaryPreference extends IconSummaryPreference {
    public BigIconSummaryPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public BigIconSummaryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.IconSummaryPreference, com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142501);
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(R.dimen.i6));
        AppMethodBeat.o(142501);
        return onCreateView;
    }
}
