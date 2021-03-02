package com.tencent.mm.loader.e;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.loader.e.b.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016J\u0016\u0010\u0012\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016R \u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/loader/impr/DefaultImageLoaderAnimation;", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "animation", "Landroid/view/animation/Animation;", "animTarget", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Landroid/view/animation/Animation;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimTarget", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setAnimTarget", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimation", "()Landroid/view/animation/Animation;", "setAnimation", "(Landroid/view/animation/Animation;)V", "onLoadCompleted", "", "holder", "onLoadStart", "libimageloader_release"})
public final class d implements com.tencent.mm.loader.f.d {
    Animation FN;
    g<?> iah;

    public d() {
        this(null, null, 3);
    }

    private d(Animation animation, g<?> gVar) {
        p.h(animation, "animation");
        this.FN = animation;
        this.iah = gVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Animation animation, g gVar, int i2) {
        this((i2 & 1) != 0 ? new AlphaAnimation(0.0f, 1.0f) : animation, (i2 & 2) != 0 ? null : gVar);
    }

    @Override // com.tencent.mm.loader.f.d
    public final void a(g<?> gVar) {
        com.tencent.mm.ac.d.h(new a(this, gVar));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d iai;
        final /* synthetic */ g iaj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, g gVar) {
            super(0);
            this.iai = dVar;
            this.iaj = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            final g<?> gVar;
            View view;
            this.iai.FN.setDuration(320);
            g<?> gVar2 = this.iai.iah;
            if (gVar2 == null) {
                gVar = this.iaj;
            } else {
                gVar = gVar2;
            }
            this.iai.FN.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.loader.e.d.a.AnonymousClass1 */

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    View view;
                    g gVar = gVar;
                    if (gVar != null && (view = gVar.getView()) != null) {
                        view.setAlpha(1.0f);
                    }
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            if (!(gVar == null || (view = gVar.getView()) == null)) {
                view.startAnimation(this.iai.FN);
            }
            return x.SXb;
        }
    }
}
