package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l {
    public static boolean bdN() {
        boolean z;
        AppMethodBeat.i(132584);
        g.aAi();
        if (Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)).length() > 0) {
            g.aAi();
            if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
                z = false;
                Log.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
                AppMethodBeat.o(132584);
                return z;
            }
        }
        z = true;
        Log.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(132584);
        return z;
    }

    public static void b(int i2, byte[] bArr, byte[] bArr2, long j2) {
        AppMethodBeat.i(132585);
        v.b bVar = new v.b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
            Log.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret:" + unpack + ", noticeid:" + unpack, Integer.valueOf(pInt3.value));
            if (pInt3.value != 0) {
                jm jmVar = new jm();
                jmVar.dOn.dOo = pInt3.value;
                Log.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar)));
                pInt3.value = 0;
            }
            if (pInt2.value == 13) {
                g.aAi();
                byte[] qe = g.aAg().qe(3);
                pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(qe, pByteArray2.value);
                Log.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession" + (qe == null ? -1 : qe.length) + " new pr[" + pByteArray2.value + ": " + (pByteArray2.value == null ? -1 : pByteArray2.value.length) + "]");
            }
            if (!unpack) {
                Log.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
                AppMethodBeat.o(132585);
                return;
            }
            bVar.setHeadExtFlags(pInt4.value);
            if (pInt.value == -13) {
                bVar.setRetCode(pInt.value);
                Log.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
                AppMethodBeat.o(132585);
                return;
            }
            int fromProtoBuf = bVar.fromProtoBuf(pByteArray2.value);
            Log.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
            bVar.setRetCode(fromProtoBuf);
            bVar.setBufferSize((long) bArr.length);
            g.aAi();
            byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)));
            byte[] a2 = z.a(bVar.KAh.Lev);
            g.aAi();
            g.aAf().cU(bVar.KAh.oTW, bVar.KAh.Mzb);
            a.qc(bVar.KAh.oTW);
            if (Util.isNullOrNil(a2) || !ad.m(decodeHexString, a2)) {
                Log.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                AppMethodBeat.o(132585);
                return;
            }
            ((b) g.af(b.class)).bdS().a(bVar, i2, j2);
            if (pInt3.value != 0) {
                jm jmVar2 = new jm();
                jmVar2.dOn.dOo = pInt3.value;
                Log.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar2)));
                pInt3.value = 0;
            }
            AppMethodBeat.o(132585);
        } catch (Exception e2) {
            Log.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", e2);
            Log.printErrStackTrace("MicroMsg.NewSyncMgr", e2, "", new Object[0]);
        }
    }
}
