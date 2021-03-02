package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.ViewAnimHelper;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "gallery", "Lcom/tencent/mm/ui/tools/MMGestureGallery;", "galleryBg", "Landroid/view/View;", "isAvatar", "", "playingAnimation", "root", "scaleX", "", "scaleY", "thumRect", "Landroid/graphics/Rect;", "translationX", "translationY", "convertActivityFromTranslucent", "getLayoutId", "", "goBack", "", "initDragGallery", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "runEnterAnimation", "runExitAnimation", "setFullscreen", "FinderPreviewImageAdapter", "plugin-finder_release"})
public final class FinderImagePreviewUI extends MMFinderUI {
    private final String TAG = "MicroMsg.FinderImagePreviewUI";
    private HashMap _$_findViewCache;
    private View gvQ;
    private AnimationLayout jUD;
    private boolean jUE;
    private MMGestureGallery jUy;
    private float scaleX;
    private float scaleY;
    private float translationX;
    private float translationY;
    private Rect vKA;
    private View vKy;
    private boolean vKz;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252436);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252436);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252435);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252435);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final /* synthetic */ void b(FinderImagePreviewUI finderImagePreviewUI) {
        AppMethodBeat.i(167312);
        finderImagePreviewUI.goBack();
        AppMethodBeat.o(167312);
    }

    public static final /* synthetic */ MMGestureGallery c(FinderImagePreviewUI finderImagePreviewUI) {
        AppMethodBeat.i(167313);
        MMGestureGallery mMGestureGallery = finderImagePreviewUI.jUy;
        if (mMGestureGallery == null) {
            p.btv("gallery");
        }
        AppMethodBeat.o(167313);
        return mMGestureGallery;
    }

    public static final /* synthetic */ View e(FinderImagePreviewUI finderImagePreviewUI) {
        AppMethodBeat.i(167314);
        View view = finderImagePreviewUI.gvQ;
        if (view == null) {
            p.btv("root");
        }
        AppMethodBeat.o(167314);
        return view;
    }

    public static final /* synthetic */ View g(FinderImagePreviewUI finderImagePreviewUI) {
        AppMethodBeat.i(167315);
        View view = finderImagePreviewUI.vKy;
        if (view == null) {
            p.btv("galleryBg");
        }
        AppMethodBeat.o(167315);
        return view;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167308);
        super.onCreate(bundle);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
        initView();
        AppMethodBeat.o(167308);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167309);
        t controller = getController();
        p.g(controller, "controller");
        controller.getSupportActionBar().hide();
        getController().p(this, getResources().getColor(R.color.ac_));
        getController().setNavigationbarColor(getResources().getColor(R.color.ac_));
        View findViewById = findViewById(R.id.h8v);
        p.g(findViewById, "findViewById(R.id.root)");
        this.gvQ = findViewById;
        View findViewById2 = findViewById(R.id.dci);
        p.g(findViewById2, "findViewById(R.id.gallery)");
        this.jUy = (MMGestureGallery) findViewById2;
        View findViewById3 = findViewById(R.id.dcj);
        p.g(findViewById3, "findViewById(R.id.gallery_bg)");
        this.vKy = findViewById3;
        View findViewById4 = findViewById(R.id.n0);
        p.g(findViewById4, "findViewById(R.id.animation_layout)");
        this.jUD = (AnimationLayout) findViewById4;
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("key_file_list");
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra("key_url_list");
        this.vKz = getIntent().getBooleanExtra("key_preview_avatar", false);
        this.vKA = (Rect) getIntent().getParcelableExtra("key_thumb_location");
        Log.i(this.TAG, "files %s, urls", stringArrayListExtra, stringArrayListExtra2);
        a aVar = new a();
        if (stringArrayListExtra != null) {
            aVar.al(stringArrayListExtra);
            aVar.dLQ = true;
        } else if (stringArrayListExtra2 != null) {
            aVar.al(stringArrayListExtra2);
            aVar.dLQ = false;
        }
        MMGestureGallery mMGestureGallery = this.jUy;
        if (mMGestureGallery == null) {
            p.btv("gallery");
        }
        mMGestureGallery.setSingleClickOverListener(new c(this));
        MMGestureGallery mMGestureGallery2 = this.jUy;
        if (mMGestureGallery2 == null) {
            p.btv("gallery");
        }
        mMGestureGallery2.setAdapter((SpinnerAdapter) aVar);
        MMGestureGallery mMGestureGallery3 = this.jUy;
        if (mMGestureGallery3 == null) {
            p.btv("gallery");
        }
        mMGestureGallery3.setGalleryScaleListener(new b(this));
        if (this.vKA != null) {
            if (!this.jUE) {
                this.jUE = true;
                Log.i(this.TAG, "runEnterAnimation");
                AnimationLayout animationLayout = this.jUD;
                if (animationLayout == null) {
                    p.btv("animationLayout");
                }
                View view = this.vKy;
                if (view == null) {
                    p.btv("galleryBg");
                }
                View view2 = this.gvQ;
                if (view2 == null) {
                    p.btv("root");
                }
                animationLayout.a(view, view2, new ViewAnimHelper.ViewInfo(this.vKA), new d(this));
            }
            AppMethodBeat.o(167309);
            return;
        }
        View view3 = this.vKy;
        if (view3 == null) {
            p.btv("galleryBg");
        }
        view3.setVisibility(0);
        AppMethodBeat.o(167309);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "singleClickOver"})
    public static final class c implements MMGestureGallery.f {
        final /* synthetic */ FinderImagePreviewUI vKB;

        c(FinderImagePreviewUI finderImagePreviewUI) {
            this.vKB = finderImagePreviewUI;
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
        public final void bmt() {
            AppMethodBeat.i(167300);
            FinderImagePreviewUI.b(this.vKB);
            AppMethodBeat.o(167300);
        }
    }

    private final void goBack() {
        AppMethodBeat.i(167310);
        if (this.vKA == null) {
            finish();
            AppMethodBeat.o(167310);
        } else if (this.jUE) {
            finish();
            AppMethodBeat.o(167310);
        } else {
            this.jUE = true;
            Log.i(this.TAG, "runExitAnimation");
            MMGestureGallery mMGestureGallery = this.jUy;
            if (mMGestureGallery == null) {
                p.btv("gallery");
            }
            View selectedView = mMGestureGallery.getSelectedView();
            if (selectedView == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
                AppMethodBeat.o(167310);
                throw tVar;
            }
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            AnimationLayout animationLayout = this.jUD;
            if (animationLayout == null) {
                p.btv("animationLayout");
            }
            View view = this.vKy;
            if (view == null) {
                p.btv("galleryBg");
            }
            View view2 = this.gvQ;
            if (view2 == null) {
                p.btv("root");
            }
            animationLayout.a(view, view2, new ViewAnimHelper.ViewInfo(this.vKA), new e(this, multiTouchImageView), new f(this, multiTouchImageView));
            AppMethodBeat.o(167310);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167311);
        goBack();
        AppMethodBeat.o(167311);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.acd;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean convertActivityFromTranslucent() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$initDragGallery$1", "Lcom/tencent/mm/ui/tools/MMGestureGallery$IOnGalleryScale;", "onGalleryScale", "", "tx", "", "ty", "onSetPrePrama", "plugin-finder_release"})
    public static final class b implements MMGestureGallery.b {
        final /* synthetic */ FinderImagePreviewUI vKB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderImagePreviewUI finderImagePreviewUI) {
            this.vKB = finderImagePreviewUI;
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
        public final void S(float f2, float f3) {
            AppMethodBeat.i(167299);
            float height = 1.0f - (f3 / ((float) FinderImagePreviewUI.c(this.vKB).getHeight()));
            if (height > 1.0f) {
                height = 1.0f;
            }
            Log.d(this.vKB.TAG, "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(height));
            View selectedView = FinderImagePreviewUI.c(this.vKB).getSelectedView();
            if (selectedView == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
                AppMethodBeat.o(167299);
                throw tVar;
            }
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            multiTouchImageView.setPivotX((float) (FinderImagePreviewUI.c(this.vKB).getWidth() / 2));
            multiTouchImageView.setPivotY((float) (FinderImagePreviewUI.c(this.vKB).getHeight() / 2));
            multiTouchImageView.setScaleX(height);
            multiTouchImageView.setScaleY(height);
            multiTouchImageView.setTranslationX(f2);
            multiTouchImageView.setTranslationY(f3);
            FinderImagePreviewUI.e(this.vKB).setAlpha(height);
            AppMethodBeat.o(167299);
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
        public final void T(float f2, float f3) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ FinderImagePreviewUI vKB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderImagePreviewUI finderImagePreviewUI) {
            this.vKB = finderImagePreviewUI;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(167301);
            this.vKB.jUE = false;
            AppMethodBeat.o(167301);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(167302);
            FinderImagePreviewUI.g(this.vKB).setVisibility(0);
            AppMethodBeat.o(167302);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ FinderImagePreviewUI vKB;
        final /* synthetic */ MultiTouchImageView vKG;

        e(FinderImagePreviewUI finderImagePreviewUI, MultiTouchImageView multiTouchImageView) {
            this.vKB = finderImagePreviewUI;
            this.vKG = multiTouchImageView;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(167303);
            p.h(animator, "animation");
            if (this.vKG.getScale() > 1.0f) {
                this.vKG.gKy();
            }
            this.vKB.translationX = this.vKG.getTranslationX();
            this.vKB.translationY = this.vKG.getTranslationY();
            this.vKB.scaleX = this.vKG.getScaleX();
            this.vKB.scaleY = this.vKG.getScaleY();
            AppMethodBeat.o(167303);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(167304);
            p.h(animator, "animation");
            this.vKB.finish();
            this.vKB.overridePendingTransition(R.anim.s, R.anim.s);
            AppMethodBeat.o(167304);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(167305);
            p.h(animator, "animation");
            AppMethodBeat.o(167305);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(167306);
            p.h(animator, "animation");
            AppMethodBeat.o(167306);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$runExitAnimation$2", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-finder_release"})
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderImagePreviewUI vKB;
        final /* synthetic */ MultiTouchImageView vKG;

        f(FinderImagePreviewUI finderImagePreviewUI, MultiTouchImageView multiTouchImageView) {
            this.vKB = finderImagePreviewUI;
            this.vKG = multiTouchImageView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(167307);
            p.h(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(167307);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.vKG.setTranslationX(this.vKB.translationX * (1.0f - floatValue));
            this.vKG.setTranslationY(this.vKB.translationY * (1.0f - floatValue));
            this.vKG.setScaleX(((1.0f - floatValue) * this.vKB.scaleX) + floatValue);
            this.vKG.setScaleY(floatValue + ((1.0f - floatValue) * this.vKB.scaleY));
            AppMethodBeat.o(167307);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\nH\u0016J$\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
    public final class a extends BaseAdapter {
        boolean dLQ;
        private ArrayList<String> images = new ArrayList<>();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
        /* renamed from: com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI$a$a  reason: collision with other inner class name */
        static final class C1289a<T, R> implements com.tencent.mm.loader.f.e<String, Bitmap> {
            public static final C1289a vKC = new C1289a();

            static {
                AppMethodBeat.i(167289);
                AppMethodBeat.o(167289);
            }

            C1289a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
            @Override // com.tencent.mm.loader.f.e
            public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<String> aVar, g gVar, Bitmap bitmap) {
                AppMethodBeat.i(167288);
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    MMHandlerThread.postToMainThread(new RunnableC1290a(gVar, bitmap2));
                }
                AppMethodBeat.o(167288);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI$a$a$a  reason: collision with other inner class name */
            static final class RunnableC1290a implements Runnable {
                final /* synthetic */ g vKD;
                final /* synthetic */ Bitmap vKE;

                RunnableC1290a(g gVar, Bitmap bitmap) {
                    this.vKD = gVar;
                    this.vKE = bitmap;
                }

                public final void run() {
                    AppMethodBeat.i(167287);
                    g gVar = this.vKD;
                    p.g(gVar, "imageView");
                    View view = gVar.getView();
                    if (view == null) {
                        AppMethodBeat.o(167287);
                    } else if (view == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
                        AppMethodBeat.o(167287);
                        throw tVar;
                    } else {
                        ((MultiTouchImageView) view).cN(this.vKE.getWidth(), this.vKE.getHeight());
                        ((MultiTouchImageView) view).gKy();
                        AppMethodBeat.o(167287);
                    }
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
        static final class b extends q implements m<g<?>, Bitmap, x> {
            public static final b vKF = new b();

            static {
                AppMethodBeat.i(167292);
                AppMethodBeat.o(167292);
            }

            b() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(g<?> gVar, Bitmap bitmap) {
                AppMethodBeat.i(252434);
                g<?> gVar2 = gVar;
                Bitmap bitmap2 = bitmap;
                p.h(gVar2, "imageView");
                if (bitmap2 != null) {
                    MMHandlerThread.postToMainThread(new RunnableC1291a(gVar2, bitmap2));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(252434);
                return xVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI$a$b$a  reason: collision with other inner class name */
            static final class RunnableC1291a implements Runnable {
                final /* synthetic */ g vKD;
                final /* synthetic */ Bitmap vKE;

                RunnableC1291a(g gVar, Bitmap bitmap) {
                    this.vKD = gVar;
                    this.vKE = bitmap;
                }

                public final void run() {
                    AppMethodBeat.i(167290);
                    View view = this.vKD.getView();
                    if (view == null) {
                        AppMethodBeat.o(167290);
                    } else if (view == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
                        AppMethodBeat.o(167290);
                        throw tVar;
                    } else {
                        ((MultiTouchImageView) view).cN(this.vKE.getWidth(), this.vKE.getHeight());
                        ((MultiTouchImageView) view).gKy();
                        AppMethodBeat.o(167290);
                    }
                }
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
            AppMethodBeat.i(167298);
            AppMethodBeat.o(167298);
        }

        public final int getCount() {
            AppMethodBeat.i(167293);
            int size = this.images.size();
            AppMethodBeat.o(167293);
            return size;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(167294);
            String str = this.images.get(i2);
            AppMethodBeat.o(167294);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            MultiTouchImageView multiTouchImageView;
            com.tencent.mm.loader.a.b<o, Bitmap> bQ;
            AppMethodBeat.i(167296);
            p.h(viewGroup, "viewGroup");
            if (view == null) {
                MultiTouchImageView multiTouchImageView2 = new MultiTouchImageView(FinderImagePreviewUI.this, 0, 0, (byte) 0);
                multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                multiTouchImageView = multiTouchImageView2;
            } else {
                multiTouchImageView = view;
            }
            if (this.dLQ) {
                com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.hXU;
                com.tencent.mm.loader.a aJs = com.tencent.mm.loader.e.aJs();
                String item = getItem(i2);
                if (item == null) {
                    p.hyc();
                }
                com.tencent.mm.loader.a.b<String, Bitmap> Hf = aJs.Hf(item);
                Hf.hXY = C1289a.vKC;
                Hf.c((ImageView) multiTouchImageView);
            } else {
                if (!FinderImagePreviewUI.this.vKz) {
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    bQ = com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(Util.nullAsNil(getItem(i2)), com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE));
                } else {
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    bQ = com.tencent.mm.plugin.finder.loader.m.dkd().bQ(new com.tencent.mm.plugin.finder.loader.a(Util.nullAsNil(getItem(i2))));
                }
                ((com.tencent.mm.loader.a.a) bQ).a((ImageView) multiTouchImageView, b.vKF);
            }
            AppMethodBeat.o(167296);
            return multiTouchImageView;
        }

        public final void al(ArrayList<String> arrayList) {
            AppMethodBeat.i(167297);
            p.h(arrayList, "files");
            this.images.addAll(arrayList);
            AppMethodBeat.o(167297);
        }
    }
}
