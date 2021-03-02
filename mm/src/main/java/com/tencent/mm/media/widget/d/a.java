package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nJ>\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/media/widget/util/Camera2ProcessIDKeyStat;", "", "()V", "ID", "", "KV_ID", "", "TAG", "", "markCamera2Open", "", "markCamera2OpenFailed", "markCamera2OpenSuccess", "markCamera2Release", "markCamera2SupportEXTERNAL", "markCamera2SupportFULL", "markCamera2SupportLEGACY", "markCamera2SupportLEVEL3", "markCamera2SupportLIMITED", "markCamera2TakePhotoBack", "markCamera2TakePhotoBackError", "markCamera2TakePhotoFront", "markCamera2TakePhotoFrontError", "markCamera2TakePhotoUseHDRSystem", "markCamera2UseEISSystem", "markCamera2UseOISSystem", "markCamera2UseRecordStream", "markCameraNumberAllBeenRemove", "markCameraNumberHasOne", "markCameraNumberHasTwo", "markCameraNumberMoreThanTwo", "markCameraQueryFail", "markCaptureSuccessUseImageBack", "markCaptureSuccessUseImageFront", "markCaptureUseImageCostTimes", "times", "markCaptureUseImageCostTimesBack", "markCaptureUseImageCostTimesFront", "markCaptureUseImageSuccess", "markErrorFindImage", "markErrorFindPreview", "markImageAvailable", "markReportCamera2Info", "numbers", "supportLevels", "levelDiffCameras", "frontLevel", "backLevel", "frontCameraNumber", "backCameraNumber", "markSupportLevelDiffCameras", "plugin-mediaeditor_release"})
public final class a {
    public static final a itg = new a();

    static {
        AppMethodBeat.i(218938);
        AppMethodBeat.o(218938);
    }

    private a() {
    }

    public static void aRb() {
        AppMethodBeat.i(218910);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Open");
        h.INSTANCE.n(1099, 0, 1);
        AppMethodBeat.o(218910);
    }

    public static void aRc() {
        AppMethodBeat.i(218911);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenSuccess");
        h.INSTANCE.n(1099, 1, 1);
        AppMethodBeat.o(218911);
    }

    public static void aRd() {
        AppMethodBeat.i(218912);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenFailed");
        h.INSTANCE.n(1099, 2, 1);
        AppMethodBeat.o(218912);
    }

    public static void aRe() {
        AppMethodBeat.i(218913);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Release");
        h.INSTANCE.n(1099, 3, 1);
        AppMethodBeat.o(218913);
    }

    public static void aRf() {
        AppMethodBeat.i(218914);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoFront");
        h.INSTANCE.n(1099, 4, 1);
        AppMethodBeat.o(218914);
    }

    public static void aRg() {
        AppMethodBeat.i(218915);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBack");
        h.INSTANCE.n(1099, 5, 1);
        AppMethodBeat.o(218915);
    }

    public static void aRh() {
        AppMethodBeat.i(218916);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
        h.INSTANCE.n(1099, 6, 1);
        AppMethodBeat.o(218916);
    }

    public static void aRi() {
        AppMethodBeat.i(218917);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
        com.tencent.mm.compatible.d.a aVar = com.tencent.mm.compatible.d.a.INSTANCE;
        com.tencent.mm.compatible.d.a.v(1099, 7);
        AppMethodBeat.o(218917);
    }

    public static void aRj() {
        AppMethodBeat.i(218918);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseOISSystem");
        h.INSTANCE.n(1099, 9, 1);
        AppMethodBeat.o(218918);
    }

    public static void aRk() {
        AppMethodBeat.i(218919);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markErrorFindImage");
        h.INSTANCE.n(1099, 12, 1);
        AppMethodBeat.o(218919);
    }

    public static void aRl() {
        AppMethodBeat.i(218920);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markImageAvailable");
        h.INSTANCE.n(1099, 13, 1);
        AppMethodBeat.o(218920);
    }

    public static void aRm() {
        AppMethodBeat.i(218921);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageBack");
        h.INSTANCE.n(1099, 14, 1);
        AppMethodBeat.o(218921);
    }

    public static void aRn() {
        AppMethodBeat.i(218922);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageFront");
        h.INSTANCE.n(1099, 15, 1);
        AppMethodBeat.o(218922);
    }

    public static void aRo() {
        AppMethodBeat.i(218923);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageSuccess");
        h.INSTANCE.n(1099, 16, 1);
        AppMethodBeat.o(218923);
    }

    public static void aRp() {
        AppMethodBeat.i(218924);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseRecordStream");
        h.INSTANCE.n(1099, 18, 1);
        AppMethodBeat.o(218924);
    }

    public static void aRq() {
        AppMethodBeat.i(218925);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLIMITED");
        h.INSTANCE.n(1099, 19, 1);
        AppMethodBeat.o(218925);
    }

    public static void aRr() {
        AppMethodBeat.i(218926);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportFULL");
        h.INSTANCE.n(1099, 20, 1);
        AppMethodBeat.o(218926);
    }

    public static void aRs() {
        AppMethodBeat.i(218927);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEGACY");
        h.INSTANCE.n(1099, 21, 1);
        AppMethodBeat.o(218927);
    }

    public static void aRt() {
        AppMethodBeat.i(218928);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEVEL3");
        h.INSTANCE.n(1099, 22, 1);
        AppMethodBeat.o(218928);
    }

    public static void aRu() {
        AppMethodBeat.i(218929);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportEXTERNAL");
        h.INSTANCE.n(1099, 23, 1);
        AppMethodBeat.o(218929);
    }

    public static void zW(long j2) {
        AppMethodBeat.i(218930);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesFront ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1099, 24, j2);
        AppMethodBeat.o(218930);
    }

    public static void zX(long j2) {
        AppMethodBeat.i(218931);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesBack ".concat(String.valueOf(j2)));
        h.INSTANCE.n(1099, 25, j2);
        AppMethodBeat.o(218931);
    }

    public static void aRv() {
        AppMethodBeat.i(218932);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberAllBeenRemove ");
        h.INSTANCE.n(1099, 26, 1);
        AppMethodBeat.o(218932);
    }

    public static void aRw() {
        AppMethodBeat.i(218933);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasOne ");
        h.INSTANCE.n(1099, 27, 1);
        AppMethodBeat.o(218933);
    }

    public static void aRx() {
        AppMethodBeat.i(218934);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasTwo");
        h.INSTANCE.n(1099, 28, 1);
        AppMethodBeat.o(218934);
    }

    public static void aRy() {
        AppMethodBeat.i(218935);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberMoreThanTwo");
        h.INSTANCE.n(1099, 29, 1);
        AppMethodBeat.o(218935);
    }

    public static void aRz() {
        AppMethodBeat.i(218936);
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markSupportLevelDiffCameras");
        h.INSTANCE.n(1099, 30, 1);
        AppMethodBeat.o(218936);
    }

    public static void a(int i2, String str, int i3, String str2, String str3, int i4, int i5) {
        AppMethodBeat.i(218937);
        p.h(str, "supportLevels");
        p.h(str2, "frontLevel");
        p.h(str3, "backLevel");
        Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markReportCamera2Info " + i2 + ',' + str + ',' + i3 + ',' + str2 + ',' + str3 + ',' + i4 + ',' + i5);
        h.INSTANCE.a(22109, Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(218937);
    }
}
