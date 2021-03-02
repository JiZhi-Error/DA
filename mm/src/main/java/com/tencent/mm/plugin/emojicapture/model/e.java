package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ&\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e {
    private static final String TAG = TAG;
    private static final long oIi = oIi;
    public static final e roB = new e();

    static {
        AppMethodBeat.i(188);
        AppMethodBeat.o(188);
    }

    private e() {
    }

    public static void cIN() {
        AppMethodBeat.i(TbsListener.ErrorCode.STARTDOWNLOAD_3);
        Log.i(TAG, "markEmojiCaptureUIOnCreate");
        h.INSTANCE.n(oIi, 0, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.STARTDOWNLOAD_3);
    }

    public static void cIO() {
        AppMethodBeat.i(TbsListener.ErrorCode.STARTDOWNLOAD_4);
        Log.i(TAG, "markEmojiCaptureUIOnDestroy");
        h.INSTANCE.n(oIi, 1, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.STARTDOWNLOAD_4);
    }

    public static void aNm() {
        AppMethodBeat.i(TbsListener.ErrorCode.STARTDOWNLOAD_5);
        Log.i(TAG, "markCameraOpenFailed");
        h.INSTANCE.n(oIi, 3, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.STARTDOWNLOAD_5);
    }

    public static void cIP() {
        AppMethodBeat.i(TbsListener.ErrorCode.STARTDOWNLOAD_6);
        Log.i(TAG, "markGpuCropPreview");
        h.INSTANCE.n(oIi, 6, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.STARTDOWNLOAD_6);
    }

    public static void cIQ() {
        AppMethodBeat.i(166);
        Log.i(TAG, "markCpuCropPreview");
        h.INSTANCE.n(oIi, 7, 1);
        AppMethodBeat.o(166);
    }

    public static void cIR() {
        AppMethodBeat.i(TbsListener.ErrorCode.STARTDOWNLOAD_8);
        Log.i(TAG, "markGpuCropPreviewFailed");
        h.INSTANCE.n(oIi, 8, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.STARTDOWNLOAD_8);
    }

    public static void cIS() {
        AppMethodBeat.i(168);
        Log.i(TAG, "markCpuCropPreviewFailed");
        h.INSTANCE.n(oIi, 9, 1);
        AppMethodBeat.o(168);
    }

    public static void cIT() {
        AppMethodBeat.i(169);
        Log.i(TAG, "markVideoRecordFailed");
        h.INSTANCE.n(oIi, 10, 1);
        AppMethodBeat.o(169);
    }

    public static void cIU() {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE);
        Log.i(TAG, "markVideoRecordNoThumb");
        h.INSTANCE.n(oIi, 11, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE);
    }

    public static void cIV() {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1);
        Log.i(TAG, "markSdkInitFailed");
        h.INSTANCE.n(oIi, 13, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1);
    }

    public static void cIW() {
        AppMethodBeat.i(172);
        Log.i(TAG, "markSdkDrawFailed");
        h.INSTANCE.n(oIi, 14, 1);
        AppMethodBeat.o(172);
    }

    public static void cIX() {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
        Log.i(TAG, "markSdkReleaseFailed");
        h.INSTANCE.n(oIi, 15, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
    }

    public static void b(boolean z, boolean z2, boolean z3, int i2) {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
        Log.i(TAG, "markStartEmojiMix, removeBackground:" + z + ", hasSticker:" + z2 + ", speedUp:" + z3 + ", videoDuration:" + i2);
        h.INSTANCE.n(oIi, 17, 1);
        if (z) {
            h.INSTANCE.n(oIi, 18, 1);
        }
        if (z2) {
            h.INSTANCE.n(oIi, 19, 1);
        }
        if (z3) {
            h.INSTANCE.n(oIi, 20, 1);
        }
        if (i2 > 0) {
            h.INSTANCE.n(oIi, 36, (long) i2);
        }
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
    }

    public static void q(long j2, boolean z) {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
        Log.i(TAG, "markEmojiMixSucc, costTime:" + j2 + ", removeBackground:" + z);
        h.INSTANCE.n(oIi, 21, 1);
        if (z) {
            h.INSTANCE.n(oIi, 23, 1);
        } else {
            h.INSTANCE.n(oIi, 22, 1);
        }
        if (z) {
            h.INSTANCE.n(oIi, 42, j2);
            AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
            return;
        }
        h.INSTANCE.n(oIi, 39, j2);
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5);
    }

    public static void cIY() {
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        Log.i(TAG, "markPixelBufferInitFailed");
        h.INSTANCE.n(oIi, 25, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
    }

    public static void cIZ() {
        AppMethodBeat.i(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
        Log.i(TAG, "markVideoDecoderInitFailed");
        h.INSTANCE.n(oIi, 26, 1);
        AppMethodBeat.o(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
    }

    public static void cJa() {
        AppMethodBeat.i(178);
        Log.i(TAG, "markMixFrameDrawFailed");
        h.INSTANCE.n(oIi, 27, 1);
        AppMethodBeat.o(178);
    }

    public static void cJb() {
        AppMethodBeat.i(179);
        Log.i(TAG, "markUseWxam");
        h.INSTANCE.n(oIi, 30, 1);
        AppMethodBeat.o(179);
    }

    public static void cJc() {
        AppMethodBeat.i(TXLiveConstants.RENDER_ROTATION_180);
        Log.i(TAG, "markUseGif");
        h.INSTANCE.n(oIi, 31, 1);
        AppMethodBeat.o(TXLiveConstants.RENDER_ROTATION_180);
    }

    public static void cJd() {
        AppMethodBeat.i(181);
        Log.i(TAG, "markWxamInitFailed");
        h.INSTANCE.n(oIi, 32, 1);
        AppMethodBeat.o(181);
    }

    public static void cJe() {
        AppMethodBeat.i(182);
        Log.i(TAG, "markGifInitFailed");
        h.INSTANCE.n(oIi, 33, 1);
        AppMethodBeat.o(182);
    }

    public static void cJf() {
        AppMethodBeat.i(183);
        Log.i(TAG, "markSdkSegmentInitFailed");
        h.INSTANCE.F(oIi, 45);
        AppMethodBeat.o(183);
    }

    public static void cJg() {
        AppMethodBeat.i(184);
        Log.i(TAG, "markSdkSegmentDestroyFailed");
        h.INSTANCE.F(oIi, 47);
        AppMethodBeat.o(184);
    }

    public static void cJh() {
        AppMethodBeat.i(185);
        h.INSTANCE.F(oIi, 56);
        AppMethodBeat.o(185);
    }

    public static void cJi() {
        AppMethodBeat.i(186);
        h.INSTANCE.F(oIi, 57);
        AppMethodBeat.o(186);
    }

    public static void cJj() {
        AppMethodBeat.i(187);
        Log.i(TAG, "markProxyCallFailed");
        h.INSTANCE.F(oIi, 59);
        AppMethodBeat.o(187);
    }
}
