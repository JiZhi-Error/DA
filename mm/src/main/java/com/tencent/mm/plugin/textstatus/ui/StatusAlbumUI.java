package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020*H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020*H\u0016J,\u00109\u001a\u00020*2\u0006\u0010:\u001a\u0002022\u0006\u0010;\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020*H\u0002J\b\u0010A\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "hasShowStoryEntry", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickListener", "Landroid/view/View$OnLongClickListener;", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "rvSelfHistory", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealContentView", "", "v", "Landroid/view/View;", "getCal", "Ljava/util/Calendar;", "timeStamp", "", "getLayoutId", "", "initActionBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preData", "supportNavigationSwipeBack", "Companion", "HistoryItemLoader", "plugin-textstatus_release"})
public final class StatusAlbumUI extends MMFragment implements i {
    public static final a Gdm = new a((byte) 0);
    private WxRecyclerView Gdj;
    private b Gdk;
    private boolean Gdl = true;
    private boolean VeR;
    q gut;
    private ArrayList<com.tencent.mm.view.recyclerview.a> kgc = new ArrayList<>();
    private RefreshLoadMoreLayout qgY;
    View.OnLongClickListener tib = new g(this);

    static {
        AppMethodBeat.i(216440);
        AppMethodBeat.o(216440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public StatusAlbumUI() {
        AppMethodBeat.i(216439);
        AppMethodBeat.o(216439);
    }

    public static final /* synthetic */ WxRecyclerView a(StatusAlbumUI statusAlbumUI) {
        AppMethodBeat.i(216441);
        WxRecyclerView wxRecyclerView = statusAlbumUI.Gdj;
        if (wxRecyclerView == null) {
            p.btv("rvSelfHistory");
        }
        AppMethodBeat.o(216441);
        return wxRecyclerView;
    }

    public static final /* synthetic */ b b(StatusAlbumUI statusAlbumUI) {
        AppMethodBeat.i(216442);
        b bVar = statusAlbumUI.Gdk;
        if (bVar == null) {
            p.btv("dataLoader");
        }
        AppMethodBeat.o(216442);
        return bVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout c(StatusAlbumUI statusAlbumUI) {
        AppMethodBeat.i(216443);
        RefreshLoadMoreLayout refreshLoadMoreLayout = statusAlbumUI.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        AppMethodBeat.o(216443);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ void d(StatusAlbumUI statusAlbumUI) {
        AppMethodBeat.i(216444);
        statusAlbumUI.fwl();
        AppMethodBeat.o(216444);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final int getLayoutId() {
        return R.layout.c2x;
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(216434);
        super.onCreate(bundle);
        setMMTitle(R.string.gl);
        setBackBtn(new d(this));
        AppMethodBeat.o(216434);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onDestroy() {
        AppMethodBeat.i(216435);
        super.onDestroy();
        b bVar = this.Gdk;
        if (bVar == null) {
            p.btv("dataLoader");
        }
        com.tencent.mm.kernel.g.azz().b(4245, bVar.gNh);
        com.tencent.mm.kernel.g.azz().b(5967, this);
        AppMethodBeat.o(216435);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StatusAlbumUI Gdq;

        d(StatusAlbumUI statusAlbumUI) {
            this.Gdq = statusAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(216422);
            FragmentActivity activity = this.Gdq.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(216422);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final void dealContentView(View view) {
        String str;
        AppMethodBeat.i(216436);
        p.h(view, "v");
        super.dealContentView(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            p.g(activity, LocaleUtil.ITALIAN);
            ((SecDataUIC) com.tencent.mm.ui.component.a.ko(activity).get(SecDataUIC.class)).a(new com.tencent.mm.plugin.secdata.c(y.class, 9, (byte) 0));
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(activity, 9, y.class);
            if (yVar != null) {
                com.tencent.mm.plugin.textstatus.k.a aVar3 = com.tencent.mm.plugin.textstatus.k.a.VeA;
                y hXs = com.tencent.mm.plugin.textstatus.k.a.hXs();
                if (hXs != null) {
                    str = hXs.sessionId;
                } else {
                    str = null;
                }
                yVar.sessionId = str;
            }
        }
        View findViewById = view.findViewById(R.id.gy2);
        p.g(findViewById, "v.findViewById(R.id.recycler_view)");
        this.Gdj = (WxRecyclerView) findViewById;
        WxRecyclerView wxRecyclerView = this.Gdj;
        if (wxRecyclerView == null) {
            p.btv("rvSelfHistory");
        }
        if (wxRecyclerView != null) {
            getContext();
            wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new c(this), this.kgc, true);
        wxRecyclerAdapter.RrA = new e(this, wxRecyclerAdapter);
        WxRecyclerView wxRecyclerView2 = this.Gdj;
        if (wxRecyclerView2 == null) {
            p.btv("rvSelfHistory");
        }
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setAdapter(wxRecyclerAdapter);
        }
        WxRecyclerView wxRecyclerView3 = this.Gdj;
        if (wxRecyclerView3 == null) {
            p.btv("rvSelfHistory");
        }
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(new f(this));
        }
        View findViewById2 = view.findViewById(R.id.h7t);
        p.g(findViewById2, "v.findViewById(R.id.rl_layout)");
        this.qgY = (RefreshLoadMoreLayout) findViewById2;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.qgY;
        if (refreshLoadMoreLayout == null) {
            p.btv("mRefreshLayout");
        }
        refreshLoadMoreLayout.setActionCallback(new h(this, wxRecyclerAdapter));
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.qgY;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("mRefreshLayout");
        }
        this.Gdk = new b(wxRecyclerAdapter, refreshLoadMoreLayout2);
        b bVar = this.Gdk;
        if (bVar == null) {
            p.btv("dataLoader");
        }
        bVar.epE();
        Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "init OK");
        AppMethodBeat.o(216436);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-textstatus_release"})
    public static final class e implements com.tencent.mm.view.recyclerview.l {
        final /* synthetic */ StatusAlbumUI Gdq;
        final /* synthetic */ WxRecyclerAdapter uMv;

        e(StatusAlbumUI statusAlbumUI, WxRecyclerAdapter wxRecyclerAdapter) {
            this.Gdq = statusAlbumUI;
            this.uMv = wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.view.recyclerview.l
        public final void a(RecyclerView recyclerView, j jVar) {
            AppMethodBeat.i(258443);
            p.h(recyclerView, "recyclerView");
            p.h(jVar, "data");
            if (jVar.tIA >= this.uMv.getItemCount() - 1 && !this.Gdq.VeR) {
                com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(14, (String) null, (String) null, 6);
                this.Gdq.VeR = true;
            }
            AppMethodBeat.o(258443);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
    public static final class f extends RecyclerView.h {
        final /* synthetic */ StatusAlbumUI Gdq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(StatusAlbumUI statusAlbumUI) {
            this.Gdq = statusAlbumUI;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, int i2, RecyclerView recyclerView) {
            RecyclerView.a adapter;
            AppMethodBeat.i(258444);
            p.h(rect, "outRect");
            p.h(recyclerView, "parent");
            WxRecyclerView a2 = StatusAlbumUI.a(this.Gdq);
            if (i2 == ((a2 == null || (adapter = a2.getAdapter()) == null) ? 1 : adapter.getItemCount()) - 1) {
                rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.Gdq.getContext(), 16);
                AppMethodBeat.o(258444);
                return;
            }
            rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.Gdq.getContext(), 8);
            AppMethodBeat.o(258444);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
    public static final class h extends RefreshLoadMoreLayout.a {
        final /* synthetic */ StatusAlbumUI Gdq;
        final /* synthetic */ WxRecyclerAdapter uMv;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(258449);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(258449);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(258450);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(258450);
        }

        h(StatusAlbumUI statusAlbumUI, WxRecyclerAdapter wxRecyclerAdapter) {
            this.Gdq = statusAlbumUI;
            this.uMv = wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(258447);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            com.tencent.mm.ac.d.h(new a(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(258447);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            RecyclerView.a adapter;
            AppMethodBeat.i(258448);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "onLoadMoreEnd");
            if (!StatusAlbumUI.b(this.Gdq).tuG) {
                RefreshLoadMoreLayout.e(StatusAlbumUI.c(this.Gdq));
                if (this.uMv.RqN.size() == 0) {
                    View inflate = aa.jQ(StatusAlbumUI.a(this.Gdq).getContext()).inflate(R.layout.cg7, (ViewGroup) StatusAlbumUI.a(this.Gdq), false);
                    WxRecyclerAdapter wxRecyclerAdapter = this.uMv;
                    p.g(inflate, "footer");
                    g.b unused = wxRecyclerAdapter.g(inflate, Integer.MAX_VALUE, true);
                    inflate.findViewById(R.id.k02).setOnClickListener(new b(this));
                }
                Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "hasMoreData true");
            }
            StatusAlbumUI.d(this.Gdq);
            WxRecyclerView a2 = StatusAlbumUI.a(this.Gdq);
            if (!(a2 == null || (adapter = a2.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(258448);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ h VeS;

            b(h hVar) {
                this.VeS = hVar;
            }

            public final void onClick(View view) {
                Bundle bundle;
                Intent intent;
                AppMethodBeat.i(258446);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent2 = new Intent();
                FragmentActivity activity = this.VeS.Gdq.getActivity();
                if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
                    bundle = new Bundle();
                }
                Intent putExtras = intent2.putExtras(bundle);
                p.g(putExtras, "Intent().putExtras(activ…intent?.extras?:Bundle())");
                putExtras.putExtra("story_only", true);
                com.tencent.mm.br.c.b(this.VeS.Gdq.getContext(), "", "com.tencent.mm.ui.AlbumUI", putExtras);
                com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.a(15, (String) null, (String) null, 6);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(258446);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ h VeS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar) {
                super(0);
                this.VeS = hVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(258445);
                Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "onLoadMoreBegin");
                StatusAlbumUI.b(this.VeS.Gdq).epE();
                x xVar = x.SXb;
                AppMethodBeat.o(258445);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class c implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ StatusAlbumUI Gdq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(StatusAlbumUI statusAlbumUI) {
            this.Gdq = statusAlbumUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(216421);
            switch (i2) {
                case 0:
                    com.tencent.mm.plugin.textstatus.b.a.b bVar = new com.tencent.mm.plugin.textstatus.b.a.b(this.Gdq.tib);
                    AppMethodBeat.o(216421);
                    return bVar;
                default:
                    com.tencent.mm.plugin.textstatus.b.a.a aVar = new com.tencent.mm.plugin.textstatus.b.a.a();
                    AppMethodBeat.o(216421);
                    return aVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class g implements View.OnLongClickListener {
        final /* synthetic */ StatusAlbumUI Gdq;

        g(StatusAlbumUI statusAlbumUI) {
            this.Gdq = statusAlbumUI;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x007e, code lost:
            r1 = r0.field_StatusID;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onLongClick(android.view.View r9) {
            /*
            // Method dump skipped, instructions count: 185
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI.g.onLongClick(android.view.View):boolean");
        }
    }

    private final void fwl() {
        com.tencent.mm.plugin.textstatus.f.f.a aVar;
        AppMethodBeat.i(216437);
        Iterator<com.tencent.mm.view.recyclerview.a> it = this.kgc.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            com.tencent.mm.view.recyclerview.a next = it.next();
            if ((next instanceof com.tencent.mm.plugin.textstatus.f.a.a) && (aVar = ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZq) != null) {
                int i4 = aVar.field_CreateTime;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(((long) i4) * 1000)));
                Calendar instance = Calendar.getInstance();
                p.g(instance, "cal");
                instance.setTime(parse);
                int i5 = instance.get(1);
                int i6 = instance.get(6);
                if (i5 != i3) {
                    ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZr = DateFormat.format(MMApplicationContext.getContext().getString(R.string.ho7), ((long) i4) * 1000).toString();
                    i3 = i5;
                } else {
                    ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZr = "";
                }
                if (i6 != i2) {
                    ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZs = DateFormat.format(MMApplicationContext.getContext().getString(R.string.hnj), ((long) i4) * 1000).toString();
                    i2 = i6;
                } else {
                    ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZs = "";
                }
            }
        }
        AppMethodBeat.o(216437);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        RecyclerView.a adapter;
        String str2;
        AppMethodBeat.i(216438);
        if (qVar instanceof com.tencent.mm.plugin.textstatus.f.a) {
            com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.a) qVar).getType(), this);
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                Activity context = getContext();
                if (context != null) {
                    com.tencent.mm.ui.base.h.X(context, context.getString(R.string.hn7), "");
                }
                z = false;
            }
            if (z) {
                Iterator<com.tencent.mm.view.recyclerview.a> it = this.kgc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mm.view.recyclerview.a next = it.next();
                    if (next instanceof com.tencent.mm.plugin.textstatus.f.a.a) {
                        com.tencent.mm.plugin.textstatus.f.f.a aVar = ((com.tencent.mm.plugin.textstatus.f.a.a) next).FZq;
                        if (aVar != null) {
                            str2 = aVar.field_StatusID;
                        } else {
                            str2 = null;
                        }
                        if (p.j(str2, ((com.tencent.mm.plugin.textstatus.f.a) qVar).FYf)) {
                            this.kgc.remove(next);
                            break;
                        }
                    }
                }
                fwl();
                WxRecyclerView wxRecyclerView = this.Gdj;
                if (wxRecyclerView == null) {
                    p.btv("rvSelfHistory");
                }
                if (!(wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null)) {
                    adapter.notifyDataSetChanged();
                }
            }
        }
        q qVar2 = this.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216438);
            return;
        }
        AppMethodBeat.o(216438);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
    public static final class b {
        com.tencent.mm.bw.b Gdn;
        final RefreshLoadMoreLayout Gdo;
        final i gNh = new a(this);
        final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;
        boolean tuG;

        public b(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            p.h(wxRecyclerAdapter, "adapter");
            p.h(refreshLoadMoreLayout, "refreahLayout");
            AppMethodBeat.i(216420);
            this.tFp = wxRecyclerAdapter;
            this.Gdo = refreshLoadMoreLayout;
            com.tencent.mm.kernel.g.azz().a(4245, this.gNh);
            AppMethodBeat.o(216420);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
        static final class a implements i {
            final /* synthetic */ b Gdp;

            a(b bVar) {
                this.Gdp = bVar;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                com.tencent.mm.plugin.textstatus.g.j jVar;
                AppMethodBeat.i(216418);
                p.h(qVar, "netSceneBase");
                if (i2 == 0 && i3 == 0 && (jVar = ((com.tencent.mm.plugin.textstatus.f.e) qVar).FYW) != null) {
                    this.Gdp.Gdn = jVar.GaF;
                    this.Gdp.tuG = jVar.GaH;
                    LinkedList<com.tencent.mm.plugin.textstatus.g.q> linkedList = jVar.GaG;
                    if (linkedList != null) {
                        for (T t : linkedList) {
                            if (t != null) {
                                this.Gdp.tFp.data.add(new com.tencent.mm.plugin.textstatus.f.a.a(t));
                            }
                        }
                    }
                    Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "data size = " + this.Gdp.tFp.data.size() + ", continueFlag: " + this.Gdp.tuG);
                }
                this.Gdp.Gdo.apT(0);
                AppMethodBeat.o(216418);
            }
        }

        public final void epE() {
            AppMethodBeat.i(216419);
            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.textstatus.f.e(this.Gdn));
            AppMethodBeat.o(216419);
        }
    }
}
