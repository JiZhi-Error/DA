package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b;

public final class a extends d {
    private static a oRe;
    private e oRf;
    private c oRg;
    private b oRh;

    public static a cgZ() {
        AppMethodBeat.i(21859);
        if (oRe == null) {
            a aVar = new a();
            oRe = aVar;
            a(aVar);
        }
        a aVar2 = oRe;
        AppMethodBeat.o(21859);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oRe = null;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void o(Object... objArr) {
        AppMethodBeat.i(21860);
        cgZ().chc().chd();
        b.clear();
        c.bs(new Intent().setClassName((Context) objArr[0], "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
        AppMethodBeat.o(21860);
    }

    public final e cha() {
        AppMethodBeat.i(21861);
        if (this.oRf == null) {
            this.oRf = new e();
        }
        e eVar = this.oRf;
        AppMethodBeat.o(21861);
        return eVar;
    }

    public final c chb() {
        AppMethodBeat.i(21862);
        if (this.oRg == null) {
            this.oRg = new c();
        }
        c cVar = this.oRg;
        AppMethodBeat.o(21862);
        return cVar;
    }

    public final b chc() {
        AppMethodBeat.i(21863);
        if (this.oRh == null) {
            this.oRh = new b();
        }
        b bVar = this.oRh;
        AppMethodBeat.o(21863);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceN() {
    }

    @Override // com.tencent.mm.plugin.backup.b.d
    public final void ceO() {
    }
}
