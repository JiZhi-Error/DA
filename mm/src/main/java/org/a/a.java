package org.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a {
    private final Class<?> bWR;
    public final Object object;

    public static a bF(Class<?> cls) {
        AppMethodBeat.i(4271);
        a aVar = new a(cls);
        AppMethodBeat.o(4271);
        return aVar;
    }

    public static a gG(Object obj) {
        AppMethodBeat.i(4272);
        a aVar = new a(obj == null ? Object.class : obj.getClass(), obj);
        AppMethodBeat.o(4272);
        return aVar;
    }

    private static a e(Class<?> cls, Object obj) {
        AppMethodBeat.i(4273);
        a aVar = new a(cls, obj);
        AppMethodBeat.o(4273);
        return aVar;
    }

    private static <T extends AccessibleObject> T a(T t) {
        AppMethodBeat.i(4274);
        if (t == null) {
            AppMethodBeat.o(4274);
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                AppMethodBeat.o(4274);
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        AppMethodBeat.o(4274);
        return t;
    }

    private a(Class<?> cls) {
        this(cls, cls);
        AppMethodBeat.i(4275);
        AppMethodBeat.o(4275);
    }

    private a(Class<?> cls, Object obj) {
        this.bWR = cls;
        this.object = obj;
    }

    public final <T> T get(String str) {
        AppMethodBeat.i(4276);
        T t = (T) bvr(str).object;
        AppMethodBeat.o(4276);
        return t;
    }

    public final a bvr(String str) {
        AppMethodBeat.i(4277);
        try {
            Field bvs = bvs(str);
            a e2 = e(bvs.getType(), bvs.get(this.object));
            AppMethodBeat.o(4277);
            return e2;
        } catch (Exception e3) {
            b bVar = new b(e3);
            AppMethodBeat.o(4277);
            throw bVar;
        }
    }

    public final a bvt(String str) {
        AppMethodBeat.i(4279);
        a u = u(str, new Object[0]);
        AppMethodBeat.o(4279);
        return u;
    }

    public final a u(String str, Object... objArr) {
        Method method;
        a c2;
        AppMethodBeat.i(4280);
        Class<?>[] al = al(objArr);
        try {
            c2 = c(a(str, al), this.object, objArr);
            AppMethodBeat.o(4280);
        } catch (NoSuchMethodException e2) {
            try {
                Class<?> cls = this.bWR;
                Method[] methods = cls.getMethods();
                int length = methods.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        method = methods[i2];
                        if (a(method, str, al)) {
                            break;
                        }
                        i2++;
                    } else {
                        Class<? super Object> cls2 = cls;
                        loop1:
                        while (true) {
                            Method[] declaredMethods = cls2.getDeclaredMethods();
                            int length2 = declaredMethods.length;
                            for (int i3 = 0; i3 < length2; i3++) {
                                method = declaredMethods[i3];
                                if (a(method, str, al)) {
                                    break loop1;
                                }
                            }
                            Class<? super Object> superclass = cls2.getSuperclass();
                            if (superclass == null) {
                                NoSuchMethodException noSuchMethodException = new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(al) + " could be found on type " + this.bWR + ".");
                                AppMethodBeat.o(4280);
                                throw noSuchMethodException;
                            }
                            cls2 = superclass;
                        }
                    }
                }
                c2 = c(method, this.object, objArr);
                AppMethodBeat.o(4280);
            } catch (NoSuchMethodException e3) {
                b bVar = new b(e3);
                AppMethodBeat.o(4280);
                throw bVar;
            }
        }
        return c2;
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        AppMethodBeat.i(4282);
        if (!method.getName().equals(str) || !a(method.getParameterTypes(), clsArr)) {
            AppMethodBeat.o(4282);
            return false;
        }
        AppMethodBeat.o(4282);
        return true;
    }

    public final a hPX() {
        AppMethodBeat.i(4283);
        a ak = ak(new Object[0]);
        AppMethodBeat.o(4283);
        return ak;
    }

    public final a ak(Object... objArr) {
        AppMethodBeat.i(4284);
        Class<?>[] al = al(objArr);
        try {
            a b2 = b(this.bWR.getDeclaredConstructor(al), objArr);
            AppMethodBeat.o(4284);
            return b2;
        } catch (NoSuchMethodException e2) {
            Constructor<?>[] declaredConstructors = this.bWR.getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructors) {
                if (a(constructor.getParameterTypes(), al)) {
                    a b3 = b(constructor, objArr);
                    AppMethodBeat.o(4284);
                    return b3;
                }
            }
            b bVar = new b(e2);
            AppMethodBeat.o(4284);
            throw bVar;
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        AppMethodBeat.i(4285);
        if (clsArr.length == clsArr2.length) {
            for (int i2 = 0; i2 < clsArr2.length; i2++) {
                if (clsArr2[i2] != C2381a.class && !bG(clsArr[i2]).isAssignableFrom(bG(clsArr2[i2]))) {
                    AppMethodBeat.o(4285);
                    return false;
                }
            }
            AppMethodBeat.o(4285);
            return true;
        }
        AppMethodBeat.o(4285);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(4286);
        int hashCode = this.object.hashCode();
        AppMethodBeat.o(4286);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4287);
        if (obj instanceof a) {
            boolean equals = this.object.equals(((a) obj).object);
            AppMethodBeat.o(4287);
            return equals;
        }
        AppMethodBeat.o(4287);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(4288);
        String obj = this.object.toString();
        AppMethodBeat.o(4288);
        return obj;
    }

    private static a b(Constructor<?> constructor, Object... objArr) {
        AppMethodBeat.i(4289);
        try {
            a e2 = e(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
            AppMethodBeat.o(4289);
            return e2;
        } catch (Exception e3) {
            b bVar = new b(e3);
            AppMethodBeat.o(4289);
            throw bVar;
        }
    }

    private static a c(Method method, Object obj, Object... objArr) {
        AppMethodBeat.i(4290);
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                a gG = gG(obj);
                AppMethodBeat.o(4290);
                return gG;
            }
            a gG2 = gG(method.invoke(obj, objArr));
            AppMethodBeat.o(4290);
            return gG2;
        } catch (Exception e2) {
            b bVar = new b(e2);
            AppMethodBeat.o(4290);
            throw bVar;
        }
    }

    private static Class<?>[] al(Object... objArr) {
        AppMethodBeat.i(4291);
        if (objArr == null) {
            Class<?>[] clsArr = new Class[0];
            AppMethodBeat.o(4291);
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            clsArr2[i2] = obj == null ? C2381a.class : obj.getClass();
        }
        AppMethodBeat.o(4291);
        return clsArr2;
    }

    public static Class<?> forName(String str) {
        AppMethodBeat.i(4292);
        try {
            Class<?> cls = Class.forName(str);
            AppMethodBeat.o(4292);
            return cls;
        } catch (Exception e2) {
            b bVar = new b(e2);
            AppMethodBeat.o(4292);
            throw bVar;
        }
    }

    private static Class<?> bG(Class<?> cls) {
        AppMethodBeat.i(4293);
        if (cls == null) {
            AppMethodBeat.o(4293);
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Boolean.class;
            } else if (Integer.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Integer.class;
            } else if (Long.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Long.class;
            } else if (Short.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Short.class;
            } else if (Byte.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Byte.class;
            } else if (Double.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Double.class;
            } else if (Float.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Float.class;
            } else if (Character.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Character.class;
            } else if (Void.TYPE == cls) {
                AppMethodBeat.o(4293);
                return Void.class;
            }
        }
        AppMethodBeat.o(4293);
        return cls;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.a.a$a  reason: collision with other inner class name */
    public static class C2381a {
        private C2381a() {
        }
    }

    private Field bvs(String str) {
        Field field;
        AppMethodBeat.i(4278);
        Class<?> cls = this.bWR;
        try {
            field = (Field) a(cls.getField(str));
            AppMethodBeat.o(4278);
        } catch (NoSuchFieldException e2) {
            while (true) {
                try {
                    field = (Field) a(cls.getDeclaredField(str));
                    AppMethodBeat.o(4278);
                    break;
                } catch (NoSuchFieldException e3) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == null) {
                        b bVar = new b(e2);
                        AppMethodBeat.o(4278);
                        throw bVar;
                    }
                    cls = superclass;
                }
            }
        }
        return field;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Method declaredMethod;
        AppMethodBeat.i(4281);
        Class<?> cls = this.bWR;
        try {
            declaredMethod = cls.getMethod(str, clsArr);
            AppMethodBeat.o(4281);
        } catch (NoSuchMethodException e2) {
            do {
                try {
                    declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    AppMethodBeat.o(4281);
                } catch (NoSuchMethodException e3) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                        AppMethodBeat.o(4281);
                        throw noSuchMethodException;
                    }
                }
            } while (cls == null);
            NoSuchMethodException noSuchMethodException2 = new NoSuchMethodException();
            AppMethodBeat.o(4281);
            throw noSuchMethodException2;
        }
        return declaredMethod;
    }
}
