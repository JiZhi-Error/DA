package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.conv.f;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.plugin.finder.conv.h;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0014J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\"\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0014J\u0006\u0010#\u001a\u00020\u000eJ\b\u0010$\u001a\u00020\u000eH\u0014J\b\u0010%\u001a\u00020\u000eH\u0002J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "msgTypes", "", "requestScene", "", "scene", "scrollListener", "Lcom/tencent/mm/plugin/finder/report/SystemMsgScrollListener;", "sysMsgConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "fakeData", "", "getLayoutId", "getSystemConversationInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "mentionId", "", "limit", "getTitleResId", "initSystemMsgReporter", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onExitChattingUI", "onResume", "reportSystemMsg", "setTeamConversation", "updateSysConversation", "Companion", "plugin-finder_release"})
public final class FinderConversationUI extends FinderConversationParentUI implements f.b {
    public static final a vHZ = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final int scene = 1;
    private final int tvu = 1;
    private final int[] uYt = {4};
    private final com.tencent.mm.plugin.finder.conv.c vHX = new com.tencent.mm.plugin.finder.conv.c();
    public al vHY;

    static {
        AppMethodBeat.i(252229);
        AppMethodBeat.o(252229);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252232);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252232);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252231);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252231);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationUI$onCreate$1$2"})
    static final class c extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x> {
        final /* synthetic */ FinderConversationUI vIa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderConversationUI finderConversationUI) {
            super(1);
            this.vIa = finderConversationUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.conv.b bVar) {
            AppMethodBeat.i(252218);
            com.tencent.mm.plugin.finder.conv.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            this.vIa.vHO = bVar2;
            x xVar = x.SXb;
            AppMethodBeat.o(252218);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d vIb = new d();

        static {
            AppMethodBeat.i(252219);
            AppMethodBeat.o(252219);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public FinderConversationUI() {
        AppMethodBeat.i(252228);
        AppMethodBeat.o(252228);
    }

    public static final /* synthetic */ void a(FinderConversationUI finderConversationUI) {
        AppMethodBeat.i(252230);
        finderConversationUI.dzc();
        AppMethodBeat.o(252230);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI$Companion;", "", "()V", "REQUEST_CODE_HI_BOX", "", "RESULT_CODE_REMOVE_HI_BOX", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int getLayoutId() {
        return R.layout.a_8;
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int dzb() {
        return R.string.ck1;
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void a(Bundle bundle, int i2) {
        String str;
        AppMethodBeat.i(252220);
        g gVar = new g();
        gVar.a(new h(d.vIb));
        gVar.a(new e(this, new c(this)));
        g gVar2 = gVar;
        p.h(gVar2, "<set-?>");
        this.vHP = gVar2;
        if (this.vHP instanceof g) {
            com.tencent.mm.plugin.finder.conv.c cVar = this.vHX;
            cVar.nickname = getString(R.string.ck2);
            cVar.field_sessionId = "finder_system_message";
            Context context = MMApplicationContext.getContext();
            String str2 = cVar.nickname;
            if (str2 != null) {
                str = str2;
            }
            cVar.tyr = com.tencent.mm.pluginsdk.ui.span.l.c(context, str);
            com.tencent.mm.plugin.finder.conv.d dVar = this.vHP;
            if (dVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
                AppMethodBeat.o(252220);
                throw tVar;
            }
            ((g) dVar).tyI = this.vHX;
        }
        super.a(bundle, i2);
        al alVar = new al();
        com.tencent.mm.plugin.finder.report.a<ID> aVar = alVar.viV;
        if (aVar != null) {
            aVar.vcM = new b(this);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView, "conversationRecyclerView");
        alVar.b(recyclerView, false);
        this.vHY = alVar;
        AppMethodBeat.o(252220);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationUI$initSystemMsgReporter$1$1", "Lcom/tencent/mm/plugin/finder/report/IDiffData;", "", "onDiffData", "", "diffData", "", "plugin-finder_release"})
    public static final class b implements z<String> {
        final /* synthetic */ FinderConversationUI vIa;

        b(FinderConversationUI finderConversationUI) {
            this.vIa = finderConversationUI;
        }

        @Override // com.tencent.mm.plugin.finder.report.z
        public final void doO() {
            AppMethodBeat.i(252217);
            FinderConversationUI.a(this.vIa);
            AppMethodBeat.o(252217);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void anv() {
        AppMethodBeat.i(252221);
        super.anv();
        dzd();
        AppMethodBeat.o(252221);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        String str;
        long j2;
        AppMethodBeat.i(252222);
        super.onResume();
        f dyY = dyY();
        List<com.tencent.mm.plugin.finder.conv.c> a2 = dyY.tyE.a(0, this.vHP.ppH.size(), new int[]{1}, dyY.scene);
        if (a2.isEmpty()) {
            str = "";
        } else {
            str = a2.get(0).nickname + ':' + a2.get(0).field_digest;
        }
        if (a2.isEmpty()) {
            j2 = 0;
        } else {
            j2 = a2.get(0).field_updateTime;
        }
        Log.i("Finder.FinderConversationUI", "[onResume] digest:".concat(String.valueOf(str)));
        com.tencent.mm.plugin.finder.storage.e conversationStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getConversationStorage();
        int KX = conversationStorage.KX(2);
        com.tencent.mm.plugin.finder.conv.c avq = conversationStorage.avq("findersayhisessionholder");
        if (KX > 0 && avq.systemRowid > 0 && ((!p.j(str, avq.field_digest)) || j2 != avq.field_updateTime)) {
            avq.field_digest = str;
            avq.field_updateTime = j2;
            if (conversationStorage.update(avq.systemRowid, avq, false)) {
                conversationStorage.doNotify(avq.field_sessionId, 1, avq);
            }
        } else if (avq.systemRowid > 0 && KX == 0 && conversationStorage.delete(avq.systemRowid)) {
            conversationStorage.doNotify(avq.field_sessionId, 6, avq);
        }
        dzd();
        al alVar = this.vHY;
        if (alVar != null) {
            if (alVar.doZ()) {
                dzc();
            }
            AppMethodBeat.o(252222);
            return;
        }
        AppMethodBeat.o(252222);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252223);
        super.onDestroy();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().tJB.dat();
        al alVar = this.vHY;
        if (alVar != null) {
            alVar.doY();
            AppMethodBeat.o(252223);
            return;
        }
        AppMethodBeat.o(252223);
    }

    public final void dzc() {
        bbn bbn;
        AppMethodBeat.i(252224);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
        if (i2 > 0) {
            k kVar = k.vfA;
            k.ai(i2, 1);
            k kVar2 = k.vfA;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            AppCompatActivity context = getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                bbn = fH.dIx();
            } else {
                bbn = null;
            }
            k.a("11", 4, 1, 5, 0, i2, (String) null, (String) null, 0, bbn, 0, 0, 3520);
            AppMethodBeat.o(252224);
            return;
        }
        k kVar3 = k.vfA;
        k.ai(0, 1);
        AppMethodBeat.o(252224);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252225);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 1) {
            com.tencent.mm.plugin.finder.conv.d dVar = this.vHP;
            p.h("findersayhisessionholder", "sessionId");
            int a2 = j.a((List) dVar.ppH, (Object) dVar.tyt.get("findersayhisessionholder"));
            if (a2 >= 0 && a2 < dVar.ppH.size()) {
                dVar.ppH.remove(a2);
                dVar.tyt.remove("findersayhisessionholder");
                dVar.In(a2);
            }
        }
        AppMethodBeat.o(252225);
    }

    private final void dzd() {
        AppMethodBeat.i(252226);
        ArrayList<com.tencent.mm.plugin.finder.model.a> dze = dze();
        if (!dze.isEmpty()) {
            azp azp = dze.get(0).uNF.field_notify;
            this.vHX.field_updateTime = ((long) dze.get(0).uNF.field_createTime) * 1000;
            this.vHX.field_digest = azp.title;
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        this.vHX.field_unReadCount = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
        this.vHX.field_readStatus = 0;
        this.vHP.ci(0);
        AppMethodBeat.o(252226);
    }

    private final ArrayList<com.tencent.mm.plugin.finder.model.a> dze() {
        AppMethodBeat.i(252227);
        ArrayList<com.tencent.mm.plugin.finder.model.a> arrayList = new ArrayList<>();
        e.a aVar = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = e.a.a(MAlarmHandler.NEXT_FIRE_INTERVAL, 1, this.uYt, this.scene).iterator();
        while (it.hasNext()) {
            e.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
            com.tencent.mm.plugin.finder.model.a b2 = e.a.b(it.next());
            if (b2 != null) {
                arrayList2.add(b2);
            }
        }
        arrayList.addAll(arrayList2);
        AppMethodBeat.o(252227);
        return arrayList;
    }
}
