package com.tencent.mm.search.d;

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
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.search.d.c;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0011\u0018\u0000 .2\u00020\u0001:\u0001.B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0006\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0002J\u0012\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\bH\u0014J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "dismiss", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/jvm/functions/Function0;)V", "commentScrolling", "", "getDismiss", "()Lkotlin/jvm/functions/Function0;", "setDismiss", "(Lkotlin/jvm/functions/Function0;)V", "galleryScale", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "needCancelTouch", "targetView", "Lcom/tencent/mm/search/ui/SimilarEmojiView;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b extends e {
    public static final a NJF = new a((byte) 0);
    private SimilarEmojiQueryModel INC;
    private c NJD = new c(new u(this.mContext, R.style.i4), this);
    private final C2058b NJE;
    private com.tencent.mm.ui.m.b gZR;
    private boolean hVn;
    private boolean hVo;
    private boolean hVp;
    private kotlin.g.a.a<x> hen;
    private Context mContext;

    static {
        AppMethodBeat.i(105877);
        AppMethodBeat.o(105877);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, SimilarEmojiQueryModel similarEmojiQueryModel, kotlin.g.a.a<x> aVar) {
        super(context, R.style.ht);
        p.h(context, "mContext");
        p.h(similarEmojiQueryModel, "model");
        p.h(aVar, "dismiss");
        AppMethodBeat.i(105876);
        this.mContext = context;
        this.INC = similarEmojiQueryModel;
        this.hen = aVar;
        gR();
        Context context2 = getContext();
        p.g(context2, "context");
        this.gZR = new com.tencent.mm.ui.m.b(context2);
        c cVar = this.NJD;
        SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INC;
        p.h(similarEmojiQueryModel2, "model");
        cVar.NJm = similarEmojiQueryModel2.NJm;
        if (similarEmojiQueryModel2.gau()) {
            com.tencent.mm.kernel.b.a ah = g.ah(d.class);
            p.g(ah, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
            EmojiInfo aml = ((d) ah).getEmojiMgr().aml(similarEmojiQueryModel2.emojiMD5);
            a aVar2 = cVar.INF;
            p.g(aml, "head");
            aVar2.F(aml);
        } else {
            a.a(cVar.INF);
        }
        cVar.INF.NJB = false;
        cVar.INF.gxB();
        cVar.INF.notifyDataSetChanged();
        n nVar = cVar.INF.haK;
        if (nVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.search.logic.SimilarEmojiPanelClickListener");
            AppMethodBeat.o(105876);
            throw tVar;
        }
        ((com.tencent.mm.search.b.b) nVar).hek = similarEmojiQueryModel2;
        n nVar2 = cVar.INF.haK;
        if (nVar2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.emoji.panel.adapter.EmojiPanelClickListener");
            AppMethodBeat.o(105876);
            throw tVar2;
        }
        ((com.tencent.mm.emoji.panel.a.d) nVar2).haC = similarEmojiQueryModel2.NJn;
        cVar.NJJ.b(similarEmojiQueryModel2, new c.b(cVar, similarEmojiQueryModel2));
        this.NJE = new C2058b(this);
        AppMethodBeat.o(105876);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiDialog$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(105870);
        super.onCreate(bundle);
        setContentView(this.NJD);
        Log.i("MicroMsg.SimilarEmoji", "dialog onCreate " + this.INC);
        j jVar = this.INC.NJn;
        if (jVar != null) {
            com.tencent.mm.search.b.a aVar = com.tencent.mm.search.b.a.NJs;
            com.tencent.mm.search.b.a.a(jVar);
            AppMethodBeat.o(105870);
            return;
        }
        AppMethodBeat.o(105870);
    }

    @Override // android.support.v7.app.e
    public final void onStop() {
        AppMethodBeat.i(105871);
        Log.i("MicroMsg.SimilarEmoji", "dialog onStop");
        super.onStop();
        this.NJD.NJJ.onDestroy();
        com.tencent.mm.search.b.a aVar = com.tencent.mm.search.b.a.NJs;
        com.tencent.mm.search.b.a.destroy();
        AppMethodBeat.o(105871);
    }

    public final void dismiss() {
        AppMethodBeat.i(105872);
        Log.i("MicroMsg.SimilarEmoji", "dialog dismiss");
        super.dismiss();
        this.hen.invoke();
        AppMethodBeat.o(105872);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.search.d.b$b  reason: collision with other inner class name */
    public static final class C2058b implements com.tencent.mm.search.a.b {
        final /* synthetic */ b NJG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C2058b(b bVar) {
            this.NJG = bVar;
        }

        @Override // com.tencent.mm.search.a.b
        public final void aJl() {
            long j2 = 0;
            AppMethodBeat.i(200093);
            c cVar = this.NJG.NJD;
            cVar.setEnabled(false);
            long height = (long) (((((float) cVar.getHeight()) - cVar.getTranslationY()) / ((float) cVar.getHeight())) * 300.0f);
            if (height >= 0) {
                j2 = height;
            }
            cVar.animate().translationY((float) cVar.getHeight()).setDuration(j2).withEndAction(new a(this)).start();
            AppMethodBeat.o(200093);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
        /* renamed from: com.tencent.mm.search.d.b$b$a */
        static final class a implements Runnable {
            final /* synthetic */ C2058b NJH;

            a(C2058b bVar) {
                this.NJH = bVar;
            }

            public final void run() {
                AppMethodBeat.i(200092);
                new MMHandler().post(new Runnable(this) {
                    /* class com.tencent.mm.search.d.b.C2058b.a.AnonymousClass1 */
                    final /* synthetic */ a NJI;

                    {
                        this.NJI = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(200091);
                        if (this.NJI.NJH.NJG.isShowing()) {
                            this.NJI.NJH.NJG.cancel();
                        }
                        AppMethodBeat.o(200091);
                    }
                });
                AppMethodBeat.o(200092);
            }
        }
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(105873);
        Resources resources = this.mContext.getResources();
        p.g(resources, "mContext.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(105873);
            return true;
        }
        AppMethodBeat.o(105873);
        return false;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(105875);
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
            AppMethodBeat.o(105875);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(105875);
        return dispatchTouchEvent;
    }

    @Override // android.support.v7.app.e, android.app.Dialog
    public final void setContentView(View view) {
        AppMethodBeat.i(105874);
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
        super.setContentView(view, new ViewGroup.LayoutParams(-1, bD + (context.getResources().getDimensionPixelOffset(R.dimen.cp) * 1)));
        Window window2 = getWindow();
        if (window2 == null) {
            p.hyc();
        }
        window2.setLayout(-1, -2);
        AppMethodBeat.o(105874);
    }
}
