package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lkotlinx/serialization/internal/NullableSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", "", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"})
public final class as<T> implements h<T> {
    private final n TXo = new bb(this.TYH.fWv());
    private final h<T> TYH;

    public as(h<T> hVar) {
        p.h(hVar, "serializer");
        AppMethodBeat.i(225437);
        this.TYH = hVar;
        AppMethodBeat.o(225437);
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.v
    public final void a(g gVar, T t) {
        AppMethodBeat.i(225432);
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        if (t != null) {
            gVar.a(this.TYH, t);
            AppMethodBeat.o(225432);
            return;
        }
        gVar.hOx();
        AppMethodBeat.o(225432);
    }

    @Override // kotlinx.a.f
    public final T a(c cVar) {
        AppMethodBeat.i(225433);
        p.h(cVar, "decoder");
        if (cVar.hOm()) {
            T t = (T) cVar.a(this.TYH);
            AppMethodBeat.o(225433);
            return t;
        }
        T t2 = (T) cVar.hOn();
        AppMethodBeat.o(225433);
        return t2;
    }

    @Override // kotlinx.a.f
    public final T a(c cVar, T t) {
        AppMethodBeat.i(225434);
        p.h(cVar, "decoder");
        if (t == null) {
            T a2 = a(cVar);
            AppMethodBeat.o(225434);
            return a2;
        } else if (cVar.hOm()) {
            T t2 = (T) cVar.a(this.TYH, t);
            AppMethodBeat.o(225434);
            return t2;
        } else {
            cVar.hOn();
            AppMethodBeat.o(225434);
            return t;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225435);
        if (this == obj) {
            AppMethodBeat.o(225435);
            return true;
        } else if (obj == null || (!p.j(aa.bp(getClass()), aa.bp(obj.getClass())))) {
            AppMethodBeat.o(225435);
            return false;
        } else if (!p.j(this.TYH, ((as) obj).TYH)) {
            AppMethodBeat.o(225435);
            return false;
        } else {
            AppMethodBeat.o(225435);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(225436);
        int hashCode = this.TYH.hashCode();
        AppMethodBeat.o(225436);
        return hashCode;
    }
}
