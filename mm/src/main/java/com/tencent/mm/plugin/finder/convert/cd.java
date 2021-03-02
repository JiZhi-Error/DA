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
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderSelectActivityConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class cd extends e<com.tencent.mm.plugin.finder.model.l> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.l lVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243272);
        com.tencent.mm.plugin.finder.model.l lVar2 = lVar;
        p.h(hVar, "holder");
        p.h(lVar2, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.hgy);
        TextView textView = (TextView) hVar.Mn(R.id.hh0);
        TextView textView2 = (TextView) hVar.Mn(R.id.hgz);
        m mVar = m.uJa;
        d<o> djY = m.djY();
        String str = lVar2.tqo.coverImgUrl;
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE);
        p.g(imageView, "avatarView");
        m mVar2 = m.uJa;
        djY.a(pVar, imageView, m.a(m.a.TIMELINE));
        p.g(textView, "activityTitle");
        textView.setText(lVar2.tqo.eventName);
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        String string = view.getResources().getString(R.string.cgz, k.gm(2, lVar2.tqo.LCy));
        p.g(string, "holder.itemView.resource…ntInfo.participantCount))");
        p.g(textView2, "activityDesc");
        textView2.setText(string);
        AppMethodBeat.o(243272);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ajh;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243271);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243271);
    }
}
