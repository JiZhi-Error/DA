package com.tencent.mm.plugin.finder.live.widget;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "TAG", "", "textview", "Landroid/widget/TextView;", "hideStatistics", "", "showStatistics", "statistics", "plugin-finder_release"})
public final class m {
    private final String TAG = "Finder.LiveStatisticsWidget";
    public final TextView uHs;

    public m(final Context context, ViewGroup viewGroup) {
        p.h(context, "context");
        p.h(viewGroup, "rootView");
        AppMethodBeat.i(248148);
        this.uHs = new TextView(context);
        ao.a(this.uHs.getPaint(), 0.8f);
        TextView textView = this.uHs;
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        textView.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_5));
        TextView textView2 = this.uHs;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        textView2.setTextSize(0, context3.getResources().getDimension(R.dimen.a_));
        this.uHs.setBackgroundResource(R.drawable.a1s);
        this.uHs.setPadding(d.e(MMApplicationContext.getContext(), 10.0f), this.uHs.getPaddingTop(), d.e(MMApplicationContext.getContext(), 10.0f), this.uHs.getPaddingBottom());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = d.e(MMApplicationContext.getContext(), 150.0f);
        viewGroup.addView(this.uHs, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.uHs.getLayoutParams();
        double d2 = (double) ((float) au.az(MMApplicationContext.getContext()).x);
        v.a aVar = v.uoz;
        int i2 = (int) (d2 * v.uon);
        if (i2 > 0) {
            layoutParams2.width = i2;
        }
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(context4.getResources().getDimensionPixelOffset(R.dimen.cb));
        }
        this.uHs.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.m.AnonymousClass1 */
            final /* synthetic */ m uHt;

            {
                this.uHt = r1;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(248146);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                StringBuilder append = new StringBuilder().append(this.uHt.uHs.getText()).append("cdnUrl:");
                com.tencent.mm.live.core.core.d dVar = com.tencent.mm.live.core.core.d.hwY;
                String sb = append.append(com.tencent.mm.live.core.core.d.aCd()).append('\n').toString();
                Object systemService = MMApplicationContext.getContext().getSystemService("clipboard");
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.content.ClipboardManager");
                    AppMethodBeat.o(248146);
                    throw tVar;
                }
                ((ClipboardManager) systemService).setText(sb);
                Toast.makeText(context, "copy done", 0).show();
                a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(248146);
                return true;
            }
        });
        AppMethodBeat.o(248148);
    }

    public final void atZ(String str) {
        AppMethodBeat.i(248147);
        p.h(str, "statistics");
        this.uHs.setVisibility(0);
        this.uHs.setText(str);
        AppMethodBeat.o(248147);
    }
}
