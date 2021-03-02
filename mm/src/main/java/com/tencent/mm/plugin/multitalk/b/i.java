package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.protocal.protobuf.esb;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.FileUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {
    public static d bd(LinkedList<String> linkedList) {
        AppMethodBeat.i(239034);
        d.a aVar = new d.a();
        aVar.iLN = new err();
        aVar.iLO = new ers();
        aVar.funcId = 3994;
        aVar.uri = "/cgi-bin/micromsg-bin/voipmtgetuserinfo";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        ((err) aXF.iLK.iLR).jfN = linkedList;
        AppMethodBeat.o(239034);
        return aXF;
    }

    public static d a(String str, long j2, String str2, String str3, String str4, LinkedList<esc> linkedList, LinkedList<acw> linkedList2) {
        AppMethodBeat.i(239035);
        d.a aVar = new d.a();
        aVar.iLN = new eru();
        aVar.iLO = new erv();
        aVar.funcId = FileUtils.S_IRWXU;
        aVar.uri = "/cgi-bin/micromsg-bin/voipmtinvite";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        esc esc = new esc();
        esc.username = str3;
        esc.Npd = str4;
        d aXF = aVar.aXF();
        eru eru = (eru) aXF.iLK.iLR;
        eru.Npm = esc;
        eru.NoW = str;
        eru.NoX = str2;
        eru.Lnw = j2;
        LinkedList<erw> linkedList3 = new LinkedList<>();
        Iterator<acw> it = linkedList2.iterator();
        while (it.hasNext()) {
            acw next = it.next();
            erw erw = new erw();
            erw.Loi = next.Loi;
            Iterator<esc> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                esc next2 = it2.next();
                if (next.openid.equals(next2.Npd)) {
                    erw.Npo = next2;
                }
            }
            linkedList3.add(erw);
        }
        Log.i("MicroMsg.Multitalk.ILinkCGIImp", "invite member cnt:%d", Integer.valueOf(linkedList3.size()));
        eru.Npn = linkedList3;
        eru.Npl = linkedList;
        AppMethodBeat.o(239035);
        return aXF;
    }

    public static d a(String str, String str2, eri eri) {
        AppMethodBeat.i(239036);
        d.a aVar = new d.a();
        aVar.iLN = new esa();
        aVar.iLO = new esb();
        aVar.funcId = 3878;
        aVar.uri = "/cgi-bin/micromsg-bin/voipmtsendbannermsg";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        esc esc = new esc();
        esc.username = str2;
        esc.Npd = null;
        d aXF = aVar.aXF();
        esa esa = (esa) aXF.iLK.iLR;
        esa.Npm = esc;
        esa.NoW = str;
        try {
            esa.Npr = b.cD(eri.toByteArray());
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkCGIImp", e2, "hy: error when convert to byte array", new Object[0]);
        }
        AppMethodBeat.o(239036);
        return aXF;
    }
}
