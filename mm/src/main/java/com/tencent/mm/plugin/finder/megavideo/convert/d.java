package com.tencent.mm.plugin.finder.megavideo.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.plugin.finder.megavideo.ui.d;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J@\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert;", "Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "deleteItem", "", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "posting", "", "getLayoutId", "", "initLockIcon", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "refreshPostingLayout", "plugin-finder_release"})
public final class d extends b {
    private final d.a uKA;

    public d(d.a aVar) {
        p.h(aVar, "presenter");
        AppMethodBeat.i(248356);
        this.uKA = aVar;
        AppMethodBeat.o(248356);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.megavideo.convert.b
    public final /* bridge */ /* synthetic */ void a(h hVar, bm bmVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(248353);
        a(hVar, bmVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(248353);
    }

    @Override // com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.megavideo.convert.b
    public final int getLayoutId() {
        return R.layout.agq;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.finder.megavideo.convert.b
    public final void a(h hVar, bm bmVar, int i2, int i3, boolean z, List<Object> list) {
        int i4;
        AppMethodBeat.i(248352);
        p.h(hVar, "holder");
        p.h(bmVar, "item");
        List<Object> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            for (T t : list) {
                if (t instanceof o) {
                    switch (t.first.intValue()) {
                        case 0:
                            c(hVar, bmVar);
                            AppMethodBeat.o(248352);
                            return;
                        case 4:
                            d(hVar, bmVar);
                            AppMethodBeat.o(248352);
                            return;
                    }
                }
            }
        }
        super.a(hVar, bmVar, i2, i3, z, list);
        d(hVar, bmVar);
        int i5 = R.drawable.we;
        if (this.uKA.isSelf()) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            int color = context.getResources().getColor(R.color.qs);
            i5 = R.drawable.wf;
            i4 = color;
        } else {
            i4 = -1;
        }
        TextView textView = (TextView) hVar.Mn(R.id.j4n);
        if (textView != null) {
            textView.setTextColor(i4);
        }
        View Mn = hVar.Mn(R.id.j4m);
        if (Mn != null) {
            Mn.setBackgroundResource(i5);
        }
        c(hVar, bmVar);
        TextView textView2 = (TextView) hVar.Mn(R.id.j4w);
        if (textView2 != null) {
            String gm = k.gm(this.uKA.isSelf() ? 1 : 2, bmVar.getFeedObject().likeCount);
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            textView2.setText(context2.getResources().getString(R.string.d0y, gm));
            AppMethodBeat.o(248352);
            return;
        }
        AppMethodBeat.o(248352);
    }

    private final void c(h hVar, bm bmVar) {
        AppMethodBeat.i(248354);
        if (!this.uKA.isSelf()) {
            AppMethodBeat.o(248354);
            return;
        }
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
        if (bmVar.isPrivate()) {
            View Mn = hVar.Mn(R.id.j4m);
            p.g(Mn, LocaleUtil.ITALIAN);
            Mn.setPadding(dimensionPixelOffset, Mn.getPaddingTop(), 0, Mn.getPaddingBottom());
            View Mn2 = hVar.Mn(R.id.brt);
            p.g(Mn2, "holder.getView<View>(R.id.divider)");
            Mn2.setVisibility(0);
            View Mn3 = hVar.Mn(R.id.ghe);
            p.g(Mn3, "holder.getView<View>(R.id.private_lock_icon)");
            Mn3.setVisibility(0);
            AppMethodBeat.o(248354);
            return;
        }
        View Mn4 = hVar.Mn(R.id.j4m);
        p.g(Mn4, LocaleUtil.ITALIAN);
        Mn4.setPadding(dimensionPixelOffset, Mn4.getPaddingTop(), dimensionPixelOffset, Mn4.getPaddingBottom());
        View Mn5 = hVar.Mn(R.id.brt);
        p.g(Mn5, "holder.getView<View>(R.id.divider)");
        Mn5.setVisibility(8);
        View Mn6 = hVar.Mn(R.id.ghe);
        p.g(Mn6, "holder.getView<View>(R.id.private_lock_icon)");
        Mn6.setVisibility(8);
        AppMethodBeat.o(248354);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderPostProgressView tAY;

        b(FinderPostProgressView finderPostProgressView) {
            this.tAY = finderPostProgressView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(248350);
            FinderPostProgressView finderPostProgressView = this.tAY;
            p.g(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(248350);
                throw tVar;
            }
            finderPostProgressView.setProgress(((Integer) animatedValue).intValue());
            this.tAY.invalidate();
            AppMethodBeat.o(248350);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderItem uKB;

        c(FinderItem finderItem) {
            this.uKB = finderItem;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248351);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = g.vSJ;
            g.vSH.t(this.uKB);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248351);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$1$3"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ h tzq;
        final /* synthetic */ FinderItem uKB;
        final /* synthetic */ d uKC;
        final /* synthetic */ bm uKn;

        a(FinderItem finderItem, d dVar, h hVar, bm bmVar) {
            this.uKB = finderItem;
            this.uKC = dVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(248349);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.uKn.tuP == null) {
                p.hyc();
            }
            FinderItem finderItem = this.uKB;
            if (!this.uKB.isPostFailed()) {
                z = true;
            } else {
                z = false;
            }
            if (finderItem.getId() != 0) {
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                if (c.a.FT(finderItem.getId())) {
                    hg hgVar = new hg();
                    hgVar.dLJ.id = finderItem.getId();
                    EventCenter.instance.publish(hgVar);
                    Log.i("Finder.FeedConvert", "deleteItem by finder video id " + finderItem.getId());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(248349);
                }
            }
            if (finderItem.getLocalId() >= 0) {
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                FinderItem FS = c.a.FS(finderItem.getLocalId());
                c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.FV(finderItem.getLocalId());
                if (z) {
                    r.d dVar = r.d.vhx;
                    r.d.ol(finderItem.isLongVideo());
                    r.d dVar2 = r.d.vhx;
                    r.d.dow();
                    if (FS != null) {
                        i iVar = i.vfo;
                        i.e(finderItem);
                    }
                } else {
                    r.d dVar3 = r.d.vhx;
                    r.d.om(finderItem.isLongVideo());
                    r.d dVar4 = r.d.vhx;
                    r.d.dox();
                }
                hg hgVar2 = new hg();
                hgVar2.dLJ.localId = finderItem.getLocalId();
                EventCenter.instance.publish(hgVar2);
                Log.i("Finder.FeedConvert", "deleteItem by localId " + finderItem.getLocalId() + ", posting:" + z);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoProfileConvert$refreshPostingLayout$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248349);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x006f, code lost:
        if (r2 == null) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d(com.tencent.mm.view.recyclerview.h r11, com.tencent.mm.plugin.finder.model.bm r12) {
        /*
        // Method dump skipped, instructions count: 430
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.convert.d.d(com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.bm):void");
    }
}
