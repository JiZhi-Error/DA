package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectRecommendLikeNewConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectRecommendLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bp extends bh<az> {
    private final String TAG = "Finder.FinderMsgFriendObjectRecommendLikeConvert";
    private final int scene;

    public bp(int i2) {
        super(R.layout.aha, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, az azVar) {
        String str;
        boolean z;
        AppMethodBeat.i(243206);
        az azVar2 = azVar;
        p.h(hVar, "holder");
        p.h(azVar2, "item");
        y yVar = y.vXH;
        String hh = y.hh(azVar2.uNF.field_username, azVar2.uNF.field_nickname);
        Log.i(this.TAG, "username " + Util.nullAs(azVar2.uNF.field_username, "") + " nickname " + Util.nullAs(azVar2.uNF.field_nickname, "") + " url " + Util.nullAs(azVar2.uNF.field_headUrl, "") + " flag " + azVar2.uNF.field_extFlag + " content " + Util.secPrint(azVar2.uNF.field_content) + " id " + azVar2.uNF.field_id + " time " + azVar2.uNF.field_createTime);
        View Mn = hVar.Mn(R.id.x1);
        p.g(Mn, "holder.getView<View>(R.id.avatar_iv)");
        Mn.setVisibility(0);
        a aVar = new a(azVar2.uNF.field_headUrl);
        if ((azVar2.uNF.field_extFlag & 2) == 0 && (azVar2.uNF.field_extFlag & 1) == 0) {
            m mVar = m.uJa;
            d<o> dkb = m.dkb();
            View Mn2 = hVar.Mn(R.id.x1);
            p.g(Mn2, "holder.getView(R.id.avatar_iv)");
            m mVar2 = m.uJa;
            dkb.a(aVar, (ImageView) Mn2, m.a(m.a.WX_AVATAR));
        } else {
            m mVar3 = m.uJa;
            d<o> dka = m.dka();
            View Mn3 = hVar.Mn(R.id.x1);
            p.g(Mn3, "holder.getView(R.id.avatar_iv)");
            m mVar4 = m.uJa;
            dka.a(aVar, (ImageView) Mn3, m.a(m.a.AVATAR));
        }
        View Mn4 = hVar.Mn(R.id.fz8);
        p.g(Mn4, "holder.getView<View>(R.id.nick_name)");
        Mn4.setVisibility(0);
        View Mn5 = hVar.Mn(R.id.fz8);
        p.g(Mn5, "holder.getView<TextView>(R.id.nick_name)");
        ((TextView) Mn5).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), hh));
        g gVar = g.vGW;
        azu Lj = g.Lj((int) azVar2.uNF.field_objectType);
        if (Lj != null) {
            String str2 = Lj.LJC;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str = Lj.LJC;
                View Mn6 = hVar.Mn(R.id.ie1);
                p.g(Mn6, "holder.getView<TextView>(R.id.suffix_desc_tv)");
                ((TextView) Mn6).setText(str);
                Context context = hVar.getContext();
                p.g(context, "holder.context");
                Resources resources = context.getResources();
                y yVar2 = y.vXH;
                ((TextView) hVar.Mn(R.id.ie1)).setTextColor(resources.getColor(y.LQ(this.scene)));
                View Mn7 = hVar.Mn(R.id.ik6);
                p.g(Mn7, "holder.getView<TextView>(R.id.text_content_view)");
                ((TextView) Mn7).setVisibility(8);
                m mVar5 = m.uJa;
                d<o> djY = m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(azVar2.uNF.field_thumbUrl, x.THUMB_IMAGE);
                View Mn8 = hVar.Mn(R.id.ime);
                p.g(Mn8, "holder.getView(R.id.thumb_view)");
                m mVar6 = m.uJa;
                djY.a(pVar, (ImageView) Mn8, m.a(m.a.MSG_THUMB));
                if (Util.isNullOrNil(azVar2.uNF.field_thumbUrl) && azVar2.uNF.field_mediaType == 1) {
                    View Mn9 = hVar.Mn(R.id.ik6);
                    p.g(Mn9, "holder.getView<TextView>(R.id.text_content_view)");
                    ((TextView) Mn9).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), azVar2.uNF.field_description));
                    View Mn10 = hVar.Mn(R.id.ik6);
                    p.g(Mn10, "holder.getView<TextView>(R.id.text_content_view)");
                    ((TextView) Mn10).setVisibility(0);
                }
                AppMethodBeat.o(243206);
            }
        }
        str = hVar.getContext().getString(R.string.d27);
        View Mn62 = hVar.Mn(R.id.ie1);
        p.g(Mn62, "holder.getView<TextView>(R.id.suffix_desc_tv)");
        ((TextView) Mn62).setText(str);
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        Resources resources2 = context2.getResources();
        y yVar22 = y.vXH;
        ((TextView) hVar.Mn(R.id.ie1)).setTextColor(resources2.getColor(y.LQ(this.scene)));
        View Mn72 = hVar.Mn(R.id.ik6);
        p.g(Mn72, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn72).setVisibility(8);
        m mVar52 = m.uJa;
        d<o> djY2 = m.djY();
        com.tencent.mm.plugin.finder.loader.p pVar2 = new com.tencent.mm.plugin.finder.loader.p(azVar2.uNF.field_thumbUrl, x.THUMB_IMAGE);
        View Mn82 = hVar.Mn(R.id.ime);
        p.g(Mn82, "holder.getView(R.id.thumb_view)");
        m mVar62 = m.uJa;
        djY2.a(pVar2, (ImageView) Mn82, m.a(m.a.MSG_THUMB));
        View Mn92 = hVar.Mn(R.id.ik6);
        p.g(Mn92, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn92).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), azVar2.uNF.field_description));
        View Mn102 = hVar.Mn(R.id.ik6);
        p.g(Mn102, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn102).setVisibility(0);
        AppMethodBeat.o(243206);
    }
}
