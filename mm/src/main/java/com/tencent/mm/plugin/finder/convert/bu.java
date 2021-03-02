package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgNotifyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgNotify;", "scene", "", "(I)V", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bu extends bh<bd> {
    private final int scene;

    public bu(int i2) {
        super(R.layout.ahf, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, bd bdVar) {
        AppMethodBeat.i(165440);
        bd bdVar2 = bdVar;
        p.h(hVar, "holder");
        p.h(bdVar2, "item");
        azp azp = bdVar2.uNF.field_notify;
        if (azp != null) {
            View Mn = hVar.Mn(R.id.fn7);
            p.g(Mn, "holder.getView<TextView>(R.id.msg_title)");
            ((TextView) Mn).setText(azp.title);
            View Mn2 = hVar.Mn(R.id.fmb);
            p.g(Mn2, "holder.getView<TextView>(R.id.msg_content)");
            ((TextView) Mn2).setText(azp.content);
            View Mn3 = hVar.Mn(R.id.bo3);
            View Mn4 = hVar.Mn(R.id.dvd);
            if ((azp.subType == 1 || azp.subType == 2) && !Util.isNullOrNil(azp.link)) {
                p.g(Mn3, "detailContainer");
                Mn3.setVisibility(0);
                p.g(Mn4, "imageDivider");
                Mn4.setVisibility(0);
                AppMethodBeat.o(165440);
                return;
            }
            p.g(Mn3, "detailContainer");
            Mn3.setVisibility(8);
            p.g(Mn4, "imageDivider");
            Mn4.setVisibility(8);
            AppMethodBeat.o(165440);
            return;
        }
        AppMethodBeat.o(165440);
    }
}
