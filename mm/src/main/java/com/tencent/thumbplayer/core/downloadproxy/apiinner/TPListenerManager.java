package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.util.HashMap;
import java.util.Map;

public class TPListenerManager {
    private static final String FILE_NAME = "TPListenerManager";
    private static final int MSG_CURRENT_CDN_URL = 5;
    private static final int MSG_CURRENT_CDN_URL_INFO = 6;
    private static final int MSG_DOWNLOAD_PROTOCOL = 9;
    private static final int MSG_DOWNLOAD_STATUS = 8;
    private static final int MSG_ERROR = 4;
    private static final int MSG_FINISH = 3;
    private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
    private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
    private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
    private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
    private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
    private static final int MSG_PREPARE_FINISH = 50;
    private static final int MSG_PROGRESS = 2;
    private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
    private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
    private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
    private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
    private static final int MSG_PROXY_READ_DATA = 201;
    private static final int MSG_PROXY_START_READ_DATA = 200;
    private static final int MSG_URL_EXPIRED = 7;
    private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
    private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
    private static final Object PRELOAD_LISTENER_MAP_MUTEX = new Object();
    private static final String THREAD_NAME = "TVKDL-Listener";
    private Handler mMsgHandler;
    private HandlerThread mMsgHandlerThread;
    private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap;
    private Map<Integer, ITPPlayListener> mPlayListenerMap;
    private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap;
    private Runnable updatePlayerInfo;

    static /* synthetic */ void access$500(TPListenerManager tPListenerManager, int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209969);
        tPListenerManager.dispatchCallbackMessage(i2, i3, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(209969);
    }

    static {
        AppMethodBeat.i(209970);
        AppMethodBeat.o(209970);
    }

    private TPListenerManager() {
        AppMethodBeat.i(209948);
        this.mPlayListenerMap = new HashMap();
        this.mPreLoadListenerMap = new HashMap();
        this.mOfflineDownloadListenerMap = new HashMap();
        this.updatePlayerInfo = new Runnable() {
            /* class com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(209944);
                try {
                    for (Map.Entry entry : TPListenerManager.this.mPlayListenerMap.entrySet()) {
                        int intValue = ((Integer) entry.getKey()).intValue();
                        ITPPlayListener iTPPlayListener = (ITPPlayListener) entry.getValue();
                        TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(intValue, (int) (iTPPlayListener.getCurrentPosition() / 1000), (int) (iTPPlayListener.getPlayerBufferLength() / 1000), (int) (iTPPlayListener.getAdvRemainTime() / 1000));
                    }
                    TPListenerManager.this.mMsgHandler.postDelayed(TPListenerManager.this.updatePlayerInfo, 1000);
                    AppMethodBeat.o(209944);
                } catch (Throwable th) {
                    TPDLProxyLog.e(TPListenerManager.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updatePlayerInfo failed, error:" + th.toString());
                    AppMethodBeat.o(209944);
                }
            }
        };
        AppMethodBeat.o(209948);
    }

    static class SingletonHolder {
        private static final TPListenerManager INSTANCE = new TPListenerManager();

        private SingletonHolder() {
        }

        static {
            AppMethodBeat.i(209947);
            AppMethodBeat.o(209947);
        }
    }

    public static TPListenerManager getInstance() {
        AppMethodBeat.i(209949);
        TPListenerManager tPListenerManager = SingletonHolder.INSTANCE;
        AppMethodBeat.o(209949);
        return tPListenerManager;
    }

    public void initHandler() {
        AppMethodBeat.i(209950);
        if (this.mMsgHandlerThread == null) {
            this.mMsgHandlerThread = new HandlerThread(THREAD_NAME);
            this.mMsgHandlerThread.start();
            this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
            this.mMsgHandler.postDelayed(this.updatePlayerInfo, 1000);
        }
        AppMethodBeat.o(209950);
    }

    public void setPlayListener(int i2, ITPPlayListener iTPPlayListener) {
        AppMethodBeat.i(209951);
        if (i2 <= 0 || iTPPlayListener == null) {
            AppMethodBeat.o(209951);
            return;
        }
        synchronized (PLAY_LISTENER_MAP_MUTEX) {
            try {
                this.mPlayListenerMap.put(Integer.valueOf(i2), iTPPlayListener);
            } finally {
                AppMethodBeat.o(209951);
            }
        }
    }

    public void removePlayListener(int i2) {
        AppMethodBeat.i(209952);
        if (i2 > 0) {
            synchronized (PLAY_LISTENER_MAP_MUTEX) {
                try {
                    this.mPlayListenerMap.remove(Integer.valueOf(i2));
                } finally {
                    AppMethodBeat.o(209952);
                }
            }
            return;
        }
        AppMethodBeat.o(209952);
    }

    public void removeAllPlayListener() {
        AppMethodBeat.i(209953);
        synchronized (PLAY_LISTENER_MAP_MUTEX) {
            try {
                this.mPlayListenerMap.clear();
            } finally {
                AppMethodBeat.o(209953);
            }
        }
    }

    public ITPPlayListener getPlaylistener(int i2) {
        ITPPlayListener iTPPlayListener;
        AppMethodBeat.i(209954);
        synchronized (PLAY_LISTENER_MAP_MUTEX) {
            try {
                iTPPlayListener = this.mPlayListenerMap.get(Integer.valueOf(i2));
            } finally {
                AppMethodBeat.o(209954);
            }
        }
        return iTPPlayListener;
    }

    public void setPreLoadListener(int i2, ITPPreLoadListener iTPPreLoadListener) {
        AppMethodBeat.i(209955);
        if (i2 <= 0 || iTPPreLoadListener == null) {
            AppMethodBeat.o(209955);
            return;
        }
        synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
            try {
                this.mPreLoadListenerMap.put(Integer.valueOf(i2), iTPPreLoadListener);
            } finally {
                AppMethodBeat.o(209955);
            }
        }
    }

    public void removePreLoadListener(int i2) {
        AppMethodBeat.i(209956);
        if (i2 > 0) {
            synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
                try {
                    this.mPreLoadListenerMap.remove(Integer.valueOf(i2));
                } finally {
                    AppMethodBeat.o(209956);
                }
            }
            return;
        }
        AppMethodBeat.o(209956);
    }

    public void removeAllPreLoadListener() {
        AppMethodBeat.i(209957);
        synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
            try {
                this.mPreLoadListenerMap.clear();
            } finally {
                AppMethodBeat.o(209957);
            }
        }
    }

    public ITPPreLoadListener getPreLoadListener(int i2) {
        ITPPreLoadListener iTPPreLoadListener;
        AppMethodBeat.i(209958);
        synchronized (PRELOAD_LISTENER_MAP_MUTEX) {
            try {
                iTPPreLoadListener = this.mPreLoadListenerMap.get(Integer.valueOf(i2));
            } finally {
                AppMethodBeat.o(209958);
            }
        }
        return iTPPreLoadListener;
    }

    public void setOfflineDownloadListener(int i2, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        AppMethodBeat.i(209959);
        if (i2 <= 0 || iTPOfflineDownloadListener == null) {
            AppMethodBeat.o(209959);
            return;
        }
        synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
            try {
                this.mOfflineDownloadListenerMap.put(Integer.valueOf(i2), iTPOfflineDownloadListener);
            } finally {
                AppMethodBeat.o(209959);
            }
        }
    }

    public void removeOfflineDownloadListener(int i2) {
        AppMethodBeat.i(209960);
        if (i2 > 0) {
            synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
                try {
                    this.mOfflineDownloadListenerMap.remove(Integer.valueOf(i2));
                } finally {
                    AppMethodBeat.o(209960);
                }
            }
            return;
        }
        AppMethodBeat.o(209960);
    }

    public ITPOfflineDownloadListener getOfflineDownloadListener(int i2) {
        ITPOfflineDownloadListener iTPOfflineDownloadListener;
        AppMethodBeat.i(209961);
        synchronized (OFFLINE_LISTENER_MAP_MUTEX) {
            try {
                iTPOfflineDownloadListener = this.mOfflineDownloadListenerMap.get(Integer.valueOf(i2));
            } finally {
                AppMethodBeat.o(209961);
            }
        }
        return iTPOfflineDownloadListener;
    }

    public synchronized void handleCallbackMessage(final int i2, final int i3, final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5) {
        AppMethodBeat.i(209962);
        this.mMsgHandler.post(new Runnable() {
            /* class com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(209945);
                TPListenerManager.access$500(TPListenerManager.this, i2, i3, obj, obj2, obj3, obj4, obj5);
                AppMethodBeat.o(209945);
            }
        });
        AppMethodBeat.o(209962);
    }

    public int handleIntCallbackMessage(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209963);
        int i4 = 0;
        ITPPlayListener playlistener = getPlaylistener(i3);
        if (playlistener != null) {
            if (i2 == 200) {
                i4 = playlistener.onStartReadData(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0), TPDLProxyUtils.objectToLong(obj3, -1));
            } else if (i2 == 202) {
                i4 = playlistener.onStopReadData(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToInt(obj2, 0));
            } else if (i2 == 201) {
                i4 = playlistener.onReadData(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.objectToLong(obj2, 0), (long) TPDLProxyUtils.objectToInt(obj3, 0));
            }
        }
        AppMethodBeat.o(209963);
        return i4;
    }

    public String handleStringCallbackMessage(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209964);
        String str = "";
        ITPPlayListener playlistener = getPlaylistener(i3);
        if (playlistener != null) {
            if (i2 == 205) {
                str = playlistener.getContentType(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj));
            } else if (i2 == 203) {
                str = String.valueOf(playlistener.getDataTotalSize(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj)));
            } else if (i2 == 204) {
                str = playlistener.getDataFilePath(i3, TPDLProxyUtils.byteArrayToString((byte[]) obj));
            }
        }
        AppMethodBeat.o(209964);
        return str;
    }

    private void dispatchCallbackMessage(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209965);
        ITPPlayListener playlistener = getPlaylistener(i3);
        if (playlistener != null) {
            dispatchPlayMessage(playlistener, i2, i3, obj, obj2, obj3, obj4, obj5);
            AppMethodBeat.o(209965);
            return;
        }
        ITPPreLoadListener preLoadListener = getPreLoadListener(i3);
        if (preLoadListener != null) {
            dispatchPreLoadMessage(preLoadListener, i2, i3, obj, obj2, obj3, obj4, obj5);
            AppMethodBeat.o(209965);
            return;
        }
        ITPOfflineDownloadListener offlineDownloadListener = getOfflineDownloadListener(i3);
        if (offlineDownloadListener != null) {
            dispatchOfflineDownloadMessage(offlineDownloadListener, i2, i3, obj, obj2, obj3, obj4, obj5);
        }
        AppMethodBeat.o(209965);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void dispatchPlayMessage(ITPPlayListener iTPPlayListener, int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209966);
        if (iTPPlayListener == null) {
            AppMethodBeat.o(209966);
            return;
        }
        switch (i2) {
            case 2:
                iTPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0), TPDLProxyUtils.objectToLong(obj4, 0), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                AppMethodBeat.o(209966);
                return;
            case 3:
                iTPPlayListener.onDownloadFinish();
                AppMethodBeat.o(209966);
                return;
            case 4:
                AppMethodBeat.o(209966);
                return;
            case 5:
                iTPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                AppMethodBeat.o(209966);
                return;
            case 6:
                iTPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), TPDLProxyUtils.byteArrayToString((byte[]) obj3), TPDLProxyUtils.byteArrayToString((byte[]) obj4));
                AppMethodBeat.o(209966);
                return;
            case 7:
                String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0);
                Map<String, String> hashMap = new HashMap<>();
                if (!TextUtils.isEmpty(byteArrayToString)) {
                    hashMap.put("exttag", byteArrayToString);
                    hashMap.put("randnum", String.valueOf(objectToLong));
                }
                iTPPlayListener.onDownloadCdnUrlExpired(hashMap);
                AppMethodBeat.o(209966);
                return;
            case 8:
                iTPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(obj, 0));
                AppMethodBeat.o(209966);
                return;
            case 9:
                iTPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2));
                AppMethodBeat.o(209966);
                return;
            case 101:
                String byteArrayToString2 = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong2 = TPDLProxyUtils.objectToLong(obj2, 0);
                HashMap hashMap2 = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString2)) {
                    hashMap2.put("exttag", byteArrayToString2);
                    hashMap2.put("randnum", String.valueOf(objectToLong2));
                }
                iTPPlayListener.onPlayCallback(1, hashMap2, null, null, null);
                AppMethodBeat.o(209966);
                return;
            case 2003:
                iTPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), Integer.valueOf(TPDLProxyUtils.objectToInt(obj3, 0)), null);
                AppMethodBeat.o(209966);
                return;
            case 2004:
                final int objectToInt = TPDLProxyUtils.objectToInt(obj2, 0);
                TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new Runnable() {
                    /* class com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(209946);
                        TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_LOSS_PACKAGE_INFO, TPDLProxyUtils.losePackageCheck(objectToInt));
                        AppMethodBeat.o(209946);
                    }
                });
                AppMethodBeat.o(209966);
                return;
            case 2006:
                iTPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[]) obj), null, null, null);
                AppMethodBeat.o(209966);
                return;
            case 2007:
                iTPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[]) obj), null, null, null);
                break;
        }
        AppMethodBeat.o(209966);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void dispatchPreLoadMessage(ITPPreLoadListener iTPPreLoadListener, int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209967);
        if (iTPPreLoadListener == null) {
            AppMethodBeat.o(209967);
            return;
        }
        switch (i2) {
            case 2:
                iTPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0), TPDLProxyUtils.objectToLong(obj4, 0), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                AppMethodBeat.o(209967);
                return;
            case 4:
                iTPPreLoadListener.onPrepareError(((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                break;
            case 50:
                iTPPreLoadListener.onPrepareOK();
                AppMethodBeat.o(209967);
                return;
        }
        AppMethodBeat.o(209967);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener iTPOfflineDownloadListener, int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(209968);
        if (iTPOfflineDownloadListener == null) {
            AppMethodBeat.o(209968);
            return;
        }
        switch (i2) {
            case 2:
                iTPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(obj, 0), TPDLProxyUtils.objectToInt(obj2, 0), TPDLProxyUtils.objectToLong(obj3, 0), TPDLProxyUtils.objectToLong(obj4, 0), TPDLProxyUtils.byteArrayToString((byte[]) obj5));
                AppMethodBeat.o(209968);
                return;
            case 3:
                iTPOfflineDownloadListener.onDownloadFinish();
                AppMethodBeat.o(209968);
                return;
            case 4:
                iTPOfflineDownloadListener.onDownloadError(((Integer) obj).intValue(), ((Integer) obj2).intValue(), TPDLProxyUtils.byteArrayToString((byte[]) obj3));
                AppMethodBeat.o(209968);
                return;
            case 5:
                iTPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj));
                AppMethodBeat.o(209968);
                return;
            case 6:
                iTPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2), TPDLProxyUtils.byteArrayToString((byte[]) obj3), TPDLProxyUtils.byteArrayToString((byte[]) obj4));
                AppMethodBeat.o(209968);
                return;
            case 7:
                String byteArrayToString = TPDLProxyUtils.byteArrayToString((byte[]) obj);
                long objectToLong = TPDLProxyUtils.objectToLong(obj2, 0);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(byteArrayToString)) {
                    hashMap.put("exttag", byteArrayToString);
                    hashMap.put("randnum", String.valueOf(objectToLong));
                }
                iTPOfflineDownloadListener.onDownloadCdnUrlExpired(hashMap);
                AppMethodBeat.o(209968);
                return;
            case 8:
                iTPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(obj, 0));
                AppMethodBeat.o(209968);
                return;
            case 9:
                iTPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[]) obj), TPDLProxyUtils.byteArrayToString((byte[]) obj2));
                break;
        }
        AppMethodBeat.o(209968);
    }
}
