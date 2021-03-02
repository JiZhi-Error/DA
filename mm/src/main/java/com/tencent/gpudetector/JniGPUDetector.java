package com.tencent.gpudetector;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.a.ae;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n¨\u0006\u0019"}, hxF = {"Lcom/tencent/gpudetector/JniGPUDetector;", "", "()V", "gpuArchInfo", "", "getGpuArchInfo", "()Ljava/lang/String;", "gpuCodeInfo", "", "getGpuCodeInfo", "()I", "gpuCoreSumInfo", "getGpuCoreSumInfo", "gpuInfo", "", "getGpuInfo", "()[I", "gpuPerfScoreInfo", "getGpuPerfScoreInfo", "GetGPUDeviceModel", "", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "Companion", "GpuDeviceModel", "gpudetector_release"})
public final class JniGPUDetector {
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Integer, String> gpuDetailList = ae.g(s.U(-1, "GpuDeviceArchUnknown"), s.U(0, "GpuDeviceArchAMDGeneric"), s.U(1, "GpuDeviceArchAppleGeneric"), s.U(2, "GpuDeviceArchAppleA"), s.U(3, "GpuDeviceArchARMGeneric"), s.U(4, "GpuDeviceArchMaliMidgardT"), s.U(5, "GpuDeviceArchMaliBifrostG"), s.U(6, "GpuDeviceArchMaliValhallG"), s.U(7, "GpuDeviceArchImaginationGeneric"), s.U(8, "GpuDeviceArchPowerVRSGX"), s.U(9, "GpuDeviceArchPowerVRRogueGeneric"), s.U(10, "GpuDeviceArchPowerVRRogueG"), s.U(11, "GpuDeviceArchPowerVRRogueGX"), s.U(12, "GpuDeviceArchPowerVRRogueGT"), s.U(13, "GpuDeviceArchPowerVRRogueGE"), s.U(14, "GpuDeviceArchPowerVRRogueGM"), s.U(15, "GpuDeviceArchPowerVRFurianBegin"), s.U(16, "GpuDeviceArchPowerVRFurianGT"), s.U(17, "GpuDeviceArchImgAlbiorixGeneric"), s.U(18, "GpuDeviceArchImgAlbiorixAXE"), s.U(19, "GpuDeviceArchImgAlbiorixAXM"), s.U(20, "GpuDeviceArchImgAlbiorixAXT"), s.U(21, "GpuDeviceArchIntelGeneric"), s.U(22, "GpuDeviceArchNVIDIAGeneric"), s.U(23, "GpuDeviceArchQualcommGeneric"), s.U(24, "GpuDeviceArchAdreno3XX"), s.U(25, "GpuDeviceArchAdreno4XX"), s.U(26, "GpuDeviceArchAdreno5XX"), s.U(27, "GpuDeviceArchAdreno6XX"));

    public final native boolean GetGPUDeviceModel(GpuDeviceModel gpuDeviceModel);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, hxF = {"Lcom/tencent/gpudetector/JniGPUDetector$Companion;", "", "()V", "gpuDetailList", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getGpuDetailList", "()Ljava/util/HashMap;", "getArchNameDetail", "arch", "getVersion", "showGpuDeviceModel", "gpudetector_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }

        public final HashMap<Integer, String> getGpuDetailList() {
            AppMethodBeat.i(194404);
            HashMap<Integer, String> hashMap = JniGPUDetector.gpuDetailList;
            AppMethodBeat.o(194404);
            return hashMap;
        }

        public final String showGpuDeviceModel() {
            AppMethodBeat.i(194405);
            GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
            if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
                kotlin.g.b.ae aeVar = kotlin.g.b.ae.SYK;
                String format = String.format("GPU arch: %s\n, code: %d, numCores: %d, perfScore: %d\nvendor: %s\nname: %s\nversion: %s\n", Arrays.copyOf(new Object[]{getArchNameDetail(gpuDeviceModel.getArch()), Integer.valueOf(gpuDeviceModel.getCode()), Integer.valueOf(gpuDeviceModel.getNumCores()), Integer.valueOf(gpuDeviceModel.getPerfScore()), gpuDeviceModel.getVendor(), gpuDeviceModel.getName(), gpuDeviceModel.getVersion()}, 7));
                p.g(format, "java.lang.String.format(format, *args)");
                AppMethodBeat.o(194405);
                return format;
            }
            AppMethodBeat.o(194405);
            return "Failed to detect GPU";
        }

        public final String getArchNameDetail(int i2) {
            AppMethodBeat.i(194406);
            String str = i2 + '(' + getGpuDetailList().get(Integer.valueOf(i2)) + ')';
            AppMethodBeat.o(194406);
            return str;
        }

        public final String getVersion() {
            return "1.0.0-23";
        }
    }

    static {
        AppMethodBeat.i(194415);
        System.loadLibrary("GPUDetector");
        AppMethodBeat.o(194415);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, hxF = {"Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "", "()V", "arch", "", "getArch", "()I", "setArch", "(I)V", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "getCode", "setCode", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "numCores", "getNumCores", "setNumCores", "perfScore", "getPerfScore", "setPerfScore", "vendor", "getVendor", "setVendor", "version", "getVersion", "setVersion", "gpudetector_release"})
    public static final class GpuDeviceModel {
        private int arch;
        private int code;
        private String name = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        private int numCores;
        private int perfScore;
        private String vendor = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        private String version = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;

        public final int getArch() {
            return this.arch;
        }

        public final void setArch(int i2) {
            this.arch = i2;
        }

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int i2) {
            this.code = i2;
        }

        public final int getNumCores() {
            return this.numCores;
        }

        public final void setNumCores(int i2) {
            this.numCores = i2;
        }

        public final int getPerfScore() {
            return this.perfScore;
        }

        public final void setPerfScore(int i2) {
            this.perfScore = i2;
        }

        public final String getVendor() {
            return this.vendor;
        }

        public final void setVendor(String str) {
            AppMethodBeat.i(194407);
            p.h(str, "<set-?>");
            this.vendor = str;
            AppMethodBeat.o(194407);
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            AppMethodBeat.i(194408);
            p.h(str, "<set-?>");
            this.name = str;
            AppMethodBeat.o(194408);
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            AppMethodBeat.i(194409);
            p.h(str, "<set-?>");
            this.version = str;
            AppMethodBeat.o(194409);
        }
    }

    public final String getGpuArchInfo() {
        AppMethodBeat.i(194410);
        GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
        if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
            String archNameDetail = Companion.getArchNameDetail(gpuDeviceModel.getArch());
            AppMethodBeat.o(194410);
            return archNameDetail;
        }
        String archNameDetail2 = Companion.getArchNameDetail(-1);
        AppMethodBeat.o(194410);
        return archNameDetail2;
    }

    public final int getGpuCodeInfo() {
        AppMethodBeat.i(194411);
        GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
        if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
            int code = gpuDeviceModel.getCode();
            AppMethodBeat.o(194411);
            return code;
        }
        AppMethodBeat.o(194411);
        return -1;
    }

    public final int getGpuCoreSumInfo() {
        AppMethodBeat.i(194412);
        GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
        if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
            int numCores = gpuDeviceModel.getNumCores();
            AppMethodBeat.o(194412);
            return numCores;
        }
        AppMethodBeat.o(194412);
        return -1;
    }

    public final int getGpuPerfScoreInfo() {
        AppMethodBeat.i(194413);
        GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
        if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
            int perfScore = gpuDeviceModel.getPerfScore();
            AppMethodBeat.o(194413);
            return perfScore;
        }
        AppMethodBeat.o(194413);
        return -1;
    }

    public final int[] getGpuInfo() {
        AppMethodBeat.i(194414);
        GpuDeviceModel gpuDeviceModel = new GpuDeviceModel();
        if (new JniGPUDetector().GetGPUDeviceModel(gpuDeviceModel)) {
            int[] iArr = {gpuDeviceModel.getArch(), gpuDeviceModel.getCode(), gpuDeviceModel.getNumCores()};
        }
        AppMethodBeat.o(194414);
        return null;
    }
}
