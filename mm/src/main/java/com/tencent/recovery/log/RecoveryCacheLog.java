package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLog.RecoveryLogImpl {
    private static final int MAX_SIZE = 100;
    private List<LogItem> logCacheList = new ArrayList(100);

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void v(String str, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 1;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void d(String str, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 2;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void i(String str, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 3;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void w(String str, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 4;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void e(String str, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.logCacheList.size() < 100) {
            LogItem logItem = new LogItem();
            logItem.level = 5;
            logItem.tag = str;
            logItem.format = str2;
            logItem.args = objArr;
            logItem.f1560e = th;
            this.logCacheList.add(logItem);
        }
        String.format(str2, objArr);
    }

    @Override // com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl
    public void setDebugMode() {
    }

    public void printAll(RecoveryLog.RecoveryLogImpl recoveryLogImpl) {
        int size = this.logCacheList.size();
        for (int i2 = 0; i2 < size; i2++) {
            LogItem logItem = this.logCacheList.get(i2);
            switch (logItem.level) {
                case 1:
                    recoveryLogImpl.v(logItem.tag, logItem.format, logItem.args);
                    break;
                case 2:
                    recoveryLogImpl.d(logItem.tag, logItem.format, logItem.args);
                    break;
                case 3:
                    recoveryLogImpl.i(logItem.tag, logItem.format, logItem.args);
                    break;
                case 4:
                    recoveryLogImpl.w(logItem.tag, logItem.format, logItem.args);
                    break;
                case 5:
                    if (logItem.f1560e != null) {
                        recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.f1560e, logItem.format, logItem.args);
                        break;
                    } else {
                        recoveryLogImpl.e(logItem.tag, logItem.format, logItem.args);
                        break;
                    }
            }
        }
        this.logCacheList = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public class LogItem {
        Object[] args;

        /* renamed from: e  reason: collision with root package name */
        Throwable f1560e;
        String format;
        int level;
        String tag;

        private LogItem() {
        }
    }
}
