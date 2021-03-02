package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;

public class TextButtonPreference extends Preference {
    public TextButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextButtonPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final int getLayoutResource() {
        return R.layout.b8n;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142679);
        super.onCreateView(viewGroup);
        View inflate = aa.jQ(this.mContext).inflate(R.layout.b8n, viewGroup, false);
        AppMethodBeat.o(142679);
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142680);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
            textView.setEnabled(isEnabled());
        }
        AppMethodBeat.o(142680);
    }
}
