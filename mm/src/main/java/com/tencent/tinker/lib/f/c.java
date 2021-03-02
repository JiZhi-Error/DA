package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.c.b.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class c {
    private static c Sks;
    public boolean Skt = true;
    public File Sku = null;
    public File Skv = null;
    private Context context = null;
    public int yiR = 20;

    private c(Context context2) {
        this.context = context2;
        this.Sku = new File(SharePatchFileUtil.getPatchTempDirectory(context2), "patch.retry");
        this.Skv = new File(SharePatchFileUtil.getPatchTempDirectory(context2), "temp.apk");
    }

    public static c lp(Context context2) {
        if (Sks == null) {
            Sks = new c(context2);
        }
        return Sks;
    }

    public final boolean hpj() {
        if (!this.Skt) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!com.tencent.tinker.lib.e.a.lk(this.context).FgY) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.Sku.exists()) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (b.lm(this.context)) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.Skv.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
                return false;
            }
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", absolutePath);
            com.tencent.tinker.lib.e.c.cY(this.context, absolutePath);
            return true;
        }
    }

    public final boolean bqK(String str) {
        int parseInt;
        if (!this.Skt) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.Sku.exists()) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            a ag = a.ag(this.Sku);
            if (!str.equals(ag.md5) || (parseInt = Integer.parseInt(ag.Skw)) < this.yiR) {
                return true;
            }
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", Integer.valueOf(parseInt));
            SharePatchFileUtil.safeDeleteFile(this.Skv);
            return false;
        }
    }

    public final boolean bqL(String str) {
        if (!this.Skt) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
        } else if (!this.Sku.exists()) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
        } else if (str == null) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
        } else {
            a ag = a.ag(this.Sku);
            if (str.equals(ag.md5)) {
                ShareTinkerLog.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                ag.Skw = "1";
                a.a(this.Sku, ag);
            }
        }
        return true;
    }

    public final void af(File file) {
        if (!file.getAbsolutePath().equals(this.Skv.getAbsolutePath())) {
            ShareTinkerLog.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", file.getAbsolutePath(), this.Skv.getAbsolutePath());
            try {
                SharePatchFileUtil.copyFileUsingStream(file, this.Skv);
            } catch (IOException e2) {
                ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", file.getAbsolutePath(), this.Skv.getAbsolutePath());
            }
        }
    }

    public static class a {
        public String Skw;
        public String md5;

        public a(String str, String str2) {
            this.md5 = str;
            this.Skw = str2;
        }

        public static a ag(File file) {
            FileInputStream fileInputStream;
            Throwable th;
            IOException e2;
            String str;
            String str2 = null;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str = properties.getProperty("md5");
                } catch (IOException e3) {
                    e2 = e3;
                    str = null;
                    try {
                        ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e2)), new Object[0]);
                        b.closeQuietly(fileInputStream);
                        return new a(str, str2);
                    } catch (Throwable th2) {
                        th = th2;
                        b.closeQuietly(fileInputStream);
                        throw th;
                    }
                }
                try {
                    str2 = properties.getProperty("times");
                    b.closeQuietly(fileInputStream);
                } catch (IOException e4) {
                    e2 = e4;
                    ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e2)), new Object[0]);
                    b.closeQuietly(fileInputStream);
                    return new a(str, str2);
                }
            } catch (IOException e5) {
                e2 = e5;
                fileInputStream = null;
                str = null;
                ShareTinkerLog.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:".concat(String.valueOf(e2)), new Object[0]);
                b.closeQuietly(fileInputStream);
                return new a(str, str2);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                b.closeQuietly(fileInputStream);
                throw th;
            }
            return new a(str, str2);
        }

        public static void a(File file, a aVar) {
            FileOutputStream fileOutputStream;
            Throwable th;
            Exception e2;
            if (aVar != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put("md5", aVar.md5);
                properties.put("times", aVar.Skw);
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, (String) null);
                        b.closeQuietly(fileOutputStream);
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            ShareTinkerLog.printErrStackTrace("Tinker.UpgradePatchRetry", e2, "retry write property fail", new Object[0]);
                            b.closeQuietly(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            b.closeQuietly(fileOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    fileOutputStream = null;
                    ShareTinkerLog.printErrStackTrace("Tinker.UpgradePatchRetry", e2, "retry write property fail", new Object[0]);
                    b.closeQuietly(fileOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    b.closeQuietly(fileOutputStream);
                    throw th;
                }
            }
        }
    }
}
