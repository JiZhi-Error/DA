package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "()V", "getLayoutId", "", "getStr", "", "context", "Landroid/content/Context;", "resId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setDefaultAvatarImage", "imageView", "Landroid/widget/ImageView;", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Companion", "plugin-finder_release"})
public final class e extends com.tencent.mm.view.recyclerview.e<q> {
    public static final b UHR = new b((byte) 0);

    static {
        AppMethodBeat.i(260194);
        AppMethodBeat.o(260194);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, q qVar, int i2, int i3, boolean z, List list) {
        String str;
        AppMethodBeat.i(242776);
        q qVar2 = qVar;
        p.h(hVar, "holder");
        p.h(qVar2, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.d2l);
        TextView textView = (TextView) hVar.Mn(R.id.giz);
        if (Util.isNullOrNil(qVar2.dkw())) {
            p.g(textView, "musicText");
            textView.setText(hVar.getContext().getString(R.string.cll));
        } else {
            p.g(textView, "musicText");
            textView.setText(qVar2.dkw());
        }
        TextView textView2 = (TextView) hVar.Mn(R.id.gix);
        p.g(textView2, "musicTagText");
        if (qVar2.dkx()) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            String string = context.getResources().getString(R.string.d6m);
            p.g(string, "context.resources.getString(resId)");
            str = string;
        }
        textView2.setText(str);
        TextView textView3 = (TextView) hVar.Mn(R.id.giy);
        p.g(textView3, "timeText");
        textView3.setText(k.l(hVar.getContext(), ((long) qVar2.uNV.field_createTime) * 1000));
        if (qVar2.dkx()) {
            p.g(imageView, "imageView");
            imageView.setImageResource(R.drawable.c9a);
        }
        p.g(imageView, "imageView");
        cjl cjl = (cjl) j.kt(qVar2.uNV.dxn().getMediaList());
        Log.i("FinderDraftInfoConvert", "setImage " + (cjl != null ? cjl.thumbUrl : null) + " token:" + (cjl != null ? cjl.thumb_url_token : null) + " position:" + i2 + "  imageView:" + imageView);
        if (cjl != null) {
            m mVar = m.uJa;
            d<o> djY = m.djY();
            com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, x.THUMB_IMAGE, null, null, 12);
            m mVar2 = m.uJa;
            djY.a(kVar, imageView, m.a(m.a.TIMELINE));
        }
        if (!z) {
            com.tencent.f.h.RTc.aX(new a(hVar, com.tencent.mm.ac.d.zs(qVar2.uNV.field_localId)));
        }
        AppMethodBeat.o(242776);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderDraftInfoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.aiv;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242775);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(242775);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ h qhp;
        final /* synthetic */ String tzi;

        a(h hVar, String str) {
            this.qhp = hVar;
            this.tzi = str;
        }

        public final void run() {
            AppMethodBeat.i(242774);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ((FinderProfileEduUIC) com.tencent.mm.ui.component.a.ko(context).get(FinderProfileEduUIC.class)).R("draft", 0, this.tzi);
            AppMethodBeat.o(242774);
        }
    }
}
