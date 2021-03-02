package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j extends Preference {
    List<MallOrderDetailObject.HelpCenter> ANM = new LinkedList();
    String AQR;
    View.OnClickListener AQS = null;
    View.OnClickListener mOnClickListener = null;
    private View mView = null;

    public j(Context context) {
        super(context);
        AppMethodBeat.i(66831);
        setLayoutResource(R.layout.b63);
        AppMethodBeat.o(66831);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66832);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66832);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66833);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f8j);
        linearLayout.removeAllViews();
        if (this.ANM == null) {
            AppMethodBeat.o(66833);
            return;
        }
        int size = (Util.isNullOrNil(this.AQR) || this.AQS == null) ? this.ANM.size() - 1 : this.ANM.size();
        int i2 = size == 0 ? -1 : size;
        int i3 = 0;
        for (int i4 = 0; i4 < this.ANM.size(); i4++) {
            MallOrderDetailObject.HelpCenter helpCenter = this.ANM.get(i4);
            TextView textView = new TextView(this.mContext);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
            textView.setTextSize(0, (float) a.aG(this.mContext, R.dimen.is));
            textView.setIncludeFontPadding(false);
            textView.setText(helpCenter.name);
            textView.setTag(helpCenter);
            textView.setGravity(17);
            textView.setOnClickListener(this.mOnClickListener);
            if (i3 == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.ts));
            }
            linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (i3 < i2) {
                View view2 = new View(this.mContext);
                view2.setBackgroundColor(this.mContext.getResources().getColor(R.color.a7t));
                linearLayout.addView(view2, new LinearLayout.LayoutParams(a.aG(this.mContext, R.dimen.bq), -1));
            }
            i3++;
        }
        if (!Util.isNullOrNil(this.AQR) && this.AQS != null) {
            TextView textView2 = new TextView(this.mContext);
            textView2.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
            textView2.setTextSize(0, (float) a.aG(this.mContext, R.dimen.is));
            textView2.setIncludeFontPadding(false);
            textView2.setText(this.AQR);
            textView2.setGravity(17);
            textView2.setOnClickListener(this.AQS);
            if (i3 == i2) {
                textView2.setTextColor(this.mContext.getResources().getColor(R.color.ts));
            }
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
        AppMethodBeat.o(66833);
    }
}
