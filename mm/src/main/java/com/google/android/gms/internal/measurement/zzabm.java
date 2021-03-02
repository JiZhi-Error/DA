package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzabm {
    private static final Logger logger = Logger.getLogger(zzabm.class.getName());
    private static final Class<?> zzbqv = zzyv.zzsw();
    private static final Unsafe zzbtj = zzur();
    private static final boolean zzbun = zzk(Long.TYPE);
    private static final boolean zzbuo = zzk(Integer.TYPE);
    private static final zzd zzbup = (zzbtj == null ? null : zzyv.zzsv() ? zzbun ? new zzb(zzbtj) : zzbuo ? new zza(zzbtj) : null : new zzc(zzbtj));
    private static final boolean zzbuq = zzut();
    private static final boolean zzbur = zzus();
    private static final long zzbus = ((long) zzi(byte[].class));
    private static final long zzbut = ((long) zzi(boolean[].class));
    private static final long zzbuu = ((long) zzj(boolean[].class));
    private static final long zzbuv = ((long) zzi(int[].class));
    private static final long zzbuw = ((long) zzj(int[].class));
    private static final long zzbux = ((long) zzi(long[].class));
    private static final long zzbuy = ((long) zzj(long[].class));
    private static final long zzbuz = ((long) zzi(float[].class));
    private static final long zzbva = ((long) zzj(float[].class));
    private static final long zzbvb = ((long) zzi(double[].class));
    private static final long zzbvc = ((long) zzj(double[].class));
    private static final long zzbvd = ((long) zzi(Object[].class));
    private static final long zzbve = ((long) zzj(Object[].class));
    private static final long zzbvf = zza(zzuu());
    private static final long zzbvg;
    private static final boolean zzbvh = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzd {
        Unsafe zzbvi;

        zzd(Unsafe unsafe) {
            this.zzbvi = unsafe;
        }
    }

    static {
        Field field = null;
        AppMethodBeat.i(40214);
        Field zza2 = zza(String.class, "value");
        if (zza2 != null && zza2.getType() == char[].class) {
            field = zza2;
        }
        zzbvg = zza(field);
        AppMethodBeat.o(40214);
    }

    private zzabm() {
    }

    private static long zza(Field field) {
        AppMethodBeat.i(40212);
        if (field == null || zzbup == null) {
            AppMethodBeat.o(40212);
            return -1;
        }
        long objectFieldOffset = zzbup.zzbvi.objectFieldOffset(field);
        AppMethodBeat.o(40212);
        return objectFieldOffset;
    }

    private static Field zza(Class<?> cls, String str) {
        Field field;
        AppMethodBeat.i(40213);
        try {
            field = cls.getDeclaredField(str);
            field.setAccessible(true);
        } catch (Throwable th) {
            field = null;
        }
        AppMethodBeat.o(40213);
        return field;
    }

    private static int zzi(Class<?> cls) {
        AppMethodBeat.i(40205);
        if (zzbur) {
            int arrayBaseOffset = zzbup.zzbvi.arrayBaseOffset(cls);
            AppMethodBeat.o(40205);
            return arrayBaseOffset;
        }
        AppMethodBeat.o(40205);
        return -1;
    }

    private static int zzj(Class<?> cls) {
        AppMethodBeat.i(40206);
        if (zzbur) {
            int arrayIndexScale = zzbup.zzbvi.arrayIndexScale(cls);
            AppMethodBeat.o(40206);
            return arrayIndexScale;
        }
        AppMethodBeat.o(40206);
        return -1;
    }

    private static boolean zzk(Class<?> cls) {
        AppMethodBeat.i(40210);
        if (!zzyv.zzsv()) {
            AppMethodBeat.o(40210);
            return false;
        }
        try {
            Class<?> cls2 = zzbqv;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            AppMethodBeat.o(40210);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(40210);
            return false;
        }
    }

    static Unsafe zzur() {
        Unsafe unsafe;
        AppMethodBeat.i(40207);
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzabn());
        } catch (Throwable th) {
            unsafe = null;
        }
        AppMethodBeat.o(40207);
        return unsafe;
    }

    private static boolean zzus() {
        AppMethodBeat.i(40208);
        if (zzbtj == null) {
            AppMethodBeat.o(40208);
            return false;
        }
        try {
            Class<?> cls = zzbtj.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzyv.zzsv()) {
                AppMethodBeat.o(40208);
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            AppMethodBeat.o(40208);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            AppMethodBeat.o(40208);
            return false;
        }
    }

    private static boolean zzut() {
        AppMethodBeat.i(40209);
        if (zzbtj == null) {
            AppMethodBeat.o(40209);
            return false;
        }
        try {
            Class<?> cls = zzbtj.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzuu() == null) {
                AppMethodBeat.o(40209);
                return false;
            } else if (zzyv.zzsv()) {
                AppMethodBeat.o(40209);
                return true;
            } else {
                cls.getMethod("getByte", Long.TYPE);
                cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
                cls.getMethod("getInt", Long.TYPE);
                cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
                cls.getMethod("getLong", Long.TYPE);
                cls.getMethod("putLong", Long.TYPE, Long.TYPE);
                cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
                cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                AppMethodBeat.o(40209);
                return true;
            }
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            AppMethodBeat.o(40209);
            return false;
        }
    }

    private static Field zzuu() {
        Field zza2;
        AppMethodBeat.i(40211);
        if (!zzyv.zzsv() || (zza2 = zza(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zza3 = zza(Buffer.class, "address");
            if (zza3 == null || zza3.getType() != Long.TYPE) {
                AppMethodBeat.o(40211);
                return null;
            }
            AppMethodBeat.o(40211);
            return zza3;
        }
        AppMethodBeat.o(40211);
        return zza2;
    }
}
