package com.tencent.thumbplayer.core.downloadproxy.client;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPDownloadProxyClient implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxyClient";
    private ITPDownloadProxyAidl downloadProxyAidl = null;

    public TPDownloadProxyClient(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    public void updateAidl(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        AppMethodBeat.i(210008);
        String serialize = TPDLProxyUtils.serialize(tPDLProxyInitParam);
        if (TextUtils.isEmpty(serialize)) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
            AppMethodBeat.o(210008);
            return -1;
        }
        try {
            int init = this.downloadProxyAidl.init(serialize);
            AppMethodBeat.o(210008);
            return init;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th.toString());
            AppMethodBeat.o(210008);
            return -2;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int deinit() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        AppMethodBeat.i(210009);
        TPDLProxyLog.setLogListener(10303, iTPDLProxyLogListener);
        AppMethodBeat.o(210009);
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPlay(String str, TPDownloadParam tPDownloadParam, final ITPPlayListener iTPPlayListener) {
        AppMethodBeat.i(210010);
        if (this.downloadProxyAidl == null || tPDownloadParam == null) {
            AppMethodBeat.o(210010);
            return -1;
        }
        TPDownloadParamAidl tPDownloadParamAidl = new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap());
        if (iTPPlayListener == null) {
            try {
                int startPlay = this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, null);
                AppMethodBeat.o(210010);
                return startPlay;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th.toString());
                AppMethodBeat.o(210010);
                return -1;
            }
        } else {
            int startPlay2 = this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, new ITPPlayListenerAidl.Stub() {
                /* class com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.AnonymousClass1 */

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                    AppMethodBeat.i(209971);
                    iTPPlayListener.onDownloadProgressUpdate(i2, i3, j2, j3, str);
                    AppMethodBeat.o(209971);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadFinish() {
                    AppMethodBeat.i(209972);
                    iTPPlayListener.onDownloadFinish();
                    AppMethodBeat.o(209972);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadError(int i2, int i3, String str) {
                    AppMethodBeat.i(209973);
                    iTPPlayListener.onDownloadError(i2, i3, str);
                    AppMethodBeat.o(209973);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onPlayCallback(int i2, List list) {
                    AppMethodBeat.i(209974);
                    Object obj = 0;
                    if (list != null && !list.isEmpty()) {
                        if (list.size() == 1) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), null, null, null);
                        } else if (list.size() == 2) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), list.get(1), null, null);
                        } else if (list.size() == 3) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), list.get(1), list.get(2), null);
                        }
                    }
                    if (obj.getClass() != Integer.class) {
                        AppMethodBeat.o(209974);
                        return -1;
                    }
                    int intValue = ((Integer) obj).intValue();
                    AppMethodBeat.o(209974);
                    return intValue;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlUpdate(String str) {
                    AppMethodBeat.i(209975);
                    iTPPlayListener.onDownloadCdnUrlUpdate(str);
                    AppMethodBeat.o(209975);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                    AppMethodBeat.i(209976);
                    iTPPlayListener.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                    AppMethodBeat.o(209976);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlExpired(Map map) {
                    AppMethodBeat.i(209977);
                    iTPPlayListener.onDownloadCdnUrlExpired(map);
                    AppMethodBeat.o(209977);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadStatusUpdate(int i2) {
                    AppMethodBeat.i(209978);
                    iTPPlayListener.onDownloadStatusUpdate(i2);
                    AppMethodBeat.o(209978);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProtocolUpdate(String str, String str2) {
                    AppMethodBeat.i(209979);
                    iTPPlayListener.onDownloadProtocolUpdate(str, str2);
                    AppMethodBeat.o(209979);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getPlayerBufferLength() {
                    AppMethodBeat.i(209980);
                    long playerBufferLength = iTPPlayListener.getPlayerBufferLength();
                    AppMethodBeat.o(209980);
                    return playerBufferLength;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getCurrentPosition() {
                    AppMethodBeat.i(209981);
                    long currentPosition = iTPPlayListener.getCurrentPosition();
                    AppMethodBeat.o(209981);
                    return currentPosition;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int getCurrentPlayClipNo() {
                    AppMethodBeat.i(209982);
                    int currentPlayClipNo = iTPPlayListener.getCurrentPlayClipNo();
                    AppMethodBeat.o(209982);
                    return currentPlayClipNo;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getAdvRemainTime() {
                    AppMethodBeat.i(209983);
                    long advRemainTime = iTPPlayListener.getAdvRemainTime();
                    AppMethodBeat.o(209983);
                    return advRemainTime;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getPlayInfo(String str) {
                    AppMethodBeat.i(209984);
                    Object playInfo = iTPPlayListener.getPlayInfo(str);
                    if (playInfo != null && playInfo.getClass() == String.class) {
                        if (playInfo.getClass() == String.class) {
                            String str2 = (String) playInfo;
                            AppMethodBeat.o(209984);
                            return str2;
                        } else if (playInfo.getClass() == Integer.class) {
                            String num = Integer.toString(((Integer) playInfo).intValue());
                            AppMethodBeat.o(209984);
                            return num;
                        }
                    }
                    AppMethodBeat.o(209984);
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStartReadData(int i2, String str, long j2, long j3) {
                    AppMethodBeat.i(209985);
                    int onStartReadData = iTPPlayListener.onStartReadData(i2, str, j2, j3);
                    AppMethodBeat.o(209985);
                    return onStartReadData;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onReadData(int i2, String str, long j2, long j3) {
                    AppMethodBeat.i(209986);
                    int onReadData = iTPPlayListener.onReadData(i2, str, j2, j3);
                    AppMethodBeat.o(209986);
                    return onReadData;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStopReadData(int i2, String str, int i3) {
                    AppMethodBeat.i(209987);
                    int onStopReadData = iTPPlayListener.onStopReadData(i2, str, i3);
                    AppMethodBeat.o(209987);
                    return onStopReadData;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getDataTotalSize(int i2, String str) {
                    AppMethodBeat.i(209988);
                    long dataTotalSize = iTPPlayListener.getDataTotalSize(i2, str);
                    AppMethodBeat.o(209988);
                    return dataTotalSize;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getDataFilePath(int i2, String str) {
                    AppMethodBeat.i(209989);
                    String dataFilePath = iTPPlayListener.getDataFilePath(i2, str);
                    AppMethodBeat.o(209989);
                    return dataFilePath;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getContentType(int i2, String str) {
                    AppMethodBeat.i(209990);
                    String contentType = iTPPlayListener.getContentType(i2, str);
                    AppMethodBeat.o(209990);
                    return contentType;
                }
            });
            AppMethodBeat.o(210010);
            return startPlay2;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipPlay(String str, int i2, final ITPPlayListener iTPPlayListener) {
        AppMethodBeat.i(210011);
        if (iTPPlayListener == null) {
            try {
                int startClipPlay = this.downloadProxyAidl.startClipPlay(str, i2, null);
                AppMethodBeat.o(210011);
                return startClipPlay;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th.toString());
                AppMethodBeat.o(210011);
                return -1;
            }
        } else {
            int startClipPlay2 = this.downloadProxyAidl.startClipPlay(str, i2, new ITPPlayListenerAidl.Stub() {
                /* class com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.AnonymousClass2 */

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                    AppMethodBeat.i(209991);
                    iTPPlayListener.onDownloadProgressUpdate(i2, i3, j2, j3, str);
                    AppMethodBeat.o(209991);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadFinish() {
                    AppMethodBeat.i(209992);
                    iTPPlayListener.onDownloadFinish();
                    AppMethodBeat.o(209992);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadError(int i2, int i3, String str) {
                    AppMethodBeat.i(209993);
                    iTPPlayListener.onDownloadError(i2, i3, str);
                    AppMethodBeat.o(209993);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onPlayCallback(int i2, List list) {
                    AppMethodBeat.i(209994);
                    Object obj = 0;
                    if (list != null && !list.isEmpty()) {
                        if (list.size() == 1) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), null, null, null);
                        } else if (list.size() == 2) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), list.get(1), null, null);
                        } else if (list.size() == 3) {
                            obj = iTPPlayListener.onPlayCallback(i2, list.get(0), list.get(1), list.get(2), null);
                        }
                    }
                    if (obj.getClass() != Integer.class) {
                        AppMethodBeat.o(209994);
                        return -1;
                    }
                    int intValue = ((Integer) obj).intValue();
                    AppMethodBeat.o(209994);
                    return intValue;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlUpdate(String str) {
                    AppMethodBeat.i(209995);
                    iTPPlayListener.onDownloadCdnUrlUpdate(str);
                    AppMethodBeat.o(209995);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                    AppMethodBeat.i(209996);
                    iTPPlayListener.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                    AppMethodBeat.o(209996);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadCdnUrlExpired(Map map) {
                    AppMethodBeat.i(209997);
                    iTPPlayListener.onDownloadCdnUrlExpired(map);
                    AppMethodBeat.o(209997);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadStatusUpdate(int i2) {
                    AppMethodBeat.i(209998);
                    iTPPlayListener.onDownloadStatusUpdate(i2);
                    AppMethodBeat.o(209998);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public void onDownloadProtocolUpdate(String str, String str2) {
                    AppMethodBeat.i(209999);
                    iTPPlayListener.onDownloadProtocolUpdate(str, str2);
                    AppMethodBeat.o(209999);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getPlayerBufferLength() {
                    AppMethodBeat.i(210000);
                    long playerBufferLength = iTPPlayListener.getPlayerBufferLength();
                    AppMethodBeat.o(210000);
                    return playerBufferLength;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getCurrentPosition() {
                    AppMethodBeat.i(210001);
                    long currentPosition = iTPPlayListener.getCurrentPosition();
                    AppMethodBeat.o(210001);
                    return currentPosition;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int getCurrentPlayClipNo() {
                    AppMethodBeat.i(210002);
                    int currentPlayClipNo = iTPPlayListener.getCurrentPlayClipNo();
                    AppMethodBeat.o(210002);
                    return currentPlayClipNo;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getAdvRemainTime() {
                    AppMethodBeat.i(210003);
                    long advRemainTime = iTPPlayListener.getAdvRemainTime();
                    AppMethodBeat.o(210003);
                    return advRemainTime;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getPlayInfo(String str) {
                    AppMethodBeat.i(210004);
                    Object playInfo = iTPPlayListener.getPlayInfo(str);
                    if (playInfo != null && playInfo.getClass() == String.class) {
                        if (playInfo.getClass() == String.class) {
                            String str2 = (String) playInfo;
                            AppMethodBeat.o(210004);
                            return str2;
                        } else if (playInfo.getClass() == Integer.class) {
                            String num = Integer.toString(((Integer) playInfo).intValue());
                            AppMethodBeat.o(210004);
                            return num;
                        }
                    }
                    AppMethodBeat.o(210004);
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStartReadData(int i2, String str, long j2, long j3) {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onReadData(int i2, String str, long j2, long j3) {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public int onStopReadData(int i2, String str, int i3) {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public long getDataTotalSize(int i2, String str) {
                    return 0;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getDataFilePath(int i2, String str) {
                    return null;
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
                public String getContentType(int i2, String str) {
                    return null;
                }
            });
            AppMethodBeat.o(210011);
            return startClipPlay2;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public boolean setClipInfo(int i2, int i3, String str, TPDownloadParam tPDownloadParam) {
        boolean z = false;
        AppMethodBeat.i(210012);
        try {
            z = this.downloadProxyAidl.setClipInfo(i2, i3, str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()));
            AppMethodBeat.o(210012);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th.toString());
            AppMethodBeat.o(210012);
        }
        return z;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayUrl(int i2, int i3) {
        AppMethodBeat.i(210013);
        try {
            String playUrl = this.downloadProxyAidl.getPlayUrl(i2, i3);
            AppMethodBeat.o(210013);
            return playUrl;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th.toString());
            AppMethodBeat.o(210013);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getClipPlayUrl(int i2, int i3, int i4) {
        AppMethodBeat.i(210014);
        try {
            String clipPlayUrl = this.downloadProxyAidl.getClipPlayUrl(i2, i3, i4);
            AppMethodBeat.o(210014);
            return clipPlayUrl;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th.toString());
            AppMethodBeat.o(210014);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public String getPlayErrorCodeStr(int i2) {
        AppMethodBeat.i(210015);
        try {
            String playErrorCodeStr = this.downloadProxyAidl.getPlayErrorCodeStr(i2);
            AppMethodBeat.o(210015);
            return playErrorCodeStr;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th.toString());
            AppMethodBeat.o(210015);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPlay(int i2) {
        AppMethodBeat.i(210016);
        try {
            this.downloadProxyAidl.stopPlay(i2);
            AppMethodBeat.o(210016);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th.toString());
            AppMethodBeat.o(210016);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int pauseDownload(int i2) {
        AppMethodBeat.i(210017);
        try {
            int pauseDownload = this.downloadProxyAidl.pauseDownload(i2);
            AppMethodBeat.o(210017);
            return pauseDownload;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th.toString());
            AppMethodBeat.o(210017);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int resumeDownload(int i2) {
        AppMethodBeat.i(210018);
        try {
            int resumeDownload = this.downloadProxyAidl.resumeDownload(i2);
            AppMethodBeat.o(210018);
            return resumeDownload;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th.toString());
            AppMethodBeat.o(210018);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startPreload(String str, TPDownloadParam tPDownloadParam, final ITPPreLoadListener iTPPreLoadListener) {
        AppMethodBeat.i(210019);
        try {
            int startPreload = this.downloadProxyAidl.startPreload(str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()), new ITPPreLoadListenerAidl.Stub() {
                /* class com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient.AnonymousClass3 */

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareOK() {
                    AppMethodBeat.i(210005);
                    iTPPreLoadListener.onPrepareOK();
                    AppMethodBeat.o(210005);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareError(int i2, int i3, String str) {
                    AppMethodBeat.i(210006);
                    iTPPreLoadListener.onPrepareError(i2, i3, str);
                    AppMethodBeat.o(210006);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl
                public void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
                    AppMethodBeat.i(210007);
                    iTPPreLoadListener.onPrepareDownloadProgressUpdate(i2, i3, j2, j3, str);
                    AppMethodBeat.o(210007);
                }
            });
            AppMethodBeat.o(210019);
            return startPreload;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th.toString());
            AppMethodBeat.o(210019);
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopPreload(int i2) {
        AppMethodBeat.i(210020);
        try {
            this.downloadProxyAidl.stopPreload(i2);
            AppMethodBeat.o(210020);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th.toString());
            AppMethodBeat.o(210020);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int startClipOfflineDownload(String str, int i2, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void stopOfflineDownload(int i2) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void startTask(int i2) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void updateStoragePath(String str) {
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public int removeStorageCache(String str) {
        return -1;
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setMaxStorageSizeMB(long j2) {
        AppMethodBeat.i(210021);
        try {
            this.downloadProxyAidl.setMaxStorageSizeMB(j2);
            AppMethodBeat.o(210021);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th.toString());
            AppMethodBeat.o(210021);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setUserData(String str, Object obj) {
        AppMethodBeat.i(210022);
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        try {
            this.downloadProxyAidl.setUserData(hashMap);
            AppMethodBeat.o(210022);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th.toString());
            AppMethodBeat.o(210022);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void pushEvent(int i2) {
        AppMethodBeat.i(210023);
        try {
            this.downloadProxyAidl.pushEvent(i2);
            AppMethodBeat.o(210023);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pushEvent failed, error:" + th.toString());
            AppMethodBeat.o(210023);
        }
    }

    @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy
    public void setPlayState(int i2, int i3) {
        AppMethodBeat.i(210024);
        try {
            this.downloadProxyAidl.setPlayState(i2, i3);
            AppMethodBeat.o(210024);
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th.toString());
            AppMethodBeat.o(210024);
        }
    }
}
