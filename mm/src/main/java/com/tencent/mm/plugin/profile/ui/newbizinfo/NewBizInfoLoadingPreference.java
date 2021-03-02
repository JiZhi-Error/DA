package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoLoadingPreference extends Preference {
    private ph BiU;
    private boolean BjA = false;
    private MMActivity gte;
    private TextView hPW;
    private ProgressBar hbv;
    private View jxm;
    private boolean rFe = false;
    private int state = 1;

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27520);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27520);
    }

    public NewBizInfoLoadingPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27521);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27521);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27522);
        this.jxm = view.findViewById(R.id.fva);
        this.hPW = (TextView) view.findViewById(R.id.fvb);
        this.hbv = (ProgressBar) view.findViewById(R.id.fvd);
        this.rFe = true;
        if (this.rFe) {
            if (this.state == 1) {
                this.jxm.setVisibility(0);
                this.hbv.setVisibility(0);
                this.hPW.setVisibility(8);
                AppMethodBeat.o(27522);
                return;
            } else if (this.state == 2) {
                this.jxm.setVisibility(0);
                this.hPW.setText(l.a(this.gte, this.BiU.KWe.KQV, (int) this.hPW.getTextSize(), 1));
                this.hPW.setMovementMethod(LinkMovementMethod.getInstance());
                this.hPW.setVisibility(0);
                this.hbv.setVisibility(8);
                AppMethodBeat.o(27522);
                return;
            } else if (this.state == 3) {
                this.jxm.setVisibility(0);
                this.hPW.setText(this.gte.getString(R.string.bh7));
                this.hPW.setVisibility(0);
                this.hbv.setVisibility(8);
                AppMethodBeat.o(27522);
                return;
            } else {
                this.jxm.setVisibility(8);
            }
        }
        AppMethodBeat.o(27522);
    }
}
