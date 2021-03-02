package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.wrapper.ExtractorLoader;
import com.tencent.tav.extractor.wrapper.ExtractorWrapperPool;
import java.io.FileDescriptor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

public class AssetExtractor implements Cloneable {
    public static boolean DOWNGRADING = false;
    public static final int SAMPLE_FLAG_ENCRYPTED = 2;
    public static final int SAMPLE_FLAG_SYNC = 1;
    public static final int SEEK_TO_CLOSEST_SYNC = 2;
    public static final int SEEK_TO_NEXT_SYNC = 1;
    public static final int SEEK_TO_PREVIOUS_SYNC = 0;
    private static final String TAG = "AssetExtractor";
    private IAssetExtractorDelegate delegate;
    private long duration;
    private long mNativeContext;
    private int preferRotation;
    private boolean released;
    private CGSize size;
    private String sourcePath;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SampleFlag {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SeekMode {
    }

    private native synchronized boolean advanceNative();

    private native synchronized long getSampleTimeNative();

    private native synchronized int getSampleTrackIndexNative();

    private final native synchronized int getTrackCountNative();

    private native synchronized Map<String, Object> getTrackFormatNative(int i2);

    private final native synchronized void nativeFinalize();

    private static final native synchronized void nativeInit();

    private native synchronized int readSampleDataNative(ByteBuffer byteBuffer, int i2);

    private final native synchronized void releaseNative();

    private native void seekToNative(long j2, int i2);

    private native synchronized void selectTrackNative(int i2);

    private native synchronized void unselectTrackNative(int i2);

    public native int getSampleFlags();

    public final native void setDataSource(FileDescriptor fileDescriptor, long j2, long j3);

    static {
        AppMethodBeat.i(218504);
        if (ResourceLoadUtil.isLoaded()) {
            nativeInit();
            AppMethodBeat.o(218504);
            return;
        }
        System.out.println("loadlibrary : tav start");
        try {
            System.loadLibrary("tav");
            ResourceLoadUtil.setLoaded(true);
            nativeInit();
            AppMethodBeat.o(218504);
        } catch (Throwable th) {
            AppMethodBeat.o(218504);
        }
    }

    public AssetExtractor() {
        this(DOWNGRADING);
    }

    public AssetExtractor(boolean z) {
        AppMethodBeat.i(218482);
        this.released = false;
        this.mNativeContext = 0;
        this.sourcePath = "";
        this.duration = 0;
        this.size = null;
        this.preferRotation = -1;
        if (z) {
            this.delegate = new ApiAssetExtractorDelegate();
        }
        AppMethodBeat.o(218482);
    }

    @Override // java.lang.Object
    public AssetExtractor clone() {
        AppMethodBeat.i(218483);
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setSize(getSize());
        assetExtractor.setPreferRotation(getPreferRotation());
        assetExtractor.setDuration(getDuration());
        assetExtractor.setDataSource(this.sourcePath);
        AppMethodBeat.o(218483);
        return assetExtractor;
    }

    public final synchronized void setDataSource(String str) {
        AppMethodBeat.i(218484);
        if (this.delegate != null) {
            this.delegate.setDataSource(str);
        }
        this.sourcePath = str;
        if (ExtractorWrapperPool.contains(str)) {
            ExtractorWrapperPool.fillIn(this.sourcePath, this);
            AppMethodBeat.o(218484);
        } else {
            ExtractorLoader.cacheExtractor(str);
            AppMethodBeat.o(218484);
        }
    }

    public final synchronized void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        AppMethodBeat.i(218485);
        if (this.delegate != null) {
            this.delegate.setDataSource(assetFileDescriptor);
            AppMethodBeat.o(218485);
        } else if (assetFileDescriptor.getDeclaredLength() < 0) {
            setDataSource(assetFileDescriptor.getFileDescriptor());
            AppMethodBeat.o(218485);
        } else {
            setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
            AppMethodBeat.o(218485);
        }
    }

    public final synchronized void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(218486);
        if (this.delegate != null) {
            this.delegate.setDataSource(fileDescriptor);
            AppMethodBeat.o(218486);
        } else {
            setDataSource(fileDescriptor, 0, 576460752303423487L);
            AppMethodBeat.o(218486);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(218487);
        if (this.delegate != null) {
            AppMethodBeat.o(218487);
        } else if (this.released) {
            AppMethodBeat.o(218487);
        } else {
            synchronized (this) {
                try {
                    if (!this.released) {
                        this.released = true;
                        nativeFinalize();
                    }
                } finally {
                    AppMethodBeat.o(218487);
                }
            }
        }
    }

    public final synchronized void release() {
        AppMethodBeat.i(218488);
        if (this.delegate != null) {
            this.delegate.release();
            this.delegate = null;
            AppMethodBeat.o(218488);
        } else {
            if (!this.released) {
                releaseNative();
                this.released = true;
            }
            AppMethodBeat.o(218488);
        }
    }

    public final synchronized int getTrackCount() {
        int i2;
        AppMethodBeat.i(218489);
        if (this.delegate != null) {
            i2 = this.delegate.getTrackCount();
            AppMethodBeat.o(218489);
        } else if (!this.released) {
            i2 = getTrackCountNative();
            AppMethodBeat.o(218489);
        } else {
            i2 = 0;
            AppMethodBeat.o(218489);
        }
        return i2;
    }

    public synchronized MediaFormat getTrackFormat(int i2) {
        MediaFormat mediaFormat;
        AppMethodBeat.i(218490);
        if (this.delegate != null) {
            mediaFormat = this.delegate.getTrackFormat(i2);
            AppMethodBeat.o(218490);
        } else {
            mediaFormat = new MediaFormat();
            if (this.released) {
                AppMethodBeat.o(218490);
            } else {
                Map<String, Object> trackFormatNative = getTrackFormatNative(i2);
                try {
                    Field declaredField = MediaFormat.class.getDeclaredField("mMap");
                    declaredField.setAccessible(true);
                    declaredField.set(mediaFormat, trackFormatNative);
                } catch (Exception e2) {
                    Logger.e("VideoCore", e2.getMessage());
                }
                AppMethodBeat.o(218490);
            }
        }
        return mediaFormat;
    }

    public synchronized void selectTrack(int i2) {
        AppMethodBeat.i(218491);
        if (this.delegate != null) {
            this.delegate.selectTrack(i2);
            AppMethodBeat.o(218491);
        } else {
            if (!this.released) {
                selectTrackNative(i2);
            }
            AppMethodBeat.o(218491);
        }
    }

    public synchronized void unselectTrack(int i2) {
        AppMethodBeat.i(218492);
        if (this.delegate != null) {
            this.delegate.unselectTrack(i2);
            AppMethodBeat.o(218492);
        } else {
            if (!this.released) {
                unselectTrackNative(i2);
            }
            AppMethodBeat.o(218492);
        }
    }

    public synchronized void seekTo(long j2, int i2) {
        AppMethodBeat.i(218493);
        if (this.delegate != null) {
            this.delegate.seekTo(j2, i2);
            AppMethodBeat.o(218493);
        } else {
            if (!this.released) {
                seekToNative(j2, i2);
            }
            AppMethodBeat.o(218493);
        }
    }

    public synchronized boolean advance() {
        boolean z;
        AppMethodBeat.i(218494);
        if (this.delegate != null) {
            z = this.delegate.advance();
            AppMethodBeat.o(218494);
        } else if (!this.released) {
            z = advanceNative();
            AppMethodBeat.o(218494);
        } else {
            z = false;
            AppMethodBeat.o(218494);
        }
        return z;
    }

    public synchronized int readSampleData(ByteBuffer byteBuffer, int i2) {
        int i3;
        AppMethodBeat.i(218495);
        if (this.delegate != null) {
            i3 = this.delegate.readSampleData(byteBuffer, i2);
            AppMethodBeat.o(218495);
        } else if (!this.released) {
            i3 = readSampleDataNative(byteBuffer, i2);
            AppMethodBeat.o(218495);
        } else {
            i3 = -1;
            AppMethodBeat.o(218495);
        }
        return i3;
    }

    public synchronized int getSampleTrackIndex() {
        int i2;
        AppMethodBeat.i(218496);
        if (this.delegate != null) {
            i2 = this.delegate.getSampleTrackIndex();
            AppMethodBeat.o(218496);
        } else if (!this.released) {
            i2 = getSampleTrackIndexNative();
            AppMethodBeat.o(218496);
        } else {
            i2 = -1;
            AppMethodBeat.o(218496);
        }
        return i2;
    }

    public synchronized long getSampleTime() {
        long j2;
        AppMethodBeat.i(218497);
        if (this.delegate != null) {
            j2 = this.delegate.getSampleTime();
            AppMethodBeat.o(218497);
        } else if (!this.released) {
            j2 = getSampleTimeNative();
            AppMethodBeat.o(218497);
        } else {
            j2 = -1;
            AppMethodBeat.o(218497);
        }
        return j2;
    }

    public synchronized void dispose() {
        AppMethodBeat.i(218498);
        if (this.sourcePath.isEmpty()) {
            AppMethodBeat.o(218498);
        } else {
            if (!this.released && this.delegate == null) {
                releaseNative();
            }
            AppMethodBeat.o(218498);
        }
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public boolean isReleased() {
        return this.released;
    }

    public synchronized long getDuration() {
        long j2;
        AppMethodBeat.i(218499);
        if (this.duration == 0) {
            this.duration = DecoderUtils.getDuration(this);
        }
        j2 = this.duration;
        AppMethodBeat.o(218499);
        return j2;
    }

    public synchronized long getAudioDuration() {
        long audioDuration;
        AppMethodBeat.i(218500);
        audioDuration = DecoderUtils.getAudioDuration(this);
        AppMethodBeat.o(218500);
        return audioDuration;
    }

    public synchronized CGSize getSize() {
        CGSize cGSize;
        AppMethodBeat.i(218501);
        if (this.size == null) {
            this.size = ExtractorUtils.getVideoSize(this);
        }
        cGSize = this.size;
        AppMethodBeat.o(218501);
        return cGSize;
    }

    public synchronized int getPreferRotation() {
        int i2;
        AppMethodBeat.i(218502);
        if (this.preferRotation == -1) {
            this.preferRotation = ExtractorUtils.getPreferRotation(this);
        }
        i2 = this.preferRotation;
        AppMethodBeat.o(218502);
        return i2;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setSize(CGSize cGSize) {
        this.size = cGSize;
    }

    public void setPreferRotation(int i2) {
        this.preferRotation = i2;
    }
}
