package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

public class TPDownloadProxy implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxy";
    private String mCurrentStoragePath = "";
    private boolean mIsInit = false;
    private int mServiceType;

    public TPDownloadProxy(int i2) {
        this.mServiceType = i2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public synchronized int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(209900);
            if (this.mIsInit) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "download already init");
                AppMethodBeat.o(209900);
            } else {
                if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                    try {
                        if (!TextUtils.isEmpty(tPDLProxyInitParam.getAppVer())) {
                            setUserData(TPDownloadProxyEnum.USER_APP_VERSION, tPDLProxyInitParam.getAppVer());
                        }
                        if (tPDLProxyInitParam.getPlatform() > 0) {
                            setUserData(TPDownloadProxyEnum.USER_PLATFORM, Integer.valueOf(tPDLProxyInitParam.getPlatform()));
                        }
                        if (!TextUtils.isEmpty(tPDLProxyInitParam.getGuid())) {
                            setUserData(TPDownloadProxyEnum.USER_GUID, tPDLProxyInitParam.getGuid());
                        }
                        String cacheDir = tPDLProxyInitParam.getCacheDir();
                        if (TextUtils.isEmpty(cacheDir) && context != null) {
                            try {
                                File properCacheDirectory = TPDLFileSystem.getProperCacheDirectory(context, "download");
                                if (properCacheDirectory != null) {
                                    cacheDir = properCacheDirectory.getAbsolutePath();
                                }
                            } catch (Throwable th) {
                                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init get cache dir failed, error:" + th.toString());
                            }
                        }
                        TPListenerManager.getInstance().initHandler();
                        if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir()) || TextUtils.isEmpty(this.mCurrentStoragePath)) {
                            if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir())) {
                                this.mCurrentStoragePath = tPDLProxyInitParam.getDataDir();
                            }
                            i2 = TPDownloadProxyNative.getInstance().initService(this.mServiceType, cacheDir, tPDLProxyInitParam.getDataDir(), tPDLProxyInitParam.getConfigStr());
                        } else {
                            i2 = TPDownloadProxyNative.getInstance().initService(this.mServiceType, cacheDir, this.mCurrentStoragePath, tPDLProxyInitParam.getConfigStr());
                        }
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        AnonymousClass1 r2 = new BroadcastReceiver() {
                            /* class com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxy.AnonymousClass1 */

                            public void onReceive(Context context, Intent intent) {
                                AppMethodBeat.i(209899);
                                String action = intent.getAction();
                                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                                    TPDownloadProxy.this.pushEvent(20);
                                    AppMethodBeat.o(209899);
                                    return;
                                }
                                if ("android.intent.action.SCREEN_ON".equals(action)) {
                                    TPDownloadProxy.this.pushEvent(19);
                                }
                                AppMethodBeat.o(209899);
                            }
                        };
                        if (context != null) {
                            context.registerReceiver(r2, intentFilter);
                        }
                        if (i2 == 0) {
                            this.mIsInit = true;
                        }
                        AppMethodBeat.o(209900);
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th2.toString());
                    }
                }
                i2 = -1;
                AppMethodBeat.o(209900);
            }
        }
        return i2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int deinit() {
        AppMethodBeat.i(209901);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                this.mIsInit = false;
                int deInitService = TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
                AppMethodBeat.o(209901);
                return deInitService;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deinit failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209901);
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        AppMethodBeat.i(209902);
        TPDLProxyLog.setLogListener(this.mServiceType, iTPDLProxyLogListener);
        AppMethodBeat.o(209902);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener) {
        int i2;
        AppMethodBeat.i(209903);
        int i3 = -1;
        int dlType = tPDownloadParam.getDlType();
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (!tPDownloadParam.isAdaptive() || dlType != 3) {
                    i2 = dlType;
                } else {
                    i2 = dlType + 400;
                }
                i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, i2, tPDownloadParam.getClipCount());
                TPDownloadProxyNative.getInstance().setClipInfo(i3, tPDownloadParam.getClipNo(), TextUtils.isEmpty(tPDownloadParam.getKeyid()) ? str : tPDownloadParam.getKeyid(), i2, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
                TPListenerManager.getInstance().setPlayListener(i3, iTPPlayListener);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209903);
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPlay(String str, int i2, ITPPlayListener iTPPlayListener) {
        AppMethodBeat.i(209904);
        int i3 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 2, i2);
                TPListenerManager.getInstance().setPlayListener(i3, iTPPlayListener);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209904);
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean setClipInfo(int i2, int i3, String str, TPDownloadParam tPDownloadParam) {
        boolean z = false;
        AppMethodBeat.i(209905);
        int dlType = tPDownloadParam.getDlType();
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                z = TPDownloadProxyNative.getInstance().setClipInfo(i2, i3, str, dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo()) >= 0;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209905);
        return z;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayUrl(int i2, int i3) {
        AppMethodBeat.i(209906);
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i2, 1, i3));
                if (i3 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i2);
                }
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209906);
        return str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getClipPlayUrl(int i2, int i3, int i4) {
        AppMethodBeat.i(209907);
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i2, i3, i4));
                if (i4 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i2);
                }
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209907);
        return str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayErrorCodeStr(int i2) {
        AppMethodBeat.i(209908);
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(i2));
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209908);
        return str;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPlay(int i2) {
        AppMethodBeat.i(209909);
        if (i2 <= 0) {
            AppMethodBeat.o(209909);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i2);
                TPListenerManager.getInstance().removePlayListener(i2);
                AppMethodBeat.o(209909);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209909);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int pauseDownload(int i2) {
        int i3 = -1;
        AppMethodBeat.i(209910);
        if (i2 <= 0) {
            AppMethodBeat.o(209910);
        } else {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                try {
                    i3 = TPDownloadProxyNative.getInstance().pauseDownload(i2);
                    AppMethodBeat.o(209910);
                } catch (Throwable th) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th.toString());
                }
            }
            AppMethodBeat.o(209910);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int resumeDownload(int i2) {
        int i3 = -1;
        AppMethodBeat.i(209911);
        if (i2 <= 0) {
            AppMethodBeat.o(209911);
        } else {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                try {
                    i3 = TPDownloadProxyNative.getInstance().resumeDownload(i2);
                    AppMethodBeat.o(209911);
                } catch (Throwable th) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th.toString());
                }
            }
            AppMethodBeat.o(209911);
        }
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener) {
        AppMethodBeat.i(209912);
        int i2 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 200;
                i2 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setPreLoadListener(i2, iTPPreLoadListener);
                TPDownloadProxyNative.getInstance().setClipInfo(i2, tPDownloadParam.getClipNo(), TextUtils.isEmpty(tPDownloadParam.getKeyid()) ? str : tPDownloadParam.getKeyid(), dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
                TPDownloadProxyNative.getInstance().startDownload(i2);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209912);
        return i2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPreload(int i2) {
        AppMethodBeat.i(209913);
        if (i2 <= 0) {
            AppMethodBeat.o(209913);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i2);
                TPListenerManager.getInstance().removePreLoadListener(i2);
                AppMethodBeat.o(209913);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209913);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        AppMethodBeat.i(209914);
        int i2 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 100;
                i2 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setOfflineDownloadListener(i2, iTPOfflineDownloadListener);
                TPDownloadProxyNative.getInstance().setClipInfo(i2, tPDownloadParam.getClipNo(), TextUtils.isEmpty(tPDownloadParam.getKeyid()) ? str : tPDownloadParam.getKeyid(), dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209914);
        return i2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipOfflineDownload(String str, int i2, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        AppMethodBeat.i(209915);
        int i3 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                i3 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 102, i2);
                TPListenerManager.getInstance().setOfflineDownloadListener(i3, iTPOfflineDownloadListener);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipOfflineDownload failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209915);
        return i3;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopOfflineDownload(int i2) {
        AppMethodBeat.i(209916);
        if (i2 <= 0) {
            AppMethodBeat.o(209916);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i2);
                TPListenerManager.getInstance().removeOfflineDownloadListener(i2);
                AppMethodBeat.o(209916);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209916);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void startTask(int i2) {
        AppMethodBeat.i(209917);
        if (i2 <= 0) {
            AppMethodBeat.o(209917);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().startDownload(i2);
                AppMethodBeat.o(209917);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startTask failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209917);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateStoragePath(String str) {
        AppMethodBeat.i(209918);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(209918);
            return;
        }
        try {
            this.mCurrentStoragePath = str;
            TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, str);
            AppMethodBeat.o(209918);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateStoragePath failed, error:" + th.toString());
            AppMethodBeat.o(209918);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setMaxStorageSizeMB(long j2) {
        AppMethodBeat.i(209919);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, j2);
                AppMethodBeat.o(209919);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209919);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int removeStorageCache(String str) {
        int i2 = -1;
        AppMethodBeat.i(209920);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(209920);
        } else {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                try {
                    i2 = TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, str);
                    AppMethodBeat.o(209920);
                } catch (Throwable th) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteCache failed, error:" + th.toString());
                }
            }
            AppMethodBeat.o(209920);
        }
        return i2;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUserData(String str, Object obj) {
        AppMethodBeat.i(209921);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_APP_VERSION)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_APP_VERSION, (String) obj);
                    AppMethodBeat.o(209921);
                    return;
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_PLATFORM)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_PLATFORM, obj.toString());
                    AppMethodBeat.o(209921);
                    return;
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_GUID)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_GUID, (String) obj);
                    AppMethodBeat.o(209921);
                    return;
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_IS_VIP)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_IS_VIP, ((Boolean) obj).booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    AppMethodBeat.o(209921);
                    return;
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_UPC)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_UPC, (String) obj);
                    AppMethodBeat.o(209921);
                    return;
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_UPC_STATE)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_UPC_STATE, obj.toString());
                    AppMethodBeat.o(209921);
                    return;
                } else {
                    TPDownloadProxyNative.getInstance().setUserData(str, obj.toString());
                    AppMethodBeat.o(209921);
                    return;
                }
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209921);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void pushEvent(int i2) {
        AppMethodBeat.i(209922);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().pushEvent(i2);
                AppMethodBeat.o(209922);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pushEvent failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209922);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setPlayState(int i2, int i3) {
        AppMethodBeat.i(209923);
        if (i2 <= 0) {
            AppMethodBeat.o(209923);
            return;
        }
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setPlayerState(i2, i3);
                AppMethodBeat.o(209923);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209923);
    }
}
