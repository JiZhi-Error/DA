package com.tencent.mm.plugin.textstatus.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/FestivalSpecialViewSingleton;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "()V", "list", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "genIconView", "getView", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public final class e implements b {
    private ArrayList<View> dtS = new ArrayList<>();

    public e() {
        AppMethodBeat.i(258438);
        AppMethodBeat.o(258438);
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar) {
        AppMethodBeat.i(258434);
        p.h(rVar, "jumpInfo");
        if (!p.j(rVar.GaO, "4") || !((a) g.af(a.class)).dml()) {
            AppMethodBeat.o(258434);
            return null;
        }
        View hXt = hXt();
        AppMethodBeat.o(258434);
        return hXt;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(258435);
        p.h(rVar, "jumpInfo");
        p.h(aVar, "refreshCallback");
        if (!p.j(rVar.GaO, "4") || !((a) g.af(a.class)).dml()) {
            AppMethodBeat.o(258435);
            return null;
        }
        View hXt = hXt();
        this.dtS.add(hXt);
        AppMethodBeat.o(258435);
        return hXt;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final void b(r rVar) {
        AppMethodBeat.i(258436);
        p.h(rVar, "jumpInfo");
        this.dtS.clear();
        AppMethodBeat.o(258436);
    }

    private static View hXt() {
        AppMethodBeat.i(258437);
        ImageView imageView = new ImageView(MMApplicationContext.getContext());
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        imageView.setImageDrawable(context.getResources().getDrawable(R.raw.finder_live_icon));
        ImageView imageView2 = imageView;
        AppMethodBeat.o(258437);
        return imageView2;
    }
}
