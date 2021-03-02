package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u000bH\u0014J\b\u0010(\u001a\u00020\u000bH\u0016J\u0016\u0010)\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0016\u0010-\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0012\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020%H\u0016J\b\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020%H\u0016J\b\u0010:\u001a\u00020%H\u0014J\b\u0010;\u001a\u00020%H\u0014J\u0006\u0010<\u001a\u00020%J\b\u0010=\u001a\u00020%H\u0002J\u0010\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "animRunnable", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "getAnimRunnable", "()Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "setAnimRunnable", "(Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;)V", "convScene", "", "getConvScene", "()I", "setConvScene", "(I)V", "convType", "getConvType", "setConvType", "conversationAdapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "getConversationAdapter", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "setConversationAdapter", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;)V", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;)V", "onContactStorageChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onFinderContactStorageChange", "checkEmpty", "", "doSomethingOnConvDel", "getLayoutId", "getTitleResId", "loadAfter", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "modifyChange", "obj", "", "onBackPressed", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onResume", "refreshAll", "reportChatExpose", "updateActionBar", "scene", "Companion", "plugin-finder_release"})
public class FinderConversationParentUI extends ReadyChattingCompatUI implements f.b {
    public static final b vHT = new b((byte) 0);
    private HashMap _$_findViewCache;
    int vHL = -1;
    int vHM = -1;
    public com.tencent.mm.plugin.finder.conv.f vHN;
    com.tencent.mm.plugin.finder.conv.b vHO;
    com.tencent.mm.plugin.finder.conv.d vHP;
    private final MStorage.IOnStorageChange vHQ;
    private final MStorage.IOnStorageChange vHR;
    private final MStorageEx.IOnStorageChange vHS;

    static {
        AppMethodBeat.i(252206);
        AppMethodBeat.o(252206);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252210);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252210);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252209);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252209);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$conversationAdapter$1$2"})
    static final class a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x> {
        final /* synthetic */ FinderConversationParentUI vHU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderConversationParentUI finderConversationParentUI) {
            super(1);
            this.vHU = finderConversationParentUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.conv.b bVar) {
            AppMethodBeat.i(252179);
            com.tencent.mm.plugin.finder.conv.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            this.vHU.vHO = bVar2;
            x xVar = x.SXb;
            AppMethodBeat.o(252179);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        public static final c vHV = new c();

        static {
            AppMethodBeat.i(252180);
            AppMethodBeat.o(252180);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public FinderConversationParentUI() {
        AppMethodBeat.i(252205);
        com.tencent.mm.plugin.finder.conv.d dVar = new com.tencent.mm.plugin.finder.conv.d();
        dVar.a(new com.tencent.mm.plugin.finder.conv.h(c.vHV));
        dVar.a(new com.tencent.mm.plugin.finder.conv.e(this, new a(this)));
        this.vHP = dVar;
        this.vHQ = new e(this);
        this.vHR = new j(this);
        this.vHS = new d(this);
        AppMethodBeat.o(252205);
    }

    public static final /* synthetic */ void b(FinderConversationParentUI finderConversationParentUI) {
        AppMethodBeat.i(252208);
        finderConversationParentUI.dza();
        AppMethodBeat.o(252208);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI$Companion;", "", "()V", "DEFAULT_DURATION", "", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "MENU_ID_MORE", "", "PAGE_COUNT", "PAGE_INITIAL_COUNT", "PREFETCH_DISTANCE", "REPORT_EXPOSE_SCROLL_LIMIT", "REQUEST_CODE_BLACK_SESSION", "TAG", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.plugin.finder.conv.f dyY() {
        AppMethodBeat.i(252193);
        com.tencent.mm.plugin.finder.conv.f fVar = this.vHN;
        if (fVar == null) {
            p.btv("dataSource");
        }
        AppMethodBeat.o(252193);
        return fVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class e implements MStorage.IOnStorageChange {
        final /* synthetic */ FinderConversationParentUI vHU;

        e(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, final MStorageEventData mStorageEventData) {
            AppMethodBeat.i(252183);
            if (mStorageEventData.obj instanceof com.tencent.mm.plugin.finder.conv.c) {
                Object obj = mStorageEventData.obj;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
                    AppMethodBeat.o(252183);
                    throw tVar;
                }
                com.tencent.mm.plugin.finder.conv.c cVar = (com.tencent.mm.plugin.finder.conv.c) obj;
                if (cVar.field_scene != this.vHU.vHM) {
                    Log.i("Finder.FinderConversationParentUI", "conv.field_scene:" + cVar.field_scene + " != conveScene:" + this.vHU.vHM);
                    AppMethodBeat.o(252183);
                    return;
                }
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderConversationParentUI.e.AnonymousClass1 */
                    final /* synthetic */ e vHW;

                    {
                        this.vHW = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        int[] iArr;
                        AppMethodBeat.i(252182);
                        Log.i("Finder.FinderConversationParentUI", "[onConversationStorageChange] convScene = " + this.vHW.vHU.vHM + ", convType = " + this.vHW.vHU.vHL + ",eventData.eventId = " + mStorageEventData.eventId + ',');
                        switch (mStorageEventData.eventId) {
                            case 1:
                            case 2:
                                com.tencent.mm.plugin.finder.conv.d dVar = this.vHW.vHU.vHP;
                                Object obj = mStorageEventData.obj;
                                if (obj != null) {
                                    dVar.a((com.tencent.mm.plugin.finder.conv.c) obj);
                                    break;
                                } else {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
                                    AppMethodBeat.o(252182);
                                    throw tVar;
                                }
                            case 3:
                            case 4:
                                com.tencent.mm.plugin.finder.conv.d dVar2 = this.vHW.vHU.vHP;
                                com.tencent.mm.plugin.finder.conv.f dyY = this.vHW.vHU.dyY();
                                p.h(dyY, "dataSource");
                                int size = dVar2.ppH.size();
                                com.tencent.mm.plugin.finder.storage.e eVar = dyY.tyE;
                                if (dyY.type == 1) {
                                    iArr = dyY.scene == 2 ? new int[]{2, 100} : new int[]{2};
                                } else {
                                    iArr = new int[]{1};
                                }
                                List<com.tencent.mm.plugin.finder.conv.c> a2 = eVar.a(0, size, iArr, dyY.scene);
                                if (a2 != null) {
                                    com.tencent.mm.ac.d.h(new d.e(dVar2, a2));
                                    break;
                                }
                                break;
                            case 5:
                                com.tencent.mm.plugin.finder.conv.d dVar3 = this.vHW.vHU.vHP;
                                Object obj2 = mStorageEventData.obj;
                                if (obj2 != null) {
                                    com.tencent.mm.plugin.finder.conv.c cVar = (com.tencent.mm.plugin.finder.conv.c) obj2;
                                    p.h(cVar, "conv");
                                    if (cVar.field_type != 1 || dVar3.pageType != 1) {
                                        int a3 = kotlin.a.j.a((List) dVar3.ppH, (Object) dVar3.tyt.get(cVar.field_sessionId));
                                        cVar.prepare();
                                        if (a3 >= 0 && a3 < dVar3.ppH.size()) {
                                            dVar3.ppH.set(a3, cVar);
                                            String str = cVar.field_sessionId;
                                            p.g(str, "conv.field_sessionId");
                                            dVar3.tyt.put(str, cVar);
                                            if (a3 >= 0 && a3 < dVar3.ppH.size()) {
                                                dVar3.Il(a3);
                                                break;
                                            }
                                        }
                                    } else {
                                        com.tencent.mm.plugin.finder.conv.c cVar2 = dVar3.tyt.get("findersayhisessionholder");
                                        if (cVar2 != null) {
                                            cVar2.field_unReadCount = 0;
                                            cVar2.field_readStatus = 1;
                                            int indexOf = dVar3.ppH.indexOf(cVar);
                                            if (indexOf >= 0 && indexOf < dVar3.ppH.size()) {
                                                dVar3.Il(indexOf);
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
                                    AppMethodBeat.o(252182);
                                    throw tVar2;
                                }
                                break;
                            case 6:
                                com.tencent.mm.plugin.finder.conv.d dVar4 = this.vHW.vHU.vHP;
                                Object obj3 = mStorageEventData.obj;
                                if (obj3 != null) {
                                    com.tencent.mm.plugin.finder.conv.c cVar3 = (com.tencent.mm.plugin.finder.conv.c) obj3;
                                    p.h(cVar3, "conv");
                                    int a4 = kotlin.a.j.a((List) dVar4.ppH, (Object) dVar4.tyt.get(cVar3.field_sessionId));
                                    if (a4 >= 0 && a4 < dVar4.ppH.size()) {
                                        dVar4.ppH.remove(a4);
                                        dVar4.tyt.remove(cVar3.field_sessionId);
                                        dVar4.In(a4);
                                    }
                                    this.vHW.vHU.dyZ();
                                    break;
                                } else {
                                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
                                    AppMethodBeat.o(252182);
                                    throw tVar3;
                                }
                            case 7:
                                com.tencent.mm.plugin.finder.conv.d dVar5 = this.vHW.vHU.vHP;
                                Object obj4 = mStorageEventData.obj;
                                if (obj4 != null) {
                                    dVar5.a((com.tencent.mm.plugin.finder.conv.c) obj4);
                                    break;
                                } else {
                                    t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
                                    AppMethodBeat.o(252182);
                                    throw tVar4;
                                }
                        }
                        FinderConversationParentUI.b(this.vHW.vHU);
                        x xVar = x.SXb;
                        AppMethodBeat.o(252182);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(252183);
        }
    }

    public void dyZ() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(252194);
        super.onBackPressed();
        AppMethodBeat.o(252194);
    }

    private final void dza() {
        AppMethodBeat.i(252195);
        View findViewById = findViewById(R.id.c35);
        if (findViewById == null) {
            AppMethodBeat.o(252195);
        } else if (this.vHP.getItemCount() == 0) {
            findViewById.setVisibility(0);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t);
            p.g(refreshLoadMoreLayout, "rl_layout");
            refreshLoadMoreLayout.setVisibility(8);
            AppMethodBeat.o(252195);
        } else {
            findViewById.setVisibility(8);
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = (RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t);
            p.g(refreshLoadMoreLayout2, "rl_layout");
            refreshLoadMoreLayout2.setVisibility(0);
            AppMethodBeat.o(252195);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(252196);
        super.onResume();
        com.tencent.mm.plugin.finder.conv.b bVar = this.vHO;
        if (bVar != null) {
            com.tencent.mm.ac.d.a(200, bVar);
            this.vHO = null;
        }
        dza();
        AppMethodBeat.o(252196);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "obj", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class j implements MStorage.IOnStorageChange {
        final /* synthetic */ FinderConversationParentUI vHU;

        j(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(252192);
            Log.i("Finder.FinderConversationParentUI", "[onFinderContactStorageChange]");
            this.vHU.dn(mStorageEventData.obj);
            AppMethodBeat.o(252192);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
    static final class d implements MStorageEx.IOnStorageChange {
        final /* synthetic */ FinderConversationParentUI vHU;

        d(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(252181);
            Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange]");
            this.vHU.dn(obj);
            AppMethodBeat.o(252181);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public void a(Bundle bundle, int i2) {
        int[] iArr;
        AppMethodBeat.i(252197);
        super.a(bundle, i2);
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            aVar.c(Boolean.TRUE);
        }
        this.vHL = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
        this.vHM = getIntent().getIntExtra("KEY_TALKER_SCENE", -1);
        this.vHP.pageType = this.vHL;
        this.vHP.scene = this.vHM;
        Log.i("Finder.FinderConversationParentUI", "[onCreate] scene==" + this.vHL);
        ((n) com.tencent.mm.kernel.g.af(n.class)).m(this.vHQ);
        ((m) com.tencent.mm.kernel.g.af(m.class)).m(this.vHR);
        setBackBtn(new g(this));
        com.tencent.mm.plugin.finder.storage.e conversationStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getConversationStorage();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView, "this");
        recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.setAdapter(this.vHP);
        recyclerView.setItemAnimator(null);
        recyclerView.a(new f(this));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView2, "conversationRecyclerView");
        ViewTreeObserver viewTreeObserver = recyclerView2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new h(this));
        }
        this.vHN = new com.tencent.mm.plugin.finder.conv.f(conversationStorage, this.vHL, this.vHM, this);
        com.tencent.mm.plugin.finder.conv.f fVar = this.vHN;
        if (fVar == null) {
            p.btv("dataSource");
        }
        com.tencent.mm.plugin.finder.storage.e eVar = fVar.tyE;
        if (fVar.type == 1) {
            iArr = fVar.scene == 2 ? new int[]{2, 100} : new int[]{2};
        } else {
            iArr = new int[]{1};
        }
        fVar.tyF.dS(eVar.a(0, 15, iArr, fVar.scene));
        ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).setActionCallback(new i(this));
        if (this.vHM == 1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1473, 11, 1);
            AppMethodBeat.o(252197);
            return;
        }
        if (this.vHM == 2) {
            if (this.vHL == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1473, 12, 1);
                AppMethodBeat.o(252197);
                return;
            } else if (this.vHL == 2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1473, 13, 1);
            }
        }
        AppMethodBeat.o(252197);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderConversationParentUI vHU;

        g(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252186);
            this.vHU.finish();
            AppMethodBeat.o(252186);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$2$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ FinderConversationParentUI vHU;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(252185);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(252185);
        }

        f(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(252184);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            switch (i2) {
                case 0:
                    FinderConversationParentUI.a(this.vHU);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(252184);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ FinderConversationParentUI vHU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(252187);
            FinderConversationParentUI.a(this.vHU);
            RecyclerView recyclerView = (RecyclerView) this.vHU._$_findCachedViewById(R.id.bfy);
            p.g(recyclerView, "conversationRecyclerView");
            ViewTreeObserver viewTreeObserver = recyclerView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(252187);
                return;
            }
            AppMethodBeat.o(252187);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
    public static final class i extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderConversationParentUI vHU;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(252189);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(252189);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252191);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252191);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252190);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252190);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderConversationParentUI finderConversationParentUI) {
            this.vHU = finderConversationParentUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            int[] iArr;
            AppMethodBeat.i(252188);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            com.tencent.mm.plugin.finder.conv.f dyY = this.vHU.dyY();
            int size = this.vHU.vHP.ppH.size();
            com.tencent.mm.plugin.finder.storage.e eVar = dyY.tyE;
            if (dyY.type == 1) {
                iArr = dyY.scene == 2 ? new int[]{2, 100} : new int[]{2};
            } else {
                iArr = new int[]{1};
            }
            dyY.tyF.dT(eVar.a(size, 60, iArr, dyY.scene));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(252188);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public void anv() {
        AppMethodBeat.i(252198);
        super.anv();
        setMMTitle(dzb());
        AppMethodBeat.o(252198);
    }

    public int dzb() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.conv.f.b
    public final void dS(List<com.tencent.mm.plugin.finder.conv.c> list) {
        AppMethodBeat.i(252199);
        p.h(list, "data");
        this.vHP.dR(list);
        MMProcessBar mMProcessBar = (MMProcessBar) _$_findCachedViewById(R.id.ep7);
        p.g(mMProcessBar, "loadingIcon");
        if (mMProcessBar.getVisibility() == 0) {
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t);
            p.g(refreshLoadMoreLayout, "rl_layout");
            if (refreshLoadMoreLayout.getVisibility() != 0) {
                MMProcessBar mMProcessBar2 = (MMProcessBar) _$_findCachedViewById(R.id.ep7);
                p.g(mMProcessBar2, "loadingIcon");
                mMProcessBar2.setVisibility(8);
                RefreshLoadMoreLayout refreshLoadMoreLayout2 = (RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t);
                p.g(refreshLoadMoreLayout2, "rl_layout");
                refreshLoadMoreLayout2.setVisibility(0);
            }
        }
        if (list.size() < 15) {
            ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).setEnableLoadMore(false);
        }
        AppMethodBeat.o(252199);
    }

    @Override // com.tencent.mm.plugin.finder.conv.f.b
    public final void dT(List<com.tencent.mm.plugin.finder.conv.c> list) {
        boolean z;
        AppMethodBeat.i(252200);
        p.h(list, "data");
        RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
        RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(RefreshLoadMoreLayout.c.Rmn);
        cVar.jLE = false;
        if (!list.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        cVar.Rmj = z;
        cVar.Rmk = list.size();
        this.vHP.dR(list);
        ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).onPreFinishLoadMoreSmooth(cVar);
        AppMethodBeat.o(252200);
    }

    @Override // com.tencent.mm.j.a.b, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void anx() {
        AppMethodBeat.i(252201);
        super.anx();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView, "conversationRecyclerView");
        recyclerView.setLayoutFrozen(true);
        AppMethodBeat.o(252201);
    }

    @Override // com.tencent.mm.j.a.b, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public boolean any() {
        AppMethodBeat.i(252202);
        super.any();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView, "conversationRecyclerView");
        recyclerView.setLayoutFrozen(false);
        AppMethodBeat.o(252202);
        return true;
    }

    public final void dn(Object obj) {
        T t;
        T t2;
        String str;
        boolean z;
        AppMethodBeat.i(252203);
        if (obj instanceof String) {
            if (((CharSequence) obj).length() > 0) {
                LinkedList<com.tencent.mm.plugin.finder.conv.c> linkedList = this.vHP.ppH;
                if (linkedList != null) {
                    Iterator<T> it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next = it.next();
                        T t3 = next;
                        as asVar = t3.contact;
                        if (asVar != null) {
                            str = asVar.getUsername();
                        } else {
                            str = null;
                        }
                        if (p.j(str, obj) || p.j(((com.tencent.mm.plugin.finder.conv.c) t3).field_talker, obj)) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            t2 = next;
                            break;
                        }
                    }
                    t = t2;
                } else {
                    t = null;
                }
                if (t != null) {
                    Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange] username=".concat(String.valueOf(obj)));
                    com.tencent.mm.plugin.finder.conv.d dVar = this.vHP;
                    p.h(t, "conv");
                    t.prepare();
                    int indexOf = dVar.ppH.indexOf(t);
                    if (indexOf >= 0 && indexOf < dVar.ppH.size()) {
                        dVar.Il(indexOf);
                    }
                }
            }
        }
        AppMethodBeat.o(252203);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(252204);
        super.onDestroy();
        ((m) com.tencent.mm.kernel.g.af(m.class)).l(this.vHR);
        ((n) com.tencent.mm.kernel.g.af(n.class)).l(this.vHQ);
        com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        com.tencent.mm.plugin.finder.report.d.c(fH != null ? fH.dIx() : null);
        AppMethodBeat.o(252204);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return 0;
    }

    public static final /* synthetic */ void a(FinderConversationParentUI finderConversationParentUI) {
        com.tencent.mm.plugin.finder.conv.c cVar;
        String str;
        AppMethodBeat.i(252207);
        RecyclerView recyclerView = (RecyclerView) finderConversationParentUI._$_findCachedViewById(R.id.bfy);
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(252207);
            throw tVar;
        }
        int ks = ((LinearLayoutManager) layoutManager).ks();
        RecyclerView recyclerView2 = (RecyclerView) finderConversationParentUI._$_findCachedViewById(R.id.bfy);
        RecyclerView.LayoutManager layoutManager2 = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        if (layoutManager2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(252207);
            throw tVar2;
        }
        int ku = ((LinearLayoutManager) layoutManager2).ku();
        Log.i("Finder.FinderConversationParentUI", "reportChatExpose:" + ks + "--" + ku);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (ks < 0 || ku < ks) {
            AppMethodBeat.o(252207);
            return;
        }
        if (ks <= ku) {
            while (true) {
                if (finderConversationParentUI.vHP instanceof com.tencent.mm.plugin.finder.conv.g) {
                    com.tencent.mm.plugin.finder.conv.d dVar = finderConversationParentUI.vHP;
                    if (dVar == null) {
                        t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversationFirstFixAdapter");
                        AppMethodBeat.o(252207);
                        throw tVar3;
                    }
                    cVar = ((com.tencent.mm.plugin.finder.conv.g) dVar).Ip(ks);
                } else {
                    LinkedList<com.tencent.mm.plugin.finder.conv.c> linkedList = finderConversationParentUI.vHP.ppH;
                    cVar = linkedList != null ? linkedList.get(ks) : null;
                }
                if (cVar == null || (str = cVar.field_sessionId) == null) {
                    str = "";
                }
                if (!Util.isNullOrNil(str)) {
                    linkedHashSet.add(str);
                }
                if (ks == ku) {
                    break;
                }
                ks++;
            }
        }
        Log.i("Finder.FinderConversationParentUI", "pageSet" + linkedHashSet + " size:" + linkedHashSet.size());
        com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
        com.tencent.mm.plugin.finder.report.d.n(linkedHashSet);
        AppMethodBeat.o(252207);
    }
}
