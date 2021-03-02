package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ad;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u0018\u0000 /2\u00020\u0001:\u0001/B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0002J\u0012\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020 H\u0014J\u0010\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "talkName", "", "toSendText", "panelCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "needCancelTouch", "getPanelCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getTalkName", "()Ljava/lang/String;", "targetView", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView;", "getToSendText", "checkFocus", "", "dismiss", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "show", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b extends e {
    public static final a rgJ = new a((byte) 0);
    private com.tencent.mm.ui.m.b gZR;
    private boolean hVn;
    private boolean hVo;
    private boolean hVp;
    private Context mContext;
    final String rgD;
    public c rgF = new c(new u(this.mContext, R.style.i4), this.rgD, this.rgH, this, this.rgI);
    private final C0962b rgG;
    private final String rgH;
    private final j rgI;

    static {
        AppMethodBeat.i(200055);
        AppMethodBeat.o(200055);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, String str, String str2, j jVar) {
        super(context, R.style.i3);
        p.h(context, "mContext");
        p.h(str, "talkName");
        p.h(str2, "toSendText");
        p.h(jVar, "panelCallback");
        AppMethodBeat.i(200054);
        this.mContext = context;
        this.rgD = str;
        this.rgH = str2;
        this.rgI = jVar;
        gR();
        Context context2 = getContext();
        p.g(context2, "context");
        this.gZR = new com.tencent.mm.ui.m.b(context2);
        this.rgF.cHs();
        this.rgG = new C0962b(this);
        AppMethodBeat.o(200054);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(200047);
        super.onCreate(bundle);
        j jVar = this.rgI;
        Context context = getContext();
        p.g(context, "context");
        jVar.N(true, context.getResources().getDimensionPixelOffset(R.dimen.c4));
        setContentView(this.rgF);
        AppMethodBeat.o(200047);
    }

    public final void show() {
        AppMethodBeat.i(200048);
        Log.i("MicroMsg.EmojiSearch", "dialog show");
        super.show();
        c cVar = this.rgF;
        if (cVar != null) {
            if (Util.isNullOrNil(cVar.rgH)) {
                cVar.het = 1;
                cVar.rgP.awD();
                cVar.rgP.awC();
            } else {
                cVar.het = 2;
            }
        }
        com.tencent.mm.emojisearch.d.a aVar = com.tencent.mm.emojisearch.d.a.hew;
        com.tencent.mm.emojisearch.d.a.Fb(this.rgD);
        AppMethodBeat.o(200048);
    }

    @Override // android.support.v7.app.e
    public final void onStop() {
        AppMethodBeat.i(200049);
        Log.i("MicroMsg.EmojiSearch", "dialog onStop");
        super.onStop();
        this.rgF.rgN.onDestroy();
        AppMethodBeat.o(200049);
    }

    public final void dismiss() {
        AppMethodBeat.i(200050);
        Log.i("MicroMsg.EmojiSearch", "dialog dismiss");
        this.rgF.hideVKB();
        super.dismiss();
        this.rgI.N(false, 0);
        AppMethodBeat.o(200050);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.plugin.emoji.ui.b$b  reason: collision with other inner class name */
    public static final class C0962b implements com.tencent.mm.search.a.b {
        final /* synthetic */ b rgK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0962b(b bVar) {
            this.rgK = bVar;
        }

        @Override // com.tencent.mm.search.a.b
        public final void aJl() {
            long j2 = 0;
            AppMethodBeat.i(200046);
            c cVar = this.rgK.rgF;
            cVar.setEnabled(false);
            long height = (long) (((((float) cVar.getHeight()) - cVar.getTranslationY()) / ((float) cVar.getHeight())) * 300.0f);
            if (height >= 0) {
                j2 = height;
            }
            cVar.animate().translationY((float) cVar.getHeight()).setDuration(j2).withEndAction(new a(this)).start();
            AppMethodBeat.o(200046);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        /* renamed from: com.tencent.mm.plugin.emoji.ui.b$b$a */
        static final class a implements Runnable {
            final /* synthetic */ C0962b rgL;

            a(C0962b bVar) {
                this.rgL = bVar;
            }

            public final void run() {
                AppMethodBeat.i(200045);
                new MMHandler().post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.emoji.ui.b.C0962b.a.AnonymousClass1 */
                    final /* synthetic */ a rgM;

                    {
                        this.rgM = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(200044);
                        if (this.rgM.rgL.rgK.isShowing()) {
                            this.rgM.rgL.rgK.cancel();
                        }
                        AppMethodBeat.o(200044);
                    }
                });
                AppMethodBeat.o(200045);
            }
        }
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(200051);
        Resources resources = this.mContext.getResources();
        p.g(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(200051);
            return true;
        }
        AppMethodBeat.o(200051);
        return false;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(200053);
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
            AppMethodBeat.o(200053);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(200053);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(200052);
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
        int bD = ad.bD(getContext());
        Context context = getContext();
        p.g(context, "context");
        super.setContentView(view, new ViewGroup.LayoutParams(-1, bD + context.getResources().getDimensionPixelOffset(R.dimen.c_)));
        Window window2 = getWindow();
        if (window2 == null) {
            p.hyc();
        }
        window2.setLayout(-1, -2);
        Window window3 = getWindow();
        if (window3 == null) {
            p.hyc();
        }
        window3.setFlags(256, 256);
        AppMethodBeat.o(200052);
    }
}
