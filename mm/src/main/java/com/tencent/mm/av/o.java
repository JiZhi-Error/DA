package com.tencent.mm.av;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o extends q implements m {
    private i callback;
    private int hmk;
    private g iWX;
    private a iZF;
    private final d rr;

    public interface a {
        void a(long j2, int i2, int i3, int i4, String str);
    }

    public o(int i2, enu enu, g gVar, com.tencent.mm.i.d dVar, a aVar) {
        this(i2, enu, gVar, dVar, aVar, (byte) 0);
        AppMethodBeat.i(150717);
        AppMethodBeat.o(150717);
    }

    private o(int i2, enu enu, g gVar, com.tencent.mm.i.d dVar, a aVar, byte b2) {
        AppMethodBeat.i(223632);
        d.a aVar2 = new d.a();
        aVar2.iLN = new enu();
        aVar2.iLO = new env();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar2.funcId = 110;
        aVar2.iLP = 9;
        aVar2.respCmdId = 1000000009;
        this.rr = aVar2.aXF();
        this.iZF = aVar;
        this.hmk = i2;
        this.iWX = gVar;
        enu enu2 = (enu) this.rr.iLK.iLR;
        enu2.KHl = enu.KHl;
        enu2.KHm = enu.KHm;
        enu2.NlB = enu.NlB;
        enu2.xKb = enu.xKb;
        enu2.KHq = enu.KHq;
        enu2.LbM = enu.LbM;
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(q.bcR().o(gVar.iXo, "", ""));
        enu2.NlJ = imageOptions != null ? imageOptions.outWidth : 0;
        enu2.NlI = imageOptions != null ? imageOptions.outHeight : 0;
        enu2.NlG = dVar.field_fileId;
        enu2.NlH = dVar.field_thumbimgLength;
        enu2.BsF = dVar.field_thumbimgLength;
        enu2.BsG = 0;
        enu2.BsH = dVar.field_thumbimgLength;
        enu2.BsI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        enu2.jfi = enu.jfi;
        enu2.KEq = enu.KEq;
        enu2.KEs = enu.KEs;
        enu2.KEr = enu.KEr;
        enu2.LbK = 1;
        enu2.MDZ = null;
        if (dVar.alL()) {
            Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(dVar.field_upload_by_safecdn), Integer.valueOf(dVar.field_UploadHitCacheType), Integer.valueOf(dVar.field_filecrc), dVar.field_aesKey);
            enu2.MVx = 1;
            enu2.LbJ = "";
            enu2.Mir = "";
        } else {
            enu2.LbJ = dVar.field_aesKey;
            enu2.Mir = dVar.field_aesKey;
        }
        enu2.LYt = enu.LYt;
        if (enu.LYt == 1) {
            enu2.NlE = (int) dVar.field_fileLength;
            enu2.NlF = dVar.field_midimgLength;
            enu2.NlC = dVar.field_fileId;
            enu2.NlD = dVar.field_fileId;
        } else {
            enu2.NlE = 0;
            enu2.NlF = (int) dVar.field_fileLength;
            enu2.NlC = "";
            enu2.NlD = dVar.field_fileId;
        }
        enu2.LbL = dVar.field_filecrc;
        enu2.Md5 = dVar.field_filemd5;
        if (((s) g.ah(s.class)).ifAddTicketByActionFlag(z.a(enu.KHm))) {
            enu2.LbN = ((l) g.af(l.class)).aSN().bjT(z.a(enu.KHm));
        }
        Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(enu2.LbM), Integer.valueOf(enu2.MVx), Util.secPrint(enu2.LbJ), Integer.valueOf(enu2.LbL));
        AppMethodBeat.o(223632);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150718);
        Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((enu) this.rr.iLK.iLR).toString());
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150718);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(150719);
        Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i3 + " errcode:" + i4);
        env env = (env) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(env.CreateTime), Long.valueOf(env.Brn));
        if (env != null && (i3 == 4 || (i3 == 0 && i4 == 0))) {
            ((s) g.ah(s.class)).setEnSendMsgActionFlag(env.LbO);
        }
        if (this.iZF != null) {
            this.iZF.a(env.Brn, env.CreateTime, i3, i4, env.KHq);
        }
        this.callback.onSceneEnd(0, 0, "", this);
        AppMethodBeat.o(150719);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 110;
    }
}
