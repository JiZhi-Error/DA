package com.tencent.mm.plugin.finder.live.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cz;
import com.tencent.mm.plugin.finder.cgi.db;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15;
import com.tencent.mm.plugin.finder.live.view.adapter.t;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.fhg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 H2\u00020\u0001:\u0001HB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020-H\u0002J\"\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u0011H\u0016J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020-H\u0002J\b\u0010:\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0002J&\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010A\u001a\u00020-H\u0002J(\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rH\u0002J\u0010\u0010G\u001a\u00020-2\u0006\u0010D\u001a\u00020\u000bH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "aliasInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "curRoleType", "", "deleteBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableVisitorRoleEntrance", "", "getEnableVisitorRoleEntrance", "()Z", "setEnableVisitorRoleEntrance", "(Z)V", "fromSetting", "liveVisitorRoleGroup", "Landroid/view/View;", "getLiveVisitorRoleGroup", "()Landroid/view/View;", "setLiveVisitorRoleGroup", "(Landroid/view/View;)V", "loadingProgress", "Landroid/widget/ProgressBar;", "modifyTime", "", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sourceType", "touchLoc", "", "visitorRoleAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "visitorRv", "Landroid/support/v7/widget/RecyclerView;", "visitorTips", "Landroid/widget/TextView;", "doRemoveAliasInfo", "", "getModifyTimeInfo", "goBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseData", "refreshLayout", "removeAliasInfo", "setActivityResult", "showAlertDialog", "title", "content", "buttonTitle", "showBottomSheet", "showPopupMenu", "itemView", "aliasInfo", "anchorPosX", "anchorPosY", "updateVisitorRole", "Companion", "plugin-finder_release"})
public final class FinderLiveVisitorRoleUIC extends UIComponent {
    private static final int UQD = 10001;
    public static final a UQE = new a((byte) 0);
    final String TAG = "FinderLiveVisitorRoleUIC";
    private int UPl = 1;
    private boolean UQA;
    private LinkedList<aus> UQB = new LinkedList<>();
    private long UQC = Long.MIN_VALUE;
    private View UQu;
    private RecyclerView UQv;
    private TextView UQw;
    private ProgressBar UQx;
    private com.tencent.mm.ui.widget.a.e UQy;
    private t UQz;
    private boolean UvI = true;
    private com.tencent.mm.ui.widget.b.a pqr;
    private int sourceType;
    private int[] utT = new int[2];

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$1"})
    static final class b extends q implements kotlin.g.a.b<aus, x> {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            super(1);
            this.UQF = finderLiveVisitorRoleUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(aus aus) {
            AppMethodBeat.i(261076);
            aus aus2 = aus;
            p.h(aus2, LocaleUtil.ITALIAN);
            FinderLiveVisitorRoleUIC.a(this.UQF, aus2);
            x xVar = x.SXb;
            AppMethodBeat.o(261076);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "itemView", "Landroid/view/View;", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$2$2"})
    static final class c extends q implements m<aus, View, x> {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            super(2);
            this.UQF = finderLiveVisitorRoleUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(aus aus, View view) {
            AppMethodBeat.i(261077);
            aus aus2 = aus;
            View view2 = view;
            p.h(aus2, "aliasInfo");
            p.h(view2, "itemView");
            if (aus2.LFy == 2) {
                if (this.UQF.utT[0] == 0 || this.UQF.utT[1] == 0) {
                    Log.i(this.UQF.TAG, "onItemLongClickCallback before change x:" + this.UQF.utT[0] + ", original y:" + this.UQF.utT[1]);
                    view2.getLocationOnScreen(this.UQF.utT);
                    Log.i(this.UQF.TAG, "onItemLongClickCallback after change x:" + this.UQF.utT[0] + ", original y:" + this.UQF.utT[1]);
                }
                FinderLiveVisitorRoleUIC.a(this.UQF, view2, aus2, this.UQF.utT[0], this.UQF.utT[1]);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261077);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveVisitorRoleUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(261102);
        AppMethodBeat.o(261102);
    }

    public static final /* synthetic */ void d(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
        AppMethodBeat.i(261106);
        finderLiveVisitorRoleUIC.eoD();
        AppMethodBeat.o(261106);
    }

    public static final /* synthetic */ String j(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
        AppMethodBeat.i(261109);
        String hUh = finderLiveVisitorRoleUIC.hUh();
        AppMethodBeat.o(261109);
        return hUh;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$Companion;", "", "()V", "KEY_IS_FROM_SETTING", "", "KEY_MODIFY_TIME", "KEY_SOURCE", "KEY_VISITOR_ROLE_LIST", "KEY_VISITOR_ROLE_TYPE", "MENU_ID_DELETE_ROLE", "", "MENU_ID_ITEM_DELETE", "MENU_ID_ITEM_EDIT", "REQUEST_CREATE_FINDER_LIVE_ROLE", "SOURCE_FINDER", "SOURCE_LIVE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(261103);
        AppMethodBeat.o(261103);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(261095);
        super.onCreate(bundle);
        this.UQu = findViewById(R.id.k0_);
        this.UQx = (ProgressBar) findViewById(R.id.epq);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        this.UvI = com.tencent.mm.plugin.finder.utils.m.hVq();
        if (this.UvI) {
            View view = this.UQu;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.UQu;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            ProgressBar progressBar = this.UQx;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
        this.UQv = (RecyclerView) findViewById(R.id.k3d);
        this.UQw = (TextView) findViewById(R.id.k3e);
        TextView textView = this.UQw;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = au.aD(textView.getContext());
            }
        }
        this.UQz = new t();
        t tVar = this.UQz;
        if (tVar != null) {
            tVar.UPj = new b(this);
            tVar.UPk = new c(this);
        }
        RecyclerView recyclerView = this.UQv;
        if (recyclerView != null) {
            recyclerView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
            recyclerView.setAdapter(this.UQz);
            recyclerView.a(new d(this));
        }
        this.sourceType = getIntent().getIntExtra("KEY_SOURCE", 0);
        this.UQA = getIntent().getBooleanExtra("KEY_IS_FROM_SETTING", true);
        if (this.UQA) {
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            this.UQB = com.tencent.mm.plugin.finder.utils.m.hVr();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            this.UPl = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 1);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            this.UQC = aAh2.azQ().a(ar.a.USERINFO_FINDER_LIVE_ALIAS_MODIFY_TIME_LONG_SYNC, Long.MIN_VALUE);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("KEY_VISITOR_ROLE_LIST");
            if (!(serializableExtra instanceof List)) {
                serializableExtra = null;
            }
            List list = (List) serializableExtra;
            if (list != null) {
                com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.c(list, this.UQB);
            }
            this.UPl = getIntent().getIntExtra("KEY_VISITOR_ROLE", 1);
            this.UQC = getIntent().getLongExtra("KEY_MODIFY_TIME", Long.MIN_VALUE);
        }
        if (this.UQB.size() > 0) {
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_GUIDE_SHOW_BOOLEAN_SYNC, Boolean.TRUE);
        }
        String str = this.TAG;
        StringBuilder append = new StringBuilder("parseInten fromSetting:").append(this.UQA).append(',');
        com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
        Log.i(str, append.append(com.tencent.mm.plugin.finder.utils.m.a(this.TAG, this.UQB, this.UPl, this.UQC)).toString());
        eoD();
        Log.i(this.TAG, "onCreate enableVisitorRoleEntrance:" + this.UvI);
        AppMethodBeat.o(261095);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$3$1", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
    public static final class d implements RecyclerView.k {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        d(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            this.UQF = finderLiveVisitorRoleUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(261078);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$$inlined$apply$lambda$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
            p.h(recyclerView, "p0");
            p.h(motionEvent, "p1");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$onCreate$$inlined$apply$lambda$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(261078);
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(261079);
            p.h(recyclerView, "recyclerView");
            p.h(motionEvent, "motionEvent");
            this.UQF.utT[0] = (int) motionEvent.getRawX();
            this.UQF.utT[1] = (int) motionEvent.getRawY();
            AppMethodBeat.o(261079);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(261096);
        if (this.UvI && this.sourceType == 1) {
            hUf();
        }
        getActivity().finish();
        AppMethodBeat.o(261096);
        return true;
    }

    private final void hUf() {
        AppMethodBeat.i(261097);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("setActivityResult fromSetting:").append(this.UQA).append(", ");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        Log.i(str, append.append(com.tencent.mm.plugin.finder.utils.m.a(this.TAG, this.UQB, this.UPl, this.UQC)).toString());
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this.UQB, this.UPl, this.UQC);
        AppCompatActivity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("KEY_IS_FROM_SETTING", this.UQA);
        activity.setResult(-1, intent);
        AppMethodBeat.o(261097);
    }

    private final void eoD() {
        boolean z = true;
        AppMethodBeat.i(261098);
        boolean z2 = this.UQC - ((long) cl.aWB()) <= 0;
        y yVar = y.vXH;
        if (!y.dCM()) {
            z = z2;
        }
        t tVar = this.UQz;
        if (tVar != null) {
            tVar.a(this.UPl, this.UQB, z);
        }
        t tVar2 = this.UQz;
        if (tVar2 != null) {
            tVar2.notifyDataSetChanged();
        }
        if (z) {
            TextView textView = this.UQw;
            if (textView != null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                textView.setText(context.getResources().getString(R.string.jcd));
                AppMethodBeat.o(261098);
                return;
            }
            AppMethodBeat.o(261098);
            return;
        }
        TextView textView2 = this.UQw;
        if (textView2 != null) {
            textView2.setText(hUh());
            AppMethodBeat.o(261098);
            return;
        }
        AppMethodBeat.o(261098);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$updateVisitorRole$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder_release"})
    public static final class j implements db.a {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;
        final /* synthetic */ int UQJ;

        j(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC, int i2) {
            this.UQF = finderLiveVisitorRoleUIC;
            this.UQJ = i2;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.db.a
        public final void a(fhg fhg) {
            AppMethodBeat.i(261093);
            p.h(fhg, "resp");
            com.tencent.mm.ac.d.h(new b(this));
            AppMethodBeat.o(261093);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.db.a
        public final void bxA(String str) {
            AppMethodBeat.i(261094);
            com.tencent.mm.ac.d.h(new a(this, str));
            AppMethodBeat.o(261094);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ j UQK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(j jVar) {
                super(0);
                this.UQK = jVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(261092);
                ProgressBar progressBar = this.UQK.UQF.UQx;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.UQK.UQF.UPl = this.UQK.UQJ;
                FinderLiveVisitorRoleUIC.d(this.UQK.UQF);
                if (this.UQK.UQF.sourceType == 1) {
                    FinderLiveVisitorRoleUIC.f(this.UQK.UQF);
                } else {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    com.tencent.mm.plugin.finder.utils.m.a(this.UQK.UQF.UQB, this.UQK.UQF.UPl, this.UQK.UQF.UQC);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(261092);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ String $errMsg;
            final /* synthetic */ j UQK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(j jVar, String str) {
                super(0);
                this.UQK = jVar;
                this.$errMsg = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                String str;
                AppMethodBeat.i(261091);
                ProgressBar progressBar = this.UQK.UQF.UQx;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.jca);
                p.g(string, "MMApplicationContext.get…_visitor_role_chang_fail)");
                String str2 = this.$errMsg;
                if (!(str2 == null || str2.length() == 0)) {
                    str = this.$errMsg;
                } else {
                    str = string;
                }
                u.a(this.UQK.UQF.getContext(), str, AnonymousClass1.UQL);
                x xVar = x.SXb;
                AppMethodBeat.o(261091);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class h implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        h(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            this.UQF = finderLiveVisitorRoleUIC;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(261087);
            contextMenu.add(0, 1, 0, this.UQF.getContext().getResources().getString(R.string.jcg));
            contextMenu.add(0, 2, 1, this.UQF.getContext().getResources().getString(R.string.jce));
            AppMethodBeat.o(261087);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class i implements o.g {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;
        final /* synthetic */ aus UQI;

        i(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC, aus aus) {
            this.UQF = finderLiveVisitorRoleUIC;
            this.UQI = aus;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(261088);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    com.tencent.mm.ui.widget.b.a aVar = this.UQF.pqr;
                    if (aVar != null) {
                        aVar.gNq();
                    }
                    Log.i(this.UQF.TAG, "showPopupMenu modifyTime:" + this.UQF.UQC + ",serverTime:" + cl.aWB());
                    String string = this.UQF.getContext().getResources().getString(R.string.jc8);
                    p.g(string, "context.resources.getStr…bidden_edit_dialog_title)");
                    if (this.UQF.UQC == Long.MIN_VALUE) {
                        u.makeText(this.UQF.getContext(), string, 0).show();
                        AppMethodBeat.o(261088);
                        return;
                    } else if (this.UQF.UQC - ((long) cl.aWB()) <= 0) {
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Intent intent = new Intent();
                        OccupyFinderUI15.a aVar3 = OccupyFinderUI15.UJc;
                        intent.putExtra(OccupyFinderUI15.UIZ, this.UQI.nickname);
                        OccupyFinderUI15.a aVar4 = OccupyFinderUI15.UJc;
                        intent.putExtra(OccupyFinderUI15.UJa, this.UQI.qFV);
                        intent.putExtra("KEY_SOURCE", this.UQF.getIntent().getIntExtra("KEY_SOURCE", 0));
                        com.tencent.mm.plugin.finder.utils.a.k(this.UQF.getActivity(), intent);
                        AppMethodBeat.o(261088);
                        return;
                    } else {
                        FinderLiveVisitorRoleUIC.a(this.UQF, string, FinderLiveVisitorRoleUIC.j(this.UQF), "");
                        AppMethodBeat.o(261088);
                        return;
                    }
                case 2:
                    com.tencent.mm.ui.widget.b.a aVar5 = this.UQF.pqr;
                    if (aVar5 != null) {
                        aVar5.gNq();
                    }
                    FinderLiveVisitorRoleUIC.k(this.UQF);
                    break;
            }
            AppMethodBeat.o(261088);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        f(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            this.UQF = finderLiveVisitorRoleUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(261081);
            mVar.a(FinderLiveVisitorRoleUIC.UQD, this.UQF.getContext().getResources().getColor(R.color.Red_100), this.UQF.getContext().getResources().getString(R.string.jce));
            AppMethodBeat.o(261081);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        g(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            this.UQF = finderLiveVisitorRoleUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(261086);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == FinderLiveVisitorRoleUIC.UQD) {
                new cz(new cz.a(this) {
                    /* class com.tencent.mm.plugin.finder.live.viewmodel.FinderLiveVisitorRoleUIC.g.AnonymousClass1 */
                    final /* synthetic */ g UQG;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.UQG = r1;
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.cz.a
                    public final void a(fgr fgr) {
                        AppMethodBeat.i(261084);
                        p.h(fgr, "resp");
                        com.tencent.mm.ac.d.h(new b(this));
                        AppMethodBeat.o(261084);
                    }

                    @Override // com.tencent.mm.plugin.finder.cgi.cz.a
                    public final void awK(int i2) {
                        AppMethodBeat.i(261085);
                        com.tencent.mm.ac.d.h(new a(this, i2));
                        AppMethodBeat.o(261085);
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                    /* renamed from: com.tencent.mm.plugin.finder.live.viewmodel.FinderLiveVisitorRoleUIC$g$1$b */
                    static final class b extends q implements kotlin.g.a.a<x> {
                        final /* synthetic */ AnonymousClass1 UQH;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        b(AnonymousClass1 r2) {
                            super(0);
                            this.UQH = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(261083);
                            FinderLiveVisitorRoleUIC.l(this.UQH.UQG.UQF);
                            x xVar = x.SXb;
                            AppMethodBeat.o(261083);
                            return xVar;
                        }
                    }

                    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
                    /* renamed from: com.tencent.mm.plugin.finder.live.viewmodel.FinderLiveVisitorRoleUIC$g$1$a */
                    static final class a extends q implements kotlin.g.a.a<x> {
                        final /* synthetic */ int $errCode;
                        final /* synthetic */ AnonymousClass1 UQH;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        a(AnonymousClass1 r2, int i2) {
                            super(0);
                            this.UQH = r2;
                            this.$errCode = i2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(261082);
                            if (this.$errCode == -200067) {
                                FinderLiveVisitorRoleUIC.l(this.UQH.UQG.UQF);
                            } else {
                                Context context = MMApplicationContext.getContext();
                                p.g(context, "MMApplicationContext.getContext()");
                                u.makeText(this.UQH.UQG.UQF.getContext(), context.getResources().getString(R.string.jcf), 0).show();
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(261082);
                            return xVar;
                        }
                    }
                }).aYI();
            }
            com.tencent.mm.ui.widget.a.e eVar = this.UQF.UQy;
            if (eVar != null) {
                eVar.bMo();
                AppMethodBeat.o(261086);
                return;
            }
            AppMethodBeat.o(261086);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class e implements f.c {
        final /* synthetic */ FinderLiveVisitorRoleUIC UQF;

        e(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
            this.UQF = finderLiveVisitorRoleUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(261080);
            Log.i(this.UQF.TAG, "showAlertDialog click bOk:".concat(String.valueOf(z)));
            AppMethodBeat.o(261080);
        }
    }

    private final void hUg() {
        AppMethodBeat.i(261099);
        Log.i(this.TAG, "before removeAliasInfo size:" + this.UQB.size());
        Iterator<aus> it = this.UQB.iterator();
        p.g(it, "aliasInfoList.iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aus next = it.next();
            p.g(next, "iterator.next()");
            aus aus = next;
            if (aus.LFy == 2) {
                it.remove();
                Log.i(this.TAG, "removeAliasInfo:" + com.tencent.mm.ac.g.bN(aus));
                break;
            }
        }
        Log.i(this.TAG, "after removeAliasInfo size:" + this.UQB.size());
        AppMethodBeat.o(261099);
    }

    private final String hUh() {
        AppMethodBeat.i(261100);
        Time time = new Time();
        time.set(this.UQC * 1000);
        CharSequence a2 = com.tencent.mm.pluginsdk.i.e.a(getContext().getString(R.string.dev), time);
        String string = getContext().getResources().getString(R.string.jc7, a2);
        p.g(string, "context.resources.getStr…_dialog_content, timeStr)");
        AppMethodBeat.o(261100);
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005a, code lost:
        if (r0 == null) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.FinderLiveVisitorRoleUIC.onActivityResult(int, int, android.content.Intent):void");
    }

    public static final /* synthetic */ void a(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC, aus aus) {
        AppMethodBeat.i(261104);
        int i2 = aus.LFy;
        Log.i(finderLiveVisitorRoleUIC.TAG, "updateVisitorRole chooseType:".concat(String.valueOf(i2)));
        switch (i2) {
            case 10001:
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                Intent intent = new Intent();
                OccupyFinderUI15.a aVar2 = OccupyFinderUI15.UJc;
                intent.putExtra(OccupyFinderUI15.UIZ, aus.nickname);
                OccupyFinderUI15.a aVar3 = OccupyFinderUI15.UJc;
                intent.putExtra(OccupyFinderUI15.UJa, aus.qFV);
                intent.putExtra("KEY_SOURCE", finderLiveVisitorRoleUIC.getIntent().getIntExtra("KEY_SOURCE", 0));
                com.tencent.mm.plugin.finder.utils.a.k(finderLiveVisitorRoleUIC.getActivity(), intent);
                AppMethodBeat.o(261104);
                return;
            default:
                ProgressBar progressBar = finderLiveVisitorRoleUIC.UQx;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                new db(aUg, i2, new j(finderLiveVisitorRoleUIC, i2)).aYI();
                AppMethodBeat.o(261104);
                return;
        }
    }

    public static final /* synthetic */ void a(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC, View view, aus aus, int i2, int i3) {
        AppMethodBeat.i(261105);
        if (finderLiveVisitorRoleUIC.pqr == null) {
            finderLiveVisitorRoleUIC.pqr = new com.tencent.mm.ui.widget.b.a(finderLiveVisitorRoleUIC.getContext());
        }
        com.tencent.mm.ui.widget.b.a aVar = finderLiveVisitorRoleUIC.pqr;
        if (aVar != null) {
            aVar.gNq();
        }
        com.tencent.mm.ui.widget.b.a aVar2 = finderLiveVisitorRoleUIC.pqr;
        if (aVar2 != null) {
            aVar2.a(view, new h(finderLiveVisitorRoleUIC), new i(finderLiveVisitorRoleUIC, aus), i2, i3);
            AppMethodBeat.o(261105);
            return;
        }
        AppMethodBeat.o(261105);
    }

    public static final /* synthetic */ void f(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
        AppMethodBeat.i(261107);
        finderLiveVisitorRoleUIC.hUf();
        finderLiveVisitorRoleUIC.getActivity().finish();
        AppMethodBeat.o(261107);
    }

    public static final /* synthetic */ void a(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC, String str, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(261108);
        f.a aVar = new f.a(finderLiveVisitorRoleUIC.getContext());
        String str4 = str;
        if (str4 == null || str4.length() == 0) {
            aVar.bow(str2);
        } else {
            aVar.aC(str).bow(str2);
        }
        aVar.hbu();
        String string = finderLiveVisitorRoleUIC.getContext().getResources().getString(R.string.cqo);
        p.g(string, "context.resources.getStr…ive_alert_dialog_btn_txt)");
        if (str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str3 = string;
        }
        aVar.boA(str3);
        aVar.b(new e(finderLiveVisitorRoleUIC)).show();
        AppMethodBeat.o(261108);
    }

    public static final /* synthetic */ void k(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
        AppMethodBeat.i(261110);
        finderLiveVisitorRoleUIC.UQy = new com.tencent.mm.ui.widget.a.e((Context) finderLiveVisitorRoleUIC.getContext(), 1, false);
        View inflate = View.inflate(finderLiveVisitorRoleUIC.getContext(), R.layout.b0l, null);
        TextView textView = (TextView) inflate.findViewById(R.id.eg6);
        p.g(textView, "bottomSheetTitleTv");
        textView.setText(finderLiveVisitorRoleUIC.getContext().getResources().getString(R.string.jc6));
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        textView.setTextColor(context.getResources().getColor(R.color.ad));
        com.tencent.mm.ui.widget.a.e eVar = finderLiveVisitorRoleUIC.UQy;
        if (eVar != null) {
            eVar.setTitleView(inflate);
        }
        com.tencent.mm.ui.widget.a.e eVar2 = finderLiveVisitorRoleUIC.UQy;
        if (eVar2 != null) {
            eVar2.a(new f(finderLiveVisitorRoleUIC));
        }
        com.tencent.mm.ui.widget.a.e eVar3 = finderLiveVisitorRoleUIC.UQy;
        if (eVar3 != null) {
            eVar3.a(new g(finderLiveVisitorRoleUIC));
        }
        com.tencent.mm.ui.widget.a.e eVar4 = finderLiveVisitorRoleUIC.UQy;
        if (eVar4 != null) {
            eVar4.dGm();
            AppMethodBeat.o(261110);
            return;
        }
        AppMethodBeat.o(261110);
    }

    public static final /* synthetic */ void l(FinderLiveVisitorRoleUIC finderLiveVisitorRoleUIC) {
        AppMethodBeat.i(261111);
        finderLiveVisitorRoleUIC.hUg();
        aus aus = (aus) kotlin.a.j.kt(finderLiveVisitorRoleUIC.UQB);
        if (aus != null) {
            finderLiveVisitorRoleUIC.UPl = aus.LFy;
        }
        finderLiveVisitorRoleUIC.eoD();
        AppMethodBeat.o(261111);
    }
}
