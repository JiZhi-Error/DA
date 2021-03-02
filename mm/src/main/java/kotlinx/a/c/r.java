package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.p;
import kotlinx.a.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonNullSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonNull;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class r implements h<q> {
    static final n TXo = p.a("kotlinx.serialization.json.JsonNull", x.c.TXZ);
    public static final r TZV = new r();

    static {
        AppMethodBeat.i(225817);
        AppMethodBeat.o(225817);
    }

    private r() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225816);
        kotlin.g.b.p.h(cVar, "decoder");
        h.b(cVar);
        cVar.hOn();
        q qVar = q.TZU;
        AppMethodBeat.o(225816);
        return qVar;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225818);
        kotlin.g.b.p.h(cVar, "decoder");
        kotlin.g.b.p.h((q) obj, "old");
        q qVar = (q) h.a.a(this, cVar);
        AppMethodBeat.o(225818);
        return qVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225815);
        kotlin.g.b.p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        kotlin.g.b.p.h((q) obj, "value");
        h.a(gVar);
        gVar.hOx();
        AppMethodBeat.o(225815);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
