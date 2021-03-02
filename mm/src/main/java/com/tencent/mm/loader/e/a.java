package com.tencent.mm.loader.e;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a implements g {
    @Override // com.tencent.mm.loader.f.g
    public final String c(com.tencent.mm.loader.h.a.a<?> aVar) {
        if (aVar == null || Util.isNullOrNil(aVar.toString())) {
            return null;
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(aVar.toString().getBytes());
        Log.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", messageDigest);
        return messageDigest;
    }

    @Override // com.tencent.mm.loader.f.g
    public final String d(com.tencent.mm.loader.h.a.a<?> aVar) {
        String str = null;
        if (aVar != null && !Util.isNullOrNil(aVar.toString())) {
            str = com.tencent.mm.b.g.getMessageDigest(aVar.toString().getBytes());
            Log.d("MicroMsg.Loader.DefaultFileNameCreator", "create image file name :%s", str);
        }
        return str + ".tmp";
    }
}
