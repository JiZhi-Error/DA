package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d extends b {
    private i gNh;
    private z oPH = new z();
    public aa oPI = new aa();

    public d(String str, long j2, long j3, String str2, String str3, LinkedList<String> linkedList, i iVar) {
        AppMethodBeat.i(21714);
        Log.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(linkedList.size()));
        this.oPH.oTx = str;
        this.oPH.oUG = j2;
        this.oPH.oUH = j3;
        this.oPH.oUI = str2;
        this.oPH.oUJ = str3;
        this.oPH.oUn = linkedList;
        this.gNh = iVar;
        AppMethodBeat.o(21714);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final boolean cgA() {
        AppMethodBeat.i(21715);
        boolean cgB = super.cgB();
        if (!cgB) {
            this.gNh.onSceneEnd(1, -2, "doScene failed", this);
        }
        AppMethodBeat.o(21715);
        return cgB;
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 15;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgq() {
        return this.oPI;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgr() {
        return this.oPH;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21716);
        Log.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        q(0, 0, "success");
        this.gNh.onSceneEnd(0, 0, "", this);
        AppMethodBeat.o(21716);
    }
}
