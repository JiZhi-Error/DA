package com.tencent.mm.bl;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public static float AO(long j2) {
        float f2 = 1.0f;
        AppMethodBeat.i(20676);
        float f3 = ((float) j2) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(20676);
        return round;
    }

    public static CharSequence J(Context context, int i2) {
        AppMethodBeat.i(20677);
        if (i2 <= 0) {
            String string = context.getString(R.string.cc3, 0, 0);
            AppMethodBeat.o(20677);
            return string;
        }
        String string2 = context.getString(R.string.cc3, Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
        AppMethodBeat.o(20677);
        return string2;
    }
}
