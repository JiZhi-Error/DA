package com.tencent.mm.plugin.d.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.c;
import com.tencent.mm.plugin.d.a.b.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public Context mAppContext;
    public MMHandler mHandler;
    private ReentrantLock mLock;
    public Runnable mRunnable;
    public final HashMap<Long, f> pgC;
    public c pgE;
    public c.a pgH;
    a phj;
    public HashSet<Long> phk;
    final HashMap<Long, Boolean> phl;
    public f.a phm;

    public static abstract class a {
        public void a(long j2, boolean z, long j3) {
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

    public e(a aVar) {
        AppMethodBeat.i(22523);
        this.mAppContext = null;
        this.mLock = new ReentrantLock();
        this.mHandler = null;
        this.mRunnable = null;
        this.pgH = new c.a() {
            /* class com.tencent.mm.plugin.d.a.b.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.d.a.b.c.a
            public final void a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                AppMethodBeat.i(22514);
                long anY = b.anY(bluetoothDevice.getAddress());
                if (!e.this.phk.contains(Long.valueOf(anY))) {
                    Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(anY), b.bw(bArr));
                    e.this.phk.add(Long.valueOf(anY));
                    if (com.tencent.mm.plugin.d.a.b.a.c.aY(bArr)) {
                        e.this.phj.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i2, bArr);
                    }
                }
                AppMethodBeat.o(22514);
            }

            @Override // com.tencent.mm.plugin.d.a.b.c.a
            public final void ckF() {
                AppMethodBeat.i(22515);
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
                if (e.this.phj != null) {
                    e.this.phj.ckF();
                } else {
                    Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
                }
                e.this.phk.clear();
                AppMethodBeat.o(22515);
            }
        };
        this.phk = new HashSet<>();
        this.pgC = new HashMap<>();
        this.phl = new HashMap<>();
        this.phm = new f.a() {
            /* class com.tencent.mm.plugin.d.a.b.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.d.a.b.f.a
            public final void a(final long j2, final boolean z, final long j3) {
                AppMethodBeat.i(22517);
                Object[] objArr = new Object[2];
                objArr[0] = b.Dj(j2);
                objArr[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onConnected. mac = %s, connected = %s", objArr);
                e.this.ai(new Runnable() {
                    /* class com.tencent.mm.plugin.d.a.b.e.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(22516);
                        f fVar = e.this.pgC.get(Long.valueOf(j2));
                        Boolean bool = Boolean.FALSE;
                        boolean z = !z;
                        if (fVar != null || z) {
                            if (e.this.phj != null) {
                                e.this.phj.a(j2, z, j3);
                                if (z) {
                                    Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", b.Dj(j2));
                                }
                            }
                            if (z) {
                                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", b.Dj(j2));
                                e.this.pgC.remove(Long.valueOf(j2));
                                e.this.phl.remove(Long.valueOf(j2));
                                AppMethodBeat.o(22516);
                                return;
                            }
                        } else {
                            Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", b.Dj(j2));
                        }
                        AppMethodBeat.o(22516);
                    }
                });
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", Integer.valueOf(e.this.pgC.size()));
                AppMethodBeat.o(22517);
            }

            @Override // com.tencent.mm.plugin.d.a.b.f.a
            public final void b(long j2, byte[] bArr) {
                AppMethodBeat.i(22518);
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", b.Dj(j2));
                if (e.this.phj != null) {
                    e.this.phj.b(j2, bArr);
                    AppMethodBeat.o(22518);
                    return;
                }
                Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
                AppMethodBeat.o(22518);
            }

            @Override // com.tencent.mm.plugin.d.a.b.f.a
            public final void m(long j2, boolean z) {
                AppMethodBeat.i(22519);
                Object[] objArr = new Object[2];
                objArr[0] = b.Dj(j2);
                objArr[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onSend. mac = %s, success = %s", objArr);
                if (e.this.phj != null) {
                    e.this.phj.m(j2, z);
                }
                AppMethodBeat.o(22519);
            }
        };
        this.mAppContext = MMApplicationContext.getContext();
        this.phj = aVar;
        this.pgE = c.ckG();
        this.mRunnable = new Runnable() {
            /* class com.tencent.mm.plugin.d.a.b.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(22520);
                e.this.pgE.a(false, e.this.pgH);
                Log.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
                AppMethodBeat.o(22520);
            }
        };
        this.mHandler = new MMHandler("BluetoothLESimpleManagerThread");
        AppMethodBeat.o(22523);
    }

    public final void ai(Runnable runnable) {
        AppMethodBeat.i(22524);
        this.mLock.lock();
        runnable.run();
        this.mLock.unlock();
        AppMethodBeat.o(22524);
    }

    @TargetApi(18)
    public final boolean ckE() {
        AppMethodBeat.i(22525);
        boolean hasSystemFeature = this.mAppContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        AppMethodBeat.o(22525);
        return hasSystemFeature;
    }
}
