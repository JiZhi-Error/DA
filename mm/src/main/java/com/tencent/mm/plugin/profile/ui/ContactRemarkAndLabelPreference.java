package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView BeF;
    private TextView BeG;
    private boolean BeH = false;
    private String BeI;
    private String BeJ;
    private Context mContext;
    private TextView mPa;
    private String sUf;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27044);
        this.mContext = context;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27044);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27045);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) super.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9m, viewGroup2);
        AppMethodBeat.o(27045);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        boolean z;
        AppMethodBeat.i(27046);
        this.mPa = (TextView) view.findViewById(R.id.ipm);
        this.BeF = (TextView) view.findViewById(R.id.h03);
        this.BeG = (TextView) view.findViewById(R.id.e6y);
        if (this.mPa != null && !Util.isNullOrNil(this.sUf)) {
            this.mPa.setVisibility(0);
            this.mPa.setText(this.sUf);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPa.getLayoutParams();
            layoutParams.width = a.aG(this.mContext, R.dimen.em);
            this.mPa.setLayoutParams(layoutParams);
        }
        if (this.BeF != null) {
            if (!this.BeH) {
                this.BeF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                z = false;
            } else {
                this.BeF.setVisibility(0);
                this.BeF.setCompoundDrawablesWithIntrinsicBounds(R.raw.card_photoicon, 0, 0, 0);
                z = true;
            }
            if (!Util.isNullOrNil(this.BeI)) {
                this.BeF.setVisibility(0);
                this.BeF.setText(l.b(this.mContext, Util.nullAsNil(this.BeI), this.BeF.getTextSize()));
                z = true;
            }
        } else {
            z = false;
        }
        if (this.BeG != null && !Util.isNullOrNil(this.BeJ)) {
            z |= true;
            this.BeG.setVisibility(0);
            this.BeG.setText(this.BeJ);
        }
        if (z) {
            ((RelativeLayout.LayoutParams) this.BeF.getLayoutParams()).addRule(15);
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.BeG.getLayoutParams();
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(15);
        }
        super.onBindView(view);
        AppMethodBeat.o(27046);
    }
}
