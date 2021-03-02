package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceTitleCategory extends PreferenceCategory {
    public PreferenceTitleCategory(Context context) {
        this(context, null);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142664);
        if (getLayoutResource() != R.layout.b_a) {
            setLayoutResource(R.layout.b_8);
        }
        AppMethodBeat.o(142664);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142665);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.o(142665);
        } else if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(142665);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            AppMethodBeat.o(142665);
        }
    }
}
