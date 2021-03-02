package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.a.b.bj;
import kotlinx.a.c;
import kotlinx.a.h;
import kotlinx.a.j;
import kotlinx.a.n;
import kotlinx.a.o;
import kotlinx.a.p;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonElementSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class g implements h<f> {
    static final n TXo = p.a("kotlinx.serialization.json.JsonElement", j.b.TXn, a.TZH);
    public static final g TZG = new g();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
    static final class a extends q implements b<o, x> {
        public static final a TZH = new a();

        static {
            AppMethodBeat.i(225769);
            AppMethodBeat.o(225769);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(o oVar) {
            AppMethodBeat.i(225768);
            o oVar2 = oVar;
            kotlin.g.b.p.h(oVar2, "$receiver");
            o.a(oVar2, "JsonPrimitive", bj.ap(AnonymousClass1.TZI));
            o.a(oVar2, "JsonNull", bj.ap(AnonymousClass2.TZJ));
            o.a(oVar2, "JsonLiteral", bj.ap(AnonymousClass3.TZK));
            o.a(oVar2, "JsonObject", bj.ap(AnonymousClass4.TZL));
            o.a(oVar2, "JsonArray", bj.ap(AnonymousClass5.TZM));
            x xVar = x.SXb;
            AppMethodBeat.o(225768);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(225764);
        AppMethodBeat.o(225764);
    }

    private g() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225763);
        kotlin.g.b.p.h(cVar, "decoder");
        f hOR = h.b(cVar).hOR();
        AppMethodBeat.o(225763);
        return hOR;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225765);
        kotlin.g.b.p.h(cVar, "decoder");
        kotlin.g.b.p.h((f) obj, "old");
        f fVar = (f) h.a.a(this, cVar);
        AppMethodBeat.o(225765);
        return fVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(kotlinx.a.g gVar, Object obj) {
        AppMethodBeat.i(225762);
        f fVar = (f) obj;
        kotlin.g.b.p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        kotlin.g.b.p.h(fVar, "value");
        h.a(gVar);
        if (fVar instanceof v) {
            gVar.a(w.Uad, fVar);
            AppMethodBeat.o(225762);
        } else if (fVar instanceof s) {
            gVar.a(t.Uaa, fVar);
            AppMethodBeat.o(225762);
        } else {
            if (fVar instanceof b) {
                gVar.a(c.TZp, fVar);
            }
            AppMethodBeat.o(225762);
        }
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
