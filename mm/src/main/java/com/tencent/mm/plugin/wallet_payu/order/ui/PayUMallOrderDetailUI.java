package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private String AJn = "";
    private TextView CrY;
    private daq ItC;
    private LinearLayout ItD;
    private LinearLayout ItE;
    private LinearLayout ItF;
    private LinearLayout ItG;
    private LinearLayout ItH;
    private LinearLayout ItI;
    private LinearLayout ItJ;
    private TextView ItK;
    private TextView ItL;
    private TextView ItM;
    private TextView ItN;
    private TextView nnA;
    private TextView yQj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72067);
        super.onCreate(bundle);
        addSceneEndListener(1520);
        this.AJn = getInput().getString("key_trans_id");
        if (Util.isNullOrNil(this.AJn)) {
            Log.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        doSceneProgress(new c(this.AJn));
        this.ItD = (LinearLayout) findViewById(R.id.bon);
        this.ItE = (LinearLayout) findViewById(R.id.bny);
        this.ItF = (LinearLayout) findViewById(R.id.bo9);
        this.ItG = (LinearLayout) findViewById(R.id.boe);
        this.ItH = (LinearLayout) findViewById(R.id.bol);
        this.ItI = (LinearLayout) findViewById(R.id.bog);
        this.ItJ = (LinearLayout) findViewById(R.id.boq);
        this.ItK = (TextView) findViewById(R.id.boo);
        this.ItL = (TextView) findViewById(R.id.bnz);
        this.ItM = (TextView) findViewById(R.id.bo_);
        this.CrY = (TextView) findViewById(R.id.bof);
        this.yQj = (TextView) findViewById(R.id.bom);
        this.nnA = (TextView) findViewById(R.id.boh);
        this.ItN = (TextView) findViewById(R.id.bor);
        eDD();
        AppMethodBeat.o(72067);
    }

    private void eDD() {
        AppMethodBeat.i(72068);
        if (this.ItC == null) {
            AppMethodBeat.o(72068);
            return;
        }
        if (!Util.isNullOrNil(this.ItC.AOT)) {
            this.ItD.setVisibility(0);
            this.ItK.setText(this.ItC.AOT);
        } else {
            this.ItD.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.ItC.APc)) {
            this.ItE.setVisibility(0);
            this.ItL.setText(this.ItC.APc);
        } else {
            this.ItE.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.ItC.AOV)) {
            this.ItF.setVisibility(0);
            this.ItM.setText(this.ItC.AOV);
        } else {
            this.ItF.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.ItC.AOY)) {
            this.ItG.setVisibility(0);
            this.CrY.setText(f.d(((double) this.ItC.MFR) / 100.0d, this.ItC.AOY));
        } else {
            this.ItG.setVisibility(8);
        }
        if (this.ItC.CreateTime >= 0) {
            this.ItH.setVisibility(0);
            this.yQj.setText(f.rZ(this.ItC.CreateTime));
        } else {
            this.ItH.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.ItC.AOW)) {
            this.ItI.setVisibility(0);
            this.nnA.setText(this.ItC.AOW);
        } else {
            this.ItI.setVisibility(8);
        }
        switch (this.ItC.APa) {
            case 3:
                this.ItN.setText(R.string.i6s);
                AppMethodBeat.o(72068);
                return;
            case 4:
            default:
                this.ItN.setText(R.string.ioc);
                AppMethodBeat.o(72068);
                return;
            case 5:
                this.ItN.setText(R.string.ie7);
                AppMethodBeat.o(72068);
                return;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72069);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof c) {
                this.ItC = ((c) qVar).ItB;
                eDD();
            }
            AppMethodBeat.o(72069);
            return true;
        }
        AppMethodBeat.o(72069);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(72070);
        super.onDestroy();
        removeSceneEndListener(1520);
        AppMethodBeat.o(72070);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhi;
    }
}
