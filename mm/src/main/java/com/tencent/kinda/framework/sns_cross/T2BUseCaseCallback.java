package com.tencent.kinda.framework.sns_cross;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class T2BUseCaseCallback implements ISnsUseCaseCallback {
    private static final int REQ_DETAIL = 2;
    private SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
    public void setData(Context context, PayInfo payInfo) {
        AppMethodBeat.i(18720);
        this.mBean = new SnsServiceBean(context, payInfo);
        AppMethodBeat.o(18720);
    }

    @Override // com.tencent.kinda.gen.UseCaseCallback
    public void call(ITransmitKvData iTransmitKvData) {
        Bundle bundle;
        AppMethodBeat.i(18721);
        Context context = this.mBean.getContext();
        if (context instanceof BankRemitMoneyInputUI) {
            Activity activity = (Activity) context;
            if (iTransmitKvData.getString("closeLoading").equals("1")) {
                ((BankRemitMoneyInputUI) activity).hideLoading();
                AppMethodBeat.o(18721);
                return;
            }
            int i2 = iTransmitKvData.getInt("retcode");
            String string = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
            if (!(i2 != 1 || this.mBean == null || this.mBean.getPayInfo() == null || (bundle = this.mBean.getPayInfo().iqp) == null)) {
                String string2 = bundle.getString("key_transfer_bill_id");
                Intent intent = new Intent(context, BankRemitDetailUI.class);
                intent.putExtra("key_transfer_transaction_id", string);
                intent.putExtra("key_transfer_bill_id", string2);
                intent.putExtra("key_enter_scene", 0);
                BankRemitMoneyInputUI bankRemitMoneyInputUI = (BankRemitMoneyInputUI) activity;
                bankRemitMoneyInputUI.startActivityForResult(intent, 2);
                bankRemitMoneyInputUI.aDI(intent.getStringExtra("key_transfer_transaction_id"));
                bankRemitMoneyInputUI.Cli = 1;
                bankRemitMoneyInputUI.doSceneProgress(new n(bankRemitMoneyInputUI.CkH, bankRemitMoneyInputUI.zfX, 1), false);
            }
        }
        AppMethodBeat.o(18721);
    }
}
