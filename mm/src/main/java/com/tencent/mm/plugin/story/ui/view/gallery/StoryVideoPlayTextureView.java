package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPlayTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "seekTo", "time", "", "plugin-story_release"})
public final class StoryVideoPlayTextureView extends VideoPlayerTextureView {
    public StoryVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.i(120530);
        setScaleType(i.e.COVER);
        AppMethodBeat.o(120530);
    }

    public StoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(120531);
        setScaleType(i.e.COVER);
        AppMethodBeat.o(120531);
    }

    public StoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(120532);
        setScaleType(i.e.COVER);
        AppMethodBeat.o(120532);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(120527);
        setScaleType(i.e.COVER);
        if (this.Kwz == 90 || this.Kwz == 270) {
            if (this.mVideoHeight > this.mVideoWidth) {
                this.pMX.a(i.e.DEFAULT);
            }
        } else if (this.mVideoWidth > this.mVideoHeight) {
            this.pMX.a(i.e.DEFAULT);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(120527);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView, com.tencent.mm.pluginsdk.ui.tools.j
    public final void q(double d2) {
        AppMethodBeat.i(120528);
        if (this.ZA) {
            super.q(d2);
            AppMethodBeat.o(120528);
            return;
        }
        Log.printInfoStack("MicroMsg.VideoPlayerTextureView", hashCode() + " error seekTo " + this.ZA + ' ', new Object[0]);
        AppMethodBeat.o(120528);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
    public final void l(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(120529);
        super.l(surfaceTexture);
        this.rso.fh(getCurrentPosition(), getDuration());
        AppMethodBeat.o(120529);
    }
}
