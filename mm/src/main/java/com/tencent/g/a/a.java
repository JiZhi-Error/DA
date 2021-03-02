package com.tencent.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private Object NMD = new Object();
    private HashMap<String, Object> Spd = new HashMap<>();
    c Spe;

    public a() {
        AppMethodBeat.i(62812);
        AppMethodBeat.o(62812);
    }

    public final void a(d dVar, String[] strArr) {
        AppMethodBeat.i(62813);
        if (strArr == null) {
            AppMethodBeat.o(62813);
            return;
        }
        synchronized (this.NMD) {
            try {
                for (String str : strArr) {
                    if (str != null) {
                        Object obj = this.Spd.get(str);
                        if (obj == null) {
                            this.Spd.put(str, dVar);
                        } else if (obj instanceof d) {
                            d dVar2 = (d) obj;
                            if (dVar2 != dVar) {
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(dVar2);
                                linkedList.add(dVar);
                                this.Spd.put(str, linkedList);
                            } else {
                                return;
                            }
                        } else if (obj instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                AppMethodBeat.o(62813);
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
                AppMethodBeat.o(62813);
            } finally {
                AppMethodBeat.o(62813);
            }
        }
    }

    public final void c(String str, int i2, Object obj) {
        AppMethodBeat.i(62814);
        e eVar = (e) this.Spe.hpO();
        eVar.dST = str;
        eVar.Spg = i2;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        a(eVar);
        AppMethodBeat.o(62814);
    }

    private void a(e eVar) {
        LinkedList linkedList;
        d dVar;
        AppMethodBeat.i(62815);
        if (!(eVar == null || eVar.dST == null)) {
            System.currentTimeMillis();
            String str = eVar.dST;
            synchronized (this.NMD) {
                try {
                    Object obj = this.Spd.get(str);
                    if (obj != null) {
                        if (obj instanceof d) {
                            linkedList = null;
                            dVar = (d) obj;
                        } else if (obj instanceof List) {
                            linkedList = (LinkedList) ((LinkedList) obj).clone();
                            dVar = null;
                        }
                    }
                    linkedList = null;
                    dVar = null;
                } finally {
                    AppMethodBeat.o(62815);
                }
            }
            if (dVar != null) {
                dVar.hH(str, eVar.Spg);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).hH(str, eVar.Spg);
                }
            }
            this.Spe.a(eVar);
        }
    }
}
