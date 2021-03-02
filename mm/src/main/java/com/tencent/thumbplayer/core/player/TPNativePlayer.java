package com.tencent.thumbplayer.core.player;

import android.content.Context;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.demuxer.ITPDemuxerCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TPNativePlayer {
    private Context mContext = null;
    @TPFieldCalledByNative
    private long mNativeContext;
    private int m_playerID = -1;

    private native int _addAudioTrackSource(String str, String str2);

    private native int _addInitConfigQueueInt(int i2, int i3);

    private native int _addInitConfigQueueString(int i2, String str);

    private native int _addSubtitleTrackSource(String str, String str2);

    private native int _applyInitConfig();

    private native int _createPlayer();

    private native int _deselectTrackAsync(int i2, long j2);

    private native long _getBufferedDurationMs();

    private native long _getBufferedSize();

    private native long _getCurrentPositionMs();

    private native long _getDurationMs();

    private native int _getPlayerID();

    private native int _getProgramCount();

    private native TPNativePlayerProgramInfo _getProgramInfo(int i2);

    private native long _getPropertyLong(int i2);

    private native String _getPropertyString(int i2);

    private native int _getTrackCount();

    private native boolean _getTrackIsExclusive(int i2);

    private native boolean _getTrackIsInternal(int i2);

    private native boolean _getTrackIsSelected(int i2);

    private native String _getTrackName(int i2);

    private native int _getTrackType(int i2);

    private native int _getVideoHeight();

    private native int _getVideoWidth();

    private native int _pause();

    private native int _prepare();

    private native int _prepareAsync();

    private native int _release();

    private native int _reset();

    private native int _resetInitConfig();

    private native int _resume();

    private native int _seekToAsync(int i2, int i3, long j2);

    private native int _selectProgramAsync(int i2, long j2);

    private native int _selectTrackAsync(int i2, long j2);

    private native int _setAudioFrameCallback(Object obj);

    private native int _setAudioMute(boolean z);

    private native int _setAudioNormalizeVolumeParams(String str);

    private native int _setAudioVolume(float f2);

    private native int _setDataSource(String str);

    private native int _setDataSourceFd(int i2);

    private native int _setDataSourceWithHttpHeader(String str, Object[] objArr);

    private native int _setDemuxerCallback(Object obj);

    private native int _setInitConfigBool(int i2, boolean z);

    private native int _setInitConfigFloat(int i2, float f2);

    private native int _setInitConfigInt(int i2, int i3);

    private native int _setInitConfigLong(int i2, long j2);

    private native int _setLoopback(boolean z, long j2, long j3);

    private native int _setMessageCallback(Object obj);

    private native int _setOptionLong(int i2, long j2, long j3);

    private native int _setOptionObject(int i2, Object obj);

    private native int _setPlaybackRate(float f2);

    private native int _setPostProcessFrameCallback(Object obj);

    private native int _setSubtitleFrameCallback(Object obj);

    private native int _setVideoFrameCallback(Object obj);

    private native int _setVideoSurface(Surface surface);

    private native int _setVideoSurfaceWithType(Surface surface, int i2);

    private native int _start();

    private native int _stop();

    private native int _switchDefinitionAsync(String str, int i2, long j2);

    public TPNativePlayer(Context context) {
        AppMethodBeat.i(189938);
        this.mContext = context.getApplicationContext();
        TPNativeLibraryLoader.loadLibIfNeeded(context);
        try {
            this.m_playerID = _createPlayer();
            TPHeadsetPluginDetector.init(this.mContext);
            TPAudioPassThroughPluginDetector.init(this.mContext);
            if (Build.VERSION.SDK_INT >= 17) {
                TPScreenRefreshRateDetector.init(this.mContext);
            }
            TPSystemInfo.initAudioBestSettings(this.mContext);
            AppMethodBeat.o(189938);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "Failed to create native player:" + th.getMessage());
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to create native player");
            AppMethodBeat.o(189938);
            throw unsupportedOperationException;
        }
    }

    public void setInitConfig(TPNativePlayerInitConfig tPNativePlayerInitConfig) {
        AppMethodBeat.i(189939);
        try {
            _resetInitConfig();
            HashMap<Integer, Integer> intMap = tPNativePlayerInitConfig.getIntMap();
            HashMap<Integer, Long> longMap = tPNativePlayerInitConfig.getLongMap();
            HashMap<Integer, Float> floatMap = tPNativePlayerInitConfig.getFloatMap();
            HashMap<Integer, Boolean> boolMap = tPNativePlayerInitConfig.getBoolMap();
            HashMap<Integer, Vector<Integer>> queueIntMap = tPNativePlayerInitConfig.getQueueIntMap();
            for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
                _setInitConfigInt(entry.getKey().intValue(), entry.getValue().intValue());
            }
            for (Map.Entry<Integer, Long> entry2 : longMap.entrySet()) {
                _setInitConfigLong(entry2.getKey().intValue(), entry2.getValue().longValue());
            }
            for (Map.Entry<Integer, Float> entry3 : floatMap.entrySet()) {
                _setInitConfigFloat(entry3.getKey().intValue(), entry3.getValue().floatValue());
            }
            for (Map.Entry<Integer, Boolean> entry4 : boolMap.entrySet()) {
                _setInitConfigBool(entry4.getKey().intValue(), entry4.getValue().booleanValue());
            }
            for (Map.Entry<Integer, Vector<Integer>> entry5 : queueIntMap.entrySet()) {
                Vector<Integer> value = entry5.getValue();
                if (value != null) {
                    Iterator<Integer> it = value.iterator();
                    while (it.hasNext()) {
                        _addInitConfigQueueInt(entry5.getKey().intValue(), it.next().intValue());
                    }
                }
            }
            for (Map.Entry<Integer, Vector<String>> entry6 : tPNativePlayerInitConfig.getQueueStringMap().entrySet()) {
                Vector<String> value2 = entry6.getValue();
                if (value2 != null) {
                    Iterator<String> it2 = value2.iterator();
                    while (it2.hasNext()) {
                        _addInitConfigQueueString(entry6.getKey().intValue(), it2.next());
                    }
                }
            }
            _applyInitConfig();
            AppMethodBeat.o(189939);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189939);
        }
    }

    public int setDataSource(String str) {
        AppMethodBeat.i(189940);
        try {
            int _setDataSource = _setDataSource(str);
            AppMethodBeat.o(189940);
            return _setDataSource;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189940);
            return 1000001;
        }
    }

    public int setDataSource(String str, Map<String, String> map) {
        String[] strArr;
        AppMethodBeat.i(189941);
        if (map != null) {
            try {
                if (map.size() != 0) {
                    String[] strArr2 = new String[(map.size() * 2)];
                    int i2 = 0;
                    for (String str2 : map.keySet()) {
                        strArr2[i2 * 2] = str2;
                        strArr2[(i2 * 2) + 1] = map.get(str2);
                        i2++;
                    }
                    strArr = strArr2;
                    int _setDataSourceWithHttpHeader = _setDataSourceWithHttpHeader(str, strArr);
                    AppMethodBeat.o(189941);
                    return _setDataSourceWithHttpHeader;
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                AppMethodBeat.o(189941);
                return 1000001;
            }
        }
        strArr = new String[0];
        int _setDataSourceWithHttpHeader2 = _setDataSourceWithHttpHeader(str, strArr);
        AppMethodBeat.o(189941);
        return _setDataSourceWithHttpHeader2;
    }

    public int setDataSource(int i2) {
        AppMethodBeat.i(189942);
        try {
            int _setDataSourceFd = _setDataSourceFd(i2);
            AppMethodBeat.o(189942);
            return _setDataSourceFd;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189942);
            return 1000001;
        }
    }

    public int prepare() {
        AppMethodBeat.i(189943);
        try {
            int _prepare = _prepare();
            AppMethodBeat.o(189943);
            return _prepare;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189943);
            return 1000001;
        }
    }

    public int prepareAsync() {
        AppMethodBeat.i(189944);
        try {
            int _prepareAsync = _prepareAsync();
            AppMethodBeat.o(189944);
            return _prepareAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189944);
            return 1000001;
        }
    }

    public int start() {
        AppMethodBeat.i(189945);
        try {
            int _start = _start();
            AppMethodBeat.o(189945);
            return _start;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189945);
            return 1000001;
        }
    }

    public int pause() {
        AppMethodBeat.i(189946);
        try {
            int _pause = _pause();
            AppMethodBeat.o(189946);
            return _pause;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189946);
            return 1000001;
        }
    }

    public int stop() {
        AppMethodBeat.i(189947);
        try {
            int _stop = _stop();
            AppMethodBeat.o(189947);
            return _stop;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189947);
            return 1000001;
        }
    }

    public void reset() {
        AppMethodBeat.i(189948);
        try {
            _reset();
            AppMethodBeat.o(189948);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189948);
        }
    }

    public void release() {
        AppMethodBeat.i(189949);
        try {
            _release();
            AppMethodBeat.o(189949);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189949);
        }
    }

    public int seekToAsync(int i2, int i3, long j2) {
        AppMethodBeat.i(189950);
        try {
            int _seekToAsync = _seekToAsync(i2, i3, j2);
            AppMethodBeat.o(189950);
            return _seekToAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189950);
            return 1000001;
        }
    }

    @Deprecated
    public int switchDefinitionAsync(String str, long j2) {
        AppMethodBeat.i(189951);
        int switchDefinitionAsync = switchDefinitionAsync(str, 0, j2);
        AppMethodBeat.o(189951);
        return switchDefinitionAsync;
    }

    public int switchDefinitionAsync(String str, int i2, long j2) {
        AppMethodBeat.i(189952);
        try {
            int _switchDefinitionAsync = _switchDefinitionAsync(str, i2, j2);
            AppMethodBeat.o(189952);
            return _switchDefinitionAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189952);
            return 1000001;
        }
    }

    public int setOptionLong(int i2, long j2, long j3) {
        AppMethodBeat.i(189953);
        try {
            int _setOptionLong = _setOptionLong(i2, j2, j3);
            AppMethodBeat.o(189953);
            return _setOptionLong;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189953);
            return 1000001;
        }
    }

    public int setOptionObject(int i2, Object obj) {
        AppMethodBeat.i(189954);
        try {
            int _setOptionObject = _setOptionObject(i2, obj);
            AppMethodBeat.o(189954);
            return _setOptionObject;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189954);
            return 1000001;
        }
    }

    public int setAudioVolume(float f2) {
        AppMethodBeat.i(189955);
        try {
            int _setAudioVolume = _setAudioVolume(f2);
            AppMethodBeat.o(189955);
            return _setAudioVolume;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189955);
            return 1000001;
        }
    }

    public int setAudioMute(boolean z) {
        AppMethodBeat.i(189956);
        try {
            int _setAudioMute = _setAudioMute(z);
            AppMethodBeat.o(189956);
            return _setAudioMute;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189956);
            return 1000001;
        }
    }

    public int setAudioNormalizeVolumeParams(String str) {
        AppMethodBeat.i(189957);
        try {
            int _setAudioNormalizeVolumeParams = _setAudioNormalizeVolumeParams(str);
            AppMethodBeat.o(189957);
            return _setAudioNormalizeVolumeParams;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189957);
            return 1000001;
        }
    }

    public int setPlaybackRate(float f2) {
        AppMethodBeat.i(189958);
        try {
            int _setPlaybackRate = _setPlaybackRate(f2);
            AppMethodBeat.o(189958);
            return _setPlaybackRate;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189958);
            return 1000001;
        }
    }

    public int setVideoSurface(Surface surface) {
        AppMethodBeat.i(189959);
        try {
            int _setVideoSurface = _setVideoSurface(surface);
            AppMethodBeat.o(189959);
            return _setVideoSurface;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189959);
            return 1000001;
        }
    }

    public int setVideoSurfaceWithType(Surface surface, int i2) {
        AppMethodBeat.i(189960);
        try {
            int _setVideoSurfaceWithType = _setVideoSurfaceWithType(surface, i2);
            AppMethodBeat.o(189960);
            return _setVideoSurfaceWithType;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189960);
            return 1000001;
        }
    }

    public int setLoopback(boolean z, long j2, long j3) {
        AppMethodBeat.i(189961);
        try {
            int _setLoopback = _setLoopback(z, j2, j3);
            AppMethodBeat.o(189961);
            return _setLoopback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189961);
            return 1000001;
        }
    }

    public int setMessageCallback(ITPNativePlayerMessageCallback iTPNativePlayerMessageCallback) {
        AppMethodBeat.i(189962);
        try {
            int _setMessageCallback = _setMessageCallback(iTPNativePlayerMessageCallback);
            AppMethodBeat.o(189962);
            return _setMessageCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189962);
            return 1000001;
        }
    }

    public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback iTPNativePlayerAudioFrameCallback) {
        AppMethodBeat.i(189963);
        try {
            int _setAudioFrameCallback = _setAudioFrameCallback(iTPNativePlayerAudioFrameCallback);
            AppMethodBeat.o(189963);
            return _setAudioFrameCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189963);
            return 1000001;
        }
    }

    public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback iTPNativePlayerVideoFrameCallback) {
        AppMethodBeat.i(189964);
        try {
            int _setVideoFrameCallback = _setVideoFrameCallback(iTPNativePlayerVideoFrameCallback);
            AppMethodBeat.o(189964);
            return _setVideoFrameCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189964);
            return 1000001;
        }
    }

    public int setSubtitleFrameCallback(ITPNativePlayerSubtitleFrameCallback iTPNativePlayerSubtitleFrameCallback) {
        AppMethodBeat.i(189965);
        try {
            int _setSubtitleFrameCallback = _setSubtitleFrameCallback(iTPNativePlayerSubtitleFrameCallback);
            AppMethodBeat.o(189965);
            return _setSubtitleFrameCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189965);
            return 1000001;
        }
    }

    public int setDemuxerCallback(ITPDemuxerCallback iTPDemuxerCallback) {
        AppMethodBeat.i(189966);
        try {
            int _setDemuxerCallback = _setDemuxerCallback(iTPDemuxerCallback);
            AppMethodBeat.o(189966);
            return _setDemuxerCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189966);
            return 1000001;
        }
    }

    public int setPostProcessFrameCallback(ITPNativePlayerPostProcessFrameCallback iTPNativePlayerPostProcessFrameCallback) {
        AppMethodBeat.i(189967);
        try {
            int _setPostProcessFrameCallback = _setPostProcessFrameCallback(iTPNativePlayerPostProcessFrameCallback);
            AppMethodBeat.o(189967);
            return _setPostProcessFrameCallback;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189967);
            return 1000001;
        }
    }

    public int getPlayerID() {
        AppMethodBeat.i(189968);
        try {
            int _getPlayerID = _getPlayerID();
            AppMethodBeat.o(189968);
            return _getPlayerID;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189968);
            return 0;
        }
    }

    public long getPropertyLong(int i2) {
        AppMethodBeat.i(189969);
        try {
            long _getPropertyLong = _getPropertyLong(i2);
            AppMethodBeat.o(189969);
            return _getPropertyLong;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189969);
            return 0;
        }
    }

    public String getPropertyString(int i2) {
        AppMethodBeat.i(189970);
        try {
            String _getPropertyString = _getPropertyString(i2);
            AppMethodBeat.o(189970);
            return _getPropertyString;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189970);
            return "";
        }
    }

    public int getVideoWidth() {
        AppMethodBeat.i(189971);
        try {
            int _getVideoWidth = _getVideoWidth();
            AppMethodBeat.o(189971);
            return _getVideoWidth;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189971);
            return 0;
        }
    }

    public int getVideoHeight() {
        AppMethodBeat.i(189972);
        try {
            int _getVideoHeight = _getVideoHeight();
            AppMethodBeat.o(189972);
            return _getVideoHeight;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189972);
            return 0;
        }
    }

    public long getDurationMs() {
        AppMethodBeat.i(189973);
        try {
            long _getDurationMs = _getDurationMs();
            AppMethodBeat.o(189973);
            return _getDurationMs;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189973);
            return 0;
        }
    }

    public long getCurrentPositionMs() {
        AppMethodBeat.i(189974);
        try {
            long _getCurrentPositionMs = _getCurrentPositionMs();
            AppMethodBeat.o(189974);
            return _getCurrentPositionMs;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189974);
            return 0;
        }
    }

    public long getBufferedDurationMs() {
        AppMethodBeat.i(189975);
        try {
            long _getBufferedDurationMs = _getBufferedDurationMs();
            AppMethodBeat.o(189975);
            return _getBufferedDurationMs;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189975);
            return 0;
        }
    }

    public long getBufferedSize() {
        AppMethodBeat.i(189976);
        try {
            long _getBufferedSize = _getBufferedSize();
            AppMethodBeat.o(189976);
            return _getBufferedSize;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189976);
            return 0;
        }
    }

    public int addSubtitleTrackSource(String str, String str2) {
        AppMethodBeat.i(189977);
        try {
            int _addSubtitleTrackSource = _addSubtitleTrackSource(str, str2);
            AppMethodBeat.o(189977);
            return _addSubtitleTrackSource;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189977);
            return 1000001;
        }
    }

    public int addAudioTrackSource(String str, String str2) {
        AppMethodBeat.i(189978);
        try {
            int _addAudioTrackSource = _addAudioTrackSource(str, str2);
            AppMethodBeat.o(189978);
            return _addAudioTrackSource;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189978);
            return 1000001;
        }
    }

    public int selectTrackAsync(int i2, long j2) {
        AppMethodBeat.i(189979);
        try {
            int _selectTrackAsync = _selectTrackAsync(i2, j2);
            AppMethodBeat.o(189979);
            return _selectTrackAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189979);
            return 1000001;
        }
    }

    public int deselectTrackAsync(int i2, long j2) {
        AppMethodBeat.i(189980);
        try {
            int _deselectTrackAsync = _deselectTrackAsync(i2, j2);
            AppMethodBeat.o(189980);
            return _deselectTrackAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189980);
            return 1000001;
        }
    }

    public TPMediaTrackInfo[] getTrackInfo() {
        TPMediaTrackInfo[] tPMediaTrackInfoArr;
        AppMethodBeat.i(189981);
        try {
            int _getTrackCount = _getTrackCount();
            if (_getTrackCount > 0) {
                tPMediaTrackInfoArr = new TPMediaTrackInfo[_getTrackCount];
                for (int i2 = 0; i2 < _getTrackCount; i2++) {
                    tPMediaTrackInfoArr[i2] = new TPMediaTrackInfo();
                    tPMediaTrackInfoArr[i2].trackType = _getTrackType(i2);
                    tPMediaTrackInfoArr[i2].trackName = _getTrackName(i2);
                    tPMediaTrackInfoArr[i2].isSelected = _getTrackIsSelected(i2);
                    tPMediaTrackInfoArr[i2].isExclusive = _getTrackIsExclusive(i2);
                    tPMediaTrackInfoArr[i2].isInternal = _getTrackIsInternal(i2);
                }
            } else {
                tPMediaTrackInfoArr = null;
            }
            AppMethodBeat.o(189981);
            return tPMediaTrackInfoArr;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189981);
            return null;
        }
    }

    public int getProgramCount() {
        AppMethodBeat.i(189982);
        try {
            int _getProgramCount = _getProgramCount();
            AppMethodBeat.o(189982);
            return _getProgramCount;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189982);
            return 1000001;
        }
    }

    public int selectProgramAsync(int i2, long j2) {
        AppMethodBeat.i(189983);
        try {
            int _selectProgramAsync = _selectProgramAsync(i2, j2);
            AppMethodBeat.o(189983);
            return _selectProgramAsync;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189983);
            return 1000001;
        }
    }

    public TPNativePlayerProgramInfo[] getProgramInfo() {
        AppMethodBeat.i(189984);
        try {
            int _getProgramCount = _getProgramCount();
            TPNativePlayerProgramInfo[] tPNativePlayerProgramInfoArr = new TPNativePlayerProgramInfo[_getProgramCount];
            for (int i2 = 0; i2 < _getProgramCount; i2++) {
                tPNativePlayerProgramInfoArr[i2] = _getProgramInfo(i2);
            }
            AppMethodBeat.o(189984);
            return tPNativePlayerProgramInfoArr;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189984);
            return null;
        }
    }
}
