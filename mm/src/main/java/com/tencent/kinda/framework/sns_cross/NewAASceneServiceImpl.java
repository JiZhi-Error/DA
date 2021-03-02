package com.tencent.kinda.framework.sns_cross;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public class NewAASceneServiceImpl extends BaseSnsSceneService {
    NewAASceneServiceImpl() {
    }

    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(18711);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        String receiverText = SnsTextUtil.getReceiverText(this.mBean.getContext(), this.mBean.getReceiverName(), this.mBean.getTrueName());
        generateSnsUseCaseData.putString("prepay_page_payee", receiverText);
        generateSnsUseCaseData.putString("cashier_desc", this.mBean.getContext().getString(R.string.ip3, receiverText));
        AppMethodBeat.o(18711);
        return generateSnsUseCaseData;
    }
}
