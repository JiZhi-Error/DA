package com.tencent.mm.plugin.exdevice.c;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.j.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import junit.framework.Assert;

public final class k implements i {
    public static k rxE = null;
    public MMHandler mHandler;
    private final HashMap<Long, e> rxD;
    public HashMap<String, Integer> rxF;

    /* access modifiers changed from: package-private */
    public static final class e {
        f rxK;
        private d rxL;
        int rxM;

        private e() {
            this.rxK = null;
            this.rxL = null;
            this.rxM = 0;
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final void a(f fVar) {
            AppMethodBeat.i(23165);
            Assert.assertNotNull(fVar);
            this.rxK = fVar;
            AppMethodBeat.o(23165);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(23166);
            Assert.assertNotNull(dVar);
            this.rxL = dVar;
            AppMethodBeat.o(23166);
        }

        public final f cKm() {
            AppMethodBeat.i(23167);
            Assert.assertNotNull(this.rxK);
            f fVar = this.rxK;
            AppMethodBeat.o(23167);
            return fVar;
        }

        public final d cKn() {
            AppMethodBeat.i(23168);
            Assert.assertNotNull(this.rxL);
            d dVar = this.rxL;
            AppMethodBeat.o(23168);
            return dVar;
        }
    }

    static final class b {
        public String lAr;
        public int rxH;
        public q rxI;
        public int rxv;

        private b() {
            this.rxv = 0;
            this.rxH = 0;
            this.lAr = null;
            this.rxI = null;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final class c {
        public byte[] mData;
        public long mSessionId;

        private c() {
            this.mSessionId = 0;
            this.mData = null;
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final class d implements Runnable {
        private long rxJ = -1;

        public d(long j2) {
            AppMethodBeat.i(23163);
            Assert.assertTrue(j2 >= 0);
            this.rxJ = j2;
            AppMethodBeat.o(23163);
        }

        public final void run() {
            AppMethodBeat.i(23164);
            Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", Long.valueOf(this.rxJ));
            k.this.mHandler.obtainMessage(0, Long.valueOf(this.rxJ)).sendToTarget();
            AppMethodBeat.o(23164);
        }
    }

    class a extends MMHandler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            AppMethodBeat.i(23162);
            Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", Integer.valueOf(message.what));
            switch (message.what) {
                case 0:
                    long longValue = ((Long) message.obj).longValue();
                    e eVar = (e) k.this.rxD.get(Long.valueOf(longValue));
                    if (eVar == null) {
                        Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", Long.valueOf(longValue));
                        AppMethodBeat.o(23162);
                        return;
                    }
                    eVar.cKm().b(-1, "", null);
                    u.cLy().a(new h(eVar.cKm()));
                    k.this.rxD.remove(Long.valueOf(longValue));
                    AppMethodBeat.o(23162);
                    return;
                case 1:
                    f fVar = (f) message.obj;
                    if (!u.cLx().Dc(fVar.pkb)) {
                        Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", Long.valueOf(fVar.pkb));
                        fVar.b(-2, "", new byte[0]);
                        u.cLy().a(new h(fVar));
                        AppMethodBeat.o(23162);
                        return;
                    } else if (-5 == message.arg1 || -3 == message.arg1 || -4 == message.arg1) {
                        Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(message.arg1));
                        fVar.b(-1, "", new byte[0]);
                        u.cLy().a(new h(fVar));
                        AppMethodBeat.o(23162);
                        return;
                    } else {
                        com.tencent.mm.plugin.exdevice.i.b anI = ad.cKL().anI(new StringBuilder().append(fVar.pkb).toString());
                        if (anI == null) {
                            Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                            AppMethodBeat.o(23162);
                            return;
                        }
                        if (System.currentTimeMillis() / 1000 < ((long) anI.fLY)) {
                            Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
                            fVar.b(-5, "Device Is Block", null);
                            u.cLy().a(new h(fVar));
                            AppMethodBeat.o(23162);
                            return;
                        }
                        long cKo = f.cKo();
                        com.tencent.mm.plugin.exdevice.f.k kVar = (com.tencent.mm.plugin.exdevice.f.k) fVar.cKj();
                        if (kVar == null) {
                            Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
                            fVar.b(-4, "Decode failed", null);
                            u.cLy().a(new h(fVar));
                            AppMethodBeat.o(23162);
                            return;
                        }
                        Integer num = (Integer) k.this.rxF.get(anI.field_deviceID);
                        if (num == null) {
                            num = 0;
                        }
                        Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", num);
                        if (num.intValue() != 0) {
                            if ((num.intValue() & 1) != 0) {
                                ad.cKW();
                                com.tencent.mm.plugin.exdevice.model.e.c(anI.field_deviceID, anI.field_brandName, kVar.oTm.toByteArray());
                            }
                            if ((num.intValue() & 2) != 0) {
                                bg.azz().a(new w(fVar.pkb, anI.field_deviceType, anI.field_deviceID, cKo, Util.nowMilliSecond(), kVar.oTm.toByteArray(), kVar.oUv), 0);
                                d dVar = new d(cKo);
                                k.this.mHandler.postDelayed(dVar, 30000);
                                e eVar2 = new e((byte) 0);
                                eVar2.a(fVar);
                                eVar2.a(dVar);
                                eVar2.rxM = 0;
                                k.this.rxD.put(Long.valueOf(cKo), eVar2);
                            }
                            AppMethodBeat.o(23162);
                            return;
                        } else if (kVar.oUv == 10001) {
                            ad.cKW();
                            com.tencent.mm.plugin.exdevice.model.e.c(anI.field_deviceID, anI.field_brandName, kVar.oTm.toByteArray());
                            AppMethodBeat.o(23162);
                            return;
                        } else {
                            bg.azz().a(new w(fVar.pkb, anI.field_deviceType, anI.field_deviceID, cKo, Util.nowMilliSecond(), kVar.oTm.toByteArray(), kVar.oUv), 0);
                            d dVar2 = new d(cKo);
                            k.this.mHandler.postDelayed(dVar2, 30000);
                            e eVar3 = new e((byte) 0);
                            eVar3.a(fVar);
                            eVar3.a(dVar2);
                            eVar3.rxM = 0;
                            k.this.rxD.put(Long.valueOf(cKo), eVar3);
                            AppMethodBeat.o(23162);
                            return;
                        }
                    }
                case 2:
                    b bVar = (b) message.obj;
                    if (bVar.rxH == 0 && bVar.rxv == 0) {
                        AppMethodBeat.o(23162);
                        return;
                    }
                    w wVar = (w) bVar.rxI;
                    Assert.assertNotNull(wVar.hhm);
                    long j2 = ((dtp) wVar.hhm.iLK.iLR).MVD.Mgq;
                    e eVar4 = (e) k.this.rxD.get(Long.valueOf(j2));
                    if (eVar4 == null) {
                        Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(j2));
                        AppMethodBeat.o(23162);
                        return;
                    }
                    f cKm = eVar4.cKm();
                    switch (bVar.rxv) {
                        case -417:
                            i2 = -5;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    cKm.b(i2, bVar.lAr, null);
                    u.cLy().a(new h(eVar4.cKm()));
                    k.this.mHandler.removeCallbacks(eVar4.cKn());
                    k.this.rxD.remove(Long.valueOf(j2));
                    AppMethodBeat.o(23162);
                    return;
                case 3:
                    c cVar = (c) message.obj;
                    e eVar5 = (e) k.this.rxD.get(Long.valueOf(cVar.mSessionId));
                    if (eVar5 == null) {
                        Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", Long.valueOf(cVar.mSessionId));
                        AppMethodBeat.o(23162);
                        return;
                    }
                    eVar5.rxK.b(0, "", cVar.mData);
                    u.cLy().a(new h(eVar5.cKm()));
                    k.this.mHandler.removeCallbacks(eVar5.cKn());
                    k.this.rxD.remove(Long.valueOf(cVar.mSessionId));
                    AppMethodBeat.o(23162);
                    return;
                default:
                    Log.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", Integer.valueOf(message.what));
                    AppMethodBeat.o(23162);
                    return;
            }
        }
    }

    public static final class f {
        private static f rxO = null;
        private long rxN;

        public f() {
            long j2 = 0;
            AppMethodBeat.i(23169);
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                j2 = sharedPreferences.getLong("local_message_seq", 0);
                Log.i("MicroMsg.exdevice.Util", "lasted seq id is %d", Long.valueOf(j2));
            }
            this.rxN = j2;
            AppMethodBeat.o(23169);
        }

        public static long cKo() {
            AppMethodBeat.i(23170);
            if (rxO == null) {
                rxO = new f();
            }
            f fVar = rxO;
            if (MAlarmHandler.NEXT_FIRE_INTERVAL == fVar.rxN) {
                Log.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
                fVar.rxN = 0;
            }
            long j2 = fVar.rxN + 1;
            fVar.rxN = j2;
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
            if (sharedPreferences != null) {
                Log.i("MicroMsg.exdevice.Util", "save locall seq id : %d", Long.valueOf(j2));
                sharedPreferences.edit().putLong("local_message_seq", j2).commit();
            }
            AppMethodBeat.o(23170);
            return j2;
        }
    }

    public static k cKl() {
        AppMethodBeat.i(23171);
        if (rxE != null) {
            k kVar = rxE;
            AppMethodBeat.o(23171);
            return kVar;
        }
        k kVar2 = new k();
        rxE = kVar2;
        AppMethodBeat.o(23171);
        return kVar2;
    }

    private k() {
        AppMethodBeat.i(23172);
        this.rxD = new HashMap<>();
        this.mHandler = null;
        this.rxF = new HashMap<>();
        this.mHandler = new a(bg.aAk().getLooper());
        AppMethodBeat.o(23172);
    }

    public final void b(int i2, long j2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(23173);
        this.mHandler.obtainMessage(1, i2, 0, new f(j2, i3, i4, bArr)).sendToTarget();
        AppMethodBeat.o(23173);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23174);
        Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        b bVar = new b((byte) 0);
        bVar.rxv = i3;
        bVar.rxH = i2;
        bVar.lAr = str;
        bVar.rxI = qVar;
        this.mHandler.obtainMessage(2, bVar).sendToTarget();
        AppMethodBeat.o(23174);
    }
}
