package com.tencent.mm.plugin.vlog.model.panel;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-vlog_release"})
public final class g extends q<e> {
    private final ImageView kc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, n nVar) {
        super(view, nVar);
        p.h(view, "itemView");
        AppMethodBeat.i(190797);
        this.kc = (ImageView) view.findViewById(R.id.bxj);
        AppMethodBeat.o(190797);
    }

    @Override // com.tencent.mm.emoji.panel.a.q
    public final void a(ac acVar) {
        AppMethodBeat.i(190796);
        p.h(acVar, "item");
        super.a(acVar);
        e eVar = (e) this.hbh;
        if (eVar != null) {
            Log.i(b.TAG, "onBind: " + eVar.name);
            e eVar2 = e.hXU;
            b<String, Bitmap> He = e.aJs().He(eVar.GAV);
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            He.c(imageView);
            AppMethodBeat.o(190796);
            return;
        }
        AppMethodBeat.o(190796);
    }
}
