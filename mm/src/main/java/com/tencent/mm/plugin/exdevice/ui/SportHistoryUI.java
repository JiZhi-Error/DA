package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.exdevice.g.a.k;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u000201B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020#H\u0014J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020&H\u0014J,\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010!2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R&\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\u000b\u001a\u001a\u0012\b\u0012\u00060\u0006R\u00020\u00000\fj\f\u0012\b\u0012\u00060\u0006R\u00020\u0000`\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "netSceneGetSportHistory", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "getNetSceneGetSportHistory", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "setNetSceneGetSportHistory", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "formatDay", "", "time", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "HistoryItem", "HistoryItemConvert", "app_release"})
public final class SportHistoryUI extends MMSecDataActivity implements i {
    private ArrayList<a> kgc = new ArrayList<>();
    WxRecyclerView rHX;
    private k rMF;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SportHistoryUI() {
        AppMethodBeat.i(230635);
        AppMethodBeat.o(230635);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(230632);
        super.onCreate(bundle);
        setMMTitle(R.string.c25);
        setBackBtn(new d(this));
        this.rHX = (WxRecyclerView) findViewById(R.id.gy2);
        WxRecyclerView wxRecyclerView = this.rHX;
        if (wxRecyclerView != null) {
            wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerView wxRecyclerView2 = this.rHX;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setAdapter(new WxRecyclerAdapter(new c(this), this.kgc));
        }
        WxRecyclerView wxRecyclerView3 = this.rHX;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(new e(this));
        }
        g.azz().a(4835, this);
        bvp bvp = new bvp();
        bvp.username = getIntent().getStringExtra(ch.COL_USERNAME);
        this.rMF = new k(bvp);
        g.azz().b(this.rMF);
        AppMethodBeat.o(230632);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ SportHistoryUI rMH;

        d(SportHistoryUI sportHistoryUI) {
            this.rMH = sportHistoryUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(230630);
            this.rMH.finish();
            AppMethodBeat.o(230630);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$onCreate$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
    public static final class e extends RecyclerView.h {
        final /* synthetic */ SportHistoryUI rMH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(SportHistoryUI sportHistoryUI) {
            this.rMH = sportHistoryUI;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, int i2, RecyclerView recyclerView) {
            RecyclerView.a adapter;
            AppMethodBeat.i(230631);
            p.h(rect, "outRect");
            p.h(recyclerView, "parent");
            WxRecyclerView wxRecyclerView = this.rMH.rHX;
            if (i2 == ((wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) ? 1 : adapter.getItemCount()) - 1) {
                rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.rMH, 16);
            }
            AppMethodBeat.o(230631);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(230633);
        k kVar = this.rMF;
        if (kVar != null) {
            g.azz().a(kVar);
        }
        g.azz().b(4835, this);
        super.onDestroy();
        AppMethodBeat.o(230633);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
    public static final class c implements f {
        final /* synthetic */ SportHistoryUI rMH;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(SportHistoryUI sportHistoryUI) {
            this.rMH = sportHistoryUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(230629);
            b bVar = new b();
            AppMethodBeat.o(230629);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
    public final class b extends com.tencent.mm.view.recyclerview.e<a> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(h hVar, a aVar, int i2, int i3, boolean z, List list) {
            String formatTime;
            AppMethodBeat.i(230628);
            a aVar2 = aVar;
            p.h(hVar, "holder");
            p.h(aVar2, "item");
            View Mn = hVar.Mn(R.id.bkp);
            p.g(Mn, "holder.getView<TextView>(R.id.date_tv)");
            TextView textView = (TextView) Mn;
            SportHistoryUI sportHistoryUI = SportHistoryUI.this;
            int i4 = aVar2.rMG.qwL;
            if (((long) i4) * 1000 >= com.tencent.mm.plugin.sport.model.k.fmH()) {
                formatTime = sportHistoryUI.getString(R.string.c2e);
                p.g(formatTime, "getString(R.string.exdevice_today)");
            } else {
                if (((long) i4) * 1000 >= com.tencent.mm.plugin.sport.model.k.fmH() - Util.MILLSECONDS_OF_DAY) {
                    formatTime = sportHistoryUI.getString(R.string.c2q);
                } else {
                    formatTime = com.tencent.mm.pluginsdk.i.f.formatTime(sportHistoryUI.getString(R.string.dec), (long) i4);
                }
                p.g(formatTime, "if (time * 1000L >= Spor… time.toLong())\n        }");
            }
            textView.setText(formatTime);
            ffn ffn = aVar2.rMG.LpZ;
            int i5 = ffn != null ? ffn.score : 0;
            View Mn2 = hVar.Mn(R.id.i5w);
            p.g(Mn2, "holder.getView<TextView>(R.id.step_tv)");
            ((TextView) Mn2).setText(String.valueOf(i5));
            if (i5 >= 10000) {
                ((TextView) hVar.Mn(R.id.i5w)).setTextColor(com.tencent.mm.cb.a.n(SportHistoryUI.this, R.color.nq));
            } else {
                ((TextView) hVar.Mn(R.id.i5w)).setTextColor(com.tencent.mm.cb.a.n(SportHistoryUI.this, R.color.np));
            }
            View Mn3 = hVar.Mn(R.id.eba);
            p.g(Mn3, "holder.getView<TextView>(R.id.like_count_tv)");
            ((TextView) Mn3).setText(String.valueOf(aVar2.rMG.Lqb));
            if (aVar2.rMG.ApK) {
                ((ImageView) hVar.Mn(R.id.ebf)).setImageResource(R.raw.device_rank_item_liked);
            } else {
                ((ImageView) hVar.Mn(R.id.ebf)).setImageResource(R.raw.device_rank_item_unliked);
            }
            ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.tg);
            viewGroup.removeAllViews();
            LinkedList<ecf> linkedList = aVar2.rMG.Lqa;
            p.g(linkedList, LocaleUtil.ITALIAN);
            if (!(!linkedList.isEmpty())) {
                linkedList = null;
            }
            if (linkedList != null) {
                p.g(viewGroup, "sportLayout");
                viewGroup.setVisibility(0);
                View Mn4 = hVar.Mn(R.id.tf);
                p.g(Mn4, "holder.getView<View>(R.i…brand_sport_info_divider)");
                Mn4.setVisibility(0);
            } else {
                p.g(viewGroup, "sportLayout");
                viewGroup.setVisibility(8);
                View Mn5 = hVar.Mn(R.id.tf);
                p.g(Mn5, "holder.getView<View>(R.i…brand_sport_info_divider)");
                Mn5.setVisibility(8);
            }
            LinkedList<ecf> linkedList2 = aVar2.rMG.Lqa;
            p.g(linkedList2, "item.record.sportrecord");
            for (T t : linkedList2) {
                z.f fVar = new z.f();
                fVar.SYG = (T) SportHistoryUI.this.getLayoutInflater().inflate(R.layout.a4x, viewGroup, false);
                View findViewById = fVar.SYG.findViewById(R.id.t2);
                p.g(findViewById, "view.findViewById<TextVi…(R.id.appbrand_info_1_tv)");
                ((TextView) findViewById).setText(t.Ncs);
                View findViewById2 = fVar.SYG.findViewById(R.id.t3);
                p.g(findViewById2, "view.findViewById<TextVi…(R.id.appbrand_info_2_tv)");
                ((TextView) findViewById2).setText(String.valueOf(t.Nct));
                View findViewById3 = fVar.SYG.findViewById(R.id.t4);
                p.g(findViewById3, "view.findViewById<TextVi…(R.id.appbrand_info_3_tv)");
                ((TextView) findViewById3).setText(t.Ncu);
                ImageView imageView = (ImageView) fVar.SYG.findViewById(R.id.t1);
                if (!p.j("21f9d636b41b25be", t.appId)) {
                    ((q) g.af(q.class)).b(t.appId, new C1004b(fVar, imageView));
                } else {
                    ((TextView) fVar.SYG.findViewById(R.id.t7)).setText(R.string.hdq);
                    imageView.setImageResource(R.raw.icons_outlined_apple_watch);
                }
                viewGroup.addView(fVar.SYG);
                fVar.SYG.setOnClickListener(new a(t, this, viewGroup));
            }
            AppMethodBeat.o(230628);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.bym;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, h hVar, int i2) {
            AppMethodBeat.i(230627);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(230627);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
        /* renamed from: com.tencent.mm.plugin.exdevice.ui.SportHistoryUI$b$b  reason: collision with other inner class name */
        static final class C1004b implements q.a {
            final /* synthetic */ z.f qhQ;
            final /* synthetic */ ImageView rMO;

            C1004b(z.f fVar, ImageView imageView) {
                this.qhQ = fVar;
                this.rMO = imageView;
            }

            @Override // com.tencent.mm.plugin.appbrand.service.q.a
            public final void b(WxaAttributes wxaAttributes) {
                AppMethodBeat.i(230626);
                if (wxaAttributes != null) {
                    com.tencent.f.h.RTc.aV(new a(wxaAttributes, this));
                    AppMethodBeat.o(230626);
                    return;
                }
                AppMethodBeat.o(230626);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$4$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.exdevice.ui.SportHistoryUI$b$b$a */
            static final class a implements Runnable {
                final /* synthetic */ WxaAttributes rMP;
                final /* synthetic */ C1004b rMQ;

                a(WxaAttributes wxaAttributes, C1004b bVar) {
                    this.rMP = wxaAttributes;
                    this.rMQ = bVar;
                }

                public final void run() {
                    AppMethodBeat.i(230625);
                    View findViewById = this.rMQ.qhQ.SYG.findViewById(R.id.t7);
                    p.g(findViewById, "view.findViewById<TextView>(R.id.appbrand_name_tv)");
                    ((TextView) findViewById).setText(this.rMP.field_nickname);
                    com.tencent.mm.av.q.bcV().a(this.rMP.field_smallHeadURL, this.rMQ.rMO, new c.a().bdt().bdq().bdv());
                    AppMethodBeat.o(230625);
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$4$2"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ ecf rMI;
            final /* synthetic */ b rMJ;
            final /* synthetic */ ViewGroup rMK;

            a(ecf ecf, b bVar, ViewGroup viewGroup) {
                this.rMI = ecf;
                this.rMJ = bVar;
                this.rMK = viewGroup;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230624);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((q) g.af(q.class)).b(this.rMI.appId, new q.a(this) {
                    /* class com.tencent.mm.plugin.exdevice.ui.SportHistoryUI.b.a.AnonymousClass1 */
                    final /* synthetic */ a rML;

                    {
                        this.rML = r1;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.service.q.a
                    public final void b(final WxaAttributes wxaAttributes) {
                        AppMethodBeat.i(230623);
                        if (wxaAttributes != null) {
                            f.a aVar = new f.a(MMApplicationContext.getContext());
                            aVar.bow(SportHistoryUI.this.getString(R.string.hq6, new Object[]{wxaAttributes.field_nickname})).Dq(true);
                            aVar.apa(R.string.h4);
                            aVar.c(new f.c() {
                                /* class com.tencent.mm.plugin.exdevice.ui.SportHistoryUI.b.a.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                    AppMethodBeat.i(230622);
                                    if (z) {
                                        wq wqVar = new wq();
                                        wqVar.ecI.userName = wxaAttributes.field_username;
                                        wqVar.ecI.ecK = this.rML.rMI.Ncv;
                                        wqVar.ecI.scene = 1171;
                                        EventCenter.instance.publish(wqVar);
                                    }
                                    AppMethodBeat.o(230622);
                                }
                            }).show();
                            AppMethodBeat.o(230623);
                            return;
                        }
                        AppMethodBeat.o(230623);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItemConvert$onBindViewHolder$$inlined$forEach$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230624);
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.byn;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        RecyclerView.a adapter;
        bvq bvq;
        LinkedList<aes> linkedList;
        AppMethodBeat.i(230634);
        if (i2 == 0 && i3 == 0) {
            k kVar = this.rMF;
            if (!(kVar == null || (bvq = kVar.rCP) == null || (linkedList = bvq.MbD) == null)) {
                int i4 = 0;
                for (T t : linkedList) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    ArrayList<a> arrayList = this.kgc;
                    p.g(t2, "dailySportRecord");
                    arrayList.add(new a(this, (long) i4, t2));
                    i4 = i5;
                }
            }
            WxRecyclerView wxRecyclerView = this.rHX;
            if (!(wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
        }
        View findViewById = findViewById(R.id.ep_);
        p.g(findViewById, "findViewById<View>(R.id.loading_bar)");
        findViewById.setVisibility(8);
        this.rMF = null;
        AppMethodBeat.o(230634);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI$HistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "record", "Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "(Lcom/tencent/mm/plugin/exdevice/ui/SportHistoryUI;JLcom/tencent/mm/protocal/protobuf/DailySportRecord;)V", "getId", "()J", "getRecord", "()Lcom/tencent/mm/protocal/protobuf/DailySportRecord;", "getItemId", "getItemType", "", "app_release"})
    public final class a implements com.tencent.mm.view.recyclerview.a {
        private final long id;
        final aes rMG;
        final /* synthetic */ SportHistoryUI rMH;

        public a(SportHistoryUI sportHistoryUI, long j2, aes aes) {
            p.h(aes, "record");
            this.rMH = sportHistoryUI;
            AppMethodBeat.i(230621);
            this.id = j2;
            this.rMG = aes;
            AppMethodBeat.o(230621);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return this.id;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 3;
        }
    }
}
