package com.tencent.mm.live.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class r extends a implements View.OnClickListener {
    private final b hOp;
    private final WeImageView hPV;
    private final TextView hPW;
    private final Button hPX;
    private final ImageView kc;
    private final TextView titleTv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207994);
        this.hOp = bVar;
        this.hPV = (WeImageView) viewGroup.findViewById(R.id.egx);
        this.titleTv = (TextView) viewGroup.findViewById(R.id.eh1);
        this.hPW = (TextView) viewGroup.findViewById(R.id.egz);
        this.kc = (ImageView) viewGroup.findViewById(R.id.eh0);
        this.hPX = (Button) viewGroup.findViewById(R.id.egy);
        this.hPV.setOnClickListener(this);
        this.hPX.setOnClickListener(this);
        TextView textView = this.hPW;
        p.g(textView, "descTv");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(207994);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(207992);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.egx) || (valueOf != null && valueOf.intValue() == R.id.egy)) {
            b.C0376b.a(this.hOp, b.c.hLD);
        }
        a.a(this, "com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207992);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        CharSequence charSequence;
        Integer num;
        Drawable drawable = null;
        AppMethodBeat.i(207993);
        p.h(cVar, "status");
        switch (s.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                String string = bundle != null ? bundle.getString("PARAM_LIVE_EXCEPTION_TITLE") : null;
                if (bundle != null) {
                    charSequence = bundle.getCharSequence("PARAM_LIVE_EXCEPTION_DESC");
                } else {
                    charSequence = null;
                }
                if (bundle != null) {
                    num = Integer.valueOf(bundle.getInt("PARAM_LIVE_EXCEPTION_ICON_RES"));
                } else {
                    num = null;
                }
                if (!(num == null || num.intValue() == 0)) {
                    Context context = this.hwr.getContext();
                    p.g(context, "root.context");
                    drawable = context.getResources().getDrawable(num.intValue());
                }
                TextView textView = this.titleTv;
                p.g(textView, "titleTv");
                textView.setText(string);
                this.hPW.setText(charSequence, TextView.BufferType.SPANNABLE);
                this.kc.setImageDrawable(drawable);
                break;
        }
        AppMethodBeat.o(207993);
    }
}
