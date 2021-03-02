package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class v implements q {
    public final LinkedList<q> kTe = new LinkedList<>();
    private final q kTf = new j();

    public v(LinkedList<q> linkedList) {
        AppMethodBeat.i(175580);
        this.kTe.addAll(linkedList);
        AppMethodBeat.o(175580);
    }

    public final LinkedList<q> bxv() {
        return this.kTe;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final InputStream Wc(String str) {
        AppMethodBeat.i(134355);
        i<ByteBuffer> iVar = new i<>();
        m b2 = b(str, iVar);
        if (b2 == m.OK) {
            a aVar = new a(iVar.value);
            AppMethodBeat.o(134355);
            return aVar;
        }
        Log.e("MicroMsg.LuggageFileSystemRegistry", "readStream error: %s %s", b2, str);
        AppMethodBeat.o(134355);
        return null;
    }

    public final <T extends q> T az(Class<T> cls) {
        AppMethodBeat.i(134356);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (cls.isInstance(t)) {
                AppMethodBeat.o(134356);
                return t;
            }
        }
        AppMethodBeat.o(134356);
        return null;
    }

    public final q Wj(String str) {
        AppMethodBeat.i(134357);
        if (Util.isNullOrNil(str)) {
            q qVar = this.kTf;
            AppMethodBeat.o(134357);
            return qVar;
        }
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next.Vi(str)) {
                AppMethodBeat.o(134357);
                return next;
            }
        }
        q qVar2 = this.kTf;
        AppMethodBeat.o(134357);
        return qVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m Vj(String str) {
        AppMethodBeat.i(134358);
        m Vj = Wj(str).Vj(str);
        AppMethodBeat.o(134358);
        return Vj;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m Vl(String str) {
        AppMethodBeat.i(134359);
        m Vl = Wj(str).Vl(str);
        AppMethodBeat.o(134359);
        return Vl;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m ai(String str, boolean z) {
        AppMethodBeat.i(134360);
        m ai = Wj(str).ai(str, z);
        AppMethodBeat.o(134360);
        return ai;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m aj(String str, boolean z) {
        AppMethodBeat.i(134361);
        m aj = Wj(str).aj(str, z);
        AppMethodBeat.o(134361);
        return aj;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(String str, i<List<k>> iVar) {
        AppMethodBeat.i(134362);
        m a2 = Wj(str).a(str, iVar);
        AppMethodBeat.o(134362);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m b(String str, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134363);
        m b2 = Wj(str).b(str, iVar);
        AppMethodBeat.o(134363);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134364);
        m a2 = Wj(str).a(str, j2, j3, iVar);
        AppMethodBeat.o(134364);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(String str, InputStream inputStream, boolean z) {
        AppMethodBeat.i(134365);
        m a2 = Wj(str).a(str, inputStream, z);
        AppMethodBeat.o(134365);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m VX(String str) {
        AppMethodBeat.i(134366);
        m VX = Wj(str).VX(str);
        AppMethodBeat.o(134366);
        return VX;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(134367);
        m a2 = Wj(str).a(str, fileStructStat);
        AppMethodBeat.o(134367);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m h(String str, List<x> list) {
        AppMethodBeat.i(134368);
        m h2 = Wj(str).h(str, list);
        AppMethodBeat.o(134368);
        return h2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(String str, o oVar, boolean z) {
        AppMethodBeat.i(175581);
        m a2 = Wj(str).a(str, oVar, z);
        AppMethodBeat.o(175581);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final o VY(String str) {
        AppMethodBeat.i(175582);
        o ag = ag(str, false);
        AppMethodBeat.o(175582);
        return ag;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final o ag(String str, boolean z) {
        AppMethodBeat.i(175583);
        o ag = Wj(str).ag(str, z);
        AppMethodBeat.o(175583);
        return ag;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final o VV(String str) {
        AppMethodBeat.i(196178);
        o VV = Wj(str).VV(str);
        AppMethodBeat.o(196178);
        return VV;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(String str, o oVar) {
        AppMethodBeat.i(175584);
        m a2 = Wj(str).a(str, oVar);
        AppMethodBeat.o(175584);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final boolean Vi(String str) {
        AppMethodBeat.i(134373);
        String[] strArr = {"file://", HttpWrapperBase.PROTOCAL_HTTP, HttpWrapperBase.PROTOCAL_HTTPS};
        for (int i2 = 0; i2 < 3; i2++) {
            if (l.C(str, strArr[i2])) {
                AppMethodBeat.o(134373);
                return false;
            }
        }
        AppMethodBeat.o(134373);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final boolean VZ(String str) {
        AppMethodBeat.i(175585);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next.Vi(str) && next.VZ(str)) {
                AppMethodBeat.o(175585);
                return true;
            }
        }
        AppMethodBeat.o(175585);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final boolean VW(String str) {
        AppMethodBeat.i(196179);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next.Vi(str) && !next.VW(str)) {
                AppMethodBeat.o(196179);
                return false;
            }
        }
        AppMethodBeat.o(196179);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final void initialize() {
        AppMethodBeat.i(134374);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            it.next().initialize();
        }
        this.kTf.initialize();
        AppMethodBeat.o(134374);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final void release() {
        AppMethodBeat.i(134375);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.kTf.release();
        AppMethodBeat.o(134375);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public o Wa(String str) {
        AppMethodBeat.i(134376);
        o Wa = ((o) az(o.class)).Wa(str);
        AppMethodBeat.o(134376);
        return Wa;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(i<String> iVar) {
        AppMethodBeat.i(134377);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            m a2 = it.next().a(iVar);
            if (a2 != m.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(134377);
                return a2;
            }
        }
        m mVar = m.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(134377);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public m a(o oVar, String str, boolean z, i<String> iVar) {
        AppMethodBeat.i(175586);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            m a2 = it.next().a(oVar, str, z, iVar);
            if (a2 != m.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(175586);
                return a2;
            }
        }
        m mVar = m.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(175586);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final m a(o oVar, String str, i<String> iVar) {
        AppMethodBeat.i(175587);
        Iterator<q> it = this.kTe.iterator();
        while (it.hasNext()) {
            m a2 = it.next().a(oVar, str, iVar);
            if (a2 != m.ERR_NOT_SUPPORTED) {
                AppMethodBeat.o(175587);
                return a2;
            }
        }
        m mVar = m.ERR_NOT_SUPPORTED;
        AppMethodBeat.o(175587);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public List<? extends q.a> bxs() {
        AppMethodBeat.i(134380);
        List<y> bxw = ((o) az(o.class)).kSN.bxw();
        AppMethodBeat.o(134380);
        return bxw;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q
    public final boolean Wb(String str) {
        AppMethodBeat.i(134381);
        boolean Wb = ((o) az(o.class)).Wb(str);
        AppMethodBeat.o(134381);
        return Wb;
    }
}
