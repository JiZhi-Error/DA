package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;

public class MobileRemittanceCaseCallBack implements ISnsUseCaseCallback {
    private SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
    public void setData(Context context, PayInfo payInfo) {
        AppMethodBeat.i(214456);
        this.mBean = new SnsServiceBean(context, payInfo);
        AppMethodBeat.o(214456);
    }

    @Override // com.tencent.kinda.gen.UseCaseCallback
    public void call(ITransmitKvData iTransmitKvData) {
        int i2;
        AppMethodBeat.i(214457);
        Context context = this.mBean.getContext();
        if (context instanceof MobileRemittanceUI) {
            MobileRemittanceUI mobileRemittanceUI = (MobileRemittanceUI) context;
            if (iTransmitKvData.getString("closeLoading").equals("1")) {
                mobileRemittanceUI.hideProgress();
                AppMethodBeat.o(214457);
                return;
            }
            if (iTransmitKvData.getInt("retcode") == 1) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            mobileRemittanceUI.hideProgress();
            mobileRemittanceUI.hideLoading();
            Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "resultCode :%s", Integer.valueOf(i2));
            if (i2 == -1) {
                a bl = new a().bl(mobileRemittanceUI.CnQ);
                com.tencent.mm.hellhoundlib.a.a.a(mobileRemittanceUI, bl.axQ(), "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI", "onMobileRemittanceResult", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mobileRemittanceUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mobileRemittanceUI, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI", "onMobileRemittanceResult", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        AppMethodBeat.o(214457);
    }
}
