package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a extends q implements m {
    private i callback;
    public s iMO = new C0844a();

    public a(LinkedList<adi> linkedList, String str, String str2) {
        AppMethodBeat.i(21370);
        final k.a aVar = (k.a) this.iMO.getReqObj();
        final boolean isSingleSession = this.iMO.isSingleSession();
        aVar.KzD = d.ceQ();
        aVar.KzC.KMC = linkedList.size();
        aVar.KzC.KMD = linkedList;
        aVar.KzC.KME = com.tencent.mm.compatible.deviceinfo.q.aoJ();
        aVar.KzC.KMF = z.aTY();
        aVar.KzC.Scene = 2;
        aVar.KzC.oTS = 0;
        aVar.KzC.KMG = str;
        aVar.KzC.KMH = str2;
        aVar.setPassKey(aVar.KzD);
        if (!isSingleSession) {
            aVar.KzE = aVar.KzD;
        }
        aVar.setReqPackControl(new l.a() {
            /* class com.tencent.mm.plugin.backup.e.a.AnonymousClass1 */

            @Override // com.tencent.mm.protocal.l.a
            public final boolean a(PByteArray pByteArray, int i2, byte[] bArr, byte[] bArr2, int i3) {
                long j2;
                byte[] bArr3;
                AppMethodBeat.i(21368);
                long uin = (long) aVar.getUin();
                if (!CrashReportFactory.hasDebuger() || uin != 0) {
                    j2 = uin;
                } else {
                    j2 = com.tencent.mm.protocal.d.KyN;
                }
                ac rsaInfo = aVar.getRsaInfo();
                if (i2 == 1000) {
                    byte[] passKey = aVar.getPassKey();
                    if (!rsaInfo.gtU()) {
                        passKey = new byte[0];
                    }
                    if (!isSingleSession) {
                        bArr3 = aVar.KzE;
                        aVar.setPassKey(aVar.KzE);
                    } else {
                        bArr3 = passKey;
                    }
                    if (Util.isNullOrNil(bArr3)) {
                        Log.e("MicroMsg.BackupCreateQRCodeOfflineScene", "dksession jType %d session should not null", Integer.valueOf(i2));
                        AppMethodBeat.o(21368);
                        return false;
                    }
                    byte[] protoBuf = aVar.toProtoBuf();
                    int i4 = 0;
                    if (!Util.isNullOrNil(bArr2) && !Util.isNullOrNil(protoBuf)) {
                        i4 = MMProtocalJni.genSignature((int) j2, bArr2, protoBuf);
                    }
                    int i5 = 0;
                    if (!isSingleSession) {
                        protoBuf = UtilsJni.AesGcmEncryptWithCompress(bArr3, protoBuf);
                        i5 = 13;
                        Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "not single session , use aes gcm encrypt");
                    }
                    Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "start to encode ,entype is %d", Integer.valueOf(i5));
                    if (MMProtocalJni.pack(protoBuf, pByteArray, bArr3, i5, bArr, aVar.getDeviceID(), (int) j2, aVar.getFuncId(), rsaInfo.ver, rsaInfo.KAw.getBytes(), rsaInfo.KAx.getBytes(), i4, i3, aVar.getRouteInfo(), 0)) {
                        Log.d("MicroMsg.BackupCreateQRCodeOfflineScene", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                        AppMethodBeat.o(21368);
                        return true;
                    }
                }
                AppMethodBeat.o(21368);
                return false;
            }
        });
        AppMethodBeat.o(21370);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(21371);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(21371);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(21372);
        Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", ((k.b) sVar.getRespObj()).KzF.KMJ);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(21372);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(21372);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1000;
    }

    /* renamed from: com.tencent.mm.plugin.backup.e.a$a  reason: collision with other inner class name */
    public static class C0844a extends o {
        private final k.a oMD = new k.a();
        private final k.b oME = new k.b();

        public C0844a() {
            AppMethodBeat.i(21369);
            AppMethodBeat.o(21369);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.oMD;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.oME;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 1000;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            return 1;
        }
    }
}
