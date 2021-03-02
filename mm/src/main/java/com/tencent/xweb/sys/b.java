package com.tencent.xweb.sys;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal;

public final class b implements CookieInternal.ICookieSyncManagerInternal {
    CookieSyncManager SDV;

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void init(Context context) {
        AppMethodBeat.i(153655);
        this.SDV = CookieSyncManager.createInstance(context);
        AppMethodBeat.o(153655);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal
    public final void sync() {
        AppMethodBeat.i(153656);
        if (this.SDV != null) {
            this.SDV.sync();
        }
        AppMethodBeat.o(153656);
    }
}
