package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Map<String, q> yOT = new HashMap();
    private static Map<String, dlt> yOU = new HashMap();
    private static Map<Long, dls> yOV = new HashMap();

    static {
        AppMethodBeat.i(168789);
        AppMethodBeat.o(168789);
    }

    public static void a(String str, q qVar) {
        AppMethodBeat.i(168781);
        yOT.put(str, qVar);
        AppMethodBeat.o(168781);
    }

    public static q aDn(String str) {
        AppMethodBeat.i(168782);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(168782);
            return null;
        }
        q qVar = yOT.get(str);
        AppMethodBeat.o(168782);
        return qVar;
    }

    public static void a(String str, dlt dlt) {
        AppMethodBeat.i(168783);
        yOU.put(str, dlt);
        AppMethodBeat.o(168783);
    }

    public static dlt aDo(String str) {
        AppMethodBeat.i(168784);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(168784);
            return null;
        }
        dlt dlt = yOU.get(str);
        AppMethodBeat.o(168784);
        return dlt;
    }

    public static void a(Long l, dls dls) {
        AppMethodBeat.i(168785);
        yOV.put(l, dls);
        AppMethodBeat.o(168785);
    }

    public static dls j(Long l) {
        AppMethodBeat.i(168786);
        if (l == null) {
            AppMethodBeat.o(168786);
            return null;
        }
        dls dls = yOV.get(l);
        AppMethodBeat.o(168786);
        return dls;
    }

    public static void clear() {
        AppMethodBeat.i(168787);
        yOT.clear();
        yOU.clear();
        AppMethodBeat.o(168787);
    }

    public static void ees() {
        AppMethodBeat.i(168788);
        yOV.clear();
        AppMethodBeat.o(168788);
    }
}
