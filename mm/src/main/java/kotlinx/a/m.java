package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0002\u0010\fJ \u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J%\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "serialName2Serializer", "findPolymorphicSerializer", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "klassName", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-runtime"})
public final class m<T> extends b<T> {
    private final Map<kotlin.l.b<? extends T>, h<? extends T>> TXA;
    private final Map<String, h<? extends T>> TXB;
    private final n TXo;
    private final kotlin.l.b<T> TXp;

    @Override // kotlinx.a.b.b
    public final kotlin.l.b<T> hOy() {
        return this.TXp;
    }

    @Override // kotlinx.a.h, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.b
    public final h<? extends T> a(a aVar, String str) {
        AppMethodBeat.i(225854);
        p.h(aVar, "decoder");
        p.h(str, "klassName");
        h<? extends T> hVar = this.TXB.get(str);
        if (hVar == null) {
            hVar = super.a(aVar, str);
        }
        AppMethodBeat.o(225854);
        return hVar;
    }

    @Override // kotlinx.a.b.b
    public final h<? extends T> b(g gVar, T t) {
        AppMethodBeat.i(225855);
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_ENCODER);
        p.h(t, "value");
        h<? extends T> hVar = this.TXA.get(aa.bp(t.getClass()));
        if (hVar == null) {
            hVar = super.b(gVar, t);
        }
        AppMethodBeat.o(225855);
        return hVar;
    }
}
