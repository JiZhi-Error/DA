package com.tencent.mm.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.ca.a;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.emoji.b.b.i;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.c.c;
import com.tencent.mm.emoji.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.d.a;
import java.util.Iterator;
import kotlin.g.b.p;

public class SmileyPanelImpl extends SmileyPanel implements LifecycleObserver {
    private final a RmS;
    private boolean RmT;
    private final String TAG;
    private boolean aMn;

    public SmileyPanelImpl(Context context, boolean z) {
        this(context, null, z);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SmileyPanelImpl(android.content.Context r9, android.util.AttributeSet r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.view.SmileyPanelImpl.<init>(android.content.Context, android.util.AttributeSet, boolean):void");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        AppMethodBeat.i(105187);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onActivityDestroy:%s", getContext());
        destroy();
        AppMethodBeat.o(105187);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void onResume() {
        AppMethodBeat.i(105188);
        Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        if (!this.RmT) {
            this.RmT = true;
            a aVar = this.RmS;
            aVar.RpL.avu();
            aVar.RpK.avt();
        }
        AppMethodBeat.o(105188);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void goF() {
        AppMethodBeat.i(105189);
        this.RmS.apY(0);
        AppMethodBeat.o(105189);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void onPause() {
        AppMethodBeat.i(105190);
        Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        ((d) g.ah(d.class)).getProvider().cFR();
        a aVar = this.RmS;
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "saveSelectedTab: %s", aVar.RpA);
        j auL = j.auL();
        auL.gXo = aVar.RpA;
        if (MMApplicationContext.isMainProcess()) {
            g.aAh().azQ().set(-29414086, auL.gXo);
            AppMethodBeat.o(105190);
            return;
        }
        com.tencent.mm.ca.a.gvc();
        a.b bVar = com.tencent.mm.ca.a.NCN;
        a.b.bhD(auL.gXo);
        AppMethodBeat.o(105190);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void destroy() {
        AppMethodBeat.i(105191);
        if (this.aMn) {
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: has destroyed");
            AppMethodBeat.o(105191);
            return;
        }
        this.aMn = true;
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "destroy: ");
        this.Kbz = null;
        this.RmS.RpW.dead();
        this.RmS.onDestroy();
        ((d) g.ah(d.class)).getProvider().cFR();
        ((d) g.ah(d.class)).getProvider().onDestroy();
        AppMethodBeat.o(105191);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(105192);
        super.onAttachedToWindow();
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onAttachedToWindow");
        com.tencent.mm.view.d.a aVar = this.RmS;
        if (aVar.RpB) {
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "listener added %s", aVar);
            AppMethodBeat.o(105192);
            return;
        }
        aVar.RpB = true;
        ((d) g.ah(d.class)).getProvider().k(aVar.wKe);
        ((d) g.ah(d.class)).getProvider().i(aVar.wKf);
        EventCenter.instance.addListener(aVar.wKg);
        EventCenter.instance.addListener(aVar.RpT);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener. %s", aVar);
        AppMethodBeat.o(105192);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(105193);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDetachedFromWindow");
        this.RmS.removeListener();
        AppMethodBeat.o(105193);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setCallback(f fVar) {
        AppMethodBeat.i(105194);
        super.setCallback(fVar);
        com.tencent.mm.view.d.a aVar = this.RmS;
        com.tencent.mm.pluginsdk.ui.chat.j jVar = (com.tencent.mm.pluginsdk.ui.chat.j) fVar;
        aVar.rgI = jVar;
        aVar.RpE.haC = jVar;
        AppMethodBeat.o(105194);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setOnTextOperationListener(ChatFooterPanel.a aVar) {
        AppMethodBeat.i(105195);
        super.setOnTextOperationListener(aVar);
        com.tencent.mm.view.d.a aVar2 = this.RmS;
        aVar2.har = aVar;
        aVar2.RpE.har = aVar;
        aVar2.RpD.har = aVar;
        AppMethodBeat.o(105195);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setSendButtonEnable(boolean z) {
        AppMethodBeat.i(105196);
        i iVar = this.RmS.RpK;
        iVar.gYo = z;
        Iterator<T> it = iVar.gYq.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        AppMethodBeat.o(105196);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void goC() {
        this.Kbz = null;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setShowSmiley(boolean z) {
        this.RmS.RpK.gYg = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setShowStore(boolean z) {
        AppMethodBeat.i(105197);
        this.RmS.setShowStore(z);
        AppMethodBeat.o(105197);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setShowSend(boolean z) {
        AppMethodBeat.i(105198);
        this.RmS.setShowSend(z);
        AppMethodBeat.o(105198);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setShowClose(boolean z) {
        AppMethodBeat.i(105199);
        com.tencent.mm.view.d.a aVar = this.RmS;
        aVar.RpG.setVisibility(z ? 0 : 8);
        if (z) {
            aVar.RpF.setBackgroundResource(R.drawable.emoji_panel_tab_bg_corner);
            AppMethodBeat.o(105199);
            return;
        }
        View view = aVar.RpF;
        View view2 = aVar.RpF;
        p.h(view2, "$this$getAttrResId");
        TypedValue typedValue = new TypedValue();
        Context context = view2.getContext();
        p.g(context, "context");
        context.getTheme().resolveAttribute(R.attr.kf, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
        AppMethodBeat.o(105199);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void goD() {
        boolean z = true;
        AppMethodBeat.i(105200);
        com.tencent.mm.view.d.a aVar = this.RmS;
        boolean z2 = aVar.RpK.gYh || aVar.RpK.gYj;
        aVar.RpK.gYh = false;
        aVar.RpK.gYj = false;
        if (z2) {
            aVar.RpL.avu();
        }
        com.tencent.mm.view.d.a aVar2 = this.RmS;
        if (!aVar2.RpK.gYk && !aVar2.RpK.gYl) {
            z = false;
        }
        aVar2.RpK.gYk = false;
        aVar2.RpK.gYl = false;
        if (z) {
            aVar2.RpL.avu();
        }
        this.RmS.setShowStore(false);
        AppMethodBeat.o(105200);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void zN(boolean z) {
        AppMethodBeat.i(199828);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", Boolean.valueOf(z), Boolean.FALSE);
        AppMethodBeat.o(199828);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public final void goE() {
        AppMethodBeat.i(169244);
        this.RmS.setShowSend(false);
        AppMethodBeat.o(169244);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setPortHeightPx(int i2) {
        AppMethodBeat.i(105202);
        Log.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", Integer.valueOf(i2));
        AppMethodBeat.o(105202);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(105203);
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onSizeChanged: %s, %s; %s, %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.RmS != null) {
            com.tencent.mm.view.d.a aVar = this.RmS;
            aVar.RpQ.pn(i2);
            aVar.RpP.pn(i2);
            aVar.RpK.gYp = aVar.RpQ.att;
            int dimensionPixelSize = aVar.context.getResources().getDimensionPixelSize(R.dimen.a36);
            ViewGroup.LayoutParams layoutParams = aVar.RpH.getLayoutParams();
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "updateViewSize: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(dimensionPixelSize));
            if (i3 >= dimensionPixelSize * 4) {
                dimensionPixelSize = aVar.context.getResources().getDimensionPixelSize(R.dimen.a35);
            }
            if (layoutParams.height != dimensionPixelSize) {
                layoutParams.height = dimensionPixelSize;
                aVar.RpH.setLayoutParams(layoutParams);
                aVar.RpH.post(new Runnable() {
                    /* class com.tencent.mm.view.d.a.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(105284);
                        a.this.RpH.requestLayout();
                        AppMethodBeat.o(105284);
                    }
                });
            }
            c.awc().hch = aVar.RpQ.att;
            h.awf().hch = aVar.RpP.att;
        }
        AppMethodBeat.o(105203);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(105204);
        super.setVisibility(i2);
        if (i2 == 0) {
            com.tencent.mm.view.d.a aVar = this.RmS;
            Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onResume: ");
            aVar.isResume = true;
            aVar.RpK.avt();
            if (aVar.RpO != null) {
                aVar.RpO.avu();
            }
            if (aVar.har != null) {
                aVar.har.eP(aVar.RpN);
            }
            if (aVar.isResume) {
                if (Util.isEqual(aVar.RpA, ad.avD()) && aVar.RpK.gYl) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15982, 0);
                }
                com.tencent.mm.emoji.c.d dVar = com.tencent.mm.emoji.c.d.hcj;
                com.tencent.mm.emoji.c.d.pl(1);
                if (aVar.RpS != null) {
                    com.tencent.mm.plugin.emoji.ui.c cVar = aVar.RpS.rgF;
                    if (cVar.rgP.hasFocus()) {
                        cVar.rgP.awC();
                    }
                }
            }
            AppMethodBeat.o(105204);
            return;
        }
        com.tencent.mm.view.d.a aVar2 = this.RmS;
        Log.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "onPause: ");
        aVar2.isResume = false;
        aVar2.RpR.clear();
        AppMethodBeat.o(105204);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setTalkerName(String str) {
        AppMethodBeat.i(105205);
        com.tencent.mm.view.d.a aVar = this.RmS;
        aVar.rgD = str;
        aVar.RpE.haD = str;
        boolean z = Util.isNullOrNil(str) || (!as.bjp(str) && !ab.Iy(str));
        if (aVar.RpK.gYi != z) {
            aVar.RpK.gYi = z;
            aVar.RpL.avu();
        }
        if (as.bju(aVar.rgD) && aVar.RpK.gYk) {
            aVar.RpK.gYk = false;
            aVar.RpL.avu();
        }
        AppMethodBeat.o(105205);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setToSendText(String str) {
        this.RmS.rgH = str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setDefaultEmojiByDetail(String str) {
        AppMethodBeat.i(105206);
        this.RmS.blU(str);
        this.RmS.RpW.alive();
        AppMethodBeat.o(105206);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel
    public void setEntranceScene(int i2) {
        boolean z;
        AppMethodBeat.i(105207);
        com.tencent.mm.view.d.a aVar = this.RmS;
        h.awf().scene = i2;
        c.awc().scene = i2;
        com.tencent.mm.emoji.c.g gVar = com.tencent.mm.emoji.c.g.hcn;
        com.tencent.mm.emoji.c.g.setScene(i2);
        int i3 = aVar.RpK.scene;
        aVar.RpK.scene = i2;
        aVar.RpK.gYl = i.pf(i2);
        aVar.RpK.gYj = i.pg(i2);
        i iVar = aVar.RpK;
        if (i2 == ChatFooterPanel.KbC) {
            z = true;
        } else {
            z = false;
        }
        iVar.gYf = z;
        if (i3 != i2) {
            aVar.RpL.avu();
        }
        aVar.RpE.scene = i2;
        AppMethodBeat.o(105207);
    }

    @Override // com.tencent.mm.api.SmileyPanel
    public void set16029ExtraInfo(String str) {
        AppMethodBeat.i(105208);
        h.awf().extraInfo = str;
        AppMethodBeat.o(105208);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(199829);
        com.tencent.mm.view.d.a aVar = this.RmS;
        com.tencent.mm.emoji.b.b.j jVar = aVar.RpL;
        p.h(nVar, "externalPanelProvider");
        jVar.gYv.add(nVar);
        aVar.RpL.avu();
        AppMethodBeat.o(199829);
    }
}
