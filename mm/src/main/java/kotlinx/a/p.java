package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0016\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a3\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\n2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0011\u0018\u0001*\u00020\rH\b\u001a\u0015\u0010\u0012\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0011\u0018\u0001*\u00020\rH\b\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u001d\u0010\u0014\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0015\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001*\u00020\rH\b\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0015\u0010\u0019\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0011\u0018\u0001*\u00020\rH\b\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001a"}, hxF = {"nullable", "Lkotlinx/serialization/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/SerialDescriptor;)Lkotlinx/serialization/SerialDescriptor;", "PrimitiveDescriptor", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "SerialDescriptor", "Lkotlinx/serialization/SerialKind;", "builder", "Lkotlin/Function1;", "Lkotlinx/serialization/SerialDescriptorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "descriptor", "T", "listDescriptor", "typeDescriptor", "mapDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "setDescriptor", "kotlinx-serialization-runtime"})
public final class p {

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
    public static final class a extends q implements b<o, x> {
        public static final a TXJ = new a();

        static {
            AppMethodBeat.i(225380);
            AppMethodBeat.o(225380);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(o oVar) {
            AppMethodBeat.i(225379);
            kotlin.g.b.p.h(oVar, "$receiver");
            x xVar = x.SXb;
            AppMethodBeat.o(225379);
            return xVar;
        }
    }

    public static /* synthetic */ n a(String str, s sVar) {
        AppMethodBeat.i(225364);
        n a2 = a(str, sVar, a.TXJ);
        AppMethodBeat.o(225364);
        return a2;
    }

    public static final n a(String str, s sVar, b<? super o, x> bVar) {
        AppMethodBeat.i(225363);
        kotlin.g.b.p.h(str, "serialName");
        kotlin.g.b.p.h(sVar, "kind");
        kotlin.g.b.p.h(bVar, "builder");
        if (!(!n.aL(str))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Blank serial names are prohibited".toString());
            AppMethodBeat.o(225363);
            throw illegalArgumentException;
        }
        o oVar = new o(str);
        bVar.invoke(oVar);
        q qVar = new q(str, sVar, oVar.TXD.size(), oVar);
        AppMethodBeat.o(225363);
        return qVar;
    }
}
