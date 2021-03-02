package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.reflect.Field;
import org.xwalk.core.XWalkEnvironment;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "MicroMsg.MMApplication";
    private static MMApplicationLike sSafeguardInstance = null;
    private static byte[] sSafeguardLock = new byte[0];
    private s mMMApplicationLikeImpl = new s(this);
    private ApplicationLifeCycle wrapper;

    public MMApplicationLike(Application application, int i2, boolean z, long j2, long j3, Intent intent) {
        super(application, i2, z, j2, j3, intent);
        AppMethodBeat.i(123467);
        AppMethodBeat.o(123467);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onBaseContextAttached(Context context) {
        String str;
        AppMethodBeat.i(123468);
        if (safeguard()) {
            AppMethodBeat.o(123468);
            return;
        }
        ApplicationGlobal.attach(getApplication());
        MMApplicationContext.setApplicationId(context.getPackageName());
        Bundle bO = ac.bO(context);
        if (bO == null) {
            Log.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
        } else {
            a.y(bO);
        }
        BuildInfo.DEBUG = false;
        BuildInfo.BUILD_TAG = BuildConfig.BUILD_TAG;
        BuildInfo.OWNER = BuildConfig.OWNER;
        BuildInfo.HOSTNAME = BuildConfig.HOSTNAME;
        BuildInfo.TIME = BuildConfig.TIME;
        BuildInfo.COMMAND = BuildConfig.COMMAND;
        BuildInfo.REV = BuildConfig.REV;
        BuildInfo.SVNPATH = BuildConfig.SVNPATH;
        String str2 = a.IS_ARM64 ? BuildConfig.CLIENT_VERSION_ARM64 : BuildConfig.CLIENT_VERSION_ARMEABI;
        BuildInfo.CLIENT_VERSION = str2;
        BuildInfo.CLIENT_VERSION_INT = Integer.decode(str2).intValue();
        BuildInfo.ENABLE_FPS_ANALYSE = false;
        BuildInfo.ENABLE_MATRIX = true;
        BuildInfo.ENABLE_MATRIX_TRACE = false;
        BuildInfo.EX_DEVICE_LOGIN = false;
        BuildInfo.PRE_RELEASE = false;
        BuildInfo.REDESIGN_ENTRANCE = false;
        BuildInfo.IS_FLAVOR_RED = false;
        BuildInfo.IS_FLAVOR_PURPLE = false;
        BuildInfo.IS_FLAVOR_BLUE = false;
        BuildInfo.MATRIX_VERSION = BuildConfig.MATRIX_VERSION;
        BuildInfo.IS_ARM64 = a.IS_ARM64;
        BuildInfo.KINDA_DEFAULT = BuildConfig.KINDA_DEFAULT;
        BuildInfo.TINKER_VERSION = "1.9.14.10";
        BuildInfo.IS_UAT = false;
        BuildInfo.ENABLE_PAYTEST = false;
        BuildInfo.OVERRIDE_VERSION_NAME = "";
        ArrayMap arrayMap = new ArrayMap();
        Field[] fields = BuildConfig.class.getFields();
        for (Field field : fields) {
            try {
                Log.i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", field.getName(), field.get(null));
                arrayMap.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e2) {
                Log.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e2, "", new Object[0]);
            }
        }
        BuildInfo.ext.putAll(arrayMap);
        BuildInfo.ext.markImmutable();
        com.tencent.stubs.logger.Log.setLogger(m.Wp());
        super.onBaseContextAttached(context);
        String processNameByPid = Util.getProcessNameByPid(context, Process.myPid());
        d.cQi = processNameByPid;
        if (aa.bN(context)) {
            AppMethodBeat.o(123468);
            return;
        }
        s sVar = this.mMMApplicationLikeImpl;
        if (!BuildInfo.DEBUG) {
            Log.e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
            l.f(s.dks.getApplication());
        }
        if (!MMApplicationContext.isToolsIsolatedProcess()) {
            ag.a.dmC.b(s.dks);
            ag.a.dmC.WL();
        }
        ApplicationLike applicationLike = s.dks;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.o(123468);
            throw tinkerRuntimeException;
        }
        if (ShareTinkerInternals.isTinkerEnabledForNativeLib(applicationLike.getTinkerFlags()) && b.c(s.dks)) {
            if (a.IS_ARM64) {
                String gd = s.gd(XWalkEnvironment.RUNTIME_ABI_ARM64_STR);
                if (!TextUtils.isEmpty(gd)) {
                    j.Ec(gd);
                }
                com.tencent.tinker.lib.a.a.a(s.dks, XWalkEnvironment.RUNTIME_ABI_ARM64_STR);
            } else {
                String gd2 = s.gd(XWalkEnvironment.RUNTIME_ABI_ARM32_STR);
                if (!TextUtils.isEmpty(gd2)) {
                    j.Ec(gd2);
                }
                String gd3 = s.gd("armeabi");
                if (!TextUtils.isEmpty(gd3)) {
                    j.Ec(gd3);
                }
                com.tencent.tinker.lib.a.a.a(s.dks, XWalkEnvironment.RUNTIME_ABI_ARM32_STR);
                com.tencent.tinker.lib.a.a.a(s.dks, "armeabi");
            }
        }
        d.dkt = s.dks.getApplicationStartMillisTime();
        s.a(s.dks);
        s.dlj += FilePathGenerator.ANDROID_DIR_SEP + sVar.hashCode();
        MMApplicationContext.setAppHasInitFlag(false);
        MMApplicationContext.setContext(s.dks.getApplication());
        Log.setLevel(0, false);
        long currentTimeMillis = System.currentTimeMillis();
        r rVar = new r(com.tencent.mm.loader.j.b.aKB() + "NowRev.ini");
        if (rVar.propertie == null || !rVar.propertie.containsKey("NowRev")) {
            str = null;
        } else {
            str = rVar.propertie.getProperty("NowRev");
        }
        sVar.dlk = str;
        sVar.dll = BuildInfo.CLIENT_VERSION;
        long currentTimeMillis2 = System.currentTimeMillis();
        sVar.dlm = currentTimeMillis2 - currentTimeMillis;
        sVar.dln = 0;
        if (!sVar.dll.equals(sVar.dlk)) {
            MMApplicationContext.sIsRevChange = true;
            s.D(s.dks.getApplication().getDir(ShareConstants.SO_PATH, 0));
            s.D(s.dks.getApplication().getDir(ShareConstants.DEX_PATH, 0));
            s.D(s.dks.getApplication().getDir("cache", 0));
            s.D(s.dks.getApplication().getDir("recover_lib", 0));
            if (a.CLIENT_VERSION.equals(BuildInfo.CLIENT_VERSION)) {
                Log.i("MicroMsg.MMApplicationLikeImpl", "[tomys] clean patch since base apk is upgraded, prev_clientversion: %s, curr_clientversion: %s, curr_base_clientversion: %s", sVar.dlk, sVar.dll, a.CLIENT_VERSION);
                b.e(s.dks);
            }
            rVar.saveValue("NowRev", sVar.dll);
            sVar.dln = System.currentTimeMillis() - currentTimeMillis2;
            Log.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", s.dlj, Util.getStack().toString());
        }
        Log.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", sVar.dlk, sVar.dll, Long.valueOf(sVar.dlm), Long.valueOf(sVar.dln));
        if (BuildInfo.DEBUG || BuildInfo.PRE_RELEASE) {
            Log.e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
            l.f(s.dks.getApplication());
        }
        if (processNameByPid.equals(context.getPackageName())) {
            x.a(TAG, "** Hit main process condition.", new Object[0]);
            try {
                if (b.c(this)) {
                    File patchDirectory = SharePatchFileUtil.getPatchDirectory(context);
                    File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(patchDirectory.getAbsolutePath());
                    File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(patchDirectory.getAbsolutePath());
                    SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
                    if (ShareConstants.CHANING_DEX_OPTIMIZE_PATH.equals(readAndCheckPropertyWithLock.oatDir)) {
                        x.a(TAG, "** Before fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion, readAndCheckPropertyWithLock.oatDir, readAndCheckPropertyWithLock.fingerPrint);
                        x.a(19725, 2, processNameByPid, String.format("BEFORE_FIXED##%s##%s##%s##%s", readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion, readAndCheckPropertyWithLock.oatDir, readAndCheckPropertyWithLock.fingerPrint));
                        File file = new File(patchDirectory, SharePatchFileUtil.getPatchVersionDirectory(readAndCheckPropertyWithLock.newVersion));
                        File file2 = new File(file, "odex");
                        File file3 = new File(file, ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH);
                        File file4 = new File(file2, "tinker_classN.dex");
                        File file5 = new File(file3, "tinker_classN.dex");
                        if (file4.exists() && file4.canRead()) {
                            readAndCheckPropertyWithLock.oatDir = "odex";
                        } else if (file5.exists() && file5.canRead()) {
                            readAndCheckPropertyWithLock.oatDir = ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH;
                        }
                        x.a(19725, 2, processNameByPid, String.format("FIXED##%s##%s##%s##%s", readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion, readAndCheckPropertyWithLock.oatDir, readAndCheckPropertyWithLock.fingerPrint));
                        x.a(TAG, "** After fixing: oldver: %s, newver: %s, oatdir: %s, fingerpint: %s", readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion, readAndCheckPropertyWithLock.oatDir, readAndCheckPropertyWithLock.fingerPrint);
                        SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
                        x.a(TAG, "** Killing other processes.", new Object[0]);
                        ShareTinkerInternals.killProcessExceptMain(context);
                        x.a(TAG, "** Other processes were killed.", new Object[0]);
                    } else {
                        x.a(TAG, "** Status is ok, do not needs to do fix.", new Object[0]);
                    }
                } else {
                    x.a(TAG, "** Patch is not loaded, do not needs to do fix.", new Object[0]);
                }
            } catch (Throwable th) {
                x.a(TAG, th, "** Exception occurred.", new Object[0]);
            }
        }
        if (k.e(getApplication())) {
            AppMethodBeat.o(123468);
            return;
        }
        try {
            if (MMApplicationContext.isToolsIsolatedProcess()) {
                this.wrapper = (ApplicationLifeCycle) Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMIsolatedApplicationWrapper").getConstructor(ApplicationLike.class, String.class).newInstance(this, processNameByPid);
            } else if (MMApplicationContext.isNoSpaceProcess()) {
                this.wrapper = (ApplicationLifeCycle) Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMCleanApplicationWrapper").getConstructor(ApplicationLike.class, String.class).newInstance(this, processNameByPid);
            } else if (MMApplicationContext.isHotpotDotDotProcess()) {
                this.wrapper = (ApplicationLifeCycle) Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMHotpotDotDotWrapper").getConstructor(ApplicationLike.class, String.class).newInstance(this, processNameByPid);
            } else {
                this.wrapper = (ApplicationLifeCycle) Class.forName(MMApplicationContext.getSourcePackageName() + ".app.MMApplicationWrapper").getConstructor(ApplicationLike.class, String.class).newInstance(this, processNameByPid);
            }
            this.wrapper.onBaseContextAttached(context);
            AppMethodBeat.o(123468);
        } catch (Exception e3) {
            Log.printErrStackTrace(TAG, e3, "failed to create application wrapper class", new Object[0]);
            RuntimeException runtimeException = new RuntimeException("failed to create application wrapper class", e3);
            AppMethodBeat.o(123468);
            throw runtimeException;
        }
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onCreate() {
        AppMethodBeat.i(123469);
        if (this.wrapper != null) {
            this.wrapper.onCreate();
        }
        AppMethodBeat.o(123469);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onTerminate() {
        AppMethodBeat.i(123470);
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.onTerminate();
        }
        AppMethodBeat.o(123470);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(123471);
        Log.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(123471);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike
    public Resources getResources(Resources resources) {
        AppMethodBeat.i(123472);
        if (MMApplicationContext.getResources() == null) {
            AppMethodBeat.o(123472);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(123472);
        return resources2;
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onLowMemory() {
        AppMethodBeat.i(123473);
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.onLowMemory();
        }
        AppMethodBeat.o(123473);
    }

    @Override // com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle, com.tencent.tinker.entry.DefaultApplicationLike
    public void onTrimMemory(int i2) {
        AppMethodBeat.i(123474);
        super.onTrimMemory(i2);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i2);
        }
        AppMethodBeat.o(123474);
    }

    public boolean safeguard() {
        boolean z;
        synchronized (sSafeguardLock) {
            if (sSafeguardInstance != this) {
                if (sSafeguardInstance == null) {
                    sSafeguardInstance = this;
                } else {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.tencent.tinker.entry.ApplicationLike
    public int mzNightModeUseOf() {
        return 0;
    }
}
