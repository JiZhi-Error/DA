package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0001J\u001e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0001¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0004\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, hxF = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "patch", "old", "(Lkotlinx/serialization/Decoder;Lkotlin/Unit;)V", "serialize", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Lkotlin/Unit;)V", "kotlinx-serialization-runtime"})
public final class bi implements h<x> {
    public static final bi TZa = new bi();
    private final /* synthetic */ at TZb = new at("kotlin.Unit", x.SXb);

    static {
        AppMethodBeat.i(225540);
        AppMethodBeat.o(225540);
    }

    private bi() {
        AppMethodBeat.i(225539);
        AppMethodBeat.o(225539);
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar, Object obj) {
        AppMethodBeat.i(225542);
        x xVar = (x) obj;
        p.h(cVar, "decoder");
        p.h(xVar, "old");
        this.TZb.a(cVar, xVar);
        x xVar2 = x.SXb;
        AppMethodBeat.o(225542);
        return xVar2;
    }

    @Override // kotlinx.a.v
    public final /* synthetic */ void a(g gVar, Object obj) {
        AppMethodBeat.i(225543);
        x xVar = (x) obj;
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(xVar, "value");
        this.TZb.a(gVar, xVar);
        AppMethodBeat.o(225543);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TZb.TXo;
    }

    @Override // kotlinx.a.f
    public final /* synthetic */ Object a(c cVar) {
        AppMethodBeat.i(225541);
        p.h(cVar, "decoder");
        this.TZb.a(cVar);
        x xVar = x.SXb;
        AppMethodBeat.o(225541);
        return xVar;
    }
}
