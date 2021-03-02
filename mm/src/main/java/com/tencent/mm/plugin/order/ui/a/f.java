package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private int AQA = Integer.MAX_VALUE;
    private int AQB = -1;
    private int AQC = -1;
    private View.OnClickListener hEZ;
    private boolean mClickable;
    private String mContent;
    private View mView = null;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(66815);
        setLayoutResource(R.layout.b5u);
        AppMethodBeat.o(66815);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66816);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66816);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66817);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.f7k);
        ((TextView) view.findViewById(R.id.f7l)).setText(getTitle());
        if (this.AQA != Integer.MAX_VALUE) {
            textView.setTextColor(this.AQA);
        }
        if (!this.mClickable) {
            textView.setOnClickListener(null);
            textView.setText(l.b(this.mContext, this.mContent, textView.getTextSize()));
            AppMethodBeat.o(66817);
        } else if (this.AQB < 0 || this.AQC <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.zf));
            textView.setOnClickListener(this.hEZ);
            textView.setText(l.b(this.mContext, this.mContent, textView.getTextSize()));
            AppMethodBeat.o(66817);
        } else {
            a aVar = new a(this.mContext);
            SpannableString spannableString = new SpannableString(this.mContent);
            aVar.AQT = new a.AbstractC1567a() {
                /* class com.tencent.mm.plugin.order.ui.a.f.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.order.c.a.AbstractC1567a
                public final void onClick(View view) {
                    AppMethodBeat.i(66814);
                    if (f.this.hEZ != null) {
                        f.this.hEZ.onClick(view);
                    }
                    AppMethodBeat.o(66814);
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.AQB, this.AQC, 33);
            textView.setText(spannableString);
            AppMethodBeat.o(66817);
        }
    }

    public final void aJG(String str) {
        AppMethodBeat.i(66818);
        try {
            this.AQA = g.cI(str, true);
            AppMethodBeat.o(66818);
        } catch (Exception e2) {
            this.AQA = Integer.MAX_VALUE;
            AppMethodBeat.o(66818);
        }
    }

    public final void setContent(String str) {
        this.mContent = str;
        this.mClickable = false;
    }

    public final void a(String str, int i2, int i3, View.OnClickListener onClickListener) {
        this.mContent = str;
        this.mClickable = true;
        this.AQB = i2;
        this.AQC = i3;
        this.hEZ = onClickListener;
    }
}
