package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a extends q implements m {
    private final AbstractC2016a JXx;
    private i callback;
    private d rr;

    /* renamed from: com.tencent.mm.pluginsdk.g.a$a  reason: collision with other inner class name */
    public interface AbstractC2016a {
        void bS(int i2, String str);
    }

    public static class b {
        public String aesKey;
        public String fileName;
        public String filePath;
        public long fileSize;
        public String gCr;
        public String pkL;
        public String toUser;
    }

    public a(List<b> list, AbstractC2016a aVar) {
        AppMethodBeat.i(223767);
        d.a aVar2 = new d.a();
        aVar2.iLN = new js();
        aVar2.iLO = new jt();
        aVar2.uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
        aVar2.funcId = 3939;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        js jsVar = (js) this.rr.iLK.iLR;
        for (b bVar : list) {
            xv xvVar = new xv();
            String str = bVar.filePath;
            String str2 = bVar.toUser;
            if (Util.isNullOrNil(bVar.aesKey) || Util.isNullOrNil(bVar.pkL)) {
                f.baR();
                xvVar.LbJ = com.tencent.mm.an.a.baG();
                f.baR();
                xvVar.xuB = com.tencent.mm.an.a.NV(str);
                xvVar.xuz = s.bpb(str);
                xvVar.KMh = s.akC(str);
                xvVar.KMg = (long) ((int) s.boW(str));
            } else {
                xvVar.LbJ = bVar.aesKey;
                xvVar.xuB = bVar.pkL;
                xvVar.xuz = bVar.fileName;
                xvVar.KMh = bVar.gCr;
                xvVar.KMg = bVar.fileSize;
            }
            xvVar.KKA = com.tencent.mm.i.a.gpO;
            xvVar.xNG = str2;
            xvVar.xNH = z.aTY();
            Log.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", xvVar.LbJ, xvVar.xuB, xvVar.xuz, Long.valueOf(xvVar.KMg), xvVar.KMh, xvVar.xNG, xvVar.xNH, Util.getStack());
            jsVar.oTA.add(xvVar);
        }
        jsVar.oTz = jsVar.oTA.size();
        this.JXx = aVar;
        AppMethodBeat.o(223767);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3939;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(223768);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(223768);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        String str2;
        AppMethodBeat.i(223769);
        Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            js jsVar = (js) ((d) sVar).iLK.iLR;
            jt jtVar = (jt) ((d) sVar).iLL.iLR;
            int i5 = jtVar.getBaseResponse().Ret;
            if (i5 != 0) {
                String dqi = jtVar.getBaseResponse().ErrMsg.toString();
                Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + i5 + ", errMsg:" + dqi);
                this.callback.onSceneEnd(i3, i5, dqi, this);
                if (this.JXx != null) {
                    this.JXx.bS(i5, dqi);
                }
                AppMethodBeat.o(223769);
            } else if (jsVar.oTz == jtVar.oTz && jsVar.oTA.size() == jtVar.oTA.size() && jtVar.oTz == jtVar.oTA.size()) {
                Iterator<xw> it = jtVar.oTA.iterator();
                while (it.hasNext()) {
                    xw next = it.next();
                    int i6 = next.getBaseResponse().Ret;
                    String dqi2 = next.getBaseResponse().ErrMsg.toString();
                    if (i6 != 0) {
                        Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + next + ", errMsg:" + dqi2);
                        Map<String, String> parseXml = XmlParser.parseXml(dqi2, "e", null);
                        if (parseXml == null) {
                            str2 = MMApplicationContext.getContext().getString(R.string.b3c);
                        } else {
                            str2 = parseXml.get(".e.Content");
                        }
                        this.callback.onSceneEnd(i3, i6, str2, this);
                        if (this.JXx != null) {
                            this.JXx.bS(i6, str2);
                        }
                        AppMethodBeat.o(223769);
                        return;
                    }
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                if (this.JXx != null) {
                    List synchronizedList = Collections.synchronizedList(new ArrayList());
                    for (int i7 = 0; i7 < jtVar.oTz; i7++) {
                        c cVar = new c();
                        cVar.pkL = jsVar.oTA.get(i7).xuB;
                        cVar.totalLen = jsVar.oTA.get(i7).KMg;
                        cVar.aesKey = jsVar.oTA.get(i7).LbJ;
                        cVar.signature = jtVar.oTA.get(i7).keb;
                        cVar.JXy = jtVar.oTA.get(i7).LiS;
                        cVar.JXz = jtVar.oTA.get(i7).LiT;
                        Log.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", cVar.signature, Integer.valueOf(jtVar.oTA.get(i7).LiR), cVar.JXy, cVar.JXz);
                        synchronizedList.add(cVar);
                    }
                    this.JXx.bS(0, "");
                }
                AppMethodBeat.o(223769);
            } else {
                Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + jsVar.oTz + " not equals resp.Count:" + jtVar.oTz + ", resp.List.size() = " + jtVar.oTA.size());
                this.callback.onSceneEnd(i3, -1000, "req-count mismatch resp-count", this);
                if (this.JXx != null) {
                    this.JXx.bS(-1000, MMApplicationContext.getContext().getString(R.string.b3b));
                }
                AppMethodBeat.o(223769);
            }
        } else {
            Log.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i3 + ", errCode = " + i4);
            this.callback.onSceneEnd(i3, i4, str, this);
            if (this.JXx != null) {
                if (Util.isNullOrNil(str)) {
                    str = MMApplicationContext.getContext().getString(R.string.b3d);
                }
                AbstractC2016a aVar = this.JXx;
                if (i4 == 0) {
                    i4 = -1001;
                }
                aVar.bS(i4, str);
            }
            AppMethodBeat.o(223769);
        }
    }

    public class c {
        public String JXy;
        public String JXz;
        public String aesKey;
        public String pkL;
        public String signature;
        public long totalLen;

        public c() {
        }
    }
}
