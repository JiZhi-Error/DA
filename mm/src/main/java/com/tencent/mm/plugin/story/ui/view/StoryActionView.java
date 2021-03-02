package com.tencent.mm.plugin.story.ui.view;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001IB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u001bH\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00107\u001a\u00020\u001bH\u0002J\u0010\u00109\u001a\u00020'2\u0006\u00107\u001a\u00020\u001bH\u0002J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\tH\u0002J\u0006\u0010<\u001a\u00020'J\u000e\u0010=\u001a\u00020'2\u0006\u0010&\u001a\u00020\tJ\u000e\u0010>\u001a\u00020'2\u0006\u0010&\u001a\u00020\tJ\u000e\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\tJ\u001e\u0010A\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\tJ\u000e\u0010D\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u001bH\u0002J\u000e\u0010H\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R7\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SCROLL_DIRECTION_L2R", "SCROLL_DIRECTION_R2L", "TAG", "", "TEXT_MAX_COLOR", "TEXT_MAX_SIZE", "", "TEXT_MIN_COLOR", "TEXT_MIN_SIZE", "TIP_ICON_REPLACE", "TIP_ICON_SPACE", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "commentOtherView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "commentTipTv", "Landroid/widget/TextView;", "curIndex", "isOpenList", "", "isSelf", "lastOffset", "likeTipTv", "onActionClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.b.INDEX, "", "getOnActionClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActionClicked", "(Lkotlin/jvm/functions/Function1;)V", "otherGroup", "Landroid/view/View;", "readyAnimation", "scrollDirection", "scrollState", "selfGroup", "tipGroup", "Landroid/widget/LinearLayout;", "tipSpan", "Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "animateToFocus", "textView", "animateToNormal", "animateToUnfocus", "needTipIcon", "tipIndex", "onMsgClosed", "onMsgOpened", "onPageChanged", "onPageChangedState", "state", "onPageChanging", "offset", "p2", "setup", "showTipIcon", "show", "view", "upadteComment", "StoryTipImageSpan", "plugin-story_release"})
public final class StoryActionView extends RelativeLayout {
    int EOS;
    final float FBg;
    final float FBh;
    final int FBi;
    final int FBj;
    final int FBk;
    final int FBl;
    private final String FBm;
    private final String FBn;
    final TextView FBo;
    final TextView FBp;
    private final LinearLayout FBq;
    private final StoryCommentBubbleView FBr;
    private final View FBs;
    final View FBt;
    boolean FBu;
    float FBv;
    boolean FBw;
    private final a FBx;
    private kotlin.g.a.b<? super Integer, x> FBy;
    com.tencent.mm.plugin.story.f.d.g FoU;
    final String TAG;
    boolean dJM;
    int sTB;
    int vp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryActionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120079);
        this.TAG = "MicroMsg.StoryActionView";
        this.FBg = (float) at.fromDPToPix(context, 17);
        this.FBh = (float) at.fromDPToPix(context, 14);
        this.FBi = Color.parseColor("#FFFFFFFF");
        this.FBj = Color.parseColor("#7FFFFFFF");
        this.FBl = 1;
        this.FBm = "  ";
        this.FBn = " ";
        this.FBv = -1.0f;
        this.EOS = -1;
        View.inflate(context, R.layout.byx, this);
        View findViewById = findViewById(R.id.i6u);
        p.g(findViewById, "findViewById(R.id.story_action_like_tip_tv)");
        this.FBo = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.i6s);
        p.g(findViewById2, "findViewById(R.id.story_action_comment_tip_tv)");
        this.FBp = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.i8x);
        p.g(findViewById3, "findViewById(R.id.story_…ment_others_comment_icon)");
        this.FBr = (StoryCommentBubbleView) findViewById3;
        View findViewById4 = findViewById(R.id.i6w);
        p.g(findViewById4, "findViewById(R.id.story_action_self)");
        this.FBs = findViewById4;
        View findViewById5 = findViewById(R.id.i6v);
        p.g(findViewById5, "findViewById(R.id.story_action_other)");
        this.FBt = findViewById5;
        View findViewById6 = findViewById(R.id.i6t);
        p.g(findViewById6, "findViewById(R.id.story_action_like_tip_group)");
        this.FBq = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.i8y);
        p.g(findViewById7, "findViewById(R.id.story_comment_others_comment_tv)");
        com.tencent.mm.ac.d.f((TextView) findViewById7);
        Drawable drawable = context.getResources().getDrawable(R.drawable.axr);
        drawable.setBounds(0, 0, at.fromDPToPix(context, 8), at.fromDPToPix(context, 8));
        p.g(drawable, "drawable");
        this.FBx = new a(drawable);
        ViewGroup.LayoutParams layoutParams = this.FBq.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120079);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = at.fromDPToPix(context, 48);
        ViewGroup.LayoutParams layoutParams2 = this.FBq.getLayoutParams();
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120079);
            throw tVar2;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = at.fromDPToPix(context, 48) + au.aD(context);
        ViewGroup.LayoutParams layoutParams3 = this.FBt.getLayoutParams();
        if (layoutParams3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120079);
            throw tVar3;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = at.fromDPToPix(context, 48);
        ViewGroup.LayoutParams layoutParams4 = this.FBt.getLayoutParams();
        if (layoutParams4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(120079);
            throw tVar4;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = at.fromDPToPix(context, 48) + au.aD(context);
        this.FBr.setImageDrawable(ar.m(context, R.raw.icons_filled_chats, -1));
        this.FBo.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryActionView.AnonymousClass1 */
            final /* synthetic */ StoryActionView FBz;

            {
                this.FBz = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120063);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<Integer, x> onActionClicked = this.FBz.getOnActionClicked();
                if (onActionClicked != null) {
                    onActionClicked.invoke(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120063);
            }
        });
        this.FBp.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryActionView.AnonymousClass2 */
            final /* synthetic */ StoryActionView FBz;

            {
                this.FBz = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120064);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<Integer, x> onActionClicked = this.FBz.getOnActionClicked();
                if (onActionClicked != null) {
                    onActionClicked.invoke(1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120064);
            }
        });
        this.FBr.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.StoryActionView.AnonymousClass3 */
            final /* synthetic */ StoryActionView FBz;

            {
                this.FBz = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120065);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.b<Integer, x> onActionClicked = this.FBz.getOnActionClicked();
                if (onActionClicked != null) {
                    onActionClicked.invoke(0);
                }
                h hVar = h.FuH;
                h.aaT(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryActionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120065);
            }
        });
        AppMethodBeat.o(120079);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getOnActionClicked() {
        return this.FBy;
    }

    public final void setOnActionClicked(kotlin.g.a.b<? super Integer, x> bVar) {
        this.FBy = bVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120080);
        AppMethodBeat.o(120080);
    }

    /* access modifiers changed from: package-private */
    public final void w(TextView textView) {
        AppMethodBeat.i(120073);
        ValueAnimator ofArgb = ObjectAnimator.ofArgb(textView.getCurrentTextColor(), this.FBi);
        ofArgb.setEvaluator(new ArgbEvaluator());
        ofArgb.addUpdateListener(new b(textView));
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(textView.getTextSize(), this.FBg);
        ofFloat.addUpdateListener(new c(textView));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playTogether(ofArgb, ofFloat);
        animatorSet.start();
        AppMethodBeat.o(120073);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        b(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120067);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(120067);
                throw tVar;
            }
            textView.setTextColor(((Integer) animatedValue).intValue());
            AppMethodBeat.o(120067);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        c(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120068);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(120068);
                throw tVar;
            }
            textView.setTextSize(0, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(120068);
        }
    }

    /* access modifiers changed from: package-private */
    public final void x(TextView textView) {
        AppMethodBeat.i(120074);
        ValueAnimator ofArgb = ObjectAnimator.ofArgb(textView.getCurrentTextColor(), this.FBj);
        ofArgb.setEvaluator(new ArgbEvaluator());
        ofArgb.addUpdateListener(new f(textView));
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(textView.getTextSize(), this.FBh);
        ofFloat.addUpdateListener(new g(textView));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playTogether(ofArgb, ofFloat);
        animatorSet.start();
        AppMethodBeat.o(120074);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        f(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120071);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(120071);
                throw tVar;
            }
            textView.setTextColor(((Integer) animatedValue).intValue());
            AppMethodBeat.o(120071);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        g(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120072);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(120072);
                throw tVar;
            }
            textView.setTextSize(0, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(120072);
        }
    }

    /* access modifiers changed from: package-private */
    public final void y(TextView textView) {
        AppMethodBeat.i(120075);
        ValueAnimator ofArgb = ObjectAnimator.ofArgb(textView.getCurrentTextColor(), this.FBi);
        ofArgb.setEvaluator(new ArgbEvaluator());
        ofArgb.addUpdateListener(new d(textView));
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(textView.getTextSize(), this.FBh);
        ofFloat.addUpdateListener(new e(textView));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L);
        animatorSet.playTogether(ofArgb, ofFloat);
        animatorSet.start();
        AppMethodBeat.o(120075);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        d(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120069);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(120069);
                throw tVar;
            }
            textView.setTextColor(((Integer) animatedValue).intValue());
            AppMethodBeat.o(120069);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView hUM;

        e(TextView textView) {
            this.hUM = textView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(120070);
            TextView textView = this.hUM;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(120070);
                throw tVar;
            }
            textView.setTextSize(0, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(120070);
        }
    }

    private final boolean abd(int i2) {
        if (!this.FBw || this.sTB != i2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ((r0.length == 0) != false) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r7, android.widget.TextView r8) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.StoryActionView.a(boolean, android.widget.TextView):void");
    }

    public final void setup(com.tencent.mm.plugin.story.f.d.g gVar) {
        AppMethodBeat.i(120077);
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        this.FoU = gVar;
        j.b bVar = j.Fmy;
        this.dJM = Util.isEqual(j.b.fau(), gVar.Foa);
        if (this.dJM) {
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList = gVar.FoS;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2 = gVar.FoQ;
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList2) {
                if (t.FnW) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            for (T t2 : linkedList) {
                if (t2.FnW) {
                    arrayList3.add(t2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList3 = linkedList;
            if (!(linkedList3 == null || linkedList3.isEmpty())) {
                TextView textView = this.FBo;
                ae aeVar = ae.SYK;
                Context context = getContext();
                p.g(context, "context");
                String string = context.getResources().getString(R.string.hi5);
                p.g(string, "context.resources.getStr…story_gallery_bubble_tip)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(linkedList.size())}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
            } else {
                TextView textView2 = this.FBo;
                Context context2 = getContext();
                p.g(context2, "context");
                textView2.setText(context2.getResources().getString(R.string.hi7));
            }
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList4 = linkedList2;
            if (!(linkedList4 == null || linkedList4.isEmpty())) {
                TextView textView3 = this.FBp;
                ae aeVar2 = ae.SYK;
                Context context3 = getContext();
                p.g(context3, "context");
                String string2 = context3.getResources().getString(R.string.hi8);
                p.g(string2, "context.resources.getStr…tory_gallery_comment_tip)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(linkedList2.size())}, 1));
                p.g(format2, "java.lang.String.format(format, *args)");
                textView3.setText(format2);
            } else {
                TextView textView4 = this.FBp;
                Context context4 = getContext();
                p.g(context4, "context");
                textView4.setText(context4.getResources().getString(R.string.hi_));
            }
            if ((arrayList2.isEmpty()) || !abd(1)) {
                a(false, this.FBp);
            } else {
                a(true, this.FBp);
            }
            if ((arrayList4.isEmpty()) || !abd(0)) {
                a(false, this.FBo);
            } else {
                a(true, this.FBo);
            }
            this.FBo.requestLayout();
            this.FBp.requestLayout();
            this.FBs.setVisibility(0);
            this.FBt.setVisibility(8);
            AppMethodBeat.o(120077);
            return;
        }
        this.FBs.setVisibility(8);
        this.FBt.setVisibility(0);
        AppMethodBeat.o(120077);
    }

    public final void a(com.tencent.mm.plugin.story.f.d.g gVar) {
        AppMethodBeat.i(120078);
        p.h(gVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        if (this.dJM) {
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList = gVar.FoQ;
            LinkedList<com.tencent.mm.plugin.story.f.b.a> linkedList2 = linkedList;
            if (!(linkedList2 == null || linkedList2.isEmpty())) {
                TextView textView = this.FBp;
                ae aeVar = ae.SYK;
                Context context = getContext();
                p.g(context, "context");
                String string = context.getResources().getString(R.string.hi8);
                p.g(string, "context.resources.getStr…tory_gallery_comment_tip)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(linkedList.size())}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
                AppMethodBeat.o(120078);
                return;
            }
            TextView textView2 = this.FBp;
            Context context2 = getContext();
            p.g(context2, "context");
            textView2.setText(context2.getResources().getString(R.string.hi_));
        }
        AppMethodBeat.o(120078);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryActionView$StoryTipImageSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "plugin-story_release"})
    public static final class a extends com.tencent.mm.ui.widget.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Drawable drawable) {
            super(drawable, 1);
            p.h(drawable, "drawable");
            AppMethodBeat.i(120066);
            AppMethodBeat.o(120066);
        }
    }
}
