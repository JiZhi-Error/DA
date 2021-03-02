package com.tencent.mm.plugin.scanner.model;

import android.content.SharedPreferences;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0007J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\u0013H\u0007J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\rH\u0007J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\rH\u0007J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\tH\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\t2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010-\u001a\u0002012\u0006\u00102\u001a\u00020\tH\u0007J$\u00103\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u00104\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0007J\b\u00105\u001a\u00020\u0016H\u0007J\b\u00106\u001a\u00020\u0016H\u0007J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u000209H\u0007J\u0018\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004H\u0007J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\t2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0004H\u0007J\u0010\u0010@\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\tH\u0007J:\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\rH\u0007J\u0010\u0010J\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "KEY_SCAN_CONFIG_GUIDE_WORDING", "", "KEY_SCAN_CONFIG_LAST_UPDATE_TIME_SUFFIX", "TAG", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "checkAndUpdateScanConfig", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "getScanConfigGuideWording", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "width", "height", "cameraRotation", "usingAI", "initMMKV", "initNetSpeed", "needUpdateScanConfig", "type", "onUpdateScanConfigSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "saveUpdateScanConfigTime", AppMeasurement.Param.TIMESTAMP, "", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "plugin-scan_release"})
public final class x {
    private static ScanFastFocusEngineNative CGb = new ScanFastFocusEngineNative();
    private static int CGc = -1;
    private static boolean CGd;
    private static boolean CGe;
    private static ae CGf = new ae();
    public static final x CGg = new x();
    private static MultiProcessMMKV cQe;
    private static int count;
    private static boolean isInit;

    static {
        AppMethodBeat.i(52213);
        String str = z.aTY() + "_scan_config_mmkv";
        cQe = MultiProcessMMKV.getMMKV(str);
        Log.v("MicroMsg.ScanFastFocusEngineManager", "initMMKV key: %s", str);
        AppMethodBeat.o(52213);
    }

    private x() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int d(int r12, int r13, int r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.x.d(int, int, int, boolean):int");
    }

    public static final ScanFastFocusEngineNative process(byte[] bArr, int i2, int i3) {
        Integer num;
        byte[] bArr2;
        Integer num2 = null;
        AppMethodBeat.i(52203);
        p.h(bArr, "imageData");
        if (isInit) {
            long currentTimeMillis = System.currentTimeMillis();
            CGb.resetStatus();
            ScanFastFocusEngineNative process = CGb.process(bArr, i2, i3);
            long currentTimeMillis2 = System.currentTimeMillis();
            Object[] objArr = new Object[5];
            if (process != null) {
                num = Integer.valueOf(process.result);
            } else {
                num = null;
            }
            objArr[0] = num;
            objArr[1] = Long.valueOf(currentTimeMillis2 - currentTimeMillis);
            objArr[2] = process != null ? Integer.valueOf(process.width) : null;
            objArr[3] = process != null ? Integer.valueOf(process.height) : null;
            if (!(process == null || (bArr2 = process.bestImageData) == null)) {
                num2 = Integer.valueOf(bArr2.length);
            }
            objArr[4] = num2;
            Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", objArr);
            AppMethodBeat.o(52203);
            return process;
        }
        AppMethodBeat.o(52203);
        return null;
    }

    public static final ae ePX() {
        Integer num = null;
        AppMethodBeat.i(52204);
        if (isInit) {
            CGf.points = CGb.getPointObjects();
            CGf.pointCount = CGb.pointCount;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(CGf.pointCount);
            objArr[1] = Integer.valueOf(CGf.hashCode());
            ScanPoint[] scanPointArr = CGf.points;
            if (scanPointArr != null) {
                num = Integer.valueOf(scanPointArr.hashCode());
            }
            objArr[2] = num;
            Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", objArr);
            ae aeVar = CGf;
            AppMethodBeat.o(52204);
            return aeVar;
        }
        AppMethodBeat.o(52204);
        return null;
    }

    public static final z a(mw mwVar, int i2) {
        ScanFrameProcessResult scanFrameProcessResult;
        AppMethodBeat.i(52205);
        p.h(mwVar, "response");
        z zVar = new z();
        if (mwVar != null) {
            zVar.dDL = mwVar.dNQ;
            zVar.jumpType = mwVar.KRs;
            zVar.CGk = mwVar.KRt;
            zVar.CGl = mwVar.KRu;
            zVar.twt = mwVar.KRv;
            zVar.CGm = mwVar.KRw;
            zVar.sessionId = mwVar.KRi;
            zVar.CGn = mwVar.KRh;
            zVar.CGo = mwVar.KRy;
        }
        if (mwVar.KRw != null) {
            if (i2 == 1) {
                float f2 = mwVar.KRw.relative_minx;
                float f3 = mwVar.KRw.relative_miny;
                float f4 = mwVar.KRw.relative_maxx;
                float f5 = mwVar.KRw.relative_maxy;
                int i3 = mwVar.KRh;
                boolean z = mwVar.KRx;
                if (isInit) {
                    Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i3), Boolean.valueOf(z));
                    scanFrameProcessResult = CGb.shouldJump(f2, f3, f4, f5, i3, z);
                } else {
                    scanFrameProcessResult = null;
                }
                if (scanFrameProcessResult != null) {
                    zVar.CGj = scanFrameProcessResult.shouldJump;
                    zVar.centerX = (scanFrameProcessResult.minX + scanFrameProcessResult.maxX) / 2.0f;
                    zVar.centerY = (scanFrameProcessResult.maxY + scanFrameProcessResult.minY) / 2.0f;
                }
            } else if (i2 == 2) {
                zVar.CGj = true;
                zVar.centerX = (mwVar.KRw.relative_minx + mwVar.KRw.relative_maxx) / 2.0f;
                zVar.centerY = (mwVar.KRw.relative_miny + mwVar.KRw.relative_maxy) / 2.0f;
            }
            zVar.centerX = Math.max(0.0f, zVar.centerX);
            zVar.centerX = Math.min(1.0f, zVar.centerX);
            zVar.centerY = Math.max(0.0f, zVar.centerY);
            zVar.centerY = Math.min(1.0f, zVar.centerY);
            Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", Float.valueOf(zVar.centerX), Float.valueOf(zVar.centerY));
        }
        AppMethodBeat.o(52205);
        return zVar;
    }

    public static final GoodsObject ePY() {
        AppMethodBeat.i(52206);
        if (isInit) {
            Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", Float.valueOf(CGb.cropObject.relative_minx), Float.valueOf(CGb.cropObject.relative_maxx), Float.valueOf(CGb.cropObject.relative_miny), Float.valueOf(CGb.cropObject.relative_maxy));
            GoodsObject goodsObject = CGb.cropObject;
            AppMethodBeat.o(52206);
            return goodsObject;
        }
        AppMethodBeat.o(52206);
        return null;
    }

    public static final boolean isAICrop() {
        return CGe;
    }

    public static final boolean isUsingAI() {
        return CGd;
    }

    public static final void reset() {
        AppMethodBeat.i(52207);
        if (isInit) {
            Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
            CGb.reset();
        }
        AppMethodBeat.o(52207);
    }

    public static final void release() {
        AppMethodBeat.i(52208);
        if (isInit) {
            Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
            CGb.nativeRelease();
            isInit = false;
        }
        AppMethodBeat.o(52208);
    }

    public static final void ePZ() {
        AppMethodBeat.i(52209);
        if (CGc != 0) {
            a(new b());
        }
        AppMethodBeat.o(52209);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements y {
        final /* synthetic */ int CGi = 0;

        b() {
        }

        public final void run() {
            AppMethodBeat.i(52199);
            Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", Integer.valueOf(this.CGi));
            x xVar = x.CGg;
            x.CGc = this.CGi;
            x xVar2 = x.CGg;
            x.CGb.setServerState(this.CGi);
            AppMethodBeat.o(52199);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements y {
        final /* synthetic */ String CGh;

        a(String str) {
            this.CGh = str;
        }

        public final void run() {
            AppMethodBeat.i(52198);
            x xVar = x.CGg;
            if (x.isInit) {
                x xVar2 = x.CGg;
                x.CGb.setConfig(this.CGh);
            }
            AppMethodBeat.o(52198);
        }
    }

    public static final String getReportString() {
        AppMethodBeat.i(52211);
        if (isInit) {
            String reportString = CGb.getReportString();
            AppMethodBeat.o(52211);
            return reportString;
        }
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
        AppMethodBeat.o(52211);
        return null;
    }

    public static final ScanImagePHashInfo M(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(240423);
        p.h(bArr, "imageData");
        ScanImagePHashInfo computeImagePHash = CGb.computeImagePHash(bArr, i2, i3, false);
        AppMethodBeat.o(240423);
        return computeImagePHash;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
    public static final class c implements w.a {
        final /* synthetic */ int $type;

        c(int i2) {
            this.$type = i2;
        }

        @Override // com.tencent.mm.plugin.scanner.model.w.a
        public final void a(clg clg) {
            AppMethodBeat.i(52200);
            if (clg == null) {
                AppMethodBeat.o(52200);
                return;
            }
            Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", Integer.valueOf(clg.type), clg.version, clg.MqB);
            x xVar = x.CGg;
            x.a(this.$type, clg);
            AppMethodBeat.o(52200);
        }

        @Override // com.tencent.mm.plugin.scanner.model.w.a
        public final void p(int i2, int i3, String str) {
            AppMethodBeat.i(52201);
            Log.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(52201);
        }
    }

    private static void Ww(int i2) {
        AppMethodBeat.i(240424);
        Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", Integer.valueOf(i2));
        w.a(i2, new c(i2));
        AppMethodBeat.o(240424);
    }

    public static final String eQa() {
        String str;
        AppMethodBeat.i(240425);
        MultiProcessMMKV multiProcessMMKV = cQe;
        if (multiProcessMMKV == null || (str = multiProcessMMKV.getString("scan_config_guide_wording", "")) == null) {
            str = "";
        }
        p.g(str, "mmkv?.getString(KEY_SCAN…_GUIDE_WORDING, \"\") ?: \"\"");
        try {
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            JSONObject jSONObject = new JSONObject(str);
            Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanConfigGuideWording currentLanguage: %s", applicationLanguage);
            if (applicationLanguage != null) {
                switch (applicationLanguage.hashCode()) {
                    case 3241:
                        if (applicationLanguage.equals(LocaleUtil.ENGLISH)) {
                            String optString = jSONObject.optString("desc_english");
                            AppMethodBeat.o(240425);
                            return optString;
                        }
                        break;
                    case 115861276:
                        if (applicationLanguage.equals(LocaleUtil.CHINA)) {
                            String optString2 = jSONObject.optString("desc_chinese");
                            AppMethodBeat.o(240425);
                            return optString2;
                        }
                        break;
                }
            }
            AppMethodBeat.o(240425);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", e2, "getScanConfigGuideWording exception", new Object[0]);
            AppMethodBeat.o(240425);
            return null;
        }
    }

    public static final void a(y yVar) {
        AppMethodBeat.i(52212);
        p.h(yVar, "task");
        count++;
        Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", Integer.valueOf(count));
        h.RTc.b(yVar, "AiScanImageDecodeQueue_decode_task");
        AppMethodBeat.o(52212);
    }

    public static final void a(y yVar, String str) {
        AppMethodBeat.i(161055);
        p.h(yVar, "task");
        p.h(str, "tag");
        h.RTc.b(yVar, str);
        AppMethodBeat.o(161055);
    }

    public static final /* synthetic */ void a(int i2, clg clg) {
        boolean z;
        MultiProcessMMKV multiProcessMMKV;
        SharedPreferences.Editor putString;
        SharedPreferences.Editor putLong;
        AppMethodBeat.i(240426);
        if (i2 == 2) {
            String str = clg.MqB;
            p.g(str, "response.conf_str");
            p.h(str, "config");
            a(new a(str));
            AppMethodBeat.o(240426);
            return;
        }
        if (i2 == 3) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.ScanFastFocusEngineManager", "saveUpdateScanConfigTime type: %d, timestamp: %d", Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            MultiProcessMMKV multiProcessMMKV2 = cQe;
            if (!(multiProcessMMKV2 == null || (putLong = multiProcessMMKV2.putLong("scan_config_last_update_".concat(String.valueOf(i2)), currentTimeMillis)) == null)) {
                putLong.apply();
            }
            String str2 = clg.MqB;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!(z || (multiProcessMMKV = cQe) == null || (putString = multiProcessMMKV.putString("scan_config_guide_wording", clg.MqB)) == null)) {
                putString.apply();
                AppMethodBeat.o(240426);
                return;
            }
        }
        AppMethodBeat.o(240426);
    }
}
