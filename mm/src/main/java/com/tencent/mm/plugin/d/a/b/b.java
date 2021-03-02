package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build;
import android.view.InputDevice;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.d.a.b.c;
import com.tencent.mm.plugin.d.a.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public Context mAppContext;
    public MMHandler mHandler;
    public volatile boolean mIsInit;
    private Runnable mRunnable;
    public BluetoothAdapter pfW;
    public a pgB;
    public final HashMap<String, d> pgC;
    volatile boolean pgD;
    public c pgE;
    public g pgF;
    final HashSet<Long> pgG;
    private c.a pgH;
    private g.a pgI;

    public static abstract class a {
        public void i(long j2, long j3, long j4) {
        }

        public void l(long j2, boolean z) {
        }

        public void b(long j2, byte[] bArr) {
        }

        public void m(long j2, boolean z) {
        }

        public void a(String str, String str2, int i2, byte[] bArr) {
        }

        public void ckF() {
        }
    }

    public b(String str) {
        AppMethodBeat.i(179580);
        this.pgB = null;
        this.mAppContext = null;
        this.pgC = new HashMap<>();
        this.pfW = null;
        this.mHandler = null;
        this.mRunnable = null;
        this.pgD = false;
        this.mIsInit = false;
        this.pgG = new HashSet<>();
        this.pgH = new c.a() {
            /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.d.a.b.c.a
            public final void a(final BluetoothDevice bluetoothDevice, final int i2, final byte[] bArr) {
                AppMethodBeat.i(22476);
                Log.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.anY(bluetoothDevice.getAddress())));
                b.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(22475);
                        b.a(b.this, bluetoothDevice, i2, bArr);
                        AppMethodBeat.o(22475);
                    }
                });
                AppMethodBeat.o(22476);
            }

            @Override // com.tencent.mm.plugin.d.a.b.c.a
            public final void ckF() {
            }
        };
        this.pgI = new g.a() {
            /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.d.a.b.g.a
            public final void a(final BluetoothDevice bluetoothDevice, final int i2, final byte[] bArr) {
                AppMethodBeat.i(22479);
                Log.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.k.b.anY(bluetoothDevice.getAddress())));
                b.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(22477);
                        b.a(b.this, bluetoothDevice, i2, bArr);
                        AppMethodBeat.o(22477);
                    }
                });
                AppMethodBeat.o(22479);
            }

            @Override // com.tencent.mm.plugin.d.a.b.g.a
            public final void CL(int i2) {
                AppMethodBeat.i(22480);
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", Integer.valueOf(i2));
                if (i2 != 1) {
                    b.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass3.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(22478);
                            if (!b.this.pgG.isEmpty()) {
                                Iterator<Long> it = b.this.pgG.iterator();
                                while (it.hasNext()) {
                                    Long next = it.next();
                                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", next);
                                    if (b.this.pgB != null) {
                                        b.this.pgB.l(next.longValue(), false);
                                    }
                                }
                                b.this.pgG.clear();
                            }
                            AppMethodBeat.o(22478);
                        }
                    });
                }
                AppMethodBeat.o(22480);
            }
        };
        this.mRunnable = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(22474);
                b.this.pgD = false;
                b.this.kf(false);
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
                b.this.ckD();
                if (b.this.pgB != null) {
                    b.this.pgB.ckF();
                }
                AppMethodBeat.o(22474);
            }
        };
        this.mHandler = new MMHandler(str);
        AppMethodBeat.o(179580);
    }

    /* access modifiers changed from: package-private */
    public final void ckD() {
        AppMethodBeat.i(22483);
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.pgG.isEmpty()) {
            Iterator<Long> it = this.pgG.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", next);
                if (this.pgB != null) {
                    this.pgB.l(next.longValue(), false);
                }
            }
            this.pgG.clear();
        }
        AppMethodBeat.o(22483);
    }

    private void stopScan() {
        AppMethodBeat.i(22485);
        if (!this.pgD) {
            AppMethodBeat.o(22485);
            return;
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        this.pgD = false;
        kf(false);
        ckD();
        if (this.pgB != null) {
            this.pgB.ckF();
        }
        AppMethodBeat.o(22485);
    }

    public final boolean a(boolean z, int... iArr) {
        String str;
        AppMethodBeat.i(22486);
        StringBuilder sb = new StringBuilder("------scanLEDevice------");
        if (z) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        Log.i("MicroMsg.exdevice.BluetoothLEManager", sb.append(str).toString());
        Assert.assertTrue(this.mIsInit);
        if (!ckE()) {
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            AppMethodBeat.o(22486);
            return false;
        } else if (!z) {
            stopScan();
            AppMethodBeat.o(22486);
            return true;
        } else if (this.pgD) {
            AppMethodBeat.o(22486);
            return true;
        } else if (!kf(z)) {
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.pgG.isEmpty()) {
                Iterator<Long> it = this.pgG.iterator();
                while (it.hasNext()) {
                    Long next = it.next();
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", next);
                    if (this.pgB != null) {
                        this.pgB.l(next.longValue(), false);
                    }
                }
                this.pgG.clear();
            }
            AppMethodBeat.o(22486);
            return false;
        } else {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
            } else {
                this.mHandler.removeCallbacks(this.mRunnable);
            }
            this.pgD = true;
            AppMethodBeat.o(22486);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean kf(boolean z) {
        AppMethodBeat.i(22487);
        boolean z2 = false;
        if (d.oD(21) && this.pgF != null) {
            z2 = this.pgF.a(z, this.pgI);
        } else if (this.pgE != null) {
            z2 = this.pgE.a(z, this.pgH);
        } else {
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
        }
        AppMethodBeat.o(22487);
        return z2;
    }

    /* renamed from: com.tencent.mm.plugin.d.a.b.b$b  reason: collision with other inner class name */
    public final class RunnableC0936b implements Runnable {
        private long pgN = 0;
        private long pgO = 0;

        public RunnableC0936b(long j2, long j3) {
            this.pgN = j2;
            this.pgO = j3;
        }

        public final void run() {
            AppMethodBeat.i(22481);
            b bVar = b.this;
            long j2 = this.pgN;
            d dVar = new d(j2, bVar.mAppContext, bVar);
            String valueOf = String.valueOf(dVar.mSessionId);
            Log.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", Integer.valueOf(dVar.hashCode()), Long.valueOf(j2), valueOf);
            d remove = bVar.pgC.remove(valueOf);
            if (remove != null) {
                remove.close();
            }
            bVar.pgC.put(valueOf, dVar);
            long j3 = dVar.mSessionId;
            if (b.this.pgB != null) {
                b.this.pgB.i(j3, this.pgN, this.pgO);
            }
            AppMethodBeat.o(22481);
        }
    }

    public final boolean connect(long j2) {
        AppMethodBeat.i(22488);
        Log.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", Long.valueOf(j2));
        Assert.assertTrue(this.mIsInit);
        if (!ckE()) {
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            AppMethodBeat.o(22488);
            return false;
        }
        d dVar = this.pgC.get(String.valueOf(j2));
        Assert.assertTrue(dVar != null);
        BluetoothManager bluetoothManager = (BluetoothManager) this.mAppContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            Log.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
        } else {
            List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
            if (connectedDevices == null) {
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
            } else {
                for (BluetoothDevice bluetoothDevice : connectedDevices) {
                    long anY = com.tencent.mm.plugin.exdevice.k.b.anY(bluetoothDevice.getAddress());
                    Log.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", bluetoothDevice.getAddress(), Long.valueOf(anY), bluetoothDevice.getName());
                    if (j2 == anY) {
                        Log.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                        boolean connect = dVar.connect();
                        AppMethodBeat.o(22488);
                        return connect;
                    }
                }
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", Build.VERSION.RELEASE);
                if (!d.oD(23) || ((LocationManager) this.mAppContext.getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps") || Build.VERSION.RELEASE.equalsIgnoreCase("6.0") || Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                    Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                    if (bondedDevices != null) {
                        Iterator<BluetoothDevice> it = bondedDevices.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            BluetoothDevice next = it.next();
                            long anY2 = com.tencent.mm.plugin.exdevice.k.b.anY(next.getAddress());
                            Log.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", next.getAddress(), Long.valueOf(anY2), next.getName());
                            if (j2 == anY2) {
                                Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                InputManager inputManager = (InputManager) this.mAppContext.getSystemService("input");
                                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                if (inputDeviceIds == null) {
                                    Log.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                    break;
                                }
                                for (int i2 : inputDeviceIds) {
                                    InputDevice inputDevice = inputManager.getInputDevice(i2);
                                    if (inputDevice != null) {
                                        String name = inputDevice.getName();
                                        Log.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", name);
                                        if (name != null && name.equals(next.getName())) {
                                            Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                            boolean connect2 = dVar.connect();
                                            AppMethodBeat.o(22488);
                                            return connect2;
                                        }
                                    }
                                }
                                Log.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                            }
                        }
                    } else {
                        Log.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                    }
                } else {
                    boolean connect3 = dVar.connect();
                    AppMethodBeat.o(22488);
                    return connect3;
                }
            }
        }
        this.pgG.add(Long.valueOf(j2));
        boolean a2 = a(true, new int[0]);
        AppMethodBeat.o(22488);
        return a2;
    }

    @TargetApi(18)
    public final boolean ckE() {
        AppMethodBeat.i(22484);
        Assert.assertTrue(this.mIsInit);
        boolean hasSystemFeature = this.mAppContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.o(22484);
        return hasSystemFeature;
    }

    static /* synthetic */ void a(b bVar, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        AppMethodBeat.i(22489);
        Log.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!bVar.pgG.isEmpty()) {
            long anY = com.tencent.mm.plugin.exdevice.k.b.anY(bluetoothDevice.getAddress());
            if (bVar.pgG.contains(Long.valueOf(anY))) {
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", Long.valueOf(anY));
                d dVar = bVar.pgC.get(String.valueOf(anY));
                if (dVar == null) {
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (bVar.pgB != null) {
                        bVar.pgB.l(anY, false);
                    }
                } else if (!dVar.connect()) {
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (bVar.pgB != null) {
                        bVar.pgB.l(anY, false);
                    }
                }
                bVar.pgG.remove(Long.valueOf(anY));
                if (bVar.pgG.isEmpty()) {
                    Log.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (bVar.pgB != null) {
            bVar.pgB.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i2, bArr);
        }
        AppMethodBeat.o(22489);
    }
}
