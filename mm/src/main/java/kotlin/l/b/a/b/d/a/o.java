package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class o {
    public static final b Tph = new b("kotlin.jvm.JvmField");
    public static final a Tpi = a.p(new b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57615);
        switch (i2) {
            case 1:
            case 3:
            case 7:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 7:
            case 9:
                i3 = 2;
                break;
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
            case 7:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi";
                break;
            case 2:
                objArr[0] = "typeAliasName";
                break;
            case 4:
            case 5:
                objArr[0] = "name";
                break;
            case 6:
            case 8:
                objArr[0] = "propertyName";
                break;
            case 10:
                objArr[0] = "propertyDescriptor";
                break;
            case 11:
            case 12:
                objArr[0] = "companionObject";
                break;
            case 13:
                objArr[0] = "memberDescriptor";
                break;
            default:
                objArr[0] = "baseName";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "getSyntheticMethodNameForAnnotatedProperty";
                break;
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JvmAbi";
                break;
            case 3:
                objArr[1] = "getSyntheticMethodNameForAnnotatedTypeAlias";
                break;
            case 7:
                objArr[1] = "getterName";
                break;
            case 9:
                objArr[1] = "setterName";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 7:
            case 9:
                break;
            case 2:
                objArr[2] = "getSyntheticMethodNameForAnnotatedTypeAlias";
                break;
            case 4:
                objArr[2] = "isGetterName";
                break;
            case 5:
                objArr[2] = "isSetterName";
                break;
            case 6:
                objArr[2] = "getterName";
                break;
            case 8:
                objArr[2] = "setterName";
                break;
            case 10:
                objArr[2] = "isPropertyWithBackingFieldInOuterClass";
                break;
            case 11:
                objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
                break;
            case 12:
                objArr[2] = "isMappedIntrinsicCompanionObject";
                break;
            case 13:
                objArr[2] = "hasJvmFieldAnnotation";
                break;
            default:
                objArr[2] = "getSyntheticMethodNameForAnnotatedProperty";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 3:
            case 7:
            case 9:
                illegalStateException = new IllegalStateException(format);
                break;
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57615);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57614);
        AppMethodBeat.o(57614);
    }

    public static boolean btH(String str) {
        AppMethodBeat.i(57608);
        if (str == null) {
            atM(4);
        }
        if (str.startsWith("get") || str.startsWith("is")) {
            AppMethodBeat.o(57608);
            return true;
        }
        AppMethodBeat.o(57608);
        return false;
    }

    public static boolean btI(String str) {
        AppMethodBeat.i(57609);
        if (str == null) {
            atM(5);
        }
        boolean startsWith = str.startsWith("set");
        AppMethodBeat.o(57609);
        return startsWith;
    }

    public static String btJ(String str) {
        AppMethodBeat.i(57610);
        if (str == null) {
            atM(6);
        }
        if (!btL(str)) {
            str = "get" + kotlin.l.b.a.b.n.a.a.but(str);
        }
        if (str == null) {
            atM(7);
        }
        AppMethodBeat.o(57610);
        return str;
    }

    public static String btK(String str) {
        AppMethodBeat.i(57611);
        if (str == null) {
            atM(8);
        }
        String str2 = "set" + (btL(str) ? str.substring(2) : kotlin.l.b.a.b.n.a.a.but(str));
        if (str2 == null) {
            atM(9);
        }
        AppMethodBeat.o(57611);
        return str2;
    }

    private static boolean btL(String str) {
        AppMethodBeat.i(57612);
        if (!str.startsWith("is")) {
            AppMethodBeat.o(57612);
            return false;
        } else if (str.length() == 2) {
            AppMethodBeat.o(57612);
            return false;
        } else {
            char charAt = str.charAt(2);
            if ('a' > charAt || charAt > 'z') {
                AppMethodBeat.o(57612);
                return true;
            }
            AppMethodBeat.o(57612);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(kotlin.l.b.a.b.b.ah r5) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.o.d(kotlin.l.b.a.b.b.ah):boolean");
    }
}
