package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.event.IListener;

/* access modifiers changed from: package-private */
public abstract class ag implements aa, z {
    boolean mUW = true;
    QualitySession mVi;
    private final IListener<lf> mVj = new IListener<lf>() {
        /* class com.tencent.mm.plugin.appbrand.launching.ag.AnonymousClass1 */

        {
            AppMethodBeat.i(160606);
            this.__eventId = lf.class.getName().hashCode();
            AppMethodBeat.o(160606);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lf lfVar) {
            AppMethodBeat.i(47240);
            lf lfVar2 = lfVar;
            if (ag.this.mVi != null && lfVar2.dQt.dQu.nJD.equals(ag.this.mVm.toString())) {
                g.a(lfVar2.dQt.dQu, ag.this.mVi);
                lfVar2.dQt.dQv.proceed();
                dead();
            }
            AppMethodBeat.o(47240);
            return false;
        }
    };
    private volatile z.b mVk;
    private volatile z.a mVl;
    final ad mVm;

    public abstract String brS();

    public abstract void prepare();

    @Override // com.tencent.mm.plugin.appbrand.launching.z
    public void a(QualitySession qualitySession) {
        this.mVi = qualitySession;
    }

    ag(ad adVar) {
        this.mVm = adVar;
    }

    /* access modifiers changed from: package-private */
    public final void e(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (this.mVk != null) {
            this.mVk.c(wxaPkgWrappingInfo);
        }
        this.mVj.dead();
    }

    /* access modifiers changed from: package-private */
    public final void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
        z.a aVar = this.mVl;
        if (aVar != null) {
            aVar.a(wxaPkgLoadProgress);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bNE() {
        if (this.mVk != null) {
            z.b bVar = this.mVk;
        }
        this.mVj.dead();
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.z
    public final void a(z.b bVar) {
        this.mVk = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.z
    public final void a(z.a aVar) {
        this.mVl = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.z
    public final void prepareAsync() {
        if (this.mVi != null) {
            this.mVj.alive();
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.ag.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(47241);
                ag.this.prepare();
                AppMethodBeat.o(47241);
            }
        }, "AppBrandLaunchPrepareJob#" + brS());
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public final boolean bNh() {
        return this.mUW;
    }
}
