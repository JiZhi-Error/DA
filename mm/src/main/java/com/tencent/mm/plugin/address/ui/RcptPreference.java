package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.base.preference.Preference;

public class RcptPreference extends Preference {
    RcptItem kuR;

    public RcptPreference(Context context) {
        this(context, null);
    }

    public RcptPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RcptPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(20973);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(20973);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(20974);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9l, viewGroup2);
        AppMethodBeat.o(20974);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(20975);
        super.onBindView(view);
        if (this.kuR == null) {
            AppMethodBeat.o(20975);
            return;
        }
        ((TextView) view.findViewById(R.id.jsn)).setText(this.kuR.name);
        View findViewById = view.findViewById(16908312);
        if (findViewById == null) {
            AppMethodBeat.o(20975);
        } else if (this.kuR.ksW) {
            findViewById.setVisibility(0);
            AppMethodBeat.o(20975);
        } else {
            findViewById.setVisibility(8);
            AppMethodBeat.o(20975);
        }
    }
}
