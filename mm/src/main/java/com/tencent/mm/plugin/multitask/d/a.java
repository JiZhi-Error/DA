package com.tencent.mm.plugin.multitask.d;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.g.b.a.gj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004J\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000e¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0004J4\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u000eJ4\u0010(\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101J \u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00132\b\b\u0002\u00105\u001a\u000206J\u0016\u00107\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R-\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0012j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/multitask/report/MultiTaskReportLogic;", "", "()V", "IDKEY_ID", "", "IDKEY_TYPE_APPBRAND", "IDKEY_TYPE_FAV", "IDKEY_TYPE_FILES", "IDKEY_TYPE_FINDER_MEGA_VIDEO", "IDKEY_TYPE_LUGGAGE", "IDKEY_TYPE_TOPSTORY_VIDEO", "IDKEY_TYPE_UNKOWN", "IDKEY_TYPE_WEBPAGE", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getReportInfoMap", "()Ljava/util/HashMap;", "clear", "", "getItemType", "multiTaskType", "getLastExposeTime", "itemId", "(Ljava/lang/String;)Ljava/lang/Long;", "getMultiTaskContextId", "getScene", FirebaseAnalytics.b.INDEX, "multiTaskItemActionReport", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "contextId", "position", NativeProtocol.WEB_DIALOG_ACTION, "itemSubId", "multiTaskItemAddReport", "addType", "status", "multiTaskItemPageActionReport", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "multiTaskItemPageBrowse", "multiTaskPerformanceReport", "performanceData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskPerformanceData;", "reportIDKey", "type", "time", "canConvertTranslucent", "", "setReportInfo", "exposeTime", "plugin-multitask_release"})
public final class a {
    private static final HashMap<String, Long> AbY = new HashMap<>();
    public static final a AbZ = new a();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(200637);
        AppMethodBeat.o(200637);
    }

    private a() {
    }

    public static void clear() {
        AppMethodBeat.i(200630);
        AbY.clear();
        AppMethodBeat.o(200630);
    }

    public static void bb(String str, long j2) {
        AppMethodBeat.i(200631);
        p.h(str, "itemId");
        AbY.put(str, Long.valueOf(j2));
        AppMethodBeat.o(200631);
    }

    public static String erj() {
        AppMethodBeat.i(200632);
        StringBuilder sb = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        String str = MD5Util.getMD5String(sb.append(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin()))).append(System.currentTimeMillis()).toString()).toString();
        AppMethodBeat.o(200632);
        return str;
    }

    public static void a(MultiTaskInfo multiTaskInfo, long j2, long j3, String str, String str2) {
        AppMethodBeat.i(200633);
        if (multiTaskInfo != null) {
            gh ghVar = new gh();
            ghVar.tP(multiTaskInfo.field_id);
            ghVar.qc(RM(multiTaskInfo.field_type));
            ghVar.qd(j2);
            ghVar.qe(j3);
            ghVar.tQ(str);
            ghVar.tR(str2);
            ghVar.bfK();
            AppMethodBeat.o(200633);
            return;
        }
        AppMethodBeat.o(200633);
    }

    public static void a(MultiTaskInfo multiTaskInfo, String str, long j2, long j3, String str2) {
        AppMethodBeat.i(200634);
        if (multiTaskInfo != null) {
            gg ggVar = new gg();
            ggVar.tN(multiTaskInfo.field_id);
            ggVar.pX(RM(multiTaskInfo.field_type));
            ggVar.tM(str);
            ggVar.pY(j2);
            ggVar.pZ(cl.aWA());
            ggVar.qa(j3);
            ggVar.tO(str2);
            String str3 = multiTaskInfo.field_id;
            p.g(str3, "it.field_id");
            p.h(str3, "itemId");
            Long valueOf = AbY.containsKey(str3) ? AbY.get(str3) : Long.valueOf(cl.aWA());
            ggVar.qb(valueOf != null ? valueOf.longValue() : cl.aWA());
            ggVar.bfK();
            AppMethodBeat.o(200634);
            return;
        }
        AppMethodBeat.o(200634);
    }

    public static void a(crt crt) {
        crr crr;
        AppMethodBeat.i(200635);
        if (crt == null || (crr = crt.MwN) == null) {
            AppMethodBeat.o(200635);
            return;
        }
        gi giVar = new gi();
        giVar.tT(crt.MwM);
        giVar.qf(RM(crt.dUm));
        giVar.tS(crt.sGQ);
        giVar.tU(crt.MwB);
        giVar.qg(crr.duration);
        giVar.bfK();
        AppMethodBeat.o(200635);
    }

    public static void b(crt crt) {
        crs crs;
        AppMethodBeat.i(200636);
        if (crt == null || (crs = crt.MwP) == null) {
            AppMethodBeat.o(200636);
            return;
        }
        gj gjVar = new gj();
        gjVar.tV(crt.sGQ);
        gjVar.qh(crs.hlf);
        gjVar.qi(crs.igp);
        gjVar.qj(crs.MwJ);
        gjVar.qk(crs.MwK);
        gjVar.ql(crs.MwL);
        gjVar.qm(crs.duration);
        gjVar.bfK();
        AppMethodBeat.o(200636);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, fho fho) {
        AppMethodBeat.i(259532);
        if (fho != null) {
            switch (i2) {
                case 1:
                    a(10, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
                case 2:
                    a(5, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
                case 3:
                    a(20, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
                case 4:
                    a(15, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
                case 5:
                    a(0, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
                case 8:
                    a(30, fho.VjX, fho.VjY);
                    break;
                case 22:
                    a(25, fho.VjX, fho.VjY);
                    AppMethodBeat.o(259532);
                    return;
            }
            AppMethodBeat.o(259532);
            return;
        }
        AppMethodBeat.o(259532);
    }

    private static void a(int i2, long j2, boolean z) {
        AppMethodBeat.i(259533);
        Log.v(TAG, "reportIDKey: type=%d time=%d translucent=%b", Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z));
        switch (i2) {
            case -1:
            case 0:
            case 5:
            case 10:
            case 15:
            case 20:
            case 25:
            case 30:
                IDKey iDKey = new IDKey();
                iDKey.SetID(1627);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue(j2);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(1627);
                iDKey2.SetKey(i2 + 2);
                iDKey2.SetValue(1);
                ArrayList<IDKey> arrayList = new ArrayList<>();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                if (!z) {
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(1627);
                    iDKey3.SetKey(i2 + 3);
                    iDKey3.SetValue(1);
                    arrayList.add(iDKey3);
                }
                h.INSTANCE.b(arrayList, false);
                break;
        }
        AppMethodBeat.o(259533);
    }

    private static long RM(int i2) {
        switch (i2) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 0;
            case 8:
                return 6;
            case 22:
                return 5;
            default:
                return -1;
        }
    }

    public static long RN(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            default:
                return -1;
        }
    }
}
