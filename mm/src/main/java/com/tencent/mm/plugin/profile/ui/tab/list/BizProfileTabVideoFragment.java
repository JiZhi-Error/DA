package com.tencent.mm.plugin.profile.ui.tab.list;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.ph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "mMsgList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "mVideoAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "mVideoRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabVideoFragment extends BaseBizProfileFragment {
    private RecyclerView BnD;
    private e BnE;
    private List<ou> pRP = new ArrayList();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
    public static final class b<T> implements Observer<ph> {
        final /* synthetic */ BizProfileTabVideoFragment BnF;

        b(BizProfileTabVideoFragment bizProfileTabVideoFragment) {
            this.BnF = bizProfileTabVideoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
        @Override // android.arch.lifecycle.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(com.tencent.mm.protocal.protobuf.ph r7) {
            /*
            // Method dump skipped, instructions count: 172
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.list.BizProfileTabVideoFragment.b.onChanged(java.lang.Object):void");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
    public static final class c<T> implements Observer<ph> {
        final /* synthetic */ BizProfileTabVideoFragment BnF;

        c(BizProfileTabVideoFragment bizProfileTabVideoFragment) {
            this.BnF = bizProfileTabVideoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ph phVar) {
            pf pfVar;
            boolean z;
            boolean z2;
            AppMethodBeat.i(230846);
            ph phVar2 = phVar;
            if (phVar2 == null) {
                AppMethodBeat.o(230846);
                return;
            }
            if (this.BnF.eFK().KWi == null) {
                phVar2.KWi = phVar2.KWi;
            } else {
                ov ovVar = phVar2.KWi;
                if (!(ovVar == null || (pfVar = ovVar.KVx) == null)) {
                    this.BnF.eFK().KWi.KVx = pfVar;
                }
            }
            ov ovVar2 = phVar2.KWi;
            if (ovVar2 != null) {
                LinkedList<ou> linkedList = ovVar2.KVw;
                if (linkedList != null) {
                    if (!linkedList.isEmpty()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        int size = this.BnF.pRP.size();
                        this.BnF.pRP.addAll(linkedList);
                        BizProfileTabVideoFragment.b(this.BnF).as(size, linkedList.size());
                    }
                }
                e b2 = BizProfileTabVideoFragment.b(this.BnF);
                pf pfVar2 = ovVar2.KVx;
                if (pfVar2 == null || pfVar2.KWa != 0) {
                    z = false;
                } else {
                    z = true;
                }
                b2.sP(z);
                AppMethodBeat.o(230846);
                return;
            }
            AppMethodBeat.o(230846);
        }
    }

    public BizProfileTabVideoFragment() {
        AppMethodBeat.i(230852);
        AppMethodBeat.o(230852);
    }

    public static final /* synthetic */ e b(BizProfileTabVideoFragment bizProfileTabVideoFragment) {
        AppMethodBeat.i(230853);
        e eVar = bizProfileTabVideoFragment.BnE;
        if (eVar == null) {
            p.btv("mVideoAdapter");
        }
        AppMethodBeat.o(230853);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void f(ph phVar) {
        AppMethodBeat.i(230847);
        p.h(phVar, "bizProfileResp");
        e(new ph());
        eFK().KWi = phVar.KWi;
        AppMethodBeat.o(230847);
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void e(BizProfileDataFetcher bizProfileDataFetcher) {
        AppMethodBeat.i(230848);
        p.h(bizProfileDataFetcher, "dataFetcher");
        d(bizProfileDataFetcher);
        eFJ().Bmz.observe(this, new b(this));
        eFJ().BmA.observe(this, new c(this));
        AppMethodBeat.o(230848);
    }

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(230849);
        p.h(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.x2, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.gy2);
        p.g(findViewById, "view.findViewById(R.id.recycler_view)");
        this.BnD = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.BnD;
        if (recyclerView == null) {
            p.btv("mVideoRecyclerView");
        }
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("contact") : null;
        if (string == null) {
            p.hyc();
        }
        Rx(string);
        this.BnE = new e(this.pRP);
        RecyclerView recyclerView2 = this.BnD;
        if (recyclerView2 == null) {
            p.btv("mVideoRecyclerView");
        }
        RecyclerView.m recycledViewPool = recyclerView2.getRecycledViewPool();
        p.g(recycledViewPool, "mVideoRecyclerView.recycledViewPool");
        recycledViewPool.aw(0, 20);
        RecyclerView recyclerView3 = this.BnD;
        if (recyclerView3 == null) {
            p.btv("mVideoRecyclerView");
        }
        recyclerView3.setRecycledViewPool(recycledViewPool);
        RecyclerView recyclerView4 = this.BnD;
        if (recyclerView4 == null) {
            p.btv("mVideoRecyclerView");
        }
        e eVar = this.BnE;
        if (eVar == null) {
            p.btv("mVideoAdapter");
        }
        recyclerView4.setAdapter(eVar);
        AppMethodBeat.o(230849);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        ov ovVar;
        LinkedList<ou> linkedList;
        AppMethodBeat.i(230850);
        p.h(view, "view");
        super.onViewCreated(view, bundle);
        if (!(!this.pRP.isEmpty() || (ovVar = eFK().KWi) == null || (linkedList = ovVar.KVw) == null)) {
            if (!linkedList.isEmpty()) {
                List<ou> list = this.pRP;
                LinkedList<ou> linkedList2 = eFK().KWi.KVw;
                p.g(linkedList2, "mBizProfileResp.VideoList.Msg");
                list.addAll(linkedList2);
                e eVar = this.BnE;
                if (eVar == null) {
                    p.btv("mVideoAdapter");
                }
                eVar.notifyDataSetChanged();
            }
        }
        e eVar2 = this.BnE;
        if (eVar2 == null) {
            p.btv("mVideoAdapter");
        }
        eVar2.BmU = new a(this);
        AppMethodBeat.o(230850);
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void eFM() {
        AppMethodBeat.i(230851);
        RecyclerView recyclerView = this.BnD;
        if (recyclerView == null) {
            p.btv("mVideoRecyclerView");
        }
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoFragment", "onAppBarLayoutExpand", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(230851);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ BizProfileTabVideoFragment BnF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BizProfileTabVideoFragment bizProfileTabVideoFragment) {
            super(0);
            this.BnF = bizProfileTabVideoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            pf pfVar;
            com.tencent.mm.bw.b bVar;
            pf pfVar2;
            AppMethodBeat.i(230844);
            ov ovVar = this.BnF.eFK().KWi;
            if (!(ovVar == null || (pfVar = ovVar.KVx) == null || pfVar.KWa != 0)) {
                BizProfileDataFetcher eFJ = this.BnF.eFJ();
                ov ovVar2 = this.BnF.eFK().KWi;
                if (ovVar2 == null || (pfVar2 = ovVar2.KVx) == null) {
                    bVar = null;
                } else {
                    bVar = pfVar2.KVZ;
                }
                if (!eFJ.BmC) {
                    eFJ.BmC = true;
                    aa.a(BizProfileDataFetcher.a(eFJ, 2, bVar), new BizProfileDataFetcher.d(eFJ), false, eFJ.gte);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230844);
            return xVar;
        }
    }
}
