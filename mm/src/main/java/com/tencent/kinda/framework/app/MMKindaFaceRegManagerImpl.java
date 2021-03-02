package com.tencent.kinda.framework.app;

import android.app.Activity;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaFaceRegManager;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.g.a.se;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKindaFaceRegManagerImpl implements KindaFaceRegManager {
    private static final int FACE_ACTION_REQUEST_CODE = 1;
    private final String TAG = "MMKindaFaceRegManagerImpl";

    @Override // com.tencent.kinda.gen.KindaFaceRegManager
    public void startFaceImpl(int i2, String str, String str2, VoidBoolStringI32StringCallback voidBoolStringI32StringCallback, VoidCallback voidCallback, String str3) {
        AppMethodBeat.i(214427);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        if (!(topOrUIPageFragmentActivity instanceof UIPageFragmentActivity) && !(topOrUIPageFragmentActivity instanceof WalletBrandUI)) {
            Log.e("MMKindaFaceRegManagerImpl", "startFaceImpl failed due to incompatible context(%s)", topOrUIPageFragmentActivity.getClass().getName());
            AppMethodBeat.o(214427);
        } else if (topOrUIPageFragmentActivity instanceof WalletBrandUI) {
            WalletBrandUI walletBrandUI = (WalletBrandUI) topOrUIPageFragmentActivity;
            walletBrandUI.IrP = true;
            walletBrandUI.hgw = voidBoolStringI32StringCallback;
            walletBrandUI.hgx = voidCallback;
            se seVar = new se();
            seVar.dYI.dKq = walletBrandUI;
            seVar.dYI.scene = i2;
            seVar.dYI.packageName = str;
            seVar.dYI.dYK = str2;
            seVar.dYI.dYL = str3;
            seVar.dYI.requestCode = 4;
            EventCenter.instance.publish(seVar);
            AppMethodBeat.o(214427);
        } else {
            UIPageFragmentActivity uIPageFragmentActivity = (UIPageFragmentActivity) topOrUIPageFragmentActivity;
            uIPageFragmentActivity.hgw = voidBoolStringI32StringCallback;
            uIPageFragmentActivity.hgx = voidCallback;
            se seVar2 = new se();
            seVar2.dYI.dKq = uIPageFragmentActivity;
            seVar2.dYI.scene = i2;
            seVar2.dYI.packageName = str;
            seVar2.dYI.dYK = str2;
            seVar2.dYI.dYL = str3;
            seVar2.dYI.requestCode = 4;
            EventCenter.instance.publish(seVar2);
            AppMethodBeat.o(214427);
        }
    }
}
