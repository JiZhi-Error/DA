package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0003BCDB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u00020\u000fJB\u00107\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010=J\b\u0010?\u001a\u000202H\u0014J\u0006\u0010@\u001a\u000202J\u0006\u0010A\u001a\u000202R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView extends LinearLayout {
    public static final b FAM = new b((byte) 0);
    ValueAnimator FAF;
    private ValueAnimator FAG;
    com.tencent.mm.plugin.story.f.b.a FAH;
    private boolean FAI;
    int FAJ;
    int FAK;
    int FAL;
    public ImageView jWS;
    public View maskView;
    public ViewGroup zhm;

    static {
        AppMethodBeat.i(120036);
        AppMethodBeat.o(120036);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120034);
        this.FAH = new com.tencent.mm.plugin.story.f.b.a();
        this.FAJ = com.tencent.mm.cb.a.fromDPToPix(context, 48);
        AppMethodBeat.o(120034);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120035);
        AppMethodBeat.o(120035);
    }

    public final ValueAnimator getNormalAnimator() {
        return this.FAF;
    }

    public final void setNormalAnimator(ValueAnimator valueAnimator) {
        this.FAF = valueAnimator;
    }

    public final ValueAnimator getNormalBgAnimator() {
        return this.FAG;
    }

    public final void setNormalBgAnimator(ValueAnimator valueAnimator) {
        this.FAG = valueAnimator;
    }

    public final View getMaskView() {
        AppMethodBeat.i(120026);
        View view = this.maskView;
        if (view == null) {
            p.btv("maskView");
        }
        AppMethodBeat.o(120026);
        return view;
    }

    public final void setMaskView(View view) {
        AppMethodBeat.i(120027);
        p.h(view, "<set-?>");
        this.maskView = view;
        AppMethodBeat.o(120027);
    }

    public final ImageView getAvatarView() {
        AppMethodBeat.i(120028);
        ImageView imageView = this.jWS;
        if (imageView == null) {
            p.btv("avatarView");
        }
        AppMethodBeat.o(120028);
        return imageView;
    }

    public final void setAvatarView(ImageView imageView) {
        AppMethodBeat.i(120029);
        p.h(imageView, "<set-?>");
        this.jWS = imageView;
        AppMethodBeat.o(120029);
    }

    public final ViewGroup getContentLayout() {
        AppMethodBeat.i(120030);
        ViewGroup viewGroup = this.zhm;
        if (viewGroup == null) {
            p.btv("contentLayout");
        }
        AppMethodBeat.o(120030);
        return viewGroup;
    }

    public final void setContentLayout(ViewGroup viewGroup) {
        AppMethodBeat.i(120031);
        p.h(viewGroup, "<set-?>");
        this.zhm = viewGroup;
        AppMethodBeat.o(120031);
    }

    public final com.tencent.mm.plugin.story.f.b.a getComment() {
        return this.FAH;
    }

    public final void setComment(com.tencent.mm.plugin.story.f.b.a aVar) {
        AppMethodBeat.i(120032);
        p.h(aVar, "<set-?>");
        this.FAH = aVar;
        AppMethodBeat.o(120032);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(120033);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.i7z);
        if (findViewById == null) {
            findViewById = findViewById(R.id.i86);
        }
        if (findViewById == null) {
            this.maskView = this;
        } else {
            this.maskView = findViewById;
        }
        View findViewById2 = findViewById(R.id.i8j);
        p.g(findViewById2, "findViewById(R.id.story_comment_item_avatar)");
        this.jWS = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.i8n);
        p.g(findViewById3, "findViewById(R.id.story_…ment_item_content_layout)");
        this.zhm = (ViewGroup) findViewById3;
        AppMethodBeat.o(120033);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CommentItemView FAS;
        final /* synthetic */ int FAT;
        final /* synthetic */ int FAU;
        final /* synthetic */ float FAV = 0.1f;
        final /* synthetic */ z.f FAW;
        final /* synthetic */ kotlin.g.a.a FAX;

        e(CommentItemView commentItemView, int i2, int i3, z.f fVar, kotlin.g.a.a aVar) {
            this.FAS = commentItemView;
            this.FAT = i2;
            this.FAU = i3;
            this.FAW = fVar;
            this.FAX = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120025);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(120025);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            int i2 = (int) (((float) (this.FAT - this.FAU)) * (1.0f - floatValue));
            this.FAS.setTranslationY((float) i2);
            if (floatValue < this.FAV) {
                this.FAS.setScaleX(floatValue / this.FAV);
                this.FAS.setScaleY(floatValue / this.FAV);
                this.FAS.setAlpha(((floatValue / this.FAV) * 0.5f) + 0.5f);
            } else {
                this.FAS.setScaleX(1.0f);
                this.FAS.setScaleY(1.0f);
                this.FAS.setAlpha(1.0f);
                T t = this.FAW.SYG;
                if (t != null) {
                    t.invoke();
                }
                this.FAW.SYG = null;
                if (!this.FAS.FAI) {
                    this.FAS.FAI = true;
                    CommentItemView commentItemView = this.FAS;
                    long j2 = 0;
                    if (!commentItemView.FAH.FnX) {
                        ValueAnimator ofFloat = ObjectAnimator.ofFloat(0.0f, 1.0f);
                        ofFloat.addUpdateListener(new d(commentItemView));
                        p.g(ofFloat, "sizeAnimator");
                        ofFloat.setDuration(300L);
                        ofFloat.start();
                        j2 = 300;
                    } else {
                        ViewGroup.LayoutParams layoutParams = commentItemView.getLayoutParams();
                        layoutParams.width = commentItemView.FAL;
                        layoutParams.height = commentItemView.FAK;
                        commentItemView.setLayoutParams(layoutParams);
                    }
                    ViewGroup viewGroup = commentItemView.zhm;
                    if (viewGroup == null) {
                        p.btv("contentLayout");
                    }
                    viewGroup.setVisibility(0);
                    ViewGroup viewGroup2 = commentItemView.zhm;
                    if (viewGroup2 == null) {
                        p.btv("contentLayout");
                    }
                    viewGroup2.setAlpha(0.0f);
                    ViewGroup viewGroup3 = commentItemView.zhm;
                    if (viewGroup3 == null) {
                        p.btv("contentLayout");
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup3, "alpha", 0.0f, 1.0f);
                    p.g(ofFloat2, "contentLayoutAnim");
                    ofFloat2.setStartDelay(j2);
                    ofFloat2.setDuration(100L);
                    ofFloat2.start();
                }
            }
            if (i2 < 100) {
                this.FAS.setAlpha(((float) i2) / 100.0f);
            }
            if (this.FAS.getAlpha() < 0.05f) {
                ValueAnimator normalAnimator = this.FAS.getNormalAnimator();
                if (normalAnimator != null) {
                    normalAnimator.removeAllUpdateListeners();
                }
                kotlin.g.a.a aVar = this.FAX;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(120025);
                    return;
                }
            }
            AppMethodBeat.o(120025);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ CommentItemView FAS;

        d(CommentItemView commentItemView) {
            this.FAS = commentItemView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120024);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(120024);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ViewGroup.LayoutParams layoutParams = this.FAS.getLayoutParams();
            layoutParams.width = this.FAS.FAJ + ((int) (((float) (this.FAS.FAL - this.FAS.FAJ)) * floatValue));
            layoutParams.height = ((int) (floatValue * ((float) (this.FAS.FAK - this.FAS.FAJ)))) + this.FAS.FAJ;
            this.FAS.setLayoutParams(layoutParams);
            AppMethodBeat.o(120024);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
    public static final class c implements Interpolator {
        private final float FAN = 0.2f;
        private final PointF FAO = new PointF(this.FAQ.x * (1.0f - this.FAN), this.FAQ.y * (1.0f - this.FAN));
        private final PointF FAP = new PointF(this.FAQ.x + ((1.0f - this.FAQ.x) * this.FAN), this.FAQ.y + ((1.0f - this.FAQ.y) * this.FAN));
        private final PointF FAQ;

        public c(PointF pointF) {
            p.h(pointF, "divide");
            AppMethodBeat.i(120023);
            this.FAQ = pointF;
            AppMethodBeat.o(120023);
        }

        public final float getInterpolation(float f2) {
            if (f2 < this.FAO.x) {
                return (this.FAQ.y * f2) / this.FAQ.x;
            }
            if (f2 < this.FAP.x) {
                return this.FAO.y + (((f2 - this.FAO.x) / (this.FAP.x - this.FAO.x)) * (this.FAP.y - this.FAO.y));
            }
            return this.FAQ.y + (((f2 - this.FAQ.x) / (1.0f - this.FAQ.x)) * (1.0f - this.FAQ.y));
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
    public static final class a implements TypeEvaluator<Object> {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f2, Object obj, Object obj2) {
            AppMethodBeat.i(120022);
            p.h(obj, "startValue");
            p.h(obj2, "endValue");
            int intValue = ((Integer) obj).intValue();
            float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
            int intValue2 = ((Integer) obj2).intValue();
            float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
            float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
            float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
            float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
            float pow5 = (float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d);
            int round = Math.round(((float) Math.pow((double) (pow3 + ((((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3) * f2)), 0.45454545454545453d)) * 255.0f);
            Integer valueOf = Integer.valueOf(round | (Math.round((f3 + (((((float) ((intValue2 >> 24) & 255)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (pow + ((pow4 - pow) * f2)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(((float) Math.pow((double) (pow2 + ((pow5 - pow2) * f2)), 0.45454545454545453d)) * 255.0f) << 8));
            AppMethodBeat.o(120022);
            return valueOf;
        }
    }
}
