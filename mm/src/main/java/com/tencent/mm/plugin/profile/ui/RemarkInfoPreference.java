package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private TextView BfZ;
    private boolean Bih = false;
    private ImageView gBZ;
    private MMActivity gte;
    private String summary;
    private String title;
    private TextView titleTv;

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27387);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27387);
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27388);
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(R.layout.b_t);
        AppMethodBeat.o(27388);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27389);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9n, viewGroup2);
        AppMethodBeat.o(27389);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27390);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.BfZ = (TextView) view.findViewById(R.id.ied);
        this.gBZ = (ImageView) view.findViewById(R.id.dvz);
        if (!this.Bih) {
            this.gBZ.setVisibility(8);
        } else {
            this.gBZ.setVisibility(0);
        }
        if (this.titleTv != null) {
            this.titleTv.setText(this.title);
        }
        if (this.BfZ != null) {
            this.BfZ.setText(this.summary);
        }
        super.onBindView(view);
        AppMethodBeat.o(27390);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.i(27391);
        String charSequence = this.BfZ.getText().toString();
        AppMethodBeat.o(27391);
        return charSequence;
    }
}
