package com.tencent.mm.plugin.forcenotify.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u001c\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI extends MMActivity implements MStorage.IOnStorageChange {
    private final String TAG = "MicroMsg.ForceNotifyListUI";
    private final ArrayList<com.tencent.mm.plugin.forcenotify.c.d> data = new ArrayList<>();
    private View hSw;
    private RecyclerView hak;
    private final int[] utT = new int[2];
    private a wMc;
    private View wMd;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyListUI() {
        AppMethodBeat.i(149229);
        AppMethodBeat.o(149229);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ame;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(149225);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(149225);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(149226);
        super.onCreate(bundle);
        com.tencent.mm.plugin.forcenotify.d.a.wLU.add(this);
        setMMTitle(R.string.dgy);
        setBackBtn(new c(this));
        this.hSw = findViewById(R.id.ep6);
        this.wMd = findViewById(R.id.c35);
        this.hak = (RecyclerView) findViewById(R.id.ecm);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.hyc();
        }
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.wMc = new a();
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 == null) {
            p.hyc();
        }
        recyclerView2.setAdapter(this.wMc);
        h.RTc.aX(new d(this));
        ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B("", 1, cl.aWz() / 1000);
        AppMethodBeat.o(149226);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ForceNotifyListUI wMe;

        c(ForceNotifyListUI forceNotifyListUI) {
            this.wMe = forceNotifyListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(149220);
            this.wMe.onBackPressed();
            AppMethodBeat.o(149220);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ ForceNotifyListUI wMe;

        d(ForceNotifyListUI forceNotifyListUI) {
            this.wMe = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.i(149222);
            this.wMe.data.clear();
            ArrayList arrayList = this.wMe.data;
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.wLS;
            arrayList.addAll(com.tencent.mm.plugin.forcenotify.b.c.dMo());
            this.wMe.runOnUiThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.d.AnonymousClass1 */
                final /* synthetic */ d wMq;

                {
                    this.wMq = r1;
                }

                public final void run() {
                    AppMethodBeat.i(149221);
                    Log.i(this.wMq.wMe.TAG, "[onCreate] load size=" + this.wMq.wMe.data.size());
                    a aVar = this.wMq.wMe.wMc;
                    if (aVar == null) {
                        p.hyc();
                    }
                    aVar.notifyDataSetChanged();
                    View view = this.wMq.wMe.hSw;
                    if (view == null) {
                        p.hyc();
                    }
                    view.setVisibility(8);
                    if (this.wMq.wMe.data.isEmpty()) {
                        RecyclerView recyclerView = this.wMq.wMe.hak;
                        if (recyclerView == null) {
                            p.hyc();
                        }
                        recyclerView.setVisibility(8);
                        View view2 = this.wMq.wMe.wMd;
                        if (view2 == null) {
                            p.hyc();
                        }
                        view2.setVisibility(0);
                        AppMethodBeat.o(149221);
                        return;
                    }
                    RecyclerView recyclerView2 = this.wMq.wMe.hak;
                    if (recyclerView2 == null) {
                        p.hyc();
                    }
                    recyclerView2.setVisibility(0);
                    AppMethodBeat.o(149221);
                }
            });
            AppMethodBeat.o(149222);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(149227);
        super.onDestroy();
        com.tencent.mm.plugin.forcenotify.d.a.wLU.remove(this);
        ((com.tencent.mm.plugin.forcenotify.a.a) g.af(com.tencent.mm.plugin.forcenotify.a.a.class)).B("", 2, cl.aWz() / 1000);
        AppMethodBeat.o(149227);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(149228);
        Log.i(this.TAG, "[onNotifyChange] event:%s", str);
        h.RTc.aX(new e(this));
        AppMethodBeat.o(149228);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ ForceNotifyListUI wMe;

        e(ForceNotifyListUI forceNotifyListUI) {
            this.wMe = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.i(149224);
            this.wMe.data.clear();
            ArrayList arrayList = this.wMe.data;
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.wLS;
            arrayList.addAll(com.tencent.mm.plugin.forcenotify.b.c.dMo());
            this.wMe.runOnUiThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.e.AnonymousClass1 */
                final /* synthetic */ e wMr;

                {
                    this.wMr = r1;
                }

                public final void run() {
                    AppMethodBeat.i(149223);
                    if (this.wMr.wMe.data.isEmpty()) {
                        RecyclerView recyclerView = this.wMr.wMe.hak;
                        if (recyclerView == null) {
                            p.hyc();
                        }
                        recyclerView.setVisibility(8);
                        View view = this.wMr.wMe.wMd;
                        if (view == null) {
                            p.hyc();
                        }
                        view.setVisibility(0);
                        AppMethodBeat.o(149223);
                        return;
                    }
                    RecyclerView recyclerView2 = this.wMr.wMe.hak;
                    if (recyclerView2 == null) {
                        p.hyc();
                    }
                    recyclerView2.setVisibility(0);
                    a aVar = this.wMr.wMe.wMc;
                    if (aVar == null) {
                        p.hyc();
                    }
                    aVar.notifyDataSetChanged();
                    AppMethodBeat.o(149223);
                }
            });
            AppMethodBeat.o(149224);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
    public final class a extends RecyclerView.a<b> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "msgItem", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$a$a  reason: collision with other inner class name */
        static final class C1366a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.forcenotify.c.h, x> {
            final /* synthetic */ a wMf;
            final /* synthetic */ b wMg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1366a(a aVar, b bVar) {
                super(1);
                this.wMf = aVar;
                this.wMg = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.forcenotify.c.h hVar) {
                AppMethodBeat.i(261787);
                com.tencent.mm.plugin.forcenotify.c.h hVar2 = hVar;
                p.h(hVar2, "msgItem");
                if (n.nm(hVar2.wMn, "@miniapp")) {
                    com.tencent.mm.av.q.bcV().loadImage(hVar2.kog, this.wMg.keC);
                } else {
                    a.b.d(this.wMg.keC, hVar2.username, 0.1f);
                }
                this.wMg.titleView.setText(com.tencent.mm.pluginsdk.ui.span.l.a(ForceNotifyListUI.this.getContext(), hVar2.nickname, (int) this.wMg.titleView.getTextSize(), 0, (Object) null, (String) null));
                x xVar = x.SXb;
                AppMethodBeat.o(261787);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "liveItem", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "invoke"})
        static final class b extends q implements kotlin.g.a.b<com.tencent.mm.plugin.forcenotify.c.g, x> {
            final /* synthetic */ a wMf;
            final /* synthetic */ b wMg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, b bVar) {
                super(1);
                this.wMf = aVar;
                this.wMg = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.forcenotify.c.g gVar) {
                AppMethodBeat.i(261788);
                com.tencent.mm.plugin.forcenotify.c.g gVar2 = gVar;
                p.h(gVar2, "liveItem");
                ((aj) g.ah(aj.class)).loadAvatar(gVar2.kog, this.wMg.keC);
                this.wMg.titleView.setText(com.tencent.mm.pluginsdk.ui.span.l.a(ForceNotifyListUI.this.getContext(), gVar2.nickname, (int) this.wMg.titleView.getTextSize(), 0, (Object) null, (String) null));
                x xVar = x.SXb;
                AppMethodBeat.o(261788);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(149209);
            p.h(viewGroup, "parent");
            View inflate = aa.jQ(ForceNotifyListUI.this.getContext()).inflate(R.layout.amb, (ViewGroup) null);
            if (i2 == 0) {
                ((ViewStub) inflate.findViewById(R.id.g0o)).inflate();
            } else {
                ((ViewStub) inflate.findViewById(R.id.fez)).inflate();
            }
            ForceNotifyListUI forceNotifyListUI = ForceNotifyListUI.this;
            p.g(inflate, "view");
            b bVar = new b(forceNotifyListUI, inflate);
            AppMethodBeat.o(149209);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            TextView textView;
            AppMethodBeat.i(149212);
            b bVar2 = bVar;
            p.h(bVar2, "holder");
            Object obj = ForceNotifyListUI.this.data.get(i2);
            p.g(obj, "data[position]");
            com.tencent.mm.plugin.forcenotify.c.d dVar = (com.tencent.mm.plugin.forcenotify.c.d) obj;
            int itemViewType = getItemViewType(i2);
            bVar2.username = dVar.field_UserName;
            bVar2.wMn = dVar.field_ForcePushId;
            switch (dVar.field_Type) {
                case 0:
                    com.tencent.mm.plugin.forcenotify.f.b bVar3 = com.tencent.mm.plugin.forcenotify.f.b.UWP;
                    com.tencent.mm.plugin.forcenotify.f.b.a(dVar, new C1366a(this, bVar2));
                    break;
                case 1:
                    com.tencent.mm.plugin.forcenotify.f.b bVar4 = com.tencent.mm.plugin.forcenotify.f.b.UWP;
                    com.tencent.mm.plugin.forcenotify.f.b.b(dVar, new b(this, bVar2));
                    break;
            }
            ViewPropertyAnimator animate = bVar2.wMm.animate();
            if (animate != null) {
                animate.cancel();
            }
            if (!dVar.isEnable()) {
                bVar2.wMj.setVisibility(8);
                bVar2.wMl.setVisibility(0);
            } else {
                bVar2.wMj.setVisibility(0);
                bVar2.wMl.setVisibility(8);
                TextView textView2 = bVar2.wMj;
                AppCompatActivity context = ForceNotifyListUI.this.getContext();
                p.g(context, "context");
                textView2.setText(context.getResources().getString(R.string.dh9, new SimpleDateFormat("HH:mm").format(new Date(dVar.field_ExpiredTime))));
            }
            if (itemViewType != 1 || (textView = bVar2.wMk) == null) {
                AppMethodBeat.o(149212);
                return;
            }
            textView.setText(dVar.field_ExtInfo);
            AppMethodBeat.o(149212);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(149210);
            int size = ForceNotifyListUI.this.data.size();
            AppMethodBeat.o(149210);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(149211);
            Object obj = ForceNotifyListUI.this.data.get(i2);
            p.g(obj, "data[position]");
            String str = ((com.tencent.mm.plugin.forcenotify.c.d) obj).field_UserName;
            p.g(str, "info.field_UserName");
            if (n.nm(str, "@app")) {
                AppMethodBeat.o(149211);
                return 1;
            }
            AppMethodBeat.o(149211);
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010 \u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "forcePushId", "", "getForcePushId", "()Ljava/lang/String;", "setForcePushId", "(Ljava/lang/String;)V", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "userView", "getUserView", ch.COL_USERNAME, "getUsername", "setUsername", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "", "plugin-force-notify_release"})
    public final class b extends RecyclerView.v implements View.OnCreateContextMenuListener, o.g {
        final ImageView keC;
        final TextView titleView;
        String username;
        final /* synthetic */ ForceNotifyListUI wMe;
        final TextView wMj;
        final TextView wMk;
        final LinearLayout wMl;
        final View wMm;
        String wMn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ForceNotifyListUI forceNotifyListUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.wMe = forceNotifyListUI;
            AppMethodBeat.i(149219);
            View findViewById = view.findViewById(R.id.x1);
            if (findViewById == null) {
                p.hyc();
            }
            this.keC = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ir3);
            if (findViewById2 == null) {
                p.hyc();
            }
            this.titleView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.imy);
            if (findViewById3 == null) {
                p.hyc();
            }
            this.wMj = (TextView) findViewById3;
            this.wMk = (TextView) view.findViewById(R.id.j1s);
            View findViewById4 = view.findViewById(R.id.h41);
            if (findViewById4 == null) {
                p.hyc();
            }
            this.wMl = (LinearLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.gyc);
            if (findViewById5 == null) {
                p.hyc();
            }
            this.wMm = findViewById5;
            View findViewById6 = view.findViewById(R.id.be9);
            findViewById6.setOnTouchListener(new View.OnTouchListener(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.AnonymousClass1 */
                final /* synthetic */ b wMo;

                {
                    this.wMo = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(149213);
                    p.h(view, "view");
                    p.h(motionEvent, "event");
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.wMo.wMe.utT[0] = (int) motionEvent.getRawX();
                            this.wMo.wMe.utT[1] = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(149213);
                    return false;
                }
            });
            findViewById6.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.AnonymousClass2 */
                final /* synthetic */ b wMo;

                {
                    this.wMo = r1;
                }

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(149214);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    Log.i(this.wMo.wMe.TAG, "OnLongClick!");
                    new com.tencent.mm.ui.widget.b.a(this.wMo.wMe.getContext()).a(view, 0, 0, this.wMo, this.wMo, this.wMo.wMe.utT[0], this.wMo.wMe.utT[1]);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(149214);
                    return true;
                }
            });
            this.wMl.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.AnonymousClass3 */
                final /* synthetic */ b wMo;

                {
                    this.wMo = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(149216);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i(this.wMo.wMe.TAG, "resetView onClick! username:%s", this.wMo.username);
                    com.tencent.mm.plugin.forcenotify.b.c.wLS.axA(this.wMo.username);
                    this.wMo.wMm.animate().rotation(360.0f).setDuration(300).withEndAction(new Runnable(this) {
                        /* class com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.b.AnonymousClass3.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass3 wMp;

                        {
                            this.wMp = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(149215);
                            this.wMp.wMo.wMm.animate().start();
                            AppMethodBeat.o(149215);
                        }
                    }).start();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(149216);
                }
            });
            AppMethodBeat.o(149219);
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(149217);
            if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
                Toast.makeText(this.wMe.getContext(), this.wMe.getResources().getText(R.string.dep), 1).show();
                AppMethodBeat.o(149217);
                return;
            }
            this.wMe.data.remove(lR());
            a aVar = this.wMe.wMc;
            if (aVar == null) {
                p.hyc();
            }
            aVar.ck(lR());
            com.tencent.mm.plugin.forcenotify.b.c.wLS.aS(this.wMn, 4);
            if (this.wMe.data.isEmpty()) {
                RecyclerView recyclerView = this.wMe.hak;
                if (recyclerView == null) {
                    p.hyc();
                }
                recyclerView.setVisibility(8);
                View view = this.wMe.wMd;
                if (view == null) {
                    p.hyc();
                }
                view.setVisibility(0);
            }
            AppMethodBeat.o(149217);
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(149218);
            p.h(contextMenu, "menu");
            AppCompatActivity context = this.wMe.getContext();
            p.g(context, "context");
            contextMenu.add(context.getResources().getString(R.string.dh6));
            AppMethodBeat.o(149218);
        }
    }
}
