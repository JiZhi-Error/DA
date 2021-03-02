package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class TransferNormalUseCaseCallback implements ISnsUseCaseCallback {
    private SnsServiceBean mBean;

    @Override // com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
    public void setData(Context context, PayInfo payInfo) {
        AppMethodBeat.i(18722);
        this.mBean = new SnsServiceBean(context, payInfo);
        AppMethodBeat.o(18722);
    }

    @Override // com.tencent.kinda.gen.UseCaseCallback
    public void call(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18723);
        Context context = this.mBean.getContext();
        if (!"1".equals(iTransmitKvData.getString("closeLoading")) || !(context instanceof WalletBaseUI)) {
            String string = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
            int payScene = this.mBean.getPayScene();
            int i2 = iTransmitKvData.getInt("retcode");
            long j2 = iTransmitKvData.getLong("total_fee");
            int i3 = iTransmitKvData.getInt(NativeProtocol.WEB_DIALOG_ACTION);
            gn gnVar = new gn();
            gnVar.dKu.dDL = iTransmitKvData.getString("req_key");
            if (payScene == 31) {
                gnVar.dKu.type = 0;
            } else if (payScene == 32 || payScene == 33) {
                gnVar.dKu.type = 1;
            }
            if (payScene != 31) {
                gnVar.dKu.dDN = i2;
            } else if (i2 == 1 && i3 == 1) {
                gnVar.dKu.dDN = 1;
            } else if (i2 == 1 && i3 == 2) {
                gnVar.dKu.dDN = 2;
            }
            gnVar.dKu.dDM = string;
            gnVar.dKu.isKinda = true;
            gnVar.dKu.dKv = context.hashCode();
            EventCenter.instance.publish(gnVar);
            as asVar = new as();
            asVar.dDK.dDL = iTransmitKvData.getString("req_key");
            asVar.dDK.dDM = string;
            asVar.dDK.dDN = i2;
            asVar.dDK.dDO = ((double) j2) / 100.0d;
            asVar.dDK.isKinda = true;
            asVar.dDK.dDP = iTransmitKvData.getInt("pay_fail_reason");
            EventCenter.instance.publish(asVar);
            AppMethodBeat.o(18723);
        } else if (context instanceof RemittanceF2fDynamicCodeUI) {
            ((RemittanceF2fDynamicCodeUI) context).hideProgress();
            AppMethodBeat.o(18723);
        } else {
            ((WalletBaseUI) context).hideLoading();
            AppMethodBeat.o(18723);
        }
    }
}
