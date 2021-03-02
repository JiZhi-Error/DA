package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.b.c;
import com.tencent.mm.pluginsdk.j.a.b.e;
import com.tencent.mm.pluginsdk.j.a.c.j;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

final class d extends n.a<c> {
    public d(c cVar) {
        super(cVar);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.e
    public final String avy() {
        return "CheckResUpdate";
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
    public final boolean AX(long j2) {
        AppMethodBeat.i(151946);
        if (((c) bwt()).fileSize <= 0 || ((c) bwt()).fileSize == a.hv(getFilePath()) + j2) {
            boolean AX = super.AX(j2);
            AppMethodBeat.o(151946);
            return AX;
        }
        AppMethodBeat.o(151946);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
    public final boolean bws() {
        AppMethodBeat.i(151947);
        if (super.bws()) {
            j.F(((c) bwt()).IBJ, 12);
            AppMethodBeat.o(151947);
            return true;
        }
        j.F(((c) bwt()).IBJ, 27);
        AppMethodBeat.o(151947);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.n.a
    public final m a(j jVar) {
        AppMethodBeat.i(151948);
        c cVar = (c) bwt();
        String aee = i.aee(cVar.JYs);
        String str = cVar.md5;
        if (cVar.IOp && Util.nullAsNil(s.bhK(i.aee(cVar.JYs))).equals(str)) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            m mVar = new m(cVar, a.hv(aee));
            AppMethodBeat.o(151948);
            return mVar;
        } else if (Util.isNullOrNil(((c) bwt()).JYY) || !a.y(i.aee(((c) bwt()).JYs), ((c) bwt()).JYY) || !Util.nullAsNil(s.bhK(i.aee(((c) bwt()).JYs))).equals(((c) bwt()).md5)) {
            m a2 = super.a(jVar);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(a2)), cVar.JYs);
            if (a2 == null) {
                m mVar2 = new m("CheckResUpdate", gnA(), getURL(), getFilePath(), 0, "", 3, new e());
                AppMethodBeat.o(151948);
                return mVar2;
            }
            if (a2.status == 2) {
                if (Util.isNullOrNil(((c) bwt()).md5) || !((c) bwt()).md5.equals(s.bhK(getFilePath()))) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", cVar.JYs);
                    m mVar3 = new m("CheckResUpdate", gnA(), getURL(), getFilePath(), a2.contentLength, a2.contentType, 3, new c());
                    AppMethodBeat.o(151948);
                    return mVar3;
                }
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", cVar.JYs);
            }
            AppMethodBeat.o(151948);
            return a2;
        } else {
            m mVar4 = new m((l) bwt(), a.hv(i.aee(((c) bwt()).JYs)));
            AppMethodBeat.o(151948);
            return mVar4;
        }
    }
}
