package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.w;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0017"}, hxF = {"Lkotlinx/serialization/internal/ObjectSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "objectInstance", "(Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class at<T> implements h<T> {
    final n TXo;
    private final T TYI;

    public at(String str, T t) {
        p.h(str, "serialName");
        p.h(t, "objectInstance");
        AppMethodBeat.i(225490);
        this.TYI = t;
        this.TXo = kotlinx.a.p.a(str, w.d.TXV);
        AppMethodBeat.o(225490);
    }

    @Override // kotlinx.a.f
    public final T a(c cVar, T t) {
        AppMethodBeat.i(225491);
        p.h(cVar, "decoder");
        p.h(t, "old");
        T t2 = (T) h.a.a(this, cVar);
        AppMethodBeat.o(225491);
        return t2;
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.v
    public final void a(g gVar, T t) {
        AppMethodBeat.i(225488);
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(t, "value");
        gVar.b(this.TXo, new h[0]).a(this.TXo);
        AppMethodBeat.o(225488);
    }

    @Override // kotlinx.a.f
    public final T a(c cVar) {
        AppMethodBeat.i(225489);
        p.h(cVar, "decoder");
        cVar.a(this.TXo, new h[0]).a(this.TXo);
        T t = this.TYI;
        AppMethodBeat.o(225489);
        return t;
    }
}
