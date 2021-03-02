package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public class MediaCodecAssetWriterVideoEncoder implements AssetWriterVideoEncoder {
    private static final long WAIT_TRANSIENT_MS = 20;
    private final String TAG = ("MediaCodecAssetWriterVideoEncoder@" + hashCode());
    private ExportConfig encodeOption;
    private CGSize encodeSize;
    private Surface inputSurface;
    private boolean isEncodeToEndOfStream = false;
    private IMediaMuxer muxer;
    private int outHeight;
    private int outWidth;
    private volatile MediaCodec.BufferInfo videoBufferInfo = new MediaCodec.BufferInfo();
    private volatile MediaFormat videoEncodeFormat = null;
    private MediaCodec videoEncoder;
    private long videoPresentationTimeUs = 0;

    public MediaCodecAssetWriterVideoEncoder() {
        AppMethodBeat.i(218228);
        AppMethodBeat.o(218228);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public Surface createInputSurface() {
        AppMethodBeat.i(218229);
        if (this.videoEncoder != null && this.inputSurface == null) {
            Logger.i(this.TAG, "createInputSurface");
            this.inputSurface = this.videoEncoder.createInputSurface();
        }
        Surface surface = this.inputSurface;
        AppMethodBeat.o(218229);
        return surface;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean prepare(ExportConfig exportConfig, MediaFormat mediaFormat) {
        AppMethodBeat.i(218230);
        CGSize correctSupportSize = CodecHelper.correctSupportSize(exportConfig.getOutputSize(), "video/avc");
        this.outHeight = (int) correctSupportSize.height;
        this.outWidth = (int) correctSupportSize.width;
        this.encodeSize = new CGSize((float) this.outWidth, (float) this.outHeight);
        this.encodeOption = exportConfig;
        try {
            Logger.i(this.TAG, "prepareVideoEncoder: format = ".concat(String.valueOf(mediaFormat)));
            String str = "video/avc";
            if (mediaFormat.containsKey("mime")) {
                str = mediaFormat.getString("mime");
            }
            this.videoEncoder = MediaCodec.createEncoderByType(str);
            this.videoEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            AppMethodBeat.o(218230);
        } catch (Exception e2) {
            Logger.e(this.TAG, "prepareVideoEncoder: 失败，准备重试。format = ".concat(String.valueOf(mediaFormat)), e2);
            mediaFormat.setInteger(Scopes.PROFILE, 0);
            mediaFormat.setInteger("level", 0);
            try {
                this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
                this.videoEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                AppMethodBeat.o(218230);
            } catch (Exception e3) {
                Logger.e(this.TAG, "prepareVideoEncoder: retry 失败 format = ".concat(String.valueOf(mediaFormat)), e3);
                ExportRuntimeException exportRuntimeException = new ExportRuntimeException(new ExportErrorStatus(-103, e3, mediaFormat.toString()));
                AppMethodBeat.o(218230);
                throw exportRuntimeException;
            }
        }
        return true;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setMediaMuxer(IMediaMuxer iMediaMuxer) {
        this.muxer = iMediaMuxer;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void inputVideoTexture(TextureInfo textureInfo) {
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean start() {
        AppMethodBeat.i(218231);
        if (this.videoEncoder != null) {
            this.videoEncoder.start();
            AppMethodBeat.o(218231);
            return true;
        }
        AppMethodBeat.o(218231);
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void signalEndOfInputStream() {
        AppMethodBeat.i(218232);
        if (this.videoEncoder != null) {
            this.videoEncoder.signalEndOfInputStream();
        }
        AppMethodBeat.o(218232);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean writeVideoSample(CMSampleBuffer cMSampleBuffer, boolean z) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(218233);
        if (this.muxer != null) {
            z2 = this.muxer.isMuxerStarted();
        } else {
            z2 = false;
        }
        if (z2 || this.videoEncodeFormat == null) {
            int dequeueOutputBuffer = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    z3 = true;
                }
            } else if (dequeueOutputBuffer == -2) {
                this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = getOutputBuffer(this.videoEncoder, dequeueOutputBuffer);
                if ((this.videoBufferInfo.flags & 2) != 0 && this.muxer.ignoreHeader()) {
                    this.videoBufferInfo.size = 0;
                }
                if (z2 && validAndCorrectBufferInfo(this.videoBufferInfo)) {
                    try {
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.set(this.videoBufferInfo.offset, this.videoBufferInfo.size, this.videoBufferInfo.presentationTimeUs, this.videoBufferInfo.flags);
                        this.muxer.writeSampleData(this.muxer.videoTrackIndex(), outputBuffer, bufferInfo);
                        this.videoPresentationTimeUs = this.videoBufferInfo.presentationTimeUs;
                    } catch (Exception e2) {
                        Logger.e(this.TAG, "writeVideoFrame: ", e2);
                    }
                }
                releaseOutputBuffer(this.videoEncoder, dequeueOutputBuffer, false);
                if ((this.videoBufferInfo.flags & 4) != 0) {
                    Logger.i(this.TAG, "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
                    this.videoPresentationTimeUs = -1;
                    this.isEncodeToEndOfStream = true;
                    z3 = true;
                }
            }
        } else if (!z) {
            z3 = true;
        }
        AppMethodBeat.o(218233);
        return z3;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isEncodeToEndOfStream() {
        return this.isEncodeToEndOfStream;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public MediaFormat getEncodeFormat() {
        return this.videoEncodeFormat;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public boolean isNeedVideoOutputTexture() {
        return false;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void setVideoSampleRenderContext(RenderContext renderContext) {
    }

    private int dequeueOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(218234);
        while (true) {
            try {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 1000);
                AppMethodBeat.o(218234);
                return dequeueOutputBuffer;
            } catch (Exception e2) {
                Logger.e(this.TAG, "dequeueOutputBuffer e = ", e2);
                if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (23 <= Build.VERSION.SDK_INT) {
                    Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218234);
                throw e2;
            }
        }
        AppMethodBeat.o(218234);
        throw e2;
    }

    private void releaseOutputBuffer(MediaCodec mediaCodec, int i2, boolean z) {
        AppMethodBeat.i(218235);
        try {
            mediaCodec.releaseOutputBuffer(i2, z);
            AppMethodBeat.o(218235);
        } catch (Error | Exception e2) {
            Logger.e(this.TAG, "releaseOutputBuffer", e2);
            if (Build.VERSION.SDK_INT >= 21 && (e2 instanceof MediaCodec.CodecException)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (((MediaCodec.CodecException) e2).isTransient()) {
                    waitTime(WAIT_TRANSIENT_MS);
                    releaseOutputBuffer(mediaCodec, i2, z);
                }
            }
            AppMethodBeat.o(218235);
            throw e2;
        }
    }

    private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo bufferInfo) {
        return bufferInfo.size > 0 && (bufferInfo.flags & 4) == 0;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void stop() {
        AppMethodBeat.i(218236);
        if (this.videoEncoder != null) {
            this.videoEncoder.stop();
        }
        AppMethodBeat.o(218236);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public void release() {
        AppMethodBeat.i(218237);
        if (this.videoEncoder != null) {
            this.videoEncoder.release();
        }
        AppMethodBeat.o(218237);
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public long getEncodePresentationTimeUs() {
        return this.videoPresentationTimeUs;
    }

    @Override // com.tencent.tav.decoder.AssetWriterVideoEncoder
    public CGSize getEncodeSize() {
        return this.encodeSize;
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i2) {
        AppMethodBeat.i(218238);
        while (true) {
            try {
                ByteBuffer outputBuffer = DecoderUtils.getOutputBuffer(mediaCodec, i2);
                AppMethodBeat.o(218238);
                return outputBuffer;
            } catch (Error | Exception e2) {
                Logger.e(this.TAG, "getOutputBuffer", e2);
                if (Build.VERSION.SDK_INT < 21 || !(e2 instanceof MediaCodec.CodecException)) {
                    break;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException) e2).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException) e2).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException) e2).getErrorCode());
                }
                if (!((MediaCodec.CodecException) e2).isTransient()) {
                    break;
                }
                waitTime(WAIT_TRANSIENT_MS);
                AppMethodBeat.o(218238);
                throw e2;
            }
        }
        AppMethodBeat.o(218238);
        throw e2;
    }

    private void waitTime(long j2) {
        AppMethodBeat.i(218239);
        try {
            wait(j2);
            AppMethodBeat.o(218239);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(218239);
        }
    }
}
