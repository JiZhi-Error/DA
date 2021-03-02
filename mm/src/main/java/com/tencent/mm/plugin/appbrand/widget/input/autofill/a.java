package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h;
import com.tencent.mm.plugin.appbrand.widget.input.d.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a extends ArrayAdapter<a.b> implements g {
    private final LayoutInflater mInflater;
    private b ovQ;
    h ovR;
    private boolean ovS = false;

    a(Context context, List<a.b> list) {
        super(context, (int) R.layout.e5, list);
        AppMethodBeat.i(136615);
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(136615);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(136616);
        super.notifyDataSetChanged();
        AppMethodBeat.o(136616);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.g
    public final void a(b bVar) {
        AppMethodBeat.i(136617);
        this.ovQ = bVar;
        this.ovQ.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.a.AnonymousClass1 */

            public final void onDismiss() {
                AppMethodBeat.i(136612);
                if (a.this.ovR != null && !a.this.ovS) {
                    a.this.ovR.a("", h.a.CANCEL);
                }
                AppMethodBeat.o(136612);
            }
        });
        AppMethodBeat.o(136617);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.g
    public final void ccb() {
        AppMethodBeat.i(136618);
        this.ovQ.setOnDismissListener(null);
        this.ovQ = null;
        AppMethodBeat.o(136618);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View$OnClickListenerC0821a aVar;
        int i3;
        int i4 = 8;
        AppMethodBeat.i(136619);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.e5, viewGroup, false);
        }
        View$OnClickListenerC0821a aVar2 = (View$OnClickListenerC0821a) view.getTag();
        if (aVar2 == null) {
            View$OnClickListenerC0821a aVar3 = new View$OnClickListenerC0821a(view);
            view.setTag(aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        a.b bVar = (a.b) getItem(i2);
        aVar.ovX = bVar;
        aVar.ovU.setText(bVar.title);
        aVar.ovV.setText(bVar.content);
        TextView textView = aVar.ovV;
        if (Util.isNullOrNil(bVar.content)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        View view2 = aVar.jWr;
        if (i2 != getCount() - 1) {
            i4 = 0;
        }
        view2.setVisibility(i4);
        AppMethodBeat.o(136619);
        return view;
    }

    public final Filter getFilter() {
        AppMethodBeat.i(136620);
        Filter filter = super.getFilter();
        AppMethodBeat.o(136620);
        return filter;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.a$a  reason: collision with other inner class name */
    final class View$OnClickListenerC0821a implements View.OnClickListener {
        View aus;
        View jWr;
        TextView ovU;
        TextView ovV;
        View ovW;
        a.b ovX;

        View$OnClickListenerC0821a(View view) {
            AppMethodBeat.i(136613);
            this.aus = view;
            this.ovU = (TextView) view.findViewById(R.id.ipm);
            this.ovV = (TextView) view.findViewById(R.id.be9);
            this.ovW = view.findViewById(R.id.b3z);
            this.jWr = view.findViewById(R.id.brt);
            view.setBackgroundResource(R.drawable.aol);
            view.setOnClickListener(this);
            this.ovW.setOnClickListener(this);
            AppMethodBeat.o(136613);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(136614);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.ovX != null) {
                if (view.getId() == R.id.b3z) {
                    a.this.remove(this.ovX);
                    if (a.this.ovR != null) {
                        a.this.ovR.a(this.ovX.id, h.a.DELETE);
                    }
                } else if (view == this.aus && a.this.ovR != null) {
                    if (this.ovX != null) {
                        a.this.ovR.a(this.ovX.id, h.a.SELECT);
                    }
                    a.this.ovS = true;
                    if (a.this.ovQ != null) {
                        a.this.ovQ.ovY.getView().clearFocus();
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/input/autofill/AutoFillAdapter$AutoFillViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(136614);
        }
    }
}
