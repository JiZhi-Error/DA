package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
public final class FinderLiveWeCoinHotConstract$Presenter$onAttach$3 extends q implements b<IResponse<bo>, x> {
    final /* synthetic */ FinderLiveWeCoinHotConstract.Presenter uXP;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveWeCoinHotConstract$Presenter$onAttach$3(FinderLiveWeCoinHotConstract.Presenter presenter) {
        super(1);
        this.uXP = presenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
        AppMethodBeat.i(249835);
        IResponse<bo> iResponse2 = iResponse;
        p.h(iResponse2, LocaleUtil.ITALIAN);
        if (iResponse2 instanceof FinderLiveWecoinHotLoader.c) {
            Log.i("FinderLiveWeCoinHotConstract.Presenter", "wecoinHotList.size:" + ((FinderLiveWecoinHotLoader.c) iResponse2).tWv.size() + ", totalWecoinHot:" + ((FinderLiveWecoinHotLoader.c) iResponse2).tWw);
            LinkedList<axa> linkedList = ((FinderLiveWecoinHotLoader.c) iResponse2).tWv;
            if (linkedList == null || linkedList.isEmpty()) {
                FinderLiveWeCoinHotConstract.ViewCallback viewCallback = this.uXP.uXM;
                if (viewCallback != null) {
                    FinderLiveWecoinHotLoader.c cVar = (FinderLiveWecoinHotLoader.c) iResponse2;
                    p.h(cVar, "wecoinHotResp");
                    c cVar2 = c.vCb;
                    if (c.hVh().value().intValue() == 1) {
                        TextView textView = viewCallback.uXW;
                        if (textView == null) {
                            p.btv("titleAmountTv");
                        }
                        textView.setText(String.valueOf(cVar.tWw));
                        RelativeLayout relativeLayout = viewCallback.uXV;
                        if (relativeLayout == null) {
                            p.btv("titleGroup");
                        }
                        relativeLayout.setVisibility(0);
                        TextView textView2 = viewCallback.qqJ;
                        if (textView2 == null) {
                            p.btv("emptyTv");
                        }
                        textView2.setVisibility(8);
                    } else {
                        RelativeLayout relativeLayout2 = viewCallback.uXV;
                        if (relativeLayout2 == null) {
                            p.btv("titleGroup");
                        }
                        relativeLayout2.setVisibility(8);
                        TextView textView3 = viewCallback.qqJ;
                        if (textView3 == null) {
                            p.btv("emptyTv");
                        }
                        textView3.setVisibility(0);
                    }
                    RecyclerView recyclerView = viewCallback.uXQ;
                    if (recyclerView == null) {
                        p.btv("wecoinRecyclerView");
                    }
                    recyclerView.setVisibility(8);
                    View view = viewCallback.hSw;
                    if (view == null) {
                        p.btv("loadingView");
                    }
                    view.setVisibility(8);
                }
            } else {
                FinderLiveWeCoinHotConstract.ViewCallback viewCallback2 = this.uXP.uXM;
                if (viewCallback2 != null) {
                    FinderLiveWecoinHotLoader.c cVar3 = (FinderLiveWecoinHotLoader.c) iResponse2;
                    p.h(cVar3, "wecoinHotResp");
                    TextView textView4 = viewCallback2.uXW;
                    if (textView4 == null) {
                        p.btv("titleAmountTv");
                    }
                    textView4.setText(String.valueOf(cVar3.tWw));
                    RelativeLayout relativeLayout3 = viewCallback2.uXV;
                    if (relativeLayout3 == null) {
                        p.btv("titleGroup");
                    }
                    relativeLayout3.setVisibility(0);
                    TextView textView5 = viewCallback2.qqJ;
                    if (textView5 == null) {
                        p.btv("emptyTv");
                    }
                    textView5.setVisibility(8);
                    RecyclerView recyclerView2 = viewCallback2.uXQ;
                    if (recyclerView2 == null) {
                        p.btv("wecoinRecyclerView");
                    }
                    recyclerView2.setVisibility(0);
                    View view2 = viewCallback2.hSw;
                    if (view2 == null) {
                        p.btv("loadingView");
                    }
                    view2.setVisibility(8);
                }
                this.uXP.getAdapter().notifyDataSetChanged();
            }
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249835);
        return xVar;
    }
}
