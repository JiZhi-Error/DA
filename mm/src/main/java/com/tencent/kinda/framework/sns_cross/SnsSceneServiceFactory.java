package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class SnsSceneServiceFactory {
    public static ISnsSceneService createService(int i2) {
        ISnsSceneService hongBaoServiceImpl;
        AppMethodBeat.i(18715);
        switch (i2) {
            case 37:
                hongBaoServiceImpl = new HongBaoServiceImpl();
                break;
            case 42:
                hongBaoServiceImpl = new NewAASceneServiceImpl();
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                hongBaoServiceImpl = new QRCodeRewardServiceImpl();
                break;
            case 49:
                hongBaoServiceImpl = new T2BSceneServiceImpl();
                break;
            case 56:
                hongBaoServiceImpl = new MobileRemittanceServiceImpl();
                break;
            default:
                hongBaoServiceImpl = new DefaultSnsServiceImpl();
                break;
        }
        AppMethodBeat.o(18715);
        return hongBaoServiceImpl;
    }

    public static ISnsUseCaseCallback createCallback(int i2) {
        ISnsUseCaseCallback mobileRemittanceCaseCallBack;
        AppMethodBeat.i(18716);
        switch (i2) {
            case 31:
            case 32:
            case 33:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                mobileRemittanceCaseCallBack = new TransferNormalUseCaseCallback();
                break;
            case 37:
                mobileRemittanceCaseCallBack = new LuckMoneyUseCaseCallback();
                break;
            case 42:
                mobileRemittanceCaseCallBack = new NewAAUseCaseCallback();
                break;
            case 49:
                mobileRemittanceCaseCallBack = new T2BUseCaseCallback();
                break;
            case 56:
                mobileRemittanceCaseCallBack = new MobileRemittanceCaseCallBack();
                break;
            default:
                mobileRemittanceCaseCallBack = new ISnsUseCaseCallback() {
                    /* class com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory.AnonymousClass1 */

                    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
                    public final void setData(Context context, PayInfo payInfo) {
                    }

                    @Override // com.tencent.kinda.gen.UseCaseCallback
                    public final void call(ITransmitKvData iTransmitKvData) {
                    }
                };
                break;
        }
        AppMethodBeat.o(18716);
        return mobileRemittanceCaseCallBack;
    }
}
