package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder {
    private static final String TAG = "AudioDecoder";
    boolean IsTenFramesReady = false;
    int channels = 0;
    private boolean codeOver = true;
    private RingBuffer decRingBuffer = null;
    private MediaCodec.BufferInfo decodeBufferInfo = null;
    private ByteBuffer[] decodeInputBuffers = null;
    private ByteBuffer[] decodeOutputBuffers = null;
    private long fileTotalMs = 0;
    int m_nIndex = 0;
    private MediaCodec mediaDecode = null;
    private MediaExtractor mediaExtractor = null;
    int nFirstThreeFrameInfo = 3;
    int nFrameSize = 3840;
    private OnCompleteListener onCompleteListener = null;
    private OnProgressListener onProgressListener = null;
    int sampleRate = 0;
    private String srcPath;

    public interface OnCompleteListener {
        void completed();
    }

    public interface OnProgressListener {
        void progress();
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getChannels() {
        return this.channels;
    }

    public long getFileTotalMs() {
        return this.fileTotalMs;
    }

    public int getFrameSize() {
        return this.nFrameSize;
    }

    public void setIOPath(String str) {
        this.srcPath = str;
    }

    public void setIndex(int i2) {
        this.m_nIndex = i2;
    }

    public int prepare(int i2) {
        AppMethodBeat.i(13904);
        if (this.srcPath == null) {
            AppMethodBeat.o(13904);
            return -1;
        }
        int initMediaDecode = initMediaDecode(i2);
        AppMethodBeat.o(13904);
        return initMediaDecode;
    }

    private int initMediaDecode(int i2) {
        AppMethodBeat.i(13905);
        try {
            this.mediaExtractor = new MediaExtractor();
            this.mediaExtractor.setDataSource(this.srcPath);
            if (this.mediaExtractor.getTrackCount() > 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor container video, getTrackCount: " + this.mediaExtractor.getTrackCount());
                }
                this.codeOver = true;
                AppMethodBeat.o(13905);
                return -2;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.mediaExtractor.getTrackCount()) {
                    break;
                }
                MediaFormat trackFormat = this.mediaExtractor.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor audio type:" + string);
                }
                if (string.startsWith("audio/mpeg")) {
                    this.mediaExtractor.selectTrack(i3);
                    this.mediaDecode = MediaCodec.createDecoderByType(string);
                    this.mediaDecode.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                    this.sampleRate = trackFormat.getInteger("sample-rate");
                    this.channels = trackFormat.getInteger("channel-count");
                    this.fileTotalMs = trackFormat.getLong("durationUs") / 1000;
                    this.nFrameSize = (((this.sampleRate * this.channels) * 2) * 20) / 1000;
                    this.decRingBuffer = new RingBuffer(this.nFrameSize * i2);
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode open succeed, mp3 format:(" + this.sampleRate + "," + this.channels + "), fileTotalMs:" + this.fileTotalMs + "ms RingBufferFrame:" + i2);
                    }
                } else {
                    i3++;
                }
            }
            if (this.mediaDecode == null) {
                new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create mediaDecode failed");
                this.codeOver = true;
                AppMethodBeat.o(13905);
                return -1;
            } else if (this.decRingBuffer == null) {
                new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create decRingBuffer failed");
                this.codeOver = true;
                AppMethodBeat.o(13905);
                return -1;
            } else {
                this.mediaDecode.start();
                this.decodeInputBuffers = this.mediaDecode.getInputBuffers();
                this.decodeOutputBuffers = this.mediaDecode.getOutputBuffers();
                this.decodeBufferInfo = new MediaCodec.BufferInfo();
                this.codeOver = false;
                this.IsTenFramesReady = false;
                this.nFirstThreeFrameInfo = 3;
                AppMethodBeat.o(13905);
                return 0;
            }
        } catch (IOException e2) {
            TXCLog.e(TAG, "init media decode failed.", e2);
            this.codeOver = true;
            AppMethodBeat.o(13905);
            return -1;
        }
    }

    private void srcAudioFormatToPCM() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        AppMethodBeat.i(13906);
        if (this.decodeInputBuffers.length <= 1) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.length to small," + this.decodeInputBuffers.length);
            }
            this.codeOver = true;
            AppMethodBeat.o(13906);
            return;
        }
        int dequeueInputBuffer = this.mediaDecode.dequeueInputBuffer(-1);
        if (dequeueInputBuffer < 0) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.inputIndex <0");
            }
            this.codeOver = true;
            AppMethodBeat.o(13906);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            byteBuffer = this.mediaDecode.getInputBuffer(dequeueInputBuffer);
        } else {
            byteBuffer = this.decodeInputBuffers[dequeueInputBuffer];
        }
        byteBuffer.clear();
        int readSampleData = this.mediaExtractor.readSampleData(byteBuffer, 0);
        if (readSampleData < 0) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM readSampleData over,end");
            }
            this.codeOver = true;
        } else {
            this.mediaDecode.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, 0, 0);
            this.mediaExtractor.advance();
        }
        int dequeueOutputBuffer = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000);
        while (dequeueOutputBuffer >= 0) {
            if (i2 >= 21) {
                byteBuffer2 = this.mediaDecode.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer2 = this.decodeOutputBuffers[dequeueOutputBuffer];
            }
            byte[] bArr = new byte[this.decodeBufferInfo.size];
            try {
                byteBuffer2.get(bArr);
                byteBuffer2.clear();
                if (this.decRingBuffer != null && this.decodeBufferInfo.size > 0) {
                    this.decRingBuffer.Push(bArr, this.decodeBufferInfo.size);
                    int i3 = this.nFirstThreeFrameInfo;
                    this.nFirstThreeFrameInfo = i3 - 1;
                    if (i3 > 0 && QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " DecodeOneFrame size: " + this.decodeBufferInfo.size + " Remain: " + (this.decRingBuffer.RemainRead() / this.nFrameSize));
                    }
                }
                this.mediaDecode.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (this.decodeBufferInfo.size > 0) {
                    break;
                }
                dequeueOutputBuffer = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM wrong outputIndex: " + dequeueOutputBuffer);
                }
                this.codeOver = true;
                AppMethodBeat.o(13906);
                return;
            }
        }
        AppMethodBeat.o(13906);
    }

    public int SeekTo(int i2) {
        AppMethodBeat.i(13907);
        if (this.mediaExtractor != null) {
            long sampleTime = this.mediaExtractor.getSampleTime();
            int RemainRead = ((this.decRingBuffer.RemainRead() * 20) / this.nFrameSize) + i2;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " current PlayMs: " + (sampleTime / 1000) + " SeekTo: " + RemainRead);
            }
            this.mediaExtractor.seekTo((long) (RemainRead * 1000), 2);
            long sampleTime2 = this.mediaExtractor.getSampleTime();
            int i3 = (int) ((sampleTime2 - sampleTime) / 1000);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " total SeekTo time: " + i3 + " t2:" + (sampleTime2 / 1000));
            }
            AppMethodBeat.o(13907);
            return i3;
        }
        AppMethodBeat.o(13907);
        return 0;
    }

    public int ReadOneFrame(byte[] bArr, int i2) {
        int i3 = 20;
        AppMethodBeat.i(13908);
        if (!this.IsTenFramesReady) {
            int i4 = 20;
            while (this.decRingBuffer.RemainRead() / this.nFrameSize < 10) {
                int i5 = i4 - 1;
                if (i4 <= 0 || this.codeOver) {
                    break;
                }
                srcAudioFormatToPCM();
                i4 = i5;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " 10 FramesReady Remain frame: " + (this.decRingBuffer.RemainRead() / this.nFrameSize));
            }
            this.IsTenFramesReady = true;
        }
        while (!this.codeOver && this.decRingBuffer.RemainRead() / this.nFrameSize < 10) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            srcAudioFormatToPCM();
            i3 = i6;
        }
        if (this.decRingBuffer.RemainRead() >= i2) {
            this.decRingBuffer.Pop(bArr, i2);
        } else {
            i2 = -1;
        }
        AppMethodBeat.o(13908);
        return i2;
    }

    public void release() {
        AppMethodBeat.i(13909);
        if (this.mediaDecode != null) {
            this.mediaDecode.stop();
            this.mediaDecode.release();
            this.mediaDecode = null;
        }
        if (this.mediaExtractor != null) {
            this.mediaExtractor.release();
            this.mediaExtractor = null;
        }
        if (this.onCompleteListener != null) {
            this.onCompleteListener = null;
        }
        if (this.onProgressListener != null) {
            this.onProgressListener = null;
        }
        showLog("release");
        AppMethodBeat.o(13909);
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener2) {
        this.onCompleteListener = onCompleteListener2;
    }

    public void setOnProgressListener(OnProgressListener onProgressListener2) {
        this.onProgressListener = onProgressListener2;
    }

    private void showLog(String str) {
    }
}
