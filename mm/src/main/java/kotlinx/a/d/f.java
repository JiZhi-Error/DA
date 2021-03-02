package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlin.t;
import kotlinx.a.h;
import kotlinx.a.u;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001Bu\u0012\u001a\u0010\u0002\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00030\u0003\u0012&\u0010\u0007\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00030\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u0005\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H\u0016J7\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u000f\u0018\u00010\u0005\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\u0006\u0010\u0014\u001a\u0002H\u000fH\u0016¢\u0006\u0002\u0010\u0015J2\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u000f\u0018\u00010\u0005\"\b\b\u0000\u0010\u000f*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0016R\"\u0010\u0002\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerialModule;", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "polyBase2NamedSerializers", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "T", "", "kclass", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "kotlinx-serialization-runtime"})
public final class f implements b {
    private final Map<b<?>, h<?>> TXA;
    private final Map<b<?>, Map<b<?>, h<?>>> UaL;
    private final Map<b<?>, Map<String, h<?>>> UaM;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<kotlin.l.b<?>, ? extends kotlinx.a.h<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<kotlin.l.b<?>, ? extends java.util.Map<kotlin.l.b<?>, ? extends kotlinx.a.h<?>>> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<kotlin.l.b<?>, ? extends java.util.Map<java.lang.String, ? extends kotlinx.a.h<?>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public f(Map<b<?>, ? extends h<?>> map, Map<b<?>, ? extends Map<b<?>, ? extends h<?>>> map2, Map<b<?>, ? extends Map<String, ? extends h<?>>> map3) {
        p.h(map, "class2Serializer");
        p.h(map2, "polyBase2Serializers");
        p.h(map3, "polyBase2NamedSerializers");
        AppMethodBeat.i(225868);
        this.TXA = map;
        this.UaL = map2;
        this.UaM = map3;
        AppMethodBeat.o(225868);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v13. Raw type applied. Possible types: kotlinx.a.h<?> */
    @Override // kotlinx.a.d.b
    public final <T> h<? extends T> a(b<T> bVar, T t) {
        h hVar = null;
        AppMethodBeat.i(225865);
        p.h(bVar, "baseClass");
        p.h(t, "value");
        if (!u.a(t, bVar)) {
            AppMethodBeat.o(225865);
            return null;
        }
        Map<b<?>, h<?>> map = this.UaL.get(bVar);
        h<? extends T> hVar2 = map != null ? (h<? extends T>) map.get(aa.bp(t.getClass())) : null;
        if (!(hVar2 instanceof h)) {
            hVar2 = null;
        }
        if (hVar2 != null) {
            AppMethodBeat.o(225865);
            return hVar2;
        } else if (p.j(bVar, aa.bp(Object.class))) {
            i iVar = i.UaO;
            h gA = i.gA(t);
            if (gA instanceof h) {
                hVar = gA;
            }
            AppMethodBeat.o(225865);
            return hVar;
        } else {
            AppMethodBeat.o(225865);
            return null;
        }
    }

    @Override // kotlinx.a.d.b
    public final <T> h<? extends T> a(b<T> bVar, String str) {
        h<? extends T> hVar;
        h<? extends T> hVar2 = null;
        AppMethodBeat.i(225866);
        p.h(bVar, "baseClass");
        p.h(str, "serializedClassName");
        if (p.j(bVar, aa.bp(Object.class))) {
            i iVar = i.UaO;
            hVar = (h<? extends T>) i.buU(str);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            AppMethodBeat.o(225866);
            return hVar;
        }
        Map<String, h<?>> map = this.UaM.get(bVar);
        h<?> hVar3 = map != null ? map.get(str) : null;
        if (hVar3 instanceof h) {
            hVar2 = hVar3;
        }
        AppMethodBeat.o(225866);
        return hVar2;
    }

    @Override // kotlinx.a.d.b
    public final void a(d dVar) {
        AppMethodBeat.i(225867);
        p.h(dVar, "collector");
        for (Map.Entry<b<?>, h<?>> entry : this.TXA.entrySet()) {
            b<?> key = entry.getKey();
            h<?> value = entry.getValue();
            if (key == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                AppMethodBeat.o(225867);
                throw tVar;
            } else if (value == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
                AppMethodBeat.o(225867);
                throw tVar2;
            } else {
                dVar.a(key, value);
            }
        }
        for (Map.Entry<b<?>, Map<b<?>, h<?>>> entry2 : this.UaL.entrySet()) {
            b<?> key2 = entry2.getKey();
            Iterator<Map.Entry<b<?>, h<?>>> it = entry2.getValue().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<b<?>, h<?>> next = it.next();
                    b<?> key3 = next.getKey();
                    h<?> value2 = next.getValue();
                    if (key2 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                        AppMethodBeat.o(225867);
                        throw tVar3;
                    } else if (key3 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                        AppMethodBeat.o(225867);
                        throw tVar4;
                    } else if (value2 == null) {
                        t tVar5 = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
                        AppMethodBeat.o(225867);
                        throw tVar5;
                    } else {
                        dVar.a(key2, key3, value2);
                    }
                }
            }
        }
        AppMethodBeat.o(225867);
    }
}
