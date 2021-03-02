package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private TextView Beb;
    private String knP;
    private TextView mPa;
    private String mTitle;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27015);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27015);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27016);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9e, viewGroup2);
        AppMethodBeat.o(27016);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27017);
        this.mPa = (TextView) view.findViewById(R.id.ipm);
        this.Beb = (TextView) view.findViewById(R.id.fgi);
        if (this.mPa != null) {
            this.mPa.setText(this.mTitle);
        }
        if (this.Beb != null) {
            this.Beb.setText(this.knP);
        }
        super.onBindView(view);
        AppMethodBeat.o(27017);
    }
}
