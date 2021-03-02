package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.ui.view.CommentItemView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010*\u001a\u00020\u001aH\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u000fH\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0006\u00104\u001a\u00020\u001aJ\u000e\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\tJ\u001e\u00107\u001a\u00020\u001a2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f092\b\b\u0002\u0010\u0016\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u000e\u0010'\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "currIndex", "isPause", "", "()Z", "setPause", "(Z)V", "isUnread", "setUnread", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "nextItemDelay", "", "nextItemDuration", "nextRunnable", "Ljava/lang/Runnable;", "onLoop", "getOnLoop", "setOnLoop", "onLoopRunnable", "random", "Ljava/util/Random;", "animNext", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "getItemView", "Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "nextDelay", "nextDuration", "pause", "restart", "resume", "shakeIndex", FirebaseAnalytics.b.INDEX, "update", "storyComments", "", "plugin-story_release"})
public final class CommentsContainer extends RelativeLayout {
    private int Cgl;
    private long FAY;
    private long FAZ;
    private kotlin.g.a.a<x> FBa;
    private final Runnable FBb;
    private final Runnable FBc;
    private boolean FnW;
    private final ArrayList<com.tencent.mm.plugin.story.f.b.a> FwY;
    private final String TAG;
    public boolean dLD;
    private kotlin.g.a.a<x> hXJ;
    private Random random;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentsContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120058);
        this.TAG = "MicroMsg.CommentsContainer";
        this.FwY = new ArrayList<>();
        this.Cgl = -1;
        this.random = new Random();
        this.dLD = true;
        this.FBb = new c(this);
        this.FBc = new d(this);
        AppMethodBeat.o(120058);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentsContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120059);
        AppMethodBeat.o(120059);
    }

    public final void setPause(boolean z) {
        this.dLD = z;
    }

    public final kotlin.g.a.a<x> getItemClickListener() {
        return this.hXJ;
    }

    public final void setItemClickListener(kotlin.g.a.a<x> aVar) {
        this.hXJ = aVar;
    }

    public final kotlin.g.a.a<x> getOnLoop() {
        return this.FBa;
    }

    public final void setOnLoop(kotlin.g.a.a<x> aVar) {
        this.FBa = aVar;
    }

    public final void setUnread(boolean z) {
        this.FnW = z;
    }

    public static /* synthetic */ void a(CommentsContainer commentsContainer, List list) {
        AppMethodBeat.i(120054);
        commentsContainer.p(list, false);
        AppMethodBeat.o(120054);
    }

    public final void p(List<com.tencent.mm.plugin.story.f.b.a> list, boolean z) {
        AppMethodBeat.i(120053);
        p.h(list, "storyComments");
        this.FnW = z;
        this.FwY.clear();
        this.FwY.addAll(list);
        this.Cgl = -1;
        this.FAZ = 4000;
        AppMethodBeat.o(120053);
    }

    public final void restart() {
        AppMethodBeat.i(120055);
        Log.i(this.TAG, "LogStory: restart ".concat(String.valueOf(this)));
        resume();
        AppMethodBeat.o(120055);
    }

    public final void resume() {
        AppMethodBeat.i(120056);
        Log.i(this.TAG, "LogStory: resume ".concat(String.valueOf(this)));
        this.dLD = false;
        if (this.Cgl != 0) {
            removeCallbacks(this.FBb);
            removeCallbacks(this.FBc);
            removeAllViews();
            this.Cgl = -1;
            postDelayed(this.FBb, 300);
        }
        AppMethodBeat.o(120056);
    }

    public final void pause() {
        AppMethodBeat.i(120057);
        Log.i(this.TAG, "LogStory: pause ".concat(String.valueOf(this)));
        this.dLD = true;
        removeCallbacks(this.FBb);
        removeCallbacks(this.FBc);
        removeAllViews();
        this.Cgl = -1;
        AppMethodBeat.o(120057);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ CommentsContainer FBd;

        c(CommentsContainer commentsContainer) {
            this.FBd = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.i(120051);
            CommentsContainer.h(this.FBd);
            AppMethodBeat.o(120051);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ CommentsContainer FBd;

        d(CommentsContainer commentsContainer) {
            this.FBd = commentsContainer;
        }

        public final void run() {
            AppMethodBeat.i(120052);
            kotlin.g.a.a<x> onLoop = this.FBd.getOnLoop();
            if (onLoop != null) {
                onLoop.invoke();
                AppMethodBeat.o(120052);
                return;
            }
            AppMethodBeat.o(120052);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ int FAT;
        final /* synthetic */ CommentsContainer FBd;
        final /* synthetic */ CommentItemView FBe;
        final /* synthetic */ com.tencent.mm.plugin.story.f.b.a FxV;

        a(CommentsContainer commentsContainer, CommentItemView commentItemView, com.tencent.mm.plugin.story.f.b.a aVar, int i2) {
            this.FBd = commentsContainer;
            this.FBe = commentItemView;
            this.FxV = aVar;
            this.FAT = i2;
        }

        public final void run() {
            AppMethodBeat.i(120049);
            View maskView = this.FBe.getMaskView();
            CommentsContainer commentsContainer = this.FBd;
            Context context = this.FBd.getContext();
            p.g(context, "context");
            maskView.setBackground(CommentsContainer.a(commentsContainer, context));
            this.FBe.setVisibility(0);
            int measuredHeight = this.FBe.getMeasuredHeight();
            int paddingBottom = this.FAT - this.FBd.getPaddingBottom();
            this.FBd.FAZ = ((long) com.tencent.mm.cb.a.E(this.FBd.getContext(), paddingBottom)) * 9;
            if (this.FBd.FAZ <= 0) {
                this.FBd.FAZ = 4000;
            }
            CommentItemView commentItemView = this.FBe;
            long j2 = this.FBd.FAZ;
            int paddingBottom2 = this.FBd.getPaddingBottom();
            int i2 = this.FAT - (measuredHeight / 2);
            T t = (T) new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.ui.view.CommentsContainer.a.AnonymousClass1 */
                final /* synthetic */ a FBf;

                {
                    this.FBf = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(120047);
                    Log.i(this.FBf.FBd.TAG, "LogStory: comment appear " + this.FBf.FxV.FnY);
                    if (this.FBf.FxV.FnY) {
                        this.FBf.FxV.FnY = false;
                    }
                    if (this.FBf.FxV.FnW) {
                        CommentItemView commentItemView = this.FBf.FBe;
                        View view = commentItemView.maskView;
                        if (view == null) {
                            p.btv("maskView");
                        }
                        Drawable background = view.getBackground();
                        if (background instanceof GradientDrawable) {
                            int color = commentItemView.getResources().getColor(R.color.Indigo);
                            Context context = commentItemView.getContext();
                            p.g(context, "context");
                            ObjectAnimator ofInt = ObjectAnimator.ofInt(background, "color", color, context.getResources().getColor(R.color.a_s));
                            ofInt.setEvaluator(new CommentItemView.a());
                            if (ofInt != null) {
                                ofInt.setStartDelay(400);
                            }
                            if (ofInt != null) {
                                ofInt.setDuration(2000L);
                            }
                            if (ofInt != null) {
                                ofInt.start();
                            }
                        }
                        this.FBf.FxV.FnW = false;
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(120047);
                    return xVar;
                }
            };
            AnonymousClass2 r5 = new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.ui.view.CommentsContainer.a.AnonymousClass2 */
                final /* synthetic */ a FBf;

                {
                    this.FBf = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(120048);
                    Log.i(this.FBf.FBd.TAG, "LogStory: remove " + this.FBf.FBe + ' ' + this.FBf.FBe.getParent());
                    this.FBf.FBd.removeView(this.FBf.FBe);
                    x xVar = x.SXb;
                    AppMethodBeat.o(120048);
                    return xVar;
                }
            };
            commentItemView.FAL = commentItemView.getMeasuredWidth();
            commentItemView.FAK = commentItemView.getMeasuredHeight();
            ViewGroup viewGroup = commentItemView.zhm;
            if (viewGroup == null) {
                p.btv("contentLayout");
            }
            viewGroup.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = commentItemView.getLayoutParams();
            layoutParams.height = commentItemView.FAJ;
            layoutParams.width = commentItemView.FAJ;
            commentItemView.setLayoutParams(layoutParams);
            Log.i("MicroMsg.CommentItemView", "LogStory: animation start " + commentItemView.FAJ + ", " + commentItemView.FAL + ' ' + commentItemView.FAK);
            z.f fVar = new z.f();
            fVar.SYG = t;
            CommentItemView.c cVar = new CommentItemView.c(new PointF(0.05f, 0.1f));
            commentItemView.FAF = ObjectAnimator.ofFloat(0.0f, 1.0f);
            ValueAnimator valueAnimator = commentItemView.FAF;
            if (valueAnimator != null) {
                valueAnimator.setInterpolator(cVar);
            }
            ValueAnimator valueAnimator2 = commentItemView.FAF;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(j2);
            }
            ValueAnimator valueAnimator3 = commentItemView.FAF;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new CommentItemView.e(commentItemView, i2, paddingBottom2, fVar, r5));
            }
            ValueAnimator valueAnimator4 = commentItemView.FAF;
            if (valueAnimator4 != null) {
                valueAnimator4.start();
            }
            this.FBd.FAY = ((long) (com.tencent.mm.cb.a.E(this.FBd.getContext(), measuredHeight) + 96)) * 6;
            if (this.FBd.Cgl == this.FBd.FwY.size() - 1) {
                this.FBd.FAY = this.FBd.FAZ;
                this.FBd.postDelayed(this.FBd.FBc, this.FBd.FAY);
            }
            this.FBd.postDelayed(this.FBd.FBb, this.FBd.FAY);
            AppMethodBeat.o(120049);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ CommentsContainer FBd;

        b(CommentsContainer commentsContainer) {
            this.FBd = commentsContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120050);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/CommentsContainer$getItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> itemClickListener = this.FBd.getItemClickListener();
            if (itemClickListener != null) {
                itemClickListener.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/CommentsContainer$getItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120050);
        }
    }

    public static final /* synthetic */ GradientDrawable a(CommentsContainer commentsContainer, Context context) {
        AppMethodBeat.i(120060);
        int color = context.getResources().getColor(R.color.Indigo);
        int color2 = context.getResources().getColor(R.color.a_s);
        if (!commentsContainer.FnW) {
            color = color2;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix(context, 24));
        AppMethodBeat.o(120060);
        return gradientDrawable;
    }

    public static final /* synthetic */ void h(CommentsContainer commentsContainer) {
        boolean z;
        SpannableString spannableString;
        String arJ;
        String arJ2;
        AppMethodBeat.i(120061);
        Log.i(commentsContainer.TAG, "LogStory: animNext " + commentsContainer.Cgl + ' ' + commentsContainer.dLD + ' ' + commentsContainer.FwY.size());
        if (commentsContainer.dLD || commentsContainer.FwY.size() <= 0) {
            AppMethodBeat.o(120061);
            return;
        }
        commentsContainer.Cgl++;
        commentsContainer.Cgl %= commentsContainer.FwY.size();
        int i2 = commentsContainer.Cgl;
        com.tencent.mm.plugin.story.f.b.a aVar = commentsContainer.FwY.get(i2);
        p.g(aVar, "comments[itemIndex]");
        com.tencent.mm.plugin.story.f.b.a aVar2 = aVar;
        View inflate = LayoutInflater.from(commentsContainer.getContext()).inflate(aVar2.FnX ? R.layout.bzp : R.layout.bzo, (ViewGroup) commentsContainer, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        p.g(inflate, "itemView");
        inflate.setLayoutParams(layoutParams);
        View findViewById = inflate.findViewById(R.id.i8j);
        p.g(findViewById, "itemView.findViewById(R.…tory_comment_item_avatar)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.i8t);
        p.g(findViewById2, "itemView.findViewById(R.…ry_comment_item_username)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.i8m);
        p.g(findViewById3, "itemView.findViewById(R.…ory_comment_item_content)");
        TextView textView2 = (TextView) findViewById3;
        imageView.setClickable(false);
        a.b.d(imageView, aVar2.dRL);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aVar2.dRL);
        SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(textView.getContext(), (Kn == null || (arJ2 = Kn.arJ()) == null) ? "" : arJ2, textView.getTextSize());
        com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().Kn(aVar2.toUser);
        SpannableString b3 = com.tencent.mm.pluginsdk.ui.span.l.b(textView.getContext(), (Kn2 == null || (arJ = Kn2.arJ()) == null) ? "" : arJ, textView.getTextSize());
        if (aVar2.Fob != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            StringBuilder append = new StringBuilder().append((Object) b2).append(' ');
            Context context = textView.getContext();
            p.g(context, "fromUser.context");
            spannableString = append.append(context.getResources().getString(R.string.yf)).append(' ').append((Object) b3).toString();
        } else {
            spannableString = b2;
        }
        textView.setText(spannableString);
        if (aVar2.FnX) {
            textView2.setVisibility(8);
            com.tencent.mm.ac.d.f(textView);
        } else {
            textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.b(textView2.getContext(), aVar2.content, textView2.getTextSize()));
        }
        inflate.setOnClickListener(new b(commentsContainer));
        CommentItemView commentItemView = (CommentItemView) inflate;
        int measuredHeight = (commentsContainer.getMeasuredHeight() * 2) / 3;
        Log.i(commentsContainer.TAG, "LogStory: is enhance comment " + aVar2.FnZ);
        commentItemView.setId(i2);
        commentItemView.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = commentsContainer.getMeasuredHeight() - measuredHeight;
        commentsContainer.addView(commentItemView, layoutParams2);
        commentsContainer.post(new a(commentsContainer, commentItemView, aVar2, measuredHeight));
        AppMethodBeat.o(120061);
    }
}
