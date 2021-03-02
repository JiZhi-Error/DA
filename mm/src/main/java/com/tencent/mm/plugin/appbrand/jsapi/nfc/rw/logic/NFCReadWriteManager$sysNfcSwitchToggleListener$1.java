package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-commons-jsapi-nfc-ext_release"})
public final class NFCReadWriteManager$sysNfcSwitchToggleListener$1 extends BroadcastReceiver {
    final /* synthetic */ c miP;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NFCReadWriteManager$sysNfcSwitchToggleListener$1(c cVar) {
        this.miP = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z;
        AppMethodBeat.i(207156);
        if (intent != null) {
            int intValue = Integer.valueOf(intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", -1)).intValue();
            if (-1 == intValue) {
                Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is invalid");
                AppMethodBeat.o(207156);
                return;
            }
            if (3 == intValue) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, isNFCEnabled: ".concat(String.valueOf(z)));
            if (!z) {
                this.miP.miD.set(false);
                this.miP.miE = false;
            }
            AppMethodBeat.o(207156);
            return;
        }
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is null");
        AppMethodBeat.o(207156);
    }
}
