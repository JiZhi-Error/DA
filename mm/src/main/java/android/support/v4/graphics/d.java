package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.v4.c.b;
import android.support.v4.content.a.c;
import android.support.v4.content.a.f;
import android.support.v4.e.h;

public final class d {
    private static final i JV;
    private static final h<String, Typeface> JW = new h<>(16);

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            JV = new h();
        } else if (Build.VERSION.SDK_INT >= 26) {
            JV = new g();
        } else if (Build.VERSION.SDK_INT >= 24 && f.ez()) {
            JV = new f();
        } else if (Build.VERSION.SDK_INT >= 21) {
            JV = new e();
        } else {
            JV = new i();
        }
    }

    public static Typeface a(Resources resources, int i2, int i3) {
        return JW.get(b(resources, i2, i3));
    }

    private static String b(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, Handler handler, boolean z) {
        Typeface a2;
        int i4;
        boolean z2 = true;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            if (z) {
                if (dVar.JM != 0) {
                    z2 = false;
                }
            } else if (aVar2 != null) {
                z2 = false;
            }
            if (z) {
                i4 = dVar.JL;
            } else {
                i4 = -1;
            }
            a2 = b.a(context, dVar.JK, aVar2, handler, z2, i4, i3);
        } else {
            a2 = JV.a(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (a2 != null) {
            JW.put(b(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = JV.a(context, resources, i2, str, i3);
        if (a2 != null) {
            JW.put(b(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, b.C0019b[] bVarArr, int i2) {
        return JV.a(context, bVarArr, i2);
    }
}
