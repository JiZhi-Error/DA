package com.c.a.b;

import com.c.a.c.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c extends i implements Comparable<c> {
    long coA;
    long coB;
    d[] coC;
    d[] coD;
    int coE;
    boolean coF = false;
    g<a> coG = new g<>();
    Set<c> coH = new HashSet();
    private final long coz;
    public final String mClassName;

    public static class a {
        public int coI = 0;
        public List<i> coJ = new ArrayList();
    }

    public c(long j2, n nVar, String str, long j3) {
        super(j2, nVar);
        this.mClassName = str;
        this.coz = j3;
    }

    public final String toString() {
        return this.mClassName.replace('/', '.');
    }

    public final Map<d, Object> Kc() {
        HashMap hashMap = new HashMap();
        Kl().aT(this.coz);
        int readUnsignedShort = readUnsignedShort();
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            d dVar = this.coD[i2];
            Ki();
            readUnsignedByte();
            hashMap.put(dVar, a(dVar.cow));
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(c cVar) {
        if (getId() == cVar.getId()) {
            return 0;
        }
        int compareTo = this.mClassName.compareTo(cVar.mClassName);
        if (compareTo == 0) {
            return getId() - cVar.getId() > 0 ? 1 : -1;
        }
        return compareTo;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof c) && compareTo((c) obj) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.mClassName.hashCode();
    }

    public final c Kd() {
        return this.cpb.coS.aS(this.coA);
    }

    public final List<i> Ke() {
        Collection collection;
        g<a> gVar = this.coG;
        Object[] objArr = new Object[gVar.size()];
        V[] vArr = gVar.cql;
        int i2 = 0;
        int length = vArr.length;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                break;
            } else if (g.b(vArr, i3)) {
                objArr[i2] = g.aF(vArr[i3]);
                i2++;
                length = i3;
            } else {
                length = i3;
            }
        }
        int i4 = 0;
        for (Object obj : objArr) {
            i4 += ((a) obj).coJ.size();
        }
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 : this.coG.Kv()) {
            a aVar = this.coG.get(i5);
            if (aVar == null) {
                collection = new ArrayList(0);
            } else {
                collection = aVar.coJ;
            }
            arrayList.addAll(collection);
        }
        return arrayList;
    }

    public static String Kf() {
        return "java.lang.ref.Reference";
    }

    public final List<c> Kg() {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        stack.push(this);
        while (!stack.isEmpty()) {
            c cVar = (c) stack.pop();
            arrayList.add(cVar);
            for (c cVar2 : cVar.coH) {
                stack.push(cVar2);
            }
        }
        return arrayList;
    }
}
