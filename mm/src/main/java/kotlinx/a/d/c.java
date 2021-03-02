package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u0007\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\b\u001a\"\u0010\f\u001a\u00020\u00012\u001a\u0010\r\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u000e\u001a,\u0010\f\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b\u001a\u0019\u0010\u0011\u001a\u00020\u0005\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t*\u00020\u0004H\b¨\u0006\u0012"}, hxF = {"SerializersModule", "Lkotlinx/serialization/modules/SerialModule;", "buildAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "", "Lkotlin/ExtensionFunctionType;", "serializersModule", "T", "", "serializer", "Lkotlinx/serialization/KSerializer;", "serializersModuleOf", "map", "", "Lkotlin/reflect/KClass;", "kClass", "contextual", "kotlinx-serialization-runtime"})
public final class c {
    public static final b Y(b<? super h, x> bVar) {
        AppMethodBeat.i(225870);
        p.h(bVar, "buildAction");
        h hVar = new h();
        bVar.invoke(hVar);
        b hPh = hVar.hPh();
        AppMethodBeat.o(225870);
        return hPh;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "invoke"})
    public static final class a extends q implements b<h, x> {
        final /* synthetic */ Map TOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(1);
            this.TOA = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(h hVar) {
            AppMethodBeat.i(225869);
            h hVar2 = hVar;
            p.h(hVar2, "$receiver");
            for (Map.Entry entry : this.TOA.entrySet()) {
                kotlin.l.b bVar = (kotlin.l.b) entry.getKey();
                h hVar3 = (h) entry.getValue();
                if (bVar == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                    AppMethodBeat.o(225869);
                    throw tVar;
                } else if (hVar3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
                    AppMethodBeat.o(225869);
                    throw tVar2;
                } else {
                    hVar2.a(bVar, hVar3);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(225869);
            return xVar;
        }
    }
}
