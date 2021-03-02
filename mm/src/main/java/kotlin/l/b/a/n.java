package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.y;
import kotlin.l.j;
import kotlin.l.k;
import kotlin.l.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, hxF = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", FirebaseAnalytics.b.INDEX, "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "kotlin-reflection"})
public final class n implements j {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(n.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), aa.a(new y(aa.bp(n.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final y.a SZW;
    private final y.a SZX = y.ak(new a(this));
    final e<?> TaS;
    final j.a TaT;
    final int index;

    static {
        AppMethodBeat.i(56434);
        AppMethodBeat.o(56434);
    }

    public n(e<?> eVar, int i2, j.a aVar, kotlin.g.a.a<? extends ae> aVar2) {
        p.h(eVar, "callable");
        p.h(aVar, "kind");
        p.h(aVar2, "computeDescriptor");
        AppMethodBeat.i(56440);
        this.TaS = eVar;
        this.index = i2;
        this.TaT = aVar;
        this.SZW = y.ak(aVar2);
        AppMethodBeat.o(56440);
    }

    public static final /* synthetic */ ae a(n nVar) {
        AppMethodBeat.i(56441);
        ae hyH = nVar.hyH();
        AppMethodBeat.o(56441);
        return hyH;
    }

    @Override // kotlin.l.j
    public final j.a hym() {
        return this.TaT;
    }

    @Override // kotlin.l.j
    public final String getName() {
        AppMethodBeat.i(56436);
        ae hyH = hyH();
        if (!(hyH instanceof av)) {
            hyH = null;
        }
        av avVar = (av) hyH;
        if (avVar == null) {
            AppMethodBeat.o(56436);
            return null;
        } else if (avVar.hBz().hAx()) {
            AppMethodBeat.o(56436);
            return null;
        } else {
            f hAH = avVar.hAH();
            p.g(hAH, "valueParameter.name");
            if (hAH.TDa) {
                AppMethodBeat.o(56436);
                return null;
            }
            String sG = hAH.sG();
            AppMethodBeat.o(56436);
            return sG;
        }
    }

    @Override // kotlin.l.j
    public final o hyl() {
        AppMethodBeat.i(186235);
        ab hBy = hyH().hBy();
        p.g(hBy, "descriptor.type");
        t tVar = new t(hBy, new b(this));
        AppMethodBeat.o(186235);
        return tVar;
    }

    @Override // kotlin.l.j
    public final boolean FI() {
        AppMethodBeat.i(186236);
        ae hyH = hyH();
        if (!(hyH instanceof av)) {
            hyH = null;
        }
        av avVar = (av) hyH;
        if (avVar != null) {
            boolean b2 = kotlin.l.b.a.b.j.d.a.b(avVar);
            AppMethodBeat.o(186236);
            return b2;
        }
        AppMethodBeat.o(186236);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56437);
        if (!(obj instanceof n) || !p.j(this.TaS, ((n) obj).TaS) || !p.j(hyH(), ((n) obj).hyH())) {
            AppMethodBeat.o(56437);
            return false;
        }
        AppMethodBeat.o(56437);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(56438);
        int hashCode = (this.TaS.hashCode() * 31) + hyH().hashCode();
        AppMethodBeat.o(56438);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(56439);
        aa aaVar = aa.TbF;
        String b2 = aa.b(this);
        AppMethodBeat.o(56439);
        return b2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<List<? extends Annotation>> {
        final /* synthetic */ n TaU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar) {
            super(0);
            this.TaU = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends Annotation> invoke() {
            AppMethodBeat.i(56433);
            List<Annotation> a2 = ae.a((kotlin.l.b.a.b.b.a.a) n.a(this.TaU));
            AppMethodBeat.o(56433);
            return a2;
        }
    }

    private final ae hyH() {
        AppMethodBeat.i(56435);
        ae aeVar = (ae) this.SZW.invoke();
        AppMethodBeat.o(56435);
        return aeVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Type> {
        final /* synthetic */ n TaU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(n nVar) {
            super(0);
            this.TaU = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Type invoke() {
            AppMethodBeat.i(186234);
            ae a2 = n.a(this.TaU);
            if (!(a2 instanceof ak) || !p.j(ae.a((kotlin.l.b.a.b.b.a) this.TaU.TaS.hys()), a2) || this.TaU.TaS.hys().hAA() != b.a.FAKE_OVERRIDE) {
                Type type = this.TaU.TaS.hyt().hyX().get(this.TaU.index);
                AppMethodBeat.o(186234);
                return type;
            }
            kotlin.l.b.a.b.b.l hzx = this.TaU.TaS.hys().hzx();
            if (hzx == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(186234);
                throw tVar;
            }
            Class<?> a3 = ae.a((e) hzx);
            if (a3 != null) {
                Class<?> cls = a3;
                AppMethodBeat.o(186234);
                return cls;
            }
            w wVar = new w("Cannot determine receiver Java type of inherited declaration: ".concat(String.valueOf(a2)));
            AppMethodBeat.o(186234);
            throw wVar;
        }
    }
}
