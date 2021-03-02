package com.bumptech.glide.d;

import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private final List<String> aMS = new ArrayList();
    private final Map<String, List<a<?, ?>>> aMT = new HashMap();

    public e() {
        AppMethodBeat.i(77610);
        AppMethodBeat.o(77610);
    }

    public final synchronized void r(List<String> list) {
        AppMethodBeat.i(77611);
        ArrayList<String> arrayList = new ArrayList(this.aMS);
        this.aMS.clear();
        this.aMS.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.aMS.add(str);
            }
        }
        AppMethodBeat.o(77611);
    }

    public final synchronized <T, R> List<j<T, R>> f(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.i(77612);
        arrayList = new ArrayList();
        for (String str : this.aMS) {
            List<a<?, ?>> list = this.aMT.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.e(cls, cls2)) {
                        arrayList.add(aVar.aKJ);
                    }
                }
            }
        }
        AppMethodBeat.o(77612);
        return arrayList;
    }

    public final synchronized <T, R> List<Class<R>> g(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        AppMethodBeat.i(77613);
        arrayList = new ArrayList();
        for (String str : this.aMS) {
            List<a<?, ?>> list = this.aMT.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.e(cls, cls2) && !arrayList.contains(aVar.aFX)) {
                        arrayList.add(aVar.aFX);
                    }
                }
            }
        }
        AppMethodBeat.o(77613);
        return arrayList;
    }

    public final synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        AppMethodBeat.i(77614);
        U(str).add(new a<>(cls, cls2, jVar));
        AppMethodBeat.o(77614);
    }

    private synchronized List<a<?, ?>> U(String str) {
        List<a<?, ?>> list;
        AppMethodBeat.i(77615);
        if (!this.aMS.contains(str)) {
            this.aMS.add(str);
        }
        list = this.aMT.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.aMT.put(str, list);
        }
        AppMethodBeat.o(77615);
        return list;
    }

    /* access modifiers changed from: package-private */
    public static class a<T, R> {
        final Class<R> aFX;
        private final Class<T> aGU;
        final j<T, R> aKJ;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.aGU = cls;
            this.aFX = cls2;
            this.aKJ = jVar;
        }

        public final boolean e(Class<?> cls, Class<?> cls2) {
            AppMethodBeat.i(77609);
            if (!this.aGU.isAssignableFrom(cls) || !cls2.isAssignableFrom(this.aFX)) {
                AppMethodBeat.o(77609);
                return false;
            }
            AppMethodBeat.o(77609);
            return true;
        }
    }
}
