package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements BluetoothAdapter.LeScanCallback {
    private static c pgP;
    private ArrayList<a> mCallbackList;
    private Context mContext;
    private MMHandler mHandler;
    private BluetoothAdapter pfW;
    private boolean pgQ;

    public interface a {
        void a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr);

        void ckF();
    }

    public static c ckG() {
        AppMethodBeat.i(22492);
        if (pgP != null) {
            c cVar = pgP;
            AppMethodBeat.o(22492);
            return cVar;
        }
        c cVar2 = new c(MMApplicationContext.getContext());
        pgP = cVar2;
        AppMethodBeat.o(22492);
        return cVar2;
    }

    private c(Context context) {
        AppMethodBeat.i(22493);
        if (context == null) {
            Log.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            AppMethodBeat.o(22493);
            return;
        }
        this.mContext = context;
        this.mCallbackList = new ArrayList<>();
        this.pgQ = false;
        this.pfW = null;
        this.mHandler = null;
        this.pfW = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new MMHandler("BluetoothLEScanerThread");
        AppMethodBeat.o(22493);
    }

    public final boolean a(final boolean z, final a aVar) {
        AppMethodBeat.i(22494);
        Boolean bool = (Boolean) new SyncTask<Boolean>() {
            /* class com.tencent.mm.plugin.d.a.b.c.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(22490);
                Boolean valueOf = Boolean.valueOf(c.a(c.this, z, aVar));
                AppMethodBeat.o(22490);
                return valueOf;
            }
        }.exec(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(22494);
        return booleanValue;
    }

    private boolean a(a aVar) {
        int i2;
        int i3 = 0;
        boolean z = false;
        AppMethodBeat.i(22495);
        if (aVar == null) {
            Log.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            AppMethodBeat.o(22495);
        } else {
            while (true) {
                i2 = i3;
                if (i2 >= this.mCallbackList.size()) {
                    i2 = -1;
                    break;
                } else if (this.mCallbackList.get(i2) == aVar) {
                    break;
                } else {
                    i3 = i2 + 1;
                }
            }
            if (i2 < 0) {
                z = this.mCallbackList.add(aVar);
                Log.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                Log.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
            }
            AppMethodBeat.o(22495);
        }
        return z;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i2, final byte[] bArr) {
        AppMethodBeat.i(22496);
        Log.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.bw(bArr));
        Log.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", Integer.valueOf(this.mCallbackList.size()));
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(22491);
                for (int i2 = 0; i2 < c.this.mCallbackList.size(); i2++) {
                    ((a) c.this.mCallbackList.get(i2)).a(bluetoothDevice, i2, bArr);
                }
                AppMethodBeat.o(22491);
            }
        });
        AppMethodBeat.o(22496);
    }

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean hasSystemFeature;
        boolean z2;
        AppMethodBeat.i(22497);
        if (cVar.mContext == null) {
            Log.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            hasSystemFeature = false;
        } else {
            hasSystemFeature = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!hasSystemFeature) {
            Log.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            AppMethodBeat.o(22497);
            return false;
        } else if (cVar.pfW == null) {
            Log.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            AppMethodBeat.o(22497);
            return false;
        } else {
            if (z) {
                if (cVar.pgQ) {
                    Log.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    AppMethodBeat.o(22497);
                    return true;
                }
                Log.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                Log.i("MicroMsg.exdevice.BluetoothLEScaner", "[BluetoothTrace] start scan");
                Log.printErrStackTrace("MicroMsg.exdevice.BluetoothLEScaner", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                z2 = cVar.pfW.startLeScan(cVar);
                if (z2) {
                    cVar.pgQ = true;
                    cVar.a(aVar);
                } else if (cVar.mCallbackList.size() <= 0) {
                    Log.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.pfW.getState());
                    int i2 = 0;
                    while (!z2 && i2 < 3) {
                        cVar.pfW.stopLeScan(cVar);
                        cVar.pgQ = false;
                        Log.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i2 + " time");
                        Log.i("MicroMsg.exdevice.BluetoothLEScaner", "[BluetoothTrace] start scan");
                        Log.printErrStackTrace("MicroMsg.exdevice.BluetoothLEScaner", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                        z2 = cVar.pfW.startLeScan(cVar);
                        if (z2) {
                            cVar.pgQ = true;
                            cVar.a(aVar);
                        }
                        i2++;
                    }
                    AppMethodBeat.o(22497);
                    return z2;
                } else if (cVar.pfW.getState() == 12) {
                    Log.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.pgQ = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (!cVar.pgQ) {
                Log.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", Integer.valueOf(cVar.mCallbackList.size()));
                AppMethodBeat.o(22497);
                return true;
            } else {
                if (aVar == null) {
                    Log.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    Log.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback ".concat(String.valueOf(cVar.mCallbackList.remove(aVar))));
                }
                if (aVar != null) {
                    aVar.ckF();
                }
                Log.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.mCallbackList.size() <= 0) {
                    Log.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.pfW.stopLeScan(cVar);
                    cVar.pgQ = false;
                }
                z2 = true;
            }
            AppMethodBeat.o(22497);
            return z2;
        }
    }
}
