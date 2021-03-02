package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.f;
import android.support.v4.content.b;
import android.support.v7.view.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static volatile boolean aLF = true;

    public static Drawable b(Context context, Context context2, int i2) {
        AppMethodBeat.i(77453);
        Drawable a2 = a(context, context2, i2, null);
        AppMethodBeat.o(77453);
        return a2;
    }

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        AppMethodBeat.i(77454);
        Drawable a2 = a(context, context, i2, theme);
        AppMethodBeat.o(77454);
        return a2;
    }

    private static Drawable a(Context context, Context context2, int i2, Resources.Theme theme) {
        AppMethodBeat.i(77455);
        try {
            if (aLF) {
                Drawable l = android.support.v7.c.a.a.l(theme != null ? new d(context2, theme) : context2, i2);
                AppMethodBeat.o(77455);
                return l;
            }
        } catch (NoClassDefFoundError e2) {
            aLF = false;
        } catch (IllegalStateException e3) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                AppMethodBeat.o(77455);
                throw e3;
            }
            Drawable l2 = b.l(context2, i2);
            AppMethodBeat.o(77455);
            return l2;
        } catch (Resources.NotFoundException e4) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Drawable c2 = f.c(context2.getResources(), i2, theme);
        AppMethodBeat.o(77455);
        return c2;
    }
}
