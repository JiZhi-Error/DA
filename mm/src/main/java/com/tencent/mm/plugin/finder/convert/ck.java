package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J@\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderTopicFilterConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderTopicInfoFeed;", "()V", "TAG", "", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class ck extends e<bl> {
    private final String TAG = "Finder.FinderTopicFilterConvert";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, bl blVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243371);
        bl blVar2 = blVar;
        p.h(hVar, "holder");
        p.h(blVar2, "item");
        TextView textView = (TextView) hVar.Mn(R.id.iu2);
        if (textView != null) {
            Context context = hVar.getContext();
            StringBuilder sb = new StringBuilder("#");
            String str = blVar2.dMU.dST;
            if (str == null) {
                str = "";
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, sb.append((Object) str).toString()));
        }
        if (blVar2.uOQ) {
            if (textView != null) {
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                textView.setTextColor(context2.getResources().getColor(R.color.FG_0));
            }
            p.g(textView, "topicTv");
            ao.a(textView.getPaint(), 0.8f);
        } else {
            if (textView != null) {
                Context context3 = hVar.getContext();
                p.g(context3, "holder.context");
                textView.setTextColor(context3.getResources().getColor(R.color.FG_1));
            }
            p.g(textView, "topicTv");
            ao.a(textView.getPaint(), 0.1f);
        }
        Log.i(this.TAG, "item hash:" + blVar2.hashCode() + ", topic:" + blVar2.dMU.dST + ", selected:" + blVar2.uOQ);
        AppMethodBeat.o(243371);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.akq;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243370);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.Mn(R.id.iu2);
        if (textView != null) {
            textView.setTextSize(1, 12.0f);
            AppMethodBeat.o(243370);
            return;
        }
        AppMethodBeat.o(243370);
    }
}
