package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, hxF = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"})
public final class h {
    public static /* synthetic */ d a(d dVar, b bVar) {
        AppMethodBeat.i(56633);
        d a2 = a(dVar, bVar, false);
        AppMethodBeat.o(56633);
        return a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.l.b.a.a.d<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        if (r0 != false) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <M extends java.lang.reflect.Member> kotlin.l.b.a.a.d<M> a(kotlin.l.b.a.a.d<? extends M> r6, kotlin.l.b.a.b.b.b r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.h.a(kotlin.l.b.a.a.d, kotlin.l.b.a.b.b.b, boolean):kotlin.l.b.a.a.d");
    }

    public static final Method a(Class<?> cls, b bVar) {
        AppMethodBeat.i(56634);
        p.h(cls, "$this$getUnboxMethod");
        p.h(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", new Class[0]);
            p.g(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            AppMethodBeat.o(56634);
            return declaredMethod;
        } catch (NoSuchMethodException e2) {
            w wVar = new w("No unbox method found in inline class: " + cls + " (calling " + bVar + ')');
            AppMethodBeat.o(56634);
            throw wVar;
        }
    }

    public static final Method b(Class<?> cls, b bVar) {
        AppMethodBeat.i(56635);
        p.h(cls, "$this$getBoxMethod");
        p.h(bVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", a(cls, bVar).getReturnType());
            p.g(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            AppMethodBeat.o(56635);
            return declaredMethod;
        } catch (NoSuchMethodException e2) {
            w wVar = new w("No box method found in inline class: " + cls + " (calling " + bVar + ')');
            AppMethodBeat.o(56635);
            throw wVar;
        }
    }

    public static final Class<?> c(ab abVar) {
        AppMethodBeat.i(56636);
        p.h(abVar, "$this$toInlineClass");
        Class<?> a2 = a(abVar.hKE().hzS());
        AppMethodBeat.o(56636);
        return a2;
    }

    public static final Class<?> a(kotlin.l.b.a.b.b.l lVar) {
        Class<?> cls;
        AppMethodBeat.i(56637);
        if (!(lVar instanceof e) || !((e) lVar).hzI()) {
            cls = null;
        } else {
            cls = ae.a((e) lVar);
            if (cls == null) {
                w wVar = new w("Class object for the class " + ((e) lVar).hAH() + " cannot be found (classId=" + a.c((kotlin.l.b.a.b.b.h) lVar) + ')');
                AppMethodBeat.o(56637);
                throw wVar;
            }
        }
        AppMethodBeat.o(56637);
        return cls;
    }

    private static final ab c(b bVar) {
        aj ajVar;
        AppMethodBeat.i(56638);
        ak hAr = bVar.hAr();
        ak hAs = bVar.hAs();
        if (hAr != null) {
            ab hBy = hAr.hBy();
            AppMethodBeat.o(56638);
            return hBy;
        } else if (hAs == null) {
            AppMethodBeat.o(56638);
            return null;
        } else if (bVar instanceof k) {
            ab hBy2 = hAs.hBy();
            AppMethodBeat.o(56638);
            return hBy2;
        } else {
            kotlin.l.b.a.b.b.l hzx = bVar.hzx();
            if (!(hzx instanceof e)) {
                hzx = null;
            }
            e eVar = (e) hzx;
            if (eVar != null) {
                ajVar = eVar.hAG();
            } else {
                ajVar = null;
            }
            aj ajVar2 = ajVar;
            AppMethodBeat.o(56638);
            return ajVar2;
        }
    }

    public static final Object a(Object obj, b bVar) {
        Class<?> c2;
        Method a2;
        AppMethodBeat.i(56639);
        p.h(bVar, "descriptor");
        if (!(bVar instanceof ah) || !kotlin.l.b.a.b.j.e.a((ax) bVar)) {
            ab c3 = c(bVar);
            if (c3 == null || (c2 = c(c3)) == null || (a2 = a(c2, bVar)) == null) {
                AppMethodBeat.o(56639);
                return obj;
            }
            Object invoke = a2.invoke(obj, new Object[0]);
            AppMethodBeat.o(56639);
            return invoke;
        }
        AppMethodBeat.o(56639);
        return obj;
    }
}
