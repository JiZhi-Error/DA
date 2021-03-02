package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.c.b;
import android.support.v4.content.a.c;
import android.support.v4.e.n;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class f extends i {
    private static final Class JX;
    private static final Constructor JY;
    private static final Method JZ;
    private static final Method Ka;

    f() {
    }

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            e2.getClass().getName();
            method = null;
            method2 = null;
            constructor = null;
            cls = null;
        }
        JY = constructor;
        JX = cls;
        JZ = method2;
        Ka = method;
    }

    public static boolean ez() {
        return JZ != null;
    }

    private static Object eA() {
        try {
            return JY.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) JZ.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface q(Object obj) {
        try {
            Object newInstance = Array.newInstance(JX, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) Ka.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.graphics.i
    public final Typeface a(Context context, b.C0019b[] bVarArr, int i2) {
        Object eA = eA();
        n nVar = new n();
        for (b.C0019b bVar : bVarArr) {
            Uri uri = bVar.mUri;
            ByteBuffer byteBuffer = (ByteBuffer) nVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = j.a(context, (CancellationSignal) null, uri);
                nVar.put(uri, byteBuffer);
            }
            if (!a(eA, byteBuffer, bVar.JI, bVar.JF, bVar.JG)) {
                return null;
            }
        }
        return Typeface.create(q(eA), i2);
    }

    @Override // android.support.v4.graphics.i
    public final Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object eA = eA();
        c.C0021c[] cVarArr = bVar.JE;
        for (c.C0021c cVar : cVarArr) {
            ByteBuffer a2 = j.a(context, resources, cVar.JJ);
            if (a2 == null || !a(eA, a2, cVar.JI, cVar.JF, cVar.JG)) {
                return null;
            }
        }
        return q(eA);
    }
}
