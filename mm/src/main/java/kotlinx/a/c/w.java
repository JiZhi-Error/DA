package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.aa;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.l;
import kotlinx.a.n;
import kotlinx.a.p;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonPrimitiveSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonPrimitive;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class w implements h<v> {
    static final n TXo = p.a("kotlinx.serialization.json.JsonPrimitive", l.i.TXz);
    public static final w Uad = new w();

    static {
        AppMethodBeat.i(225629);
        AppMethodBeat.o(225629);
    }

    private w() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225628);
        kotlin.g.b.p.h(cVar, "decoder");
        f hOR = h.b(cVar).hOR();
        if (!(hOR instanceof v)) {
            e af = l.af(-1, "Unexpected JSON element, expected JsonPrimitive, had " + aa.bp(hOR.getClass()), hOR.toString());
            AppMethodBeat.o(225628);
            throw af;
        }
        v vVar = (v) hOR;
        AppMethodBeat.o(225628);
        return vVar;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225630);
        kotlin.g.b.p.h(cVar, "decoder");
        kotlin.g.b.p.h((v) obj, "old");
        v vVar = (v) h.a.a(this, cVar);
        AppMethodBeat.o(225630);
        return vVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225627);
        v vVar = (v) obj;
        kotlin.g.b.p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        kotlin.g.b.p.h(vVar, "value");
        h.a(gVar);
        if (vVar instanceof q) {
            gVar.a(r.TZV, q.TZU);
            AppMethodBeat.o(225627);
            return;
        }
        gVar.a(p.TZS, (o) vVar);
        AppMethodBeat.o(225627);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
