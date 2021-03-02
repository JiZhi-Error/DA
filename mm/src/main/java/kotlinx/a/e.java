package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0019\b\u0004\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00010\f¢\u0006\u0002\b\u000eH\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, hxF = {"decode", "T", "", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/Decoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/Decoder;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class e {
    public static final <T> T c(c cVar, f<T> fVar) {
        AppMethodBeat.i(225366);
        p.h(cVar, "$this$decode");
        p.h(fVar, "deserializer");
        T t = (T) cVar.a(fVar);
        AppMethodBeat.o(225366);
        return t;
    }
}
