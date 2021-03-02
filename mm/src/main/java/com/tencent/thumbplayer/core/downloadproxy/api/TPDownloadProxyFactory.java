package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadProxyFactory {
    private static final String FILE_NAME = "TPDownloadProxyFactory";
    private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
    private static TPDLProxyBindServiceCallback mCallback = null;
    private static boolean mCanUseAIDL = false;
    private static ServiceConnection mConnection = new ServiceConnection() {
        /* class com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory.AnonymousClass1 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(209924);
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = TPDownloadProxyFactoryAidl.Stub.asInterface(iBinder);
            try {
                for (Map.Entry entry : TPDownloadProxyFactory.mvTPDownloadProxyClientMap.entrySet()) {
                    ((TPDownloadProxyClient) entry.getValue()).updateAidl(TPDownloadProxyFactory.downloadProxyFactoryAidl.getTPDownloadProxy(((Integer) entry.getKey()).intValue()));
                }
            } catch (Throwable th) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onServiceConnected failed, error:" + th.toString());
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected!");
            if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl is null!");
                AppMethodBeat.o(209924);
                return;
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl not null!");
            TPDownloadProxyFactory.access$200(true);
            if (TPDownloadProxyFactory.mCallback != null) {
                TPDownloadProxyFactory.mCallback.onBindSuccess();
            }
            AppMethodBeat.o(209924);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(209925);
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service disconnected");
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = null;
            TPDownloadProxyFactory.access$200(false);
            TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
            AppMethodBeat.o(209925);
        }
    };
    private static boolean mIsReadyForDownload = false;
    private static Object mMapObject = new Object();
    private static boolean mUseService = false;
    private static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap = new HashMap<>();
    private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap<>();

    static /* synthetic */ void access$200(boolean z) {
        AppMethodBeat.i(209933);
        setCanUseAIDL(z);
        AppMethodBeat.o(209933);
    }

    static {
        AppMethodBeat.i(209934);
        AppMethodBeat.o(209934);
    }

    public static void setUseService(boolean z) {
        mUseService = z;
    }

    public static boolean getUseService() {
        return mUseService;
    }

    public static ITPDownloadProxy getTPDownloadProxy(int i2) {
        ITPDownloadProxy iTPDownloadProxy = null;
        AppMethodBeat.i(209926);
        if (i2 <= 0) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy is invalid, serviceType:".concat(String.valueOf(i2)));
            AppMethodBeat.o(209926);
        } else if (!mUseService) {
            synchronized (mMapObject) {
                try {
                    iTPDownloadProxy = mvTPDownloadProxyMap.get(Integer.valueOf(i2));
                    if (iTPDownloadProxy == null) {
                        iTPDownloadProxy = new TPDownloadProxy(i2);
                        mvTPDownloadProxyMap.put(Integer.valueOf(i2), iTPDownloadProxy);
                    }
                } finally {
                    AppMethodBeat.o(209926);
                }
            }
        } else if (mCanUseAIDL) {
            try {
                iTPDownloadProxy = getTPDownloadProxyService(i2);
                AppMethodBeat.o(209926);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, error:" + th.toString());
                AppMethodBeat.o(209926);
            }
        } else {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, can't use aidl!");
            AppMethodBeat.o(209926);
        }
        return iTPDownloadProxy;
    }

    private static synchronized ITPDownloadProxy getTPDownloadProxyService(int i2) {
        TPDownloadProxyClient tPDownloadProxyClient;
        synchronized (TPDownloadProxyFactory.class) {
            AppMethodBeat.i(209927);
            if (downloadProxyFactoryAidl != null) {
                synchronized (mvTPDownloadProxyClientMap) {
                    try {
                        tPDownloadProxyClient = mvTPDownloadProxyClientMap.get(Integer.valueOf(i2));
                        if (tPDownloadProxyClient == null) {
                            try {
                                tPDownloadProxyClient = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(i2));
                            } catch (Throwable th) {
                                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, error:" + th.toString());
                            }
                        }
                        mvTPDownloadProxyClientMap.put(Integer.valueOf(i2), tPDownloadProxyClient);
                    } finally {
                        AppMethodBeat.o(209927);
                    }
                }
            } else {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, aidl is null!");
                tPDownloadProxyClient = null;
                AppMethodBeat.o(209927);
            }
        }
        return tPDownloadProxyClient;
    }

    public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback tPDLProxyBindServiceCallback) {
        AppMethodBeat.i(209928);
        Context context = TPDownloadProxyHelper.getContext();
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService get context null!");
            AppMethodBeat.o(209928);
            return false;
        }
        mCallback = tPDLProxyBindServiceCallback;
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService " + (context == null ? "context is null" : "ok"));
        try {
            Intent intent = new Intent(context, TPDownloadProxyService.class);
            context.startService(intent);
            if (!context.bindService(intent, mConnection, 1)) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService bind service failed!");
            }
            AppMethodBeat.o(209928);
            return true;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService failed, error:" + th.toString());
            AppMethodBeat.o(209928);
            return false;
        }
    }

    private static synchronized void setCanUseAIDL(boolean z) {
        synchronized (TPDownloadProxyFactory.class) {
            mCanUseAIDL = z;
        }
    }

    public static synchronized boolean getCanUseAIDL() {
        boolean z;
        synchronized (TPDownloadProxyFactory.class) {
            z = mCanUseAIDL;
        }
        return z;
    }

    public static synchronized boolean isReadyForPlay() {
        boolean z = false;
        synchronized (TPDownloadProxyFactory.class) {
            AppMethodBeat.i(209929);
            if (!mUseService) {
                z = TPDownloadProxyNative.getInstance().isReadyForWork();
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay ret:".concat(String.valueOf(z)));
                AppMethodBeat.o(209929);
            } else if (!mCanUseAIDL) {
                AppMethodBeat.o(209929);
            } else {
                if (downloadProxyFactoryAidl != null) {
                    try {
                        z = downloadProxyFactoryAidl.isReadyForPlay();
                    } catch (Throwable th) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay failed, error:" + th.toString());
                    }
                }
                AppMethodBeat.o(209929);
            }
        }
        return z;
    }

    public static synchronized void setReadyForDownload(boolean z) {
        synchronized (TPDownloadProxyFactory.class) {
            mIsReadyForDownload = z;
        }
    }

    public static synchronized boolean isReadyForDownload() {
        boolean z = false;
        synchronized (TPDownloadProxyFactory.class) {
            AppMethodBeat.i(209930);
            if (!mUseService) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload ret:" + mIsReadyForDownload);
                z = mIsReadyForDownload;
                AppMethodBeat.o(209930);
            } else if (!mCanUseAIDL) {
                AppMethodBeat.o(209930);
            } else {
                if (downloadProxyFactoryAidl != null) {
                    try {
                        z = downloadProxyFactoryAidl.isReadyForDownload();
                    } catch (Throwable th) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload failed, error:" + th.toString());
                    }
                }
                AppMethodBeat.o(209930);
            }
        }
        return z;
    }

    public static synchronized boolean canUseService() {
        boolean z = true;
        synchronized (TPDownloadProxyFactory.class) {
            AppMethodBeat.i(209931);
            if (!mUseService) {
                AppMethodBeat.o(209931);
            } else if (!mCanUseAIDL) {
                AppMethodBeat.o(209931);
                z = false;
            } else {
                if (downloadProxyFactoryAidl != null) {
                    try {
                        downloadProxyFactoryAidl.isReadyForPlay();
                        AppMethodBeat.o(209931);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "canUseService failed, error:" + th.toString());
                    }
                }
                AppMethodBeat.o(209931);
                z = false;
            }
        }
        return z;
    }

    public static String getNativeVersion() {
        AppMethodBeat.i(209932);
        if (!mUseService) {
            String nativeVersion = TPDownloadProxyNative.getInstance().getNativeVersion();
            AppMethodBeat.o(209932);
            return nativeVersion;
        } else if (!mCanUseAIDL) {
            String nativeVersion2 = TPDownloadProxyNative.getInstance().getNativeVersion();
            AppMethodBeat.o(209932);
            return nativeVersion2;
        } else {
            if (downloadProxyFactoryAidl != null) {
                try {
                    String nativeVersion3 = downloadProxyFactoryAidl.getNativeVersion();
                    AppMethodBeat.o(209932);
                    return nativeVersion3;
                } catch (Throwable th) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeVersion failed, error:" + th.toString());
                }
            }
            String nativeVersion4 = TPDownloadProxyNative.getInstance().getNativeVersion();
            AppMethodBeat.o(209932);
            return nativeVersion4;
        }
    }
}
