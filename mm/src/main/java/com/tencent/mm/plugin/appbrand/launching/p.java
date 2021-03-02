package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.jsapi.ab.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class p {
    final int enterScene;
    final int kMt = this.mSb.appVersion;
    final QualitySession ldW;
    final WxaAttributes.WxaVersionInfo mSb;
    final AppBrandPrepareTask.PrepareParams mTv;
    final a mTw;

    public interface a {
        void a(b bVar);
    }

    p(AppBrandPrepareTask.PrepareParams prepareParams, a aVar) {
        AppMethodBeat.i(180300);
        this.mTv = prepareParams;
        this.enterScene = prepareParams.jZJ;
        this.mSb = prepareParams.mRd;
        this.mTw = aVar;
        this.ldW = prepareParams.mRg;
        AppMethodBeat.o(180300);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.p$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] kPJ = new int[aa.b.a.values().length];

        static {
            AppMethodBeat.i(227081);
            try {
                kPJ[aa.b.a.RET_CGI_FAIL.ordinal()] = 1;
                AppMethodBeat.o(227081);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(227081);
            }
        }
    }
}
