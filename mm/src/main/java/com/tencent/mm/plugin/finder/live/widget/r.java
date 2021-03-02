package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "globalLayoutCallbackCount", "", "globalLayoutCallbackFrequency", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "plugin-finder_release"})
public final class r {
    private final String TAG = "Finder.FinderLiveVisitorShoppingEntranceWidget";
    final b hOp;
    public final ViewGroup hwr;
    public final d uFw;
    int uHO;
    final int uHP;

    public r(ViewGroup viewGroup, b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248188);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        c cVar = c.vCb;
        this.uHP = c.duY().value().intValue();
        this.hwr.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.r.AnonymousClass1 */
            final /* synthetic */ r uHQ;

            {
                this.uHQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248184);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bo boVar = this.uHQ.uFw.getLiveData().UPW;
                Bundle bundle = new Bundle();
                if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                    bundle.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko);
                } else if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                    bundle.putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE);
                }
                this.uHQ.hOp.statusChange(b.c.hMZ, bundle);
                a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248184);
            }
        });
        this.hwr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.r.AnonymousClass2 */
            final /* synthetic */ r uHQ;

            {
                this.uHQ = r1;
            }

            public final void onGlobalLayout() {
                bd shoppingBubblePlugin;
                Integer num = null;
                AppMethodBeat.i(248185);
                r rVar = this.uHQ;
                int i2 = rVar.uHO;
                rVar.uHO = i2 + 1;
                if (i2 >= Integer.MAX_VALUE) {
                    this.uHQ.uHO = 0;
                }
                if (this.uHQ.uHO % this.uHQ.uHP == 0) {
                    b bVar = this.uHQ.hOp;
                    if (!(bVar instanceof FinderLiveVisitorPluginLayout)) {
                        bVar = null;
                    }
                    FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = (FinderLiveVisitorPluginLayout) bVar;
                    if (!(finderLiveVisitorPluginLayout == null || (shoppingBubblePlugin = finderLiveVisitorPluginLayout.getShoppingBubblePlugin()) == null)) {
                        m mVar = m.vVH;
                        if (!m.dBP() && shoppingBubblePlugin.hwr.getVisibility() == 0) {
                            l lVar = shoppingBubblePlugin.utB;
                            int[] iArr = new int[2];
                            lVar.uHq.getLocationInWindow(iArr);
                            y yVar = y.vXH;
                            View view = lVar.uHi;
                            ViewGroup viewGroup = lVar.ulG;
                            if (!(view == null || viewGroup == null)) {
                                int[] iArr2 = new int[2];
                                viewGroup.getLocationInWindow(iArr2);
                                int i3 = iArr2[0];
                                ViewGroup viewGroup2 = lVar.ulG;
                                if (viewGroup2 == null) {
                                    p.hyc();
                                }
                                int width = (i3 + viewGroup2.getWidth()) - iArr[0];
                                View view2 = lVar.uHi;
                                if (view2 == null) {
                                    p.hyc();
                                }
                                int mZ = j.mZ((width - (view2.getWidth() / 2)) - (lVar.uHq.getWidth() / 2), 0);
                                float f2 = -((float) mZ);
                                View view3 = lVar.uHi;
                                if (view3 == null) {
                                    p.hyc();
                                }
                                if (f2 != view3.getTranslationX()) {
                                    String str = lVar.TAG;
                                    StringBuilder append = new StringBuilder("[visitor add shopping bubble] arrow:").append(lVar.uHi).append(" container:").append(lVar.ulG).append(" container.right:");
                                    ViewGroup viewGroup3 = lVar.ulG;
                                    StringBuilder append2 = append.append(viewGroup3 != null ? Integer.valueOf(viewGroup3.getRight()) : null).append(" loc:").append(iArr[0]).append(',').append(iArr[1]).append(" arrow.width:");
                                    View view4 = lVar.uHi;
                                    if (view4 != null) {
                                        num = Integer.valueOf(view4.getWidth());
                                    }
                                    Log.i(str, append2.append(num).append(" entranceRoot.width:").append(lVar.uHq.getWidth()).append(",arrowMarginEnd:").append(mZ).toString());
                                }
                                view.setTranslationX(-((float) mZ));
                            }
                        }
                        AppMethodBeat.o(248185);
                        return;
                    }
                }
                AppMethodBeat.o(248185);
            }
        });
        Log.i(this.TAG, "init globalLayoutCallbackFrequency:" + this.uHP);
        AppMethodBeat.o(248188);
    }

    public final void rg(int i2) {
        AppMethodBeat.i(248186);
        if (this.uFw.getLiveData().isLiveStarted() || i2 != 0) {
            this.hwr.setVisibility(i2);
            AppMethodBeat.o(248186);
            return;
        }
        o oVar = o.ujN;
        s finderLiveAssistant = o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.ag(this.hwr, i2);
            AppMethodBeat.o(248186);
            return;
        }
        AppMethodBeat.o(248186);
    }

    public final boolean isVisible() {
        AppMethodBeat.i(248187);
        if (this.hwr.getVisibility() == 0) {
            AppMethodBeat.o(248187);
            return true;
        }
        AppMethodBeat.o(248187);
        return false;
    }
}
