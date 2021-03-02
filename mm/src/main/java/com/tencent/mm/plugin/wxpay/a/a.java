package com.tencent.mm.plugin.wxpay.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ag.k;
import com.tencent.mm.wallet_core.c.aa;

public interface a extends com.tencent.mm.kernel.b.a {
    void beforeJumpRedPacketPreviewUI();

    void doRedPacketPreviewLoading(Context context, String str);

    aa getWalletCacheStg();

    void gotoLuckyMoneyReceiveUI(Context context, Bundle bundle, k.b bVar);

    void gotoRedPacketPreviewUI(Context context, String str);

    boolean hasInitBiometricManager();

    void onExitRedPacketPreviewChatting();

    void triggerSoterReInit();
}
