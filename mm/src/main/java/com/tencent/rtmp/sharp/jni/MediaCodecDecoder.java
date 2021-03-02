package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;

public class MediaCodecDecoder {
    private static final String TAG = "MediaCodecDecoder";
    private MediaCodec.BufferInfo mAACDecBufferInfo = null;
    private MediaCodec mAudioAACDecoder = null;
    private int mChannels = 2;
    private ByteBuffer mDecInBuffer = ByteBuffer.allocateDirect(16384);
    private ByteBuffer mDecOutBuffer = ByteBuffer.allocateDirect(16384);
    ByteBuffer mInputBuffer = null;
    ByteBuffer mOutputBuffer = null;
    private int mSampleRate = 44100;
    private byte[] mTempBufDec = new byte[16384];

    public MediaCodecDecoder() {
        AppMethodBeat.i(13650);
        AppMethodBeat.o(13650);
    }

    @SuppressLint({"NewApi"})
    public int createAACDecoder(int i2, int i3) {
        AppMethodBeat.i(13651);
        try {
            this.mAudioAACDecoder = MediaCodec.createDecoderByType(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, i2, i3);
            createAudioFormat.setInteger("sample-rate", i2);
            createAudioFormat.setInteger("channel-count", i3);
            createAudioFormat.setInteger("aac-profile", 2);
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{17, -112}));
            this.mAudioAACDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            if (this.mAudioAACDecoder != null) {
                this.mAudioAACDecoder.start();
                this.mAACDecBufferInfo = new MediaCodec.BufferInfo();
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "createAACDecoder succeed!!! : (" + i2 + ", " + i3 + ")");
                }
            }
            AppMethodBeat.o(13651);
            return 0;
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Error when creating aac decode stream");
            }
            AppMethodBeat.o(13651);
            return -1;
        }
    }

    public int decodeAACFrame(int i2) {
        AppMethodBeat.i(13652);
        this.mDecInBuffer.get(this.mTempBufDec, 0, i2);
        int decodeInternalAACFrame = decodeInternalAACFrame(i2);
        this.mDecOutBuffer.rewind();
        if (decodeInternalAACFrame > 0) {
            this.mDecOutBuffer.put(this.mTempBufDec, 0, decodeInternalAACFrame);
        } else {
            decodeInternalAACFrame = 0;
        }
        AppMethodBeat.o(13652);
        return decodeInternalAACFrame;
    }

    @SuppressLint({"NewApi"})
    public int decodeInternalAACFrame(int i2) {
        AppMethodBeat.i(13653);
        while (true) {
            try {
                int dequeueInputBuffer = this.mAudioAACDecoder.dequeueInputBuffer(200);
                if (dequeueInputBuffer >= 0) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.mInputBuffer = this.mAudioAACDecoder.getInputBuffer(dequeueInputBuffer);
                    } else {
                        this.mInputBuffer = this.mAudioAACDecoder.getInputBuffers()[dequeueInputBuffer];
                    }
                    this.mInputBuffer.clear();
                    this.mInputBuffer.put(this.mTempBufDec, 0, i2);
                    this.mDecInBuffer.rewind();
                    this.mAudioAACDecoder.queueInputBuffer(dequeueInputBuffer, 0, i2, 0, 0);
                }
                int dequeueOutputBuffer = this.mAudioAACDecoder.dequeueOutputBuffer(this.mAACDecBufferInfo, 10000);
                if (dequeueOutputBuffer < 0) {
                    AppMethodBeat.o(13653);
                    return 0;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffers()[dequeueOutputBuffer];
                }
                int i3 = this.mAACDecBufferInfo.size;
                try {
                    this.mOutputBuffer.limit(i3);
                    this.mOutputBuffer.get(this.mTempBufDec, 0, i3);
                    this.mOutputBuffer.position(0);
                    this.mAudioAACDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    AppMethodBeat.o(13653);
                    return i3;
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "Error when decoding aac stream");
                    }
                }
            } catch (Exception e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "decode failed.");
                }
                AppMethodBeat.o(13653);
                return 0;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public int releaseAACDecoder() {
        AppMethodBeat.i(13654);
        try {
            if (this.mAudioAACDecoder != null) {
                this.mAudioAACDecoder.stop();
                this.mAudioAACDecoder.release();
                this.mAudioAACDecoder = null;
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "releaseAACDecoder, release aac decode stream succeed!!");
                }
                AppMethodBeat.o(13654);
                return 0;
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "release aac decoder failed.");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "releaseAACDecoder, Error when releasing aac decode stream");
        }
        AppMethodBeat.o(13654);
        return -1;
    }
}
