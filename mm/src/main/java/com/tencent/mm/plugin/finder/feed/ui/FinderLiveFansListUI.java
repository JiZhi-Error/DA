package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u0010\u001c\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0014J,\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "listView", "Landroid/widget/ListView;", "liveId", "", "doGetFansScene", "", "getLayoutId", "", "initIntent", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateTitle", "FinderLiveFansAdapter", "plugin-finder_release"})
public final class FinderLiveFansListUI extends MMFinderUI implements i {
    private final String TAG = "Finder.LiveFansListUI";
    private HashMap _$_findViewCache;
    private TextView hRM;
    private boolean hasMore;
    private ListView krb;
    private long liveId;
    private com.tencent.mm.bw.b tsO;
    private final ArrayList<aqr> uae = new ArrayList<>();
    private final a ubr = new a();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245368);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245368);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245367);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245367);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderLiveFansListUI() {
        AppMethodBeat.i(245363);
        AppMethodBeat.o(245363);
    }

    public static final /* synthetic */ void b(FinderLiveFansListUI finderLiveFansListUI) {
        AppMethodBeat.i(245364);
        finderLiveFansListUI.dea();
        AppMethodBeat.o(245364);
    }

    public static final /* synthetic */ ListView c(FinderLiveFansListUI finderLiveFansListUI) {
        AppMethodBeat.i(245365);
        ListView listView = finderLiveFansListUI.krb;
        if (listView == null) {
            p.btv("listView");
        }
        AppMethodBeat.o(245365);
        return listView;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245357);
        super.onCreate(bundle);
        g.azz().a(3531, this);
        this.liveId = getIntent().getLongExtra("PARAM_FINDER_LIVE_ID", 0);
        Log.i(this.TAG, "init intent liveId:" + this.liveId);
        initView();
        dea();
        AppMethodBeat.o(245357);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(245358);
        View findViewById = findViewById(R.id.bcd);
        p.g(findViewById, "findViewById<ListView>(R.id.contact_list)");
        this.krb = (ListView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById<TextView>(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        updateTitle();
        setBackBtn(new b(this));
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setAdapter((ListAdapter) this.ubr);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        listView2.setOnScrollListener(new c(this));
        AppMethodBeat.o(245358);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLiveFansListUI ubt;

        b(FinderLiveFansListUI finderLiveFansListUI) {
            this.ubt = finderLiveFansListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245354);
            this.ubt.finish();
            AppMethodBeat.o(245354);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
    public static final class c implements AbsListView.OnScrollListener {
        final /* synthetic */ FinderLiveFansListUI ubt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderLiveFansListUI finderLiveFansListUI) {
            this.ubt = finderLiveFansListUI;
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(245355);
            if (i2 == 0 && absListView != null && !absListView.canScrollVertically(1)) {
                if (this.ubt.hasMore) {
                    FinderLiveFansListUI.b(this.ubt);
                    AppMethodBeat.o(245355);
                    return;
                } else if (FinderLiveFansListUI.c(this.ubt).getFooterViewsCount() == 0) {
                    FinderLiveFansListUI.c(this.ubt).addFooterView(View.inflate(this.ubt, R.layout.ag7, null));
                }
            }
            AppMethodBeat.o(245355);
        }
    }

    private final void updateTitle() {
        AppMethodBeat.i(245359);
        int size = this.uae.size();
        Log.i(this.TAG, "update title fans count %s", Integer.valueOf(size));
        setMMTitle(getString(R.string.cqf, new Object[]{Integer.valueOf(this.uae.size())}));
        if (size == 0) {
            TextView textView = this.hRM;
            if (textView == null) {
                p.btv("emptyTip");
            }
            textView.setVisibility(0);
            TextView textView2 = this.hRM;
            if (textView2 == null) {
                p.btv("emptyTip");
            }
            textView2.setText(getString(R.string.cqg));
            AppMethodBeat.o(245359);
            return;
        }
        TextView textView3 = this.hRM;
        if (textView3 == null) {
            p.btv("emptyTip");
        }
        textView3.setVisibility(8);
        AppMethodBeat.o(245359);
    }

    private final void dea() {
        AppMethodBeat.i(245360);
        g.azz().b(new bg(this.tsO, this.liveId, 1));
        AppMethodBeat.o(245360);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245361);
        super.onDestroy();
        g.azz().b(3531, this);
        AppMethodBeat.o(245361);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_5;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(245362);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
                AppMethodBeat.o(245362);
                throw tVar;
            }
            if (!p.j(this.tsO, ((bg) qVar).cYn())) {
                Log.i(this.TAG, "not my buf, ignore!");
                AppMethodBeat.o(245362);
                return;
            }
            this.hasMore = ((bg) qVar).cYp();
            this.tsO = ((bg) qVar).cYm();
            com.tencent.mm.ac.d.h(new d(this, qVar));
        }
        AppMethodBeat.o(245362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\bH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;", "Landroid/widget/BaseAdapter;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setContactList", "", "FansViewHolder", "plugin-finder_release"})
    public static final class a extends BaseAdapter {
        ArrayList<aqr> kgc = new ArrayList<>();

        public a() {
            AppMethodBeat.i(245353);
            AppMethodBeat.o(245353);
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(245351);
            aqr IR = IR(i2);
            AppMethodBeat.o(245351);
            return IR;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter$FansViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveFansListUI$FinderLiveFansAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI$a$a  reason: collision with other inner class name */
        public final class C1168a extends RecyclerView.v {
            ImageView keC;
            TextView qbF;
            final /* synthetic */ a ubs;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1168a(a aVar, View view) {
                super(view);
                p.h(view, "itemView");
                this.ubs = aVar;
                AppMethodBeat.i(245348);
                View findViewById = view.findViewById(R.id.x1);
                p.g(findViewById, "itemView.findViewById<ImageView>(R.id.avatar_iv)");
                this.keC = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.fzg);
                p.g(findViewById2, "itemView.findViewById<TextView>(R.id.nickname_tv)");
                this.qbF = (TextView) findViewById2;
                AppMethodBeat.o(245348);
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            String str;
            String str2;
            String str3 = null;
            AppMethodBeat.i(245349);
            p.h(viewGroup, "parent");
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), R.layout.adm, null);
                p.g(view, "itemView");
                view.setTag(new C1168a(this, view));
            }
            Object tag = view.getTag();
            if (!(tag instanceof C1168a)) {
                tag = null;
            }
            C1168a aVar = (C1168a) tag;
            if (aVar != null) {
                aqr IR = IR(i2);
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> dkb = m.dkb();
                FinderContact finderContact = IR.contact;
                if (finderContact == null || (str = finderContact.headUrl) == null) {
                    str = "";
                }
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
                ImageView imageView = aVar.keC;
                m mVar2 = m.uJa;
                dkb.a(aVar2, imageView, m.a(m.a.WX_AVATAR));
                TextView textView = aVar.qbF;
                Context context = aVar.qbF.getContext();
                y yVar = y.vXH;
                FinderContact finderContact2 = IR.contact;
                if (finderContact2 != null) {
                    str2 = finderContact2.username;
                } else {
                    str2 = null;
                }
                FinderContact finderContact3 = IR.contact;
                if (finderContact3 != null) {
                    str3 = finderContact3.nickname;
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.hf(str2, str3)));
            }
            AppMethodBeat.o(245349);
            return view;
        }

        private aqr IR(int i2) {
            AppMethodBeat.i(245350);
            int size = this.kgc.size();
            if (i2 >= 0 && size > i2) {
                aqr aqr = this.kgc.get(i2);
                p.g(aqr, "dataList[position]");
                aqr aqr2 = aqr;
                AppMethodBeat.o(245350);
                return aqr2;
            }
            aqr aqr3 = new aqr();
            AppMethodBeat.o(245350);
            return aqr3;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getCount() {
            AppMethodBeat.i(245352);
            int size = this.kgc.size();
            AppMethodBeat.o(245352);
            return size;
        }
    }

    public static final /* synthetic */ void a(FinderLiveFansListUI finderLiveFansListUI, List list) {
        AppMethodBeat.i(245366);
        Log.i(finderLiveFansListUI.TAG, "fans contact " + (list != null ? Integer.valueOf(list.size()) : null));
        if (list != null) {
            finderLiveFansListUI.uae.addAll(list);
            a aVar = finderLiveFansListUI.ubr;
            ArrayList<aqr> arrayList = finderLiveFansListUI.uae;
            p.h(arrayList, "dataList");
            aVar.kgc = arrayList;
            finderLiveFansListUI.ubr.notifyDataSetChanged();
            finderLiveFansListUI.updateTitle();
        }
        AppMethodBeat.o(245366);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q hvN;
        final /* synthetic */ FinderLiveFansListUI ubt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLiveFansListUI finderLiveFansListUI, q qVar) {
            super(0);
            this.ubt = finderLiveFansListUI;
            this.hvN = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245356);
            FinderLiveFansListUI.a(this.ubt, ((bg) this.hvN).cYo());
            x xVar = x.SXb;
            AppMethodBeat.o(245356);
            return xVar;
        }
    }
}
