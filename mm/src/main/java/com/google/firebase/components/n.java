package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n implements b {
    private final List<a<?>> bKS;
    private final Map<Class<?>, p<?>> bKT = new HashMap();

    @Override // com.google.firebase.components.b
    public final <T> a<T> A(Class<T> cls) {
        AppMethodBeat.i(4087);
        r.zza(cls, "Null interface requested.");
        p<?> pVar = this.bKT.get(cls);
        AppMethodBeat.o(4087);
        return pVar;
    }

    @Override // com.google.firebase.components.b
    public final Object y(Class cls) {
        AppMethodBeat.i(4089);
        Object a2 = c.a(this, cls);
        AppMethodBeat.o(4089);
        return a2;
    }

    public n(Iterable<e> iterable, a<?>... aVarArr) {
        o oVar;
        AppMethodBeat.i(4086);
        ArrayList<a> arrayList = new ArrayList();
        for (e eVar : iterable) {
            arrayList.addAll(eVar.getComponents());
        }
        Collections.addAll(arrayList, aVarArr);
        HashMap hashMap = new HashMap(arrayList.size());
        for (a aVar : arrayList) {
            o oVar2 = new o(aVar);
            Iterator<Class<? super T>> it = aVar.bKJ.iterator();
            while (true) {
                if (it.hasNext()) {
                    Class<? super T> next = it.next();
                    if (hashMap.put(next, oVar2) != null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Multiple components provide %s.", next));
                        AppMethodBeat.o(4086);
                        throw illegalArgumentException;
                    }
                }
            }
        }
        for (o oVar3 : hashMap.values()) {
            for (f fVar : oVar3.bKU.bKK) {
                if (fVar.ya() && (oVar = (o) hashMap.get(fVar.bKM)) != null) {
                    oVar3.bKV.add(oVar);
                    oVar.bKW.add(oVar3);
                }
            }
        }
        HashSet<o> hashSet = new HashSet(hashMap.values());
        HashSet hashSet2 = new HashSet();
        for (o oVar4 : hashSet) {
            if (oVar4.yb()) {
                hashSet2.add(oVar4);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            o oVar5 = (o) hashSet2.iterator().next();
            hashSet2.remove(oVar5);
            arrayList2.add(oVar5.bKU);
            for (o oVar6 : oVar5.bKV) {
                oVar6.bKW.remove(oVar5);
                if (oVar6.yb()) {
                    hashSet2.add(oVar6);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            this.bKS = Collections.unmodifiableList(arrayList2);
            for (a<?> aVar2 : this.bKS) {
                p<?> pVar = new p<>(aVar2.bKL, new s(aVar2.bKK, this));
                for (Class<? super T> cls : aVar2.bKJ) {
                    this.bKT.put(cls, pVar);
                }
            }
            for (a<?> aVar3 : this.bKS) {
                Iterator<f> it2 = aVar3.bKK.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        f next2 = it2.next();
                        if ((next2.bKN == 1) && !this.bKT.containsKey(next2.bKM)) {
                            i iVar = new i(String.format("Unsatisfied dependency for component %s: %s", aVar3, next2.bKM));
                            AppMethodBeat.o(4086);
                            throw iVar;
                        }
                    }
                }
            }
            AppMethodBeat.o(4086);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (o oVar7 : hashSet) {
            if (!oVar7.yb() && !oVar7.bKV.isEmpty()) {
                arrayList3.add(oVar7.bKU);
            }
        }
        g gVar = new g(arrayList3);
        AppMethodBeat.o(4086);
        throw gVar;
    }

    public final void bd(boolean z) {
        AppMethodBeat.i(4088);
        for (a<?> aVar : this.bKS) {
            if (aVar.xX() || (aVar.xY() && z)) {
                c.a(this, aVar.bKJ.iterator().next());
            }
        }
        AppMethodBeat.o(4088);
    }
}
