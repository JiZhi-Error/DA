package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Map;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.a.d;
import kotlinx.a.a.e;
import kotlinx.a.b.aq;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"Lkotlinx/serialization/json/JsonObjectSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class t implements h<s> {
    static final n TXo;
    public static final t Uaa = new t();

    static {
        AppMethodBeat.i(225637);
        n fWv = e.a(ae.SYK).fWv();
        g gVar = g.TZG;
        TXo = new aq("kotlinx.serialization.json.JsonObject", fWv, g.TXo);
        AppMethodBeat.o(225637);
    }

    private t() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225636);
        p.h(cVar, "decoder");
        h.b(cVar);
        s sVar = new s((Map) d.a(e.a(ae.SYK), g.TZG).a(cVar));
        AppMethodBeat.o(225636);
        return sVar;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225638);
        p.h(cVar, "decoder");
        p.h((s) obj, "old");
        s sVar = (s) h.a.a(this, cVar);
        AppMethodBeat.o(225638);
        return sVar;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225635);
        s sVar = (s) obj;
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(sVar, "value");
        h.a(gVar);
        d.a(e.a(ae.SYK), g.TZG).a(gVar, sVar.TZX);
        AppMethodBeat.o(225635);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
