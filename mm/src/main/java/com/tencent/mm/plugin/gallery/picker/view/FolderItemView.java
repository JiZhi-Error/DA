package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\tJ,\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/gallery/picker/view/FolderItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "getLayoutId", "onCovert", "", "media", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "isSelected", "", "plugin-gallery_release"})
public final class FolderItemView extends FrameLayout {
    public b xlC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FolderItemView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164917);
        View inflate = aa.jQ(getContext()).inflate(getLayoutId(), this);
        p.g(inflate, "view");
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(164917);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FolderItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164918);
        View inflate = aa.jQ(getContext()).inflate(getLayoutId(), this);
        p.g(inflate, "view");
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(164918);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FolderItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164919);
        View inflate = aa.jQ(getContext()).inflate(getLayoutId(), this);
        p.g(inflate, "view");
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(164919);
    }

    public final b getHolder() {
        AppMethodBeat.i(164915);
        b bVar = this.xlC;
        if (bVar == null) {
            p.btv("holder");
        }
        AppMethodBeat.o(164915);
        return bVar;
    }

    public final void setHolder(b bVar) {
        AppMethodBeat.i(164916);
        p.h(bVar, "<set-?>");
        this.xlC = bVar;
        AppMethodBeat.o(164916);
    }

    public final int getLayoutId() {
        return R.layout.bol;
    }
}
