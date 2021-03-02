package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.live.view.adapter.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\f¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI17;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Landroid/view/View$OnClickListener;", "()V", "cancelTv", "Landroid/widget/TextView;", "chooseWhiteList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getChooseWhiteList", "()Ljava/util/LinkedList;", "setChooseWhiteList", "(Ljava/util/LinkedList;)V", "contentView", "Landroid/support/v7/widget/RecyclerView;", "finishTv", "titleGroup", "Landroid/view/View;", "visitorWhiteList", "getVisitorWhiteList", "setVisitorWhiteList", "whiteListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter;", "whiteListWrapper", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListAdapter$FinderLiveAudienceListFileWrapper;", "getWhiteListWrapper", "setWhiteListWrapper", "getLayoutId", "", "handleFinish", "", "initLogic", "initViews", "mergeWhiteList", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseInten", "setWindowStyle", "updateChooseList", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI17 extends MMFinderUI implements View.OnClickListener {
    public static final a UJk = new a((byte) 0);
    private RecyclerView FCJ;
    private i UJi;
    private LinkedList<i.c> UJj = new LinkedList<>();
    private HashMap _$_findViewCache;
    private View hRR;
    private TextView ued;
    private TextView uee;
    private LinkedList<avh> ueu = new LinkedList<>();
    private LinkedList<avh> uev = new LinkedList<>();

    static {
        AppMethodBeat.i(260303);
        AppMethodBeat.o(260303);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(260306);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(260306);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(260305);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(260305);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OccupyFinderUI17() {
        AppMethodBeat.i(260302);
        AppMethodBeat.o(260302);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI17$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ OccupyFinderUI17 UJl;

        c(OccupyFinderUI17 occupyFinderUI17) {
            this.UJl = occupyFinderUI17;
        }

        public final void run() {
            ViewGroup.LayoutParams layoutParams;
            ViewParent viewParent;
            ViewGroup viewGroup = null;
            AppMethodBeat.i(260299);
            int statusBarHeight = au.getStatusBarHeight(this.UJl.getContext());
            View view = this.UJl.hRR;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = statusBarHeight;
            }
            View view2 = this.UJl.hRR;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.updateViewLayout(this.UJl.hRR, marginLayoutParams);
                AppMethodBeat.o(260299);
                return;
            }
            AppMethodBeat.o(260299);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        T t;
        Integer num = null;
        AppMethodBeat.i(260300);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        context.getWindow().addFlags(2097280);
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        context2.getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            AppCompatActivity context3 = getContext();
            p.g(context3, "context");
            context3.getWindow().clearFlags(67108864);
            AppCompatActivity context4 = getContext();
            p.g(context4, "context");
            Window window = context4.getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            AppCompatActivity context5 = getContext();
            p.g(context5, "context");
            context5.getWindow().addFlags(Integer.MIN_VALUE);
            AppCompatActivity context6 = getContext();
            p.g(context6, "context");
            Window window2 = context6.getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            AppCompatActivity context7 = getContext();
            p.g(context7, "context");
            Window window3 = context7.getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        AppCompatActivity context8 = getContext();
        p.g(context8, "context");
        context8.getWindow().setFormat(-3);
        AppCompatActivity context9 = getContext();
        p.g(context9, "context");
        context9.getWindow().setSoftInputMode(51);
        this.hRR = findViewById(R.id.iq_);
        View view = this.hRR;
        if (view != null) {
            view.post(new c(this));
        }
        this.ued = (TextView) findViewById(R.id.aik);
        this.uee = (TextView) findViewById(R.id.d54);
        this.FCJ = (RecyclerView) findViewById(R.id.jnm);
        TextView textView = this.uee;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.ued;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        i iVar = new i();
        iVar.uCb = new b(this);
        this.UJi = iVar;
        RecyclerView recyclerView = this.FCJ;
        if (recyclerView != null) {
            recyclerView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
            recyclerView.setAdapter(this.UJi);
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = au.aD(recyclerView.getContext());
            }
        }
        Intent intent = getIntent();
        OccupyFinderUI14.a aVar = OccupyFinderUI14.ueB;
        Serializable serializableExtra = intent.getSerializableExtra(OccupyFinderUI14.deH());
        if (!(serializableExtra instanceof List)) {
            serializableExtra = null;
        }
        List list = (List) serializableExtra;
        if (list != null) {
            m mVar = m.vVH;
            m.b(list, this.ueu);
        }
        Intent intent2 = getIntent();
        OccupyFinderUI14.a aVar2 = OccupyFinderUI14.ueB;
        Serializable serializableExtra2 = intent2.getSerializableExtra(OccupyFinderUI14.deI());
        if (!(serializableExtra2 instanceof List)) {
            serializableExtra2 = null;
        }
        List list2 = (List) serializableExtra2;
        if (list2 != null) {
            m mVar2 = m.vVH;
            m.b(list2, this.uev);
        }
        this.UJj.clear();
        for (T t2 : this.ueu) {
            Iterator<T> it = this.uev.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (p.j(t.KRd, t2.KRd)) {
                    break;
                }
            }
            this.UJj.add(new i.c(t != null, t2));
        }
        i iVar2 = this.UJi;
        if (iVar2 != null) {
            LinkedList<i.c> linkedList = this.UJj;
            StringBuilder append = new StringBuilder("updateWhiteList,ori size:").append(iVar2.ppH.size()).append(",new size:");
            if (linkedList != null) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i("FinderLiveWhiteListAdapter", append.append(num).toString());
            if (linkedList != null) {
                iVar2.ppH.clear();
                iVar2.ppH.addAll(linkedList);
                iVar2.ppH.add(new i.c(false, new avh(), 2));
            }
        }
        i iVar3 = this.UJi;
        if (iVar3 != null) {
            iVar3.notifyDataSetChanged();
        }
        Log.i("Finder.FinderLiveWhiteListUI", "initLogic visitorWhiteList size:" + this.ueu.size() + ",chooseWhiteList size:" + this.uev.size());
        AppMethodBeat.o(260300);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ag6;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(260301);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.d54) {
            Intent intent = new Intent();
            OccupyFinderUI14.a aVar = OccupyFinderUI14.ueB;
            String deI = OccupyFinderUI14.deI();
            LinkedList<avh> linkedList = this.uev;
            ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toByteArray());
            }
            intent.putExtra(deI, arrayList);
            OccupyFinderUI14.a aVar2 = OccupyFinderUI14.ueB;
            String deI2 = OccupyFinderUI14.deI();
            LinkedList<avh> linkedList2 = this.uev;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().toByteArray());
            }
            intent.putExtra(deI2, arrayList2);
            setResult(-1, intent);
            finish();
        } else if (valueOf != null && valueOf.intValue() == R.id.aik) {
            setResult(0);
            finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(260301);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI17$initViews$2$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI17 UJl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(OccupyFinderUI17 occupyFinderUI17) {
            super(0);
            this.UJl = occupyFinderUI17;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260298);
            OccupyFinderUI17.b(this.UJl);
            x xVar = x.SXb;
            AppMethodBeat.o(260298);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(OccupyFinderUI17 occupyFinderUI17) {
        AppMethodBeat.i(260304);
        Log.i("Finder.FinderLiveWhiteListUI", "before updateChooseList size:" + occupyFinderUI17.uev.size());
        occupyFinderUI17.uev.clear();
        for (T t : occupyFinderUI17.UJj) {
            if (t.uCe) {
                occupyFinderUI17.uev.add(t.uCf);
            }
        }
        Log.i("Finder.FinderLiveWhiteListUI", "after updateChooseList size:" + occupyFinderUI17.uev.size());
        AppMethodBeat.o(260304);
    }
}
