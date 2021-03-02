package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.view.View;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H$J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H$J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/BaseViewAnimationHandler;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "hideAnimator", "Landroid/animation/Animator;", "getHideAnimator", "()Landroid/animation/Animator;", "setHideAnimator", "(Landroid/animation/Animator;)V", "isHiding", "", "()Z", "isShowing", "showAnimator", "getShowAnimator", "setShowAnimator", "getTargetView", "()Landroid/view/View;", "setTargetView", "cancelAnimations", "", "createHideAnimationSet", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "createShowAnimationSet", "playHideAnimation", "playShowAnimation", "Companion", "plugin-multitask_release"})
public abstract class a {
    public static final C1512a Aai = new C1512a((byte) 0);
    private View targetView;

    public a(View view) {
        this.targetView = view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/BaseViewAnimationHandler$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.swipeahead.a$a  reason: collision with other inner class name */
    public static final class C1512a {
        private C1512a() {
        }

        public /* synthetic */ C1512a(byte b2) {
            this();
        }
    }
}
