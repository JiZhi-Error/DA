package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;

public class RightBelowPreference extends SummaryBelowPreference {
    private CharSequence HII;

    public RightBelowPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RightBelowPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.SummaryBelowPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(69583);
        View onCreateView = super.onCreateView(viewGroup);
        ((ViewGroup) ((ViewGroup) onCreateView.findViewById(R.id.be9)).findViewById(16908312)).addView((ViewGroup) View.inflate(this.mContext, R.layout.c_n, null));
        AppMethodBeat.o(69583);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(69584);
        super.onBindView(view);
        if (!Util.isNullOrNil(this.HII)) {
            ((TextView) view.findViewById(R.id.h74)).setText(this.HII);
        }
        view.findViewById(R.id.h6o).setVisibility(8);
        AppMethodBeat.o(69584);
    }

    public final void S(CharSequence charSequence) {
        AppMethodBeat.i(69585);
        this.HII = charSequence;
        notifyChanged();
        AppMethodBeat.o(69585);
    }
}
