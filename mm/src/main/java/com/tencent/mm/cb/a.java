package com.tencent.mm.cb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    private static AbstractC0286a NCP = null;
    private static boolean NCQ = false;
    private static boolean NCR = true;
    private static final SparseIntArray csc = new SparseIntArray();
    private static float density = -1.0f;
    private static float scale = 0.0f;

    /* renamed from: com.tencent.mm.cb.a$a  reason: collision with other inner class name */
    public interface AbstractC0286a {
        int gvd();

        ColorStateList gve();

        Drawable gvf();

        int gvg();

        String gvh();
    }

    static {
        AppMethodBeat.i(125178);
        AppMethodBeat.o(125178);
    }

    public static int n(Context context, int i2) {
        AppMethodBeat.i(125146);
        if (NCP != null) {
            int gvd = NCP.gvd();
            AppMethodBeat.o(125146);
            return gvd;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i2));
            AppMethodBeat.o(125146);
            return 0;
        } else {
            int color = context.getResources().getColor(i2);
            AppMethodBeat.o(125146);
            return color;
        }
    }

    public static ColorStateList m(Context context, int i2) {
        AppMethodBeat.i(125147);
        if (NCP != null) {
            ColorStateList gve = NCP.gve();
            AppMethodBeat.o(125147);
            return gve;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i2));
            AppMethodBeat.o(125147);
            return null;
        } else {
            ColorStateList colorStateList = context.getResources().getColorStateList(i2);
            AppMethodBeat.o(125147);
            return colorStateList;
        }
    }

    public static Drawable l(Context context, int i2) {
        AppMethodBeat.i(125148);
        if (NCP != null) {
            Drawable gvf = NCP.gvf();
            AppMethodBeat.o(125148);
            return gvf;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i2));
            AppMethodBeat.o(125148);
            return null;
        } else {
            Drawable drawable = context.getResources().getDrawable(i2);
            AppMethodBeat.o(125148);
            return drawable;
        }
    }

    public static int aG(Context context, int i2) {
        float f2 = 1.4f;
        AppMethodBeat.i(125149);
        float ez = ez(context);
        if (ez <= 1.4f) {
            f2 = ez;
        }
        int aH = (int) (f2 * ((float) aH(context, i2)));
        AppMethodBeat.o(125149);
        return aH;
    }

    public static int aH(Context context, int i2) {
        int i3 = 0;
        AppMethodBeat.i(125150);
        if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i2));
            AppMethodBeat.o(125150);
        } else {
            synchronized (csc) {
                try {
                    i3 = csc.get(i2, 0);
                } finally {
                    AppMethodBeat.o(125150);
                }
            }
            if (i3 <= 0) {
                if (NCP == null) {
                    i3 = context.getResources().getDimensionPixelSize(i2);
                } else {
                    i3 = NCP.gvg();
                }
                synchronized (csc) {
                    try {
                        csc.put(i2, i3);
                    } finally {
                        AppMethodBeat.o(125150);
                    }
                }
            }
        }
        return i3;
    }

    public static String aI(Context context, int i2) {
        AppMethodBeat.i(125151);
        if (NCP != null) {
            String gvh = NCP.gvh();
            AppMethodBeat.o(125151);
            return gvh;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i2));
            AppMethodBeat.o(125151);
            return "";
        } else {
            String string = context.getResources().getString(i2);
            AppMethodBeat.o(125151);
            return string;
        }
    }

    public static float getDensity(Context context) {
        AppMethodBeat.i(125152);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        density = f2;
        AppMethodBeat.o(125152);
        return f2;
    }

    public static int fromDPToPix(Context context, float f2) {
        AppMethodBeat.i(125153);
        int round = Math.round(getDensity(context) * f2);
        AppMethodBeat.o(125153);
        return round;
    }

    public static int fromDPToPix(Context context, int i2) {
        AppMethodBeat.i(125154);
        int round = Math.round(getDensity(context) * ((float) i2));
        AppMethodBeat.o(125154);
        return round;
    }

    public static int E(Context context, int i2) {
        AppMethodBeat.i(125155);
        int round = Math.round(((float) i2) / getDensity(context));
        AppMethodBeat.o(125155);
        return round;
    }

    public static float iW(Context context) {
        AppMethodBeat.i(125156);
        if (jf(context)) {
            AppMethodBeat.o(125156);
            return 0.8f;
        }
        AppMethodBeat.o(125156);
        return 0.875f;
    }

    public static float iX(Context context) {
        AppMethodBeat.i(125157);
        if (jf(context)) {
            AppMethodBeat.o(125157);
        } else {
            AppMethodBeat.o(125157);
        }
        return 1.0f;
    }

    public static float iY(Context context) {
        AppMethodBeat.i(125158);
        if (jf(context)) {
            AppMethodBeat.o(125158);
            return 1.1f;
        }
        AppMethodBeat.o(125158);
        return 1.11f;
    }

    public static float iZ(Context context) {
        AppMethodBeat.i(125159);
        if (jf(context)) {
            AppMethodBeat.o(125159);
            return 1.12f;
        }
        AppMethodBeat.o(125159);
        return 1.25f;
    }

    public static float ja(Context context) {
        AppMethodBeat.i(125160);
        if (jf(context)) {
            AppMethodBeat.o(125160);
            return 1.125f;
        }
        AppMethodBeat.o(125160);
        return 1.375f;
    }

    public static float jb(Context context) {
        AppMethodBeat.i(125161);
        if (jf(context)) {
            AppMethodBeat.o(125161);
            return 1.4f;
        }
        AppMethodBeat.o(125161);
        return 1.625f;
    }

    public static float jc(Context context) {
        AppMethodBeat.i(125162);
        if (jf(context)) {
            AppMethodBeat.o(125162);
            return 1.55f;
        }
        AppMethodBeat.o(125162);
        return 1.875f;
    }

    public static float jd(Context context) {
        AppMethodBeat.i(125163);
        if (jf(context)) {
            AppMethodBeat.o(125163);
            return 1.65f;
        }
        AppMethodBeat.o(125163);
        return 2.025f;
    }

    public static float ez(Context context) {
        AppMethodBeat.i(125164);
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        if (!NCQ) {
            NCR = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true);
            NCQ = true;
        }
        if (NCR && (scale == 1.1f || scale == 0.8f)) {
            scale = 1.0f;
        }
        float f2 = scale;
        AppMethodBeat.o(125164);
        return f2;
    }

    public static float je(Context context) {
        float f2 = 1.0f;
        AppMethodBeat.i(125165);
        if (context != null) {
            f2 = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("text_size_scale_key", 1.0f);
        }
        AppMethodBeat.o(125165);
        return f2;
    }

    public static boolean jf(Context context) {
        AppMethodBeat.i(125166);
        if (context != null && !NCQ) {
            NCR = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true);
            NCQ = true;
        }
        boolean z = NCR;
        AppMethodBeat.o(125166);
        return z;
    }

    public static int jg(Context context) {
        AppMethodBeat.i(125167);
        float je = je(context);
        if (je == iW(context)) {
            AppMethodBeat.o(125167);
            return 1;
        } else if (je == iX(context)) {
            AppMethodBeat.o(125167);
            return 2;
        } else if (je == iY(context)) {
            AppMethodBeat.o(125167);
            return 3;
        } else if (je == iZ(context)) {
            AppMethodBeat.o(125167);
            return 4;
        } else if (je == ja(context)) {
            AppMethodBeat.o(125167);
            return 5;
        } else if (je == jb(context)) {
            AppMethodBeat.o(125167);
            return 6;
        } else if (je == jc(context)) {
            AppMethodBeat.o(125167);
            return 7;
        } else if (je == jd(context)) {
            AppMethodBeat.o(125167);
            return 8;
        } else {
            AppMethodBeat.o(125167);
            return 2;
        }
    }

    public static int jh(Context context) {
        AppMethodBeat.i(125168);
        float je = je(context);
        if (je == 0.875f) {
            AppMethodBeat.o(125168);
            return 0;
        } else if (je == 1.0f) {
            AppMethodBeat.o(125168);
            return 1;
        } else if (je == 1.11f) {
            AppMethodBeat.o(125168);
            return 2;
        } else if (je == 1.25f) {
            AppMethodBeat.o(125168);
            return 3;
        } else if (je == 1.375f) {
            AppMethodBeat.o(125168);
            return 4;
        } else if (je == 1.625f || as(je, 1.3f)) {
            AppMethodBeat.o(125168);
            return 5;
        } else if (je == 1.875f || as(je, 1.38f)) {
            AppMethodBeat.o(125168);
            return 6;
        } else if (je == 2.025f || as(je, 1.565f)) {
            AppMethodBeat.o(125168);
            return 7;
        } else {
            AppMethodBeat.o(125168);
            return 1;
        }
    }

    public static float ji(Context context) {
        AppMethodBeat.i(125169);
        float f2 = 1.0f;
        if (jl(context)) {
            if (jf(context)) {
                f2 = 1.2f;
            } else {
                f2 = 1.1f;
            }
        }
        AppMethodBeat.o(125169);
        return f2;
    }

    public static float jj(Context context) {
        AppMethodBeat.i(125170);
        float f2 = 1.0f;
        if (!jf(context) && jl(context)) {
            f2 = 1.1f;
        }
        AppMethodBeat.o(125170);
        return f2;
    }

    public static void h(Context context, float f2) {
        AppMethodBeat.i(125171);
        SharedPreferences.Editor edit = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
        edit.putFloat("text_size_scale_key", f2);
        edit.commit();
        scale = f2;
        AppMethodBeat.o(125171);
    }

    public static boolean jk(Context context) {
        AppMethodBeat.i(125172);
        float ez = ez(context);
        scale = ez;
        if (Float.compare(ez, iY(context)) > 0) {
            AppMethodBeat.o(125172);
            return true;
        }
        AppMethodBeat.o(125172);
        return false;
    }

    public static boolean jl(Context context) {
        AppMethodBeat.i(125173);
        float ez = ez(context);
        scale = ez;
        if (Float.compare(ez, iZ(context)) > 0) {
            AppMethodBeat.o(125173);
            return true;
        }
        AppMethodBeat.o(125173);
        return false;
    }

    public static boolean jm(Context context) {
        AppMethodBeat.i(125174);
        float ez = ez(context);
        scale = ez;
        if (ez == iW(context)) {
            AppMethodBeat.o(125174);
            return true;
        }
        AppMethodBeat.o(125174);
        return false;
    }

    public static int jn(Context context) {
        AppMethodBeat.i(125175);
        if (NCP != null) {
            AppMethodBeat.o(125175);
            return 0;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
            AppMethodBeat.o(125175);
            return 0;
        } else {
            int i2 = context.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.o(125175);
            return i2;
        }
    }

    public static int jo(Context context) {
        AppMethodBeat.i(125176);
        if (NCP != null) {
            AppMethodBeat.o(125176);
            return 0;
        } else if (context == null) {
            Log.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
            AppMethodBeat.o(125176);
            return 0;
        } else {
            int i2 = context.getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.o(125176);
            return i2;
        }
    }

    private static boolean as(float f2, float f3) {
        AppMethodBeat.i(125177);
        if (((double) Math.abs(f2 - f3)) <= 1.0E-5d) {
            AppMethodBeat.o(125177);
            return true;
        }
        AppMethodBeat.o(125177);
        return false;
    }
}
