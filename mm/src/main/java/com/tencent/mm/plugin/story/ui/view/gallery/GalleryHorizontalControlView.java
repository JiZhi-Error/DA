package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.a.a;
import com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView extends FrameLayout {
    private final a FEX;
    private final ArrayList<h> Fsh;
    private final RecyclerView gTW;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120347);
        this.Fsh = new ArrayList<>();
        View.inflate(context, R.layout.c05, this);
        View findViewById = findViewById(R.id.ian);
        p.g(findViewById, "findViewById(R.id.story_gallery_control_recycler)");
        this.gTW = (RecyclerView) findViewById;
        this.gTW.setLayoutManager(new IndicatorLayoutManager(context));
        this.FEX = new a();
        this.gTW.setAdapter(this.FEX);
        this.gTW.setFocusable(false);
        this.gTW.setVisibility(8);
        setPadding(0, 0, 0, au.aD(context));
        AppMethodBeat.o(120347);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120348);
        AppMethodBeat.o(120348);
    }

    public final void hw(List<h> list) {
        AppMethodBeat.i(120345);
        p.h(list, "items");
        this.Fsh.clear();
        this.Fsh.addAll(list);
        a aVar = this.FEX;
        ArrayList<h> arrayList = this.Fsh;
        p.h(arrayList, "items");
        aVar.Fsh.clear();
        aVar.Fsh.addAll(arrayList);
        this.FEX.notifyDataSetChanged();
        if (this.Fsh.size() <= 1) {
            this.gTW.setVisibility(8);
            AppMethodBeat.o(120345);
            return;
        }
        this.gTW.setVisibility(0);
        AppMethodBeat.o(120345);
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(120346);
        a aVar = this.FEX;
        if (aVar.va != i2) {
            aVar.ci(aVar.va);
            aVar.va = i2;
            aVar.ci(aVar.va);
        }
        RecyclerView recyclerView = this.gTW;
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(120346);
    }
}
