package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public interface ISnsUseCaseCallback extends UseCaseCallback {
    void setData(Context context, PayInfo payInfo);
}
