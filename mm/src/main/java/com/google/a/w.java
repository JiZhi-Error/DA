package com.google.a;

import com.google.a.ae;
import com.google.a.y;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
public final class w implements Comparable<w> {
    final Field bUo;
    final y bUp;
    final Class<?> bUq;
    final int bUr;
    final Field bUs;
    final int bUt;
    final boolean bUu;
    final bi bUv;
    final Field bUw;
    final Class<?> bUx;
    final Object bUy;
    final ae.c bUz;
    final boolean required;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(w wVar) {
        return this.bUr - wVar.bUr;
    }

    public static w a(Field field, int i2, y yVar, boolean z) {
        gC(i2);
        ae.checkNotNull(field, "field");
        ae.checkNotNull(yVar, "fieldType");
        if (yVar != y.MESSAGE_LIST && yVar != y.GROUP_LIST) {
            return new w(field, i2, yVar, null, null, 0, false, z, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static w a(Field field, int i2, y yVar, Field field2) {
        gC(i2);
        ae.checkNotNull(field, "field");
        ae.checkNotNull(yVar, "fieldType");
        if (yVar != y.MESSAGE_LIST && yVar != y.GROUP_LIST) {
            return new w(field, i2, yVar, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static w a(Field field, int i2, y yVar, Class<?> cls) {
        gC(i2);
        ae.checkNotNull(field, "field");
        ae.checkNotNull(yVar, "fieldType");
        ae.checkNotNull(cls, "messageClass");
        return new w(field, i2, yVar, cls, null, 0, false, false, null, null, null, null, null);
    }

    public static w a(Field field, int i2, y yVar, ae.c cVar) {
        gC(i2);
        ae.checkNotNull(field, "field");
        return new w(field, i2, yVar, null, null, 0, false, false, null, null, null, cVar, null);
    }

    public static w a(Field field, int i2, y yVar, ae.c cVar, Field field2) {
        gC(i2);
        ae.checkNotNull(field, "field");
        return new w(field, i2, yVar, null, null, 0, false, false, null, null, null, cVar, field2);
    }

    public static w a(Field field, int i2, y yVar, Field field2, int i3, boolean z, ae.c cVar) {
        gC(i2);
        ae.checkNotNull(field, "field");
        ae.checkNotNull(yVar, "fieldType");
        ae.checkNotNull(field2, "presenceField");
        if (field2 == null || gD(i3)) {
            return new w(field, i2, yVar, null, field2, i3, false, z, null, null, null, cVar, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(i3)));
    }

    public static w a(int i2, y yVar, bi biVar, Class<?> cls, boolean z, ae.c cVar) {
        boolean z2;
        gC(i2);
        ae.checkNotNull(yVar, "fieldType");
        ae.checkNotNull(biVar, "oneof");
        ae.checkNotNull(cls, "oneofStoredType");
        if (yVar.bVH == y.a.SCALAR) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return new w(null, i2, yVar, null, null, 0, false, z, biVar, cls, null, cVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i2 + " is of type " + yVar);
    }

    private static void gC(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("fieldNumber must be positive: ".concat(String.valueOf(i2)));
        }
    }

    public static w b(Field field, int i2, y yVar, Field field2, int i3, boolean z, ae.c cVar) {
        gC(i2);
        ae.checkNotNull(field, "field");
        ae.checkNotNull(yVar, "fieldType");
        ae.checkNotNull(field2, "presenceField");
        if (field2 == null || gD(i3)) {
            return new w(field, i2, yVar, null, field2, i3, true, z, null, null, null, cVar, null);
        }
        throw new IllegalArgumentException("presenceMask must have exactly one bit set: ".concat(String.valueOf(i3)));
    }

    public static w a(Field field, int i2, Object obj, ae.c cVar) {
        ae.checkNotNull(obj, "mapDefaultEntry");
        gC(i2);
        ae.checkNotNull(field, "field");
        return new w(field, i2, y.MAP, null, null, 0, false, true, null, null, obj, cVar, null);
    }

    private w(Field field, int i2, y yVar, Class<?> cls, Field field2, int i3, boolean z, boolean z2, bi biVar, Class<?> cls2, Object obj, ae.c cVar, Field field3) {
        this.bUo = field;
        this.bUp = yVar;
        this.bUq = cls;
        this.bUr = i2;
        this.bUs = field2;
        this.bUt = i3;
        this.required = z;
        this.bUu = z2;
        this.bUv = biVar;
        this.bUx = cls2;
        this.bUy = obj;
        this.bUz = cVar;
        this.bUw = field3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.a.w$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bUA = new int[y.values().length];

        static {
            try {
                bUA[y.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bUA[y.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bUA[y.MESSAGE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bUA[y.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static boolean gD(int i2) {
        return i2 != 0 && ((i2 + -1) & i2) == 0;
    }
}
