package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "verticalHelper", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToCenter", "", "helper", "getHorizontalHelper", "getVerticalHelper", "Companion", "plugin-story_release"})
public final class i extends ak {
    public static final a FFS = new a((byte) 0);
    private static final String TAG = TAG;
    private aj hbL;
    private aj hbM;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120396);
        AppMethodBeat.o(120396);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (r0 != r8) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        if ((r1 != null ? r1.getLayoutManager() : null) != r8) goto L_0x0045;
     */
    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] a(android.support.v7.widget.RecyclerView.LayoutManager r8, android.view.View r9) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.i.a(android.support.v7.widget.RecyclerView$LayoutManager, android.view.View):int[]");
    }

    private static int a(RecyclerView.LayoutManager layoutManager, View view, aj ajVar) {
        int topDecorationHeight;
        int end;
        AppMethodBeat.i(120395);
        if (layoutManager.canScrollHorizontally()) {
            topDecorationHeight = layoutManager.getLeftDecorationWidth(view) + layoutManager.getRightDecorationWidth(view);
        } else {
            topDecorationHeight = layoutManager.getTopDecorationHeight(view) + layoutManager.getBottomDecorationHeight(view);
        }
        int bo = ajVar.bo(view) + ((ajVar.bs(view) - topDecorationHeight) / 2);
        if (layoutManager.getClipToPadding()) {
            end = ajVar.kH() + (ajVar.kJ() / 2);
        } else {
            end = ajVar.getEnd() / 2;
        }
        int i2 = bo - end;
        AppMethodBeat.o(120395);
        return i2;
    }
}
