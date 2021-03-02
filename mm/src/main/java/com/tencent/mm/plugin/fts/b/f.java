package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.TimeUtil;

public final class f implements au {
    @Override // com.tencent.mm.model.au
    public final void Ab(long j2) {
        AppMethodBeat.i(52764);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(52764);
            throw bVar;
        }
        try {
            d fTSIndexDB = ((PluginFTS) g.ah(PluginFTS.class)).getFTSIndexDB();
            if (fTSIndexDB != null) {
                fTSIndexDB.deleteMsgById(j2);
                AppMethodBeat.o(52764);
                return;
            }
            ((PluginFTS) g.ah(PluginFTS.class)).getFTSTaskDaemon().a(65536, new b(j2));
            Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteSingleMsg post task to fts task daemon %d", Long.valueOf(j2));
            AppMethodBeat.o(52764);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e2, "syncDeleteSingleMsg", new Object[0]);
            AppMethodBeat.o(52764);
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private long msgId;

        b(long j2) {
            this.msgId = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52762);
            d fTSIndexDB = ((PluginFTS) g.ah(PluginFTS.class)).getFTSIndexDB();
            if (fTSIndexDB != null) {
                fTSIndexDB.deleteMsgById(this.msgId);
            }
            AppMethodBeat.o(52762);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTSDeleteMsgLogic.DeleteSingleMsgTask";
        }
    }

    @Override // com.tencent.mm.model.au
    public final void A(String str, long j2) {
        AppMethodBeat.i(52765);
        Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete fts talker msg %s %s", str, com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, j2 / 1000));
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(52765);
            throw bVar;
        }
        try {
            d fTSIndexDB = ((PluginFTS) g.ah(PluginFTS.class)).getFTSIndexDB();
            if (fTSIndexDB != null) {
                fTSIndexDB.au(str, j2);
                AppMethodBeat.o(52765);
                return;
            }
            ((PluginFTS) g.ah(PluginFTS.class)).getFTSTaskDaemon().a(65536, new c(str, j2));
            Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteTalkerMsg post task to fts task daemon %s %s", str, Long.valueOf(j2));
            AppMethodBeat.o(52765);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.FTSDeleteMsgLogic", e2, "syncDeleteTalkerMsg", new Object[0]);
            AppMethodBeat.o(52765);
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private String talker;
        private long wZu;

        c(String str, long j2) {
            this.talker = str;
            this.wZu = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52763);
            d fTSIndexDB = ((PluginFTS) g.ah(PluginFTS.class)).getFTSIndexDB();
            if (fTSIndexDB != null) {
                fTSIndexDB.au(this.talker, this.wZu);
            }
            AppMethodBeat.o(52763);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTSDeleteMsgLogic.DeleteTalkerMsgByTimestamp";
        }
    }

    @Override // com.tencent.mm.model.au
    public final void aVn() {
        AppMethodBeat.i(176905);
        Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "start to delete all msg");
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(176905);
            throw bVar;
        }
        ((PluginFTS) g.ah(PluginFTS.class)).getFTSTaskDaemon().a(-131072, new a(this, (byte) 0));
        Log.i("MicroMsg.FTS.FTSDeleteMsgLogic", "syncDeleteAllMsg post task to fts task daemon");
        AppMethodBeat.o(176905);
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(176904);
            d fTSIndexDB = ((PluginFTS) g.ah(PluginFTS.class)).getFTSIndexDB();
            if (fTSIndexDB != null) {
                long currentTimeMillis = System.currentTimeMillis();
                fTSIndexDB.execSQL(String.format("Delete From %s;", "FTS5MetaMessage"));
                fTSIndexDB.execSQL(String.format("Delete From %s;", "FTS5IndexMessage"));
                Log.i("MicroMsg.FTS.FTSIndexDB", "deleteAllMsg use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(176904);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "FTSDeleteMsgLogic.DeleteAllMsgTask";
        }
    }
}
