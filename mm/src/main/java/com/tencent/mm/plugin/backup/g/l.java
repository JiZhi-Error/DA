package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;

public final class l extends b {
    private af oQq = new af();
    private ag oQr = new ag();
    private a oQs;

    public interface a {
        void E(LinkedList<Long> linkedList);
    }

    public l(String str, HashMap<Long, h.a> hashMap, a aVar) {
        AppMethodBeat.i(21740);
        this.oQs = aVar;
        this.oQq.oTx = str;
        Log.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", str);
        this.oQq.oUR = new LinkedList<>();
        this.oQq.oUS = new LinkedList<>();
        this.oQq.oUT = new LinkedList<>();
        for (Long l : hashMap.keySet()) {
            h.a aVar2 = hashMap.get(l);
            this.oQq.oUR.add(Long.valueOf(aVar2.oNJ));
            this.oQq.oUS.add(aVar2.oNK);
            this.oQq.oUT.add(aVar2.md5);
        }
        AppMethodBeat.o(21740);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 13;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgq() {
        return this.oQr;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgr() {
        return this.oQq;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21741);
        Log.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        q(0, 0, "success");
        this.oQs.E(this.oQr.oUR);
        AppMethodBeat.o(21741);
    }
}
