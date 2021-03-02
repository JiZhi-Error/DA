package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;

public class DownloadSetting {
    public static final String ISDOWNLOADWIFIONLY = "isDownloadWifiOnly";
    public static final String ISTASKAUTORESUME = "isTaskAutoResume";
    public static final String MAXTASKNUM = "maxTaskNum";
    private static final String TAG = "DownloadSetting";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_INTEGER = "Integer";
    protected static DownloadSetting mInstance = null;
    protected boolean isDownloadWifiOnly = false;
    protected boolean isTaskAutoResume = true;
    protected int maxTaskNum = 5;

    public DownloadSetting() {
        AppMethodBeat.i(101980);
        loadFromDB();
        AppMethodBeat.o(101980);
    }

    public static synchronized DownloadSetting getInstance() {
        DownloadSetting downloadSetting;
        synchronized (DownloadSetting.class) {
            AppMethodBeat.i(101981);
            if (mInstance == null) {
                mInstance = new DownloadSetting();
            }
            downloadSetting = mInstance;
            AppMethodBeat.o(101981);
        }
        return downloadSetting;
    }

    static int getSplitSizeInBytes(String str) {
        AppMethodBeat.i(101982);
        if (str.equalsIgnoreCase("WIFI")) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Split is not allowed in current version. netType: ".concat(String.valueOf(str)));
            AppMethodBeat.o(101982);
            throw unsupportedOperationException;
        } else if (str.contains("net")) {
            AppMethodBeat.o(101982);
            return Downloads.SPLIT_RANGE_SIZE_NET;
        } else if (str.contains("wap")) {
            AppMethodBeat.o(101982);
            return Downloads.SPLIT_RANGE_SIZE_WAP;
        } else {
            AppMethodBeat.o(101982);
            return Downloads.SPLIT_RANGE_SIZE_NET;
        }
    }

    public void setIsTaskAutoResume(boolean z) {
        AppMethodBeat.i(101983);
        if (mInstance.isTaskAutoResume == z) {
            AppMethodBeat.o(101983);
            return;
        }
        mInstance.isTaskAutoResume = z;
        DownloadSettingTable.save(ISTASKAUTORESUME, String.valueOf(z), TYPE_BOOLEAN);
        AppMethodBeat.o(101983);
    }

    public void setIsDownloadWifiOnly(boolean z) {
        AppMethodBeat.i(101984);
        if (mInstance.isDownloadWifiOnly == z) {
            AppMethodBeat.o(101984);
            return;
        }
        mInstance.isDownloadWifiOnly = z;
        DownloadSettingTable.save(ISDOWNLOADWIFIONLY, String.valueOf(z), TYPE_BOOLEAN);
        AppMethodBeat.o(101984);
    }

    public void setMaxTaskNum(int i2) {
        AppMethodBeat.i(101985);
        if (mInstance.maxTaskNum == i2) {
            AppMethodBeat.o(101985);
            return;
        }
        mInstance.maxTaskNum = i2;
        DownloadSettingTable.save(MAXTASKNUM, String.valueOf(i2), TYPE_INTEGER);
        AppMethodBeat.o(101985);
    }

    private void loadFromDB() {
        boolean z = true;
        AppMethodBeat.i(101986);
        HashMap<String, String> query = DownloadSettingTable.query();
        String str = query.get(ISTASKAUTORESUME);
        if (str != null && str.length() > 0) {
            this.isTaskAutoResume = !str.equals("false");
        }
        String str2 = query.get(ISDOWNLOADWIFIONLY);
        if (str2 != null && str2.length() > 0) {
            if (str2.equals("false")) {
                z = false;
            }
            this.isDownloadWifiOnly = z;
        }
        String str3 = query.get(MAXTASKNUM);
        if (str3 != null && str3.length() > 0) {
            this.maxTaskNum = Util.getInt(str3, 0);
        }
        AppMethodBeat.o(101986);
    }

    public boolean getIsTaskAutoResume() {
        return this.isTaskAutoResume;
    }

    public boolean getIsDownloadWifiOnly() {
        return this.isDownloadWifiOnly;
    }

    public int getMaxTaskNum() {
        return this.maxTaskNum;
    }

    public boolean isAutoDownload() {
        AppMethodBeat.i(101987);
        if (this.isTaskAutoResume) {
            String netStatus = DownloadHelper.getNetStatus();
            if (netStatus.contains("wifi") || netStatus.contains("net")) {
                AppMethodBeat.o(101987);
                return true;
            }
        }
        AppMethodBeat.o(101987);
        return false;
    }

    public boolean isAutoDownload(String str, String str2) {
        AppMethodBeat.i(101988);
        TMLog.i(TAG, "downloadInfoNetType = ".concat(String.valueOf(str)));
        TMLog.i(TAG, "currentNetType = ".concat(String.valueOf(str2)));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(101988);
            return false;
        } else if (str2.equalsIgnoreCase("WIFI")) {
            AppMethodBeat.o(101988);
            return true;
        } else if (!str2.contains("net") || str.equalsIgnoreCase("WIFI")) {
            AppMethodBeat.o(101988);
            return false;
        } else {
            AppMethodBeat.o(101988);
            return true;
        }
    }
}
