package com.tencent.luggage.sdk.launching;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum b {
    LEGACY,
    PRE_RENDER;

    public static b valueOf(String str) {
        AppMethodBeat.i(229865);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(229865);
        return bVar;
    }

    static {
        AppMethodBeat.i(229869);
        AppMethodBeat.o(229869);
    }

    public final long OC() {
        AppMethodBeat.i(229866);
        long ordinal = (long) ordinal();
        AppMethodBeat.o(229866);
        return ordinal;
    }

    public static void a(b bVar, Parcel parcel) {
        AppMethodBeat.i(229867);
        parcel.writeInt(bVar.ordinal());
        AppMethodBeat.o(229867);
    }

    public static b b(Parcel parcel) {
        AppMethodBeat.i(229868);
        int readInt = parcel.readInt();
        b[] values = values();
        for (b bVar : values) {
            if (readInt == bVar.ordinal()) {
                AppMethodBeat.o(229868);
                return bVar;
            }
        }
        Log.e("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", Integer.valueOf(readInt));
        b bVar2 = LEGACY;
        AppMethodBeat.o(229868);
        return bVar2;
    }
}
