package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends i {
    private View qjP;

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        AppMethodBeat.i(113669);
        b cvq = this.qjX.cvq();
        uo uoVar = cvq.csQ().LeO;
        if (uoVar != null) {
            Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + uoVar.DhD);
            Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + uoVar.text);
            Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + uoVar.gTB);
        }
        if (uoVar == null || TextUtils.isEmpty(uoVar.text) || !cvq.csO()) {
            if (this.qjP != null) {
                this.qjP.setVisibility(8);
            }
            AppMethodBeat.o(113669);
            return;
        }
        if (this.qjP == null) {
            this.qjP = ((ViewStub) findViewById(R.id.ak_)).inflate();
        }
        ((TextView) this.qjP.findViewById(R.id.gm1)).setText(uoVar.text);
        this.qjP.setOnClickListener(this.qjX.cvu());
        AppMethodBeat.o(113669);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        AppMethodBeat.i(113670);
        if (this.qjP != null) {
            this.qjP.setVisibility(8);
        }
        AppMethodBeat.o(113670);
    }
}
