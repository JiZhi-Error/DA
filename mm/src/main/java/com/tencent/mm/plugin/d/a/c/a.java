package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.ServerProtocol;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID pjy = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID pjz = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public MMHandler mHandler;
    public boolean mIsInit = false;
    public final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.d.a.c.a.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(22586);
            if (intent == null) {
                AppMethodBeat.o(22586);
                return;
            }
            String action = intent.getAction();
            Log.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = ".concat(String.valueOf(action)));
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    a.this.pjA.fb(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                }
                AppMethodBeat.o(22586);
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                a.this.pjA.ckF();
                AppMethodBeat.o(22586);
            } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1);
                AppMethodBeat.o(22586);
            } else {
                if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    String address = bluetoothDevice2.getAddress();
                    if (!a.this.pgC.containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.anY(address)))) {
                        AppMethodBeat.o(22586);
                        return;
                    }
                    Log.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice2.getName(), address);
                    if (a.this.pjA != null) {
                        a.this.pjA.l(com.tencent.mm.plugin.exdevice.k.b.anY(address), false);
                    }
                }
                AppMethodBeat.o(22586);
            }
        }
    };
    private Runnable mRunnable;
    public BluetoothAdapter pfW;
    public HashMap<Long, b> pgC = new HashMap<>();
    public AbstractC0937a pjA;
    public Context pjB;

    /* renamed from: com.tencent.mm.plugin.d.a.c.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0937a {
        public void i(long j2, long j3, long j4) {
        }

        public void fb(String str, String str2) {
        }

        public void ckF() {
        }

        public void l(long j2, boolean z) {
        }

        public void b(long j2, byte[] bArr) {
        }

        public void m(long j2, boolean z) {
        }

        public void c(long j2, int i2, String str) {
        }
    }

    static {
        AppMethodBeat.i(22593);
        AppMethodBeat.o(22593);
    }

    public a(MMHandler mMHandler) {
        AppMethodBeat.i(179583);
        this.mHandler = new MMHandler(mMHandler.getSerialTag());
        this.mRunnable = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.c.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(22587);
                if (a.this.pfW.isDiscovering()) {
                    a.this.pfW.cancelDiscovery();
                }
                AppMethodBeat.o(22587);
            }
        };
        AppMethodBeat.o(179583);
    }

    private boolean ckO() {
        AppMethodBeat.i(22591);
        if (!this.pfW.isDiscovering()) {
            AppMethodBeat.o(22591);
            return true;
        } else if (!this.pfW.cancelDiscovery()) {
            Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
            AppMethodBeat.o(22591);
            return false;
        } else {
            this.mHandler.removeCallbacks(this.mRunnable);
            AppMethodBeat.o(22591);
            return true;
        }
    }

    public final boolean kg(boolean z) {
        String str;
        AppMethodBeat.i(22592);
        StringBuilder sb = new StringBuilder("scanDevices");
        if (z) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        Log.i("MicroMsg.exdevice.BluetoothChatManager", sb.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!ckN()) {
            Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            AppMethodBeat.o(22592);
            return false;
        } else if (!z) {
            boolean ckO = ckO();
            AppMethodBeat.o(22592);
            return ckO;
        } else if (!this.pfW.isDiscovering() || ckO()) {
            Log.i("MicroMsg.exdevice.BluetoothChatManager", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.exdevice.BluetoothChatManager", new Throwable(), "[BluetoothTrace] startDiscovery stacktrace", new Object[0]);
            if (!this.pfW.startDiscovery()) {
                Log.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
                AppMethodBeat.o(22592);
                return false;
            }
            this.mHandler.postDelayed(this.mRunnable, 10000);
            AppMethodBeat.o(22592);
            return true;
        } else {
            AppMethodBeat.o(22592);
            return false;
        }
    }

    public final class b implements Runnable {
        private long pgN = 0;
        private long pgO = 0;

        public b(long j2, long j3) {
            this.pgN = j2;
            this.pgO = j3;
        }

        public final void run() {
            AppMethodBeat.i(22588);
            a aVar = a.this;
            b bVar = new b(this.pgN);
            long j2 = bVar.mSessionId;
            b remove = aVar.pgC.remove(Long.valueOf(j2));
            if (remove != null) {
                remove.disconnect();
            }
            aVar.pgC.put(Long.valueOf(j2), bVar);
            if (a.this.pjA != null) {
                a.this.pjA.i(j2, this.pgN, this.pgO);
            }
            AppMethodBeat.o(22588);
        }
    }

    public final boolean ckN() {
        AppMethodBeat.i(22590);
        Assert.assertTrue(this.mIsInit);
        if (this.pfW == null) {
            AppMethodBeat.o(22590);
            return false;
        }
        AppMethodBeat.o(22590);
        return true;
    }
}
