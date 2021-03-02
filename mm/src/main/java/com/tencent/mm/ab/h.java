package com.tencent.mm.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    private static e hpA;
    private static volatile int hpz = 0;
    private static volatile boolean sInitialized = false;

    public static void initialize() {
    }

    public static JSONObject FE(String str) {
        AppMethodBeat.i(158565);
        if (hpz == 1) {
            i iVar = new i(str);
            AppMethodBeat.o(158565);
            return iVar;
        }
        JSONObject jSONObject = new JSONObject(str);
        AppMethodBeat.o(158565);
        return jSONObject;
    }

    public static c ayS() {
        AppMethodBeat.i(158566);
        if (hpz == 1) {
            l lVar = new l();
            AppMethodBeat.o(158566);
            return lVar;
        }
        d dVar = new d();
        AppMethodBeat.o(158566);
        return dVar;
    }

    public static c v(Map map) {
        AppMethodBeat.i(158567);
        if (hpz == 1) {
            l lVar = new l(map);
            AppMethodBeat.o(158567);
            return lVar;
        }
        d dVar = new d(map);
        AppMethodBeat.o(158567);
        return dVar;
    }

    public static c FF(String str) {
        AppMethodBeat.i(158568);
        if (hpz == 1) {
            l lVar = new l(str);
            AppMethodBeat.o(158568);
            return lVar;
        }
        d dVar = new d(str);
        AppMethodBeat.o(158568);
        return dVar;
    }

    public static a ayT() {
        AppMethodBeat.i(158569);
        if (hpz == 1) {
            k kVar = new k();
            AppMethodBeat.o(158569);
            return kVar;
        }
        b bVar = new b();
        AppMethodBeat.o(158569);
        return bVar;
    }

    public static a FG(String str) {
        AppMethodBeat.i(158570);
        if (hpz == 1) {
            k kVar = new k(str);
            AppMethodBeat.o(158570);
            return kVar;
        }
        b bVar = new b(str);
        AppMethodBeat.o(158570);
        return bVar;
    }

    public static void qa(int i2) {
        hpz = i2;
        sInitialized = true;
    }

    public static int ayU() {
        return hpz;
    }

    public static void a(e eVar) {
        hpA = eVar;
    }
}
