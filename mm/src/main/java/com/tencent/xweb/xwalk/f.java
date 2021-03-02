package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal;
import org.xwalk.core.XWalkCookieManager;

public final class f implements CookieInternal.ICookieSyncManagerInternal {
    XWalkCookieManager SGP = new XWalkCookieManager();

    public f() {
        AppMethodBeat.i(154262);
        AppMethodBeat.o(154262);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void init(Context context) {
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void sync() {
        AppMethodBeat.i(154263);
        if (this.SGP != null) {
            this.SGP.flushCookieStore();
        }
        AppMethodBeat.o(154263);
    }
}
