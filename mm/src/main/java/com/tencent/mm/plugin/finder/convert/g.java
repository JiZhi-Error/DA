package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0007H\u0016J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\t¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedBulletSubtitleConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authorItemPaddingStart", "", "getAuthorItemPaddingStart", "()I", "authorItemPaddingStart$delegate", "Lkotlin/Lazy;", "normalPaddingStart", "getNormalPaddingStart", "normalPaddingStart$delegate", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class g extends e<s> {
    final Context context;
    private final f tzj = kotlin.g.ah(new b(this));
    private final f tzk = kotlin.g.ah(new a(this));

    public g(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(242783);
        this.context = context2;
        AppMethodBeat.o(242783);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, s sVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242782);
        s sVar2 = sVar;
        p.h(hVar, "holder");
        p.h(sVar2, "item");
        int cxn = sVar2.cxn();
        s.a aVar = s.uOj;
        boolean z2 = cxn == s.uOh && sVar2.uOf.dyj();
        TextView textView = (TextView) hVar.Mn(R.id.iwu);
        if (textView != null) {
            String content = sVar2.uOf.getContent();
            if (z2) {
                content = hVar.getContext().getString(R.string.db_) + content;
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                textView.setTextColor(context2.getResources().getColor(R.color.pm));
            } else {
                textView.setTextColor(-1);
            }
            String j2 = n.j(content, "\n", " ", false);
            if (j2.length() > 30) {
                j2 = TextUtils.ellipsize(j2, textView.getPaint(), textView.getPaint().measureText(j2, 0, 30), TextUtils.TruncateAt.END).toString();
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar.getContext(), j2));
            c cVar = c.vdc;
            c.EU(sVar2.uOf.field_feedId);
        }
        View Mn = hVar.Mn(R.id.afj);
        int intValue = z2 ? ((Number) this.tzk.getValue()).intValue() : ((Number) this.tzj.getValue()).intValue();
        p.g(Mn, LocaleUtil.ITALIAN);
        boolean z3 = 1 == Mn.getLayoutDirection();
        if (i2 == 0) {
            intValue = 0;
        }
        if (z3) {
            Mn.setPadding(0, 0, intValue, 0);
            AppMethodBeat.o(242782);
            return;
        }
        Mn.setPadding(intValue, 0, 0, 0);
        AppMethodBeat.o(242782);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.a8h;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242781);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.Mn(R.id.iwu);
        p.g(textView, LocaleUtil.ITALIAN);
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(242781);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ g tzl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(0);
            this.tzl = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(242780);
            Integer valueOf = Integer.valueOf(this.tzl.context.getResources().getDimensionPixelOffset(R.dimen.cm));
            AppMethodBeat.o(242780);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ g tzl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(0);
            this.tzl = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(242779);
            Integer valueOf = Integer.valueOf(this.tzl.context.getResources().getDimensionPixelOffset(R.dimen.cb));
            AppMethodBeat.o(242779);
            return valueOf;
        }
    }
}
