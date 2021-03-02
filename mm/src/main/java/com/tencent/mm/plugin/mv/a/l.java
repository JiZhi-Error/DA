package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.util.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tJ \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\"\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u000fJ\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\u000fJ\u001e\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*J\u0016\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*J\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010/\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*J\b\u00100\u001a\u00020\u0004H\u0002J\u0010\u00101\u001a\u00020\u000f2\b\u00102\u001a\u0004\u0018\u00010*R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper;", "", "()V", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCreateActionStruct;", "finderPostFinishListener", "com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1;", "materialFrom", "", "materialPosition", "postCache", "", "", "cacheMaterialFrom", "", "cacheMaterialPosition", "enterCreateMv", "context", "Landroid/content/Context;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "initReporter", "onCancelMaterial", "position", "data", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "isScrollEdit", "", "onConfirmMaterial", "onCreateMvFinish", "onDestroy", "onMaterialExposure", "onPreparePostSuccess", ch.COL_LOCALID, "onPreviewMvFinish", "onSaveDraft", "isSave", "isFinderNew", "partList", "", "onSearch", "keyWord", "expId", "onSelect", "onStartPost", "reporter", "updateRequestId", "requestId", "plugin-mv_release"})
public final class l {
    public static on UZn = new on();
    public static int UZo;
    public static int UZp;
    public static final Map<Long, on> UZq = new LinkedHashMap();
    private static final a UZr = new a();
    public static final l UZs = new l();

    static {
        AppMethodBeat.i(259174);
        EventCenter.instance.addListener(UZr);
        AppMethodBeat.o(259174);
    }

    private l() {
    }

    public static on hWv() {
        AppMethodBeat.i(259170);
        on onVar = new on(UZn.abV());
        AppMethodBeat.o(259170);
        return onVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderPostStatusEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class a extends IListener<ia> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ia iaVar) {
            ia.a aVar;
            String str;
            AppMethodBeat.i(259169);
            ia iaVar2 = iaVar;
            if (!(iaVar2 == null || (aVar = iaVar2.dMC) == null || !aVar.dMD)) {
                l lVar = l.UZs;
                on onVar = (on) l.UZq.remove(Long.valueOf(aVar.localId));
                if (onVar != null) {
                    bcj bcj = aVar.dME;
                    if (bcj == null || (str = bcj.objectId) == null) {
                        str = "";
                    }
                    onVar.bvG(str);
                    onVar.bfK();
                    b bVar = b.QYu;
                    b.a(onVar);
                }
            }
            AppMethodBeat.o(259169);
            return false;
        }
    }

    public static void byk(String str) {
        AppMethodBeat.i(259171);
        UZn.bvN(str);
        AppMethodBeat.o(259171);
    }

    public static void axb(int i2) {
        UZp = i2;
    }

    public static void axc(int i2) {
        UZo = i2;
    }

    public static void a(int i2, d dVar) {
        AppMethodBeat.i(259172);
        p.h(dVar, "data");
        on hWv = hWv();
        hWv.bvJ(dVar.adk());
        hWv.bvK(dVar.hWt());
        if (UZo == 3) {
            hWv.PY((long) UZp);
        }
        hWv.Qa((long) i2);
        hWv.Qb((long) UZo);
        hWv.Qd(dVar.hWu());
        hWv.PV(2);
        hWv.bfK();
        b bVar = b.QYu;
        b.a(hWv);
        AppMethodBeat.o(259172);
    }

    public static void iv(String str, String str2) {
        AppMethodBeat.i(259173);
        p.h(str, "keyWord");
        p.h(str2, "expId");
        on hWv = hWv();
        hWv.bvL(str);
        hWv.bvM(str2);
        hWv.PV(3);
        hWv.bfK();
        b bVar = b.QYu;
        b.a(hWv);
        AppMethodBeat.o(259173);
    }
}
