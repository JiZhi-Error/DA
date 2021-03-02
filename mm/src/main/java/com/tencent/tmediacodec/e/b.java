package com.tencent.tmediacodec.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final b SmK = new b();
    public boolean SmG = true;
    public int SmH = 1920;
    public int SmI = 1920;
    public a SmJ = a.First;

    static {
        AppMethodBeat.i(190176);
        AppMethodBeat.o(190176);
    }

    private b() {
    }

    public final String toString() {
        AppMethodBeat.i(190175);
        String str = "[initWidth:" + this.SmH + ", initHeight:" + this.SmI + ", reConfigByRealFormat:" + this.SmG + ']';
        AppMethodBeat.o(190175);
        return str;
    }

    public enum a {
        First,
        SAME;

        public static a valueOf(String str) {
            AppMethodBeat.i(190173);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(190173);
            return aVar;
        }

        static {
            AppMethodBeat.i(190174);
            AppMethodBeat.o(190174);
        }
    }
}
