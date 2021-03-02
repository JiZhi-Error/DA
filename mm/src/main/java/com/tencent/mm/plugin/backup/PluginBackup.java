package com.tencent.mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public class PluginBackup extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(21164);
        if (gVar.aBb()) {
            y.b("msgsynchronize", "msgsynchronize", 2592000000L, 107);
            Log.i("VFS.Debug", "msgsynchronize FS registered");
            y.b("backupRecover", "backupRecover", 2592000000L, 99);
            Log.i("VFS.Debug", "backupRecover FS registered");
        }
        AppMethodBeat.o(21164);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(21165);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginBackup", "PluginMonitor execute PluginMonitor new BackupCore");
            pin(new com.tencent.mm.model.y(com.tencent.mm.plugin.backup.j.a.class));
        }
        AppMethodBeat.o(21165);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-backup";
    }
}
