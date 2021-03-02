package com.tencent.mm.plugin.d.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements BluetoothAdapter.LeScanCallback, b, r {
    private static boolean pfT = false;
    public static boolean pfV = false;
    public final MMHandler mHandler;
    private final b pfO;
    private final d pfR = new d(this);
    private final HashSet<UUID> pfS = new HashSet<>();
    private boolean pfU = false;
    private BluetoothAdapter pfW;
    private boolean pfX = true;
    private int pfY = 0;
    private String pfZ = "";
    private e pga = null;
    private Map<String, Long> pgb = new ConcurrentHashMap();
    private final MTimerHandler pgc = new MTimerHandler(v.cLz().jkv.getSerialTag(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(22445);
            f.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22444);
                    f.this.pfR.a(f.this.pfY, f.this.pfZ, f.this.pga);
                    AppMethodBeat.o(22444);
                }
            });
            AppMethodBeat.o(22445);
            return false;
        }
    }, true);
    private final MTimerHandler pgd = new MTimerHandler(v.cLz().jkv.getSerialTag(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(22446);
            if (f.this.pfS.size() > 0) {
                Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                if (f.g(f.this).booleanValue()) {
                    Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                boolean unused = f.pfV = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                if (!f.pfV) {
                    if (!f.this.pge.stopped()) {
                        f.this.pge.stopTimer();
                    }
                    if (!f.this.pgd.stopped()) {
                        f.this.pgd.stopTimer();
                    }
                }
            }
            AppMethodBeat.o(22446);
            return false;
        }
    }, true);
    private final MTimerHandler pge = new MTimerHandler(v.cLz().jkv.getSerialTag(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(22447);
            if (f.this.pfS.size() > 0) {
                Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
                f.j(f.this);
                if (f.this.pgd.stopped()) {
                    f.this.pgd.startTimer(2000);
                }
                AppMethodBeat.o(22447);
                return true;
            }
            AppMethodBeat.o(22447);
            return false;
        }
    }, true);
    private final MTimerHandler pgf = new MTimerHandler(v.cLz().jkv.getSerialTag(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(22448);
            Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            boolean unused = f.pfT = false;
            AppMethodBeat.o(22448);
            return false;
        }
    }, true);
    private final MTimerHandler pgg = new MTimerHandler(v.cLz().jkv.getSerialTag(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(22449);
            Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            f.k(f.this);
            AppMethodBeat.o(22449);
            return false;
        }
    }, true);

    static /* synthetic */ void k(f fVar) {
        AppMethodBeat.i(22464);
        fVar.stopScan();
        AppMethodBeat.o(22464);
    }

    public f(b bVar) {
        AppMethodBeat.i(22454);
        this.pfO = bVar;
        this.mHandler = new MMHandler(v.cLz().jkv.getSerialTag());
        this.pfW = ((BluetoothManager) MMApplicationContext.getContext().getSystemService("bluetooth")).getAdapter();
        AppMethodBeat.o(22454);
    }

    private void stopScan() {
        AppMethodBeat.i(22455);
        this.pgb.clear();
        pfT = false;
        if (!this.pgf.stopped()) {
            this.pgf.stopTimer();
        }
        if (!this.pge.stopped()) {
            this.pge.stopTimer();
        }
        if (!this.pgd.stopped()) {
            this.pgd.stopTimer();
        }
        if (!this.pgc.stopped()) {
            this.pgc.stopTimer();
        }
        if (!this.pgg.stopped()) {
            this.pgg.stopTimer();
        }
        if (this.pfU && this.pfW != null) {
            if (this.pfW != null) {
                this.pfW.stopLeScan(this);
            }
            this.pfU = false;
        }
        AppMethodBeat.o(22455);
    }

    private synchronized void ckA() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(22456);
            if (this.pgf.stopped()) {
                this.pgf.startTimer(2000);
            }
            if (pfV && this.pge.stopped()) {
                this.pge.startTimer(10000);
            }
            if (this.pgg.stopped()) {
                if (!pfV) {
                    this.pgg.startTimer(120000);
                } else {
                    this.pgg.startTimer(1800000);
                }
            }
            if (!pfT) {
                this.pfX = true;
                Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
                Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                Boolean valueOf = Boolean.valueOf(this.pfW.startLeScan(this));
                if (valueOf.booleanValue() || pfT) {
                    this.pfU = true;
                    pfT = true;
                    Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                } else {
                    while (!valueOf.booleanValue() && i2 < 3 && !pfT) {
                        i2++;
                        this.pfW.stopLeScan(this);
                        Log.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i2 + " time");
                        Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
                        Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                        valueOf = Boolean.valueOf(this.pfW.startLeScan(this));
                        if (valueOf.booleanValue()) {
                            pfT = true;
                            this.pfU = true;
                            Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                        }
                    }
                    AppMethodBeat.o(22456);
                }
            }
            AppMethodBeat.o(22456);
        }
    }

    @Override // com.tencent.mm.plugin.d.a.a.b
    public final void a(double d2, c cVar) {
        AppMethodBeat.i(22457);
        Log.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", Double.valueOf(d2));
        String bw = b.bw(cVar.pfM.pfQ.pgr);
        if (bw.length() >= 32) {
            bw = bw.substring(0, 8) + "-" + bw.substring(8, 12) + "-" + bw.substring(12, 16) + "-" + bw.substring(16, 20) + "-" + bw.substring(20);
        }
        String str = bw + ((int) cVar.pfM.pfQ.pgs) + ((int) cVar.pfM.pfQ.pgt);
        if (!this.pgb.containsKey(str)) {
            this.pgb.put(str, Long.valueOf(System.currentTimeMillis()));
            this.pfO.a(d2, cVar);
            Log.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + bw + ",major = " + ((int) cVar.pfM.pfQ.pgs) + ",minor = " + (cVar.pfM.pfQ.pgt & ISelectionInterface.HELD_NOTHING));
            AppMethodBeat.o(22457);
            return;
        }
        long longValue = this.pgb.get(str).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 500) {
            this.pgb.put(str, Long.valueOf(currentTimeMillis));
            this.pfO.a(d2, cVar);
        }
        AppMethodBeat.o(22457);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void CK(int i2) {
        AppMethodBeat.i(22458);
        if (i2 != 0) {
            AppMethodBeat.o(22458);
            return;
        }
        stopScan();
        AppMethodBeat.o(22458);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void a(final String str, String str2, int i2, final int i3, byte[] bArr) {
        AppMethodBeat.i(22459);
        Log.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), b.bw(bArr));
        if (i2 != 0) {
            AppMethodBeat.o(22459);
            return;
        }
        final e eVar = new e();
        if (!eVar.aV(bArr)) {
            Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
            AppMethodBeat.o(22459);
            return;
        }
        UUID by = b.by(eVar.pfQ.pgr);
        if (by == null) {
            Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
            AppMethodBeat.o(22459);
        } else if (!this.pfS.contains(by)) {
            Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
            AppMethodBeat.o(22459);
        } else {
            if (this.pfX) {
                this.pfZ = str;
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(22452);
                    f.this.pfR.a(i3, str, eVar);
                    AppMethodBeat.o(22452);
                }
            });
            AppMethodBeat.o(22459);
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void ahk(String str) {
        AppMethodBeat.i(22460);
        Log.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", -1, str);
        AppMethodBeat.o(22460);
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i2, byte[] bArr) {
        AppMethodBeat.i(22461);
        final e eVar = new e();
        if (!eVar.aV(bArr)) {
            Log.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
            AppMethodBeat.o(22461);
            return;
        }
        UUID by = b.by(eVar.pfQ.pgr);
        if (by == null) {
            Log.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
            AppMethodBeat.o(22461);
        } else if (!this.pfS.contains(by)) {
            Log.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
            AppMethodBeat.o(22461);
        } else {
            if (this.pfX) {
                this.pfY = i2;
                this.pga = eVar;
                if (this.pgc.stopped()) {
                    this.pgc.startTimer(2000);
                }
                this.pfX = false;
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.d.a.a.f.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(22453);
                    f.this.pfR.a(i2, bluetoothDevice.getAddress(), eVar);
                    AppMethodBeat.o(22453);
                }
            });
            AppMethodBeat.o(22461);
        }
    }

    static /* synthetic */ Boolean g(f fVar) {
        AppMethodBeat.i(22462);
        if (fVar.pfW != null) {
            Log.i("MicroMsg.exdevice.IBeaconServer", "[BluetoothTrace] start scan");
            Log.printErrStackTrace("MicroMsg.exdevice.IBeaconServer", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
            Boolean valueOf = Boolean.valueOf(fVar.pfW.startLeScan(fVar));
            AppMethodBeat.o(22462);
            return valueOf;
        }
        Boolean bool = Boolean.FALSE;
        AppMethodBeat.o(22462);
        return bool;
    }

    static /* synthetic */ void j(f fVar) {
        AppMethodBeat.i(22463);
        if (fVar.pfW != null) {
            fVar.pfW.stopLeScan(fVar);
        }
        AppMethodBeat.o(22463);
    }

    static /* synthetic */ boolean a(f fVar, UUID uuid) {
        AppMethodBeat.i(22465);
        Log.i("MicroMsg.exdevice.IBeaconServer", "startRanging");
        if (uuid == null) {
            Log.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            AppMethodBeat.o(22465);
            return false;
        }
        if (!fVar.pfS.contains(uuid)) {
            fVar.pfS.add(uuid);
        }
        fVar.ckA();
        AppMethodBeat.o(22465);
        return true;
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        AppMethodBeat.i(22466);
        Log.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            Log.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            AppMethodBeat.o(22466);
            return false;
        }
        fVar.pfS.remove(uuid);
        fVar.stopScan();
        AppMethodBeat.o(22466);
        return true;
    }
}
