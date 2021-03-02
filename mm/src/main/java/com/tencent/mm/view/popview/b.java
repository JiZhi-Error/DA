package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.popview.AbstractPopView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", e.a.NAME, "", "anchor", "item", "", "onMove", "onOutsideTouched", e.C0599e.NAME, "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b extends a implements com.tencent.mm.vending.e.a {
    EmojiPopView Rqb;
    private View Rqc;
    private final String TAG = "MicroMsg.EmojiOperatePopupHelper";
    private final Context context;
    private final int type;
    final WindowManager windowManager;

    public b(Context context2, int i2) {
        p.h(context2, "context");
        AppMethodBeat.i(184003);
        this.context = context2;
        this.type = i2;
        Object systemService = this.context.getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(184003);
            throw tVar;
        }
        this.windowManager = (WindowManager) systemService;
        AppMethodBeat.o(184003);
    }

    @Override // com.tencent.mm.view.popview.a
    public final boolean c(View view, Object obj) {
        AppMethodBeat.i(183998);
        p.h(view, "anchor");
        if (!(obj instanceof h) || !view.isEnabled()) {
            AppMethodBeat.o(183998);
            return false;
        }
        this.Rqc = view;
        view.setPressed(true);
        e(view, obj);
        AppMethodBeat.o(183998);
        return true;
    }

    @Override // com.tencent.mm.view.popview.a
    public final void d(View view, Object obj) {
        AppMethodBeat.i(183999);
        p.h(view, "anchor");
        view.setPressed(true);
        if (p.j(this.Rqc, view)) {
            AppMethodBeat.o(183999);
            return;
        }
        View view2 = this.Rqc;
        if (view2 != null) {
            view2.setPressed(false);
        }
        this.Rqc = view;
        e(view, obj);
        AppMethodBeat.o(183999);
    }

    @Override // com.tencent.mm.view.popview.a
    public final void fdM() {
        AppMethodBeat.i(184000);
        View view = this.Rqc;
        if (view != null) {
            view.setPressed(false);
            AppMethodBeat.o(184000);
            return;
        }
        AppMethodBeat.o(184000);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(200102);
        hgq();
        AppMethodBeat.o(200102);
    }

    private final void e(View view, Object obj) {
        WindowManager.LayoutParams layoutParams = null;
        AppMethodBeat.i(184002);
        if (!(obj instanceof h) || !view.isEnabled()) {
            EmojiPopView emojiPopView = this.Rqb;
            if (emojiPopView != null) {
                emojiPopView.setVisibility(8);
                AppMethodBeat.o(184002);
                return;
            }
            AppMethodBeat.o(184002);
            return;
        }
        if (this.type == 2 || this.type == 3 || this.type == 4) {
            com.tencent.mm.emoji.c.e eVar = com.tencent.mm.emoji.c.e.hcl;
            com.tencent.mm.emoji.c.e.awe().iv(((h) obj).gWm.avy());
        }
        com.tencent.mm.emoji.c.e eVar2 = com.tencent.mm.emoji.c.e.hcl;
        com.tencent.mm.emoji.c.e.ps(this.type);
        com.tencent.mm.emoji.c.e eVar3 = com.tencent.mm.emoji.c.e.hcl;
        com.tencent.mm.emoji.c.e.awe().iw(((h) obj).gWm.getMd5());
        com.tencent.mm.emoji.c.e eVar4 = com.tencent.mm.emoji.c.e.hcl;
        com.tencent.mm.emoji.c.e.pl(1);
        view.setPressed(true);
        if (this.Rqb == null) {
            this.Rqb = new EmojiPopView(this.context);
            EmojiPopView emojiPopView2 = this.Rqb;
            if (emojiPopView2 != null) {
                emojiPopView2.setOnDismissCallback(new a(this));
            }
            WindowManager windowManager2 = this.windowManager;
            EmojiPopView emojiPopView3 = this.Rqb;
            EmojiPopView emojiPopView4 = this.Rqb;
            if (emojiPopView4 != null) {
                layoutParams = emojiPopView4.getWindowLayoutParams();
            }
            windowManager2.addView(emojiPopView3, layoutParams);
            EmojiPopView emojiPopView5 = this.Rqb;
            if (emojiPopView5 != null) {
                emojiPopView5.setVisibility(4);
            }
        } else {
            EmojiPopView emojiPopView6 = this.Rqb;
            if (emojiPopView6 != null) {
                emojiPopView6.hI(view);
            }
            WindowManager windowManager3 = this.windowManager;
            EmojiPopView emojiPopView7 = this.Rqb;
            EmojiPopView emojiPopView8 = this.Rqb;
            if (emojiPopView8 != null) {
                layoutParams = emojiPopView8.getWindowLayoutParams();
            }
            windowManager3.updateViewLayout(emojiPopView7, layoutParams);
        }
        EmojiPopView emojiPopView9 = this.Rqb;
        if (emojiPopView9 != null) {
            emojiPopView9.post(new RunnableC2162b(this, view));
        }
        EmojiPopView emojiPopView10 = this.Rqb;
        if (emojiPopView10 != null) {
            emojiPopView10.setEmojiInfo(((h) obj).gWm);
        }
        EmojiPopView emojiPopView11 = this.Rqb;
        if (emojiPopView11 != null) {
            emojiPopView11.setPopupType(this.type);
            AppMethodBeat.o(184002);
            return;
        }
        AppMethodBeat.o(184002);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class a implements AbstractPopView.a {
        final /* synthetic */ b Rqd;

        a(b bVar) {
            this.Rqd = bVar;
        }

        @Override // com.tencent.mm.view.popview.AbstractPopView.a
        public final void onDismiss() {
            AppMethodBeat.i(183996);
            this.Rqd.hgq();
            AppMethodBeat.o(183996);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.view.popview.b$b  reason: collision with other inner class name */
    public static final class RunnableC2162b implements Runnable {
        final /* synthetic */ b Rqd;
        final /* synthetic */ View Rqe;

        RunnableC2162b(b bVar, View view) {
            this.Rqd = bVar;
            this.Rqe = view;
        }

        public final void run() {
            AppMethodBeat.i(183997);
            if (this.Rqd.Rqb != null) {
                EmojiPopView emojiPopView = this.Rqd.Rqb;
                if (emojiPopView != null) {
                    emojiPopView.setVisibility(0);
                }
                EmojiPopView emojiPopView2 = this.Rqd.Rqb;
                if (emojiPopView2 != null) {
                    emojiPopView2.hI(this.Rqe);
                }
                WindowManager windowManager = this.Rqd.windowManager;
                EmojiPopView emojiPopView3 = this.Rqd.Rqb;
                EmojiPopView emojiPopView4 = this.Rqd.Rqb;
                windowManager.updateViewLayout(emojiPopView3, emojiPopView4 != null ? emojiPopView4.getWindowLayoutParams() : null);
            }
            AppMethodBeat.o(183997);
        }
    }

    /* access modifiers changed from: package-private */
    public final void hgq() {
        AppMethodBeat.i(200103);
        Log.i(this.TAG, "removePopup: " + this.Rqb);
        View view = this.Rqc;
        if (view != null) {
            view.setPressed(false);
        }
        this.Rqc = null;
        EmojiPopView emojiPopView = this.Rqb;
        if (emojiPopView != null) {
            this.windowManager.removeView(emojiPopView);
        }
        this.Rqb = null;
        AppMethodBeat.o(200103);
    }
}
