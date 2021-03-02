package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J$\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0016H\u0014J$\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J*\u0010\u001f\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", SearchIntents.EXTRA_QUERY, "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"})
public final class f extends d implements e.b {
    private final String TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    private final int mve = 5;
    private e xaU;
    private final MMHandler xad;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(e eVar) {
        super(eVar);
        p.h(eVar, "ftsBaseUIComponent");
        AppMethodBeat.i(235424);
        e createFTSUIUnit = ((n) g.ah(n.class)).createFTSUIUnit(4208, getContext(), this, this.mve);
        p.g(createFTSUIUnit, "MMKernel.plugin(IPluginF…ntext, this, searchScene)");
        this.xaU = createFTSUIUnit;
        this.xad = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(235424);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final a No(int i2) {
        AppMethodBeat.i(235419);
        a No = this.xaU.No(i2);
        p.g(No, "bizUIUnit.createDataItem(position)");
        AppMethodBeat.o(235419);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(235420);
        this.xaU.a(getQuery(), this.xad, new HashSet<>(), 0);
        AppMethodBeat.o(235420);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, a aVar, boolean z) {
        AppMethodBeat.i(235421);
        boolean a2 = this.xaU.a(view, aVar, z);
        AppMethodBeat.o(235421);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(235422);
        setCount(this.xaU.Nn(0));
        notifyDataSetChanged();
        ax(getCount(), true);
        AppMethodBeat.o(235422);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(235423);
        super.onScroll(absListView, i2, i3, i4);
        if (dPg() instanceof FTSBizDetailUI) {
            e dPg = dPg();
            if (dPg == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
                AppMethodBeat.o(235423);
                throw tVar;
            }
            FTSBizDetailUI fTSBizDetailUI = (FTSBizDetailUI) dPg;
            if (absListView == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.ListView");
                AppMethodBeat.o(235423);
                throw tVar2;
            }
            int headerViewsCount = ((ListView) absListView).getHeaderViewsCount();
            f fVar = fTSBizDetailUI.xaV;
            czf czf = fTSBizDetailUI.xbd;
            if (!(fVar == null || czf == null)) {
                View view = fTSBizDetailUI.xaY;
                if (view != null && absListView.getLastVisiblePosition() >= fVar.getCount() + headerViewsCount && view.getVisibility() == 0 && fTSBizDetailUI.xat == 1) {
                    int jo = com.tencent.mm.cb.a.jo(fTSBizDetailUI);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    if (view.getMeasuredHeight() + iArr[1] <= jo) {
                        fTSBizDetailUI.xat = 2;
                        fTSBizDetailUI.a(czf, 2);
                    }
                }
                LinearLayout linearLayout = fTSBizDetailUI.xba;
                if (linearLayout != null) {
                    if (absListView.getLastVisiblePosition() >= headerViewsCount + fVar.getCount() && linearLayout.getVisibility() == 0) {
                        int jo2 = com.tencent.mm.cb.a.jo(fTSBizDetailUI);
                        int childCount = linearLayout.getChildCount();
                        for (int i5 = 0; i5 < childCount; i5++) {
                            View childAt = linearLayout.getChildAt(i5);
                            int[] iArr2 = new int[2];
                            childAt.getLocationOnScreen(iArr2);
                            p.g(childAt, "childView");
                            int measuredHeight = iArr2[1] + childAt.getMeasuredHeight();
                            Object tag = childAt.getTag();
                            if (tag == null) {
                                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FTSRelatedSugItem");
                                AppMethodBeat.o(235423);
                                throw tVar3;
                            }
                            alv alv = (alv) tag;
                            if (measuredHeight <= jo2 && fTSBizDetailUI.xbg.add(alv.Lux.MEq)) {
                                fTSBizDetailUI.a(alv, czf, 2);
                            }
                        }
                    }
                    AppMethodBeat.o(235423);
                    return;
                }
            }
        }
        AppMethodBeat.o(235423);
    }
}
