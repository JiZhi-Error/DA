package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int AQE;
    private static float AQF = 16.0f;
    String AQG;
    private String[] AQH;
    private TextUtils.TruncateAt AQI;
    private boolean AQJ = false;
    private View mView = null;
    f nRm;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(66820);
        setLayoutResource(R.layout.b5v);
        AQE = context.getResources().getColor(R.color.zm);
        AppMethodBeat.o(66820);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66821);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66821);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66822);
        super.onBindView(view);
        final TextView textView = (TextView) view.findViewById(R.id.f7r);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f7q);
        ((TextView) view.findViewById(R.id.f7s)).setText(getTitle());
        if (this.AQH == null || this.AQH.length <= 1) {
            textView.setTextColor(AQE);
        } else {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.order.ui.a.g.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(66819);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    textView.setVisibility(8);
                    for (int i2 = 0; i2 < g.this.AQH.length; i2++) {
                        linearLayout.addView(g.a(g.this, g.this.AQH[i2]), new LinearLayout.LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (g.this.nRm != null) {
                        g.this.nRm.notifyDataSetChanged();
                    }
                    a.a(this, "com/tencent/mm/plugin/order/ui/preference/MallOrderDeployablePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(66819);
                }
            });
        }
        textView.setText(this.AQG);
        AppMethodBeat.o(66822);
    }

    public final void a(String[] strArr, TextUtils.TruncateAt truncateAt) {
        this.AQH = strArr;
        this.AQI = truncateAt;
        this.AQJ = true;
    }

    static /* synthetic */ TextView a(g gVar, String str) {
        AppMethodBeat.i(66823);
        TextView textView = new TextView(gVar.mContext);
        textView.setText(str);
        textView.setTextSize(AQF);
        textView.setTextColor(AQE);
        if (gVar.AQJ) {
            textView.setSingleLine(true);
            textView.setEllipsize(gVar.AQI);
        } else {
            textView.setSingleLine(false);
        }
        AppMethodBeat.o(66823);
        return textView;
    }
}
