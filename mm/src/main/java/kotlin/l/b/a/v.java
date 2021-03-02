package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.y;
import kotlin.l.k;
import kotlin.l.o;
import kotlin.l.p;
import kotlin.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, hxF = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "toString", "kotlin-reflection"})
public final class v implements p {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(v.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    private final y.a Tbx = y.ak(new a(this));
    final as Tby;

    static {
        AppMethodBeat.i(56505);
        AppMethodBeat.o(56505);
    }

    public v(as asVar) {
        kotlin.g.b.p.h(asVar, "descriptor");
        AppMethodBeat.i(56510);
        this.Tby = asVar;
        AppMethodBeat.o(56510);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56507);
        if (!(obj instanceof v) || !kotlin.g.b.p.j(this.Tby, ((v) obj).Tby)) {
            AppMethodBeat.o(56507);
            return false;
        }
        AppMethodBeat.o(56507);
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(56509);
        aa aaVar = aa.TbF;
        String a2 = aa.a(this.Tby);
        AppMethodBeat.o(56509);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<List<? extends t>> {
        final /* synthetic */ v Tbz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar) {
            super(0);
            this.Tbz = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends t> invoke() {
            AppMethodBeat.i(56504);
            List<ab> hyo = this.Tbz.Tby.hyo();
            kotlin.g.b.p.g(hyo, "descriptor.upperBounds");
            List<ab> list = hyo;
            ArrayList arrayList = new ArrayList(j.a(list, 10));
            for (T t : list) {
                kotlin.g.b.p.g(t, "kotlinType");
                arrayList.add(new t(t, new C2375a(this)));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(56504);
            return arrayList2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"})
        /* renamed from: kotlin.l.b.a.v$a$a  reason: collision with other inner class name */
        static final class C2375a extends q implements kotlin.g.a.a {
            final /* synthetic */ a TbA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2375a(a aVar) {
                super(0);
                this.TbA = aVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(56503);
                n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Java type is not yet supported for type parameters: " + this.TbA.Tbz.Tby)));
                AppMethodBeat.o(56503);
                throw nVar;
            }
        }
    }

    @Override // kotlin.l.p
    public final List<o> hyo() {
        AppMethodBeat.i(56506);
        List<o> list = (List) this.Tbx.invoke();
        AppMethodBeat.o(56506);
        return list;
    }

    public final int hashCode() {
        AppMethodBeat.i(56508);
        int hashCode = this.Tby.hashCode();
        AppMethodBeat.o(56508);
        return hashCode;
    }
}
