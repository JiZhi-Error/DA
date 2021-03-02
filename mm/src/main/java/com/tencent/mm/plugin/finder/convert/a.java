package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderBlockListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class a extends e<p> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, p pVar, int i2, int i3, boolean z, List list) {
        boolean z2;
        boolean z3;
        String str;
        AppMethodBeat.i(242766);
        p pVar2 = pVar;
        kotlin.g.b.p.h(hVar, "holder");
        kotlin.g.b.p.h(pVar2, "item");
        if (as.bjt(pVar2.contact.username)) {
            m mVar = m.uJa;
            d<o> dka = m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(pVar2.contact.headUrl);
            View Mn = hVar.Mn(R.id.ckf);
            kotlin.g.b.p.g(Mn, "holder.getView<ImageView…finder_block_item_header)");
            m mVar2 = m.uJa;
            dka.a(aVar, (ImageView) Mn, m.a(m.a.AVATAR));
        } else {
            String str2 = pVar2.contact.headUrl;
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                m mVar3 = m.uJa;
                d<o> dkb = m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(pVar2.contact.headUrl);
                View Mn2 = hVar.Mn(R.id.ckf);
                kotlin.g.b.p.g(Mn2, "holder.getView<ImageView…finder_block_item_header)");
                m mVar4 = m.uJa;
                dkb.a(aVar2, (ImageView) Mn2, m.a(m.a.WX_AVATAR));
            } else {
                a.b.c((ImageView) hVar.Mn(R.id.ckf), pVar2.contact.username);
            }
        }
        String str3 = pVar2.contact.nickname;
        if (str3 == null || str3.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            y yVar = y.vXH;
            str = y.hh(pVar2.contact.username, null);
        } else {
            str = pVar2.contact.nickname;
        }
        View Mn3 = hVar.Mn(R.id.ckg);
        kotlin.g.b.p.g(Mn3, "holder.getView<TextView>…d.finder_block_item_name)");
        ((TextView) Mn3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), str));
        AppMethodBeat.o(242766);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.a9l;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242765);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        AppMethodBeat.o(242765);
    }
}
