package com.tencent.kinda.framework.sns_cross;

import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class T2BSceneServiceImpl extends BaseSnsSceneService {
    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(18719);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        if (this.mBean.getPayInfo() == null || this.mBean.getPayInfo().iqp == null) {
            AppMethodBeat.o(18719);
        } else {
            Bundle bundle = this.mBean.getPayInfo().iqp;
            String string = bundle.getString("extinfo_key_3");
            String string2 = bundle.getString("extinfo_key_4");
            generateSnsUseCaseData.putString("cashier_desc", this.mBean.getContext().getString(R.string.g23, this.mBean.getContext().getString(R.string.ac4, string, string2) + this.mBean.getTrueName()));
            AppMethodBeat.o(18719);
        }
        return generateSnsUseCaseData;
    }
}
