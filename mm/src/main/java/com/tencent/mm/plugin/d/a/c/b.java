package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.c.c;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public BluetoothDevice lOM;
    public long mSessionId;
    public int mState = 0;
    public long pjD;
    public c.a pjE = null;
    public c.b pjF = null;
    public c.C0939c pjG = null;

    public b(long j2) {
        AppMethodBeat.i(22594);
        this.pjD = j2;
        this.mSessionId = j2;
        this.lOM = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(a.BC(j2));
        AppMethodBeat.o(22594);
    }

    public final void disconnect() {
        AppMethodBeat.i(22595);
        Log.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.pjE != null) {
            this.pjE.disconnect();
            this.pjE = null;
        }
        if (this.pjF != null) {
            this.pjF.cancel();
            this.pjF = null;
        }
        if (this.pjG != null) {
            this.pjG.cancel();
            this.pjG = null;
        }
        AppMethodBeat.o(22595);
    }
}
