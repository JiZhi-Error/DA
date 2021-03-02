package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgCommentConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgComment;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bf extends bh<au> {
    private final String TAG = "Finder.FinderMsgCommentConvert";
    private final int scene;

    public bf(int i2) {
        super(R.layout.ah2, i2);
        this.scene = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.a] */
    @Override // com.tencent.mm.plugin.finder.convert.bh
    public final /* synthetic */ void a(h hVar, au auVar) {
        AppMethodBeat.i(165438);
        au auVar2 = auVar;
        p.h(hVar, "holder");
        p.h(auVar2, "item");
        a aVar = new a(auVar2.uNF.field_headUrl);
        TextView textView = (TextView) hVar.Mn(R.id.fzg);
        Log.i(this.TAG, "username " + Util.nullAs(auVar2.uNF.field_username, "") + " nickname " + Util.nullAs(auVar2.uNF.field_nickname, "") + " url " + Util.nullAs(auVar2.uNF.field_headUrl, "") + " flag " + auVar2.uNF.field_extFlag + " content " + Util.secPrint(auVar2.uNF.field_content) + " id " + auVar2.uNF.field_id + " time " + auVar2.uNF.field_createTime);
        if ((auVar2.uNF.field_extFlag & 2) == 0 && (auVar2.uNF.field_extFlag & 1) == 0) {
            m mVar = m.uJa;
            d<o> dkb = m.dkb();
            View Mn = hVar.Mn(R.id.x1);
            p.g(Mn, "holder.getView(R.id.avatar_iv)");
            m mVar2 = m.uJa;
            dkb.a(aVar, (ImageView) Mn, m.a(m.a.WX_AVATAR));
        } else {
            m mVar3 = m.uJa;
            d<o> dka = m.dka();
            View Mn2 = hVar.Mn(R.id.x1);
            p.g(Mn2, "holder.getView(R.id.avatar_iv)");
            m mVar4 = m.uJa;
            dka.a(aVar, (ImageView) Mn2, m.a(m.a.AVATAR));
        }
        p.g(textView, "nickTv");
        Context context = hVar.getContext();
        y yVar = y.vXH;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.a(auVar2)));
        View Mn3 = hVar.Mn(R.id.fmb);
        p.g(Mn3, "holder.getView<TextView>(R.id.msg_content)");
        ((TextView) Mn3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), auVar2.uNF.field_content));
        if (!Util.isNullOrNil(auVar2.uNF.field_refContent)) {
            View Mn4 = hVar.Mn(R.id.gy9);
            p.g(Mn4, "holder.getView<View>(R.id.ref_comment_container)");
            Mn4.setVisibility(0);
            if (!Util.isNullOrNil(auVar2.uNF.field_replayNickname)) {
                View Mn5 = hVar.Mn(R.id.fmt);
                p.g(Mn5, "holder.getView<TextView>(R.id.msg_ref_content)");
                ((TextView) Mn5).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), hVar.getContext().getString(R.string.d2h, auVar2.uNF.field_replayNickname, auVar2.uNF.field_refContent)));
            } else {
                View Mn6 = hVar.Mn(R.id.fmt);
                p.g(Mn6, "holder.getView<TextView>(R.id.msg_ref_content)");
                ((TextView) Mn6).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), auVar2.uNF.field_refContent));
            }
        } else {
            View Mn7 = hVar.Mn(R.id.gy9);
            p.g(Mn7, "holder.getView<View>(R.id.ref_comment_container)");
            Mn7.setVisibility(8);
        }
        View Mn8 = hVar.Mn(R.id.ik6);
        p.g(Mn8, "holder.getView<TextView>(R.id.text_content_view)");
        ((TextView) Mn8).setVisibility(8);
        m mVar5 = m.uJa;
        d<o> djY = m.djY();
        com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(auVar2.uNF.field_thumbUrl, x.THUMB_IMAGE);
        View Mn9 = hVar.Mn(R.id.ime);
        p.g(Mn9, "holder.getView(R.id.thumb_view)");
        m mVar6 = m.uJa;
        djY.a(pVar, (ImageView) Mn9, m.a(m.a.MSG_THUMB));
        if (Util.isNullOrNil(auVar2.uNF.field_thumbUrl) && auVar2.uNF.field_mediaType == 1) {
            View Mn10 = hVar.Mn(R.id.ik6);
            p.g(Mn10, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn10).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), auVar2.uNF.field_description));
            View Mn11 = hVar.Mn(R.id.ik6);
            p.g(Mn11, "holder.getView<TextView>(R.id.text_content_view)");
            ((TextView) Mn11).setVisibility(0);
        }
        if (this.scene == 1 && ((int) auVar2.uNF.field_objectType) == 2 && Util.isNullOrNil(auVar2.uNF.field_refContent)) {
            View Mn12 = hVar.Mn(R.id.fmc);
            p.g(Mn12, "holder.getView<View>(R.id.msg_content_mv_desc)");
            Mn12.setVisibility(0);
            View Mn13 = hVar.Mn(R.id.fmc);
            p.g(Mn13, "holder.getView<TextView>(R.id.msg_content_mv_desc)");
            ((TextView) Mn13).setText(hVar.getContext().getString(R.string.d2_));
            AppMethodBeat.o(165438);
            return;
        }
        View Mn14 = hVar.Mn(R.id.fmc);
        p.g(Mn14, "holder.getView<View>(R.id.msg_content_mv_desc)");
        Mn14.setVisibility(8);
        AppMethodBeat.o(165438);
    }
}
