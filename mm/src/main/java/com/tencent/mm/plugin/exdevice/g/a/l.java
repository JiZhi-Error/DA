package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l extends a<byg, byh> {
    public List<String> rCR;
    public List<String> rCS;
    public List<String> rCT;
    private final WeakReference<b<l>> rxQ = new WeakReference<>(null);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* bridge */ /* synthetic */ void i(byg byg) {
    }

    public l() {
        AppMethodBeat.i(231696);
        AppMethodBeat.o(231696);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1758;
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23531);
        Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            byh byh = (byh) cgq();
            this.rCT = new ArrayList();
            Iterator<String> it = byh.MdS.iterator();
            while (it.hasNext()) {
                String next = it.next();
                bg.aVF();
                if (c.aSN().bjG(next)) {
                    this.rCT.add(next);
                }
            }
            this.rCR = new ArrayList();
            this.rCS = new ArrayList();
            if (byh.LCY != null) {
                Iterator<bew> it2 = byh.LCY.iterator();
                while (it2.hasNext()) {
                    bew next2 = it2.next();
                    if (next2.tOS) {
                        this.rCS.add(next2.username);
                    }
                    bg.aVF();
                    if (c.aSN().bjG(next2.username)) {
                        this.rCR.add(next2.username);
                    }
                }
            }
            Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", Integer.valueOf(this.rCS.size()), this.rCS.toString());
            Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", Integer.valueOf(this.rCR.size()), this.rCR);
        }
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        if (this.rxQ != null) {
            b<l> bVar = this.rxQ.get();
            if (bVar != null) {
                Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
                bVar.a(i3, i4, str, this);
                AppMethodBeat.o(23531);
                return;
            }
            Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
        }
        AppMethodBeat.o(23531);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ byh cKd() {
        AppMethodBeat.i(23532);
        byh byh = new byh();
        AppMethodBeat.o(23532);
        return byh;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ byg cKc() {
        AppMethodBeat.i(23533);
        byg byg = new byg();
        AppMethodBeat.o(23533);
        return byg;
    }
}
