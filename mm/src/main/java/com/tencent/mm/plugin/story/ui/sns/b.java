package com.tencent.mm.plugin.story.ui.sns;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.au;
import com.tencent.tavkit.component.TAVExporter;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\nH\u0014J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0002J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "onOkBtnClick", "Lkotlin/Function0;", "", "getOnOkBtnClick", "()Lkotlin/jvm/functions/Function0;", "setOnOkBtnClick", "(Lkotlin/jvm/functions/Function0;)V", "targetView", "Landroid/view/View;", "cancel", "isLandscape", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setContentView", "view", "setTranslucentStatus", "wrapSheet", "layoutResId", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-story_release"})
public final class b extends e {
    public static final a FzQ = new a((byte) 0);
    private static final String TAG = TAG;
    public kotlin.g.a.a<x> FzP;
    private Context mContext;
    private View targetView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.ht);
        p.h(context, "mContext");
        AppMethodBeat.i(119948);
        this.mContext = context;
        gR();
        AppMethodBeat.o(119948);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119949);
        AppMethodBeat.o(119949);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119944);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            AppMethodBeat.o(119944);
            return;
        }
        AppMethodBeat.o(119944);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        AppMethodBeat.i(119945);
        super.onStart();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.i7h);
        if (relativeLayout != null) {
            relativeLayout.post(new RunnableC1782b(relativeLayout));
            AppMethodBeat.o(119945);
            return;
        }
        AppMethodBeat.o(119945);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.b$b  reason: collision with other inner class name */
    static final class RunnableC1782b implements Runnable {
        final /* synthetic */ RelativeLayout FzR;

        RunnableC1782b(RelativeLayout relativeLayout) {
            this.FzR = relativeLayout;
        }

        public final void run() {
            ViewPropertyAnimator translationY;
            AppMethodBeat.i(119941);
            ViewPropertyAnimator animate = this.FzR.animate();
            if (animate == null || (translationY = animate.translationY(0.0f)) == null) {
                AppMethodBeat.o(119941);
                return;
            }
            translationY.start();
            AppMethodBeat.o(119941);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ b FzS;

        c(b bVar) {
            this.FzS = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119942);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.FzS.isShowing()) {
                this.FzS.cancel();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119942);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ b FzS;

        d(b bVar) {
            this.FzS = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119943);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.FzS.FzP;
            if (aVar != null) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119943);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(119947);
        if (this.targetView instanceof a) {
            View view = this.targetView;
            if (view == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.sns.DialogLifeStyle");
                AppMethodBeat.o(119947);
                throw tVar;
            }
            ((a) view).finish();
        }
        super.cancel();
        AppMethodBeat.o(119947);
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(119946);
        p.h(view, "view");
        getWindow();
        view.findViewById(R.id.i7i).setOnClickListener(new c(this));
        view.findViewById(R.id.i7k).setOnClickListener(new d(this));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.i7h);
        if (relativeLayout != null) {
            relativeLayout.setTranslationY((float) au.az(getContext()).y);
        }
        super.setContentView(view);
        this.targetView = view;
        Window window = getWindow();
        if (window == null) {
            p.hyc();
        }
        window.setLayout(-1, -1);
        if (getWindow() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window2 = getWindow();
                if (window2 == null) {
                    p.hyc();
                }
                p.g(window2, "window!!");
                View decorView = window2.getDecorView();
                p.g(decorView, "window!!.decorView");
                decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
                Window window3 = getWindow();
                if (window3 == null) {
                    p.hyc();
                }
                window3.addFlags(Integer.MIN_VALUE);
                Window window4 = getWindow();
                if (window4 == null) {
                    p.hyc();
                }
                p.g(window4, "window!!");
                window4.setStatusBarColor(0);
            } else {
                Window window5 = getWindow();
                if (window5 == null) {
                    p.hyc();
                }
                window5.addFlags(67108864);
            }
            Window window6 = getWindow();
            if (window6 == null) {
                p.hyc();
            }
            window6.setFlags(134217728, 134217728);
        }
        AppMethodBeat.o(119946);
    }
}
