package com.tencent.mm.plugin.mv.a;

import android.animation.Animator;
import android.graphics.Point;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a$\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, hxF = {"captureAnimationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "Landroid/view/View;", "transitionTo", "Landroid/animation/Animator;", "Landroid/widget/ImageView;", "to", "animateView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "plugin-mv_release"})
public final class g {
    public static final Animator a(ImageView imageView, View view, ImageView imageView2, boolean z) {
        AppMethodBeat.i(256795);
        p.h(imageView, "$this$transitionTo");
        p.h(view, "to");
        p.h(imageView2, "animateView");
        Animator a2 = eC(imageView).a(eC(view), imageView2, z);
        AppMethodBeat.o(256795);
        return a2;
    }

    public static final f eC(View view) {
        AppMethodBeat.i(256796);
        p.h(view, "$this$captureAnimationInfo");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        f fVar = new f(view instanceof ImageView ? ((ImageView) view).getDrawable() : null, new Point(iArr[0], iArr[1]), new Size(view.getWidth(), view.getHeight()));
        AppMethodBeat.o(256796);
        return fVar;
    }
}
