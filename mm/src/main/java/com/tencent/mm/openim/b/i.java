package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.a;
import com.tencent.mm.openim.e.c;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fbu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    String jHc;
    private LinkedList<String> jHd = new LinkedList<>();
    String language;
    public final d rr;

    public i(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.i(151202);
        if (Util.isNullOrNil(str) || !str.equals("wework")) {
            Log.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", str, Util.getStack().toString());
        } else {
            Log.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", str, Util.getStack().toString());
        }
        d.a aVar = new d.a();
        aVar.iLN = new brq();
        aVar.iLO = new brr();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimresource";
        aVar.funcId = u.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.jHc = str;
        this.language = str2;
        this.jHd.addAll(linkedList);
        int size = 10 - this.jHd.size();
        if (size > 0) {
            this.jHd.addAll(((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().S(size, str2));
        }
        brq brq = (brq) this.rr.iLK.iLR;
        brq.app_id = str;
        brq.language = str2;
        brq.LYT = this.jHd;
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", str, str2, p(linkedList), p(this.jHd));
        AppMethodBeat.o(151202);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(151203);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151203);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return u.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151204);
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.jHc, this.language);
        if (i3 == 0 && i4 == 0) {
            brr brr = (brr) this.rr.iLL.iLR;
            bb bbVar = brr.LYV;
            Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", Integer.valueOf(bbVar.duo.size()), Integer.valueOf(bbVar.KEp.size()));
            a aVar = new a();
            aVar.field_acctTypeId = bbVar.KEo;
            aVar.field_language = this.language;
            g.aAi();
            ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAccTypeInfoStg().get(aVar, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            aVar.field_accTypeRec = bbVar;
            g.aAi();
            ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAccTypeInfoStg().a(aVar);
            ez ezVar = brr.LYU;
            Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", Integer.valueOf(ezVar.KIp), Integer.valueOf(ezVar.duo.size()), Integer.valueOf(ezVar.KEp.size()));
            c cVar = new c();
            cVar.field_appid = this.jHc;
            cVar.field_language = this.language;
            g.aAi();
            ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            cVar.field_appRec = ezVar;
            cVar.field_acctTypeId = bbVar.KEo;
            g.aAi();
            ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().a(cVar);
            Iterator<cwr> it = ezVar.duo.iterator();
            while (it.hasNext()) {
                cwr next = it.next();
                if ("openim_desc_icon".equals(next.key)) {
                    ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).RY(next.url);
                }
            }
            Log.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", Integer.valueOf(brr.LYW.size()));
            Iterator<fbu> it2 = brr.LYW.iterator();
            while (it2.hasNext()) {
                fbu next2 = it2.next();
                e eVar = new e();
                eVar.field_appid = this.jHc;
                eVar.field_wordingId = next2.MOt;
                eVar.field_language = this.language;
                g.aAi();
                ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                eVar.field_wording = next2.dQx;
                eVar.field_pinyin = next2.pinyin;
                eVar.field_quanpin = next2.NxU;
                g.aAi();
                ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().a(eVar);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(151204);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151204);
    }

    private static String p(LinkedList<String> linkedList) {
        AppMethodBeat.i(151205);
        String str = "size:" + linkedList.size() + "[";
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            str = str + it.next() + ",";
        }
        String str2 = str + "]";
        AppMethodBeat.o(151205);
        return str2;
    }
}
