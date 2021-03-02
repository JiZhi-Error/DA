package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.l;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, hxF = {"Lkotlinx/serialization/internal/LongSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Long;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "kotlinx-serialization-runtime"})
public final class al implements h<Long> {
    private static final n TXo = new ay("kotlin.Long", l.g.TXx);
    public static final al TYB = new al();

    static {
        AppMethodBeat.i(225402);
        AppMethodBeat.o(225402);
    }

    private al() {
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225401);
        p.h(cVar, "decoder");
        Long valueOf = Long.valueOf(cVar.hOt());
        AppMethodBeat.o(225401);
        return valueOf;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225403);
        long longValue = ((Number) obj).longValue();
        p.h(cVar, "decoder");
        Long.valueOf(longValue);
        Long l = (Long) h.a.a(this, cVar);
        AppMethodBeat.o(225403);
        return l;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225400);
        long longValue = ((Number) obj).longValue();
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        gVar.Pq(longValue);
        AppMethodBeat.o(225400);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return TXo;
    }
}
