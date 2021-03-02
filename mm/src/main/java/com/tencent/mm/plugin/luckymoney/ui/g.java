package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public final class g extends f {
    private Context mContext = null;

    public g(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(65660);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.b43, viewGroup, false);
            a aVar2 = new a();
            aVar2.mPa = (TextView) view.findViewById(R.id.f2c);
            aVar2.jVn = (TextView) view.findViewById(R.id.f2a);
            aVar2.yQj = (TextView) view.findViewById(R.id.f2b);
            aVar2.yQk = (TextView) view.findViewById(R.id.f2_);
            aVar2.fs = i2;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        y PT = getItem(i2);
        if (!Util.isNullOrNil(PT.yWu)) {
            SpannableString b2 = l.b(this.mContext, PT.yWq + PT.yWu, aVar.mPa.getTextSize());
            SpannableString b3 = l.b(this.mContext, PT.yWq, aVar.mPa.getTextSize());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b2);
            spannableStringBuilder.setSpan(new q("#FA9D3B", new q.a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.g.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                public final void dF(View view) {
                }
            }), b3.length(), b2.length(), 18);
            aVar.mPa.setText(spannableStringBuilder);
        } else {
            af.a(this.mContext, aVar.mPa, PT.yWq);
        }
        aVar.yQj.setText(PT.yWr);
        aVar.yQk.setText(this.mContext.getString(R.string.eo1, f.formatMoney2f(((double) PT.yVj) / 100.0d)));
        String string = this.mContext.getString(R.string.es3, Long.valueOf(PT.yVh), Long.valueOf(PT.yWs));
        if (PT.status == 5) {
            string = this.mContext.getString(R.string.es4) + " " + string;
        }
        aVar.jVn.setText(string);
        AppMethodBeat.o(65660);
        return view;
    }

    class a {
        int fs;
        TextView jVn;
        TextView mPa;
        TextView yQj;
        TextView yQk;

        a() {
        }
    }
}
