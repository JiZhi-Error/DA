package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.ui.adapter.a;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.j;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.ak;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\n\u001c!\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0017H\u0016J\u0012\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u0002022\b\u00108\u001a\u0004\u0018\u00010\u001fJ\u000e\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\rJ\u001a\u0010;\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010)R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00060$j\b\u0012\u0004\u0012\u00020\u0006`%X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0$j\b\u0012\u0004\u0012\u00020'`%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R#\u0010+\u001a\n \u0011*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "childListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1;", "currentIndex", "", "currentTime", "fullLyricView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "getFullLyricView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "fullLyricView$delegate", "Lkotlin/Lazy;", "isShowFulScreenLyric", "", "()Z", "setShowFulScreenLyric", "(Z)V", "itemClick", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1;", "itemView", "Landroid/view/View;", "lyricEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1;", "lyricLines", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lyricList", "Landroid/support/v7/widget/RecyclerView;", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "mainRV", "getMainRV", "()Landroid/support/v7/widget/RecyclerView;", "mainRV$delegate", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "hideFullLyric", "", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "selectView", "parent", "setCurrentTime", "currentPos", "setSongInfo", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "obj", "plugin-mv_release"})
public final class MusicMvLyricUIC extends UIComponent {
    com.tencent.mm.plugin.music.model.e Amv;
    private final f AtI;
    private final f AtJ;
    RecyclerView AtK;
    ArrayList<RecyclerView> AtL;
    private final ArrayList<String> AtM;
    private com.tencent.mm.xeffect.effect.b AtN;
    public boolean AtO;
    private final c AtP;
    final d AtQ;
    private final a AtR;
    private final c Atl;
    private final String TAG = "MicroMsg.MusicMvLyricUIC";
    View aus;
    int currentIndex;
    int dCS;

    /* access modifiers changed from: package-private */
    public final MusicMvLyricView evQ() {
        AppMethodBeat.i(257141);
        MusicMvLyricView musicMvLyricView = (MusicMvLyricView) this.AtI.getValue();
        AppMethodBeat.o(257141);
        return musicMvLyricView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvLyricUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257146);
        this.AtI = g.ah(new b(appCompatActivity));
        this.AtJ = g.ah(new e(appCompatActivity));
        this.AtL = new ArrayList<>();
        this.AtM = new ArrayList<>();
        this.currentIndex = -1;
        this.Atl = new c();
        this.AtP = new c(this, appCompatActivity);
        this.AtQ = new d(this);
        this.AtR = new a(this);
        AppMethodBeat.o(257146);
    }

    public static final /* synthetic */ MusicMvLyricView d(MusicMvLyricUIC musicMvLyricUIC) {
        AppMethodBeat.i(257147);
        MusicMvLyricView evQ = musicMvLyricUIC.evQ();
        AppMethodBeat.o(257147);
        return evQ;
    }

    public static final /* synthetic */ void g(MusicMvLyricUIC musicMvLyricUIC) {
        AppMethodBeat.i(257148);
        musicMvLyricUIC.evR();
        AppMethodBeat.o(257148);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"})
    public static final class c implements a.b {
        final /* synthetic */ MusicMvLyricUIC AtS;
        final /* synthetic */ AppCompatActivity uQi;

        c(MusicMvLyricUIC musicMvLyricUIC, AppCompatActivity appCompatActivity) {
            this.AtS = musicMvLyricUIC;
            this.uQi = appCompatActivity;
        }

        @Override // com.tencent.mm.plugin.mv.ui.adapter.a.b
        public final void cVN() {
            AppMethodBeat.i(257137);
            View view = this.AtS.aus;
            if (view != null) {
                this.AtS.Atl.eD(view).s(ak.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.f5l), Integer.valueOf((int) R.id.fru), Integer.valueOf((int) R.id.d8d), Integer.valueOf((int) R.id.dol), Integer.valueOf((int) R.id.bi3)}));
            }
            RecyclerView recyclerView = this.AtS.AtK;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            MusicMvLyricView d2 = MusicMvLyricUIC.d(this.AtS);
            if (d2 != null) {
                d2.setVisibility(4);
            }
            MusicMvLyricView d3 = MusicMvLyricUIC.d(this.AtS);
            if (d3 != null) {
                d3.setAlpha(0.0f);
            }
            View view2 = this.AtS.aus;
            if (view2 != null) {
                view2.post(new a(this));
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvMainUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
            MusicMvMainUIC musicMvMainUIC = (MusicMvMainUIC) viewModel;
            EffectManager evU = musicMvMainUIC.evU();
            if (evU != null) {
                this.AtS.AtN = (com.tencent.mm.xeffect.effect.b) evU.a(j.BlurEffect);
                com.tencent.mm.xeffect.effect.b bVar = this.AtS.AtN;
                if (bVar != null) {
                    bVar.setRadius(20.0f);
                }
                evU.a(this.AtS.AtN);
            }
            musicMvMainUIC.hWG();
            this.AtS.AtO = true;
            WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> adapter = musicMvMainUIC.getAdapter();
            int i2 = musicMvMainUIC.AtW.hbQ;
            MusicMvMainUIC.a aVar2 = MusicMvMainUIC.Aul;
            adapter.e(i2, 1, MusicMvMainUIC.evV());
            AppMethodBeat.o(257137);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c AtT;

            a(c cVar) {
                this.AtT = cVar;
            }

            public final void run() {
                AppMethodBeat.i(257136);
                MusicMvLyricView d2 = MusicMvLyricUIC.d(this.AtT.AtS);
                if (d2 != null) {
                    d2.E((long) this.AtT.AtS.dCS, false);
                }
                MusicMvLyricView d3 = MusicMvLyricUIC.d(this.AtT.AtS);
                if (d3 != null) {
                    d3.setVisibility(0);
                }
                MusicMvLyricView d4 = MusicMvLyricUIC.d(this.AtT.AtS);
                if (d4 != null) {
                    d4.animate().cancel();
                    d4.animate().alpha(1.0f).start();
                    AppMethodBeat.o(257136);
                    return;
                }
                AppMethodBeat.o(257136);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$lyricEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$OnLyricEventListener;", "onBackClick", "", "onLineClick", "position", "", "time", "", "plugin-mv_release"})
    public static final class d implements MusicMvLyricView.h {
        final /* synthetic */ MusicMvLyricUIC AtS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(MusicMvLyricUIC musicMvLyricUIC) {
            this.AtS = musicMvLyricUIC;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h
        public final void evS() {
            AppMethodBeat.i(257138);
            MusicMvLyricUIC.g(this.AtS);
            AppMethodBeat.o(257138);
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h
        public final void Hu(long j2) {
            AppMethodBeat.i(257139);
            com.tencent.mm.ay.a.tG((int) j2);
            if (com.tencent.mm.ay.a.bec()) {
                com.tencent.mm.ay.a.bdZ();
                AppMethodBeat.o(257139);
                return;
            }
            com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
            if (bef != null) {
                bef.dvv = (int) j2;
            }
            k.euj().t(bef);
            AppMethodBeat.o(257139);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "onChildViewRemoved", "plugin-mv_release"})
    public static final class a implements ViewGroup.OnHierarchyChangeListener {
        final /* synthetic */ MusicMvLyricUIC AtS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(MusicMvLyricUIC musicMvLyricUIC) {
            this.AtS = musicMvLyricUIC;
        }

        public final void onChildViewAdded(View view, View view2) {
            RecyclerView recyclerView;
            AppMethodBeat.i(257133);
            if (view2 == null || (recyclerView = (RecyclerView) view2.findViewById(R.id.f5j)) == null) {
                AppMethodBeat.o(257133);
            } else if (this.AtS.AtL.contains(recyclerView)) {
                AppMethodBeat.o(257133);
            } else {
                this.AtS.AtL.add(recyclerView);
                if (((com.tencent.mm.plugin.mv.ui.adapter.a) recyclerView.getAdapter()) == null) {
                    com.tencent.mm.plugin.mv.ui.adapter.a aVar = new com.tencent.mm.plugin.mv.ui.adapter.a(this.AtS.AtP);
                    aVar.hw(this.AtS.AtM);
                    recyclerView.setAdapter(aVar);
                }
                if (((LinearLayoutManager) recyclerView.getLayoutManager()) != null) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.AtS.currentIndex, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                    recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC$childListener$1", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
                }
                AppMethodBeat.o(257133);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            RecyclerView recyclerView;
            AppMethodBeat.i(257134);
            if (view2 == null || (recyclerView = (RecyclerView) view2.findViewById(R.id.f5j)) == null) {
                AppMethodBeat.o(257134);
                return;
            }
            this.AtS.AtL.remove(recyclerView);
            AppMethodBeat.o(257134);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateAfter(Bundle bundle) {
        AppMethodBeat.i(257142);
        super.onCreateAfter(bundle);
        RecyclerView recyclerView = (RecyclerView) this.AtJ.getValue();
        if (recyclerView != null) {
            recyclerView.setOnHierarchyChangeListener(this.AtR);
            AppMethodBeat.o(257142);
            return;
        }
        AppMethodBeat.o(257142);
    }

    public final void a(axy axy, com.tencent.mm.plugin.music.model.e eVar) {
        String str;
        AppMethodBeat.i(257143);
        this.AtM.clear();
        this.Amv = eVar;
        com.tencent.mm.plugin.music.model.e eVar2 = this.Amv;
        if (eVar2 != null) {
            int euw = eVar2.euw();
            for (int i2 = 0; i2 < euw; i2++) {
                ArrayList<String> arrayList = this.AtM;
                String str2 = eVar2.SQ(i2).content;
                if (str2 == null) {
                    str2 = "";
                }
                arrayList.add(str2);
            }
        }
        evQ().setLyricObj(eVar);
        if (!(axy == null || (str = axy.BPc) == null)) {
            MusicMvLyricView evQ = evQ();
            p.g(str, "name");
            String str3 = axy.lDR;
            p.h(str, "songName");
            if (str3 != null) {
                str = str + (char) 183 + str3;
            }
            evQ.Ayf.setText(str);
            evQ.Ayf.setTextBold(true);
        }
        Iterator<T> it = this.AtL.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.mv.ui.adapter.a aVar = (com.tencent.mm.plugin.mv.ui.adapter.a) it.next().getAdapter();
            if (aVar != null) {
                aVar.hw(this.AtM);
            }
        }
        AppMethodBeat.o(257143);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(257144);
        MusicMvLyricView evQ = evQ();
        if (evQ == null || evQ.getVisibility() != 0) {
            boolean onBackPressed = super.onBackPressed();
            AppMethodBeat.o(257144);
            return onBackPressed;
        }
        evR();
        AppMethodBeat.o(257144);
        return true;
    }

    private final void evR() {
        long j2;
        AppMethodBeat.i(257145);
        RecyclerView recyclerView = this.AtK;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        this.Atl.restore();
        MusicMvLyricView evQ = evQ();
        if (evQ != null) {
            evQ.setVisibility(8);
        }
        RecyclerView recyclerView2 = this.AtK;
        if (recyclerView2 != null) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.currentIndex, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView2.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvLyricUIC", "hideFullLyric", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMainUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvMainUIC::class.java)");
        MusicMvMainUIC musicMvMainUIC = (MusicMvMainUIC) viewModel;
        EffectManager evU = musicMvMainUIC.evU();
        if (evU != null) {
            com.tencent.mm.xeffect.effect.b bVar = this.AtN;
            if (bVar != null) {
                j2 = bVar.id;
            } else {
                j2 = -1;
            }
            evU.Ot(j2);
            this.AtN = null;
        }
        musicMvMainUIC.hWG();
        this.AtO = false;
        WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> adapter = musicMvMainUIC.getAdapter();
        int i2 = musicMvMainUIC.AtW.hbQ;
        MusicMvMainUIC.a aVar2 = MusicMvMainUIC.Aul;
        adapter.e(i2, 1, MusicMvMainUIC.evV());
        AppMethodBeat.o(257145);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvLyricView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MusicMvLyricView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMvLyricView invoke() {
            AppMethodBeat.i(257135);
            MusicMvLyricView musicMvLyricView = (MusicMvLyricView) this.uQi.findViewById(R.id.dbr);
            AppMethodBeat.o(257135);
            return musicMvLyricView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(257140);
            RecyclerView recyclerView = (RecyclerView) this.uQi.findViewById(R.id.gy2);
            AppMethodBeat.o(257140);
            return recyclerView;
        }
    }
}
