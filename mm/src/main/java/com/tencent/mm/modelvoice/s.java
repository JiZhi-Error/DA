package com.tencent.mm.modelvoice;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.m;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class s {
    public static volatile HashMap<String, Integer> jvA = new HashMap<>();
    public static volatile HashMap<String, Integer> jvB = new HashMap<>();
    private static final HashMap<String, WeakReference<m>> jvy = new HashMap<>();
    public static volatile HashMap<String, Integer> jvz = new HashMap<>();

    static {
        AppMethodBeat.i(148492);
        AppMethodBeat.o(148492);
    }

    public static boolean Re(String str) {
        AppMethodBeat.i(148455);
        if (str == null) {
            AppMethodBeat.o(148455);
            return false;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148455);
            return false;
        } else if (Rr.jsp >= 250) {
            AppMethodBeat.o(148455);
            return false;
        } else {
            Rr.jsp++;
            Rr.cSx = 8192;
            boolean a2 = a(Rr);
            AppMethodBeat.o(148455);
            return a2;
        }
    }

    public static int ui(int i2) {
        return ((i2 - 6) / 32) * 20;
    }

    public static b bE(String str, String str2) {
        AppMethodBeat.i(148456);
        w bib = o.bib();
        String fullPath = getFullPath(str2);
        switch (Util.getInt(str, -1)) {
            case 1:
                if (bib.jvL.get(fullPath) == null) {
                    bib.jvL.put(fullPath, new n(fullPath));
                }
                n nVar = bib.jvL.get(fullPath);
                AppMethodBeat.o(148456);
                return nVar;
            case 2:
            case 3:
            default:
                if (bib.jvK.get(fullPath) == null) {
                    bib.jvK.put(fullPath, new a(fullPath));
                }
                a aVar = bib.jvK.get(fullPath);
                AppMethodBeat.o(148456);
                return aVar;
            case 4:
                if (bib.jvM.get(fullPath) == null) {
                    bib.jvM.put(fullPath, new j(fullPath));
                }
                j jVar = bib.jvM.get(fullPath);
                AppMethodBeat.o(148456);
                return jVar;
        }
    }

    public static b Rf(String str) {
        AppMethodBeat.i(148457);
        w bib = o.bib();
        String fullPath = getFullPath(str);
        switch (q.Rc(str)) {
            case 0:
                if (bib.jvK.get(fullPath) == null) {
                    bib.jvK.put(fullPath, new a(fullPath));
                }
                a aVar = bib.jvK.get(fullPath);
                AppMethodBeat.o(148457);
                return aVar;
            case 1:
                if (bib.jvL.get(fullPath) == null) {
                    bib.jvL.put(fullPath, new n(fullPath));
                }
                n nVar = bib.jvL.get(fullPath);
                AppMethodBeat.o(148457);
                return nVar;
            case 2:
                if (bib.jvM.get(fullPath) == null) {
                    bib.jvM.put(fullPath, new j(fullPath));
                }
                j jVar = bib.jvM.get(fullPath);
                AppMethodBeat.o(148457);
                return jVar;
            default:
                if (bib.jvK.get(fullPath) == null) {
                    bib.jvK.put(fullPath, new a(fullPath));
                }
                a aVar2 = bib.jvK.get(fullPath);
                AppMethodBeat.o(148457);
                return aVar2;
        }
    }

    private static void Rg(String str) {
        AppMethodBeat.i(148458);
        w bib = o.bib();
        String fullPath = getFullPath(str);
        switch (q.Rc(str)) {
            case 0:
                a aVar = bib.jvK.get(fullPath);
                if (aVar != null) {
                    aVar.bhP();
                    bib.jvK.remove(fullPath);
                }
                AppMethodBeat.o(148458);
                return;
            case 1:
                n nVar = bib.jvL.get(fullPath);
                if (nVar != null) {
                    nVar.bhP();
                    bib.jvL.remove(fullPath);
                }
                AppMethodBeat.o(148458);
                return;
            case 2:
                j jVar = bib.jvM.get(fullPath);
                if (jVar != null) {
                    jVar.bhP();
                    bib.jvM.remove(fullPath);
                }
                AppMethodBeat.o(148458);
                return;
            default:
                a aVar2 = bib.jvK.get(fullPath);
                if (aVar2 != null) {
                    aVar2.bhP();
                    bib.jvK.remove(fullPath);
                }
                AppMethodBeat.o(148458);
                return;
        }
    }

    public static String getFullPath(String str) {
        AppMethodBeat.i(148459);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148459);
            return null;
        }
        String Y = Y(str, false);
        AppMethodBeat.o(148459);
        return Y;
    }

    public static String Y(String str, boolean z) {
        AppMethodBeat.i(148460);
        f.a aVar = new f.a();
        String genPath = FilePathGenerator.genPath(aTa(), "msg_", str, ".amr", 2);
        Log.i("MicroMsg.VoiceLogic", "getAmrFullPath cost: " + aVar.apr() + " " + genPath);
        if (Util.isNullOrNil(genPath)) {
            AppMethodBeat.o(148460);
            return null;
        } else if (z) {
            AppMethodBeat.o(148460);
            return genPath;
        } else if (new o(genPath).exists()) {
            AppMethodBeat.o(148460);
            return genPath;
        } else {
            String str2 = bij() + str;
            if (new o(str2 + ".amr").exists()) {
                com.tencent.mm.vfs.s.nx(str2 + ".amr", genPath);
            } else if (new o(str2).exists()) {
                com.tencent.mm.vfs.s.nx(str2, genPath);
            }
            AppMethodBeat.o(148460);
            return genPath;
        }
    }

    public static String Rh(String str) {
        AppMethodBeat.i(148461);
        String Rq = w.Rq(z.aTY());
        r rVar = new r();
        rVar.fileName = Rq;
        rVar.dWq = str;
        rVar.createTime = System.currentTimeMillis() / 1000;
        rVar.clientId = Rq;
        rVar.jsm = System.currentTimeMillis() / 1000;
        rVar.status = 1;
        rVar.jsh = z.aTY();
        rVar.cSx = -1;
        if (!o.bib().b(rVar)) {
            AppMethodBeat.o(148461);
            return null;
        }
        Log.i("MicroMsg.VoiceLogic", "startRecord insert voicestg success");
        AppMethodBeat.o(148461);
        return Rq;
    }

    public static boolean a(String str, m mVar) {
        AppMethodBeat.i(148462);
        if (str == null) {
            AppMethodBeat.o(148462);
            return false;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            Log.d("MicroMsg.VoiceLogic", "startSend null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(148462);
            return false;
        } else if (Rr.status != 1) {
            AppMethodBeat.o(148462);
            return false;
        } else {
            Rr.status = 2;
            Rr.cSx = 64;
            synchronized (jvy) {
                try {
                    jvy.put(str, new WeakReference<>(mVar));
                } catch (Throwable th) {
                    AppMethodBeat.o(148462);
                    throw th;
                }
            }
            boolean a2 = a(Rr);
            AppMethodBeat.o(148462);
            return a2;
        }
    }

    public static boolean Ri(String str) {
        AppMethodBeat.i(148463);
        if (str == null) {
            AppMethodBeat.o(148463);
            return false;
        }
        Log.d("MicroMsg.VoiceLogic", "Mark Canceled fileName[" + str + "]");
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148463);
            return false;
        }
        Rr.status = 8;
        Rr.iKP = q.Qy(str);
        Rr.cSx = 96;
        boolean a2 = a(Rr);
        AppMethodBeat.o(148463);
        return a2;
    }

    public static boolean Rj(String str) {
        AppMethodBeat.i(148464);
        if (str == null) {
            AppMethodBeat.o(148464);
            return false;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            Log.d("MicroMsg.VoiceLogic", "cancel null download : ".concat(String.valueOf(str)));
            AppMethodBeat.o(148464);
            return true;
        }
        Log.d("MicroMsg.VoiceLogic", "cancel download : " + str + " SvrlId:" + Rr.dTS);
        if (Rr.dTS != 0) {
            ((l) g.af(l.class)).eiy().aT(Rr.dWq, Rr.dTS);
        }
        boolean Rl = Rl(str);
        AppMethodBeat.o(148464);
        return Rl;
    }

    public static boolean Rk(String str) {
        AppMethodBeat.i(148465);
        if (str == null) {
            AppMethodBeat.o(148465);
            return false;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            Log.i("MicroMsg.VoiceLogic", "cancel null record : ".concat(String.valueOf(str)));
            AppMethodBeat.o(148465);
            return true;
        }
        Log.i("MicroMsg.VoiceLogic", "cancel record : " + str + " LocalId:" + Rr.jso);
        if (Rr.jso != 0) {
            ((l) g.af(l.class)).eiy().Hc((long) Rr.jso);
        }
        boolean Rl = Rl(str);
        AppMethodBeat.o(148465);
        return Rl;
    }

    public static boolean Rl(String str) {
        AppMethodBeat.i(148466);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148466);
            return false;
        }
        o.bib().gC(str);
        Rg(str);
        String fullPath = getFullPath(str);
        if (Util.isNullOrNil(fullPath)) {
            AppMethodBeat.o(148466);
            return false;
        }
        boolean delete = new o(fullPath).delete();
        AppMethodBeat.o(148466);
        return delete;
    }

    public static boolean aB(String str, int i2) {
        AppMethodBeat.i(148467);
        boolean v = v(str, i2, 0);
        AppMethodBeat.o(148467);
        return v;
    }

    private static boolean v(String str, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(148468);
        if (str == null) {
            AppMethodBeat.o(148468);
        } else {
            Log.d("MicroMsg.VoiceLogic", "StopRecord fileName[" + str + "], fullPath[" + getFullPath(str) + "]");
            r Rr = o.bib().Rr(str);
            if (Rr == null) {
                AppMethodBeat.o(148468);
            } else {
                if (!(Rr.status == 97 || Rr.status == 98)) {
                    Rr.status = 3;
                }
                Rr.iKP = q.Qy(str);
                if (Rr.iKP <= 0) {
                    QE(str);
                    AppMethodBeat.o(148468);
                } else {
                    Rr.jsm = System.currentTimeMillis() / 1000;
                    Rr.jvt = i2;
                    Rr.cSx = 3424;
                    ca caVar = new ca();
                    caVar.Cy(Rr.dWq);
                    caVar.setType(34);
                    caVar.nv(1);
                    caVar.Cz(str);
                    if (Rr.status == 97) {
                        caVar.setStatus(2);
                        caVar.setContent(p.b(Rr.jsh, (long) Rr.jvt, false));
                    } else if (Rr.status == 98) {
                        caVar.setStatus(5);
                        caVar.setContent(p.b(Rr.jsh, -1, true));
                    } else {
                        caVar.setStatus(1);
                        caVar.setContent(p.b(Rr.jsh, (long) Rr.jvt, false));
                    }
                    caVar.setCreateTime(bp.Kw(Rr.dWq));
                    caVar.akm(i3);
                    a.C0409a.anC().n(caVar);
                    Rr.jso = (int) bp.x(caVar);
                    z = a(Rr);
                    synchronized (jvy) {
                        try {
                            jvy.remove(str);
                        } finally {
                            AppMethodBeat.o(148468);
                        }
                    }
                }
            }
        }
        return z;
    }

    public static int a(String str, int i2, long j2, String str2, int i3, int i4) {
        AppMethodBeat.i(148469);
        if (str == null) {
            AppMethodBeat.o(148469);
            return -1;
        }
        Log.d("MicroMsg.VoiceLogic", "dkmsgid UpdateAfterSend file:[" + str + "] newOff:" + i2 + " SvrID:" + j2 + " clientID:" + str2 + " hasSendEndFlag " + i3);
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148469);
            return -1;
        }
        Rr.jqP = i2;
        Rr.jsm = System.currentTimeMillis() / 1000;
        Rr.cSx = 264;
        if (Util.isNullOrNil(Rr.clientId) && str2 != null) {
            Rr.clientId = str2;
            Rr.cSx |= 512;
        }
        if (Rr.dTS == 0 && j2 != 0) {
            Rr.dTS = j2;
            Rr.cSx |= 4;
        }
        int i5 = 0;
        if (Rr.iKP <= i2 && Rr.status == 3 && i3 == 1) {
            Rr.status = 99;
            Rr.cSx |= 64;
            ca Hb = ((l) g.af(l.class)).eiy().Hb((long) Rr.jso);
            Hb.Cy(Rr.dWq);
            Hb.yF(Rr.dTS);
            Hb.setStatus(2);
            Hb.setContent(p.b(Rr.jsh, (long) Rr.jvt, false));
            Hb.akm(i4);
            Integer num = jvz.get(getFullPath(str));
            if (num != null) {
                Rr.jvw = num.intValue();
                Rr.cSx |= 524288;
            }
            ((l) g.af(l.class)).eiy().a((long) Rr.jso, Hb);
            Log.d("MicroMsg.VoiceLogic", "END!!! updateSend  file:" + str + " total:" + Rr.iKP + " status:" + Rr.status + " netTimes:" + Rr.jsp + " msgId:" + Hb.field_msgId);
            i5 = 1;
            Rg(str);
        }
        if (!a(Rr)) {
            AppMethodBeat.o(148469);
            return -4;
        }
        AppMethodBeat.o(148469);
        return i5;
    }

    public static synchronized int b(int i2, byte[] bArr, int i3) {
        int i4;
        synchronized (s.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    i4 = i2;
                    for (int i5 = 0; i5 < i3; i5++) {
                        i4 += bArr[i5 + 0];
                    }
                }
            }
            i4 = 0;
        }
        return i4;
    }

    public static int c(int i2, byte[] bArr, int i3) {
        int i4;
        AppMethodBeat.i(148470);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(148470);
        } else {
            if (i2 == 0) {
                int hashCode = bArr.hashCode() & 255;
                i4 = hashCode;
                i2 = hashCode;
            } else {
                i4 = i2 & 255;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                i2 += (bArr[i5 + 0] & i4) * 256;
            }
            AppMethodBeat.o(148470);
        }
        return i2;
    }

    public static int a(r rVar, byte[] bArr, int i2, String str, String str2, h.a aVar) {
        boolean z;
        AppMethodBeat.i(148473);
        f.a aVar2 = new f.a();
        r AP = o.bib().AP(rVar.dTS);
        if (AP != null && AP.status == 99) {
            AppMethodBeat.o(148473);
            return 0;
        } else if (((l) g.af(l.class)).eiy().aJ(rVar.dWq, rVar.dTS).field_msgSvrId == rVar.dTS && AP == null) {
            AppMethodBeat.o(148473);
            return 0;
        } else {
            if (AP != null) {
                rVar.fileName = AP.fileName;
            } else {
                rVar.fileName = w.Rq(rVar.jsh);
            }
            rVar.cSx |= 1;
            Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + aVar2.apr());
            boolean z2 = false;
            if (bArr != null && bArr.length > 1) {
                if (AP != null) {
                    Log.e("MicroMsg.VoiceLogic", "Sync Voice Buf , But VoiceInfo is not new!");
                }
                String str3 = rVar.jui;
                String str4 = rVar.fileName;
                int write = bE(str3, str4).write(bArr, bArr.length, 0);
                if (write < 0) {
                    Log.e("MicroMsg.VoiceLogic", "Write Failed File:" + str4 + " newOffset:" + write + " voiceFormat:" + str3);
                    z = false;
                } else if (bArr.length != write) {
                    Log.e("MicroMsg.VoiceLogic", "Write File:" + str4 + " fileOff:" + write + " bufLen:" + bArr.length + " voiceFormat:" + str3);
                    z = false;
                } else {
                    Log.i("MicroMsg.VoiceLogic", "writeVoiceFile file:[" + str4 + "] + buf:" + bArr.length + " voiceFormat:" + str3);
                    Rg(str4);
                    z = true;
                }
                rVar.jvw = c(rVar.jvw, bArr, bArr.length);
                rVar.cSx |= 524288;
                z2 = z;
            }
            Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + aVar2.apr());
            rVar.jsm = System.currentTimeMillis() / 1000;
            rVar.cSx |= 256;
            if (z2) {
                rVar.status = 99;
            } else if (rVar.iKP == 0) {
                rVar.status = 5;
            } else {
                rVar.status = 6;
            }
            rVar.cSx |= 64;
            if (AP == null) {
                rVar.jso = (int) a(rVar, z2, i2, str, str2, aVar);
                if (aVar != null) {
                    rVar.fqJ = bp.d(aVar);
                    if (aVar.heO != null) {
                        rVar.jvu = aVar.heO.KHs;
                    }
                }
                Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + aVar2.apr());
                rVar.cSx = -1;
                Log.d("MicroMsg.VoiceLogic", "Insert fileName:" + rVar.fileName + " stat:" + rVar.status + " net:" + rVar.jqP + " total:" + rVar.iKP);
                if (!o.bib().b(rVar)) {
                    Log.d("MicroMsg.VoiceLogic", "Insert Error fileName:" + rVar.fileName + " stat:" + rVar.status + " net:" + rVar.jqP + " total:" + rVar.iKP);
                    AppMethodBeat.o(148473);
                    return -2;
                }
                Log.d("MicroMsg.VoiceLogic", f.apq() + "checktime :" + aVar2.apr());
                if (z2) {
                    AppMethodBeat.o(148473);
                    return 1;
                }
            } else {
                Log.d("MicroMsg.VoiceLogic", "Sync Update file:" + rVar.fileName + " stat:" + rVar.status);
                if (!a(rVar)) {
                    AppMethodBeat.o(148473);
                    return -44;
                } else if (z2) {
                    a(rVar, aVar);
                    AppMethodBeat.o(148473);
                    return 1;
                }
            }
            if (AP != null && AP.jsj == rVar.iKP) {
                a(AP.fileName, AP.jsj, aVar);
                Log.w("MicroMsg.VoiceLogic", "Sync TotalLen not Change (send endflag but TotoalLen == FileLen) :" + AP.fileName);
            }
            Log.i("MicroMsg.VoiceLogic", "summerbadcr setRecvSync end ret 0 and start run addMsgInfo[%s], syncWithBufSucc[%b], stack[%s]", aVar, Boolean.valueOf(z2), Util.getStack());
            o.bid().run();
            AppMethodBeat.o(148473);
            return 0;
        }
    }

    private static boolean a(r rVar, h.a aVar) {
        AppMethodBeat.i(148474);
        try {
            rVar.jso = (int) a(rVar, true, 3, "", rVar.fqK, aVar);
            rVar.cSx |= 2048;
            boolean a2 = a(rVar);
            AppMethodBeat.o(148474);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.VoiceLogic", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(148474);
            return false;
        }
    }

    private static long a(r rVar, boolean z, int i2, String str, String str2, h.a aVar) {
        ca caVar;
        long j2;
        AppMethodBeat.i(148475);
        if (((l) g.af(l.class)).eiy().Hd(rVar.dTS)) {
            Log.i("MicroMsg.VoiceLogic", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(rVar.dTS));
            if (Util.nullAsNil(rVar.fileName).length() > 0) {
                o.bib().gC(rVar.fileName);
            } else {
                Log.i("MicroMsg.VoiceLogic", "[oneliang] the length of voice info file name is zero");
            }
            AppMethodBeat.o(148475);
            return -1;
        }
        ca aJ = ((l) g.af(l.class)).eiy().aJ(rVar.dWq, rVar.dTS);
        boolean z2 = false;
        if (aJ.field_msgSvrId != rVar.dTS) {
            caVar = new ca();
            caVar.yF(rVar.dTS);
            caVar.Cz(rVar.fileName);
            caVar.setCreateTime(bp.C(rVar.dWq, rVar.createTime));
            caVar.Cy(rVar.dWq);
            caVar.nv(z.Im(rVar.jsh) ? 1 : 0);
            caVar.setType(34);
            caVar.akm(rVar.jup);
            z2 = true;
        } else {
            caVar = aJ;
        }
        if (z) {
            caVar.gDR();
        } else {
            caVar.gDQ();
        }
        caVar.CG(str);
        caVar.setStatus(i2);
        if (aVar == null) {
            int i3 = rVar.fqJ;
            if (i3 != 0) {
                Log.i("MicroMsg.VoiceLogic", "summerbadcr createMsgInfo flag has set[%d]", Integer.valueOf(i3));
                caVar.setFlag(i3);
                if (caVar.field_msgId == 0 && caVar.field_isSend == 0 && (i3 & 2) != 0) {
                    caVar.setCreateTime(bp.l(caVar.field_talker, rVar.createTime, caVar.field_msgSeq));
                }
            }
            if (rVar.jvu != 0) {
                caVar.yH((long) rVar.jvu);
            }
            Log.i("MicroMsg.VoiceLogic", "summerbadcr insert voice addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i3), Integer.valueOf(rVar.jvu));
        } else {
            bp.a(caVar, aVar);
        }
        Log.i("MicroMsg.VoiceLogic", "summerbadcr create voice msg info, msgSource : %s", str2);
        if (!Util.isNullOrNil(str2)) {
            caVar.BB(str2);
            caVar.CH(bp.Kz(str2));
        }
        if (!z) {
            caVar.setContent(p.b(rVar.jsh, (long) Math.max(rVar.jvt, 0), false));
        } else {
            caVar.setContent(p.b(rVar.jsh, (long) rVar.jvt, false));
            if (!Util.isNullOrNil(str2)) {
                caVar.BB(str2);
                caVar.CH(bp.Kz(str2));
                bp.b Ky = bp.Ky(str2);
                if (Ky != null) {
                    caVar.CH(Ky.iEs);
                    caVar.nM(Ky.iEt);
                    caVar.CC(Ky.iEr);
                    Log.i("MicroMsg.VoiceLogic", "bizClientMsgId = %s", Ky.iEr);
                    if (Ky.iEw != null) {
                        lt ltVar = new lt();
                        ltVar.dRf.dCM = caVar;
                        ltVar.dRf.dRg = Ky;
                        EventCenter.instance.publish(ltVar);
                    }
                }
            }
        }
        Log.i("MicroMsg.VoiceLogic", "summerbadcr parseVoiceMsg svrId[%d], msgseq[%d]", Long.valueOf(caVar.field_msgSvrId), Long.valueOf(caVar.field_msgSeq));
        if (z2) {
            j2 = bp.x(caVar);
        } else {
            bp.y(caVar);
            j2 = caVar.field_msgId;
        }
        if (z) {
            zb zbVar = new zb();
            zbVar.efl.msgId = caVar.field_msgId;
            zbVar.efl.success = true;
            zbVar.efl.efm = rVar.bih();
            EventCenter.instance.asyncPublish(zbVar, Looper.getMainLooper());
        }
        AppMethodBeat.o(148475);
        return j2;
    }

    public static int a(String str, int i2, h.a aVar) {
        int i3 = 0;
        AppMethodBeat.i(148476);
        if (str == null) {
            AppMethodBeat.o(148476);
            return -1;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148476);
            return -1;
        }
        Rr.jsj = i2;
        Rr.jsm = System.currentTimeMillis() / 1000;
        Rr.cSx = 272;
        if (Rr.iKP > 0 && i2 >= Rr.iKP) {
            a(Rr, aVar);
            Rr.status = 99;
            Rr.jvx = 0;
            Rr.cSx = Rr.cSx | 64 | 1048576;
            Log.i("MicroMsg.VoiceLogic", "END!!! updateRecv  file:" + str + " newsize:" + i2 + " total:" + Rr.iKP + " status:" + Rr.status + " netTimes:" + Rr.jsp);
            i3 = 1;
            Rg(str);
        }
        Log.i("MicroMsg.VoiceLogic", "updateRecv file:" + str + " newsize:" + i2 + " total:" + Rr.iKP + " status:" + Rr.status);
        if (!a(Rr)) {
            AppMethodBeat.o(148476);
            return -3;
        }
        AppMethodBeat.o(148476);
        return i3;
    }

    public static boolean uj(int i2) {
        AppMethodBeat.i(148478);
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) i2);
        if (Hb.field_msgId == 0 || Hb.field_imgPath == null) {
            AppMethodBeat.o(148478);
            return false;
        } else if (Util.isNullOrNil(Hb.field_imgPath)) {
            AppMethodBeat.o(148478);
            return false;
        } else {
            r Rr = o.bib().Rr(Hb.field_imgPath);
            if (Rr == null || Util.isNullOrNil(Rr.fileName)) {
                AppMethodBeat.o(148478);
                return false;
            }
            Rr.status = 3;
            Rr.jqP = 0;
            Rr.createTime = System.currentTimeMillis() / 1000;
            Rr.jsm = System.currentTimeMillis() / 1000;
            Rr.cSx = 8648;
            boolean a2 = a(Rr);
            Log.d("MicroMsg.VoiceLogic", " file:" + Rr.fileName + " msgid:" + Rr.jso + "  stat:" + Rr.status);
            if (Rr.jso == 0 || Util.isNullOrNil(Rr.dWq)) {
                Log.e("MicroMsg.VoiceLogic", " failed msg id:" + Rr.jso + " user:" + Rr.dWq);
                AppMethodBeat.o(148478);
                return a2;
            }
            Hb.setStatus(1);
            ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
            o.bid().run();
            AppMethodBeat.o(148478);
            return true;
        }
    }

    public static String n(String str, String str2, int i2) {
        AppMethodBeat.i(148479);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148479);
            return null;
        }
        if (!Util.isNullOrNil(str2) && !str2.startsWith("amr_") && !str2.startsWith("spx_")) {
            str2.startsWith("silk_");
        }
        String Rh = Rh(str);
        if (Util.isNullOrNil(Rh)) {
            AppMethodBeat.o(148479);
            return null;
        } else if (com.tencent.mm.vfs.s.nw(getFullPath(str2), getFullPath(Rh)) < 0) {
            AppMethodBeat.o(148479);
            return null;
        } else {
            v(Rh, i2, 1);
            AppMethodBeat.o(148479);
            return Rh;
        }
    }

    public static boolean QE(String str) {
        AppMethodBeat.i(148480);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(111, 234, 1, false);
        if (str == null) {
            AppMethodBeat.o(148480);
            return false;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            Log.e("MicroMsg.VoiceLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.o(148480);
            return false;
        }
        Rr.status = 98;
        Rr.jsm = System.currentTimeMillis() / 1000;
        Rr.cSx = 320;
        boolean a2 = a(Rr);
        Log.i("MicroMsg.VoiceLogic", "setError file:" + str + " msgid:" + Rr.jso + " old stat:" + Rr.status);
        if (Rr.jso == 0 || Util.isNullOrNil(Rr.dWq)) {
            Log.e("MicroMsg.VoiceLogic", "setError failed msg id:" + Rr.jso + " user:" + Rr.dWq);
            AppMethodBeat.o(148480);
            return a2;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) Rr.jso);
        e.INSTANCE.idkeyStat(111, 33, 1, true);
        Hb.setMsgId((long) Rr.jso);
        Hb.setStatus(5);
        Hb.Cy(Rr.dWq);
        Hb.setContent(p.b(Rr.jsh, (long) Math.max(Rr.jvt, 0), true));
        Hb.gDR();
        ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
        zb zbVar = new zb();
        zbVar.efl.msgId = Hb.field_msgId;
        zbVar.efl.success = false;
        zbVar.efl.efm = Rr.bih();
        EventCenter.instance.asyncPublish(zbVar, Looper.getMainLooper());
        AppMethodBeat.o(148480);
        return a2;
    }

    public static ca Rn(String str) {
        AppMethodBeat.i(148481);
        if (str == null) {
            AppMethodBeat.o(148481);
            return null;
        }
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148481);
            return null;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) Rr.jso);
        AppMethodBeat.o(148481);
        return Hb;
    }

    public static r Ro(String str) {
        AppMethodBeat.i(261900);
        r Rr = o.bib().Rr(str);
        AppMethodBeat.o(261900);
        return Rr;
    }

    public static List<r> bii() {
        ArrayList arrayList = null;
        AppMethodBeat.i(148483);
        w bib = o.bib();
        Cursor rawQuery = bib.iFy.rawQuery(("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo") + " WHERE Status<97 and User!=\"_USER_FOR_THROWBOTTLE_\"   order by CreateTime", null, 2);
        int i2 = 0;
        if (rawQuery.moveToFirst()) {
            arrayList = new ArrayList();
            do {
                r rVar = new r();
                rVar.convertFrom(rawQuery);
                arrayList.add(rVar);
                i2++;
            } while (rawQuery.moveToNext());
        }
        Log.d("MicroMsg.VoiceStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i2)));
        rawQuery.close();
        AppMethodBeat.o(148483);
        return arrayList;
    }

    public static boolean a(r rVar) {
        AppMethodBeat.i(148484);
        if (rVar == null) {
            AppMethodBeat.o(148484);
            return false;
        } else if (rVar.cSx == -1) {
            AppMethodBeat.o(148484);
            return false;
        } else {
            boolean a2 = o.bib().a(rVar.fileName, rVar);
            AppMethodBeat.o(148484);
            return a2;
        }
    }

    public static float AO(long j2) {
        float f2 = 60.0f;
        float f3 = 1.0f;
        AppMethodBeat.i(148485);
        float f4 = ((float) j2) / 1000.0f;
        if (f4 >= 1.0f) {
            f3 = f4;
        }
        if (f3 <= 60.0f) {
            f2 = f3;
        }
        float round = (float) Math.round(f2);
        AppMethodBeat.o(148485);
        return round;
    }

    public static boolean ai(ca caVar) {
        AppMethodBeat.i(148486);
        if (caVar == null || !caVar.gAy()) {
            AppMethodBeat.o(148486);
            return false;
        }
        boolean z = new p(caVar.field_content).jsi;
        AppMethodBeat.o(148486);
        return z;
    }

    public static boolean aj(ca caVar) {
        AppMethodBeat.i(148487);
        if (caVar == null || !caVar.gAy() || caVar.field_isSend == 1) {
            AppMethodBeat.o(148487);
            return false;
        } else if (new p(caVar.field_content).time == 0) {
            AppMethodBeat.o(148487);
            return true;
        } else {
            AppMethodBeat.o(148487);
            return false;
        }
    }

    public static void ak(ca caVar) {
        AppMethodBeat.i(148488);
        if (caVar == null || !caVar.gAy()) {
            AppMethodBeat.o(148488);
            return;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(caVar.field_msgId);
        if (Hb.field_msgId != caVar.field_msgId) {
            AppMethodBeat.o(148488);
            return;
        }
        p pVar = new p(Hb.field_content);
        if (pVar.jsi) {
            AppMethodBeat.o(148488);
            return;
        }
        pVar.jsi = true;
        caVar.setContent(pVar.bie());
        ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
        AppMethodBeat.o(148488);
    }

    public static int Rp(String str) {
        m mVar;
        AppMethodBeat.i(148489);
        synchronized (jvy) {
            try {
                if (jvy.get(str) != null && (mVar = jvy.get(str).get()) != null) {
                    return (int) mVar.aas();
                }
                AppMethodBeat.o(148489);
                return -1;
            } finally {
                AppMethodBeat.o(148489);
            }
        }
    }

    public static String bij() {
        AppMethodBeat.i(148490);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("voice/").toString();
        AppMethodBeat.o(148490);
        return sb2;
    }

    public static String aTa() {
        AppMethodBeat.i(148491);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("voice2/").toString();
        AppMethodBeat.o(148491);
        return sb2;
    }

    public static int a(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(148471);
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148471);
            return -1;
        }
        Rr.jvw = c(Rr.jvw, bArr, i2);
        Rr.cSx |= 524288;
        if (a(Rr)) {
            int i3 = Rr.jvw;
            AppMethodBeat.o(148471);
            return i3;
        }
        AppMethodBeat.o(148471);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e8 A[SYNTHETIC, Splitter:B:42:0x00e8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Rm(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.Rm(java.lang.String):boolean");
    }

    public static boolean QF(String str) {
        AppMethodBeat.i(148477);
        r Rr = o.bib().Rr(str);
        if (Rr == null) {
            AppMethodBeat.o(148477);
            return false;
        }
        if (Rr.status == 3) {
            ca Hb = ((l) g.af(l.class)).eiy().Hb((long) Rr.jso);
            Hb.setContent(p.b(Rr.jsh, (long) Rr.jvt, false));
            Hb.setStatus(2);
            ((l) g.af(l.class)).eiy().a((long) Rr.jso, Hb);
        }
        Rr.status = 97;
        Rr.jsm = System.currentTimeMillis() / 1000;
        Rr.cSx = 320;
        boolean a2 = a(Rr);
        AppMethodBeat.o(148477);
        return a2;
    }
}
