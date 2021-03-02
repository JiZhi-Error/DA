package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0007J&\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-J\u0016\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u001eJ\u0010\u00101\u001a\u00020\n2\u0006\u00100\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0007J\u0006\u00104\u001a\u00020$J\n\u00105\u001a\u00020\u0011*\u000206R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n`\u0012X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n`\u0012X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n`\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR6\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001e0\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001e`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTimeLineExposeHelper;", "", "context", "Landroid/content/Context;", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;)V", "getContext", "()Landroid/content/Context;", "doingReport", "", "getDoingReport", "()Z", "setDoingReport", "(Z)V", "exposedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingMap", "renderMap", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "screenHeight", "", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "getSessionItemCache", "()Ljava/util/HashMap;", "setSessionItemCache", "(Ljava/util/HashMap;)V", "addToRenderMap", "", "id", "doUpdateReadStatus", "firstVisibleItem", "lastVisibleItem", "listView", "Landroid/widget/ListView;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "putToSessionItemCache", "key", "item", "realExpose", "Landroid/view/View;", "removeFormRenderMap", "reportExpose", "keyWithExpandStatus", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Companion", "plugin-brandservice_release"})
public final class b {
    public static final a pyS = new a((byte) 0);
    public final Context context;
    public int mEY = com.tencent.mm.cb.a.jo(this.context);
    final f pqZ;
    public final HashMap<String, Boolean> pyN = new HashMap<>();
    private final HashMap<String, Boolean> pyO = new HashMap<>();
    private final HashMap<String, Boolean> pyP = new HashMap<>();
    public HashMap<String, f.b> pyQ = new HashMap<>();
    boolean pyR;

    static {
        AppMethodBeat.i(195518);
        AppMethodBeat.o(195518);
    }

    public b(Context context2, f fVar) {
        p.h(context2, "context");
        p.h(fVar, "report");
        AppMethodBeat.i(195517);
        this.context = context2;
        this.pqZ = fVar;
        this.pqZ.a(this);
        AppMethodBeat.o(195517);
    }

    public static String n(z zVar) {
        AppMethodBeat.i(195513);
        p.h(zVar, "$this$keyWithExpandStatus");
        String str = zVar.getId() + '-' + zVar.field_isExpand;
        AppMethodBeat.o(195513);
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, android.widget.ListView r10, com.tencent.mm.plugin.brandservice.ui.timeline.f r11) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.a.b.a(int, int, android.widget.ListView, com.tencent.mm.plugin.brandservice.ui.timeline.f):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.b$b  reason: collision with other inner class name */
    static final class RunnableC0872b implements Runnable {
        final /* synthetic */ f prI;
        final /* synthetic */ z prL;
        final /* synthetic */ b pyT;
        final /* synthetic */ View pyU;

        RunnableC0872b(b bVar, View view, z zVar, f fVar) {
            this.pyT = bVar;
            this.pyU = view;
            this.prL = zVar;
            this.prI = fVar;
        }

        public final void run() {
            AppMethodBeat.i(195511);
            Object tag = this.pyU.getTag();
            if (!(tag instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
                tag = null;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.item.a aVar = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a) tag;
            if (aVar == null) {
                AppMethodBeat.o(195511);
                return;
            }
            z zVar = aVar.psm;
            if (zVar == null) {
                AppMethodBeat.o(195511);
                return;
            }
            final int i2 = aVar.position;
            if (p.j(b.n(zVar), b.n(this.prL)) && (this.pyU.isShown() || this.pyU.isAttachedToWindow())) {
                this.pyT.pyO.remove(b.n(this.prL));
                b bVar = this.pyT;
                String id = this.prL.getId();
                p.g(id, "info.id");
                p.h(id, "id");
                bVar.pyN.remove(id);
                Log.v("MicroMsg.BizTimeLineExposeHelper", "doUpdateReadStatus on expose " + this.prL.getId());
                if (!this.pyT.pyP.containsKey(b.n(zVar))) {
                    this.pyT.cnl();
                }
                this.pyT.pyP.put(b.n(zVar), Boolean.TRUE);
                h.RTc.b(new Runnable(this) {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.a.b.RunnableC0872b.AnonymousClass1 */
                    final /* synthetic */ RunnableC0872b pyV;

                    {
                        this.pyV = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(195510);
                        this.pyV.prI.c(this.pyV.prL, i2);
                        AppMethodBeat.o(195510);
                    }
                }, "BizTimeLineExpose");
            }
            AppMethodBeat.o(195511);
        }
    }

    private final boolean dx(View view) {
        AppMethodBeat.i(195515);
        int height = view.getHeight();
        if (view.getTop() < 0) {
            height += view.getTop();
        }
        if (view.getBottom() > this.mEY) {
            height -= view.getBottom() - this.mEY;
        }
        if (((double) (((float) height) / ((float) view.getHeight()))) > 0.5d) {
            AppMethodBeat.o(195515);
            return true;
        }
        AppMethodBeat.o(195515);
        return false;
    }

    public final void cnl() {
        AppMethodBeat.i(195516);
        if (this.pyR) {
            AppMethodBeat.o(195516);
            return;
        }
        this.pyR = true;
        h.RTc.a(new c(this), 1000, "BizTimeLineExpose");
        AppMethodBeat.o(195516);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b pyT;

        c(b bVar) {
            this.pyT = bVar;
        }

        public final void run() {
            AppMethodBeat.i(195512);
            this.pyT.pyR = false;
            synchronized (b.class) {
                try {
                    HashMap<String, f.b> hashMap = this.pyT.pyQ;
                    if (!(hashMap == null || hashMap.isEmpty())) {
                        LinkedList linkedList = new LinkedList();
                        for (Map.Entry<String, f.b> entry : this.pyT.pyQ.entrySet()) {
                            f.b value = entry.getValue();
                            if (!Util.isNullOrNil(value.psI)) {
                                MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
                                value.KVl = MPVideoPreviewMgr.aiL(value.psI);
                                MPVideoPreviewMgr mPVideoPreviewMgr2 = MPVideoPreviewMgr.pJz;
                                value.KVm = MPVideoPreviewMgr.aiM(value.psI);
                            }
                            linkedList.add(value);
                        }
                        this.pyT.pyQ.clear();
                        Log.i("MicroMsg.BizTimeLineExposeHelper", "reportExpose size = " + linkedList.size());
                        com.tencent.mm.kernel.b aAg = g.aAg();
                        p.g(aAg, "MMKernel.network()");
                        aAg.azz().b(new k(linkedList, this.pyT.pqZ.psq, this.pyT.pqZ.psr, this.pyT.pqZ.dEb, this.pyT.pqZ.pss, 1, 0));
                        AppMethodBeat.o(195512);
                    }
                } finally {
                    AppMethodBeat.o(195512);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTimeLineExposeHelper$Companion;", "", "()V", "TAG", "", "minExposureRatio", "", "minExposureTme", "", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
