package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.feq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public class d extends a<Boolean, feq> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(final String str, String str2, feq feq) {
        AppMethodBeat.i(44390);
        feq feq2 = feq;
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            final b hdx = g.hdx();
            hdx.hdw();
            final int i2 = feq2.NzO.NzL;
            a aVar = a.INSTANCE;
            a.F((long) i2, 24);
            aa.a(str, true, (aa.b<WxaAttributes>) new aa.b<WxaAttributes>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.d.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.config.aa$b$a, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.config.aa.b
                public final /* synthetic */ void a(aa.b.a aVar, WxaAttributes wxaAttributes) {
                    AppMethodBeat.i(226377);
                    WxaAttributes wxaAttributes2 = wxaAttributes;
                    Log.i("MicroMsg.AppBrand.Predownload.CmdGetContact", "onGetContact with username[%s] result[%s]", str, aVar);
                    hdx.G(Boolean.FALSE);
                    switch (AnonymousClass2.kPJ[aVar.ordinal()]) {
                        case 1:
                            a aVar2 = a.INSTANCE;
                            a.F((long) i2, 26);
                            break;
                        case 2:
                        case 3:
                            a aVar3 = a.INSTANCE;
                            a.F((long) i2, 27);
                            break;
                        case 4:
                            a aVar4 = a.INSTANCE;
                            a.F((long) i2, 25);
                            break;
                    }
                    if (wxaAttributes2 != null) {
                        ((com.tencent.mm.plugin.appbrand.config.a.b) n.W(com.tencent.mm.plugin.appbrand.config.a.b.class)).b(new b.a.C0564b(str));
                    }
                    AppMethodBeat.o(226377);
                }
            });
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(44390);
            return bool;
        }
        Log.e("MicroMsg.AppBrand.Predownload.CmdGetContact", "invalid username & appId");
        Boolean bool2 = Boolean.FALSE;
        AppMethodBeat.o(44390);
        return bool2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(feq feq) {
        return feq.NzO;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.b.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] kPJ = new int[aa.b.a.values().length];

        static {
            AppMethodBeat.i(226378);
            try {
                kPJ[aa.b.a.RET_CGI_FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kPJ[aa.b.a.RET_HIT_FREQUENCY_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kPJ[aa.b.a.RET_NO_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kPJ[aa.b.a.RET_UPDATED.ordinal()] = 4;
                AppMethodBeat.o(226378);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(226378);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdGetContact";
    }
}
