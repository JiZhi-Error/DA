package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5),
    BOOL(6),
    INT8(9);
    
    private static final a[] UiU = values();
    private final int value;

    public static a valueOf(String str) {
        AppMethodBeat.i(238959);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(238959);
        return aVar;
    }

    static {
        AppMethodBeat.i(238963);
        AppMethodBeat.o(238963);
    }

    private a(int i2) {
        this.value = i2;
    }

    public final int hQq() {
        AppMethodBeat.i(238960);
        switch (this) {
            case FLOAT32:
            case INT32:
                AppMethodBeat.o(238960);
                return 4;
            case INT8:
            case UINT8:
                AppMethodBeat.o(238960);
                return 1;
            case INT64:
                AppMethodBeat.o(238960);
                return 8;
            case BOOL:
                AppMethodBeat.o(238960);
                return -1;
            case STRING:
                AppMethodBeat.o(238960);
                return -1;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
                AppMethodBeat.o(238960);
                throw illegalArgumentException;
        }
    }

    static a awm(int i2) {
        AppMethodBeat.i(238961);
        a[] aVarArr = UiU;
        for (a aVar : aVarArr) {
            if (aVar.value == i2) {
                AppMethodBeat.o(238961);
                return aVar;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DataType error: DataType " + i2 + " is not recognized in Java (version " + TensorFlowLite.hQt() + ")");
        AppMethodBeat.o(238961);
        throw illegalArgumentException;
    }

    /* access modifiers changed from: package-private */
    public final String hQr() {
        AppMethodBeat.i(238962);
        switch (this) {
            case FLOAT32:
                AppMethodBeat.o(238962);
                return "float";
            case INT32:
                AppMethodBeat.o(238962);
                return "int";
            case INT8:
            case UINT8:
                AppMethodBeat.o(238962);
                return "byte";
            case INT64:
                AppMethodBeat.o(238962);
                return "long";
            case BOOL:
                AppMethodBeat.o(238962);
                return "bool";
            case STRING:
                AppMethodBeat.o(238962);
                return "string";
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
                AppMethodBeat.o(238962);
                throw illegalArgumentException;
        }
    }
}
