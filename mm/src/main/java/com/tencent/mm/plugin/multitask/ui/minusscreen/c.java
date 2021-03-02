package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.g;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020(H\u0016J\u0016\u0010)\u001a\u00020*2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "multiTaskInfo", "", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "gridSpanCount", "", "(Ljava/util/List;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getGridSpanCount", "()I", "getMultiTaskInfo", "()Ljava/util/List;", "viewListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ui-multitask_release"})
public final class c implements a {
    private com.tencent.mm.plugin.multitask.ui.minusscreen.d.a AdJ;
    private final List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> AdK;
    private final String TAG;
    private WxRecyclerAdapter<?> tFp;
    private final int vEY;

    private c(List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> list) {
        p.h(list, "multiTaskInfo");
        AppMethodBeat.i(236440);
        this.AdK = list;
        this.vEY = 2;
        this.TAG = "MicroMsg.MultiTask.MinusScreenGridLayoutConfig";
        AppMethodBeat.o(236440);
    }

    public /* synthetic */ c(List list, byte b2) {
        this(list);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.a
    public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a aVar) {
        this.AdJ = aVar;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.a
    public final void setAdapter(WxRecyclerAdapter<?> wxRecyclerAdapter) {
        this.tFp = wxRecyclerAdapter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "ui-multitask_release"})
    public static final class b extends GridLayoutManager.b {
        b() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            if (i2 == 0) {
                return 2;
            }
            return 1;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.a
    public final RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(236437);
        p.h(context, "context");
        MinusScreenGridLayoutManager minusScreenGridLayoutManager = new MinusScreenGridLayoutManager(context, this.vEY);
        minusScreenGridLayoutManager.a(new b());
        minusScreenGridLayoutManager.setItemPrefetchEnabled(true);
        MinusScreenGridLayoutManager minusScreenGridLayoutManager2 = minusScreenGridLayoutManager;
        AppMethodBeat.o(236437);
        return minusScreenGridLayoutManager2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-multitask_release"})
    public static final class a implements f {
        final /* synthetic */ c AdL;
        final /* synthetic */ kotlin.g.a.b uTz = null;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/g/a/b;)V */
        a(c cVar) {
            this.AdL = cVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            e<?> eVar;
            AppMethodBeat.i(236436);
            switch (i2) {
                case 1:
                    com.tencent.mm.plugin.multitask.ui.minusscreen.view.a aVar = new com.tencent.mm.plugin.multitask.ui.minusscreen.view.a(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return aVar;
                case 2:
                    h hVar = new h(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return hVar;
                case 3:
                    com.tencent.mm.plugin.multitask.ui.minusscreen.view.e eVar2 = new com.tencent.mm.plugin.multitask.ui.minusscreen.view.e(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return eVar2;
                case 4:
                    com.tencent.mm.plugin.multitask.ui.minusscreen.view.b bVar = new com.tencent.mm.plugin.multitask.ui.minusscreen.view.b(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return bVar;
                case 5:
                    com.tencent.mm.plugin.multitask.ui.minusscreen.view.c cVar = new com.tencent.mm.plugin.multitask.ui.minusscreen.view.c(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return cVar;
                case 8:
                    com.tencent.mm.plugin.multitask.ui.minusscreen.view.f fVar = new com.tencent.mm.plugin.multitask.ui.minusscreen.view.f(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return fVar;
                case 22:
                    g gVar = new g(this.AdL.AdJ);
                    AppMethodBeat.o(236436);
                    return gVar;
                default:
                    kotlin.g.a.b bVar2 = this.uTz;
                    if (bVar2 == null || (eVar = (e) bVar2.invoke(Integer.valueOf(i2))) == null) {
                        eVar = c.erC();
                    }
                    AppMethodBeat.o(236436);
                    return eVar;
            }
        }
    }

    public static e<?> erC() {
        AppMethodBeat.i(236439);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            RuntimeException runtimeException = new RuntimeException("type invalid");
            AppMethodBeat.o(236439);
            throw runtimeException;
        }
        Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
        b bVar = new b();
        AppMethodBeat.o(236439);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.minusscreen.a
    public final f dcK() {
        AppMethodBeat.i(236438);
        a aVar = new a(this);
        AppMethodBeat.o(236438);
        return aVar;
    }
}
