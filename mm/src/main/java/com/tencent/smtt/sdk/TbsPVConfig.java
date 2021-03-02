package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsPVConfig extends TbsBaseConfig {

    /* renamed from: b  reason: collision with root package name */
    private static TbsPVConfig f1854b;
    public SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_DISABLE_TBS_ONE_GREY = "disable_tbs_one_grey";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
        public static final String KEY_TBS_CORE_SANDBOX_MODE_ENABLE = "tbs_core_sandbox_mode_enable";
    }

    private TbsPVConfig() {
    }

    @Override // com.tencent.smtt.sdk.TbsBaseConfig
    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    public static synchronized TbsPVConfig getInstance(Context context) {
        TbsPVConfig tbsPVConfig;
        synchronized (TbsPVConfig.class) {
            AppMethodBeat.i(54664);
            if (f1854b == null) {
                TbsPVConfig tbsPVConfig2 = new TbsPVConfig();
                f1854b = tbsPVConfig2;
                tbsPVConfig2.init(context);
            }
            tbsPVConfig = f1854b;
            AppMethodBeat.o(54664);
        }
        return tbsPVConfig;
    }

    public static synchronized void releaseInstance() {
        synchronized (TbsPVConfig.class) {
            f1854b = null;
        }
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int i2;
        AppMethodBeat.i(54665);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
                AppMethodBeat.o(54665);
            }
        } catch (Exception e2) {
        }
        i2 = 0;
        AppMethodBeat.o(54665);
        return i2;
    }

    public synchronized int getEmergentCoreVersion() {
        int i2;
        AppMethodBeat.i(54666);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
                AppMethodBeat.o(54666);
            }
        } catch (Exception e2) {
        }
        i2 = 0;
        AppMethodBeat.o(54666);
        return i2;
    }

    public synchronized int getReadApk() {
        int i2;
        AppMethodBeat.i(54667);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_READ_APK);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
                AppMethodBeat.o(54667);
            }
        } catch (Exception e2) {
        }
        i2 = 0;
        AppMethodBeat.o(54667);
        return i2;
    }

    public synchronized int getDisabledCoreVersion() {
        int i2;
        AppMethodBeat.i(54668);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
                AppMethodBeat.o(54668);
            }
        } catch (Exception e2) {
        }
        i2 = 0;
        AppMethodBeat.o(54668);
        return i2;
    }

    public synchronized boolean isEnableNoCoreGray() {
        boolean z;
        AppMethodBeat.i(54669);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
            if (!TextUtils.isEmpty(str) && str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z = true;
                AppMethodBeat.o(54669);
            }
        } catch (Exception e2) {
        }
        z = false;
        AppMethodBeat.o(54669);
        return z;
    }

    public synchronized boolean getTbsCoreSandboxModeEnable() {
        boolean z;
        AppMethodBeat.i(54670);
        try {
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals((String) this.f1773a.get(TbsPVConfigKey.KEY_TBS_CORE_SANDBOX_MODE_ENABLE))) {
                z = true;
                AppMethodBeat.o(54670);
            }
        } catch (Exception e2) {
        }
        z = false;
        AppMethodBeat.o(54670);
        return z;
    }

    public synchronized boolean isDisableHostBackupCore() {
        boolean z;
        AppMethodBeat.i(54671);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
            if (!TextUtils.isEmpty(str) && str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z = true;
                AppMethodBeat.o(54671);
            }
        } catch (Exception e2) {
        }
        z = false;
        AppMethodBeat.o(54671);
        return z;
    }

    public synchronized boolean isDisableTbsOneGrey() {
        boolean z;
        AppMethodBeat.i(54672);
        try {
            String str = (String) this.f1773a.get(TbsPVConfigKey.KEY_DISABLE_TBS_ONE_GREY);
            if (!TextUtils.isEmpty(str) && str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z = true;
                AppMethodBeat.o(54672);
            }
        } catch (Exception e2) {
        }
        z = false;
        AppMethodBeat.o(54672);
        return z;
    }

    public synchronized void putData(String str, String str2) {
        AppMethodBeat.i(54673);
        this.f1773a.put(str, str2);
        AppMethodBeat.o(54673);
    }
}
