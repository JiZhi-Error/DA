package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private MMSingelLinePanel BdZ;
    private ArrayList<String> Bea;
    private String title;
    private TextView titleTv;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27012);
        this.Bea = new ArrayList<>();
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27012);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27013);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9c, viewGroup2);
        AppMethodBeat.o(27013);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27014);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.BdZ = (MMSingelLinePanel) view.findViewById(R.id.bcb);
        this.BdZ.setSingleLine(true);
        this.BdZ.OTd = false;
        this.BdZ.Bz(false);
        if (this.titleTv != null) {
            this.titleTv.setText(this.title);
        }
        if (!(this.BdZ == null || this.Bea == null || this.Bea.size() <= 0)) {
            this.BdZ.a(this.Bea, this.Bea);
        }
        super.onBindView(view);
        AppMethodBeat.o(27014);
    }
}
