package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView dPk;
    private MMActivity pQZ;
    View pXr;
    b pXs;
    protected LinearLayout pXt;
    protected LinearLayout pXu;
    private TextView pXv;

    public e(MMActivity mMActivity) {
        this.pQZ = mMActivity;
    }

    public final void cuI() {
        AppMethodBeat.i(113084);
        if (this.pXr == null) {
            this.pXr = View.inflate(this.pQZ, R.layout.o_, null);
            this.dPk = (ImageView) this.pXr.findViewById(R.id.ki);
            this.pXv = (TextView) this.pXr.findViewById(R.id.hr6);
            this.pXt = (LinearLayout) this.pXr.findViewById(R.id.epm);
            this.pXu = (LinearLayout) this.pXr.findViewById(R.id.epf);
            this.pXt.setVisibility(8);
            this.pXu.setVisibility(8);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.dPk.startAnimation(rotateAnimation);
        }
        updateView();
        AppMethodBeat.o(113084);
    }

    private void cuJ() {
        AppMethodBeat.i(113085);
        this.pXt.setVisibility(8);
        this.pXu.setVisibility(8);
        AppMethodBeat.o(113085);
    }

    public final void cuK() {
        AppMethodBeat.i(113086);
        this.pXt.setVisibility(0);
        this.pXu.setVisibility(8);
        AppMethodBeat.o(113086);
    }

    public final void cuL() {
        AppMethodBeat.i(113087);
        this.pXt.setVisibility(8);
        AppMethodBeat.o(113087);
    }

    private void cuM() {
        AppMethodBeat.i(113088);
        this.pXt.setVisibility(8);
        this.pXu.setVisibility(8);
        AppMethodBeat.o(113088);
    }

    public final void cnh() {
        AppMethodBeat.i(113089);
        cuM();
        this.pXv.setVisibility(8);
        AppMethodBeat.o(113089);
    }

    public final void updateView() {
        AppMethodBeat.i(113090);
        Integer num = (Integer) am.ctV().getValue("key_share_card_show_type");
        if (num == null) {
            num = 0;
        }
        if (this.pXs == null || !b.cuB() || (!(num.intValue() == 1 || num.intValue() == 4) || !b.cuy())) {
            this.pXv.setVisibility(8);
            if (this.pXs != null) {
                Log.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", Boolean.valueOf(b.cuB()), Boolean.valueOf(b.cuC()));
                if (!b.cuB() || !b.cuC()) {
                    cuK();
                    AppMethodBeat.o(113090);
                    return;
                }
                if (b.cuB() && b.cuC()) {
                    cuJ();
                    AppMethodBeat.o(113090);
                    return;
                }
                AppMethodBeat.o(113090);
            }
        } else {
            this.pXv.setVisibility(0);
        }
        cuM();
        AppMethodBeat.o(113090);
    }
}
