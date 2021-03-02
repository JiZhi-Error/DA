package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z {
    static final int caA = 16;
    static final int caB = 26;
    static final int cay = 11;
    static final int caz = 12;

    static int gX(int i2) {
        return i2 & 7;
    }

    public static int gY(int i2) {
        return i2 >>> 3;
    }

    static int bA(int i2, int i3) {
        return (i2 << 3) | i3;
    }

    public enum b {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(d.TDp),
        ENUM(null),
        MESSAGE(null);
        
        private final Object bTf;

        public static b valueOf(String str) {
            AppMethodBeat.i(59643);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(59643);
            return bVar;
        }

        static {
            AppMethodBeat.i(59644);
            AppMethodBeat.o(59644);
        }

        private b(Object obj) {
            this.bTf = obj;
        }
    }

    public enum a {
        DOUBLE(b.DOUBLE, 1),
        FLOAT(b.FLOAT, 5),
        INT64(b.LONG, 0),
        UINT64(b.LONG, 0),
        INT32(b.INT, 0),
        FIXED64(b.LONG, 1),
        FIXED32(b.INT, 5),
        BOOL(b.BOOLEAN, 0),
        STRING {
            @Override // kotlin.l.b.a.b.h.z.a
            public final boolean FL() {
                return false;
            }
        },
        GROUP {
            @Override // kotlin.l.b.a.b.h.z.a
            public final boolean FL() {
                return false;
            }
        },
        MESSAGE {
            @Override // kotlin.l.b.a.b.h.z.a
            public final boolean FL() {
                return false;
            }
        },
        BYTES {
            @Override // kotlin.l.b.a.b.h.z.a
            public final boolean FL() {
                return false;
            }
        },
        UINT32(b.INT, 0),
        ENUM(b.ENUM, 0),
        SFIXED32(b.INT, 5),
        SFIXED64(b.LONG, 1),
        SINT32(b.INT, 0),
        SINT64(b.LONG, 0);
        
        final b TEG;
        final int caV;

        /* synthetic */ a(b bVar, int i2, byte b2) {
            this(bVar, i2);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(59640);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(59640);
            return aVar;
        }

        static {
            AppMethodBeat.i(59641);
            AppMethodBeat.o(59641);
        }

        private a(b bVar, int i2) {
            this.TEG = bVar;
            this.caV = i2;
        }

        public boolean FL() {
            return true;
        }
    }
}
