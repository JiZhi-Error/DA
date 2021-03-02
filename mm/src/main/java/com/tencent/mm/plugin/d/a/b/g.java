package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g phC;
    private ArrayList<a> mCallbackList;
    private Context mContext;
    private MMHandler mHandler;
    private BluetoothAdapter pfW;
    private boolean pgQ;
    private BluetoothManager phD;
    private BluetoothLeScanner phE;

    public interface a {
        void CL(int i2);

        void a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr);
    }

    public static g ckL() {
        AppMethodBeat.i(22559);
        if (phC != null) {
            g gVar = phC;
            AppMethodBeat.o(22559);
            return gVar;
        }
        g gVar2 = new g(MMApplicationContext.getContext());
        phC = gVar2;
        AppMethodBeat.o(22559);
        return gVar2;
    }

    private g(Context context) {
        AppMethodBeat.i(22560);
        if (context == null) {
            Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            AppMethodBeat.o(22560);
            return;
        }
        this.mContext = context;
        this.mCallbackList = new ArrayList<>();
        this.pgQ = false;
        this.pfW = null;
        this.phE = null;
        this.mHandler = null;
        this.phD = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.pfW = this.phD.getAdapter();
        if (this.pfW != null) {
            Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.phE = this.pfW.getBluetoothLeScanner();
        }
        this.mHandler = new MMHandler("NewBluetoothLEScannerThread");
        AppMethodBeat.o(22560);
    }

    public final boolean a(final boolean z, final a aVar) {
        AppMethodBeat.i(22561);
        Log.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
        Boolean bool = (Boolean) new SyncTask<Boolean>() {
            /* class com.tencent.mm.plugin.d.a.b.g.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Boolean run() {
                AppMethodBeat.i(22556);
                Boolean valueOf = Boolean.valueOf(g.a(g.this, z, aVar));
                AppMethodBeat.o(22556);
                return valueOf;
            }
        }.exec(this.mHandler);
        Assert.assertTrue(bool != null);
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(22561);
        return booleanValue;
    }

    private boolean a(a aVar) {
        int i2;
        int i3 = 0;
        boolean z = false;
        AppMethodBeat.i(22562);
        if (aVar == null) {
            Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            AppMethodBeat.o(22562);
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
                Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback ".concat(String.valueOf(z)));
            } else {
                z = true;
                Log.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
            }
            AppMethodBeat.o(22562);
        }
        return z;
    }

    public final void onScanFailed(final int i2) {
        AppMethodBeat.i(22563);
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.g.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(22558);
                for (int i2 = 0; i2 < g.this.mCallbackList.size(); i2++) {
                    ((a) g.this.mCallbackList.get(i2)).CL(i2);
                }
                AppMethodBeat.o(22558);
            }
        });
        AppMethodBeat.o(22563);
    }

    public final void onScanResult(int i2, ScanResult scanResult) {
        AppMethodBeat.i(22564);
        if (!(scanResult == null || scanResult.getScanRecord() == null)) {
            Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.bw(scanResult.getScanRecord().getBytes()));
            Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", Integer.valueOf(this.mCallbackList.size()));
            final BluetoothDevice device = scanResult.getDevice();
            final int rssi = scanResult.getRssi();
            final byte[] bytes = scanResult.getScanRecord().getBytes();
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.d.a.b.g.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(22557);
                    for (int i2 = 0; i2 < g.this.mCallbackList.size(); i2++) {
                        ((a) g.this.mCallbackList.get(i2)).a(device, rssi, bytes);
                    }
                    AppMethodBeat.o(22557);
                }
            });
        }
        AppMethodBeat.o(22564);
    }

    @Override // android.bluetooth.le.ScanCallback
    public final void onBatchScanResults(List<ScanResult> list) {
        AppMethodBeat.i(22565);
        if (list != null) {
            for (ScanResult scanResult : list) {
                Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.bw(scanResult.getScanRecord().getBytes()));
            }
        }
        AppMethodBeat.o(22565);
    }

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean hasSystemFeature;
        AppMethodBeat.i(22566);
        if (gVar.mContext == null) {
            Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            hasSystemFeature = false;
        } else {
            hasSystemFeature = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!hasSystemFeature) {
            Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
            AppMethodBeat.o(22566);
            return false;
        }
        if (gVar.phE == null) {
            gVar.pfW = gVar.phD.getAdapter();
            if (gVar.pfW != null) {
                Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                gVar.phE = gVar.pfW.getBluetoothLeScanner();
                if (gVar.phE == null) {
                    AppMethodBeat.o(22566);
                    return false;
                }
            } else {
                Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                AppMethodBeat.o(22566);
                return false;
            }
        }
        if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
            Log.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
        } else if (z) {
            Log.i("MicroMsg.exdevice.NewBluetoothLEScanner", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.exdevice.NewBluetoothLEScanner", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            if (gVar.pgQ) {
                Log.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                gVar.a(aVar);
            } else {
                gVar.phE.startScan(gVar);
                gVar.a(aVar);
                gVar.pgQ = true;
            }
        } else if (!gVar.pgQ) {
            Log.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", Integer.valueOf(gVar.mCallbackList.size()));
        } else {
            if (aVar == null) {
                Log.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            } else {
                Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback ".concat(String.valueOf(gVar.mCallbackList.remove(aVar))));
            }
            if (gVar.mCallbackList.size() <= 0) {
                Log.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                gVar.phE.stopScan(gVar);
                gVar.pgQ = false;
            }
        }
        AppMethodBeat.o(22566);
        return true;
    }
}
