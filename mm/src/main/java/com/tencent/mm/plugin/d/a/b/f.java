package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Message;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class f {
    static int phA = 0;
    private int aHK;
    public BluetoothDevice lOM;
    public MMHandler mHandler;
    public long mSessionId;
    private BluetoothAdapter pfW;
    private Context pgT;
    private BluetoothGatt pgU;
    private a pgY;
    private Runnable pgZ;
    private Runnable phb;
    private final LinkedList<byte[]> phd;
    private volatile boolean phe;
    private volatile int phf;
    private final BluetoothGattCallback phg;
    private a pht;
    private Runnable phu;
    private f phv;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> phw;
    private long phx;
    private ArrayList<BluetoothGattCharacteristic> phy;
    private boolean phz;

    static /* synthetic */ void j(f fVar) {
        AppMethodBeat.i(22554);
        fVar.ckI();
        AppMethodBeat.o(22554);
    }

    static /* synthetic */ void m(f fVar) {
        AppMethodBeat.i(22555);
        fVar.releaseResources();
        AppMethodBeat.o(22555);
    }

    public static abstract class a {
        public void a(long j2, boolean z, long j3) {
        }

        public void b(long j2, byte[] bArr) {
        }

        public void m(long j2, boolean z) {
        }
    }

    static class b extends MMHandler {
        private final WeakReference<f> phi;

        public b(com.tencent.f.j.a aVar, f fVar) {
            super(aVar);
            AppMethodBeat.i(179582);
            this.phi = new WeakReference<>(fVar);
            AppMethodBeat.o(179582);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22536);
            f fVar = this.phi.get();
            if (fVar == null) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                AppMethodBeat.o(22536);
                return;
            }
            switch (message.what) {
                case 0:
                    f.a(fVar);
                    AppMethodBeat.o(22536);
                    return;
                case 1:
                    f.b(fVar);
                    AppMethodBeat.o(22536);
                    return;
                case 2:
                    f.c(fVar);
                    AppMethodBeat.o(22536);
                    return;
                case 3:
                    f.a(fVar, (byte[]) message.obj);
                    AppMethodBeat.o(22536);
                    return;
                case 4:
                    if (fVar == null || message == null) {
                        AppMethodBeat.o(22536);
                        return;
                    }
                    f.a(fVar, message.arg1);
                    AppMethodBeat.o(22536);
                    return;
                case 5:
                    if (!f.a(fVar, (BluetoothGatt) message.obj, message.arg1)) {
                        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
                        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(1))) {
                            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 1);
                        }
                        AppMethodBeat.o(22536);
                        return;
                    }
                    break;
                case 6:
                    Object obj = message.obj;
                    f.b(fVar, message.arg1);
                    AppMethodBeat.o(22536);
                    return;
                case 7:
                    f.c(fVar, message.arg1);
                    AppMethodBeat.o(22536);
                    return;
                case 8:
                    f.a(fVar, (BluetoothGattCharacteristic) message.obj);
                    AppMethodBeat.o(22536);
                    return;
                case 9:
                    f.d(fVar);
                    break;
            }
            AppMethodBeat.o(22536);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ckJ() {
        AppMethodBeat.i(22537);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
        this.phf = 2;
        this.mHandler.removeCallbacks(this.phb);
        this.mHandler.removeCallbacks(this.phu);
        ckK();
        releaseResources();
        AppMethodBeat.o(22537);
    }

    @TargetApi(18)
    public f(long j2, Context context, a aVar) {
        AppMethodBeat.i(22538);
        this.phd = new LinkedList<>();
        this.phe = false;
        this.phw = new HashMap<>();
        this.phx = 0;
        this.phy = new ArrayList<>();
        this.phg = new BluetoothGattCallback() {
            /* class com.tencent.mm.plugin.d.a.b.f.AnonymousClass1 */

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
                AppMethodBeat.i(22526);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(f.this.phf));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(4, i3, 0))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 4);
                }
                AppMethodBeat.o(22526);
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
                AppMethodBeat.i(22527);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i2));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(5, i2, 0, bluetoothGatt))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 5);
                }
                AppMethodBeat.o(22527);
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
                AppMethodBeat.i(22528);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i2));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(6, i2, 0, bluetoothGatt))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 6);
                }
                AppMethodBeat.o(22528);
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                AppMethodBeat.i(22529);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 8);
                }
                AppMethodBeat.o(22529);
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
                AppMethodBeat.i(22530);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i2));
                if (i2 == 0 && !f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 8);
                }
                AppMethodBeat.o(22530);
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
                AppMethodBeat.i(22531);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i2));
                if (!f.this.mHandler.sendMessage(f.this.mHandler.obtainMessage(7, i2, 0))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 7);
                }
                AppMethodBeat.o(22531);
            }
        };
        this.aHK = -1;
        this.aHK = hashCode();
        this.phv = this;
        this.pht = aVar;
        this.pgT = context;
        this.pfW = ((BluetoothManager) this.pgT.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j2;
        this.phf = 3;
        this.lOM = this.pfW.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.BC(j2));
        this.pgY = new a();
        this.phz = false;
        this.mHandler = new b(com.tencent.f.j.a.bqt("BluetoothLESimpleSession_handlerThread"), this);
        this.pgZ = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(22532);
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(f.this.mSessionId), f.this.lOM.getName());
                if (f.this.pht != null) {
                    f.this.pht.m(f.this.mSessionId, false);
                }
                f.j(f.this);
                AppMethodBeat.o(22532);
            }
        };
        this.phb = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(22533);
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(f.this.mSessionId), f.this.lOM.getName());
                if (3 == f.this.phf) {
                    Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                    AppMethodBeat.o(22533);
                } else if (f.this.phf == 1) {
                    Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                    AppMethodBeat.o(22533);
                } else {
                    f.this.ckJ();
                    AppMethodBeat.o(22533);
                }
            }
        };
        this.phu = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.f.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(22534);
                if (f.this.phz) {
                    if (f.this.pht != null) {
                        f.this.pht.a(f.this.mSessionId, false, f.this.phx);
                    }
                    Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                    f.m(f.this);
                }
                AppMethodBeat.o(22534);
            }
        };
        AppMethodBeat.o(22538);
    }

    private void releaseResources() {
        AppMethodBeat.i(22539);
        if (this.pgU == null) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
            AppMethodBeat.o(22539);
            return;
        }
        phA--;
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(hashCode()), Integer.valueOf(phA), com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
        this.phz = false;
        this.pgU.close();
        this.mHandler.quitSafely();
        this.pgU = null;
        AppMethodBeat.o(22539);
    }

    public final boolean connect() {
        AppMethodBeat.i(22540);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.o(22540);
        return sendMessage;
    }

    private void ckH() {
        AppMethodBeat.i(22541);
        this.phe = false;
        this.phd.clear();
        AppMethodBeat.o(22541);
    }

    private void ckK() {
        AppMethodBeat.i(22542);
        if (this.pht == null) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
            AppMethodBeat.o(22542);
            return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
        if (this.pht != null) {
            this.pht.a(this.mSessionId, false, this.phx);
        }
        this.pht = null;
        AppMethodBeat.o(22542);
    }

    private void ckI() {
        String str;
        AppMethodBeat.i(22543);
        if (this.phd.isEmpty()) {
            this.phe = false;
            AppMethodBeat.o(22543);
            return;
        }
        com.tencent.mm.plugin.d.a.b.a.a aX = com.tencent.mm.plugin.d.a.b.a.a.aX(this.phd.pop());
        byte[] ckM = aX.ckM();
        String str2 = aX.pie;
        int i2 = aX.pif;
        String BA = c.BA(aX.phx);
        HashMap<String, BluetoothGattCharacteristic> hashMap = this.phw.get(BA);
        if (hashMap == null) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", BA, com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
            if (this.pht != null) {
                this.pht.m(this.mSessionId, false);
            }
            AppMethodBeat.o(22543);
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = hashMap.get(str2);
        if (bluetoothGattCharacteristic == null) {
            Object[] objArr = new Object[3];
            if (str2 == null) {
                str = BuildConfig.COMMAND;
            } else {
                str = str2;
            }
            objArr[0] = str;
            objArr[1] = com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId);
            objArr[2] = this.lOM.getName();
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found, mac=%s, name=%s", objArr);
            if (this.pht != null) {
                this.pht.m(this.mSessionId, false);
            }
            AppMethodBeat.o(22543);
        } else if (i2 == 8) {
            this.pgY.pgA = bluetoothGattCharacteristic;
            this.pgY.setData(ckM);
            byte[] ckC = this.pgY.ckC();
            Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.bw(ckC), str2, com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
            bluetoothGattCharacteristic.setValue(ckC);
            this.mHandler.postDelayed(this.pgZ, 5000);
            if (!this.pgU.writeCharacteristic(bluetoothGattCharacteristic)) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
                if (this.pht != null) {
                    this.pht.m(this.mSessionId, false);
                }
                AppMethodBeat.o(22543);
                return;
            }
            this.phe = true;
            AppMethodBeat.o(22543);
        } else {
            Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", Integer.valueOf(i2), com.tencent.mm.plugin.exdevice.k.b.Dj(this.mSessionId), this.lOM.getName());
            if (this.pht != null) {
                this.pht.m(this.mSessionId, false);
            }
            AppMethodBeat.o(22543);
        }
    }

    static /* synthetic */ void a(f fVar) {
        boolean z;
        AppMethodBeat.i(22544);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (1 == fVar.phf) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.pht != null) {
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.pht.a(fVar.mSessionId, true, fVar.phx);
            }
            AppMethodBeat.o(22544);
        } else if (fVar.phf == 0) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
            AppMethodBeat.o(22544);
        } else {
            fVar.ckH();
            if (fVar.pgU == null) {
                try {
                    fVar.pgU = fVar.lOM.connectGatt(fVar.pgT, false, fVar.phg);
                    z = false;
                } catch (NullPointerException e2) {
                    Log.printErrStackTrace("MicroMsg.exdevice.BluetoothLESimpleSession", e2, "", new Object[0]);
                    z = true;
                }
                phA++;
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", Integer.valueOf(fVar.hashCode()), Integer.valueOf(phA), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
                if (fVar.pgU == null || z) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.ckK();
                    AppMethodBeat.o(22544);
                    return;
                }
                fVar.phf = 0;
                fVar.mHandler.postDelayed(fVar.phb, 10000);
                AppMethodBeat.o(22544);
            } else if (!fVar.pgU.connect()) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.ckK();
                AppMethodBeat.o(22544);
            } else {
                fVar.phf = 0;
                fVar.mHandler.postDelayed(fVar.phb, 10000);
                AppMethodBeat.o(22544);
            }
        }
    }

    static /* synthetic */ void a(f fVar, int i2) {
        AppMethodBeat.i(22545);
        Object[] objArr = new Object[3];
        objArr[0] = i2 == 2 ? "Connected" : "Disconnected";
        objArr[1] = com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId);
        objArr[2] = fVar.lOM.getName();
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChangeImp------ aState = %s, mac=%s, name=%s", objArr);
        if (i2 == 2) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(fVar.phf));
            if (3 == fVar.phf) {
                Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.phb);
                AppMethodBeat.o(22545);
            } else if (1 == fVar.phf) {
                Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.phb);
                AppMethodBeat.o(22545);
            } else if (fVar.pgU == null || !fVar.pgU.discoverServices()) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "discover Services start failed!!!");
                fVar.ckJ();
                AppMethodBeat.o(22545);
            } else {
                fVar.mHandler.removeCallbacks(fVar.phb);
                fVar.mHandler.postDelayed(fVar.phb, 10000);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "start discoverServices...");
                AppMethodBeat.o(22545);
            }
        } else {
            if (i2 == 0) {
                Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Disconnected from GATT server.");
                fVar.phw.clear();
                fVar.phy.clear();
                fVar.phx = 0;
                fVar.ckJ();
            }
            AppMethodBeat.o(22545);
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i2) {
        boolean z;
        AppMethodBeat.i(22546);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", Integer.valueOf(i2), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        fVar.mHandler.removeCallbacks(fVar.phb);
        if (3 == fVar.phf) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            AppMethodBeat.o(22546);
            return false;
        }
        if (1 == fVar.phf) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i2 != 0) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.ckJ();
            AppMethodBeat.o(22546);
            return false;
        } else {
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            for (int i3 = 0; i3 < services.size(); i3++) {
                BluetoothGattService bluetoothGattService = services.get(i3);
                if (bluetoothGattService == null) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    z = false;
                } else if (!c.b(bluetoothGattService)) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    z = false;
                } else {
                    fVar.phx |= c.a(bluetoothGattService);
                    HashMap<String, BluetoothGattCharacteristic> hashMap = new HashMap<>();
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    for (int i4 = 0; i4 < characteristics.size(); i4++) {
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristics.get(i4);
                        String uuid = bluetoothGattCharacteristic.getUuid().toString();
                        Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", uuid, Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(bluetoothGattCharacteristic.getPermissions()));
                        if (uuid == null) {
                            uuid = BuildConfig.COMMAND;
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.phy.add(bluetoothGattCharacteristic);
                    }
                    fVar.phw.put(bluetoothGattService.getUuid().toString(), hashMap);
                    z = true;
                }
                if (!z) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", bluetoothGattService.getUuid().toString());
                }
            }
            if (0 == fVar.phx) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.ckJ();
                AppMethodBeat.o(22546);
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 9);
            }
        }
        AppMethodBeat.o(22546);
        return true;
    }

    static /* synthetic */ void b(f fVar, int i2) {
        AppMethodBeat.i(22547);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i2), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", 9);
        }
        AppMethodBeat.o(22547);
    }

    static /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(22548);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (3 == fVar.phf) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
            AppMethodBeat.o(22548);
        } else if (2 == fVar.phf) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
            AppMethodBeat.o(22548);
        } else {
            fVar.ckH();
            if (fVar.pgU == null) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                AppMethodBeat.o(22548);
                return;
            }
            fVar.phf = 3;
            fVar.mHandler.removeCallbacks(fVar.phb);
            if (fVar.pgU != null) {
                fVar.pgU.disconnect();
            }
            AppMethodBeat.o(22548);
        }
    }

    static /* synthetic */ void a(f fVar, byte[] bArr) {
        boolean z;
        String str;
        boolean z2 = true;
        AppMethodBeat.i(22549);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeDataAsync------parserobj length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (1 != fVar.phf) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Not ready for write data, connectstate = %d", Integer.valueOf(fVar.phf));
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
            return;
        }
        com.tencent.mm.plugin.d.a.b.a.a aX = com.tencent.mm.plugin.d.a.b.a.a.aX(bArr);
        if (aX == null) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error, no match ProfileParser, connect state = %d", Integer.valueOf(fVar.phf));
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
            return;
        }
        Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "rawData data dump = %s", com.tencent.mm.plugin.exdevice.k.b.bw(aX.ckM()));
        String str2 = aX.pie;
        int i2 = aX.pif;
        String BA = c.BA(aX.phx);
        HashMap<String, BluetoothGattCharacteristic> hashMap = fVar.phw.get(BA);
        if (hashMap == null) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found", BA);
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = hashMap.get(str2);
        if (bluetoothGattCharacteristic == null) {
            Object[] objArr = new Object[1];
            if (str2 == null) {
                str = BuildConfig.COMMAND;
            } else {
                str = str2;
            }
            objArr[0] = str;
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic(%s) not found", objArr);
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
        } else if ((bluetoothGattCharacteristic.getProperties() | i2) == 0) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "property not support. current = %d, provided = %d", Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(i2));
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
        } else if (i2 == 2) {
            if (bluetoothGattCharacteristic == null) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic not found");
                z = false;
            } else if (!fVar.pgU.readCharacteristic(bluetoothGattCharacteristic)) {
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.readCharacteristic Failed!!!");
                z = false;
            } else {
                z = true;
            }
            Object[] objArr2 = new Object[1];
            objArr2[0] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "readCharacteristic state: %s", objArr2);
            if (fVar.pht != null) {
                if (z) {
                    fVar.pht.m(fVar.mSessionId, true);
                    AppMethodBeat.o(22549);
                    return;
                }
                fVar.pht.m(fVar.mSessionId, false);
            }
            AppMethodBeat.o(22549);
        } else {
            Assert.assertTrue(fVar.pgU != null);
            fVar.phd.add(bArr);
            if (!fVar.phe) {
                if (1 != fVar.phd.size()) {
                    z2 = false;
                }
                Assert.assertTrue(z2);
                fVar.ckI();
            }
            AppMethodBeat.o(22549);
        }
    }

    static /* synthetic */ void c(f fVar, int i2) {
        AppMethodBeat.i(22550);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", Integer.valueOf(i2), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        fVar.mHandler.removeCallbacks(fVar.pgZ);
        if (i2 != 0) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: ".concat(String.valueOf(i2)));
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, false);
            }
            fVar.ckI();
            AppMethodBeat.o(22550);
            return;
        }
        byte[] ckC = fVar.pgY.ckC();
        Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", com.tencent.mm.plugin.exdevice.k.b.bw(ckC));
        if (ckC == null) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.pht != null) {
                fVar.pht.m(fVar.mSessionId, true);
            }
            fVar.ckI();
            AppMethodBeat.o(22550);
            return;
        }
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.pgY.pgA.setValue(ckC);
        fVar.pgU.writeCharacteristic(fVar.pgY.pgA);
        fVar.mHandler.postDelayed(fVar.pgZ, 5000);
        AppMethodBeat.o(22550);
    }

    static /* synthetic */ void a(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(22551);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceiveImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (bluetoothGattCharacteristic == null) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic is null");
            AppMethodBeat.o(22551);
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        String V = com.tencent.mm.plugin.exdevice.k.b.V(value, value.length);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "data length = %d", Integer.valueOf(value.length));
        Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "data dump = %s", V);
        byte[] a2 = c.a(bluetoothGattCharacteristic, value);
        if (a2 == null) {
            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse data error");
            AppMethodBeat.o(22551);
            return;
        }
        if (fVar.pht != null) {
            fVar.pht.b(fVar.mSessionId, a2);
        }
        AppMethodBeat.o(22551);
    }

    static /* synthetic */ void c(f fVar) {
        AppMethodBeat.i(22552);
        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
        if (3 == fVar.phf) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.ckK();
            AppMethodBeat.o(22552);
            return;
        }
        fVar.ckH();
        if (fVar.pgU == null) {
            Log.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.ckK();
            AppMethodBeat.o(22552);
            return;
        }
        fVar.phf = 3;
        fVar.mHandler.removeCallbacks(fVar.phb);
        fVar.ckK();
        if (fVar.pgU != null) {
            Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
            fVar.pgU.disconnect();
            fVar.phz = true;
            fVar.mHandler.postDelayed(fVar.phu, 10000);
        }
        AppMethodBeat.o(22552);
    }

    static /* synthetic */ void d(f fVar) {
        boolean z;
        AppMethodBeat.i(22553);
        while (true) {
            if (fVar.phy.size() > 0) {
                BluetoothGattCharacteristic remove = fVar.phy.remove(0);
                f fVar2 = fVar.phv;
                int properties = remove.getProperties();
                if ((properties & 48) == 0) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                    z = false;
                } else if (!fVar2.pgU.setCharacteristicNotification(remove, true)) {
                    Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                    z = false;
                } else {
                    BluetoothGattDescriptor descriptor = remove.getDescriptor(UUID.fromString(h.phH));
                    if (descriptor == null) {
                        Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                        z = false;
                    } else {
                        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                        byte[] bArr = {0, 0};
                        if ((properties & 32) != 0) {
                            bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                            bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                        }
                        if ((properties & 16) != 0) {
                            bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                            bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                        }
                        if (!descriptor.setValue(bArr)) {
                            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                            z = false;
                        } else if (!fVar2.pgU.writeDescriptor(descriptor)) {
                            Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                }
                if (z) {
                    break;
                }
                Log.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", remove.getUuid().toString(), Integer.valueOf(remove.getProperties()));
            } else {
                Log.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
                fVar.phf = 1;
                fVar.mHandler.removeCallbacks(fVar.phb);
                if (fVar.pht != null) {
                    fVar.pht.a(fVar.mSessionId, true, fVar.phx);
                }
            }
        }
        AppMethodBeat.o(22553);
    }
}
