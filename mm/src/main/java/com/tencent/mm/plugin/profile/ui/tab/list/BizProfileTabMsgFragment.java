package com.tencent.mm.plugin.profile.ui.tab.list;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.profile.ui.tab.data.BizProfileDataFetcher;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108TX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgFragment;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "()V", "enterTime", "", "getEnterTime", "()J", "setEnterTime", "(J)V", "listView", "Landroid/widget/ListView;", "mAdapter", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "mBizMessageList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "msgType", "", "getMsgType", "()I", "onAppBarLayoutExpand", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setBizProfileResp", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "setDataFetcher", "dataFetcher", "Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileDataFetcher;", "app_release"})
public final class BizProfileTabMsgFragment extends BaseBizProfileFragment {
    private a Bnl;
    private final ov Bnm;
    public long enterTime;
    private ListView krb;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
    public static final class b<T> implements Observer<ph> {
        final /* synthetic */ BizProfileTabMsgFragment Bnn;

        b(BizProfileTabMsgFragment bizProfileTabMsgFragment) {
            this.Bnn = bizProfileTabMsgFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ph phVar) {
            LinkedList<ou> linkedList;
            AppMethodBeat.i(230814);
            ph phVar2 = phVar;
            if (phVar2 == null) {
                AppMethodBeat.o(230814);
                return;
            }
            this.Bnn.e(new ph());
            this.Bnn.eFK().KWg = phVar2.KWg;
            LinkedList<ou> linkedList2 = this.Bnn.Bnm.KVw;
            if (linkedList2 != null) {
                linkedList2.clear();
            }
            ov ovVar = this.Bnn.Bnm;
            ov ovVar2 = phVar2.KWg;
            ovVar.KVx = ovVar2 != null ? ovVar2.KVx : null;
            ov ovVar3 = phVar2.KWg;
            if (!(ovVar3 == null || (linkedList = ovVar3.KVw) == null)) {
                LinkedList<ou> linkedList3 = this.Bnn.Bnm.KVw;
                if (linkedList3 != null) {
                    linkedList3.addAll(linkedList);
                }
                BizProfileTabMsgFragment.b(this.Bnn).d(this.Bnn.Bnm);
            }
            String a2 = com.tencent.mm.plugin.profile.ui.tab.a.a(8, phVar2);
            if (a2 != null) {
                if (a2.length() > 0) {
                    this.Bnn.eFL().setText(a2);
                    BizProfileTabMsgFragment.c(this.Bnn).addFooterView(this.Bnn.getFooterView());
                    AppMethodBeat.o(230814);
                    return;
                }
            }
            this.Bnn.eFL().setText(R.string.aih);
            BizProfileTabMsgFragment.c(this.Bnn).removeFooterView(this.Bnn.getFooterView());
            AppMethodBeat.o(230814);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bizProfileResp", "Lcom/tencent/mm/protocal/protobuf/BizProfileV2Resp;", "onChanged"})
    public static final class c<T> implements Observer<ph> {
        final /* synthetic */ BizProfileTabMsgFragment Bnn;

        c(BizProfileTabMsgFragment bizProfileTabMsgFragment) {
            this.Bnn = bizProfileTabMsgFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ph phVar) {
            pf pfVar;
            AppMethodBeat.i(230815);
            ph phVar2 = phVar;
            if (phVar2 == null) {
                AppMethodBeat.o(230815);
                return;
            }
            if (this.Bnn.eFK().KWg == null) {
                phVar2.KWg = phVar2.KWg;
            } else {
                ov ovVar = phVar2.KWg;
                if (!(ovVar == null || (pfVar = ovVar.KVx) == null)) {
                    this.Bnn.Bnm.KVx = pfVar;
                    this.Bnn.eFK().KWg.KVx = pfVar;
                }
            }
            ov ovVar2 = phVar2.KWg;
            if (ovVar2 != null) {
                LinkedList<ou> linkedList = ovVar2.KVw;
                if (linkedList != null) {
                    this.Bnn.Bnm.KVw.addAll(linkedList);
                    BizProfileTabMsgFragment.b(this.Bnn).d(this.Bnn.Bnm);
                }
                pf pfVar2 = ovVar2.KVx;
                if (pfVar2 == null || pfVar2.KWa != 0) {
                    BizProfileTabMsgFragment.c(this.Bnn).addFooterView(this.Bnn.getFooterView());
                }
                AppMethodBeat.o(230815);
                return;
            }
            AppMethodBeat.o(230815);
        }
    }

    public BizProfileTabMsgFragment() {
        AppMethodBeat.i(230820);
        ov ovVar = new ov();
        ovVar.KVw = new LinkedList<>();
        ovVar.KVx = new pf();
        this.Bnm = ovVar;
        AppMethodBeat.o(230820);
    }

    public static final /* synthetic */ a b(BizProfileTabMsgFragment bizProfileTabMsgFragment) {
        AppMethodBeat.i(230821);
        a aVar = bizProfileTabMsgFragment.Bnl;
        if (aVar == null) {
            p.btv("mAdapter");
        }
        AppMethodBeat.o(230821);
        return aVar;
    }

    public static final /* synthetic */ ListView c(BizProfileTabMsgFragment bizProfileTabMsgFragment) {
        AppMethodBeat.i(230822);
        ListView listView = bizProfileTabMsgFragment.krb;
        if (listView == null) {
            p.btv("listView");
        }
        AppMethodBeat.o(230822);
        return listView;
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void f(ph phVar) {
        AppMethodBeat.i(230816);
        p.h(phVar, "bizProfileResp");
        ph phVar2 = new ph();
        phVar2.KWg = phVar.KWg;
        e(phVar2);
        ov ovVar = this.Bnm;
        ov ovVar2 = phVar.KWg;
        ovVar.KVx = ovVar2 != null ? ovVar2.KVx : null;
        AppMethodBeat.o(230816);
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void e(BizProfileDataFetcher bizProfileDataFetcher) {
        AppMethodBeat.i(230817);
        p.h(bizProfileDataFetcher, "dataFetcher");
        d(bizProfileDataFetcher);
        eFJ().Bmz.observe(this, new b(this));
        eFJ().BmB.observe(this, new c(this));
        AppMethodBeat.o(230817);
    }

    @Override // com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment
    public final void eFM() {
        AppMethodBeat.i(230818);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setItemChecked(0, true);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        listView2.setSelection(0);
        AppMethodBeat.o(230818);
    }

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(230819);
        p.h(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.x1, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.gy2);
        p.g(findViewById, "view.findViewById(R.id.recycler_view)");
        this.krb = (ListView) findViewById;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("contact") : null;
        p.g(bg.aVF(), "MMCore.getAccStg()");
        bv aSN = com.tencent.mm.model.c.aSN();
        if (string == null) {
            p.hyc();
        }
        as Kn = aSN.Kn(string);
        Context context = getContext();
        if (context == null) {
            p.hyc();
        }
        p.g(context, "context!!");
        p.g(Kn, "contact");
        this.Bnl = new a(context, Kn, this.enterTime);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        a aVar = this.Bnl;
        if (aVar == null) {
            p.btv("mAdapter");
        }
        listView.setAdapter((ListAdapter) aVar);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        u.av(listView2);
        if (eFK().KWg != null) {
            a aVar2 = this.Bnl;
            if (aVar2 == null) {
                p.btv("mAdapter");
            }
            ov ovVar = eFK().KWg;
            p.g(ovVar, "mBizProfileResp.MsgList");
            aVar2.d(ovVar);
        }
        a aVar3 = this.Bnl;
        if (aVar3 == null) {
            p.btv("mAdapter");
        }
        aVar3.BmU = new a(this);
        AppMethodBeat.o(230819);
        return inflate;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ BizProfileTabMsgFragment Bnn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BizProfileTabMsgFragment bizProfileTabMsgFragment) {
            super(0);
            this.Bnn = bizProfileTabMsgFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            pf pfVar;
            com.tencent.mm.bw.b bVar;
            pf pfVar2;
            AppMethodBeat.i(230813);
            ov ovVar = this.Bnn.eFK().KWg;
            if (!(ovVar == null || (pfVar = ovVar.KVx) == null || pfVar.KWa != 0)) {
                BizProfileDataFetcher eFJ = this.Bnn.eFJ();
                ov ovVar2 = this.Bnn.eFK().KWg;
                if (ovVar2 == null || (pfVar2 = ovVar2.KVx) == null) {
                    bVar = null;
                } else {
                    bVar = pfVar2.KVZ;
                }
                if (!eFJ.BmD) {
                    eFJ.BmD = true;
                    aa.a(BizProfileDataFetcher.a(eFJ, 1, bVar), new BizProfileDataFetcher.c(eFJ), false, eFJ.gte);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230813);
            return xVar;
        }
    }
}
