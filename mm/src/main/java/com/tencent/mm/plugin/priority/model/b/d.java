package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    private String AYi;

    public d(String str) {
        this.AYi = str;
    }

    @Override // com.tencent.mm.plugin.priority.model.b.a
    public final String getName() {
        return "PriorityDeleteContactTask";
    }

    public final void run() {
        AppMethodBeat.i(87871);
        if (c.oR(((l) g.af(l.class)).aSN().Kn(this.AYi).field_type)) {
            Log.i("MicroMsg.Priority.PriorityDeleteContactTask", "%s is Contact", this.AYi);
            AppMethodBeat.o(87871);
            return;
        }
        com.tencent.mm.plugin.priority.model.a.c.c c2CMsgAutoDownloadImgStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage();
        String str = this.AYi;
        c2CMsgAutoDownloadImgStorage.AYH.bindString(1, str);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadImgStorage", "delete %d img %s", Integer.valueOf(c2CMsgAutoDownloadImgStorage.AYG.executeUpdateDelete()), str);
        ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().aKf(this.AYi);
        com.tencent.mm.plugin.priority.model.a.b.c c2CMsgAutoDownloadFileStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadFileStorage();
        String str2 = this.AYi;
        c2CMsgAutoDownloadFileStorage.AYH.bindString(1, str2);
        Log.i("MicroMsg.Priority.C2CMsgAutoDownloadFileStorage", "delete %d file %s", Integer.valueOf(c2CMsgAutoDownloadFileStorage.AYG.executeUpdateDelete()), str2);
        ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgFileUsageStorage().aKf(this.AYi);
        b c2CChatUsageResultStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageResultStorage();
        String str3 = this.AYi;
        String format = String.format("DELETE FROM %s WHERE chat = ?", "C2CChatUsageResult");
        c2CChatUsageResultStorage.AXQ.execSQL(format, new String[]{str3});
        com.tencent.mm.plugin.priority.model.a.a.c c2CChatUsageStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageStorage();
        String str4 = this.AYi;
        String format2 = String.format("DELETE FROM %s WHERE chat = ?", "C2CChatUsage");
        c2CChatUsageStorage.AXQ.execSQL(format2, new String[]{str4});
        AppMethodBeat.o(87871);
    }
}
