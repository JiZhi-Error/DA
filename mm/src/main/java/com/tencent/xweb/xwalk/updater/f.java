package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public final class f implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener {
    public static boolean SJn = true;
    private static boolean SJo = false;
    private static f SJp;
    XWalkInitializer SHI;
    XWalkUpdater SHJ;
    Context mContext;

    private f(Context context) {
        AppMethodBeat.i(154564);
        this.mContext = context;
        this.SHI = new XWalkInitializer(this, context);
        this.SHJ = new XWalkUpdater(this, context);
        AppMethodBeat.o(154564);
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public final void onXWalkInitStarted() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public final void onXWalkInitCancelled() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public final void onXWalkInitFailed() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public final void onXWalkInitCompleted() {
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public final void onXWalkUpdateStarted() {
        AppMethodBeat.i(154565);
        g.hvS();
        AppMethodBeat.o(154565);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public final void onXWalkUpdateProgress(int i2) {
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public final void onXWalkUpdateCancelled() {
        AppMethodBeat.i(154566);
        g.hvT();
        AppMethodBeat.o(154566);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public final void onXWalkUpdateFailed(int i2, Scheduler scheduler) {
        AppMethodBeat.i(207359);
        g.a(i2, scheduler);
        AppMethodBeat.o(207359);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public final void onXWalkUpdateCompleted(Scheduler scheduler) {
        AppMethodBeat.i(207360);
        g.a(scheduler);
        AppMethodBeat.o(207360);
    }

    public static boolean isXWalkReady() {
        AppMethodBeat.i(154569);
        if (!SJo || SJp == null) {
            AppMethodBeat.o(154569);
            return false;
        }
        boolean isXWalkReady = SJp.SHI.isXWalkReady();
        AppMethodBeat.o(154569);
        return isXWalkReady;
    }

    public static boolean lK(Context context) {
        AppMethodBeat.i(154570);
        if (SJo) {
            boolean z = SJo;
            AppMethodBeat.o(154570);
            return z;
        }
        SJo = true;
        SJp = new f(context);
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isDownloadMode()) {
            f fVar = SJp;
            if (!SJn) {
                HashMap hashMap = new HashMap();
                hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                new g(fVar.SHJ, hashMap).execute(new String[0]);
            }
            if (fVar.SHI.tryInitSync()) {
                AppMethodBeat.o(154570);
                return true;
            }
            AppMethodBeat.o(154570);
            return false;
        }
        AppMethodBeat.o(154570);
        return false;
    }
}
