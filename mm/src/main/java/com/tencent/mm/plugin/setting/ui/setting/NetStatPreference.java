package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean CZf;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        boolean z;
        AppMethodBeat.i(73895);
        this.CZf = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.NetStatPreference, i2, 0);
        if (obtainStyledAttributes.getInt(0, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.CZf = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(R.string.grm, 15));
        AppMethodBeat.o(73895);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(73896);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b9g, viewGroup2);
        AppMethodBeat.o(73896);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(73897);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.dl9);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / Util.MILLSECONDS_OF_DAY);
        for (int i2 = 15; i2 > 0; i2 -= 5) {
            NetStatGroup netStatGroup = new NetStatGroup(this.mContext);
            int i3 = (currentTimeMillis - i2) + 1;
            boolean z = this.CZf;
            String charSequence = DateFormat.format(netStatGroup.getContext().getString(R.string.dec, ""), ((long) i3) * Util.MILLSECONDS_OF_DAY).toString();
            netStatGroup.CZe.setText(charSequence);
            Log.d("MicroMsg.NetStatGroup", "NetStat dataTime = ".concat(String.valueOf(charSequence)));
            netStatGroup.CZd.removeAllViews();
            for (int i4 = 0; i4 < 5; i4++) {
                NetStatUnit netStatUnit = new NetStatUnit(netStatGroup.getContext());
                k tU = q.bgo().tU(i3 + i4);
                if (tU != null) {
                    if (z) {
                        Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", Integer.valueOf(tU.jog), Long.valueOf(tU.joC), Long.valueOf(tU.joq), Long.valueOf(tU.joE), Long.valueOf(tU.jos));
                        netStatUnit.al(tU.joC + tU.joq, tU.jos + tU.joE);
                    } else {
                        Log.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", Integer.valueOf(tU.jog), Long.valueOf(tU.joB), Long.valueOf(tU.jop), Long.valueOf(tU.joD), Long.valueOf(tU.jor));
                        netStatUnit.al(tU.joB + tU.jop, tU.jor + tU.joD);
                    }
                }
                netStatUnit.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
                netStatGroup.CZd.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.h9w);
        linearLayout2.removeAllViews();
        NetStatGroup netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.CZf;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), R.layout.bfn, netStatGroup2);
        netStatGroup2.CZd = (LinearLayout) netStatGroup2.findViewById(R.id.dl9);
        NetStatRuler netStatRuler = new NetStatRuler(netStatGroup2.getContext());
        netStatRuler.setTag(z2 ? "wifi" : "mobile");
        netStatRuler.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        netStatGroup2.CZd.addView(netStatRuler);
        linearLayout2.addView(netStatGroup2);
        alO(8);
        AppMethodBeat.o(73897);
    }
}
