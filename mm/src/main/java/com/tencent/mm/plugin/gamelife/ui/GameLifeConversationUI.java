package com.tencent.mm.plugin.gamelife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.c;
import com.tencent.mm.plugin.gamelife.ui.e;
import com.tencent.mm.plugin.gamelife.ui.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001aH\u0004J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J\b\u0010&\u001a\u00020\u0015H\u0014J\b\u0010'\u001a\u00020\u0015H\u0016J\u0012\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u0015H\u0014J\b\u0010,\u001a\u00020\u0015H\u0004J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\tH\u0016J \u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeChattingCompatUI;", "Lcom/tencent/mm/plugin/gamelife/ui/IGameLifeContract$IConversationView;", "()V", "conversationAdapter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "emptyCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeEmptyCoverView;", "enableLoadMore", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "loadingCoverView", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeLoadingCoverView;", "presenter", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationPresenter;", "disableLoadMore", "", "now", "dismissLoadingView", "finishLoadMore", "size", "", "getLayoutId", "getVisibleItemRange", "Lkotlin/Pair;", "initialLoadFailed", "isChattingClosed", "loadMoreFailed", "onBottomTabWidgetInstalled", "bottomMargin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "refreshGameCenterMsg", "showEmptyView", "show", "startChatting", "sessionId", "", "selfUsername", "talker", "Companion", "plugin-gamelife_release"})
public class GameLifeConversationUI extends GameLifeChattingCompatUI implements h.a {
    public static final a ydm = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final kotlin.f vat = kotlin.g.ah(new d(this));
    private final b ydh = new b();
    public final e ydi = new e(this, this.ydh);
    private boolean ydj = true;
    public GameLifeLoadingCoverView ydk;
    public GameLifeEmptyCoverView ydl;

    static {
        AppMethodBeat.i(241517);
        AppMethodBeat.o(241517);
    }

    private final LinearLayoutManager getLayoutManager() {
        AppMethodBeat.i(241502);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.vat.getValue();
        AppMethodBeat.o(241502);
        return linearLayoutManager;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(241521);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(241521);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(241520);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(241520);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameLifeConversationUI() {
        AppMethodBeat.i(241516);
        AppMethodBeat.o(241516);
    }

    public static final /* synthetic */ GameLifeEmptyCoverView c(GameLifeConversationUI gameLifeConversationUI) {
        AppMethodBeat.i(241518);
        GameLifeEmptyCoverView gameLifeEmptyCoverView = gameLifeConversationUI.ydl;
        if (gameLifeEmptyCoverView == null) {
            p.btv("emptyCoverView");
        }
        AppMethodBeat.o(241518);
        return gameLifeEmptyCoverView;
    }

    public static final /* synthetic */ GameLifeLoadingCoverView d(GameLifeConversationUI gameLifeConversationUI) {
        AppMethodBeat.i(241519);
        GameLifeLoadingCoverView gameLifeLoadingCoverView = gameLifeConversationUI.ydk;
        if (gameLifeLoadingCoverView == null) {
            p.btv("loadingCoverView");
        }
        AppMethodBeat.o(241519);
        return gameLifeLoadingCoverView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$Companion;", "", "()V", "GAME_CENTER_ITEM_AREA_HEIGHT", "", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(241503);
        super.onCreate(bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bg2);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this.ydh);
        recyclerView.setItemAnimator(null);
        ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).setActionCallback(new g(this));
        GameLifeLoadingCoverView gameLifeLoadingCoverView = new GameLifeLoadingCoverView(this, null, 6, (byte) 0);
        gameLifeLoadingCoverView.setOnClickListener(new f(this));
        this.ydk = gameLifeLoadingCoverView;
        GameLifeEmptyCoverView gameLifeEmptyCoverView = new GameLifeEmptyCoverView(this, null, 6, (byte) 0);
        gameLifeEmptyCoverView.setVisibility(8);
        this.ydl = gameLifeEmptyCoverView;
        com.tencent.mm.plugin.gamelife.i.a aVar = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.plugin.gamelife.i.a.GN((long) getIntent().getIntExtra("game_report_from_scene", 0));
        e eVar = this.ydi;
        b bVar = eVar.ydb;
        e.i iVar = eVar.ycY;
        bVar.ycB.ycF = iVar;
        bVar.ycF = iVar;
        b bVar2 = eVar.ydb;
        c cVar = new c(e.g.ydg);
        bVar2.ycB.ycG = cVar;
        bVar2.ycG = cVar;
        eVar.ycX.m(eVar.vHQ);
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).m(eVar.ycZ);
        eVar.dXp();
        AppMethodBeat.o(241503);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-gamelife_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ GameLifeConversationUI ydn;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(241499);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(241499);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(241500);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(241500);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(GameLifeConversationUI gameLifeConversationUI) {
            this.ydn = gameLifeConversationUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(241497);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            this.ydn.ydi.onLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(241497);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(241498);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            ((RefreshLoadMoreLayout) this.ydn._$_findCachedViewById(R.id.h7t)).setEnableLoadMore(this.ydn.ydj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(241498);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(241504);
        super.onNewIntent(intent);
        if (intent != null) {
            com.tencent.mm.plugin.gamelife.i.a aVar = com.tencent.mm.plugin.gamelife.i.a.ycs;
            com.tencent.mm.plugin.gamelife.i.a.GN((long) intent.getIntExtra("game_report_from_scene", 0));
        }
        AppMethodBeat.o(241504);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.atc;
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void at(String str, String str2, String str3) {
        AppMethodBeat.i(241505);
        p.h(str, "sessionId");
        p.h(str2, "selfUsername");
        p.h(str3, "talker");
        Intent intent = new Intent();
        intent.putExtra("Chat_Self", str2);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        com.tencent.mm.br.c.f(getContext(), ".ui.chatting.ChattingUI", intent);
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAS(str3);
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAS(str2);
        AppMethodBeat.o(241505);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onResume() {
        o<Integer, Integer> oVar;
        int intValue;
        AppMethodBeat.i(241506);
        super.onResume();
        e eVar = this.ydi;
        c.a aVar = com.tencent.mm.game.report.c.hhl;
        com.tencent.mm.plugin.gamelife.i.a aVar2 = com.tencent.mm.plugin.gamelife.i.a.ycs;
        long dXm = com.tencent.mm.plugin.gamelife.i.a.dXm();
        c.a.a(2, 0, 0, 1, dXm).bfK();
        c.a.a(2, 201, 0, 1, dXm).bfK();
        if (eVar.ycW) {
            eVar.ycW = false;
            AppMethodBeat.o(241506);
            return;
        }
        com.tencent.mm.plugin.gamelife.i.a aVar3 = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.plugin.gamelife.i.a.GN(301);
        eVar.dXq();
        eVar.ydb.dXn();
        h.a aVar4 = eVar.yda;
        if (aVar4 != null) {
            if (aVar4.anw()) {
                h.a aVar5 = eVar.yda;
                if (aVar5 != null) {
                    oVar = aVar5.dXu();
                } else {
                    oVar = null;
                }
                if (oVar == null) {
                    AppMethodBeat.o(241506);
                    return;
                }
                if (oVar.first.intValue() < 2) {
                    intValue = 2;
                } else {
                    intValue = oVar.first.intValue();
                }
                int intValue2 = oVar.second.intValue();
                if (intValue <= intValue2) {
                    while (true) {
                        com.tencent.mm.plugin.gamelife.e.a OD = eVar.ydb.OD(intValue);
                        if (!OD.dXj()) {
                            com.tencent.mm.plugin.gamelife.a.a aAR = ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(OD.field_selfUserName);
                            if (aAR != null) {
                                c.a aVar6 = com.tencent.mm.game.report.c.hhl;
                                int i2 = (intValue - 2) + 1;
                                int size = eVar.ydb.ppH.size();
                                String str = OD.field_sessionId;
                                p.g(str, "item.field_sessionId");
                                long dWY = (long) aAR.dWY();
                                String str2 = OD.field_selfUserName;
                                p.g(str2, "item.field_selfUserName");
                                com.tencent.mm.plugin.gamelife.d.a aVar7 = OD.ybV;
                                if (aVar7 == null) {
                                    p.hyc();
                                }
                                long j2 = (long) aVar7.field_accountType;
                                String str3 = OD.field_talker;
                                p.g(str3, "item.field_talker");
                                long dXi = OD.dXi();
                                com.tencent.mm.plugin.gamelife.i.a aVar8 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                                c.a.a(i2, 1, size, str, dWY, str2, j2, str3, dXi, com.tencent.mm.plugin.gamelife.i.a.dXm());
                            }
                        } else {
                            c.a aVar9 = com.tencent.mm.game.report.c.hhl;
                            int size2 = eVar.ydb.ppH.size();
                            String str4 = OD.field_sessionId;
                            p.g(str4, "item.field_sessionId");
                            long dXi2 = OD.dXi();
                            com.tencent.mm.plugin.gamelife.i.a aVar10 = com.tencent.mm.plugin.gamelife.i.a.ycs;
                            c.a.a((intValue - 2) + 1, 1, size2, str4, 0, "", 0, "", dXi2, com.tencent.mm.plugin.gamelife.i.a.dXm());
                        }
                        if (intValue == intValue2) {
                            break;
                        }
                        intValue++;
                    }
                }
            }
            AppMethodBeat.o(241506);
            return;
        }
        AppMethodBeat.o(241506);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onDestroy() {
        AppMethodBeat.i(241507);
        super.onDestroy();
        e eVar = this.ydi;
        eVar.yda = null;
        eVar.ycX.l(eVar.vHQ);
        ((com.tencent.mm.plugin.gamelife.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).l(eVar.ycZ);
        AppMethodBeat.o(241507);
    }

    @Override // com.tencent.mm.j.a.c
    public void onFinish() {
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void mB(boolean z) {
        AppMethodBeat.i(241508);
        com.tencent.mm.ac.d.h(new h(this, z));
        AppMethodBeat.o(241508);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void dXr() {
        AppMethodBeat.i(241509);
        com.tencent.mm.ac.d.h(new b(this));
        AppMethodBeat.o(241509);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void dXs() {
        AppMethodBeat.i(241510);
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(241510);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void OF(int i2) {
        AppMethodBeat.i(241511);
        ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).apT(i2);
        AppMethodBeat.o(241511);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void dXt() {
        AppMethodBeat.i(241512);
        com.tencent.mm.ac.d.h(new e(this));
        AppMethodBeat.o(241512);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(GameLifeConversationUI gameLifeConversationUI) {
            super(0);
            this.ydn = gameLifeConversationUI;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$1$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ e ydo;

            a(e eVar) {
                this.ydo = eVar;
            }

            public final void onClick(View view) {
                View findViewById;
                AppMethodBeat.i(241494);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.ydo.ydn.ydi.onLoadMore();
                p.g(view, LocaleUtil.ITALIAN);
                view.setVisibility(8);
                View loadMoreFooter = ((RefreshLoadMoreLayout) this.ydo.ydn._$_findCachedViewById(R.id.h7t)).getLoadMoreFooter();
                if (!(loadMoreFooter == null || (findViewById = loadMoreFooter.findViewById(R.id.ep6)) == null)) {
                    findViewById.setVisibility(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$loadMoreFailed$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(241494);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            View findViewById2;
            AppMethodBeat.i(241495);
            View loadMoreFooter = ((RefreshLoadMoreLayout) this.ydn._$_findCachedViewById(R.id.h7t)).getLoadMoreFooter();
            if (!(loadMoreFooter == null || (findViewById2 = loadMoreFooter.findViewById(R.id.ep6)) == null)) {
                findViewById2.setVisibility(8);
            }
            View loadMoreFooter2 = ((RefreshLoadMoreLayout) this.ydn._$_findCachedViewById(R.id.h7t)).getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (findViewById = loadMoreFooter2.findViewById(R.id.epg)) == null)) {
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new a(this));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(241495);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final void pY(boolean z) {
        AppMethodBeat.i(241513);
        this.ydj = false;
        if (z) {
            ((RefreshLoadMoreLayout) _$_findCachedViewById(R.id.h7t)).setEnableLoadMore(false);
        }
        AppMethodBeat.o(241513);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final o<Integer, Integer> dXu() {
        AppMethodBeat.i(241514);
        o<Integer, Integer> oVar = new o<>(Integer.valueOf(getLayoutManager().ks()), Integer.valueOf(getLayoutManager().ku()));
        Log.d("GameLife.ConversationUI", "range " + oVar.first.intValue() + " - " + oVar.second.intValue());
        AppMethodBeat.o(241514);
        return oVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<LinearLayoutManager> {
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(GameLifeConversationUI gameLifeConversationUI) {
            super(0);
            this.ydn = gameLifeConversationUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayoutManager invoke() {
            AppMethodBeat.i(241493);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
            AppMethodBeat.o(241493);
            return linearLayoutManager;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/gamelife/ui/GameLifeConversationUI$onCreate$3$1"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(GameLifeConversationUI gameLifeConversationUI) {
            super(0);
            this.ydn = gameLifeConversationUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241496);
            this.ydn.ydi.dXp();
            x xVar = x.SXb;
            AppMethodBeat.o(241496);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean rti;
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(GameLifeConversationUI gameLifeConversationUI, boolean z) {
            super(0);
            this.ydn = gameLifeConversationUI;
            this.rti = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(241501);
            GameLifeEmptyCoverView c2 = GameLifeConversationUI.c(this.ydn);
            if (this.rti) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            c2.setVisibility(i2);
            x xVar = x.SXb;
            AppMethodBeat.o(241501);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GameLifeConversationUI gameLifeConversationUI) {
            super(0);
            this.ydn = gameLifeConversationUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241491);
            GameLifeConversationUI.d(this.ydn).setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(241491);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ GameLifeConversationUI ydn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(GameLifeConversationUI gameLifeConversationUI) {
            super(0);
            this.ydn = gameLifeConversationUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241492);
            GameLifeLoadingCoverView d2 = GameLifeConversationUI.d(this.ydn);
            View view = d2.hSw;
            p.g(view, "loadingView");
            view.setVisibility(8);
            View view2 = d2.ydq;
            p.g(view2, "loadingFailView");
            view2.setVisibility(0);
            x xVar = x.SXb;
            AppMethodBeat.o(241492);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.h.a
    public final boolean anw() {
        AppMethodBeat.i(241515);
        com.tencent.mm.j.a aVar = this.vQb;
        if (aVar != null) {
            boolean anw = aVar.anw();
            AppMethodBeat.o(241515);
            return anw;
        }
        AppMethodBeat.o(241515);
        return true;
    }
}
