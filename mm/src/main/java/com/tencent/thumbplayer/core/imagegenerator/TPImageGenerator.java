package com.tencent.thumbplayer.core.imagegenerator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import java.util.Map;

public class TPImageGenerator {
    private ITPImageGeneratorCallback mCallback = null;
    private int mFd = -1;
    private Map<String, String> mHttpHeader = null;
    private boolean mInited = false;
    private boolean mIsLibLoaded = false;
    private long mNativeContext = 0;
    private String mUrl = null;

    private native void _cancelAllImageGenerations();

    private native int _createWithFd(int i2, Object obj);

    private native int _createWithUrl(String str, Object obj);

    private native void _generateImageAsyncAtTime(long j2, long j3, Object obj);

    private native void _generateImagesAsyncForTimes(long[] jArr, long j2, Object obj);

    private native void _release();

    private void loadLibrary() {
        AppMethodBeat.i(189929);
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            this.mIsLibLoaded = true;
            AppMethodBeat.o(189929);
        } catch (UnsupportedOperationException e2) {
            this.mIsLibLoaded = false;
            AppMethodBeat.o(189929);
        }
    }

    public TPImageGenerator(String str, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        AppMethodBeat.i(189930);
        loadLibrary();
        this.mUrl = str;
        this.mCallback = iTPImageGeneratorCallback;
        AppMethodBeat.o(189930);
    }

    public TPImageGenerator(String str, Map<String, String> map, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        AppMethodBeat.i(189931);
        loadLibrary();
        this.mUrl = str;
        this.mHttpHeader = map;
        this.mCallback = iTPImageGeneratorCallback;
        AppMethodBeat.o(189931);
    }

    public TPImageGenerator(int i2, ITPImageGeneratorCallback iTPImageGeneratorCallback) {
        AppMethodBeat.i(189932);
        loadLibrary();
        this.mFd = i2;
        this.mCallback = iTPImageGeneratorCallback;
        AppMethodBeat.o(189932);
    }

    public void init() {
        AppMethodBeat.i(189933);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189933);
            throw unsupportedOperationException;
        } else if (this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to init due to invalid state.");
            AppMethodBeat.o(189933);
            throw illegalStateException;
        } else {
            this.mInited = true;
            if (this.mUrl == null || this.mHttpHeader == null) {
                if (this.mUrl != null) {
                    _createWithUrl(this.mUrl, this.mCallback);
                    AppMethodBeat.o(189933);
                    return;
                }
                _createWithFd(this.mFd, this.mCallback);
            }
            AppMethodBeat.o(189933);
        }
    }

    public void unInit() {
        AppMethodBeat.i(189934);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189934);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            AppMethodBeat.o(189934);
        } else {
            this.mInited = false;
            _release();
            AppMethodBeat.o(189934);
        }
    }

    public void generateImageAsyncAtTime(long j2, long j3, TPImageGeneratorParams tPImageGeneratorParams) {
        AppMethodBeat.i(189935);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189935);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to generate image at time " + j2 + " due to invalid state.");
            AppMethodBeat.o(189935);
            throw illegalStateException;
        } else {
            _generateImageAsyncAtTime(j2, j3, tPImageGeneratorParams);
            AppMethodBeat.o(189935);
        }
    }

    public void generateImagesAsyncForTimes(long[] jArr, long j2, TPImageGeneratorParams tPImageGeneratorParams) {
        AppMethodBeat.i(189936);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189936);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            IllegalStateException illegalStateException = new IllegalStateException("Failed to generate images due to invalid state.");
            AppMethodBeat.o(189936);
            throw illegalStateException;
        } else {
            _generateImagesAsyncForTimes(jArr, j2, tPImageGeneratorParams);
            AppMethodBeat.o(189936);
        }
    }

    public void cancelAllImageGenerations() {
        AppMethodBeat.i(189937);
        if (!this.mIsLibLoaded) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
            AppMethodBeat.o(189937);
            throw unsupportedOperationException;
        } else if (!this.mInited) {
            AppMethodBeat.o(189937);
        } else {
            _cancelAllImageGenerations();
            AppMethodBeat.o(189937);
        }
    }
}
