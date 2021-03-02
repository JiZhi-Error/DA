package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.xweb.internal.IWebStorage;

public final class l implements IWebStorage {
    @Override // com.tencent.xweb.internal.IWebStorage
    public final void deleteOrigin(String str) {
        AppMethodBeat.i(153897);
        WebStorage.getInstance().deleteOrigin(str);
        AppMethodBeat.o(153897);
    }
}
