package com.tencent.mm.media.k;

import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0003\b\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u000bJ\u0006\u0010*\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u000bJ\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020\u000bJ\u0006\u00104\u001a\u00020\u000bJ\u0006\u00105\u001a\u00020\u000bJ\u0006\u00106\u001a\u00020\u000bJ\u0016\u00107\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u00020\u000bJ\u0006\u0010:\u001a\u00020\u000bJ\u0006\u0010;\u001a\u00020\u000bJ\u0006\u0010<\u001a\u00020\u000bJ\u0006\u0010=\u001a\u00020\u000bJ\u0006\u0010>\u001a\u00020\u000bJ\u0006\u0010?\u001a\u00020\u000bJ\u0006\u0010@\u001a\u00020\u000bJ\u0006\u0010A\u001a\u00020\u000bJ\u0006\u0010B\u001a\u00020\u000bJ\u0006\u0010C\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020\u000bJ\u000e\u0010E\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010F\u001a\u00020\u000bJ\u0006\u0010G\u001a\u00020\u000bJ\u000e\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000eJ\u0006\u0010J\u001a\u00020\u000bJ\u000e\u0010K\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u000bJ\u0006\u0010M\u001a\u00020\u000bJ\u0006\u0010N\u001a\u00020\u000bJ\u000e\u0010O\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010P\u001a\u00020\u000bJ\u000e\u0010Q\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u000bJ\u0006\u0010S\u001a\u00020\u000bJ\u0006\u0010T\u001a\u00020\u000bJ\u0006\u0010U\u001a\u00020\u000bJ\u0006\u0010V\u001a\u00020\u000bJ\u0006\u0010W\u001a\u00020\u000bJ\u0006\u0010X\u001a\u00020\u000bJ\u0006\u0010Y\u001a\u00020\u000bJ\u0006\u0010Z\u001a\u00020\u000bJ\u0006\u0010[\u001a\u00020\u000bJ\u0006\u0010\\\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020\u000bJ\u0006\u0010^\u001a\u00020\u000bJ\u0006\u0010_\u001a\u00020\u000bJ\u0006\u0010`\u001a\u00020\u000bJ\u0006\u0010a\u001a\u00020\u000bJ\u0006\u0010b\u001a\u00020\u000bJ\u0006\u0010c\u001a\u00020\u000bJ\u0006\u0010d\u001a\u00020\u000bJ\u0006\u0010e\u001a\u00020\u000bJ\u0006\u0010f\u001a\u00020\u000bJ\u0006\u0010g\u001a\u00020\u000bJ\u0006\u0010h\u001a\u00020\u000bJ\u0006\u0010i\u001a\u00020\u000bJ\u0006\u0010j\u001a\u00020\u000bJ\u0006\u0010k\u001a\u00020\u000bJ\u0006\u0010l\u001a\u00020\u000bJ\u0006\u0010m\u001a\u00020\u000bJ\u0006\u0010n\u001a\u00020\u000bJ\u0006\u0010o\u001a\u00020\u000bJ\u0006\u0010p\u001a\u00020\u000bJ\u0006\u0010q\u001a\u00020\u000bJ\u0006\u0010r\u001a\u00020\u000bJ\u0006\u0010s\u001a\u00020\u000bJ\u0016\u0010t\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004J\u001e\u0010u\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u0004J\u000e\u0010w\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010x\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010y\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010z\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010{\u001a\u00020\u000bJ\u0006\u0010|\u001a\u00020\u000bJ\u0006\u0010}\u001a\u00020\u000bJ\u0006\u0010~\u001a\u00020\u000bJ\u0006\u0010\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0017\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bJ\u0007\u0010\u0001\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCheckRemuxResult", "path", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class e {
    private static long ilA = -1;
    private static long ilB = -1;
    public static final e ilC = new e();

    static {
        AppMethodBeat.i(94001);
        AppMethodBeat.o(94001);
    }

    private e() {
    }

    public static void aNk() {
        AppMethodBeat.i(93892);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
        h.INSTANCE.n(985, 3, 1);
        AppMethodBeat.o(93892);
    }

    public static void aNl() {
        AppMethodBeat.i(93893);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
        h.INSTANCE.n(985, 4, 1);
        AppMethodBeat.o(93893);
    }

    public static void aNm() {
        AppMethodBeat.i(93894);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
        h.INSTANCE.n(985, 5, 1);
        AppMethodBeat.o(93894);
    }

    public static void aNn() {
        AppMethodBeat.i(93895);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
        h.INSTANCE.n(985, 7, 1);
        AppMethodBeat.o(93895);
    }

    public static void aNo() {
        AppMethodBeat.i(93896);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
        h.INSTANCE.n(985, 8, 1);
        AppMethodBeat.o(93896);
    }

    public static void aNp() {
        AppMethodBeat.i(93897);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
        h.INSTANCE.n(985, 10, 1);
        AppMethodBeat.o(93897);
    }

    public static void aNq() {
        AppMethodBeat.i(93898);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
        h.INSTANCE.n(985, 11, 1);
        AppMethodBeat.o(93898);
    }

    public static void aNr() {
        AppMethodBeat.i(93899);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
        h.INSTANCE.n(985, 12, 1);
        AppMethodBeat.o(93899);
    }

    public static void aNs() {
        AppMethodBeat.i(93900);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
        h.INSTANCE.n(985, 55, 1);
        AppMethodBeat.o(93900);
    }

    public static void aNt() {
        AppMethodBeat.i(93901);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
        ilA = -1;
        h.INSTANCE.n(985, 30, 1);
        AppMethodBeat.o(93901);
    }

    public static void aNu() {
        AppMethodBeat.i(93902);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
        h.INSTANCE.n(985, 31, 1);
        AppMethodBeat.o(93902);
    }

    public static void aNv() {
        AppMethodBeat.i(93903);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
        h.INSTANCE.n(985, 32, 1);
        AppMethodBeat.o(93903);
    }

    public static void aNw() {
        AppMethodBeat.i(93904);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
        h.INSTANCE.n(985, 33, 1);
        AppMethodBeat.o(93904);
    }

    public static void aNx() {
        AppMethodBeat.i(93905);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
        ilB = Util.currentTicks();
        AppMethodBeat.o(93905);
    }

    public static void aNy() {
        AppMethodBeat.i(93906);
        if (ilB > 0) {
            long ticksToNow = Util.ticksToNow(ilB);
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(ticksToNow)));
            h.INSTANCE.n(985, 34, ticksToNow);
            h.INSTANCE.n(985, 35, 1);
            ilB = -1;
        }
        AppMethodBeat.o(93906);
    }

    public static void aNz() {
        AppMethodBeat.i(93907);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
        h.INSTANCE.n(985, 37, 1);
        AppMethodBeat.o(93907);
    }

    public static void aNA() {
        AppMethodBeat.i(93908);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
        h.INSTANCE.n(985, 39, 1);
        AppMethodBeat.o(93908);
    }

    public static void dd(int i2, int i3) {
        AppMethodBeat.i(93909);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + i2 + ", fps:" + i3);
        h.INSTANCE.n(985, 38, (long) i2);
        h.INSTANCE.n(985, 41, (long) i3);
        AppMethodBeat.o(93909);
    }

    public static void aNB() {
        AppMethodBeat.i(93910);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
        ilB = -1;
        h.INSTANCE.n(985, 13, 1);
        AppMethodBeat.o(93910);
    }

    public static void aNC() {
        AppMethodBeat.i(93911);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
        h.INSTANCE.n(985, 14, 1);
        AppMethodBeat.o(93911);
    }

    public static void aND() {
        AppMethodBeat.i(93912);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
        h.INSTANCE.n(985, 15, 1);
        AppMethodBeat.o(93912);
    }

    public static void aNE() {
        AppMethodBeat.i(93913);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
        h.INSTANCE.n(985, 16, 1);
        AppMethodBeat.o(93913);
    }

    public static void aNF() {
        AppMethodBeat.i(93914);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
        ilB = Util.currentTicks();
        AppMethodBeat.o(93914);
    }

    public static void aNG() {
        AppMethodBeat.i(93915);
        if (ilB > 0) {
            long ticksToNow = Util.ticksToNow(ilB);
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(ticksToNow)));
            h.INSTANCE.n(985, 17, ticksToNow);
            h.INSTANCE.n(985, 18, 1);
            ilB = -1;
        }
        AppMethodBeat.o(93915);
    }

    public static void aNH() {
        AppMethodBeat.i(93916);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
        h.INSTANCE.n(985, 20, 1);
        AppMethodBeat.o(93916);
    }

    public static void aNI() {
        AppMethodBeat.i(93917);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
        h.INSTANCE.n(985, 22, 1);
        AppMethodBeat.o(93917);
    }

    public static void de(int i2, int i3) {
        AppMethodBeat.i(93918);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + i2 + ", fps:" + i3);
        h.INSTANCE.n(985, 21, (long) i2);
        h.INSTANCE.n(985, 24, (long) i3);
        AppMethodBeat.o(93918);
    }

    public static void aNJ() {
        AppMethodBeat.i(93919);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
        h.INSTANCE.n(985, 26, 1);
        AppMethodBeat.o(93919);
    }

    public static void aNK() {
        AppMethodBeat.i(93920);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
        h.INSTANCE.n(985, 27, 1);
        AppMethodBeat.o(93920);
    }

    public static void n(String str, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(93921);
        p.h(str, "filePath");
        try {
            if (Util.isNullOrNil(str) || !s.YS(str)) {
                AppMethodBeat.o(93921);
                return;
            }
            h.INSTANCE.idkeyStat(985, 69, 1, false);
            JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(str));
            int i9 = (int) jSONObject.getDouble("videoFPS");
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", Integer.valueOf(i9), Integer.valueOf(jSONObject.optInt("videoBitrate")), Integer.valueOf(i2), Integer.valueOf(i3));
            int i10 = 89;
            int i11 = 104;
            if (i2 == 1) {
                h.INSTANCE.idkeyStat(985, 71, 1, false);
                h.INSTANCE.idkeyStat(985, 73, (long) i9, false);
                i6 = 74;
                i5 = 95;
                i10 = 98;
                i4 = 108;
                i11 = 107;
            } else {
                h.INSTANCE.idkeyStat(985, 70, 1, false);
                h.INSTANCE.idkeyStat(985, 72, (long) i9, false);
                i4 = 105;
                i5 = 86;
                i6 = 57;
            }
            if (i3 == 720) {
                i10++;
                i7 = i5 + 1;
                i8 = i6 + 4;
            } else {
                com.tencent.mm.plugin.mmsight.model.p pVar = k.zuy;
                p.g(pVar, "MMSightRecorderConfig.parameter");
                if (pVar.ejS() || i3 == 1080) {
                    i10 += 2;
                    i7 = i5 + 2;
                    i8 = i6 + 8;
                } else {
                    i7 = i5;
                    i8 = i6;
                }
            }
            h.INSTANCE.idkeyStat(985, (long) i7, 1, false);
            h.INSTANCE.idkeyStat(985, (long) i10, (long) i9, false);
            h.INSTANCE.idkeyStat(985, (long) i11, 1, false);
            h.INSTANCE.idkeyStat(985, (long) i4, (long) i9, false);
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", str, Integer.valueOf(i8));
            if (i9 >= 0 && i9 <= 10) {
                h.INSTANCE.idkeyStat(985, (long) i8, 1, false);
                AppMethodBeat.o(93921);
            } else if (i9 > 10 && i9 <= 15) {
                h.INSTANCE.idkeyStat(985, (long) (i8 + 1), 1, false);
                AppMethodBeat.o(93921);
            } else if (i9 <= 15 || i9 > 20) {
                if (i9 > 20 && i9 <= 30) {
                    h.INSTANCE.idkeyStat(985, (long) (i8 + 3), 1, false);
                }
                AppMethodBeat.o(93921);
            } else {
                h.INSTANCE.idkeyStat(985, (long) (i8 + 2), 1, false);
                AppMethodBeat.o(93921);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish error: %s", e2.getMessage());
            AppMethodBeat.o(93921);
        }
    }

    public static void aNL() {
        AppMethodBeat.i(93922);
        h.INSTANCE.idkeyStat(985, 118, 1, false);
        AppMethodBeat.o(93922);
    }

    public static void aNM() {
        AppMethodBeat.i(93923);
        h.INSTANCE.idkeyStat(985, 119, 1, false);
        AppMethodBeat.o(93923);
    }

    public static void aNN() {
        AppMethodBeat.i(93924);
        h.INSTANCE.idkeyStat(985, 120, 1, false);
        AppMethodBeat.o(93924);
    }

    public static void aNO() {
        AppMethodBeat.i(93925);
        h.INSTANCE.idkeyStat(985, 121, 1, false);
        AppMethodBeat.o(93925);
    }

    public static void zK(long j2) {
        AppMethodBeat.i(93926);
        h.INSTANCE.idkeyStat(985, 122, j2, false);
        AppMethodBeat.o(93926);
    }

    public static void aNP() {
        AppMethodBeat.i(93927);
        h.INSTANCE.idkeyStat(985, 124, 1, false);
        AppMethodBeat.o(93927);
    }

    public static void aNQ() {
        AppMethodBeat.i(93928);
        h.INSTANCE.idkeyStat(985, 125, 1, false);
        AppMethodBeat.o(93928);
    }

    public static void aNR() {
        AppMethodBeat.i(93929);
        h.INSTANCE.idkeyStat(985, 126, 1, false);
        AppMethodBeat.o(93929);
    }

    public static void aNS() {
        AppMethodBeat.i(93930);
        h.INSTANCE.idkeyStat(985, 127, 1, false);
        AppMethodBeat.o(93930);
    }

    public static void zL(long j2) {
        AppMethodBeat.i(93931);
        h.INSTANCE.idkeyStat(985, 128, j2, false);
        AppMethodBeat.o(93931);
    }

    public static void aNT() {
        AppMethodBeat.i(93932);
        h.INSTANCE.idkeyStat(985, 130, 1, false);
        AppMethodBeat.o(93932);
    }

    public static void aNU() {
        AppMethodBeat.i(93933);
        h.INSTANCE.idkeyStat(985, 135, 1, false);
        AppMethodBeat.o(93933);
    }

    public static void aNV() {
        AppMethodBeat.i(93934);
        h.INSTANCE.idkeyStat(985, 136, 1, false);
        AppMethodBeat.o(93934);
    }

    public static void aNW() {
        AppMethodBeat.i(93935);
        h.INSTANCE.idkeyStat(985, 138, 1, false);
        AppMethodBeat.o(93935);
    }

    public static void aNX() {
        AppMethodBeat.i(93936);
        h.INSTANCE.idkeyStat(985, 139, 1, false);
        AppMethodBeat.o(93936);
    }

    public static void aNY() {
        AppMethodBeat.i(93937);
        h.INSTANCE.idkeyStat(985, 143, 1, false);
        AppMethodBeat.o(93937);
    }

    public static void aNZ() {
        AppMethodBeat.i(93938);
        h.INSTANCE.idkeyStat(985, 144, 1, false);
        AppMethodBeat.o(93938);
    }

    public static void aOa() {
        AppMethodBeat.i(93939);
        h.INSTANCE.idkeyStat(985, 146, 1, false);
        AppMethodBeat.o(93939);
    }

    public static void aOb() {
        AppMethodBeat.i(177318);
        h.INSTANCE.idkeyStat(985, 147, 1, false);
        AppMethodBeat.o(177318);
    }

    public static void aOc() {
        AppMethodBeat.i(177319);
        h.INSTANCE.idkeyStat(985, 148, 1, false);
        AppMethodBeat.o(177319);
    }

    public static void aOd() {
        AppMethodBeat.i(93940);
        h.INSTANCE.idkeyStat(985, 149, 1, false);
        AppMethodBeat.o(93940);
    }

    public static void aOe() {
        AppMethodBeat.i(93941);
        h.INSTANCE.idkeyStat(985, 150, 1, false);
        AppMethodBeat.o(93941);
    }

    public static void aOf() {
        AppMethodBeat.i(93942);
        h.INSTANCE.idkeyStat(985, 151, 1, false);
        AppMethodBeat.o(93942);
    }

    public static void aOg() {
        AppMethodBeat.i(93943);
        h.INSTANCE.idkeyStat(985, 152, 1, false);
        AppMethodBeat.o(93943);
    }

    public static void aOh() {
        AppMethodBeat.i(93944);
        h.INSTANCE.idkeyStat(985, 154, 1, false);
        AppMethodBeat.o(93944);
    }

    public static void zM(long j2) {
        AppMethodBeat.i(93945);
        h.INSTANCE.idkeyStat(985, 155, j2, false);
        AppMethodBeat.o(93945);
    }

    public static void aOi() {
        AppMethodBeat.i(93946);
        h.INSTANCE.idkeyStat(985, 159, 1, false);
        AppMethodBeat.o(93946);
    }

    public static void aOj() {
        AppMethodBeat.i(93947);
        h.INSTANCE.idkeyStat(985, 160, 1, false);
        AppMethodBeat.o(93947);
    }

    public static void aOk() {
        AppMethodBeat.i(93948);
        h.INSTANCE.idkeyStat(985, 161, 1, false);
        AppMethodBeat.o(93948);
    }

    public static void aOl() {
        AppMethodBeat.i(93949);
        h.INSTANCE.idkeyStat(985, 162, 1, false);
        AppMethodBeat.o(93949);
    }

    public static void aOm() {
        AppMethodBeat.i(93950);
        h.INSTANCE.idkeyStat(985, 163, 1, false);
        AppMethodBeat.o(93950);
    }

    public static void aOn() {
        AppMethodBeat.i(93951);
        h.INSTANCE.idkeyStat(985, 164, 1, false);
        AppMethodBeat.o(93951);
    }

    public static void aOo() {
        AppMethodBeat.i(93952);
        h.INSTANCE.idkeyStat(985, 165, 1, false);
        AppMethodBeat.o(93952);
    }

    public static void aOp() {
        AppMethodBeat.i(93953);
        h.INSTANCE.idkeyStat(985, 166, 1, false);
        AppMethodBeat.o(93953);
    }

    public static void zN(long j2) {
        AppMethodBeat.i(93954);
        h.INSTANCE.idkeyStat(985, 168, j2, false);
        AppMethodBeat.o(93954);
    }

    public static void aOq() {
        AppMethodBeat.i(93955);
        h.INSTANCE.idkeyStat(985, 169, 1, false);
        AppMethodBeat.o(93955);
    }

    public static void zO(long j2) {
        AppMethodBeat.i(93956);
        h.INSTANCE.idkeyStat(985, 170, j2, false);
        AppMethodBeat.o(93956);
    }

    public static void zP(long j2) {
        AppMethodBeat.i(93957);
        h.INSTANCE.idkeyStat(985, 173, j2, false);
        AppMethodBeat.o(93957);
    }

    public static void aOr() {
        AppMethodBeat.i(93958);
        h.INSTANCE.idkeyStat(985, 174, 1, false);
        AppMethodBeat.o(93958);
    }

    public static void zQ(long j2) {
        AppMethodBeat.i(93959);
        h.INSTANCE.idkeyStat(985, 175, j2, false);
        AppMethodBeat.o(93959);
    }

    public static void aOs() {
        AppMethodBeat.i(93960);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
        h.INSTANCE.idkeyStat(985, 181, 1, false);
        AppMethodBeat.o(93960);
    }

    public static void aOt() {
        AppMethodBeat.i(93961);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
        h.INSTANCE.idkeyStat(985, 182, 1, false);
        AppMethodBeat.o(93961);
    }

    public static void rn(int i2) {
        AppMethodBeat.i(93962);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(i2)));
        h.INSTANCE.n(986, 0, 1);
        if (i2 == 1) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
            h.INSTANCE.n(986, 1, 1);
            AppMethodBeat.o(93962);
        } else if (i2 == 3) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
            h.INSTANCE.n(986, 2, 1);
            AppMethodBeat.o(93962);
        } else if (i2 == 2) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
            h.INSTANCE.n(986, 3, 1);
            AppMethodBeat.o(93962);
        } else {
            if (i2 == 0) {
                Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
                h.INSTANCE.n(986, 4, 1);
            }
            AppMethodBeat.o(93962);
        }
    }

    public static void aOu() {
        AppMethodBeat.i(93963);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
        h.INSTANCE.n(986, 7, 1);
        AppMethodBeat.o(93963);
    }

    public static void aOv() {
        AppMethodBeat.i(93964);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
        h.INSTANCE.n(986, 10, 1);
        AppMethodBeat.o(93964);
    }

    public static void aOw() {
        AppMethodBeat.i(93965);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
        h.INSTANCE.n(986, 11, 1);
        AppMethodBeat.o(93965);
    }

    public static void aOx() {
        AppMethodBeat.i(93968);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
        h.INSTANCE.n(986, 14, 1);
        AppMethodBeat.o(93968);
    }

    public static void aOy() {
        AppMethodBeat.i(93969);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
        h.INSTANCE.n(986, 15, 1);
        AppMethodBeat.o(93969);
    }

    public static void aOz() {
        AppMethodBeat.i(93970);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
        h.INSTANCE.n(986, 16, 1);
        AppMethodBeat.o(93970);
    }

    public static void aOA() {
        AppMethodBeat.i(93971);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
        h.INSTANCE.n(986, 17, 1);
        AppMethodBeat.o(93971);
    }

    public static void aOB() {
        AppMethodBeat.i(93972);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
        h.INSTANCE.n(986, 18, 1);
        AppMethodBeat.o(93972);
    }

    public static void aOC() {
        AppMethodBeat.i(93973);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
        h.INSTANCE.n(986, 19, 1);
        AppMethodBeat.o(93973);
    }

    public static void aOD() {
        AppMethodBeat.i(93974);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
        h.INSTANCE.n(986, 22, 1);
        AppMethodBeat.o(93974);
    }

    public static void aOE() {
        AppMethodBeat.i(93975);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
        h.INSTANCE.n(986, 23, 1);
        AppMethodBeat.o(93975);
    }

    public static void aOF() {
        AppMethodBeat.i(93976);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
        h.INSTANCE.n(986, 24, 1);
        AppMethodBeat.o(93976);
    }

    public static void aOG() {
        AppMethodBeat.i(93977);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
        h.INSTANCE.n(986, 26, 1);
        AppMethodBeat.o(93977);
    }

    public static void zR(long j2) {
        AppMethodBeat.i(93978);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(986, 27, j2);
        AppMethodBeat.o(93978);
    }

    public static void aOH() {
        AppMethodBeat.i(93979);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
        h.INSTANCE.n(986, 30, 1);
        AppMethodBeat.o(93979);
    }

    public static void zS(long j2) {
        AppMethodBeat.i(93980);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(j2)));
        h.INSTANCE.n(986, 31, j2);
        AppMethodBeat.o(93980);
    }

    public static void y(int i2, long j2) {
        AppMethodBeat.i(93981);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + i2 + ", time:" + j2);
        h.INSTANCE.n(986, 34, 1);
        if (i2 == 1) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(j2)));
            h.INSTANCE.n(986, 35, j2);
            AppMethodBeat.o(93981);
        } else if (i2 == 3) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(j2)));
            h.INSTANCE.n(986, 41, j2);
            AppMethodBeat.o(93981);
        } else if (i2 == 2) {
            Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(j2)));
            h.INSTANCE.n(986, 37, j2);
            AppMethodBeat.o(93981);
        } else {
            if (i2 == 0) {
                Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(j2)));
                h.INSTANCE.n(986, 39, j2);
            }
            AppMethodBeat.o(93981);
        }
    }

    public static void f(long j2, long j3, long j4) {
        AppMethodBeat.i(93982);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + j2 + ", fps:" + j3 + ", originVideoFps:" + j4);
        h.INSTANCE.n(986, 43, j4);
        h.INSTANCE.n(986, 45, j3);
        h.INSTANCE.n(986, 48, j2);
        AppMethodBeat.o(93982);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void Hs(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.k.e.Hs(java.lang.String):void");
    }

    public static void aOI() {
        AppMethodBeat.i(93983);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
        h.INSTANCE.n(986, 53, 1);
        AppMethodBeat.o(93983);
    }

    public static void aOJ() {
        AppMethodBeat.i(93984);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
        h.INSTANCE.n(986, 25, 1);
        AppMethodBeat.o(93984);
    }

    public static void aOK() {
        AppMethodBeat.i(93985);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
        h.INSTANCE.n(986, 76, 1);
        AppMethodBeat.o(93985);
    }

    public static void aOL() {
        AppMethodBeat.i(93986);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
        h.INSTANCE.n(986, 80, 1);
        AppMethodBeat.o(93986);
    }

    public static void aOM() {
        AppMethodBeat.i(93987);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
        h.INSTANCE.n(986, 80, 1);
        AppMethodBeat.o(93987);
    }

    public static void aON() {
        AppMethodBeat.i(93988);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
        h.INSTANCE.n(986, 77, 1);
        AppMethodBeat.o(93988);
    }

    public static void aOO() {
        AppMethodBeat.i(93989);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
        h.INSTANCE.n(986, 81, 1);
        AppMethodBeat.o(93989);
    }

    public static void aOP() {
        AppMethodBeat.i(93990);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
        h.INSTANCE.n(986, 78, 1);
        AppMethodBeat.o(93990);
    }

    public static void aOQ() {
        AppMethodBeat.i(93991);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
        h.INSTANCE.n(986, 82, 1);
        AppMethodBeat.o(93991);
    }

    public static void aOR() {
        AppMethodBeat.i(93992);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
        h.INSTANCE.n(986, 83, 1);
        AppMethodBeat.o(93992);
    }

    public static void aOS() {
        AppMethodBeat.i(93993);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
        h.INSTANCE.n(986, 84, 1);
        AppMethodBeat.o(93993);
    }

    public static void aOT() {
        AppMethodBeat.i(93994);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
        h.INSTANCE.n(986, 54, 1);
        AppMethodBeat.o(93994);
    }

    public static void aOU() {
        AppMethodBeat.i(93995);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
        h.INSTANCE.n(986, 86, 1);
        AppMethodBeat.o(93995);
    }

    public static void aOV() {
        AppMethodBeat.i(93996);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
        h.INSTANCE.n(986, 90, 1);
        AppMethodBeat.o(93996);
    }

    public static void aOW() {
        AppMethodBeat.i(93997);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
        h.INSTANCE.n(986, 91, 1);
        AppMethodBeat.o(93997);
    }

    public static void aOX() {
        AppMethodBeat.i(93998);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
        h.INSTANCE.n(986, 100, 1);
        AppMethodBeat.o(93998);
    }

    public static void aOY() {
        AppMethodBeat.i(93999);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
        h.INSTANCE.n(986, 123, 1);
        AppMethodBeat.o(93999);
    }

    public static void aOZ() {
        AppMethodBeat.i(94000);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
        h.INSTANCE.n(986, 124, 1);
        AppMethodBeat.o(94000);
    }

    public static void zT(long j2) {
        AppMethodBeat.i(177320);
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(j2)));
        if (j2 < 1000) {
            h.INSTANCE.n(986, 130, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 2000) {
            h.INSTANCE.n(986, 131, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 3000) {
            h.INSTANCE.n(986, 132, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 4000) {
            h.INSTANCE.n(986, 133, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 5000) {
            h.INSTANCE.n(986, 134, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            h.INSTANCE.n(986, 135, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 7000) {
            h.INSTANCE.n(986, 136, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 8000) {
            h.INSTANCE.n(986, 137, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 9000) {
            h.INSTANCE.n(986, 138, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 10000) {
            h.INSTANCE.n(986, 139, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 15000) {
            h.INSTANCE.n(986, 140, 1);
            AppMethodBeat.o(177320);
        } else if (j2 < 20000) {
            h.INSTANCE.n(986, 141, 1);
            AppMethodBeat.o(177320);
        } else {
            h.INSTANCE.n(986, 142, 1);
            AppMethodBeat.o(177320);
        }
    }
}
