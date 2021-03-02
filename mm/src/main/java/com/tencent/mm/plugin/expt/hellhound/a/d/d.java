package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d {
    public static final a sHY = new a((byte) 0);

    static {
        AppMethodBeat.i(122581);
        AppMethodBeat.o(122581);
    }

    public static final void a(bfz bfz) {
        AppMethodBeat.i(161614);
        a.a(bfz);
        AppMethodBeat.o(161614);
    }

    public static final bfz cPD() {
        AppMethodBeat.i(161613);
        bfz cPD = a.cPD();
        AppMethodBeat.o(161613);
        return cPD;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J*\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0018\u001a\u00020\tH\u0007J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0007J$\u0010\u001d\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u0010H\u0007J\u0012\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0007J\u001a\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", FirebaseAnalytics.b.INDEX, "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static dve aqf(String str) {
            AppMethodBeat.i(122578);
            if (str == null) {
                AppMethodBeat.o(122578);
                return null;
            }
            bfz cPD = cPD();
            if (cPD == null) {
                AppMethodBeat.o(122578);
                return null;
            }
            for (int size = cPD.LPD.size() - 1; size >= 0; size--) {
                dve dve = cPD.LPD.get(size);
                if (!(!p.j(str, dve.dRM))) {
                    AppMethodBeat.o(122578);
                    return dve;
                }
            }
            AppMethodBeat.o(122578);
            return null;
        }

        public static Pair<dve, Integer> aqg(String str) {
            bfz bfz;
            AppMethodBeat.i(169396);
            p.h(str, "sessionId");
            bfz cPD = cPD();
            if (cPD == null) {
                bfz = new bfz();
            } else {
                bfz = cPD;
            }
            for (int size = bfz.LPD.size() - 1; size >= 0; size--) {
                dve dve = bfz.LPD.get(size);
                p.g(dve, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
                dve dve2 = dve;
                if (p.j(str, dve2.dRM)) {
                    Pair<dve, Integer> create = Pair.create(dve2, Integer.valueOf(size));
                    p.g(create, "Pair.create(tmpSessionPath, i)");
                    AppMethodBeat.o(169396);
                    return create;
                }
            }
            dve dve3 = new dve();
            bfz.LPD.addLast(dve3);
            a(bfz);
            Pair<dve, Integer> create2 = Pair.create(dve3, Integer.valueOf(bfz.LPD.size() - 1));
            p.g(create2, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
            AppMethodBeat.o(169396);
            return create2;
        }

        public static void a(dve dve) {
            boolean z;
            bfz bfz;
            AppMethodBeat.i(122579);
            if (dve == null) {
                AppMethodBeat.o(122579);
                return;
            }
            bfz cPD = cPD();
            if (cPD == null) {
                bfz = new bfz();
                Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, addNew: " + dve.dRM);
                bfz.LPD.addLast(dve);
            } else {
                int size = cPD.LPD.size() - 1;
                while (true) {
                    if (size >= 0) {
                        dve dve2 = cPD.LPD.get(size);
                        if (dve2 != null && p.j(dve2.dRM, dve.dRM)) {
                            cPD.LPD.set(size, dve);
                            z = true;
                            break;
                        }
                        size--;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, add: " + dve.dRM);
                    cPD.LPD.addLast(dve);
                }
                bfz = cPD;
            }
            a(bfz);
            AppMethodBeat.o(122579);
        }

        public static void b(dve dve, int i2) {
            AppMethodBeat.i(169397);
            if (dve == null) {
                AppMethodBeat.o(169397);
                return;
            }
            bfz cPD = cPD();
            if (cPD == null) {
                cPD = new bfz();
                cPD.LPD.addLast(dve);
            } else {
                cPD.LPD.set(i2, dve);
            }
            a(cPD);
            AppMethodBeat.o(169397);
        }

        public static void a(bfz bfz) {
            AppMethodBeat.i(122580);
            if (bfz == null) {
                AppMethodBeat.o(122580);
                return;
            }
            try {
                byte[] byteArray = bfz.toByteArray();
                if (byteArray == null) {
                    AppMethodBeat.o(122580);
                    return;
                }
                b.o("mmkv_fuzzy_pgs_io", byteArray);
                AppMethodBeat.o(122580);
            } catch (IOException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", e2, "FuzzyMatchDao, setFuzzyMatchInfo: %s", e2.getMessage());
                AppMethodBeat.o(122580);
            }
        }

        public static void reset() {
            AppMethodBeat.i(169398);
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
                AppMethodBeat.o(169398);
                return;
            }
            Log.i("HABBYGE-MALI.FuzzyMatchDao", "FuzzyMatchDao, reset...");
            bfz cPD = cPD();
            if (cPD == null) {
                AppMethodBeat.o(169398);
                return;
            }
            for (int size = cPD.LPD.size() - 1; size >= 0; size--) {
                dve dve = cPD.LPD.get(size);
                if (dve == null || dve.LPC.isEmpty()) {
                    cPD.LPD.remove(size);
                } else {
                    for (int size2 = dve.LPC.size() - 1; size2 >= 0; size2--) {
                        bgb bgb = dve.LPC.get(size2);
                        p.g(bgb, "sessionPath.paths[j]");
                        bgb bgb2 = bgb;
                        if (bgb2 == null || bgb2.LPK.isEmpty() || bgb2.LPL) {
                            dve.LPC.remove(size2);
                        }
                    }
                    if (dve.LPC.isEmpty()) {
                        cPD.LPD.remove(size);
                    }
                }
            }
            a(cPD);
            AppMethodBeat.o(169398);
        }

        public static bfz cPD() {
            AppMethodBeat.i(122577);
            byte[] bytes = b.getBytes("mmkv_fuzzy_pgs_io");
            if (bytes != null) {
                if (!(bytes.length == 0)) {
                    bfz bfz = new bfz();
                    try {
                        bfz.parseFrom(bytes);
                        AppMethodBeat.o(122577);
                        return bfz;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", e2, "FuzzyMatchDao, getFuzzyMatchInfo: %s", e2.getMessage());
                        AppMethodBeat.o(122577);
                        return null;
                    }
                }
            }
            AppMethodBeat.o(122577);
            return null;
        }
    }

    public static final Pair<bgb, Integer> ah(String str, long j2) {
        AppMethodBeat.i(169399);
        dve aqf = a.aqf(str);
        if (aqf == null) {
            AppMethodBeat.o(169399);
            return null;
        }
        for (int size = aqf.LPC.size() - 1; size >= 0; size--) {
            bgb bgb = aqf.LPC.get(size);
            if (bgb.LPN == j2) {
                Pair<bgb, Integer> create = Pair.create(bgb, Integer.valueOf(size));
                AppMethodBeat.o(169399);
                return create;
            }
        }
        AppMethodBeat.o(169399);
        return null;
    }

    public static final void a(String str, bgb bgb, int i2) {
        AppMethodBeat.i(169400);
        if (str == null) {
            AppMethodBeat.o(169400);
        } else if (bgb == null) {
            AppMethodBeat.o(169400);
        } else {
            dve aqf = a.aqf(str);
            if (aqf == null) {
                AppMethodBeat.o(169400);
                return;
            }
            aqf.LPC.set(i2, bgb);
            a.a(aqf);
            AppMethodBeat.o(169400);
        }
    }
}
