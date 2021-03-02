package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j {
    public static final a sIK = new a((byte) 0);

    static {
        AppMethodBeat.i(185603);
        AppMethodBeat.o(185603);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void reset() {
            AppMethodBeat.i(185601);
            b.o("mmkv_ssionPg_matched_bckup", new byte[0]);
            AppMethodBeat.o(185601);
        }

        static cbl cQA() {
            AppMethodBeat.i(185602);
            byte[] bytes = b.getBytes("mmkv_ssionPg_matched_bckup");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    cbl cbl = new cbl();
                    try {
                        cbl.parseFrom(bytes);
                        AppMethodBeat.o(185602);
                        return cbl;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", e2, "SessionPageBackup, _read: %s", e2.getMessage());
                        AppMethodBeat.o(185602);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(185602);
            return null;
        }
    }

    public static final List<cbm> aqO(String str) {
        AppMethodBeat.i(185604);
        if (str == null) {
            AppMethodBeat.o(185604);
            return null;
        }
        cbl cQA = a.cQA();
        if (cQA == null) {
            AppMethodBeat.o(185604);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<cbm> it = cQA.Mhn.iterator();
        while (it.hasNext()) {
            cbm next = it.next();
            if (next != null && !(!p.j(str, next.dRM))) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(185604);
        return arrayList2;
    }

    public static final void akH(String str) {
        AppMethodBeat.i(185605);
        if (str == null) {
            AppMethodBeat.o(185605);
            return;
        }
        cbl cQA = a.cQA();
        if (cQA == null) {
            AppMethodBeat.o(185605);
            return;
        }
        for (int size = cQA.Mhn.size() - 1; size >= 0; size--) {
            cbm cbm = cQA.Mhn.get(size);
            if (cbm != null && !(!p.j(str, cbm.dRM))) {
                cQA.Mhn.remove(size);
            }
        }
        if (cQA == null || cQA.Mhn.isEmpty()) {
            AppMethodBeat.o(185605);
            return;
        }
        try {
            byte[] byteArray = cQA.toByteArray();
            if (byteArray != null) {
                b.o("mmkv_ssionPg_matched_bckup", byteArray);
            }
            AppMethodBeat.o(185605);
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", e2, "SessionPageBackup, _write: %s", e2.getMessage());
            AppMethodBeat.o(185605);
        }
    }
}
