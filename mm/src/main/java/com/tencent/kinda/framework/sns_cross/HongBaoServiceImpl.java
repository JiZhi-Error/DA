package com.tencent.kinda.framework.sns_cross;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class HongBaoServiceImpl extends BaseSnsSceneService {
    @Override // com.tencent.kinda.framework.sns_cross.BaseSnsSceneService, com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        AppMethodBeat.i(18708);
        ITransmitKvData generateSnsUseCaseData = super.generateSnsUseCaseData();
        generateSnsUseCaseData.putString("cashier_desc", this.mBean.getContext().getResources().getString(R.string.ese));
        AppMethodBeat.o(18708);
        return generateSnsUseCaseData;
    }
}
