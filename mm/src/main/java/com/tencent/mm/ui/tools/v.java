package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public final class v {
    public static int kH(Context context) {
        AppMethodBeat.i(143282);
        float ez = a.ez(context);
        if (Float.compare(ez, a.iZ(context)) > 0) {
            AppMethodBeat.o(143282);
            return R.drawable.b18;
        } else if (Float.compare(ez, a.iX(context)) > 0) {
            AppMethodBeat.o(143282);
            return R.drawable.b1_;
        } else {
            AppMethodBeat.o(143282);
            return R.drawable.b16;
        }
    }

    public static int aQ(Context context, int i2) {
        AppMethodBeat.i(177648);
        if (Float.compare(a.ez(context), a.iZ(context)) > 0) {
            if (i2 < 10) {
                AppMethodBeat.o(177648);
                return R.drawable.b19;
            }
            AppMethodBeat.o(177648);
            return R.drawable.b18;
        } else if (i2 < 10) {
            AppMethodBeat.o(177648);
            return R.drawable.b17;
        } else {
            AppMethodBeat.o(177648);
            return R.drawable.b16;
        }
    }
}
