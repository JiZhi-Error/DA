package com.tencent.mm.app;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;

public final class ag {
    private MMUncaughtExceptionHandler.IOnUncaughtExceptionListener dmA = new MMUncaughtExceptionHandler.IOnUncaughtExceptionListener() {
        /* class com.tencent.mm.app.ag.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
        public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
            AppMethodBeat.i(200819);
            if (!b.c(ag.this.mAppLike)) {
                AppMethodBeat.o(200819);
            } else if (!(th instanceof NoClassDefFoundError) && !(th instanceof VerifyError) && !(th instanceof IncompatibleClassChangeError) && !(th instanceof InternalError)) {
                AppMethodBeat.o(200819);
            } else if (!ag.this.dmz) {
                AppMethodBeat.o(200819);
            } else {
                try {
                    SharedPreferences sharedPreferences = ag.this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
                    synchronized (ag.this) {
                        try {
                            if (!ag.this.dmy) {
                                int i2 = sharedPreferences.getInt("tinker_crash_count", 0);
                                if (i2 > 3) {
                                    String str2 = com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count";
                                    sharedPreferences.edit().putInt(str2, sharedPreferences.getInt(str2, 0) + 1).putInt("tinker_crash_count", 0).commit();
                                    b.e(ag.this.mAppLike);
                                    Log.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] clean patch by ensurance logic!!");
                                    Log.appenderFlushSync();
                                } else {
                                    sharedPreferences.edit().putInt("tinker_crash_count", i2 + 1).commit();
                                }
                            }
                        } finally {
                            AppMethodBeat.o(200819);
                        }
                    }
                } catch (Throwable th2) {
                    Log.printErrStackTrace("MicroMsg.TinkerEnsuranceOnFault", th2, "[-] Exception occurred.", new Object[0]);
                    Log.appenderFlushSync();
                    AppMethodBeat.o(200819);
                }
            }
        }
    };
    volatile boolean dmy = false;
    boolean dmz = false;
    ApplicationLike mAppLike = null;
    private volatile boolean mInstalled = false;

    public ag() {
        AppMethodBeat.i(125030);
        AppMethodBeat.o(125030);
    }

    public static final class a {
        public static final ag dmC = new ag();

        static {
            AppMethodBeat.i(125029);
            AppMethodBeat.o(125029);
        }
    }

    public static ag WK() {
        return a.dmC;
    }

    public final synchronized void b(ApplicationLike applicationLike) {
        AppMethodBeat.i(125031);
        try {
            if (this.mInstalled) {
                AppMethodBeat.o(125031);
            } else {
                this.mAppLike = applicationLike;
                this.dmz = this.mAppLike.getApplication().getPackageName().equals(this.mAppLike.getApplication().getApplicationInfo().processName);
                SharedPreferences sharedPreferences = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
                String string = sharedPreferences.getString("tinker_last_clientversion", null);
                if (string == null) {
                    sharedPreferences.edit().putString("tinker_last_clientversion", com.tencent.mm.loader.j.a.CLIENT_VERSION).commit();
                } else if (!com.tencent.mm.loader.j.a.CLIENT_VERSION.equals(string)) {
                    sharedPreferences.edit().remove(string + "_clean_patch_count").putString("tinker_last_clientversion", com.tencent.mm.loader.j.a.CLIENT_VERSION).commit();
                }
                MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(this.dmA);
                this.mInstalled = true;
                AppMethodBeat.o(125031);
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.TinkerEnsuranceOnFault", th, "[-] Exception occurred.", new Object[0]);
            this.mInstalled = false;
            AppMethodBeat.o(125031);
        }
    }

    public final synchronized void WL() {
        this.dmy = false;
    }

    public final synchronized void WM() {
        this.dmy = true;
    }

    public final synchronized boolean WN() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(125032);
            if (!this.mInstalled) {
                Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, canApplyPatch will return true.");
                AppMethodBeat.o(125032);
            } else {
                if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count", 0) > 3) {
                    z = false;
                }
                if (z) {
                    Log.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we can apply patch.");
                } else {
                    Log.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we CANNOT apply patch !!");
                }
                AppMethodBeat.o(125032);
            }
        }
        return z;
    }

    private synchronized boolean WO() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(125033);
            if (!this.mInstalled) {
                Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isCleanPatchTriggered will return false.");
                AppMethodBeat.o(125033);
            } else {
                int i2 = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count", 0);
                if (i2 > 0) {
                    z = true;
                }
                if (z) {
                    Log.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we have cleaned patch by %s times !!", Integer.valueOf(i2));
                } else {
                    Log.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: clean patch logic is not being triggered.");
                }
                AppMethodBeat.o(125033);
            }
        }
        return z;
    }

    private synchronized boolean WP() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(125034);
            if (!this.mInstalled) {
                Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isCleanPatchReported will return false.");
                AppMethodBeat.o(125034);
            } else if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.o(125034);
            } else {
                AppMethodBeat.o(125034);
            }
        }
        return z;
    }

    private synchronized boolean WQ() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(125035);
            if (!this.mInstalled) {
                Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, isBlockApplyPatchReported will return false.");
                AppMethodBeat.o(125035);
            } else if (this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_block_apply_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.o(125035);
            } else {
                AppMethodBeat.o(125035);
            }
        }
        return z;
    }

    public final synchronized void WR() {
        AppMethodBeat.i(125036);
        if (!this.mInstalled) {
            Log.w("MicroMsg.TinkerEnsuranceOnFault", "[!] Uninitialized or install failed, reportStats will be ignored.");
            AppMethodBeat.o(125036);
        } else {
            SharedPreferences sharedPreferences = this.mAppLike.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
            if (!WP() && WO()) {
                e.INSTANCE.idkeyStat(338, 231, 1, false);
                sharedPreferences.edit().putInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_reported", 1).apply();
            }
            if (!WQ() && !WN()) {
                e.INSTANCE.idkeyStat(338, 232, 1, false);
                sharedPreferences.edit().putInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_block_apply_patch_reported", 1).apply();
            }
            AppMethodBeat.o(125036);
        }
    }
}
