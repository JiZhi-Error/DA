package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.au;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0002J\"\u0010/\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020.H\u0016J\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u000201H\u0016J\u0006\u00108\u001a\u00020'J\b\u00109\u001a\u00020'H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Landroid/app/Activity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "actionGroup", "Landroid/view/View;", "getActionGroup", "()Landroid/view/View;", "setActionGroup", "(Landroid/view/View;)V", "chooseRoleBtn", "Landroid/widget/Button;", "getChooseRoleBtn", "()Landroid/widget/Button;", "setChooseRoleBtn", "(Landroid/widget/Button;)V", "clickArea", "getClickArea", "setClickArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "getContentGroup", "()Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "setContentGroup", "(Lcom/tencent/mm/live/view/LiveBottomSheetPanel;)V", "gotoLiveBtn", "getGotoLiveBtn", "setGotoLiveBtn", "gotoLiveCallback", "Lkotlin/Function0;", "", "getGotoLiveCallback", "()Lkotlin/jvm/functions/Function0;", "setGotoLiveCallback", "(Lkotlin/jvm/functions/Function0;)V", "back", "gotoLive", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "setVisible", "visible", "show", "updateVisitorRoleInfo", "plugin-finder_release"})
public final class ce extends d {
    final String TAG = "FinderLiveVisitorRoleGuidePlugin";
    private Button UNf;
    private Button UNg;
    public kotlin.g.a.a<x> UNh;
    private View clickArea;
    private final b hOp;
    public LiveBottomSheetPanel hRy;
    private View hVy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ce(ViewGroup viewGroup, b bVar, final Activity activity, bbn bbn) {
        super(viewGroup, bVar, bbn);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(260753);
        this.hOp = bVar;
        this.clickArea = viewGroup.findViewById(R.id.b3o);
        View view = this.clickArea;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ce.AnonymousClass1 */
                final /* synthetic */ ce UNi;

                {
                    this.UNi = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(260744);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.UNi.Fx(true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(260744);
                }
            });
        }
        this.hRy = (LiveBottomSheetPanel) viewGroup.findViewById(R.id.bei);
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        if (liveBottomSheetPanel != null) {
            liveBottomSheetPanel.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ce.AnonymousClass2 */
                final /* synthetic */ ce UNi;

                {
                    this.UNi = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Boolean bool) {
                    AppMethodBeat.i(260745);
                    if (!bool.booleanValue()) {
                        this.UNi.rg(8);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260745);
                    return xVar;
                }
            });
        }
        this.hVy = viewGroup.findViewById(R.id.jsw);
        int aD = au.aD(viewGroup.getContext());
        View view2 = this.hVy;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260753);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = aD + marginLayoutParams.bottomMargin;
        }
        this.UNf = (Button) viewGroup.findViewById(R.id.jtt);
        Button button = this.UNf;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ce.AnonymousClass3 */
                final /* synthetic */ ce UNi;

                {
                    this.UNi = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(260746);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    o oVar = o.ujN;
                    s finderLiveAssistant = o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.g(activity, true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(260746);
                }
            });
        }
        this.UNg = (Button) viewGroup.findViewById(R.id.jzr);
        Button button2 = this.UNg;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ce.AnonymousClass4 */
                final /* synthetic */ ce UNi;

                {
                    this.UNi = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(260747);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.UNi.Fx(true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorRoleGuidePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(260747);
                }
            });
        }
        g.azz().b(new cd(14));
        AppMethodBeat.o(260753);
    }

    /* access modifiers changed from: package-private */
    public final void Fx(boolean z) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(260750);
        View view = this.clickArea;
        if (view != null) {
            view.setVisibility(8);
        }
        LiveBottomSheetPanel liveBottomSheetPanel = this.hRy;
        if (liveBottomSheetPanel != null) {
            liveBottomSheetPanel.hide();
        }
        if (!z || (aVar = this.UNh) == null) {
            AppMethodBeat.o(260750);
            return;
        }
        aVar.invoke();
        AppMethodBeat.o(260750);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        View view;
        AppMethodBeat.i(260751);
        super.rg(i2);
        if (i2 == 0 || (view = this.clickArea) == null) {
            AppMethodBeat.o(260751);
            return;
        }
        view.setVisibility(8);
        AppMethodBeat.o(260751);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(260752);
        switch (i2) {
            case 1009:
                if (i3 != -1) {
                    Log.i(this.TAG, "REQUEST_FINDER_LIVE_ROLE resultCode:" + i3 + ",data:" + intent);
                    break;
                } else {
                    if (intent != null) {
                        z = intent.getBooleanExtra("KEY_IS_FROM_SETTING", false);
                    } else {
                        z = false;
                    }
                    Log.i(this.TAG, "REQUEST_FINDER_LIVE_ROLE fromUserGuide:".concat(String.valueOf(z)));
                    if (z) {
                        o oVar = o.ujN;
                        s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            z2 = finderLiveAssistant.b(this);
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            z3 = true;
                        }
                        Fx(z3);
                        AppMethodBeat.o(260752);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(260752);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ ce UNi;

        public a(ce ceVar) {
            this.UNi = ceVar;
        }

        public final void run() {
            AppMethodBeat.i(260748);
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_GUIDE_SHOW_BOOLEAN_SYNC, Boolean.TRUE);
            LiveBottomSheetPanel liveBottomSheetPanel = this.UNi.hRy;
            if (liveBottomSheetPanel != null) {
                liveBottomSheetPanel.show();
            }
            Log.i(this.UNi.TAG, "show");
            AppMethodBeat.o(260748);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(260749);
        if (this.hwr.getVisibility() == 0) {
            Fx(true);
            AppMethodBeat.o(260749);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(260749);
        return onBackPress;
    }
}
