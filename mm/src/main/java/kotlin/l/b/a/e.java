package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.y;
import kotlin.l.j;
import kotlin.l.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u00105\u001a\u00028\u00002\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010807\"\u0004\u0018\u000108H\u0016¢\u0006\u0002\u00109J#\u0010:\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002¢\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0016¢\u0006\u0002\u0010<J3\u0010>\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;2\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010@H\u0000¢\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001a\u0004\u0018\u0001082\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010F\u001a\u0004\u0018\u00010EH\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \b*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u00020\"8DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0012\u0010%\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0012R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006G"}, hxF = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"})
public abstract class e<R> implements kotlin.l.a<R> {
    private final y.a<List<Annotation>> SZL;
    private final y.a<ArrayList<j>> SZM;
    private final y.a<t> SZN;
    private final y.a<List<v>> SZO;

    public abstract kotlin.l.b.a.b.b.b hys();

    public abstract kotlin.l.b.a.a.d<?> hyt();

    public abstract kotlin.l.b.a.a.d<?> hyu();

    public abstract i hyv();

    public abstract boolean isBound();

    public e() {
        y.a<List<Annotation>> ak = y.ak(new a(this));
        p.g(ak, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.SZL = ak;
        y.a<ArrayList<j>> ak2 = y.ak(new b(this));
        p.g(ak2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.SZM = ak2;
        y.a<t> ak3 = y.ak(new c(this));
        p.g(ak3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.SZN = ak3;
        y.a<List<v>> ak4 = y.ak(new d(this));
        p.g(ak4, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
        this.SZO = ak4;
    }

    @Override // kotlin.l.a
    public final List<j> getParameters() {
        ArrayList<j> invoke = this.SZM.invoke();
        p.g(invoke, "_parameters()");
        return invoke;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
    static final class b extends q implements kotlin.g.a.a<ArrayList<j>> {
        final /* synthetic */ e SZP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.SZP = eVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(56298);
                int a2 = kotlin.b.a.a(t.getName(), t2.getName());
                AppMethodBeat.o(56298);
                return a2;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ArrayList<j> invoke() {
            int i2;
            final int i3 = 0;
            AppMethodBeat.i(56300);
            final kotlin.l.b.a.b.b.b hys = this.SZP.hys();
            ArrayList arrayList = new ArrayList();
            if (!this.SZP.isBound()) {
                final ak a2 = ae.a((kotlin.l.b.a.b.b.a) hys);
                if (a2 != null) {
                    arrayList.add(new n(this.SZP, 0, j.a.INSTANCE, new kotlin.g.a.a<ak>() {
                        /* class kotlin.l.b.a.e.b.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* bridge */ /* synthetic */ ak invoke() {
                            return a2;
                        }
                    }));
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                final ak hAr = hys.hAr();
                if (hAr != null) {
                    arrayList.add(new n(this.SZP, i2, j.a.EXTENSION_RECEIVER, new kotlin.g.a.a<ak>() {
                        /* class kotlin.l.b.a.e.b.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* bridge */ /* synthetic */ ak invoke() {
                            return hAr;
                        }
                    }));
                    i2++;
                }
            } else {
                i2 = 0;
            }
            List<av> hAw = hys.hAw();
            p.g(hAw, "descriptor.valueParameters");
            int size = hAw.size();
            while (i3 < size) {
                arrayList.add(new n(this.SZP, i2, j.a.VALUE, new kotlin.g.a.a<av>() {
                    /* class kotlin.l.b.a.e.b.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ av invoke() {
                        AppMethodBeat.i(56299);
                        av avVar = hys.hAw().get(i3);
                        p.g(avVar, "descriptor.valueParameters[i]");
                        av avVar2 = avVar;
                        AppMethodBeat.o(56299);
                        return avVar2;
                    }
                }));
                i3++;
                i2++;
            }
            if (this.SZP.hyw() && (hys instanceof kotlin.l.b.a.b.d.a.b.b)) {
                ArrayList arrayList2 = arrayList;
                if (arrayList2.size() > 1) {
                    kotlin.a.j.a((List) arrayList2, (Comparator) new a());
                }
            }
            arrayList.trimToSize();
            AppMethodBeat.o(56300);
            return arrayList;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean hyw() {
        return p.j(getName(), "<init>") && hyv().hxU().isAnnotation();
    }

    @Override // kotlin.l.a
    public final R ag(Object... objArr) {
        p.h(objArr, "args");
        try {
            return (R) hyt().ag(objArr);
        } catch (IllegalAccessException e2) {
            throw new kotlin.l.a.a(e2);
        }
    }

    @Override // kotlin.l.a
    public final R cx(Map<j, ? extends Object> map) {
        p.h(map, "args");
        return hyw() ? cz(map) : cy(map);
    }

    private R cy(Map<j, ? extends Object> map) {
        int i2;
        long j2;
        boolean z;
        int i3;
        p.h(map, "args");
        List<j> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        boolean z2 = false;
        int i4 = 0;
        int i5 = 0;
        for (j jVar : parameters) {
            if (i4 == 0 || i4 % 32 != 0) {
                i2 = i5;
            } else {
                arrayList2.add(Integer.valueOf(i5));
                i2 = 0;
            }
            if (map.containsKey(jVar)) {
                arrayList.add(map.get(jVar));
                z = z2;
            } else if (jVar.FI()) {
                o hyl = jVar.hyl();
                p.h(hyl, "$this$javaType");
                Type hyT = ((t) hyl).hyT();
                if (!(hyT instanceof Class) || !((Class) hyT).isPrimitive()) {
                    j2 = null;
                } else if (p.j(hyT, Boolean.TYPE)) {
                    j2 = Boolean.FALSE;
                } else if (p.j(hyT, Character.TYPE)) {
                    j2 = (char) 0;
                } else if (p.j(hyT, Byte.TYPE)) {
                    j2 = (byte) 0;
                } else if (p.j(hyT, Short.TYPE)) {
                    j2 = (short) 0;
                } else if (p.j(hyT, Integer.TYPE)) {
                    j2 = 0;
                } else if (p.j(hyT, Float.TYPE)) {
                    j2 = Float.valueOf(0.0f);
                } else if (p.j(hyT, Long.TYPE)) {
                    j2 = 0L;
                } else if (p.j(hyT, Double.TYPE)) {
                    j2 = Double.valueOf(0.0d);
                } else if (p.j(hyT, Void.TYPE)) {
                    throw new IllegalStateException("Parameter with void type is illegal");
                } else {
                    throw new UnsupportedOperationException("Unknown primitive: ".concat(String.valueOf(hyT)));
                }
                arrayList.add(j2);
                i2 |= 1 << (i4 % 32);
                z = true;
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(jVar)));
            }
            if (jVar.hym() == j.a.VALUE) {
                i3 = i4 + 1;
            } else {
                i3 = i4;
            }
            z2 = z;
            i4 = i3;
            i5 = i2;
        }
        if (!z2) {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return ag(Arrays.copyOf(array, array.length));
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        arrayList2.add(Integer.valueOf(i5));
        kotlin.l.b.a.a.d<?> hyu = hyu();
        if (hyu == null) {
            throw new w("This callable does not support a default call: " + hys());
        }
        arrayList.addAll(arrayList2);
        arrayList.add(null);
        try {
            Object[] array2 = arrayList.toArray(new Object[0]);
            if (array2 != null) {
                return (R) hyu.ag(array2);
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e2) {
            throw new kotlin.l.a.a(e2);
        }
    }

    private final R cz(Map<j, ? extends Object> map) {
        Object obj;
        List<j> parameters = getParameters();
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(parameters, 10));
        for (T t : parameters) {
            if (map.containsKey(t)) {
                Object obj2 = map.get(t);
                if (obj2 == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + ((Object) t) + ')');
                }
                obj = obj2;
            } else if (t.FI()) {
                obj = null;
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(t)));
            }
            arrayList.add(obj);
        }
        ArrayList arrayList2 = arrayList;
        kotlin.l.b.a.a.d<?> hyu = hyu();
        if (hyu == null) {
            throw new w("This callable does not support a default call: " + hys());
        }
        try {
            Object[] array = arrayList2.toArray(new Object[0]);
            if (array != null) {
                return (R) hyu.ag(array);
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e2) {
            throw new kotlin.l.a.a(e2);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "", "R", "invoke"})
    static final class a extends q implements kotlin.g.a.a<List<? extends Annotation>> {
        final /* synthetic */ e SZP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(0);
            this.SZP = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends Annotation> invoke() {
            AppMethodBeat.i(56297);
            List<Annotation> a2 = ae.a((kotlin.l.b.a.b.b.a.a) this.SZP.hys());
            AppMethodBeat.o(56297);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
    static final class c extends q implements kotlin.g.a.a<t> {
        final /* synthetic */ e SZP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(0);
            this.SZP = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ t invoke() {
            AppMethodBeat.i(56302);
            ab hAu = this.SZP.hys().hAu();
            if (hAu == null) {
                p.hyc();
            }
            p.g(hAu, "descriptor.returnType!!");
            t tVar = new t(hAu, new kotlin.g.a.a<Type>(this) {
                /* class kotlin.l.b.a.e.c.AnonymousClass1 */
                final /* synthetic */ c SZT;

                {
                    this.SZT = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
                @Override // kotlin.g.a.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ java.lang.reflect.Type invoke() {
                    /*
                    // Method dump skipped, instructions count: 121
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.e.c.AnonymousClass1.invoke():java.lang.Object");
                }
            });
            AppMethodBeat.o(56302);
            return tVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
    static final class d extends q implements kotlin.g.a.a<List<? extends v>> {
        final /* synthetic */ e SZP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.SZP = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends v> invoke() {
            AppMethodBeat.i(56303);
            List<as> hAt = this.SZP.hys().hAt();
            p.g(hAt, "descriptor.typeParameters");
            List<as> list = hAt;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new v(it.next()));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(56303);
            return arrayList2;
        }
    }
}
