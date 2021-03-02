package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ab extends e<h> {
    public static final a tDz = new a((byte) 0);

    static {
        AppMethodBeat.i(165410);
        AppMethodBeat.o(165410);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, h hVar2, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165409);
        a(hVar, hVar2);
        AppMethodBeat.o(165409);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.f3119i;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(165408);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(true);
        }
        hVar.Mn(R.id.fmk).setOnClickListener(new b(hVar));
        AppMethodBeat.o(165408);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        b(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            int i2;
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(165407);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i6 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            int i7 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh3 = g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            int i8 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh4 = g.aAh();
            p.g(aAh4, "MMKernel.storage()");
            int i9 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.fu(context);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah).getRedDotManager().asX("TLWxBubble");
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("TLWxBubble");
            String str = "7";
            if (asX != null) {
                c cVar = c.vCb;
                if (c.dsx().value().intValue() == 1) {
                    i2 = 5;
                    if (i7 > 0) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    if (i6 > 0) {
                        i4 |= 8;
                    }
                    if (i8 > 0) {
                        i4 |= 2;
                    }
                    if (i9 > 0) {
                        i5 = i4 | 4;
                    } else {
                        i5 = i4;
                    }
                    str = "7";
                    i3 = i5;
                } else {
                    str = "7";
                    i2 = 1;
                    i3 = 1;
                }
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                int i10 = i6 + i7 + i8 + i9;
                String str2 = asX.field_tipsId;
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                Context context2 = this.qhp.getContext();
                p.g(context2, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
                com.tencent.mm.plugin.finder.report.k.a(str, i2, 2, 2, i3, i10, str2, (String) null, 0, fH != null ? fH.dIx() : null, 0, 0, 3456);
            }
            if (!(asX == null || asW == null)) {
                j jVar = j.vft;
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                Context context3 = this.qhp.getContext();
                p.g(context3, "holder.context");
                FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context3);
                j.a(str, asX, asW, 2, fH2 != null ? fH2.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165407);
        }
    }

    public static void a(com.tencent.mm.view.recyclerview.h hVar, h hVar2) {
        AppMethodBeat.i(243077);
        p.h(hVar, "holder");
        p.h(hVar2, "item");
        Log.i("Finder.FeedMsgNotifyConvert", "item count = " + hVar2.count + ",item avatar = " + hVar2.uNR);
        if (hVar2.count > 0) {
            View Mn = hVar.Mn(R.id.fmk);
            p.g(Mn, "holder.getView<View>(R.id.msg_layout)");
            Mn.setVisibility(0);
            if (Util.isNullOrNil(hVar2.uNR)) {
                View Mn2 = hVar.Mn(R.id.fm7);
                p.g(Mn2, "holder.getView<View>(R.id.msg_avatar)");
                Mn2.setVisibility(8);
            } else {
                View Mn3 = hVar.Mn(R.id.fm7);
                p.g(Mn3, "holder.getView<View>(R.id.msg_avatar)");
                Mn3.setVisibility(0);
                m mVar = m.uJa;
                d<o> dkb = m.dkb();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(hVar2.uNR, x.THUMB_IMAGE);
                View Mn4 = hVar.Mn(R.id.fm7);
                p.g(Mn4, "holder.getView<ImageView>(R.id.msg_avatar)");
                m mVar2 = m.uJa;
                dkb.a(pVar, (ImageView) Mn4, m.a(m.a.WX_AVATAR));
            }
            View Mn5 = hVar.Mn(R.id.fdw);
            p.g(Mn5, "holder.getView<TextView>(R.id.message_count)");
            TextView textView = (TextView) Mn5;
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            Resources resources = context.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = hVar2.count > 99 ? "99+" : Integer.valueOf(hVar2.count);
            textView.setText(resources.getString(R.string.d1e, objArr));
            AppMethodBeat.o(243077);
            return;
        }
        View Mn6 = hVar.Mn(R.id.fmk);
        p.g(Mn6, "holder.getView<View>(R.id.msg_layout)");
        Mn6.setVisibility(8);
        AppMethodBeat.o(243077);
    }
}
