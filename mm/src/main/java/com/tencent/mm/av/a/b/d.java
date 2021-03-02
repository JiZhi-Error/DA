package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements g {
    @Override // com.tencent.mm.av.a.c.g
    public final String OX(String str) {
        AppMethodBeat.i(130413);
        String str2 = null;
        if (!Util.isNullOrNil(str)) {
            str2 = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
            Log.d("MicroMsg.imageloader.DefaultImageFileNameCreator", "[cpan] create image file name :%s", str2);
        }
        AppMethodBeat.o(130413);
        return str2;
    }
}
