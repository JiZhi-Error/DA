package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f {
    public static final a sIa = new a((byte) 0);

    static {
        AppMethodBeat.i(185597);
        AppMethodBeat.o(185597);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0012\u001a\u00020\tH\u0007J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void ad(LinkedList<bgb> linkedList) {
            AppMethodBeat.i(185591);
            p.h(linkedList, "paths");
            b.a aVar = b.sIy;
            if (b.a.cPX()) {
                Log.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
                AppMethodBeat.o(185591);
                return;
            }
            Log.i("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report: " + linkedList.size());
            bfy cPE = cPE();
            if (cPE == null) {
                cPE = new bfy();
            }
            cPE.LPC.addAll(linkedList);
            a(cPE);
            AppMethodBeat.o(185591);
        }

        public static dve aqh(String str) {
            AppMethodBeat.i(185592);
            if (str == null) {
                AppMethodBeat.o(185592);
                return null;
            }
            bfy cPE = cPE();
            if (cPE == null) {
                AppMethodBeat.o(185592);
                return null;
            }
            dve dve = new dve();
            dve.dRM = str;
            Iterator<bgb> it = cPE.LPC.iterator();
            while (it.hasNext()) {
                bgb next = it.next();
                if (next != null && !(!p.j(str, next.dRM))) {
                    dve.LPC.add(next);
                }
            }
            AppMethodBeat.o(185592);
            return dve;
        }

        public static void reset() {
            AppMethodBeat.i(185593);
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", new byte[0]);
            AppMethodBeat.o(185593);
        }

        public static void akH(String str) {
            AppMethodBeat.i(185594);
            if (str == null) {
                AppMethodBeat.o(185594);
                return;
            }
            bfy cPE = cPE();
            if (cPE == null) {
                AppMethodBeat.o(185594);
                return;
            }
            for (int size = cPE.LPC.size() - 1; size >= 0; size--) {
                bgb bgb = cPE.LPC.get(size);
                if (bgb != null && !(!p.j(str, bgb.dRM))) {
                    cPE.LPC.remove(size);
                }
            }
            a(cPE);
            AppMethodBeat.o(185594);
        }

        private static void a(bfy bfy) {
            AppMethodBeat.i(185595);
            if (bfy == null || bfy.LPC.isEmpty()) {
                AppMethodBeat.o(185595);
                return;
            }
            try {
                byte[] byteArray = bfy.toByteArray();
                if (byteArray == null) {
                    AppMethodBeat.o(185595);
                    return;
                }
                com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", byteArray);
                AppMethodBeat.o(185595);
            } catch (IOException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", e2, "FuzzyMatchedBackup, _write: %s", e2.getMessage());
                AppMethodBeat.o(185595);
            }
        }

        private static bfy cPE() {
            AppMethodBeat.i(185596);
            byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_fuzzy_matched_bckup");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    bfy bfy = new bfy();
                    try {
                        bfy.parseFrom(bytes);
                        AppMethodBeat.o(185596);
                        return bfy;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", e2, "FuzzyMatchedBackup, _read: %s", e2.getMessage());
                        AppMethodBeat.o(185596);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(185596);
            return null;
        }
    }
}
