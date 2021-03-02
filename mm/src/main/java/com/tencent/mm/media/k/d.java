package com.tencent.mm.media.k;

import android.content.SharedPreferences;
import android.os.HandlerThread;
import com.eclipsesource.a.e;
import com.tencent.gpudetector.JniGPUDetector;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJH\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "saveGpuDetectorVersion", "saveGpuDeviceModel", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "saveGpuRating", "Companion", "plugin-mediaeditor_release"})
public final class d {
    public static final a ilx = new a((byte) 0);
    public MMHandler handler;
    private HandlerThread igZ;
    private c.b ilw;

    public static final int aNd() {
        AppMethodBeat.i(218810);
        int aNd = ilx.aNd();
        AppMethodBeat.o(218810);
        return aNd;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\rH\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_DETECTOR_VERSION", "", "GPU_INFO_DEVICE_MODEL", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "KV_NAME", "TAG", "checkGpuDetectorVersionFormSharePreference", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "spToMMKV", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final int aNe() {
            int i2;
            AppMethodBeat.i(218796);
            try {
                i2 = aNg();
                String aNi = aNi();
                String version = JniGPUDetector.Companion.getVersion();
                if (i2 == -1 || aNi == null || (!p.j(version, version))) {
                    new d().aNb();
                }
            } catch (Exception e2) {
                Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(e2)), new Object[0]);
                i2 = -1;
            }
            AppMethodBeat.o(218796);
            return i2;
        }

        public final int aNd() {
            int i2;
            AppMethodBeat.i(218797);
            try {
                i2 = aNg();
                if (i2 == -1) {
                    new d().aNb();
                }
            } catch (Exception e2) {
                Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(e2)), new Object[0]);
                i2 = -1;
            }
            AppMethodBeat.o(218797);
            return i2;
        }

        public final String aNf() {
            String str;
            AppMethodBeat.i(218798);
            try {
                str = aNh();
                if (str == null) {
                    new d().aNb();
                }
            } catch (Exception e2) {
                Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(e2)), new Object[0]);
                str = null;
            }
            AppMethodBeat.o(218798);
            return str;
        }

        static int aNg() {
            AppMethodBeat.i(218799);
            int i2 = VQ().getInt("gpu_info_rating", -1);
            if (i2 == -1) {
                aNj();
            }
            AppMethodBeat.o(218799);
            return i2;
        }

        static String aNh() {
            AppMethodBeat.i(218800);
            String string = VQ().getString("gpu_info_device_model", null);
            String str = string;
            if (str == null || str.length() == 0) {
                aNj();
            }
            AppMethodBeat.o(218800);
            return string;
        }

        static String aNi() {
            AppMethodBeat.i(218801);
            String string = VQ().getString("gpu_detector_version", null);
            String str = string;
            if (str == null || str.length() == 0) {
                aNj();
            }
            AppMethodBeat.o(218801);
            return string;
        }

        static MultiProcessMMKV VQ() {
            AppMethodBeat.i(218802);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gpu_info");
            p.g(mmkv, "MultiProcessMMKV.getMMKV(KV_NAME)");
            AppMethodBeat.o(218802);
            return mmkv;
        }

        private static void aNj() {
            boolean z;
            AppMethodBeat.i(218803);
            MultiProcessMMKV VQ = VQ();
            try {
                Log.i("MicroMsg.GpuDetectorUtil", "spToMMKV: ");
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                int i2 = sharedPreferences.getInt("gpu_info_rating", -1);
                if (i2 != -1) {
                    VQ.putInt("gpu_info_rating", i2);
                }
                String string = sharedPreferences.getString("gpu_info_device_model", null);
                String str = string;
                if (!(str == null || str.length() == 0)) {
                    VQ.putString("gpu_info_device_model", string);
                }
                String string2 = sharedPreferences.getString("gpu_detector_version", null);
                String str2 = string2;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    VQ.putString("gpu_detector_version", string2);
                    AppMethodBeat.o(218803);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.GpuDetectorUtil", e2, "", new Object[0]);
            }
            AppMethodBeat.o(218803);
        }
    }

    static {
        AppMethodBeat.i(218808);
        ilx.getClass().getClassLoader();
        j.Ed("GPUDetector");
        AppMethodBeat.o(218808);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ d ily;

        b(d dVar) {
            this.ily = dVar;
        }

        public final void run() {
            AppMethodBeat.i(218805);
            this.ily.ilw = c.a.a(c.ilt, null, 1, 1, null, 16);
            d.aNc();
            MMHandler mMHandler = this.ily.handler;
            if (mMHandler != null) {
                mMHandler.removeCallbacksAndMessages(null);
            }
            MMHandler mMHandler2 = this.ily.handler;
            if (mMHandler2 != null) {
                mMHandler2.post(new Runnable(this) {
                    /* class com.tencent.mm.media.k.d.b.AnonymousClass1 */
                    final /* synthetic */ b ilz;

                    {
                        this.ilz = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(218804);
                        if (this.ilz.ily.ilw != null) {
                            c.a aVar = c.ilt;
                            c.b bVar = this.ilz.ily.ilw;
                            if (bVar == null) {
                                p.hyc();
                            }
                            c.a.a(bVar);
                        }
                        HandlerThread handlerThread = this.ilz.ily.igZ;
                        if (handlerThread != null) {
                            handlerThread.quitSafely();
                            AppMethodBeat.o(218804);
                            return;
                        }
                        AppMethodBeat.o(218804);
                    }
                });
                AppMethodBeat.o(218805);
                return;
            }
            AppMethodBeat.o(218805);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ d ily;

        public c(d dVar) {
            this.ily = dVar;
        }

        public final void run() {
            AppMethodBeat.i(218806);
            if (this.ily.ilw != null) {
                c.a aVar = c.ilt;
                c.b bVar = this.ily.ilw;
                if (bVar == null) {
                    p.hyc();
                }
                c.a.a(bVar);
            }
            HandlerThread handlerThread = this.ily.igZ;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                AppMethodBeat.o(218806);
                return;
            }
            AppMethodBeat.o(218806);
        }
    }

    public final void aNb() {
        AppMethodBeat.i(218807);
        try {
            if (a.aNg() == -1 || a.aNh() == null || a.aNi() == null || (!p.j(JniGPUDetector.Companion.getVersion(), a.aNi()))) {
                this.igZ = com.tencent.f.c.d.hC("GpuDetectorUtil", 5);
                HandlerThread handlerThread = this.igZ;
                if (handlerThread != null) {
                    handlerThread.start();
                }
                HandlerThread handlerThread2 = this.igZ;
                this.handler = new MMHandler(handlerThread2 != null ? handlerThread2.getLooper() : null);
                MMHandler mMHandler = this.handler;
                if (mMHandler != null) {
                    mMHandler.post(new b(this));
                    AppMethodBeat.o(218807);
                    return;
                }
                AppMethodBeat.o(218807);
                return;
            }
            Log.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
            AppMethodBeat.o(218807);
        } catch (Exception e2) {
            Log.printInfoStack("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(e2)), new Object[0]);
            AppMethodBeat.o(218807);
        }
    }

    public static final /* synthetic */ void aNc() {
        AppMethodBeat.i(218809);
        try {
            JniGPUDetector.GpuDeviceModel gpuDeviceModel = new JniGPUDetector.GpuDeviceModel();
            JniGPUDetector jniGPUDetector = new JniGPUDetector();
            if (jniGPUDetector.GetGPUDeviceModel(gpuDeviceModel)) {
                int arch = gpuDeviceModel.getArch();
                int code = gpuDeviceModel.getCode();
                int numCores = gpuDeviceModel.getNumCores();
                String name = gpuDeviceModel.getName();
                String vendor = gpuDeviceModel.getVendor();
                String version = gpuDeviceModel.getVersion();
                int gpuPerfScoreInfo = jniGPUDetector.getGpuPerfScoreInfo();
                String archNameDetail = JniGPUDetector.Companion.getArchNameDetail(gpuDeviceModel.getArch());
                h.INSTANCE.a(20128, true, true, Integer.valueOf(arch), Integer.valueOf(code), Integer.valueOf(numCores), name, vendor, version, Integer.valueOf(gpuPerfScoreInfo), archNameDetail);
                a.VQ().putInt("gpu_info_rating", jniGPUDetector.getGpuPerfScoreInfo());
                a.VQ().putString("gpu_detector_version", JniGPUDetector.Companion.getVersion());
                e eVar = new e();
                eVar.g("arch", String.valueOf(gpuDeviceModel.getArch()));
                eVar.g(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, String.valueOf(gpuDeviceModel.getCode()));
                eVar.g("numCores", String.valueOf(gpuDeviceModel.getNumCores()));
                eVar.g("name", gpuDeviceModel.getName());
                eVar.g("vendor", gpuDeviceModel.getVendor());
                eVar.g("version", gpuDeviceModel.getVersion());
                eVar.g("archDetail", JniGPUDetector.Companion.getArchNameDetail(gpuDeviceModel.getArch()));
                a.VQ().putString("gpu_info_device_model", eVar.toString());
                AppMethodBeat.o(218809);
                return;
            }
        } catch (Exception e2) {
            Log.printInfoStack("MicroMsg.GpuDetectorUtil", "Failed to detect GPU ".concat(String.valueOf(e2)), new Object[0]);
        }
        AppMethodBeat.o(218809);
    }
}
