package com.tencent.mm.plugin.gallery.picker.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.gallery.picker.view.FolderItemView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003#$%B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001eH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Lcom/tencent/mm/loader/Loader;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;)V", "onItemLongClickListener", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "getOnItemLongClickListener", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "setOnItemLongClickListener", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;)V", "selectedFolder", "getSelectedFolder", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "setSelectedFolder", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;)V", "onBindViewHolder", "", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "position", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemClickListener", "OnItemClickListener", "OnItemLongClickListener", "plugin-gallery_release"})
public final class b extends com.tencent.mm.ui.base.a.a<GalleryItem.AlbumItem, FolderItemView> {
    private d<GalleryItem.MediaItem> gVG;
    public AbstractC1387b xkH;
    c xkI;
    GalleryItem.AlbumItem xkJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemClickListener;", "", "onItemClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
    /* renamed from: com.tencent.mm.plugin.gallery.picker.a.b$b  reason: collision with other inner class name */
    public interface AbstractC1387b {
        void a(GalleryItem.AlbumItem albumItem);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "plugin-gallery_release"})
    public interface c {
        boolean dRB();
    }

    public b(d<GalleryItem.MediaItem> dVar) {
        p.h(dVar, "loader");
        AppMethodBeat.i(164868);
        this.gVG = dVar;
        AppMethodBeat.o(164868);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
        AppMethodBeat.i(164867);
        a(bVar, i2);
        AppMethodBeat.o(164867);
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.tencent.mm.ui.base.a.a
    public final /* synthetic */ FolderItemView l(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(164865);
        p.h(viewGroup, "parent");
        Context context = viewGroup.getContext();
        p.g(context, "parent.context");
        FolderItemView folderItemView = new FolderItemView(context);
        AppMethodBeat.o(164865);
        return folderItemView;
    }

    @Override // com.tencent.mm.ui.base.a.a
    public final void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
        int i3;
        AppMethodBeat.i(164866);
        p.h(bVar, "viewHolder");
        FolderItemView folderItemView = (FolderItemView) bVar.getView();
        folderItemView.setOnClickListener(new a(this, bVar));
        Object obj = this.cvc.get(i2);
        p.g(obj, "mItems[position]");
        GalleryItem.AlbumItem albumItem = (GalleryItem.AlbumItem) obj;
        d<GalleryItem.MediaItem> dVar = this.gVG;
        boolean j2 = p.j(this.xkJ, (GalleryItem.AlbumItem) this.cvc.get(i2));
        p.h(bVar, "holder");
        p.h(albumItem, "media");
        p.h(dVar, "loader");
        folderItemView.xlC = bVar;
        View Mn = bVar.Mn(R.id.d7v);
        Context context = bVar.getContext();
        p.g(context, "holder.context");
        Mn.setBackgroundColor(context.getResources().getColor(R.color.a2h));
        bVar.e(R.id.d7p, albumItem.albumName);
        bVar.e(R.id.d7l, String.valueOf(albumItem.dJl));
        bVar.mf(R.id.d7l, 0);
        ImageView imageView = (ImageView) bVar.Mn(R.id.d7u);
        p.g(imageView, "thumbView");
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GalleryItem.MediaItem hVO = albumItem.hVO();
        p.g(hVO, "media.mediaItem");
        dVar.bP(hVO).c(imageView);
        if (!j2) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        bVar.mf(R.id.d7t, i3);
        AppMethodBeat.o(164866);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "viewHolder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter;Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "onClick", "", "v", "Landroid/view/View;", "onLongClick", "", "plugin-gallery_release"})
    public final class a implements View.OnClickListener, View.OnLongClickListener {
        private final com.tencent.mm.ui.base.a.b xkK;
        final /* synthetic */ b xkL;

        public a(b bVar, com.tencent.mm.ui.base.a.b bVar2) {
            p.h(bVar2, "viewHolder");
            this.xkL = bVar;
            AppMethodBeat.i(164864);
            this.xkK = bVar2;
            AppMethodBeat.o(164864);
        }

        public final boolean onLongClick(View view) {
            boolean z;
            AppMethodBeat.i(164862);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            p.h(view, "v");
            c cVar = this.xkL.xkI;
            if (cVar != null) {
                p.g(this.xkL.cvc.get(this.xkK.lR()), "mItems[viewHolder.adapterPosition]");
                z = cVar.dRB();
            } else {
                z = false;
            }
            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(164862);
            return z;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(164863);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.h(view, "v");
            this.xkL.xkJ = (GalleryItem.AlbumItem) this.xkL.cvc.get(this.xkK.lR());
            AbstractC1387b bVar2 = this.xkL.xkH;
            if (bVar2 != null) {
                GalleryItem.AlbumItem albumItem = this.xkL.xkJ;
                if (albumItem == null) {
                    p.hyc();
                }
                bVar2.a(albumItem);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerFolderAdapter$ItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(164863);
        }
    }
}
