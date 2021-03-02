package com.tencent.mm.plugin.textstatus.b.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.f.d.a;
import com.tencent.mm.plugin.textstatus.j.f;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J@\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetHeaderSetConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetHeaderItem;", "clickListener", "Landroid/view/View$OnClickListener;", "(Landroid/view/View$OnClickListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
public final class b extends e<a> {
    private final View.OnClickListener dec;

    public b(View.OnClickListener onClickListener) {
        this.dec = onClickListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, a aVar, int i2, int i3, boolean z, List list) {
        BitmapDrawable bitmapDrawable;
        AppMethodBeat.i(216114);
        a aVar2 = aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        hVar.Mn(R.id.e_6).setOnClickListener(this.dec);
        ImageView imageView = (ImageView) hVar.Mn(R.id.j23);
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        Context context = view.getContext();
        p.g(context, "holder.itemView.context");
        p.h(context, "context");
        if (aVar2.bitmap == null) {
            f fVar = f.Ggk;
            aVar2.bitmap = f.aTs(aVar2.username);
        }
        if (aVar2.bitmap != null) {
            f fVar2 = f.Ggk;
            bitmapDrawable = new BitmapDrawable(f.a(aVar2.bitmap, context));
        } else {
            bitmapDrawable = null;
        }
        imageView.setImageDrawable(bitmapDrawable);
        AppMethodBeat.o(216114);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2q;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    @SuppressLint({"ResourceType"})
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216113);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 12.0f);
        f fVar = f.Ggk;
        f.B(hVar.aus, (float) fromDPToPix);
        Drawable drawable = recyclerView.getContext().getDrawable(R.raw.icons_outlined_add);
        Context context = recyclerView.getContext();
        p.g(context, "recyclerView.context");
        ((ImageView) hVar.Mn(R.id.dte)).setImageDrawable(ar.e(drawable, context.getResources().getColor(R.color.afz)));
        AppMethodBeat.o(216113);
    }
}
