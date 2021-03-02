package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tavkit.component.TAVExporter;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\"\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "cancel", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class c extends e {
    public static final a FzU = new a((byte) 0);
    private static final String TAG = TAG;
    private final b FzT = new b(this);
    private com.tencent.mm.ui.m.b gZR;
    private boolean hVn;
    private boolean hVo;
    private boolean hVp;
    private Context mContext;
    private View targetView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, R.style.ht);
        p.h(context, "mContext");
        AppMethodBeat.i(119959);
        this.mContext = context;
        gR();
        Context context2 = getContext();
        p.g(context2, "context");
        this.gZR = new com.tencent.mm.ui.m.b(context2);
        AppMethodBeat.o(119959);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119960);
        AppMethodBeat.o(119960);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public static final class b implements StoryGalleryView.b {
        final /* synthetic */ c FzV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(c cVar) {
            this.FzV = cVar;
        }

        @Override // com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b
        public final void ca(float f2) {
        }

        @Override // com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b
        public final void aJl() {
            long j2 = 0;
            AppMethodBeat.i(119952);
            View view = this.FzV.targetView;
            if (view != null) {
                view.setEnabled(false);
                long height = (long) (((((float) view.getHeight()) - view.getTranslationY()) / ((float) view.getHeight())) * 300.0f);
                if (height >= 0) {
                    j2 = height;
                }
                view.animate().translationY((float) view.getHeight()).setDuration(j2).withEndAction(new a(this)).start();
                AppMethodBeat.o(119952);
                return;
            }
            AppMethodBeat.o(119952);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b FzW;

            a(b bVar) {
                this.FzW = bVar;
            }

            public final void run() {
                AppMethodBeat.i(119951);
                new MMHandler().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.story.ui.sns.c.b.a.AnonymousClass1 */
                    final /* synthetic */ a FzX;

                    {
                        this.FzX = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(119950);
                        if (this.FzX.FzW.FzV.isShowing()) {
                            this.FzX.FzW.FzV.cancel();
                        }
                        AppMethodBeat.o(119950);
                    }
                });
                AppMethodBeat.o(119951);
            }
        }
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(119954);
        Resources resources = this.mContext.getResources();
        p.g(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(119954);
            return true;
        }
        AppMethodBeat.o(119954);
        return false;
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119955);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            AppMethodBeat.o(119955);
            return;
        }
        AppMethodBeat.o(119955);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c  reason: collision with other inner class name */
    static final class View$OnClickListenerC1783c implements View.OnClickListener {
        final /* synthetic */ c FzV;

        View$OnClickListenerC1783c(c cVar) {
            this.FzV = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119953);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.FzV.isShowing()) {
                this.FzV.cancel();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119953);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(119957);
        p.h(motionEvent, "ev");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hVp = false;
            case 1:
            case 3:
                this.hVo = false;
                break;
        }
        this.gZR.al(motionEvent);
        int i2 = this.gZR.QnD;
        if (!(i2 == 1 || i2 == 2)) {
            if (!this.hVo && !this.hVn) {
                z = this.gZR.dispatchTouchEvent(motionEvent);
            } else if (!this.hVp) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                p.g(obtain, "cancelEvent");
                obtain.setAction(3);
                this.gZR.dispatchTouchEvent(obtain);
                obtain.recycle();
                this.hVp = true;
            }
        }
        if (this.hVo || z) {
            if (!this.hVp) {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                p.g(obtain2, "cancelEvent");
                obtain2.setAction(3);
                super.dispatchTouchEvent(obtain2);
                obtain2.recycle();
                this.hVp = true;
            }
            AppMethodBeat.o(119957);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(119957);
        return dispatchTouchEvent;
    }

    public final void cancel() {
        AppMethodBeat.i(119958);
        if (this.targetView instanceof a) {
            View view = this.targetView;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
                AppMethodBeat.o(119958);
                throw tVar;
            }
            ((a) view).finish();
        }
        super.cancel();
        AppMethodBeat.o(119958);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(119956);
        p.h(view, "view");
        Window window = getWindow();
        if (isLandscape()) {
            if (window == null) {
                p.hyc();
            }
            window.setGravity(5);
            window.setWindowAnimations(R.style.t2);
        } else {
            if (window == null) {
                p.hyc();
            }
            window.setGravity(80);
            window.setWindowAnimations(R.style.fs);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (isLandscape()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        view.findViewById(R.id.iua).setOnClickListener(new View$OnClickListenerC1783c(this));
        super.setContentView(view);
        this.targetView = view;
        this.gZR.a(new f(view, this.FzT));
        Window window2 = getWindow();
        if (window2 == null) {
            p.hyc();
        }
        window2.setLayout(-1, -1);
        if (getWindow() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window3 = getWindow();
                if (window3 == null) {
                    p.hyc();
                }
                p.g(window3, "window!!");
                View decorView = window3.getDecorView();
                p.g(decorView, "window!!.decorView");
                decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
                Window window4 = getWindow();
                if (window4 == null) {
                    p.hyc();
                }
                window4.addFlags(Integer.MIN_VALUE);
                Window window5 = getWindow();
                if (window5 == null) {
                    p.hyc();
                }
                p.g(window5, "window!!");
                window5.setStatusBarColor(0);
            } else {
                Window window6 = getWindow();
                if (window6 == null) {
                    p.hyc();
                }
                window6.addFlags(67108864);
            }
            Window window7 = getWindow();
            if (window7 == null) {
                p.hyc();
            }
            window7.setFlags(134217728, 134217728);
        }
        AppMethodBeat.o(119956);
    }
}
