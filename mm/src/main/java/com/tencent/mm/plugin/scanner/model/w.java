package com.tencent.mm.plugin.scanner.model;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0007J,\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001b\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0010H\u0007J\u001a\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010&\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000RJ\u0010\u0006\u001a>\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\u0007j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b`\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "scanGoodsResultShowPreviewImage", "", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "syncScanConfig", "callback", "updateScanExptConfig", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class w implements i {
    private static HashMap<Integer, o> CFX = new HashMap<>();
    private static boolean CFY;
    public static final w CFZ = new w();
    private static HashMap<Integer, ArrayList<a>> hdu = new HashMap<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
    public interface a {
        void a(clg clg);

        void p(int i2, int i3, String str);
    }

    static {
        AppMethodBeat.i(240419);
        AppMethodBeat.o(240419);
    }

    private w() {
    }

    public static final void ePT() {
        boolean z;
        AppMethodBeat.i(240414);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_goods_show_preview_image, 0);
        if (a2 == 1 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
            z = true;
        } else {
            z = false;
        }
        CFY = z;
        Log.i("MicroMsg.ScanConfigSyncManager", "updateScanExptConfig showPreviewImage: %d, %b", Integer.valueOf(a2), Boolean.valueOf(CFY));
        AppMethodBeat.o(240414);
    }

    public static final boolean ePU() {
        return CFY;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ int $type;
        final /* synthetic */ a CGa;

        c(int i2, a aVar) {
            this.$type = i2;
            this.CGa = aVar;
        }

        public final void run() {
            AppMethodBeat.i(240413);
            w wVar = w.CFZ;
            ArrayList arrayList = (ArrayList) w.hdu.get(Integer.valueOf(this.$type));
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                w wVar2 = w.CFZ;
                w.hdu.put(Integer.valueOf(this.$type), arrayList2);
                arrayList = arrayList2;
            }
            if (this.CGa != null) {
                arrayList.add(this.CGa);
            }
            w wVar3 = w.CFZ;
            if (w.CFX.containsKey(Integer.valueOf(this.$type))) {
                Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
                AppMethodBeat.o(240413);
                return;
            }
            g.azz().a(1812, w.CFZ);
            o oVar = new o(this.$type);
            g.azz().b(oVar);
            w wVar4 = w.CFZ;
            w.CFX.put(Integer.valueOf(this.$type), oVar);
            AppMethodBeat.o(240413);
        }
    }

    public static final void a(int i2, a aVar) {
        AppMethodBeat.i(240415);
        v(new c(i2, aVar));
        AppMethodBeat.o(240415);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(240416);
        Log.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        v(new b(qVar, i2, i3, str));
        AppMethodBeat.o(240416);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int $errCode;
        final /* synthetic */ String $errMsg;
        final /* synthetic */ int $errType;
        final /* synthetic */ q hvN;

        b(q qVar, int i2, int i3, String str) {
            this.hvN = qVar;
            this.$errType = i2;
            this.$errCode = i3;
            this.$errMsg = str;
        }

        public final void run() {
            clg clg;
            AppMethodBeat.i(240412);
            q qVar = this.hvN;
            if (qVar != null) {
                if (qVar.getType() == 1812) {
                    if (this.hvN.isCanceled()) {
                        Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
                        AppMethodBeat.o(240412);
                        return;
                    } else if (this.$errType == 0 && this.$errCode == 0) {
                        q qVar2 = this.hvN;
                        if (qVar2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
                            AppMethodBeat.o(240412);
                            throw tVar;
                        }
                        o oVar = (o) qVar2;
                        if (oVar.rr.aYK() != null) {
                            com.tencent.mm.bw.a aYK = oVar.rr.aYK();
                            if (aYK == null) {
                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
                                AppMethodBeat.o(240412);
                                throw tVar2;
                            }
                            clg = (clg) aYK;
                        } else {
                            clg = null;
                        }
                        w wVar = w.CFZ;
                        w.a(this.hvN, clg);
                        AppMethodBeat.o(240412);
                        return;
                    } else {
                        w wVar2 = w.CFZ;
                        w.h(this.$errType, this.$errCode, this.$errMsg, this.hvN);
                    }
                }
                AppMethodBeat.o(240412);
                return;
            }
            AppMethodBeat.o(240412);
        }
    }

    private static void Wv(int i2) {
        AppMethodBeat.i(240417);
        Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", Integer.valueOf(i2));
        hdu.remove(Integer.valueOf(i2));
        CFX.remove(Integer.valueOf(i2));
        AppMethodBeat.o(240417);
    }

    private static void v(Runnable runnable) {
        AppMethodBeat.i(240418);
        h.RTc.b(runnable, "ScanConfigSync");
        AppMethodBeat.o(240418);
    }

    public static final /* synthetic */ void a(q qVar, clg clg) {
        AppMethodBeat.i(240420);
        if (qVar instanceof o) {
            int i2 = ((o) qVar).CFG;
            ArrayList<a> arrayList = hdu.get(Integer.valueOf(i2));
            Object[] objArr = new Object[1];
            objArr[0] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
            Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo onSuccess callbackList size: %d", objArr);
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a(clg);
                }
            }
            Wv(i2);
        }
        AppMethodBeat.o(240420);
    }

    public static final /* synthetic */ void h(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(240421);
        if (qVar instanceof o) {
            int i4 = ((o) qVar).CFG;
            ArrayList<a> arrayList = hdu.get(Integer.valueOf(i4));
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().p(i2, i3, str);
                }
            }
            Wv(i4);
        }
        AppMethodBeat.o(240421);
    }
}
