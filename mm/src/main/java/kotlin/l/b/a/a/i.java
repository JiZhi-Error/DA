package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.a.e;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B\u001d\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J%\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0004¢\u0006\u0002\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0018\u0019¨\u0006\u001a"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"})
public abstract class i implements d<Method> {
    private final List<Type> TbO;
    private final Type Tci;
    private final Method Tcs;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends java.lang.reflect.Type> */
    /* JADX WARN: Multi-variable type inference failed */
    private i(Method method, List<? extends Type> list) {
        this.Tcs = method;
        this.TbO = list;
        Class<?> returnType = this.Tcs.getReturnType();
        p.g(returnType, "unboxMethod.returnType");
        this.Tci = returnType;
    }

    public /* synthetic */ i(Method method, List list, byte b2) {
        this(method, list);
    }

    public final void ah(Object[] objArr) {
        p.h(objArr, "args");
        d.a.a(this, objArr);
    }

    /* Return type fixed from 'java.lang.reflect.Member' to match base method */
    @Override // kotlin.l.b.a.a.d
    public final /* bridge */ /* synthetic */ Method hyV() {
        return null;
    }

    @Override // kotlin.l.b.a.a.d
    public final List<Type> hyX() {
        return this.TbO;
    }

    @Override // kotlin.l.b.a.a.d
    public final Type hyW() {
        return this.Tci;
    }

    /* access modifiers changed from: protected */
    public final Object b(Object obj, Object[] objArr) {
        p.h(objArr, "args");
        return this.Tcs.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class b extends i {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, j.listOf(method.getDeclaringClass()), (byte) 0);
            p.h(method, "unboxMethod");
            AppMethodBeat.i(56643);
            AppMethodBeat.o(56643);
        }

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            Object[] copyOfRange;
            AppMethodBeat.i(56642);
            p.h(objArr, "args");
            ah(objArr);
            Object obj = objArr[0];
            e.d dVar = e.Tck;
            if (objArr.length <= 1) {
                copyOfRange = new Object[0];
            } else {
                copyOfRange = kotlin.a.e.copyOfRange(objArr, 1, objArr.length);
                if (copyOfRange == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(56642);
                    throw tVar;
                }
            }
            Object b2 = b(obj, copyOfRange);
            AppMethodBeat.o(56642);
            return b2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a extends i implements c {
        private final Object Tcl;

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            AppMethodBeat.i(56640);
            p.h(objArr, "args");
            ah(objArr);
            Object b2 = b(this.Tcl, objArr);
            AppMethodBeat.o(56640);
            return b2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, v.SXr, (byte) 0);
            p.h(method, "unboxMethod");
            AppMethodBeat.i(56641);
            this.Tcl = obj;
            AppMethodBeat.o(56641);
        }
    }
}
