package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class LuckMoneyUseCaseCallback implements ISnsUseCaseCallback {
    private SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
    public void setData(Context context, PayInfo payInfo) {
        AppMethodBeat.i(18709);
        this.mBean = new SnsServiceBean(context, payInfo);
        AppMethodBeat.o(18709);
    }

    @Override // com.tencent.kinda.gen.UseCaseCallback
    public void call(ITransmitKvData iTransmitKvData) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(18710);
        Context context = this.mBean.getContext();
        if (context instanceof LuckyMoneyPrepareUI) {
            LuckyMoneyPrepareUI luckyMoneyPrepareUI = (LuckyMoneyPrepareUI) context;
            if (iTransmitKvData.getString("closeLoading").equals("1")) {
                if (luckyMoneyPrepareUI.tipDialog != null && luckyMoneyPrepareUI.tipDialog.isShowing()) {
                    luckyMoneyPrepareUI.tipDialog.dismiss();
                }
                AppMethodBeat.o(18710);
                return;
            }
            int i3 = iTransmitKvData.getInt("retcode");
            String string = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
            PayInfo payInfo = this.mBean.getPayInfo();
            if (i3 == 1) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("key_trans_id", string);
            if (payInfo.iqp != null) {
                z = payInfo.iqp.getBoolean("isF2FHongBao", false);
            }
            if (z) {
                luckyMoneyPrepareUI.i(i2, intent);
                AppMethodBeat.o(18710);
                return;
            }
            luckyMoneyPrepareUI.j(i2, intent);
        }
        AppMethodBeat.o(18710);
    }
}
