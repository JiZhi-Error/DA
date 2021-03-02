package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    static void Hq(int i2) {
        AppMethodBeat.i(220598);
        ben cQO = cQO();
        if (cQO == null) {
            cQO = new ben();
        }
        cQO.type = i2;
        a(cQO);
        AppMethodBeat.o(220598);
    }

    static int getMethod() {
        AppMethodBeat.i(220599);
        ben cQO = cQO();
        if (cQO == null) {
            AppMethodBeat.o(220599);
            return -1;
        }
        int i2 = cQO.type;
        AppMethodBeat.o(220599);
        return i2;
    }

    public static void b(cbm cbm) {
        AppMethodBeat.i(122279);
        if (cbm == null) {
            AppMethodBeat.o(122279);
            return;
        }
        ben cQO = cQO();
        if (cQO == null) {
            cQO = new ben();
        }
        cQO.LOl = new cbm();
        cQO.LOl.dMl = cbm.dMl;
        cQO.LOl.dRM = cbm.dRM;
        cQO.LOl.aHK = cbm.aHK;
        a(cQO);
        AppMethodBeat.o(122279);
    }

    public static cbm cQL() {
        AppMethodBeat.i(122280);
        ben cQO = cQO();
        if (cQO == null) {
            AppMethodBeat.o(122280);
            return null;
        }
        cbm cbm = cQO.LOl;
        AppMethodBeat.o(122280);
        return cbm;
    }

    public static void mk(boolean z) {
        AppMethodBeat.i(122281);
        ben cQO = cQO();
        if (cQO == null) {
            cQO = new ben();
        }
        cQO.LOo = z;
        a(cQO);
        Log.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", Boolean.valueOf(z));
        AppMethodBeat.o(122281);
    }

    public static void fN(int i2, int i3) {
        AppMethodBeat.i(122283);
        ben cQO = cQO();
        if (cQO == null) {
            cQO = new ben();
        }
        if (i2 != -1) {
            cQO.LOm = i2;
        }
        if (i3 != -1) {
            cQO.LOn = i3;
        }
        a(cQO);
        AppMethodBeat.o(122283);
    }

    public static int cQM() {
        AppMethodBeat.i(184390);
        ben cQO = cQO();
        if (cQO == null) {
            AppMethodBeat.o(184390);
            return 8;
        }
        int i2 = cQO.LOp;
        AppMethodBeat.o(184390);
        return i2;
    }

    public static Pair<Integer, Integer> cQN() {
        AppMethodBeat.i(122284);
        ben cQO = cQO();
        if (cQO == null) {
            AppMethodBeat.o(122284);
            return null;
        }
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf(cQO.LOm), Integer.valueOf(cQO.LOn));
        AppMethodBeat.o(122284);
        return create;
    }

    public static void a(ben ben) {
        AppMethodBeat.i(122285);
        if (ben == null) {
            AppMethodBeat.o(122285);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_floatS", ben.toByteArray());
            AppMethodBeat.o(122285);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", e2, "FloatSessionDao._writeBack: %s", e2.getMessage());
            AppMethodBeat.o(122285);
        }
    }

    public static ben cQO() {
        AppMethodBeat.i(122286);
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_floatS");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(122286);
            return null;
        }
        ben ben = new ben();
        try {
            ben.parseFrom(bytes);
            AppMethodBeat.o(122286);
            return ben;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", e2, "FloatSessionDao._read: %s", e2.getMessage());
            AppMethodBeat.o(122286);
            return null;
        }
    }
}
