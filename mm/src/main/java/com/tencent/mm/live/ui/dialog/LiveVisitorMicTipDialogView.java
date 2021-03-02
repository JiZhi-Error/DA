package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\u0010\u001a\u00020\u000f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nR+\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onButtonClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOK", "", "setOnButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "plugin-logic_release"})
public final class LiveVisitorMicTipDialogView extends RelativeLayout {
    private b<? super Boolean, x> hVE;

    public /* synthetic */ LiveVisitorMicTipDialogView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveVisitorMicTipDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208488);
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.b1y, (ViewGroup) this, true).findViewById(R.id.ejh);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView.AnonymousClass1 */
                final /* synthetic */ LiveVisitorMicTipDialogView hVF;

                {
                    this.hVF = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(208486);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b bVar2 = this.hVF.hVE;
                    if (bVar2 != null) {
                        bVar2.invoke(Boolean.TRUE);
                    }
                    a.a(this, "com/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(208486);
                }
            });
            AppMethodBeat.o(208488);
            return;
        }
        AppMethodBeat.o(208488);
    }

    public final void setOnButtonClickListener(b<? super Boolean, x> bVar) {
        AppMethodBeat.i(208487);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.hVE = bVar;
        AppMethodBeat.o(208487);
    }
}
