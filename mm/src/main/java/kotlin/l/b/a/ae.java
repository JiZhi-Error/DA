package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.w;
import kotlin.l;
import kotlin.l.b.a.b.a.b.c;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.d.a.f;
import kotlin.l.b.a.b.b.d.a.k;
import kotlin.l.b.a.b.b.d.b.j;
import kotlin.l.b.a.b.b.d.b.n;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.d.b.r;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.r;
import kotlin.m;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001an\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\u000b*\u00020\f\"\b\b\u0001\u0010\n*\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u0002H\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u001d\u0010\u0016\u001a\u0019\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\u0017¢\u0006\u0002\b\u0019H\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002\u001a(\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010!\u001a\u00020\"H\u0002\u001a\"\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\b¢\u0006\u0002\u0010)\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010,H\u0000\u001a\u0010\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010,H\u0000\u001a\u0014\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u000100*\u0004\u0018\u00010,H\u0000\u001a\u0012\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u000204H\u0000\u001a\u000e\u00105\u001a\u0004\u0018\u000103*\u000206H\u0002\u001a\u0012\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e*\u000208H\u0000\u001a\u000e\u00109\u001a\u0004\u0018\u00010:*\u00020;H\u0000\u001a\u001a\u0010<\u001a\u0004\u0018\u00010,*\u0006\u0012\u0002\b\u00030=2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006>"}, hxF = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", QLog.TAG_REPORTLEVEL_DEVELOPER, "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"})
public final class ae {
    private static final b TbL = new b("kotlin.jvm.JvmStatic");

    static {
        AppMethodBeat.i(56564);
        AppMethodBeat.o(56564);
    }

    public static final b hyU() {
        return TbL;
    }

    public static final Class<?> a(e eVar) {
        AppMethodBeat.i(56554);
        p.h(eVar, "$this$toJavaClass");
        an hzM = eVar.hzM();
        p.g(hzM, "source");
        if (hzM instanceof r) {
            kotlin.l.b.a.b.d.b.p pVar = ((r) hzM).TvP;
            if (pVar == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
                AppMethodBeat.o(56554);
                throw tVar;
            }
            Class<?> cls = ((f) pVar).TmJ;
            AppMethodBeat.o(56554);
            return cls;
        } else if (hzM instanceof k.a) {
            n nVar = ((k.a) hzM).TmS;
            if (nVar == null) {
                t tVar2 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
                AppMethodBeat.o(56554);
                throw tVar2;
            }
            Class<?> cls2 = ((j) nVar).TmJ;
            AppMethodBeat.o(56554);
            return cls2;
        } else {
            a c2 = kotlin.l.b.a.b.j.d.a.c(eVar);
            if (c2 == null) {
                AppMethodBeat.o(56554);
                return null;
            }
            Class<?> a2 = a(kotlin.l.b.a.b.b.d.b.b.bx(eVar.getClass()), c2, 0);
            AppMethodBeat.o(56554);
            return a2;
        }
    }

    private static final Class<?> a(ClassLoader classLoader, a aVar, int i2) {
        AppMethodBeat.i(56555);
        c cVar = c.TfZ;
        kotlin.l.b.a.b.f.c hJe = aVar.hJd().hJe();
        p.g(hJe, "kotlinClassId.asSingleFqName().toUnsafe()");
        a c2 = c.c(hJe);
        if (c2 != null) {
            aVar = c2;
        }
        String sG = aVar.hIY().sG();
        p.g(sG, "javaClassId.packageFqName.asString()");
        String sG2 = aVar.hIZ().sG();
        p.g(sG2, "javaClassId.relativeClassName.asString()");
        Class<?> a2 = a(classLoader, sG, sG2, i2);
        AppMethodBeat.o(56555);
        return a2;
    }

    private static final Class<?> a(ClassLoader classLoader, String str, String str2, int i2) {
        String str3;
        AppMethodBeat.i(56556);
        if (p.j(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        AppMethodBeat.o(56556);
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        AppMethodBeat.o(56556);
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        AppMethodBeat.o(56556);
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        AppMethodBeat.o(56556);
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        AppMethodBeat.o(56556);
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        AppMethodBeat.o(56556);
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        AppMethodBeat.o(56556);
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        AppMethodBeat.o(56556);
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        AppMethodBeat.o(56556);
                        return long[].class;
                    }
                    break;
            }
        }
        String str4 = str + '.' + kotlin.n.n.a(str2, '.', '$');
        if (i2 > 0) {
            str3 = kotlin.n.n.r("[", i2) + 'L' + str4 + ';';
        } else {
            str3 = str4;
        }
        Class<?> a2 = kotlin.l.b.a.b.b.d.a.e.a(classLoader, str3);
        AppMethodBeat.o(56556);
        return a2;
    }

    public static final List<Annotation> a(kotlin.l.b.a.b.b.a.a aVar) {
        Annotation a2;
        AppMethodBeat.i(56557);
        p.h(aVar, "$this$computeAnnotations");
        ArrayList arrayList = new ArrayList();
        for (kotlin.l.b.a.b.b.a.c cVar : aVar.hzL()) {
            an hzM = cVar.hzM();
            if (hzM instanceof kotlin.l.b.a.b.b.d.a.b) {
                a2 = ((kotlin.l.b.a.b.b.d.a.b) hzM).TmG;
            } else if (hzM instanceof k.a) {
                n nVar = ((k.a) hzM).TmS;
                if (!(nVar instanceof kotlin.l.b.a.b.b.d.b.c)) {
                    nVar = null;
                }
                kotlin.l.b.a.b.b.d.b.c cVar2 = (kotlin.l.b.a.b.b.d.b.c) nVar;
                a2 = cVar2 != null ? cVar2.TmG : null;
            } else {
                a2 = a(cVar);
            }
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(56557);
        return arrayList2;
    }

    private static final Annotation a(kotlin.l.b.a.b.b.a.c cVar) {
        AppMethodBeat.i(56558);
        e l = kotlin.l.b.a.b.j.d.a.l(cVar);
        Class<?> a2 = l != null ? a(l) : null;
        Class<?> cls = !(a2 instanceof Class) ? null : a2;
        if (cls == null) {
            AppMethodBeat.o(56558);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : cVar.hBO().entrySet()) {
            kotlin.l.b.a.b.f.f fVar = (kotlin.l.b.a.b.f.f) t.getKey();
            ClassLoader classLoader = cls.getClassLoader();
            p.g(classLoader, "annotationClass.classLoader");
            Object a3 = a((g) t.getValue(), classLoader);
            o U = a3 != null ? s.U(fVar.sG(), a3) : null;
            if (U != null) {
                arrayList.add(U);
            }
        }
        Annotation annotation = (Annotation) kotlin.l.b.a.a.b.a(cls, kotlin.a.ae.E(arrayList));
        AppMethodBeat.o(56558);
        return annotation;
    }

    private static final Object a(g<?> gVar, ClassLoader classLoader) {
        Object obj;
        AppMethodBeat.i(56559);
        if (gVar instanceof kotlin.l.b.a.b.j.b.a) {
            Annotation a2 = a((kotlin.l.b.a.b.b.a.c) ((kotlin.l.b.a.b.j.b.a) gVar).getValue());
            AppMethodBeat.o(56559);
            return a2;
        }
        if (gVar instanceof kotlin.l.b.a.b.j.b.b) {
            Iterable<g> iterable = (Iterable) ((kotlin.l.b.a.b.j.b.b) gVar).getValue();
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(iterable, 10));
            for (g gVar2 : iterable) {
                arrayList.add(a(gVar2, classLoader));
            }
            obj = arrayList.toArray(new Object[0]);
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(56559);
                throw tVar;
            }
        } else if (gVar instanceof kotlin.l.b.a.b.j.b.j) {
            o oVar = (o) ((kotlin.l.b.a.b.j.b.j) gVar).getValue();
            B b2 = oVar.second;
            Class<?> a3 = a(classLoader, oVar.first, 0);
            if (a3 == null) {
                AppMethodBeat.o(56559);
                return null;
            } else if (a3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                AppMethodBeat.o(56559);
                throw tVar2;
            } else {
                Enum valueOf = Enum.valueOf(a3, b2.sG());
                AppMethodBeat.o(56559);
                return valueOf;
            }
        } else if (gVar instanceof kotlin.l.b.a.b.j.b.r) {
            r.b bVar = (r.b) ((kotlin.l.b.a.b.j.b.r) gVar).getValue();
            if (bVar instanceof r.b.C2344b) {
                Class<?> a4 = a(classLoader, ((r.b.C2344b) bVar).TIK.Tfj, ((r.b.C2344b) bVar).TIK.TIt);
                AppMethodBeat.o(56559);
                return a4;
            } else if (bVar instanceof r.b.a) {
                h hzS = ((r.b.a) bVar).Tbs.hKE().hzS();
                if (!(hzS instanceof e)) {
                    hzS = null;
                }
                e eVar = (e) hzS;
                if (eVar != null) {
                    Class<?> a5 = a(eVar);
                    AppMethodBeat.o(56559);
                    return a5;
                }
                AppMethodBeat.o(56559);
                return null;
            } else {
                m mVar = new m();
                AppMethodBeat.o(56559);
                throw mVar;
            }
        } else if ((gVar instanceof kotlin.l.b.a.b.j.b.k) || (gVar instanceof kotlin.l.b.a.b.j.b.t)) {
            AppMethodBeat.o(56559);
            return null;
        } else {
            obj = gVar.getValue();
        }
        AppMethodBeat.o(56559);
        return obj;
    }

    public static final j fh(Object obj) {
        AppMethodBeat.i(56560);
        j jVar = (j) (!(obj instanceof j) ? null : obj);
        if (jVar == null) {
            kotlin.g.b.n nVar = (kotlin.g.b.n) (!(obj instanceof kotlin.g.b.n) ? null : obj);
            kotlin.l.a hxR = nVar != null ? nVar.hxR() : null;
            if (!(hxR instanceof j)) {
                hxR = null;
            }
            jVar = (j) hxR;
        }
        AppMethodBeat.o(56560);
        return jVar;
    }

    public static final r<?> fi(Object obj) {
        AppMethodBeat.i(56561);
        r<?> rVar = (r) (!(obj instanceof r) ? null : obj);
        if (rVar == null) {
            w wVar = (w) (!(obj instanceof w) ? null : obj);
            kotlin.l.a hxR = wVar != null ? wVar.hxR() : null;
            if (!(hxR instanceof r)) {
                hxR = null;
            }
            rVar = (r) hxR;
        }
        AppMethodBeat.o(56561);
        return rVar;
    }

    public static final ak a(kotlin.l.b.a.b.b.a aVar) {
        AppMethodBeat.i(56562);
        p.h(aVar, "$this$instanceReceiverParameter");
        if (aVar.hAs() != null) {
            kotlin.l.b.a.b.b.l hzx = aVar.hzx();
            if (hzx == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                AppMethodBeat.o(56562);
                throw tVar;
            }
            ak hAO = ((e) hzx).hAO();
            AppMethodBeat.o(56562);
            return hAO;
        }
        AppMethodBeat.o(56562);
        return null;
    }

    public static final <M extends q, D extends kotlin.l.b.a.b.b.a> D a(Class<?> cls, M m, kotlin.l.b.a.b.e.b.c cVar, kotlin.l.b.a.b.e.b.h hVar, kotlin.l.b.a.b.e.b.a aVar, kotlin.g.a.m<? super kotlin.l.b.a.b.k.a.w, ? super M, ? extends D> mVar) {
        List<a.r> list;
        AppMethodBeat.i(56563);
        p.h(cls, "moduleAnchor");
        p.h(m, "proto");
        p.h(cVar, "nameResolver");
        p.h(hVar, "typeTable");
        p.h(aVar, "metadataVersion");
        p.h(mVar, "createDescriptor");
        kotlin.l.b.a.b.b.d.a.j bs = x.bs(cls);
        if (m instanceof a.h) {
            list = ((a.h) m).Txu;
        } else if (m instanceof a.m) {
            list = ((a.m) m).Txu;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported message: ".concat(String.valueOf(m)).toString());
            AppMethodBeat.o(56563);
            throw illegalStateException;
        }
        i.a aVar2 = i.TBK;
        i hIl = i.hIl();
        p.g(list, "typeParameters");
        D d2 = (D) ((kotlin.l.b.a.b.b.a) mVar.invoke(new kotlin.l.b.a.b.k.a.w(new kotlin.l.b.a.b.k.a.n(bs.TmO, cVar, bs.TmO.Tge, hVar, hIl, aVar, null, null, list)), m));
        AppMethodBeat.o(56563);
        return d2;
    }
}
