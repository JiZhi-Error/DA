package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPageControlView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView;", "Lcom/tencent/mm/ui/base/MMPageControlView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPageIndicatorStatusInterface", "Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "generatePageControl", "", "currentIndex", "", "setPageIndicatorStatusInterface", "pageControlInterface", "IPageIndicatorStatusInterface", "plugin-story_release"})
public final class StoryPageControlView extends MMPageControlView {
    private a FDU;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "", "isUnread", "", FirebaseAnalytics.b.INDEX, "", "plugin-story_release"})
    public interface a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(120285);
        AppMethodBeat.o(120285);
    }

    public final void setPageIndicatorStatusInterface(a aVar) {
        this.FDU = aVar;
    }

    @Override // com.tencent.mm.ui.base.MMPageControlView
    public final void Za(int i2) {
        AppMethodBeat.i(120284);
        super.Za(i2);
        int i3 = this.count;
        int i4 = 0;
        while (i4 < i3) {
            this.dKU = (ImageView) this.map.get(Integer.valueOf(i4));
            ImageView imageView = this.dKU;
            p.g(imageView, "imageView");
            imageView.setSelected(i2 == i4);
            i4++;
        }
        AppMethodBeat.o(120284);
    }
}
