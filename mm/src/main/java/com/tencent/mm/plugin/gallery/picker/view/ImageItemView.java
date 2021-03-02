package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.ui.base.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/ImageItemView;", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$ImageMediaItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "onCovert", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "loader", "Lcom/tencent/mm/loader/Loader;", "covertType", "Companion", "plugin-gallery_release"})
public final class ImageItemView extends MediaItemView<GalleryItem.ImageMediaItem> {
    public static final a xmy = new a((byte) 0);

    static {
        AppMethodBeat.i(164924);
        AppMethodBeat.o(164924);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.base.a.b, com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem, com.tencent.mm.loader.d, int] */
    @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView
    public final /* synthetic */ void a(b bVar, GalleryItem.ImageMediaItem imageMediaItem, d<GalleryItem.ImageMediaItem> dVar, int i2) {
        AppMethodBeat.i(164920);
        GalleryItem.ImageMediaItem imageMediaItem2 = imageMediaItem;
        p.h(bVar, "holder");
        p.h(imageMediaItem2, "media");
        p.h(dVar, "loader");
        super.a(bVar, imageMediaItem2, dVar, i2);
        if (i2 == 0) {
            ImageView imageView = (ImageView) bVar.Mn(R.id.dwr);
            com.tencent.mm.loader.a.b<GalleryItem.ImageMediaItem, Bitmap> bP = dVar.bP(imageMediaItem2);
            p.g(imageView, "thumbIv");
            bP.c(imageView);
        }
        AppMethodBeat.o(164920);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/ImageItemView$Companion;", "", "()V", "TAG", "", "plugin-gallery_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gallery.picker.view.MediaItemView
    public final int getLayoutId() {
        return R.layout.bi3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageItemView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164921);
        AppMethodBeat.o(164921);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164922);
        AppMethodBeat.o(164922);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164923);
        AppMethodBeat.o(164923);
    }
}
