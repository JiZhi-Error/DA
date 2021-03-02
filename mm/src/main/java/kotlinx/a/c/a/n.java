package kotlinx.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.a.b;
import kotlinx.a.b.bj;
import kotlinx.a.c.d;
import kotlinx.a.c.j;
import kotlinx.a.c.u;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.m;
import kotlinx.a.s;
import kotlinx.a.v;
import kotlinx.a.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FB3\b\u0010\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\u0010\fB-\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\u0010\u000fJ1\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u001a\u0010 \u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030!0\u000b\"\u0006\u0012\u0002\b\u00030!H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010%\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010%\u001a\u00020.H\u0016J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010%\u001a\u000208H\u0016J\b\u00109\u001a\u00020$H\u0016J)\u0010:\u001a\u00020$\"\u0004\b\u0000\u0010;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0006\u0010%\u001a\u0002H;H\u0016¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020$2\u0006\u0010%\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010%\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010D\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010E\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lkotlinx/serialization/json/internal/StreamingJsonOutput;", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/builtins/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", FFmpegMetadataRetriever.METADATA_KEY_COMPOSER, "Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonOutput;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", FirebaseAnalytics.b.INDEX, "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJson", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"})
public final class n extends b implements u {
    private final d TZf;
    private final kotlinx.a.c.a Uae;
    private final kotlinx.a.d.b Uar;
    private final r Uas;
    private boolean Uat;
    private boolean Uau;
    private final a Uav;
    private final u[] Uaw;

    @Override // kotlinx.a.c.u
    public final kotlinx.a.c.a hOQ() {
        return this.Uae;
    }

    private n(a aVar, kotlinx.a.c.a aVar2, r rVar, u[] uVarArr) {
        p.h(aVar, FFmpegMetadataRetriever.METADATA_KEY_COMPOSER);
        p.h(aVar2, "json");
        p.h(rVar, "mode");
        p.h(uVarArr, "modeReuseCache");
        AppMethodBeat.i(225694);
        this.Uav = aVar;
        this.Uae = aVar2;
        this.Uas = rVar;
        this.Uaw = uVarArr;
        this.Uar = this.Uae.TZe;
        this.TZf = this.Uae.TZf;
        int ordinal = this.Uas.ordinal();
        if (!(this.Uaw[ordinal] == null && this.Uaw[ordinal] == this)) {
            this.Uaw[ordinal] = this;
        }
        AppMethodBeat.o(225694);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n(StringBuilder sb, kotlinx.a.c.a aVar, r rVar, u[] uVarArr) {
        this(new a(sb, aVar), aVar, rVar, uVarArr);
        p.h(sb, "output");
        p.h(aVar, "json");
        p.h(rVar, "mode");
        p.h(uVarArr, "modeReuseCache");
        AppMethodBeat.i(225695);
        AppMethodBeat.o(225695);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final kotlinx.a.d.b hOk() {
        return this.Uar;
    }

    @Override // kotlinx.a.a.b, kotlinx.a.b
    public final boolean c(kotlinx.a.n nVar) {
        AppMethodBeat.i(225679);
        p.h(nVar, "descriptor");
        boolean z = this.TZf.TZq;
        AppMethodBeat.o(225679);
        return z;
    }

    @Override // kotlinx.a.b
    public final void a(kotlinx.a.n nVar) {
        AppMethodBeat.i(225682);
        p.h(nVar, "descriptor");
        if (this.Uas.UaH != 0) {
            a aVar = this.Uav;
            aVar.level--;
            this.Uav.hPf();
            this.Uav.H(this.Uas.UaH);
        }
        AppMethodBeat.o(225682);
    }

    @Override // kotlinx.a.a.b
    public final boolean j(kotlinx.a.n nVar, int i2) {
        boolean z = false;
        AppMethodBeat.i(225683);
        p.h(nVar, "descriptor");
        switch (o.$EnumSwitchMapping$0[this.Uas.ordinal()]) {
            case 1:
                if (!this.Uav.Uax) {
                    this.Uav.H(',');
                }
                this.Uav.hPf();
                break;
            case 2:
                if (this.Uav.Uax) {
                    this.Uat = true;
                    this.Uav.hPf();
                    break;
                } else {
                    if (i2 % 2 == 0) {
                        this.Uav.H(',');
                        this.Uav.hPf();
                        z = true;
                    } else {
                        this.Uav.H(':');
                        this.Uav.hPg();
                    }
                    this.Uat = z;
                    break;
                }
            case 3:
                if (i2 == 0) {
                    this.Uat = true;
                }
                if (i2 == 1) {
                    this.Uav.H(',');
                    this.Uav.hPg();
                    this.Uat = false;
                    break;
                }
                break;
            default:
                if (!this.Uav.Uax) {
                    this.Uav.H(',');
                }
                this.Uav.hPf();
                buE(nVar.awc(i2));
                this.Uav.H(':');
                this.Uav.hPg();
                break;
        }
        AppMethodBeat.o(225683);
        return true;
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void hOx() {
        AppMethodBeat.i(225684);
        this.Uav.buP(BuildConfig.COMMAND);
        AppMethodBeat.o(225684);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void Fb(boolean z) {
        AppMethodBeat.i(225685);
        if (this.Uat) {
            buE(String.valueOf(z));
            AppMethodBeat.o(225685);
            return;
        }
        this.Uav.sb.append(z);
        AppMethodBeat.o(225685);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void m(byte b2) {
        AppMethodBeat.i(225686);
        if (this.Uat) {
            buE(String.valueOf((int) b2));
            AppMethodBeat.o(225686);
            return;
        }
        this.Uav.sb.append(Byte.valueOf(b2));
        AppMethodBeat.o(225686);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void d(short s) {
        AppMethodBeat.i(225687);
        if (this.Uat) {
            buE(String.valueOf((int) s));
            AppMethodBeat.o(225687);
            return;
        }
        this.Uav.sb.append(Short.valueOf(s));
        AppMethodBeat.o(225687);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void awb(int i2) {
        AppMethodBeat.i(225688);
        if (this.Uat) {
            buE(String.valueOf(i2));
            AppMethodBeat.o(225688);
            return;
        }
        this.Uav.sb.append(i2);
        AppMethodBeat.o(225688);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void Pq(long j2) {
        AppMethodBeat.i(225689);
        if (this.Uat) {
            buE(String.valueOf(j2));
            AppMethodBeat.o(225689);
            return;
        }
        this.Uav.sb.append(j2);
        AppMethodBeat.o(225689);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void cU(float f2) {
        AppMethodBeat.i(225690);
        if (this.Uat) {
            buE(String.valueOf(f2));
        } else {
            this.Uav.sb.append(f2);
        }
        if (!this.TZf.TZt) {
            if (!(!Float.isInfinite(f2) && !Float.isNaN(f2))) {
                String sb = this.Uav.sb.toString();
                p.g(sb, "composer.sb.toString()");
                j a2 = kotlinx.a.c.l.a(Float.valueOf(f2), "float", sb);
                AppMethodBeat.o(225690);
                throw a2;
            }
        }
        AppMethodBeat.o(225690);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void O(double d2) {
        AppMethodBeat.i(225691);
        if (this.Uat) {
            buE(String.valueOf(d2));
        } else {
            this.Uav.sb.append(d2);
        }
        if (!this.TZf.TZt) {
            if (!(!Double.isInfinite(d2) && !Double.isNaN(d2))) {
                String sb = this.Uav.sb.toString();
                p.g(sb, "composer.sb.toString()");
                j a2 = kotlinx.a.c.l.a(Double.valueOf(d2), "double", sb);
                AppMethodBeat.o(225691);
                throw a2;
            }
        }
        AppMethodBeat.o(225691);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void F(char c2) {
        AppMethodBeat.i(225692);
        buE(String.valueOf(c2));
        AppMethodBeat.o(225692);
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final void buE(String str) {
        AppMethodBeat.i(225693);
        p.h(str, "value");
        if (!this.TZf.TZw || p.buT(str)) {
            this.Uav.buQ(str);
            AppMethodBeat.o(225693);
            return;
        }
        this.Uav.buP(str);
        AppMethodBeat.o(225693);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0016J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0017J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0018J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u0019J\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u001aJ\u0016\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0014\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, hxF = {"Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", SharePatchInfo.FINGER_PRINT, "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"})
    public static final class a {
        private final kotlinx.a.c.a Uae;
        boolean Uax = true;
        int level;
        public final StringBuilder sb;

        public a(StringBuilder sb2, kotlinx.a.c.a aVar) {
            p.h(sb2, "sb");
            p.h(aVar, "json");
            AppMethodBeat.i(225709);
            this.sb = sb2;
            this.Uae = aVar;
            AppMethodBeat.o(225709);
        }

        public final void hPf() {
            AppMethodBeat.i(225704);
            this.Uax = false;
            if (this.Uae.TZf.TZv) {
                buP("\n");
                int i2 = this.level;
                for (int i3 = 0; i3 < i2; i3++) {
                    buP(this.Uae.TZf.TZx);
                }
            }
            AppMethodBeat.o(225704);
        }

        public final void hPg() {
            AppMethodBeat.i(225705);
            if (this.Uae.TZf.TZv) {
                H(' ');
            }
            AppMethodBeat.o(225705);
        }

        public final StringBuilder H(char c2) {
            AppMethodBeat.i(225706);
            StringBuilder append = this.sb.append(c2);
            AppMethodBeat.o(225706);
            return append;
        }

        public final StringBuilder buP(String str) {
            AppMethodBeat.i(225707);
            p.h(str, "v");
            StringBuilder append = this.sb.append(str);
            AppMethodBeat.o(225707);
            return append;
        }

        public final void buQ(String str) {
            AppMethodBeat.i(225708);
            p.h(str, "value");
            p.b(this.sb, str);
            AppMethodBeat.o(225708);
        }
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final <T> void a(v<? super T> vVar, T t) {
        AppMethodBeat.i(225680);
        p.h(vVar, "serializer");
        if (!(vVar instanceof kotlinx.a.b.b) || hOQ().TZf.TZy) {
            vVar.a(this, t);
            AppMethodBeat.o(225680);
            return;
        }
        kotlinx.a.b.b bVar = (kotlinx.a.b.b) vVar;
        n nVar = this;
        if (t == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Any");
            AppMethodBeat.o(225680);
            throw tVar;
        }
        h<? extends T> b2 = bVar.b(nVar, t);
        if (b2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
            AppMethodBeat.o(225680);
            throw tVar2;
        }
        h hVar = (h) vVar;
        String str = hOQ().TZf.TZz;
        if (!(hVar instanceof m) || !bj.e(b2.fWv()).contains(str)) {
            s hOA = b2.fWv().hOA();
            p.h(hOA, "kind");
            if (hOA instanceof x.c) {
                IllegalStateException illegalStateException = new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
                AppMethodBeat.o(225680);
                throw illegalStateException;
            } else if (hOA instanceof kotlinx.a.l) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
                AppMethodBeat.o(225680);
                throw illegalStateException2;
            } else if (hOA instanceof kotlinx.a.j) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
                AppMethodBeat.o(225680);
                throw illegalStateException3;
            } else {
                this.Uau = true;
                b2.a(this, t);
                AppMethodBeat.o(225680);
            }
        } else {
            IllegalStateException illegalStateException4 = new IllegalStateException(("Sealed class '" + b2.fWv().hOz() + "' cannot be serialized as base class '" + hVar.fWv().hOz() + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
            AppMethodBeat.o(225680);
            throw illegalStateException4;
        }
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final kotlinx.a.b b(kotlinx.a.n nVar, h<?>... hVarArr) {
        AppMethodBeat.i(225681);
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeSerializers");
        r a2 = s.a(this.Uae, nVar);
        if (a2.UaG != 0) {
            this.Uav.H(a2.UaG);
            a aVar = this.Uav;
            aVar.Uax = true;
            aVar.level++;
        }
        if (this.Uau) {
            this.Uau = false;
            this.Uav.hPf();
            buE(this.TZf.TZz);
            this.Uav.H(':');
            this.Uav.hPg();
            buE(nVar.hOz());
        }
        if (this.Uas == a2) {
            n nVar2 = this;
            AppMethodBeat.o(225681);
            return nVar2;
        }
        u uVar = this.Uaw[a2.ordinal()];
        if (uVar != null) {
            u uVar2 = uVar;
            AppMethodBeat.o(225681);
            return uVar2;
        }
        n nVar3 = new n(this.Uav, this.Uae, a2, this.Uaw);
        AppMethodBeat.o(225681);
        return nVar3;
    }

    @Override // kotlinx.a.a.b, kotlinx.a.g
    public final kotlinx.a.b c(kotlinx.a.n nVar, h<?>... hVarArr) {
        AppMethodBeat.i(225696);
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeSerializers");
        p.h(nVar, "descriptor");
        p.h(hVarArr, "typeSerializers");
        kotlinx.a.b a2 = g.a.a(this, nVar, hVarArr);
        AppMethodBeat.o(225696);
        return a2;
    }

    @Override // kotlinx.a.a.b
    public final <T> void b(v<? super T> vVar, T t) {
        AppMethodBeat.i(225697);
        p.h(vVar, "serializer");
        p.h(vVar, "serializer");
        g.a.a(this, vVar, t);
        AppMethodBeat.o(225697);
    }
}
