package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\"\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a extends e {
    private static final String TAG = TAG;
    public static final C0393a hVq = new C0393a((byte) 0);
    private com.tencent.mm.ui.m.b gZR;
    private final b hVm = new b(this);
    private boolean hVn;
    private boolean hVo;
    private boolean hVp;
    private Context mContext;
    private View targetView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.ht);
        p.h(context, "mContext");
        AppMethodBeat.i(208478);
        this.mContext = context;
        gR();
        Context context2 = getContext();
        p.g(context2, "context");
        this.gZR = new com.tencent.mm.ui.m.b(context2);
        AppMethodBeat.o(208478);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    /* renamed from: com.tencent.mm.live.ui.dialog.a$a  reason: collision with other inner class name */
    public static final class C0393a {
        private C0393a() {
        }

        public /* synthetic */ C0393a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(208479);
        AppMethodBeat.o(208479);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
    public static final class b implements com.tencent.mm.search.a.b {
        final /* synthetic */ a hVr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.hVr = aVar;
        }

        @Override // com.tencent.mm.search.a.b
        public final void aJl() {
            long j2 = 0;
            AppMethodBeat.i(208473);
            View view = this.hVr.targetView;
            if (view != null) {
                view.setEnabled(false);
                long height = (long) (((((float) view.getHeight()) - view.getTranslationY()) / ((float) view.getHeight())) * 300.0f);
                if (height >= 0) {
                    j2 = height;
                }
                view.animate().translationY((float) view.getHeight()).setDuration(j2).withEndAction(new RunnableC0394a(this)).start();
                AppMethodBeat.o(208473);
                return;
            }
            AppMethodBeat.o(208473);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        /* renamed from: com.tencent.mm.live.ui.dialog.a$b$a  reason: collision with other inner class name */
        static final class RunnableC0394a implements Runnable {
            final /* synthetic */ b hVs;

            RunnableC0394a(b bVar) {
                this.hVs = bVar;
            }

            public final void run() {
                AppMethodBeat.i(208472);
                new MMHandler().post(new Runnable(this) {
                    /* class com.tencent.mm.live.ui.dialog.a.b.RunnableC0394a.AnonymousClass1 */
                    final /* synthetic */ RunnableC0394a hVt;

                    {
                        this.hVt = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(208471);
                        if (this.hVt.hVs.hVr.isShowing()) {
                            this.hVt.hVs.hVr.cancel();
                        }
                        AppMethodBeat.o(208471);
                    }
                });
                AppMethodBeat.o(208472);
            }
        }
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(208475);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            AppMethodBeat.o(208475);
            return;
        }
        AppMethodBeat.o(208475);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ a hVr;

        c(a aVar) {
            this.hVr = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208474);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.hVr.isShowing()) {
                this.hVr.cancel();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208474);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(208477);
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
            AppMethodBeat.o(208477);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(208477);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        boolean z = false;
        AppMethodBeat.i(208476);
        p.h(view, "view");
        Window window = getWindow();
        if (window == null) {
            p.hyc();
        }
        window.setGravity(80);
        window.setWindowAnimations(R.style.fs);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Resources resources = this.mContext.getResources();
        p.g(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            z = true;
        }
        if (z) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        view.findViewById(R.id.ejp).setOnClickListener(new c(this));
        super.setContentView(view);
        this.targetView = view;
        this.gZR.a(new com.tencent.mm.search.a.a(view, this.hVm));
        Window window2 = getWindow();
        if (window2 == null) {
            p.hyc();
        }
        window2.setLayout(-1, -1);
        AppMethodBeat.o(208476);
    }
}
