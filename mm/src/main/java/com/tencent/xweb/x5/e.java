package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.xweb.internal.CookieInternal;

public final class e implements CookieInternal.ICookieSyncManagerInternal {
    CookieSyncManager SEZ;

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void init(Context context) {
        AppMethodBeat.i(153841);
        this.SEZ = CookieSyncManager.createInstance(context);
        AppMethodBeat.o(153841);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void sync() {
        AppMethodBeat.i(153842);
        if (this.SEZ != null) {
            this.SEZ.sync();
        }
        AppMethodBeat.o(153842);
    }
}
