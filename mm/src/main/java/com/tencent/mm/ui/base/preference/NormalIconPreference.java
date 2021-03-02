package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NormalIconPreference extends IconPreference {
    public NormalIconPreference(Context context) {
        this(context, null);
    }

    public NormalIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NormalIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142626);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(142626);
        return onCreateView;
    }
}
