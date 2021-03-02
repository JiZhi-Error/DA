package com.google.a;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
public final class ch {
    private static final Unsafe UNSAFE;
    private static final boolean bNy = HV();
    private static final b cae;
    private static final boolean caf = HW();
    static final long cag = ((long) K(byte[].class));
    private static final long cah = ((long) K(boolean[].class));
    private static final long cai = ((long) L(boolean[].class));
    private static final long caj = ((long) K(int[].class));
    private static final long cak = ((long) L(int[].class));
    private static final long cal = ((long) K(long[].class));
    private static final long cam = ((long) L(long[].class));
    private static final long can = ((long) K(float[].class));
    private static final long cao = ((long) L(float[].class));
    private static final long cap = ((long) K(double[].class));
    private static final long caq = ((long) L(double[].class));
    private static final long car = ((long) K(Object[].class));
    private static final long cas = ((long) L(Object[].class));
    private static final long cat;
    private static final int cau = ((int) (cag & 7));
    static final boolean cav;
    private static final Logger logger = Logger.getLogger(ch.class.getName());

    static {
        a aVar;
        long j2;
        boolean z;
        Unsafe HU = HU();
        UNSAFE = HU;
        if (HU == null) {
            aVar = null;
        } else {
            aVar = new a(UNSAFE);
        }
        cae = aVar;
        Field HX = HX();
        if (HX == null || cae == null) {
            j2 = -1;
        } else {
            j2 = cae.a(HX);
        }
        cat = j2;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        } else {
            z = false;
        }
        cav = z;
    }

    private ch() {
    }

    static boolean HS() {
        return bNy;
    }

    static boolean HT() {
        return caf;
    }

    static <T> T J(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static long a(Field field) {
        return cae.a(field);
    }

    private static int K(Class<?> cls) {
        if (bNy) {
            return cae.caw.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int L(Class<?> cls) {
        if (bNy) {
            return cae.caw.arrayIndexScale(cls);
        }
        return -1;
    }

    static int f(Object obj, long j2) {
        return cae.caw.getInt(obj, j2);
    }

    static void a(Object obj, long j2, int i2) {
        cae.caw.putInt(obj, j2, i2);
    }

    static long g(Object obj, long j2) {
        return cae.caw.getLong(obj, j2);
    }

    static void a(Object obj, long j2, long j3) {
        cae.caw.putLong(obj, j2, j3);
    }

    static boolean h(Object obj, long j2) {
        return cae.h(obj, j2);
    }

    static void a(Object obj, long j2, boolean z) {
        cae.a(obj, j2, z);
    }

    static float i(Object obj, long j2) {
        return cae.i(obj, j2);
    }

    static void a(Object obj, long j2, float f2) {
        cae.a(obj, j2, f2);
    }

    static double j(Object obj, long j2) {
        return cae.j(obj, j2);
    }

    static void a(Object obj, long j2, double d2) {
        cae.a(obj, j2, d2);
    }

    static Object k(Object obj, long j2) {
        return cae.k(obj, j2);
    }

    static void a(Object obj, long j2, Object obj2) {
        cae.caw.putObject(obj, j2, obj2);
    }

    static byte c(byte[] bArr, long j2) {
        return cae.l(bArr, cag + j2);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        cae.a((Object) bArr, cag + j2, b2);
    }

    static Object b(Field field) {
        return cae.b(field);
    }

    static Unsafe HU() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                /* class com.google.a.ch.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.security.PrivilegedExceptionAction
                public final /* synthetic */ Unsafe run() {
                    Field[] declaredFields = Unsafe.class.getDeclaredFields();
                    for (Field field : declaredFields) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean HV() {
        if (UNSAFE == null) {
            return false;
        }
        try {
            Class<?> cls = UNSAFE.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(th)));
            return false;
        }
    }

    private static boolean HW() {
        if (UNSAFE == null) {
            return false;
        }
        try {
            Class<?> cls = UNSAFE.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (HX() == null) {
                return false;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: ".concat(String.valueOf(th)));
            return false;
        }
    }

    private static Field HX() {
        Field a2 = a(Buffer.class, "address");
        if (a2 == null || a2.getType() != Long.TYPE) {
            return null;
        }
        return a2;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class b {
        Unsafe caw;

        public abstract void a(Object obj, long j2, byte b2);

        public abstract void a(Object obj, long j2, double d2);

        public abstract void a(Object obj, long j2, float f2);

        public abstract void a(Object obj, long j2, boolean z);

        public abstract Object b(Field field);

        public abstract boolean h(Object obj, long j2);

        public abstract float i(Object obj, long j2);

        public abstract double j(Object obj, long j2);

        public abstract byte l(Object obj, long j2);

        b(Unsafe unsafe) {
            this.caw = unsafe;
        }

        public final long a(Field field) {
            return this.caw.objectFieldOffset(field);
        }

        public final Object k(Object obj, long j2) {
            return this.caw.getObject(obj, j2);
        }
    }

    static final class a extends b {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.a.ch.b
        public final byte l(Object obj, long j2) {
            return this.caw.getByte(obj, j2);
        }

        @Override // com.google.a.ch.b
        public final void a(Object obj, long j2, byte b2) {
            this.caw.putByte(obj, j2, b2);
        }

        @Override // com.google.a.ch.b
        public final boolean h(Object obj, long j2) {
            return this.caw.getBoolean(obj, j2);
        }

        @Override // com.google.a.ch.b
        public final void a(Object obj, long j2, boolean z) {
            this.caw.putBoolean(obj, j2, z);
        }

        @Override // com.google.a.ch.b
        public final float i(Object obj, long j2) {
            return this.caw.getFloat(obj, j2);
        }

        @Override // com.google.a.ch.b
        public final void a(Object obj, long j2, float f2) {
            this.caw.putFloat(obj, j2, f2);
        }

        @Override // com.google.a.ch.b
        public final double j(Object obj, long j2) {
            return this.caw.getDouble(obj, j2);
        }

        @Override // com.google.a.ch.b
        public final void a(Object obj, long j2, double d2) {
            this.caw.putDouble(obj, j2, d2);
        }

        @Override // com.google.a.ch.b
        public final Object b(Field field) {
            return k(this.caw.staticFieldBase(field), this.caw.staticFieldOffset(field));
        }
    }
}
