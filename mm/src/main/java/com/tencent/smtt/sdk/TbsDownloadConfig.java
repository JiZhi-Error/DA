package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;

    /* renamed from: a  reason: collision with root package name */
    private static TbsDownloadConfig f1785a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1786b;
    public SharedPreferences mPreferences;
    public Map<String, Object> mSyncMap = new HashMap();

    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
        public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_FULL_PACKAGE = "request_full_package";
        public static final String KEY_GUID = "tbs_guid";
        public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
        public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_REQUEST_FAIL = "request_fail";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final String KEY_USE_BUGLY = "tbs_use_bugly";
    }

    private TbsDownloadConfig(Context context) {
        AppMethodBeat.i(54073);
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        this.f1786b = context.getApplicationContext();
        if (this.f1786b == null) {
            this.f1786b = context;
        }
        AppMethodBeat.o(54073);
    }

    public static synchronized TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            AppMethodBeat.i(54074);
            if (f1785a == null) {
                f1785a = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = f1785a;
            AppMethodBeat.o(54074);
        }
        return tbsDownloadConfig;
    }

    public static synchronized TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            tbsDownloadConfig = f1785a;
        }
        return tbsDownloadConfig;
    }

    public synchronized long getDownloadMaxflow() {
        long j2;
        AppMethodBeat.i(54075);
        int i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i2 == 0) {
            i2 = 20;
        }
        j2 = ((long) (i2 * 1024)) * 1024;
        AppMethodBeat.o(54075);
        return j2;
    }

    public synchronized long getRetryInterval() {
        long j2;
        AppMethodBeat.i(54076);
        if (TbsDownloader.getRetryIntervalInSeconds() >= 0) {
            j2 = TbsDownloader.getRetryIntervalInSeconds();
            AppMethodBeat.o(54076);
        } else {
            j2 = this.mPreferences.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, 86400);
            AppMethodBeat.o(54076);
        }
        return j2;
    }

    public synchronized long getDownloadMinFreeSpace() {
        long j2;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(54077);
            int i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
            if (i3 != 0) {
                i2 = i3;
            }
            j2 = ((long) (i2 * 1024)) * 1024;
            AppMethodBeat.o(54077);
        }
        return j2;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i2;
        AppMethodBeat.i(54078);
        i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        if (i2 == 0) {
            i2 = 3;
            AppMethodBeat.o(54078);
        } else {
            AppMethodBeat.o(54078);
        }
        return i2;
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i2;
        AppMethodBeat.i(54079);
        i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        if (i2 == 0) {
            i2 = 100;
            AppMethodBeat.o(54079);
        } else {
            AppMethodBeat.o(54079);
        }
        return i2;
    }

    public synchronized void setDownloadInterruptCode(int i2) {
        AppMethodBeat.i(54080);
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, i2);
            edit.putLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, System.currentTimeMillis());
            edit.commit();
            AppMethodBeat.o(54080);
        } catch (Exception e2) {
            AppMethodBeat.o(54080);
        }
    }

    public synchronized void setTbsCoreLoadRenameFileLockEnable(boolean z) {
        AppMethodBeat.i(54081);
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, z);
            edit.commit();
            AppMethodBeat.o(54081);
        } catch (Exception e2) {
            AppMethodBeat.o(54081);
        }
    }

    public synchronized void setTbsCoreLoadRenameFileLockWaitEnable(boolean z) {
        AppMethodBeat.i(54082);
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, z);
            edit.commit();
            AppMethodBeat.o(54082);
        } catch (Exception e2) {
            AppMethodBeat.o(54082);
        }
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockEnable() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(54083);
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, true);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(54083);
        }
        return z;
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockWaitEnable() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(54084);
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, true);
            } catch (Exception e2) {
            }
            AppMethodBeat.o(54084);
        }
        return z;
    }

    public synchronized void uploadDownloadInterruptCodeIfNeeded(Context context) {
        int i2;
        AppMethodBeat.i(54085);
        if (context != null) {
            try {
                if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                    boolean z = true;
                    if (!this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
                        try {
                            i2 = !new File(new File(this.f1786b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : -101;
                        } catch (Throwable th) {
                            i2 = -95;
                        }
                    } else {
                        i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
                        if ((i2 > -206 || i2 < -219) && ((i2 > -302 || i2 < -316) && (i2 > -318 || i2 < -322))) {
                            z = false;
                        }
                    }
                    if (z) {
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                        tbsLogInfo.setErrorCode(128);
                        tbsLogInfo.setFailDetail(" ".concat(String.valueOf(i2)));
                        TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(54085);
            }
        }
        AppMethodBeat.o(54085);
    }

    public synchronized int getDownloadInterruptCode() {
        int i2;
        int i3;
        AppMethodBeat.i(54086);
        if (!this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
            try {
                if (!new File(new File(this.f1786b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists()) {
                    i2 = -97;
                } else if (!this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD)) {
                    i2 = -96;
                } else {
                    i2 = -101;
                }
            } catch (Throwable th) {
                i2 = -95;
            }
        } else {
            i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
            if (i2 == -119 || i2 == -121) {
                i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -119);
            }
            if (System.currentTimeMillis() - this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, 0) > Util.MILLSECONDS_OF_DAY) {
                i2 -= 98000;
            }
        }
        if (this.f1786b == null || !TbsConfig.APP_QQ.equals(this.f1786b.getApplicationInfo().packageName) || WeChatBrands.AppInfo.LANG_CN.equals(Locale.getDefault().getCountry())) {
            i3 = (i2 * 1000) + this.mPreferences.getInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, -1);
            AppMethodBeat.o(54086);
        } else {
            i3 = -320;
            AppMethodBeat.o(54086);
        }
        return i3;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j2;
        AppMethodBeat.i(54087);
        j2 = this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0);
        if (j2 == 0) {
            j2 = 1200000;
            AppMethodBeat.o(54087);
        } else {
            AppMethodBeat.o(54087);
        }
        return j2;
    }

    public synchronized boolean isOverSea() {
        boolean z;
        AppMethodBeat.i(54088);
        z = this.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
        AppMethodBeat.o(54088);
        return z;
    }

    public synchronized void commit() {
        AppMethodBeat.i(54089);
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            for (String str : this.mSyncMap.keySet()) {
                Object obj = this.mSyncMap.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                }
            }
            edit.commit();
            this.mSyncMap.clear();
            AppMethodBeat.o(54089);
        } catch (Exception e2) {
            AppMethodBeat.o(54089);
        }
    }

    public void clear() {
        AppMethodBeat.i(54090);
        try {
            this.mSyncMap.clear();
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.clear();
            edit.commit();
            AppMethodBeat.o(54090);
        } catch (Exception e2) {
            AppMethodBeat.o(54090);
        }
    }

    public synchronized void setInstallInterruptCode(int i2) {
        AppMethodBeat.i(54091);
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i2);
        edit.commit();
        AppMethodBeat.o(54091);
    }
}
