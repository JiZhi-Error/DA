package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.ui.AARemittanceUI;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class NewAAUseCaseCallback implements ISnsUseCaseCallback {
    private SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
    public void setData(Context context, PayInfo payInfo) {
        AppMethodBeat.i(18712);
        this.mBean = new SnsServiceBean(context, payInfo);
        AppMethodBeat.o(18712);
    }

    @Override // com.tencent.kinda.gen.UseCaseCallback
    public void call(ITransmitKvData iTransmitKvData) {
        int i2;
        AppMethodBeat.i(18713);
        Context context = this.mBean.getContext();
        if (!"1".equals(iTransmitKvData.getString("closeLoading")) || !(context instanceof PaylistAAUI)) {
            String string = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
            if (iTransmitKvData.getInt("retcode") == 1) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            if (context instanceof PaylistAAUI) {
                Intent intent = new Intent();
                intent.putExtra("key_trans_id", string);
                ((PaylistAAUI) context).b(i2, intent);
                AppMethodBeat.o(18713);
                return;
            }
            if (context instanceof AARemittanceUI) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_trans_id", string);
                ((AARemittanceUI) context).b(i2, intent2);
            }
            AppMethodBeat.o(18713);
            return;
        }
        ((PaylistAAUI) context).hideLoading();
        AppMethodBeat.o(18713);
    }
}
