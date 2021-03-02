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
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference extends Preference {
    private ImageView Bec;
    private ImageView Bed;
    private ImageView Bee;
    private ImageView Bef;
    private ImageView Beg;
    private ImageView Beh;
    private int Bei = 8;
    private int Bej = 8;
    private int Bek = 8;
    private int Bel = 8;
    private int Bem = 8;
    private int Ben = 8;
    private TextView qbV;

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27018);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(27018);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(27019);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9f, viewGroup2);
        AppMethodBeat.o(27019);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27020);
        this.Bec = (ImageView) view.findViewById(R.id.dwb);
        this.Bed = (ImageView) view.findViewById(R.id.dwj);
        this.Bee = (ImageView) view.findViewById(R.id.dw8);
        this.Bef = (ImageView) view.findViewById(R.id.dvj);
        this.Beg = (ImageView) view.findViewById(R.id.dvt);
        this.Beh = (ImageView) view.findViewById(R.id.dws);
        this.qbV = (TextView) view.findViewById(R.id.ipm);
        updateView();
        super.onBindView(view);
        AppMethodBeat.o(27020);
    }

    public final void UF(int i2) {
        AppMethodBeat.i(27021);
        this.Bej = i2;
        updateView();
        AppMethodBeat.o(27021);
    }

    public final void UG(int i2) {
        AppMethodBeat.i(27022);
        this.Bek = i2;
        updateView();
        AppMethodBeat.o(27022);
    }

    public final void UH(int i2) {
        AppMethodBeat.i(27023);
        this.Bem = i2;
        updateView();
        AppMethodBeat.o(27023);
    }

    public final void UI(int i2) {
        AppMethodBeat.i(27024);
        this.Ben = i2;
        updateView();
        AppMethodBeat.o(27024);
    }

    private void updateView() {
        AppMethodBeat.i(27025);
        if (this.Bec != null) {
            this.Bec.setVisibility(this.Bei);
        }
        if (this.Bed != null) {
            this.Bed.setVisibility(this.Bej);
        }
        if (this.Bee != null) {
            this.Bee.setVisibility(this.Bek);
        }
        if (this.Bef != null) {
            this.Bef.setVisibility(this.Bel);
        }
        if (this.Beg != null) {
            this.Beg.setVisibility(this.Bem);
        }
        if (this.qbV != null) {
            ViewGroup.LayoutParams layoutParams = this.qbV.getLayoutParams();
            layoutParams.width = a.aG(this.mContext, R.dimen.em);
            this.qbV.setLayoutParams(layoutParams);
        }
        if (this.Beh != null) {
            this.Beh.setVisibility(this.Ben);
        }
        AppMethodBeat.o(27025);
    }
}
