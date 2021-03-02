package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class o extends j {
    private volatile boolean kSM = false;
    public final LuggageLocalFileObjectManager kSN;
    public String kSO = "tmp";
    private final String kSp;
    public final String kSq;
    public final String kSr;
    public volatile long kSt = -1;

    public o(String str, String str2, String str3) {
        AppMethodBeat.i(134338);
        this.kSr = aa.z(new com.tencent.mm.vfs.o(str).her());
        this.kSp = str2;
        this.kSq = str3;
        this.kSN = new LuggageLocalFileObjectManager(this.kSr, this.kSp, this.kSq);
        AppMethodBeat.o(134338);
    }

    public final String getRootPath() {
        return this.kSr;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Vi(String str) {
        AppMethodBeat.i(134339);
        boolean startsWith = Util.nullAsNil(str).startsWith(this.kSq);
        AppMethodBeat.o(134339);
        return startsWith;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void release() {
        AppMethodBeat.i(196167);
        super.release();
        this.kSM = true;
        AppMethodBeat.o(196167);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vj(String str) {
        AppMethodBeat.i(134340);
        y Wl = this.kSN.Wl(str);
        if (Wl == null || !s.YS(Wl.iGf)) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134340);
            return mVar;
        }
        m mVar2 = m.OK;
        AppMethodBeat.o(134340);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m b(String str, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134341);
        y Wl = this.kSN.Wl(str);
        if (Wl == null || !s.YS(Wl.iGf)) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134341);
            return mVar;
        }
        iVar.value = (T) n.s(new com.tencent.mm.vfs.o(Wl.iGf));
        m mVar2 = m.OK;
        AppMethodBeat.o(134341);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        AppMethodBeat.i(175575);
        y Wl = this.kSN.Wl(str);
        if (Wl == null || !s.YS(Wl.iGf)) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(175575);
            return mVar;
        }
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(Wl.iGf);
        m g2 = g(j2, j3, oVar.length());
        if (g2 != m.OK) {
            AppMethodBeat.o(175575);
            return g2;
        }
        if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            j3 = oVar.length() - j2;
        }
        iVar.value = (T) n.a(oVar, j2, j3);
        m mVar2 = m.OK;
        AppMethodBeat.o(175575);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(134342);
        y Wl = this.kSN.Wl(str);
        if (Wl == null || !s.YS(Wl.iGf)) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134342);
            return mVar;
        } else if (fileStructStat == null) {
            m mVar2 = m.ERR_OP_FAIL;
            AppMethodBeat.o(134342);
            return mVar2;
        } else if (FileStat.b(Wl.iGf, fileStructStat) == 0) {
            m mVar3 = m.OK;
            AppMethodBeat.o(134342);
            return mVar3;
        } else {
            m mVar4 = m.ERR_OP_FAIL;
            AppMethodBeat.o(134342);
            return mVar4;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, i<List<k>> iVar) {
        AppMethodBeat.i(134343);
        LinkedList<y> linkedList = new LinkedList();
        b.c(linkedList, this.kSN.bxw());
        b.c(linkedList, this.kSN.bxy());
        T t = (T) new LinkedList();
        for (y yVar : linkedList) {
            k kVar = new k();
            kVar.fileName = yVar.dJX;
            t.add(kVar);
        }
        iVar.value = t;
        m mVar = m.OK;
        AppMethodBeat.o(134343);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final com.tencent.mm.vfs.o ag(String str, boolean z) {
        AppMethodBeat.i(175576);
        com.tencent.mm.vfs.o VY = VY(str);
        AppMethodBeat.o(175576);
        return VY;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final com.tencent.mm.vfs.o VY(String str) {
        AppMethodBeat.i(175577);
        y Wl = this.kSN.Wl(str);
        if (Wl == null) {
            AppMethodBeat.o(175577);
            return null;
        }
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(Wl.iGf);
        AppMethodBeat.o(175577);
        return oVar;
    }

    public final String Wh(String str) {
        AppMethodBeat.i(134346);
        y Wl = this.kSN.Wl(str);
        if (Wl == null) {
            AppMethodBeat.o(134346);
            return null;
        }
        String str2 = Wl.iGf;
        AppMethodBeat.o(134346);
        return str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void initialize() {
        AppMethodBeat.i(134347);
        if (!s.boN(this.kSr)) {
            Log.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
        }
        AppMethodBeat.o(134347);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final com.tencent.mm.vfs.o Wa(String str) {
        AppMethodBeat.i(134348);
        s.boN(this.kSr);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(this.kSr + FilePathGenerator.ANDROID_DIR_SEP + str);
        AppMethodBeat.o(134348);
        return oVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(i<String> iVar) {
        iVar.value = (T) this.kSr;
        return m.OK;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(com.tencent.mm.vfs.o oVar, String str, boolean z, i<String> iVar) {
        AppMethodBeat.i(175578);
        Log.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b] released[%b]", oVar, str, Boolean.valueOf(z), Boolean.valueOf(this.kSM));
        if (this.kSM) {
            m mVar = m.ERR_FS_NOT_MOUNTED;
            AppMethodBeat.o(175578);
            return mVar;
        }
        y j2 = this.kSN.j(aa.z(oVar.her()), str, z);
        if (j2 == null) {
            m mVar2 = m.ERR_OP_FAIL;
            AppMethodBeat.o(175578);
            return mVar2;
        }
        iVar.value = (T) j2.dJX;
        m mVar3 = m.OK;
        AppMethodBeat.o(175578);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(com.tencent.mm.vfs.o oVar, String str, i<String> iVar) {
        long j2 = 0;
        AppMethodBeat.i(175579);
        if (oVar == null || !oVar.exists()) {
            m mVar = m.ERR_OP_FAIL;
            AppMethodBeat.o(175579);
            return mVar;
        } else if (!TextUtils.isEmpty(str) || iVar == null) {
            m mVar2 = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(175579);
            return mVar2;
        } else {
            if (this.kSt > 0) {
                com.tencent.mm.vfs.o[] bxx = this.kSN.bxx();
                if (bxx != null && bxx.length > 0) {
                    for (com.tencent.mm.vfs.o oVar2 : bxx) {
                        j2 += oVar2.length();
                    }
                }
                if (j2 + oVar.length() > this.kSt) {
                    m mVar3 = m.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.o(175579);
                    return mVar3;
                }
            }
            y Wk = this.kSN.Wk(oVar.getName());
            if (Wk == null) {
                iVar.value = (T) this.kSN.a(this.kSN.j(aa.z(oVar.her()), null, false)).dJX;
                m mVar4 = m.OK;
                AppMethodBeat.o(175579);
                return mVar4;
            } else if (Wk.kSa) {
                iVar.value = (T) Wk.dJX;
                m mVar5 = m.OK;
                AppMethodBeat.o(175579);
                return mVar5;
            } else {
                iVar.value = (T) this.kSN.a(Wk).dJX;
                m mVar6 = m.OK;
                AppMethodBeat.o(175579);
                return mVar6;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final List<y> bxs() {
        AppMethodBeat.i(134351);
        List<y> bxw = this.kSN.bxw();
        AppMethodBeat.o(134351);
        return bxw;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Wb(String str) {
        AppMethodBeat.i(134352);
        y Wl = this.kSN.Wl(str);
        if (Wl == null || !Wl.kSa) {
            AppMethodBeat.o(134352);
            return false;
        }
        AppMethodBeat.o(134352);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m VX(String str) {
        AppMethodBeat.i(134353);
        m mVar = m.ERR_PERMISSION_DENIED;
        AppMethodBeat.o(134353);
        return mVar;
    }
}
