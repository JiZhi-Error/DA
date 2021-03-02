package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class g {
    public f szE;

    g() {
    }

    public static c<egw, Integer> a(bo boVar, bn bnVar) {
        AppMethodBeat.i(121899);
        if (boVar == null || boVar.KFn.isEmpty()) {
            AppMethodBeat.o(121899);
            return null;
        }
        for (int size = boVar.KFn.size() - 1; size >= 0; size--) {
            egw egw = boVar.KFn.get(size);
            if (egw != null && !egw.NgI.isEmpty()) {
                for (int size2 = egw.NgI.size() - 1; size2 >= 0; size2--) {
                    bn bnVar2 = egw.NgI.get(size2);
                    if (bnVar2 != null && h.a(bnVar.KFh, bnVar2.KFh)) {
                        c<egw, Integer> Q = a.Q(egw, Integer.valueOf(size));
                        AppMethodBeat.o(121899);
                        return Q;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(121899);
        return null;
    }

    static void b(bo boVar, bn bnVar) {
        AppMethodBeat.i(121900);
        egw egw = null;
        if (!boVar.KFn.isEmpty()) {
            egw = boVar.KFn.getLast();
        }
        if (egw == null) {
            egw = new egw();
            boVar.KFn.addLast(egw);
        }
        egw.NgI.addLast(bnVar);
        AppMethodBeat.o(121900);
    }

    static void a(bo boVar, bn bnVar, boolean z) {
        AppMethodBeat.i(121901);
        egw egw = new egw();
        egw.NgH = z;
        egw.NgI.addLast(bnVar);
        if (boVar == null) {
            boVar = new bo();
        }
        boVar.KFn.addLast(egw);
        AppMethodBeat.o(121901);
    }

    static boolean b(bo boVar) {
        AppMethodBeat.i(121902);
        if (boVar == null) {
            AppMethodBeat.o(121902);
            return false;
        }
        egw egw = null;
        if (!boVar.KFn.isEmpty()) {
            egw = boVar.KFn.getLast();
        }
        if (egw == null || !egw.NgH) {
            AppMethodBeat.o(121902);
            return false;
        }
        AppMethodBeat.o(121902);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(bo boVar, int i2, bn bnVar) {
        AppMethodBeat.i(121903);
        if (boVar == null) {
            AppMethodBeat.o(121903);
            return;
        }
        egw last = boVar.KFn.getLast();
        int size = last.NgI.size();
        if (i2 < 0 || i2 >= size) {
            AppMethodBeat.o(121903);
            return;
        }
        for (int i3 = size - 1; i3 >= i2; i3--) {
            bn remove = last.NgI.remove(i3);
            if (this.szE != null) {
                remove.KFh.timestamp = bnVar.KFh.timestamp;
                this.szE.c(remove, bnVar);
            }
        }
        a(boVar, last);
        AppMethodBeat.o(121903);
    }

    /* access modifiers changed from: package-private */
    public final void b(bo boVar, int i2, bn bnVar) {
        AppMethodBeat.i(121904);
        if (boVar == null) {
            AppMethodBeat.o(121904);
            return;
        }
        int size = boVar.KFn.size();
        if (i2 < 0 || i2 >= size) {
            AppMethodBeat.o(121904);
            return;
        }
        for (int i3 = size - 1; i3 >= i2; i3--) {
            Iterator<bn> it = boVar.KFn.remove(i3).NgI.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if (this.szE != null) {
                    next.KFh.timestamp = bnVar.KFh.timestamp;
                    this.szE.c(next, bnVar);
                }
            }
        }
        AppMethodBeat.o(121904);
    }

    private static void a(bo boVar, egw egw) {
        AppMethodBeat.i(121905);
        if (egw.NgI.isEmpty() && !boVar.KFn.isEmpty()) {
            boVar.KFn.removeLast();
        }
        AppMethodBeat.o(121905);
    }

    static bn c(bo boVar) {
        egw egw;
        AppMethodBeat.i(121906);
        if (boVar == null) {
            AppMethodBeat.o(121906);
            return null;
        }
        if (!boVar.KFn.isEmpty()) {
            egw = boVar.KFn.getLast();
        } else {
            egw = null;
        }
        if (egw == null) {
            AppMethodBeat.o(121906);
            return null;
        } else if (egw.NgI.isEmpty()) {
            AppMethodBeat.o(121906);
            return null;
        } else {
            bn last = egw.NgI.getLast();
            AppMethodBeat.o(121906);
            return last;
        }
    }

    static c<Integer, Integer> c(bo boVar, bn bnVar) {
        AppMethodBeat.i(121907);
        c<Integer, Integer> a2 = a(boVar, bnVar.KFh.activityName);
        AppMethodBeat.o(121907);
        return a2;
    }

    static c<Integer, Integer> a(bo boVar, String str) {
        int i2;
        int i3;
        AppMethodBeat.i(220423);
        if (TextUtils.isEmpty(str)) {
            c<Integer, Integer> Q = a.Q(-1, -1);
            AppMethodBeat.o(220423);
            return Q;
        } else if (boVar == null) {
            c<Integer, Integer> Q2 = c.Q(-1, -1);
            AppMethodBeat.o(220423);
            return Q2;
        } else {
            int size = boVar.KFn.size();
            if (size <= 0) {
                c<Integer, Integer> Q3 = c.Q(-1, -1);
                AppMethodBeat.o(220423);
                return Q3;
            }
            int i4 = size - 1;
            int i5 = -1;
            int i6 = -1;
            while (i4 >= 0) {
                egw egw = boVar.KFn.get(i4);
                int size2 = egw.NgI.size() - 1;
                while (true) {
                    if (size2 < 0) {
                        i2 = i5;
                        i3 = i6;
                        break;
                    } else if (str.equals(egw.NgI.get(size2).KFh.activityName)) {
                        i2 = size2;
                        i3 = i4;
                        break;
                    } else {
                        size2--;
                    }
                }
                i4--;
                i5 = i2;
                i6 = i3;
            }
            if (i6 == -1) {
                c<Integer, Integer> Q4 = c.Q(-1, -1);
                AppMethodBeat.o(220423);
                return Q4;
            }
            c<Integer, Integer> Q5 = a.Q(Integer.valueOf(i6), Integer.valueOf(i5));
            AppMethodBeat.o(220423);
            return Q5;
        }
    }

    static LinkedList<egw> d(bo boVar) {
        if (boVar == null) {
            return null;
        }
        return boVar.KFn;
    }

    public static bn e(bo boVar) {
        egw egw;
        AppMethodBeat.i(121910);
        if (boVar == null) {
            AppMethodBeat.o(121910);
            return null;
        }
        if (!boVar.KFn.isEmpty()) {
            egw = boVar.KFn.getLast();
        } else {
            egw = null;
        }
        if (egw == null) {
            AppMethodBeat.o(121910);
            return null;
        } else if (egw.NgI.isEmpty()) {
            AppMethodBeat.o(121910);
            return null;
        } else {
            bn last = egw.NgI.getLast();
            AppMethodBeat.o(121910);
            return last;
        }
    }

    public static c<bo, bn> cNS() {
        AppMethodBeat.i(121909);
        bo cNK = c.cNK();
        c<bo, bn> Q = a.Q(cNK, e(cNK));
        AppMethodBeat.o(121909);
        return Q;
    }

    public static bn apc(String str) {
        AppMethodBeat.i(121911);
        bo cNK = c.cNK();
        c<Integer, Integer> a2 = a(cNK, str);
        int intValue = ((Integer) a2.get(0)).intValue();
        int intValue2 = ((Integer) a2.get(1)).intValue();
        if (intValue < 0 || intValue2 < 0) {
            AppMethodBeat.o(121911);
            return null;
        }
        bn bnVar = cNK.KFn.get(intValue).NgI.get(intValue2);
        AppMethodBeat.o(121911);
        return bnVar;
    }
}
