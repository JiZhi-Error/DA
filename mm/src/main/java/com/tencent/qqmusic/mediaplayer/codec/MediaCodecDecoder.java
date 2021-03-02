package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.tav.decoder.EncoderWriter;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(23)
public class MediaCodecDecoder extends BaseDecoder {
    private static final int CONTINUOUS_TIMEOUT_COUNT = 500;
    private static final String KEY_BIT_RATE = "bit-rate";
    private static final String KEY_PCM_ENCODING = "pcm-encoding";
    private static final String TAG = "MediaCodecDecoder";
    private static final long TIMEOUT_AUTO_SEEK_INTERVAL_MS = 5000;
    private static final int TIMEOUT_US = 1000;
    private WeakReference<AudioTrack> mAudioTrackRef = new WeakReference<>(null);
    private long mCurrentDecodeTime = 0;
    private boolean mDecoderFinished = false;
    private long mFileSize = 0;
    private AudioInformation mInfo = null;
    private MediaCodec mMediaCodec = null;
    private final MediaExtractor mMediaExtractor = new MediaExtractor();
    private volatile byte[] mRemainBuffer = null;
    private SeekTable mSeekTable = null;

    public MediaCodecDecoder() {
        AppMethodBeat.i(114358);
        AppMethodBeat.o(114358);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public List<NativeLibs> getNativeLibs() {
        AppMethodBeat.i(114359);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(114359);
        return arrayList;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(String str, boolean z) {
        AppMethodBeat.i(114360);
        int init = init(new FileDataSource(str));
        AppMethodBeat.o(114360);
        return init;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    @TargetApi(23)
    public int init(final IDataSource iDataSource) {
        int i2 = -1;
        AppMethodBeat.i(114361);
        if (iDataSource != null) {
            try {
                iDataSource.open();
                this.mMediaExtractor.setDataSource(new MediaDataSource() {
                    /* class com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder.AnonymousClass1 */

                    @Override // android.media.MediaDataSource
                    public int readAt(long j2, byte[] bArr, int i2, int i3) {
                        AppMethodBeat.i(114334);
                        int readAt = iDataSource.readAt(j2, bArr, i2, i3);
                        AppMethodBeat.o(114334);
                        return readAt;
                    }

                    @Override // android.media.MediaDataSource
                    public long getSize() {
                        AppMethodBeat.i(114335);
                        long size = iDataSource.getSize();
                        AppMethodBeat.o(114335);
                        return size;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }
                });
                this.mFileSize = iDataSource.getSize();
                if (initMediaCodecAndFormat(iDataSource)) {
                    i2 = 0;
                }
            } catch (Throwable th) {
                Logger.e(TAG, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, th);
            }
        }
        AppMethodBeat.o(114361);
        return i2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int init(INativeDataSource iNativeDataSource) {
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public AudioInformation getAudioInformation() {
        return this.mInfo;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int decodeData(int i2, byte[] bArr) {
        long currentTime;
        AppMethodBeat.i(114362);
        try {
            int decodeDataInternal = decodeDataInternal(i2, bArr);
            AppMethodBeat.o(114362);
            return decodeDataInternal;
        } catch (BufferTimeoutException e2) {
            do {
                currentTime = getCurrentTime() + TIMEOUT_AUTO_SEEK_INTERVAL_MS;
                Logger.i(TAG, "decodeData buffer timeout, seekTime:".concat(String.valueOf(currentTime)));
                seekTo((int) Math.min(getDuration(), currentTime));
                try {
                    int decodeDataInternal2 = decodeDataInternal(i2, bArr);
                    AppMethodBeat.o(114362);
                    return decodeDataInternal2;
                } catch (BufferTimeoutException e3) {
                    if (currentTime < getDuration()) {
                        AppMethodBeat.o(114362);
                        return -1;
                    }
                }
            } while (currentTime < getDuration());
            AppMethodBeat.o(114362);
            return -1;
        }
    }

    private int processInputOutputBuffer(MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(114363);
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(1000);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer inputBuffer = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
            if (inputBuffer == null) {
                NullInputBufferException nullInputBufferException = new NullInputBufferException();
                AppMethodBeat.o(114363);
                throw nullInputBufferException;
            }
            int readSampleData = this.mMediaExtractor.readSampleData(inputBuffer, 0);
            if (readSampleData < 0) {
                Logger.i(TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
            } else {
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
                this.mMediaExtractor.advance();
            }
        }
        int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 1000);
        AppMethodBeat.o(114363);
        return dequeueOutputBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int decodeDataInternal(int r13, byte[] r14) {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder.decodeDataInternal(int, byte[]):int");
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getCurrentTime() {
        return this.mCurrentDecodeTime;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int seekTo(int i2) {
        AppMethodBeat.i(114365);
        this.mMediaCodec.flush();
        this.mRemainBuffer = null;
        this.mMediaExtractor.seekTo((long) (i2 * 1000), 2);
        this.mCurrentDecodeTime = (long) i2;
        AppMethodBeat.o(114365);
        return i2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int release() {
        AppMethodBeat.i(114366);
        this.mMediaExtractor.release();
        if (this.mMediaCodec != null) {
            this.mMediaCodec.release();
        }
        AppMethodBeat.o(114366);
        return 0;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public int getErrorCodeMask() {
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getDuration() {
        AppMethodBeat.i(114367);
        long j2 = 0;
        if (this.mInfo != null) {
            j2 = this.mInfo.getDuration();
        }
        AppMethodBeat.o(114367);
        return j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getMinBufferSize() {
        long j2;
        int i2 = 4;
        AppMethodBeat.i(114368);
        if (this.mInfo != null) {
            int bitDepth = this.mInfo.getBitDepth();
            if (bitDepth == 1) {
                i2 = 3;
            } else if (bitDepth != 4 || Build.VERSION.SDK_INT < 21) {
                i2 = 2;
            }
            j2 = (long) AudioTrack.getMinBufferSize((int) this.mInfo.getSampleRate(), 12, i2);
        } else {
            j2 = 0;
        }
        AppMethodBeat.o(114368);
        return j2;
    }

    private boolean initMediaCodecAndFormat(IDataSource iDataSource) {
        boolean z = false;
        AppMethodBeat.i(114369);
        int i2 = 0;
        while (true) {
            if (i2 >= this.mMediaExtractor.getTrackCount()) {
                break;
            }
            MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                this.mInfo = new AudioInformation();
                AudioFormat.AudioType audioType = iDataSource.getAudioType();
                this.mInfo.setAudioType(audioType);
                setAudioType(audioType);
                z = initAudioInformation(string, i2, trackFormat, iDataSource, audioType);
                break;
            }
            i2++;
        }
        AppMethodBeat.o(114369);
        return z;
    }

    private static MediaFormat getMediaFormatByExtractor(MediaExtractor mediaExtractor) {
        MediaFormat mediaFormat;
        AppMethodBeat.i(114370);
        int i2 = 0;
        while (true) {
            if (i2 >= mediaExtractor.getTrackCount()) {
                mediaFormat = null;
                break;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                mediaFormat = trackFormat;
                break;
            }
            i2++;
        }
        AppMethodBeat.o(114370);
        return mediaFormat;
    }

    public static AudioFormat.AudioType getAudioType(String str) {
        boolean z;
        AppMethodBeat.i(114371);
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        if (Build.VERSION.SDK_INT >= 16) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                z = true;
            } catch (Throwable th) {
                Logger.e(TAG, "getAudioType", th);
                z = false;
            }
            if (z) {
                FileDataSource fileDataSource = new FileDataSource(str);
                fileDataSource.open();
                audioType = getAudioType(mediaExtractor, fileDataSource);
                fileDataSource.close();
            }
        }
        AppMethodBeat.o(114371);
        return audioType;
    }

    @TargetApi(16)
    private static AudioFormat.AudioType getAudioType(MediaExtractor mediaExtractor, IDataSource iDataSource) {
        AppMethodBeat.i(114372);
        AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
        MediaFormat mediaFormatByExtractor = getMediaFormatByExtractor(mediaExtractor);
        if (mediaFormatByExtractor != null) {
            String string = mediaFormatByExtractor.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                char c2 = 65535;
                switch (string.hashCode()) {
                    case -1003765268:
                        if (string.equals("audio/vorbis")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -53558318:
                        if (string.equals(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 187094639:
                        if (string.equals("audio/raw")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1504619009:
                        if (string.equals("audio/flac")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1504831518:
                        if (string.equals("audio/mpeg")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        audioType = AudioFormat.AudioType.OGG;
                        break;
                    case 1:
                        audioType = AudioFormat.AudioType.FLAC;
                        break;
                    case 2:
                        if (!FLACRecognition.isFlac(iDataSource)) {
                            if (WavRecognition.isWav(iDataSource)) {
                                audioType = AudioFormat.AudioType.WAV;
                                break;
                            }
                        } else {
                            audioType = AudioFormat.AudioType.FLAC;
                            break;
                        }
                        break;
                    case 3:
                        if (FfmpegRecognition.isM4a(iDataSource)) {
                            audioType = AudioFormat.AudioType.M4A;
                            break;
                        }
                        break;
                    case 4:
                        audioType = AudioFormat.AudioType.MP3;
                        break;
                }
            }
        }
        AppMethodBeat.o(114372);
        return audioType;
    }

    private static void setAudioInformationByMediaFormat(AudioInformation audioInformation, MediaFormat mediaFormat, long j2) {
        int i2;
        AppMethodBeat.i(114373);
        int integer = mediaFormat.getInteger("sample-rate");
        int integer2 = mediaFormat.getInteger("channel-count");
        long j3 = 0;
        int i3 = 0;
        if (mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
            i3 = mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) / 1000;
        } else if (mediaFormat.containsKey(KEY_BIT_RATE)) {
            i3 = mediaFormat.getInteger(KEY_BIT_RATE) / 1000;
        }
        if (i3 > 0) {
            j3 = mediaFormat.containsKey("durationUs") ? mediaFormat.getLong("durationUs") / 1000 : (long) ((int) ((j2 / ((long) i3)) * 8));
        } else if (mediaFormat.containsKey("durationUs")) {
            j3 = mediaFormat.getLong("durationUs") / 1000;
            if (j3 > 0) {
                i3 = (int) ((j2 / j3) * 8);
            } else {
                i3 = 0;
            }
        }
        if (mediaFormat.containsKey(KEY_PCM_ENCODING)) {
            switch (mediaFormat.getInteger(KEY_PCM_ENCODING)) {
                case 3:
                    i2 = 1;
                    break;
                case 4:
                    i2 = 4;
                    break;
                default:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int i4 = 0;
            try {
                i4 = mediaFormat.getInteger("bitrate-mode");
            } catch (Exception e2) {
            }
            switch (i4) {
                case 1:
                    audioInformation.setCbr(3);
                    break;
                case 2:
                    audioInformation.setCbr(1);
                    break;
            }
        }
        audioInformation.setSampleRate((long) integer);
        audioInformation.setChannels(integer2);
        audioInformation.setDuration(j3);
        audioInformation.setBitrate(i3);
        audioInformation.setBitDept(i2);
        AppMethodBeat.o(114373);
    }

    private boolean initAudioInformation(String str, int i2, MediaFormat mediaFormat, IDataSource iDataSource, AudioFormat.AudioType audioType) {
        MediaFormat mediaFormat2;
        boolean z;
        AppMethodBeat.i(114374);
        this.mMediaExtractor.selectTrack(i2);
        this.mMediaCodec = MediaCodec.createDecoderByType(str);
        this.mMediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        this.mMediaCodec.start();
        int i3 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= 500 || !(i3 == -1 || i3 == -3)) {
                mediaFormat2 = null;
            } else {
                try {
                    i3 = processInputOutputBuffer(new MediaCodec.BufferInfo());
                    if (i3 == -2) {
                        mediaFormat2 = this.mMediaCodec.getOutputFormat();
                        break;
                    }
                    i4++;
                } catch (NullInputBufferException e2) {
                }
            }
        }
        if (mediaFormat2 != null) {
            Logger.i(TAG, "format:" + mediaFormat + " outputFormat:" + mediaFormat2);
            if (mediaFormat2.containsKey(KEY_PCM_ENCODING)) {
                mediaFormat.setInteger(KEY_PCM_ENCODING, mediaFormat2.getInteger(KEY_PCM_ENCODING));
            }
            if (mediaFormat2.containsKey("sample-rate")) {
                mediaFormat.setInteger("sample-rate", mediaFormat2.getInteger("sample-rate"));
            }
            if (mediaFormat2.containsKey("channel-count")) {
                mediaFormat.setInteger("channel-count", mediaFormat2.getInteger("channel-count"));
            }
            setAudioInformationByMediaFormat(this.mInfo, mediaFormat, iDataSource.getSize());
            if (audioType == AudioFormat.AudioType.FLAC) {
                this.mSeekTable = new FlacSeekTable((int) this.mInfo.getSampleRate());
            } else if (audioType == AudioFormat.AudioType.M4A || audioType == AudioFormat.AudioType.MP4) {
                this.mSeekTable = new Mp4SeekTable();
            } else if (audioType == AudioFormat.AudioType.MP3) {
                this.mSeekTable = new Mp3SeekTable();
            }
            if (this.mSeekTable != null) {
                try {
                    this.mSeekTable.parse(iDataSource);
                } catch (InvalidBoxException e3) {
                    this.mSeekTable = null;
                    Logger.e(TAG, "seek table parse", e3);
                }
            }
            if (this.mInfo.getDuration() > 0 && this.mInfo.getChannels() >= 2) {
                z = true;
            }
            z = false;
        } else {
            this.mMediaCodec.release();
            z = false;
        }
        AppMethodBeat.o(114374);
        return z;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public long getBytePositionOfTime(long j2) {
        AppMethodBeat.i(114375);
        int bitrate = this.mInfo.getBitrate();
        if (this.mSeekTable != null) {
            long seek = this.mSeekTable.seek(j2);
            AppMethodBeat.o(114375);
            return seek;
        } else if (bitrate > 0) {
            long j3 = ((long) bitrate) * j2;
            AppMethodBeat.o(114375);
            return j3;
        } else if (getDuration() > 0) {
            long duration = (this.mFileSize * j2) / getDuration();
            AppMethodBeat.o(114375);
            return duration;
        } else {
            AppMethodBeat.o(114375);
            return 0;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    public void setAudioTrack(AudioTrack audioTrack) {
        AppMethodBeat.i(114376);
        this.mAudioTrackRef = new WeakReference<>(audioTrack);
        AppMethodBeat.o(114376);
    }

    /* access modifiers changed from: package-private */
    public static class BufferTimeoutException extends Exception {
        BufferTimeoutException() {
            super("buffer timeout exception");
        }
    }

    /* access modifiers changed from: package-private */
    public static class NullInputBufferException extends Exception {
        NullInputBufferException() {
            super("Null Input Buffer exception");
        }
    }
}
