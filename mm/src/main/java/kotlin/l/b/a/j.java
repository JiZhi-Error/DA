package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.b.a.a.a;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.a.e;
import kotlin.l.b.a.a.f;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.c;
import kotlin.l.b.a.i;
import kotlin.l.b.a.y;
import kotlin.l.e;
import kotlin.l.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J&\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0010\u0010:\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0013\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "kotlin-reflection"})
public final class j extends e<Object> implements m<Object>, b, e<Object> {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), aa.a(new y(aa.bp(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), aa.a(new y(aa.bp(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    private final y.a SZW;
    private final y.b TaG;
    private final y.b TaH;
    final i TaI;
    private final Object TaJ;
    private final String signature;

    static {
        AppMethodBeat.i(56371);
        AppMethodBeat.o(56371);
    }

    private j(i iVar, String str, String str2, t tVar, Object obj) {
        AppMethodBeat.i(56382);
        this.TaI = iVar;
        this.signature = str2;
        this.TaJ = obj;
        this.SZW = y.a(tVar, new c(this, str));
        this.TaG = y.aj(new a(this));
        this.TaH = y.aj(new b(this));
        AppMethodBeat.o(56382);
    }

    @Override // kotlin.l.b.a.e
    public final /* synthetic */ kotlin.l.b.a.b.b.b hys() {
        AppMethodBeat.i(56374);
        t hyE = hyE();
        AppMethodBeat.o(56374);
        return hyE;
    }

    @Override // kotlin.l.b.a.e
    public final i hyv() {
        return this.TaI;
    }

    private /* synthetic */ j(i iVar, String str, String str2, t tVar) {
        this(iVar, str, str2, tVar, kotlin.g.b.e.SYm);
        AppMethodBeat.i(56383);
        AppMethodBeat.o(56383);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public j(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        p.h(iVar, "container");
        p.h(str, "name");
        p.h(str2, "signature");
        AppMethodBeat.i(56384);
        AppMethodBeat.o(56384);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(kotlin.l.b.a.i r4, kotlin.l.b.a.b.b.t r5) {
        /*
            r3 = this;
            r2 = 56385(0xdc41, float:7.9012E-41)
            java.lang.String r0 = "container"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "descriptor"
            kotlin.g.b.p.h(r5, r0)
            kotlin.l.b.a.b.f.f r0 = r5.hAH()
            java.lang.String r0 = r0.sG()
            java.lang.String r1 = "descriptor.name.asString()"
            kotlin.g.b.p.g(r0, r1)
            kotlin.l.b.a.ac r1 = kotlin.l.b.a.ac.TbJ
            kotlin.l.b.a.c r1 = kotlin.l.b.a.ac.c(r5)
            java.lang.String r1 = r1.sG()
            r3.<init>(r4, r0, r1, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.j.<init>(kotlin.l.b.a.i, kotlin.l.b.a.b.b.t):void");
    }

    @Override // kotlin.l.b.a.e
    public final boolean isBound() {
        AppMethodBeat.i(56372);
        boolean z = !p.j(this.TaJ, kotlin.g.b.e.SYm);
        AppMethodBeat.o(56372);
        return z;
    }

    @Override // kotlin.l.a
    public final String getName() {
        AppMethodBeat.i(56375);
        String sG = hyE().hAH().sG();
        p.g(sG, "descriptor.name.asString()");
        AppMethodBeat.o(56375);
        return sG;
    }

    private final Object hxQ() {
        AppMethodBeat.i(56377);
        Object a2 = h.a(this.TaJ, hyE());
        AppMethodBeat.o(56377);
        return a2;
    }

    @Override // kotlin.g.b.m
    public final int getArity() {
        AppMethodBeat.i(56378);
        int a2 = f.a(hyt());
        AppMethodBeat.o(56378);
        return a2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56379);
        j fh = ae.fh(obj);
        if (fh == null) {
            AppMethodBeat.o(56379);
            return false;
        } else if (!p.j(this.TaI, fh.TaI) || !p.j(getName(), fh.getName()) || !p.j(this.signature, fh.signature) || !p.j(this.TaJ, fh.TaJ)) {
            AppMethodBeat.o(56379);
            return false;
        } else {
            AppMethodBeat.o(56379);
            return true;
        }
    }

    public final String toString() {
        AppMethodBeat.i(56381);
        aa aaVar = aa.TbF;
        String a2 = aa.a(hyE());
        AppMethodBeat.o(56381);
        return a2;
    }

    public final t hyE() {
        AppMethodBeat.i(56373);
        t tVar = (t) this.SZW.invoke();
        AppMethodBeat.o(56373);
        return tVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<t> {
        final /* synthetic */ j TaK;
        final /* synthetic */ String naX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar, String str) {
            super(0);
            this.TaK = jVar;
            this.naX = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ t invoke() {
            Collection<t> b2;
            boolean z = false;
            AppMethodBeat.i(56370);
            i iVar = this.TaK.TaI;
            String str = this.naX;
            String str2 = this.TaK.signature;
            p.h(str, "name");
            p.h(str2, "signature");
            if (p.j(str, "<init>")) {
                b2 = kotlin.a.j.p(iVar.hyq());
            } else {
                kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(str);
                p.g(btY, "Name.identifier(name)");
                b2 = iVar.b(btY);
            }
            ArrayList arrayList = new ArrayList();
            for (T t : b2) {
                ac acVar = ac.TbJ;
                if (p.j(ac.c((t) t).sG(), str2)) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.size() != 1) {
                String a2 = kotlin.a.j.a(b2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, i.d.TaD, 30);
                StringBuilder append = new StringBuilder("Function '").append(str).append("' (JVM signature: ").append(str2).append(") not resolved in ").append(iVar).append(':');
                if (a2.length() == 0) {
                    z = true;
                }
                w wVar = new w(append.append(z ? " no members found" : "\n".concat(String.valueOf(a2))).toString());
                AppMethodBeat.o(56370);
                throw wVar;
            }
            t tVar = (t) kotlin.a.j.kw(arrayList2);
            AppMethodBeat.o(56370);
            return tVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<d<? extends Member>> {
        final /* synthetic */ j TaK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j jVar) {
            super(0);
            this.TaK = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d<? extends Member> invoke() {
            Constructor<?> constructor;
            e.h c2;
            e.h hVar;
            AppMethodBeat.i(56368);
            ac acVar = ac.TbJ;
            c c3 = ac.c(this.TaK.hyE());
            if (c3 instanceof c.d) {
                if (this.TaK.hyw()) {
                    Class<?> hxU = this.TaK.TaI.hxU();
                    List<kotlin.l.j> parameters = this.TaK.getParameters();
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = it.next().getName();
                        if (name == null) {
                            p.hyc();
                        }
                        arrayList.add(name);
                    }
                    kotlin.l.b.a.a.a aVar = new kotlin.l.b.a.a.a(hxU, arrayList, a.EnumC2264a.POSITIONAL_CALL, a.b.KOTLIN);
                    AppMethodBeat.o(56368);
                    return aVar;
                }
                constructor = this.TaK.TaI.btw(((c.d) c3).SZB.desc);
            } else if (c3 instanceof c.e) {
                constructor = this.TaK.TaI.oq(((c.e) c3).SZB.name, ((c.e) c3).SZB.desc);
            } else if (c3 instanceof c.C2369c) {
                constructor = ((c.C2369c) c3).method;
            } else if (c3 instanceof c.b) {
                constructor = ((c.b) c3).SZy;
            } else if (c3 instanceof c.a) {
                List<Method> list = ((c.a) c3).SZw;
                Class<?> hxU2 = this.TaK.TaI.hxU();
                List<Method> list2 = list;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
                for (T t : list2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList2.add(t.getName());
                }
                kotlin.l.b.a.a.a aVar2 = new kotlin.l.b.a.a.a(hxU2, arrayList2, a.EnumC2264a.POSITIONAL_CALL, a.b.JAVA, list);
                AppMethodBeat.o(56368);
                return aVar2;
            } else {
                kotlin.m mVar = new kotlin.m();
                AppMethodBeat.o(56368);
                throw mVar;
            }
            if (constructor instanceof Constructor) {
                hVar = j.a(this.TaK, (Constructor) constructor, this.TaK.hyE());
            } else if (constructor instanceof Method) {
                if (!Modifier.isStatic(((Method) constructor).getModifiers())) {
                    c2 = j.a(this.TaK, (Method) constructor);
                } else if (this.TaK.hyE().hzL().g(ae.hyU()) != null) {
                    c2 = j.b(this.TaK, (Method) constructor);
                } else {
                    c2 = j.c(this.TaK, (Method) constructor);
                }
                hVar = c2;
            } else {
                w wVar = new w("Could not compute caller for function: " + this.TaK.hyE() + " (member = " + constructor + ')');
                AppMethodBeat.o(56368);
                throw wVar;
            }
            d a2 = h.a(hVar, (kotlin.l.b.a.b.b.b) this.TaK.hyE());
            AppMethodBeat.o(56368);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<d<? extends Member>> {
        final /* synthetic */ j TaK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super(0);
            this.TaK = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d<? extends Member> invoke() {
            Constructor<?> constructor;
            e.h hVar;
            e.h c2;
            AppMethodBeat.i(56369);
            ac acVar = ac.TbJ;
            c c3 = ac.c(this.TaK.hyE());
            if (c3 instanceof c.e) {
                i iVar = this.TaK.TaI;
                String str = ((c.e) c3).SZB.name;
                String str2 = ((c.e) c3).SZB.desc;
                Member hyV = this.TaK.hyt().hyV();
                if (hyV == null) {
                    p.hyc();
                }
                constructor = iVar.H(str, str2, !Modifier.isStatic(hyV.getModifiers()));
            } else if (c3 instanceof c.d) {
                if (this.TaK.hyw()) {
                    Class<?> hxU = this.TaK.TaI.hxU();
                    List<kotlin.l.j> parameters = this.TaK.getParameters();
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = it.next().getName();
                        if (name == null) {
                            p.hyc();
                        }
                        arrayList.add(name);
                    }
                    kotlin.l.b.a.a.a aVar = new kotlin.l.b.a.a.a(hxU, arrayList, a.EnumC2264a.CALL_BY_NAME, a.b.KOTLIN);
                    AppMethodBeat.o(56369);
                    return aVar;
                }
                i iVar2 = this.TaK.TaI;
                String str3 = ((c.d) c3).SZB.desc;
                p.h(str3, "desc");
                Class<?> hxU2 = iVar2.hxU();
                ArrayList arrayList2 = new ArrayList();
                iVar2.d(arrayList2, str3, true);
                constructor = i.a(hxU2, arrayList2);
            } else if (c3 instanceof c.a) {
                List<Method> list = ((c.a) c3).SZw;
                Class<?> hxU3 = this.TaK.TaI.hxU();
                List<Method> list2 = list;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list2, 10));
                for (T t : list2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList3.add(t.getName());
                }
                kotlin.l.b.a.a.a aVar2 = new kotlin.l.b.a.a.a(hxU3, arrayList3, a.EnumC2264a.CALL_BY_NAME, a.b.JAVA, list);
                AppMethodBeat.o(56369);
                return aVar2;
            } else {
                constructor = null;
            }
            if (constructor instanceof Constructor) {
                hVar = j.a(this.TaK, (Constructor) constructor, this.TaK.hyE());
            } else if (constructor instanceof Method) {
                if (this.TaK.hyE().hzL().g(ae.hyU()) != null) {
                    kotlin.l.b.a.b.b.l hzx = this.TaK.hyE().hzx();
                    if (hzx == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(56369);
                        throw tVar;
                    } else if (!((kotlin.l.b.a.b.b.e) hzx).hzF()) {
                        c2 = j.b(this.TaK, (Method) constructor);
                        hVar = c2;
                    }
                }
                c2 = j.c(this.TaK, (Method) constructor);
                hVar = c2;
            } else {
                hVar = null;
            }
            if (hVar != null) {
                d a2 = h.a(hVar, this.TaK.hyE(), true);
                AppMethodBeat.o(56369);
                return a2;
            }
            AppMethodBeat.o(56369);
            return null;
        }
    }

    @Override // kotlin.l.b.a.e
    public final d<?> hyt() {
        AppMethodBeat.i(56376);
        d<?> dVar = (d) this.TaG.invoke();
        AppMethodBeat.o(56376);
        return dVar;
    }

    @Override // kotlin.l.b.a.e
    public final d<?> hyu() {
        AppMethodBeat.i(186231);
        d<?> dVar = (d) this.TaH.invoke();
        AppMethodBeat.o(186231);
        return dVar;
    }

    public final int hashCode() {
        AppMethodBeat.i(56380);
        int hashCode = (((this.TaI.hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
        AppMethodBeat.o(56380);
        return hashCode;
    }

    @Override // kotlin.g.a.a
    public final Object invoke() {
        AppMethodBeat.i(56386);
        Object ag = ag(new Object[0]);
        AppMethodBeat.o(56386);
        return ag;
    }

    @Override // kotlin.g.a.b
    public final Object invoke(Object obj) {
        AppMethodBeat.i(56387);
        Object ag = ag(obj);
        AppMethodBeat.o(56387);
        return ag;
    }

    @Override // kotlin.g.a.m
    public final Object invoke(Object obj, Object obj2) {
        AppMethodBeat.i(56388);
        Object ag = ag(obj, obj2);
        AppMethodBeat.o(56388);
        return ag;
    }

    @Override // kotlin.g.a.q
    public final Object d(Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(56389);
        Object ag = ag(obj, obj2, obj3);
        AppMethodBeat.o(56389);
        return ag;
    }

    @Override // kotlin.g.a.r
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(56390);
        Object ag = ag(obj, obj2, obj3, obj4);
        AppMethodBeat.o(56390);
        return ag;
    }

    @Override // kotlin.g.a.s
    public final Object a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(168742);
        Object ag = ag(obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(168742);
        return ag;
    }

    @Override // kotlin.g.a.u
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        AppMethodBeat.i(186232);
        Object ag = ag(obj, obj2, obj3, obj4, obj5, obj6, obj7);
        AppMethodBeat.o(186232);
        return ag;
    }

    public static final /* synthetic */ kotlin.l.b.a.a.e a(j jVar, Constructor constructor, t tVar) {
        t tVar2;
        boolean z;
        AppMethodBeat.i(56391);
        t tVar3 = tVar;
        p.h(tVar3, "descriptor");
        if (!(tVar3 instanceof kotlin.l.b.a.b.b.d)) {
            tVar2 = null;
        } else {
            tVar2 = tVar3;
        }
        kotlin.l.b.a.b.b.d dVar = (kotlin.l.b.a.b.b.d) tVar2;
        if (dVar != null && !az.b(dVar.hzE())) {
            kotlin.l.b.a.b.b.e hAS = dVar.hAS();
            p.g(hAS, "constructorDescriptor.constructedClass");
            if (!hAS.hzI() && !kotlin.l.b.a.b.j.c.v(dVar.hAS())) {
                List<av> hAw = dVar.hAw();
                p.g(hAw, "constructorDescriptor.valueParameters");
                List<av> list = hAw;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        p.g(next, LocaleUtil.ITALIAN);
                        ab hBy = next.hBy();
                        p.g(hBy, "it.type");
                        if (kotlin.l.b.a.b.j.e.a.ag(hBy)) {
                            z = true;
                            break;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            if (jVar.isBound()) {
                e.a aVar = new e.a(constructor, jVar.hxQ());
                AppMethodBeat.o(56391);
                return aVar;
            }
            e.b bVar = new e.b(constructor);
            AppMethodBeat.o(56391);
            return bVar;
        } else if (jVar.isBound()) {
            e.c cVar = new e.c(constructor, jVar.hxQ());
            AppMethodBeat.o(56391);
            return cVar;
        } else {
            e.C2266e eVar = new e.C2266e(constructor);
            AppMethodBeat.o(56391);
            return eVar;
        }
    }

    public static final /* synthetic */ e.h a(j jVar, Method method) {
        AppMethodBeat.i(56392);
        if (jVar.isBound()) {
            e.h.a aVar = new e.h.a(method, jVar.hxQ());
            AppMethodBeat.o(56392);
            return aVar;
        }
        e.h.d dVar = new e.h.d(method);
        AppMethodBeat.o(56392);
        return dVar;
    }

    public static final /* synthetic */ e.h b(j jVar, Method method) {
        AppMethodBeat.i(56393);
        if (jVar.isBound()) {
            e.h.b bVar = new e.h.b(method);
            AppMethodBeat.o(56393);
            return bVar;
        }
        e.h.C2269e eVar = new e.h.C2269e(method);
        AppMethodBeat.o(56393);
        return eVar;
    }

    public static final /* synthetic */ e.h c(j jVar, Method method) {
        AppMethodBeat.i(56394);
        if (jVar.isBound()) {
            e.h.c cVar = new e.h.c(method, jVar.hxQ());
            AppMethodBeat.o(56394);
            return cVar;
        }
        e.h.f fVar = new e.h.f(method);
        AppMethodBeat.o(56394);
        return fVar;
    }
}
