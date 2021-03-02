package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class b extends a {
    private boolean ABF = true;
    com.tencent.mm.plugin.nearlife.b.b ABM;
    private com.tencent.mm.plugin.nearlife.b.b ABN = new com.tencent.mm.plugin.nearlife.b.b("", new chj());
    String ABO;
    private HashMap<String, Integer> ABP = new HashMap<>();
    private boolean Vav = false;
    private String ixw;

    public b(Context context, View.OnClickListener onClickListener, String str, boolean z, boolean z2, String str2, boolean z3) {
        super(context, onClickListener, str, z2);
        AppMethodBeat.i(258845);
        this.ABN.AAG = "NotCheckIn";
        this.ABN.Title = context.getString(R.string.f_k);
        this.ABF = z;
        this.ixw = str2;
        this.ABP.put(this.ABN.AAG, 2);
        if (!z2 && z) {
            a(this.ABN, 0);
            notifyDataSetChanged();
        }
        this.Vav = z3;
        AppMethodBeat.o(258845);
    }

    public final com.tencent.mm.plugin.nearlife.b.b jd(String str, String str2) {
        int i2 = 1;
        AppMethodBeat.i(26574);
        if (this.ABM == null) {
            this.ABM = new com.tencent.mm.plugin.nearlife.b.b("", new chj());
            this.ABM.AAG = "City";
            this.ABP.put(this.ABM.AAG, 1);
            com.tencent.mm.plugin.nearlife.b.b bVar = this.ABM;
            if (!this.ABF) {
                i2 = 0;
            }
            a(bVar, i2);
        }
        this.ABM.Title = str;
        this.ABM.dPI = str2;
        notifyDataSetChanged();
        com.tencent.mm.plugin.nearlife.b.b bVar2 = this.ABM;
        AppMethodBeat.o(26574);
        return bVar2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        int i3;
        AppMethodBeat.i(26575);
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.mContext, R.layout.bew, null);
            aVar.titleTv = (TextView) view.findViewById(R.id.eb0);
            aVar.ywY = (TextView) view.findViewById(R.id.eaz);
            aVar.hPW = (TextView) view.findViewById(R.id.eay);
            aVar.ABR = (LinearLayout) view.findViewById(R.id.h8z);
            aVar.ABS = (WeImageView) view.findViewById(R.id.hi2);
            if (this.ixw != null) {
                aVar.ABS.setIconColor(Color.parseColor(this.ixw));
            }
            aVar.ABR.setOnClickListener(this.dec);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.nearlife.b.b Tv = getItem(i2);
        if (this.ABP.containsKey(Tv.AAG)) {
            i3 = this.ABP.get(Tv.AAG).intValue();
        } else {
            i3 = 0;
        }
        aVar.ABS.setVisibility(8);
        aVar.type = i3;
        aVar.ABQ = Tv;
        if (!Util.isNullOrNil(this.ABO) && this.ABO.equals(Tv.AAG)) {
            aVar.ABS.setVisibility(0);
        }
        switch (i3) {
            case 0:
                aVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                aVar.hPW.setVisibility(0);
                break;
            case 1:
                aVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                aVar.hPW.setVisibility(8);
                break;
            case 2:
                aVar.hPW.setVisibility(8);
                aVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.a92));
                if (Util.isNullOrNil(this.ABO)) {
                    aVar.ABS.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i2;
        aVar.AAG = Tv.AAG;
        if (this.xrR) {
            aVar.titleTv.setText(aDk(Tv.Title));
            aVar.hPW.setText(aDk(fF(Tv.AAL)));
        } else {
            aVar.titleTv.setText(Tv.Title);
            aVar.hPW.setText(fF(Tv.AAL));
        }
        aVar.ywY.setVisibility(8);
        if (this.Vav) {
            aVar.ABR.setBackground(this.mContext.getDrawable(R.drawable.cva));
            aVar.titleTv.setTextColor(Color.parseColor("#CCFFFFFF"));
            aVar.hPW.setTextColor(Color.parseColor("#80FFFFFF"));
            aVar.ywY.setTextColor(Color.parseColor("#CCFFFFFF"));
        }
        AppMethodBeat.o(26575);
        return view;
    }

    private Spannable aDk(String str) {
        AppMethodBeat.i(26576);
        Spannable b2 = f.b(str, this.AAT);
        AppMethodBeat.o(26576);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public class a {
        String AAG;
        com.tencent.mm.plugin.nearlife.b.b ABQ;
        LinearLayout ABR;
        WeImageView ABS;
        TextView hPW;
        int position;
        TextView titleTv;
        int type;
        TextView ywY;

        a() {
        }
    }
}
