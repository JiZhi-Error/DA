package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.a.a.e;
import kotlinx.a.b.b;
import kotlinx.a.j;
import kotlinx.a.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class k<T> extends b<T> {
    private final n TXo = p.a("kotlinx.serialization.Polymorphic", j.a.TXm, new a(this));
    final kotlin.l.b<T> TXp;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<o, x> {
        final /* synthetic */ k TXq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar) {
            super(1);
            this.TXq = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(o oVar) {
            AppMethodBeat.i(225374);
            o oVar2 = oVar;
            p.h(oVar2, "$receiver");
            o.a(oVar2, "type", e.a(ae.SYK).fWv());
            o.a(oVar2, "value", p.a("kotlinx.serialization.Polymorphic<" + this.TXq.TXp.getSimpleName() + '>', x.a.TXY));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(225374);
            return xVar;
        }
    }

    public k(kotlin.l.b<T> bVar) {
        p.h(bVar, "baseClass");
        AppMethodBeat.i(225881);
        this.TXp = bVar;
        AppMethodBeat.o(225881);
    }

    @Override // kotlinx.a.b.b
    public final kotlin.l.b<T> hOy() {
        return this.TXp;
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }
}
