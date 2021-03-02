package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static volatile c hnt;
    Map<String, List<e>> mMap = new ConcurrentHashMap();

    public static c ayj() {
        AppMethodBeat.i(158784);
        if (hnt == null) {
            synchronized (c.class) {
                try {
                    if (hnt == null) {
                        hnt = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158784);
                    throw th;
                }
            }
        }
        c cVar = hnt;
        AppMethodBeat.o(158784);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(158785);
        AppMethodBeat.o(158785);
    }

    public final boolean m(String str, Bundle bundle) {
        ArrayList<e> arrayList;
        AppMethodBeat.i(158786);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158786);
            return false;
        }
        List<e> list = this.mMap.get(str);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(158786);
            return true;
        }
        synchronized (list) {
            try {
                arrayList = new ArrayList(list);
            } finally {
                AppMethodBeat.o(158786);
            }
        }
        for (e eVar : arrayList) {
            eVar.bn(bundle);
        }
        return true;
    }

    public final boolean a(String str, e eVar) {
        boolean add;
        AppMethodBeat.i(158787);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158787);
            return false;
        }
        List<e> list = this.mMap.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.mMap.put(str, list);
        }
        if (list.contains(eVar)) {
            AppMethodBeat.o(158787);
            return false;
        }
        synchronized (list) {
            try {
                add = list.add(eVar);
            } finally {
                AppMethodBeat.o(158787);
            }
        }
        return add;
    }

    public final boolean b(String str, e eVar) {
        boolean z;
        boolean remove;
        AppMethodBeat.i(158788);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158788);
            return false;
        }
        List<e> list = this.mMap.get(str);
        if (list != null) {
            synchronized (list) {
                try {
                    remove = list.remove(eVar);
                } finally {
                    AppMethodBeat.o(158788);
                }
            }
            if (list.isEmpty()) {
                this.mMap.remove(str);
            }
            z = remove;
        } else {
            z = false;
        }
        return z;
    }
}
