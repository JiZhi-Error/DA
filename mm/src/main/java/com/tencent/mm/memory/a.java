package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.NavigableMap;

public abstract class a<T> extends e<T, Integer> {
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public synchronized T b(Integer num) {
        T t;
        NavigableMap subMap = this.itu.subMap(num, true, Integer.MAX_VALUE, true);
        if (subMap != null && !subMap.isEmpty()) {
            Iterator it = subMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                d dVar = (d) subMap.get(Integer.valueOf(((Integer) it.next()).intValue()));
                if (dVar.size() > 0) {
                    Object pop = dVar.pop();
                    this.itu.put(dVar.aRS(), dVar);
                    t = pop;
                    break;
                }
            }
            if (t != null) {
                zZ(bV(t));
            }
        }
        t = null;
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.tencent.mm.memory.a<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized T e(Integer num) {
        int size;
        T t;
        d dVar = (d) this.itu.get(num);
        if (dVar == null || dVar.size() <= 0) {
            Object[] objArr = new Object[2];
            objArr[0] = num;
            if (dVar == null) {
                size = -1;
            } else if (dVar.its == null) {
                size = -1;
            } else {
                size = dVar.its.size();
            }
            objArr[1] = Integer.valueOf(size);
            Log.d("MicroMsg.BiggerThanPool", "BiggerThanPool getExactSize cannot get %s size count %d", objArr);
            t = null;
        } else {
            Object pop = dVar.pop();
            this.itu.put(dVar.aRS(), dVar);
            zZ(bV(pop));
            t = pop;
        }
        return t;
    }
}
