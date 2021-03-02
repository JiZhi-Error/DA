package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.y;
import kotlin.l.c;
import kotlin.l.k;
import kotlin.l.o;
import kotlin.l.q;
import kotlin.l.r;
import kotlin.m;
import kotlin.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, hxF = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "", "kotlin-reflection"})
public final class t implements o {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(t.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), aa.a(new y(aa.bp(t.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), aa.a(new y(aa.bp(t.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final y.a Tbp;
    private final y.a Tbq = y.ak(new b(this));
    private final y.a Tbr = y.ak(new a(this));
    public final ab Tbs;

    static {
        AppMethodBeat.i(56494);
        AppMethodBeat.o(56494);
    }

    public t(ab abVar, kotlin.g.a.a<? extends Type> aVar) {
        p.h(abVar, "type");
        p.h(aVar, "computeJavaType");
        AppMethodBeat.i(56501);
        this.Tbs = abVar;
        this.Tbp = y.ak(aVar);
        AppMethodBeat.o(56501);
    }

    public static final /* synthetic */ c a(t tVar, ab abVar) {
        AppMethodBeat.i(56502);
        c a2 = tVar.a(abVar);
        AppMethodBeat.o(56502);
        return a2;
    }

    private final c a(ab abVar) {
        ab hBy;
        AppMethodBeat.i(56497);
        h hzS = abVar.hKE().hzS();
        if (hzS instanceof e) {
            Class<?> a2 = ae.a((e) hzS);
            if (a2 == null) {
                AppMethodBeat.o(56497);
                return null;
            } else if (a2.isArray()) {
                av avVar = (av) j.kx(abVar.hKB());
                if (avVar == null || (hBy = avVar.hBy()) == null) {
                    g gVar = new g(a2);
                    AppMethodBeat.o(56497);
                    return gVar;
                }
                p.g(hBy, "type.arguments.singleOrN…return KClassImpl(jClass)");
                c a3 = a(hBy);
                if (a3 == null) {
                    w wVar = new w("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
                    AppMethodBeat.o(56497);
                    throw wVar;
                }
                g gVar2 = new g(kotlin.l.b.a.b.b.d.b.b.bD(kotlin.g.a.a(kotlin.l.b.a.a(a3))));
                AppMethodBeat.o(56497);
                return gVar2;
            } else if (!bc.aE(abVar)) {
                Class<?> bz = kotlin.l.b.a.b.b.d.b.b.bz(a2);
                if (bz != null) {
                    a2 = bz;
                }
                g gVar3 = new g(a2);
                AppMethodBeat.o(56497);
                return gVar3;
            } else {
                g gVar4 = new g(a2);
                AppMethodBeat.o(56497);
                return gVar4;
            }
        } else if (hzS instanceof as) {
            v vVar = new v((as) hzS);
            AppMethodBeat.o(56497);
            return vVar;
        } else if (hzS instanceof ar) {
            n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
            AppMethodBeat.o(56497);
            throw nVar;
        } else {
            AppMethodBeat.o(56497);
            return null;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56498);
        if (!(obj instanceof t) || !p.j(this.Tbs, ((t) obj).Tbs)) {
            AppMethodBeat.o(56498);
            return false;
        }
        AppMethodBeat.o(56498);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(56499);
        int hashCode = this.Tbs.hashCode();
        AppMethodBeat.o(56499);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(56500);
        aa aaVar = aa.TbF;
        String b2 = aa.b(this.Tbs);
        AppMethodBeat.o(56500);
        return b2;
    }

    public final Type hyT() {
        AppMethodBeat.i(56495);
        Type type = (Type) this.Tbp.invoke();
        AppMethodBeat.o(56495);
        return type;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<c> {
        final /* synthetic */ t Tbt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(0);
            this.Tbt = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(56493);
            c a2 = t.a(this.Tbt, this.Tbt.Tbs);
            AppMethodBeat.o(56493);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<List<? extends kotlin.l.q>> {
        final /* synthetic */ t Tbt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t tVar) {
            super(0);
            this.Tbt = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.q> invoke() {
            kotlin.l.q qVar;
            AppMethodBeat.i(56492);
            List<av> hKB = this.Tbt.Tbs.hKB();
            if (hKB.isEmpty()) {
                v vVar = v.SXr;
                AppMethodBeat.o(56492);
                return vVar;
            }
            f a2 = g.a(kotlin.k.PUBLICATION, new b(this));
            List<av> list = hKB;
            ArrayList arrayList = new ArrayList(j.a(list, 10));
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (t2.hLH()) {
                    q.a aVar = kotlin.l.q.SZp;
                    qVar = kotlin.l.q.hyp();
                } else {
                    ab hBy = t2.hBy();
                    p.g(hBy, "typeProjection.type");
                    t tVar = new t(hBy, new C2374a(i2, this, a2));
                    switch (u.$EnumSwitchMapping$0[t2.hLI().ordinal()]) {
                        case 1:
                            q.a aVar2 = kotlin.l.q.SZp;
                            t tVar2 = tVar;
                            p.h(tVar2, "type");
                            qVar = new kotlin.l.q(r.INVARIANT, tVar2);
                            continue;
                        case 2:
                            q.a aVar3 = kotlin.l.q.SZp;
                            t tVar3 = tVar;
                            p.h(tVar3, "type");
                            qVar = new kotlin.l.q(r.IN, tVar3);
                            continue;
                        case 3:
                            q.a aVar4 = kotlin.l.q.SZp;
                            t tVar4 = tVar;
                            p.h(tVar4, "type");
                            qVar = new kotlin.l.q(r.OUT, tVar4);
                            continue;
                        default:
                            m mVar = new m();
                            AppMethodBeat.o(56492);
                            throw mVar;
                    }
                }
                arrayList.add(qVar);
                i2 = i3;
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(56492);
            return arrayList2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends Type>> {
            final /* synthetic */ a Tbu;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.Tbu = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends Type> invoke() {
                AppMethodBeat.i(56491);
                List<Type> a2 = kotlin.l.b.a.b.b.d.b.b.a(this.Tbu.Tbt.hyT());
                AppMethodBeat.o(56491);
                return a2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
        /* renamed from: kotlin.l.b.a.t$a$a  reason: collision with other inner class name */
        static final class C2374a extends kotlin.g.b.q implements kotlin.g.a.a<Type> {
            final /* synthetic */ a Tbu;
            final /* synthetic */ f Tbv;
            final /* synthetic */ k Tbw = null;
            final /* synthetic */ int hAM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2374a(int i2, a aVar, f fVar) {
                super(0);
                this.hAM = i2;
                this.Tbu = aVar;
                this.Tbv = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Type invoke() {
                AppMethodBeat.i(56490);
                Type hyT = this.Tbu.Tbt.hyT();
                if (hyT instanceof Class) {
                    Class componentType = ((Class) hyT).isArray() ? ((Class) hyT).getComponentType() : Object.class;
                    p.g(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    Class<?> cls = componentType;
                    AppMethodBeat.o(56490);
                    return cls;
                } else if (hyT instanceof GenericArrayType) {
                    if (this.hAM != 0) {
                        w wVar = new w("Array type has been queried for a non-0th argument: " + this.Tbu.Tbt);
                        AppMethodBeat.o(56490);
                        throw wVar;
                    }
                    Type genericComponentType = ((GenericArrayType) hyT).getGenericComponentType();
                    p.g(genericComponentType, "javaType.genericComponentType");
                    AppMethodBeat.o(56490);
                    return genericComponentType;
                } else if (hyT instanceof ParameterizedType) {
                    Type type = (Type) ((List) this.Tbv.getValue()).get(this.hAM);
                    if (type instanceof WildcardType) {
                        Type[] lowerBounds = ((WildcardType) type).getLowerBounds();
                        p.g(lowerBounds, "argument.lowerBounds");
                        Type type2 = (Type) kotlin.a.e.R(lowerBounds);
                        if (type2 == null) {
                            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                            p.g(upperBounds, "argument.upperBounds");
                            type = (Type) kotlin.a.e.Q(upperBounds);
                        } else {
                            type = type2;
                        }
                    }
                    p.g(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                    AppMethodBeat.o(56490);
                    return type;
                } else {
                    w wVar2 = new w("Non-generic type has been queried for arguments: " + this.Tbu.Tbt);
                    AppMethodBeat.o(56490);
                    throw wVar2;
                }
            }
        }
    }

    @Override // kotlin.l.o
    public final c hyn() {
        AppMethodBeat.i(56496);
        c cVar = (c) this.Tbq.invoke();
        AppMethodBeat.o(56496);
        return cVar;
    }
}
