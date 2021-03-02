package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b {
    private static boolean Ovi = false;
    private static boolean Ovj = false;
    private static boolean mInitialized = false;
    private static String mPackageName = "";

    public static void gm(String str) {
        mPackageName = str;
    }

    public static final boolean gFW() {
        return Ovj;
    }

    public static final void AP(boolean z) {
        Ovj = z;
    }

    private static final Object blC(String str) {
        AppMethodBeat.i(148757);
        try {
            Class<?> cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            AppMethodBeat.o(148757);
            return obj;
        } catch (NoSuchFieldException e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(148757);
            return null;
        } catch (IllegalArgumentException e3) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e3, "IllegalArgumentException", new Object[0]);
            AppMethodBeat.o(148757);
            return null;
        } catch (ClassNotFoundException e4) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e4, "ClassNotFoundException", new Object[0]);
            AppMethodBeat.o(148757);
            return null;
        } catch (IllegalAccessException e5) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e5, "IllegalAccessException", new Object[0]);
            AppMethodBeat.o(148757);
            return null;
        }
    }

    public static final Class<?> gFY() {
        AppMethodBeat.i(148759);
        Object blC = blC("WxSVGRawClass");
        if (blC != null) {
            Class<?> cls = (Class) blC;
            AppMethodBeat.o(148759);
            return cls;
        }
        AppMethodBeat.o(148759);
        return null;
    }

    public static long gFZ() {
        AppMethodBeat.i(148760);
        long nanoTime = System.nanoTime();
        AppMethodBeat.o(148760);
        return nanoTime;
    }

    public static long Nn(long j2) {
        AppMethodBeat.i(148761);
        long nanoTime = (System.nanoTime() - j2) / 1000;
        AppMethodBeat.o(148761);
        return nanoTime;
    }

    public static final boolean gFX() {
        AppMethodBeat.i(148758);
        if (!mInitialized) {
            Object blC = blC("WxSVGCode");
            if (blC == null) {
                Ovi = false;
            } else {
                Ovi = ((Boolean) blC).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(Ovi));
            mInitialized = true;
        }
        if (!Ovi) {
            AppMethodBeat.o(148758);
            return true;
        }
        AppMethodBeat.o(148758);
        return false;
    }
}
