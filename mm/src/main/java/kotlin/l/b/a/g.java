package kotlin.l.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.d.a.f;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.d.b.a.a;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.i;
import kotlin.l.b.a.y;
import kotlin.l.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001`B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010O\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u00132\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010Z\u001a\u00020XH\u0016J\u0012\u0010[\u001a\u00020%2\b\u0010\\\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020<H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R3\u0010\u001a\u001a$\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0016\u00108\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\n8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0016\u0010A\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010C\u001a\u0002008@X\u0004¢\u0006\u0006\u001a\u0004\bD\u00102R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\rR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\rR\u0016\u0010K\u001a\u0004\u0018\u00010L8VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006a"}, hxF = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", FirebaseAnalytics.b.INDEX, "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"})
public final class g<T> extends i implements kotlin.l.b<T> {
    final Class<T> SYp;
    public final y.b<g<T>.a> SZV;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0015\u0010\u0006\u001a\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "T", "", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    static final /* synthetic */ class c extends n implements m<w, a.m, ah> {
        public static final c Tat = new c();

        static {
            AppMethodBeat.i(56338);
            AppMethodBeat.o(56338);
        }

        c() {
            super(2);
        }

        @Override // kotlin.g.b.e
        public final d Rs() {
            AppMethodBeat.i(56337);
            kotlin.l.b bp = aa.bp(w.class);
            AppMethodBeat.o(56337);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "loadProperty";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ ah invoke(w wVar, a.m mVar) {
            AppMethodBeat.i(56336);
            w wVar2 = wVar;
            a.m mVar2 = mVar;
            p.h(wVar2, "p1");
            p.h(mVar2, "p2");
            ah g2 = wVar2.g(mVar2);
            AppMethodBeat.o(56336);
            return g2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, hxF = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
    public final class a extends i.b {
        static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new kotlin.g.b.y(aa.bp(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "annotations", "getAnnotations()Ljava/util/List;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), aa.a(new kotlin.g.b.y(aa.bp(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        private final y.a SZW = y.ak(new i(this));
        private final y.a SZX = y.ak(new d(this));
        final y.a SZY = y.ak(new p(this));
        final y.a SZZ = y.ak(new n(this));
        final y.a Taa = y.ak(new e(this));
        private final y.a Tab = y.ak(new l(this));
        private final y.b Tac = y.aj(new m(this));
        private final y.a Tad = y.ak(new r(this));
        private final y.a Tae = y.ak(new q(this));
        private final y.a Taf = y.ak(new o(this));
        private final y.a Tag = y.ak(new C2372g(this));
        private final y.a Tah = y.ak(new h(this));
        private final y.a Tai = y.ak(new j(this));
        private final y.a Taj = y.ak(new k(this));
        final y.a Tak = y.ak(new b(this));
        final y.a Tal = y.ak(new c(this));
        private final y.a Tam = y.ak(new f(this));
        private final y.a Tan = y.ak(new C2371a(this));

        static {
            AppMethodBeat.i(56326);
            AppMethodBeat.o(56326);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            super();
            AppMethodBeat.i(56329);
            AppMethodBeat.o(56329);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
        static final class m extends kotlin.g.b.q implements kotlin.g.a.a<T> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            m(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:10:0x0044  */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x005e  */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final T invoke() {
                /*
                    r5 = this;
                    r1 = 0
                    r4 = 56318(0xdbfe, float:7.8918E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    kotlin.l.b.a.g$a r0 = r5.Tap
                    kotlin.l.b.a.b.b.e r0 = r0.hyx()
                    kotlin.l.b.a.b.b.f r2 = r0.hzB()
                    kotlin.l.b.a.b.b.f r3 = kotlin.l.b.a.b.b.f.OBJECT
                    if (r2 == r3) goto L_0x001a
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    r0 = r1
                L_0x0019:
                    return r0
                L_0x001a:
                    boolean r2 = r0.hzF()
                    if (r2 == 0) goto L_0x0050
                    kotlin.l.b.a.b.a.c r2 = kotlin.l.b.a.b.a.c.Tcz
                    boolean r2 = kotlin.l.b.a.b.a.c.b(r0)
                    if (r2 != 0) goto L_0x0050
                    kotlin.l.b.a.g$a r2 = r5.Tap
                    kotlin.l.b.a.g r2 = kotlin.l.b.a.g.this
                    java.lang.Class<T> r2 = r2.SYp
                    java.lang.Class r2 = r2.getEnclosingClass()
                    kotlin.l.b.a.b.f.f r0 = r0.hAH()
                    java.lang.String r0 = r0.sG()
                    java.lang.reflect.Field r0 = r2.getDeclaredField(r0)
                L_0x003e:
                    java.lang.Object r0 = r0.get(r1)
                    if (r0 != 0) goto L_0x005e
                    kotlin.t r0 = new kotlin.t
                    java.lang.String r1 = "null cannot be cast to non-null type T"
                    r0.<init>(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    throw r0
                L_0x0050:
                    kotlin.l.b.a.g$a r0 = r5.Tap
                    kotlin.l.b.a.g r0 = kotlin.l.b.a.g.this
                    java.lang.Class<T> r0 = r0.SYp
                    java.lang.String r2 = "INSTANCE"
                    java.lang.reflect.Field r0 = r0.getDeclaredField(r2)
                    goto L_0x003e
                L_0x005e:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    goto L_0x0019
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.g.a.m.invoke():java.lang.Object");
            }
        }

        public final kotlin.l.b.a.b.b.e hyx() {
            AppMethodBeat.i(56327);
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) this.SZW.invoke();
            AppMethodBeat.o(56327);
            return eVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
        static final class i extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.l.b.a.b.b.e> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.l.b.a.b.b.e invoke() {
                kotlin.l.b.a.b.b.e b2;
                AppMethodBeat.i(56314);
                kotlin.l.b.a.b.f.a a2 = g.a(g.this);
                kotlin.l.b.a.b.b.d.a.j jVar = (kotlin.l.b.a.b.b.d.a.j) g.this.SZV.invoke().Tax.invoke();
                if (a2.BPb) {
                    b2 = jVar.TmO.g(a2);
                } else {
                    b2 = s.b(jVar.TmO.Tge, a2);
                }
                if (b2 == null) {
                    g.b(g.this);
                    AppMethodBeat.o(56314);
                    throw null;
                }
                AppMethodBeat.o(56314);
                return b2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "", "T", "", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends Annotation>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends Annotation> invoke() {
                AppMethodBeat.i(56309);
                List<Annotation> a2 = ae.a((kotlin.l.b.a.b.b.a.a) this.Tap.hyx());
                AppMethodBeat.o(56309);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "", "invoke"})
        static final class p extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            p(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                AppMethodBeat.i(56321);
                if (g.this.SYp.isAnonymousClass()) {
                    AppMethodBeat.o(56321);
                    return null;
                }
                kotlin.l.b.a.b.f.a a2 = g.a(g.this);
                if (a2.BPb) {
                    String br = a.br(g.this.SYp);
                    AppMethodBeat.o(56321);
                    return br;
                }
                String sG = a2.hJa().sG();
                kotlin.g.b.p.g(sG, "classId.shortClassName.asString()");
                AppMethodBeat.o(56321);
                return sG;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "", "invoke"})
        static final class n extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            n(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                AppMethodBeat.i(56319);
                if (g.this.SYp.isAnonymousClass()) {
                    AppMethodBeat.o(56319);
                    return null;
                }
                kotlin.l.b.a.b.f.a a2 = g.a(g.this);
                if (a2.BPb) {
                    AppMethodBeat.o(56319);
                    return null;
                }
                String sG = a2.hJd().sG();
                AppMethodBeat.o(56319);
                return sG;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"})
        static final class e extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.e<? extends T>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(56310);
                Collection<kotlin.l.b.a.b.b.k> hyq = g.this.hyq();
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(hyq, 10));
                Iterator<T> it = hyq.iterator();
                while (it.hasNext()) {
                    arrayList.add(new j(g.this, it.next()));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(56310);
                return arrayList2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
        static final class l extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends g<? extends Object>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            l(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends g<? extends Object>> invoke() {
                AppMethodBeat.i(56317);
                ArrayList arrayList = new ArrayList();
                for (T t : j.a.a(this.Tap.hyx().hAN(), null, null, 3)) {
                    if (!kotlin.l.b.a.b.j.c.x(t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (T t2 : arrayList) {
                    if (t2 == null) {
                        t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(56317);
                        throw tVar;
                    }
                    Class<?> a2 = ae.a((kotlin.l.b.a.b.b.e) t2);
                    g gVar = a2 != null ? new g(a2) : null;
                    if (gVar != null) {
                        arrayList2.add(gVar);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                AppMethodBeat.o(56317);
                return arrayList3;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"})
        static final class r extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends v>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            r(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends v> invoke() {
                AppMethodBeat.i(56325);
                List<as> hzO = this.Tap.hyx().hzO();
                kotlin.g.b.p.g(hzO, "descriptor.declaredTypeParameters");
                List<as> list = hzO;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new v(it.next()));
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(56325);
                return arrayList2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"})
        static final class q extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends t>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            q(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ java.util.List<? extends kotlin.l.b.a.t> invoke() {
                /*
                // Method dump skipped, instructions count: 213
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.g.a.q.invoke():java.lang.Object");
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"})
            /* renamed from: kotlin.l.b.a.g$a$q$a  reason: collision with other inner class name */
            static final class C2373a extends kotlin.g.b.q implements kotlin.g.a.a<Type> {
                final /* synthetic */ ab Taq;
                final /* synthetic */ q Tar;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C2373a(ab abVar, q qVar) {
                    super(0);
                    this.Taq = abVar;
                    this.Tar = qVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ Type invoke() {
                    AppMethodBeat.i(56322);
                    kotlin.l.b.a.b.b.h hzS = this.Taq.hKE().hzS();
                    if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
                        w wVar = new w("Supertype not a class: ".concat(String.valueOf(hzS)));
                        AppMethodBeat.o(56322);
                        throw wVar;
                    }
                    Class<?> a2 = ae.a((kotlin.l.b.a.b.b.e) hzS);
                    if (a2 == null) {
                        w wVar2 = new w("Unsupported superclass of " + this.Tar.Tap + ": " + hzS);
                        AppMethodBeat.o(56322);
                        throw wVar2;
                    } else if (kotlin.g.b.p.j(g.this.SYp.getSuperclass(), a2)) {
                        Type genericSuperclass = g.this.SYp.getGenericSuperclass();
                        kotlin.g.b.p.g(genericSuperclass, "jClass.genericSuperclass");
                        AppMethodBeat.o(56322);
                        return genericSuperclass;
                    } else {
                        Class<?>[] interfaces = g.this.SYp.getInterfaces();
                        kotlin.g.b.p.g(interfaces, "jClass.interfaces");
                        int indexOf = kotlin.a.e.indexOf(interfaces, a2);
                        if (indexOf < 0) {
                            w wVar3 = new w("No superclass of " + this.Tar.Tap + " in Java reflection for " + hzS);
                            AppMethodBeat.o(56322);
                            throw wVar3;
                        }
                        Type type = g.this.SYp.getGenericInterfaces()[indexOf];
                        kotlin.g.b.p.g(type, "jClass.genericInterfaces[index]");
                        AppMethodBeat.o(56322);
                        return type;
                    }
                }
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
        static final class o extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends g<? extends T>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            o(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ Object invoke() {
                g gVar;
                AppMethodBeat.i(56320);
                Collection<kotlin.l.b.a.b.b.e> hzN = this.Tap.hyx().hzN();
                kotlin.g.b.p.g(hzN, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (T t : hzN) {
                    if (t == null) {
                        t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.o(56320);
                        throw tVar;
                    }
                    Class<?> a2 = ae.a((kotlin.l.b.a.b.b.e) t);
                    if (a2 != null) {
                        gVar = new g(a2);
                    } else {
                        gVar = null;
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(56320);
                return arrayList2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: kotlin.l.b.a.g$a$g  reason: collision with other inner class name */
        static final class C2372g extends kotlin.g.b.q implements kotlin.g.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2372g(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends e<?>> invoke() {
                AppMethodBeat.i(56312);
                Collection<e<?>> a2 = g.this.a(g.this.hyz(), i.c.DECLARED);
                AppMethodBeat.o(56312);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends e<?>> invoke() {
                AppMethodBeat.i(56313);
                Collection<e<?>> a2 = g.this.a(g.this.hyA(), i.c.DECLARED);
                AppMethodBeat.o(56313);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends e<?>> invoke() {
                AppMethodBeat.i(56315);
                Collection<e<?>> a2 = g.this.a(g.this.hyz(), i.c.INHERITED);
                AppMethodBeat.o(56315);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class k extends kotlin.g.b.q implements kotlin.g.a.a<Collection<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            k(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends e<?>> invoke() {
                AppMethodBeat.i(56316);
                Collection<e<?>> a2 = g.this.a(g.this.hyA(), i.c.INHERITED);
                AppMethodBeat.o(56316);
                return a2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends e<?>> invoke() {
                AppMethodBeat.i(56307);
                List b2 = kotlin.a.j.b((Collection) this.Tap.hyB(), (Iterable) a.a(this.Tap));
                AppMethodBeat.o(56307);
                return b2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends e<?>> invoke() {
                AppMethodBeat.i(56308);
                List b2 = kotlin.a.j.b(a.b(this.Tap), (Iterable) a.c(this.Tap));
                AppMethodBeat.o(56308);
                return b2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        static final class f extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends e<?>> invoke() {
                AppMethodBeat.i(56311);
                List b2 = kotlin.a.j.b((Collection) this.Tap.hyB(), (Iterable) a.b(this.Tap));
                AppMethodBeat.o(56311);
                return b2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"})
        /* renamed from: kotlin.l.b.a.g$a$a  reason: collision with other inner class name */
        static final class C2371a extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends e<?>>> {
            final /* synthetic */ a Tap;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2371a(a aVar) {
                super(0);
                this.Tap = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends e<?>> invoke() {
                AppMethodBeat.i(56306);
                List b2 = kotlin.a.j.b((Collection) this.Tap.Tak.invoke(), (Iterable) ((Collection) this.Tap.Tal.invoke()));
                AppMethodBeat.o(56306);
                return b2;
            }
        }

        public final Collection<e<?>> hyB() {
            AppMethodBeat.i(56328);
            Collection<e<?>> collection = (Collection) this.Tag.invoke();
            AppMethodBeat.o(56328);
            return collection;
        }

        public static final /* synthetic */ String br(Class cls) {
            AppMethodBeat.i(56330);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.g.b.p.g(simpleName, "name");
                String oB = kotlin.n.n.oB(simpleName, enclosingMethod.getName() + "$");
                AppMethodBeat.o(56330);
                return oB;
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                kotlin.g.b.p.g(simpleName, "name");
                String oB2 = kotlin.n.n.oB(simpleName, enclosingConstructor.getName() + "$");
                AppMethodBeat.o(56330);
                return oB2;
            }
            kotlin.g.b.p.g(simpleName, "name");
            String oA = kotlin.n.n.oA(simpleName, simpleName);
            AppMethodBeat.o(56330);
            return oA;
        }

        public static final /* synthetic */ Collection a(a aVar) {
            AppMethodBeat.i(56331);
            Collection collection = (Collection) aVar.Tai.invoke();
            AppMethodBeat.o(56331);
            return collection;
        }

        public static final /* synthetic */ Collection b(a aVar) {
            AppMethodBeat.i(56332);
            Collection collection = (Collection) aVar.Tah.invoke();
            AppMethodBeat.o(56332);
            return collection;
        }

        public static final /* synthetic */ Collection c(a aVar) {
            AppMethodBeat.i(56333);
            Collection collection = (Collection) aVar.Taj.invoke();
            AppMethodBeat.o(56333);
            return collection;
        }
    }

    public g(Class<T> cls) {
        p.h(cls, "jClass");
        AppMethodBeat.i(56351);
        this.SYp = cls;
        y.b<g<T>.a> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Data() }");
        this.SZV = aj;
        AppMethodBeat.o(56351);
    }

    public static final /* synthetic */ kotlin.l.b.a.b.f.a a(g gVar) {
        AppMethodBeat.i(56352);
        kotlin.l.b.a.b.f.a hyy = gVar.hyy();
        AppMethodBeat.o(56352);
        return hyy;
    }

    @Override // kotlin.g.b.g
    public final Class<T> hxU() {
        return this.SYp;
    }

    private e hyx() {
        AppMethodBeat.i(56339);
        e hyx = this.SZV.invoke().hyx();
        AppMethodBeat.o(56339);
        return hyx;
    }

    private final kotlin.l.b.a.b.f.a hyy() {
        AppMethodBeat.i(56340);
        ac acVar = ac.TbJ;
        Class<T> cls = this.SYp;
        p.h(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            p.g(componentType, "klass.componentType");
            h bt = ac.bt(componentType);
            if (bt != null) {
                kotlin.l.b.a.b.f.a aVar = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, bt.hzu());
                AppMethodBeat.o(56340);
                return aVar;
            }
            kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(kotlin.l.b.a.b.a.g.TcO.TcZ.hJj());
            p.g(p, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
            AppMethodBeat.o(56340);
            return p;
        } else if (p.j(cls, Void.TYPE)) {
            kotlin.l.b.a.b.f.a aVar2 = ac.TbI;
            AppMethodBeat.o(56340);
            return aVar2;
        } else {
            h bt2 = ac.bt(cls);
            if (bt2 != null) {
                kotlin.l.b.a.b.f.a aVar3 = new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, bt2.hzt());
                AppMethodBeat.o(56340);
                return aVar3;
            }
            kotlin.l.b.a.b.f.a bB = kotlin.l.b.a.b.b.d.b.b.bB(cls);
            if (!bB.BPb) {
                kotlin.l.b.a.b.a.b.c cVar = kotlin.l.b.a.b.a.b.c.TfZ;
                kotlin.l.b.a.b.f.b hJd = bB.hJd();
                p.g(hJd, "classId.asSingleFqName()");
                kotlin.l.b.a.b.f.a c2 = kotlin.l.b.a.b.a.b.c.c(hJd);
                if (c2 != null) {
                    AppMethodBeat.o(56340);
                    return c2;
                }
            }
            AppMethodBeat.o(56340);
            return bB;
        }
    }

    public final kotlin.l.b.a.b.j.f.h hyz() {
        AppMethodBeat.i(56341);
        kotlin.l.b.a.b.j.f.h hAp = hyx().hAG().hAp();
        AppMethodBeat.o(56341);
        return hAp;
    }

    public final kotlin.l.b.a.b.j.f.h hyA() {
        AppMethodBeat.i(56342);
        kotlin.l.b.a.b.j.f.h hzy = hyx().hzy();
        p.g(hzy, "descriptor.staticScope");
        AppMethodBeat.o(56342);
        return hzy;
    }

    @Override // kotlin.l.b.a.i
    public final Collection<k> hyq() {
        AppMethodBeat.i(56343);
        e hyx = hyx();
        if (hyx.hzB() == f.INTERFACE || hyx.hzB() == f.OBJECT) {
            v vVar = v.SXr;
            AppMethodBeat.o(56343);
            return vVar;
        }
        Collection<kotlin.l.b.a.b.b.d> hxW = hyx.hxW();
        p.g(hxW, "descriptor.constructors");
        AppMethodBeat.o(56343);
        return hxW;
    }

    @Override // kotlin.l.b.a.i
    public final Collection<ah> a(kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(56344);
        p.h(fVar, "name");
        List b2 = kotlin.a.j.b((Collection) hyz().a(fVar, kotlin.l.b.a.b.c.a.c.FROM_REFLECTION), (Iterable) hyA().a(fVar, kotlin.l.b.a.b.c.a.c.FROM_REFLECTION));
        AppMethodBeat.o(56344);
        return b2;
    }

    @Override // kotlin.l.b.a.i
    public final Collection<kotlin.l.b.a.b.b.t> b(kotlin.l.b.a.b.f.f fVar) {
        AppMethodBeat.i(56345);
        p.h(fVar, "name");
        List b2 = kotlin.a.j.b((Collection) hyz().b(fVar, kotlin.l.b.a.b.c.a.c.FROM_REFLECTION), (Iterable) hyA().b(fVar, kotlin.l.b.a.b.c.a.c.FROM_REFLECTION));
        AppMethodBeat.o(56345);
        return b2;
    }

    @Override // kotlin.l.b
    public final String getSimpleName() {
        AppMethodBeat.i(186229);
        String str = (String) this.SZV.invoke().SZY.invoke();
        AppMethodBeat.o(186229);
        return str;
    }

    @Override // kotlin.l.b
    public final String hxV() {
        AppMethodBeat.i(56347);
        String str = (String) this.SZV.invoke().SZZ.invoke();
        AppMethodBeat.o(56347);
        return str;
    }

    @Override // kotlin.l.b
    public final Collection<kotlin.l.e<T>> hxW() {
        AppMethodBeat.i(186230);
        Collection<kotlin.l.e<T>> collection = (Collection) this.SZV.invoke().Taa.invoke();
        AppMethodBeat.o(186230);
        return collection;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56348);
        if (!(obj instanceof g) || !p.j(kotlin.g.a.c(this), kotlin.g.a.c((kotlin.l.b) obj))) {
            AppMethodBeat.o(56348);
            return false;
        }
        AppMethodBeat.o(56348);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(56349);
        int hashCode = kotlin.g.a.c(this).hashCode();
        AppMethodBeat.o(56349);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(56350);
        StringBuilder sb = new StringBuilder("class ");
        kotlin.l.b.a.b.f.a hyy = hyy();
        kotlin.l.b.a.b.f.b hIY = hyy.hIY();
        p.g(hIY, "classId.packageFqName");
        String str = hIY.TCR.TCW.isEmpty() ? "" : hIY.sG() + ".";
        String sG = hyy.hIZ().sG();
        p.g(sG, "classId.relativeClassName.asString()");
        String sb2 = sb.append(str + kotlin.n.n.a(sG, '.', '$')).toString();
        AppMethodBeat.o(56350);
        return sb2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\f0\u0001R\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<g<T>.a> {
        final /* synthetic */ g Tao;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.Tao = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ g<T>.a invoke() {
            AppMethodBeat.i(56335);
            a aVar = new a();
            AppMethodBeat.o(56335);
            return aVar;
        }
    }

    @Override // kotlin.l.b.a.i
    public final ah atL(int i2) {
        Object obj;
        Class<?> declaringClass;
        AppMethodBeat.i(56346);
        while (p.j(this.SYp.getSimpleName(), "DefaultImpls") && (declaringClass = this.SYp.getDeclaringClass()) != null && declaringClass.isInterface()) {
            kotlin.l.b bo = kotlin.g.a.bo(declaringClass);
            if (bo == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                AppMethodBeat.o(56346);
                throw tVar;
            }
            this = (g) bo;
        }
        e hyx = this.hyx();
        if (!(hyx instanceof kotlin.l.b.a.b.k.a.b.e)) {
            hyx = null;
        }
        kotlin.l.b.a.b.k.a.b.e eVar = (kotlin.l.b.a.b.k.a.b.e) hyx;
        if (eVar != null) {
            a.b bVar = eVar.TKA;
            i.f<a.b, List<a.m>> fVar = kotlin.l.b.a.b.e.c.a.TBS;
            p.g(fVar, "JvmProtoBuf.classLocalVariable");
            p.h(bVar, "$this$getExtensionOrNull");
            p.h(fVar, ShareConstants.MEDIA_EXTENSION);
            if (i2 < bVar.d(fVar)) {
                obj = bVar.a(fVar, i2);
            } else {
                obj = null;
            }
            a.m mVar = (a.m) obj;
            if (mVar != null) {
                ah ahVar = (ah) ae.a(this.SYp, mVar, eVar.TLm.SZH, eVar.TLm.SZI, eVar.TKB, c.Tat);
                AppMethodBeat.o(56346);
                return ahVar;
            }
            AppMethodBeat.o(56346);
            return null;
        }
        AppMethodBeat.o(56346);
        return null;
    }

    public static final /* synthetic */ Void b(g gVar) {
        a.EnumC2293a aVar;
        kotlin.l.b.a.b.d.b.a.a aVar2;
        AppMethodBeat.i(56353);
        f.a aVar3 = kotlin.l.b.a.b.b.d.a.f.TmL;
        kotlin.l.b.a.b.b.d.a.f bw = f.a.bw(gVar.SYp);
        if (bw == null || (aVar2 = bw.TmK) == null) {
            aVar = null;
        } else {
            aVar = aVar2.Twl;
        }
        if (aVar != null) {
            switch (h.$EnumSwitchMapping$0[aVar.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + gVar.SYp);
                    AppMethodBeat.o(56353);
                    throw unsupportedOperationException;
                case 4:
                    UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations does it have. Please use Java reflection to inspect this class: " + gVar.SYp);
                    AppMethodBeat.o(56353);
                    throw unsupportedOperationException2;
                case 5:
                    w wVar = new w("Unknown class: " + gVar.SYp + " (kind = " + aVar + ')');
                    AppMethodBeat.o(56353);
                    throw wVar;
                case 6:
                    break;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(56353);
                    throw mVar;
            }
        }
        w wVar2 = new w("Unresolved class: " + gVar.SYp);
        AppMethodBeat.o(56353);
        throw wVar2;
    }
}
