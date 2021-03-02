package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0005¢\u0006\u0002\u0010\u0003J\b\u00106\u001a\u000207H\u0004J\b\u00108\u001a\u000207H\u0004J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tJ\u0014\u0010<\u001a\u00020:2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>J\b\u0010@\u001a\u00020:H\u0016J\u0006\u0010A\u001a\u00020\tJ\b\u0010B\u001a\u00020\u0005H\u0014J\u001e\u0010C\u001a\u00020:2\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010J\b\u0010E\u001a\u00020:H\u0014J\u0012\u0010F\u001a\u00020:2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020:H\u0014J,\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0016\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u000207J\u001e\u0010S\u001a\u00020:2\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010J\u0006\u0010U\u001a\u00020:J\u0006\u0010V\u001a\u00020:J \u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u000207H\u0002J\u000e\u0010\\\u001a\u00020:2\u0006\u0010]\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u0007R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b.\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI extends MMFinderUI implements com.tencent.mm.ak.i {
    static final String TAG = TAG;
    public static final a uao = new a((byte) 0);
    private HashMap _$_findViewCache;
    private TextView hRM;
    private ListView krb;
    private String md5 = "";
    private com.tencent.mm.ui.widget.b.a pqr;
    q tipDialog;
    private final ArrayList<String> uae = new ArrayList<>();
    private final ArrayList<String> uaf = new ArrayList<>();
    final int uag = 1001;
    private final com.tencent.mm.plugin.finder.ui.c uah = new com.tencent.mm.plugin.finder.ui.c(this);
    private final kotlin.f uai = kotlin.g.ah(i.uar);
    private final kotlin.f uaj = kotlin.g.ah(new c(this));
    private final kotlin.f uak = kotlin.g.ah(new b(this));
    private final kotlin.f ual = kotlin.g.ah(new f(this));
    private final kotlin.f uam = kotlin.g.ah(new e(this));
    private int uan;

    private final String acj() {
        AppMethodBeat.i(245201);
        String str = (String) this.uaj.getValue();
        AppMethodBeat.o(245201);
        return str;
    }

    private final String ack() {
        AppMethodBeat.i(245202);
        String str = (String) this.uak.getValue();
        AppMethodBeat.o(245202);
        return str;
    }

    private final int ddV() {
        AppMethodBeat.i(245203);
        int intValue = ((Number) this.ual.getValue()).intValue();
        AppMethodBeat.o(245203);
        return intValue;
    }

    private final String getSessionId() {
        AppMethodBeat.i(245200);
        String str = (String) this.uai.getValue();
        AppMethodBeat.o(245200);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245216);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245216);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245215);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245215);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", "", "invoke"})
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.q<View, String, Boolean, x> {
        final /* synthetic */ FinderFriendBlackListUI uap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderFriendBlackListUI finderFriendBlackListUI) {
            super(3);
            this.uap = finderFriendBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(View view, String str, Boolean bool) {
            AppMethodBeat.i(245194);
            View view2 = view;
            String str2 = str;
            boolean booleanValue = bool.booleanValue();
            p.h(view2, "view");
            p.h(str2, "blackInfo");
            FinderFriendBlackListUI.a(this.uap, str2, view2, booleanValue);
            x xVar = x.SXb;
            AppMethodBeat.o(245194);
            return xVar;
        }
    }

    public FinderFriendBlackListUI() {
        AppMethodBeat.i(245212);
        AppMethodBeat.o(245212);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245213);
        AppMethodBeat.o(245213);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245204);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3528, this);
        com.tencent.mm.kernel.g.azz().a(3990, this);
        d.a aVar = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        d.a.dyw().onAlive();
        initView();
        d.a aVar2 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        ArrayList<String> dyv = d.a.dyw().dyv();
        p.h(dyv, "data");
        if (dyv.isEmpty()) {
            IQ(0);
        } else {
            this.uae.clear();
            this.uae.addAll(dyv);
            String listToString = Util.listToString(this.uae, ",");
            p.g(listToString, "Util.listToString(contactList, \",\")");
            this.md5 = listToString;
            ArrayList<String> arrayList = this.uae;
            p.h(arrayList, "addList");
            Log.i(TAG, "friend list: " + arrayList.size());
            if (arrayList.isEmpty()) {
                bIo();
            } else {
                TextView textView = this.hRM;
                if (textView == null) {
                    p.btv("emptyTip");
                }
                textView.setVisibility(8);
                ListView listView = this.krb;
                if (listView == null) {
                    p.btv("listView");
                }
                listView.setVisibility(0);
                this.uah.ew(arrayList);
                this.uah.notifyDataSetChanged();
            }
            this.uan = arrayList.size();
            IQ(arrayList.size());
        }
        Log.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + acj() + " clickTabContextId:" + ack() + " fromCommentScene:" + ddV());
        AppMethodBeat.o(245204);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.abr;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(245205);
        View findViewById = findViewById(R.id.cmp);
        p.g(findViewById, "findViewById(R.id.finder_liked_list)");
        this.krb = (ListView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        this.pqr = new com.tencent.mm.ui.widget.b.a(this);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setAdapter((ListAdapter) this.uah);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        listView2.setSelector(new ColorDrawable(0));
        this.uah.vKe = new g(this);
        setBackBtn(new h(this));
        AppMethodBeat.o(245205);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class h implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFriendBlackListUI uap;

        h(FinderFriendBlackListUI finderFriendBlackListUI) {
            this.uap = finderFriendBlackListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245195);
            this.uap.finish();
            AppMethodBeat.o(245195);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class j implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderFriendBlackListUI uap;
        final /* synthetic */ boolean uas;

        j(FinderFriendBlackListUI finderFriendBlackListUI, boolean z) {
            this.uap = finderFriendBlackListUI;
            this.uas = z;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(245198);
            contextMenu.add(0, this.uap.uag, 0, this.uas ? this.uap.getString(R.string.cqd) : this.uap.getString(R.string.cqc));
            AppMethodBeat.o(245198);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class k implements o.g {
        final /* synthetic */ FinderFriendBlackListUI uap;
        final /* synthetic */ String uat;

        k(FinderFriendBlackListUI finderFriendBlackListUI, String str) {
            this.uap = finderFriendBlackListUI;
            this.uat = str;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(245199);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.uap.uag) {
                FinderFriendBlackListUI finderFriendBlackListUI = this.uap;
                String str = this.uat;
                p.h(str, "deleteName");
                if (!Util.isNullOrNil(str)) {
                    com.tencent.mm.kernel.b.h azG = com.tencent.mm.kernel.g.aAe().azG();
                    p.g(azG, "MMKernel.process().current()");
                    if (azG.aBb()) {
                        t azz = com.tencent.mm.kernel.g.azz();
                        p.g(azz, "MMKernel.getNetSceneQueue()");
                        int aYS = azz.aYS();
                        if (aYS == 4 || aYS == 6) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        u.makeText(finderFriendBlackListUI, (int) R.string.ci_, 0).show();
                        AppMethodBeat.o(245199);
                        return;
                    }
                    finderFriendBlackListUI.getString(R.string.zb);
                    finderFriendBlackListUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) finderFriendBlackListUI, finderFriendBlackListUI.getString(R.string.cid), true, (DialogInterface.OnCancelListener) d.uaq);
                    LinkedList linkedList = new LinkedList();
                    Log.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(str)));
                    cpm cpm = new cpm();
                    cpm.UserName = str;
                    cpm.MvC = com.tencent.mm.plugin.i.a.k.wEb;
                    cpm.MvD = 2;
                    linkedList.add(cpm);
                    FinderFriendBlackListUI.ah(linkedList);
                }
            }
            AppMethodBeat.o(245199);
        }
    }

    private void IQ(int i2) {
        AppMethodBeat.i(245206);
        if (i2 <= 0) {
            setMMTitle(getString(R.string.cqa));
            AppMethodBeat.o(245206);
            return;
        }
        setMMTitle(getString(R.string.cq9, new Object[]{Integer.valueOf(i2)}));
        AppMethodBeat.o(245206);
    }

    private void bIo() {
        AppMethodBeat.i(245207);
        TextView textView = this.hRM;
        if (textView == null) {
            p.btv("emptyTip");
        }
        textView.setVisibility(0);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setVisibility(8);
        AppMethodBeat.o(245207);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements DialogInterface.OnCancelListener {
        public static final d uaq = new d();

        static {
            AppMethodBeat.i(245191);
            AppMethodBeat.o(245191);
        }

        d() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    static void ah(LinkedList<cpm> linkedList) {
        AppMethodBeat.i(245208);
        p.h(linkedList, "opList");
        LinkedList<cpm> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        Iterator<T> it = linkedList2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().UserName);
        }
        com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.modelmulti.c(arrayList, TPMediaCodecProfileLevel.HEVCHighTierLevel62, 2, com.tencent.mm.n.h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30)));
        AppMethodBeat.o(245208);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(245209);
        if (qVar instanceof com.tencent.mm.modelmulti.c) {
            Log.i(TAG, "NetSceneBatchSetBlackList errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            if (i2 == 0 && i3 == 0) {
                q qVar2 = this.tipDialog;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                List<String> bdH = ((com.tencent.mm.modelmulti.c) qVar).bdH();
                p.g(bdH, "scene.names");
                String str2 = (String) kotlin.a.j.kt(bdH);
                if (str2 != null) {
                    this.uaf.add(str2);
                    this.uah.avP(str2);
                    IQ(this.uah.getCount());
                    if (this.uah.getCount() <= 0) {
                        bIo();
                    }
                    AppMethodBeat.o(245209);
                    return;
                }
                AppMethodBeat.o(245209);
                return;
            } else if (i3 == -3500) {
                q qVar3 = this.tipDialog;
                if (qVar3 != null) {
                    qVar3.dismiss();
                }
                u.makeText(this, (int) R.string.ci9, 0).show();
                AppMethodBeat.o(245209);
                return;
            } else {
                q qVar4 = this.tipDialog;
                if (qVar4 != null) {
                    qVar4.dismiss();
                }
                u.makeText(this, (int) R.string.cqb, 0).show();
            }
        }
        AppMethodBeat.o(245209);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245210);
        if (!this.uaf.isEmpty()) {
            p.h("", "userName");
            hh hhVar = new hh();
            hhVar.dLL.dLN = "";
            hhVar.dLL.dLM = 0;
            EventCenter.instance.publish(hhVar);
            Log.i(TAG, "publishEvent");
        }
        super.finish();
        AppMethodBeat.o(245210);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245211);
        String listToString = Util.listToString(this.uaf, ";");
        bbn bbn = new bbn();
        bbn.sessionId = getSessionId();
        bbn.sGQ = acj();
        bbn.sGE = ack();
        bbn.tCE = ddV();
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        long longValue = ((Number) this.uam.getValue()).longValue();
        p.g(listToString, "delUsernames");
        int i2 = this.uan;
        p.h(bbn, "contextObj");
        p.h("", "addUsernames");
        p.h(listToString, "delUsernames");
        dr drVar = new dr();
        drVar.pA(bbn.sessionId);
        drVar.pB(bbn.sGQ);
        drVar.pC(bbn.sGE);
        drVar.ku((long) bbn.tCE);
        drVar.pF(com.tencent.mm.ac.d.zs(longValue));
        drVar.pD("");
        drVar.pE(listToString);
        drVar.kv((long) i2);
        drVar.bfK();
        com.tencent.mm.plugin.finder.report.k.a(drVar);
        com.tencent.mm.kernel.g.azz().b(3528, this);
        com.tencent.mm.kernel.g.azz().b(3990, this);
        d.a aVar = com.tencent.mm.plugin.finder.storage.data.d.vFS;
        d.a.dyw().onDetach();
        q qVar = this.tipDialog;
        if (qVar != null) {
            qVar.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(245211);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final i uar = new i();

        static {
            AppMethodBeat.i(245197);
            AppMethodBeat.o(245197);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245196);
            String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
            if (cMD == null) {
                cMD = "";
            }
            AppMethodBeat.o(245196);
            return cMD;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderFriendBlackListUI uap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFriendBlackListUI finderFriendBlackListUI) {
            super(0);
            this.uap = finderFriendBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245190);
            String stringExtra = this.uap.getIntent().getStringExtra("key_context_id");
            if (stringExtra == null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                stringExtra = com.tencent.mm.plugin.finder.report.k.doc();
            }
            AppMethodBeat.o(245190);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderFriendBlackListUI uap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFriendBlackListUI finderFriendBlackListUI) {
            super(0);
            this.uap = finderFriendBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(245189);
            String stringExtra = this.uap.getIntent().getStringExtra("key_click_tab_context_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(245189);
            return stringExtra;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderFriendBlackListUI uap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderFriendBlackListUI finderFriendBlackListUI) {
            super(0);
            this.uap = finderFriendBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245193);
            Integer valueOf = Integer.valueOf(this.uap.getIntent().getIntExtra("key_comment_scene", 0));
            AppMethodBeat.o(245193);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<Long> {
        final /* synthetic */ FinderFriendBlackListUI uap;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFriendBlackListUI finderFriendBlackListUI) {
            super(0);
            this.uap = finderFriendBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(245192);
            Long valueOf = Long.valueOf(this.uap.getIntent().getLongExtra("key_click_feed_id", 0));
            AppMethodBeat.o(245192);
            return valueOf;
        }
    }

    public static final /* synthetic */ void a(FinderFriendBlackListUI finderFriendBlackListUI, String str, View view, boolean z) {
        AppMethodBeat.i(245214);
        com.tencent.mm.ui.widget.b.a aVar = finderFriendBlackListUI.pqr;
        if (aVar == null) {
            p.btv("popupMenu");
        }
        aVar.gNq();
        com.tencent.mm.ui.widget.b.a aVar2 = finderFriendBlackListUI.pqr;
        if (aVar2 == null) {
            p.btv("popupMenu");
        }
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        int i2 = TouchableLayout.kuv;
        TouchableLayout.a aVar4 = TouchableLayout.Rni;
        aVar2.a(view, new j(finderFriendBlackListUI, z), new k(finderFriendBlackListUI, str), i2, TouchableLayout.kuw);
        AppMethodBeat.o(245214);
    }
}
