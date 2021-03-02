package com.tencent.mm.plugin.crashfix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public final class a {
    public static void c(Field field) {
        AppMethodBeat.i(145624);
        try {
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            declaredField.setAccessible(true);
            declaredField.setInt(field, field.getModifiers() & -17);
            AppMethodBeat.o(145624);
        } catch (Exception e2) {
            Log.e("MicroMsg.HookUtils", e2.getMessage());
            AppMethodBeat.o(145624);
        }
    }
}
