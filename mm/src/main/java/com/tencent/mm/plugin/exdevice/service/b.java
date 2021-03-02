package com.tencent.mm.plugin.exdevice.service;

import android.os.Build;
import android.os.Looper;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.d;
import com.tencent.mm.plugin.d.a.c.a;
import com.tencent.mm.plugin.d.a.c.c;
import com.tencent.mm.plugin.d.a.d.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

public final class b implements c {
    private static b rDm = null;
    private MMHandler mHandler = new MMHandler(v.cLz().jkv.getSerialTag());
    private com.tencent.mm.plugin.d.a.d.b rDi = null;
    private final Vector<r> rDj = new Vector<>();
    private final HashMap<Long, Integer> rDk = new HashMap<>();
    private final HashMap<Long, Integer> rDl = new HashMap<>();
    private CountDownLatch rDn;

    public b() {
        AppMethodBeat.i(23614);
        long id = Thread.currentThread().getId();
        long id2 = Looper.getMainLooper().getThread().getId();
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now thread id : %d, main thread is : %d", Long.valueOf(id), Long.valueOf(id2));
        if (Build.VERSION.SDK_INT != 14 && Build.VERSION.SDK_INT != 15) {
            this.rDi = new com.tencent.mm.plugin.d.a.d.b(MMApplicationContext.getContext(), this, v.cLz().jkv);
            AppMethodBeat.o(23614);
        } else if (id == id2) {
            Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "it is main thread now, init the bluetoothadapter directly");
            this.rDi = new com.tencent.mm.plugin.d.a.d.b(MMApplicationContext.getContext(), this, v.cLz().jkv);
            AppMethodBeat.o(23614);
        } else {
            new MMHandler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(23607);
                    b.this.rDi = new com.tencent.mm.plugin.d.a.d.b(MMApplicationContext.getContext(), b.this, v.cLz().jkv);
                    Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
                    b.this.rDn.countDown();
                    AppMethodBeat.o(23607);
                }
            });
            this.rDn = new CountDownLatch(1);
            try {
                this.rDn.await();
            } catch (InterruptedException e2) {
            }
            Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now has init the sdk adapter");
            AppMethodBeat.o(23614);
        }
    }

    private static b cLb() {
        AppMethodBeat.i(23615);
        if (rDm != null) {
            b bVar = rDm;
            AppMethodBeat.o(23615);
            return bVar;
        }
        b bVar2 = new b();
        rDm = bVar2;
        AppMethodBeat.o(23615);
        return bVar2;
    }

    public static boolean a(final int i2, final r rVar, final int... iArr) {
        AppMethodBeat.i(23616);
        b cLb = cLb();
        boolean post = cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass2 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23608);
                if (!b.a(this.rDp, i2, rVar, iArr)) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
                }
                AppMethodBeat.o(23608);
            }
        });
        if (!post) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "scan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23616);
        return post;
    }

    public static boolean Gz(final int i2) {
        AppMethodBeat.i(23617);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---stopScan--- aBluetoothVersion = %d", Integer.valueOf(i2));
        b cLb = cLb();
        boolean post = cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass3 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23609);
                if (!b.a(this.rDp, i2)) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
                }
                AppMethodBeat.o(23609);
            }
        });
        if (!post) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "stopScan: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23617);
        return post;
    }

    public static void createSession(final long j2, final long j3) {
        AppMethodBeat.i(23618);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---createSession--- aDeviceId = %d, aChannelId = %d", Long.valueOf(j2), Long.valueOf(j3));
        b cLb = cLb();
        if (!cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass4 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23610);
                b.a(this.rDp, j2, j3);
                AppMethodBeat.o(23610);
            }
        })) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "createSession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23618);
    }

    public static boolean sendData(final long j2, final byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(23619);
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j2);
        if (bArr != null) {
            i2 = bArr.length;
        }
        objArr[1] = Integer.valueOf(i2);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "----sendData---- aSessionId = %d, datalength = %d", objArr);
        Assert.assertNotNull(bArr);
        b cLb = cLb();
        boolean post = cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass5 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23611);
                if (!b.a(this.rDp, j2, bArr)) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
                }
                AppMethodBeat.o(23611);
            }
        });
        if (!post) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "sendData: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23619);
        return post;
    }

    public static boolean connect(final long j2) {
        AppMethodBeat.i(23620);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---connect--- aSessionId = %d", Long.valueOf(j2));
        b cLb = cLb();
        boolean post = cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass6 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23612);
                if (!b.a(this.rDp, j2)) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
                }
                AppMethodBeat.o(23612);
            }
        });
        if (!post) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "connect: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23620);
        return post;
    }

    public static void destroySession(final long j2) {
        AppMethodBeat.i(23621);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---destroySession--- aSessionId = %d", Long.valueOf(j2));
        b cLb = cLb();
        if (!cLb.mHandler.post(new Runnable(cLb) {
            /* class com.tencent.mm.plugin.exdevice.service.b.AnonymousClass7 */
            final /* synthetic */ b rDp;

            {
                this.rDp = r1;
            }

            public final void run() {
                AppMethodBeat.i(23613);
                b.b(this.rDp, j2);
                AppMethodBeat.o(23613);
            }
        })) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "destroySession: instance.mHandler.post failed!!!");
        }
        AppMethodBeat.o(23621);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void i(long j2, long j3, long j4) {
        AppMethodBeat.i(23622);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSessionCreate--- aSessionId = " + j2 + " aDeviceID = " + j3);
        Assert.assertTrue(this.rDk.containsKey(Long.valueOf(j3)));
        if (!this.rDl.containsKey(Long.valueOf(j2))) {
            this.rDl.put(Long.valueOf(j2), this.rDk.get(Long.valueOf(j3)));
        }
        Java2CExDevice.onBluetoothSessionCreated(j3, j4, j2);
        AppMethodBeat.o(23622);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void CK(int i2) {
        AppMethodBeat.i(23623);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFinished--- aBluetoothVersion =%d", Integer.valueOf(i2));
        if (this.rDj.isEmpty()) {
            Log.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.o(23623);
            return;
        }
        Iterator<r> it = this.rDj.iterator();
        while (it.hasNext()) {
            r next = it.next();
            if (next != null) {
                next.CK(i2);
            }
        }
        this.rDj.clear();
        AppMethodBeat.o(23623);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void a(String str, String str2, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(23624);
        Object[] objArr = new Object[5];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        Log.d("MicroMsg.exdevice.BluetoothSDKAdapter", "---onScanFound--- deviceMac = %s, deviceName = %s, BTversion = %d, rssi = %d, advertisment length = %d", objArr);
        if (this.rDj.isEmpty()) {
            Log.w("MicroMsg.exdevice.BluetoothSDKAdapter", "mScanCallbackList is empty");
            AppMethodBeat.o(23624);
            return;
        }
        Iterator<r> it = this.rDj.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, i2, i3, bArr);
        }
        AppMethodBeat.o(23624);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void l(long j2, boolean z) {
        AppMethodBeat.i(23625);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onConnected--- sessionId = " + j2 + "Connected = " + z);
        if (z) {
            Java2CExDevice.onBluetoothConnected(j2);
            AppMethodBeat.o(23625);
            return;
        }
        Java2CExDevice.onBluetoothDisconnected(j2);
        AppMethodBeat.o(23625);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void b(long j2, byte[] bArr) {
        AppMethodBeat.i(23626);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onRecv--- sessionId = ".concat(String.valueOf(j2)));
        Java2CExDevice.onBluetoothRecvData(j2, bArr);
        AppMethodBeat.o(23626);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void m(long j2, boolean z) {
        AppMethodBeat.i(23627);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "---onSend--- sessionId = " + j2 + "success = " + z);
        if (z) {
            Java2CExDevice.onBluetoothSendDataCompleted(j2);
            AppMethodBeat.o(23627);
            return;
        }
        Java2CExDevice.onBluetoothError(j2, 0);
        AppMethodBeat.o(23627);
    }

    @Override // com.tencent.mm.plugin.d.a.d.c
    public final void BB(long j2) {
        AppMethodBeat.i(23628);
        Java2CExDevice.onBluetoothError(j2, 0);
        AppMethodBeat.o(23628);
    }

    static /* synthetic */ boolean a(b bVar, int i2, r rVar, int[] iArr) {
        boolean d2;
        AppMethodBeat.i(23629);
        if (rVar == null) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "Error parameter: null == aCallback");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
            AppMethodBeat.o(23629);
            throw illegalArgumentException;
        }
        if (iArr == null) {
            d2 = bVar.rDi.d(i2, new int[0]);
        } else {
            d2 = bVar.rDi.d(i2, iArr);
        }
        if (!d2) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.scan failed!!!");
            if (rVar != null) {
                rVar.ahk("scanImp: mBTSDKMrg.scan failed!!!");
            }
            AppMethodBeat.o(23629);
            return false;
        }
        bVar.rDj.add(rVar);
        AppMethodBeat.o(23629);
        return true;
    }

    static /* synthetic */ boolean a(b bVar, int i2) {
        boolean a2;
        AppMethodBeat.i(23630);
        com.tencent.mm.plugin.d.a.d.b bVar2 = bVar.rDi;
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***stopScan*** aBluetoothVersion = ".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                if (bVar2.pjW != null) {
                    a2 = bVar2.pjW.a(false, new int[0]);
                    break;
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    a2 = false;
                    break;
                }
            case 1:
                if (bVar2.pjX != null) {
                    a2 = bVar2.pjX.kg(false);
                    break;
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    a2 = false;
                    break;
                }
            default:
                Assert.assertTrue(false);
                a2 = false;
                break;
        }
        if (!a2) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.stopScan failed!!!");
            AppMethodBeat.o(23630);
            return false;
        }
        AppMethodBeat.o(23630);
        return true;
    }

    static /* synthetic */ void a(b bVar, long j2, long j3) {
        int intValue;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(23631);
        if (bVar.rDk.containsKey(Long.valueOf(j2))) {
            bVar.rDi.e(j2, j3, bVar.rDk.get(Long.valueOf(j2)).intValue());
            AppMethodBeat.o(23631);
            return;
        }
        v cLz = v.cLz();
        if (!cLz.rDW.containsKey(Long.valueOf(j2))) {
            Log.e("MicroMsg.exdevice.MMExDevicePushCore", "getBluetoothVersionByDeviceId Failed!!! Cannot find BLuetoothVersion by DeviceInfo(%d)", Long.valueOf(j2));
            intValue = -1;
        } else {
            intValue = cLz.rDW.get(Long.valueOf(j2)).intValue();
        }
        if (-1 != intValue) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String Dj = com.tencent.mm.plugin.exdevice.k.b.Dj(j2);
        Log.i("MicroMsg.exdevice.BluetoothSDKAdapter", "insertDeviceIdTypeMap deviceid = %s, BTVersion = %d", Dj, Integer.valueOf(intValue));
        Assert.assertNotNull(Dj);
        if (1 == intValue || intValue == 0) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        long anY = com.tencent.mm.plugin.exdevice.k.b.anY(Dj);
        if (!bVar.rDk.containsKey(Long.valueOf(anY))) {
            bVar.rDk.put(Long.valueOf(anY), Integer.valueOf(intValue));
        }
        bVar.rDi.e(j2, j3, intValue);
        AppMethodBeat.o(23631);
    }

    static /* synthetic */ boolean a(b bVar, long j2, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(23632);
        Assert.assertTrue(bVar.rDl.containsKey(Long.valueOf(j2)));
        com.tencent.mm.plugin.d.a.d.b bVar2 = bVar.rDi;
        int intValue = bVar.rDl.get(Long.valueOf(j2)).intValue();
        Assert.assertNotNull(bArr);
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***SendData*** sessionId = " + j2 + "bluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.pjW != null) {
                    com.tencent.mm.plugin.d.a.b.b bVar3 = bVar2.pjW;
                    Log.i("MicroMsg.exdevice.BluetoothLEManager", "------writeData------ sessionId = %d, data length = %d", Long.valueOf(j2), Integer.valueOf(bArr.length));
                    Assert.assertTrue(bVar3.mIsInit);
                    if (bVar3.ckE()) {
                        d dVar = bVar3.pgC.get(String.valueOf(j2));
                        if (dVar != null) {
                            Log.i("MicroMsg.exdevice.BluetoothLESession", "------writeData------length = %d", Integer.valueOf(bArr.length));
                            Log.d("MicroMsg.exdevice.BluetoothLESession", "writeData data dump = %s", com.tencent.mm.plugin.exdevice.k.b.bw(bArr));
                            z = dVar.mHandler.sendMessage(dVar.mHandler.obtainMessage(3, bArr));
                            break;
                        } else {
                            Log.w("MicroMsg.exdevice.BluetoothLEManager", "session is null, may be this session is closed");
                            z = false;
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                        z = false;
                        break;
                    }
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    z = false;
                    break;
                }
            case 1:
                if (bVar2.pjX != null) {
                    a aVar = bVar2.pjX;
                    Log.i("MicroMsg.exdevice.BluetoothChatManager", "writeData to: ".concat(String.valueOf(j2)));
                    Assert.assertTrue(aVar.mIsInit);
                    if (aVar.ckN()) {
                        com.tencent.mm.plugin.d.a.c.b bVar4 = aVar.pgC.get(Long.valueOf(j2));
                        if (bVar4 == null) {
                            z2 = false;
                        }
                        Assert.assertTrue(z2);
                        Log.i("MicroMsg.exdevice.BluetoothChatSession", "write");
                        if (bVar4.pjG == null) {
                            z = false;
                            break;
                        } else {
                            z = bVar4.pjG.aZ(bArr);
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z = false;
                        break;
                    }
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    z = false;
                    break;
                }
            default:
                Assert.assertTrue(false);
                z = false;
                break;
        }
        if (!z) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.sendData failed!!!");
            bVar.m(j2, false);
        }
        AppMethodBeat.o(23632);
        return z;
    }

    static /* synthetic */ boolean a(b bVar, long j2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(23633);
        Assert.assertTrue(bVar.rDl.containsKey(Long.valueOf(j2)));
        com.tencent.mm.plugin.d.a.d.b bVar2 = bVar.rDi;
        int intValue = bVar.rDl.get(Long.valueOf(j2)).intValue();
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***connect*** aSessionId = " + j2 + " aBluetoothVersion = " + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.pjW != null) {
                    z2 = bVar2.pjW.connect(j2);
                    break;
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    z2 = false;
                    break;
                }
            case 1:
                if (bVar2.pjX != null) {
                    a aVar = bVar2.pjX;
                    Log.i("MicroMsg.exdevice.BluetoothChatManager", "connect, session id = %d, secure = %s", Long.valueOf(j2), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    Assert.assertTrue(aVar.mIsInit);
                    if (aVar.ckN()) {
                        com.tencent.mm.plugin.d.a.c.b bVar3 = aVar.pgC.get(Long.valueOf(j2));
                        if (bVar3 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        Log.i("MicroMsg.exdevice.BluetoothChatSession", "connect");
                        if (bVar3.lOM != null) {
                            bVar3.mState = 2;
                            if (bVar3.pjE != null) {
                                bVar3.pjE.disconnect();
                                bVar3.pjE = null;
                            }
                            bVar3.pjE = new c.a(bVar3, aVar, bVar3.lOM);
                            c.a aVar2 = bVar3.pjE;
                            Log.i("MicroMsg.exdevice.ConnectThread", "------connect------");
                            if (!aVar2.mHandler.sendMessage(aVar2.mHandler.obtainMessage(0))) {
                                Log.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", 0);
                                if (aVar2.pjK != null) {
                                    aVar2.pjK.pjA.l(aVar2.pjJ.mSessionId, false);
                                    break;
                                }
                            }
                        } else {
                            Log.e("MicroMsg.exdevice.BluetoothChatSession", "Can not found remote device(" + com.tencent.mm.plugin.d.a.e.a.BC(bVar3.pjD) + ")");
                            aVar.pjA.c(bVar3.mSessionId, 7, "Device not found");
                            z2 = false;
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                        z2 = false;
                        break;
                    }
                } else {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    z2 = false;
                    break;
                }
                break;
            default:
                Assert.assertTrue(false);
                z2 = false;
                break;
        }
        if (!z2) {
            Log.e("MicroMsg.exdevice.BluetoothSDKAdapter", "mBTSDKMrg.connect failed!!!");
            bVar.l(j2, false);
        }
        AppMethodBeat.o(23633);
        return z2;
    }

    static /* synthetic */ void b(b bVar, long j2) {
        boolean z = true;
        AppMethodBeat.i(23634);
        if (!bVar.rDk.containsKey(Long.valueOf(j2))) {
            Log.w("MicroMsg.exdevice.BluetoothSDKAdapter", "the session not exist");
            AppMethodBeat.o(23634);
            return;
        }
        com.tencent.mm.plugin.d.a.d.b bVar2 = bVar.rDi;
        int intValue = bVar.rDl.get(Long.valueOf(j2)).intValue();
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***Destroy Session*** aSessionId = " + j2 + " aBluetoothVersion" + intValue);
        switch (intValue) {
            case 0:
                if (bVar2.pjW == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.o(23634);
                    return;
                }
                com.tencent.mm.plugin.d.a.b.b bVar3 = bVar2.pjW;
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "------destroySession------ sessionId = %d", Long.valueOf(j2));
                Assert.assertTrue(bVar3.mIsInit);
                if (!bVar3.ckE()) {
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    AppMethodBeat.o(23634);
                    return;
                }
                d remove = bVar3.pgC.remove(String.valueOf(j2));
                if (remove == null) {
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot find BluetoothLESession by sessionId(%d)", Long.valueOf(j2));
                    AppMethodBeat.o(23634);
                    return;
                }
                remove.close();
                AppMethodBeat.o(23634);
                return;
            case 1:
                if (bVar2.pjX == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.o(23634);
                    return;
                }
                a aVar = bVar2.pjX;
                Log.i("MicroMsg.exdevice.BluetoothChatManager", "------destroySession------ sessionId = %d", Long.valueOf(j2));
                Assert.assertTrue(aVar.mIsInit);
                if (!aVar.ckN()) {
                    Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    AppMethodBeat.o(23634);
                    return;
                }
                com.tencent.mm.plugin.d.a.c.b remove2 = aVar.pgC.remove(Long.valueOf(j2));
                if (remove2 == null) {
                    z = false;
                }
                Assert.assertTrue(z);
                remove2.disconnect();
                AppMethodBeat.o(23634);
                return;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.o(23634);
                return;
        }
    }
}
