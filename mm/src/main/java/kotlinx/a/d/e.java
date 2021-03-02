package kotlinx.a.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\b\u001a)\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0006\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0007\u001a\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0004\u001a\u0015\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¨\u0006\r"}, hxF = {"getContextual", "Lkotlinx/serialization/KSerializer;", "T", "", "Lkotlinx/serialization/modules/SerialModule;", "value", "(Lkotlinx/serialization/modules/SerialModule;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "getContextualOrDefault", "klass", "Lkotlin/reflect/KClass;", "overwriteWith", FacebookRequestErrorClassification.KEY_OTHER, "plus", "kotlinx-serialization-runtime"})
public final class e {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "invoke"})
    public static final class a extends q implements b<h, x> {
        final /* synthetic */ b UaJ;
        final /* synthetic */ b UaK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, b bVar2) {
            super(1);
            this.UaJ = bVar;
            this.UaK = bVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(h hVar) {
            AppMethodBeat.i(225879);
            h hVar2 = hVar;
            p.h(hVar2, "$receiver");
            hVar2.a(this.UaJ);
            hVar2.a(this.UaK);
            x xVar = x.SXb;
            AppMethodBeat.o(225879);
            return xVar;
        }
    }
}
