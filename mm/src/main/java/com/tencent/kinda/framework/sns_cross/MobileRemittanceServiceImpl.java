package com.tencent.kinda.framework.sns_cross;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MobileRemittanceServiceImpl extends BaseSnsSceneService {
    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(214458);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        if (this.mBean.getPayInfo() == null || this.mBean.getPayInfo().iqp == null) {
            AppMethodBeat.o(214458);
        } else {
            generateSnsUseCaseData.putString("cashier_desc", this.mBean.getPayInfo().iqp.getString("extinfo_key_12"));
            AppMethodBeat.o(214458);
        }
        return generateSnsUseCaseData;
    }
}
