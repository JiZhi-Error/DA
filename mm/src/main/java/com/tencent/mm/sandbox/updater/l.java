package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.w;
import java.util.HashMap;

public final class l implements a {
    /* synthetic */ l(byte b2) {
        this();
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean bu(Intent intent) {
        AppMethodBeat.i(32811);
        if (intent == null) {
            AppMethodBeat.o(32811);
            return false;
        }
        int intExtra = intent.getIntExtra("intent_extra_download_type", 4);
        Log.i("MicroMsg.WCWebDownloadMgr", "WCWebDownloadMgr  downloadType = %d", Integer.valueOf(intExtra));
        HashMap hashMap = new HashMap();
        if (intExtra == 5) {
            hashMap.put("UpdaterCheckType", "1");
        } else {
            hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        w.b(MMApplicationContext.getContext(), hashMap);
        AppMethodBeat.o(32811);
        return true;
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void Ay(boolean z) {
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean isBusy() {
        AppMethodBeat.i(32812);
        boolean isBusy = w.isBusy();
        Log.i("MicroMsg.WCWebDownloadMgr", "bIsBusy = ".concat(String.valueOf(isBusy)));
        AppMethodBeat.o(32812);
        return isBusy;
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void onDestroy() {
    }

    public static final class a {
        public static final l NGg = new l((byte) 0);

        static {
            AppMethodBeat.i(32810);
            AppMethodBeat.o(32810);
        }
    }

    private l() {
        AppMethodBeat.i(32813);
        d.kT(MMApplicationContext.getContext());
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
        AppMethodBeat.o(32813);
    }
}
