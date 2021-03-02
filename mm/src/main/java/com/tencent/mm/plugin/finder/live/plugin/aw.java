package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DISABLE_TXT", "", "ENABLE_TXT", "TAG", "autoInputMsg", "postContainer", "Landroid/view/View;", "kotlin.jvm.PlatformType", "postHint", "Landroid/widget/TextView;", "canClearScreen", "", "checkComment", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class aw extends d {
    private final String TAG = "Finder.FinderLiveNewVisitorPostPlugin";
    final b hOp;
    private final View uto;
    final TextView utp;
    String utq;
    final String utr;
    final String uts;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(final ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246945);
        this.hOp = bVar;
        this.uto = viewGroup.findViewById(R.id.cz8);
        this.utp = (TextView) viewGroup.findViewById(R.id.cz6);
        this.utq = "";
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String string = context.getResources().getString(R.string.crr);
        p.g(string, "MMApplicationContext.get….finder_live_comment_tip)");
        this.utr = string;
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        String string2 = context2.getResources().getString(R.string.d5g);
        p.g(string2, "MMApplicationContext.get…finder_post_disable_hint)");
        this.uts = string2;
        this.uto.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.aw.AnonymousClass1 */
            final /* synthetic */ aw utt;

            {
                this.utt = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246941);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.utt.getLiveData().uDB || !this.utt.getLiveData().uDC) {
                    Context context = viewGroup.getContext();
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    u.makeText(context, context2.getResources().getString(R.string.cyx), 0).show();
                } else {
                    TextView textView = this.utt.utp;
                    p.g(textView, "postHint");
                    if (p.j(textView.getText(), this.utt.utr)) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                        bundle.putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", this.utt.utq);
                        this.utt.hOp.statusChange(b.c.hMd, bundle);
                    } else {
                        TextView textView2 = this.utt.utp;
                        p.g(textView2, "postHint");
                        if (p.j(textView2.getText(), this.utt.uts)) {
                            Context context3 = viewGroup.getContext();
                            Context context4 = MMApplicationContext.getContext();
                            p.g(context4, "MMApplicationContext.getContext()");
                            u.a(context3, context4.getResources().getString(R.string.crg), AnonymousClass1.utu);
                        }
                    }
                }
                this.utt.utq = "";
                a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveNewVisitorPostPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246941);
            }
        });
        if (!isLandscape()) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246945);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        }
        m mVar = m.vVH;
        m.a((d) this, true);
        AppMethodBeat.o(246945);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public final void dhK() {
        AppMethodBeat.i(246943);
        if (!getLiveData().uDB || !getLiveData().uDD || !getLiveData().uDC) {
            TextView textView = this.utp;
            p.g(textView, "postHint");
            textView.setText(this.uts);
        } else {
            TextView textView2 = this.utp;
            p.g(textView2, "postHint");
            textView2.setText(this.utr);
        }
        Log.i(this.TAG, "riskControlEnableComment:" + getLiveData().uDB + ",enableLiveRoomComment:" + getLiveData().uDD + ",enableCustomerComment:" + getLiveData().uDC);
        AppMethodBeat.o(246943);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String str;
        AppMethodBeat.i(246944);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ax.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(8);
                AppMethodBeat.o(246944);
                return;
            case 3:
                dhK();
                AppMethodBeat.o(246944);
                return;
            case 4:
                m mVar = m.vVH;
                m.a((d) this, true);
                AppMethodBeat.o(246944);
                return;
            case 5:
                if (bundle == null || (str = bundle.getString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG")) == null) {
                    str = "";
                }
                this.utq = str;
                this.uto.performClick();
                break;
        }
        AppMethodBeat.o(246944);
    }
}
