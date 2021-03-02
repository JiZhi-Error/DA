package kotlinx.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J9\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0002\u0010\u000fJ1\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000e0\r\"\u0006\u0012\u0002\b\u00030\u000eH&¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000bH&J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH&J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020#H&J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H&J/\u0010&\u001a\u00020\u0013\"\b\b\u0000\u0010'*\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\b\u0010\u0014\u001a\u0004\u0018\u0001H'H\u0016¢\u0006\u0002\u0010*J)\u0010+\u001a\u00020\u0013\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010\u0014\u001a\u0002H'H\u0016¢\u0006\u0002\u0010*J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020/H&J\b\u00100\u001a\u00020\u0013H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u00061"}, hxF = {"Lkotlinx/serialization/Encoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginCollection", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "collectionSize", "", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;I[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", FirebaseAnalytics.b.INDEX, "encodeFloat", "", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "encodeUnit", "kotlinx-serialization-runtime"})
public interface g {
    void F(char c2);

    void Fb(boolean z);

    void O(double d2);

    void Pq(long j2);

    <T> void a(v<? super T> vVar, T t);

    void awb(int i2);

    b b(n nVar, h<?>... hVarArr);

    void buE(String str);

    b c(n nVar, h<?>... hVarArr);

    void cU(float f2);

    void d(short s);

    b hOk();

    void hOx();

    void m(byte b2);

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static b a(g gVar, n nVar, h<?>... hVarArr) {
            AppMethodBeat.i(225357);
            p.h(nVar, "descriptor");
            p.h(hVarArr, "typeSerializers");
            b b2 = gVar.b(nVar, (h[]) Arrays.copyOf(hVarArr, hVarArr.length));
            AppMethodBeat.o(225357);
            return b2;
        }

        public static <T> void a(g gVar, v<? super T> vVar, T t) {
            AppMethodBeat.i(225358);
            p.h(vVar, "serializer");
            if (t == null) {
                gVar.hOx();
                AppMethodBeat.o(225358);
                return;
            }
            gVar.a(vVar, t);
            AppMethodBeat.o(225358);
        }
    }
}
