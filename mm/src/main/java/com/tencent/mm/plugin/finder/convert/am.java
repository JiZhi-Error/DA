package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016J@\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "layoutResId", "", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;I)V", "getController", "()Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class am extends e<BaseFinderFeed> {
    private final int tDB;
    final FinderFoldedScrollLayout.b tEj;

    public am(FinderFoldedScrollLayout.b bVar, int i2) {
        p.h(bVar, "controller");
        this.tEj = bVar;
        this.tDB = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return this.tDB;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ am tEk;

        a(am amVar, h hVar) {
            this.tEk = amVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243125);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tEk.tEj.h(this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243125);
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void a(RecyclerView recyclerView, h hVar, int i2) {
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        hVar.aus.setOnClickListener(new a(this, hVar));
        this.tEj.cZE();
        ImageView imageView = (ImageView) hVar.Mn(R.id.cka);
        TextView textView = (TextView) hVar.Mn(R.id.d0q);
        if (textView != null) {
            textView.setOnClickListener(new b(imageView));
        }
        if (imageView != null) {
            imageView.setOnClickListener(new c(hVar));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ ImageView tEl;

        b(ImageView imageView) {
            this.tEl = imageView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243126);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tEl.callOnClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243126);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ h qhp;

        c(h hVar) {
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243127);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            intent.putExtra("finder_username", baseFinderFeed.feedObject.getUserName());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC.a.a(context, intent, baseFinderFeed.lT(), 5, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.qhp.getContext();
            p.g(context2, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFoldedConvert$onCreateViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243127);
        }
    }

    public void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        g gVar;
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.cka);
        TextView textView = (TextView) hVar.Mn(R.id.d0q);
        hVar.Mn(R.id.eba);
        if (this.tEj.cZG() == 1) {
            p.g(imageView, "avatar");
            imageView.setVisibility(0);
            m mVar = m.uJa;
            d<o> dka = m.dka();
            g gVar2 = baseFinderFeed.contact;
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(gVar2 != null ? gVar2.cXH() : null));
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(baseFinderFeed.feedObject.getNickNameSpan());
                ao.a(textView.getPaint(), 0.8f);
            }
            ImageView imageView2 = (ImageView) hVar.Mn(R.id.w0);
            if (!(imageView2 == null || (gVar = baseFinderFeed.contact) == null)) {
                y yVar = y.vXH;
                y.a(imageView2, gVar.field_authInfo);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView3 = (ImageView) hVar.Mn(R.id.w0);
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        View Mn = hVar.Mn(R.id.cml);
        if (Mn != null) {
            baseFinderFeed.feedObject.getLikeCount();
            this.tEj.cZF();
            Mn.setVisibility(8);
            this.tEj.cZF();
        }
        TextView textView2 = (TextView) hVar.Mn(R.id.cl2);
        if (textView2 == null) {
            return;
        }
        if (!Util.isNullOrNil(baseFinderFeed.feedObject.getDescription())) {
            textView2.setVisibility(0);
            textView2.setText(baseFinderFeed.feedObject.getDescriptionSpan());
            return;
        }
        textView2.setText("");
    }
}
