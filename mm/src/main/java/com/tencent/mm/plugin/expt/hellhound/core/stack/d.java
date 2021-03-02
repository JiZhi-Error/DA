package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.stack.b;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;

public final class d {
    private static volatile d szz;
    public e szA = new e();

    public static d cNM() {
        AppMethodBeat.i(121882);
        if (szz == null) {
            synchronized (d.class) {
                try {
                    if (szz == null) {
                        szz = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121882);
                    throw th;
                }
            }
        }
        d dVar = szz;
        AppMethodBeat.o(121882);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(121883);
        if (b.isMMProcess()) {
            Log.i("HABBYGE-MALI.ActivityStackDao", "ActivityStackDao reset");
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_astackd_mmkv_key", new byte[0]);
        }
        AppMethodBeat.o(121883);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Deprecated
    public final void a(Activity activity, Intent intent, String str, String str2, int i2) {
        char c2;
        boolean z;
        boolean z2;
        char c3;
        AppMethodBeat.i(220417);
        e eVar = this.szA;
        if (intent != null) {
            if (!TextUtils.isEmpty(str2)) {
                int flags = intent.getFlags();
                if (!(i2 <= 0)) {
                    c<bo, bn> cNS = g.cNS();
                    bo boVar = (bo) cNS.get(0);
                    bn bnVar = (bn) cNS.get(1);
                    if (bnVar != null && bnVar.KFh != null && bnVar.KFh.activityName.equals(str2) && bnVar.KFh.aHK <= 0) {
                        bnVar.KFh.aHK = i2;
                        c.a(boVar);
                        AppMethodBeat.o(220417);
                        return;
                    }
                }
                bn bnVar2 = new bn();
                bnVar2.KFh = new eih();
                bnVar2.KFh.activityName = str2;
                if (!TextUtils.isEmpty(str)) {
                    bnVar2.KFk = str;
                }
                bnVar2.KFh.aHK = i2;
                bnVar2.flags = flags;
                bnVar2.state = a.CREATE.value;
                if (flags == 0) {
                    c2 = 0;
                } else if ((268435456 & flags) == 268435456) {
                    int i3 = bnVar2.flags;
                    if ((134217728 & i3) == 134217728) {
                        c2 = 3;
                    } else if ((32768 & i3) == 32768) {
                        g gVar = eVar.szB;
                        if (!TextUtils.isEmpty(bnVar2.KFh.activityName)) {
                            bo cNK = c.cNK();
                            bn e2 = g.e(cNK);
                            c<egw, Integer> a2 = g.a(cNK, bnVar2);
                            if (a2 == null) {
                                c2 = 'e';
                            } else {
                                egw egw = (egw) a2.get(0);
                                egw.NgI.clear();
                                egw.NgH = false;
                                egw.NgI.addLast(bnVar2);
                                c.a(cNK);
                                if (gVar.szE != null) {
                                    gVar.szE.a(activity, bnVar2, e2);
                                }
                            }
                        }
                        c2 = 'd';
                    } else if ((i3 & 67108864) == 67108864) {
                        c2 = 2;
                    } else {
                        g gVar2 = eVar.szB;
                        if (TextUtils.isEmpty(bnVar2.KFh.activityName)) {
                            z = false;
                        } else {
                            bo cNK2 = c.cNK();
                            bn e3 = g.e(cNK2);
                            c<egw, Integer> a3 = g.a(cNK2, bnVar2);
                            if (a3 == null) {
                                z = false;
                            } else {
                                egw egw2 = (egw) a3.get(0);
                                cNK2.KFn.remove(((Integer) a3.get(1)).intValue());
                                cNK2.KFn.addLast(egw2);
                                bn last = egw2.NgI.getLast();
                                if (last != null && !h.a(last.KFh, bnVar2.KFh)) {
                                    int size = egw2.NgI.size() - 1;
                                    while (size >= 0 && !h.a(egw2.NgI.get(size).KFh, bnVar2.KFh)) {
                                        egw2.NgI.remove(size);
                                        size--;
                                    }
                                }
                                c.a(cNK2);
                                if (gVar2.szE != null) {
                                    gVar2.szE.a(activity, bnVar2, e3);
                                }
                                z = true;
                            }
                        }
                        c2 = !z ? 'e' : 'd';
                    }
                } else if ((67108864 & flags) == 67108864) {
                    c2 = 2;
                } else if ((536870912 & flags) == 536870912) {
                    c2 = 1;
                } else if ((131072 & flags) == 131072) {
                    if ((67108864 & flags) == 67108864) {
                        c2 = 2;
                    } else {
                        g gVar3 = eVar.szB;
                        bo cNK3 = c.cNK();
                        bn e4 = g.e(cNK3);
                        c<Integer, Integer> c4 = g.c(cNK3, bnVar2);
                        int intValue = ((Integer) c4.get(0)).intValue();
                        int intValue2 = ((Integer) c4.get(1)).intValue();
                        if (intValue2 < 0) {
                            g.b(cNK3, bnVar2);
                        } else if (intValue == cNK3.KFn.size() + -1) {
                            egw last2 = cNK3.KFn.getLast();
                            if (last2 == null) {
                                g.b(cNK3, bnVar2);
                            } else {
                                g.b(cNK3, last2.NgI.remove(intValue2));
                            }
                        } else {
                            egw remove = cNK3.KFn.remove(intValue);
                            cNK3.KFn.addLast(remove);
                            g.b(cNK3, remove.NgI.remove(intValue2));
                        }
                        c.a(cNK3);
                        if (gVar3.szE != null) {
                            gVar3.szE.a(activity, bnVar2, e4);
                        }
                        c2 = 'd';
                    }
                } else if ((134217728 & flags) == 134217728 && (524288 & flags) == 524288) {
                    c2 = 3;
                } else {
                    c2 = 'd';
                }
                switch (c2) {
                    case 0:
                        g gVar4 = eVar.szB;
                        bo cNK4 = c.cNK();
                        bn e5 = g.e(cNK4);
                        if (g.b(cNK4)) {
                            g.a(cNK4, bnVar2, false);
                        } else {
                            g.b(cNK4, bnVar2);
                        }
                        c.a(cNK4);
                        if (gVar4.szE != null) {
                            gVar4.szE.a(activity, bnVar2, e5);
                        }
                        AppMethodBeat.o(220417);
                        return;
                    case 1:
                        g gVar5 = eVar.szB;
                        bo cNK5 = c.cNK();
                        bn e6 = g.e(cNK5);
                        if (g.b(cNK5)) {
                            g.a(cNK5, bnVar2, false);
                        } else {
                            bn c5 = g.c(cNK5);
                            if (c5 == null || !h.a(bnVar2.KFh, c5.KFh)) {
                                g.b(cNK5, bnVar2);
                            }
                        }
                        c.a(cNK5);
                        if (gVar5.szE != null) {
                            gVar5.szE.a(activity, bnVar2, e6);
                        }
                        AppMethodBeat.o(220417);
                        return;
                    case 2:
                        g gVar6 = eVar.szB;
                        bo cNK6 = c.cNK();
                        bn e7 = g.e(cNK6);
                        if (g.b(cNK6)) {
                            g.a(cNK6, bnVar2, false);
                        } else {
                            c<Integer, Integer> c6 = g.c(cNK6, bnVar2);
                            int intValue3 = ((Integer) c6.get(0)).intValue();
                            int intValue4 = ((Integer) c6.get(1)).intValue();
                            if (intValue4 < 0) {
                                g.b(cNK6, bnVar2);
                            } else {
                                if (!(intValue3 == cNK6.KFn.size() + -1)) {
                                    c3 = 2;
                                } else if (intValue4 == cNK6.KFn.getLast().NgI.size() + -1) {
                                    c3 = 0;
                                } else {
                                    c3 = 1;
                                }
                                if (c3 == 1) {
                                    gVar6.a(cNK6, intValue4 + 1, bnVar2);
                                }
                                if (c3 == 2) {
                                    gVar6.b(cNK6, intValue3 + 1, bnVar2);
                                    gVar6.a(cNK6, intValue4 + 1, bnVar2);
                                }
                            }
                        }
                        c.a(cNK6);
                        if (gVar6.szE != null) {
                            gVar6.szE.a(activity, bnVar2, e7);
                        }
                        AppMethodBeat.o(220417);
                        return;
                    case 3:
                        g gVar7 = eVar.szB;
                        bo cNK7 = c.cNK();
                        bn e8 = g.e(cNK7);
                        LinkedList<egw> d2 = g.d(cNK7);
                        if (d2 == null) {
                            g.a(cNK7, bnVar2, true);
                        } else {
                            boolean z3 = false;
                            for (int size2 = d2.size() - 1; size2 >= 0; size2--) {
                                egw egw3 = d2.get(size2);
                                if (egw3 != null && egw3.NgH) {
                                    int size3 = egw3.NgI.size() - 1;
                                    while (true) {
                                        if (size3 >= 0) {
                                            bn bnVar3 = egw3.NgI.get(size3);
                                            if (bnVar3 == null || !h.a(bnVar2.KFh, bnVar3.KFh)) {
                                                size3--;
                                            } else {
                                                d2.addLast(d2.remove(size2));
                                                z2 = true;
                                            }
                                        }
                                    }
                                    z3 = z2;
                                }
                                z2 = z3;
                                z3 = z2;
                            }
                            if (!z3) {
                                g.a(cNK7, bnVar2, true);
                            }
                        }
                        c.a(cNK7);
                        if (gVar7.szE != null) {
                            gVar7.szE.a(activity, bnVar2, e8);
                        }
                        AppMethodBeat.o(220417);
                        return;
                    case 'e':
                        g gVar8 = eVar.szB;
                        bo cNK8 = c.cNK();
                        bn e9 = g.e(cNK8);
                        g.a(cNK8, bnVar2, false);
                        c.a(cNK8);
                        if (gVar8.szE != null) {
                            gVar8.szE.a(activity, bnVar2, e9);
                            break;
                        }
                        break;
                }
            } else {
                Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: aName=null, action: %s", intent.getAction());
                AppMethodBeat.o(220417);
                return;
            }
        }
        AppMethodBeat.o(220417);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(int i2, String str, String str2, String str3, int i3, long j2) {
        char c2;
        boolean z;
        boolean z2;
        char c3;
        AppMethodBeat.i(220418);
        e eVar = this.szA;
        if (TextUtils.isEmpty(str3)) {
            Log.e("HABBYGE-MALI.ActivityStackWrapper", "push: toActivity is NULL");
            AppMethodBeat.o(220418);
            return;
        }
        if (!(i3 <= 0)) {
            c<bo, bn> cNS = g.cNS();
            bo boVar = (bo) cNS.get(0);
            bn bnVar = (bn) cNS.get(1);
            if (bnVar != null && bnVar.KFh != null && bnVar.KFh.activityName.equals(str3) && bnVar.KFh.aHK <= 0) {
                bnVar.KFh.aHK = i3;
                c.a(boVar);
                AppMethodBeat.o(220418);
                return;
            }
        }
        bn bnVar2 = new bn();
        bnVar2.KFh = new eih();
        bnVar2.KFh.activityName = str3;
        bnVar2.KFh.timestamp = j2;
        if (!TextUtils.isEmpty(str)) {
            bnVar2.KFk = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            bnVar2.KFj = str2;
        }
        bnVar2.KFh.aHK = i3;
        bnVar2.flags = i2;
        bnVar2.state = a.CREATE.value;
        if (i2 == 0) {
            c2 = 0;
        } else if ((268435456 & i2) == 268435456) {
            int i4 = bnVar2.flags;
            if ((134217728 & i4) == 134217728) {
                c2 = 3;
            } else if ((32768 & i4) == 32768) {
                g gVar = eVar.szB;
                if (!TextUtils.isEmpty(bnVar2.KFh.activityName)) {
                    bo cNK = c.cNK();
                    bn e2 = g.e(cNK);
                    c<egw, Integer> a2 = g.a(cNK, bnVar2);
                    if (a2 == null) {
                        c2 = 'e';
                    } else {
                        egw egw = (egw) a2.get(0);
                        egw.NgI.clear();
                        egw.NgH = false;
                        egw.NgI.addLast(bnVar2);
                        c.a(cNK);
                        if (gVar.szE != null) {
                            gVar.szE.a(bnVar2, e2);
                        }
                    }
                }
                c2 = 'd';
            } else if ((i4 & 67108864) == 67108864) {
                c2 = 2;
            } else {
                g gVar2 = eVar.szB;
                if (TextUtils.isEmpty(bnVar2.KFh.activityName)) {
                    z = false;
                } else {
                    bo cNK2 = c.cNK();
                    bn e3 = g.e(cNK2);
                    c<egw, Integer> a3 = g.a(cNK2, bnVar2);
                    if (a3 == null) {
                        z = false;
                    } else {
                        egw egw2 = (egw) a3.get(0);
                        cNK2.KFn.remove(((Integer) a3.get(1)).intValue());
                        cNK2.KFn.addLast(egw2);
                        bn last = egw2.NgI.getLast();
                        if (last != null && !h.a(last.KFh, bnVar2.KFh)) {
                            int size = egw2.NgI.size() - 1;
                            while (size >= 0 && !h.a(egw2.NgI.get(size).KFh, bnVar2.KFh)) {
                                egw2.NgI.remove(size);
                                size--;
                            }
                        }
                        c.a(cNK2);
                        if (gVar2.szE != null) {
                            gVar2.szE.a(bnVar2, e3);
                        }
                        z = true;
                    }
                }
                c2 = !z ? 'e' : 'd';
            }
        } else if ((67108864 & i2) == 67108864) {
            c2 = 2;
        } else if ((536870912 & i2) == 536870912) {
            c2 = 1;
        } else if ((131072 & i2) == 131072) {
            if ((67108864 & i2) == 67108864) {
                c2 = 2;
            } else {
                g gVar3 = eVar.szB;
                bo cNK3 = c.cNK();
                bn e4 = g.e(cNK3);
                c<Integer, Integer> c4 = g.c(cNK3, bnVar2);
                int intValue = ((Integer) c4.get(0)).intValue();
                int intValue2 = ((Integer) c4.get(1)).intValue();
                if (intValue2 < 0) {
                    g.b(cNK3, bnVar2);
                } else if (intValue == cNK3.KFn.size() + -1) {
                    egw last2 = cNK3.KFn.getLast();
                    if (last2 == null) {
                        g.b(cNK3, bnVar2);
                    } else {
                        g.b(cNK3, last2.NgI.remove(intValue2));
                    }
                } else {
                    egw remove = cNK3.KFn.remove(intValue);
                    cNK3.KFn.addLast(remove);
                    g.b(cNK3, remove.NgI.remove(intValue2));
                }
                c.a(cNK3);
                if (gVar3.szE != null) {
                    gVar3.szE.a(bnVar2, e4);
                }
                c2 = 'd';
            }
        } else if ((134217728 & i2) == 134217728 && (524288 & i2) == 524288) {
            c2 = 3;
        } else {
            c2 = 'd';
        }
        switch (c2) {
            case 0:
                g gVar4 = eVar.szB;
                bo cNK4 = c.cNK();
                bn e5 = g.e(cNK4);
                if (g.b(cNK4)) {
                    g.a(cNK4, bnVar2, false);
                } else {
                    g.b(cNK4, bnVar2);
                }
                c.a(cNK4);
                if (gVar4.szE != null) {
                    gVar4.szE.a(bnVar2, e5);
                }
                AppMethodBeat.o(220418);
                return;
            case 1:
                g gVar5 = eVar.szB;
                bo cNK5 = c.cNK();
                bn e6 = g.e(cNK5);
                if (g.b(cNK5)) {
                    g.a(cNK5, bnVar2, false);
                } else {
                    bn c5 = g.c(cNK5);
                    if (c5 == null || !h.a(bnVar2.KFh, c5.KFh)) {
                        g.b(cNK5, bnVar2);
                    }
                }
                c.a(cNK5);
                if (gVar5.szE != null) {
                    gVar5.szE.a(bnVar2, e6);
                }
                AppMethodBeat.o(220418);
                return;
            case 2:
                g gVar6 = eVar.szB;
                bo cNK6 = c.cNK();
                bn e7 = g.e(cNK6);
                if (g.b(cNK6)) {
                    g.a(cNK6, bnVar2, false);
                } else {
                    c<Integer, Integer> c6 = g.c(cNK6, bnVar2);
                    int intValue3 = ((Integer) c6.get(0)).intValue();
                    int intValue4 = ((Integer) c6.get(1)).intValue();
                    if (intValue4 < 0) {
                        g.b(cNK6, bnVar2);
                    } else {
                        if (!(intValue3 == cNK6.KFn.size() + -1)) {
                            c3 = 2;
                        } else if (intValue4 == cNK6.KFn.getLast().NgI.size() + -1) {
                            c3 = 0;
                        } else {
                            c3 = 1;
                        }
                        if (c3 == 1) {
                            gVar6.a(cNK6, intValue4 + 1, bnVar2);
                        }
                        if (c3 == 2) {
                            gVar6.b(cNK6, intValue3 + 1, bnVar2);
                            gVar6.a(cNK6, intValue4 + 1, bnVar2);
                        }
                    }
                }
                c.a(cNK6);
                if (gVar6.szE != null) {
                    gVar6.szE.a(bnVar2, e7);
                }
                AppMethodBeat.o(220418);
                return;
            case 3:
                g gVar7 = eVar.szB;
                bo cNK7 = c.cNK();
                bn e8 = g.e(cNK7);
                LinkedList<egw> d2 = g.d(cNK7);
                if (d2 == null) {
                    g.a(cNK7, bnVar2, true);
                } else {
                    boolean z3 = false;
                    for (int size2 = d2.size() - 1; size2 >= 0; size2--) {
                        egw egw3 = d2.get(size2);
                        if (egw3 != null && egw3.NgH) {
                            int size3 = egw3.NgI.size() - 1;
                            while (true) {
                                if (size3 >= 0) {
                                    bn bnVar3 = egw3.NgI.get(size3);
                                    if (bnVar3 == null || !h.a(bnVar2.KFh, bnVar3.KFh)) {
                                        size3--;
                                    } else {
                                        d2.addLast(d2.remove(size2));
                                        z2 = true;
                                    }
                                }
                            }
                            z3 = z2;
                        }
                        z2 = z3;
                        z3 = z2;
                    }
                    if (!z3) {
                        g.a(cNK7, bnVar2, true);
                    }
                }
                c.a(cNK7);
                if (gVar7.szE != null) {
                    gVar7.szE.a(bnVar2, e8);
                }
                AppMethodBeat.o(220418);
                return;
            case 'e':
                g gVar8 = eVar.szB;
                bo cNK8 = c.cNK();
                bn e9 = g.e(cNK8);
                g.a(cNK8, bnVar2, false);
                c.a(cNK8);
                if (gVar8.szE != null) {
                    gVar8.szE.a(bnVar2, e9);
                    break;
                }
                break;
        }
        AppMethodBeat.o(220418);
    }

    public static void L(String str, String str2, int i2) {
        AppMethodBeat.i(220420);
        if (str == null || str2 == null) {
            AppMethodBeat.o(220420);
            return;
        }
        bo cNK = c.cNK();
        if (!(cNK.KFo == null || cNK.KFo.KFd == null || !str.equals(cNK.KFo.KFd.KFh.activityName))) {
            cNK.KFo.KFd.KFi = str2;
            cNK.KFo.KFd.KFm = i2;
        }
        c<Integer, Integer> a2 = g.a(cNK, str);
        int intValue = ((Integer) a2.get(0)).intValue();
        int intValue2 = ((Integer) a2.get(1)).intValue();
        if (intValue < 0 || intValue2 < 0) {
            AppMethodBeat.o(220420);
            return;
        }
        bn bnVar = cNK.KFn.get(intValue).NgI.get(intValue2);
        bnVar.KFi = str2;
        bnVar.KFm = i2;
        c.a(cNK);
        AppMethodBeat.o(220420);
    }

    public static void M(String str, String str2, int i2) {
        AppMethodBeat.i(220421);
        if (str == null || str2 == null) {
            AppMethodBeat.o(220421);
        } else if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNT() == 8) {
            AppMethodBeat.o(220421);
        } else {
            bo cNK = c.cNK();
            if (!(cNK.KFo == null || cNK.KFo.KFe == null || !str.equals(cNK.KFo.KFe.KFh.activityName))) {
                cNK.KFo.KFe.KFi = str2;
                cNK.KFo.KFe.KFm = i2;
            }
            c<Integer, Integer> a2 = g.a(cNK, str);
            int intValue = ((Integer) a2.get(0)).intValue();
            int intValue2 = ((Integer) a2.get(1)).intValue();
            if (intValue < 0 || intValue2 < 0) {
                AppMethodBeat.o(220421);
                return;
            }
            cNK.KFn.get(intValue).NgI.get(intValue2).KFj = str2;
            c.a(cNK);
            AppMethodBeat.o(220421);
        }
    }

    public static void apb(String str) {
        boolean z;
        AppMethodBeat.i(220419);
        if (!TextUtils.isEmpty(str)) {
            bo cNK = c.cNK();
            if (cNK == null || cNK.KFn.isEmpty() || TextUtils.isEmpty(str)) {
                z = false;
            } else {
                egw last = cNK.KFn.getLast();
                if (last == null) {
                    z = false;
                } else if (last.NgI.isEmpty()) {
                    z = false;
                } else {
                    bn last2 = last.NgI.getLast();
                    if (last2 == null) {
                        z = false;
                    } else if (last2.KFh.activityName.equals(str)) {
                        z = false;
                    } else {
                        c<Integer, Integer> a2 = g.a(cNK, str);
                        int intValue = ((Integer) a2.get(0)).intValue();
                        int intValue2 = ((Integer) a2.get(1)).intValue();
                        if (intValue < 0) {
                            z = false;
                        } else {
                            egw remove = cNK.KFn.remove(intValue);
                            int size = remove.NgI.size();
                            if (intValue2 < size - 1) {
                                for (int i2 = size - 1; i2 > intValue2; i2--) {
                                    remove.NgI.remove(i2);
                                }
                            }
                            cNK.KFn.addLast(remove);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                c.a(cNK);
            }
        }
        AppMethodBeat.o(220419);
    }

    public static void a(String str, int i2, a aVar) {
        AppMethodBeat.i(220422);
        bo cNK = c.cNK();
        if (cNK.KFo == null) {
            cNK.KFo = new bm();
        }
        switch (b.AnonymousClass1.szy[aVar.ordinal()]) {
            case 1:
                if (cNK.KFo.KFc == null) {
                    cNK.KFo.KFc = new bn();
                }
                if (cNK.KFo.KFc.KFh == null) {
                    cNK.KFo.KFc.KFh = new eih();
                }
                cNK.KFo.KFc.KFh.activityName = str;
                cNK.KFo.KFc.KFh.aHK = i2;
                cNK.KFo.KFc.state = a.CREATE.value;
                break;
            case 2:
                if (cNK.KFo.KFd == null) {
                    cNK.KFo.KFd = new bn();
                }
                if (cNK.KFo.KFd.KFh == null) {
                    cNK.KFo.KFd.KFh = new eih();
                }
                cNK.KFo.KFd.KFh.activityName = str;
                cNK.KFo.KFd.KFh.aHK = i2;
                cNK.KFo.KFd.state = a.RESUME.value;
                break;
            case 3:
                if (cNK.KFo.KFe == null) {
                    cNK.KFo.KFe = new bn();
                }
                if (cNK.KFo.KFe.KFh == null) {
                    cNK.KFo.KFe.KFh = new eih();
                }
                cNK.KFo.KFe.KFh.activityName = str;
                cNK.KFo.KFe.KFh.aHK = i2;
                cNK.KFo.KFe.state = a.PAUSE.value;
                break;
            case 4:
                if (cNK.KFo.KFf == null) {
                    cNK.KFo.KFf = new bn();
                }
                if (cNK.KFo.KFf.KFh == null) {
                    cNK.KFo.KFf.KFh = new eih();
                }
                cNK.KFo.KFf.KFh.activityName = str;
                cNK.KFo.KFf.KFh.aHK = i2;
                cNK.KFo.KFf.state = a.STOP.value;
                break;
        }
        c.a(cNK);
        AppMethodBeat.o(220422);
    }

    public static c<String, Integer> cNN() {
        AppMethodBeat.i(121892);
        bo cNK = c.cNK();
        if (cNK.KFo == null) {
            c<String, Integer> Q = a.Q(null, null);
            AppMethodBeat.o(121892);
            return Q;
        } else if (cNK.KFo.KFc == null) {
            c<String, Integer> Q2 = a.Q(null, null);
            AppMethodBeat.o(121892);
            return Q2;
        } else {
            c<String, Integer> Q3 = a.Q(cNK.KFo.KFc.KFh.activityName, Integer.valueOf(cNK.KFo.KFc.KFh.aHK));
            AppMethodBeat.o(121892);
            return Q3;
        }
    }

    public static c<String, Integer> cNO() {
        AppMethodBeat.i(121893);
        bo cNK = c.cNK();
        if (cNK.KFo == null) {
            c<String, Integer> Q = a.Q(null, null);
            AppMethodBeat.o(121893);
            return Q;
        } else if (cNK.KFo.KFd == null) {
            c<String, Integer> Q2 = a.Q(null, null);
            AppMethodBeat.o(121893);
            return Q2;
        } else {
            c<String, Integer> Q3 = a.Q(cNK.KFo.KFd.KFh.activityName, Integer.valueOf(cNK.KFo.KFd.KFh.aHK));
            AppMethodBeat.o(121893);
            return Q3;
        }
    }

    public static c<String, Integer> cNP() {
        AppMethodBeat.i(121894);
        bo cNK = c.cNK();
        if (cNK.KFo == null) {
            c<String, Integer> Q = a.Q(null, null);
            AppMethodBeat.o(121894);
            return Q;
        } else if (cNK.KFo.KFe == null) {
            c<String, Integer> Q2 = a.Q(null, null);
            AppMethodBeat.o(121894);
            return Q2;
        } else {
            c<String, Integer> Q3 = a.Q(cNK.KFo.KFe.KFh.activityName, Integer.valueOf(cNK.KFo.KFe.KFh.aHK));
            AppMethodBeat.o(121894);
            return Q3;
        }
    }

    public static bn cNQ() {
        AppMethodBeat.i(121895);
        bo cNK = c.cNK();
        if (cNK.KFo == null) {
            AppMethodBeat.o(121895);
            return null;
        }
        bn bnVar = cNK.KFo.KFe;
        AppMethodBeat.o(121895);
        return bnVar;
    }
}
