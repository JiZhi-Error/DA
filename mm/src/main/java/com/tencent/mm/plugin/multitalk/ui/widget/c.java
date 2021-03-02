package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil;", "", "()V", "Companion", "plugin-multitalk_release"})
public final class c {
    public static final a zRp = new a((byte) 0);

    static {
        AppMethodBeat.i(178969);
        AppMethodBeat.o(178969);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil$Companion;", "", "()V", "inflateBigAvatarLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "clickListener", "Landroid/view/View$OnClickListener;", "startLoadingAnimation", "", "holder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "stopLoadingAnimation", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void g(b bVar) {
            Drawable drawable;
            Drawable drawable2;
            AppMethodBeat.i(178967);
            p.h(bVar, "holder");
            ImageView imageView = bVar.zhh;
            if (imageView != null) {
                drawable = imageView.getBackground();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                ImageView imageView2 = bVar.zhh;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                ImageView imageView3 = bVar.zhh;
                if (imageView3 != null) {
                    drawable2 = imageView3.getBackground();
                } else {
                    drawable2 = null;
                }
                if (drawable2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(178967);
                    throw tVar;
                }
                ((AnimationDrawable) drawable2).stop();
                ImageView imageView4 = bVar.zhh;
                Drawable background = imageView4 != null ? imageView4.getBackground() : null;
                if (background == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(178967);
                    throw tVar2;
                }
                ((AnimationDrawable) background).start();
            }
            AppMethodBeat.o(178967);
        }

        public static void h(b bVar) {
            Drawable drawable;
            Drawable drawable2 = null;
            AppMethodBeat.i(178968);
            p.h(bVar, "holder");
            ImageView imageView = bVar.zhh;
            if (imageView != null) {
                drawable = imageView.getBackground();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                ImageView imageView2 = bVar.zhh;
                if (imageView2 != null) {
                    drawable2 = imageView2.getBackground();
                }
                if (drawable2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(178968);
                    throw tVar;
                }
                ((AnimationDrawable) drawable2).stop();
            }
            ImageView imageView3 = bVar.zhh;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
                AppMethodBeat.o(178968);
                return;
            }
            AppMethodBeat.o(178968);
        }
    }
}
