package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.l.b.a.a.e;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.j.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.w;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"})
public final class g<M extends Member> implements d<M> {
    private final a Tcn;
    private final d<M> Tco;
    private final boolean isDefault;

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: kotlin.l.b.a.a.d<? extends M extends java.lang.reflect.Member> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(b bVar, d<? extends M> dVar, boolean z) {
        int i2;
        a aVar;
        Class<?> c2;
        p.h(bVar, "descriptor");
        p.h(dVar, "caller");
        AppMethodBeat.i(56631);
        this.Tco = dVar;
        this.isDefault = z;
        g<M> gVar = this;
        ab hAu = bVar.hAu();
        if (hAu == null) {
            p.hyc();
        }
        p.g(hAu, "descriptor.returnType!!");
        Class<?> c3 = h.c(hAu);
        Method b2 = c3 != null ? h.b(c3, bVar) : null;
        if (e.f(bVar)) {
            f.a aVar2 = f.SZb;
            aVar = new a(f.SZa, new Method[0], b2);
        } else {
            if (gVar.Tco instanceof e.h.c) {
                i2 = -1;
            } else if (bVar instanceof k) {
                i2 = gVar.Tco instanceof c ? -1 : 0;
            } else {
                if (bVar.hAs() != null && !(gVar.Tco instanceof c)) {
                    kotlin.l.b.a.b.b.l hzx = bVar.hzx();
                    p.g(hzx, "descriptor.containingDeclaration");
                    if (!kotlin.l.b.a.b.j.e.D(hzx)) {
                        i2 = 1;
                    }
                }
                i2 = 0;
            }
            int i3 = gVar.isDefault ? 2 : 0;
            ArrayList arrayList = new ArrayList();
            ak hAr = bVar.hAr();
            ab hBy = hAr != null ? hAr.hBy() : null;
            if (hBy != null) {
                arrayList.add(hBy);
            } else if (bVar instanceof k) {
                kotlin.l.b.a.b.b.e hAS = ((k) bVar).hAS();
                p.g(hAS, "descriptor.constructedClass");
                if (hAS.hzG()) {
                    kotlin.l.b.a.b.b.l hzx2 = hAS.hzx();
                    if (hzx2 == null) {
                        t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(56631);
                        throw tVar;
                    }
                    arrayList.add(((kotlin.l.b.a.b.b.e) hzx2).hAG());
                }
            } else {
                kotlin.l.b.a.b.b.l hzx3 = bVar.hzx();
                p.g(hzx3, "descriptor.containingDeclaration");
                if ((hzx3 instanceof kotlin.l.b.a.b.b.e) && ((kotlin.l.b.a.b.b.e) hzx3).hzI()) {
                    arrayList.add(((kotlin.l.b.a.b.b.e) hzx3).hAG());
                }
            }
            List<av> hAw = bVar.hAw();
            p.g(hAw, "descriptor.valueParameters");
            Iterator<T> it = hAw.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hBy());
            }
            ArrayList arrayList2 = arrayList;
            int size = i3 + arrayList2.size() + i2;
            if (f.a(gVar) != size) {
                w wVar = new w("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a(gVar) + " != " + size + '\n' + "Calling: " + bVar + '\n' + "Parameter types: " + gVar.hyX() + ")\nDefault: " + gVar.isDefault);
                AppMethodBeat.o(56631);
                throw wVar;
            }
            f mY = j.mY(Math.max(i2, 0), arrayList2.size() + i2);
            Method[] methodArr = new Method[size];
            for (int i4 = 0; i4 < size; i4++) {
                methodArr[i4] = (!mY.contains(i4) || (c2 = h.c((ab) arrayList2.get(i4 - i2))) == null) ? null : h.a(c2, bVar);
            }
            aVar = new a(mY, methodArr, b2);
        }
        this.Tcn = aVar;
        AppMethodBeat.o(56631);
    }

    @Override // kotlin.l.b.a.a.d
    public final M hyV() {
        AppMethodBeat.i(56627);
        M hyV = this.Tco.hyV();
        AppMethodBeat.o(56627);
        return hyV;
    }

    @Override // kotlin.l.b.a.a.d
    public final Type hyW() {
        AppMethodBeat.i(56628);
        Type hyW = this.Tco.hyW();
        AppMethodBeat.o(56628);
        return hyW;
    }

    @Override // kotlin.l.b.a.a.d
    public final List<Type> hyX() {
        AppMethodBeat.i(56629);
        List<Type> hyX = this.Tco.hyX();
        AppMethodBeat.o(56629);
        return hyX;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"})
    static final class a {
        final f Tcp;
        final Method[] Tcq;
        final Method Tcr;

        public a(f fVar, Method[] methodArr, Method method) {
            p.h(fVar, "argumentRange");
            p.h(methodArr, "unbox");
            AppMethodBeat.i(56626);
            this.Tcp = fVar;
            this.Tcq = methodArr;
            this.Tcr = method;
            AppMethodBeat.o(56626);
        }
    }

    @Override // kotlin.l.b.a.a.d
    public final Object ag(Object[] objArr) {
        Object obj;
        AppMethodBeat.i(56630);
        p.h(objArr, "args");
        a aVar = this.Tcn;
        f fVar = aVar.Tcp;
        Method[] methodArr = aVar.Tcq;
        Method method = aVar.Tcr;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        p.g(copyOf, "java.util.Arrays.copyOf(this, size)");
        if (copyOf == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            AppMethodBeat.o(56630);
            throw tVar;
        }
        int i2 = fVar.SYU;
        int i3 = fVar.SYV;
        if (i2 <= i3) {
            while (true) {
                Method method2 = methodArr[i2];
                Object obj2 = objArr[i2];
                if (!(method2 == null || obj2 == null)) {
                    obj2 = method2.invoke(obj2, new Object[0]);
                }
                copyOf[i2] = obj2;
                if (i2 == i3) {
                    break;
                }
                i2++;
            }
        }
        Object ag = this.Tco.ag(copyOf);
        if (method == null || (obj = method.invoke(null, ag)) == null) {
            obj = ag;
        }
        AppMethodBeat.o(56630);
        return obj;
    }
}
