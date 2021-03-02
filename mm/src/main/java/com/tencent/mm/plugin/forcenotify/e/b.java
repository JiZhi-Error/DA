package com.tencent.mm.plugin.forcenotify.e;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.forcenotify.c.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/convert/ForceNotifyMsgConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-force-notify_release"})
public final class b extends e<h> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, h hVar2, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(261740);
        h hVar3 = hVar2;
        p.h(hVar, "holder");
        p.h(hVar3, "item");
        ImageView imageView = (ImageView) hVar.aus.findViewById(R.id.x1);
        if (n.nm(hVar3.wMn, "@miniapp")) {
            q.bcV().loadImage(hVar3.kog, imageView);
        } else {
            a.b.d(imageView, hVar3.username, 0.12f);
        }
        TextView textView = (TextView) hVar.aus.findViewById(R.id.ir3);
        p.g(textView, "titleTv");
        textView.setText(hVar3.nickname);
        TextView textView2 = (TextView) hVar.aus.findViewById(R.id.k3u);
        p.g(textView2, "wordingTv");
        textView2.setText(hVar3.dQx);
        AppMethodBeat.o(261740);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.cfq;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(261739);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.aus.findViewById(R.id.ir3);
        p.g(textView, "titleTv");
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(261739);
    }
}
