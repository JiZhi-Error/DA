package com.tencent.mm.live.core.debug;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/core/debug/LiveDebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentView", "Landroid/widget/TextView;", "liveInfoView", "printDebugInfo", "", "debugText", "", "printLiveInfo", "liveInfo", "plugin-core_release"})
public final class LiveDebugView extends LinearLayout {
    private final TextView contentView;
    final TextView hCx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDebugView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(196563);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b0q, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.egt);
        p.g(findViewById, "parent.findViewById(R.id.live_debug_text)");
        this.contentView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.egs);
        p.g(findViewById2, "parent.findViewById(R.id.live_debug_info)");
        this.hCx = (TextView) findViewById2;
        this.contentView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.hCx.setMovementMethod(ScrollingMovementMethod.getInstance());
        ((Button) inflate.findViewById(R.id.bkx)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.core.debug.LiveDebugView.AnonymousClass1 */
            final /* synthetic */ LiveDebugView hCy;

            {
                this.hCy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(196559);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ClipboardHelper.setText(this.hCy.contentView.getText());
                a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196559);
            }
        });
        ((Button) inflate.findViewById(R.id.bkv)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.core.debug.LiveDebugView.AnonymousClass2 */
            final /* synthetic */ LiveDebugView hCy;

            {
                this.hCy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(196560);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hCy.contentView.getCurrentTextColor() == com.tencent.mm.cb.a.n(context, R.color.fm)) {
                    this.hCy.contentView.setTextColor(com.tencent.mm.cb.a.n(context, R.color.afz));
                    this.hCy.hCx.setTextColor(com.tencent.mm.cb.a.n(context, R.color.afz));
                } else {
                    this.hCy.contentView.setTextColor(com.tencent.mm.cb.a.n(context, R.color.fm));
                    this.hCy.hCx.setTextColor(com.tencent.mm.cb.a.n(context, R.color.fm));
                }
                a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196560);
            }
        });
        ((Button) inflate.findViewById(R.id.bkw)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.core.debug.LiveDebugView.AnonymousClass3 */
            final /* synthetic */ LiveDebugView hCy;

            {
                this.hCy = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(196561);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hCy.contentView.getVisibility() == 0) {
                    if (view == null) {
                        t tVar = new t("null cannot be cast to non-null type android.widget.Button");
                        AppMethodBeat.o(196561);
                        throw tVar;
                    }
                    ((Button) view).setText(com.tencent.mm.cb.a.aI(context, R.string.eft));
                    this.hCy.contentView.setVisibility(4);
                    this.hCy.hCx.setVisibility(4);
                } else if (view == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.widget.Button");
                    AppMethodBeat.o(196561);
                    throw tVar2;
                } else {
                    ((Button) view).setText(com.tencent.mm.cb.a.aI(context, R.string.efs));
                    this.hCy.contentView.setVisibility(0);
                    this.hCy.hCx.setVisibility(0);
                }
                a.a(this, "com/tencent/mm/live/core/debug/LiveDebugView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196561);
            }
        });
        AppMethodBeat.o(196563);
    }

    public final void GA(String str) {
        AppMethodBeat.i(196562);
        p.h(str, "debugText");
        String format = new SimpleDateFormat("[HH:mm:ss.SSS]", Locale.US).format(new Date(System.currentTimeMillis()));
        TextView textView = this.contentView;
        ae aeVar = ae.SYK;
        String format2 = String.format("%s:%s\n\n", Arrays.copyOf(new Object[]{format, str}, 2));
        p.g(format2, "java.lang.String.format(format, *args)");
        textView.append(format2);
        AppMethodBeat.o(196562);
    }
}
