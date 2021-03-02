package com.tencent.matrix.resource.analyzer.a;

import com.c.a.b.b;
import com.c.a.b.e;
import com.c.a.b.f;
import com.c.a.b.k;
import com.c.a.b.l;
import com.c.a.b.p;
import com.tencent.matrix.resource.analyzer.model.d;
import com.tencent.matrix.resource.analyzer.model.h;
import com.tencent.matrix.resource.analyzer.model.i;
import com.tencent.matrix.resource.analyzer.model.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c {
    private final d cYq;
    private final Queue<i> cYr = new LinkedList();
    private final Queue<i> cYs = new LinkedList();
    private final Set<com.c.a.b.i> cYt = new HashSet();
    private final Set<com.c.a.b.i> cYu = new HashSet();
    private final Set<com.c.a.b.i> cYv = new HashSet();
    private boolean cYw;

    public c(d dVar) {
        this.cYq = dVar;
    }

    public static final class a {
        public final i cYy;
        public final boolean cYz;

        public a(i iVar, boolean z) {
            this.cYy = iVar;
            this.cYz = z;
        }

        public final h Ta() {
            ArrayList arrayList = new ArrayList();
            for (i iVar = new i(null, null, this.cYy, null, null); iVar != null; iVar = iVar.cXZ) {
                j d2 = d(iVar);
                if (d2 != null) {
                    arrayList.add(0, d2);
                }
            }
            return new h(arrayList);
        }

        private static j d(i iVar) {
            String str;
            j.a aVar;
            String str2 = null;
            if (iVar.cXZ == null) {
                return null;
            }
            com.c.a.b.i iVar2 = iVar.cXZ.cXY;
            if (iVar2 instanceof com.c.a.b.j) {
                return null;
            }
            j.b bVar = iVar.cYb;
            String str3 = iVar.cYa;
            ArrayList arrayList = new ArrayList();
            if (iVar2 instanceof com.c.a.b.c) {
                for (Map.Entry<com.c.a.b.d, Object> entry : ((com.c.a.b.c) iVar2).Kc().entrySet()) {
                    arrayList.add("static " + entry.getKey().mName + " = " + entry.getValue());
                }
            } else if (iVar2 instanceof com.c.a.b.a) {
                com.c.a.b.a aVar2 = (com.c.a.b.a) iVar2;
                if (aVar2.cow == p.OBJECT) {
                    Object[] JZ = aVar2.JZ();
                    for (int i2 = 0; i2 < JZ.length; i2++) {
                        arrayList.add("[" + i2 + "] = " + JZ[i2]);
                    }
                }
            } else {
                Iterator<Map.Entry<com.c.a.b.d, Object>> it = iVar2.Ka().Kc().entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add("static " + e.d(it.next()));
                }
                for (b.a aVar3 : ((b) iVar2).Kb()) {
                    arrayList.add(e.a(aVar3));
                }
            }
            if (iVar2 instanceof com.c.a.b.c) {
                str = ((com.c.a.b.c) iVar2).mClassName;
            } else if (iVar2 instanceof com.c.a.b.a) {
                str = ((com.c.a.b.a) iVar2).Ka().mClassName;
            } else {
                str = iVar2.Ka().mClassName;
            }
            if (iVar2 instanceof com.c.a.b.c) {
                aVar = j.a.CLASS;
            } else if (iVar2 instanceof com.c.a.b.a) {
                aVar = j.a.ARRAY;
            } else {
                com.c.a.b.c Ka = iVar2.Ka();
                if (e.b(Ka)) {
                    str2 = "(named '" + e.a(iVar2) + "')";
                    aVar = j.a.THREAD;
                } else if (str.matches("^.+\\$\\d+$")) {
                    String str4 = Ka.Kd().mClassName;
                    if (Object.class.getName().equals(str4)) {
                        aVar = j.a.OBJECT;
                        try {
                            Class<?>[] interfaces = Class.forName(Ka.mClassName).getInterfaces();
                            str2 = interfaces.length > 0 ? "(anonymous implementation of " + interfaces[0].getName() + ")" : "(anonymous subclass of java.lang.Object)";
                        } catch (ClassNotFoundException e2) {
                        }
                    } else {
                        aVar = j.a.OBJECT;
                        str2 = "(anonymous subclass of " + str4 + ")";
                    }
                } else {
                    aVar = j.a.OBJECT;
                }
            }
            return new j(str3, bVar, aVar, str, str2, iVar.cXX, arrayList);
        }
    }

    public final Map<com.c.a.b.i, a> a(l lVar, Collection<com.c.a.b.i> collection) {
        i iVar;
        boolean z;
        HashMap hashMap = new HashMap();
        if (collection.isEmpty()) {
            return hashMap;
        }
        this.cYr.clear();
        this.cYs.clear();
        this.cYt.clear();
        this.cYu.clear();
        this.cYv.clear();
        b(lVar);
        this.cYw = true;
        Iterator<com.c.a.b.i> it = collection.iterator();
        while (true) {
            if (it.hasNext()) {
                if (d(it.next())) {
                    this.cYw = false;
                    break;
                }
            } else {
                break;
            }
        }
        HashSet hashSet = new HashSet(collection);
        while (true) {
            if (this.cYr.isEmpty() && this.cYs.isEmpty()) {
                break;
            }
            if (!this.cYr.isEmpty()) {
                iVar = this.cYr.poll();
            } else {
                i poll = this.cYs.poll();
                if (poll.cXX == null) {
                    throw new IllegalStateException("Expected node to have an exclusion ".concat(String.valueOf(poll)));
                }
                iVar = poll;
            }
            if (hashSet.contains(iVar.cXY)) {
                hashMap.put(iVar.cXY, new a(iVar, iVar.cXX != null));
                hashSet.remove(iVar.cXY);
                if (hashSet.isEmpty()) {
                    break;
                }
            }
            if (!this.cYv.add(iVar.cXY)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (iVar.cXY instanceof com.c.a.b.j) {
                    com.c.a.b.j jVar = (com.c.a.b.j) iVar.cXY;
                    com.c.a.b.i Km = jVar.Km();
                    if (jVar.cpi == k.JAVA_LOCAL) {
                        com.c.a.b.i c2 = f.c(jVar);
                        com.tencent.matrix.resource.analyzer.model.e eVar = null;
                        if (iVar.cXX != null) {
                            eVar = iVar.cXX;
                        }
                        a(eVar, new i(null, c2, null, null, null), Km, "<Java Local>", j.b.LOCAL);
                    } else {
                        a(null, iVar, Km, null, null);
                    }
                } else if (iVar.cXY instanceof com.c.a.b.c) {
                    a(iVar);
                } else if (iVar.cXY instanceof b) {
                    b(iVar);
                } else if (iVar.cXY instanceof com.c.a.b.a) {
                    c(iVar);
                } else {
                    throw new IllegalStateException("Unexpected type for " + iVar.cXY);
                }
            }
        }
        return hashMap;
    }

    private void b(l lVar) {
        for (com.c.a.b.j jVar : lVar.Kn()) {
            switch (jVar.cpi) {
                case JAVA_LOCAL:
                    com.tencent.matrix.resource.analyzer.model.e eVar = this.cYq.cXP.get(e.a(f.c(jVar)));
                    if (eVar == null || !eVar.cXT) {
                        a(eVar, null, jVar, null, null);
                        break;
                    } else {
                        break;
                    }
                case INTERNED_STRING:
                case DEBUGGER:
                case INVALID_TYPE:
                case UNREACHABLE:
                case UNKNOWN:
                case FINALIZING:
                    break;
                case SYSTEM_CLASS:
                case VM_INTERNAL:
                case NATIVE_LOCAL:
                case NATIVE_STATIC:
                case THREAD_BLOCK:
                case BUSY_MONITOR:
                case NATIVE_MONITOR:
                case REFERENCE_CLEANUP:
                case NATIVE_STACK:
                case JAVA_STATIC:
                    a(null, null, jVar, null, null);
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown root type:" + jVar.cpi);
            }
        }
    }

    private void a(i iVar) {
        com.tencent.matrix.resource.analyzer.model.e eVar;
        com.c.a.b.c cVar = (com.c.a.b.c) iVar.cXY;
        Map<String, com.tencent.matrix.resource.analyzer.model.e> map = this.cYq.cXO.get(cVar.mClassName);
        for (Map.Entry<com.c.a.b.d, Object> entry : cVar.Kc().entrySet()) {
            com.c.a.b.d key = entry.getKey();
            if (key.cow == p.OBJECT) {
                String str = key.mName;
                if (!"$staticOverhead".equals(str)) {
                    com.c.a.b.i iVar2 = (com.c.a.b.i) entry.getValue();
                    boolean z = true;
                    if (!(map == null || (eVar = map.get(str)) == null)) {
                        if (!eVar.cXT) {
                            a(eVar, iVar, iVar2, str, j.b.STATIC_FIELD);
                        }
                        z = false;
                    }
                    if (z) {
                        a(null, iVar, iVar2, str, j.b.STATIC_FIELD);
                    }
                }
            }
        }
    }

    private void b(i iVar) {
        com.tencent.matrix.resource.analyzer.model.e eVar;
        com.tencent.matrix.resource.analyzer.model.e eVar2;
        b bVar = (b) iVar.cXY;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.matrix.resource.analyzer.model.e eVar3 = null;
        for (com.c.a.b.c Ka = bVar.Ka(); Ka != null; Ka = Ka.Kd()) {
            com.tencent.matrix.resource.analyzer.model.e eVar4 = this.cYq.cXQ.get(Ka.mClassName);
            if (eVar4 == null || (eVar3 != null && eVar3.cXT)) {
                eVar2 = eVar3;
            } else {
                eVar2 = eVar4;
            }
            Map<String, com.tencent.matrix.resource.analyzer.model.e> map = this.cYq.cXN.get(Ka.mClassName);
            if (map != null) {
                linkedHashMap.putAll(map);
            }
            eVar3 = eVar2;
        }
        if (eVar3 == null || !eVar3.cXT) {
            for (b.a aVar : bVar.Kb()) {
                com.c.a.b.d dVar = aVar.coy;
                if (dVar.cow == p.OBJECT) {
                    com.c.a.b.i iVar2 = (com.c.a.b.i) aVar.mValue;
                    String str = dVar.mName;
                    com.tencent.matrix.resource.analyzer.model.e eVar5 = (com.tencent.matrix.resource.analyzer.model.e) linkedHashMap.get(str);
                    if (eVar5 == null || (eVar3 != null && (!eVar5.cXT || eVar3.cXT))) {
                        eVar = eVar3;
                    } else {
                        eVar = eVar5;
                    }
                    a(eVar, iVar, iVar2, str, j.b.INSTANCE_FIELD);
                }
            }
        }
    }

    private void c(i iVar) {
        com.c.a.b.a aVar = (com.c.a.b.a) iVar.cXY;
        if (aVar.cow == p.OBJECT) {
            Object[] JZ = aVar.JZ();
            for (int i2 = 0; i2 < JZ.length; i2++) {
                a(null, iVar, (com.c.a.b.i) JZ[i2], "[" + i2 + "]", j.b.ARRAY_ENTRY);
            }
        }
    }

    private void a(com.tencent.matrix.resource.analyzer.model.e eVar, i iVar, com.c.a.b.i iVar2, String str, j.b bVar) {
        boolean z;
        if (iVar2 != null && !e.aC(iVar2) && !e.aB(iVar2) && !this.cYt.contains(iVar2)) {
            if (eVar == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z && this.cYu.contains(iVar2)) {
                return;
            }
            if ((!this.cYw || !d(iVar2)) && !this.cYv.contains(iVar2)) {
                i iVar3 = new i(eVar, iVar2, iVar, str, bVar);
                if (z) {
                    this.cYt.add(iVar2);
                    this.cYr.add(iVar3);
                    return;
                }
                this.cYu.add(iVar2);
                this.cYs.add(iVar3);
            }
        }
    }

    private static boolean d(com.c.a.b.i iVar) {
        return iVar.Ka() != null && iVar.Ka().mClassName.equals(String.class.getName());
    }
}
