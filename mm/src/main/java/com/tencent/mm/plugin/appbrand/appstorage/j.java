package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j implements q {
    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m Vj(String str) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m Vl(String str) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m ai(String str, boolean z) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m aj(String str, boolean z) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, i<List<k>> iVar) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m b(String str, i<ByteBuffer> iVar) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, InputStream inputStream, boolean z) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m VX(String str) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, FileStructStat fileStructStat) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m h(String str, List<x> list) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, o oVar, boolean z) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public o VY(String str) {
        AppMethodBeat.i(174620);
        o ag = ag(str, false);
        AppMethodBeat.o(174620);
        return ag;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public o ag(String str, boolean z) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public o VV(String str) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, o oVar) {
        return m.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public boolean Vi(String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public boolean VZ(String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public boolean VW(String str) {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public void initialize() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public void release() {
    }

    public void bxq() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public o Wa(String str) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(i<String> iVar) {
        return m.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(o oVar, String str, boolean z, i<String> iVar) {
        return m.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(o oVar, String str, i<String> iVar) {
        return m.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public List<? extends q.a> bxs() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public boolean Wb(String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final InputStream Wc(String str) {
        AppMethodBeat.i(140587);
        i<ByteBuffer> iVar = new i<>();
        if (b(str, iVar) == m.OK) {
            a aVar = new a(iVar.value);
            AppMethodBeat.o(140587);
            return aVar;
        }
        AppMethodBeat.o(140587);
        return null;
    }

    protected static m g(long j2, long j3, long j4) {
        m mVar = m.OK;
        if (j2 < 0 || j2 > j4 - 1) {
            return m.ERR_ILLEGAL_READ_POSITION;
        }
        if (j3 < 1 || j3 > j4 - j2) {
            return m.ERR_ILLEGAL_READ_LENGTH;
        }
        return mVar;
    }
}
