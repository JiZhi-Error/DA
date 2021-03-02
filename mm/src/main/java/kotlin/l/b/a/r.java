package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ab;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.d;
import kotlin.l.b.a.i;
import kotlin.l.b.a.y;
import kotlin.l.f;
import kotlin.l.k;
import kotlin.m;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 >*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004=>?@B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\n\u00104\u001a\u0004\u0018\u00010\u0017H\u0004J\u0013\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00107\u001a\u0004\u0018\u00010\n2\b\u00108\u001a\u0004\u0018\u00010\u00172\b\u00109\u001a\u0004\u0018\u00010\nH\u0004J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\r0\r0\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0013\u0010.\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00102¨\u0006A"}, hxF = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", FacebookRequestErrorClassification.KEY_OTHER, "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"})
public abstract class r<R> extends e<R> implements k<R> {
    private static final Object Tbg = new Object();
    public static final b Tbh = new b((byte) 0);
    final i TaI;
    private final Object TaJ;
    private final y.b<Field> Tbe;
    private final y.a<ah> Tbf;
    final String name;
    final String signature;

    public abstract c<R> hyJ();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Field> {
        final /* synthetic */ r Tbk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(r rVar) {
            super(0);
            this.Tbk = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Field invoke() {
            AppMethodBeat.i(56478);
            Field hyS = hyS();
            AppMethodBeat.o(56478);
            return hyS;
        }

        private Field hyS() {
            Class<?> cls;
            Field field;
            Field field2 = null;
            AppMethodBeat.i(56479);
            ac acVar = ac.TbJ;
            d c2 = ac.c(this.Tbk.hys());
            if (c2 instanceof d.c) {
                ah ahVar = ((d.c) c2).SZE;
                i iVar = i.TCN;
                e.a a2 = i.a(((d.c) c2).SZF, ((d.c) c2).SZH, ((d.c) c2).SZI);
                if (a2 != null) {
                    if (o.d(ahVar) || i.f(((d.c) c2).SZF)) {
                        cls = this.Tbk.TaI.hxU().getEnclosingClass();
                    } else {
                        kotlin.l.b.a.b.b.l hzx = ahVar.hzx();
                        if (hzx instanceof kotlin.l.b.a.b.b.e) {
                            cls = ae.a((kotlin.l.b.a.b.b.e) hzx);
                        } else {
                            cls = this.Tbk.TaI.hxU();
                        }
                    }
                    if (cls != null) {
                        try {
                            field = cls.getDeclaredField(a2.name);
                        } catch (NoSuchFieldException e2) {
                        }
                    } else {
                        field = null;
                    }
                    field2 = field;
                    AppMethodBeat.o(56479);
                    return field2;
                }
                AppMethodBeat.o(56479);
                return null;
            } else if (c2 instanceof d.a) {
                Field field3 = ((d.a) c2).bUo;
                AppMethodBeat.o(56479);
                return field3;
            } else if (c2 instanceof d.b) {
                AppMethodBeat.o(56479);
                return null;
            } else if (c2 instanceof d.C2370d) {
                AppMethodBeat.o(56479);
                return null;
            } else {
                m mVar = new m();
                AppMethodBeat.o(56479);
                throw mVar;
            }
        }
    }

    @Override // kotlin.l.b.a.e
    public final i hyv() {
        return this.TaI;
    }

    @Override // kotlin.l.a
    public final String getName() {
        return this.name;
    }

    private r(i iVar, String str, String str2, ah ahVar, Object obj) {
        this.TaI = iVar;
        this.name = str;
        this.signature = str2;
        this.TaJ = obj;
        y.b<Field> aj = y.aj(new f(this));
        p.g(aj, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.Tbe = aj;
        y.a<ah> a2 = y.a(ahVar, new e(this));
        p.g(a2, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.Tbf = a2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        p.h(iVar, "container");
        p.h(str, "name");
        p.h(str2, "signature");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public r(kotlin.l.b.a.i r7, kotlin.l.b.a.b.b.ah r8) {
        /*
            r6 = this;
            java.lang.String r0 = "container"
            kotlin.g.b.p.h(r7, r0)
            java.lang.String r0 = "descriptor"
            kotlin.g.b.p.h(r8, r0)
            kotlin.l.b.a.b.f.f r0 = r8.hAH()
            java.lang.String r2 = r0.sG()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.g.b.p.g(r2, r0)
            kotlin.l.b.a.ac r0 = kotlin.l.b.a.ac.TbJ
            kotlin.l.b.a.d r0 = kotlin.l.b.a.ac.c(r8)
            java.lang.String r3 = r0.sG()
            java.lang.Object r5 = kotlin.g.b.e.SYm
            r0 = r6
            r1 = r7
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.r.<init>(kotlin.l.b.a.i, kotlin.l.b.a.b.b.ah):void");
    }

    public final Object hxQ() {
        return h.a(this.TaJ, hys());
    }

    @Override // kotlin.l.b.a.e
    public final boolean isBound() {
        return !p.j(this.TaJ, kotlin.g.b.e.SYm);
    }

    public final Field hyM() {
        return this.Tbe.invoke();
    }

    /* access modifiers changed from: protected */
    public final Field hyN() {
        if (hys().hBJ()) {
            return hyM();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final Object a(Field field, Object obj) {
        try {
            if (obj == Tbg && hys().hAr() == null) {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            } else if (field != null) {
                return field.get(obj);
            } else {
                return null;
            }
        } catch (IllegalAccessException e2) {
            throw new kotlin.l.a.b(e2);
        }
    }

    /* renamed from: hyO */
    public final ah hys() {
        ah invoke = this.Tbf.invoke();
        p.g(invoke, "_descriptor()");
        return invoke;
    }

    @Override // kotlin.l.b.a.e
    public final kotlin.l.b.a.a.d<?> hyt() {
        return hyJ().hyt();
    }

    @Override // kotlin.l.b.a.e
    public final kotlin.l.b.a.a.d<?> hyu() {
        hyJ();
        return null;
    }

    public boolean equals(Object obj) {
        r<?> fi = ae.fi(obj);
        if (fi != null && p.j(this.TaI, fi.TaI) && p.j(this.name, fi.name) && p.j(this.signature, fi.signature) && p.j(this.TaJ, fi.TaJ)) {
            return true;
        }
        return false;
    }

    public String toString() {
        aa aaVar = aa.TbF;
        return aa.b(hys());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, hxF = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"})
    public static abstract class a<PropertyType, ReturnType> extends e<ReturnType> implements kotlin.l.e<ReturnType> {
        public abstract r<PropertyType> hyF();

        public abstract ag hyP();

        @Override // kotlin.l.b.a.e
        public final i hyv() {
            return hyF().TaI;
        }

        @Override // kotlin.l.b.a.e
        public final kotlin.l.b.a.a.d<?> hyu() {
            return null;
        }

        @Override // kotlin.l.b.a.e
        public final boolean isBound() {
            return hyF().isBound();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
    public static abstract class c<R> extends a<R, R> implements k.a<R> {
        static final /* synthetic */ k[] cLI = {aa.a(new kotlin.g.b.y(aa.bp(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), aa.a(new kotlin.g.b.y(aa.bp(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final y.a SZW = y.ak(new b(this));
        private final y.b TaG = y.aj(new a(this));

        @Override // kotlin.l.a
        public final String getName() {
            return "<get-" + hyF().name + '>';
        }

        /* access modifiers changed from: private */
        /* renamed from: hyQ */
        public ai hys() {
            return (ai) this.SZW.invoke();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "R", "invoke"})
        static final class b extends q implements kotlin.g.a.a<ai> {
            final /* synthetic */ c Tbi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar) {
                super(0);
                this.Tbi = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ai invoke() {
                AppMethodBeat.i(56474);
                ab hBn = this.Tbi.hyF().hys().hBn();
                if (hBn == null) {
                    ah hyO = this.Tbi.hyF().hys();
                    g.a aVar = g.TiC;
                    hBn = kotlin.l.b.a.b.j.b.a(hyO, g.a.hBP());
                }
                AppMethodBeat.o(56474);
                return hBn;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0006\b\u0000\u0010\u0002 \u0001\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        static final class a extends q implements kotlin.g.a.a<kotlin.l.b.a.a.d<?>> {
            final /* synthetic */ c Tbi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.Tbi = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.l.b.a.a.d<?> invoke() {
                AppMethodBeat.i(56473);
                kotlin.l.b.a.a.d<?> a2 = s.a(this.Tbi, true);
                AppMethodBeat.o(56473);
                return a2;
            }
        }

        @Override // kotlin.l.b.a.e
        public final kotlin.l.b.a.a.d<?> hyt() {
            return (kotlin.l.b.a.a.d) this.TaG.invoke();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, hxF = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"})
    public static abstract class d<R> extends a<R, x> implements f.a<R> {
        static final /* synthetic */ k[] cLI = {aa.a(new kotlin.g.b.y(aa.bp(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), aa.a(new kotlin.g.b.y(aa.bp(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final y.a SZW = y.ak(new b(this));
        private final y.b TaG = y.aj(new a(this));

        @Override // kotlin.l.a
        public final String getName() {
            return "<set-" + hyF().name + '>';
        }

        /* access modifiers changed from: private */
        /* renamed from: hyR */
        public aj hys() {
            return (aj) this.SZW.invoke();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"})
        static final class b extends q implements kotlin.g.a.a<aj> {
            final /* synthetic */ d Tbj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar) {
                super(0);
                this.Tbj = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ aj invoke() {
                AppMethodBeat.i(56476);
                ac hBo = this.Tbj.hyF().hys().hBo();
                if (hBo == null) {
                    ah hyO = this.Tbj.hyF().hys();
                    g.a aVar = g.TiC;
                    g hBP = g.a.hBP();
                    g.a aVar2 = g.TiC;
                    hBo = kotlin.l.b.a.b.j.b.a(hyO, hBP, g.a.hBP());
                }
                AppMethodBeat.o(56476);
                return hBo;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "R", "invoke"})
        static final class a extends q implements kotlin.g.a.a<kotlin.l.b.a.a.d<?>> {
            final /* synthetic */ d Tbj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.Tbj = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.l.b.a.a.d<?> invoke() {
                AppMethodBeat.i(56475);
                kotlin.l.b.a.a.d<?> a2 = s.a(this.Tbj, false);
                AppMethodBeat.o(56475);
                return a2;
            }
        }

        @Override // kotlin.l.b.a.e
        public final kotlin.l.b.a.a.d<?> hyt() {
            return (kotlin.l.b.a.a.d) this.TaG.invoke();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
    static final class e extends q implements kotlin.g.a.a<ah> {
        final /* synthetic */ r Tbk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(r rVar) {
            super(0);
            this.Tbk = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ah invoke() {
            boolean z = false;
            AppMethodBeat.i(56477);
            i iVar = this.Tbk.TaI;
            String str = this.Tbk.name;
            String str2 = this.Tbk.signature;
            p.h(str, "name");
            p.h(str2, "signature");
            kotlin.n.i aK = i.Tav.aK(str2);
            if (aK != null) {
                String str3 = aK.hMj().TTa.hMi().get(1);
                ah atL = iVar.atL(Integer.parseInt(str3));
                if (atL == null) {
                    w wVar = new w("Local property #" + str3 + " not found in " + iVar.hxU());
                    AppMethodBeat.o(56477);
                    throw wVar;
                }
                AppMethodBeat.o(56477);
                return atL;
            }
            kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(str);
            p.g(btY, "Name.identifier(name)");
            ArrayList arrayList = new ArrayList();
            for (T t : iVar.a(btY)) {
                ac acVar = ac.TbJ;
                if (p.j(ac.c((ah) t).sG(), str2)) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.isEmpty()) {
                w wVar2 = new w("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + iVar);
                AppMethodBeat.o(56477);
                throw wVar2;
            } else if (arrayList2.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : arrayList2) {
                    ba hzE = ((ah) obj).hzE();
                    Object obj2 = linkedHashMap.get(hzE);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(hzE, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                i.f fVar = i.f.TaF;
                p.h(linkedHashMap, "$this$toSortedMap");
                p.h(fVar, "comparator");
                TreeMap treeMap = new TreeMap(fVar);
                treeMap.putAll(linkedHashMap);
                Collection values = treeMap.values();
                p.g(values, "properties\n             …                }).values");
                List list = (List) j.g(values);
                if (list.size() == 1) {
                    p.g(list, "mostVisibleProperties");
                    ah ahVar = (ah) j.ks(list);
                    AppMethodBeat.o(56477);
                    return ahVar;
                }
                kotlin.l.b.a.b.f.f btY2 = kotlin.l.b.a.b.f.f.btY(str);
                p.g(btY2, "Name.identifier(name)");
                String a2 = j.a(iVar.a(btY2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, i.e.TaE, 30);
                StringBuilder append = new StringBuilder("Property '").append(str).append("' (JVM signature: ").append(str2).append(") not resolved in ").append(iVar).append(':');
                if (a2.length() == 0) {
                    z = true;
                }
                w wVar3 = new w(append.append(z ? " no members found" : "\n".concat(String.valueOf(a2))).toString());
                AppMethodBeat.o(56477);
                throw wVar3;
            } else {
                ah ahVar2 = (ah) j.kw(arrayList2);
                AppMethodBeat.o(56477);
                return ahVar2;
            }
        }
    }

    public int hashCode() {
        return (((this.TaI.hashCode() * 31) + this.name.hashCode()) * 31) + this.signature.hashCode();
    }
}
