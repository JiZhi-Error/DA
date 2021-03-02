package kotlin.e;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
public final class b {
    public static final a SYe;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        AppMethodBeat.i(128992);
        int hxO = hxO();
        if (hxO >= 65544) {
            try {
                Object newInstance3 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                p.g(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance3 == null) {
                    try {
                        t tVar = new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        AppMethodBeat.o(128992);
                        throw tVar;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + a.class.getClassLoader()).initCause(e2);
                        p.g(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        AppMethodBeat.o(128992);
                        throw initCause;
                    }
                } else {
                    aVar = (a) newInstance3;
                    SYe = aVar;
                    AppMethodBeat.o(128992);
                }
            } catch (ClassNotFoundException e3) {
                try {
                    newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    p.g(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        AppMethodBeat.o(128992);
                        throw tVar2;
                    }
                    aVar = (a) newInstance2;
                } catch (ClassNotFoundException e4) {
                }
            } catch (ClassCastException e5) {
                ClassLoader classLoader2 = newInstance2.getClass().getClassLoader();
                Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader2 + ", base type classloader: " + a.class.getClassLoader()).initCause(e5);
                p.g(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.o(128992);
                throw initCause2;
            }
        }
        if (hxO >= 65543) {
            try {
                Object newInstance4 = Class.forName("kotlin.e.a.a").newInstance();
                p.g(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                if (newInstance4 == null) {
                    try {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        AppMethodBeat.o(128992);
                        throw tVar3;
                    } catch (ClassCastException e6) {
                        ClassLoader classLoader3 = newInstance4.getClass().getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + a.class.getClassLoader()).initCause(e6);
                        p.g(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        AppMethodBeat.o(128992);
                        throw initCause3;
                    }
                } else {
                    aVar = (a) newInstance4;
                    SYe = aVar;
                    AppMethodBeat.o(128992);
                }
            } catch (ClassNotFoundException e7) {
                try {
                    newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    p.g(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    if (newInstance == null) {
                        t tVar4 = new t("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        AppMethodBeat.o(128992);
                        throw tVar4;
                    }
                    aVar = (a) newInstance;
                } catch (ClassNotFoundException e8) {
                }
            } catch (ClassCastException e9) {
                ClassLoader classLoader4 = newInstance.getClass().getClassLoader();
                Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader4 + ", base type classloader: " + a.class.getClassLoader()).initCause(e9);
                p.g(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.o(128992);
                throw initCause4;
            }
        }
        aVar = new a();
        SYe = aVar;
        AppMethodBeat.o(128992);
    }

    private static final int hxO() {
        int i2;
        int i3 = NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        AppMethodBeat.i(128991);
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            AppMethodBeat.o(128991);
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int a2 = n.a((CharSequence) property, '.', 0, false, 6);
        if (a2 < 0) {
            try {
                i2 = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException e2) {
                i2 = 65542;
            }
            AppMethodBeat.o(128991);
            return i2;
        }
        int a3 = n.a((CharSequence) property, '.', a2 + 1, false, 4);
        if (a3 < 0) {
            a3 = property.length();
        }
        if (property == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(128991);
            throw tVar;
        }
        String substring = property.substring(0, a2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int i4 = a2 + 1;
        if (property == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(128991);
            throw tVar2;
        }
        String substring2 = property.substring(i4, a3);
        p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            i3 = (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException e3) {
        }
        AppMethodBeat.o(128991);
        return i3;
    }
}
