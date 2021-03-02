package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.h;
import com.tencent.mm.media.i.j;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0002\u0001\b\u0016\u0018\u0000 ®\u00012\u00020\u00012\u00020\u0002:\u0002®\u0001B\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012%\b\u0002\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010\u001f\u0012%\u0010%\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020$\u0018\u00010\u001f¢\u0006\u0002\u0010'J\t\u0010\u0001\u001a\u00020$H\u0002J\t\u0010\u0001\u001a\u00020$H\u0002J\u001e\u0010\u0001\u001a\u00020$2\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020$0\u001fH\u0002J\u0012\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u0001\u001a\u00020$H\u0002J\u0012\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020\u0018H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\u001f\u0010¢\u0001\u001a\u00020$2\t\b\u0002\u0010£\u0001\u001a\u00020\u00182\t\b\u0002\u0010¤\u0001\u001a\u00020\u0018H\u0002J\t\u0010¥\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010¦\u0001\u001a\u00020$2\b\u0010§\u0001\u001a\u00030¡\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020$H\u0002J\u0012\u0010©\u0001\u001a\u00020$2\u0007\u0010ª\u0001\u001a\u000200H\u0016J\u001f\u0010«\u0001\u001a\u00020$2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u0001000\u001fH\u0016J\u001f\u0010¬\u0001\u001a\u00020$2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u0001000\u001fH\u0016J\t\u0010­\u0001\u001a\u00020$H\u0002R\u000e\u0010(\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR9\u0010%\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020$\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000e\u0010N\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010@\"\u0004\bP\u0010BR\u000e\u0010Q\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010T\"\u0004\bZ\u0010VR\u001a\u0010[\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010T\"\u0004\b]\u0010VR\u000e\u0010^\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010T\"\u0004\bh\u0010VR\u0010\u0010i\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010T\"\u0004\bk\u0010VR\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010T\"\u0004\bm\u0010VR\u001a\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010T\"\u0004\bo\u0010VR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010T\"\u0004\bq\u0010VR\u0014\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010GR\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010T\"\u0004\bt\u0010VR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010T\"\u0004\bv\u0010VR\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010T\"\u0004\bx\u0010VR7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010K\"\u0004\bz\u0010MR\u000e\u0010{\u001a\u00020|X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u000f\u0010\u0001\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010@\"\u0005\b\u0001\u0010BR\u000f\u0010\u0001\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010T\"\u0005\b\u0001\u0010VR\u0011\u0010\u0001\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010TR\u000f\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006¯\u0001"}, hxF = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "lastFrameDts", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "writeDtsCount", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f extends d implements c {
    private static final long iiK = 1000;
    private static final long iiL = 1000;
    public static final a iiM = new a((byte) 0);
    private final String TAG;
    private String filePath;
    private final int idY;
    private volatile boolean idb;
    private int idi;
    private int idq;
    private com.tencent.mm.media.f.a iei;
    private volatile boolean ifd;
    private com.tencent.mm.media.d.f ihG;
    protected int ihQ;
    protected int ihR;
    private int ihS;
    private com.tencent.mm.media.e.b ihT;
    private com.tencent.mm.media.e.h ihU;
    private com.tencent.mm.media.a.a ihV;
    private a ihW;
    private i ihX;
    private com.tencent.mm.media.f.a ihY;
    private com.tencent.mm.media.f.a ihZ;
    private kotlin.g.a.b<? super Long, Bitmap> ihf;
    private Bitmap ihg;
    private long iho;
    private int iiA;
    int iiB;
    protected boolean iiC;
    boolean iiD;
    private int iiE;
    private int iiF;
    private boolean iiG;
    private int iiH;
    kotlin.g.a.b<? super Float, x> iiI;
    private kotlin.g.a.b<? super String, x> iiJ;
    private HandlerThread iia;
    private HandlerThread iib;
    private boolean iic;
    private boolean iid;
    private g iie;
    private kotlin.g.a.b<? super Long, Bitmap> iif;
    private long iig;
    private final com.tencent.mm.media.k.a iih;
    private volatile boolean iii;
    private boolean iij;
    private boolean iik;
    private int iil;
    private int iim;
    private long iin;
    private int iio;
    private final int iip;
    private volatile boolean iiq;
    private volatile boolean iir;
    private long iis;
    private final n iit;
    private final Runnable iiu;
    private final String iiv;
    protected Rect iiw;
    private int iix;
    private int iiy;
    private int iiz;
    private final String outputFilePath;
    protected int outputHeight;
    protected int outputWidth;
    private long remuxEndTime;
    private int videoDuration;
    private int videoFps;
    protected final int videoHeight;
    protected final int videoWidth;

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ f iiN;
        final /* synthetic */ com.tencent.mm.media.j.c iiQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(f fVar, com.tencent.mm.media.j.c cVar) {
            super(1);
            this.iiN = fVar;
            this.iiQ = cVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
        static final class a extends q implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x> {
            final /* synthetic */ i iiR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(i iVar) {
                super(4);
                this.iiR = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.r
            public final /* synthetic */ x invoke(ByteBuffer byteBuffer, Long l, MediaCodec.BufferInfo bufferInfo, Boolean bool) {
                long j2;
                com.tencent.mm.media.d.f fVar;
                AppMethodBeat.i(184140);
                long longValue = l.longValue();
                boolean booleanValue = bool.booleanValue();
                p.h(bufferInfo, "<anonymous parameter 2>");
                this.iiR.iiN.iil++;
                if (!booleanValue && (fVar = this.iiR.iiN.ihG) != null) {
                    fVar.eU(true);
                }
                if (this.iiR.iiN.iho < 0) {
                    j2 = longValue;
                } else if (this.iiR.iiN.iil == 1) {
                    this.iiR.iiN.iho = longValue / 1000;
                    j2 = 0;
                } else {
                    j2 = longValue - (this.iiR.iiN.iho * 1000);
                }
                if (!this.iiR.iiN.iiC) {
                    if (this.iiR.iiN.iil == 1) {
                        this.iiR.iiN.ihX.zJ(-1 * ((long) Math.round(1000.0f / ((float) this.iiR.iiN.iiB))) * 1000);
                        this.iiR.iiN.iio++;
                    }
                    this.iiR.iiN.ihX.zJ(j2);
                    this.iiR.iiN.iio++;
                }
                Log.i(this.iiR.iiN.TAG, "onDecode, drawPts:" + j2 + ", pts:" + longValue + ", remuxStartTime:" + this.iiR.iiN.iho + ", lastFrameDts:" + this.iiR.iiN.iis);
                float f2 = (((float) j2) / 1000.0f) / ((float) (this.iiR.iiN.remuxEndTime - this.iiR.iiN.iho)) >= 0.9f ? 0.9f : (((float) j2) / 1000.0f) / ((float) (this.iiR.iiN.remuxEndTime - this.iiR.iiN.iho));
                kotlin.g.a.b<? super Float, x> bVar = this.iiR.iiN.iiI;
                if (bVar != null) {
                    bVar.invoke(Float.valueOf(f2));
                }
                if (this.iiR.iiN.iir) {
                    if (this.iiR.iiN.ihg != null) {
                        a aVar = this.iiR.iiN.ihW;
                        if (aVar != null) {
                            a.a(aVar, j2 * 1000, this.iiR.iiN.ihg);
                        }
                    } else {
                        a aVar2 = this.iiR.iiN.ihW;
                        if (aVar2 != null) {
                            long j3 = j2 * 1000;
                            kotlin.g.a.b bVar2 = this.iiR.iiN.ihf;
                            Bitmap bitmap = bVar2 != null ? (Bitmap) bVar2.invoke(Long.valueOf(j2)) : null;
                            kotlin.g.a.b bVar3 = this.iiR.iiN.iif;
                            aVar2.a(j3, bitmap, bVar3 != null ? (Bitmap) bVar3.invoke(Long.valueOf(j2)) : null);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184140);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            com.tencent.mm.media.d.f fVar;
            com.tencent.mm.media.d.i iVar;
            a aVar;
            c.b bVar;
            com.tencent.mm.media.e.h hVar;
            int i2;
            AppMethodBeat.i(93793);
            if (!bool.booleanValue()) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOB();
            }
            if (!(!this.iiN.iiC || (aVar = this.iiN.ihW) == null || (bVar = aVar.hDs) == null || (hVar = this.iiN.ihU) == null)) {
                com.tencent.mm.media.g.d aEE = this.iiQ.aEE();
                if (aEE != null) {
                    i2 = aEE.igv;
                } else {
                    i2 = 0;
                }
                int i3 = this.iiQ.hEp;
                int i4 = this.iiQ.hEq;
                p.h(bVar, "videoDataRenderEnvironment");
                Log.i("MicroMsg.X264TransImageReaderEncoder", "start");
                hVar.ifW = i2;
                hVar.ifQ = Util.currentTicks();
                hVar.ifN = hVar.videoWidth / 4;
                hVar.ifO = (hVar.videoHeight * 3) / 2;
                hVar.ifI = ImageReader.newInstance(hVar.ifN, hVar.ifO, 1, 1);
                ImageReader imageReader = hVar.ifI;
                if (imageReader != null) {
                    hVar.ifK.start();
                    hVar.ifJ = new Handler(hVar.ifK.getLooper());
                    imageReader.setOnImageAvailableListener(new h.e(hVar, bVar, i2, i3, i4), hVar.ifJ);
                    Handler handler = hVar.ifJ;
                    if (handler != null) {
                        handler.post(new h.f(imageReader, hVar, bVar, i2, i3, i4));
                    }
                }
                Log.i("MicroMsg.X264TransImageReaderEncoder", "initRgb2YuvImageReader, yuv size:[" + hVar.ifN + 'x' + hVar.ifO + ']');
            }
            final b bVar2 = new b(this);
            final a aVar2 = new a(this);
            a aVar3 = this.iiN.ihW;
            if (aVar3 != null) {
                aVar3.ihl = new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.media.i.f.i.AnonymousClass1 */
                    final /* synthetic */ i iiR;

                    {
                        this.iiR = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(218751);
                        Log.i(this.iiR.iiN.TAG, "onDrawFrameOnFrameAvailableFailed!! force use request draw");
                        this.iiR.iiN.iir = true;
                        com.tencent.mm.media.d.f fVar = this.iiR.iiN.ihG;
                        if (fVar != null) {
                            fVar.eU(false);
                        }
                        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOU();
                        a aVar = this.iiR.iiN.ihW;
                        if (aVar != null) {
                            aVar.ihl = null;
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(218751);
                        return xVar;
                    }
                };
            }
            final c cVar = new c(this);
            try {
                f fVar2 = this.iiN;
                if (com.tencent.mm.compatible.util.d.oD(23)) {
                    long j2 = this.iiN.iho;
                    long j3 = this.iiN.remuxEndTime;
                    com.tencent.mm.media.f.a aVar4 = this.iiN.iei;
                    a aVar5 = this.iiN.ihW;
                    if (aVar5 == null) {
                        p.hyc();
                    }
                    iVar = new com.tencent.mm.media.d.j(j2, j3, aVar4, aVar5.aME(), this.iiN.iiB, this.iiN.iiD, new kotlin.g.a.b<com.tencent.mm.media.d.f, x>(this) {
                        /* class com.tencent.mm.media.i.f.i.AnonymousClass2 */
                        final /* synthetic */ i iiR;

                        {
                            this.iiR = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(com.tencent.mm.media.d.f fVar) {
                            AppMethodBeat.i(93790);
                            com.tencent.mm.media.d.f fVar2 = fVar;
                            p.h(fVar2, "$receiver");
                            fVar2.ieo = aVar2;
                            fVar2.iep = bVar2;
                            fVar2.ier = cVar;
                            fVar2.iex = true;
                            fVar2.ieq = new kotlin.g.a.b<MediaFormat, x>(this) {
                                /* class com.tencent.mm.media.i.f.i.AnonymousClass2.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass2 iiV;

                                {
                                    this.iiV = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // kotlin.g.a.b
                                public final /* synthetic */ x invoke(MediaFormat mediaFormat) {
                                    AppMethodBeat.i(93789);
                                    MediaFormat mediaFormat2 = mediaFormat;
                                    p.h(mediaFormat2, "mediaFormat");
                                    Log.i(this.iiV.iiR.iiN.TAG, "onFormatChanged, format:".concat(String.valueOf(mediaFormat2)));
                                    a aVar = this.iiV.iiR.iiN.ihW;
                                    if (aVar != null) {
                                        aVar.e(mediaFormat2);
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(93789);
                                    return xVar;
                                }
                            };
                            x xVar = x.SXb;
                            AppMethodBeat.o(93790);
                            return xVar;
                        }
                    });
                } else {
                    long j4 = this.iiN.iho;
                    long j5 = this.iiN.remuxEndTime;
                    com.tencent.mm.media.f.a aVar6 = this.iiN.iei;
                    a aVar7 = this.iiN.ihW;
                    if (aVar7 == null) {
                        p.hyc();
                    }
                    iVar = new com.tencent.mm.media.d.i(j4, j5, aVar6, aVar7.aME(), this.iiN.iiB, this.iiN.iiD, new kotlin.g.a.b<com.tencent.mm.media.d.f, x>(this) {
                        /* class com.tencent.mm.media.i.f.i.AnonymousClass3 */
                        final /* synthetic */ i iiR;

                        {
                            this.iiR = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(com.tencent.mm.media.d.f fVar) {
                            AppMethodBeat.i(218753);
                            com.tencent.mm.media.d.f fVar2 = fVar;
                            p.h(fVar2, "$receiver");
                            fVar2.ieo = aVar2;
                            fVar2.iep = bVar2;
                            fVar2.ier = cVar;
                            fVar2.iex = true;
                            fVar2.ieq = new kotlin.g.a.b<MediaFormat, x>(this) {
                                /* class com.tencent.mm.media.i.f.i.AnonymousClass3.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass3 iiW;

                                {
                                    this.iiW = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // kotlin.g.a.b
                                public final /* synthetic */ x invoke(MediaFormat mediaFormat) {
                                    AppMethodBeat.i(218752);
                                    MediaFormat mediaFormat2 = mediaFormat;
                                    p.h(mediaFormat2, "mediaFormat");
                                    Log.i(this.iiW.iiR.iiN.TAG, "onFormatChanged, format:".concat(String.valueOf(mediaFormat2)));
                                    a aVar = this.iiW.iiR.iiN.ihW;
                                    if (aVar != null) {
                                        aVar.e(mediaFormat2);
                                    }
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(218752);
                                    return xVar;
                                }
                            };
                            x xVar = x.SXb;
                            AppMethodBeat.o(218753);
                            return xVar;
                        }
                    });
                }
                fVar2.ihG = iVar;
            } catch (Exception e2) {
                Log.printErrStackTrace(this.iiN.TAG, e2, "init decoder error", new Object[0]);
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOA();
                f.a(this.iiN, true, false);
            }
            int i5 = this.iiN.videoFps - 1;
            int i6 = this.iiN.iiB;
            if (1 <= i6 && i5 >= i6 && (fVar = this.iiN.ihG) != null) {
                int ceil = (int) Math.ceil((double) (((float) this.iiN.videoFps) / ((float) this.iiN.iiB)));
                Log.i(fVar.TAG, "setFrameDropInterval: ".concat(String.valueOf(ceil)));
                fVar.ies = ceil;
                if (fVar.ies > 1) {
                    com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aOQ();
                }
            }
            this.iiN.iic = true;
            if (this.iiN.iid) {
                this.iiN.aMG();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93793);
            return xVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ i iiR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(i iVar) {
                super(0);
                this.iiR = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                com.tencent.mm.media.e.h hVar;
                AppMethodBeat.i(93792);
                Log.i(this.iiR.iiN.TAG, "onDecodeEnd, encodeFrameCount:" + this.iiR.iiN.idi + ", drawFrameCount:" + this.iiR.iiN.iim);
                this.iiR.iiN.idb = true;
                if (this.iiR.iiN.iiC && (hVar = this.iiR.iiN.ihU) != null) {
                    hVar.stop();
                }
                f.h(this.iiR.iiN);
                x xVar = x.SXb;
                AppMethodBeat.o(93792);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ i iiR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(i iVar) {
                super(0);
                this.iiR = iVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(218754);
                Log.e(this.iiR.iiN.TAG, "onDecodeError");
                f.a(this.iiR.iiN, true, false);
                x xVar = x.SXb;
                AppMethodBeat.o(218754);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    /* renamed from: com.tencent.mm.media.i.f$f  reason: collision with other inner class name */
    public static final class C0420f extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0420f(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(93783);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOk();
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(93783);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<com.tencent.mm.media.e.b, x> {
        final /* synthetic */ kotlin.g.a.m iiO;
        final /* synthetic */ kotlin.g.a.a iiP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(kotlin.g.a.m mVar, kotlin.g.a.a aVar) {
            super(1);
            this.iiO = mVar;
            this.iiP = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.e.b bVar) {
            AppMethodBeat.i(93784);
            com.tencent.mm.media.e.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOk();
            bVar2.ifb = this.iiO;
            bVar2.ifc = this.iiP;
            bVar2.iex = true;
            x xVar = x.SXb;
            AppMethodBeat.o(93784);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class h extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(f fVar) {
            super(1);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Type inference failed for r0v44. Raw type applied. Possible types: com.tencent.f.e.f<R>, com.tencent.f.e.f<?> */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            int i2;
            long j2;
            kotlin.g.a.a<x> aVar;
            AppMethodBeat.i(93785);
            if (!bool.booleanValue()) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOC();
            }
            this.iiN.iim++;
            this.iiN.iiq = true;
            Log.i(this.iiN.TAG, "onFrameDraw, drawFrameCount:" + this.iiN.iim + ", encodeFrameCount:" + this.iiN.idi + ", isDecodeEnd:" + this.iiN.idb);
            g gVar = this.iiN.iie;
            if (!(gVar == null || (aVar = gVar.ijf) == null)) {
                aVar.invoke();
            }
            if (this.iiN.iiC) {
                GLES20.glFinish();
                com.tencent.mm.media.e.h hVar = this.iiN.ihU;
                if (hVar != null) {
                    a aVar2 = this.iiN.ihW;
                    if (aVar2 != null) {
                        j2 = aVar2.ihp;
                    } else {
                        j2 = 0;
                    }
                    Handler handler = hVar.ifJ;
                    if (handler != null) {
                        handler.post(new h.d(hVar, j2));
                    }
                    if (hVar.ifx == null) {
                        Log.i("MicroMsg.X264TransImageReaderEncoder", "do start encode loop");
                        hVar.ifx = (com.tencent.f.e.f<R>) com.tencent.f.e.f.hmn().hms().c(new h.b(hVar));
                        com.tencent.f.e.f<?> fVar = hVar.ifx;
                        if (fVar != null) {
                            fVar.begin();
                        }
                    }
                }
                com.tencent.mm.media.e.h hVar2 = this.iiN.ihU;
                if (hVar2 != null) {
                    synchronized (hVar2.ifS) {
                        try {
                            hVar2.ifS.wait(500);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e2, "wait writeYuvRenderWaitLock error", new Object[0]);
                        }
                        try {
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(93785);
                        }
                    }
                    if (!hVar2.ifP && hVar2.ifV - hVar2.ifA >= 10) {
                        Log.i("MicroMsg.X264TransImageReaderEncoder", "writeYuvCount:" + hVar2.ifV + ", curEncodeIndex:" + hVar2.ifA + ", need to wait encode");
                        synchronized (hVar2.ifT) {
                            try {
                                hVar2.ifT.wait(500);
                            } catch (Exception e3) {
                                Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", e3, "", new Object[0]);
                            }
                            try {
                                x xVar2 = x.SXb;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
                f fVar2 = this.iiN;
                com.tencent.mm.media.e.h hVar3 = this.iiN.ihU;
                if (hVar3 != null) {
                    i2 = hVar3.ifV;
                } else {
                    i2 = 0;
                }
                fVar2.idi = i2;
                f.h(this.iiN);
            } else {
                com.tencent.mm.media.e.b bVar = this.iiN.ihT;
                if (bVar != null) {
                    bVar.aMl();
                }
            }
            com.tencent.mm.media.d.f fVar3 = this.iiN.ihG;
            if (fVar3 != null) {
                fVar3.eU(false);
            }
            x xVar3 = x.SXb;
            AppMethodBeat.o(93785);
            return xVar3;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
    public static final class j extends q implements kotlin.g.a.m<ByteBuffer, MediaCodec.BufferInfo, x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(f fVar) {
            super(2);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            kotlin.g.a.m<? super ByteBuffer, ? super MediaCodec.BufferInfo, x> mVar;
            AppMethodBeat.i(93794);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            p.h(byteBuffer2, "byteBuffer");
            p.h(bufferInfo2, "bufferInfo");
            Log.i(this.iiN.TAG, "onEncode: " + this.iiN.idi + ", isDecodeEnd:" + this.iiN.idb + ", drawFrameCount:" + this.iiN.iim + ", decodeFrameCount:" + this.iiN.iil + ", " + bufferInfo2.presentationTimeUs);
            this.iiN.idi++;
            g gVar = this.iiN.iie;
            if (((gVar == null || (mVar = gVar.ijc) == null) ? null : mVar.invoke(byteBuffer2, bufferInfo2)) == null) {
                p.hyc();
            }
            f.h(this.iiN);
            if (this.iiN.iin != 0) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.zT(System.currentTimeMillis() - this.iiN.iin);
            }
            this.iiN.iin = System.currentTimeMillis();
            this.iiN.iit.cancel();
            com.tencent.f.h.RTc.o(this.iiN.iit, (long) this.iiN.iip);
            x xVar = x.SXb;
            AppMethodBeat.o(93794);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
    public static final class l extends q implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(f fVar) {
            super(3);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
            kotlin.g.a.q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> qVar;
            AppMethodBeat.i(93796);
            ByteBuffer byteBuffer2 = byteBuffer;
            MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
            MediaFormat mediaFormat2 = mediaFormat;
            p.h(byteBuffer2, "buffer");
            p.h(bufferInfo2, "bufferInfo");
            p.h(mediaFormat2, "format");
            g gVar = this.iiN.iie;
            if (!(gVar == null || (qVar = gVar.ijd) == null)) {
                qVar.d(byteBuffer2, bufferInfo2, mediaFormat2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(93796);
            return xVar;
        }
    }

    public static final /* synthetic */ void L(f fVar) {
        AppMethodBeat.i(93816);
        fVar.aMi();
        AppMethodBeat.o(93816);
    }

    public static final /* synthetic */ void a(f fVar, boolean z) {
        AppMethodBeat.i(93811);
        fVar.eX(z);
        AppMethodBeat.o(93811);
    }

    public static final /* synthetic */ void a(f fVar, boolean z, boolean z2) {
        AppMethodBeat.i(177317);
        fVar.l(z, z2);
        AppMethodBeat.o(177317);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ f(java.lang.String r31, java.lang.String r32, int r33, java.lang.String r34, int r35, int r36, int r37, int r38, int r39, int r40, int r41, int r42, int r43, long r44, long r46, boolean r48, boolean r49, int r50, int r51, boolean r52, int r53, kotlin.g.a.b r54, int r55) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.i.f.<init>(java.lang.String, java.lang.String, int, java.lang.String, int, int, int, int, int, int, int, int, int, long, long, boolean, boolean, int, int, boolean, int, kotlin.g.a.b, int):void");
    }

    public f(String str, String str2, int i2, String str3, Rect rect, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j2, long j3, boolean z, boolean z2, int i12, int i13, boolean z3, int i14, kotlin.g.a.b<? super Float, x> bVar, kotlin.g.a.b<? super String, x> bVar2) {
        i iVar;
        boolean z4;
        int i15;
        p.h(str2, "filePath");
        p.h(str3, "outputFilePath");
        AppMethodBeat.i(218755);
        this.iiv = str;
        this.filePath = str2;
        this.idq = i2;
        this.outputFilePath = str3;
        this.iiw = rect;
        this.videoWidth = i3;
        this.videoHeight = i4;
        this.outputWidth = i5;
        this.outputHeight = i6;
        this.iix = i7;
        this.iiy = i8;
        this.iiz = i9;
        this.iiA = i10;
        this.iiB = i11;
        this.iiC = z;
        this.iiD = z2;
        this.iiE = i12;
        this.iiF = i13;
        this.iiG = z3;
        this.iiH = i14;
        this.iiI = bVar;
        this.iiJ = bVar2;
        this.TAG = "MicroMsg.MediaCodecRemuxer";
        this.videoDuration = -1;
        this.iho = j2;
        this.remuxEndTime = -1;
        this.iih = new com.tencent.mm.media.k.a("remuxCost");
        this.idY = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_vfr_threshold, 10);
        this.iip = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mediacodec_frame_timeout, 10000);
        this.iis = Long.MIN_VALUE;
        this.iit = new n(this);
        if (Util.isNullOrNil(this.filePath) || !s.YS(this.filePath) || Util.isNullOrNil(this.outputFilePath) || this.outputWidth <= 0 || this.outputHeight <= 0) {
            Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.iiB);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOv();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.o(218755);
            throw illegalArgumentException;
        }
        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.rn(this.idq);
        if (com.tencent.mm.bk.e.QW(this.filePath)) {
            Log.i(this.TAG, "remux h265 format");
            com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOu();
        }
        s.boN(s.boZ(this.outputFilePath));
        this.ihS = SightVideoJNI.getMp4RotateVFS(this.filePath);
        if (this.iiG && (this.ihS == 90 || this.ihS == 270)) {
            int i16 = this.outputWidth;
            this.outputWidth = this.outputHeight;
            this.outputHeight = i16;
        }
        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(this.filePath);
        if (aNx != null) {
            this.ihQ = aNx.width;
            this.ihR = aNx.height;
            this.videoFps = aNx.frameRate;
            this.videoDuration = aNx.videoDuration;
        }
        if (this.ihQ <= 0 || this.ihR <= 0) {
            try {
                com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                dVar.setDataSource(this.filePath);
                this.ihQ = Util.getInt(dVar.extractMetadata(18), 0);
                this.ihR = Util.getInt(dVar.extractMetadata(19), 0);
                dVar.release();
            } catch (Exception e2) {
            }
        }
        if (this.videoFps <= 0) {
            Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
            com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOv();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("create MediaCodecRemuxer error");
            AppMethodBeat.o(218755);
            throw illegalArgumentException2;
        }
        if (j3 == 0) {
            this.remuxEndTime = (long) this.videoDuration;
        } else {
            this.remuxEndTime = j3;
        }
        Log.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.iip);
        if (this.iiC) {
            iVar = new i(this.iho, this.remuxEndTime, this.iix, this.outputWidth, this.outputHeight, this.iiC, (float) this.iiB, this.iiD);
        } else {
            iVar = new i(this.iho, this.remuxEndTime, this.iix, this.iiC);
        }
        this.ihX = iVar;
        if (this.iiA <= 0) {
            this.iiA = 1;
        }
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.ihQ + ", inputHeight: " + this.ihR + ", videoRotate: " + this.ihS + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.iix + ", outputAudioBitrate:" + this.iiy + ", outputAudioChannelCount:" + this.iiA + ", outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + j2 + ", endTimeMs: " + j3 + " , outputFps: " + this.iiB + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.iho + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + aNx.videoBitrate + ", enableHevc:" + this.iiD, new Object[0]);
        this.iei = new com.tencent.mm.media.f.a(this.filePath);
        if (this.iei.igl) {
            com.tencent.mm.media.k.e eVar5 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOw();
        }
        int i17 = this.outputWidth - this.ihQ;
        if ((1 > i17 || 16 <= i17) && (1 > (i15 = this.outputHeight - this.ihR) || 16 <= i15)) {
            z4 = false;
        } else {
            z4 = true;
        }
        Log.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(z4)));
        Log.i(this.TAG, "startRemux, useSoftEncode:" + this.iiC + ", enablHevc:" + this.iiD);
        if (this.iiD) {
            if (this.iiC) {
                com.tencent.mm.media.k.e eVar6 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOY();
            } else {
                com.tencent.mm.media.k.e eVar7 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOZ();
            }
        }
        if (this.iiC) {
            com.tencent.mm.media.k.e eVar8 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOX();
        }
        a(aMH());
        this.iiu = new c(this);
        AppMethodBeat.o(218755);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
    public static final class n extends com.tencent.f.i.b {
        final /* synthetic */ f iiN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(f fVar) {
            this.iiN = fVar;
        }

        public final void run() {
            AppMethodBeat.i(177315);
            Log.e(this.iiN.TAG, "remux error! handing one frame time out ,isInvokeEndCallback:" + this.iiN.iii);
            if (!this.iiN.iii) {
                f.a(this.iiN, !this.iiN.idb, true);
            }
            AppMethodBeat.o(177315);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MediaCodecRemuxer#timeoutInvoke";
        }
    }

    public com.tencent.mm.media.j.c aMH() {
        int i2 = 1;
        AppMethodBeat.i(164113);
        if (this.ihS == 90 || this.ihS == 270) {
            if (this.ihR > this.ihQ) {
                Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
            } else {
                Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
                i2 = 2;
            }
        } else if (this.ihQ > this.ihR) {
            Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
        } else {
            Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
            i2 = 2;
        }
        if (this.iiC) {
            com.tencent.mm.media.j.c cVar = new com.tencent.mm.media.j.c(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, 2, i2);
            AppMethodBeat.o(164113);
            return cVar;
        }
        com.tencent.mm.media.j.c cVar2 = new com.tencent.mm.media.j.c(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, i2);
        AppMethodBeat.o(164113);
        return cVar2;
    }

    @Override // com.tencent.mm.media.i.d
    public final void D(Bitmap bitmap) {
        AppMethodBeat.i(93801);
        p.h(bitmap, "bitmap");
        this.ihg = bitmap;
        a aVar = this.ihW;
        if (aVar != null) {
            Log.i(aVar.TAG, "setDrawBlendBitmap:" + (bitmap != null ? bitmap.hashCode() : 0));
            aVar.ihg = bitmap;
            AppMethodBeat.o(93801);
            return;
        }
        AppMethodBeat.o(93801);
    }

    @Override // com.tencent.mm.media.i.c
    public final void k(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(93802);
        p.h(bVar, "blendBitmapProvider");
        this.ihf = bVar;
        a aVar = this.ihW;
        if (aVar != null) {
            aVar.i(bVar);
            AppMethodBeat.o(93802);
            return;
        }
        AppMethodBeat.o(93802);
    }

    @Override // com.tencent.mm.media.i.d, com.tencent.mm.media.i.c
    public final int aMG() {
        AppMethodBeat.i(93803);
        Log.i(this.TAG, "start remux, initFinish:" + this.iic);
        this.iig = Util.currentTicks();
        if (this.ihg != null && this.ihS > 0) {
            this.ihg = BitmapUtil.rotate(this.ihg, -((float) this.ihS));
        }
        this.iih.hvh.reset();
        if (this.iic) {
            HandlerThread handlerThread = this.iia;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.iia = com.tencent.mm.ac.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a) new d(this));
            HandlerThread handlerThread2 = this.iib;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            if (this.ihG != null) {
                this.iib = com.tencent.mm.ac.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a) new e(this));
            }
        } else {
            this.iid = true;
        }
        AppMethodBeat.o(93803);
        return 0;
    }

    @Override // com.tencent.mm.media.i.c
    public final void l(kotlin.g.a.b<? super Long, Bitmap> bVar) {
        AppMethodBeat.i(93804);
        p.h(bVar, "blurBgProvider");
        this.iif = bVar;
        a aVar = this.ihW;
        if (aVar != null) {
            aVar.j(bVar);
            AppMethodBeat.o(93804);
            return;
        }
        AppMethodBeat.o(93804);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ f iiN;

        b(f fVar) {
            this.iiN = fVar;
        }

        public final void run() {
            AppMethodBeat.i(93779);
            Log.i(this.iiN.TAG, "delay check frameDraw: " + this.iiN.iiq);
            if (!this.iiN.iiq) {
                Log.e(this.iiN.TAG, "after " + f.iiK + " ms, first frame stil not draw!!!");
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOT();
            }
            AppMethodBeat.o(93779);
        }
    }

    private final void aMi() {
        AppMethodBeat.i(93805);
        Log.i(this.TAG, "finishEncode");
        if (this.iiC) {
            com.tencent.mm.media.e.h hVar = this.ihU;
            if (hVar != null) {
                hVar.stop();
            }
            eX(true);
        } else {
            com.tencent.mm.media.e.b bVar = this.ihT;
            if (bVar != null) {
                bVar.aMi();
            }
        }
        MMHandlerThread.removeRunnable(this.iiu);
        this.ifd = true;
        AppMethodBeat.o(93805);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ f iiN;

        c(f fVar) {
            this.iiN = fVar;
        }

        public final void run() {
            AppMethodBeat.i(93780);
            Log.i(this.iiN.TAG, "decode end after " + f.iiL + ", isFinishEncode:" + this.iiN.ifd);
            if (!this.iiN.ifd) {
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOW();
                f.L(this.iiN);
            }
            AppMethodBeat.o(93780);
        }
    }

    private final synchronized void eX(boolean z) {
        kotlin.g.a.b<? super kotlin.g.a.b<? super String, x>, x> bVar;
        AppMethodBeat.i(93806);
        Log.i(this.TAG, "finishRemux, isVideo: " + z + ", isAudioRemuxFinish:" + this.iik + ", isVideoRemuxFinish:" + this.iij + ", isInvokeEndCallback:" + this.iii);
        if (z) {
            this.iij = true;
        } else {
            this.iik = true;
        }
        if (this.iik && this.iij && !this.iii) {
            a aVar = this.ihW;
            if (aVar != null) {
                aVar.release();
            }
            this.iih.aBw();
            this.iii = true;
            try {
                j.a aVar2 = j.ijn;
                s.deleteFile(j.a.Ho(this.filePath));
                j.a aVar3 = j.ijn;
                s.deleteFile(j.a.Hp(this.filePath));
            } catch (Exception e2) {
            }
            this.iit.cancel();
            this.iei.release();
            com.tencent.mm.media.f.a aVar4 = this.ihZ;
            if (aVar4 != null) {
                aVar4.release();
            }
            g gVar = this.iie;
            if (!(gVar == null || (bVar = gVar.ije) == null)) {
                bVar.invoke(this.iiJ);
            }
            HandlerThread handlerThread = this.iia;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            HandlerThread handlerThread2 = this.iib;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            long ticksToNow = Util.ticksToNow(this.iig);
            Log.i(this.TAG, "remux used " + ticksToNow + " decodeFrame:" + this.iil + ", encodeFrame:" + this.idi + ", drawFrameCount:" + this.iim + ", writeDtsCount:" + this.iio);
            try {
                com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(this.outputFilePath);
                if (aNx != null) {
                    com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.y(this.idq, ticksToNow);
                    com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.f((long) aNx.videoBitrate, (long) aNx.frameRate, (long) this.videoFps);
                    if (((double) (((float) this.iil) / ((float) this.idi))) >= 1.5d) {
                        com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aOI();
                    }
                    com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.Hs(this.outputFilePath);
                    AppMethodBeat.o(93806);
                }
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(93806);
    }

    private final synchronized void l(boolean z, boolean z2) {
        AppMethodBeat.i(177316);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + z + " isEncoder:" + z2);
        this.iit.cancel();
        if (z) {
            com.tencent.mm.media.d.f fVar = this.ihG;
            if (fVar != null) {
                fVar.releaseDecoder();
            }
            this.ihG = null;
        }
        if (z2) {
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOl();
            com.tencent.mm.media.e.b bVar = this.ihT;
            if (bVar != null) {
                bVar.aMj();
            }
            this.ihT = null;
        }
        if (!this.iii) {
            a aVar = this.ihW;
            if (aVar != null) {
                aVar.release();
            }
            this.iih.aBw();
            this.iii = true;
            try {
                j.a aVar2 = j.ijn;
                s.deleteFile(j.a.Ho(this.filePath));
                j.a aVar3 = j.ijn;
                s.deleteFile(j.a.Hp(this.filePath));
                this.iei.release();
                com.tencent.mm.media.f.a aVar4 = this.ihZ;
                if (aVar4 != null) {
                    aVar4.release();
                }
                HandlerThread handlerThread = this.iia;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                HandlerThread handlerThread2 = this.iib;
                if (handlerThread2 != null) {
                    handlerThread2.quit();
                }
                s.deleteFile(this.outputFilePath);
                Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(Util.ticksToNow(this.iig))));
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "onDecoderEncoderFailed error:" + e2.getMessage(), new Object[0]);
            }
            kotlin.g.a.b<? super String, x> bVar2 = this.iiJ;
            if (bVar2 != null) {
                bVar2.invoke(null);
                AppMethodBeat.o(177316);
            }
        }
        AppMethodBeat.o(177316);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$Companion;", "", "()V", "CHECK_FRAME_DRWA_TIMEOUT", "", "DECODE_END_FINISH_ENCODE_CHECK_TIMEOUT", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(93809);
        AppMethodBeat.o(93809);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(f fVar) {
            super(0);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93795);
            Log.i(this.iiN.TAG, "onEncodeEnd: " + this.iiN.idi);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOl();
            com.tencent.mm.media.e.b bVar = this.iiN.ihT;
            if (bVar != null) {
                bVar.aMj();
            }
            f.a(this.iiN, true);
            x xVar = x.SXb;
            AppMethodBeat.o(93795);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f iiN;
        final /* synthetic */ long iiX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(f fVar, long j2) {
            super(0);
            this.iiN = fVar;
            this.iiX = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93797);
            com.tencent.mm.media.a.a aVar = this.iiN.ihV;
            if (aVar != null) {
                aVar.aLO();
            }
            Log.i(this.iiN.TAG, "mix audio used " + Util.ticksToNow(this.iiX));
            com.tencent.mm.media.f.a aVar2 = this.iiN.ihY;
            if (aVar2 != null) {
                aVar2.release();
            }
            f.a(this.iiN, false);
            x xVar = x.SXb;
            AppMethodBeat.o(93797);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar) {
            super(0);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93781);
            f.H(this.iiN);
            x xVar = x.SXb;
            AppMethodBeat.o(93781);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f iiN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar) {
            super(0);
            this.iiN = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93782);
            com.tencent.mm.media.d.f fVar = this.iiN.ihG;
            if (fVar != null) {
                fVar.startDecode();
            }
            f.I(this.iiN);
            x xVar = x.SXb;
            AppMethodBeat.o(93782);
            return xVar;
        }
    }

    private final void a(com.tencent.mm.media.j.c cVar) {
        com.tencent.mm.media.e.b eVar;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        com.tencent.mm.media.e.b bVar;
        boolean z3;
        a aVar;
        a aVar2;
        AppMethodBeat.i(93799);
        String str = this.filePath;
        j.a aVar3 = j.ijn;
        String Hp = j.a.Hp(str);
        if (str == null) {
            Log.e(this.TAG, "copyVideoFile invalid parameters, can not be null");
        } else {
            if (s.YS(Hp)) {
                s.deleteFile(Hp);
            }
            Log.i(this.TAG, "copyVideoFile from %s, to %s", str, Hp);
            long currentTicks = Util.currentTicks();
            long nw = s.nw(str, Hp);
            Log.i(this.TAG, "copy video file cost " + Util.ticksToNow(currentTicks));
            if (nw <= 0) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOx();
            }
        }
        j.a aVar4 = j.ijn;
        this.ihZ = new com.tencent.mm.media.f.a(j.a.Hp(this.filePath));
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("cpVideoFile:");
        j.a aVar5 = j.ijn;
        StringBuilder append = sb.append(j.a.Hp(this.filePath)).append(", audioCpFile:");
        j.a aVar6 = j.ijn;
        Log.i(str2, append.append(j.a.Ho(this.filePath)).toString());
        com.tencent.mm.media.f.a aVar7 = this.ihZ;
        if (aVar7 != null) {
            this.iie = new g(this.ihX, aVar7, this.outputFilePath, this.idq, this.iiz);
            if (s.YS(this.iiv)) {
                String str3 = this.iiv;
                if (str3 == null) {
                    p.hyc();
                }
                com.tencent.mm.media.f.a aVar8 = new com.tencent.mm.media.f.a(str3);
                if (aVar8.igl) {
                    com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aOy();
                }
                this.ihY = aVar8;
            }
        }
        g gVar = this.iie;
        if (gVar != null) {
            gVar.ihS = this.ihS;
        }
        try {
            com.tencent.mm.media.b.d aMI = aMI();
            j jVar = new j(this);
            k kVar = new k(this);
            try {
                if (this.iiC) {
                    this.ihU = new com.tencent.mm.media.e.h(this.ihX.bufId, aMI.targetWidth, aMI.targetHeight);
                } else {
                    if (com.tencent.mm.compatible.util.d.oD(23)) {
                        eVar = new com.tencent.mm.media.e.f(aMI, new C0420f(jVar, kVar));
                    } else {
                        eVar = new com.tencent.mm.media.e.e(aMI, new g(jVar, kVar));
                    }
                    this.ihT = eVar;
                }
                this.ihW = new a(cVar);
                a aVar9 = this.ihW;
                if (aVar9 != null) {
                    aVar9.ihm = 1000000000 / this.videoFps;
                    Log.i(aVar9.TAG, "videoFps : " + aVar9.ihm);
                }
                if (!(this.ihf == null || (aVar2 = this.ihW) == null)) {
                    aVar2.i(this.ihf);
                }
                if (!(this.iif == null || (aVar = this.ihW) == null)) {
                    aVar.j(this.iif);
                }
                a aVar10 = this.ihW;
                if (aVar10 != null) {
                    aVar10.ihb = new h(this);
                }
                this.iir = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_remuxer_with_surface_timestamp, 0) == 0;
                if (WeChatEnvironment.hasDebugger()) {
                    Log.i(this.TAG, "in debug environment, set useRequestDraw to false");
                    this.iir = false;
                }
                double[] dArr = {0.0d, 0.0d, 0.0d};
                com.tencent.mm.media.k.b.a(this.filePath, dArr, this.idY);
                int i4 = 0;
                while (true) {
                    if (i4 >= 3) {
                        z = true;
                        break;
                    }
                    if (dArr[i4] > 0.0d) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        z = false;
                        break;
                    }
                    i4++;
                }
                if (z && dArr[1] - dArr[0] >= ((double) this.idY)) {
                    Log.i(this.TAG, "min fps = " + dArr[0] + ", max fps = " + dArr[1] + ", vfr threshold = " + this.idY + " diff too much, set useRequestDraw to true");
                    this.iir = true;
                }
                Surface inputSurface = (this.ihT == null || (bVar = this.ihT) == null) ? null : bVar.getInputSurface();
                a aVar11 = this.ihW;
                if (aVar11 != null) {
                    if (!this.iir) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.iiC) {
                        i2 = this.outputWidth;
                    } else {
                        i2 = 0;
                    }
                    if (this.iiC) {
                        i3 = this.outputHeight;
                    } else {
                        i3 = 0;
                    }
                    aVar11.a(inputSurface, z2, i2, i3, this.iho, new i(this, cVar));
                    AppMethodBeat.o(93799);
                    return;
                }
                AppMethodBeat.o(93799);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "create encoder error", new Object[0]);
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOz();
                MultiProcessMMKV.getSingleDefault().putBoolean("mediacodec_create_error", true);
                l(false, true);
                AppMethodBeat.o(93799);
            }
        } catch (Exception e3) {
            Log.printErrStackTrace(this.TAG, e3, "remux impl error", new Object[0]);
            AppMethodBeat.o(93799);
        }
    }

    private final com.tencent.mm.media.b.d aMI() {
        AppMethodBeat.i(93800);
        int min = this.iiB > 0 ? Math.min(this.iiB, this.videoFps) : this.videoFps;
        com.tencent.mm.media.b.d dVar = new com.tencent.mm.media.b.d(this.iiD);
        dVar.bitrate = this.iix;
        dVar.frameRate = min;
        dVar.targetHeight = this.outputHeight;
        dVar.targetWidth = this.outputWidth;
        dVar.idF = this.iiE;
        dVar.idG = this.iiF;
        if (this.iiH > 0) {
            dVar.idB = this.iiH;
        }
        while ((dVar.frameRate * dVar.idB) - 1 <= 1) {
            dVar.frameRate++;
            Log.e(this.TAG, "encodeConfig.frameRate + 1");
        }
        Log.i(this.TAG, "steve: hardcoder qp:" + this.iiE + ", " + this.iiF);
        AppMethodBeat.o(93800);
        return dVar;
    }

    public static final /* synthetic */ void h(f fVar) {
        AppMethodBeat.i(93810);
        Log.i(fVar.TAG, "checkFinishEncode, encodeFrameCount:" + fVar.idi + ", drawFrameCount:" + fVar.iim + ", useRequestDraw:" + fVar.iir + ", isFinishEncode:" + fVar.ifd + ", isDecodeEnd:" + fVar.idb);
        if (fVar.idi <= 0 || fVar.iim <= 0 || fVar.idi < fVar.iim || !fVar.idb) {
            if (fVar.idb) {
                MMHandlerThread.removeRunnable(fVar.iiu);
                MMHandlerThread.postToMainThreadDelayed(fVar.iiu, iiL);
            }
            AppMethodBeat.o(93810);
            return;
        }
        fVar.aMi();
        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOV();
        AppMethodBeat.o(93810);
    }

    public static final /* synthetic */ void H(f fVar) {
        MediaFormat mediaFormat;
        AppMethodBeat.i(93813);
        Log.i(fVar.TAG, "runAudioMix, mixType:" + fVar.idq);
        com.tencent.mm.media.f.a aVar = fVar.ihZ;
        if (aVar != null) {
            aVar.aMr();
        }
        int i2 = fVar.idq;
        if (i2 == 1) {
            i.a(fVar.ihX, fVar.ihZ);
            fVar.eX(false);
            AppMethodBeat.o(93813);
            return;
        }
        if (kotlin.a.j.listOf((Object[]) new Integer[]{2, 3}).contains(Integer.valueOf(i2))) {
            try {
                long currentTicks = Util.currentTicks();
                fVar.ihV = new com.tencent.mm.media.a.a(fVar.ihX.bufId, fVar.idq, fVar.iiz, fVar.iiA, new l(fVar));
                com.tencent.mm.media.a.a aVar2 = fVar.ihV;
                if (aVar2 != null) {
                    aVar2.a(fVar.ihZ, fVar.ihY, fVar.ihX.iho, fVar.ihX.remuxEndTime);
                }
                com.tencent.mm.media.f.a aVar3 = fVar.ihY;
                if (aVar3 != null) {
                    mediaFormat = aVar3.igi;
                } else {
                    mediaFormat = null;
                }
                if (mediaFormat == null) {
                    p.hyc();
                }
                if (!mediaFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) {
                    mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, fVar.iiy);
                }
                mediaFormat.setInteger("channel-count", fVar.iiA);
                com.tencent.mm.media.a.a aVar4 = fVar.ihV;
                if (aVar4 != null) {
                    aVar4.c(mediaFormat);
                }
                com.tencent.mm.media.a.a aVar5 = fVar.ihV;
                if (aVar5 != null) {
                    aVar5.p(new m(fVar, currentTicks));
                    AppMethodBeat.o(93813);
                    return;
                }
                AppMethodBeat.o(93813);
            } catch (Exception e2) {
                Log.printErrStackTrace(fVar.TAG, e2, "mix audio error: " + e2.getMessage(), new Object[0]);
                fVar.eX(false);
                AppMethodBeat.o(93813);
            }
        } else {
            if (i2 == 0) {
                fVar.eX(false);
            }
            AppMethodBeat.o(93813);
        }
    }

    public static final /* synthetic */ void I(f fVar) {
        AppMethodBeat.i(93814);
        MMHandlerThread.postToMainThreadDelayed(new b(fVar), iiK);
        AppMethodBeat.o(93814);
    }
}
