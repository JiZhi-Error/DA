package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class m {
    public static final a sIM = new a((byte) 0);

    static {
        AppMethodBeat.i(185607);
        AppMethodBeat.o(185607);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", SharePluginInfo.ISSUE_KEY_TABLE, "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static dvn cQG() {
            AppMethodBeat.i(185606);
            byte[] bytes = b.getBytes("mmkv_sionId_table_hell");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    dvn dvn = new dvn();
                    try {
                        dvn.parseFrom(bytes);
                        AppMethodBeat.o(185606);
                        return dvn;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", e2, "SessionTable, _read: %s", e2.getMessage());
                        AppMethodBeat.o(185606);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(185606);
            return null;
        }
    }

    public static final void add(String str) {
        AppMethodBeat.i(185608);
        if (str == null) {
            AppMethodBeat.o(185608);
            return;
        }
        dvn cQG = a.cQG();
        if (cQG == null) {
            cQG = new dvn();
        }
        if (cQG.Mhr.size() > 100) {
            cQG.Mhr.removeFirst();
        }
        cQG.Mhr.addLast(str);
        if (cQG == null || cQG.Mhr.isEmpty()) {
            AppMethodBeat.o(185608);
            return;
        }
        try {
            byte[] byteArray = cQG.toByteArray();
            if (byteArray != null) {
                b.o("mmkv_sionId_table_hell", byteArray);
            }
            AppMethodBeat.o(185608);
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", e2, "SessionTable, _write: %s", e2.getMessage());
            AppMethodBeat.o(185608);
        }
    }

    public static final dvn cQF() {
        AppMethodBeat.i(185609);
        dvn cQG = a.cQG();
        AppMethodBeat.o(185609);
        return cQG;
    }

    public static final String cPR() {
        AppMethodBeat.i(221131);
        dvn cQG = a.cQG();
        if (cQG == null) {
            AppMethodBeat.o(221131);
            return null;
        } else if (cQG.Mhr.isEmpty()) {
            AppMethodBeat.o(221131);
            return null;
        } else {
            LinkedList<String> linkedList = cQG.Mhr;
            p.g(linkedList, "table.sessions");
            String last = linkedList.getLast();
            AppMethodBeat.o(221131);
            return last;
        }
    }

    public static final void reset() {
        AppMethodBeat.i(185610);
        b.o("mmkv_sionId_table_hell", new byte[0]);
        AppMethodBeat.o(185610);
    }
}
