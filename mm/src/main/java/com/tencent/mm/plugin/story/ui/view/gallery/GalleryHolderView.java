package com.tencent.mm.plugin.story.ui.view.gallery;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.f.d;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001*B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\u001eJ\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\nH\u0016R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "attrs", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initMargin", "getInitMargin", "()I", "setInitMargin", "(I)V", "lastScrollAlpha", "", "mActionIv", "Landroid/widget/ImageView;", "mActionView", "Landroid/widget/LinearLayout;", "mBubbleIv", "mIsFirstPullDown", "", "mTitleTv", "Landroid/widget/TextView;", "smallHead", "animClosing", "", "animOpening", "checkSmallHead", "closed", "goStoryCaptureUI", "onClosing", "offset", "onListInnerScroll", "onOpening", "opened", "setVisibility", "visibility", "Companion", "plugin-story_release"})
public final class GalleryHolderView extends RelativeLayout {
    public static final a FEV = new a((byte) 0);
    static final String TAG = TAG;
    LinearLayout FEP;
    private ImageView FEQ;
    private ImageView FER;
    private boolean FES;
    int FET;
    float FEU;
    TextView mPa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryHolderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120340);
        View.inflate(context, R.layout.c08, this);
        View findViewById = findViewById(R.id.iar);
        p.g(findViewById, "findViewById(R.id.story_…ery_holder_action_layout)");
        this.FEP = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.iaq);
        p.g(findViewById2, "findViewById(R.id.story_gallery_holder_action_iv)");
        this.FEQ = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.iat);
        p.g(findViewById3, "findViewById(R.id.story_gallery_holder_bubble)");
        this.FER = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.iav);
        p.g(findViewById4, "findViewById(R.id.story_gallery_holder_title_tv)");
        this.mPa = (TextView) findViewById4;
        this.FEP.setVisibility(4);
        this.FEQ.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_camera), context.getResources().getColor(R.color.aaj)));
        this.FEP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.story.ui.view.gallery.GalleryHolderView.AnonymousClass1 */
            final /* synthetic */ GalleryHolderView FEW;

            {
                this.FEW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(120336);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GalleryHolderView.a(this.FEW);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(120336);
            }
        });
        setBackgroundColor(context.getResources().getColor(R.color.aa_));
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(120340);
            throw tVar;
        }
        this.FES = ((Boolean) obj).booleanValue();
        if (this.FES) {
            this.mPa.setTextColor(getResources().getColor(R.color.a_l));
            TextView textView = this.mPa;
            StoryGalleryView.a aVar = StoryGalleryView.FGV;
            String string = getResources().getString(R.string.hif);
            p.g(string, "resources.getString(R.st…ory_gallery_holder_title)");
            textView.setText(StoryGalleryView.a.k(string, getResources().getColor(R.color.a_l)));
        } else {
            this.mPa.setTextColor(getResources().getColor(R.color.aaa));
            this.mPa.setText(getResources().getString(R.string.hid));
        }
        if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
            this.FER.setVisibility(8);
        } else {
            this.FER.setVisibility(0);
        }
        this.FEU = 1.0f;
        AppMethodBeat.o(120340);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryHolderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120341);
        AppMethodBeat.o(120341);
    }

    public final int getInitMargin() {
        return this.FET;
    }

    public final void setInitMargin(int i2) {
        this.FET = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120342);
        AppMethodBeat.o(120342);
    }

    public final void fsl() {
        AppMethodBeat.i(120337);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mPa, "alpha", this.mPa.getAlpha(), 0.0f), ObjectAnimator.ofFloat(this.FEP, "alpha", this.FEP.getAlpha(), 1.0f));
        animatorSet.setDuration(100L);
        animatorSet.start();
        AppMethodBeat.o(120337);
    }

    public final void fsm() {
        AppMethodBeat.i(120338);
        this.FEP.setVisibility(0);
        this.mPa.setVisibility(4);
        if (this.FES) {
            this.FES = false;
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.FALSE);
        }
        this.mPa.setTextColor(getResources().getColor(R.color.aaa));
        this.mPa.setText(getResources().getString(R.string.hid));
        AppMethodBeat.o(120338);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(120339);
        super.setVisibility(i2);
        if (i2 == 0) {
            if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                this.FER.setVisibility(8);
                AppMethodBeat.o(120339);
                return;
            }
            this.FER.setVisibility(0);
        }
        AppMethodBeat.o(120339);
    }

    public static final /* synthetic */ void a(GalleryHolderView galleryHolderView) {
        AppMethodBeat.i(120343);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.TRUE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(120343);
            throw tVar;
        }
        if (((Boolean) obj).booleanValue()) {
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.FALSE);
        }
        d dVar = d.FlN;
        if (!d.canPostStory()) {
            e aAh3 = g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            Object obj2 = aAh3.azQ().get(ar.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, (Object) 0);
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(120343);
                throw tVar2;
            }
            int intValue = ((Integer) obj2).intValue();
            Context context = galleryHolderView.getContext();
            Context context2 = galleryHolderView.getContext();
            p.g(context2, "context");
            h.X(context, "", context2.getResources().getString(R.string.his, Integer.valueOf(intValue)));
            AppMethodBeat.o(120343);
            return;
        }
        com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
        Context context3 = galleryHolderView.getContext();
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        aVar.startStoryCapture(context3, 1, com.tencent.mm.plugin.story.h.h.fqA());
        AppMethodBeat.o(120343);
    }
}
