package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\b\u0010\u0004\u001a\u00020\u0005H&J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "destroy", "", "invoke", "pts", "seekFrame", "timeMs", "start", "plugin-recordvideo_release"})
public interface c extends b<Long, Bitmap> {
    Bitmap Im(long j2);

    void destroy();

    void start();
}
