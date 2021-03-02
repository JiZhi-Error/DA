package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dxk;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.protocal.protobuf.zj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.List;

public final class g extends q implements m {
    private i callback;
    private d iUB;
    private List<String> jjc;
    private String jjd;
    private int type;

    public g(int i2, List<String> list, String str) {
        this.type = i2;
        this.jjc = list;
        this.jjd = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x009f A[SYNTHETIC, Splitter:B:19:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bc A[SYNTHETIC, Splitter:B:26:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aD(java.util.List<java.lang.String> r14) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsimple.g.aD(java.util.List):void");
    }

    private void aE(List<String> list) {
        AppMethodBeat.i(20605);
        zj zjVar = (zj) this.iUB.iLK.iLR;
        zjVar.oUv = 5;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            Log.i("MicroMsg.NetSceneCheckSysShare", "share text %s", str);
            int indexOf = str.indexOf("|");
            dxn dxn = new dxn();
            if (indexOf < 0 || indexOf + 1 >= str.length()) {
                dxn.Title = "";
                dxn.URL = str;
            } else {
                dxn.Title = str.substring(0, indexOf);
                dxn.URL = str.substring(indexOf + 1);
            }
            dxn.MD5 = com.tencent.xweb.util.d.getMessageDigest(dxn.URL.getBytes());
            zjVar.LkI.add(dxn);
        }
        Log.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(20605);
    }

    private void aF(List<String> list) {
        AppMethodBeat.i(20606);
        zj zjVar = (zj) this.iUB.iLK.iLR;
        zjVar.oUv = 4;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            dxk dxk = new dxk();
            o oVar = new o(str);
            dxk.FileSize = (int) oVar.length();
            dxk.MD5 = s.bhK(aa.z(oVar.mUri));
            zjVar.LkH.add(dxk);
        }
        Log.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(20606);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 837;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01d7  */
    @Override // com.tencent.mm.ak.q
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int doScene(com.tencent.mm.network.g r23, com.tencent.mm.ak.i r24) {
        /*
        // Method dump skipped, instructions count: 612
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsimple.g.doScene(com.tencent.mm.network.g, com.tencent.mm.ak.i):int");
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(20608);
        Log.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20608);
    }
}
