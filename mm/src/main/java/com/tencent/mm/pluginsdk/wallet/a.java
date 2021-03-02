package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

public interface a extends com.tencent.mm.kernel.c.a {
    boolean TenPaySDKABTestKindaEnable();

    boolean canOpenKindaCashier(Context context);

    long getColorByMode(long j2, long j3);

    Activity getCrossActivity();

    boolean isSwitch2InWxAppPay(String str);

    void notifyUploadCardSuccess();

    void startBindCardUseCase(Context context, Bundle bundle);

    void startFastBindUseCase(String str, int i2, Runnable runnable);

    void startInWxAppPayUseCase(Context context, String str, String str2, String str3, int i2, int i3);

    void startJSApiWCPaySecurityCrosscut(Map<String, Object> map);

    void startJsApiComponentUseCase(Context context, WalletJsapiData walletJsapiData, MMActivity.a aVar, int i2);

    void startLqtFixedDepositMakePlanUseCase(Context context, Bundle bundle);

    void startLqtFixedDepositPlanListUseCase(Context context, Bundle bundle);

    void startModifyPwdUseCase(Context context, Bundle bundle);

    void startOfflinePay(Context context, String str, String str2, int i2);

    boolean startOverseaWalletSuccPageUseCase(Context context, Bundle bundle);

    boolean startPayIBGJsGetSuccPageUseCase(Context context, Bundle bundle);

    void startResetPwdUseCase(Context context, Bundle bundle);

    void startSNSPay(Context context, PayInfo payInfo);

    void startScanQRCodePay(Context context, int i2, String str, int i3);

    void startUseCase(String str, Object obj, Object obj2);

    void startWalletBalanceFetchUseCase(Context context, Bundle bundle);

    void startWxpayAppPay(Context context, Bundle bundle, String str, String str2, String str3, String str4);

    void startWxpayH5Pay(Context context, Bundle bundle, String str, String str2, String str3, String str4);

    void startWxpayJsApiPay(Context context, WalletJsapiData walletJsapiData, MMActivity.a aVar, int i2);

    void startWxpayQueryCashierPay(String str, int i2);
}
