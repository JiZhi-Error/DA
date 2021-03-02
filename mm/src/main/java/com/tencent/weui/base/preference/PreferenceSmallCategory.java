package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceSmallCategory extends PreferenceCategory {
    public PreferenceSmallCategory(Context context) {
        this(context, null);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceSmallCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159994);
        setLayoutResource(R.layout.b_1);
        AppMethodBeat.o(159994);
    }
}
