package com.tencent.mm.ui.l.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.s;
import com.tencent.mmkv.MMKV;

public final class f extends e {
    private final WxaPkg Qma;
    private final String Qmb;

    public f(g gVar) {
        super(gVar);
        AppMethodBeat.i(234389);
        if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) && gVar.getAppId().equals(MMKV.mmkvWithID("magic_emoji_test").decodeString("last_open_appid"))) {
            this.Qma = new WxaPkg(bes());
            if (!this.Qma.bvf()) {
                RuntimeException runtimeException = new RuntimeException("No test package");
                AppMethodBeat.o(234389);
                throw runtimeException;
            }
            this.Qmb = CdnLogic.calcFileMD5(s.k(bes(), false));
            AppMethodBeat.o(234389);
            return;
        }
        RuntimeException runtimeException2 = new RuntimeException("Not legal for test environment!!");
        AppMethodBeat.o(234389);
        throw runtimeException2;
    }

    @Override // com.tencent.mm.ui.l.a.e
    public final String bes() {
        AppMethodBeat.i(234390);
        String decodeString = MMKV.mmkvWithID("magic_emoji_test").decodeString("last_open_pkg");
        AppMethodBeat.o(234390);
        return decodeString;
    }

    @Override // com.tencent.mm.ui.l.a.e
    public final String gWF() {
        return this.Qmb;
    }
}
