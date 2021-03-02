package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public interface ISnsSceneService {
    ITransmitKvData generateSnsUseCaseData();

    void setData(Context context, PayInfo payInfo);
}
