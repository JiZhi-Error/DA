package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\u0006\u0010@\u001a\u00020>J,\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010\u00062\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\"\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020C2\b\b\u0002\u0010L\u001a\u00020CH\u0002J\u0006\u0010M\u001a\u00020>J\u0016\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020>2\u0006\u0010I\u001a\u00020JJ\u0006\u0010R\u001a\u00020>J\u0006\u0010S\u001a\u00020>R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "ftsMainUI", "Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "(Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "currentQuery", "getCurrentQuery", "()Ljava/lang/String;", "setCurrentQuery", "(Ljava/lang/String;)V", "currentSearchId", "getCurrentSearchId", "setCurrentSearchId", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getFtsMainUI", "()Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "isKeyboardShow", "", "isScrolled", "()Z", "setScrolled", "(Z)V", "lastStartTime", "", "netSceneKeyboardSug", "Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "getNetSceneKeyboardSug", "()Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "setNetSceneKeyboardSug", "(Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "response", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;)V", "scrollListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getScrollListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "destroy", "", "onKeyboardHide", "onKeyboardShow", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSugAction", "sugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", NativeProtocol.WEB_DIALOG_ACTION, "clickType", "reset", "startSearch", SearchIntents.EXTRA_QUERY, "searchId", "startWebSearch", "stopSearch", "updateView", "ui-fts_release"})
public final class h implements i {
    private final String TAG = "MicroMsg.FTS.KeyboardSugLogic";
    ArrayList<g> kgc;
    long mZq;
    public WxRecyclerView ufR;
    final com.tencent.mm.plugin.appbrand.widget.recyclerview.b xfK;
    boolean xfO;
    private final com.tencent.mm.view.recyclerview.l xfP;
    public String xfQ;
    public cgf xfR;
    public com.tencent.mm.plugin.fts.ui.c.c xfS;
    public String xfT;
    public boolean xfU;
    final FTSMainUI xfV;

    public h(FTSMainUI fTSMainUI) {
        p.h(fTSMainUI, "ftsMainUI");
        AppMethodBeat.i(235467);
        this.xfV = fTSMainUI;
        View findViewById = this.xfV.findViewById(R.id.dbb);
        p.g(findViewById, "ftsMainUI.findViewById(R.id.fts_keyboard_sug_rv)");
        this.ufR = (WxRecyclerView) findViewById;
        this.kgc = new ArrayList<>();
        this.xfP = new d(this);
        this.xfK = new b(this);
        g.azz().a(4591, this);
        WxRecyclerView wxRecyclerView = this.ufR;
        this.xfV.getContext();
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new a(this), this.kgc, true);
        this.ufR.setAdapter(wxRecyclerAdapter);
        wxRecyclerAdapter.RrA = this.xfP;
        this.xfQ = "";
        this.xfT = "";
        AppMethodBeat.o(235467);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$scrollListener$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-fts_release"})
    public static final class d implements com.tencent.mm.view.recyclerview.l {
        final /* synthetic */ h xfW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(h hVar) {
            this.xfW = hVar;
        }

        @Override // com.tencent.mm.view.recyclerview.l
        public final void a(RecyclerView recyclerView, j jVar) {
            AppMethodBeat.i(235463);
            p.h(recyclerView, "recyclerView");
            p.h(jVar, "data");
            if (jVar.state == 1) {
                this.xfW.xfO = true;
            }
            int i2 = 0;
            for (T t : jVar.Rro) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                com.tencent.mm.view.recyclerview.a aVar = t.Rrp;
                if (aVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.KeyboardSugItem");
                    AppMethodBeat.o(235463);
                    throw tVar;
                }
                efk efk = ((g) aVar).xfN;
                if (efk != null) {
                    alv alv = new alv();
                    alv.xuA = i2;
                    alv.Lux = efk;
                    h.a(this.xfW, alv, 1, this.xfW.xfO ? 2 : 0);
                    i2 = i3;
                } else {
                    i2 = i3;
                }
            }
            AppMethodBeat.o(235463);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"})
    static final class b implements com.tencent.mm.plugin.appbrand.widget.recyclerview.b {
        final /* synthetic */ h xfW;

        b(h hVar) {
            this.xfW = hVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.b
        public final void Q(View view, int i2) {
            AppMethodBeat.i(235461);
            g gVar = this.xfW.kgc.get(i2);
            p.g(gVar, "dataList[position]");
            efk efk = gVar.xfN;
            if (efk != null) {
                this.xfW.xfV.hideVKB();
                alv alv = new alv();
                alv.xuA = i2;
                alv.Lux = efk;
                h hVar = this.xfW;
                p.h(alv, "sugItem");
                String str = alv.Lux.MGp;
                hVar.xfV.dPv().dPu();
                String str2 = str;
                if (!(str2 == null || str2.length() == 0) && System.currentTimeMillis() - hVar.mZq > 1000) {
                    hVar.mZq = System.currentTimeMillis();
                    ag agVar = new ag();
                    agVar.context = hVar.xfV.getContext();
                    agVar.scene = 74;
                    agVar.sessionId = String.valueOf(e.wVm);
                    agVar.query = str;
                    agVar.IEk = true;
                    String str3 = alv.Lux.NfG;
                    if (str3 == null) {
                        str3 = "";
                    }
                    agVar.IEq = str3;
                    cgf cgf = hVar.xfR;
                    if (cgf != null) {
                        ae aeVar = ae.SYK;
                        String format = String.format("%s:%s:%s:%s", Arrays.copyOf(new Object[]{20, cgf.Mbb, str, hVar.xfT}, 4));
                        p.g(format, "java.lang.String.format(format, *args)");
                        agVar.IEr = format;
                        Map<String, String> map = agVar.dVU;
                        p.g(map, "params.extParams");
                        String str4 = alv.Lux.MEq;
                        if (str4 == null) {
                            str4 = "";
                        }
                        map.put("sugId", str4);
                        Map<String, String> map2 = agVar.dVU;
                        p.g(map2, "params.extParams");
                        map2.put("isSug", "1");
                        Map<String, String> map3 = agVar.dVU;
                        p.g(map3, "params.extParams");
                        map3.put("prefixSug", str);
                        Map<String, String> map4 = agVar.dVU;
                        p.g(map4, "params.extParams");
                        map4.put("sceneActionType", "6");
                        String str5 = agVar.IEq;
                        if (!(str5 == null || str5.length() == 0)) {
                            Map<String, String> map5 = agVar.dVU;
                            p.g(map5, "params.extParams");
                            map5.put("hasCacheJsonResult", "1");
                        }
                    }
                    ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(agVar);
                }
                h.a(this.xfW, alv, 2, 1);
                AppMethodBeat.o(235461);
                return;
            }
            AppMethodBeat.o(235461);
        }
    }

    public final void reset() {
        AppMethodBeat.i(235464);
        this.xfO = false;
        this.xfR = null;
        this.xfQ = "";
        this.xfT = "";
        com.tencent.mm.plugin.fts.ui.c.c cVar = this.xfS;
        if (cVar != null) {
            g.azz().a(cVar);
            this.xfS = null;
        }
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(235464);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        if (r0 == null) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateView() {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.widget.h.updateView():void");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        com.tencent.mm.bw.a aVar = null;
        AppMethodBeat.i(235466);
        Log.i(this.TAG, "onSceneEnd " + i2 + ' ' + i3 + ' ' + str);
        if (i2 != 0 || i3 != 0) {
            this.xfR = null;
            AppMethodBeat.o(235466);
        } else if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.model.NetSceneKeyboardSug");
            AppMethodBeat.o(235466);
            throw tVar;
        } else {
            com.tencent.mm.ak.d dVar = ((com.tencent.mm.plugin.fts.ui.c.c) qVar).iUB;
            if (dVar != null) {
                aVar = dVar.aYK();
            }
            if (aVar == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KeyBoardSugSearchResponse");
                AppMethodBeat.o(235466);
                throw tVar2;
            }
            this.xfR = (cgf) aVar;
            updateView();
            AppMethodBeat.o(235466);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-fts_release"})
    public static final class a implements f {
        final /* synthetic */ h xfW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(h hVar) {
            this.xfW = hVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(235460);
            switch (i2) {
                case 0:
                    f fVar = new f();
                    AppMethodBeat.o(235460);
                    return fVar;
                default:
                    e eVar = new e(this.xfW.xfK);
                    AppMethodBeat.o(235460);
                    return eVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ h xfW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(0);
            this.xfW = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(235462);
            WxRecyclerView wxRecyclerView = this.xfW.ufR;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$reset$2", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
            wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$reset$2", "invoke", "()V", "Undefined", "scrollToPosition", "(I)V");
            RecyclerView.a adapter = this.xfW.ufR.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                Log.i("RecyclerViewAdapterEx", "clearReportData");
                wxRecyclerAdapter.Rrx.clear();
                wxRecyclerAdapter.Rry.clear();
                wxRecyclerAdapter.Rrz.clear();
                wxRecyclerAdapter.Rrv.clear();
                wxRecyclerAdapter.Rrw = true;
                WxRecyclerAdapter<D>.a aVar = wxRecyclerAdapter.RrB;
                if (aVar != null) {
                    aVar.ptb = -1;
                    aVar.ptc = -1;
                    aVar.currentState = 0;
                    aVar.tIj = 0;
                    aVar.RrE = 0;
                }
            }
            this.xfW.ufR.setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(235462);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(h hVar, alv alv, int i2, int i3) {
        Float f2;
        Float f3 = null;
        AppMethodBeat.i(235468);
        cgf cgf = hVar.xfR;
        if (cgf != null) {
            doc doc = new doc();
            StringBuilder append = new StringBuilder("iskeyboardsug=1&searchid=").append(cgf.Mbb).append("&query=").append(com.tencent.mm.compatible.util.q.encode(hVar.xfQ, "utf8")).append("&action=").append(i2).append("&scene=74&clienttimestamp=").append(cl.aWA()).append("&docid=").append(alv.Lux.MEq).append("&resultcount=").append(cgf.MlS.KKx.size()).append("&words=").append(com.tencent.mm.compatible.util.q.encode(alv.Lux.MGp, "utf8")).append("&requestId=").append(hVar.xfT).append("&longitude=");
            chl clJ = ai.clJ();
            if (clJ != null) {
                f2 = Float.valueOf(clJ.LbC);
            } else {
                f2 = null;
            }
            StringBuilder append2 = append.append(f2).append("&latitude=");
            chl clJ2 = ai.clJ();
            if (clJ2 != null) {
                f3 = Float.valueOf(clJ2.LbD);
            }
            doc.MRe = append2.append(f3).append("&sessionid=").append(e.wVm).append("&clicktype=").append(i3).toString();
            Log.i(hVar.TAG, "reportSugAction " + doc.MRe);
            g.azz().b(new ad(doc));
            AppMethodBeat.o(235468);
            return;
        }
        AppMethodBeat.o(235468);
    }
}
