package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.layout.a;

public class NewBizInfoDescPreference extends Preference {
    private ph BiU;
    private LinearLayout gCh;
    private MMActivity gte;
    private MMNeat7extView pIP;
    private boolean rFe = false;

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27495);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27495);
    }

    public NewBizInfoDescPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27496);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27496);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        AppMethodBeat.i(27497);
        this.gCh = (LinearLayout) view.findViewById(R.id.a_e);
        this.pIP = (MMNeat7extView) view.findViewById(R.id.a_d);
        this.rFe = true;
        if (!this.rFe) {
            Log.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", Boolean.valueOf(this.rFe));
            AppMethodBeat.o(27497);
        } else if (this.BiU == null) {
            this.gCh.setVisibility(4);
            AppMethodBeat.o(27497);
        } else {
            String sM = sM(false);
            if (!Util.isNullOrNil(sM)) {
                this.gCh.setVisibility(0);
                this.pIP.aw(sM);
                int i3 = this.BiU.KWf.KSY;
                int i4 = this.BiU.KWf.KSZ;
                if (i3 > 0 && i4 > 0) {
                    a mq = this.pIP.mq(com.tencent.mm.cb.a.jn(this.gte) - ((int) (com.tencent.mm.cb.a.getDensity(this.gte) * 24.0f)), Integer.MAX_VALUE);
                    if (mq != null) {
                        i2 = mq.hiG();
                    } else {
                        i2 = 0;
                    }
                    if (i2 > 1) {
                        this.pIP.aw(sM(true));
                    }
                }
                AppMethodBeat.o(27497);
                return;
            }
            this.gCh.setVisibility(8);
            AppMethodBeat.o(27497);
        }
    }

    private String sM(boolean z) {
        AppMethodBeat.i(27498);
        StringBuilder sb = new StringBuilder();
        if (this.BiU.KWf != null) {
            String str = this.BiU.KWf.KTb;
            String str2 = this.BiU.KWf.KTc;
            if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
                sb.append(str);
                if (z) {
                    sb.append("\n");
                } else {
                    sb.append("  ");
                }
                sb.append(str2);
                String sb2 = sb.toString();
                AppMethodBeat.o(27498);
                return sb2;
            } else if (!Util.isNullOrNil(str)) {
                sb.append(str);
                String sb3 = sb.toString();
                AppMethodBeat.o(27498);
                return sb3;
            } else if (!Util.isNullOrNil(str2)) {
                sb.append(str2);
                String sb4 = sb.toString();
                AppMethodBeat.o(27498);
                return sb4;
            }
        }
        AppMethodBeat.o(27498);
        return "";
    }
}
