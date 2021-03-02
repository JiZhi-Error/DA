package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nH&J\u001e\u0010\f\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nH&¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "", "remux", "", "setVideoBlendBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "setVideoBlendBitmapProvider", "blendBitmapProvider", "Lkotlin/Function1;", "", "setVideoBlurBgProvider", "blurBgProvider", "plugin-mediaeditor_release"})
public interface c {
    int aMG();

    void k(b<? super Long, Bitmap> bVar);

    void l(b<? super Long, Bitmap> bVar);
}
