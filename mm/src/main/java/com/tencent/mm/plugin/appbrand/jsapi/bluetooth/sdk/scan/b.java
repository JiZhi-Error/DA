package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.ParcelUuid;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public final class b {
    static final e lNV;

    /* access modifiers changed from: package-private */
    public interface e {
        boolean a(BluetoothAdapter bluetoothAdapter, e eVar);

        boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar);
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
        AppMethodBeat.i(144616);
        Log.i("MicroMsg.ble.BleScannerCompat", "scanMode: " + scanSettingsCompat.lOQ);
        boolean a2 = lNV.a(bluetoothAdapter, list, scanSettingsCompat, eVar);
        AppMethodBeat.o(144616);
        return a2;
    }

    public static boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
        AppMethodBeat.i(144617);
        boolean a2 = lNV.a(bluetoothAdapter, eVar);
        AppMethodBeat.o(144617);
        return a2;
    }

    static {
        AppMethodBeat.i(144618);
        int i2 = Build.VERSION.SDK_INT;
        if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.lMp) {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
            lNV = new a();
            AppMethodBeat.o(144618);
        } else if (i2 >= 21) {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 21");
            lNV = new c();
            AppMethodBeat.o(144618);
        } else {
            Log.i("MicroMsg.ble.BleScannerCompat", "use 18");
            lNV = new a();
            AppMethodBeat.o(144618);
        }
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    static class c implements e {
        static final n<e, d> lNW = new n<>();

        c() {
        }

        static {
            AppMethodBeat.i(144611);
            AppMethodBeat.o(144611);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.e
        public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
            ArrayList arrayList;
            AppMethodBeat.i(144609);
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (ScanFilterCompat scanFilterCompat : list) {
                    ScanFilter.Builder builder = new ScanFilter.Builder();
                    if (scanFilterCompat.mDeviceName != null) {
                        builder.setDeviceName(scanFilterCompat.mDeviceName);
                    }
                    if (scanFilterCompat.lOv != null) {
                        builder.setServiceUuid(scanFilterCompat.lOv, scanFilterCompat.lOw);
                    }
                    if (scanFilterCompat.lOu != null) {
                        builder.setDeviceAddress(scanFilterCompat.lOu);
                    }
                    if (scanFilterCompat.lOx != null) {
                        builder.setServiceData(scanFilterCompat.lOx, scanFilterCompat.lOy, scanFilterCompat.lOz);
                    }
                    if (scanFilterCompat.lOA < 0) {
                        builder.setManufacturerData(scanFilterCompat.lOA, scanFilterCompat.lOB, scanFilterCompat.lOC);
                    }
                    arrayList.add(builder.build());
                }
            } else {
                arrayList = null;
            }
            if (scanSettingsCompat == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Scan settings are null");
                AppMethodBeat.o(144609);
                throw illegalStateException;
            }
            ScanSettings build = new ScanSettings.Builder().setReportDelay(scanSettingsCompat.lOS).setScanMode(scanSettingsCompat.lOQ).build();
            if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                Log.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.o(144609);
                return false;
            }
            Log.i("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            d dVar = lNW.get(eVar);
            if (dVar == null) {
                dVar = new d(eVar);
                lNW.put(eVar, dVar);
            }
            bluetoothLeScanner.startScan(arrayList, build, dVar);
            AppMethodBeat.o(144609);
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.e
        public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
            AppMethodBeat.i(144610);
            d remove = lNW.remove(eVar);
            if (remove == null) {
                AppMethodBeat.o(144610);
                return false;
            } else if (bluetoothAdapter.getBluetoothLeScanner() == null) {
                Log.e("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
                AppMethodBeat.o(144610);
                return false;
            } else {
                bluetoothAdapter.getBluetoothLeScanner().stopScan(remove);
                AppMethodBeat.o(144610);
                return true;
            }
        }
    }

    @TargetApi(18)
    static class a implements e {
        static final n<e, C0653b> lNW = new n<>();

        a() {
        }

        static {
            AppMethodBeat.i(144606);
            AppMethodBeat.o(144606);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.e
        public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
            AppMethodBeat.i(144604);
            Log.i("MicroMsg.ble.BleScannerCompat", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.ble.BleScannerCompat", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            C0653b bVar = lNW.get(eVar);
            if (bVar == null) {
                bVar = new C0653b(list, eVar);
                lNW.put(eVar, bVar);
            }
            boolean startLeScan = bluetoothAdapter.startLeScan(bVar);
            AppMethodBeat.o(144604);
            return startLeScan;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b.e
        public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
            AppMethodBeat.i(144605);
            C0653b remove = lNW.remove(eVar);
            if (remove == null) {
                AppMethodBeat.o(144605);
                return false;
            }
            bluetoothAdapter.stopLeScan(remove);
            AppMethodBeat.o(144605);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.b$b  reason: collision with other inner class name */
    static class C0653b implements BluetoothAdapter.LeScanCallback {
        private final List<ScanFilterCompat> lNX;
        private final WeakReference<e> lNY;

        C0653b(List<ScanFilterCompat> list, e eVar) {
            AppMethodBeat.i(144607);
            this.lNX = list;
            this.lNY = new WeakReference<>(eVar);
            AppMethodBeat.o(144607);
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            boolean z;
            byte[] bArr2;
            byte[] bArr3;
            boolean z2;
            AppMethodBeat.i(144608);
            e eVar = this.lNY.get();
            if (eVar == null) {
                AppMethodBeat.o(144608);
                return;
            }
            ScanResultCompat scanResultCompat = new ScanResultCompat(bluetoothDevice, f.aJ(bArr), i2, System.currentTimeMillis());
            if (this.lNX == null) {
                eVar.a(1, scanResultCompat);
                AppMethodBeat.o(144608);
                return;
            }
            for (ScanFilterCompat scanFilterCompat : this.lNX) {
                BluetoothDevice device = scanResultCompat.getDevice();
                if (scanFilterCompat.lOu == null || (device != null && scanFilterCompat.lOu.equals(device.getAddress()))) {
                    f fVar = scanResultCompat.lON;
                    if (fVar == null && !(scanFilterCompat.mDeviceName == null && scanFilterCompat.lOv == null && scanFilterCompat.lOB == null && scanFilterCompat.lOy == null && scanFilterCompat.lOx == null && scanFilterCompat.lOA < 0)) {
                        z = false;
                        continue;
                    } else if (scanFilterCompat.mDeviceName == null || scanFilterCompat.mDeviceName.equals(fVar.mDeviceName)) {
                        if (scanFilterCompat.lOv != null) {
                            ParcelUuid parcelUuid = scanFilterCompat.lOv;
                            ParcelUuid parcelUuid2 = scanFilterCompat.lOw;
                            List<ParcelUuid> list = fVar.lOG;
                            if (parcelUuid == null) {
                                z2 = true;
                            } else {
                                if (list != null) {
                                    Iterator<ParcelUuid> it = list.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        if (ScanFilterCompat.a(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), it.next().getUuid())) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = false;
                            }
                            if (!z2) {
                                z = false;
                                continue;
                            }
                        }
                        if (scanFilterCompat.lOx != null) {
                            byte[] bArr4 = scanFilterCompat.lOy;
                            byte[] bArr5 = scanFilterCompat.lOz;
                            ParcelUuid parcelUuid3 = scanFilterCompat.lOx;
                            if (parcelUuid3 == null) {
                                bArr3 = null;
                            } else {
                                bArr3 = fVar.lOI.get(parcelUuid3);
                            }
                            if (!ScanFilterCompat.a(bArr4, bArr5, bArr3)) {
                                z = false;
                                continue;
                            }
                        }
                        if (scanFilterCompat.lOA >= 0 && fVar != null) {
                            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMq) {
                                bArr2 = fVar.lOL.get(scanFilterCompat.lOA);
                            } else {
                                bArr2 = fVar.lOH.get(scanFilterCompat.lOA);
                            }
                            if (!ScanFilterCompat.a(scanFilterCompat.lOB, scanFilterCompat.lOC, bArr2)) {
                                z = false;
                                continue;
                            }
                        }
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    eVar.a(1, scanResultCompat);
                    AppMethodBeat.o(144608);
                    return;
                }
            }
            AppMethodBeat.o(144608);
        }
    }

    @TargetApi(21)
    static class d extends ScanCallback {
        private final WeakReference<e> lNY;

        d(e eVar) {
            AppMethodBeat.i(144612);
            this.lNY = new WeakReference<>(eVar);
            AppMethodBeat.o(144612);
        }

        public final void onScanResult(int i2, ScanResult scanResult) {
            AppMethodBeat.i(144613);
            e eVar = this.lNY.get();
            if (eVar != null) {
                eVar.a(i2, new ScanResultCompat(scanResult));
            }
            AppMethodBeat.o(144613);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onBatchScanResults(List<ScanResult> list) {
            AppMethodBeat.i(144614);
            if (this.lNY.get() == null) {
                AppMethodBeat.o(144614);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ScanResult scanResult : list) {
                arrayList.add(new ScanResultCompat(scanResult));
            }
            AppMethodBeat.o(144614);
        }

        public final void onScanFailed(int i2) {
            AppMethodBeat.i(144615);
            e eVar = this.lNY.get();
            if (eVar != null) {
                eVar.onScanFailed(i2);
            }
            AppMethodBeat.o(144615);
        }
    }
}
