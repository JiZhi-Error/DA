package com.google.a;

import java.lang.reflect.Type;

public enum y {
    DOUBLE(0, a.SCALAR, ag.DOUBLE),
    FLOAT(1, a.SCALAR, ag.FLOAT),
    INT64(2, a.SCALAR, ag.LONG),
    UINT64(3, a.SCALAR, ag.LONG),
    INT32(4, a.SCALAR, ag.INT),
    FIXED64(5, a.SCALAR, ag.LONG),
    FIXED32(6, a.SCALAR, ag.INT),
    BOOL(7, a.SCALAR, ag.BOOLEAN),
    STRING(8, a.SCALAR, ag.STRING),
    MESSAGE(9, a.SCALAR, ag.MESSAGE),
    BYTES(10, a.SCALAR, ag.BYTE_STRING),
    UINT32(11, a.SCALAR, ag.INT),
    ENUM(12, a.SCALAR, ag.ENUM),
    SFIXED32(13, a.SCALAR, ag.INT),
    SFIXED64(14, a.SCALAR, ag.LONG),
    SINT32(15, a.SCALAR, ag.INT),
    SINT64(16, a.SCALAR, ag.LONG),
    GROUP(17, a.SCALAR, ag.MESSAGE),
    DOUBLE_LIST(18, a.VECTOR, ag.DOUBLE),
    FLOAT_LIST(19, a.VECTOR, ag.FLOAT),
    INT64_LIST(20, a.VECTOR, ag.LONG),
    UINT64_LIST(21, a.VECTOR, ag.LONG),
    INT32_LIST(22, a.VECTOR, ag.INT),
    FIXED64_LIST(23, a.VECTOR, ag.LONG),
    FIXED32_LIST(24, a.VECTOR, ag.INT),
    BOOL_LIST(25, a.VECTOR, ag.BOOLEAN),
    STRING_LIST(26, a.VECTOR, ag.STRING),
    MESSAGE_LIST(27, a.VECTOR, ag.MESSAGE),
    BYTES_LIST(28, a.VECTOR, ag.BYTE_STRING),
    UINT32_LIST(29, a.VECTOR, ag.INT),
    ENUM_LIST(30, a.VECTOR, ag.ENUM),
    SFIXED32_LIST(31, a.VECTOR, ag.INT),
    SFIXED64_LIST(32, a.VECTOR, ag.LONG),
    SINT32_LIST(33, a.VECTOR, ag.INT),
    SINT64_LIST(34, a.VECTOR, ag.LONG),
    DOUBLE_LIST_PACKED(35, a.PACKED_VECTOR, ag.DOUBLE),
    FLOAT_LIST_PACKED(36, a.PACKED_VECTOR, ag.FLOAT),
    INT64_LIST_PACKED(37, a.PACKED_VECTOR, ag.LONG),
    UINT64_LIST_PACKED(38, a.PACKED_VECTOR, ag.LONG),
    INT32_LIST_PACKED(39, a.PACKED_VECTOR, ag.INT),
    FIXED64_LIST_PACKED(40, a.PACKED_VECTOR, ag.LONG),
    FIXED32_LIST_PACKED(41, a.PACKED_VECTOR, ag.INT),
    BOOL_LIST_PACKED(42, a.PACKED_VECTOR, ag.BOOLEAN),
    UINT32_LIST_PACKED(43, a.PACKED_VECTOR, ag.INT),
    ENUM_LIST_PACKED(44, a.PACKED_VECTOR, ag.ENUM),
    SFIXED32_LIST_PACKED(45, a.PACKED_VECTOR, ag.INT),
    SFIXED64_LIST_PACKED(46, a.PACKED_VECTOR, ag.LONG),
    SINT32_LIST_PACKED(47, a.PACKED_VECTOR, ag.INT),
    SINT64_LIST_PACKED(48, a.PACKED_VECTOR, ag.LONG),
    GROUP_LIST(49, a.VECTOR, ag.MESSAGE),
    MAP(50, a.MAP, ag.VOID);
    
    private static final y[] bVK;
    private static final Type[] bVL = new Type[0];
    final ag bVG;
    final a bVH;
    private final Class<?> bVI;
    private final boolean bVJ;
    final int id;

    static {
        y[] values = values();
        bVK = new y[values.length];
        for (y yVar : values) {
            bVK[yVar.id] = yVar;
        }
    }

    private y(int i2, a aVar, ag agVar) {
        this.id = i2;
        this.bVH = aVar;
        this.bVG = agVar;
        switch (aVar) {
            case MAP:
                this.bVI = agVar.bXC;
                break;
            case VECTOR:
                this.bVI = agVar.bXC;
                break;
            default:
                this.bVI = null;
                break;
        }
        boolean z = false;
        if (aVar == a.SCALAR) {
            switch (agVar) {
                case BYTE_STRING:
                case MESSAGE:
                case STRING:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.bVJ = z;
    }

    /* access modifiers changed from: package-private */
    public enum a {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        final boolean bVS;

        private a(boolean z) {
            this.bVS = z;
        }
    }
}
