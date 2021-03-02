package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public final class e extends f {
    private Context mContext;

    public e(Context context) {
        super(context);
        this.mContext = context;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(65632);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.b41, viewGroup, false);
            a aVar2 = new a();
            aVar2.rMV = (TextView) view.findViewById(R.id.f28);
            aVar2.yQj = (TextView) view.findViewById(R.id.f29);
            aVar2.yQk = (TextView) view.findViewById(R.id.f23);
            aVar2.zeG = (TextView) view.findViewById(R.id.f24);
            aVar2.yQv = (ImageView) view.findViewById(R.id.f26);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        y PT = getItem(i2);
        if (!Util.isNullOrNil(PT.yWu)) {
            SpannableString b2 = l.b(this.mContext, PT.yWn + PT.yWu, aVar.rMV.getTextSize());
            SpannableString b3 = l.b(this.mContext, PT.yWn, aVar.rMV.getTextSize());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b2);
            spannableStringBuilder.setSpan(new q("#FA9D3B", new q.a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.e.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                public final void dF(View view) {
                }
            }), b3.length(), b2.length(), 18);
            aVar.rMV.setText(spannableStringBuilder);
        } else {
            af.a(this.mContext, aVar.rMV, PT.yWn);
        }
        if (!Util.isNullOrNil(PT.yWv)) {
            aVar.zeG.setVisibility(0);
            aVar.zeG.setText(PT.yWv);
        } else {
            aVar.zeG.setVisibility(8);
        }
        aVar.yQj.setText(PT.yWp);
        aVar.yQk.setText(this.mContext.getString(R.string.eri, f.formatMoney2f(((double) PT.yWo) / 100.0d)));
        if (PT.egY == 1) {
            aVar.yQv.setImageResource(R.drawable.cd9);
            aVar.yQv.setVisibility(0);
        } else if (PT.egY == 2) {
            aVar.yQv.setImageResource(R.drawable.cd1);
            aVar.yQv.setVisibility(0);
        } else if (PT.egY == 3) {
            aVar.yQv.setImageResource(R.raw.lucky_money_exclusive_hb);
            aVar.yQv.setVisibility(0);
        } else {
            aVar.yQv.setVisibility(8);
        }
        AppMethodBeat.o(65632);
        return view;
    }

    class a {
        TextView rMV;
        TextView yQj;
        TextView yQk;
        ImageView yQv;
        TextView zeG;

        a() {
        }
    }
}
