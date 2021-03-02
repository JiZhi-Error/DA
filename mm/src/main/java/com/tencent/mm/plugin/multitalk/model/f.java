package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0006H&¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "", "drawAvatar", "", "drawBitmap", "userName", "", "bm", "Landroid/graphics/Bitmap;", "angle", "", "mirror", "getAvatarIv", "Landroid/widget/ImageView;", "getUsername", "plugin-multitalk_release"})
public interface f {
    void a(String str, Bitmap bitmap, int i2, int i3);

    void emz();

    ImageView getAvatarIv();

    String getUsername();
}
