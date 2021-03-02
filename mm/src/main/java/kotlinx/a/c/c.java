package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a.d;
import kotlinx.a.b.ap;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class c implements h<b> {
    static final n TXo = new ap("kotlinx.serialization.json.JsonArray", g.TXo);
    public static final c TZp = new c();

    static {
        AppMethodBeat.i(225760);
        g gVar = g.TZG;
        AppMethodBeat.o(225760);
    }

    private c() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(kotlinx.a.c cVar) {
        AppMethodBeat.i(225759);
        p.h(cVar, "decoder");
        h.b(cVar);
        b bVar = new b((List) d.b(g.TZG).a(cVar));
        AppMethodBeat.o(225759);
        return bVar;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(kotlinx.a.c cVar, Object obj) {
        AppMethodBeat.i(225761);
        p.h(cVar, "decoder");
        p.h((b) obj, "old");
        b bVar = (b) h.a.a(this, cVar);
        AppMethodBeat.o(225761);
        return bVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225758);
        b bVar = (b) obj;
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(bVar, "value");
        h.a(gVar);
        d.b(g.TZG).a(gVar, bVar);
        AppMethodBeat.o(225758);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
