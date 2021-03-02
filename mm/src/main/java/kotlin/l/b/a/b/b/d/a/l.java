package kotlin.l.b.a.b.b.d.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.b;

final class l {
    public static final l TmT = new l();

    static {
        AppMethodBeat.i(57391);
        AppMethodBeat.o(57391);
    }

    private l() {
    }

    public static String d(Method method) {
        AppMethodBeat.i(57388);
        p.h(method, FirebaseAnalytics.b.METHOD);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> cls : parameterTypes) {
            p.g(cls, "parameterType");
            sb.append(b.bC(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        p.g(returnType, "method.returnType");
        sb.append(b.bC(returnType));
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(57388);
        return sb2;
    }

    public static String a(Constructor<?> constructor) {
        AppMethodBeat.i(57389);
        p.h(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (Class<?> cls : parameterTypes) {
            p.g(cls, "parameterType");
            sb.append(b.bC(cls));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(57389);
        return sb2;
    }

    public static String f(Field field) {
        AppMethodBeat.i(57390);
        p.h(field, "field");
        Class<?> type = field.getType();
        p.g(type, "field.type");
        String bC = b.bC(type);
        AppMethodBeat.o(57390);
        return bC;
    }
}
