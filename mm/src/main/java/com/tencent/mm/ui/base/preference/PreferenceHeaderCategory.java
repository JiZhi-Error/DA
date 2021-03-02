package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceHeaderCategory extends Preference {
    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceHeaderCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142659);
        setLayoutResource(R.layout.b_1);
        AppMethodBeat.o(142659);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142660);
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(16908310).setBackgroundResource(R.drawable.b9x);
        AppMethodBeat.o(142660);
        return onCreateView;
    }
}
