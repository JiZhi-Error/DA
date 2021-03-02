package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.textstatus.g.n;
import com.tencent.mm.plugin.textstatus.g.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0005$%&'(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0014J\b\u0010#\u001a\u00020\u001fH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rvLikeList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scene", "", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "AllMsgLoader", "Companion", "DataLoader", "HistoryItemLoader", "NotificationMsgLoader", "plugin-textstatus_release"})
public final class TextStatusLikeListActivity extends MMActivity {
    public static final b Gfx = new b((byte) 0);
    private boolean Gdl = true;
    private WxRecyclerView Gfv;
    private c Gfw;
    private ArrayList<com.tencent.mm.view.recyclerview.a> kgc = new ArrayList<>();
    private RefreshLoadMoreLayout qgY;
    private int scene;

    static {
        AppMethodBeat.i(216648);
        AppMethodBeat.o(216648);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion;", "", "()V", "KEY_SCENE", "", "KEY_STATUS_ID", "SCENE_HISTORY", "", "SCENE_SELF_ALL_HISTORY", "SCENE_UNREAD", "TAG", "startForHistory", "", "context", "Landroid/content/Context;", "statusId", "startForSelfAllHistory", "startForUnRead", "plugin-textstatus_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static void hs(Context context) {
            AppMethodBeat.i(216626);
            p.h(context, "context");
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            if (com.tencent.mm.plugin.textstatus.b.f.fvN().ctM() <= 0) {
                AppMethodBeat.o(216626);
                return;
            }
            Intent intent = new Intent(context, TextStatusLikeListActivity.class);
            intent.putExtra("scene", 1);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(216626);
        }
    }

    public TextStatusLikeListActivity() {
        AppMethodBeat.i(216647);
        AppMethodBeat.o(216647);
    }

    public static final /* synthetic */ c a(TextStatusLikeListActivity textStatusLikeListActivity) {
        AppMethodBeat.i(216649);
        c cVar = textStatusLikeListActivity.Gfw;
        if (cVar == null) {
            p.btv("dataLoader");
        }
        AppMethodBeat.o(216649);
        return cVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout b(TextStatusLikeListActivity textStatusLikeListActivity) {
        AppMethodBeat.i(216650);
        RefreshLoadMoreLayout refreshLoadMoreLayout = textStatusLikeListActivity.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        AppMethodBeat.o(216650);
        return refreshLoadMoreLayout;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2k;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(216644);
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("scene", 0);
        setMMTitle(this.scene == 0 ? R.string.hng : R.string.hnk);
        setBackBtn(new g(this));
        View findViewById = findViewById(R.id.h7t);
        p.g(findViewById, "findViewById(R.id.rl_layout)");
        this.qgY = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout.setActionCallback(new h(this));
        View findViewById2 = findViewById(R.id.gy2);
        p.g(findViewById2, "findViewById(R.id.recycler_view)");
        this.Gfv = (WxRecyclerView) findViewById2;
        WxRecyclerView wxRecyclerView = this.Gfv;
        if (wxRecyclerView == null) {
            p.btv("rvLikeList");
        }
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new f(), this.kgc);
        WxRecyclerView wxRecyclerView2 = this.Gfv;
        if (wxRecyclerView2 == null) {
            p.btv("rvLikeList");
        }
        wxRecyclerView2.setAdapter(wxRecyclerAdapter);
        switch (this.scene) {
            case 0:
                String stringExtra = getIntent().getStringExtra("status_id");
                p.g(stringExtra, "statusId");
                RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
                if (refreshLoadMoreLayout2 == null) {
                    p.btv("mRefreshLayout");
                }
                this.Gfw = new d(stringExtra, wxRecyclerAdapter, refreshLoadMoreLayout2);
                c cVar = this.Gfw;
                if (cVar == null) {
                    p.btv("dataLoader");
                }
                cVar.epE();
                AppMethodBeat.o(216644);
                return;
            case 1:
                RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.qgY;
                if (refreshLoadMoreLayout3 == null) {
                    p.btv("mRefreshLayout");
                }
                this.Gfw = new e(wxRecyclerAdapter, refreshLoadMoreLayout3);
                c cVar2 = this.Gfw;
                if (cVar2 == null) {
                    p.btv("dataLoader");
                }
                cVar2.epE();
                RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.qgY;
                if (refreshLoadMoreLayout4 == null) {
                    p.btv("mRefreshLayout");
                }
                refreshLoadMoreLayout4.setEnableRefresh(false);
                AppMethodBeat.o(216644);
                return;
            case 2:
                RefreshLoadMoreLayout refreshLoadMoreLayout5 = this.qgY;
                if (refreshLoadMoreLayout5 == null) {
                    p.btv("mRefreshLayout");
                }
                this.Gfw = new a(wxRecyclerAdapter, refreshLoadMoreLayout5);
                c cVar3 = this.Gfw;
                if (cVar3 == null) {
                    p.btv("dataLoader");
                }
                cVar3.epE();
                RefreshLoadMoreLayout refreshLoadMoreLayout6 = this.qgY;
                if (refreshLoadMoreLayout6 == null) {
                    p.btv("mRefreshLayout");
                }
                refreshLoadMoreLayout6.setEnableRefresh(false);
                break;
        }
        AppMethodBeat.o(216644);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ TextStatusLikeListActivity GfD;

        g(TextStatusLikeListActivity textStatusLikeListActivity) {
            this.GfD = textStatusLikeListActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(216638);
            this.GfD.onBackPressed();
            AppMethodBeat.o(216638);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
    public static final class h extends RefreshLoadMoreLayout.a {
        final /* synthetic */ TextStatusLikeListActivity GfD;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(216642);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(216642);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(216643);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(216643);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(TextStatusLikeListActivity textStatusLikeListActivity) {
            this.GfD = textStatusLikeListActivity;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(216640);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            com.tencent.mm.ac.d.h(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(216640);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(216641);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            if (!TextStatusLikeListActivity.a(this.GfD).fwE()) {
                RefreshLoadMoreLayout.e(TextStatusLikeListActivity.b(this.GfD));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(216641);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ h GfE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar) {
                super(0);
                this.GfE = hVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(216639);
                TextStatusLikeListActivity.a(this.GfE.GfD).epE();
                x xVar = x.SXb;
                AppMethodBeat.o(216639);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class f implements com.tencent.mm.view.recyclerview.f {
        f() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(216637);
            switch (i2) {
                case 0:
                    com.tencent.mm.plugin.textstatus.b.b.a aVar = new com.tencent.mm.plugin.textstatus.b.b.a();
                    AppMethodBeat.o(216637);
                    return aVar;
                default:
                    com.tencent.mm.plugin.textstatus.b.b.b bVar = new com.tencent.mm.plugin.textstatus.b.b.b();
                    AppMethodBeat.o(216637);
                    return bVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(216645);
        super.onPause();
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.c fvN = com.tencent.mm.plugin.textstatus.b.f.fvN();
        fvN.db.execSQL(com.tencent.mm.plugin.textstatus.f.f.c.TABLE, "update " + com.tencent.mm.plugin.textstatus.f.f.c.TABLE + " set Read = 1 where Read != 1 ");
        AppMethodBeat.o(216645);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(216646);
        super.onDestroy();
        c cVar = this.Gfw;
        if (cVar == null) {
            p.btv("dataLoader");
        }
        cVar.release();
        AppMethodBeat.o(216646);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\"\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "hasMoreData", "", "loadNextPage", "", "release", "Companion", "plugin-textstatus_release"})
    public static abstract class c {
        public static final a Gfy = new a((byte) 0);
        WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;

        public abstract void epE();

        public abstract boolean fwE();

        public abstract void release();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader$Companion;", "", "()V", "NUM_PER_PAGE", "", "plugin-textstatus_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public c(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter) {
            p.h(wxRecyclerAdapter, "adapter");
            this.tFp = wxRecyclerAdapter;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursor", "Landroid/database/Cursor;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "", "loadNextPage", "", "reInit", "release", "plugin-textstatus_release"})
    static final class e extends c {
        private final RefreshLoadMoreLayout Gdo;
        private Cursor dIU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(wxRecyclerAdapter);
            p.h(wxRecyclerAdapter, "adapter");
            p.h(refreshLoadMoreLayout, "refreahLayout");
            AppMethodBeat.i(216635);
            this.Gdo = refreshLoadMoreLayout;
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            ISQLiteDatabase iSQLiteDatabase = com.tencent.mm.plugin.textstatus.b.f.fvN().db;
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            Cursor rawQuery = iSQLiteDatabase.rawQuery("select rowid, * from " + com.tencent.mm.plugin.textstatus.f.f.c.TABLE + " where Read != 1 and HashUserName != ? order by CreateTime DESC ", new String[]{ceA});
            p.g(rawQuery, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
            this.dIU = rawQuery;
            View inflate = aa.jQ(wxRecyclerAdapter.getRecyclerView().getContext()).inflate(R.layout.c2l, (ViewGroup) wxRecyclerAdapter.getRecyclerView(), false);
            ((TextView) inflate.findViewById(R.id.d8h)).setText(R.string.dv9);
            p.g(inflate, "footer");
            final g.b bVar = wxRecyclerAdapter.g(inflate, Integer.MAX_VALUE, true);
            inflate.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.e.AnonymousClass1 */
                final /* synthetic */ e GfB;

                {
                    this.GfB = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(216631);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    e.a(this.GfB);
                    wxRecyclerAdapter.U(bVar.lT(), true);
                    this.GfB.epE();
                    com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                    com.tencent.mm.plugin.textstatus.k.a.a(11, (String) null, (String) null, 6);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(216631);
                }
            });
            AppMethodBeat.o(216635);
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void epE() {
            AppMethodBeat.i(216632);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (cursor != null) {
                for (int i2 = 0; i2 < 10; i2++) {
                    Cursor cursor2 = this.dIU;
                    if (cursor2 == null) {
                        p.btv("cursor");
                    }
                    if (!cursor2.moveToNext()) {
                        break;
                    }
                    com.tencent.mm.plugin.textstatus.f.f.b bVar = new com.tencent.mm.plugin.textstatus.f.f.b();
                    Cursor cursor3 = this.dIU;
                    if (cursor3 == null) {
                        p.btv("cursor");
                    }
                    bVar.convertFrom(cursor3);
                    this.tFp.data.add(new com.tencent.mm.plugin.textstatus.f.c.b(bVar));
                }
            }
            this.Gdo.apT(0);
            this.tFp.notifyDataSetChanged();
            AppMethodBeat.o(216632);
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final boolean fwE() {
            AppMethodBeat.i(216633);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (!(cursor != null ? Boolean.valueOf(cursor.isAfterLast()) : null).booleanValue()) {
                AppMethodBeat.o(216633);
                return true;
            }
            AppMethodBeat.o(216633);
            return false;
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void release() {
            AppMethodBeat.i(216634);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (cursor != null) {
                cursor.close();
                AppMethodBeat.o(216634);
                return;
            }
            AppMethodBeat.o(216634);
        }

        public static final /* synthetic */ void a(e eVar) {
            AppMethodBeat.i(216636);
            Cursor cursor = eVar.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (cursor != null) {
                cursor.close();
            }
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            ISQLiteDatabase iSQLiteDatabase = com.tencent.mm.plugin.textstatus.b.f.fvN().db;
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            Cursor rawQuery = iSQLiteDatabase.rawQuery("select rowid, * from " + com.tencent.mm.plugin.textstatus.f.f.c.TABLE + " where Read = 1 and HashUserName != ? order by CreateTime DESC ", new String[]{ceA});
            p.g(rawQuery, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
            eVar.dIU = rawQuery;
            AppMethodBeat.o(216636);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$HistoryItemLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "statusID", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Ljava/lang/String;Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getStatusID", "()Ljava/lang/String;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
    static final class d extends c {
        private com.tencent.mm.bw.b Gdn;
        final RefreshLoadMoreLayout Gdo;
        final String Gfz;
        private final i gNh;
        private boolean tuG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(wxRecyclerAdapter);
            p.h(str, "statusID");
            p.h(wxRecyclerAdapter, "adapter");
            p.h(refreshLoadMoreLayout, "refreahLayout");
            AppMethodBeat.i(216630);
            this.Gfz = str;
            this.Gdo = refreshLoadMoreLayout;
            this.gNh = new a(this, wxRecyclerAdapter);
            com.tencent.mm.kernel.g.azz().a(6621, this.gNh);
            AppMethodBeat.o(216630);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
        static final class a implements i {
            final /* synthetic */ d GfA;
            final /* synthetic */ WxRecyclerAdapter uMv;

            a(d dVar, WxRecyclerAdapter wxRecyclerAdapter) {
                this.GfA = dVar;
                this.uMv = wxRecyclerAdapter;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                n nVar;
                AppMethodBeat.i(216627);
                p.h(qVar, "netSceneBase");
                if (i2 == 0 && i3 == 0 && (nVar = ((com.tencent.mm.plugin.textstatus.f.f) qVar).FYY) != null) {
                    this.GfA.Gdn = nVar.GaF;
                    this.GfA.tuG = nVar.GaH;
                    LinkedList<u> linkedList = nVar.GaK;
                    if (linkedList != null) {
                        for (T t : linkedList) {
                            if (t != null) {
                                this.uMv.data.add(new com.tencent.mm.plugin.textstatus.f.c.a(this.GfA.Gfz, t));
                            }
                        }
                    }
                    this.uMv.notifyDataSetChanged();
                }
                this.GfA.Gdo.apT(0);
                AppMethodBeat.o(216627);
            }
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void epE() {
            AppMethodBeat.i(216628);
            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.f(this.Gfz, this.Gdn));
            AppMethodBeat.o(216628);
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final boolean fwE() {
            return this.tuG;
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void release() {
            AppMethodBeat.i(216629);
            com.tencent.mm.kernel.g.azz().b(6621, this.gNh);
            AppMethodBeat.o(216629);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$AllMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursor", "Landroid/database/Cursor;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "", "loadNextPage", "", "release", "plugin-textstatus_release"})
    static final class a extends c {
        private final RefreshLoadMoreLayout Gdo;
        private Cursor dIU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(wxRecyclerAdapter);
            p.h(wxRecyclerAdapter, "adapter");
            p.h(refreshLoadMoreLayout, "refreahLayout");
            AppMethodBeat.i(216624);
            this.Gdo = refreshLoadMoreLayout;
            com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            ISQLiteDatabase iSQLiteDatabase = com.tencent.mm.plugin.textstatus.b.f.fvN().db;
            String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
            p.g(ceA, "Account.username()");
            Cursor rawQuery = iSQLiteDatabase.rawQuery("select rowid, * from " + com.tencent.mm.plugin.textstatus.f.f.c.TABLE + " where HashUserName != ? order by CreateTime DESC ", new String[]{ceA});
            p.g(rawQuery, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
            this.dIU = rawQuery;
            AppMethodBeat.o(216624);
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void epE() {
            AppMethodBeat.i(216621);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (cursor != null) {
                for (int i2 = 0; i2 < 10; i2++) {
                    Cursor cursor2 = this.dIU;
                    if (cursor2 == null) {
                        p.btv("cursor");
                    }
                    if (!cursor2.moveToNext()) {
                        break;
                    }
                    com.tencent.mm.plugin.textstatus.f.f.b bVar = new com.tencent.mm.plugin.textstatus.f.f.b();
                    Cursor cursor3 = this.dIU;
                    if (cursor3 == null) {
                        p.btv("cursor");
                    }
                    bVar.convertFrom(cursor3);
                    this.tFp.data.add(new com.tencent.mm.plugin.textstatus.f.c.b(bVar));
                }
            }
            this.Gdo.apT(0);
            this.tFp.notifyDataSetChanged();
            AppMethodBeat.o(216621);
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final boolean fwE() {
            AppMethodBeat.i(216622);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (!(cursor != null ? Boolean.valueOf(cursor.isAfterLast()) : null).booleanValue()) {
                AppMethodBeat.o(216622);
                return true;
            }
            AppMethodBeat.o(216622);
            return false;
        }

        @Override // com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.c
        public final void release() {
            AppMethodBeat.i(216623);
            Cursor cursor = this.dIU;
            if (cursor == null) {
                p.btv("cursor");
            }
            if (cursor != null) {
                cursor.close();
                AppMethodBeat.o(216623);
                return;
            }
            AppMethodBeat.o(216623);
        }
    }
}
