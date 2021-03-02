package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends j.a implements i {
    static Object duI = new Object();
    private static final byte[] rAD = {-2, 1, 1};
    private static aa rAE;
    static LinkedList<String> rAI = new LinkedList<>();
    private static HashMap<String, le> rAJ = new HashMap<>(32);
    final MTimerHandler klF = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.exdevice.model.aa.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(23427);
            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ad.cKS().a(0, aa.this);
            AppMethodBeat.o(23427);
            return true;
        }
    }, true);
    a rAF;
    HashMap<String, byte[]> rAG = new HashMap<>();
    LinkedList<q> rAH = new LinkedList<>();
    boolean rzT = false;
    volatile String rzn;

    public interface a {
        void a(String str, byte[] bArr, boolean z);
    }

    static {
        AppMethodBeat.i(23435);
        AppMethodBeat.o(23435);
    }

    public static aa cKI() {
        AppMethodBeat.i(23428);
        if (rAE != null) {
            aa aaVar = rAE;
            AppMethodBeat.o(23428);
            return aaVar;
        }
        aa aaVar2 = new aa();
        rAE = aaVar2;
        AppMethodBeat.o(23428);
        return aaVar2;
    }

    private aa() {
        AppMethodBeat.i(23429);
        AppMethodBeat.o(23429);
    }

    public final void Gy(int i2) {
        AppMethodBeat.i(23430);
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", Integer.valueOf(i2));
        this.klF.stopTimer();
        if (this.rzT) {
            ad.cKS().Gx(i2);
            this.rzT = false;
            this.rzn = null;
            this.rAG.clear();
            bg.azz().b(542, this);
            Iterator<q> it = this.rAH.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null) {
                    bg.azz().a(next);
                }
            }
            this.rAH.clear();
            if (this.rAF != null) {
                this.rAF.a(null, null, true);
            }
            this.rAF = null;
        } else {
            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (duI) {
            try {
                rAI.clear();
            } finally {
                AppMethodBeat.o(23430);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r1 = new com.tencent.mm.plugin.exdevice.model.k(new java.lang.String[]{r11}, r7.rzn);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
        if (com.tencent.mm.model.bg.azz().a(r1, 0) == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        r7.rAH.add(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(23431);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        com.tencent.mm.plugin.exdevice.model.aa.rAI.remove(r0);
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.exdevice.ScanDeviceLogic", "MMCore.getNetSceneQueue().doScene failed!!!");
        com.tencent.matrix.trace.core.AppMethodBeat.o(23431);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    @Override // com.tencent.mm.plugin.exdevice.service.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, byte[] r14) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.aa.a(int, int, java.lang.String, java.lang.String, java.lang.String, int, byte[]):void");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23432);
        Object[] objArr = new Object[4];
        objArr[0] = qVar == null ? "" : Integer.valueOf(qVar.getType());
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = str;
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s", objArr);
        this.rAH.remove(qVar);
        if (i2 == 0 && i3 == 0 && qVar != null) {
            if (542 == qVar.getType()) {
                Iterator<le> it = ((k) qVar).cKD().KOW.iterator();
                while (it.hasNext()) {
                    le next = it.next();
                    if (Util.isNullOrNil(next.KOS)) {
                        Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                    } else {
                        String str2 = this.rzn + "_" + next.KOS;
                        synchronized (duI) {
                            try {
                                if (rAI.contains(str2)) {
                                    rAI.remove(str2);
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(23432);
                                throw th;
                            }
                        }
                        if (!rAJ.containsKey(str2)) {
                            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", str2);
                            rAJ.put(str2, next);
                        }
                        a(next);
                    }
                }
            }
            AppMethodBeat.o(23432);
            return;
        }
        Log.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        AppMethodBeat.o(23432);
    }

    private void a(le leVar) {
        byte[] bArr;
        AppMethodBeat.i(23433);
        if (leVar == null) {
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
            AppMethodBeat.o(23433);
        } else if (Util.isNullOrNil(leVar.KOS)) {
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
            AppMethodBeat.o(23433);
        } else if (leVar.Ret != 0) {
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", leVar.KOS);
            AppMethodBeat.o(23433);
        } else if (leVar.KOZ == null || Util.isNullOrNil(leVar.KOZ.oTH)) {
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", leVar.KOS);
            AppMethodBeat.o(23433);
        } else if (Util.isNullOrNil(leVar.KOZ.KLO) || !leVar.KOZ.KLO.equals(this.rzn)) {
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", leVar.oTI, this.rzn);
            AppMethodBeat.o(23433);
        } else {
            byte[] bArr2 = this.rAG.get(leVar.KOS);
            Object[] objArr = new Object[5];
            objArr[0] = leVar.KOS;
            objArr[1] = leVar.KOZ.KLO;
            objArr[2] = leVar.KOZ.oTH;
            objArr[3] = leVar.oTI;
            objArr[4] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s", objArr);
            if (this.rAF != null) {
                if (bArr2 != null) {
                    bArr = bv(bArr2);
                } else {
                    bArr = null;
                }
                this.rAF.a(leVar.KOZ.oTH, bArr, false);
                AppMethodBeat.o(23433);
                return;
            }
            Log.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
            AppMethodBeat.o(23433);
        }
    }

    private static byte[] bv(byte[] bArr) {
        int i2;
        int i3;
        AppMethodBeat.i(23434);
        byte[] bArr2 = null;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length - 2) {
            try {
                int i6 = i4 + 1;
                byte b2 = bArr[i4];
                if (b2 != 0) {
                    i4 = i6 + 1;
                    switch (bArr[i6]) {
                        case -1:
                            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", Integer.valueOf(b2));
                            byte[] bArr3 = new byte[(b2 - 1)];
                            int i7 = b2;
                            while (i7 > 1) {
                                if (i5 >= 32 || i5 >= bArr3.length) {
                                    i2 = i4;
                                    i3 = i5;
                                } else {
                                    i3 = i5 + 1;
                                    i2 = i4 + 1;
                                    bArr3[i5] = bArr[i4];
                                }
                                i7--;
                                i4 = i2;
                                i5 = i3;
                            }
                            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.bw(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i4 += b2 - 1;
                            break;
                    }
                } else {
                    AppMethodBeat.o(23434);
                    return bArr2;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e2, "", new Object[0]);
                Log.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", e2.getMessage());
                AppMethodBeat.o(23434);
                return null;
            }
        }
        AppMethodBeat.o(23434);
        return bArr2;
    }
}
