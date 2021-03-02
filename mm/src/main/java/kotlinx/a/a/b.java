package kotlinx.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.a;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.v;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J1\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0017J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001dH\u0016J\u001e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020#H\u0016J\u001e\u0010$\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020#J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u001e\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020(H\u0016J\u001e\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020(J\b\u0010*\u001a\u00020\u0010H\u0016J=\u0010+\u001a\u00020\u0010\"\b\b\u0000\u0010,*\u00020-2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\b\u0010\u0011\u001a\u0004\u0018\u0001H,¢\u0006\u0002\u00100J7\u00101\u001a\u00020\u0010\"\u0004\b\u0000\u0010,2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H,0/2\u0006\u0010\u0011\u001a\u0002H,¢\u0006\u0002\u00100J\u0010\u00102\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000203H\u0016J\u001e\u00104\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u000203J\u0010\u00105\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u000206H\u0016J\u001e\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u000206J\b\u00108\u001a\u00020\u0010H\u0016J\u0016\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020-H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006;"}, hxF = {"Lkotlinx/serialization/builtins/AbstractEncoder;", "Lkotlinx/serialization/Encoder;", "Lkotlinx/serialization/CompositeEncoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeBooleanElement", FirebaseAnalytics.b.INDEX, "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeUnit", "encodeUnitElement", "encodeValue", "kotlinx-serialization-runtime"})
public abstract class b implements kotlinx.a.b, g {
    @Override // kotlinx.a.g
    public <T> void a(v<? super T> vVar, T t) {
        p.h(vVar, "serializer");
        p.h(vVar, "serializer");
        vVar.a(this, t);
    }

    public <T> void b(v<? super T> vVar, T t) {
        p.h(vVar, "serializer");
        g.a.a(this, vVar, t);
    }

    @Override // kotlinx.a.g
    public kotlinx.a.b c(n nVar, h<?>... hVarArr) {
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeSerializers");
        return g.a.a(this, nVar, hVarArr);
    }

    @Override // kotlinx.a.b
    public boolean c(n nVar) {
        p.h(nVar, "descriptor");
        p.h(nVar, "descriptor");
        return true;
    }

    @Override // kotlinx.a.g
    public kotlinx.a.d.b hOk() {
        return a.UaI;
    }

    @Override // kotlinx.a.g
    public kotlinx.a.b b(n nVar, h<?>... hVarArr) {
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeSerializers");
        return this;
    }

    public boolean j(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return true;
    }

    private void gi(Object obj) {
        p.h(obj, "value");
        throw new t("Non-serializable " + aa.bp(obj.getClass()) + " is not supported by " + aa.bp(getClass()) + " encoder", (byte) 0);
    }

    @Override // kotlinx.a.g
    public void hOx() {
        throw new t("'null' is not supported by default", (byte) 0);
    }

    @Override // kotlinx.a.g
    public void Fb(boolean z) {
        gi(Boolean.valueOf(z));
    }

    @Override // kotlinx.a.g
    public void m(byte b2) {
        gi(Byte.valueOf(b2));
    }

    @Override // kotlinx.a.g
    public void d(short s) {
        gi(Short.valueOf(s));
    }

    @Override // kotlinx.a.g
    public void awb(int i2) {
        gi(Integer.valueOf(i2));
    }

    @Override // kotlinx.a.g
    public void Pq(long j2) {
        gi(Long.valueOf(j2));
    }

    @Override // kotlinx.a.g
    public void cU(float f2) {
        gi(Float.valueOf(f2));
    }

    @Override // kotlinx.a.g
    public void O(double d2) {
        gi(Double.valueOf(d2));
    }

    @Override // kotlinx.a.g
    public void F(char c2) {
        gi(Character.valueOf(c2));
    }

    @Override // kotlinx.a.g
    public void buE(String str) {
        p.h(str, "value");
        gi(str);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, boolean z) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        Fb(z);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, byte b2) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        m(b2);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, short s) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        d(s);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, int i3) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        awb(i3);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, long j2) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        Pq(j2);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, float f2) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        cU(f2);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, double d2) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        O(d2);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, int i2, char c2) {
        p.h(nVar, "descriptor");
        j(nVar, i2);
        F(c2);
    }

    @Override // kotlinx.a.b
    public final void a(n nVar, String str) {
        p.h(nVar, "descriptor");
        p.h(str, "value");
        j(nVar, 0);
        buE(str);
    }

    @Override // kotlinx.a.b
    public final <T> void a(n nVar, int i2, v<? super T> vVar, T t) {
        p.h(nVar, "descriptor");
        p.h(vVar, "serializer");
        j(nVar, i2);
        a(vVar, t);
    }

    @Override // kotlinx.a.b
    public final <T> void a(n nVar, v<? super T> vVar, T t) {
        p.h(nVar, "descriptor");
        p.h(vVar, "serializer");
        j(nVar, 5);
        b(vVar, t);
    }
}
