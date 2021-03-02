package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

final class a {
    private static C2279a TmU;
    public static final a TmV = new a();

    /* renamed from: kotlin.l.b.a.b.b.d.b.a$a  reason: collision with other inner class name */
    public static final class C2279a {
        final Method TmW;
        final Method TmX;

        public C2279a(Method method, Method method2) {
            this.TmW = method;
            this.TmX = method2;
        }
    }

    static {
        AppMethodBeat.i(57394);
        AppMethodBeat.o(57394);
    }

    private a() {
    }

    private static C2279a a(Member member) {
        AppMethodBeat.i(57392);
        p.h(member, "member");
        Class<?> cls = member.getClass();
        try {
            C2279a aVar = new C2279a(cls.getMethod("getParameters", new Class[0]), b.bx(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
            AppMethodBeat.o(57392);
            return aVar;
        } catch (NoSuchMethodException e2) {
            C2279a aVar2 = new C2279a(null, null);
            AppMethodBeat.o(57392);
            return aVar2;
        }
    }

    public static List<String> b(Member member) {
        AppMethodBeat.i(57393);
        p.h(member, "member");
        C2279a aVar = TmU;
        if (aVar == null) {
            aVar = a(member);
            TmU = aVar;
        }
        Method method = aVar.TmW;
        if (method == null) {
            AppMethodBeat.o(57393);
            return null;
        }
        Method method2 = aVar.TmX;
        if (method2 == null) {
            AppMethodBeat.o(57393);
            return null;
        }
        Object invoke = method.invoke(member, new Object[0]);
        if (invoke == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<*>");
            AppMethodBeat.o(57393);
            throw tVar;
        }
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = method2.invoke(obj, new Object[0]);
            if (invoke2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(57393);
                throw tVar2;
            }
            arrayList.add((String) invoke2);
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57393);
        return arrayList2;
    }
}
