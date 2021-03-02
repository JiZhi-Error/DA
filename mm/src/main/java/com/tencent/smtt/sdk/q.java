package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadLocal<Integer> f2104a = new ThreadLocal<Integer>() {
        /* class com.tencent.smtt.sdk.q.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ Integer initialValue() {
            AppMethodBeat.i(188150);
            Integer a2 = a();
            AppMethodBeat.o(188150);
            return a2;
        }

        public final Integer a() {
            AppMethodBeat.i(188149);
            AppMethodBeat.o(188149);
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static boolean f2105b = false;

    /* renamed from: c  reason: collision with root package name */
    static final FileFilter f2106c = new FileFilter() {
        /* class com.tencent.smtt.sdk.q.AnonymousClass2 */

        public final boolean accept(File file) {
            AppMethodBeat.i(188344);
            String name = file.getName();
            if (name == null) {
                AppMethodBeat.o(188344);
                return false;
            } else if (name.endsWith(".jar_is_first_load_dex_flag_file")) {
                AppMethodBeat.o(188344);
                return false;
            } else if (Build.VERSION.SDK_INT >= 21 && name.endsWith(ShareConstants.DEX_SUFFIX)) {
                AppMethodBeat.o(188344);
                return false;
            } else if (Build.VERSION.SDK_INT >= 26 && name.endsWith(".prof")) {
                AppMethodBeat.o(188344);
                return false;
            } else if (Build.VERSION.SDK_INT < 26 || !name.equals(ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH)) {
                AppMethodBeat.o(188344);
                return true;
            } else {
                AppMethodBeat.o(188344);
                return false;
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static q f2107d = null;

    /* renamed from: i  reason: collision with root package name */
    private static final ReentrantLock f2108i = new ReentrantLock();

    /* renamed from: j  reason: collision with root package name */
    private static final Lock f2109j = new ReentrantLock();
    private static FileLock l = null;
    private static Handler m = null;
    private static final Long[][] n = {new Long[]{44006L, 39094008L}, new Long[]{44005L, 39094008L}, new Long[]{43910L, 38917816L}, new Long[]{44027L, 39094008L}, new Long[]{44028L, 39094008L}, new Long[]{44029L, 39094008L}, new Long[]{44030L, 39094008L}, new Long[]{44032L, 39094008L}, new Long[]{44033L, 39094008L}, new Long[]{44034L, 39094008L}, new Long[]{43909L, 38917816L}};
    private static int o = 0;
    private static boolean p = false;

    /* renamed from: e  reason: collision with root package name */
    private int f2110e = 0;

    /* renamed from: f  reason: collision with root package name */
    private FileLock f2111f;

    /* renamed from: g  reason: collision with root package name */
    private FileOutputStream f2112g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2113h = false;
    private boolean k = false;

    static /* synthetic */ void a(q qVar, Context context, Context context2, int i2) {
        AppMethodBeat.i(188147);
        qVar.a(context, context2, i2);
        AppMethodBeat.o(188147);
    }

    static /* synthetic */ void a(q qVar, Context context, String str, int i2) {
        AppMethodBeat.i(188146);
        qVar.b(context, str, i2);
        AppMethodBeat.o(188146);
    }

    static {
        AppMethodBeat.i(188148);
        AppMethodBeat.o(188148);
    }

    private q() {
        AppMethodBeat.i(188070);
        if (m == null) {
            m = new Handler(o.a().getLooper()) {
                /* class com.tencent.smtt.sdk.q.AnonymousClass3 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public void handleMessage(Message message) {
                    AppMethodBeat.i(188302);
                    QbSdk.setTBSInstallingStatus(true);
                    switch (message.what) {
                        case 1:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                            Object[] objArr = (Object[]) message.obj;
                            q.a(q.this, (Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                            AppMethodBeat.o(188302);
                            return;
                        case 2:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                            Object[] objArr2 = (Object[]) message.obj;
                            q.a(q.this, (Context) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue());
                            AppMethodBeat.o(188302);
                            return;
                        case 3:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                            Object[] objArr3 = (Object[]) message.obj;
                            q.this.b((Context) objArr3[0], (Bundle) objArr3[1]);
                            AppMethodBeat.o(188302);
                            return;
                        case 4:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
                            Object[] objArr4 = (Object[]) message.obj;
                            q.this.b((Context) objArr4[0], (File) objArr4[1], ((Integer) objArr4[2]).intValue());
                            QbSdk.setTBSInstallingStatus(false);
                            super.handleMessage(message);
                            break;
                    }
                    AppMethodBeat.o(188302);
                }
            };
        }
        AppMethodBeat.o(188070);
    }

    static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            AppMethodBeat.i(188071);
            if (f2107d == null) {
                synchronized (q.class) {
                    try {
                        if (f2107d == null) {
                            f2107d = new q();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(188071);
                        throw th;
                    }
                }
            }
            qVar = f2107d;
            AppMethodBeat.o(188071);
        }
        return qVar;
    }

    public int a(boolean z, Context context) {
        AppMethodBeat.i(188072);
        if (z || f2104a.get().intValue() <= 0) {
            f2104a.set(Integer.valueOf(j(context)));
        }
        int intValue = f2104a.get().intValue();
        AppMethodBeat.o(188072);
        return intValue;
    }

    private synchronized boolean c(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(188073);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
            try {
                if (!u(context)) {
                    AppMethodBeat.o(188073);
                } else {
                    boolean tryLock = f2108i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        try {
                            int b2 = n.a(context).b("tpatch_status");
                            int a2 = a(false, context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =".concat(String.valueOf(b2)));
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =".concat(String.valueOf(a2)));
                            if (b2 == 1) {
                                if (a2 == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
                                    z(context);
                                } else if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
                                    z(context);
                                }
                                f2108i.unlock();
                            }
                            z3 = false;
                        } catch (Throwable th2) {
                            f2108i.unlock();
                            AppMethodBeat.o(188073);
                            throw th2;
                        }
                        try {
                            f2108i.unlock();
                        } catch (Throwable th3) {
                            th = th3;
                            TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th));
                            z2 = z3;
                            AppMethodBeat.o(188073);
                            return z2;
                        }
                    } else {
                        z3 = false;
                    }
                    b();
                    z2 = z3;
                    AppMethodBeat.o(188073);
                }
            } catch (Throwable th4) {
                th = th4;
                z3 = false;
                TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(th));
                z2 = z3;
                AppMethodBeat.o(188073);
                return z2;
            }
        }
        return z2;
    }

    private synchronized boolean d(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(188074);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (!u(context)) {
                    AppMethodBeat.o(188074);
                } else {
                    boolean tryLock = f2108i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        try {
                            int b2 = n.a(context).b("copy_status");
                            int a2 = a(false, context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =".concat(String.valueOf(b2)));
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =".concat(String.valueOf(a2)));
                            if (b2 == 1) {
                                if (a2 == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                    A(context);
                                } else if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                    A(context);
                                }
                                f2108i.unlock();
                            }
                            z3 = false;
                            try {
                                f2108i.unlock();
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                                    QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                                    z2 = z3;
                                    AppMethodBeat.o(188074);
                                    return z2;
                                } catch (Throwable th3) {
                                    AppMethodBeat.o(188074);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            f2108i.unlock();
                            AppMethodBeat.o(188074);
                            throw th4;
                        }
                    } else {
                        z3 = false;
                    }
                    b();
                    z2 = z3;
                    AppMethodBeat.o(188074);
                }
            } catch (Throwable th5) {
                th = th5;
                z3 = false;
                TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                z2 = z3;
                AppMethodBeat.o(188074);
                return z2;
            }
        }
        return z2;
    }

    private synchronized boolean e(Context context, boolean z) {
        Exception e2;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            AppMethodBeat.i(188075);
            if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(229, " ");
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =".concat(String.valueOf(z)));
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
            try {
                if (!u(context)) {
                    AppMethodBeat.o(188075);
                } else {
                    TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
                    boolean tryLock = f2108i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        try {
                            int c2 = n.a(context).c();
                            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=".concat(String.valueOf(c2)));
                            int a2 = a(false, context);
                            if (c2 == 2) {
                                TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                                if (a2 == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                    y(context);
                                } else if (z) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                    y(context);
                                }
                                f2108i.unlock();
                            }
                            z2 = false;
                            try {
                                f2108i.unlock();
                            } catch (Exception e3) {
                                e2 = e3;
                                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: ".concat(String.valueOf(e2)));
                                z3 = z2;
                                AppMethodBeat.o(188075);
                                return z3;
                            }
                        } catch (Throwable th) {
                            f2108i.unlock();
                            AppMethodBeat.o(188075);
                            throw th;
                        }
                    } else {
                        z2 = false;
                    }
                    b();
                    z3 = z2;
                    AppMethodBeat.o(188075);
                }
            } catch (Exception e4) {
                e2 = e4;
                z2 = false;
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: ".concat(String.valueOf(e2)));
                z3 = z2;
                AppMethodBeat.o(188075);
                return z3;
            }
        }
        return z3;
    }

    private synchronized boolean f(Context context, boolean z) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2 = false;
        AppMethodBeat.i(188076);
        if (z) {
            try {
                this.k = true;
            } catch (Throwable th) {
                AppMethodBeat.o(188076);
                return;
            }
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (!u(context)) {
            AppMethodBeat.o(188076);
            return;
        }
        String str = null;
        if (f2108i.tryLock()) {
            try {
                i5 = n.a(context).c();
                i4 = n.a(context).b();
                String d2 = n.a(context).d("install_apk_path");
                i2 = n.a(context).c("copy_core_ver");
                i3 = n.a(context).b("copy_status");
                f2108i.unlock();
                str = d2;
            } catch (Throwable th2) {
                f2108i.unlock();
                AppMethodBeat.o(188076);
                throw th2;
            }
        } else {
            i2 = 0;
            i3 = -1;
            i4 = 0;
            i5 = -1;
        }
        b();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=".concat(String.valueOf(i5)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=".concat(String.valueOf(i4)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=".concat(String.valueOf(i2)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=".concat(String.valueOf(i3)));
        if (TbsShareManager.isThirdPartyApp(context)) {
            c(context, TbsShareManager.a(context, false));
            AppMethodBeat.o(188076);
            return;
        }
        int i6 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        if (i6 == 1 || i6 == 2 || i6 == 4) {
            z2 = true;
        }
        if (!(z2 || i6 == 0 || i6 == 5)) {
            Bundle bundle = new Bundle();
            bundle.putInt("operation", 10001);
            a(context, bundle);
        }
        if (i5 >= 0 && i5 < 2) {
            a(context, str, i4);
        }
        if (i3 == 0) {
            b(context, i2);
        }
        AppMethodBeat.o(188076);
    }

    public static void a(Context context) {
        AppMethodBeat.i(188077);
        if (!w(context)) {
            if (a(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
                AppMethodBeat.o(188077);
                return;
            } else if (a(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
                AppMethodBeat.o(188077);
                return;
            } else if (a(context, "core_copy_tmp")) {
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
        AppMethodBeat.o(188077);
    }

    public boolean b(Context context) {
        AppMethodBeat.i(188078);
        if (!w(context)) {
            AppMethodBeat.o(188078);
            return false;
        } else if (a(context, "core_unzip_tmp") || a(context, "core_share_backup_tmp") || a(context, "core_copy_tmp") || a(context, "tpatch_tmp")) {
            AppMethodBeat.o(188078);
            return true;
        } else {
            AppMethodBeat.o(188078);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context, boolean z) {
        AppMethodBeat.i(188079);
        TbsLog.v("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentProcessId=" + Process.myPid());
        TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentThreadName=" + Thread.currentThread().getName());
        if (QbSdk.f1703b) {
            AppMethodBeat.o(188079);
        } else if (Build.VERSION.SDK_INT < 8) {
            TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            AppMethodBeat.o(188079);
        } else {
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
            if (TbsShareManager.isThirdPartyApp(context) && n.a(context).b("remove_old_core") == 1 && z) {
                try {
                    f.b(a().r(context));
                    TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
                } catch (Throwable th) {
                }
                n.a(context).a("remove_old_core", 0);
            }
            if (w(context)) {
                TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
                if (a(context, "core_unzip_tmp") && e(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                    AppMethodBeat.o(188079);
                } else if (a(context, "core_share_backup_tmp") && f(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
                    AppMethodBeat.o(188079);
                } else if (a(context, "core_copy_tmp") && d(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
                    AppMethodBeat.o(188079);
                } else if (!a(context, "tpatch_tmp") || !c(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                    AppMethodBeat.o(188079);
                } else {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
                    AppMethodBeat.o(188079);
                }
            } else {
                AppMethodBeat.o(188079);
            }
        }
    }

    static boolean a(Context context, String str) {
        AppMethodBeat.i(188080);
        File file = new File(QbSdk.getTbsFolderDir(context), str);
        if (!file.exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
            AppMethodBeat.o(188080);
            return false;
        } else if (!new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
            AppMethodBeat.o(188080);
            return false;
        } else {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            AppMethodBeat.o(188080);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, String str, int i2) {
        AppMethodBeat.i(188081);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(i2)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = {context, str, Integer.valueOf(i2)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        m.sendMessage(message);
        AppMethodBeat.o(188081);
    }

    @TargetApi(11)
    private void b(Context context, String str, int i2) {
        SharedPreferences sharedPreferences;
        boolean z;
        Throwable th;
        boolean z2;
        int i3;
        int i4;
        String str2;
        SharedPreferences sharedPreferences2;
        String str3;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(188082);
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (d(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            AppMethodBeat.o(188082);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=".concat(String.valueOf(i2)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
        }
        if (sharedPreferences.getInt("tbs_precheck_disable_version", -1) == i2) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i2 + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            AppMethodBeat.o(188082);
        } else if (!f.b(context)) {
            long a2 = com.tencent.smtt.utils.q.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + a2 + ",minReqRom=" + downloadMinFreeSpace);
            AppMethodBeat.o(188082);
        } else if (!u(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            AppMethodBeat.o(188082);
        } else {
            boolean tryLock = f2109j.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =".concat(String.valueOf(tryLock)));
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                f2108i.lock();
                try {
                    int c2 = n.a(context).c("copy_core_ver");
                    int b2 = n.a(context).b();
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =".concat(String.valueOf(c2)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =".concat(String.valueOf(b2)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =".concat(String.valueOf(i2)));
                    if ((b2 > 0 && i2 > b2) || (c2 > 0 && i2 > c2)) {
                        p(context);
                    }
                    int c3 = n.a(context).c();
                    int j2 = j(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=".concat(String.valueOf(c3)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=".concat(String.valueOf(j2)));
                    if (c3 < 0 || c3 >= 2) {
                        if (c3 == 3 && j2 >= 0 && (i2 > j2 || i2 == 88888888)) {
                            c3 = -1;
                            p(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        z2 = false;
                        i3 = c3;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z2 = true;
                        i3 = c3;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=".concat(String.valueOf(i3)));
                    if (i3 <= 0) {
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z2) {
                            int c4 = n.a(context).c("unzip_retry_num");
                            if (c4 > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                                F(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                try {
                                    f2108i.unlock();
                                    f2109j.unlock();
                                } catch (Exception e2) {
                                }
                                try {
                                    b();
                                    AppMethodBeat.o(188082);
                                    return;
                                } catch (Exception e3) {
                                    AppMethodBeat.o(188082);
                                    return;
                                }
                            } else {
                                n.a(context).b(c4 + 1);
                            }
                        }
                        if (str == null) {
                            str3 = n.a(context).d("install_apk_path");
                            if (str3 == null) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                try {
                                    f2108i.unlock();
                                    f2109j.unlock();
                                } catch (Exception e4) {
                                }
                                try {
                                    b();
                                    AppMethodBeat.o(188082);
                                    return;
                                } catch (Exception e5) {
                                    AppMethodBeat.o(188082);
                                    return;
                                }
                            }
                        } else {
                            str3 = str;
                        }
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =".concat(String.valueOf(str3)));
                        int c5 = c(context, str3);
                        if (c5 == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                            try {
                                f2108i.unlock();
                                f2109j.unlock();
                            } catch (Exception e6) {
                            }
                            try {
                                b();
                                AppMethodBeat.o(188082);
                                return;
                            } catch (Exception e7) {
                                AppMethodBeat.o(188082);
                                return;
                            }
                        } else {
                            n.a(context).a("install_apk_path", str3);
                            n.a(context).c(c5, 0);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                            if (TbsDownloader.a(context)) {
                                if (!a(context, new File(str3), true)) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
                                    try {
                                        f2108i.unlock();
                                        f2109j.unlock();
                                    } catch (Exception e8) {
                                    }
                                    try {
                                        b();
                                        AppMethodBeat.o(188082);
                                        return;
                                    } catch (Exception e9) {
                                        AppMethodBeat.o(188082);
                                        return;
                                    }
                                }
                            } else if (!a(context, new File(str3))) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                                try {
                                    f2108i.unlock();
                                    f2109j.unlock();
                                } catch (Exception e10) {
                                }
                                try {
                                    b();
                                    AppMethodBeat.o(188082);
                                    return;
                                } catch (Exception e11) {
                                    AppMethodBeat.o(188082);
                                    return;
                                }
                            }
                            if (z2) {
                                int b3 = n.a(context).b("unlzma_status");
                                if (b3 > 5) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, "exceed unlzma retry num!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                    F(context);
                                    m.c(context);
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                    TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, Boolean.TRUE);
                                    TbsDownloadConfig.getInstance(context).commit();
                                    try {
                                        f2108i.unlock();
                                        f2109j.unlock();
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        b();
                                        AppMethodBeat.o(188082);
                                        return;
                                    } catch (Exception e13) {
                                        AppMethodBeat.o(188082);
                                        return;
                                    }
                                } else {
                                    n.a(context).d(b3 + 1);
                                }
                            }
                            TbsLog.i("TbsInstaller", "unlzma begin");
                            int i5 = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                            if (j(context) != 0) {
                                Object a3 = QbSdk.a(context, "can_unlzma", (Bundle) null);
                                if (a3 == null || !(a3 instanceof Boolean)) {
                                    z3 = false;
                                } else {
                                    z3 = ((Boolean) a3).booleanValue();
                                }
                                if (z3) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("responseCode", i5);
                                    if (TbsDownloader.a(context)) {
                                        bundle.putString("unzip_temp_path", q(context).getAbsolutePath());
                                    } else {
                                        bundle.putString("unzip_temp_path", f(context, 0).getAbsolutePath());
                                    }
                                    Object a4 = QbSdk.a(context, "unlzma", bundle);
                                    if (a4 == null) {
                                        TbsLog.i("TbsInstaller", "unlzma return null");
                                        TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma is null");
                                        z4 = false;
                                    } else if (a4 instanceof Boolean) {
                                        if (((Boolean) a4).booleanValue()) {
                                            TbsLog.i("TbsInstaller", "unlzma success");
                                            z4 = true;
                                        } else {
                                            TbsLog.i("TbsInstaller", "unlzma return false");
                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, "unlzma return false");
                                            z4 = false;
                                        }
                                    } else if (a4 instanceof Bundle) {
                                        z4 = true;
                                    } else {
                                        if (a4 instanceof Throwable) {
                                            TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) a4));
                                            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.UNLZMA_FAIURE, (Throwable) a4);
                                        }
                                        z4 = false;
                                    }
                                    if (!z4) {
                                        try {
                                            f2108i.unlock();
                                            f2109j.unlock();
                                        } catch (Exception e14) {
                                        }
                                        try {
                                            b();
                                            AppMethodBeat.o(188082);
                                            return;
                                        } catch (Exception e15) {
                                            AppMethodBeat.o(188082);
                                            return;
                                        }
                                    }
                                }
                            }
                            TbsLog.i("TbsInstaller", "unlzma finished");
                            n.a(context).c(c5, 1);
                            i4 = c5;
                        }
                    } else {
                        if (TbsDownloader.a(context)) {
                            if (str == null) {
                                str2 = n.a(context).d("install_apk_path");
                                if (str2 == null) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    try {
                                        f2108i.unlock();
                                        f2109j.unlock();
                                    } catch (Exception e16) {
                                    }
                                    try {
                                        b();
                                        AppMethodBeat.o(188082);
                                        return;
                                    } catch (Exception e17) {
                                        AppMethodBeat.o(188082);
                                        return;
                                    }
                                }
                            } else {
                                str2 = str;
                            }
                            a(context, new File(str2), true);
                        }
                        i4 = 0;
                    }
                    if (i3 < 2) {
                        if (z2) {
                            int c6 = n.a(context).c("dexopt_retry_num");
                            if (c6 > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(208, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                F(context);
                                try {
                                    f2108i.unlock();
                                    f2109j.unlock();
                                } catch (Exception e18) {
                                }
                                try {
                                    b();
                                    AppMethodBeat.o(188082);
                                    return;
                                } catch (Exception e19) {
                                    AppMethodBeat.o(188082);
                                    return;
                                }
                            } else {
                                n.a(context).a(c6 + 1);
                            }
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (!j(context, 0)) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            try {
                                f2108i.unlock();
                                f2109j.unlock();
                            } catch (Exception e20) {
                            }
                            try {
                                b();
                                AppMethodBeat.o(188082);
                                return;
                            } catch (Exception e21) {
                                AppMethodBeat.o(188082);
                                return;
                            }
                        } else {
                            n.a(context).c(i4, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:".concat(String.valueOf(i2)));
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            if (Build.VERSION.SDK_INT >= 11) {
                                sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
                            } else {
                                sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                            }
                            try {
                                SharedPreferences.Editor edit = sharedPreferences2.edit();
                                edit.putInt("tbs_preload_x5_counter", 0);
                                edit.putInt("tbs_preload_x5_recorder", 0);
                                edit.putInt("tbs_preload_x5_version", i2);
                                edit.commit();
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            } catch (Throwable th2) {
                                TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(th2));
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-518);
                            }
                            if (i2 == 88888888) {
                                a(i2, str, context);
                            }
                            if (this.k) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(v(context), "continueInstallWithout core success");
                            } else {
                                TbsLogReport.getInstance(context).setInstallErrorCode(v(context), "success");
                            }
                        }
                    } else if (i3 == 2) {
                        try {
                            QbSdk.l.onInstallFinish(200);
                        } catch (Throwable th3) {
                            th = th3;
                            z = true;
                        }
                    } else {
                        z5 = false;
                    }
                    try {
                        f2108i.unlock();
                        f2109j.unlock();
                    } catch (Exception e22) {
                    }
                    try {
                        b();
                    } catch (Exception e23) {
                    }
                    if (z5) {
                        QbSdk.l.onInstallFinish(232);
                        AppMethodBeat.o(188082);
                        return;
                    }
                    AppMethodBeat.o(188082);
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                    try {
                        f2108i.unlock();
                        f2109j.unlock();
                    } catch (Exception e24) {
                    }
                    try {
                        b();
                    } catch (Exception e25) {
                    }
                    if (z) {
                        QbSdk.l.onInstallFinish(232);
                    }
                    AppMethodBeat.o(188082);
                    throw th;
                }
            } else {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
                b();
                AppMethodBeat.o(188082);
            }
        }
    }

    private int v(Context context) {
        boolean z = true;
        AppMethodBeat.i(188083);
        if (n.a(context).d() != 1) {
            z = false;
        }
        boolean a2 = TbsDownloader.a(context);
        if (z) {
            if (a2) {
                AppMethodBeat.o(188083);
                return TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
            }
            AppMethodBeat.o(188083);
            return TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
        } else if (a2) {
            AppMethodBeat.o(188083);
            return TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        } else {
            AppMethodBeat.o(188083);
            return 200;
        }
    }

    public void c(Context context) {
        AppMethodBeat.i(188084);
        g(context, true);
        n.a(context).c(i(context), 2);
        AppMethodBeat.o(188084);
    }

    public void a(Context context, int i2) {
        AppMethodBeat.i(188085);
        g(context, true);
        n.a(context).c(i2, 2);
        AppMethodBeat.o(188085);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        r1 = r3;
        r0 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c A[SYNTHETIC, Splitter:B:24:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0096 A[SYNTHETIC, Splitter:B:30:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.d(android.content.Context):boolean");
    }

    private static boolean w(Context context) {
        AppMethodBeat.i(188087);
        if (context == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
            AppMethodBeat.o(188087);
            return true;
        }
        try {
            if (new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                AppMethodBeat.o(188087);
                return true;
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
            AppMethodBeat.o(188087);
            return false;
        } catch (Exception e2) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
            AppMethodBeat.o(188087);
            return true;
        }
    }

    private void g(Context context, boolean z) {
        AppMethodBeat.i(188088);
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead context is null");
            AppMethodBeat.o(188088);
            return;
        }
        try {
            File file = new File(QbSdk.getTbsFolderDir(context), "tmp_folder_core_to_read.conf");
            if (!z) {
                f.b(file);
            } else if (!file.exists()) {
                file.createNewFile();
                AppMethodBeat.o(188088);
                return;
            }
            AppMethodBeat.o(188088);
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, "setTmpFolderCoreToRead Exception message is " + e2.getMessage() + " Exception cause is " + e2.getCause());
            AppMethodBeat.o(188088);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[SYNTHETIC, Splitter:B:22:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[SYNTHETIC, Splitter:B:25:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[SYNTHETIC, Splitter:B:33:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A[SYNTHETIC, Splitter:B:36:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.e(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e A[SYNTHETIC, Splitter:B:20:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093 A[SYNTHETIC, Splitter:B:23:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[SYNTHETIC, Splitter:B:31:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa A[SYNTHETIC, Splitter:B:34:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r7, java.lang.String r8, android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(int, java.lang.String, android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public boolean b(Context context, int i2) {
        AppMethodBeat.i(188091);
        if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(188091);
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=".concat(String.valueOf(i2)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        Context d2 = d(context, i2);
        if (d2 != null) {
            Object[] objArr = {d2, context, Integer.valueOf(i2)};
            Message message = new Message();
            message.what = 2;
            message.obj = objArr;
            m.sendMessage(message);
            AppMethodBeat.o(188091);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        AppMethodBeat.o(188091);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Bundle bundle) {
        AppMethodBeat.i(188092);
        if (bundle == null || context == null) {
            AppMethodBeat.o(188092);
            return;
        }
        Message message = new Message();
        message.what = 3;
        message.obj = new Object[]{context, bundle};
        m.sendMessage(message);
        AppMethodBeat.o(188092);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, File file, int i2) {
        AppMethodBeat.i(188093);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + context + "File=" + file + "coreVersion=" + i2);
        if (file == null || context == null) {
            AppMethodBeat.o(188093);
            return;
        }
        Object[] objArr = {context, file, Integer.valueOf(i2)};
        Message message = new Message();
        message.what = 4;
        message.obj = objArr;
        m.sendMessage(message);
        AppMethodBeat.o(188093);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0394  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r13, android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 1443
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.b(android.content.Context, android.os.Bundle):void");
    }

    private void h(Context context, int i2) {
        AppMethodBeat.i(188095);
        TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                if (!TbsDownloader.a(context)) {
                    g(context, true);
                    n.a(context).b(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0), 1);
                    break;
                } else {
                    i(context, 6);
                    break;
                }
        }
        QbSdk.setTBSInstallingStatus(false);
        AppMethodBeat.o(188095);
    }

    private int c(Context context, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(188096);
        try {
            a().g(context, false);
            Bundle a2 = QbSdk.a(context, bundle);
            TbsLog.i("TbsInstaller", "tpatch finished,ret is".concat(String.valueOf(a2)));
            int i3 = a2.getInt("patch_result");
            if (i3 == 0) {
                String string = bundle.getString("new_apk_location");
                int i4 = bundle.getInt("new_core_ver");
                int a3 = a(new File(string));
                if (i4 != a3) {
                    TbsLog.i("TbsInstaller", "version not equals!!!" + i4 + "patchVersion:" + a3);
                    TbsLogReport.getInstance(context).setInstallErrorCode(240, "version=" + i4 + ",patchVersion=" + a3);
                    AppMethodBeat.o(188096);
                    return 1;
                }
                File file = new File(bundle.getString("backup_apk"));
                String a4 = b.a(context, true, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a4)) {
                    TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + file + "signature:" + a4);
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, "version=" + i4 + ",patchVersion=" + a3);
                    f.b(file);
                    AppMethodBeat.o(188096);
                    return 0;
                } else if (TbsDownloader.a(context)) {
                    TbsLog.i("TbsInstaller", "Tpatch decouple success!");
                    TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, "");
                } else {
                    TbsLog.i("TbsInstaller", "Tpatch success!");
                    TbsLogReport.getInstance(context).setInstallErrorCode(236, "");
                }
            } else {
                String string2 = bundle.getString("new_apk_location");
                if (!TextUtils.isEmpty(string2)) {
                    f.b(new File(string2));
                }
                TbsLogReport.getInstance(context).setInstallErrorCode(i3, "tpatch fail,patch error_code=".concat(String.valueOf(i3)));
                i2 = 1;
            }
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, "patch exception" + Log.getStackTraceString(e2));
            i2 = 1;
        }
        AppMethodBeat.o(188096);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void c(Context context, int i2) {
        AppMethodBeat.i(188097);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i2 <= 0) {
            AppMethodBeat.o(188097);
            return;
        }
        int j2 = j(context);
        if (j2 == i2) {
            AppMethodBeat.o(188097);
            return;
        }
        Context e2 = TbsShareManager.e(context);
        if (e2 == null && TbsShareManager.getHostCorePathAppDefined() == null) {
            if (j2 <= 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
            AppMethodBeat.o(188097);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        a(context, e2);
        AppMethodBeat.o(188097);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03b2, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03b6, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03af A[SYNTHETIC, Splitter:B:108:0x03af] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03b9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:73:0x02f8] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03bc A[SYNTHETIC, Splitter:B:115:0x03bc] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0486 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0562  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0656  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0331  */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r11, android.content.Context r12, int r13) {
        /*
        // Method dump skipped, instructions count: 1628
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(android.content.Context, android.content.Context, int):void");
    }

    private boolean e(Context context, String str) {
        PackageInfo packageInfo;
        AppMethodBeat.i(188099);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            AppMethodBeat.o(188099);
            return true;
        }
        AppMethodBeat.o(188099);
        return false;
    }

    /* access modifiers changed from: package-private */
    public Context b(Context context, String str) {
        AppMethodBeat.i(188100);
        try {
            if (context.getPackageName() == str || !TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                Context createPackageContext = context.createPackageContext(str, 2);
                AppMethodBeat.o(188100);
                return createPackageContext;
            }
            AppMethodBeat.o(188100);
            return null;
        } catch (Exception e2) {
            AppMethodBeat.o(188100);
            return null;
        }
    }

    public boolean b(Context context, File file, int i2) {
        AppMethodBeat.i(188101);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean a2 = a(context, file, false);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(a2)));
        if (a2) {
            a().a(context, i2);
        }
        AppMethodBeat.o(188101);
        return a2;
    }

    private boolean a(Context context, File file) {
        AppMethodBeat.i(188102);
        boolean a2 = a(context, file, false);
        AppMethodBeat.o(188102);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r11).setInstallInterruptCode(-523);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(r11).setInstallErrorCode(206, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        com.tencent.smtt.utils.f.b(r4);
        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + r4.exists());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0193, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0194, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r11).setInstallInterruptCode(-523);
        com.tencent.smtt.sdk.TbsLogReport.getInstance(r11).setInstallErrorCode(207, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01a6, code lost:
        if (r4 == null) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ae, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        com.tencent.smtt.utils.f.b(r4);
        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + r4.exists());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01de, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01df, code lost:
        com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x020d, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012d A[ExcHandler: IOException (r1v18 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:20:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r11, java.io.File r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 528
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(android.content.Context, java.io.File, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00de, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0194, code lost:
        r1 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4 A[SYNTHETIC, Splitter:B:34:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00de A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1 A[SYNTHETIC, Splitter:B:41:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r12, android.content.Context r13) {
        /*
        // Method dump skipped, instructions count: 416
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(java.io.File, android.content.Context):boolean");
    }

    public boolean f(Context context) {
        String[] list;
        AppMethodBeat.i(188105);
        try {
            File file = new File(f.a(context, 4), TbsDownloader.getBackupFileName(true));
            File f2 = a().f(context, 2);
            f.a(f2);
            f.a(f2, true);
            f.a(file, f2);
            for (String str : f2.list()) {
                File file2 = new File(f2, str);
                if (file2.getName().endsWith(ShareConstants.DEX_SUFFIX)) {
                    file2.delete();
                }
            }
            i(context, 2);
            AppMethodBeat.o(188105);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(188105);
            return false;
        }
    }

    private void i(Context context, int i2) {
        AppMethodBeat.i(188106);
        File f2 = a().f(context, i2);
        a().g(context, true);
        File q = q(context);
        f.a(q, true);
        f2.renameTo(q);
        TbsShareManager.b(context);
        AppMethodBeat.o(188106);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A[Catch:{ Throwable -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j(android.content.Context r10, int r11) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.j(android.content.Context, int):boolean");
    }

    public synchronized boolean a(final Context context, final Context context2) {
        AppMethodBeat.i(188108);
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (p) {
            AppMethodBeat.o(188108);
        } else {
            p = true;
            new Thread() {
                /* class com.tencent.smtt.sdk.q.AnonymousClass4 */

                public void run() {
                    File r;
                    AppMethodBeat.i(188248);
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                    try {
                        if (context2 == null) {
                            r = new File(TbsShareManager.getHostCorePathAppDefined());
                        } else if (!TbsShareManager.isThirdPartyApp(context)) {
                            r = q.this.r(context2);
                        } else if (TbsShareManager.c(context) == null || !TbsShareManager.c(context).contains("decouple")) {
                            r = q.this.r(context2);
                        } else {
                            r = q.this.q(context2);
                        }
                        File r2 = q.this.r(context);
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 != 19 && i2 < 21) {
                            f.a(r, r2, new FileFilter() {
                                /* class com.tencent.smtt.sdk.q.AnonymousClass4.AnonymousClass1 */

                                public boolean accept(File file) {
                                    AppMethodBeat.i(188067);
                                    boolean endsWith = file.getName().endsWith(ShareConstants.DEX_SUFFIX);
                                    AppMethodBeat.o(188067);
                                    return endsWith;
                                }
                            });
                        }
                        f.a(r, r2, new FileFilter() {
                            /* class com.tencent.smtt.sdk.q.AnonymousClass4.AnonymousClass2 */

                            public boolean accept(File file) {
                                AppMethodBeat.i(188193);
                                boolean endsWith = file.getName().endsWith("tbs.conf");
                                AppMethodBeat.o(188193);
                                return endsWith;
                            }
                        });
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                        AppMethodBeat.o(188248);
                    } catch (Exception e2) {
                        AppMethodBeat.o(188248);
                    }
                }
            }.start();
            AppMethodBeat.o(188108);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g(Context context) {
        AppMethodBeat.i(188109);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            AppMethodBeat.o(188109);
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.o(188109);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    AppMethodBeat.o(188109);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    AppMethodBeat.o(188109);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.o(188109);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    AppMethodBeat.o(188109);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                AppMethodBeat.o(188109);
                return false;
            }
            AppMethodBeat.o(188109);
            return true;
        } catch (Exception e2) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            AppMethodBeat.o(188109);
            return false;
        }
    }

    public Context d(Context context, int i2) {
        Context b2;
        AppMethodBeat.i(188110);
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(i2)));
        if (i2 <= 0) {
            AppMethodBeat.o(188110);
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        for (int i3 = 0; i3 < coreProviderAppList.length; i3++) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i3]) && e(context, coreProviderAppList[i3]) && (b2 = b(context, coreProviderAppList[i3])) != null) {
                if (!g(b2)) {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i3] + " illegal signature go on next");
                } else {
                    int j2 = j(b2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=".concat(String.valueOf(j2)));
                    if (j2 != 0 && j2 == i2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i3]);
                        AppMethodBeat.o(188110);
                        return b2;
                    }
                }
            }
        }
        AppMethodBeat.o(188110);
        return null;
    }

    /* access modifiers changed from: package-private */
    public int c(Context context, String str) {
        AppMethodBeat.i(188111);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            int i2 = packageArchiveInfo.versionCode;
            AppMethodBeat.o(188111);
            return i2;
        }
        AppMethodBeat.o(188111);
        return 0;
    }

    public void h(Context context) {
        AppMethodBeat.i(188112);
        boolean z = true;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
        }
        if (z && l != null) {
            f.a(context, l);
            TbsLog.d("TbsInstaller", "releaseTbsCoreRenameFileLock ##!");
        }
        AppMethodBeat.o(188112);
    }

    private boolean x(Context context) {
        boolean z;
        AppMethodBeat.i(188113);
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            z = true;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(z)));
        if (!z) {
            l = x.a().a(context);
        } else {
            l = f.f(context);
        }
        if (l == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            AppMethodBeat.o(188113);
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        AppMethodBeat.o(188113);
        return true;
    }

    private void y(Context context) {
        AppMethodBeat.i(188114);
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (!x(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            AppMethodBeat.o(188114);
            return;
        }
        try {
            B(context);
            C(context);
            TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
            if (!TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
                TbsShareManager.a(context);
            } else {
                TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
            }
            n.a(context).a(0);
            n.a(context).b(0);
            n.a(context).d(0);
            n.a(context).a("incrupdate_retry_num", 0);
            n.a(context).c(0, 3);
            n.a(context).a("");
            n.a(context).a("tpatch_num", 0);
            n.a(context).c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().i(context) || i2 != a().j(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(context) + " getTbsCoreInstalledVerInNolock is " + a().j(context));
                } else {
                    o(context);
                }
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, n(context), true);
            }
            f2104a.set(0);
            o = 0;
        } catch (Throwable th) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
        h(context);
        AppMethodBeat.o(188114);
    }

    private void z(Context context) {
        AppMethodBeat.i(188115);
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
        if (!x(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            AppMethodBeat.o(188115);
            return;
        }
        try {
            B(context);
            E(context);
            TbsShareManager.a(context);
            n.a(context).b(0, -1);
            n.a(context).a("tpatch_num", 0);
            f2104a.set(0);
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(242, "exception when renameing from tpatch:" + e2.toString());
        }
        h(context);
        AppMethodBeat.o(188115);
    }

    private void A(Context context) {
        AppMethodBeat.i(188116);
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (!x(context)) {
            TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
            AppMethodBeat.o(188116);
            return;
        }
        try {
            B(context);
            D(context);
            TbsShareManager.a(context);
            n.a(context).a(0, 3);
            n.a(context).a("tpatch_num", 0);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i2 <= 0 || i2 == a().i(context) || i2 != a().j(context)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(context) + " getTbsCoreInstalledVerInNolock is " + a().j(context));
                } else {
                    o(context);
                }
            }
            f2104a.set(0);
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(TbsListener.ErrorCode.RENAME_EXCEPTION, "exception when renameing from copy:" + e2.toString());
        }
        h(context);
        AppMethodBeat.o(188116);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[SYNTHETIC, Splitter:B:23:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[SYNTHETIC, Splitter:B:28:0x0063] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(java.lang.String):int");
    }

    /* access modifiers changed from: package-private */
    public int e(Context context, int i2) {
        AppMethodBeat.i(188118);
        int a2 = a(f(context, i2));
        AppMethodBeat.o(188118);
        return a2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[SYNTHETIC, Splitter:B:20:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[SYNTHETIC, Splitter:B:25:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.io.File r7) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.a(java.io.File):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[SYNTHETIC, Splitter:B:17:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[SYNTHETIC, Splitter:B:23:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String d(android.content.Context r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.d(android.content.Context, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[SYNTHETIC, Splitter:B:20:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[SYNTHETIC, Splitter:B:25:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.i(android.content.Context):int");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4 A[SYNTHETIC, Splitter:B:28:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc A[SYNTHETIC, Splitter:B:36:0x00dc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.j(android.content.Context):int");
    }

    /* access modifiers changed from: package-private */
    public int k(Context context) {
        AppMethodBeat.i(188123);
        if (o != 0) {
            int i2 = o;
            AppMethodBeat.o(188123);
            return i2;
        }
        int j2 = j(context);
        AppMethodBeat.o(188123);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public void l(Context context) {
        AppMethodBeat.i(188124);
        if (o != 0) {
            AppMethodBeat.o(188124);
            return;
        }
        o = j(context);
        AppMethodBeat.o(188124);
    }

    /* access modifiers changed from: package-private */
    public boolean m(Context context) {
        AppMethodBeat.i(188125);
        if (!new File(r(context), "tbs.conf").exists()) {
            AppMethodBeat.o(188125);
            return false;
        }
        AppMethodBeat.o(188125);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014a A[SYNTHETIC, Splitter:B:49:0x014a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0155 A[Catch:{ Throwable -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0196 A[SYNTHETIC, Splitter:B:63:0x0196] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a1 A[Catch:{ Throwable -> 0x01c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int n(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 490
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.q.n(android.content.Context):int");
    }

    private void B(Context context) {
        AppMethodBeat.i(188127);
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        f.a(r(context), false);
        AppMethodBeat.o(188127);
    }

    private void C(Context context) {
        AppMethodBeat.i(188128);
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File f2 = f(context, 0);
        File r = r(context);
        if (f2 == null || r == null) {
            TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + f2 + "tbsSharePath=" + r);
            AppMethodBeat.o(188128);
            return;
        }
        boolean renameTo = f2.renameTo(r);
        TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=".concat(String.valueOf(renameTo)));
        if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (renameTo) {
                TbsLogReport.getInstance(context).setInstallErrorCode(230, " ");
            } else {
                TbsLogReport.getInstance(context).setInstallErrorCode(231, " ");
            }
        }
        g(context, false);
        AppMethodBeat.o(188128);
    }

    public boolean o(Context context) {
        AppMethodBeat.i(188129);
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File r = r(context);
        File q = q(context);
        try {
            f.a(q, true);
            f.a(r, q, new FileFilter() {
                /* class com.tencent.smtt.sdk.q.AnonymousClass5 */

                public boolean accept(File file) {
                    AppMethodBeat.i(188418);
                    if (file.getName().endsWith(ShareConstants.DEX_SUFFIX) || file.getName().endsWith(".jar_is_first_load_dex_flag_file")) {
                        AppMethodBeat.o(188418);
                        return false;
                    }
                    AppMethodBeat.o(188418);
                    return true;
                }
            });
            TbsShareManager.b(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            AppMethodBeat.o(188129);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(188129);
            return false;
        }
    }

    private void D(Context context) {
        AppMethodBeat.i(188130);
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File f2 = f(context, 1);
        File r = r(context);
        if (f2 == null || r == null) {
            AppMethodBeat.o(188130);
            return;
        }
        f2.renameTo(r);
        g(context, false);
        AppMethodBeat.o(188130);
    }

    private void E(Context context) {
        AppMethodBeat.i(188131);
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
        File f2 = f(context, 5);
        File r = r(context);
        if (f2 == null || r == null) {
            AppMethodBeat.o(188131);
            return;
        }
        f2.renameTo(r);
        g(context, false);
        AppMethodBeat.o(188131);
    }

    private void F(Context context) {
        AppMethodBeat.i(188132);
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File f2 = f(context, 0);
        if (f2 != null) {
            f.a(f2, false);
        }
        n.a(context).c(0, 5);
        n.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
        AppMethodBeat.o(188132);
    }

    /* access modifiers changed from: package-private */
    public void p(Context context) {
        AppMethodBeat.i(188133);
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        n.a(context).a(0);
        n.a(context).b(0);
        n.a(context).d(0);
        n.a(context).a("incrupdate_retry_num", 0);
        if (!TbsDownloader.a(context)) {
            n.a(context).c(0, -1);
            n.a(context).a("");
            n.a(context).a("copy_retry_num", 0);
            n.a(context).c(-1);
            n.a(context).a(0, -1);
            f.a(f(context, 0), true);
            f.a(f(context, 1), true);
        }
        AppMethodBeat.o(188133);
    }

    /* access modifiers changed from: package-private */
    public File b(Context context, Context context2) {
        AppMethodBeat.i(188134);
        File coreDir = TbsOneGreyInfoHelper.getCoreDir(context);
        AppMethodBeat.o(188134);
        return coreDir;
    }

    /* access modifiers changed from: package-private */
    public File q(Context context) {
        AppMethodBeat.i(188135);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(188135);
            return file;
        }
        AppMethodBeat.o(188135);
        return null;
    }

    /* access modifiers changed from: package-private */
    public File c(Context context, Context context2) {
        AppMethodBeat.i(188136);
        File file = new File(QbSdk.getTbsFolderDir(context2), "core_share_decouple");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            AppMethodBeat.o(188136);
            return file;
        }
        AppMethodBeat.o(188136);
        return null;
    }

    /* access modifiers changed from: package-private */
    public File r(Context context) {
        AppMethodBeat.i(188137);
        File b2 = b(context, context);
        AppMethodBeat.o(188137);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public File s(Context context) {
        AppMethodBeat.i(188138);
        File file = new File(QbSdk.getTbsFolderDir(context), "share");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(188138);
            return file;
        }
        AppMethodBeat.o(188138);
        return null;
    }

    static File t(Context context) {
        AppMethodBeat.i(188139);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(188139);
            return file;
        }
        AppMethodBeat.o(188139);
        return null;
    }

    /* access modifiers changed from: package-private */
    public File f(Context context, int i2) {
        AppMethodBeat.i(188140);
        File a2 = a(context, i2, true);
        AppMethodBeat.o(188140);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public File a(Context context, int i2, boolean z) {
        AppMethodBeat.i(188141);
        File tbsFolderDir = QbSdk.getTbsFolderDir(context);
        String str = "";
        switch (i2) {
            case 0:
                str = "core_unzip_tmp";
                break;
            case 1:
                str = "core_copy_tmp";
                break;
            case 2:
                str = "core_unzip_tmp_decouple";
                break;
            case 3:
                str = "core_share_backup";
                break;
            case 4:
                str = "core_share_backup_tmp";
                break;
            case 5:
                str = "tpatch_tmp";
                break;
            case 6:
                str = "tpatch_decouple_tmp";
                break;
        }
        TbsLog.i("TbsInstaller", "type=" + i2 + "needMakeDir=" + z + "folder=" + str);
        File file = new File(tbsFolderDir, str);
        if (!file.isDirectory()) {
            if (!z) {
                TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
                AppMethodBeat.o(188141);
                return null;
            } else if (!file.mkdir()) {
                TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
                AppMethodBeat.o(188141);
                return null;
            }
        }
        AppMethodBeat.o(188141);
        return file;
    }

    /* access modifiers changed from: package-private */
    public boolean g(Context context, int i2) {
        File file;
        boolean z = true;
        AppMethodBeat.i(188142);
        try {
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                file = r(context);
            } else if (TbsShareManager.j(context)) {
                File file2 = new File(TbsShareManager.c(context));
                if (file2.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    AppMethodBeat.o(188142);
                    return true;
                }
                file = file2;
            } else {
                TbsLog.e("TbsInstaller", "321");
                AppMethodBeat.o(188142);
                return false;
            }
            if (file != null) {
                Long[][] lArr = n;
                int length = lArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    Long[] lArr2 = lArr[i3];
                    if (i2 == lArr2[0].intValue()) {
                        File file3 = new File(file, "libmttwebview.so");
                        if (!file3.exists() || file3.length() != lArr2[1].longValue()) {
                            if (!isThirdPartyApp) {
                                f.b(QbSdk.getTbsFolderDir(context));
                            }
                            f2104a.set(0);
                            TbsLog.e("TbsInstaller", "322");
                            z = false;
                        } else {
                            TbsLog.d("TbsInstaller", "check so success: " + i2 + "; file: " + file3);
                        }
                    } else {
                        i3++;
                    }
                }
            } else {
                TbsLog.e("TbsInstaller", "323");
                z = false;
            }
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            z = false;
        }
        AppMethodBeat.o(188142);
        return z;
    }

    public boolean a(Context context, File[] fileArr) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean u(Context context) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(188143);
            TbsLog.d("TbsInstaller", "getTbsInstallingFileLock,current Thread Id=" + Thread.currentThread().getId() + "," + this.f2110e);
            if (this.f2110e > 0) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
                this.f2110e++;
                AppMethodBeat.o(188143);
            } else {
                this.f2112g = f.b(context, true, "tbslock.txt");
                if (this.f2112g != null) {
                    this.f2111f = f.a(context, this.f2112g);
                    if (this.f2111f == null) {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
                        AppMethodBeat.o(188143);
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.f2110e++;
                        AppMethodBeat.o(188143);
                    }
                } else {
                    TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
                    AppMethodBeat.o(188143);
                    z = false;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        AppMethodBeat.i(54372);
        if (this.f2110e <= 0) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.f2110e + "call stack:" + Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(54372);
        } else {
            TbsLog.d("TbsInstaller", "releaseTbsInstallingFileLock,current Thread Id=" + Thread.currentThread().getId() + "currentTbsFileLockStackCount=" + this.f2110e);
            if (this.f2110e > 1) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
                this.f2110e--;
                AppMethodBeat.o(54372);
            } else {
                if (this.f2110e == 1) {
                    TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                    f.a(this.f2111f, this.f2112g);
                    this.f2110e = 0;
                }
                AppMethodBeat.o(54372);
            }
        }
    }

    private boolean b(Context context, File file) {
        AppMethodBeat.i(188144);
        try {
            File[] listFiles = file.listFiles(new FileFilter() {
                /* class com.tencent.smtt.sdk.q.AnonymousClass6 */

                public boolean accept(File file) {
                    AppMethodBeat.i(188305);
                    boolean endsWith = file.getName().endsWith(ShareConstants.JAR_SUFFIX);
                    AppMethodBeat.o(188305);
                    return endsWith;
                }
            });
            int length = listFiles.length;
            if (Build.VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e2) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i2 = 0; i2 < length; i2++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i2].getAbsolutePath());
                new DexClassLoader(listFiles[i2].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            AppMethodBeat.o(188144);
            return true;
        } catch (Exception e3) {
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e3.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            AppMethodBeat.o(188144);
            return false;
        }
    }

    private boolean c(Context context, File file) {
        AppMethodBeat.i(188145);
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String a2 = e.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a2)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, "can not find oat command");
                AppMethodBeat.o(188145);
                return false;
            }
            File[] listFiles = file.listFiles(new FileFilter() {
                /* class com.tencent.smtt.sdk.q.AnonymousClass7 */

                public boolean accept(File file) {
                    AppMethodBeat.i(188321);
                    boolean endsWith = file.getName().endsWith(ShareConstants.JAR_SUFFIX);
                    AppMethodBeat.o(188321);
                    return endsWith;
                }
            });
            for (File file4 : listFiles) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + a2.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + a().r(context) + File.separator + substring + ShareConstants.JAR_SUFFIX).waitFor();
            }
            AppMethodBeat.o(188145);
            return true;
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(226, e2);
            AppMethodBeat.o(188145);
            return false;
        }
    }
}
