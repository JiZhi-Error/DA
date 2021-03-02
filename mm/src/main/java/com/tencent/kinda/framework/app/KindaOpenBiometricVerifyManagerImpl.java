package com.tencent.kinda.framework.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaOpenBiometricVerifyManager;
import com.tencent.kinda.gen.SelectBioType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class KindaOpenBiometricVerifyManagerImpl implements KindaOpenBiometricVerifyManager {
    private static final String TAG = "KindaOpenBiometricVerifyManagerImpl";

    @Override // com.tencent.kinda.gen.KindaOpenBiometricVerifyManager
    public void openBiometricVerify(String str, boolean z, SelectBioType selectBioType) {
        AppMethodBeat.i(18457);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "Fail to start KindaOpenBiometricVerifyManagerImpl due to context is null!");
            AppMethodBeat.o(18457);
        } else if (!(context instanceof MMActivity)) {
            Log.e(TAG, "Fail to start KindaOpenBiometricVerifyManagerImpl due to incompatible context(%s)", context.getClass().getName());
            AppMethodBeat.o(18457);
        } else {
            final MMActivity mMActivity = (MMActivity) context;
            mMActivity.getIntent().putExtra("isFromKinda", true);
            mMActivity.getIntent().putExtra("kindaPayPwd", str);
            if (z) {
                mMActivity.getIntent().putExtra("bSupportFaceAndTouch", true);
                if (selectBioType == SelectBioType.TOUCHID) {
                    mMActivity.getIntent().putExtra("selectBioType", 1);
                } else if (selectBioType == SelectBioType.FACEID) {
                    mMActivity.getIntent().putExtra("selectBioType", 2);
                }
            }
            Bundle extras = mMActivity.getIntent().getExtras();
            if (extras == null) {
                Log.i(TAG, "The Extras data in current kinda Activity is null!");
            } else {
                Log.i(TAG, "The Extras data in current kinda Activity is " + extras.toString());
            }
            s.fOg();
            al fRs = s.fOh().fRs();
            if (fRs == null || !fRs.fRa()) {
                Log.i(TAG, "WalletSwitchConfig.isSupportTouchPay return that the user has not opened fingerprint (biometric) payment in WeChat. Send a message to call the bind query.");
                zv zvVar = new zv();
                zvVar.efR.scene = 1;
                zvVar.efR.efT = true;
                zvVar.efR.efU = true;
                zvVar.efS.efJ = new Runnable() {
                    /* class com.tencent.kinda.framework.app.KindaOpenBiometricVerifyManagerImpl.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(18456);
                        ((h) g.af(h.class)).i(mMActivity);
                        AppMethodBeat.o(18456);
                    }
                };
                EventCenter.instance.asyncPublish(zvVar, Looper.myLooper());
                AppMethodBeat.o(18457);
                return;
            }
            Log.i(TAG, "WalletSwitchConfig.isSupportTouchPay return that the user has opened fingerprint (biometric) payment in WeChat.");
            ((h) g.af(h.class)).i(mMActivity);
            AppMethodBeat.o(18457);
        }
    }
}
