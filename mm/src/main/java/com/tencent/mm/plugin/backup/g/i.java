package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends b {
    private com.tencent.mm.plugin.backup.i.i oQc = new com.tencent.mm.plugin.backup.i.i();
    public j oQd = new j();

    public i(LinkedList<String> linkedList, long j2, long j3) {
        AppMethodBeat.i(21733);
        Log.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(linkedList.size()), Long.valueOf(j2), Long.valueOf(j3));
        this.oQc.oTB = linkedList;
        this.oQc.oTC = new LinkedList<>();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.oQc.oTC.add(Long.valueOf(j2));
            this.oQc.oTC.add(Long.valueOf(j3));
        }
        AppMethodBeat.o(21733);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 11;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgq() {
        return this.oQd;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgr() {
        return this.oQc;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21734);
        if (this.oQd.oTB == null || this.oQd.oTC == null || this.oQd.oTB.isEmpty() || this.oQd.oTB.size() * 2 != this.oQd.oTC.size()) {
            if (!(this.oQd.oTB == null || this.oQd.oTC == null)) {
                Log.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", Integer.valueOf(this.oQd.oTB.size()), Integer.valueOf(this.oQd.oTC.size()));
            }
            q(4, -1, "BackupRequestSession failed");
            AppMethodBeat.o(21734);
            return;
        }
        Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", Integer.valueOf(this.oQd.oTB.size()), this.oQd.oTB.toString());
        Log.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", this.oQd.oTC.toString());
        q(0, 0, "BackupRequestSession success");
        AppMethodBeat.o(21734);
    }
}
