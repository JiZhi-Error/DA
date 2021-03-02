package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.a.a;
import kotlinx.a.c;
import kotlinx.a.c.d;
import kotlinx.a.c.f;
import kotlinx.a.c.m;
import kotlinx.a.d.b;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.z;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ1\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001a\u0010\u001e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001f\"\u0006\u0012\u0002\b\u00030 H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020%H\u0002J\b\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00103\u001a\u00020%H\u0002J\b\u00107\u001a\u00020#H\u0016J\n\u00108\u001a\u0004\u0018\u000109H\u0016J\u0018\u0010:\u001a\u00020\u00112\u0006\u00103\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J!\u0010;\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\u0016¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020E2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J9\u0010F\u001a\u0002H<\"\u0004\b\u0000\u0010<*\u00020C2\u0006\u0010G\u001a\u00020C2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u0002H<0I¢\u0006\u0002\bJH\b¢\u0006\u0002\u0010KR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006L"}, hxF = {"Lkotlinx/serialization/json/internal/StreamingJsonInput;", "Lkotlinx/serialization/json/JsonInput;", "Lkotlinx/serialization/builtins/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJson", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class l extends a implements m {
    private final d TZf = this.Uae.TZf;
    private final kotlinx.a.c.a Uae;
    public final f Uaj;
    private final b Uar = this.Uae.TZe;
    private final r Uas;
    private int currentIndex = -1;

    @Override // kotlinx.a.c.m
    public final kotlinx.a.c.a hOQ() {
        return this.Uae;
    }

    public l(kotlinx.a.c.a aVar, r rVar, f fVar) {
        p.h(aVar, "json");
        p.h(rVar, "mode");
        p.h(fVar, "reader");
        AppMethodBeat.i(225743);
        this.Uae = aVar;
        this.Uas = rVar;
        this.Uaj = fVar;
        AppMethodBeat.o(225743);
    }

    @Override // kotlinx.a.a.a, kotlinx.a.a
    public final b hOk() {
        return this.Uar;
    }

    @Override // kotlinx.a.c.m
    public final f hOR() {
        AppMethodBeat.i(225728);
        f hOX = new d(this.Uae.TZf, this.Uaj).hOX();
        AppMethodBeat.o(225728);
        return hOX;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final z hOl() {
        return this.TZf.TYe;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final <T> T a(kotlinx.a.f<T> fVar) {
        AppMethodBeat.i(225729);
        p.h(fVar, "deserializer");
        T t = (T) k.a(this, fVar);
        AppMethodBeat.o(225729);
        return t;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.a
    public final void a(n nVar) {
        AppMethodBeat.i(225731);
        p.h(nVar, "descriptor");
        if (this.Uas.UaH != 0) {
            f fVar = this.Uaj;
            if (fVar.Ual != this.Uas.UaF) {
                fVar.ib("Expected '" + this.Uas.UaH + '\'', fVar.Uam);
                AppMethodBeat.o(225731);
                throw null;
            }
            this.Uaj.hPc();
        }
        AppMethodBeat.o(225731);
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final boolean hOm() {
        return this.Uaj.Ual != 10;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final Void hOn() {
        AppMethodBeat.i(225732);
        f fVar = this.Uaj;
        if (fVar.Ual != 10) {
            fVar.ib("Expected 'null' literal", fVar.Uam);
            AppMethodBeat.o(225732);
            throw null;
        }
        this.Uaj.hPc();
        AppMethodBeat.o(225732);
        return null;
    }

    @Override // kotlinx.a.a
    public final int b(n nVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(225733);
        p.h(nVar, "descriptor");
        byte b2 = this.Uaj.Ual;
        if (b2 == 4) {
            f fVar = this.Uaj;
            if (this.currentIndex != -1) {
                z = true;
            } else {
                z = false;
            }
            int i2 = this.Uaj.zaD;
            if (!z) {
                fVar.ib("Unexpected leading comma", i2);
                AppMethodBeat.o(225733);
                throw null;
            }
            this.Uaj.hPc();
        }
        switch (m.haE[this.Uas.ordinal()]) {
            case 1:
                if (!(b2 == 4 || this.currentIndex == -1)) {
                    f fVar2 = this.Uaj;
                    if (fVar2.Ual != 9) {
                        fVar2.ib("Expected end of the array or comma", fVar2.Uam);
                        AppMethodBeat.o(225733);
                        throw null;
                    }
                }
                if (!this.Uaj.hOY()) {
                    f fVar3 = this.Uaj;
                    if (b2 == 4) {
                        z2 = false;
                    }
                    int i3 = fVar3.zaD;
                    if (!z2) {
                        fVar3.ib("Unexpected trailing comma", i3);
                        AppMethodBeat.o(225733);
                        throw null;
                    }
                    AppMethodBeat.o(225733);
                    return -1;
                }
                this.currentIndex++;
                int i4 = this.currentIndex;
                AppMethodBeat.o(225733);
                return i4;
            case 2:
                if (b2 != 4 && this.currentIndex % 2 == 1) {
                    f fVar4 = this.Uaj;
                    if (fVar4.Ual != 7) {
                        fVar4.ib("Expected end of the object or comma", fVar4.Uam);
                        AppMethodBeat.o(225733);
                        throw null;
                    }
                }
                if (this.currentIndex % 2 == 0) {
                    f fVar5 = this.Uaj;
                    if (fVar5.Ual != 5) {
                        fVar5.ib("Expected ':' after the key", fVar5.Uam);
                        AppMethodBeat.o(225733);
                        throw null;
                    }
                    this.Uaj.hPc();
                }
                if (!this.Uaj.hOY()) {
                    f fVar6 = this.Uaj;
                    if (b2 == 4) {
                        z2 = false;
                    }
                    int i5 = fVar6.zaD;
                    if (!z2) {
                        fVar6.ib("Unexpected trailing comma", i5);
                        AppMethodBeat.o(225733);
                        throw null;
                    }
                    AppMethodBeat.o(225733);
                    return -1;
                }
                this.currentIndex++;
                int i6 = this.currentIndex;
                AppMethodBeat.o(225733);
                return i6;
            case 3:
                this.currentIndex++;
                switch (this.currentIndex) {
                    case 0:
                        AppMethodBeat.o(225733);
                        return 0;
                    case 1:
                        AppMethodBeat.o(225733);
                        return 1;
                    default:
                        AppMethodBeat.o(225733);
                        return -1;
                }
            default:
                if (b2 != 4 || this.Uaj.hOY()) {
                    while (this.Uaj.hOY()) {
                        this.currentIndex++;
                        String hOw = hOw();
                        f fVar7 = this.Uaj;
                        if (fVar7.Ual != 5) {
                            fVar7.ib("Expected ':'", fVar7.Uam);
                            AppMethodBeat.o(225733);
                            throw null;
                        }
                        this.Uaj.hPc();
                        int buF = nVar.buF(hOw);
                        if (buF != -3) {
                            AppMethodBeat.o(225733);
                            return buF;
                        } else if (!this.TZf.TZr) {
                            f.a(this.Uaj, "Encountered an unknown key '" + hOw + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys");
                            AppMethodBeat.o(225733);
                            throw null;
                        } else {
                            this.Uaj.hPd();
                            if (this.Uaj.Ual == 4) {
                                this.Uaj.hPc();
                                f fVar8 = this.Uaj;
                                boolean hOY = this.Uaj.hOY();
                                int i7 = this.Uaj.zaD;
                                if (!hOY) {
                                    fVar8.ib("Unexpected trailing comma", i7);
                                    AppMethodBeat.o(225733);
                                    throw null;
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(225733);
                    return -1;
                }
                f.a(this.Uaj, "Unexpected trailing comma");
                AppMethodBeat.o(225733);
                throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final boolean hOo() {
        AppMethodBeat.i(225734);
        if (this.TZf.TZs) {
            boolean buR = p.buR(this.Uaj.hOZ());
            AppMethodBeat.o(225734);
            return buR;
        }
        f fVar = this.Uaj;
        if (fVar.Ual != 0) {
            fVar.ib("Expected start of the unquoted boolean literal. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", fVar.Uam);
            AppMethodBeat.o(225734);
            throw null;
        }
        boolean buR2 = p.buR(fVar.hPb());
        AppMethodBeat.o(225734);
        return buR2;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final byte hOp() {
        AppMethodBeat.i(225735);
        try {
            byte parseByte = Byte.parseByte(this.Uaj.hOZ());
            AppMethodBeat.o(225735);
            return parseByte;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "byte" + '\'');
            AppMethodBeat.o(225735);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final short hOq() {
        AppMethodBeat.i(225736);
        try {
            short parseShort = Short.parseShort(this.Uaj.hOZ());
            AppMethodBeat.o(225736);
            return parseShort;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "short" + '\'');
            AppMethodBeat.o(225736);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final int hOs() {
        AppMethodBeat.i(225737);
        try {
            int parseInt = Integer.parseInt(this.Uaj.hOZ());
            AppMethodBeat.o(225737);
            return parseInt;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "int" + '\'');
            AppMethodBeat.o(225737);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final long hOt() {
        AppMethodBeat.i(225738);
        try {
            long parseLong = Long.parseLong(this.Uaj.hOZ());
            AppMethodBeat.o(225738);
            return parseLong;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "long" + '\'');
            AppMethodBeat.o(225738);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final float hOu() {
        AppMethodBeat.i(225739);
        try {
            float parseFloat = Float.parseFloat(this.Uaj.hOZ());
            AppMethodBeat.o(225739);
            return parseFloat;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "float" + '\'');
            AppMethodBeat.o(225739);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final double hOv() {
        AppMethodBeat.i(225740);
        try {
            double parseDouble = Double.parseDouble(this.Uaj.hOZ());
            AppMethodBeat.o(225740);
            return parseDouble;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "double" + '\'');
            AppMethodBeat.o(225740);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final char hOr() {
        AppMethodBeat.i(225741);
        try {
            char aT = kotlin.n.n.aT(this.Uaj.hOZ());
            AppMethodBeat.o(225741);
            return aT;
        } catch (Throwable th) {
            f.a(this.Uaj, "Failed to parse '" + "char" + '\'');
            AppMethodBeat.o(225741);
            throw null;
        }
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final String hOw() {
        AppMethodBeat.i(225742);
        if (this.TZf.TZs) {
            String hOZ = this.Uaj.hOZ();
            AppMethodBeat.o(225742);
            return hOZ;
        }
        String hPa = this.Uaj.hPa();
        AppMethodBeat.o(225742);
        return hPa;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final kotlinx.a.a a(n nVar, h<?>... hVarArr) {
        l lVar;
        AppMethodBeat.i(225730);
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeParams");
        r a2 = s.a(this.Uae, nVar);
        if (a2.UaG != 0) {
            f fVar = this.Uaj;
            if (fVar.Ual != a2.UaE) {
                fVar.ib("Expected '" + a2.UaG + ", kind: " + nVar.hOA() + '\'', fVar.Uam);
                AppMethodBeat.o(225730);
                throw null;
            }
            this.Uaj.hPc();
        }
        switch (m.$EnumSwitchMapping$0[a2.ordinal()]) {
            case 1:
            case 2:
            case 3:
                lVar = new l(this.Uae, a2, this.Uaj);
                break;
            default:
                if (this.Uas != a2) {
                    lVar = new l(this.Uae, a2, this.Uaj);
                    break;
                } else {
                    lVar = this;
                    break;
                }
        }
        l lVar2 = lVar;
        AppMethodBeat.o(225730);
        return lVar2;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final <T> T b(kotlinx.a.f<T> fVar) {
        AppMethodBeat.i(225744);
        p.h(fVar, "deserializer");
        p.h(fVar, "deserializer");
        T t = (T) c.a.b(this, fVar);
        AppMethodBeat.o(225744);
        return t;
    }

    @Override // kotlinx.a.a.a, kotlinx.a.c
    public final <T> T a(kotlinx.a.f<T> fVar, T t) {
        AppMethodBeat.i(225745);
        p.h(fVar, "deserializer");
        p.h(fVar, "deserializer");
        T t2 = (T) c.a.a(this, fVar, t);
        AppMethodBeat.o(225745);
        return t2;
    }

    @Override // kotlinx.a.a.a
    public final <T> T b(kotlinx.a.f<T> fVar, T t) {
        AppMethodBeat.i(225746);
        p.h(fVar, "deserializer");
        p.h(fVar, "deserializer");
        T t2 = (T) c.a.b(this, fVar, t);
        AppMethodBeat.o(225746);
        return t2;
    }
}
