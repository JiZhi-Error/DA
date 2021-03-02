package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryBubbleListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
public final class StoryBubbleListView extends RelativeLayout {
    private final RecyclerView FBC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryBubbleListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120087);
        View.inflate(context, R.layout.c0m, this);
        View findViewById = findViewById(R.id.ic4);
        p.g(findViewById, "findViewById(R.id.story_msg_recycler_view)");
        this.FBC = (RecyclerView) findViewById;
        AppMethodBeat.o(120087);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryBubbleListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120088);
        AppMethodBeat.o(120088);
    }
}
