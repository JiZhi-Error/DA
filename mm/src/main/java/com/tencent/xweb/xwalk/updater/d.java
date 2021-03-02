package com.tencent.xweb.xwalk.updater;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a;
import com.tencent.xweb.xwalk.updater.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWebCoreInfo;

public final class d {
    public static c a(a.b bVar, String str) {
        a.f fVar;
        AppMethodBeat.i(207353);
        c cVar = new c();
        a.c.bsv(str);
        if (bVar == null || bVar.SIK == null || bVar.SIK.length == 0) {
            fVar = null;
        } else {
            int i2 = Build.VERSION.SDK_INT;
            a.f[] fVarArr = bVar.SIK;
            int length = fVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    XWalkInitializer.addXWalkInitializeLog("no matched version");
                    fVar = null;
                    break;
                }
                fVar = fVarArr[i3];
                if (fVar != null) {
                    Log.i("VersionMatcher", "try match version = " + fVar.version + " version runtime abi is " + fVar.SCE.SDk);
                    if (fVar.version >= 49) {
                        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(fVar.SCE.SDk);
                        if (fVar.version > installedNewstVersion) {
                            if (fVar.SCE.htw()) {
                                String str2 = fVar.SCE.SDk;
                                XWalkUpdater.getLastTryInstallVer(str2);
                                if (!XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str2)) {
                                    XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(str2);
                                }
                                if (!a.c.htz() || fVar.SIQ) {
                                    break;
                                }
                                Log.i("VersionMatcher", " version.supportPredown is false, apkver = " + fVar.version);
                            } else {
                                Log.i("VersionMatcher", " apk filter out ");
                            }
                        } else {
                            Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(installedNewstVersion)));
                        }
                    } else {
                        Log.i("VersionMatcher", " apk is not support, below 49");
                    }
                } else {
                    XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
                }
                i3++;
            }
        }
        a.c.bsv(null);
        if (fVar == null || fVar.version <= XWebCoreInfo.getBackupCoreInfo(str).ver) {
            AppMethodBeat.o(207353);
            return null;
        }
        XWalkInitializer.addXWalkInitializeLog("got matched version");
        cVar.SIJ = bVar.SIJ;
        cVar.SID = fVar.SID;
        cVar.SIG = fVar.SIG;
        cVar.SIH = fVar.SIH;
        cVar.SII = fVar.SII;
        cVar.version = fVar.version;
        cVar.SJg = fVar.SIP.SIS;
        cVar.SIE = fVar.SIE;
        cVar.bUseCdn = fVar.bUseCdn;
        cVar.bTryUseSharedCore = fVar.bTryUseSharedCore;
        a.c a2 = a(fVar, str);
        cVar.SJe = fVar.SIw;
        cVar.strAbi = fVar.SCE.SDk;
        cVar.SIv = fVar.SIv;
        cVar.SJj = fVar.SIx;
        cVar.SJk = fVar.SIy;
        if (a2 != null) {
            cVar.SJc = true;
            cVar.nPatchTargetVersion = a2.SIM;
            cVar.SIw = a2.SIw;
            cVar.patchMd5 = a2.SID;
            cVar.SIE = a2.SIE;
            cVar.bUseCdn = a2.bUseCdn;
        } else {
            cVar.SJc = false;
            cVar.SIw = fVar.SIw;
        }
        cVar.SJf = Scheduler.a(fVar, "XWebCore");
        AppMethodBeat.o(207353);
        return cVar;
    }

    private static a.c a(a.f fVar, String str) {
        AppMethodBeat.i(207354);
        if (fVar.SIB != null) {
            a.c[] cVarArr = fVar.SIB;
            for (a.c cVar : cVarArr) {
                if (cVar.SIM == XWalkEnvironment.getInstalledNewstVersion(str)) {
                    XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + cVar.SIM);
                    AppMethodBeat.o(207354);
                    return cVar;
                }
            }
        }
        XWalkInitializer.addXWalkInitializeLog("no matched patch");
        AppMethodBeat.o(207354);
        return null;
    }
}
