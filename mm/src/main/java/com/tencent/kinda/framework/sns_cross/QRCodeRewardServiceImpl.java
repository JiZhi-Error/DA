package com.tencent.kinda.framework.sns_cross;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;

/* access modifiers changed from: package-private */
public class QRCodeRewardServiceImpl extends BaseSnsSceneService {
    QRCodeRewardServiceImpl() {
    }

    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(18714);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        generateSnsUseCaseData.putString("rece_desc", "收款方");
        generateSnsUseCaseData.putString("rece_name", this.mBean.getPayInfo().iqp.getString("extinfo_key_28"));
        generateSnsUseCaseData.putString(ch.COL_USERNAME, this.mBean.getReceiverName());
        generateSnsUseCaseData.putString("rece_img_url", this.mBean.getPayInfo().iqp.getString("extinfo_key_27"));
        generateSnsUseCaseData.putString("cashier_desc", this.mBean.getContext().getString(R.string.frm));
        generateSnsUseCaseData.putString("rece_remark", this.mBean.getPayInfo().iqp.getString("extinfo_key_3"));
        generateSnsUseCaseData.putString("payee_remark", this.mBean.getPayInfo().iqp.getString("extinfo_key_7"));
        AppMethodBeat.o(18714);
        return generateSnsUseCaseData;
    }
}
