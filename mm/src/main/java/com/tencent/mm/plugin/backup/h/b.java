package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.h;

public final class b {
    public String hqG;
    public h hqK = null;
    private f oQA;
    public l oQB;
    private t oQC;
    private ap oQD;
    public com.tencent.mm.pluginsdk.model.app.l oQE;
    public j oQF;
    private d oQG;
    c oQH;
    private ao oQv;
    private bv oQw;
    private i oQx;
    private bw oQy;
    private com.tencent.mm.av.i oQz;
    public int uin = 0;

    public final void cx(String str, int i2) {
        AppMethodBeat.i(21745);
        Log.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", str, Integer.valueOf(i2), Util.getStack());
        this.uin = i2;
        this.hqG = str;
        bg.aVF();
        this.hqK = com.tencent.mm.model.c.getDataDB();
        bg.aVF();
        this.oQv = com.tencent.mm.model.c.azQ();
        bg.aVF();
        this.oQw = com.tencent.mm.model.c.aSN();
        bg.aVF();
        this.oQy = com.tencent.mm.model.c.aST();
        bg.aVF();
        this.oQx = com.tencent.mm.model.c.aSQ();
        bg.aVF();
        this.oQB = com.tencent.mm.model.c.aSW();
        this.oQz = q.bcR();
        this.oQA = k.getEmojiStorageMgr().OpN;
        this.oQD = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
        this.oQC = o.bhj();
        this.oQE = a.eAT();
        this.oQF = a.eAS();
        this.oQG = a.cgO();
        bg.aVF();
        this.oQH = com.tencent.mm.model.c.aTq();
        AppMethodBeat.o(21745);
    }

    public final ao azQ() {
        AppMethodBeat.i(21746);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21746);
            throw bVar;
        }
        ao aoVar = this.oQv;
        AppMethodBeat.o(21746);
        return aoVar;
    }

    public final bv aSN() {
        AppMethodBeat.i(21747);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21747);
            throw bVar;
        }
        bv bvVar = this.oQw;
        AppMethodBeat.o(21747);
        return bvVar;
    }

    public final i aSQ() {
        AppMethodBeat.i(21748);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21748);
            throw bVar;
        }
        i iVar = this.oQx;
        AppMethodBeat.o(21748);
        return iVar;
    }

    public final bw aST() {
        AppMethodBeat.i(21749);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21749);
            throw bVar;
        }
        bw bwVar = this.oQy;
        AppMethodBeat.o(21749);
        return bwVar;
    }

    public final com.tencent.mm.av.i cgM() {
        AppMethodBeat.i(21750);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21750);
            throw bVar;
        }
        com.tencent.mm.av.i iVar = this.oQz;
        AppMethodBeat.o(21750);
        return iVar;
    }

    public final f cgN() {
        AppMethodBeat.i(21751);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21751);
            throw bVar;
        }
        f fVar = this.oQA;
        AppMethodBeat.o(21751);
        return fVar;
    }

    public final ap aSX() {
        AppMethodBeat.i(21752);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21752);
            throw bVar;
        }
        ap apVar = this.oQD;
        AppMethodBeat.o(21752);
        return apVar;
    }

    public final t bhj() {
        AppMethodBeat.i(21753);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21753);
            throw bVar;
        }
        t tVar = this.oQC;
        AppMethodBeat.o(21753);
        return tVar;
    }

    public final String bij() {
        AppMethodBeat.i(21754);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21754);
            throw bVar;
        }
        String str = this.hqG + "voice/";
        AppMethodBeat.o(21754);
        return str;
    }

    public final String aTa() {
        AppMethodBeat.i(21755);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21755);
            throw bVar;
        }
        String str = this.hqG + "voice2/";
        AppMethodBeat.o(21755);
        return str;
    }

    public final d cgO() {
        AppMethodBeat.i(21756);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(21756);
            throw bVar;
        }
        d dVar = this.oQG;
        AppMethodBeat.o(21756);
        return dVar;
    }
}
