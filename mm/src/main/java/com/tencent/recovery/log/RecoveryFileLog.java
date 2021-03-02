package com.tencent.recovery.log;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.storage.MMappedFileStorage;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog implements RecoveryLog.RecoveryLogImpl {
    public static final String LINE_SPLITTER = "​​";
    private static final int MAX_LOG_LENGTH = 5242880;
    public static final String SPLITTER = "​";
    private SimpleDateFormat formatter;
    private boolean isDebugMode;
    private MMappedFileStorage mmappedFileStorage;

    public RecoveryFileLog(Context context) {
        File file = new File(context.getFilesDir(), ConstantsRecovery.RECOVERY_CONF_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "recovery.log");
        if (file2.length() > 5242880) {
            file2.delete();
        }
        this.mmappedFileStorage = new MMappedFileStorage(file2.getAbsolutePath());
        this.formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    }

    /* access modifiers changed from: protected */
    public void appendToBuffer(String str) {
        appendToBuffer(str, false);
    }

    public synchronized void appendToBuffer(String str, boolean z) {
        this.mmappedFileStorage.appendToBuffer(str.getBytes(), z);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void v(String str, String str2, Object... objArr) {
        appendToBuffer(generateLog("V", str, String.format(str2, objArr)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void i(String str, String str2, Object... objArr) {
        appendToBuffer(generateLog("I", str, String.format(str2, objArr)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void w(String str, String str2, Object... objArr) {
        appendToBuffer(generateLog(QLog.TAG_REPORTLEVEL_COLORUSER, str, String.format(str2, objArr)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void d(String str, String str2, Object... objArr) {
        appendToBuffer(generateLog(QLog.TAG_REPORTLEVEL_DEVELOPER, str, String.format(str2, objArr)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void e(String str, String str2, Object... objArr) {
        appendToBuffer(generateLog(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        appendToBuffer(generateLog(QLog.TAG_REPORTLEVEL_USER, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)));
        if (this.isDebugMode) {
            String.format(str2, objArr);
        }
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void setDebugMode() {
        this.isDebugMode = true;
    }

    private String generateLog(String str, String str2, String str3) {
        return String.format("%s​%s​[%d][%d][%s]: %s​​", str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), this.formatter.format(new Date()), str3);
    }
}
