package com.google.a;

public final class cj {
    static final int caA = 16;
    static final int caB = 26;
    static final int cay = 11;
    static final int caz = 12;

    public static int gX(int i2) {
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
        BYTE_STRING(g.bNg),
        ENUM(null),
        MESSAGE(null);
        
        private final Object bTf;

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
            @Override // com.google.a.cj.a
            public final boolean FL() {
                return false;
            }
        },
        GROUP {
            @Override // com.google.a.cj.a
            public final boolean FL() {
                return false;
            }
        },
        MESSAGE {
            @Override // com.google.a.cj.a
            public final boolean FL() {
                return false;
            }
        },
        BYTES {
            @Override // com.google.a.cj.a
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
        
        final b caU;
        final int caV;

        /* synthetic */ a(b bVar, int i2, byte b2) {
            this(bVar, i2);
        }

        private a(b bVar, int i2) {
            this.caU = bVar;
            this.caV = i2;
        }

        public boolean FL() {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public enum c {
        LOOSE {
            /* access modifiers changed from: package-private */
            @Override // com.google.a.cj.c
            public final Object d(h hVar) {
                return hVar.readString();
            }
        },
        STRICT {
            /* access modifiers changed from: package-private */
            @Override // com.google.a.cj.c
            public final Object d(h hVar) {
                return hVar.za();
            }
        },
        LAZY {
            /* access modifiers changed from: package-private */
            @Override // com.google.a.cj.c
            public final Object d(h hVar) {
                return hVar.zb();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Object d(h hVar);

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static Object a(h hVar, a aVar, c cVar) {
        switch (aVar) {
            case DOUBLE:
                return Double.valueOf(hVar.readDouble());
            case FLOAT:
                return Float.valueOf(hVar.readFloat());
            case INT64:
                return Long.valueOf(hVar.yV());
            case UINT64:
                return Long.valueOf(hVar.yU());
            case INT32:
                return Integer.valueOf(hVar.yW());
            case FIXED64:
                return Long.valueOf(hVar.yX());
            case FIXED32:
                return Integer.valueOf(hVar.yY());
            case BOOL:
                return Boolean.valueOf(hVar.yZ());
            case BYTES:
                return hVar.zb();
            case UINT32:
                return Integer.valueOf(hVar.zc());
            case SFIXED32:
                return Integer.valueOf(hVar.ze());
            case SFIXED64:
                return Long.valueOf(hVar.zf());
            case SINT32:
                return Integer.valueOf(hVar.zg());
            case SINT64:
                return Long.valueOf(hVar.zh());
            case STRING:
                return cVar.d(hVar);
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
