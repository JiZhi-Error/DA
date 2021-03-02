package kotlinx.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.a.d.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u0000 /2\u00020\u0001:\u0001/J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J9\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001e0 H&¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u000bH\u0016J1\u0010#\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 H&¢\u0006\u0002\u0010!J\u0018\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010&\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010(\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010*\u001a\u00020)2\u0006\u0010\f\u001a\u00020\rH&JC\u0010+\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001e0 2\b\u0010,\u001a\u0004\u0018\u0001H\u001eH&¢\u0006\u0002\u0010-J9\u0010.\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 2\u0006\u0010,\u001a\u0002H\u001eH&¢\u0006\u0002\u0010-R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00060"}, hxF = {"Lkotlinx/serialization/CompositeDecoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "decodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", FirebaseAnalytics.b.INDEX, "", "decodeByteElement", "", "decodeCharElement", "", "decodeCollectionSize", "decodeDoubleElement", "", "decodeElementIndex", "decodeFloatElement", "", "decodeIntElement", "decodeLongElement", "", "decodeNullableSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSequentially", "decodeSerializableElement", "decodeShortElement", "", "decodeStringElement", "", "decodeUnitElement", "", "endStructure", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "Companion", "kotlinx-serialization-runtime"})
public interface a {
    public static final C2376a TXk = C2376a.TXl;

    <T> T a(n nVar, int i2, f<T> fVar);

    <T> T a(n nVar, int i2, f<T> fVar, T t);

    <T> T a(n nVar, f<T> fVar);

    <T> T a(n nVar, f<T> fVar, T t);

    void a(n nVar);

    boolean a(n nVar, int i2);

    byte b(n nVar, int i2);

    int b(n nVar);

    char c(n nVar, int i2);

    short d(n nVar, int i2);

    int e(n nVar, int i2);

    long f(n nVar, int i2);

    float g(n nVar, int i2);

    double h(n nVar, int i2);

    b hOk();

    String i(n nVar, int i2);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lkotlinx/serialization/CompositeDecoder$Companion;", "", "()V", "READ_ALL", "", "READ_ALL$annotations", "READ_DONE", "UNKNOWN_NAME", "kotlinx-serialization-runtime"})
    /* renamed from: kotlinx.a.a$a  reason: collision with other inner class name */
    public static final class C2376a {
        static final /* synthetic */ C2376a TXl = new C2376a();

        static {
            AppMethodBeat.i(225356);
            AppMethodBeat.o(225356);
        }

        private C2376a() {
        }
    }
}
