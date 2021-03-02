package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class c extends q implements m {
    private i heq;
    private final s iMO = new d();

    public c() {
        String str;
        byte[] bArr;
        AppMethodBeat.i(134149);
        j.c cVar = (j.c) this.iMO.getReqObj();
        this.iMO.getRespObj();
        hx hxVar = new hx();
        ia iaVar = new ia();
        cVar.Kzu.KLV = iaVar;
        cVar.Kzu.KLW = hxVar;
        hxVar.KLS = new dfx();
        String bjr = b.bjq().bjr();
        if (!TextUtils.isEmpty(bjr)) {
            hxVar.KLS.LrO = b.bjq().jDB.LrO;
            hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
            Log.i("MicroMsg.MMDisasterAuth", "disaster auth add public key , length " + bjr.length());
        } else {
            hxVar.KLS.LrO = 0;
            hxVar.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            Log.e("MicroMsg.MMDisasterAuth", "get sign key failed");
        }
        SharedPreferences aVK = bh.aVK();
        String string = aVK.getString("_auth_key", "");
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(string == null ? -1 : string.length());
        Log.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", objArr);
        byte[] decodeHexString = Util.decodeHexString(string);
        hy hyVar = new hy();
        if (!Util.isNullOrNil(decodeHexString)) {
            hxVar.KKZ = new SKBuiltinBuffer_t().setBuffer(decodeHexString);
            Log.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", Integer.valueOf(hxVar.KKZ.getBuffer().zy.length), Integer.valueOf(decodeHexString.length));
            try {
                hyVar.parseFrom(decodeHexString);
            } catch (IOException e2) {
                e.INSTANCE.idkeyStat(148, 15, 1, false);
                Log.printErrStackTrace("MicroMsg.MMDisasterAuth", e2, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
            }
        } else {
            e.INSTANCE.idkeyStat(148, 16, 1, false);
            hxVar.KKZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        }
        if (hyVar.KLT != null) {
            iaVar.KLX = hyVar.KLT;
            Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", Integer.valueOf(hyVar.KLT.getBuffer().zy.length), Util.dumpHex(hyVar.KLT.getBuffer().zy));
        } else {
            e.INSTANCE.idkeyStat(148, 17, 1, false);
            iaVar.KLX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
        }
        g.aAi();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(2, (Object) null));
        g.aAi();
        p pVar = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0));
        if (Util.isNullOrNil(nullAsNil)) {
            str = pVar.toString();
        } else {
            str = nullAsNil;
        }
        Log.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", Integer.valueOf(aVK.getInt("key_auth_update_version", 0)), Integer.valueOf(d.KyO));
        cVar.setSceneStatus(2);
        jk jkVar = new jk();
        jkVar.KOa = 1;
        jkVar.KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        jkVar.KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ewr ewr = new ewr();
        jkVar.KNY = ewr;
        ewr.KQx = "";
        ewr.KQw = "";
        ewr.Num = "";
        fca fca = new fca();
        jkVar.KNZ = fca;
        fca.MbK = "";
        fca.MbJ = "";
        if (!g.aAc()) {
            Log.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
            AppMethodBeat.o(134149);
            return;
        }
        g.aAi();
        byte[] a2 = g.aAf().azh().a(pVar.longValue(), "", false);
        hxVar.KFu = MMApplicationContext.getApplicationId();
        Object[] objArr2 = new Object[5];
        objArr2[0] = str;
        objArr2[1] = pVar;
        objArr2[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
        objArr2[3] = a2 == null ? BuildConfig.COMMAND : Util.secPrint(Util.dumpHex(a2));
        objArr2[4] = hxVar.KFu;
        Log.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s], AndroidPackageName:%s", objArr2);
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (Util.isNullOrNil(a2)) {
            bArr = new byte[0];
        } else {
            bArr = a2;
        }
        jkVar.KNX = sKBuiltinBuffer_t.setBuffer(bArr);
        hxVar.KLK = jkVar;
        cVar.username = str;
        b.a aVar = new b.a();
        aVar.jDD = b.bjq().bjr();
        aVar.jDC = b.bjq().jDC;
        cVar.setCGiVerifyKey(aVar);
        AppMethodBeat.o(134149);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(134150);
        this.heq = iVar;
        e.INSTANCE.idkeyStat(148, 126, 1, false);
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(134150);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134151);
        ell ell = ((j.d) sVar.getRespObj()).Kzw;
        if (ell != null) {
            ctc ctc = ell.NkA;
            if (!(ctc == null || ctc.KQk == null || ctc.KQl == null || ctc.KQj == null)) {
                bh.a(false, ctc.KQk, ctc.KQl, ctc.KQj);
            }
            aj.a(ell.NkB);
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        if (i4 == 0 && i3 == 0) {
            e.INSTANCE.idkeyStat(148, 127, 1, false);
            AppMethodBeat.o(134151);
            return;
        }
        e.INSTANCE.idkeyStat(148, 128, 1, false);
        AppMethodBeat.o(134151);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(134152);
        int type = this.iMO.getType();
        AppMethodBeat.o(134152);
        return type;
    }
}
