package kotlin.l.b.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d.a.j;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.y;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0013J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011J\u0018\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u001d\u001a\u00020%H&J\u0012\u0010&\u001a\u0004\u0018\u00010\u00172\u0006\u0010'\u001a\u00020(H&J\"\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0004J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001d\u001a\u00020%H&J\u001a\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00102\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00103\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(H\u0002JE\u00106\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t082\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010:\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010;J(\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t01H\u0002J=\u0010=\u001a\u0004\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t082\n\u00109\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010>R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, hxF = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", FirebaseAnalytics.b.INDEX, "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"})
public abstract class i implements kotlin.g.b.g {
    private static final Class<?> Tau = Class.forName("kotlin.g.b.j");
    static final k Tav = new k("<v#(\\d+)>");
    public static final a Taw = new a((byte) 0);

    public abstract Collection<ah> a(kotlin.l.b.a.b.f.f fVar);

    public abstract ah atL(int i2);

    public abstract Collection<t> b(kotlin.l.b.a.b.f.f fVar);

    public abstract Collection<kotlin.l.b.a.b.b.k> hyq();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<t, String> {
        public static final d TaD = new d();

        static {
            AppMethodBeat.i(56360);
            AppMethodBeat.o(56360);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(t tVar) {
            AppMethodBeat.i(56359);
            t tVar2 = tVar;
            p.h(tVar2, "descriptor");
            StringBuilder append = new StringBuilder().append(kotlin.l.b.a.b.i.c.TFj.k(tVar2)).append(APLogFileUtil.SEPARATOR_LOG);
            ac acVar = ac.TbJ;
            String sb = append.append(ac.c(tVar2).sG()).toString();
            AppMethodBeat.o(56359);
            return sb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"})
    static final class e extends q implements kotlin.g.a.b<ah, String> {
        public static final e TaE = new e();

        static {
            AppMethodBeat.i(56362);
            AppMethodBeat.o(56362);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(ah ahVar) {
            AppMethodBeat.i(56361);
            ah ahVar2 = ahVar;
            p.h(ahVar2, "descriptor");
            StringBuilder append = new StringBuilder().append(kotlin.l.b.a.b.i.c.TFj.k(ahVar2)).append(APLogFileUtil.SEPARATOR_LOG);
            ac acVar = ac.TbJ;
            String sb = append.append(ac.c(ahVar2).sG()).toString();
            AppMethodBeat.o(56361);
            return sb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"})
    static final class f<T> implements Comparator<ba> {
        public static final f TaF = new f();

        static {
            AppMethodBeat.i(56364);
            AppMethodBeat.o(56364);
        }

        f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(ba baVar, ba baVar2) {
            AppMethodBeat.i(56363);
            Integer b2 = az.b(baVar, baVar2);
            if (b2 != null) {
                int intValue = b2.intValue();
                AppMethodBeat.o(56363);
                return intValue;
            }
            AppMethodBeat.o(56363);
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"})
    public abstract class b {
        static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new y(aa.bp(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        final y.a Tax = y.ak(new a(this));

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "invoke"})
        static final class a extends q implements kotlin.g.a.a<j> {
            final /* synthetic */ b Taz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.Taz = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ j invoke() {
                AppMethodBeat.i(56354);
                j bs = x.bs(i.this.hxU());
                AppMethodBeat.o(56354);
                return bs;
            }
        }
    }

    private Class<?> hyC() {
        Class<?> bA = kotlin.l.b.a.b.b.d.b.b.bA(hxU());
        return bA == null ? hxU() : bA;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, hxF = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"})
    public static final class g extends kotlin.l.b.a.b.b.c.l<e<?>, x> {
        final /* synthetic */ i Tay;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(i iVar) {
            this.Tay = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.b.ah, java.lang.Object] */
        @Override // kotlin.l.b.a.b.b.c.l, kotlin.l.b.a.b.b.n
        public final /* synthetic */ e<?> a(ah ahVar, x xVar) {
            AppMethodBeat.i(56365);
            p.h(ahVar, "descriptor");
            p.h(xVar, "data");
            r a2 = i.a(this.Tay, ahVar);
            AppMethodBeat.o(56365);
            return a2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.b.k, java.lang.Object] */
        @Override // kotlin.l.b.a.b.b.c.l, kotlin.l.b.a.b.b.n
        public final /* synthetic */ e<?> a(kotlin.l.b.a.b.b.k kVar, x xVar) {
            AppMethodBeat.i(56367);
            p.h(kVar, "descriptor");
            p.h(xVar, "data");
            IllegalStateException illegalStateException = new IllegalStateException("No constructors should appear in this scope: ".concat(String.valueOf(kVar)));
            AppMethodBeat.o(56367);
            throw illegalStateException;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.b.t, java.lang.Object] */
        @Override // kotlin.l.b.a.b.b.c.l, kotlin.l.b.a.b.b.n
        public final /* synthetic */ e<?> a(t tVar, x xVar) {
            AppMethodBeat.i(56366);
            p.h(tVar, "descriptor");
            p.h(xVar, "data");
            j jVar = new j(this.Tay, tVar);
            AppMethodBeat.o(56366);
            return jVar;
        }
    }

    /* access modifiers changed from: protected */
    public final Collection<e<?>> a(h hVar, c cVar) {
        p.h(hVar, "scope");
        p.h(cVar, "belonginess");
        g gVar = new g(this);
        ArrayList arrayList = new ArrayList();
        for (kotlin.l.b.a.b.b.l lVar : j.a.a(hVar, null, null, 3)) {
            e eVar = (!(lVar instanceof kotlin.l.b.a.b.b.b) || !(!p.j(((kotlin.l.b.a.b.b.b) lVar).hzE(), az.ThX)) || !cVar.a((kotlin.l.b.a.b.b.b) lVar)) ? null : (e) lVar.a(gVar, x.SXb);
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return kotlin.a.j.p(arrayList);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"})
    protected enum c {
        DECLARED,
        INHERITED;

        static {
            AppMethodBeat.i(56355);
            AppMethodBeat.o(56355);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(56358);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(56358);
            return cVar;
        }

        public final boolean a(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(56356);
            p.h(bVar, "member");
            b.a hAA = bVar.hAA();
            p.g(hAA, "member.kind");
            if (hAA.hAB() == (this == DECLARED)) {
                AppMethodBeat.o(56356);
                return true;
            }
            AppMethodBeat.o(56356);
            return false;
        }
    }

    private final Method a(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method a2;
        if (z) {
            clsArr[0] = cls;
        }
        Method a3 = a(cls, str, clsArr, cls2);
        if (a3 != null) {
            return a3;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!(superclass == null || (a2 = a(superclass, str, clsArr, cls2, z)) == null)) {
            return a2;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> cls3 : interfaces) {
            p.g(cls3, "superInterface");
            Method a4 = a(cls3, str, clsArr, cls2, z);
            if (a4 != null) {
                return a4;
            }
            if (z) {
                ClassLoader classLoader = cls3.getClassLoader();
                p.g(classLoader, "superInterface.classLoader");
                Class<?> a5 = kotlin.l.b.a.b.b.d.a.e.a(classLoader, cls3.getName() + "$DefaultImpls");
                if (a5 != null) {
                    clsArr[0] = cls3;
                    Method a6 = a(a5, str, clsArr, cls2);
                    if (a6 != null) {
                        return a6;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a A[LOOP:0: B:5:0x002a->B:17:0x005a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x001d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method a(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.i.a(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    static Constructor<?> a(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array == null) {
                throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public final Method oq(String str, String str2) {
        Method a2;
        p.h(str, "name");
        p.h(str2, "desc");
        if (p.j(str, "<init>")) {
            return null;
        }
        Object[] array = btx(str2).toArray(new Class[0]);
        if (array == null) {
            throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Class<?>[] clsArr = (Class[]) array;
        Class<?> bty = bty(str2);
        Method a3 = a(hyC(), str, clsArr, bty, false);
        if (a3 != null) {
            return a3;
        }
        if (!hyC().isInterface() || (a2 = a(Object.class, str, clsArr, bty, false)) == null) {
            return null;
        }
        return a2;
    }

    public final Method H(String str, String str2, boolean z) {
        p.h(str, "name");
        p.h(str2, "desc");
        if (p.j(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(hxU());
        }
        d(arrayList, str2, false);
        Class<?> hyC = hyC();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            return a(hyC, str3, (Class[]) array, bty(str2), z);
        }
        throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final Constructor<?> btw(String str) {
        p.h(str, "desc");
        return a(hxU(), btx(str));
    }

    /* access modifiers changed from: package-private */
    public final void d(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> btx = btx(str);
        list.addAll(btx);
        int size = ((btx.size() + 32) - 1) / 32;
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> cls = Integer.TYPE;
            p.g(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? Tau : Object.class;
        p.g(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> btx(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (n.d("VZCBSIFJD", charAt)) {
                i2 = i3 + 1;
            } else if (charAt == 'L') {
                i2 = n.a((CharSequence) str, ';', i2, false, 4) + 1;
            } else {
                throw new w("Unknown type prefix in the method signature: ".concat(String.valueOf(str)));
            }
            arrayList.add(bc(str, i2, i2));
        }
        return arrayList;
    }

    private final Class<?> bc(String str, int i2, int i3) {
        switch (str.charAt(i2)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case TPCodecParamers.TP_PROFILE_H264_MAIN:
            case h.a.CTRL_INDEX:
            case 'O':
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
            case 'Q':
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
            case com.tencent.mm.plugin.appbrand.jsapi.r.f.CTRL_INDEX:
            case s.CTRL_INDEX:
            case 'W':
            case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
            case PlayerException.EXCEPTION_IN_CHECK_STATE:
            default:
                throw new w("Unknown type prefix in the method signature: ".concat(String.valueOf(str)));
            case 'F':
                return Float.TYPE;
            case com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX:
                return Integer.TYPE;
            case 'J':
                return Long.TYPE;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                ClassLoader bx = kotlin.l.b.a.b.b.d.b.b.bx(hxU());
                int i4 = i2 + 1;
                int i5 = i3 - 1;
                if (str == null) {
                    throw new kotlin.t("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(i4, i5);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Class<?> loadClass = bx.loadClass(n.a(substring, '/', '.'));
                p.g(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            case 'S':
                return Short.TYPE;
            case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                Class<?> cls = Void.TYPE;
                p.g(cls, "Void.TYPE");
                return cls;
            case 'Z':
                return Boolean.TYPE;
            case PlayerException.EXCEPTION_IN_PREPARE:
                return kotlin.l.b.a.b.b.d.b.b.bD(bc(str, i2 + 1, i3));
        }
    }

    private final Class<?> bty(String str) {
        return bc(str, n.a((CharSequence) str, ')', 0, false, 6) + 1, str.length());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ r a(i iVar, ah ahVar) {
        int i2 = 1;
        int i3 = ahVar.hAs() != null ? 1 : 0;
        if (ahVar.hAr() == null) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        if (ahVar.hBF()) {
            switch (i4) {
                case 0:
                    return new k(iVar, ahVar);
                case 1:
                    return new l(iVar, ahVar);
                default:
                    return new m(iVar, ahVar);
            }
        } else {
            switch (i4) {
                case 0:
                    return new o(iVar, ahVar);
                case 1:
                    return new p(iVar, ahVar);
                default:
                    return new q(iVar, ahVar);
            }
        }
    }
}
