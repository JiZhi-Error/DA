package com.tencent.mm.plugin.appbrand.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;

public final class a implements bw.a {
    @Override // com.tencent.mm.storage.bw.a
    public final void a(az azVar, bw bwVar) {
        AppMethodBeat.i(48310);
        if (azVar != null && !Util.isNullOrNil(azVar.field_username)) {
            String str = azVar.field_username;
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn == null || ((int) Kn.gMZ) == 0) {
                Log.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", str);
                AppMethodBeat.o(48310);
                return;
            } else if (as.HF(str) && !ab.Jf(str)) {
                Log.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                azVar.Co("appbrandcustomerservicemsg");
                ((e) g.af(e.class)).c(azVar);
                AppMethodBeat.o(48310);
                return;
            } else if (ab.JB(str)) {
                Log.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                azVar.Co(null);
            }
        }
        AppMethodBeat.o(48310);
    }
}
