package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static final f aPB = new f(null, null);
    public static final f aPC = new f(a.none, null);
    public static final f aPD = new f(a.xMidYMid, b.meet);
    public static final f aPE = new f(a.xMinYMin, b.meet);
    public static final f aPF = new f(a.xMaxYMax, b.meet);
    public static final f aPG = new f(a.xMidYMin, b.meet);
    public static final f aPH = new f(a.xMidYMax, b.meet);
    public static final f aPI = new f(a.xMidYMid, b.slice);
    public static final f aPJ = new f(a.xMinYMin, b.slice);
    b aPA;
    a aPz;

    static {
        AppMethodBeat.i(206472);
        AppMethodBeat.o(206472);
    }

    public enum a {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax;

        public static a valueOf(String str) {
            AppMethodBeat.i(206465);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(206465);
            return aVar;
        }

        static {
            AppMethodBeat.i(206466);
            AppMethodBeat.o(206466);
        }
    }

    public enum b {
        meet,
        slice;

        public static b valueOf(String str) {
            AppMethodBeat.i(206468);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(206468);
            return bVar;
        }

        static {
            AppMethodBeat.i(206469);
            AppMethodBeat.o(206469);
        }
    }

    f(a aVar, b bVar) {
        this.aPz = aVar;
        this.aPA = bVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(206470);
        if (this == obj) {
            AppMethodBeat.o(206470);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(206470);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(206470);
            return false;
        } else {
            f fVar = (f) obj;
            if (this.aPz == fVar.aPz && this.aPA == fVar.aPA) {
                AppMethodBeat.o(206470);
                return true;
            }
            AppMethodBeat.o(206470);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(206471);
        String str = this.aPz + " " + this.aPA;
        AppMethodBeat.o(206471);
        return str;
    }
}
