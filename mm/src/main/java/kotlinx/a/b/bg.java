package kotlinx.a.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.z;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J1\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u001a\u0010\u001a\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b\"\u0006\u0012\u0002\b\u00030\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0004J\u0006\u0010!\u001a\u00020\u000fJ\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u000201J\u0016\u00102\u001a\u0002012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u00103\u001a\u00020$J\u0016\u00104\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u00105\u001a\u000206J\u0016\u00107\u001a\u0002062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u00108\u001a\u00020\u000fJ\b\u00109\u001a\u0004\u0018\u00010:J7\u0010;\u001a\u0004\u0018\u0001H<\"\b\b\u0001\u0010<*\u00020=2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H<0?¢\u0006\u0002\u0010@J/\u0010A\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H<0?¢\u0006\u0002\u0010@J\u0006\u0010B\u001a\u00020CJ\u0016\u0010D\u001a\u00020C2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0006\u0010E\u001a\u00020FJ\u0016\u0010G\u001a\u00020F2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\u0015\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010JJ\u0015\u0010K\u001a\u00020&2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ\u0015\u0010M\u001a\u00020)2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010NJ\u0015\u0010O\u001a\u00020,2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010PJ\u001d\u0010Q\u001a\u00020$2\u0006\u0010I\u001a\u00028\u00002\u0006\u0010R\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010SJ\u0015\u0010T\u001a\u0002012\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010UJ\u0015\u0010V\u001a\u00020$2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010WJ\u0015\u0010X\u001a\u0002062\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010YJ\u0015\u0010Z\u001a\u00020\u000f2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010JJ\u0017\u0010[\u001a\u0004\u0018\u00010:2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\\J\u0015\u0010]\u001a\u00020C2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010^J\u0015\u0010_\u001a\u00020F2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010`J\u0015\u0010a\u001a\u00020\u001f2\u0006\u0010I\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010bJ\u0015\u0010c\u001a\u00020=2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010dJ\b\u0010e\u001a\u00020\u001fH\u0007J\u0018\u0010f\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010g\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\r\u0010h\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u000bJ\u0015\u0010i\u001a\u00020\u001f2\u0006\u0010j\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010bJ)\u0010k\u001a\u0002Hl\"\u0004\b\u0001\u0010l2\u0006\u0010I\u001a\u00028\u00002\f\u0010m\u001a\b\u0012\u0004\u0012\u0002Hl0nH\u0002¢\u0006\u0002\u0010oJC\u0010p\u001a\u0004\u0018\u0001H<\"\b\b\u0001\u0010<*\u00020=2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H<0?2\b\u0010q\u001a\u0004\u0018\u0001H<H\u0016¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0002H<\"\u0004\b\u0001\u0010<2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H<0?2\u0006\u0010q\u001a\u0002H<H\u0016¢\u0006\u0002\u0010rJ\u0019\u0010t\u001a\u00028\u0000*\u00020\u00192\u0006\u0010#\u001a\u00020$H$¢\u0006\u0002\u0010uR\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006v"}, hxF = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "copyTagsTo", "", FacebookRequestErrorClassification.KEY_OTHER, "decodeBoolean", "decodeBooleanElement", FirebaseAnalytics.b.INDEX, "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedUnit", "(Ljava/lang/Object;)V", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeUnit", "decodeUnitElement", "endStructure", "popTag", "pushTag", "name", "tagBlock", QLog.TAG_REPORTLEVEL_USER, "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "getTag", "(Lkotlinx/serialization/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class bg<Tag> implements kotlinx.a.a, kotlinx.a.c {
    private final ArrayList<Tag> TYW = new ArrayList<>();
    private final z TYe = z.UPDATE;
    private boolean hga;

    /* access modifiers changed from: protected */
    public abstract Tag l(n nVar, int i2);

    @Override // kotlinx.a.c
    public <T> T a(f<T> fVar) {
        p.h(fVar, "deserializer");
        return (T) c.a.a(this, fVar);
    }

    @Override // kotlinx.a.c
    public final <T> T a(f<T> fVar, T t) {
        p.h(fVar, "deserializer");
        return (T) c.a.a(this, fVar, t);
    }

    @Override // kotlinx.a.c
    public final <T> T b(f<T> fVar) {
        p.h(fVar, "deserializer");
        return (T) c.a.b(this, fVar);
    }

    @Override // kotlinx.a.a
    public kotlinx.a.d.b hOk() {
        return kotlinx.a.d.a.UaI;
    }

    @Override // kotlinx.a.c
    public z hOl() {
        return this.TYe;
    }

    private Object hOI() {
        throw new t(aa.bp(getClass()) + " can't retrieve untyped values", (byte) 0);
    }

    public boolean gp(Tag tag) {
        return true;
    }

    public boolean gq(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Boolean) hOI).booleanValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
    }

    public byte gr(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Byte) hOI).byteValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Byte");
    }

    public short gs(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Short) hOI).shortValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Short");
    }

    public int gt(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Integer) hOI).intValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Int");
    }

    public long gu(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Long) hOI).longValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Long");
    }

    public float gv(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Float) hOI).floatValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Float");
    }

    public double gw(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Double) hOI).doubleValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Double");
    }

    public char gx(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return ((Character) hOI).charValue();
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Char");
    }

    public String gy(Tag tag) {
        Object hOI = hOI();
        if (hOI != null) {
            return (String) hOI;
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.String");
    }

    @Override // kotlinx.a.c
    public final Void hOn() {
        return null;
    }

    @Override // kotlinx.a.c
    public final boolean hOo() {
        return gq(hOK());
    }

    @Override // kotlinx.a.c
    public final byte hOp() {
        return gr(hOK());
    }

    @Override // kotlinx.a.c
    public final short hOq() {
        return gs(hOK());
    }

    @Override // kotlinx.a.c
    public final int hOs() {
        return gt(hOK());
    }

    @Override // kotlinx.a.c
    public final long hOt() {
        return gu(hOK());
    }

    @Override // kotlinx.a.c
    public final float hOu() {
        return gv(hOK());
    }

    @Override // kotlinx.a.c
    public final double hOv() {
        return gw(hOK());
    }

    @Override // kotlinx.a.c
    public final char hOr() {
        return gx(hOK());
    }

    @Override // kotlinx.a.c
    public final String hOw() {
        return gy(hOK());
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
        return gq(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final byte b(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gr(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final short d(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gs(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final int e(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gt(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final long f(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gu(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final float g(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gv(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final double h(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gw(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final char c(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gx(l(nVar, i2));
    }

    @Override // kotlinx.a.a
    public final String i(n nVar, int i2) {
        p.h(nVar, "descriptor");
        return gy(l(nVar, i2));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
    static final class b extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ bg TYX;
        final /* synthetic */ f TYY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bg bgVar, f fVar) {
            super(0);
            this.TYX = bgVar;
            this.TYY = fVar;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            AppMethodBeat.i(225602);
            T t = (T) this.TYX.a(this.TYY);
            AppMethodBeat.o(225602);
            return t;
        }
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, int i2, f<T> fVar) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) c(l(nVar, i2), new b(this, fVar));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ bg TYX;
        final /* synthetic */ f TYY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(bg bgVar, f fVar) {
            super(0);
            this.TYX = bgVar;
            this.TYY = fVar;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            AppMethodBeat.i(225452);
            T t = (T) this.TYX.b(this.TYY);
            AppMethodBeat.o(225452);
            return t;
        }
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, f<T> fVar) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) c(l(nVar, 5), new a(this, fVar));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
    static final class d extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ bg TYX;
        final /* synthetic */ f TYY;
        final /* synthetic */ Object TYZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bg bgVar, f fVar, Object obj) {
            super(0);
            this.TYX = bgVar;
            this.TYY = fVar;
            this.TYZ = obj;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            AppMethodBeat.i(225410);
            T t = (T) this.TYX.a(this.TYY, this.TYZ);
            AppMethodBeat.o(225410);
            return t;
        }
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, int i2, f<T> fVar, T t) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) c(l(nVar, i2), new d(this, fVar, t));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
    static final class c extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ bg TYX;
        final /* synthetic */ f TYY;
        final /* synthetic */ Object TYZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bg bgVar, f fVar, Object obj) {
            super(0);
            this.TYX = bgVar;
            this.TYY = fVar;
            this.TYZ = obj;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            AppMethodBeat.i(225512);
            bg bgVar = this.TYX;
            f fVar = this.TYY;
            Object obj = this.TYZ;
            p.h(fVar, "deserializer");
            T t = (T) c.a.b(bgVar, fVar, obj);
            AppMethodBeat.o(225512);
            return t;
        }
    }

    @Override // kotlinx.a.a
    public final <T> T a(n nVar, f<T> fVar, T t) {
        p.h(nVar, "descriptor");
        p.h(fVar, "deserializer");
        return (T) c(l(nVar, 5), new c(this, fVar, t));
    }

    private final <E> E c(Tag tag, kotlin.g.a.a<? extends E> aVar) {
        gz(tag);
        E e2 = (E) aVar.invoke();
        if (!this.hga) {
            hOK();
        }
        this.hga = false;
        return e2;
    }

    /* access modifiers changed from: protected */
    public final Tag hOJ() {
        return (Tag) j.kv(this.TYW);
    }

    /* access modifiers changed from: protected */
    public final void gz(Tag tag) {
        this.TYW.add(tag);
    }

    private Tag hOK() {
        Tag remove = this.TYW.remove(j.kq(this.TYW));
        this.hga = true;
        return remove;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.a.b.bg<Tag> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.a.c
    public final boolean hOm() {
        return gp(j.ku(this.TYW));
    }
}
