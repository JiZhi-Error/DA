package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.base.preference.Preference;

public final class g extends Preference {
    public int AQA = Integer.MAX_VALUE;
    private int AQB = -1;
    private int AQC = -1;
    public View.OnClickListener hEZ;
    private View kHq;
    public boolean mClickable;
    public String mContent;
    private View mView = null;

    public g(Context context) {
        super(context, null);
        AppMethodBeat.i(70676);
        setLayoutResource(R.layout.axf);
        AppMethodBeat.o(70676);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(70677);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(70677);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(70678);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.j2g);
        ((TextView) view.findViewById(R.id.e61)).setText(getTitle());
        this.kHq = view;
        if (this.AQA != Integer.MAX_VALUE) {
            textView.setTextColor(this.AQA);
        }
        if (!this.mClickable) {
            textView.setOnClickListener(null);
            textView.setText(l.b(this.mContext, this.mContent, textView.getTextSize()));
            AppMethodBeat.o(70678);
        } else if (this.AQB < 0 || this.AQC <= 0) {
            if (this.AQA != Integer.MAX_VALUE) {
                textView.setTextColor(this.AQA);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.zf));
            }
            textView.setOnClickListener(this.hEZ);
            textView.setText(l.b(this.mContext, this.mContent, textView.getTextSize()));
            AppMethodBeat.o(70678);
        } else {
            l lVar = new l(this.mContext);
            SpannableString spannableString = new SpannableString(this.mContent);
            lVar.IgH = new l.a() {
                /* class com.tencent.mm.plugin.wallet_core.ui.g.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                public final void onClick(View view) {
                    AppMethodBeat.i(70675);
                    if (g.this.hEZ != null) {
                        g.this.hEZ.onClick(view);
                    }
                    AppMethodBeat.o(70675);
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(lVar, this.AQB, this.AQC, 33);
            textView.setText(spannableString);
            AppMethodBeat.o(70678);
        }
    }
}
