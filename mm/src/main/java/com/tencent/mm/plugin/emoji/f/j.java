package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.k;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;

public final class j extends q implements m {
    private i heq;
    private String rcS;
    private final d rr;

    public j(String str) {
        AppMethodBeat.i(108689);
        d.a aVar = new d.a();
        aVar.iLN = new bmh();
        aVar.iLO = new bmi();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.funcId = TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcS = str;
        AppMethodBeat.o(108689);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108690);
        Log.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            k kVar = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpT;
            String str2 = this.rcS;
            bmi cGt = cGt();
            if (Util.isNullOrNil(str2) || cGt == null) {
                Log.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    com.tencent.mm.storage.emotion.j jVar = new com.tencent.mm.storage.emotion.j();
                    jVar.field_designerIDAndType = str2 + k.a.DesignerSimpleInfo.value;
                    jVar.field_content = cGt.toByteArray();
                    ContentValues convertTo = jVar.convertTo();
                    new String[1][0] = str2 + k.a.DesignerSimpleInfo.value;
                    if (kVar.db.replace("EmotionDesignerInfo", "designerIDAndType", convertTo) > 0) {
                        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", str2);
                    } else {
                        Log.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", str2);
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108690);
    }

    public final bmi cGt() {
        if (this.rr == null) {
            return null;
        }
        return (bmi) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(108691);
        this.heq = iVar;
        ((bmh) this.rr.iLK.iLR).Lsl = this.rcS;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108691);
        return dispatch;
    }
}
