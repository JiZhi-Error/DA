package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder {
    private static final String TAG = "MediaCodecEncoder";
    private static boolean mDumpEnable = false;
    private MediaCodec.BufferInfo mAACEncBufferInfo;
    private MediaCodec mAudioAACEncoder;
    private MediaFormat mAudioFormat;
    private int mBitrate;
    private int mChannels;
    private Context mContext;
    private ByteBuffer mEncInBuffer;
    private ByteBuffer mEncOutBuffer;
    private boolean mFormatChangeFlag;
    private ByteBuffer mInputBuffer;
    private ByteBuffer[] mMediaInputBuffers;
    private ByteBuffer[] mMediaOutputBuffers;
    private ByteBuffer mOutputBuffer;
    private File mRecFileDump;
    private FileOutputStream mRecFileOut;
    private int mSampleRate;
    private byte[] mTempBufEncIn;
    private byte[] mTempBufEncOut;
    private int nMaxBitRate;

    public MediaCodecEncoder() {
        AppMethodBeat.i(13694);
        this.mAudioAACEncoder = null;
        this.mAudioFormat = null;
        this.mAACEncBufferInfo = null;
        this.mInputBuffer = null;
        this.mOutputBuffer = null;
        this.mSampleRate = 48000;
        this.mChannels = 1;
        this.mBitrate = 32000;
        this.nMaxBitRate = 256000;
        this.mFormatChangeFlag = false;
        this.mRecFileDump = null;
        this.mRecFileOut = null;
        this.mContext = TXCCommonUtil.getAppContext();
        this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
        this.mTempBufEncIn = new byte[7680];
        this.mEncOutBuffer = ByteBuffer.allocateDirect((((this.nMaxBitRate * 2) / 8) / 50) + 100);
        this.mTempBufEncOut = new byte[((((this.nMaxBitRate * 2) / 8) / 50) + 100)];
        AppMethodBeat.o(13694);
    }

    public MediaCodecEncoder(Context context) {
        AppMethodBeat.i(182239);
        this.mAudioAACEncoder = null;
        this.mAudioFormat = null;
        this.mAACEncBufferInfo = null;
        this.mInputBuffer = null;
        this.mOutputBuffer = null;
        this.mSampleRate = 48000;
        this.mChannels = 1;
        this.mBitrate = 32000;
        this.nMaxBitRate = 256000;
        this.mFormatChangeFlag = false;
        this.mRecFileDump = null;
        this.mRecFileOut = null;
        this.mContext = context;
        this.mEncInBuffer = ByteBuffer.allocateDirect(7680);
        this.mTempBufEncIn = new byte[7680];
        this.mEncOutBuffer = ByteBuffer.allocateDirect((((this.nMaxBitRate * 2) / 8) / 50) + 100);
        this.mTempBufEncOut = new byte[((((this.nMaxBitRate * 2) / 8) / 50) + 100)];
        AppMethodBeat.o(182239);
    }

    private String getDumpFilePath(String str) {
        AppMethodBeat.i(13695);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
        }
        if (this.mContext == null) {
            AppMethodBeat.o(13695);
            return null;
        }
        File externalFilesDir = this.mContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            AppMethodBeat.o(13695);
            return null;
        }
        String str2 = externalFilesDir.getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-" + str;
        File file = new File(str2);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump:".concat(String.valueOf(str2)));
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "dump replace:" + str2.replace(" ", "_"));
        }
        String replace = str2.replace(" ", "_");
        AppMethodBeat.o(13695);
        return replace;
    }

    private void addADTStoPacket(byte[] bArr, int i2) {
        int i3;
        if (this.mSampleRate == 48000) {
            i3 = 3;
        } else if (this.mSampleRate == 44100) {
            i3 = 4;
        } else if (this.mSampleRate == 32000) {
            i3 = 5;
        } else if (this.mSampleRate == 24000) {
            i3 = 6;
        } else {
            i3 = this.mSampleRate == 16000 ? 8 : 3;
        }
        int i4 = this.mChannels;
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) ((i3 << 2) + 64 + (i4 >> 2));
        bArr[3] = (byte) (((i4 & 3) << 6) + (i2 >> 11));
        bArr[4] = (byte) ((i2 & 2047) >> 3);
        bArr[5] = (byte) (((i2 & 7) << 5) + 31);
        bArr[6] = -4;
    }

    @SuppressLint({"NewApi"})
    public int createAACEncoder(int i2, int i3, int i4) {
        AppMethodBeat.i(13696);
        try {
            this.mAudioAACEncoder = MediaCodec.createEncoderByType(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            this.mAudioFormat = MediaFormat.createAudioFormat(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, i2, i3);
            this.mAudioFormat.setInteger("aac-profile", 2);
            this.mAudioFormat.setInteger("sample-rate", i2);
            this.mAudioFormat.setInteger("channel-count", i3);
            this.mAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, i4);
            this.mAudioAACEncoder.configure(this.mAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            if (this.mAudioAACEncoder != null) {
                this.mAudioAACEncoder.start();
                this.mAACEncBufferInfo = new MediaCodec.BufferInfo();
                this.mSampleRate = i2;
                this.mChannels = i3;
                this.mBitrate = i4;
            }
            if (mDumpEnable) {
                this.mRecFileDump = new File(getDumpFilePath("jnirecord.aac"));
                try {
                    this.mRecFileOut = new FileOutputStream(this.mRecFileDump);
                } catch (FileNotFoundException e2) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "open jnirecord.aac file failed.");
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "createAACEncoder succeed!!! : (" + i2 + ", " + i3 + ", " + i4 + ")");
            }
            AppMethodBeat.o(13696);
            return 0;
        } catch (Exception e3) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "create AAC Encoder failed.");
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "[ERROR] creating aac encode stream failed!!! : (" + i2 + ", " + i3 + ", " + i4 + ")");
            }
            AppMethodBeat.o(13696);
            return -1;
        }
    }

    @SuppressLint({"NewApi"})
    public int encodeAACFrame(int i2) {
        AppMethodBeat.i(13697);
        if (this.mFormatChangeFlag) {
            this.mFormatChangeFlag = false;
            this.mAudioAACEncoder.stop();
            this.mAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.mBitrate);
            this.mAudioAACEncoder.configure(this.mAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAudioAACEncoder.start();
        }
        this.mEncInBuffer.get(this.mTempBufEncIn, 0, i2);
        int encodeInternalAACFrame = encodeInternalAACFrame(i2);
        this.mEncOutBuffer.rewind();
        if (encodeInternalAACFrame > 0) {
            this.mEncOutBuffer.put(this.mTempBufEncOut, 0, encodeInternalAACFrame);
            if (mDumpEnable && this.mRecFileOut != null) {
                int i3 = encodeInternalAACFrame + 7;
                try {
                    byte[] bArr = new byte[i3];
                    addADTStoPacket(bArr, i3);
                    System.arraycopy(this.mTempBufEncOut, 0, bArr, 7, encodeInternalAACFrame);
                    this.mRecFileOut.write(bArr, 0, i3);
                } catch (IOException e2) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "write file failed.");
                    }
                }
            }
        } else {
            encodeInternalAACFrame = 0;
        }
        AppMethodBeat.o(13697);
        return encodeInternalAACFrame;
    }

    @SuppressLint({"NewApi"})
    public int encodeInternalAACFrame(int i2) {
        int i3;
        AppMethodBeat.i(13698);
        try {
            int dequeueInputBuffer = this.mAudioAACEncoder.dequeueInputBuffer(2000);
            if (dequeueInputBuffer != -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.mInputBuffer = this.mAudioAACEncoder.getInputBuffer(dequeueInputBuffer);
                } else {
                    this.mMediaInputBuffers = this.mAudioAACEncoder.getInputBuffers();
                    this.mInputBuffer = this.mMediaInputBuffers[dequeueInputBuffer];
                }
                this.mInputBuffer.clear();
                this.mInputBuffer.put(this.mTempBufEncIn, 0, i2);
                this.mAudioAACEncoder.queueInputBuffer(dequeueInputBuffer, 0, i2, 0, 0);
                this.mEncInBuffer.rewind();
            }
            int dequeueOutputBuffer = this.mAudioAACEncoder.dequeueOutputBuffer(this.mAACEncBufferInfo, 0);
            if (dequeueOutputBuffer < 0) {
                AppMethodBeat.o(13698);
                return 0;
            }
            int i4 = this.mAACEncBufferInfo.size;
            if (Build.VERSION.SDK_INT >= 21) {
                this.mOutputBuffer = this.mAudioAACEncoder.getOutputBuffer(dequeueOutputBuffer);
            } else {
                this.mMediaOutputBuffers = this.mAudioAACEncoder.getOutputBuffers();
                this.mOutputBuffer = this.mMediaOutputBuffers[dequeueOutputBuffer];
            }
            if ((this.mAACEncBufferInfo.flags & 2) == 2) {
                i3 = 0;
            } else {
                i3 = this.mAACEncBufferInfo.size;
            }
            try {
                this.mOutputBuffer.position(this.mAACEncBufferInfo.offset);
                this.mOutputBuffer.limit(i4 + this.mAACEncBufferInfo.offset);
                this.mOutputBuffer.get(this.mTempBufEncOut, 0, i3);
                this.mOutputBuffer.position(0);
                this.mAudioAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                AppMethodBeat.o(13698);
                return i3;
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "[ERROR] encoding aac stream failed!!!");
                }
                AppMethodBeat.o(13698);
                return i3;
            }
        } catch (Exception e3) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "encode failed." + e3.getMessage());
            }
            i3 = 0;
            AppMethodBeat.o(13698);
            return i3;
        }
    }

    @SuppressLint({"NewApi"})
    public int releaseAACEncoder() {
        AppMethodBeat.i(13699);
        try {
            if (this.mAudioAACEncoder != null) {
                this.mAudioAACEncoder.stop();
                this.mAudioAACEncoder.release();
                this.mAudioAACEncoder = null;
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "releaseAACEncoder, release aac encode stream succeed!!");
                }
                AppMethodBeat.o(13699);
                return 0;
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "release aac encoder failed." + e2.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "[ERROR] releaseAACEncoder, release aac encode stream failed!!!");
        }
        AppMethodBeat.o(13699);
        return -1;
    }

    @SuppressLint({"NewApi"})
    public int setAACEncodeBitrate(int i2) {
        AppMethodBeat.i(13700);
        if (!(this.mAudioAACEncoder == null || this.mBitrate == i2)) {
            this.mFormatChangeFlag = true;
            this.mBitrate = i2;
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Set AAC bitrate = ".concat(String.valueOf(i2)));
            }
        }
        AppMethodBeat.o(13700);
        return 0;
    }
}
