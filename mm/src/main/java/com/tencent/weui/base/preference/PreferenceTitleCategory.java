package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceTitleCategory extends PreferenceCategory {
    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159995);
        if (getLayoutResource() != R.layout.b_a) {
            setLayoutResource(R.layout.b_8);
        }
        AppMethodBeat.o(159995);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        AppMethodBeat.i(159996);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.o(159996);
        } else if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(159996);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            AppMethodBeat.o(159996);
        }
    }
}
