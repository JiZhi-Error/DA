package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileDescribePreference extends Preference {
    public cn BzG;
    private ProfileDescribeView Kqf;
    public as rjX;
    private View zlc;

    public ProfileDescribePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ProfileDescribePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31904);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            ProfileDescribeView profileDescribeView = new ProfileDescribeView(onCreateView.getContext());
            this.Kqf = profileDescribeView;
            viewGroup2.addView(profileDescribeView, new AbsListView.LayoutParams(-1, -2));
            this.Kqf.aj(this.rjX);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(31904);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31905);
        super.onBindView(view);
        if (this.rjX == null) {
            AppMethodBeat.o(31905);
            return;
        }
        this.Kqf.eEV();
        AppMethodBeat.o(31905);
    }
}
