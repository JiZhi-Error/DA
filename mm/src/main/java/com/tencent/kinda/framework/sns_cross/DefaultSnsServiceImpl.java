package com.tencent.kinda.framework.sns_cross;

import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class DefaultSnsServiceImpl extends BaseSnsSceneService {
    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(18707);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        PayInfo payInfo = this.mBean.getPayInfo();
        if (payInfo == null || payInfo.iqp == null) {
            AppMethodBeat.o(18707);
        } else {
            Bundle bundle = payInfo.iqp;
            generateSnsUseCaseData.putString("cashier_desc", bundle.getString("cashier_desc"));
            generateSnsUseCaseData.putString("succ_tip", bundle.getString("succ_tip"));
            generateSnsUseCaseData.putString("prepay_page_payee", bundle.getString("prepay_page_payee"));
            generateSnsUseCaseData.putBool("need_kinda_cashier_Loading", bundle.getBoolean("need_kinda_cashier_Loading", false));
            AppMethodBeat.o(18707);
        }
        return generateSnsUseCaseData;
    }
}
