package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;

public final class c {
    String hqG;
    public h hqK = null;
    f oQA;
    public l oQB;
    t oQC;
    ap oQD;
    public com.tencent.mm.pluginsdk.model.app.l oQE;
    public j oQF;
    d oQG;
    ao oQv;
    bv oQw;
    i oQx;
    bw oQy;
    com.tencent.mm.av.i oQz;
    ck oTh;
    g oTi = null;
    Boolean oTj = null;
    public int uin = 0;

    public final ao azQ() {
        AppMethodBeat.i(22082);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22082);
            throw bVar;
        }
        ao aoVar = this.oQv;
        AppMethodBeat.o(22082);
        return aoVar;
    }

    public final bv aSN() {
        AppMethodBeat.i(22083);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22083);
            throw bVar;
        }
        bv bvVar = this.oQw;
        AppMethodBeat.o(22083);
        return bvVar;
    }

    public final i aSQ() {
        AppMethodBeat.i(22084);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22084);
            throw bVar;
        }
        i iVar = this.oQx;
        AppMethodBeat.o(22084);
        return iVar;
    }

    public final bw aST() {
        AppMethodBeat.i(22085);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22085);
            throw bVar;
        }
        bw bwVar = this.oQy;
        AppMethodBeat.o(22085);
        return bwVar;
    }

    public final com.tencent.mm.av.i cgM() {
        AppMethodBeat.i(22086);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22086);
            throw bVar;
        }
        com.tencent.mm.av.i iVar = this.oQz;
        AppMethodBeat.o(22086);
        return iVar;
    }

    public final f cgN() {
        AppMethodBeat.i(22087);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22087);
            throw bVar;
        }
        f fVar = this.oQA;
        AppMethodBeat.o(22087);
        return fVar;
    }

    public final ap aSX() {
        AppMethodBeat.i(22088);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22088);
            throw bVar;
        }
        ap apVar = this.oQD;
        AppMethodBeat.o(22088);
        return apVar;
    }

    public final t bhj() {
        AppMethodBeat.i(22089);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22089);
            throw bVar;
        }
        t tVar = this.oQC;
        AppMethodBeat.o(22089);
        return tVar;
    }

    public final String bij() {
        AppMethodBeat.i(22090);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22090);
            throw bVar;
        }
        String str = this.hqG + "voice/";
        AppMethodBeat.o(22090);
        return str;
    }

    public final String aTa() {
        AppMethodBeat.i(22091);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22091);
            throw bVar;
        }
        String str = this.hqG + "voice2/";
        AppMethodBeat.o(22091);
        return str;
    }

    public final String aTd() {
        AppMethodBeat.i(22092);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22092);
            throw bVar;
        }
        String str = this.hqG + "emoji/";
        AppMethodBeat.o(22092);
        return str;
    }

    public final d cgO() {
        AppMethodBeat.i(22093);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(22093);
            throw bVar;
        }
        d dVar = this.oQG;
        AppMethodBeat.o(22093);
        return dVar;
    }

    public final void chE() {
        AppMethodBeat.i(22094);
        Log.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", this.oTj, this.hqK, this.oTi, Util.getStack());
        if (this.oTj == null || this.oTj.booleanValue()) {
            if (this.hqK != null) {
                Log.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", this.hqK);
                this.hqK.closeDB();
                this.hqK = null;
            }
            if (this.oTi != null) {
                this.oTi.closeDB();
                this.oTi = null;
            }
            this.oTj = null;
            AppMethodBeat.o(22094);
            return;
        }
        this.oTj = null;
        AppMethodBeat.o(22094);
    }
}
