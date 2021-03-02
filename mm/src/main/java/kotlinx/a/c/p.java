package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.aa;
import kotlin.l;
import kotlinx.a.b.az;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.l;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class p implements h<o> {
    static final n TXo;
    public static final p TZS = new p();

    static {
        AppMethodBeat.i(225779);
        l.i iVar = l.i.TXz;
        kotlin.g.b.p.h("kotlinx.serialization.json.JsonLiteral", "serialName");
        kotlin.g.b.p.h(iVar, "kind");
        if (!(!kotlin.n.n.aL("kotlinx.serialization.json.JsonLiteral"))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Blank serial names are prohibited".toString());
            AppMethodBeat.o(225779);
            throw illegalArgumentException;
        }
        TXo = az.a("kotlinx.serialization.json.JsonLiteral", iVar);
        AppMethodBeat.o(225779);
    }

    private p() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225778);
        kotlin.g.b.p.h(cVar, "decoder");
        f hOR = h.b(cVar).hOR();
        if (!(hOR instanceof o)) {
            e af = l.af(-1, "Unexpected JSON element, expected JsonLiteral, had " + aa.bp(hOR.getClass()), hOR.toString());
            AppMethodBeat.o(225778);
            throw af;
        }
        o oVar = (o) hOR;
        AppMethodBeat.o(225778);
        return oVar;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225780);
        kotlin.g.b.p.h(cVar, "decoder");
        kotlin.g.b.p.h((o) obj, "old");
        o oVar = (o) h.a.a(this, cVar);
        AppMethodBeat.o(225780);
        return oVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225777);
        o oVar = (o) obj;
        kotlin.g.b.p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        kotlin.g.b.p.h(oVar, "value");
        h.a(gVar);
        if (!oVar.TZQ) {
            Long buB = kotlin.n.n.buB(oVar.getContent());
            if (buB != null) {
                gVar.Pq(buB.longValue());
                AppMethodBeat.o(225777);
                return;
            }
            Double buz = kotlin.n.n.buz(oVar.getContent());
            if (buz != null) {
                gVar.O(buz.doubleValue());
                AppMethodBeat.o(225777);
                return;
            }
            Boolean buS = kotlinx.a.c.a.p.buS(oVar.getContent());
            if (buS != null) {
                gVar.Fb(buS.booleanValue());
                AppMethodBeat.o(225777);
                return;
            }
        }
        gVar.buE(oVar.content);
        AppMethodBeat.o(225777);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
