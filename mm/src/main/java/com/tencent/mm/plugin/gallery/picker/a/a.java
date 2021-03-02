package com.tencent.mm.plugin.gallery.picker.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.view.ImageItemView;
import com.tencent.mm.plugin.gallery.picker.view.MediaItemView;
import com.tencent.mm.plugin.gallery.picker.view.VideoItemView;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004<=>?BG\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/H\u0016J&\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010.\u001a\u00020/2\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0016J\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020/H\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\nj\b\u0012\u0004\u0012\u00020\u0002`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/loader/Loader;Ljava/util/HashSet;Ljava/util/ArrayList;)V", "isMultiSelectedMode", "", "()Z", "setMultiSelectedMode", "(Z)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "getItemId", "", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class a extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, MediaItemView<GalleryItem.MediaItem>> {
    public static final C1386a xkF = new C1386a((byte) 0);
    private com.tencent.mm.loader.d<GalleryItem.MediaItem> gVG;
    public ArrayList<GalleryItem.MediaItem> hXI;
    public c xkB;
    public d xkC;
    public MediaItemView.b<GalleryItem.MediaItem> xkD;
    public HashSet<GalleryItem.MediaItem> xkE;
    public boolean xkm;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
    public interface c {
        void e(GalleryItem.MediaItem mediaItem);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "plugin-gallery_release"})
    public interface d {
        boolean d(GalleryItem.MediaItem mediaItem);
    }

    static {
        AppMethodBeat.i(164861);
        AppMethodBeat.o(164861);
    }

    public /* synthetic */ a(com.tencent.mm.loader.d dVar, ArrayList arrayList) {
        this(dVar, new HashSet(), arrayList);
        AppMethodBeat.i(164860);
        AppMethodBeat.o(164860);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2, List list) {
        AppMethodBeat.i(164858);
        a(bVar, i2, (List<Object>) list);
        AppMethodBeat.o(164858);
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.tencent.mm.ui.base.a.a
    public final /* synthetic */ MediaItemView<GalleryItem.MediaItem> l(ViewGroup viewGroup, int i2) {
        MediaItemView videoItemView;
        AppMethodBeat.i(164855);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                Context context = viewGroup.getContext();
                p.g(context, "parent.context");
                videoItemView = new ImageItemView(context);
                break;
            case 2:
                Context context2 = viewGroup.getContext();
                p.g(context2, "parent.context");
                videoItemView = new VideoItemView(context2);
                break;
            default:
                Context context3 = viewGroup.getContext();
                p.g(context3, "parent.context");
                videoItemView = new ImageItemView(context3);
                break;
        }
        com.tencent.mm.loader.d<T> dVar = (com.tencent.mm.loader.d<T>) this.gVG;
        HashSet<T> hashSet = (HashSet<T>) this.xkE;
        ArrayList<T> arrayList = (ArrayList<T>) this.hXI;
        p.h(dVar, "loader");
        p.h(hashSet, "selectedSet");
        p.h(arrayList, "selectedList");
        p.h(this, "adapter");
        videoItemView.xkc = this;
        videoItemView.gVG = dVar;
        videoItemView.xkE = hashSet;
        videoItemView.hXI = arrayList;
        View inflate = aa.jQ(videoItemView.getContext()).inflate(videoItemView.getLayoutId(), videoItemView);
        Resources resources = videoItemView.getResources();
        p.g(resources, "resources");
        float f2 = ((float) (resources.getDisplayMetrics().widthPixels / 4)) - 8.0f;
        p.g(inflate, "contentView");
        inflate.setLayoutParams(new FrameLayout.LayoutParams((int) f2, (int) f2));
        View findViewById = inflate.findViewById(R.id.fc0);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.fbe);
        checkBox.setOnCheckedChangeListener(new MediaItemView.e(videoItemView, hashSet, arrayList, dVar));
        findViewById.setOnClickListener(new MediaItemView.f(checkBox));
        View.OnClickListener bVar = new b(this, (RecyclerView) viewGroup);
        videoItemView.setOnClickListener(bVar);
        videoItemView.setOnItemMediaSelectedListener((MediaItemView.b) bVar);
        MediaItemView mediaItemView = videoItemView;
        AppMethodBeat.o(164855);
        return mediaItemView;
    }

    private a(com.tencent.mm.loader.d<GalleryItem.MediaItem> dVar, HashSet<GalleryItem.MediaItem> hashSet, ArrayList<GalleryItem.MediaItem> arrayList) {
        p.h(dVar, "loader");
        p.h(hashSet, "selectedSet");
        p.h(arrayList, "selectedList");
        AppMethodBeat.i(164859);
        this.gVG = dVar;
        this.xkE = hashSet;
        this.hXI = arrayList;
        this.xkm = true;
        au(true);
        AppMethodBeat.o(164859);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$Companion;", "", "()V", "NOTIFY_CHANGE_MASK", "", "NOTIFY_CHANGE_NORMAL", "NOTIFY_CHANGE_NUM", "plugin-gallery_release"})
    /* renamed from: com.tencent.mm.plugin.gallery.picker.a.a$a  reason: collision with other inner class name */
    public static final class C1386a {
        private C1386a() {
        }

        public /* synthetic */ C1386a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        AppMethodBeat.i(164856);
        long j2 = ((GalleryItem.MediaItem) this.cvc.get(i2)).xiZ;
        AppMethodBeat.o(164856);
        return j2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(164857);
        Object itemAtPosition = getItemAtPosition(i2);
        p.g(itemAtPosition, "getItemAtPosition(position)");
        int type = ((GalleryItem.MediaItem) itemAtPosition).getType();
        AppMethodBeat.o(164857);
        return type;
    }

    @Override // com.tencent.mm.ui.base.a.a
    public final void a(com.tencent.mm.ui.base.a.b bVar, int i2, List<Object> list) {
        AppMethodBeat.i(257768);
        p.h(bVar, "holder");
        p.h(list, "payloads");
        MediaItemView mediaItemView = (MediaItemView) bVar.getView();
        if (list.size() > 0) {
            Object obj = this.cvc.get(i2);
            p.g(obj, "mItems[position]");
            GalleryItem.MediaItem mediaItem = (GalleryItem.MediaItem) obj;
            com.tencent.mm.loader.d<GalleryItem.MediaItem> dVar = this.gVG;
            Object ks = j.ks(list);
            if (ks == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(257768);
                throw tVar;
            }
            mediaItemView.a(bVar, mediaItem, dVar, ((Integer) ks).intValue());
            AppMethodBeat.o(257768);
            return;
        }
        Object obj2 = this.cvc.get(i2);
        p.g(obj2, "mItems[position]");
        mediaItemView.a(bVar, (GalleryItem.MediaItem) obj2, this.gVG, 0);
        AppMethodBeat.o(257768);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;Landroid/support/v7/widget/RecyclerView;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "onMediaSelected", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "onMediaUnSelected", "plugin-gallery_release"})
    public final class b implements View.OnClickListener, View.OnLongClickListener, MediaItemView.b<GalleryItem.MediaItem> {
        private final RecyclerView hak;
        final /* synthetic */ a xkG;

        public b(a aVar, RecyclerView recyclerView) {
            p.h(recyclerView, "recyclerView");
            this.xkG = aVar;
            AppMethodBeat.i(164854);
            this.hak = recyclerView;
            AppMethodBeat.o(164854);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.base.a.b, java.lang.Object] */
        @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b
        public final /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(164850);
            GalleryItem.MediaItem mediaItem2 = mediaItem;
            p.h(bVar, "holder");
            p.h(mediaItem2, "media");
            MediaItemView.b<GalleryItem.MediaItem> bVar2 = this.xkG.xkD;
            if (bVar2 != null) {
                bVar2.a(bVar, mediaItem2);
                AppMethodBeat.o(164850);
                return;
            }
            AppMethodBeat.o(164850);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.base.a.b, java.lang.Object] */
        @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView.b
        public final /* synthetic */ void b(com.tencent.mm.ui.base.a.b bVar, GalleryItem.MediaItem mediaItem) {
            AppMethodBeat.i(164851);
            GalleryItem.MediaItem mediaItem2 = mediaItem;
            p.h(bVar, "holder");
            p.h(mediaItem2, "media");
            MediaItemView.b<GalleryItem.MediaItem> bVar2 = this.xkG.xkD;
            if (bVar2 != null) {
                bVar2.b(bVar, mediaItem2);
                AppMethodBeat.o(164851);
                return;
            }
            AppMethodBeat.o(164851);
        }

        public final boolean onLongClick(View view) {
            boolean z;
            AppMethodBeat.i(164852);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            p.h(view, "v");
            RecyclerView.v bu = this.hak.bu(view);
            if (bu == null) {
                p.hyc();
            }
            p.g(bu, "recyclerView.findContainingViewHolder(v)!!");
            d dVar = this.xkG.xkC;
            if (dVar != null) {
                Object obj = this.xkG.cvc.get(bu.lR());
                p.g(obj, "mItems[holder.adapterPosition]");
                z = dVar.d((GalleryItem.MediaItem) obj);
            } else {
                z = false;
            }
            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(164852);
            return z;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164853);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.h(view, "v");
            RecyclerView.v bu = this.hak.bu(view);
            if (bu == null) {
                p.hyc();
            }
            p.g(bu, "recyclerView.findContainingViewHolder(v)!!");
            c cVar = this.xkG.xkB;
            if (cVar != null) {
                Object obj = this.xkG.cvc.get(bu.lR());
                p.g(obj, "mItems[holder.adapterPosition]");
                cVar.e((GalleryItem.MediaItem) obj);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164853);
        }
    }
}
