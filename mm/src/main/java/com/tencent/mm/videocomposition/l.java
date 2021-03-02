package com.tencent.mm.videocomposition;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 15}, hxE = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\r\u001a\n\u0010\f\u001a\u00020\u000e*\u00020\u000e\u001a\u0014\u0010\f\u001a\u00020\u000f*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0016\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u0016¨\u0006\u001b"}, hxF = {"saveTexture", "Landroid/graphics/Bitmap;", "texture", "", "width", "height", "centerCrop", "", "Landroid/graphics/Rect;", "target", "targetWidth", "targetHeight", "copy", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "Lcom/tencent/mm/videocomposition/TrackTransition;", "Lcom/tencent/mm/videocomposition/VideoComposition;", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "scale", "", "toFloatArray", "", "Lorg/json/JSONArray;", "toIntArray", "", "toLongArray", "", "video_composition_release"})
public final class l {
    public static final void c(Rect rect, Rect rect2) {
        AppMethodBeat.i(216763);
        p.h(rect, "$this$centerCrop");
        p.h(rect2, "target");
        float width = (((float) rect2.width()) * 1.0f) / ((float) rect.width());
        float height = (((float) rect2.height()) * 1.0f) / ((float) rect.height());
        if (width > height) {
            int height2 = (int) (((width * ((float) rect.height())) - ((float) rect2.height())) / 2.0f);
            rect.set(rect2);
            rect.top -= height2;
            rect.bottom = height2 + rect.bottom;
            AppMethodBeat.o(216763);
            return;
        }
        int width2 = (int) (((((float) rect.width()) * height) - ((float) rect2.width())) / 2.0f);
        rect.set(rect2);
        rect.left -= width2;
        rect.right = width2 + rect.right;
        AppMethodBeat.o(216763);
    }
}
