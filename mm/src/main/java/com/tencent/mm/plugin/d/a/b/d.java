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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int aHK;
    BluetoothDevice lOM;
    public MMHandler mHandler;
    long mSessionId;
    private BluetoothAdapter pfW;
    Context pgT;
    BluetoothGatt pgU;
    b pgV;
    BluetoothGattCharacteristic pgW;
    BluetoothGattCharacteristic pgX;
    a pgY;
    Runnable pgZ;
    Runnable pha;
    Runnable phb;
    d phc;
    final LinkedList<byte[]> phd;
    volatile boolean phe;
    int phf;
    final BluetoothGattCallback phg;

    static class a extends MMHandler {
        private final WeakReference<d> phi;

        public a(com.tencent.f.j.a aVar, d dVar) {
            super(aVar);
            AppMethodBeat.i(179581);
            this.phi = new WeakReference<>(dVar);
            AppMethodBeat.o(179581);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(22508);
            d dVar = this.phi.get();
            if (dVar == null) {
                Log.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                AppMethodBeat.o(22508);
                return;
            }
            switch (message.what) {
                case 0:
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        AppMethodBeat.o(22508);
                        return;
                    } else if (dVar.phf == 0) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        AppMethodBeat.o(22508);
                        return;
                    } else {
                        dVar.ckH();
                        if (dVar.pgU == null) {
                            dVar.pgU = dVar.lOM.connectGatt(dVar.pgT, false, dVar.phg);
                            if (dVar.pgU == null) {
                                Log.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.pgV != null) {
                                    dVar.pgV.pgB.l(dVar.mSessionId, false);
                                }
                                AppMethodBeat.o(22508);
                                return;
                            }
                            dVar.phf = 0;
                            dVar.mHandler.postDelayed(dVar.phb, 10000);
                            AppMethodBeat.o(22508);
                            return;
                        } else if (!dVar.pgU.connect()) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        } else {
                            dVar.phf = 0;
                            dVar.mHandler.postDelayed(dVar.phb, 10000);
                            AppMethodBeat.o(22508);
                            return;
                        }
                    }
                case 1:
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        AppMethodBeat.o(22508);
                        return;
                    }
                    dVar.ckH();
                    if (dVar.pgU == null) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        AppMethodBeat.o(22508);
                        return;
                    }
                    dVar.phf = 3;
                    dVar.mHandler.removeCallbacks(dVar.phb);
                    dVar.mHandler.removeCallbacks(dVar.pha);
                    dVar.pgU.disconnect();
                    AppMethodBeat.o(22508);
                    return;
                case 2:
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 != dVar.phf) {
                        dVar.ckH();
                        if (dVar.pgU != null) {
                            dVar.phf = 3;
                            dVar.pgU.disconnect();
                            dVar.pgU.close();
                            dVar.pgU = null;
                            break;
                        } else {
                            Log.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                            AppMethodBeat.o(22508);
                            return;
                        }
                    } else {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                        AppMethodBeat.o(22508);
                        return;
                    }
                case 3:
                    byte[] bArr = (byte[]) message.obj;
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", Integer.valueOf(bArr.length));
                    if (1 != dVar.phf) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", Integer.valueOf(dVar.phf));
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.m(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(22508);
                        return;
                    }
                    Assert.assertTrue((dVar.pgU == null || dVar.pgX == null) ? false : true);
                    dVar.phd.add(bArr);
                    if (!dVar.phe) {
                        if (1 != dVar.phd.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.ckI();
                    }
                    AppMethodBeat.o(22508);
                    return;
                case 4:
                    int i2 = message.arg1;
                    Object[] objArr = new Object[1];
                    objArr[0] = i2 == 2 ? "Connected" : "Disconnected";
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChangeImp------ aState = %s", objArr);
                    if (i2 == 2) {
                        Log.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(dVar.phf));
                        if (3 == dVar.phf) {
                            Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            AppMethodBeat.o(22508);
                            return;
                        } else if (1 == dVar.phf) {
                            Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            AppMethodBeat.o(22508);
                            return;
                        } else if (!dVar.pgU.discoverServices()) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        } else {
                            Log.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            AppMethodBeat.o(22508);
                            return;
                        }
                    } else {
                        if (i2 == 0) {
                            Log.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                        }
                        AppMethodBeat.o(22508);
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    int i3 = message.arg1;
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", Integer.valueOf(i3));
                    if (3 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.phb);
                        AppMethodBeat.o(22508);
                        return;
                    } else if (1 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.phb);
                        AppMethodBeat.o(22508);
                        return;
                    } else if (i3 != 0) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.phf = 2;
                        dVar.mHandler.removeCallbacks(dVar.phb);
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.l(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(22508);
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.phI));
                        if (service == null) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        }
                        dVar.pgW = service.getCharacteristic(UUID.fromString(h.phK));
                        if (dVar.pgW == null) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        }
                        dVar.pgX = service.getCharacteristic(UUID.fromString(h.phJ));
                        if (dVar.pgX == null) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        }
                        int properties = dVar.pgW.getProperties();
                        Log.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", Integer.valueOf(properties));
                        if ((properties & 32) == 0) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                            AppMethodBeat.o(22508);
                            return;
                        }
                        Log.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.phc;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.pgW;
                        if (!dVar2.pgU.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        } else {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.phH));
                            if (descriptor == null) {
                                Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                Log.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (!dVar2.pgU.writeDescriptor(descriptor)) {
                                    Log.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                } else {
                                    dVar2.mHandler.postDelayed(dVar2.pha, 5000);
                                }
                            }
                        }
                        if (!z) {
                            Log.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.phf = 2;
                            dVar.mHandler.removeCallbacks(dVar.phb);
                            if (dVar.pgV != null) {
                                dVar.pgV.pgB.l(dVar.mSessionId, false);
                            }
                        }
                        AppMethodBeat.o(22508);
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    int i4 = message.arg1;
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", Integer.valueOf(i4));
                    dVar.mHandler.removeCallbacks(dVar.pha);
                    dVar.mHandler.removeCallbacks(dVar.phb);
                    if (3 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        AppMethodBeat.o(22508);
                        return;
                    } else if (1 == dVar.phf) {
                        Log.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        AppMethodBeat.o(22508);
                        return;
                    } else if (i4 != 0) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.phf = 2;
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.l(dVar.mSessionId, false);
                        }
                        AppMethodBeat.o(22508);
                        return;
                    } else {
                        dVar.phf = 1;
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.l(dVar.mSessionId, true);
                        }
                        Log.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", Integer.valueOf(dVar.phf));
                        AppMethodBeat.o(22508);
                        return;
                    }
                case 7:
                    int i5 = message.arg1;
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", Integer.valueOf(i5));
                    dVar.mHandler.removeCallbacks(dVar.pgZ);
                    if (i5 != 0) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "write data error: ".concat(String.valueOf(i5)));
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.m(dVar.mSessionId, false);
                        }
                        dVar.ckI();
                        AppMethodBeat.o(22508);
                        return;
                    }
                    byte[] ckC = dVar.pgY.ckC();
                    Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.bw(ckC));
                    if (ckC == null) {
                        Log.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.pgV != null) {
                            dVar.pgV.pgB.m(dVar.mSessionId, true);
                        }
                        dVar.ckI();
                        AppMethodBeat.o(22508);
                        return;
                    }
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.pgX.setValue(ckC);
                    dVar.pgU.writeCharacteristic(dVar.pgX);
                    dVar.mHandler.postDelayed(dVar.pgZ, 5000);
                    AppMethodBeat.o(22508);
                    return;
                case 8:
                    byte[] bArr2 = (byte[]) message.obj;
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (Util.isNullOrNil(bArr2)) {
                        Log.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        AppMethodBeat.o(22508);
                        return;
                    }
                    String V = b.V(bArr2, bArr2.length);
                    Log.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", Integer.valueOf(bArr2.length));
                    Log.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", V);
                    if (dVar.pgV != null) {
                        dVar.pgV.pgB.b(dVar.mSessionId, bArr2);
                    }
                    AppMethodBeat.o(22508);
                    return;
            }
            AppMethodBeat.o(22508);
        }
    }

    @TargetApi(18)
    public d(long j2, Context context, b bVar) {
        AppMethodBeat.i(22509);
        this.phd = new LinkedList<>();
        this.phe = false;
        this.phg = new BluetoothGattCallback() {
            /* class com.tencent.mm.plugin.d.a.b.d.AnonymousClass1 */

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
                AppMethodBeat.i(22498);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(d.this.phf));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, i3, 0))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 4);
                }
                AppMethodBeat.o(22498);
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
                AppMethodBeat.i(22499);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i2));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, i2, 0, bluetoothGatt))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 5);
                }
                AppMethodBeat.o(22499);
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
                AppMethodBeat.i(22500);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i2));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, i2, 0, bluetoothGatt))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 6);
                }
                AppMethodBeat.o(22500);
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                AppMethodBeat.i(22501);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 8);
                }
                AppMethodBeat.o(22501);
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
                AppMethodBeat.i(22502);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i2));
                AppMethodBeat.o(22502);
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
                AppMethodBeat.i(22503);
                Log.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i2));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, i2, 0))) {
                    Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 7);
                }
                AppMethodBeat.o(22503);
            }
        };
        this.aHK = -1;
        this.aHK = hashCode();
        this.phc = this;
        this.pgV = bVar;
        this.pgT = context;
        this.pfW = ((BluetoothManager) this.pgT.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j2;
        this.phf = 3;
        this.lOM = this.pfW.getRemoteDevice(com.tencent.mm.plugin.d.a.e.a.BC(j2));
        this.pgW = null;
        this.pgX = null;
        this.pgY = new a();
        this.mHandler = new a(com.tencent.f.j.a.bqt("BluetoothLESession_handlerThread"), this);
        this.pgZ = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(22504);
                Log.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (d.this.pgV != null) {
                    d.this.pgV.pgB.m(d.this.mSessionId, false);
                }
                d.this.ckI();
                AppMethodBeat.o(22504);
            }
        };
        this.pha = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(22505);
                Log.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
                if (3 == d.this.phf) {
                    Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    AppMethodBeat.o(22505);
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.phb);
                d.this.phf = 2;
                if (d.this.pgV != null) {
                    d.this.pgV.pgB.l(d.this.mSessionId, false);
                }
                AppMethodBeat.o(22505);
            }
        };
        this.phb = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(22506);
                Log.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
                if (3 == d.this.phf) {
                    Log.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    AppMethodBeat.o(22506);
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.pha);
                d.this.phf = 2;
                if (d.this.pgV != null) {
                    d.this.pgV.pgB.l(d.this.mSessionId, false);
                }
                AppMethodBeat.o(22506);
            }
        };
        AppMethodBeat.o(22509);
    }

    public final boolean connect() {
        AppMethodBeat.i(22510);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
        AppMethodBeat.o(22510);
        return sendMessage;
    }

    public final void close() {
        AppMethodBeat.i(22511);
        Log.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", 2);
        }
        this.mHandler.quitSafely();
        AppMethodBeat.o(22511);
    }

    /* access modifiers changed from: package-private */
    public final void ckH() {
        AppMethodBeat.i(22512);
        this.phe = false;
        this.phd.clear();
        AppMethodBeat.o(22512);
    }

    /* access modifiers changed from: package-private */
    public final void ckI() {
        AppMethodBeat.i(22513);
        if (this.phd.isEmpty()) {
            this.phe = false;
            AppMethodBeat.o(22513);
            return;
        }
        this.pgY.setData(this.phd.pop());
        byte[] ckC = this.pgY.ckC();
        Log.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.bw(ckC));
        this.pgX.setValue(ckC);
        this.mHandler.postDelayed(this.pgZ, 5000);
        if (!this.pgU.writeCharacteristic(this.pgX)) {
            Log.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.phe = true;
        AppMethodBeat.o(22513);
    }
}
