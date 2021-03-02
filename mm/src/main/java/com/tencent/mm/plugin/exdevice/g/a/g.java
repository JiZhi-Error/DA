package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<db, dc> {
    List<String> oRy;
    public ArrayList<bes> rCn;
    private final WeakReference<b<g>> rxQ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ void i(db dbVar) {
        AppMethodBeat.i(23515);
        db dbVar2 = dbVar;
        for (String str : this.oRy) {
            dbVar2.jfN.add(str);
        }
        AppMethodBeat.o(23515);
    }

    public g(List<String> list, b<g> bVar) {
        AppMethodBeat.i(23513);
        this.oRy = list;
        this.rxQ = new WeakReference<>(bVar);
        AppMethodBeat.o(23513);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1777;
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        b<g> bVar;
        AppMethodBeat.i(23514);
        Log.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            dc dcVar = (dc) cgq();
            this.rCn = new ArrayList<>();
            if (dcVar.KHh != null) {
                Iterator<bes> it = dcVar.KHh.iterator();
                while (it.hasNext()) {
                    bes next = it.next();
                    Log.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", Integer.valueOf(next.index), Integer.valueOf(next.lCq), next.username);
                    this.rCn.add(next);
                }
                Log.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", this.rCn.toString(), Integer.valueOf(dcVar.KHh.size()));
            }
            ad.cKN().a(this.rCn, "hardcode_rank_id", "hardcode_app_name");
        }
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        if (!(this.rxQ == null || (bVar = this.rxQ.get()) == null)) {
            bVar.a(i3, i4, str, this);
        }
        AppMethodBeat.o(23514);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ dc cKd() {
        AppMethodBeat.i(23516);
        dc dcVar = new dc();
        AppMethodBeat.o(23516);
        return dcVar;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ db cKc() {
        AppMethodBeat.i(23517);
        db dbVar = new db();
        AppMethodBeat.o(23517);
        return dbVar;
    }
}
