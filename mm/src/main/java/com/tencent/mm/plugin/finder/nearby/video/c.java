package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.cp;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "spanCount", "", "getSpanCount", "()I", "bindConvert", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "plugin-finder_release"})
public final class c extends al {
    private final int att = 2;
    private final MMActivity gte;

    public c(MMActivity mMActivity) {
        p.h(mMActivity, "context");
        AppMethodBeat.i(249462);
        this.gte = mMActivity;
        AppMethodBeat.o(249462);
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.LayoutManager eS(Context context) {
        AppMethodBeat.i(249457);
        p.h(context, "context");
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager = new FinderStaggeredGridLayoutManager(this.att);
        finderStaggeredGridLayoutManager.setItemPrefetchEnabled(true);
        FinderStaggeredGridLayoutManager finderStaggeredGridLayoutManager2 = finderStaggeredGridLayoutManager;
        AppMethodBeat.o(249457);
        return finderStaggeredGridLayoutManager2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemDecoration$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
    public static final class b extends RecyclerView.h {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(249456);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            Context context = view.getContext();
            p.g(context, "view.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.bt);
            Context context2 = view.getContext();
            p.g(context2, "view.context");
            int dimension2 = (int) context2.getResources().getDimension(R.dimen.a4l);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                AppMethodBeat.o(249456);
                throw tVar;
            } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).mJ()) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(249456);
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams");
                    AppMethodBeat.o(249456);
                    throw tVar2;
                } else if (((StaggeredGridLayoutManager.LayoutParams) layoutParams2).kj() % 2 == 0) {
                    rect.left = dimension;
                    rect.right = dimension2;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249456);
                } else {
                    rect.left = dimension2;
                    rect.right = dimension;
                    rect.bottom = dimension2;
                    rect.top = dimension2;
                    AppMethodBeat.o(249456);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(249458);
        b bVar = new b();
        AppMethodBeat.o(249458);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final f dcK() {
        AppMethodBeat.i(249459);
        f G = G(null);
        AppMethodBeat.o(249459);
        return G;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ c uTy;
        final /* synthetic */ kotlin.g.a.b uTz;

        a(c cVar, kotlin.g.a.b bVar) {
            this.uTy = cVar;
            this.uTz = bVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/NearbyVideoFeedConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.nearby.video.c$a$a  reason: collision with other inner class name */
        public static final class C1249a extends cp {
            final /* synthetic */ a uTA;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1249a(a aVar) {
                this.uTA = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.cp
            public final /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(249452);
                a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(249452);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.plugin.finder.convert.cp
            public final void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(249451);
                p.h(hVar, "holder");
                p.h(baseFinderFeed, "item");
                super.a(hVar, baseFinderFeed, i2, i3, z, list);
                c.l(hVar, baseFinderFeed);
                AppMethodBeat.o(249451);
            }
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            com.tencent.mm.plugin.finder.convert.f fVar;
            AppMethodBeat.i(249455);
            switch (i2) {
                case 2:
                case 3001:
                    b bVar = new b(this);
                    AppMethodBeat.o(249455);
                    return bVar;
                case 4:
                case 9:
                case 3002:
                    C1249a aVar = new C1249a(this);
                    AppMethodBeat.o(249455);
                    return aVar;
                default:
                    kotlin.g.a.b bVar2 = this.uTz;
                    if (bVar2 == null || (fVar = (e) bVar2.invoke(Integer.valueOf(i2))) == null) {
                        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                            RuntimeException runtimeException = new RuntimeException("type invalid");
                            AppMethodBeat.o(249455);
                            throw runtimeException;
                        }
                        Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
                        fVar = new com.tencent.mm.plugin.finder.convert.f();
                    }
                    AppMethodBeat.o(249455);
                    return fVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoStaggeredConfig$getItemConvertFactory$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class b extends v {
            final /* synthetic */ a uTA;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(a aVar) {
                this.uTA = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.v
            public final /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(249454);
                a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(249454);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.plugin.finder.convert.v
            public final void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(249453);
                p.h(hVar, "holder");
                p.h(baseFinderFeed, "item");
                super.a(hVar, baseFinderFeed, i2, i3, z, list);
                c.l(hVar, baseFinderFeed);
                AppMethodBeat.o(249453);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final f G(kotlin.g.a.b<? super Integer, ? extends e<?>> bVar) {
        AppMethodBeat.i(249460);
        a aVar = new a(this, bVar);
        AppMethodBeat.o(249460);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.finder.storage.al
    public final RecyclerView.m f(MMActivity mMActivity) {
        AppMethodBeat.i(249461);
        p.h(mMActivity, "context");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderRecyclerViewPool.class)).wuw;
        AppMethodBeat.o(249461);
        return mVar;
    }

    public static final /* synthetic */ void l(h hVar, BaseFinderFeed baseFinderFeed) {
        String str;
        int i2;
        AppMethodBeat.i(249463);
        View Mn = hVar.Mn(R.id.cml);
        ImageView imageView = (ImageView) hVar.Mn(R.id.ebf);
        TextView textView = (TextView) hVar.Mn(R.id.eba);
        p.g(Mn, "likeContainer");
        Mn.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.d3y);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        p.g(textView, "likeTv");
        String str2 = baseFinderFeed.feedObject.getFeedObject().recommendReason;
        if (str2 != null) {
            str = str2;
        }
        textView.setText(str);
        switch (baseFinderFeed.feedObject.getFeedObject().recommendReasonType) {
            case 1:
                Mn.setVisibility(0);
                Context context = hVar.getContext();
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                imageView.setImageDrawable(ar.m(context, R.raw.icons_filled_location, context2.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
            case 9:
                Mn.setVisibility(0);
                Context context3 = hVar.getContext();
                Context context4 = hVar.getContext();
                p.g(context4, "holder.context");
                imageView.setImageDrawable(ar.m(context3, R.raw.icons_filled_me, context4.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
            case 10:
                Mn.setVisibility(0);
                Context context5 = hVar.getContext();
                Context context6 = hVar.getContext();
                p.g(context6, "holder.context");
                imageView.setImageDrawable(ar.m(context5, R.raw.finder_icons_filled_topic, context6.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
            case 11:
                Mn.setVisibility(0);
                Context context7 = hVar.getContext();
                Context context8 = hVar.getContext();
                p.g(context8, "holder.context");
                imageView.setImageDrawable(ar.m(context7, R.raw.finder_icons_filled_sight, context8.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
            case 12:
                Mn.setVisibility(0);
                Context context9 = hVar.getContext();
                Context context10 = hVar.getContext();
                p.g(context10, "holder.context");
                imageView.setImageDrawable(ar.m(context9, R.raw.finder_filled_fire, context10.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
            case 13:
                Mn.setVisibility(0);
                Context context11 = hVar.getContext();
                Context context12 = hVar.getContext();
                p.g(context12, "holder.context");
                imageView.setImageDrawable(ar.m(context11, R.raw.finder_icons_filled_food, context12.getResources().getColor(R.color.am)));
                p.g(imageView, "likeIv");
                imageView.setVisibility(0);
                break;
        }
        if (baseFinderFeed.feedObject.isLiveFeed()) {
            awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
            if (liveInfo == null || liveInfo.liveStatus != 1) {
                Mn.setVisibility(8);
            } else {
                awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
                if (liveInfo2 != null) {
                    i2 = liveInfo2.uBn;
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    Mn.setVisibility(0);
                    p.g(imageView, "likeIv");
                    imageView.setVisibility(8);
                    textView.setText(hVar.getContext().getString(R.string.cn_, k.gm(2, i2)));
                    AppMethodBeat.o(249463);
                    return;
                }
                Mn.setVisibility(8);
                AppMethodBeat.o(249463);
                return;
            }
        }
        AppMethodBeat.o(249463);
    }
}
