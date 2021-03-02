package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import junit.framework.Assert;

public final class u {
    private static u Qxc = null;
    private ColorStateList[] Pav = new ColorStateList[2];
    private boolean Qxd = false;

    private u(Context context) {
        AppMethodBeat.i(143278);
        this.Pav[0] = a.m(context, R.color.a0h);
        this.Pav[1] = a.m(context, R.color.a0i);
        AppMethodBeat.o(143278);
    }

    private static u kE(Context context) {
        AppMethodBeat.i(143279);
        Assert.assertTrue(context != null);
        if (Qxc == null || !Qxc.Qxd) {
            Qxc = new u(context);
        }
        u uVar = Qxc;
        AppMethodBeat.o(143279);
        return uVar;
    }

    public static ColorStateList kF(Context context) {
        AppMethodBeat.i(143280);
        ColorStateList colorStateList = kE(context).Pav[0];
        AppMethodBeat.o(143280);
        return colorStateList;
    }

    public static ColorStateList kG(Context context) {
        AppMethodBeat.i(143281);
        ColorStateList colorStateList = kE(context).Pav[1];
        AppMethodBeat.o(143281);
        return colorStateList;
    }
}
