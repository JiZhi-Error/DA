package com.tencent.mm.plugin.scanner.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.WxQBarResult;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004tuvwB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J\b\u0010*\u001a\u00020'H\u0007J\u0018\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH\u0007J \u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u001bH\u0007J*\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u0019H\u0007J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017022\b\u00103\u001a\u0004\u0018\u000104J\u0012\u00105\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u0004H\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020\u0004H\u0007J\b\u00107\u001a\u00020\u0017H\u0007J\u0010\u00108\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0012\u00109\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010;\u001a\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0012\u0010<\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000104H\u0007J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004H\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0004H\u0003J\u0010\u0010A\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J\u001a\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u00042\b\b\u0002\u0010D\u001a\u00020\u0004H\u0007J\b\u0010E\u001a\u00020'H\u0007J\b\u0010F\u001a\u00020'H\u0007J\u001a\u0010G\u001a\u00020'2\u0006\u0010C\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u0004H\u0007J(\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u001bH\u0007J\b\u0010M\u001a\u00020'H\u0007J\b\u0010N\u001a\u00020'H\u0007J\u0010\u0010O\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J \u0010P\u001a\u00020'2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u0019H\u0007J(\u0010R\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0007J\u0018\u0010T\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0019H\u0007J\"\u0010T\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010\u00172\u0006\u0010U\u001a\u00020\u0019H\u0002J\u0010\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020YH\u0007J\u0010\u0010Z\u001a\u00020'2\u0006\u0010X\u001a\u00020YH\u0007J\u0018\u0010[\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0004H\u0007J2\u0010\\\u001a\u00020'2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010^\u001a\u00020\u0004H\u0007J\u0018\u0010_\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0004H\u0007J\u0018\u0010a\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0004H\u0007J*\u0010b\u001a\u00020'2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010c\u001a\u00020\u0004H\u0007J\u0010\u0010d\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J*\u0010e\u001a\u00020'2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000104H\u0007J\u0010\u0010g\u001a\u00020'2\u0006\u0010I\u001a\u00020\u0004H\u0007J\u0010\u0010h\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J\u0010\u0010i\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007J\b\u0010j\u001a\u00020'H\u0007J\u0010\u0010k\u001a\u00020'2\u0006\u0010l\u001a\u00020\u0019H\u0007J(\u0010m\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u000e\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0o2\u0006\u0010q\u001a\u00020\u001bH\u0007J\u0018\u0010r\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH\u0007J\u0018\u0010s\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0\u001fj\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 `!X\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u001fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R*\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u001fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`!X\u000e¢\u0006\u0002\n\u0000R*\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`!X\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanReporter;", "", "()V", "EVENT_TYPE_ENTER", "", "EVENT_TYPE_EXIT", "REPORT_CODE_TYPE_BLACK", "REPORT_CODE_TYPE_OTHER", "REPORT_CODE_TYPE_WX_PAY", "RESULT_OP_TYPE_CANCEL_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_CLICK_JUMP_SCAN_GOODS", "RESULT_OP_TYPE_DIRECT_JUMP_SINGLE_CODE_RESULT", "RESULT_OP_TYPE_JUMP_SCAN_GOODS_SUCCESS", "RESULT_OP_TYPE_SHOW_JUMP_SCAN_GOODS_TIPS", "RESULT_OP_TYPE_USER_CANCEL", "RESULT_OP_TYPE_USER_CLICK", "SCAN_OP_CLICK_FLASH", "SCAN_OP_DOUBLE_CLICK_FOCUS", "SCAN_OP_SCROLL_FOCUS", "SCAN_OP_SHOW_FLASH", "TAB_STATUS_START", "TAB_STATUS_STOP", "TAG", "", "hasCameraPermission", "", "lastEnterScanUITimestamp", "", "multiCodeReportInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "scanReportInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "Lkotlin/collections/HashMap;", "scanSessionMap", "session", "tabSessionMap", "tabStatus", "createScanSession", "", "tabId", "createTabSession", "createUISession", "dismissScanResult", AppMeasurement.Param.TIMESTAMP, "finishScanGoods", "source", "success", "isCancelled", "getBizInfo", "Lkotlin/Pair;", "scanRequest", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "getCurrentScanSession", "getCurrentTabSession", "getCurrentUISession", "getImageSource", "getReportCodeType", "data", "getReportInfo", "getScanGoodsReportScene", "getTabAction", "tabSelectedAction", "getTabType", "isScanCode", "reportCancelGallery", "reportMultiCode", "resultOpType", "chooseIndex", "reportMultiCodeCancel", "reportMultiCodeClick", "reportMultiCodeOp", "reportOnPreviewFrameCalled", "retryType", "isRetry", "called", "stayTime", "reportOnPreviewFrameDataNull", "reportOnPreviewFrameNotCalled", "reportOpenGallery", "reportRetryScanResult", "scanSuccess", "reportScanCodeResult", "codeResultSize", "reportScanFocusEngineReportInfo", "hasResult", "reportString", "reportScanGoodsResourceDecodeFailed", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "reportScanGoodsResourceNotValid", "reportScanGoodsResult", "reportScanGoodsSuccessResult", "scene", "result", "reportScanOperation", "op", "reportScanTabSelected", "reportScanUIEvent", "eventType", "reportSelectImageFromGallery", "reportShowScanResultTime", "exitType", "reportStartRetry", "reportStartScan", "reportStopScan", "reportTakeOneShotNotCalled", "setCameraPermission", "has", "setMultiCodeReportInfo", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "showScanResult", "startScanGoods", "ScanGoodsResult", "ScanGoodsScene", "ScanMultiCodeReportInfo", "ScanReportInfo", "plugin-scan_release"})
public final class af {
    private static HashMap<Integer, String> CGL = new HashMap<>();
    private static HashMap<Integer, String> CGM = new HashMap<>();
    private static HashMap<Integer, Integer> CGN = new HashMap<>();
    private static HashMap<String, b> CGO = new HashMap<>();
    private static boolean CGP;
    private static a CGQ;
    private static long CGR;
    public static final af CGS = new af();
    private static String dRM = "";

    static {
        AppMethodBeat.i(52238);
        AppMethodBeat.o(52238);
    }

    private af() {
    }

    public static final void eQg() {
        AppMethodBeat.i(52220);
        dRM = String.valueOf(System.currentTimeMillis());
        AppMethodBeat.o(52220);
    }

    public static final String eQh() {
        return dRM;
    }

    public static final void hZ(int i2, int i3) {
        int i4;
        AppMethodBeat.i(52221);
        if (dRM.length() == 0) {
            AppMethodBeat.o(52221);
            return;
        }
        int JH = JH(i2);
        switch (i3) {
            case 0:
                i4 = 0;
                break;
            case 1:
                i4 = 3;
                break;
            case 2:
                i4 = 2;
                break;
            case 3:
                i4 = 1;
                break;
            case 4:
                i4 = 4;
                break;
            default:
                i4 = -1;
                break;
        }
        Log.d("MicroMsg.ScanReporter", "alvinluo reportScanTabSelected logId: %d, tabType: %d, tabAction: %d, session: %s", 18557, Integer.valueOf(JH), Integer.valueOf(i4), dRM);
        h.INSTANCE.a(18557, 0, Integer.valueOf(JH), Integer.valueOf(i4), dRM);
        AppMethodBeat.o(52221);
    }

    public static final void Wy(int i2) {
        AppMethodBeat.i(52222);
        CGM.put(Integer.valueOf(i2), String.valueOf(System.currentTimeMillis()));
        Log.d("MicroMsg.ScanReporter", "alvinluo createTabSession tabId: %d, session: %s", Integer.valueOf(i2), CGM.get(Integer.valueOf(i2)));
        AppMethodBeat.o(52222);
    }

    public static final String Wz(int i2) {
        AppMethodBeat.i(240463);
        String str = CGM.get(Integer.valueOf(i2));
        AppMethodBeat.o(240463);
        return str;
    }

    public static final void WA(int i2) {
        boolean z;
        AppMethodBeat.i(52224);
        if (i2 == 12 || WJ(i2)) {
            CGL.put(Integer.valueOf(i2), String.valueOf(System.currentTimeMillis()));
            Log.d("MicroMsg.ScanReporter", "alvinluo createScanSession tabId: %d, session: %s", Integer.valueOf(i2), CGL.get(Integer.valueOf(i2)));
            String str = CGM.get(Integer.valueOf(i2));
            String str2 = CGL.get(Integer.valueOf(i2));
            if (str != null) {
                if (str.length() > 0) {
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            String str3 = str + "," + str2;
                            b bVar = CGO.get(str3);
                            if (bVar == null) {
                                b bVar2 = new b();
                                bVar2.aMB(str);
                                bVar2.aMC(str2);
                                CGO.put(str3, bVar2);
                                AppMethodBeat.o(52224);
                                return;
                            }
                            bVar.CHa = "";
                            bVar.CHb = "";
                            bVar.CHc = 0;
                            bVar.CHd = 0;
                            bVar.CHe = 0;
                            bVar.gmJ = 0;
                            bVar.CHf = 0;
                            bVar.CHg = 0;
                            bVar.wNg = 0;
                            bVar.source = 0;
                            bVar.CHh = false;
                            bVar.aMB(str);
                            bVar.aMC(str2);
                        }
                    } else {
                        AppMethodBeat.o(52224);
                        return;
                    }
                }
                AppMethodBeat.o(52224);
                return;
            }
            AppMethodBeat.o(52224);
            return;
        }
        AppMethodBeat.o(52224);
    }

    public static final String WB(int i2) {
        AppMethodBeat.i(240464);
        String str = CGL.get(Integer.valueOf(i2));
        AppMethodBeat.o(240464);
        return str;
    }

    public static final void a(int i2, int i3, BaseScanRequest baseScanRequest, int i4) {
        AppMethodBeat.i(240465);
        String str = CGM.get(12);
        String str2 = CGL.get(12);
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                int WC = WC(i3);
                o<String, String> b2 = b(baseScanRequest);
                Log.d("MicroMsg.ScanReporter", "alvinluo reportScanGoodsSuccessResult logId: %d, scene: %d, tabId: %d, tabSession: %s, scanSession: %s, imageSource: %s, result: %d", 18558, Integer.valueOf(i2), 12, str, str2, Integer.valueOf(WC), Integer.valueOf(i4));
                h.INSTANCE.a(18558, str, str2, Integer.valueOf(WC), Integer.valueOf(i4), Integer.valueOf(i2), b2.first, b2.second, dRM);
                AppMethodBeat.o(240465);
                return;
            }
        }
        AppMethodBeat.o(240465);
    }

    public static final void Iy(long j2) {
        AppMethodBeat.i(52227);
        b eQi = eQi();
        if (eQi != null) {
            eQi.CHc = j2;
        }
        Log.d("MicroMsg.ScanReporter", "alvinluo showScanResult tabId: %d, timestamp: %d", 12, Long.valueOf(j2));
        AppMethodBeat.o(52227);
    }

    public static final void Iz(long j2) {
        AppMethodBeat.i(52228);
        b eQi = eQi();
        if (eQi != null) {
            eQi.CHd = j2;
        }
        Log.d("MicroMsg.ScanReporter", "alvinluo dismissScanResult tabId: %d, timestamp: %d", 12, Long.valueOf(j2));
        AppMethodBeat.o(52228);
    }

    public static final void a(int i2, int i3, BaseScanRequest baseScanRequest) {
        AppMethodBeat.i(240466);
        b eQi = eQi();
        if (eQi == null) {
            AppMethodBeat.o(240466);
            return;
        }
        eQi.gmJ = i3;
        if (eQi.CHd > eQi.CHc) {
            eQi.CHe = eQi.CHd - eQi.CHc;
        }
        if (eQi.CHe > 0) {
            o<String, String> b2 = b(baseScanRequest);
            Log.i("MicroMsg.ScanReporter", "alvinluo reportShowScanResultTime logId: %d, reportInfo: %s, scene: %d, bizId: %s, bizInfo: %s", 18560, eQi, Integer.valueOf(i2), b2.first, b2.second);
            h.INSTANCE.a(18560, eQi.CHa, eQi.CHb, Long.valueOf(eQi.CHc), Long.valueOf(eQi.CHd), Long.valueOf(eQi.CHe), Integer.valueOf(eQi.gmJ), Integer.valueOf(i2), b2.first, b2.second, dRM);
        }
        CGL.put(12, "");
        AppMethodBeat.o(240466);
    }

    public static final void ia(int i2, int i3) {
        AppMethodBeat.i(52230);
        String str = CGM.get(Integer.valueOf(i2));
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(52230);
            return;
        }
        int JH = JH(i2);
        Log.d("MicroMsg.ScanReporter", "alvinluo reportScanOperation logId: %d, tabId: %d, tabType: %d, tabSession: %s, op: %d", 18561, Integer.valueOf(i2), Integer.valueOf(JH), str, Integer.valueOf(i3));
        h.INSTANCE.a(18561, str, Integer.valueOf(JH), Integer.valueOf(i3));
        AppMethodBeat.o(52230);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements y {
        final /* synthetic */ int CHi = 12;
        final /* synthetic */ boolean CHj;

        c(boolean z) {
            this.CHj = z;
        }

        public final void run() {
            AppMethodBeat.i(52219);
            final String reportString = x.getReportString();
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.scanner.model.af.c.AnonymousClass1 */
                final /* synthetic */ c CHk;

                {
                    this.CHk = r1;
                }

                public final void run() {
                    AppMethodBeat.i(52218);
                    af afVar = af.CGS;
                    af.f(this.CHk.CHi, reportString, this.CHk.CHj);
                    AppMethodBeat.o(52218);
                }
            });
            AppMethodBeat.o(52219);
        }
    }

    public static final void tO(boolean z) {
        AppMethodBeat.i(52231);
        x.a(new c(z));
        AppMethodBeat.o(52231);
    }

    public static final void aE(int i2, long j2) {
        AppMethodBeat.i(52232);
        b eQi = eQi();
        if (eQi == null) {
            AppMethodBeat.o(52232);
            return;
        }
        eQi.CHf = j2;
        Log.d("MicroMsg.ScanReporter", "alvinluo startScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, timestamp: %d", Integer.valueOf(eQi.hashCode()), eQi.CHa, eQi.CHb, Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(52232);
    }

    public static final void a(int i2, boolean z, long j2) {
        AppMethodBeat.i(52233);
        a(i2, z, j2, false);
        AppMethodBeat.o(52233);
    }

    public static final void a(int i2, boolean z, long j2, boolean z2) {
        int i3;
        AppMethodBeat.i(52234);
        b eQi = eQi();
        if (eQi == null) {
            AppMethodBeat.o(52234);
            return;
        }
        eQi.CHg = j2;
        eQi.CHh = z;
        eQi.source = WC(i2);
        if (eQi.CHf > 0 && eQi.CHg > 0) {
            eQi.wNg = eQi.CHg - eQi.CHf;
        }
        if (eQi.wNg > 0 || z2) {
            if (z2) {
                i3 = 3;
            } else if (z) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            Log.d("MicroMsg.ScanReporter", "alvinluo finishScanGoods info: %d, tabSession: %s, scanSession: %s, source: %d, success: %b, timestamp: %d, timeCost: %d, result: %d", Integer.valueOf(eQi.hashCode()), eQi.CHa, eQi.CHb, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(eQi.wNg), Integer.valueOf(i3));
            h.INSTANCE.a(18724, eQi.CHa, eQi.CHb, Integer.valueOf(eQi.source), Integer.valueOf(i3), Long.valueOf(eQi.wNg));
        }
        AppMethodBeat.o(52234);
    }

    private static b eQi() {
        boolean z;
        AppMethodBeat.i(52235);
        String str = CGM.get(12);
        String str2 = CGL.get(12);
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && str2 != null) {
                if (str2.length() > 0) {
                    b bVar = CGO.get(str + "," + str2);
                    AppMethodBeat.o(52235);
                    return bVar;
                }
            }
        }
        AppMethodBeat.o(52235);
        return null;
    }

    private static int JH(int i2) {
        switch (i2) {
            case 1:
            case 4:
            case 8:
                return 1;
            case 3:
                return 3;
            case 12:
                return 2;
            default:
                return 0;
        }
    }

    private static int WC(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return -1;
        }
    }

    public static final void eQj() {
        AppMethodBeat.i(52236);
        Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameNotCalled");
        h.INSTANCE.dN(1259, 0);
        AppMethodBeat.o(52236);
    }

    public static final void eQk() {
        AppMethodBeat.i(52237);
        Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameDataNull");
        h.INSTANCE.dN(1259, 1);
        AppMethodBeat.o(52237);
    }

    public static final void eQl() {
        AppMethodBeat.i(161973);
        if (CGP) {
            Log.i("MicroMsg.ScanReporter", "alvinluo reportTakeOneShotNotCalled");
            h.INSTANCE.dN(1259, 2);
        }
        AppMethodBeat.o(161973);
    }

    public static final void WD(int i2) {
        AppMethodBeat.i(161056);
        Log.i("MicroMsg.ScanReporter", "alvinluo reportStartRetry retryType: %d", Integer.valueOf(i2));
        if (i2 == 1) {
            h.INSTANCE.dN(1259, 20);
            h.INSTANCE.dN(1259, 21);
            AppMethodBeat.o(161056);
            return;
        }
        if (i2 == 2) {
            h.INSTANCE.dN(1259, 20);
            h.INSTANCE.dN(1259, 22);
        }
        AppMethodBeat.o(161056);
    }

    public static final void a(int i2, boolean z, boolean z2, long j2) {
        AppMethodBeat.i(161974);
        if (!CGP) {
            Log.w("MicroMsg.ScanReporter", "alvinluo reportonPreviewFramCalled not camera permission and ignore");
            AppMethodBeat.o(161974);
            return;
        }
        Log.i("MicroMsg.ScanReporter", "alvinluo reportOnPreviewFrameCalled retryType: %d, isRetry: %b, called: %b, stayTime: %d", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
        if (z2) {
            h.INSTANCE.dN(1259, 28);
        } else if (j2 >= 0 && j2 < 1000) {
            h.INSTANCE.dN(1259, 23);
        } else if (j2 >= 1000 && j2 < 2000) {
            h.INSTANCE.dN(1259, 24);
        } else if (j2 >= 2000 && j2 < 3000) {
            h.INSTANCE.dN(1259, 25);
        } else if (j2 >= 3000 && j2 < 5000) {
            h.INSTANCE.dN(1259, 26);
        } else if (j2 >= 5000) {
            h.INSTANCE.dN(1259, 27);
        }
        if (z && i2 == 1) {
            if (z2) {
                h.INSTANCE.dN(1259, 36);
                AppMethodBeat.o(161974);
                return;
            } else if (j2 >= 0 && j2 < 1000) {
                h.INSTANCE.dN(1259, 31);
                AppMethodBeat.o(161974);
                return;
            } else if (j2 >= 1000 && j2 < 2000) {
                h.INSTANCE.dN(1259, 32);
                AppMethodBeat.o(161974);
                return;
            } else if (j2 >= 2000 && j2 < 3000) {
                h.INSTANCE.dN(1259, 33);
                AppMethodBeat.o(161974);
                return;
            } else if (j2 >= 3000 && j2 < 5000) {
                h.INSTANCE.dN(1259, 34);
                AppMethodBeat.o(161974);
                return;
            } else if (j2 >= 5000) {
                h.INSTANCE.dN(1259, 35);
            }
        }
        AppMethodBeat.o(161974);
    }

    public static final void i(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(161975);
        Log.i("MicroMsg.ScanReporter", "alvinluo reprotRetryScanResult scanSuccess: %b, isRetry: %b", Boolean.valueOf(z2), Boolean.valueOf(z));
        if (z && i2 == 2) {
            h.INSTANCE.dN(1259, z2 ? 29 : 30);
        }
        AppMethodBeat.o(161975);
    }

    public static final void tP(boolean z) {
        AppMethodBeat.i(161976);
        Log.i("MicroMsg.ScanReporter", "alvinluo setCameraPermission: %b", Boolean.valueOf(z));
        CGP = z;
        AppMethodBeat.o(161976);
    }

    public static final void WE(int i2) {
        Integer num;
        AppMethodBeat.i(170036);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportStartScan tabId: %d", Integer.valueOf(i2));
        if (WJ(i2)) {
            Integer num2 = CGN.get(Integer.valueOf(i2));
            if (num2 == null || num2.intValue() != 1) {
                CGN.put(Integer.valueOf(i2), 1);
                h.INSTANCE.dN(1259, 50);
                AppMethodBeat.o(170036);
                return;
            }
        } else if (i2 == 12 && ((num = CGN.get(Integer.valueOf(i2))) == null || num.intValue() != 1)) {
            CGN.put(Integer.valueOf(i2), 1);
            h.INSTANCE.dN(1259, 100);
        }
        AppMethodBeat.o(170036);
    }

    public static final void WF(int i2) {
        AppMethodBeat.i(170037);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportStopScan tabId: %d", Integer.valueOf(i2));
        if (WJ(i2)) {
            Integer num = CGN.get(Integer.valueOf(i2));
            if (num != null && num.intValue() == 1) {
                CGN.put(Integer.valueOf(i2), 2);
                h.INSTANCE.dN(1259, 51);
                AppMethodBeat.o(170037);
                return;
            }
            Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
            AppMethodBeat.o(170037);
            return;
        }
        if (i2 == 12) {
            Integer num2 = CGN.get(Integer.valueOf(i2));
            if (num2 != null && num2.intValue() == 1) {
                CGN.put(Integer.valueOf(i2), 2);
                h.INSTANCE.dN(1259, 101);
                AppMethodBeat.o(170037);
                return;
            }
            Log.e("MicroMsg.ScanReporter", "alvinluo reportStopScan tab not start or stopped, and ignore");
        }
        AppMethodBeat.o(170037);
    }

    public static final void a(int i2, boolean z, int i3, int i4) {
        h hVar;
        int i5;
        AppMethodBeat.i(170038);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportScanCodeResult tabId: %d, success: %b, source: %d, codeResultSize: %d", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
        if (WJ(i2)) {
            if (i3 == 1) {
                if (z) {
                    h.INSTANCE.dN(1259, 52);
                    if (i4 == 1) {
                        hVar = h.INSTANCE;
                        i5 = 60;
                    } else {
                        if (i4 > 1) {
                            h.INSTANCE.dN(1259, 61);
                        }
                        AppMethodBeat.o(170038);
                        return;
                    }
                }
            } else if (i3 == 2) {
                hVar = h.INSTANCE;
                i5 = z ? 58 : 59;
            }
            hVar.dN(1259, i5);
        }
        AppMethodBeat.o(170038);
    }

    public static final void eQm() {
        AppMethodBeat.i(240467);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeCancel");
        h.INSTANCE.dN(1259, 62);
        AppMethodBeat.o(240467);
    }

    public static final void eQn() {
        AppMethodBeat.i(240468);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCodeClick");
        h.INSTANCE.dN(1259, 63);
        AppMethodBeat.o(240468);
    }

    public static final void T(boolean z, int i2) {
        h hVar;
        int i3;
        AppMethodBeat.i(170039);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportScanGoodsResult success: %b, source: %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (i2 == 1) {
            if (z) {
                hVar = h.INSTANCE;
                i3 = 102;
            }
            AppMethodBeat.o(170039);
        }
        if (i2 == 2) {
            hVar = h.INSTANCE;
            i3 = z ? 106 : 107;
        }
        AppMethodBeat.o(170039);
        hVar.dN(1259, i3);
        AppMethodBeat.o(170039);
    }

    public static final void WG(int i2) {
        AppMethodBeat.i(170040);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportOpenGallery tabId: %d", Integer.valueOf(i2));
        if (WJ(i2)) {
            h.INSTANCE.dN(1259, 55);
            AppMethodBeat.o(170040);
            return;
        }
        if (i2 == 12) {
            h.INSTANCE.dN(1259, 103);
        }
        AppMethodBeat.o(170040);
    }

    public static final void WH(int i2) {
        AppMethodBeat.i(170041);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportCancelGallery tabId: %d", Integer.valueOf(i2));
        if (WJ(i2)) {
            h.INSTANCE.dN(1259, 56);
            AppMethodBeat.o(170041);
            return;
        }
        if (i2 == 12) {
            h.INSTANCE.dN(1259, 104);
        }
        AppMethodBeat.o(170041);
    }

    public static final void WI(int i2) {
        AppMethodBeat.i(170042);
        Log.v("MicroMsg.ScanReporter", "alvinluo reportSelectImageFromGallery tabId: %d", Integer.valueOf(i2));
        if (WJ(i2)) {
            h.INSTANCE.dN(1259, 57);
            AppMethodBeat.o(170042);
            return;
        }
        if (i2 == 12) {
            h.INSTANCE.dN(1259, 105);
        }
        AppMethodBeat.o(170042);
    }

    private static final boolean WJ(int i2) {
        return i2 == 1 || i2 == 8 || i2 == 4;
    }

    public static final void a(int i2, List<? extends WxQBarResult> list, long j2) {
        long currentTimeMillis;
        long currentTimeMillis2;
        AppMethodBeat.i(240469);
        p.h(list, "codeResultList");
        CGQ = new a(list, j2);
        try {
            a aVar = CGQ;
            if (aVar != null) {
                String Wz = Wz(i2);
                if (Wz != null) {
                    currentTimeMillis2 = Long.parseLong(Wz);
                } else {
                    currentTimeMillis2 = System.currentTimeMillis();
                }
                aVar.CGT = currentTimeMillis2;
            }
            a aVar2 = CGQ;
            if (aVar2 != null) {
                String WB = WB(i2);
                if (WB != null) {
                    currentTimeMillis = Long.parseLong(WB);
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
                aVar2.CGU = currentTimeMillis;
            }
            a aVar3 = CGQ;
            if (aVar3 != null) {
                aVar3.CGW = System.currentTimeMillis();
                AppMethodBeat.o(240469);
                return;
            }
            AppMethodBeat.o(240469);
        } catch (Exception e2) {
            AppMethodBeat.o(240469);
        }
    }

    public static final void ib(int i2, int i3) {
        String str;
        AppMethodBeat.i(240470);
        if (CGQ == null) {
            AppMethodBeat.o(240470);
            return;
        }
        Object[] objArr = new Object[5];
        a aVar = CGQ;
        if (aVar == null) {
            p.hyc();
        }
        objArr[0] = Integer.valueOf(aVar.CGY.size());
        a aVar2 = CGQ;
        if (aVar2 == null) {
            p.hyc();
        }
        objArr[1] = Long.valueOf(aVar2.CGT);
        a aVar3 = CGQ;
        if (aVar3 == null) {
            p.hyc();
        }
        objArr[2] = Long.valueOf(aVar3.CGU);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(i2);
        Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result size: %d, tabSession: %d, scanSession: %d, chooseIndex: %d, resultOpType: %d", objArr);
        a aVar4 = CGQ;
        if (aVar4 == null) {
            p.hyc();
        }
        if (!aVar4.gqx) {
            a aVar5 = CGQ;
            if (aVar5 == null) {
                p.hyc();
            }
            aVar5.CGV = i3;
            a aVar6 = CGQ;
            if (aVar6 == null) {
                p.hyc();
            }
            aVar6.gqx = true;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            a aVar7 = CGQ;
            if (aVar7 == null) {
                p.hyc();
            }
            for (T t : aVar7.CGY) {
                if (t != null) {
                    String encode = URLEncoder.encode(((WxQBarResult) t).data, ProtocolPackage.ServerEncoding);
                    p.g(encode, "URLEncoder.encode(codeResult.data, \"utf-8\")");
                    arrayList.add(encode);
                    arrayList2.add(Integer.valueOf(((WxQBarResult) t).priorityLevel));
                    String str2 = ((WxQBarResult) t).typeName;
                    if (str2 == null) {
                        str2 = "";
                    }
                    arrayList3.add(str2);
                }
            }
            a aVar8 = CGQ;
            if (aVar8 == null) {
                p.hyc();
            }
            if (aVar8.CGW > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                a aVar9 = CGQ;
                if (aVar9 == null) {
                    p.hyc();
                }
                str = String.valueOf(currentTimeMillis - aVar9.CGW);
            } else {
                str = "";
            }
            h hVar = h.INSTANCE;
            Object[] objArr2 = new Object[11];
            a aVar10 = CGQ;
            if (aVar10 == null) {
                p.hyc();
            }
            objArr2[0] = Long.valueOf(aVar10.CGU);
            a aVar11 = CGQ;
            if (aVar11 == null) {
                p.hyc();
            }
            objArr2[1] = Integer.valueOf(aVar11.CGY.size());
            String a2 = j.a(arrayList, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCode result: ".concat(String.valueOf(a2)));
            objArr2[2] = a2;
            String a3 = j.a(arrayList2, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode type: ".concat(String.valueOf(a3)));
            objArr2[3] = a3;
            objArr2[4] = Integer.valueOf(i2);
            String str3 = (String) j.L(arrayList, i3);
            if (str3 == null) {
                str3 = "";
            }
            objArr2[5] = str3;
            int i4 = (Integer) j.L(arrayList2, i3);
            if (i4 == null) {
                i4 = 0;
            }
            objArr2[6] = i4;
            a aVar12 = CGQ;
            if (aVar12 == null) {
                p.hyc();
            }
            objArr2[7] = Long.valueOf(aVar12.CGZ);
            a aVar13 = CGQ;
            if (aVar13 == null) {
                p.hyc();
            }
            objArr2[8] = Long.valueOf(aVar13.CGT);
            String a4 = j.a(arrayList3, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
            Log.v("MicroMsg.ScanReporter", "alvinluo reportMultiCode typeName: ".concat(String.valueOf(a4)));
            objArr2[9] = a4;
            objArr2[10] = str;
            hVar.a(19332, objArr2);
        }
        AppMethodBeat.o(240470);
    }

    public static /* synthetic */ void eQo() {
        AppMethodBeat.i(240472);
        ic(6, -1);
        AppMethodBeat.o(240472);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final void ic(int i2, int i3) {
        String str;
        AppMethodBeat.i(240471);
        if (CGQ == null) {
            AppMethodBeat.o(240471);
            return;
        }
        Object[] objArr = new Object[3];
        a aVar = CGQ;
        if (aVar == null) {
            p.hyc();
        }
        objArr[0] = Long.valueOf(aVar.CGT);
        a aVar2 = CGQ;
        if (aVar2 == null) {
            p.hyc();
        }
        objArr[1] = Long.valueOf(aVar2.CGU);
        objArr[2] = Integer.valueOf(i2);
        Log.i("MicroMsg.ScanReporter", "alvinluo reportMultiCodeOp tabSession:  %d, scanSession: %d, resultOpType: %d", objArr);
        if (i2 == 4) {
            a aVar3 = CGQ;
            if (aVar3 == null) {
                p.hyc();
            }
            aVar3.CGX = System.currentTimeMillis();
        }
        if (i2 == 6 || i2 == 5) {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar4 = CGQ;
            if (aVar4 == null) {
                p.hyc();
            }
            str = String.valueOf(currentTimeMillis - aVar4.CGX);
        } else if (i2 != 7 || (str = Wz(i3)) == null) {
            str = "";
        }
        h hVar = h.INSTANCE;
        Object[] objArr2 = new Object[11];
        a aVar5 = CGQ;
        if (aVar5 == null) {
            p.hyc();
        }
        objArr2[0] = Long.valueOf(aVar5.CGU);
        objArr2[1] = 0;
        objArr2[2] = "";
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i2);
        objArr2[5] = "";
        objArr2[6] = 0;
        objArr2[7] = 0;
        a aVar6 = CGQ;
        if (aVar6 == null) {
            p.hyc();
        }
        objArr2[8] = Long.valueOf(aVar6.CGT);
        objArr2[9] = "";
        objArr2[10] = str;
        hVar.a(19332, objArr2);
        switch (i2) {
            case 4:
                h.INSTANCE.dN(1259, 64);
                AppMethodBeat.o(240471);
                return;
            case 5:
                h.INSTANCE.dN(1259, 66);
                break;
            case 6:
                h.INSTANCE.dN(1259, 65);
                AppMethodBeat.o(240471);
                return;
        }
        AppMethodBeat.o(240471);
    }

    public static final void b(int i2, int i3, BaseScanRequest baseScanRequest, int i4) {
        AppMethodBeat.i(240473);
        int JH = JH(i3);
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i4 == 1) {
            CGR = currentTimeMillis;
        } else if (i4 == 2 && CGR > 0) {
            j2 = currentTimeMillis - CGR;
            CGR = 0;
        }
        o<String, String> b2 = b(baseScanRequest);
        h.INSTANCE.a(20275, b2.first, b2.second, dRM, Integer.valueOf(i2), Integer.valueOf(JH), Integer.valueOf(i4), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
        if (i4 == 1 && (baseScanRequest instanceof ScanGoodsRequest) && ((ScanGoodsRequest) baseScanRequest).mode == 5) {
            h.INSTANCE.dN(1259, 108);
        }
        AppMethodBeat.o(240473);
    }

    public static final void e(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240474);
        p.h(scanGoodsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (scanGoodsRequest.mode == 5) {
            h.INSTANCE.dN(1259, 109);
        }
        AppMethodBeat.o(240474);
    }

    public static final void f(ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240475);
        p.h(scanGoodsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (scanGoodsRequest.mode == 5) {
            h.INSTANCE.dN(1259, 110);
        }
        AppMethodBeat.o(240475);
    }

    public static final int a(BaseScanRequest baseScanRequest) {
        if ((baseScanRequest instanceof ScanGoodsRequest) && ((ScanGoodsRequest) baseScanRequest).mode == 5) {
            return 1;
        }
        if (!(baseScanRequest instanceof ScanGoodsRequest) || ((ScanGoodsRequest) baseScanRequest).requestType != 2) {
            return 0;
        }
        return 2;
    }

    private static o<String, String> b(BaseScanRequest baseScanRequest) {
        String str;
        AppMethodBeat.i(240476);
        try {
            if ((baseScanRequest instanceof ScanGoodsRequest) && ((ScanGoodsRequest) baseScanRequest).mode == 5) {
                String extra = baseScanRequest.getExtra("key_sns_ad_ux_info", "");
                p.g(extra, "bizInfo");
                String str2 = (String) j.L(n.a(extra, new String[]{"|"}), 1);
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                Log.d("MicroMsg.ScanReporter", "alvinluo getBizInfo %s, bizId: %s", extra, str);
                o<String, String> oVar = new o<>(str, extra);
                AppMethodBeat.o(240476);
                return oVar;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanReporter", e2, "alvinluo getBizId exception", new Object[0]);
        }
        o<String, String> oVar2 = new o<>("", "");
        AppMethodBeat.o(240476);
        return oVar2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanReportInfo;", "", "()V", "dismissResultTimestamp", "", "getDismissResultTimestamp", "()J", "setDismissResultTimestamp", "(J)V", "endScanTimestamp", "getEndScanTimestamp", "setEndScanTimestamp", "exitType", "", "getExitType", "()I", "setExitType", "(I)V", "scanSession", "", "getScanSession", "()Ljava/lang/String;", "setScanSession", "(Ljava/lang/String;)V", "scanSuccess", "", "getScanSuccess", "()Z", "setScanSuccess", "(Z)V", "showResultTime", "getShowResultTime", "setShowResultTime", "showResultTimestamp", "getShowResultTimestamp", "setShowResultTimestamp", "source", "getSource", "setSource", "startScanTimestamp", "getStartScanTimestamp", "setStartScanTimestamp", "tabSession", "getTabSession", "setTabSession", "timeCost", "getTimeCost", "setTimeCost", "reset", "", "toString", "plugin-scan_release"})
    public static final class b {
        String CHa = "";
        String CHb = "";
        long CHc;
        long CHd;
        long CHe;
        long CHf;
        long CHg;
        boolean CHh;
        int gmJ;
        int source;
        long wNg;

        public final void aMB(String str) {
            AppMethodBeat.i(52215);
            p.h(str, "<set-?>");
            this.CHa = str;
            AppMethodBeat.o(52215);
        }

        public final void aMC(String str) {
            AppMethodBeat.i(52216);
            p.h(str, "<set-?>");
            this.CHb = str;
            AppMethodBeat.o(52216);
        }

        public final String toString() {
            AppMethodBeat.i(52217);
            ae aeVar = ae.SYK;
            String format = String.format("ScanReportInfo tabSession: %s, scanSession: %s, show: %d, dismiss: %d, time: %d, exitType: %d", Arrays.copyOf(new Object[]{this.CHa, this.CHb, Long.valueOf(this.CHc), Long.valueOf(this.CHd), Long.valueOf(this.CHe), Integer.valueOf(this.gmJ)}, 6));
            p.g(format, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(52217);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J%\u0010&\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u001a¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "showInfoViewTimestamp", "getShowInfoViewTimestamp", "setShowInfoViewTimestamp", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-scan_release"})
    public static final class a {
        long CGT;
        long CGU;
        int CGV = -1;
        long CGW;
        long CGX;
        final List<WxQBarResult> CGY;
        final long CGZ;
        boolean gqx;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (r5.CGZ == r6.CGZ) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 240462(0x3ab4e, float:3.36959E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0020
                boolean r0 = r6 instanceof com.tencent.mm.plugin.scanner.model.af.a
                if (r0 == 0) goto L_0x0025
                com.tencent.mm.plugin.scanner.model.af$a r6 = (com.tencent.mm.plugin.scanner.model.af.a) r6
                java.util.List<com.tencent.qbar.WxQBarResult> r0 = r5.CGY
                java.util.List<com.tencent.qbar.WxQBarResult> r1 = r6.CGY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0025
                long r0 = r5.CGZ
                long r2 = r6.CGZ
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0024:
                return r0
            L_0x0025:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.af.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(240461);
            List<WxQBarResult> list = this.CGY;
            int hashCode = list != null ? list.hashCode() : 0;
            long j2 = this.CGZ;
            int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
            AppMethodBeat.o(240461);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(240460);
            String str = "ScanMultiCodeReportInfo(codeResultList=" + this.CGY + ", scanCost=" + this.CGZ + ")";
            AppMethodBeat.o(240460);
            return str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.qbar.WxQBarResult> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends WxQBarResult> list, long j2) {
            p.h(list, "codeResultList");
            AppMethodBeat.i(240459);
            this.CGY = list;
            this.CGZ = j2;
            AppMethodBeat.o(240459);
        }
    }

    public static final /* synthetic */ void f(int i2, String str, boolean z) {
        boolean z2;
        int i3;
        AppMethodBeat.i(52239);
        Log.d("MicroMsg.ScanReporter", "alvinluo reportScanFocusEngineReportInfo %s", str);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = CGM.get(Integer.valueOf(i2));
            String str4 = CGL.get(Integer.valueOf(i2));
            String str5 = str3;
            if (str5 == null || str5.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                String str6 = str4;
                if (!(str6 == null || str6.length() == 0)) {
                    Log.d("MicroMsg.ScanReporter", "alvinluo reportScanFocusEngineReportInfo logId: %d, tabId: %d, tabSession: %s, scanSession: %s, hasResult: %b", 18731, Integer.valueOf(i2), str3, str4, Boolean.valueOf(z));
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[4];
                    objArr[0] = str3;
                    objArr[1] = str4;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    objArr[2] = Integer.valueOf(i3);
                    objArr[3] = str;
                    hVar.a(18731, objArr);
                }
            }
            AppMethodBeat.o(52239);
            return;
        }
        AppMethodBeat.o(52239);
    }
}
