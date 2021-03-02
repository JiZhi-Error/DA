package kotlin.g.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.c;
import kotlin.g.a.d;
import kotlin.g.a.e;
import kotlin.g.a.f;
import kotlin.g.a.g;
import kotlin.g.a.i;
import kotlin.g.a.k;
import kotlin.g.a.m;
import kotlin.g.a.n;
import kotlin.g.a.o;
import kotlin.g.a.p;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.s;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;
import kotlin.l;
import kotlin.l.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006L"}, hxF = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"})
public final class h implements g, b<Object> {
    private static final Map<Class<? extends c<?>>, Integer> SYq;
    private static final HashMap<String, String> SYr;
    private static final HashMap<String, String> SYs;
    private static final HashMap<String, String> SYt;
    private static final Map<String, String> SYu;
    public static final a SYv = new a((byte) 0);
    private final Class<?> SYp;

    public h(Class<?> cls) {
        p.h(cls, "jClass");
        AppMethodBeat.i(129340);
        this.SYp = cls;
        AppMethodBeat.o(129340);
    }

    @Override // kotlin.g.b.g
    public final Class<?> hxU() {
        return this.SYp;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(129337);
        if (!(obj instanceof h) || !p.j(kotlin.g.a.c(this), kotlin.g.a.c((b) obj))) {
            AppMethodBeat.o(129337);
            return false;
        }
        AppMethodBeat.o(129337);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(129338);
        int hashCode = kotlin.g.a.c(this).hashCode();
        AppMethodBeat.o(129338);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(129339);
        String str = this.SYp.toString() + " (Kotlin reflection is not available)";
        AppMethodBeat.o(129339);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        int i2 = 0;
        AppMethodBeat.i(206211);
        List listOf = j.listOf((Object[]) new Class[]{kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.g.a.c.class, d.class, e.class, f.class, g.class, kotlin.g.a.h.class, i.class, kotlin.g.a.j.class, k.class, kotlin.g.a.l.class, n.class, o.class, p.class});
        ArrayList arrayList = new ArrayList(j.a(listOf, 10));
        for (Object obj : listOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            arrayList.add(kotlin.s.U((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        SYq = ae.E(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(DownloadSetting.TYPE_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        SYr = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        SYs = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(SYr);
        hashMap3.putAll(SYs);
        Collection<String> values = SYr.values();
        p.g(values, "primitiveFqNames.values");
        for (T t : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            p.g(t, "kotlinName");
            kotlin.o U = kotlin.s.U(sb.append(kotlin.n.n.b((String) t, '.')).append("CompanionObject").toString(), ((String) t) + ".Companion");
            hashMap3.put(U.first, U.second);
        }
        for (Map.Entry<Class<? extends c<?>>, Integer> entry : SYq.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function".concat(String.valueOf(entry.getValue().intValue())));
        }
        SYt = hashMap3;
        HashMap<String, String> hashMap4 = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(hashMap4.size()));
        for (T t2 : hashMap4.entrySet()) {
            linkedHashMap.put(t2.getKey(), kotlin.n.n.b((String) t2.getValue(), '.'));
        }
        SYu = linkedHashMap;
        AppMethodBeat.o(206211);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004c, code lost:
        if (r0 == null) goto L_0x004e;
     */
    @Override // kotlin.l.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSimpleName() {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.g.b.h.getSimpleName():java.lang.String");
    }

    @Override // kotlin.l.b
    public final String hxV() {
        String str;
        String str2;
        AppMethodBeat.i(129336);
        Class<?> cls = this.SYp;
        p.h(cls, "jClass");
        if (cls.isAnonymousClass()) {
            AppMethodBeat.o(129336);
            return null;
        } else if (cls.isLocalClass()) {
            AppMethodBeat.o(129336);
            return null;
        } else {
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                p.g(componentType, "componentType");
                if (!componentType.isPrimitive() || (str2 = SYt.get(componentType.getName())) == null) {
                    str = null;
                } else {
                    str = str2 + "Array";
                }
                if (str == null) {
                    AppMethodBeat.o(129336);
                    return "kotlin.Array";
                }
            } else {
                str = SYt.get(cls.getName());
                if (str == null) {
                    str = cls.getCanonicalName();
                }
            }
            AppMethodBeat.o(129336);
            return str;
        }
    }

    @Override // kotlin.l.b
    public final Collection<kotlin.l.e<Object>> hxW() {
        AppMethodBeat.i(206210);
        kotlin.g.b bVar = new kotlin.g.b();
        AppMethodBeat.o(206210);
        throw bVar;
    }
}
