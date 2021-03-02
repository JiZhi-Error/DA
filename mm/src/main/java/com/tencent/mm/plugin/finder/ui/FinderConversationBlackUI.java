package com.tencent.mm.plugin.finder.ui;

import android.arch.b.d;
import android.arch.b.f;
import android.arch.b.h;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ContactDataSource", "ContactDataSourceFactory", "ContactHolder", "ContactItem", "ContactListAdapter", "PageParam", "plugin-finder_release"})
public final class FinderConversationBlackUI extends MMActivity {
    public static final a vHF = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final f vHE = new f();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-finder_release"})
    public static final class d extends com.tencent.mm.view.recyclerview.h {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "Lcom/tencent/mm/storage/Contact;", "()V", "plugin-finder_release"})
    public static final class e extends as {
    }

    static {
        AppMethodBeat.i(252176);
        AppMethodBeat.o(252176);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252178);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252178);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252177);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252177);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/arch/paging/PagedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "kotlin.jvm.PlatformType", "onChanged"})
    static final class h<T> implements Observer<android.arch.b.h<e>> {
        final /* synthetic */ FinderConversationBlackUI vHJ;
        final /* synthetic */ i vHK;

        h(FinderConversationBlackUI finderConversationBlackUI, i iVar) {
            this.vHJ = finderConversationBlackUI;
            this.vHK = iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(android.arch.b.h<e> hVar) {
            AppMethodBeat.i(252173);
            this.vHJ.vHE.a(hVar);
            i iVar = this.vHK;
            Log.i("Finder.ConversationBlackUI", "[onItemsChangeLoaded]");
            MMProcessBar mMProcessBar = (MMProcessBar) iVar.vHJ._$_findCachedViewById(R.id.ep7);
            p.g(mMProcessBar, "loadingIcon");
            if (mMProcessBar.getVisibility() == 0) {
                RecyclerView recyclerView = (RecyclerView) iVar.vHJ._$_findCachedViewById(R.id.bfy);
                p.g(recyclerView, "conversationRecyclerView");
                if (recyclerView.getVisibility() != 0) {
                    MMProcessBar mMProcessBar2 = (MMProcessBar) iVar.vHJ._$_findCachedViewById(R.id.ep7);
                    p.g(mMProcessBar2, "loadingIcon");
                    mMProcessBar2.setVisibility(8);
                    RecyclerView recyclerView2 = (RecyclerView) iVar.vHJ._$_findCachedViewById(R.id.bfy);
                    p.g(recyclerView2, "conversationRecyclerView");
                    recyclerView2.setVisibility(0);
                }
            }
            AppMethodBeat.o(252173);
        }
    }

    public FinderConversationBlackUI() {
        AppMethodBeat.i(252175);
        AppMethodBeat.o(252175);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$Companion;", "", "()V", "KEY_TALKER_TYPE", "", "PAGE_COUNT", "", "PAGE_INITIAL_COUNT", "PREFETCH_DISTANCE", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252174);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
        Log.i("Finder.ConversationBlackUI", "[onCreate] talkerType==".concat(String.valueOf(intExtra)));
        setMMTitle(R.string.dam);
        setBackBtn(new g(this));
        h.d ay = new h.d.a().au().aw().ax().av().ay();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.bfy);
        p.g(recyclerView, "this");
        recyclerView.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.setAdapter(recyclerView.getAdapter());
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.lB();
        }
        RecyclerView.f itemAnimator2 = recyclerView.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.lw();
        }
        i iVar = new i(this);
        LiveData as = new android.arch.b.e(new c(intExtra), ay).a(iVar).a(com.tencent.mm.plugin.finder.a.cXm()).as();
        p.g(as, "LivePagedListBuilder(Con…tor)\n            .build()");
        as.observe(this, new h(this, iVar));
        AppMethodBeat.o(252174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderConversationBlackUI vHJ;

        g(FinderConversationBlackUI finderConversationBlackUI) {
            this.vHJ = finderConversationBlackUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252172);
            this.vHJ.finish();
            AppMethodBeat.o(252172);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$onCreate$boundaryCallback$1", "Landroid/arch/paging/PagedList$BoundaryCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "onItemAtEndLoaded", "", "itemAtEnd", "onItemAtFrontLoaded", "itemAtFront", "onItemsChangeLoaded", "onZeroItemsLoaded", "plugin-finder_release"})
    public static final class i extends h.a<e> {
        final /* synthetic */ FinderConversationBlackUI vHJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(FinderConversationBlackUI finderConversationBlackUI) {
            this.vHJ = finderConversationBlackUI;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "Landroid/arch/paging/PagedListAdapter;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactHolder;", "()V", "onBindViewHolder", "", "p0", "p1", "", "onCreateViewHolder", "Landroid/view/ViewGroup;", "Companion", "plugin-finder_release"})
    public static final class f extends android.arch.b.i<e, d> {
        private static final b vHH = new b();
        public static final a vHI = new a((byte) 0);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter$Companion$DIFF_CALLBACK$1", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter$Companion$DIFF_CALLBACK$1;", "plugin-finder_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public f() {
            super(vHH);
            AppMethodBeat.i(252170);
            AppMethodBeat.o(252170);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(252168);
            p.h(viewGroup, "p0");
            n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
            AppMethodBeat.o(252168);
            throw nVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(252169);
            p.h((d) vVar, "p0");
            n nVar = new n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
            AppMethodBeat.o(252169);
            throw nVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter$Companion$DIFF_CALLBACK$1", "Landroid/support/v7/util/DiffUtil$ItemCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "plugin-finder_release"})
        public static final class b extends c.AbstractC0051c<e> {
            b() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.support.v7.h.c.AbstractC0051c
            public final /* synthetic */ boolean d(e eVar, e eVar2) {
                AppMethodBeat.i(252166);
                e eVar3 = eVar;
                e eVar4 = eVar2;
                p.h(eVar3, "old");
                p.h(eVar4, "new");
                boolean j2 = p.j(eVar3.getUsername(), eVar4.getUsername());
                AppMethodBeat.o(252166);
                return j2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.support.v7.h.c.AbstractC0051c
            public final /* synthetic */ boolean e(e eVar, e eVar2) {
                AppMethodBeat.i(252167);
                p.h(eVar, "old");
                p.h(eVar2, "new");
                AppMethodBeat.o(252167);
                return false;
            }
        }

        static {
            AppMethodBeat.i(252171);
            AppMethodBeat.o(252171);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSourceFactory;", "Landroid/arch/paging/DataSource$Factory;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "create", "Landroid/arch/paging/DataSource;", "plugin-finder_release"})
    public static final class c extends d.a<Object, e> {
        private final int vHG;

        private /* synthetic */ c() {
            this(-1);
        }

        public c(int i2) {
            this.vHG = i2;
        }

        @Override // android.arch.b.d.a
        public final android.arch.b.d<Object, e> ar() {
            AppMethodBeat.i(252165);
            b bVar = new b(this.vHG);
            AppMethodBeat.o(252165);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J*\u0010\r\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J*\u0010\u000e\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSource;", "Landroid/arch/paging/PageKeyedDataSource;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "loadAfter", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/arch/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroid/arch/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialParams;", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialCallback;", "plugin-finder_release"})
    public static final class b extends android.arch.b.f<Object, e> {
        private final int vHG;

        private /* synthetic */ b() {
            this(-1);
        }

        public b(int i2) {
            this.vHG = i2;
        }

        @Override // android.arch.b.f
        public final void a(f.c<Object> cVar, f.a<Object, e> aVar) {
            AppMethodBeat.i(252164);
            p.h(cVar, NativeProtocol.WEB_DIALOG_PARAMS);
            p.h(aVar, "callback");
            AppMethodBeat.o(252164);
        }
    }
}
