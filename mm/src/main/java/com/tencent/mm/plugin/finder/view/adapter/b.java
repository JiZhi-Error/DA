package com.tencent.mm.plugin.finder.view.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "mediaList", "", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isAliveMode", "", "(Ljava/util/List;Z)V", "onItemClick", "Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "getOnItemClick", "()Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "setOnItemClick", "(Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;)V", "getCardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "getFinderVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "AlbumHolder", "Companion", "OnItemClickListener", "plugin-finder_release"})
public class b extends FinderFeedAlbumView.a<a> {
    public static final C1329b wrj = new C1329b((byte) 0);
    private final List<cjl> oSb;
    public c wrh;
    private final boolean wri;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "view", "Landroid/view/View;", "plugin-finder_release"})
    public interface c {
        void f(int i2, View view);
    }

    static {
        AppMethodBeat.i(255151);
        AppMethodBeat.o(255151);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.mm.protocal.protobuf.cjl> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends cjl> list, boolean z) {
        p.h(list, "mediaList");
        AppMethodBeat.i(255150);
        this.oSb = list;
        this.wri = z;
        AppMethodBeat.o(255150);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.view.FinderFeedAlbumView$c' to match base method */
    @Override // com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a
    public final /* synthetic */ a a(LayoutInflater layoutInflater, FrameLayout frameLayout, int i2) {
        a aVar;
        AppMethodBeat.i(255146);
        p.h(layoutInflater, "layoutInflater");
        p.h(frameLayout, "parent");
        Context context = frameLayout.getContext();
        int Mm = Mm(i2);
        if (i2 == 0 && Mm == 4 && this.wri) {
            View inflate = aa.jQ(frameLayout.getContext()).inflate(R.layout.agj, (ViewGroup) frameLayout, false);
            p.g(inflate, "layout");
            aVar = new a(inflate);
        } else {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar = new a(imageView);
        }
        a aVar2 = aVar;
        AppMethodBeat.o(255146);
        return aVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.adapter.b$b  reason: collision with other inner class name */
    public static final class C1329b {
        private C1329b() {
        }

        public /* synthetic */ C1329b(byte b2) {
            this();
        }
    }

    public ag cZO() {
        return null;
    }

    public k cZP() {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a
    public final void a(View view, int i2, FinderFeedAlbumView.c cVar) {
        LinkedList<BaseFinderFeed> linkedList;
        BaseFinderFeed first;
        FinderItem finderItem;
        k cZP;
        AppMethodBeat.i(255147);
        p.h(view, "itemView");
        p.h(cVar, "holder");
        cjl cjl = this.oSb.get(i2);
        int Mm = Mm(i2);
        if (i2 == 0 && Mm == 4 && this.wri) {
            View findViewById = view.findViewById(R.id.ckd);
            if (!(findViewById instanceof FinderVideoLayout)) {
                findViewById = null;
            }
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) findViewById;
            ag cZO = cZO();
            if (!(cZO == null || (linkedList = cZO.rvFeedList) == null || (first = linkedList.getFirst()) == null || (finderItem = first.feedObject) == null || (cZP = cZP()) == null)) {
                if (finderVideoLayout != null) {
                    finderVideoLayout.setVideoCore(cZP);
                }
                if (finderVideoLayout != null) {
                    FeedData.a aVar = FeedData.Companion;
                    FinderVideoLayout.a(finderVideoLayout, i2, FeedData.a.i(finderItem), 0, false, false, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                }
                if (finderVideoLayout != null) {
                    finderVideoLayout.setMute(true);
                }
                if (finderVideoLayout != null) {
                    finderVideoLayout.setEnableShowLoading(false);
                }
            }
        } else {
            ImageView imageView = (ImageView) view;
            String str = cjl.thumbUrl;
            if (str == null || str.length() == 0) {
                Context context = imageView.getContext();
                p.g(context, "thumbIv.context");
                imageView.setImageDrawable(new ColorDrawable(context.getResources().getColor(R.color.BW_93)));
            } else {
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> djY = m.djY();
                com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, x.THUMB_IMAGE, null, null, 12);
                m mVar2 = m.uJa;
                djY.a(kVar, m.a(m.a.TIMELINE)).c(imageView);
            }
        }
        String str2 = cjl.thumbUrl;
        if (!(str2 == null || str2.length() == 0)) {
            c cVar2 = this.wrh;
            if (cVar2 != null) {
                view.setOnClickListener(new d(cVar2, view, i2));
                AppMethodBeat.o(255147);
                return;
            }
            AppMethodBeat.o(255147);
            return;
        }
        view.setOnClickListener(null);
        AppMethodBeat.o(255147);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$2$1"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ int oeZ;
        final /* synthetic */ c wrk;
        final /* synthetic */ View wrl;

        d(c cVar, View view, int i2) {
            this.wrk = cVar;
            this.wrl = view;
            this.oeZ = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255145);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c cVar = this.wrk;
            int i2 = this.oeZ;
            p.g(view, LocaleUtil.ITALIAN);
            cVar.f(i2, view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$onBindView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255145);
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a
    public final int getSize() {
        AppMethodBeat.i(255148);
        int size = this.oSb.size();
        AppMethodBeat.o(255148);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderFeedAlbumAdapter$AlbumHolder;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-finder_release"})
    public static final class a extends FinderFeedAlbumView.c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "view");
            AppMethodBeat.i(255144);
            AppMethodBeat.o(255144);
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a
    public final int Mm(int i2) {
        AppMethodBeat.i(255149);
        if (i2 == 0) {
            int i3 = this.oSb.get(i2).mediaType;
            AppMethodBeat.o(255149);
            return i3;
        }
        AppMethodBeat.o(255149);
        return 2;
    }
}
