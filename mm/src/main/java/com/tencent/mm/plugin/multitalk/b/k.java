package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

public final class k {
    ArrayList<j> qsr = new ArrayList<>(10);
    ArrayList<j> qss = new ArrayList<>(10);
    final ArrayList<a> qst = new ArrayList<>(2);
    Timer qsu;
    public long zHB;
    public long zHC;
    public String zHD;
    public String zHE;
    ArrayList<j> zHF;
    public String zHG;
    public String zHH;
    public long zHI;
    public String zHJ;

    /* access modifiers changed from: package-private */
    public interface a {
        void Q(ArrayList<j> arrayList);
    }

    public k() {
        AppMethodBeat.i(239040);
        AppMethodBeat.o(239040);
    }

    /* access modifiers changed from: package-private */
    public final void amZ() {
        AppMethodBeat.i(239041);
        this.qss.clear();
        this.qsr.clear();
        this.qst.clear();
        this.zHB = 0;
        this.zHC = 0;
        this.zHD = null;
        this.zHF = null;
        this.zHG = null;
        this.zHH = null;
        elG();
        AppMethodBeat.o(239041);
    }

    /* access modifiers changed from: package-private */
    public final void hf(int i2, int i3) {
        AppMethodBeat.i(239042);
        if (this.qsr != null) {
            Iterator<j> it = this.qsr.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && next.qrD == i2) {
                    next.qtI = i3;
                }
            }
        }
        AppMethodBeat.o(239042);
    }

    /* access modifiers changed from: package-private */
    public final void be(LinkedList<acq> linkedList) {
        int i2;
        AppMethodBeat.i(239043);
        if (linkedList != null && linkedList.size() > 0) {
            Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "yuemwang videoIdList: ".concat(String.valueOf(linkedList)));
            Iterator<acq> it = linkedList.iterator();
            while (it.hasNext()) {
                acq next = it.next();
                if ((next.Lnu & 4) == 0) {
                    i2 = 103;
                } else if ((next.Lnu & 8) != 0) {
                    i2 = 102;
                } else {
                    i2 = 101;
                }
                hf(next.Lnt, i2);
            }
        }
        AppMethodBeat.o(239043);
    }

    /* access modifiers changed from: package-private */
    public final void a(ada ada, LinkedList<esc> linkedList, String str, String str2, b<String> bVar) {
        AppMethodBeat.i(239044);
        ArrayList<j> arrayList = new ArrayList<>();
        if (ada == null || ada.KHx == null || ada.KHx.size() == 0) {
            this.qsr.clear();
        } else {
            Iterator<acz> it = ada.KHx.iterator();
            while (it.hasNext()) {
                acz next = it.next();
                j jVar = new j();
                jVar.qrD = next.Lnt;
                jVar.openId = next.openid;
                jVar.mStatus = next.status;
                jVar.goe = "";
                Iterator<esc> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    esc next2 = it2.next();
                    Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "username %s, openid:%s", next2.username, next2.Npd);
                    if (next.openid.equals(next2.Npd)) {
                        jVar.goe = next2.username;
                    }
                    if (next2.username.equals(str)) {
                        jVar.zHx = str2;
                    }
                }
                arrayList.add(jVar);
                Log.i("MicroMsg.Multitalk.ILinkMemberMgr", "steve: add member, memberid:%d openid:%s, username:%s, status %d, inviteName:%s", Integer.valueOf(jVar.qrD), jVar.openId, jVar.goe, Integer.valueOf(jVar.mStatus), jVar.zHx);
            }
        }
        this.qsr = arrayList;
        this.zHF = this.qsr;
        bVar.a(0, 0, null, null);
        AppMethodBeat.o(239044);
    }

    public final synchronized ArrayList<j> elF() {
        ArrayList<j> arrayList;
        AppMethodBeat.i(239045);
        arrayList = (ArrayList) this.qsr.clone();
        AppMethodBeat.o(239045);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final String QX(int i2) {
        AppMethodBeat.i(239046);
        if (this.qsr != null) {
            Iterator<j> it = this.qsr.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && i2 == next.qrD) {
                    String str = next.goe;
                    AppMethodBeat.o(239046);
                    return str;
                }
            }
        }
        AppMethodBeat.o(239046);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final j aFx(String str) {
        AppMethodBeat.i(239047);
        if (!(this.qsr == null || str == null)) {
            Iterator<j> it = this.qsr.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next != null && next.goe.equals(str)) {
                    AppMethodBeat.o(239047);
                    return next;
                }
            }
        }
        AppMethodBeat.o(239047);
        return null;
    }

    public final int QY(int i2) {
        AppMethodBeat.i(239048);
        if (this.qsr.size() == 0) {
            AppMethodBeat.o(239048);
            return -1;
        }
        Iterator<j> it = this.qsr.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.qrD == i2) {
                int i3 = next.qtI;
                AppMethodBeat.o(239048);
                return i3;
            }
        }
        AppMethodBeat.o(239048);
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void elG() {
        AppMethodBeat.i(239049);
        synchronized (this.qst) {
            try {
                this.qst.clear();
            } finally {
                AppMethodBeat.o(239049);
            }
        }
        if (this.qsu != null) {
            this.qsu.cancel();
        }
    }

    static /* synthetic */ boolean a(k kVar, ArrayList arrayList) {
        AppMethodBeat.i(239050);
        if (kVar.qss == null) {
            AppMethodBeat.o(239050);
            return true;
        } else if (arrayList.size() != kVar.qss.size()) {
            AppMethodBeat.o(239050);
            return false;
        } else {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((j) arrayList.get(i2)).qrD != kVar.qss.get(i2).qrD) {
                    AppMethodBeat.o(239050);
                    return false;
                }
            }
            AppMethodBeat.o(239050);
            return true;
        }
    }
}
