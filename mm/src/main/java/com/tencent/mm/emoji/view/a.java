package com.tencent.mm.emoji.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ad;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, hxF = {"Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/content/Context;", "panelRoot", "Landroid/widget/FrameLayout;", "getPanelRoot", "()Landroid/widget/FrameLayout;", "getParent", "()Landroid/view/ViewGroup;", "smileyPanel", "Lcom/tencent/mm/view/SmileyPanelImpl;", "getSmileyPanel", "()Lcom/tencent/mm/view/SmileyPanelImpl;", "addExternalPanel", "", "externalPanelDataProvider", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "destroy", "dismiss", "isShow", "setCallback", "callback", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "show", "plugin-emojisdk_release"})
public class a {
    private final Context context;
    public final FrameLayout hed = new FrameLayout(this.context);
    public final SmileyPanelImpl hee;
    private final ViewGroup parent;

    public a(Context context2, ViewGroup viewGroup) {
        p.h(context2, "context");
        p.h(viewGroup, "parent");
        AppMethodBeat.i(105798);
        this.context = context2;
        this.parent = viewGroup;
        this.parent.addView(this.hed, new ViewGroup.LayoutParams(-1, -1));
        this.hed.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.emoji.view.a.AnonymousClass1 */
            final /* synthetic */ a hef;

            {
                this.hef = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105794);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hef.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/view/EmojiPanelBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105794);
            }
        });
        SmileyPanel l = ad.l(this.context, true);
        if (l == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.SmileyPanelImpl");
            AppMethodBeat.o(105798);
            throw tVar;
        }
        this.hee = (SmileyPanelImpl) l;
        this.hee.setEntranceScene(ChatFooterPanel.KbD);
        this.hee.setShowSmiley(false);
        this.hee.setShowClose(true);
        this.hee.onResume();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ad.bD(this.context));
        layoutParams.gravity = 80;
        this.hed.addView(this.hee, layoutParams);
        this.hed.setVisibility(8);
        this.hee.setVisibility(8);
        this.hee.setTranslationY((float) layoutParams.height);
        AppMethodBeat.o(105798);
    }

    public void show() {
        AppMethodBeat.i(105796);
        this.hee.setPadding(0, 0, 0, au.aD(this.context));
        this.hed.setVisibility(0);
        this.hee.setVisibility(0);
        this.hee.animate().translationY(0.0f).start();
        AppMethodBeat.o(105796);
    }

    public void dismiss() {
        AppMethodBeat.i(105797);
        this.hee.animate().translationY((float) this.hee.getLayoutParams().height).withEndAction(new RunnableC0339a(this));
        AppMethodBeat.o(105797);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.emoji.view.a$a  reason: collision with other inner class name */
    public static final class RunnableC0339a implements Runnable {
        final /* synthetic */ a hef;

        RunnableC0339a(a aVar) {
            this.hef = aVar;
        }

        public final void run() {
            AppMethodBeat.i(105795);
            this.hef.hed.setVisibility(8);
            this.hef.hee.setVisibility(8);
            AppMethodBeat.o(105795);
        }
    }
}
