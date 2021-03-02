package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b implements e {
    public final Handler aDv = new Handler(Looper.getMainLooper());
    public volatile Queue<a> lMu;
    private volatile a lMv;
    public volatile List<a> lMw;

    public b() {
        AppMethodBeat.i(144544);
        AppMethodBeat.o(144544);
    }

    public final synchronized void init() {
        AppMethodBeat.i(215147);
        this.lMu = new ConcurrentLinkedQueue();
        this.lMw = new ArrayList();
        AppMethodBeat.o(215147);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(183543);
        Queue<a> queue = this.lMu;
        if (queue != null) {
            queue.clear();
            this.lMu = null;
        }
        List<a> list = this.lMw;
        if (list != null) {
            list.clear();
            this.lMw = null;
        }
        AppMethodBeat.o(183543);
    }

    public final synchronized void bFo() {
        AppMethodBeat.i(144545);
        a aVar = this.lMv;
        if (aVar == null || aVar.brr) {
            Queue<a> queue = this.lMu;
            if (queue != null && queue.size() > 0) {
                final a poll = queue.poll();
                if (poll == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
                    AppMethodBeat.o(144545);
                } else {
                    this.lMv = poll;
                    if (poll.lMh) {
                        this.aDv.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(144543);
                                poll.doAction();
                                AppMethodBeat.o(144543);
                            }
                        }, poll.lNg);
                        AppMethodBeat.o(144545);
                    } else {
                        poll.doAction();
                    }
                }
            }
            AppMethodBeat.o(144545);
        } else {
            AppMethodBeat.o(144545);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144546);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onConnectionStateChange(bluetoothGatt, i2, i3);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onConnectionStateChange(bluetoothGatt, i2, i3);
                }
            }
        }
        AppMethodBeat.o(144546);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144547);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onServicesDiscovered(bluetoothGatt, i2);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onServicesDiscovered(bluetoothGatt, i2);
                }
            }
        }
        AppMethodBeat.o(144547);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144548);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i2);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onServicesDiscovered(bluetoothGatt, i2);
                }
            }
        }
        AppMethodBeat.o(144548);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
        AppMethodBeat.i(144549);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i2);
                }
            }
        }
        AppMethodBeat.o(144549);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        AppMethodBeat.i(144550);
        a aVar = this.lMv;
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                boolean z = aVar2.brr;
            }
        }
        AppMethodBeat.o(144550);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144551);
        a aVar = this.lMv;
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                boolean z = aVar2.brr;
            }
        }
        AppMethodBeat.o(144551);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i2) {
        AppMethodBeat.i(144552);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i2);
                }
            }
        }
        AppMethodBeat.o(144552);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i2) {
        AppMethodBeat.i(144553);
        a aVar = this.lMv;
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                boolean z = aVar2.brr;
            }
        }
        AppMethodBeat.o(144553);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144554);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onReadRemoteRssi(bluetoothGatt, i2, i3);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onServicesDiscovered(bluetoothGatt, i3);
                }
            }
        }
        AppMethodBeat.o(144554);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.e
    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i2, int i3) {
        AppMethodBeat.i(144555);
        a aVar = this.lMv;
        if (aVar != null) {
            aVar.onMtuChanged(bluetoothGatt, i2, i3);
        }
        List<a> list = this.lMw;
        if (list != null) {
            for (a aVar2 : list) {
                if (!aVar2.brr) {
                    aVar2.onMtuChanged(bluetoothGatt, i2, i3);
                }
            }
        }
        AppMethodBeat.o(144555);
    }
}
