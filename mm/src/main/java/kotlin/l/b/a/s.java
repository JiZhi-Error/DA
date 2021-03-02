package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.a.e;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.a.i;
import kotlin.l.b.a.a.j;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.c;
import kotlin.l.b.a.d;
import kotlin.l.b.a.i;
import kotlin.l.b.a.r;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, hxF = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class s {
    public static final Object a(r.a<?, ?> aVar) {
        AppMethodBeat.i(56486);
        p.h(aVar, "$this$boundReceiver");
        Object hxQ = aVar.hyF().hxQ();
        AppMethodBeat.o(56486);
        return hxQ;
    }

    static final d<?> a(r.a<?, ?> aVar, boolean z) {
        c.e eVar;
        Method method;
        e.h.d dVar;
        e<Field> eVar2;
        a.b bVar;
        Method method2;
        e.h.f fVar;
        e.h.C2269e eVar3;
        e.h.d dVar2;
        Method a2;
        i.b bVar2;
        AppMethodBeat.i(56487);
        i.a aVar2 = i.Taw;
        if (i.Tav.aJ(aVar.hyF().signature)) {
            j jVar = j.Tct;
            AppMethodBeat.o(56487);
            return jVar;
        }
        a aVar3 = new a(aVar);
        c cVar = new c(aVar, z, new b(aVar), aVar3);
        ac acVar = ac.TbJ;
        d c2 = ac.c(aVar.hyF().hys());
        if (c2 instanceof d.c) {
            a.c cVar2 = ((d.c) c2).SZG;
            if (z) {
                if (cVar2.hIA()) {
                    bVar = cVar2.TCc;
                } else {
                    bVar = null;
                }
            } else if (cVar2.hIB()) {
                bVar = cVar2.TCd;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                method2 = aVar.hyF().TaI.oq(((d.c) c2).SZH.getString(bVar.Tyk), ((d.c) c2).SZH.getString(bVar.TBX));
            } else {
                method2 = null;
            }
            if (method2 == null) {
                if (!kotlin.l.b.a.b.j.e.a(aVar.hyF().hys()) || !p.j(aVar.hyF().hys().hzE(), az.ThT)) {
                    Field hyM = aVar.hyF().hyM();
                    if (hyM == null) {
                        w wVar = new w("No accessors or field is found for property " + aVar.hyF());
                        AppMethodBeat.o(56487);
                        throw wVar;
                    }
                    eVar2 = cVar.e(hyM);
                } else {
                    Class<?> a3 = h.a(aVar.hyF().hys().hzx());
                    if (a3 == null || (a2 = h.a(a3, (kotlin.l.b.a.b.b.b) aVar.hyF().hys())) == null) {
                        w wVar2 = new w("Underlying property of inline class " + aVar.hyF() + " should have a field");
                        AppMethodBeat.o(56487);
                        throw wVar2;
                    }
                    if (aVar.hyF().isBound()) {
                        bVar2 = new i.a(a2, a(aVar));
                    } else {
                        bVar2 = new i.b(a2);
                    }
                    eVar2 = bVar2;
                }
            } else if (!Modifier.isStatic(method2.getModifiers())) {
                if (aVar.hyF().isBound()) {
                    dVar2 = new e.h.a(method2, a(aVar));
                } else {
                    dVar2 = new e.h.d(method2);
                }
                eVar2 = dVar2;
            } else if (aVar3.ij()) {
                if (aVar.hyF().isBound()) {
                    eVar3 = new e.h.b(method2);
                } else {
                    eVar3 = new e.h.C2269e(method2);
                }
                eVar2 = eVar3;
            } else {
                if (aVar.hyF().isBound()) {
                    fVar = new e.h.c(method2, a(aVar));
                } else {
                    fVar = new e.h.f(method2);
                }
                eVar2 = fVar;
            }
        } else if (c2 instanceof d.a) {
            eVar2 = cVar.e(((d.a) c2).bUo);
        } else if (c2 instanceof d.b) {
            if (z) {
                method = ((d.b) c2).SZC;
            } else {
                Method method3 = ((d.b) c2).SZD;
                if (method3 == null) {
                    w wVar3 = new w("No source found for setter of Java method property: " + ((d.b) c2).SZC);
                    AppMethodBeat.o(56487);
                    throw wVar3;
                }
                method = method3;
            }
            if (aVar.hyF().isBound()) {
                dVar = new e.h.a(method, a(aVar));
            } else {
                dVar = new e.h.d(method);
            }
            eVar2 = dVar;
        } else if (c2 instanceof d.C2370d) {
            if (z) {
                eVar = ((d.C2370d) c2).SZJ;
            } else {
                eVar = ((d.C2370d) c2).SZK;
                if (eVar == null) {
                    w wVar4 = new w("No setter found for property " + aVar.hyF());
                    AppMethodBeat.o(56487);
                    throw wVar4;
                }
            }
            Method oq = aVar.hyF().TaI.oq(eVar.SZB.name, eVar.SZB.desc);
            if (oq == null) {
                w wVar5 = new w("No accessor found for property " + aVar.hyF());
                AppMethodBeat.o(56487);
                throw wVar5;
            }
            boolean z2 = !Modifier.isStatic(oq.getModifiers());
            if (aa.SXc && !z2) {
                AssertionError assertionError = new AssertionError("Mapped property cannot have a static accessor: " + aVar.hyF());
                AppMethodBeat.o(56487);
                throw assertionError;
            } else if (aVar.hyF().isBound()) {
                e.h.a aVar4 = new e.h.a(oq, a(aVar));
                AppMethodBeat.o(56487);
                return aVar4;
            } else {
                e.h.d dVar3 = new e.h.d(oq);
                AppMethodBeat.o(56487);
                return dVar3;
            }
        } else {
            m mVar = new m();
            AppMethodBeat.o(56487);
            throw mVar;
        }
        kotlin.l.b.a.a.d<?> a4 = h.a(eVar2, (kotlin.l.b.a.b.b.b) aVar.hyP());
        AppMethodBeat.o(56487);
        return a4;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"isJvmStaticProperty", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ r.a Tbl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r.a aVar) {
            super(0);
            this.Tbl = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(56480);
            Boolean valueOf = Boolean.valueOf(ij());
            AppMethodBeat.o(56480);
            return valueOf;
        }

        public final boolean ij() {
            AppMethodBeat.i(56481);
            boolean h2 = this.Tbl.hyF().hys().hzL().h(ae.hyU());
            AppMethodBeat.o(56481);
            return h2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"isNotNullProperty", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ r.a Tbl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r.a aVar) {
            super(0);
            this.Tbl = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(56482);
            Boolean valueOf = Boolean.valueOf(ij());
            AppMethodBeat.o(56482);
            return valueOf;
        }

        public final boolean ij() {
            AppMethodBeat.i(56483);
            if (!bc.aE(this.Tbl.hyF().hys().hBy())) {
                AppMethodBeat.o(56483);
                return true;
            }
            AppMethodBeat.o(56483);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, hxF = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Field, e<? extends Field>> {
        final /* synthetic */ r.a Tbl;
        final /* synthetic */ boolean Tbm;
        final /* synthetic */ b Tbn;
        final /* synthetic */ a Tbo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(r.a aVar, boolean z, b bVar, a aVar2) {
            super(1);
            this.Tbl = aVar;
            this.Tbm = z;
            this.Tbn = bVar;
            this.Tbo = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ e<? extends Field> invoke(Field field) {
            AppMethodBeat.i(56484);
            e<Field> e2 = e(field);
            AppMethodBeat.o(56484);
            return e2;
        }

        public final e<Field> e(Field field) {
            e.g.c cVar;
            e.f.c cVar2;
            e.g.d dVar;
            e.f.d dVar2;
            AppMethodBeat.i(56485);
            p.h(field, "field");
            if (s.a(this.Tbl.hyF().hys()) || !Modifier.isStatic(field.getModifiers())) {
                if (this.Tbm) {
                    if (this.Tbl.hyF().isBound()) {
                        cVar2 = new e.f.a(field, s.a(this.Tbl));
                    } else {
                        cVar2 = new e.f.c(field);
                    }
                    e<Field> eVar = cVar2;
                    AppMethodBeat.o(56485);
                    return eVar;
                }
                if (this.Tbl.hyF().isBound()) {
                    cVar = new e.g.a(field, this.Tbn.ij(), s.a(this.Tbl));
                } else {
                    cVar = new e.g.c(field, this.Tbn.ij());
                }
                e<Field> eVar2 = cVar;
                AppMethodBeat.o(56485);
                return eVar2;
            } else if (this.Tbo.ij()) {
                if (this.Tbm) {
                    if (this.Tbl.hyF().isBound()) {
                        dVar2 = new e.f.b(field);
                    } else {
                        dVar2 = new e.f.d(field);
                    }
                    e<Field> eVar3 = dVar2;
                    AppMethodBeat.o(56485);
                    return eVar3;
                }
                if (this.Tbl.hyF().isBound()) {
                    dVar = new e.g.b(field, this.Tbn.ij());
                } else {
                    dVar = new e.g.d(field, this.Tbn.ij());
                }
                e<Field> eVar4 = dVar;
                AppMethodBeat.o(56485);
                return eVar4;
            } else if (this.Tbm) {
                e.f.C2267e eVar5 = new e.f.C2267e(field);
                AppMethodBeat.o(56485);
                return eVar5;
            } else {
                e.g.C2268e eVar6 = new e.g.C2268e(field, this.Tbn.ij());
                AppMethodBeat.o(56485);
                return eVar6;
            }
        }
    }

    public static final /* synthetic */ boolean a(ah ahVar) {
        AppMethodBeat.i(56488);
        kotlin.l.b.a.b.b.l hzx = ahVar.hzx();
        p.g(hzx, "containingDeclaration");
        if (!kotlin.l.b.a.b.j.c.u(hzx)) {
            AppMethodBeat.o(56488);
            return false;
        }
        kotlin.l.b.a.b.b.l hzx2 = hzx.hzx();
        if ((kotlin.l.b.a.b.j.c.A(hzx2) || kotlin.l.b.a.b.j.c.z(hzx2)) && (!(ahVar instanceof kotlin.l.b.a.b.k.a.b.j) || !kotlin.l.b.a.b.e.c.a.i.f(((kotlin.l.b.a.b.k.a.b.j) ahVar).SZF))) {
            AppMethodBeat.o(56488);
            return false;
        }
        AppMethodBeat.o(56488);
        return true;
    }
}
