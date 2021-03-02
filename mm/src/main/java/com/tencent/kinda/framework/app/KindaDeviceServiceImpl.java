package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KDeviceService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.WebView;

public class KindaDeviceServiceImpl implements KDeviceService {
    private static final String TAG = "KindaDeviceServiceImpl";
    private byte _hellAccFlag_;
    private a mgr = ((a) g.af(a.class));

    public KindaDeviceServiceImpl() {
        AppMethodBeat.i(18416);
        AppMethodBeat.o(18416);
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public boolean isDeviceOpenBiometricVerification() {
        AppMethodBeat.i(18417);
        if (this.mgr == null) {
            Log.w(TAG, "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, mgr == null, return false.");
            AppMethodBeat.o(18417);
            return false;
        }
        boolean dJU = this.mgr.dJU();
        boolean dKc = this.mgr.dKc();
        Log.i(TAG, "KindaDeviceServiceImpl.isDeviceOpenBiometricVerification, isDeviceHasFingerPrint: " + dJU + ", isDeviceHasFaceID: " + dKc);
        if (dJU || dKc) {
            AppMethodBeat.o(18417);
            return true;
        }
        AppMethodBeat.o(18417);
        return false;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public boolean isDeviceSupportTouchId() {
        AppMethodBeat.i(18418);
        if (this.mgr == null) {
            Log.w(TAG, "KindaDeviceServiceImpl.isDeviceSupportFP, mgr == null, return false.");
            AppMethodBeat.o(18418);
            return false;
        }
        boolean dJT = this.mgr.dJT();
        Log.i(TAG, "KindaDeviceServiceImpl.isDeviceSupportFP, return".concat(String.valueOf(dJT)));
        AppMethodBeat.o(18418);
        return dJT;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public boolean isDeviceSupportFaceId() {
        AppMethodBeat.i(18419);
        if (this.mgr == null) {
            Log.w(TAG, "KindaDeviceServiceImpl.isDeviceSupportFaceId, mgr == null, return false.");
            AppMethodBeat.o(18419);
            return false;
        }
        boolean dKb = this.mgr.dKb();
        Log.i(TAG, "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(dKb)));
        AppMethodBeat.o(18419);
        return dKb;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public boolean isRoot() {
        AppMethodBeat.i(18420);
        if (this.mgr == null) {
            Log.w(TAG, "KindaDeviceServiceImpl.isRoot, mgr == null, return false.");
            AppMethodBeat.o(18420);
        } else {
            Log.i(TAG, "KindaDeviceServiceImpl.isRoot, return: false");
            AppMethodBeat.o(18420);
        }
        return false;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public String soterCpuId() {
        AppMethodBeat.i(18421);
        String str = d.flM().FhU;
        Log.i(TAG, "KindaDeviceServiceImpl.soterCpuId, return: ".concat(String.valueOf(str)));
        AppMethodBeat.o(18421);
        return str;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public String soterUid() {
        AppMethodBeat.i(18422);
        String str = d.flM().hFF;
        Log.i(TAG, "KindaDeviceServiceImpl.isDeviceSupportFaceId, return: ".concat(String.valueOf(str)));
        AppMethodBeat.o(18422);
        return str;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public boolean useLastestTouchInfo() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public void updateBiometricVerificationState(int i2, boolean z) {
        AppMethodBeat.i(18423);
        if (i2 == 0) {
            if (this.mgr.dJT()) {
                this.mgr.pj(z);
                this.mgr.pk(false);
            } else if (this.mgr.dKb()) {
                this.mgr.pk(z);
                this.mgr.pj(false);
            }
        } else if (i2 == 1 && this.mgr.dJT()) {
            this.mgr.pj(z);
            this.mgr.pk(false);
        } else if (i2 == 2 && this.mgr.dKb()) {
            this.mgr.pk(z);
            this.mgr.pj(false);
        }
        Log.i(TAG, "KindaDeviceServiceImpl.updateBiometricVerificationState, soterOpenType: " + i2 + ", biometricVerificationState: " + z);
        AppMethodBeat.o(18423);
    }

    @Override // com.tencent.kinda.gen.KDeviceService
    public void invokePhoneCall(String str) {
        AppMethodBeat.i(18424);
        Log.i(TAG, "invokePhoneCall %s", str);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        Context context = MMApplicationContext.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/app/KindaDeviceServiceImpl", "invokePhoneCall", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(18424);
    }
}
