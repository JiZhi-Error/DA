package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i extends j {
    private final String kSp;
    private final String kSq;
    private String kSr;
    private final u kSs;
    public volatile long kSt = -1;

    public interface a {
        f bxr();
    }

    public i(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(196156);
        this.kSr = str;
        String z = aa.z(new o(str).her());
        this.kSp = str2;
        this.kSq = str3;
        this.kSs = new u(z, this.kSp, this.kSq, aVar);
        AppMethodBeat.o(196156);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Vi(String str) {
        AppMethodBeat.i(196157);
        boolean startsWith = Util.nullAsNil(str).startsWith(this.kSq);
        AppMethodBeat.o(196157);
        return startsWith;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void initialize() {
        AppMethodBeat.i(196158);
        if (!s.boN(this.kSr)) {
            Log.e("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
        }
        AppMethodBeat.o(196158);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vj(String str) {
        AppMethodBeat.i(196159);
        if (this.kSs.dI(str) == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(196159);
            return mVar;
        }
        m mVar2 = m.OK;
        AppMethodBeat.o(196159);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m b(String str, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> iVar) {
        AppMethodBeat.i(196160);
        if (!Vi(str)) {
            m mVar = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(196160);
            return mVar;
        }
        T t = (T) this.kSs.dI(str);
        if (t == null) {
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(196160);
            return mVar2;
        }
        iVar.value = t;
        m mVar3 = m.OK;
        AppMethodBeat.o(196160);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, long j2, long j3, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> iVar) {
        AppMethodBeat.i(196161);
        if (!Vi(str)) {
            m mVar = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(196161);
            return mVar;
        }
        ByteBuffer dI = this.kSs.dI(str);
        if (dI == null) {
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(196161);
            return mVar2;
        }
        int limit = dI.limit();
        m g2 = g(j2, j3, (long) limit);
        if (g2 != m.OK) {
            AppMethodBeat.o(196161);
            return g2;
        }
        if (j3 > 2147483647L) {
            j3 = ((long) limit) - j2;
        }
        byte[] bArr = new byte[((int) j3)];
        dI.get(bArr, (int) j2, (int) j3);
        T t = (T) ByteBuffer.wrap(bArr);
        t.order(ByteOrder.BIG_ENDIAN);
        iVar.value = t;
        m mVar3 = m.OK;
        AppMethodBeat.o(196161);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final o VV(String str) {
        AppMethodBeat.i(196162);
        o Wi = this.kSs.Wi(str);
        AppMethodBeat.o(196162);
        return Wi;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean VW(String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(196163);
        if (!Vi(str)) {
            m mVar = m.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(196163);
            return mVar;
        }
        ByteBuffer dI = this.kSs.dI(str);
        if (dI == null) {
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(196163);
            return mVar2;
        } else if (fileStructStat == null) {
            m mVar3 = m.ERR_OP_FAIL;
            AppMethodBeat.o(196163);
            return mVar3;
        } else {
            fileStructStat.st_mode = 33152;
            fileStructStat.st_size = (long) dI.limit();
            m mVar4 = m.OK;
            AppMethodBeat.o(196163);
            return mVar4;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void release() {
        AppMethodBeat.i(196164);
        this.kSs.clear();
        AppMethodBeat.o(196164);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.j
    public final void bxq() {
        AppMethodBeat.i(196165);
        this.kSs.clear();
        AppMethodBeat.o(196165);
    }
}
