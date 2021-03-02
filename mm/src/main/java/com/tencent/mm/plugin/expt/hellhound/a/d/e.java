package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.d;
import com.tencent.mm.plugin.expt.hellhound.a.d.f;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class e {
    public static final a sHZ = new a((byte) 0);

    static {
        AppMethodBeat.i(122587);
        AppMethodBeat.o(122587);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\tH\u0007J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", AppMeasurement.Param.TIMESTAMP, "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void Dq(long j2) {
            AppMethodBeat.i(184281);
            d.a aVar = d.sHY;
            bfz cPD = d.a.cPD();
            if (cPD == null) {
                AppMethodBeat.o(184281);
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (int size = cPD.LPD.size() - 1; size >= 0; size--) {
                dve dve = cPD.LPD.get(size);
                for (int size2 = dve.LPC.size() - 1; size2 >= 0; size2--) {
                    bgb bgb = dve.LPC.get(size2);
                    p.g(bgb, "sessionFuzzyPath.paths[j]");
                    bgb bgb2 = bgb;
                    if (bgb2.LPL) {
                        a(bgb2, j2);
                    } else {
                        linkedList.addLast(bgb2);
                        dve.LPC.remove(size2);
                    }
                }
                if (dve.LPC.isEmpty()) {
                    cPD.LPD.remove(size);
                }
            }
            d.a aVar2 = d.sHY;
            d.a.a(cPD);
            if (!linkedList.isEmpty()) {
                ac(linkedList);
                f.a aVar3 = f.sIa;
                f.a.ad(linkedList);
            }
            AppMethodBeat.o(184281);
        }

        private static void ac(LinkedList<bgb> linkedList) {
            AppMethodBeat.i(169401);
            b.a aVar = b.sIy;
            if (b.a.cPX()) {
                AppMethodBeat.o(169401);
                return;
            }
            bfy cPE = cPE();
            if (cPE == null) {
                cPE = new bfy();
            }
            cPE.LPC.addAll(linkedList);
            a(cPE);
            AppMethodBeat.o(169401);
        }

        private static void a(bfy bfy) {
            AppMethodBeat.i(122584);
            if (bfy == null || bfy.LPC.isEmpty()) {
                AppMethodBeat.o(122584);
                return;
            }
            try {
                byte[] byteArray = bfy.toByteArray();
                if (byteArray == null) {
                    AppMethodBeat.o(122584);
                    return;
                }
                com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", byteArray);
                AppMethodBeat.o(122584);
            } catch (IOException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", e2, "FuzzyMatchReport, _write: %s", e2.getMessage());
                AppMethodBeat.o(122584);
            }
        }

        static bfy cPE() {
            AppMethodBeat.i(122585);
            byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_fuzzy_mc_rpt");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    bfy bfy = new bfy();
                    try {
                        bfy.parseFrom(bytes);
                        AppMethodBeat.o(122585);
                        return bfy;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", e2, "FuzzyMatchReport, _read: %s", e2.getMessage());
                        AppMethodBeat.o(122585);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(122585);
            return null;
        }

        public static void a(bgb bgb, long j2) {
            AppMethodBeat.i(122586);
            if (bgb == null) {
                AppMethodBeat.o(122586);
            } else if (bgb.LPK.isEmpty()) {
                AppMethodBeat.o(122586);
            } else {
                LinkedList<bga> linkedList = bgb.LPK;
                p.g(linkedList, "fuzzyPath.pages");
                bga last = linkedList.getLast();
                long j3 = j2 - last.startTime;
                if (j3 < 0) {
                    j3 = 0;
                }
                last.LPF = j3;
                if (bgb.LPK.size() == 1) {
                    AppMethodBeat.o(122586);
                    return;
                }
                for (int size = bgb.LPK.size() - 1; size > 0; size--) {
                    bga bga = bgb.LPK.get(size - 1);
                    p.g(bga, "fuzzyPath.pages[i - 1]");
                    bga bga2 = bga;
                    if (bga2.LPF <= 0) {
                        long j4 = bgb.LPK.get(size).startTime - bga2.startTime;
                        if (j4 < 0) {
                            j4 = 0;
                        }
                        bga2.LPF = j4;
                    }
                }
                AppMethodBeat.o(122586);
            }
        }
    }
}
