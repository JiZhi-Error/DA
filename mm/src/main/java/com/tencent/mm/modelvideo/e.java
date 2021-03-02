package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.protocal.protobuf.eif;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends q implements m {
    private i callback;
    private String clientId = "";
    private s jqA = null;
    private d jqB = null;
    private long jqz = -1;
    private com.tencent.mm.ak.d rr;

    public e(long j2, s sVar, d dVar, String str) {
        AppMethodBeat.i(126838);
        Log.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", Long.valueOf(j2), str);
        this.jqz = j2;
        this.jqA = sVar;
        this.jqB = dVar;
        this.clientId = str;
        AppMethodBeat.o(126838);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(126839);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new duc();
        aVar.iLO = new dud();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.funcId = 245;
        this.rr = aVar.aXF();
        duc duc = (duc) this.rr.iLK.iLR;
        duc.aesKey = this.jqB.field_aesKey;
        duc.DRR = this.clientId;
        duc.md5 = this.jqA.ebj;
        duc.LaB = this.jqA.iFw;
        o.bhj();
        String Qx = t.Qx(this.jqA.getFileName());
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(Qx);
        if (imageOptions != null) {
            duc.thumbWidth = imageOptions.outWidth;
            duc.thumbHeight = imageOptions.outHeight;
        } else {
            Log.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", Qx);
        }
        duc.jqS = this.jqA.jsl;
        String[] split = Util.nullAs(this.jqA.jsv, "").split(",");
        if (split == null || split.length <= 0) {
            Log.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", Long.valueOf(this.jqz));
            AppMethodBeat.o(126839);
            return -1;
        }
        for (String str : split) {
            eif eif = new eif();
            eif.username = str;
            duc.MVN.add(eif);
        }
        duc.url = this.jqB.field_fileId;
        duc.iFw = this.jqA.iKP;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(126839);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(126840);
        Log.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.jqz);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(126840);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 245;
    }
}
