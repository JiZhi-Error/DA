package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SummaryBelowPreference extends Preference {
    private View mView;

    public SummaryBelowPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SummaryBelowPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142673);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142673);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142674);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.b_v, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(142674);
        return view;
    }
}
