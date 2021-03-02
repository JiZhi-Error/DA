package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends q implements m {
    private static long pnE = 0;
    private i callback;
    private d rr;

    public static boolean clP() {
        AppMethodBeat.i(5580);
        if (System.currentTimeMillis() - pnE > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(5580);
            return true;
        }
        AppMethodBeat.o(5580);
        return false;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 456;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5581);
        pnE = System.currentTimeMillis();
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new cac();
        aVar.iLO = new cad();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.funcId = 456;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5581);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5582);
        Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        if (i3 == 0 && i4 == 0) {
            cad cad = (cad) this.rr.iLL.iLR;
            if (cad.Mfx.GroupCount > 0) {
                Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", Integer.valueOf(cad.Mfx.GroupCount));
                try {
                    byte[] byteArray = cad.Mfx.toByteArray();
                    com.tencent.mm.vfs.s.f(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend", byteArray, byteArray.length);
                    Iterator<dkz> it = cad.Mfx.MOW.iterator();
                    while (it.hasNext()) {
                        Iterator<dsn> it2 = it.next().MOV.iterator();
                        while (it2.hasNext()) {
                            dsn next = it2.next();
                            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                            iVar.username = z.a(next.Lqk);
                            iVar.iKX = next.Lir;
                            iVar.iKW = next.Lis;
                            iVar.cSx = -1;
                            iVar.fuz = 3;
                            iVar.fv(true);
                            p.aYB().b(iVar);
                        }
                    }
                } catch (IOException e2) {
                    Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2, "", new Object[0]);
                }
            } else {
                com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend");
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(5582);
    }

    public static LinkedList<dkz> clQ() {
        AppMethodBeat.i(5583);
        try {
            byte[] aW = com.tencent.mm.vfs.s.aW(com.tencent.mm.kernel.g.aAh().hqG + "search_biz_recommend", 0, Integer.MAX_VALUE);
            if (aW != null) {
                dla dla = new dla();
                dla.parseFrom(aW);
                Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", Integer.valueOf(dla.GroupCount));
                LinkedList<dkz> linkedList = dla.MOW;
                AppMethodBeat.o(5583);
                return linkedList;
            }
        } catch (Exception e2) {
            Log.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e2, "", new Object[0]);
        }
        LinkedList<dkz> linkedList2 = new LinkedList<>();
        AppMethodBeat.o(5583);
        return linkedList2;
    }
}
