package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f\"\u0006\u0012\u0002\b\u00030\u0010H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u001bH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020\u0013H&J\n\u0010#\u001a\u0004\u0018\u00010$H&J)\u0010%\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020\u00012\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H&0(H\u0016¢\u0006\u0002\u0010)J!\u0010*\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\u0016¢\u0006\u0002\u0010)J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020.H&J\b\u0010/\u001a\u000200H&J3\u00101\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020\u00012\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H&0(2\b\u00102\u001a\u0004\u0018\u0001H&H\u0016¢\u0006\u0002\u00103J)\u00104\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(2\u0006\u00102\u001a\u0002H&H\u0016¢\u0006\u0002\u00103R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00065"}, hxF = {"Lkotlinx/serialization/Decoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "decodeUnit", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"})
public interface c {
    <T> T a(f<T> fVar);

    <T> T a(f<T> fVar, T t);

    a a(n nVar, h<?>... hVarArr);

    <T> T b(f<T> fVar);

    z hOl();

    boolean hOm();

    Void hOn();

    boolean hOo();

    byte hOp();

    short hOq();

    char hOr();

    int hOs();

    long hOt();

    float hOu();

    double hOv();

    String hOw();

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static <T> T a(c cVar, f<T> fVar) {
            AppMethodBeat.i(225375);
            p.h(fVar, "deserializer");
            T a2 = fVar.a(cVar);
            AppMethodBeat.o(225375);
            return a2;
        }

        public static <T> T b(c cVar, f<T> fVar) {
            AppMethodBeat.i(225376);
            p.h(fVar, "deserializer");
            if (cVar.hOm()) {
                T t = (T) cVar.a(fVar);
                AppMethodBeat.o(225376);
                return t;
            }
            T t2 = (T) cVar.hOn();
            AppMethodBeat.o(225376);
            return t2;
        }

        public static <T> T a(c cVar, f<T> fVar, T t) {
            AppMethodBeat.i(225377);
            p.h(fVar, "deserializer");
            switch (d.$EnumSwitchMapping$0[cVar.hOl().ordinal()]) {
                case 1:
                    aa aaVar = new aa(fVar.fWv().hOz());
                    AppMethodBeat.o(225377);
                    throw aaVar;
                case 2:
                    T t2 = (T) cVar.a(fVar);
                    AppMethodBeat.o(225377);
                    return t2;
                case 3:
                    T a2 = fVar.a(cVar, t);
                    AppMethodBeat.o(225377);
                    return a2;
                default:
                    m mVar = new m();
                    AppMethodBeat.o(225377);
                    throw mVar;
            }
        }

        public static <T> T b(c cVar, f<T> fVar, T t) {
            AppMethodBeat.i(225378);
            p.h(fVar, "deserializer");
            if (cVar.hOl() == z.BANNED) {
                aa aaVar = new aa(fVar.fWv().hOz());
                AppMethodBeat.o(225378);
                throw aaVar;
            } else if (cVar.hOl() == z.OVERWRITE || t == null) {
                T t2 = (T) cVar.b(fVar);
                AppMethodBeat.o(225378);
                return t2;
            } else if (cVar.hOm()) {
                T a2 = fVar.a(cVar, t);
                AppMethodBeat.o(225378);
                return a2;
            } else {
                cVar.hOn();
                AppMethodBeat.o(225378);
                return t;
            }
        }
    }
}
