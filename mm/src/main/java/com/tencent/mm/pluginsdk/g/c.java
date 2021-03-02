package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class c extends q implements m {
    private final a JXC;
    private i callback;
    private d rr;

    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, String str6, long j2);
    }

    public c(k.b bVar, String str, String str2, a aVar) {
        AppMethodBeat.i(223773);
        d.a aVar2 = new d.a();
        aVar2.iLN = new xv();
        aVar2.iLO = new xw();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        aVar2.funcId = 727;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        xv xvVar = (xv) this.rr.iLK.iLR;
        if (bVar == null || Util.isNullOrNil(bVar.aesKey) || Util.isNullOrNil(bVar.filemd5)) {
            f.baR();
            xvVar.LbJ = com.tencent.mm.an.a.baG();
            f.baR();
            xvVar.xuB = com.tencent.mm.an.a.NV(str);
            xvVar.xuz = s.bpb(str);
            xvVar.KMh = s.akC(str);
            xvVar.KMg = (long) ((int) s.boW(str));
        } else {
            xvVar.LbJ = bVar.aesKey;
            xvVar.xuB = bVar.filemd5;
            xvVar.xuz = bVar.title;
            xvVar.KMh = bVar.iwJ;
            xvVar.KMg = (long) bVar.iwI;
        }
        xvVar.KKA = com.tencent.mm.i.a.gpO;
        xvVar.xNG = str2;
        xvVar.xNH = z.aTY();
        this.JXC = aVar;
        Log.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", bVar, xvVar.LbJ, xvVar.xuB, xvVar.xuz, Long.valueOf(xvVar.KMg), xvVar.KMh, xvVar.xNG, xvVar.xNH, Util.getStack());
        AppMethodBeat.o(223773);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 727;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(223774);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(223774);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(223775);
        Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            xv xvVar = (xv) ((d) sVar).iLK.iLR;
            xw xwVar = (xw) ((d) sVar).iLL.iLR;
            Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", xwVar.keb, Integer.valueOf(xwVar.LiR), xwVar.LiS, xwVar.LiT);
            if (this.JXC != null) {
                String str2 = "";
                if (xwVar.getBaseResponse().Ret != 0) {
                    Map<String, String> parseXml = XmlParser.parseXml(xwVar.getBaseResponse().ErrMsg.toString(), "e", null);
                    if (parseXml == null) {
                        str2 = MMApplicationContext.getContext().getString(R.string.b3c);
                    } else {
                        str2 = parseXml.get(".e.Content");
                    }
                }
                this.JXC.a(str2, xvVar.xuB, xvVar.LbJ, xwVar.keb, xwVar.LiS, xwVar.LiT, xvVar.KMg);
            }
            AppMethodBeat.o(223775);
            return;
        }
        Log.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (this.JXC != null) {
            String string = MMApplicationContext.getContext().getString(R.string.b3d);
            if (!Util.isNullOrNil(str)) {
                Map<String, String> parseXml2 = XmlParser.parseXml(str, "e", null);
                if (parseXml2 == null) {
                    string = MMApplicationContext.getContext().getString(R.string.b3c);
                } else {
                    string = parseXml2.get(".e.Content");
                }
            }
            this.JXC.a(string, "", "", "", "", "", 0);
        }
        AppMethodBeat.o(223775);
    }
}
