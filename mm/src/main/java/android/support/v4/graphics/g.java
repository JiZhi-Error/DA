package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class g extends e {
    protected final Class Kb;
    protected final Constructor Kc;
    protected final Method Kd;
    protected final Method Ke;
    protected final Method Kf;
    protected final Method Kg;
    protected final Method Kh;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method5 = cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method4 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method3 = cls.getMethod("freeze", new Class[0]);
            method2 = cls.getMethod("abortCreation", new Class[0]);
            method = i(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            new StringBuilder("Unable to collect necessary methods for class ").append(e2.getClass().getName());
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
            constructor = null;
            cls = null;
        }
        this.Kb = cls;
        this.Kc = constructor;
        this.Kd = method5;
        this.Ke = method4;
        this.Kf = method3;
        this.Kg = method2;
        this.Kh = method;
    }

    private boolean eB() {
        return this.Kd != null;
    }

    private Object eA() {
        try {
            return this.Kc.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.Kd.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.Ke.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public Typeface q(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.Kb, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.Kh.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean r(Object obj) {
        try {
            return ((Boolean) this.Kf.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void s(Object obj) {
        try {
            this.Kg.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.graphics.i
    public final Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        int i3;
        if (!eB()) {
            return super.a(context, bVar, resources, i2);
        }
        Object eA = eA();
        c.C0021c[] cVarArr = bVar.JE;
        for (c.C0021c cVar : cVarArr) {
            String str = cVar.mFileName;
            int i4 = cVar.JI;
            int i5 = cVar.JF;
            if (cVar.JG) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!a(context, eA, str, i4, i5, i3, FontVariationAxis.fromFontVariationSettings(cVar.JH))) {
                s(eA);
                return null;
            }
        }
        if (!r(eA)) {
            return null;
        }
        return q(eA);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        r1 = r0;
        r2 = null;
     */
    @Override // android.support.v4.graphics.e, android.support.v4.graphics.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Typeface a(android.content.Context r13, android.support.v4.c.b.C0019b[] r14, int r15) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.g.a(android.content.Context, android.support.v4.c.b$b[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.i
    public final Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!eB()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object eA = eA();
        if (!a(context, eA, str, 0, -1, -1, null)) {
            s(eA);
            return null;
        } else if (r(eA)) {
            return q(eA);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Method i(Class cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
