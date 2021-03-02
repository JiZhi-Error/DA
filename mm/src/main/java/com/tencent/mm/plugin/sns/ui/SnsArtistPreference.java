package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private String Bgn;
    private int CZk;
    private int CZl;
    private TextView EAa;
    String EAb;
    private MMActivity gte;
    private String mTitle;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(98475);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(98475);
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(98476);
        this.Bgn = "";
        this.mTitle = "";
        this.CZk = -1;
        this.CZl = 8;
        this.EAa = null;
        this.EAb = "";
        this.gte = (MMActivity) context;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(98476);
    }

    public final void fhz() {
        AppMethodBeat.i(98477);
        if (!(this.EAa == null || this.EAb == null || this.EAb.equals("") || this.gte == null)) {
            this.EAa.setText(this.gte.getString(R.string.gu7, new Object[]{this.EAb}));
            this.EAa.setVisibility(0);
        }
        AppMethodBeat.o(98477);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(98478);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        this.mTitle = this.gte.getString(R.string.gu8);
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b8l, viewGroup2);
        AppMethodBeat.o(98478);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(98479);
        super.onBindView(view);
        this.EAa = (TextView) view.findViewById(R.id.uw);
        ((TextView) view.findViewById(R.id.ld)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(R.id.ikq);
        if (textView != null) {
            textView.setVisibility(this.CZl);
            textView.setText(this.Bgn);
            if (this.CZk != -1) {
                textView.setBackgroundDrawable(a.l(this.gte, this.CZk));
            }
        }
        fhz();
        AppMethodBeat.o(98479);
    }
}
