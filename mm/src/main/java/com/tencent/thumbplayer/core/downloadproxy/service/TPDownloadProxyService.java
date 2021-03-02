package com.tencent.thumbplayer.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadProxyService extends Service {
    private static final String FILE_NAME = "TPDownloadProxyService";
    private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
    private int pid = -1;

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(210102);
        if (this.downloadProxyFactory == null) {
            this.downloadProxyFactory = new DownloadProxyFactory();
        }
        isExistMainProcess();
        TPDownloadProxyFactoryAidl.Stub stub = this.downloadProxyFactory;
        AppMethodBeat.o(210102);
        return stub;
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(210103);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on unbind!");
        super.onUnbind(intent);
        if (!isExistMainProcess()) {
            try {
                TPDownloadProxyNative.getInstance().stopAllDownload(3);
                TPListenerManager.getInstance().removeAllPlayListener();
                TPListenerManager.getInstance().removeAllPreLoadListener();
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, th.toString());
            }
        }
        AppMethodBeat.o(210103);
        return true;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(210104);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on rebind!");
        isExistMainProcess();
        super.onRebind(intent);
        AppMethodBeat.o(210104);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(210105);
        super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(210105);
        return 2;
    }

    class DownloadProxyFactory extends TPDownloadProxyFactoryAidl.Stub {
        private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;

        private DownloadProxyFactory() {
            AppMethodBeat.i(210097);
            this.mvTPDownloadProxyMap = new HashMap<>();
            AppMethodBeat.o(210097);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public synchronized ITPDownloadProxyAidl getTPDownloadProxy(int i2) {
            ITPDownloadProxyAidl iTPDownloadProxyAidl;
            AppMethodBeat.i(210098);
            iTPDownloadProxyAidl = this.mvTPDownloadProxyMap.get(Integer.valueOf(i2));
            if (iTPDownloadProxyAidl == null) {
                iTPDownloadProxyAidl = new DownloadProxy(i2);
                this.mvTPDownloadProxyMap.put(Integer.valueOf(i2), iTPDownloadProxyAidl);
            }
            AppMethodBeat.o(210098);
            return iTPDownloadProxyAidl;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForPlay() {
            AppMethodBeat.i(210099);
            boolean isReadyForPlay = TPDownloadProxyFactory.isReadyForPlay();
            AppMethodBeat.o(210099);
            return isReadyForPlay;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public boolean isReadyForDownload() {
            AppMethodBeat.i(210100);
            boolean isReadyForDownload = TPDownloadProxyFactory.isReadyForDownload();
            AppMethodBeat.o(210100);
            return isReadyForDownload;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl
        public String getNativeVersion() {
            AppMethodBeat.i(210101);
            String nativeVersion = TPDownloadProxyFactory.getNativeVersion();
            AppMethodBeat.o(210101);
            return nativeVersion;
        }
    }

    class DownloadProxy extends ITPDownloadProxyAidl.Stub {
        private ITPDownloadProxy downloadProxy = null;

        public DownloadProxy(int i2) {
            AppMethodBeat.i(210080);
            this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i2);
            AppMethodBeat.o(210080);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int init(String str) {
            AppMethodBeat.i(210081);
            try {
                TPDLProxyInitParam tPDLProxyInitParam = (TPDLProxyInitParam) TPDLProxyUtils.serializeToObject(str);
                if (tPDLProxyInitParam == null) {
                    TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
                    AppMethodBeat.o(210081);
                    return -1;
                }
                int init = this.downloadProxy.init(TPDownloadProxyHelper.getContext(), tPDLProxyInitParam);
                AppMethodBeat.o(210081);
                return init;
            } catch (Throwable th) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th.toString());
                AppMethodBeat.o(210081);
                return -2;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            AppMethodBeat.i(210082);
            try {
                int startPlay = this.downloadProxy.startPlay(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPlayListener() {
                    /* class com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.AnonymousClass1 */

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                        AppMethodBeat.i(210035);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadProgressUpdate(i2, i3, j2, j3, str);
                            }
                            AppMethodBeat.o(210035);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodProgressUpdate failed, error:" + th.toString());
                            AppMethodBeat.o(210035);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadFinish() {
                        AppMethodBeat.i(210036);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadFinish();
                            }
                            AppMethodBeat.o(210036);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodFinish failed, error:" + th.toString());
                            AppMethodBeat.o(210036);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadError(int i2, int i3, String str) {
                        AppMethodBeat.i(210037);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadError(i2, i3, str);
                            }
                            AppMethodBeat.o(210037);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th.toString());
                            AppMethodBeat.o(210037);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
                        AppMethodBeat.i(210038);
                        try {
                            ArrayList arrayList = new ArrayList();
                            if (obj != null) {
                                arrayList.add(obj);
                            }
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                            if (obj3 != null) {
                                arrayList.add(obj3);
                            }
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onPlayCallback(i2, arrayList);
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210038);
                        return null;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlUpdate(String str) {
                        AppMethodBeat.i(210039);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlUpdate(str);
                            }
                            AppMethodBeat.o(210039);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th.toString());
                            AppMethodBeat.o(210039);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                        AppMethodBeat.i(210040);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                            }
                            AppMethodBeat.o(210040);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th.toString());
                            AppMethodBeat.o(210040);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadCdnUrlExpired(Map<String, String> map) {
                        AppMethodBeat.i(210041);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlExpired(map);
                            }
                            AppMethodBeat.o(210041);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th.toString());
                            AppMethodBeat.o(210041);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadStatusUpdate(int i2) {
                        AppMethodBeat.i(210042);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadStatusUpdate(i2);
                            }
                            AppMethodBeat.o(210042);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th.toString());
                            AppMethodBeat.o(210042);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public void onDownloadProtocolUpdate(String str, String str2) {
                        AppMethodBeat.i(210043);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadProtocolUpdate(str, str2);
                            }
                            AppMethodBeat.o(210043);
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th.toString());
                            AppMethodBeat.o(210043);
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getPlayerBufferLength() {
                        AppMethodBeat.i(210044);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                long playerBufferLength = iTPPlayListenerAidl.getPlayerBufferLength();
                                AppMethodBeat.o(210044);
                                return playerBufferLength;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210044);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getCurrentPosition() {
                        AppMethodBeat.i(210045);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                long currentPosition = iTPPlayListenerAidl.getCurrentPosition();
                                AppMethodBeat.o(210045);
                                return currentPosition;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210045);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int getCurrentPlayClipNo() {
                        AppMethodBeat.i(210046);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                int currentPlayClipNo = iTPPlayListenerAidl.getCurrentPlayClipNo();
                                AppMethodBeat.o(210046);
                                return currentPlayClipNo;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipInfo failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210046);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getAdvRemainTime() {
                        AppMethodBeat.i(210047);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                long advRemainTime = iTPPlayListenerAidl.getAdvRemainTime();
                                AppMethodBeat.o(210047);
                                return advRemainTime;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210047);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object getPlayInfo(long j2) {
                        AppMethodBeat.i(210048);
                        try {
                            String playInfo = iTPPlayListenerAidl.getPlayInfo(Long.toString(j2));
                            AppMethodBeat.o(210048);
                            return playInfo;
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th.toString());
                            AppMethodBeat.o(210048);
                            return null;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public Object getPlayInfo(String str) {
                        AppMethodBeat.i(210049);
                        try {
                            String playInfo = iTPPlayListenerAidl.getPlayInfo(str);
                            AppMethodBeat.o(210049);
                            return playInfo;
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th.toString());
                            AppMethodBeat.o(210049);
                            return null;
                        }
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onStartReadData(int i2, String str, long j2, long j3) {
                        AppMethodBeat.i(210050);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                int onStartReadData = iTPPlayListenerAidl.onStartReadData(i2, str, j2, j3);
                                AppMethodBeat.o(210050);
                                return onStartReadData;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210050);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onReadData(int i2, String str, long j2, long j3) {
                        AppMethodBeat.i(210051);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                int onReadData = iTPPlayListenerAidl.onReadData(i2, str, j2, j3);
                                AppMethodBeat.o(210051);
                                return onReadData;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210051);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public int onStopReadData(int i2, String str, int i3) {
                        AppMethodBeat.i(210052);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                int onStopReadData = iTPPlayListenerAidl.onStopReadData(i2, str, i3);
                                AppMethodBeat.o(210052);
                                return onStopReadData;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210052);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public long getDataTotalSize(int i2, String str) {
                        AppMethodBeat.i(210053);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                long dataTotalSize = iTPPlayListenerAidl.getDataTotalSize(i2, str);
                                AppMethodBeat.o(210053);
                                return dataTotalSize;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210053);
                        return -1;
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public String getDataFilePath(int i2, String str) {
                        AppMethodBeat.i(210054);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                String dataFilePath = iTPPlayListenerAidl.getDataFilePath(i2, str);
                                AppMethodBeat.o(210054);
                                return dataFilePath;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210054);
                        return "";
                    }

                    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                    public String getContentType(int i2, String str) {
                        AppMethodBeat.i(210055);
                        try {
                            if (iTPPlayListenerAidl != null) {
                                String contentType = iTPPlayListenerAidl.getContentType(i2, str);
                                AppMethodBeat.o(210055);
                                return contentType;
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th.toString());
                        }
                        AppMethodBeat.o(210055);
                        return "";
                    }
                });
                AppMethodBeat.o(210082);
                return startPlay;
            } catch (Throwable th) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th.toString());
                AppMethodBeat.o(210082);
                return -1;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startClipPlay(String str, int i2, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            AppMethodBeat.i(210083);
            int startClipPlay = this.downloadProxy.startClipPlay(str, i2, new ITPPlayListener() {
                /* class com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.AnonymousClass2 */

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                    AppMethodBeat.i(210056);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadProgressUpdate(i2, i3, j2, j3, str);
                        }
                        AppMethodBeat.o(210056);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProgressUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210056);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadFinish() {
                    AppMethodBeat.i(210057);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadFinish();
                        }
                        AppMethodBeat.o(210057);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadFinish failed, error:" + th.toString());
                        AppMethodBeat.o(210057);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadError(int i2, int i3, String str) {
                    AppMethodBeat.i(210058);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadError(i2, i3, str);
                        }
                        AppMethodBeat.o(210058);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th.toString());
                        AppMethodBeat.o(210058);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
                    AppMethodBeat.i(210059);
                    try {
                        ArrayList arrayList = new ArrayList();
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                        if (obj != null) {
                            arrayList.add(obj2);
                        }
                        if (obj != null) {
                            arrayList.add(obj3);
                        }
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onPlayCallback(i2, arrayList);
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210059);
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlUpdate(String str) {
                    AppMethodBeat.i(210060);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlUpdate(str);
                        }
                        AppMethodBeat.o(210060);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210060);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                    AppMethodBeat.i(210061);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                        }
                        AppMethodBeat.o(210061);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210061);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadCdnUrlExpired(Map<String, String> map) {
                    AppMethodBeat.i(210062);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlExpired(map);
                        }
                        AppMethodBeat.o(210062);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th.toString());
                        AppMethodBeat.o(210062);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadStatusUpdate(int i2) {
                    AppMethodBeat.i(210063);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadStatusUpdate(i2);
                        }
                        AppMethodBeat.o(210063);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210063);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public void onDownloadProtocolUpdate(String str, String str2) {
                    AppMethodBeat.i(210064);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadProtocolUpdate(str, str2);
                        }
                        AppMethodBeat.o(210064);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210064);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getPlayerBufferLength() {
                    AppMethodBeat.i(210065);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            long playerBufferLength = iTPPlayListenerAidl.getPlayerBufferLength();
                            AppMethodBeat.o(210065);
                            return playerBufferLength;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210065);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getCurrentPosition() {
                    AppMethodBeat.i(210066);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            long currentPosition = iTPPlayListenerAidl.getCurrentPosition();
                            AppMethodBeat.o(210066);
                            return currentPosition;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210066);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int getCurrentPlayClipNo() {
                    AppMethodBeat.i(210067);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            int currentPlayClipNo = iTPPlayListenerAidl.getCurrentPlayClipNo();
                            AppMethodBeat.o(210067);
                            return currentPlayClipNo;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipNo failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210067);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getAdvRemainTime() {
                    AppMethodBeat.i(210068);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            long advRemainTime = iTPPlayListenerAidl.getAdvRemainTime();
                            AppMethodBeat.o(210068);
                            return advRemainTime;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210068);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object getPlayInfo(long j2) {
                    AppMethodBeat.i(210069);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            String playInfo = iTPPlayListenerAidl.getPlayInfo(Long.toString(j2));
                            AppMethodBeat.o(210069);
                            return playInfo;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210069);
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public Object getPlayInfo(String str) {
                    AppMethodBeat.i(210070);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            String playInfo = iTPPlayListenerAidl.getPlayInfo(str);
                            AppMethodBeat.o(210070);
                            return playInfo;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210070);
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onStartReadData(int i2, String str, long j2, long j3) {
                    AppMethodBeat.i(210071);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            int onStartReadData = iTPPlayListenerAidl.onStartReadData(i2, str, j2, j3);
                            AppMethodBeat.o(210071);
                            return onStartReadData;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210071);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onReadData(int i2, String str, long j2, long j3) {
                    AppMethodBeat.i(210072);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            int onReadData = iTPPlayListenerAidl.onReadData(i2, str, j2, j3);
                            AppMethodBeat.o(210072);
                            return onReadData;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210072);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public int onStopReadData(int i2, String str, int i3) {
                    AppMethodBeat.i(210073);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            int onStopReadData = iTPPlayListenerAidl.onStopReadData(i2, str, i3);
                            AppMethodBeat.o(210073);
                            return onStopReadData;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210073);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public long getDataTotalSize(int i2, String str) {
                    AppMethodBeat.i(210074);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            long dataTotalSize = iTPPlayListenerAidl.getDataTotalSize(i2, str);
                            AppMethodBeat.o(210074);
                            return dataTotalSize;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210074);
                    return -1;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public String getDataFilePath(int i2, String str) {
                    AppMethodBeat.i(210075);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            String dataFilePath = iTPPlayListenerAidl.getDataFilePath(i2, str);
                            AppMethodBeat.o(210075);
                            return dataFilePath;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210075);
                    return "";
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
                public String getContentType(int i2, String str) {
                    AppMethodBeat.i(210076);
                    try {
                        if (iTPPlayListenerAidl != null) {
                            String contentType = iTPPlayListenerAidl.getContentType(i2, str);
                            AppMethodBeat.o(210076);
                            return contentType;
                        }
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th.toString());
                    }
                    AppMethodBeat.o(210076);
                    return "";
                }
            });
            AppMethodBeat.o(210083);
            return startClipPlay;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public boolean setClipInfo(int i2, int i3, String str, TPDownloadParamAidl tPDownloadParamAidl) {
            AppMethodBeat.i(210084);
            boolean clipInfo = this.downloadProxy.setClipInfo(i2, i3, str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()));
            AppMethodBeat.o(210084);
            return clipInfo;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayUrl(int i2, int i3) {
            AppMethodBeat.i(210085);
            String playUrl = this.downloadProxy.getPlayUrl(i2, i3);
            AppMethodBeat.o(210085);
            return playUrl;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getClipPlayUrl(int i2, int i3, int i4) {
            AppMethodBeat.i(210086);
            String clipPlayUrl = this.downloadProxy.getClipPlayUrl(i2, i3, i4);
            AppMethodBeat.o(210086);
            return clipPlayUrl;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayErrorCodeStr(int i2) {
            AppMethodBeat.i(210087);
            String playErrorCodeStr = this.downloadProxy.getPlayErrorCodeStr(i2);
            AppMethodBeat.o(210087);
            return playErrorCodeStr;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPlay(int i2) {
            AppMethodBeat.i(210088);
            this.downloadProxy.stopPlay(i2);
            AppMethodBeat.o(210088);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int pauseDownload(int i2) {
            AppMethodBeat.i(210089);
            int pauseDownload = this.downloadProxy.pauseDownload(i2);
            AppMethodBeat.o(210089);
            return pauseDownload;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int resumeDownload(int i2) {
            AppMethodBeat.i(210090);
            int resumeDownload = this.downloadProxy.resumeDownload(i2);
            AppMethodBeat.o(210090);
            return resumeDownload;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            AppMethodBeat.i(210091);
            int startPreload = this.downloadProxy.startPreload(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPreLoadListener() {
                /* class com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxy.AnonymousClass3 */

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareOK() {
                    AppMethodBeat.i(210077);
                    try {
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareOK();
                        }
                        AppMethodBeat.o(210077);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareOK failed, error:" + th.toString());
                        AppMethodBeat.o(210077);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareError(int i2, int i3, String str) {
                    AppMethodBeat.i(210078);
                    try {
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareError(i2, i3, str);
                        }
                        AppMethodBeat.o(210078);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareError failed, error:" + th.toString());
                        AppMethodBeat.o(210078);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
                public void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                    AppMethodBeat.i(210079);
                    try {
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(i2, i3, j2, j3, str);
                        }
                        AppMethodBeat.o(210079);
                    } catch (Throwable th) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareDownloadProgressUpdate failed, error:" + th.toString());
                        AppMethodBeat.o(210079);
                    }
                }
            });
            AppMethodBeat.o(210091);
            return startPreload;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPreload(int i2) {
            AppMethodBeat.i(210092);
            this.downloadProxy.stopPreload(i2);
            AppMethodBeat.o(210092);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setUserData(Map map) {
            AppMethodBeat.i(210093);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            if (entry.getValue() != null) {
                                this.downloadProxy.setUserData((String) entry.getKey(), entry.getValue());
                            }
                        } catch (Throwable th) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th.toString());
                        }
                    }
                }
            }
            AppMethodBeat.o(210093);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void pushEvent(int i2) {
            AppMethodBeat.i(210094);
            this.downloadProxy.pushEvent(i2);
            AppMethodBeat.o(210094);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setPlayState(int i2, int i3) {
            AppMethodBeat.i(210095);
            this.downloadProxy.setPlayState(i2, i3);
            AppMethodBeat.o(210095);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setMaxStorageSizeMB(long j2) {
            AppMethodBeat.i(210096);
            this.downloadProxy.setMaxStorageSizeMB(j2);
            AppMethodBeat.o(210096);
        }
    }

    private boolean isExistMainProcess() {
        AppMethodBeat.i(210106);
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                String str = runningAppProcessInfo.processName;
                if (!TextUtils.isEmpty(str) && str.equals(getPackageName())) {
                    if (this.pid == -1 || this.pid == runningAppProcessInfo.pid) {
                        this.pid = runningAppProcessInfo.pid;
                        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "app main exist!");
                        AppMethodBeat.o(210106);
                        return true;
                    }
                    this.pid = runningAppProcessInfo.pid;
                    AppMethodBeat.o(210106);
                    return false;
                }
            }
        } catch (Throwable th) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isExistMainProcess failed, error:" + th.toString());
        }
        AppMethodBeat.o(210106);
        return false;
    }
}
