package com.tencent.xweb.xwalk.updater;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public class XWebCoreScheduler extends Scheduler {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWebCoreScheduler.class.desiredAssertionStatus());
    static XWebCoreScheduler SJy;

    static {
        AppMethodBeat.i(207381);
        AppMethodBeat.o(207381);
    }

    public static XWebCoreScheduler hvW() {
        AppMethodBeat.i(207375);
        if (SJy == null) {
            SJy = new XWebCoreScheduler();
        }
        XWebCoreScheduler xWebCoreScheduler = SJy;
        AppMethodBeat.o(207375);
        return xWebCoreScheduler;
    }

    @Override // com.tencent.xweb.xwalk.updater.Scheduler
    public String hvc() {
        return "XWebCore";
    }

    @Override // com.tencent.xweb.xwalk.updater.Scheduler
    public synchronized boolean hvz() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(207376);
            if (!super.hvz()) {
                AppMethodBeat.o(207376);
            } else if (hvJ().version <= XWalkEnvironment.getInstalledNewstVersion(hvJ().strAbi)) {
                AppMethodBeat.o(207376);
            } else {
                z = true;
                AppMethodBeat.o(207376);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.xweb.xwalk.updater.Scheduler
    public boolean hvA() {
        AppMethodBeat.i(207377);
        if (!XWalkEnvironment.hasInstalledAvailableVersion()) {
            if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.nS("dis_update_immediately_when_no_xweb", "tools"))) {
                if (hvJ().SJh > 0) {
                    XWalkEnvironment.addXWalkInitializeLog(this.TAG, " failed update before , do not force update ");
                    if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.nS("allow_failed_schedule_force_update", "tools"))) {
                        AppMethodBeat.o(207377);
                        return false;
                    }
                }
                XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
                AppMethodBeat.o(207377);
                return true;
            }
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
        }
        AppMethodBeat.o(207377);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.xweb.xwalk.updater.Scheduler
    public final String Eu(boolean z) {
        String nS;
        AppMethodBeat.i(207378);
        if (!z) {
            nS = a.nS("UPDATE_SPEED_CONFIG", "tools");
        } else {
            nS = a.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools");
        }
        AppMethodBeat.o(207378);
        return nS;
    }

    public c a(a.b bVar) {
        AppMethodBeat.i(207379);
        if (bVar == null) {
            AppMethodBeat.o(207379);
            return null;
        }
        Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + bVar.SIJ);
        h.dO(bVar.SIJ, true);
        if (!ai.htj() || XWalkEnvironment.isInTestMode()) {
            hvJ();
            c d2 = d(d.a(bVar, XWalkEnvironment.getRuntimeAbi()));
            AppMethodBeat.o(207379);
            return d2;
        }
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
        AppMethodBeat.o(207379);
        return null;
    }

    public final XWalkUpdater.UpdateConfig f(c cVar) {
        XWalkUpdater.UpdateConfig updateConfig;
        AppMethodBeat.i(207380);
        try {
            if (!cVar.SJc) {
                if (cVar.SID != null && !cVar.SID.isEmpty()) {
                    updateConfig = new XWalkUpdater.UpdateConfig(cVar.SID, false, null, cVar.SIw, cVar.version, cVar.strAbi, cVar.nPatchTargetVersion);
                } else if (!$assertionsDisabled) {
                    AssertionError assertionError = new AssertionError("royle:no md5 info, maybe something wrong");
                    AppMethodBeat.o(207380);
                    throw assertionError;
                } else {
                    updateConfig = new XWalkUpdater.UpdateConfig(cVar.SIw, false, cVar.version, cVar.strAbi, cVar.nPatchTargetVersion);
                }
            } else if (cVar.SID != null && !cVar.SID.isEmpty() && cVar.patchMd5 != null && !cVar.patchMd5.isEmpty()) {
                updateConfig = new XWalkUpdater.UpdateConfig(cVar.patchMd5, true, cVar.SID, cVar.SIw, cVar.version, cVar.strAbi, cVar.nPatchTargetVersion);
            } else if (!$assertionsDisabled) {
                AssertionError assertionError2 = new AssertionError("royle:no md5 info, maybe something wrong");
                AppMethodBeat.o(207380);
                throw assertionError2;
            } else {
                updateConfig = new XWalkUpdater.UpdateConfig(cVar.SIw, true, cVar.version, cVar.strAbi, cVar.nPatchTargetVersion);
            }
            updateConfig.versionDetail = cVar.SJg;
            updateConfig.bUseCdn = cVar.bUseCdn;
            updateConfig.bTryUseSharedCore = cVar.bTryUseSharedCore;
            updateConfig.scheduler = this;
            AppMethodBeat.o(207380);
            return updateConfig;
        } catch (Exception e2) {
            XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
            AppMethodBeat.o(207380);
            return null;
        }
    }
}
