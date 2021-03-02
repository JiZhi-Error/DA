package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

public class VcardContactLinkPreference extends KeyValuePreference {
    public VcardContactLinkPreference(Context context) {
        super(context);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VcardContactLinkPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.KeyValuePreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(52000);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(52000);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.KeyValuePreference
    public final void onBindView(View view) {
        AppMethodBeat.i(52001);
        super.onBindView(view);
        ((TextView) view.findViewById(16908304)).setTextColor(a.n(this.mContext, R.color.kk));
        AppMethodBeat.o(52001);
    }
}
