package android.support.v4.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class h extends g {
    /* access modifiers changed from: protected */
    @Override // android.support.v4.graphics.g
    public final Typeface q(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.Kb, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.Kh.invoke(null, newInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.graphics.g
    public final Method i(Class cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
