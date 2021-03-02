package com.tencent.mm.live.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.a.d;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.view.a.b;
import com.tencent.mm.live.view.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u001eJ,\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0006\u0010.\u001a\u00020\u001eR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/live/view/LiveAfterStateView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "backBtn", "Landroid/widget/ImageView;", "loadingView", "Landroid/widget/ProgressBar;", "onlineCountGroup", "Landroid/view/ViewGroup;", "onlineCountTv", "Landroid/widget/TextView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "retryTip", "roomCountGroup", "roomCountTv", "subTitleTv", "titleTv", "finish", "", "getLayoutId", "initViews", "loadMembers", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showDataView", "showLoadingView", "showRetryView", "start", "plugin-logic_release"})
public final class LiveAfterStateView extends RelativeLayout implements i {
    private TextView hRL;
    private ViewGroup hTY;
    private ViewGroup hTZ;
    private TextView hUa;
    private TextView hUb;
    private TextView hUc;
    private final b hUd;
    private RecyclerView hak;
    private ProgressBar hbv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveAfterStateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208490);
        this.hUd = new b();
        View.inflate(context, getLayoutId(), this);
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
            AppMethodBeat.o(208490);
            return;
        }
        AppMethodBeat.o(208490);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LiveAfterStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(208491);
        AppMethodBeat.o(208491);
    }

    public final int getLayoutId() {
        return R.layout.b00;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        A<String> a2;
        AppMethodBeat.i(208489);
        if (qVar instanceof d) {
            if (i2 == 0 && i3 == 0) {
                ProgressBar progressBar = this.hbv;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                TextView textView = this.hRL;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                RecyclerView recyclerView = this.hak;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                x xVar = x.hJf;
                HashMap<String, o<ArrayList<String>, Integer>> aGo = x.aGo();
                x xVar2 = x.hJf;
                o<ArrayList<String>, Integer> oVar = aGo.get(x.aGm());
                if (oVar != null) {
                    a2 = oVar.first;
                } else {
                    a2 = null;
                }
                ArrayList arrayList = new ArrayList();
                if (a2 != null) {
                    for (String str2 : a2) {
                        arrayList.add(new g(str2));
                    }
                }
                this.hUd.ai(arrayList);
                this.hUd.notifyDataSetChanged();
                AppMethodBeat.o(208489);
                return;
            }
            ProgressBar progressBar2 = this.hbv;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            TextView textView2 = this.hRL;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
                AppMethodBeat.o(208489);
                return;
            }
        }
        AppMethodBeat.o(208489);
    }
}
