package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public abstract class BaseSnsSceneService implements ISnsSceneService {
    SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public void setData(Context context, PayInfo payInfo) {
        this.mBean = new SnsServiceBean(context, payInfo);
    }

    @Override // com.tencent.kinda.framework.sns_cross.ISnsSceneService
    public ITransmitKvData generateSnsUseCaseData() {
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("req_key", this.mBean.getReqKey());
        create.putInt("payChannel", this.mBean.getChannel());
        create.putInt("payScene", this.mBean.getPayScene());
        return create;
    }
}
