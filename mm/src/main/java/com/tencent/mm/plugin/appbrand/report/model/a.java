package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.LinkedList;

public final class a implements f {
    private final q kBw;
    private final String mAppId;
    private Intent nIi;
    private boolean nIj = false;
    private boolean nIk = false;
    private k nIl = null;
    private m nIm = null;
    private p nIn = null;
    private q nIo = null;
    private volatile h nIp = null;
    private boolean noI = false;

    public a(q qVar) {
        AppMethodBeat.i(48085);
        this.mAppId = qVar.mAppId;
        this.kBw = qVar;
        this.nIo = q.G(this.kBw);
        resetSession();
        AppMethodBeat.o(48085);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final h bOz() {
        return this.nIp;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void I(Intent intent) {
        this.nIi = intent;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final Intent bOA() {
        return this.nIi;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void resetSession() {
        AppMethodBeat.i(48086);
        if (Util.isNullOrNil(this.mAppId)) {
            Log.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", Util.stackTraceToString(new Throwable()));
            this.nIp = h.nIG;
            this.nIm = m.bUN();
            this.nIl = k.bUM();
            this.nIn = p.bUW();
            AppMethodBeat.o(48086);
            return;
        }
        String str = this.kBw.bsC().cym;
        String d2 = d.d(this.kBw.bsC().cys);
        this.nIp = new c(d2, this.kBw.brs());
        this.nIl = k.a(this.kBw, str, this.nIp);
        LinkedList linkedList = new LinkedList();
        linkedList.push(Util.nullAsNil(d2));
        this.nIn = p.a(this.kBw, str, linkedList);
        this.nIm = m.b(this.kBw, str, this.nIp);
        AppMethodBeat.o(48086);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final p bOB() {
        return this.nIn;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final q bOC() {
        return this.nIo;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void bOD() {
        this.nIj = true;
        this.nIk = true;
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final void a(ag agVar, ag agVar2, bx bxVar) {
        ag agVar3;
        boolean z = false;
        AppMethodBeat.i(48087);
        if (bx.AUTO_RE_LAUNCH != bxVar || !this.nIk) {
            this.nIk = false;
        } else {
            this.nIk = false;
            resetSession();
        }
        if (bx.AUTO_RE_LAUNCH == bxVar || agVar2 == null || Util.isNullOrNil(agVar2.nna) || agVar2 == agVar) {
            z = true;
        }
        h hVar = this.nIp;
        if (z) {
            agVar3 = null;
        } else {
            agVar3 = agVar2;
        }
        hVar.a(agVar, agVar3, bxVar);
        if (!z) {
            agVar2.nrs.onBackground();
            a(agVar, agVar2);
            AppMethodBeat.o(48087);
            return;
        }
        a(agVar, (ag) null);
        AppMethodBeat.o(48087);
    }

    private void a(ag agVar, ag agVar2) {
        AppMethodBeat.i(48088);
        if (agVar2 != null) {
            this.nIl.v(agVar2);
            this.nIn.a(agVar2, agVar.nna);
        }
        this.nIm.x(agVar);
        AppMethodBeat.o(48088);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final void d(ag agVar) {
        String className;
        AppMethodBeat.i(48089);
        this.noI = true;
        this.nIp.d(agVar);
        agVar.nrs.onBackground();
        k kVar = this.nIl;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(agVar.getContext());
        if (castActivityOrNull != null && castActivityOrNull.isFinishing()) {
            kVar.nIT = true;
        }
        kVar.w(agVar);
        kVar.report();
        p pVar = this.nIn;
        pVar.nIU = pVar.nKb.peekFirst();
        pVar.nIW = null;
        switch (h.Uc(pVar.appId)) {
            case CLOSE:
                pVar.nIV = 3;
                break;
            case HANG:
                pVar.nIV = 6;
                break;
            case LAUNCH_MINI_PROGRAM:
                break;
            default:
                Intent bOA = pVar.kBw.bsD().getReporter().bOA();
                if (bOA == null) {
                    pVar.nIV = 7;
                    break;
                } else {
                    if (bOA.getComponent() == null) {
                        className = "";
                        Log.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", bOA);
                    } else {
                        className = bOA.getComponent().getClassName();
                    }
                    pVar.nIV = 8;
                    pVar.nIW = Util.nullAs(IntentUtil.getStringExtra(bOA, AppBrandProcessProxyUI.lwf), className);
                    String str = pVar.nIW;
                    pVar.nKb.pollFirst();
                    pVar.nKb.push(Util.nullAsNil(str));
                    break;
                }
        }
        Activity castActivityOrNull2 = AndroidContextUtil.castActivityOrNull(agVar.getContext());
        if (castActivityOrNull2 != null && castActivityOrNull2.isFinishing()) {
            pVar.nIT = true;
        }
        pVar.y(agVar);
        AppMethodBeat.o(48089);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void bOy() {
        AppMethodBeat.i(48090);
        j(0, 4);
        AppMethodBeat.o(48090);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void c(ag agVar) {
        AppMethodBeat.i(48091);
        if (agVar == null || this.noI) {
            AppMethodBeat.o(48091);
            return;
        }
        d(agVar);
        AppMethodBeat.o(48091);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.g
    public final void e(ag agVar) {
        AppMethodBeat.i(48092);
        this.nIi = null;
        if (this.nIj) {
            this.nIj = false;
            AppMethodBeat.o(48092);
            return;
        }
        this.nIp.e(agVar);
        this.nIm.x(agVar);
        AppMethodBeat.o(48092);
    }

    @Override // com.tencent.mm.plugin.appbrand.report.model.f
    public final void a(long j2, bx bxVar) {
        int i2;
        int i3;
        AppMethodBeat.i(48093);
        switch (bxVar) {
            case APP_LAUNCH:
                i2 = 1;
                break;
            case REDIRECT_TO:
            case REWRITE_ROUTE:
            case RE_LAUNCH:
            case AUTO_RE_LAUNCH:
                i2 = 3;
                break;
            default:
                i2 = 2;
                break;
        }
        j(j2, i2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(390, 0, 1, false);
        switch (((int) j2) / 250) {
            case 0:
                i3 = 1;
                break;
            case 1:
                i3 = 2;
                break;
            case 2:
                i3 = 3;
                break;
            case 3:
                i3 = 4;
                break;
            case 4:
            case 5:
                i3 = 5;
                break;
            case 6:
            case 7:
                i3 = 6;
                break;
            default:
                i3 = 7;
                break;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(390, (long) i3, 1, false);
        AppMethodBeat.o(48093);
    }

    private void j(long j2, int i2) {
        AppMethodBeat.i(48094);
        int i3 = this.kBw.bsB().leE.pkgVersion;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13543, this.mAppId, Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(48094);
    }
}
