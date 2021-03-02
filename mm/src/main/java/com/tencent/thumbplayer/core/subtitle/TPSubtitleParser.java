package com.tencent.thumbplayer.core.subtitle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPSubtitleFrameWrapper;

public class TPSubtitleParser {
    public static final int TP_SUBTITLE_OUTPUT_RGBA = 1;
    public static final int TP_SUBTITLE_OUTPUT_TEXT = 0;
    private ITPSubtitleParserCallback mCallback = null;
    private boolean mInited = false;
    private boolean mIsLibLoaded = false;
    private long mNativeContext = 0;
    private int mOutputType = 0;
    private String mUrl = null;

    private native int _subtitleCreate(String str, Object obj, int i2);

    private native void _subtitleDelete();

    private native TPSubtitleFrameWrapper _subtitleGetFrame(long j2);

    private native String _subtitleGetText(long j2, int i2);

    private native int _subtitleGetTrackCount();

    private native String _subtitleGetTrackName(int i2);

    private native int _subtitleSelectTrackAsync(int i2, long j2);

    private native void _subtitleSetCanvasSize(int i2, int i3);

    private void loadLibrary() {
        AppMethodBeat.i(189993);
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            this.mIsLibLoaded = true;
            AppMethodBeat.o(189993);
        } catch (UnsupportedOperationException e2) {
            this.mIsLibLoaded = false;
            AppMethodBeat.o(189993);
        }
    }

    public TPSubtitleParser(String str, ITPSubtitleParserCallback iTPSubtitleParserCallback) {
        AppMethodBeat.i(189994);
        loadLibrary();
        this.mUrl = str;
        this.mCallback = iTPSubtitleParserCallback;
        AppMethodBeat.o(189994);
    }

    public TPSubtitleParser(String str, ITPSubtitleParserCallback iTPSubtitleParserCallback, int i2) {
        AppMethodBeat.i(189995);
        loadLibrary();
        this.mUrl = str;
        this.mCallback = iTPSubtitleParserCallback;
        this.mOutputType = i2;
        AppMethodBeat.o(189995);
    }

    public void init() {
        AppMethodBeat.i(189996);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189996);
            throw unsupportedOperationException;
        } else if (this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to init due to invalid state.");
            AppMethodBeat.o(189996);
            throw illegalStateException;
        } else {
            this.mInited = true;
            if (!(this.mUrl == null || this.mCallback == null)) {
                _subtitleCreate(this.mUrl, this.mCallback, this.mOutputType);
            }
            AppMethodBeat.o(189996);
        }
    }

    public void unInit() {
        AppMethodBeat.i(189997);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189997);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            AppMethodBeat.o(189997);
        } else {
            this.mInited = false;
            _subtitleDelete();
            AppMethodBeat.o(189997);
        }
    }

    public TPMediaTrackInfo[] getTrackInfo() {
        AppMethodBeat.i(189998);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189998);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to getTrackInfo due to invalid state.");
            AppMethodBeat.o(189998);
            throw illegalStateException;
        } else {
            TPMediaTrackInfo[] tPMediaTrackInfoArr = null;
            int _subtitleGetTrackCount = _subtitleGetTrackCount();
            if (_subtitleGetTrackCount > 0) {
                tPMediaTrackInfoArr = new TPMediaTrackInfo[_subtitleGetTrackCount];
                for (int i2 = 0; i2 < _subtitleGetTrackCount; i2++) {
                    TPMediaTrackInfo tPMediaTrackInfo = new TPMediaTrackInfo();
                    tPMediaTrackInfo.trackType = 3;
                    tPMediaTrackInfo.trackName = _subtitleGetTrackName(i2);
                    tPMediaTrackInfoArr[i2] = tPMediaTrackInfo;
                }
            }
            AppMethodBeat.o(189998);
            return tPMediaTrackInfoArr;
        }
    }

    public int selectTrackAsync(int i2, long j2) {
        AppMethodBeat.i(189999);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189999);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to selectTrackAsync due to invalid state.");
            AppMethodBeat.o(189999);
            throw illegalStateException;
        } else {
            int _subtitleSelectTrackAsync = _subtitleSelectTrackAsync(i2, j2);
            AppMethodBeat.o(189999);
            return _subtitleSelectTrackAsync;
        }
    }

    public int selectTracksAsync(int[] iArr, long j2) {
        return 0;
    }

    public String getSubtitleText(long j2, int i2) {
        AppMethodBeat.i(190000);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(190000);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to getSubtitleText due to invalid state.");
            AppMethodBeat.o(190000);
            throw illegalStateException;
        } else {
            String _subtitleGetText = _subtitleGetText(j2, i2);
            AppMethodBeat.o(190000);
            return _subtitleGetText;
        }
    }

    public void setCanvasSize(int i2, int i3) {
        AppMethodBeat.i(190001);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(190001);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to setCanvasSize due to invalid state.");
            AppMethodBeat.o(190001);
            throw illegalStateException;
        } else {
            _subtitleSetCanvasSize(i2, i3);
            AppMethodBeat.o(190001);
        }
    }

    public TPSubtitleFrameWrapper getSubtitleFrame(long j2) {
        AppMethodBeat.i(190002);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(190002);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to getSubtitleFrame due to invalid state.");
            AppMethodBeat.o(190002);
            throw illegalStateException;
        } else {
            TPSubtitleFrameWrapper _subtitleGetFrame = _subtitleGetFrame(j2);
            AppMethodBeat.o(190002);
            return _subtitleGetFrame;
        }
    }
}
