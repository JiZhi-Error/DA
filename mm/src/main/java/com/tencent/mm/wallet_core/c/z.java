package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class z {
    private static boolean Rue = false;
    private static int Ruf = -1;
    private static String Rug = "";

    public static boolean hhq() {
        return Rue;
    }

    public static int hhr() {
        return Ruf;
    }

    public static String getBindCardUuid() {
        return Rug;
    }

    public static void aqh(int i2) {
        AppMethodBeat.i(72805);
        if (!Rue) {
            Rue = true;
            Ruf = i2;
            Rug = UUID.randomUUID().toString();
        }
        AppMethodBeat.o(72805);
    }

    public static void hhs() {
        Rue = false;
        Ruf = -1;
        Rug = "";
    }
}
