package com.tencent.mm.live.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0014J,\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIC;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "getLayoutId", "", "initActionBar", "", "initViews", "loadMembers", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "plugin-logic_release"})
public final class LiveUIC extends MMActivity implements i {
    private TextView hRL;
    private ViewGroup hTY;
    private ViewGroup hTZ;
    private TextView hUa;
    private TextView hUb;
    private TextView hUc;
    private final b hUd = new b();
    private RecyclerView hak;
    private ProgressBar hbv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LiveUIC() {
        AppMethodBeat.i(208388);
        AppMethodBeat.o(208388);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ LiveUIC hUe;

        a(LiveUIC liveUIC) {
            this.hUe = liveUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(208384);
            this.hUe.finish();
            AppMethodBeat.o(208384);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b00;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(208385);
        super.onCreate(bundle);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3700, this);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
        x xVar = x.hJf;
        as Kn = aSN.Kn(x.aGm());
        p.g(Kn, "contact");
        setMMTitle(Kn.arJ());
        setBackBtn(new a(this));
        this.hTY = (ViewGroup) findViewById(R.id.edm);
        this.hTZ = (ViewGroup) findViewById(R.id.eds);
        this.hak = (RecyclerView) findViewById(R.id.edk);
        this.hUa = (TextView) findViewById(R.id.edq);
        this.hUb = (TextView) findViewById(R.id.edo);
        this.hUc = (TextView) findViewById(R.id.edu);
        this.hbv = (ProgressBar) findViewById(R.id.edl);
        this.hRL = (TextView) findViewById(R.id.edp);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.hUd);
        }
        x xVar2 = x.hJf;
        int Ie = v.Ie(x.aGm());
        TextView textView = this.hUb;
        if (textView != null) {
            x xVar3 = x.hJf;
            textView.setText(String.valueOf(x.aGr().LIa));
        }
        TextView textView2 = this.hUc;
        if (textView2 != null) {
            textView2.setText(String.valueOf(Ie));
        }
        ProgressBar progressBar = this.hbv;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        TextView textView3 = this.hRL;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(8);
        }
        r rVar = r.hIg;
        x xVar4 = x.hJf;
        r.GN(x.aGm());
        AppMethodBeat.o(208385);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(208386);
        super.onDestroy();
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3700, this);
        AppMethodBeat.o(208386);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        A<String> a2;
        AppMethodBeat.i(208387);
        if (qVar instanceof d) {
            if (i2 == 0 && i3 == 0) {
                TextView textView = this.hUb;
                if (textView != null) {
                    x xVar = x.hJf;
                    textView.setText(String.valueOf(x.aGr().LIa));
                }
                ProgressBar progressBar = this.hbv;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                TextView textView2 = this.hRL;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                RecyclerView recyclerView = this.hak;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                x xVar2 = x.hJf;
                HashMap<String, o<ArrayList<String>, Integer>> aGo = x.aGo();
                x xVar3 = x.hJf;
                o<ArrayList<String>, Integer> oVar = aGo.get(x.aGm());
                if (oVar != null) {
                    a2 = oVar.first;
                } else {
                    a2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (a2 != null) {
                    for (String str2 : a2) {
                        arrayList.add(new com.tencent.mm.live.view.a.g(str2));
                    }
                }
                this.hUd.ai(arrayList);
                this.hUd.notifyDataSetChanged();
                AppMethodBeat.o(208387);
                return;
            }
            ProgressBar progressBar2 = this.hbv;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            TextView textView3 = this.hRL;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
                AppMethodBeat.o(208387);
                return;
            }
        }
        AppMethodBeat.o(208387);
    }
}
