package com.tencent.mm.plugin.priority.model.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a {

    /* renamed from: com.tencent.mm.plugin.priority.model.a.a.a$a  reason: collision with other inner class name */
    public class C1577a extends com.tencent.mm.plugin.priority.model.b.a {
        private String AYi;
        private int chatType;
        private long dUy;
        private int score;
        private int type;

        public C1577a(String str, int i2) {
            this.AYi = str;
            this.type = i2;
        }

        public C1577a(String str, int i2, byte b2) {
            this.AYi = str;
            this.type = 2;
            this.score = i2;
        }

        public C1577a(String str, long j2) {
            AppMethodBeat.i(174313);
            this.AYi = str;
            this.type = 0;
            this.score = this.score;
            this.dUy = j2;
            AppMethodBeat.o(174313);
        }

        @Override // com.tencent.mm.plugin.priority.model.b.a
        public final String getName() {
            AppMethodBeat.i(87818);
            String format = String.format("Priority.UpdateTask[%s][%d][%d][%d][%d]", this.AYi, Integer.valueOf(this.type), Long.valueOf(this.dUy), Integer.valueOf(this.chatType), Integer.valueOf(this.score));
            AppMethodBeat.o(87818);
            return format;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void run() {
            boolean z;
            AppMethodBeat.i(87819);
            String str = this.AYi;
            if (Util.isNullOrNil(str)) {
                z = false;
            } else if (str.endsWith("@stranger")) {
                z = false;
            } else if (str.endsWith("@qqim")) {
                z = false;
            } else if (str.endsWith("@app")) {
                z = false;
            } else if (str.startsWith("fake_")) {
                z = false;
            } else if (ab.IT(this.AYi)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Log.i("MicroMsg.Priority.C2CChatUsageLogic", "filterByUsername %s", this.AYi);
                AppMethodBeat.o(87819);
            } else if (((l) g.af(l.class)).aSN().Kn(this.AYi).isHidden()) {
                Log.i("MicroMsg.Priority.C2CChatUsageLogic", "Hidden %s", this.AYi);
                AppMethodBeat.o(87819);
            } else {
                if (ab.Eq(this.AYi)) {
                    this.chatType = 2;
                } else {
                    this.chatType = 3;
                }
                switch (this.type) {
                    case 0:
                        c c2CChatUsageStorage = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageStorage();
                        String str2 = this.AYi;
                        long j2 = this.dUy;
                        long j3 = (long) this.chatType;
                        long eCQ = com.tencent.mm.plugin.priority.a.a.a.eCQ();
                        boolean K = c2CChatUsageStorage.K(str2, eCQ, j3);
                        c2CChatUsageStorage.AYy.bindLong(1, j2);
                        c2CChatUsageStorage.AYy.bindString(2, str2);
                        c2CChatUsageStorage.AYy.bindLong(3, eCQ);
                        Log.i("MicroMsg.Priority.C2CChatUsageStorage", "updateOpen chat %s insert %b update %b", str2, Boolean.valueOf(K), Integer.valueOf(c2CChatUsageStorage.AYy.executeUpdateDelete()));
                        AppMethodBeat.o(87819);
                        return;
                    case 1:
                        c c2CChatUsageStorage2 = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageStorage();
                        String str3 = this.AYi;
                        long j4 = (long) this.chatType;
                        SQLiteStatement sQLiteStatement = c2CChatUsageStorage2.AYz;
                        long eCQ2 = com.tencent.mm.plugin.priority.a.a.a.eCQ();
                        boolean K2 = c2CChatUsageStorage2.K(str3, eCQ2, j4);
                        sQLiteStatement.bindString(1, str3);
                        sQLiteStatement.bindLong(2, eCQ2);
                        Log.i("MicroMsg.Priority.C2CChatUsageStorage", "%s chat %s insert %b update %b", "updateSendMsg", str3, Boolean.valueOf(K2), Integer.valueOf(sQLiteStatement.executeUpdateDelete()));
                        AppMethodBeat.o(87819);
                        return;
                    case 2:
                        c c2CChatUsageStorage3 = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageStorage();
                        String str4 = this.AYi;
                        c2CChatUsageStorage3.AXQ.execSQL(String.format("UPDATE %s SET consumemsgcount = consumemsgcount + %d WHERE chat = ? AND date = ?", "C2CChatUsage", Integer.valueOf(this.score)), new String[]{str4, String.valueOf((long) this.chatType)});
                        AppMethodBeat.o(87819);
                        return;
                    case 3:
                        ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageStorage().K(this.AYi, com.tencent.mm.plugin.priority.a.a.a.eCQ(), (long) this.chatType);
                        break;
                }
                AppMethodBeat.o(87819);
            }
        }
    }
}
