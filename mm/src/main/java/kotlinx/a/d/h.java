package kotlinx.a.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ.\u0010\r\u001a\u00020\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0006H\u0016J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000bJT\u0010\u0015\u001a\u00020\u000e2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00052\u001a\u0010\u0017\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0018\"\u0006\u0012\u0002\b\u00030\u00052\u001f\b\u0002\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\u0010\u001dJF\u0010\u0015\u001a\u00020\u000e\"\b\b\u0000\u0010\u001e*\u00020\u0010\"\b\b\u0001\u0010\u001f*\u0002H\u001e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0006H\u0016JQ\u0010\u0015\u001a\u00020\u000e\"\b\b\u0000\u0010\u001e*\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u001e\u0018\u00010\u00062\u001f\b\u0002\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u001cJH\u0010\u0015\u001a\u00020\u000e\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00102\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u001e\u0018\u00010\u00062\u001f\b\n\u0010\u0019\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u001cH\bJP\u0010#\u001a\u00020\u000e\"\b\b\u0000\u0010\u001e*\u00020\u0010\"\b\b\u0001\u0010\u001f*\u0002H\u001e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00062\b\b\u0002\u0010&\u001a\u00020'H\u0001J8\u0010(\u001a\u00020\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00062\b\b\u0002\u0010&\u001a\u00020'H\u0001R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "()V", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2NamedSerializers", "", "polyBase2Serializers", "build", "Lkotlinx/serialization/modules/SerialModule;", "build$kotlinx_serialization_runtime", "contextual", "", "T", "", "kClass", "serializer", "include", FacebookRequestErrorClassification.KEY_OTHER, "polymorphic", "baseClass", "baseClasses", "", "buildAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Base", "Sub", "actualClass", "actualSerializer", "baseSerializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "allowOverwrite", "", "registerSerializer", "forClass", "kotlinx-serialization-runtime"})
public final class h implements d {
    private final Map<b<?>, kotlinx.a.h<?>> TXA = new HashMap();
    private final Map<b<?>, Map<b<?>, kotlinx.a.h<?>>> UaL = new HashMap();
    private final Map<b<?>, Map<String, kotlinx.a.h<?>>> UaM = new HashMap();

    public h() {
        AppMethodBeat.i(225878);
        AppMethodBeat.o(225878);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(225875);
        p.h(bVar, FacebookRequestErrorClassification.KEY_OTHER);
        bVar.a(this);
        AppMethodBeat.o(225875);
    }

    private <T> void b(b<T> bVar, kotlinx.a.h<T> hVar) {
        AppMethodBeat.i(225876);
        p.h(bVar, "forClass");
        p.h(hVar, "serializer");
        kotlinx.a.h<?> hVar2 = this.TXA.get(bVar);
        if (hVar2 == null || !(!p.j(hVar2, hVar))) {
            this.TXA.put(bVar, hVar);
            AppMethodBeat.o(225876);
            return;
        }
        g gVar = new g("Serializer for " + bVar + " already registered in this module: " + hVar2 + " (" + hVar2.fWv().hOz() + "), attempted to register " + hVar + " (" + hVar.fWv().hOz() + ')');
        AppMethodBeat.o(225876);
        throw gVar;
    }

    public final b hPh() {
        AppMethodBeat.i(225877);
        f fVar = new f(this.TXA, this.UaL, this.UaM);
        AppMethodBeat.o(225877);
        return fVar;
    }

    @Override // kotlinx.a.d.d
    public final <T> void a(b<T> bVar, kotlinx.a.h<T> hVar) {
        AppMethodBeat.i(225873);
        p.h(bVar, "kClass");
        p.h(hVar, "serializer");
        b(bVar, hVar);
        AppMethodBeat.o(225873);
    }

    @Override // kotlinx.a.d.d
    public final <Base, Sub extends Base> void a(b<Base> bVar, b<Sub> bVar2, kotlinx.a.h<Sub> hVar) {
        Object obj;
        boolean z;
        AppMethodBeat.i(225874);
        p.h(bVar, "baseClass");
        p.h(bVar2, "actualClass");
        p.h(hVar, "actualSerializer");
        p.h(bVar, "baseClass");
        p.h(bVar2, "concreteClass");
        p.h(hVar, "concreteSerializer");
        String hOz = hVar.fWv().hOz();
        Map<b<?>, Map<b<?>, kotlinx.a.h<?>>> map = this.UaL;
        Map<b<?>, kotlinx.a.h<?>> map2 = map.get(bVar);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(bVar, map2);
        }
        Map<b<?>, kotlinx.a.h<?>> map3 = map2;
        kotlinx.a.h<?> hVar2 = map3.get(bVar2);
        Map<b<?>, Map<String, kotlinx.a.h<?>>> map4 = this.UaM;
        Map<String, kotlinx.a.h<?>> map5 = map4.get(bVar);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(bVar, map5);
        }
        Map<String, kotlinx.a.h<?>> map6 = map5;
        if (hVar2 != null) {
            if (!p.j(hVar2, hVar)) {
                g gVar = new g(bVar, bVar2);
                AppMethodBeat.o(225874);
                throw gVar;
            }
            map6.remove(hVar2.fWv().hOz());
        }
        kotlinx.a.h<?> hVar3 = map6.get(hOz);
        if (hVar3 != null) {
            Map<b<?>, kotlinx.a.h<?>> map7 = this.UaL.get(bVar);
            if (map7 == null) {
                p.hyc();
            }
            Iterator it = ae.cw(map7).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (((kotlinx.a.h) ((Map.Entry) next).getValue()) == hVar3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Multiple polymorphic serializers for base class '" + bVar + "' have the same serial name '" + hOz + "': '" + bVar2 + "' and '" + ((Map.Entry) obj) + '\'');
            AppMethodBeat.o(225874);
            throw illegalArgumentException;
        }
        map3.put(bVar2, hVar);
        map6.put(hOz, hVar);
        AppMethodBeat.o(225874);
    }
}
