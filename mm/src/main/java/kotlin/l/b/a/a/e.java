package kotlin.l.b.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001e*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\b\u001b\u001c\u001d\u001e\u001f !\"B3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0004R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0001\u0007#$%&'()¨\u0006*"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflection"})
public abstract class e<M extends Member> implements d<M> {
    public static final d Tck = new d((byte) 0);
    private final List<Type> TbO;
    final M Tch;
    final Type Tci;
    final Class<?> Tcj;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002d, code lost:
        if (r0 == null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private e(M r4, java.lang.reflect.Type r5, java.lang.Class<?> r6, java.lang.reflect.Type[] r7) {
        /*
            r3 = this;
            r3.<init>()
            r3.Tch = r4
            r3.Tci = r5
            r3.Tcj = r6
            java.lang.Class<?> r0 = r3.Tcj
            if (r0 == 0) goto L_0x002f
            kotlin.g.b.ad r1 = new kotlin.g.b.ad
            r2 = 2
            r1.<init>(r2)
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            r1.add(r0)
            r1.eS(r7)
            java.util.ArrayList<java.lang.Object> r0 = r1.dtS
            int r0 = r0.size()
            java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
            java.util.List r0 = kotlin.a.j.listOf(r0)
            if (r0 != 0) goto L_0x0033
        L_0x002f:
            java.util.List r0 = kotlin.a.e.W(r7)
        L_0x0033:
            r3.TbO = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    public /* synthetic */ e(Member member, Type type, Class cls, Type[] typeArr, byte b2) {
        this(member, type, cls, typeArr);
    }

    public void ah(Object[] objArr) {
        p.h(objArr, "args");
        d.a.a(this, objArr);
    }

    @Override // kotlin.l.b.a.a.d
    public final M hyV() {
        return this.Tch;
    }

    @Override // kotlin.l.b.a.a.d
    public final Type hyW() {
        return this.Tci;
    }

    @Override // kotlin.l.b.a.a.d
    public final List<Type> hyX() {
        return this.TbO;
    }

    /* access modifiers changed from: protected */
    public final void fk(Object obj) {
        if (obj == null || !this.Tch.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    /* renamed from: kotlin.l.b.a.a.e$e  reason: collision with other inner class name */
    public static final class C2266e extends e<Constructor<?>> {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C2266e(java.lang.reflect.Constructor<?> r7) {
            /*
                r6 = this;
                java.lang.String r0 = "constructor"
                kotlin.g.b.p.h(r7, r0)
                r1 = r7
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.Class r2 = r7.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.g.b.p.g(r2, r0)
                java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
                java.lang.Class r0 = r7.getDeclaringClass()
                java.lang.String r3 = "klass"
                kotlin.g.b.p.g(r0, r3)
                java.lang.Class r3 = r0.getDeclaringClass()
                if (r3 == 0) goto L_0x0045
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L_0x0045
            L_0x002f:
                java.lang.reflect.Type[] r4 = r7.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                kotlin.g.b.p.g(r4, r0)
                r5 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                r0 = 56597(0xdd15, float:7.9309E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
                return
            L_0x0045:
                r3 = 0
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.C2266e.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            AppMethodBeat.i(56596);
            p.h(objArr, "args");
            ah(objArr);
            Object newInstance = ((Constructor) this.Tch).newInstance(Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(56596);
            return newInstance;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class c extends e<Constructor<?>> implements c {
        private final Object Tcl;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(java.lang.reflect.Constructor<?> r8, java.lang.Object r9) {
            /*
                r7 = this;
                r6 = 56595(0xdd13, float:7.9306E-41)
                java.lang.String r0 = "constructor"
                kotlin.g.b.p.h(r8, r0)
                r1 = r8
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.Class r2 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.g.b.p.g(r2, r0)
                java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
                r3 = 0
                java.lang.reflect.Type[] r4 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                kotlin.g.b.p.g(r4, r0)
                r5 = 0
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                r7.Tcl = r9
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.c.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            AppMethodBeat.i(56594);
            p.h(objArr, "args");
            ah(objArr);
            ad adVar = new ad(2);
            adVar.add(this.Tcl);
            adVar.eS(objArr);
            Object newInstance = ((Constructor) this.Tch).newInstance(adVar.toArray(new Object[adVar.dtS.size()]));
            AppMethodBeat.o(56594);
            return newInstance;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class b extends e<Constructor<?>> {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                r6 = 56593(0xdd11, float:7.9304E-41)
                r5 = 0
                java.lang.String r0 = "constructor"
                kotlin.g.b.p.h(r8, r0)
                r1 = r8
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.Class r2 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.g.b.p.g(r2, r0)
                java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r3 = "constructor.genericParameterTypes"
                kotlin.g.b.p.g(r0, r3)
                int r3 = r0.length
                r4 = 1
                if (r3 > r4) goto L_0x0034
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r5]
            L_0x0029:
                r3 = 0
                java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x0034:
                int r3 = r0.length
                int r3 = r3 + -1
                java.lang.Object[] r4 = kotlin.a.e.copyOfRange(r0, r5, r3)
                if (r4 != 0) goto L_0x0029
                kotlin.t r0 = new kotlin.t
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.b.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            AppMethodBeat.i(56592);
            p.h(objArr, "args");
            ah(objArr);
            ad adVar = new ad(2);
            adVar.eS(objArr);
            adVar.add(null);
            Object newInstance = ((Constructor) this.Tch).newInstance(adVar.toArray(new Object[adVar.dtS.size()]));
            AppMethodBeat.o(56592);
            return newInstance;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a extends e<Constructor<?>> implements c {
        private final Object Tcl;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.reflect.Constructor<?> r8, java.lang.Object r9) {
            /*
                r7 = this;
                r6 = 56591(0xdd0f, float:7.9301E-41)
                r5 = 0
                java.lang.String r0 = "constructor"
                kotlin.g.b.p.h(r8, r0)
                r1 = r8
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.Class r2 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.g.b.p.g(r2, r0)
                java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r3 = "constructor.genericParameterTypes"
                kotlin.g.b.p.g(r0, r3)
                int r3 = r0.length
                r4 = 2
                if (r3 > r4) goto L_0x0036
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r5]
            L_0x0029:
                r3 = 0
                java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                r7.Tcl = r9
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x0036:
                int r3 = r0.length
                int r3 = r3 + -1
                r4 = 1
                java.lang.Object[] r4 = kotlin.a.e.copyOfRange(r0, r4, r3)
                if (r4 != 0) goto L_0x0029
                kotlin.t r0 = new kotlin.t
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.a.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.l.b.a.a.d
        public final Object ag(Object[] objArr) {
            AppMethodBeat.i(56590);
            p.h(objArr, "args");
            ah(objArr);
            ad adVar = new ad(3);
            adVar.add(this.Tcl);
            adVar.eS(objArr);
            adVar.add(null);
            Object newInstance = ((Constructor) this.Tch).newInstance(adVar.toArray(new Object[adVar.dtS.size()]));
            AppMethodBeat.o(56590);
            return newInstance;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0001\u0006\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", FirebaseAnalytics.b.METHOD, "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", "instance", "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "kotlin-reflection"})
    public static abstract class h extends e<Method> {
        private final boolean Tcm;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private h(java.lang.reflect.Method r7, boolean r8, java.lang.reflect.Type[] r9) {
            /*
                r6 = this;
                r1 = r7
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.reflect.Type r2 = r7.getGenericReturnType()
                java.lang.String r0 = "method.genericReturnType"
                kotlin.g.b.p.g(r2, r0)
                if (r8 == 0) goto L_0x0024
                java.lang.Class r3 = r7.getDeclaringClass()
            L_0x0013:
                r5 = 0
                r0 = r6
                r4 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                java.lang.reflect.Type r0 = r6.Tci
                java.lang.Class r1 = java.lang.Void.TYPE
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                r6.Tcm = r0
                return
            L_0x0024:
                r3 = 0
                goto L_0x0013
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[]):void");
        }

        public /* synthetic */ h(Method method, Type[] typeArr) {
            this(method, false, typeArr);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* synthetic */ h(java.lang.reflect.Method r3, boolean r4, java.lang.reflect.Type[] r5, int r6) {
            /*
                r2 = this;
                r0 = r6 & 2
                if (r0 == 0) goto L_0x0023
                int r0 = r3.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L_0x0021
                r0 = 1
            L_0x000f:
                r1 = r6 & 4
                if (r1 == 0) goto L_0x001d
                java.lang.reflect.Type[] r5 = r3.getGenericParameterTypes()
                java.lang.String r1 = "method.genericParameterTypes"
                kotlin.g.b.p.g(r5, r1)
            L_0x001d:
                r2.<init>(r3, r0, r5)
                return
            L_0x0021:
                r0 = 0
                goto L_0x000f
            L_0x0023:
                r0 = r4
                goto L_0x000f
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[], int):void");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class f extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, null, 6);
                p.h(method, FirebaseAnalytics.b.METHOD);
                AppMethodBeat.i(56624);
                AppMethodBeat.o(56624);
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56623);
                p.h(objArr, "args");
                ah(objArr);
                Object b2 = b(null, objArr);
                AppMethodBeat.o(56623);
                return b2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class d extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, null, 6);
                p.h(method, FirebaseAnalytics.b.METHOD);
                AppMethodBeat.i(56620);
                AppMethodBeat.o(56620);
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                Object[] copyOfRange;
                AppMethodBeat.i(56619);
                p.h(objArr, "args");
                ah(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    copyOfRange = new Object[0];
                } else {
                    copyOfRange = kotlin.a.e.copyOfRange(objArr, 1, objArr.length);
                    if (copyOfRange == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(56619);
                        throw tVar;
                    }
                }
                Object b2 = b(obj, copyOfRange);
                AppMethodBeat.o(56619);
                return b2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        /* renamed from: kotlin.l.b.a.a.e$h$e  reason: collision with other inner class name */
        public static final class C2269e extends h {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C2269e(Method method) {
                super(method, true, null, 4);
                p.h(method, FirebaseAnalytics.b.METHOD);
                AppMethodBeat.i(56622);
                AppMethodBeat.o(56622);
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                Object[] copyOfRange;
                AppMethodBeat.i(56621);
                p.h(objArr, "args");
                ah(objArr);
                fk(kotlin.a.e.R(objArr));
                if (objArr.length <= 1) {
                    copyOfRange = new Object[0];
                } else {
                    copyOfRange = kotlin.a.e.copyOfRange(objArr, 1, objArr.length);
                    if (copyOfRange == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(56621);
                        throw tVar;
                    }
                }
                Object b2 = b(null, copyOfRange);
                AppMethodBeat.o(56621);
                return b2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class c extends h implements c {
            private final Object Tcl;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public c(java.lang.reflect.Method r5, java.lang.Object r6) {
                /*
                    r4 = this;
                    r3 = 56618(0xdd2a, float:7.9339E-41)
                    r2 = 1
                    java.lang.String r0 = "method"
                    kotlin.g.b.p.h(r5, r0)
                    java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
                    java.lang.String r1 = "method.genericParameterTypes"
                    kotlin.g.b.p.g(r0, r1)
                    int r1 = r0.length
                    if (r1 > r2) goto L_0x0025
                    r0 = 0
                    java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
                L_0x001a:
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r4.<init>(r5, r0)
                    r4.Tcl = r6
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                L_0x0025:
                    int r1 = r0.length
                    java.lang.Object[] r0 = kotlin.a.e.copyOfRange(r0, r2, r1)
                    if (r0 != 0) goto L_0x001a
                    kotlin.t r0 = new kotlin.t
                    java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                    r0.<init>(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.h.c.<init>(java.lang.reflect.Method, java.lang.Object):void");
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56617);
                p.h(objArr, "args");
                ah(objArr);
                ad adVar = new ad(2);
                adVar.add(this.Tcl);
                adVar.eS(objArr);
                Object b2 = b(null, adVar.toArray(new Object[adVar.dtS.size()]));
                AppMethodBeat.o(56617);
                return b2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class a extends h implements c {
            private final Object Tcl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4);
                p.h(method, FirebaseAnalytics.b.METHOD);
                AppMethodBeat.i(56614);
                this.Tcl = obj;
                AppMethodBeat.o(56614);
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56613);
                p.h(objArr, "args");
                ah(objArr);
                Object b2 = b(this.Tcl, objArr);
                AppMethodBeat.o(56613);
                return b2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class b extends h implements c {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4);
                p.h(method, FirebaseAnalytics.b.METHOD);
                AppMethodBeat.i(56616);
                AppMethodBeat.o(56616);
            }

            @Override // kotlin.l.b.a.a.d
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56615);
                p.h(objArr, "args");
                ah(objArr);
                Object b2 = b(null, objArr);
                AppMethodBeat.o(56615);
                return b2;
            }
        }

        /* access modifiers changed from: protected */
        public final Object b(Object obj, Object[] objArr) {
            p.h(objArr, "args");
            return this.Tcm ? x.SXb : ((Method) this.Tch).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "kotlin-reflection"})
    public static abstract class f extends e<Field> {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private f(java.lang.reflect.Field r7, boolean r8) {
            /*
                r6 = this;
                r5 = 0
                r1 = r7
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.reflect.Type r2 = r7.getGenericType()
                java.lang.String r0 = "field.genericType"
                kotlin.g.b.p.g(r2, r0)
                if (r8 == 0) goto L_0x001b
                java.lang.Class r3 = r7.getDeclaringClass()
            L_0x0014:
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r5]
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                return
            L_0x001b:
                r3 = 0
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.f.<init>(java.lang.reflect.Field, boolean):void");
        }

        public /* synthetic */ f(Field field, boolean z, byte b2) {
            this(field, z);
        }

        @Override // kotlin.l.b.a.a.d
        public Object ag(Object[] objArr) {
            p.h(objArr, "args");
            ah(objArr);
            return ((Field) this.Tch).get(this.Tcj != null ? kotlin.a.e.Q(objArr) : null);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        /* renamed from: kotlin.l.b.a.a.e$f$e  reason: collision with other inner class name */
        public static final class C2267e extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C2267e(Field field) {
                super(field, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56604);
                AppMethodBeat.o(56604);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        public static final class c extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56601);
                AppMethodBeat.o(56601);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
        public static final class d extends f {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56603);
                AppMethodBeat.o(56603);
            }

            @Override // kotlin.l.b.a.a.e
            public final void ah(Object[] objArr) {
                AppMethodBeat.i(56602);
                p.h(objArr, "args");
                super.ah(objArr);
                fk(kotlin.a.e.R(objArr));
                AppMethodBeat.o(56602);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class a extends f implements c {
            private final Object Tcl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56599);
                this.Tcl = obj;
                AppMethodBeat.o(56599);
            }

            @Override // kotlin.l.b.a.a.d, kotlin.l.b.a.a.e.f
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56598);
                p.h(objArr, "args");
                ah(objArr);
                Object obj = ((Field) this.Tch).get(this.Tcl);
                AppMethodBeat.o(56598);
                return obj;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"})
        public static final class b extends f implements c {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56600);
                AppMethodBeat.o(56600);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflection"})
    public static abstract class g extends e<Field> {
        private final boolean qEX;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private g(java.lang.reflect.Field r8, boolean r9, boolean r10) {
            /*
                r7 = this;
                r5 = 0
                r1 = r8
                java.lang.reflect.Member r1 = (java.lang.reflect.Member) r1
                java.lang.Class r2 = java.lang.Void.TYPE
                java.lang.String r0 = "Void.TYPE"
                kotlin.g.b.p.g(r2, r0)
                java.lang.reflect.Type r2 = (java.lang.reflect.Type) r2
                if (r10 == 0) goto L_0x002a
                java.lang.Class r3 = r8.getDeclaringClass()
            L_0x0014:
                r0 = 1
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r0]
                java.lang.reflect.Type r0 = r8.getGenericType()
                java.lang.String r6 = "field.genericType"
                kotlin.g.b.p.g(r0, r6)
                r4[r5] = r0
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                r7.qEX = r9
                return
            L_0x002a:
                r3 = 0
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.e.g.<init>(java.lang.reflect.Field, boolean, boolean):void");
        }

        public /* synthetic */ g(Field field, boolean z, boolean z2, byte b2) {
            this(field, z, z2);
        }

        @Override // kotlin.l.b.a.a.e
        public void ah(Object[] objArr) {
            p.h(objArr, "args");
            e.super.ah(objArr);
            if (this.qEX && kotlin.a.e.S(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // kotlin.l.b.a.a.d
        public Object ag(Object[] objArr) {
            p.h(objArr, "args");
            ah(objArr);
            ((Field) this.Tch).set(this.Tcj != null ? kotlin.a.e.Q(objArr) : null, kotlin.a.e.S(objArr));
            return x.SXb;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
        /* renamed from: kotlin.l.b.a.a.e$g$e  reason: collision with other inner class name */
        public static final class C2268e extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C2268e(Field field, boolean z) {
                super(field, z, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56612);
                AppMethodBeat.o(56612);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"})
        public static final class c extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z) {
                super(field, z, true, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56609);
                AppMethodBeat.o(56609);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"})
        public static final class d extends g {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z) {
                super(field, z, true, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56611);
                AppMethodBeat.o(56611);
            }

            @Override // kotlin.l.b.a.a.e, kotlin.l.b.a.a.e.g
            public final void ah(Object[] objArr) {
                AppMethodBeat.i(56610);
                p.h(objArr, "args");
                super.ah(objArr);
                fk(kotlin.a.e.R(objArr));
                AppMethodBeat.o(56610);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class a extends g implements c {
            private final Object Tcl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z, Object obj) {
                super(field, z, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56606);
                this.Tcl = obj;
                AppMethodBeat.o(56606);
            }

            @Override // kotlin.l.b.a.a.d, kotlin.l.b.a.a.e.g
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56605);
                p.h(objArr, "args");
                ah(objArr);
                ((Field) this.Tch).set(this.Tcl, kotlin.a.e.Q(objArr));
                x xVar = x.SXb;
                AppMethodBeat.o(56605);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
        public static final class b extends g implements c {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z) {
                super(field, z, false, (byte) 0);
                p.h(field, "field");
                AppMethodBeat.i(56608);
                AppMethodBeat.o(56608);
            }

            @Override // kotlin.l.b.a.a.d, kotlin.l.b.a.a.e.g
            public final Object ag(Object[] objArr) {
                AppMethodBeat.i(56607);
                p.h(objArr, "args");
                ah(objArr);
                ((Field) this.Tch).set(null, kotlin.a.e.S(objArr));
                x xVar = x.SXb;
                AppMethodBeat.o(56607);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\b¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\b¢\u0006\u0002\u0010\u0006J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\b¢\u0006\u0002\u0010\u0006¨\u0006\t"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", "", "()V", "dropFirst", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstAndLast", "dropLast", "kotlin-reflection"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }
}
