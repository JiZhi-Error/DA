package com.tencent.mm.plugin.exdevice.service;

import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;

@k
public class ExDeviceService extends MMService {
    private h.a rDw = null;

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(23635);
        Log.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
        AppMethodBeat.o(23635);
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(23636);
        Log.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!cLc()) {
            Log.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            a a2 = c.a(Process.myPid(), new a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/exdevice/service/ExDeviceService", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/exdevice/service/ExDeviceService", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
        AppMethodBeat.o(23636);
    }

    private static boolean cLc() {
        boolean z;
        AppMethodBeat.i(23637);
        PackageManager packageManager = MMApplicationContext.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (PackageManager.NameNotFoundException e2) {
            z = false;
        }
        Log.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", Boolean.valueOf(z));
        AppMethodBeat.o(23637);
        return z;
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        AppMethodBeat.i(23638);
        Log.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.rDw == null) {
            this.rDw = new y();
        }
        h.a aVar = this.rDw;
        AppMethodBeat.o(23638);
        return aVar;
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.exdevice.ExDeviceService";
    }
}
