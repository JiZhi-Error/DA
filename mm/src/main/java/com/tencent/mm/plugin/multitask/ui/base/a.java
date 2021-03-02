package com.tencent.mm.plugin.multitask.ui.base;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/IMultiTaskView;", "", "getView", "Landroid/view/View;", "setBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "plugin-multitask_release"})
public interface a {
    View getView();

    void setBitmap(Bitmap bitmap);
}
