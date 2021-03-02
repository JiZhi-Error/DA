package com.tencent.midas.comm;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.util.Iterator;

public class APLogInfo {
    public static final String LOG_TAG = "MidasComm<Log>";
    public static final int LOG_VERSION_CODE = 39;
    public static final String LOG_VERSION_NAME = "1.2.19";
    private boolean autoFlush = true;
    private boolean compressLog = true;
    private Context context = null;
    private boolean encryptLog = true;
    private boolean hasWritePermission = false;
    private boolean logEnable = true;
    private String logPath = "";
    private String logTag = "Midas";
    private String pkgName = "";
    private boolean printLog = false;
    private String processName = "";
    private boolean writeLog = true;

    public void init() {
        AppMethodBeat.i(193391);
        if (this.context == null) {
            AppMethodBeat.o(193391);
            return;
        }
        initPkgName();
        initPermission();
        initProcessName();
        initLogPath();
        AppMethodBeat.o(193391);
    }

    private void initPkgName() {
        AppMethodBeat.i(193392);
        if (this.context == null) {
            AppMethodBeat.o(193392);
            return;
        }
        try {
            this.pkgName = this.context.getPackageManager().getPackageInfo(this.context.getApplicationContext().getPackageName(), 0).packageName;
        } catch (Throwable th) {
            new StringBuilder("getPackage: ").append(th.toString());
        }
        new StringBuilder("get pkgName: ").append(this.pkgName);
        AppMethodBeat.o(193392);
    }

    private void initPermission() {
        AppMethodBeat.i(193393);
        this.hasWritePermission = this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pkgName) == 0;
        new StringBuilder("has WRITE_EXTERNAL_STORAGE? : ").append(this.hasWritePermission);
        AppMethodBeat.o(193393);
    }

    private void initProcessName() {
        AppMethodBeat.i(193394);
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (activityManager != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        String[] split = next.processName.split(":");
                        if (split.length > 1) {
                            this.processName = split[1];
                        } else {
                            this.processName = "";
                        }
                    }
                }
            }
        } catch (Throwable th) {
            new StringBuilder("get process: ").append(th.toString());
        }
        new StringBuilder("get process name: ").append(this.processName);
        AppMethodBeat.o(193394);
    }

    private void initLogPath() {
        AppMethodBeat.i(193395);
        try {
            if (!this.hasWritePermission) {
                File externalFilesDir = this.context.getExternalFilesDir("midas" + File.separator + "log" + File.separator);
                this.logPath = externalFilesDir == null ? "" : externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(this.logPath) || !new File(this.logPath).canWrite()) {
                this.logPath = Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator;
            }
            AppMethodBeat.o(193395);
        } catch (Throwable th) {
            new StringBuilder("init log path error: ").append(th.getMessage());
            this.logPath = Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator;
            AppMethodBeat.o(193395);
        }
    }

    public boolean isAutoFlush() {
        return this.autoFlush;
    }

    public void setAutoFlush(boolean z) {
        this.autoFlush = z;
    }

    public void setContext(Context context2) {
        AppMethodBeat.i(193396);
        this.context = context2.getApplicationContext();
        AppMethodBeat.o(193396);
    }

    public Context getContext() {
        return this.context;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setLogEnable(boolean z) {
        this.logEnable = z;
    }

    public boolean isLogEnable() {
        return this.logEnable;
    }

    public void setLogTag(String str) {
        this.logTag = str;
    }

    public String getLogTag() {
        return this.logTag;
    }

    public void setLogParamFromServer(String str) {
        AppMethodBeat.i(193397);
        setLogWrite(str);
        AppMethodBeat.o(193397);
    }

    public void setLogWrite(String str) {
        int i2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(193398);
        try {
            i2 = Integer.valueOf(str).intValue();
        } catch (Throwable th) {
            i2 = 3;
        }
        if ((i2 & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        setPrintLog(z);
        if ((i2 & 2) != 2) {
            z2 = false;
        }
        setWriteLog(z2);
        AppMethodBeat.o(193398);
    }

    private void setWriteLog(boolean z) {
        this.writeLog = z;
    }

    public boolean isWriteLog() {
        return this.writeLog;
    }

    private void setPrintLog(boolean z) {
        this.printLog = z;
    }

    public boolean isPrintLog() {
        return this.printLog;
    }

    public boolean shouldPrintLog() {
        AppMethodBeat.i(193399);
        if (this.logEnable || this.printLog || APLogFileUtil.isDebugMode(APLogFileInfo.dirName)) {
            AppMethodBeat.o(193399);
            return true;
        }
        AppMethodBeat.o(193399);
        return false;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public boolean isHasWritePermission() {
        return this.hasWritePermission;
    }

    public void setCompressLog(boolean z) {
        this.compressLog = z;
    }

    public boolean isCompressLog() {
        return this.compressLog;
    }

    public void setEncryptLog(boolean z) {
        this.encryptLog = z;
    }

    public boolean isEncryptLog() {
        return this.encryptLog;
    }

    public void setEncryptKey(String str) {
        AppMethodBeat.i(193400);
        APLogEncryptor.setEncryptKey(str);
        AppMethodBeat.o(193400);
    }

    public void setEncryptProtocolVersion(byte b2) {
        AppMethodBeat.i(193401);
        APLogEncryptor.setProtocolVersion(b2);
        AppMethodBeat.o(193401);
    }

    public void setLogFileSizeMB(int i2) {
        AppMethodBeat.i(193402);
        APLogFileUtil.maxLogFileSizeMB = i2;
        new StringBuilder("set log file size: ").append(i2).append(" MB");
        AppMethodBeat.o(193402);
    }

    public void setLogFileNum(int i2) {
        APLogFileUtil.maxLogFileNum = i2;
    }

    public void setLogFileKeepDays(int i2) {
        APLogFileUtil.maxLogKeepDays = i2;
    }
}
