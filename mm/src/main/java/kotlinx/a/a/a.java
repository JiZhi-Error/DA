package kotlinx.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.d.b;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.z;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010\"\u0006\u0012\u0002\b\u00030\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010&\u001a\u00020\u0017H\u0016J\u0016\u0010'\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010+\u001a\u00020\u0014H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J7\u0010.\u001a\u0004\u0018\u0001H/\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H/02¢\u0006\u0002\u00103J/\u00104\u001a\u0002H/\"\u0004\b\u0000\u0010/2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\f\u00101\u001a\b\u0012\u0004\u0012\u0002H/02¢\u0006\u0002\u00103J\b\u00105\u001a\u000206H\u0016J\u0016\u00107\u001a\u0002062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u00108\u001a\u000209H\u0016J\u0016\u0010:\u001a\u0002092\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u00020<2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010>\u001a\u000200H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010\r\u001a\u00020\u000eH\u0016JA\u0010@\u001a\u0004\u0018\u0001H/\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H/022\b\u0010A\u001a\u0004\u0018\u0001H/¢\u0006\u0002\u0010BJ7\u0010C\u001a\u0002H/\"\u0004\b\u0000\u0010/2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\f\u00101\u001a\b\u0012\u0004\u0012\u0002H/022\u0006\u0010A\u001a\u0002H/¢\u0006\u0002\u0010BR\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006D"}, hxF = {"Lkotlinx/serialization/builtins/AbstractDecoder;", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeBooleanElement", FirebaseAnalytics.b.INDEX, "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeUnit", "", "decodeUnitElement", "decodeValue", "endStructure", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "kotlinx-serialization-runtime"})
public abstract class a implements kotlinx.a.a, c {
    private final z TYe = z.UPDATE;

    @Override // kotlinx.a.c
    public <T> T a(f<T> fVar) {
        p.h(fVar, "deserializer");
        return (T) c.a.a(this, fVar);
    }

    @Override // kotlinx.a.c
    public <T> T a(f<T> fVar, T t) {
        p.h(fVar, "deserializer");
        return (T) c.a.a(this, fVar, t);
    }

    @Override // kotlinx.a.c
    public <T> T b(f<T> fVar) {
        p.h(fVar, "deserializer");
        return (T) c.a.b(this, fVar);
    }

    public <T> T b(f<T> fVar, T t) {
        p.h(fVar, "deserializer");
        return (T) c.a.b(this, fVar, t);
    }

    @Override // kotlinx.a.a
    public b hOk() {
        return kotlinx.a.d.a.UaI;
    }

    @Override // kotlinx.a.c
    public z hOl() {
        return this.TYe;
    }

    private Object hOD() {
        throw new t(aa.bp(getClass()) + " can't retrieve untyped values", (byte) 0);
    }

    @Override // kotlinx.a.c
    public boolean hOm() {
        return true;
    }

    @Override // kotlinx.a.c
    public Void hOn() {
        return null;
    }

    @Override // kotlinx.a.c
    public boolean hOo() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Boolean) hOD).booleanValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // kotlinx.a.c
    public byte hOp() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Byte) hOD).byteValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Byte");
    }

    @Override // kotlinx.a.c
    public short hOq() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Short) hOD).shortValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Short");
    }

    @Override // kotlinx.a.c
    public int hOs() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Integer) hOD).intValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Int");
    }

    @Override // kotlinx.a.c
    public long hOt() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Long) hOD).longValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Long");
    }

    @Override // kotlinx.a.c
    public float hOu() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Float) hOD).floatValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Float");
    }

    @Override // kotlinx.a.c
    public double hOv() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Double) hOD).doubleValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Double");
    }

    @Override // kotlinx.a.c
    public char hOr() {
        Object hOD = hOD();
        if (hOD != null) {
            return ((Character) hOD).charValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Char");
    }

    @Override // kotlinx.a.c
    public String hOw() {
        Object hOD = hOD();
        if (hOD != null) {
            return (String) hOD;
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.String");
    }

    @Override // kotlinx.a.c
    public kotlinx.a.a a(n nVar, h<?>... hVarArr) {
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeParams");
        return this;
    }

    @Override // kotlinx.a.a
    public void a(n nVar) {
        p.h(nVar, "descriptor");
    }

    @Override // kotlinx.a.a
    public final boolean a(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOo();
    }

    @Override // kotlinx.a.a
    public final byte b(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOp();
    }

    @Override // kotlinx.a.a
    public final short d(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOq();
    }

    @Override // kotlinx.a.a
    public final int e(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOs();
    }

    @Override // kotlinx.a.a
    public final long f(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOt();
    }

    @Override // kotlinx.a.a
    public final float g(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOu();
    }

    @Override // kotlinx.a.a
    public final double h(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOv();
    }

    @Override // kotlinx.a.a
    public final char c(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOr();
    }

    @Override // kotlinx.a.a
    public final String i(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return hOw();
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, int i2, f<T> fVar) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) a(fVar);
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, f<T> fVar) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) b(fVar);
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, int i2, f<T> fVar, T t) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) a(fVar, t);
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, f<T> fVar, T t) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) b(fVar, t);
    }
}
