package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiSummaryPreference extends Preference {
    public String[] Bgt;
    private Context context;
    public String title;

    public MultiSummaryPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(27265);
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27265);
    }

    public MultiSummaryPreference(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(27266);
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27266);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27267);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.bc7, viewGroup2);
        AppMethodBeat.o(27267);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27268);
        super.onBindView(view);
        ((TextView) view.findViewById(R.id.ipm)).setText(this.title);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.iee);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ief);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(8);
        if (this.Bgt == null || this.Bgt.length <= 0) {
            ((View) view.findViewById(R.id.h6o).getParent()).setVisibility(0);
            AppMethodBeat.o(27268);
            return;
        }
        if (this.Bgt.length == 1) {
            ((TextView) linearLayout2.findViewById(R.id.iem)).setText(this.Bgt[0]);
            linearLayout2.setVisibility(0);
        } else if (this.Bgt.length == 2) {
            ((TextView) linearLayout.findViewById(R.id.iel)).setText(this.Bgt[0]);
            linearLayout.setVisibility(0);
            ((TextView) linearLayout2.findViewById(R.id.iem)).setText(this.Bgt[1]);
            linearLayout2.setVisibility(0);
        }
        ((View) view.findViewById(R.id.h6o).getParent()).setVisibility(8);
        AppMethodBeat.o(27268);
    }
}
