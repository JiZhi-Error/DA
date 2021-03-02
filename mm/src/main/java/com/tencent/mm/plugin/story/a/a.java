package com.tencent.mm.plugin.story.a;

import android.animation.AnimatorSet;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\rJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH$J\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u0018J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010.\u001a\u00020\u0018R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "", "()V", "<set-?>", "Landroid/animation/AnimatorSet;", "animatorAgent", "getAnimatorAgent", "()Landroid/animation/AnimatorSet;", "isRunning", "", "()Z", "isStarted", "mDuration", "", "mRepeatMode", "", "mRepeatTimes", "startDelay", "getStartDelay", "()J", "addAnimatorListener", "l", "Landroid/animation/Animator$AnimatorListener;", "animate", "", "cancel", "getDuration", "prepare", "target", "Landroid/view/View;", "removeAllListener", "removeAnimatorListener", "reset", "restart", "setDuration", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "setInterpolator", "interpolator", "Landroid/view/animation/Interpolator;", "setRepeatMode", "repeatMode", "setRepeatTimes", "repeatTimes", "setStartDelay", "delay", "setTarget", "start", "Companion", "plugin-story_release"})
public abstract class a {
    public static final C1742a Fks = new C1742a((byte) 0);
    private static final long lZa = 1000;
    public AnimatorSet Fkp = new AnimatorSet();
    public int Fkq;
    public int Fkr = 1;
    public long mDuration = lZa;

    /* access modifiers changed from: protected */
    public abstract void fN(View view);

    public final a fO(View view) {
        p.h(view, "target");
        p.h(view, "target");
        u.g(view, 1.0f);
        u.h(view, 1.0f);
        u.i(view, 1.0f);
        u.e(view, 0.0f);
        u.f(view, 0.0f);
        u.ai(view);
        u.ak(view);
        u.aj(view);
        fN(view);
        return this;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator$Companion;", "", "()V", "DURATION", "", "getDURATION", "()J", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.a.a$a  reason: collision with other inner class name */
    public static final class C1742a {
        private C1742a() {
        }

        public /* synthetic */ C1742a(byte b2) {
            this();
        }
    }
}
