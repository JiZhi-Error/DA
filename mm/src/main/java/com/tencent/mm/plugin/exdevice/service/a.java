package com.tencent.mm.plugin.exdevice.service;

import android.os.Message;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class a implements r {
    private static a rCZ = null;
    private Object duI = new Object();
    MMHandler mHandler = new C0986a(v.cLz().jkv.getSerialTag());
    private final HashMap<Long, Long> rDa = new HashMap<>();
    private g rDb = null;

    /* access modifiers changed from: package-private */
    public static final class e {
        String lAr = null;
        long rDg = 0;
        int rxH = 0;
        int rxv = 0;
    }

    static /* synthetic */ int a(a aVar, long j2, p pVar) {
        AppMethodBeat.i(23603);
        int a2 = aVar.a(j2, pVar);
        AppMethodBeat.o(23603);
        return a2;
    }

    static /* synthetic */ boolean b(a aVar, long j2) {
        AppMethodBeat.i(23606);
        boolean CT = aVar.CT(j2);
        AppMethodBeat.o(23606);
        return CT;
    }

    static final class d {
        long pkb;
        int rDe;
        int rDf;
        int rxv;

        private d() {
            this.pkb = 0;
            this.rDe = 0;
            this.rDf = 0;
            this.rxv = 0;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class b {
        long pkb;
        short rDd;
        short rxC;
        byte[] rxw;

        private b() {
            this.pkb = 0;
            this.rxC = 0;
            this.rDd = 0;
            this.rxw = null;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static final class c {
        int lOO;
        String mDeviceName;
        String pkf;
        byte[] pkg;

        public c(String str, String str2, int i2, byte[] bArr) {
            this.pkf = str;
            this.mDeviceName = str2;
            this.lOO = i2;
            this.pkg = bArr;
        }
    }

    static final class f {
        byte[] mData;
        long pkb;

        public f(long j2, byte[] bArr) {
            this.pkb = j2;
            this.mData = bArr;
        }
    }

    static final class g {
        long rDg;
        p rDh;

        public g(long j2, p pVar) {
            this.rDg = j2;
            this.rDh = pVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.service.a$a  reason: collision with other inner class name */
    final class C0986a extends MMHandler {
        public C0986a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(23589);
            switch (message.what) {
                case 1:
                    c cVar = (c) message.obj;
                    a.this.rDb.a(1, 0, null, cVar.pkf, cVar.mDeviceName, cVar.lOO, cVar.pkg);
                    AppMethodBeat.o(23589);
                    return;
                case 2:
                    a.this.rDb.a(2, 0, null, null, null, 0, null);
                    AppMethodBeat.o(23589);
                    return;
                case 3:
                    e eVar = (e) message.obj;
                    a.this.rDb.c(eVar.rDg, eVar.rxH, eVar.rxv, eVar.lAr);
                    AppMethodBeat.o(23589);
                    return;
                case 4:
                    d dVar = (d) message.obj;
                    a.this.rDb.a(dVar.pkb, dVar.rDe, dVar.rDf, dVar.rxv);
                    AppMethodBeat.o(23589);
                    return;
                case 5:
                    b bVar = (b) message.obj;
                    a.this.rDb.a(message.arg1, bVar.pkb, bVar.rxC, bVar.rDd, bVar.rxw);
                    AppMethodBeat.o(23589);
                    return;
                case 6:
                    AppMethodBeat.o(23589);
                    return;
                case 7:
                    AppMethodBeat.o(23589);
                    return;
                case 8:
                    g gVar = (g) message.obj;
                    a.a(a.this, gVar.rDg, gVar.rDh);
                    AppMethodBeat.o(23589);
                    return;
                case 9:
                    a.CV(((Long) message.obj).longValue());
                    AppMethodBeat.o(23589);
                    return;
                case 10:
                    f fVar = (f) message.obj;
                    a.a(a.this, fVar.pkb, fVar.mData);
                    AppMethodBeat.o(23589);
                    return;
                case 11:
                    synchronized (a.this.duI) {
                        try {
                            a.a(a.this, ((Long) message.obj).longValue());
                        } finally {
                            AppMethodBeat.o(23589);
                        }
                    }
                    return;
                case 12:
                    synchronized (a.this.duI) {
                        try {
                            a.b(a.this, ((Long) message.obj).longValue());
                        } finally {
                            AppMethodBeat.o(23589);
                        }
                    }
                    return;
                default:
                    AppMethodBeat.o(23589);
                    return;
            }
        }
    }

    public a(g gVar) {
        AppMethodBeat.i(23590);
        this.rDb = gVar;
        rCZ = this;
        AppMethodBeat.o(23590);
    }

    public static boolean Gz(int i2) {
        AppMethodBeat.i(23591);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
        if (!b.Gz(i2)) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
            AppMethodBeat.o(23591);
            return false;
        }
        AppMethodBeat.o(23591);
        return true;
    }

    public static long[] cLa() {
        AppMethodBeat.i(23592);
        long[] anH = com.tencent.mm.plugin.exdevice.i.a.anH("conneted_device");
        AppMethodBeat.o(23592);
        return anH;
    }

    private boolean CT(long j2) {
        AppMethodBeat.i(23593);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(j2)));
        Log.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", Long.valueOf(j2));
        if (!com.tencent.mm.plugin.exdevice.i.a.ae("conneted_device", j2)) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
        }
        if (!this.rDa.containsKey(Long.valueOf(j2))) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
            AppMethodBeat.o(23593);
            return false;
        }
        Java2CExDevice.stopChannelService(this.rDa.get(Long.valueOf(j2)).longValue());
        Java2CExDevice.destroyChannel(this.rDa.get(Long.valueOf(j2)).longValue());
        AppMethodBeat.o(23593);
        return true;
    }

    private int a(long j2, p pVar) {
        AppMethodBeat.i(23594);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "startTaskImp, taskId = %d", Long.valueOf(j2));
        Assert.assertNotNull(pVar);
        try {
            long cLk = pVar.cLq().cLk();
            if (!com.tencent.mm.plugin.exdevice.i.a.ac("conneted_device", cLk)) {
                Log.w("MicroMsg.exdevice.BTDeviceManager", "Cannot startTask because this channel is close aready!!!");
                e eVar = new e();
                eVar.rDg = j2;
                eVar.rxv = -1;
                eVar.rxH = -1;
                eVar.lAr = "Channel is close aready!!!";
                Assert.assertTrue(rCZ.mHandler.sendMessage(rCZ.mHandler.obtainMessage(3, 0, 0, eVar)));
                AppMethodBeat.o(23594);
                return -1;
            } else if (!this.rDa.containsKey(Long.valueOf(cLk))) {
                Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find Channel by DeviceInfo(%s) in mMapDeviceChannelId", Long.valueOf(cLk));
                this.rDb.c(j2, -1, -1, "Cannot find Channel by DeviceInfo!!!");
                AppMethodBeat.o(23594);
                return -1;
            } else {
                Java2CExDevice.AccessoryCmd accessoryCmd = new Java2CExDevice.AccessoryCmd();
                accessoryCmd.channelID = this.rDa.get(Long.valueOf(cLk)).longValue();
                try {
                    accessoryCmd.reqCmdID = pVar.cLq().cLm();
                    accessoryCmd.respCmdID = pVar.cLq().cLn();
                    try {
                        byte[] cLl = pVar.cLq().cLl();
                        int cLo = pVar.cLq().cLo();
                        if (Java2CExDevice.startTask(j2, (short) cLo, accessoryCmd, cLl) != 0) {
                            Log.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startTask Failed!!!");
                            AppMethodBeat.o(23594);
                            return -1;
                        }
                        Log.i("MicroMsg.exdevice.BTDeviceManager", "------let task go------ taskId = %d, deviceId = %d, channelId = %d, seq = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j2), Long.valueOf(cLk), Long.valueOf(accessoryCmd.channelID), Integer.valueOf(cLo), Integer.valueOf(accessoryCmd.reqCmdID), Integer.valueOf(accessoryCmd.respCmdID));
                        AppMethodBeat.o(23594);
                        return 0;
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDataOut failed!!! %s", e2.getMessage());
                        Log.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e2, "", new Object[0]);
                        this.rDb.c(j2, -1, -1, "Remote getDataOut failed!!!!!!");
                        AppMethodBeat.o(23594);
                        return -1;
                    }
                } catch (RemoteException e3) {
                    Log.e("MicroMsg.exdevice.BTDeviceManager", "Remote getResquestCmdId or getResponseCmdId failed!!! %s", e3.getMessage());
                    Log.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e3, "", new Object[0]);
                    this.rDb.c(j2, -1, -1, "Remote getResquestCmdId or getResponseCmdId failed!!!");
                    AppMethodBeat.o(23594);
                    return -1;
                }
            }
        } catch (RemoteException e4) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Remote getDeviceId failed!!! %s", e4.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.BTDeviceManager", e4, "", new Object[0]);
            this.rDb.c(j2, -1, -1, "Remote getDeviceId failed!!!");
            AppMethodBeat.o(23594);
            return -1;
        }
    }

    public static void c(long j2, int i2, int i3, String str) {
        AppMethodBeat.i(23595);
        Assert.assertNotNull(rCZ);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + j2 + " errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        e eVar = new e();
        eVar.rDg = j2;
        eVar.rxv = i3;
        eVar.rxH = i2;
        eVar.lAr = str;
        Assert.assertTrue(rCZ.mHandler.sendMessage(rCZ.mHandler.obtainMessage(3, 0, 0, eVar)));
        AppMethodBeat.o(23595);
    }

    public static void a(long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(23596);
        Assert.assertNotNull(rCZ);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + j2 + " oldState = " + i2 + " newState = " + i3 + " errCode = " + i4);
        long CU = rCZ.CU(j2);
        if (-1 == CU) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.o(23596);
            return;
        }
        d dVar = new d((byte) 0);
        dVar.pkb = CU;
        dVar.rxv = i4;
        dVar.rDf = i3;
        dVar.rDe = i2;
        Assert.assertTrue(rCZ.mHandler.sendMessage(rCZ.mHandler.obtainMessage(4, 0, 0, dVar)));
        AppMethodBeat.o(23596);
    }

    private long CU(long j2) {
        AppMethodBeat.i(23597);
        if (!this.rDa.containsValue(Long.valueOf(j2))) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceInfo by channelId");
            AppMethodBeat.o(23597);
            return -1;
        }
        for (Map.Entry<Long, Long> entry : this.rDa.entrySet()) {
            if (j2 == entry.getValue().longValue()) {
                long longValue = entry.getKey().longValue();
                AppMethodBeat.o(23597);
                return longValue;
            }
        }
        Assert.assertTrue(false);
        AppMethodBeat.o(23597);
        return -1;
    }

    public static void onDeviceRequest(long j2, short s, short s2, byte[] bArr, int i2) {
        AppMethodBeat.i(23598);
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j2);
        objArr[1] = Short.valueOf(s);
        objArr[2] = Short.valueOf(s2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[4] = Integer.valueOf(i2);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d", objArr);
        Assert.assertNotNull(rCZ);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + j2 + " seq = " + ((int) s) + "cmdId = " + ((int) s2) + "errCode = " + i2);
        long CU = rCZ.CU(j2);
        if (-1 == CU) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
            AppMethodBeat.o(23598);
            return;
        }
        b bVar = new b((byte) 0);
        bVar.pkb = CU;
        bVar.rxw = bArr;
        bVar.rDd = s2;
        bVar.rxC = s;
        Assert.assertTrue(rCZ.mHandler.sendMessage(rCZ.mHandler.obtainMessage(5, i2, 0, bVar)));
        AppMethodBeat.o(23598);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void CK(int i2) {
        AppMethodBeat.i(23599);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(i2)));
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
        AppMethodBeat.o(23599);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void a(String str, String str2, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(23600);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        Log.d("MicroMsg.exdevice.BTDeviceManager", "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d", objArr);
        Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, new c(str, str2, i3, bArr))));
        AppMethodBeat.o(23600);
    }

    @Override // com.tencent.mm.plugin.exdevice.service.r
    public final void ahk(String str) {
        AppMethodBeat.i(23601);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", -1, -1);
        if (!this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.service.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(23588);
                a.this.rDb.a(0, -1, "", "", "", 0, null);
                AppMethodBeat.o(23588);
            }
        })) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
        }
        AppMethodBeat.o(23601);
    }

    static /* synthetic */ void a(a aVar, long j2, byte[] bArr) {
        AppMethodBeat.i(23602);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKeyImp------ deviceId = %d", Long.valueOf(j2));
        if (!aVar.rDa.containsKey(Long.valueOf(j2))) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
            AppMethodBeat.o(23602);
            return;
        }
        Java2CExDevice.setChannelSessionKey(aVar.rDa.get(Long.valueOf(j2)).longValue(), bArr);
        AppMethodBeat.o(23602);
    }

    static /* synthetic */ void CV(long j2) {
        AppMethodBeat.i(23604);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "stopTaskImp taskId = %d", Long.valueOf(j2));
        Java2CExDevice.stopTask(j2);
        AppMethodBeat.o(23604);
    }

    static /* synthetic */ boolean a(a aVar, long j2) {
        AppMethodBeat.i(23605);
        Log.i("MicroMsg.exdevice.BTDeviceManager", "startChannelImp deviceId = %d", Long.valueOf(j2));
        if (com.tencent.mm.plugin.exdevice.i.a.ac("conneted_device", j2)) {
            Log.w("MicroMsg.exdevice.BTDeviceManager", "This deviceId is not call stop channel before startChannel, Call it");
            aVar.CT(j2);
        }
        Java2CExDevice.LongWrapper longWrapper = new Java2CExDevice.LongWrapper();
        longWrapper.value = -1;
        int createChannel = Java2CExDevice.createChannel(j2, longWrapper);
        if (createChannel != 0) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.createChannel Failed, ret = ".concat(String.valueOf(createChannel)));
            aVar.rDb.a(j2, 1, 4, -1);
            AppMethodBeat.o(23605);
            return false;
        }
        Log.i("MicroMsg.exdevice.BTDeviceManager", "Create channel id is ok, deviceId = %d, channelId = %d", Long.valueOf(j2), Long.valueOf(longWrapper.value));
        aVar.rDa.put(Long.valueOf(j2), Long.valueOf(longWrapper.value));
        Log.i("MicroMsg.exdevice.BTDeviceManager", "add the device to connected devices : [%d]", Long.valueOf(j2));
        if (!com.tencent.mm.plugin.exdevice.i.a.ad("conneted_device", j2)) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "addToSharedPreferences failed!!!");
            aVar.rDb.a(j2, 1, 4, -1);
            AppMethodBeat.o(23605);
            return false;
        }
        int startChannelService = Java2CExDevice.startChannelService(longWrapper.value);
        if (startChannelService != 0) {
            Log.e("MicroMsg.exdevice.BTDeviceManager", "Java2CExDevice.startChannelService Failed, ret = ".concat(String.valueOf(startChannelService)));
            aVar.rDb.a(j2, 1, 4, -1);
            AppMethodBeat.o(23605);
            return false;
        }
        AppMethodBeat.o(23605);
        return true;
    }
}
