package com.tencent.map.tools.json;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FieldNameStyle {
    HUMP,
    UNDERLINE;

    public static FieldNameStyle valueOf(String str) {
        AppMethodBeat.i(180910);
        FieldNameStyle fieldNameStyle = (FieldNameStyle) Enum.valueOf(FieldNameStyle.class, str);
        AppMethodBeat.o(180910);
        return fieldNameStyle;
    }

    static {
        AppMethodBeat.i(180911);
        AppMethodBeat.o(180911);
    }
}
