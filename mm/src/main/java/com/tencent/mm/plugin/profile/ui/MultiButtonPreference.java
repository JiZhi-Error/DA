package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class MultiButtonPreference extends Preference {
    private String Bgn;
    public String Bgo;
    private String Bgp;
    private View.OnClickListener Bgq;
    public View.OnClickListener Bgr;
    private View.OnClickListener Bgs;

    public MultiButtonPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27262);
        setLayoutResource(R.layout.bjk);
        AppMethodBeat.o(27262);
    }

    public MultiButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27263);
        setLayoutResource(R.layout.bjk);
        AppMethodBeat.o(27263);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27264);
        super.onBindView(view);
        Button button = (Button) view.findViewById(R.id.agi);
        View findViewById = view.findViewById(R.id.agj);
        Button button2 = (Button) view.findViewById(R.id.agk);
        View findViewById2 = view.findViewById(R.id.agl);
        Button button3 = (Button) view.findViewById(R.id.agm);
        view.setBackgroundColor(0);
        if (!Util.isNullOrNil(this.Bgn)) {
            button.setVisibility(0);
            button.setText(this.Bgn);
        } else {
            button.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.Bgo)) {
            if (Util.isNullOrNil(this.Bgn)) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            button2.setVisibility(0);
            button2.setText(this.Bgo);
        } else {
            findViewById.setVisibility(8);
            button2.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.Bgp)) {
            if (Util.isNullOrNil(this.Bgo)) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
            }
            button3.setVisibility(0);
            button3.setText(this.Bgp);
        } else {
            findViewById2.setVisibility(8);
            button3.setVisibility(8);
        }
        button.setOnClickListener(this.Bgq);
        button2.setOnClickListener(this.Bgr);
        button3.setOnClickListener(this.Bgs);
        AppMethodBeat.o(27264);
    }

    public final void a(String str, View.OnClickListener onClickListener) {
        this.Bgn = str;
        this.Bgq = onClickListener;
    }
}
