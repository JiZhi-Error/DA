package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.k;
import java.io.IOException;

public final class i extends q implements m {
    private com.tencent.mm.ak.i heq;
    public int kfa;
    private int rcN;
    public byte[] rcO;
    private int rcP;
    private String rcQ;
    private int rcR;
    private final d rr;

    public i(int i2, int i3, int i4, String str, int i5, byte[] bArr) {
        AppMethodBeat.i(108686);
        d.a aVar = new d.a();
        aVar.iLN = new bmf();
        aVar.iLO = new bmg();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.d.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.kfa = i2;
        this.rcN = i3;
        this.rcP = i4;
        this.rcQ = str;
        this.rcO = bArr;
        this.rcR = i5;
        AppMethodBeat.o(108686);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108687);
        Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (((i3 == 0 && i4 == 0) || (i3 == 4 && (i4 == 2 || i4 == 3))) && ((this.rcO == null || this.rcO.length <= 0) && this.kfa != 3)) {
            k kVar = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpT;
            String sb = new StringBuilder().append(this.rcN).toString();
            bmg cGs = cGs();
            if (Util.isNullOrNil(sb) || cGs == null) {
                Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    j jVar = new j();
                    jVar.field_designerIDAndType = sb + k.a.DesignerEmojiList.value;
                    jVar.field_content = cGs.toByteArray();
                    ContentValues convertTo = jVar.convertTo();
                    new String[1][0] = sb + k.a.DesignerEmojiList.value;
                    if (kVar.db.replace("EmotionDesignerInfo", "designerIDAndType", convertTo) > 0) {
                        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", sb);
                    } else {
                        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", sb);
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        bmg bmg = (bmg) ((d) sVar).iLL.iLR;
        if (bmg.LUY != null) {
            this.rcO = z.a(bmg.LUY);
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108687);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(108688);
        this.heq = iVar;
        bmf bmf = (bmf) this.rr.iLK.iLR;
        if (this.rcO != null) {
            bmf.LUY = z.aC(this.rcO);
        } else {
            bmf.LUY = new SKBuiltinBuffer_t();
        }
        Log.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", bmf.LUY == null ? "Buf is NULL" : bmf.LUY.toString());
        bmf.DesignerUin = this.rcN;
        bmf.OpCode = this.kfa;
        bmf.Lst = this.rcP;
        bmf.LUZ = this.rcQ;
        bmf.LVa = this.rcR;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108688);
        return dispatch;
    }

    public final bmg cGs() {
        if (this.rr == null) {
            return null;
        }
        return (bmg) this.rr.iLL.iLR;
    }
}
