package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceFooterCategory extends Preference {
    public PreferenceFooterCategory(Context context) {
        super(context);
        AppMethodBeat.i(205305);
        setLayoutResource(R.layout.b__);
        AppMethodBeat.o(205305);
    }

    public PreferenceFooterCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142656);
        setLayoutResource(R.layout.b__);
        AppMethodBeat.o(142656);
    }

    public PreferenceFooterCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142657);
        setLayoutResource(R.layout.b__);
        AppMethodBeat.o(142657);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142658);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.o(142658);
        } else if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(142658);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            AppMethodBeat.o(142658);
        }
    }
}
