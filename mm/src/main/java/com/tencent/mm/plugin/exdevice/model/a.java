package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.plugin.exdevice.service.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends n.a {
    private static final a rxR = new a();

    static {
        AppMethodBeat.i(23196);
        AppMethodBeat.o(23196);
    }

    private a() {
    }

    public static a cKp() {
        return rxR;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.n
    public final Bundle n(int i2, Bundle bundle) {
        AppMethodBeat.i(23195);
        Log.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", Integer.valueOf(i2));
        if (bundle != null) {
            switch (i2) {
                case 0:
                    if (bundle == null) {
                        Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    } else {
                        int i3 = bundle.getInt("key_state");
                        Log.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", Integer.valueOf(i3));
                        if (-1 == i3) {
                            Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        } else {
                            eo eoVar = new eo();
                            eoVar.dHV.dHW = i3;
                            if (!EventCenter.instance.publish(eoVar)) {
                                Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                            }
                        }
                    }
                    AppMethodBeat.o(23195);
                    break;
                default:
                    AppMethodBeat.o(23195);
                    break;
            }
        } else {
            Log.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
            AppMethodBeat.o(23195);
        }
        return null;
    }
}
