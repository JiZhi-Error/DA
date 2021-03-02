package com.tencent.mm.live.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.bm;
import com.tencent.mm.live.view.a.f;
import com.tencent.mm.live.view.a.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0016\u0010 \u001a\u00020\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0006\u0010%\u001a\u00020\u0018J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveShareRoomsPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "blankArea", "Landroid/view/View;", "closeBtn", "contentGroup", "emptyView", "Landroid/widget/TextView;", "loader", "Lcom/tencent/mm/live/plugin/ShareRoomsLoader;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "sendBtn", "Landroid/widget/Button;", "hideMembersList", "", "name", "", "onBackPress", "", "onClick", "view", "onNoRooms", "onUpdateRooms", "datas", "", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "reset", "showShareRoomsList", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class au extends a implements View.OnClickListener {
    private final b hOp;
    private final View hRx;
    private final f hSA = new f();
    private final bm hSB = new bm();
    private final View hSw;
    private final TextView hSx;
    private final ViewGroup hSy;
    private final ViewGroup hSz;
    private final RecyclerView hak;
    private final Button han;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<List<? extends h>, x> {
        final /* synthetic */ au hSC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(au auVar) {
            super(1);
            this.hSC = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends h> list) {
            AppMethodBeat.i(208160);
            List<? extends h> list2 = list;
            p.h(list2, LocaleUtil.ITALIAN);
            if (list2.isEmpty()) {
                au.c(this.hSC);
            } else {
                au.a(this.hSC, list2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208160);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public au(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208166);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.elx);
        p.g(findViewById, "root.findViewById(R.id.live_share_rooms_loading)");
        this.hSw = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.elq);
        p.g(findViewById2, "root.findViewById(R.id.live_share_rooms_empty_tip)");
        this.hSx = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.elo);
        p.g(findViewById3, "root.findViewById(R.id.live_share_rooms_close_btn)");
        this.hSy = (ViewGroup) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.elr);
        p.g(findViewById4, "root.findViewById(R.id.l…e_share_rooms_finish_btn)");
        this.han = (Button) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.elw);
        p.g(findViewById5, "root.findViewById(R.id.live_share_rooms_list_view)");
        this.hak = (RecyclerView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.elp);
        p.g(findViewById6, "root.findViewById(R.id.l…share_rooms_content_area)");
        this.hSz = (ViewGroup) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.eln);
        p.g(findViewById7, "root.findViewById(R.id.l…e_share_rooms_blank_area)");
        this.hRx = findViewById7;
        this.hSA.hXJ = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.live.c.au.AnonymousClass1 */
            final /* synthetic */ au hSC;

            {
                this.hSC = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                AppMethodBeat.i(208156);
                Button button = this.hSC.han;
                if (!this.hSC.hSA.hXI.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                button.setEnabled(z);
                x xVar = x.SXb;
                AppMethodBeat.o(208156);
                return xVar;
            }
        };
        this.hak.setAdapter(this.hSA);
        RecyclerView recyclerView = this.hak;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.hSz.setTranslationY((float) com.tencent.mm.ui.au.az(viewGroup.getContext()).y);
        this.hSw.setVisibility(0);
        this.hSx.setVisibility(8);
        this.hak.setVisibility(8);
        this.hSy.setOnClickListener(this);
        this.han.setOnClickListener(this);
        this.hRx.setOnClickListener(this);
        AppMethodBeat.o(208166);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/plugin/LiveShareRoomsPlugin$hideMembersList$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ au hSC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(au auVar) {
            this.hSC = auVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208158);
            b.C0376b.a(this.hSC.hOp, b.c.hLZ);
            AppMethodBeat.o(208158);
        }
    }

    private final void aHI() {
        AppMethodBeat.i(208161);
        ViewPropertyAnimator translationY = this.hSz.animate().translationY((float) com.tencent.mm.ui.au.az(this.hwr.getContext()).y);
        translationY.setListener(new a(this));
        translationY.start();
        AppMethodBeat.o(208161);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ au hSC;

        b(au auVar) {
            this.hSC = auVar;
        }

        public final void run() {
            AppMethodBeat.i(208159);
            ViewPropertyAnimator translationY = this.hSC.hSz.animate().translationY(0.0f);
            translationY.setListener(null);
            translationY.start();
            AppMethodBeat.o(208159);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(208162);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveShareRoomsPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.elo) || (valueOf != null && valueOf.intValue() == R.id.eln)) {
            aHI();
        } else if (valueOf != null && valueOf.intValue() == R.id.elr) {
            Iterator<T> it = this.hSA.hXI.iterator();
            while (it.hasNext()) {
                r rVar = r.hIg;
                r.GO(it.next());
            }
            b.C0376b.a(this.hOp, b.c.hLZ);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveShareRoomsPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208162);
    }

    @Override // com.tencent.mm.live.view.a, com.tencent.mm.live.c.a
    public final String name() {
        AppMethodBeat.i(208164);
        String simpleName = au.class.getSimpleName();
        p.g(simpleName, "LiveShareRoomsPlugin::class.java.simpleName");
        AppMethodBeat.o(208164);
        return simpleName;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208165);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (av.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                this.han.setEnabled(false);
                this.hSA.hXI.clear();
                this.hSz.post(new b(this));
                c cVar2 = new c(this);
                p.h(cVar2, "UIcallback");
                com.tencent.f.h.RTc.aX(new bm.a(cVar2));
                AppMethodBeat.o(208165);
                return;
            case 2:
                rg(8);
                break;
        }
        AppMethodBeat.o(208165);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208163);
        if (this.hwr.getVisibility() == 0) {
            aHI();
            AppMethodBeat.o(208163);
            return true;
        }
        AppMethodBeat.o(208163);
        return false;
    }

    public static final /* synthetic */ void c(au auVar) {
        AppMethodBeat.i(208167);
        auVar.hSw.setVisibility(8);
        auVar.hSx.setVisibility(0);
        auVar.hak.setVisibility(8);
        AppMethodBeat.o(208167);
    }

    public static final /* synthetic */ void a(au auVar, List list) {
        AppMethodBeat.i(208168);
        auVar.hSw.setVisibility(8);
        auVar.hSx.setVisibility(8);
        auVar.hak.setVisibility(0);
        f fVar = auVar.hSA;
        p.h(list, "rooms");
        fVar.hXG.clear();
        fVar.hXG.addAll(list);
        auVar.hSA.notifyDataSetChanged();
        AppMethodBeat.o(208168);
    }
}
