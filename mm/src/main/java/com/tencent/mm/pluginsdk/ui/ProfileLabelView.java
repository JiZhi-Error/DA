package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cn;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView BeG;
    public TextView KcS;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public int getLayout() {
        return R.layout.bji;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final void init() {
        AppMethodBeat.i(31232);
        this.BeG = (TextView) findViewById(R.id.baw);
        this.KcS = (TextView) findViewById(R.id.bax);
        setClickable(true);
        AppMethodBeat.o(31232);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean eEV() {
        cn aEZ;
        AppMethodBeat.i(31233);
        if (this.KcS != null) {
            ViewGroup.LayoutParams layoutParams = this.KcS.getLayoutParams();
            layoutParams.width = a.aG(getContext(), R.dimen.em);
            this.KcS.setLayoutParams(layoutParams);
        }
        if (!c.oR(this.rjX.field_type)) {
            String str = this.rjX.field_encryptUsername;
            if (!Util.isNullOrNil(str)) {
                bg.aVF();
                aEZ = com.tencent.mm.model.c.aSO().aEZ(str);
            } else {
                bg.aVF();
                aEZ = com.tencent.mm.model.c.aSO().aEZ(this.rjX.field_username);
            }
            if (aEZ != null) {
                String str2 = aEZ.field_contactLabels;
                ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCI(str2);
                if (!Util.isNullOrNil(str2) && arrayList != null && arrayList.size() > 0) {
                    this.BeG.setText(l.c(getContext(), Util.listToString(arrayList, getContext().getResources().getString(R.string.b8l))));
                    AppMethodBeat.o(31233);
                    return true;
                }
            }
            setVisibility(8);
            AppMethodBeat.o(31233);
            return false;
        } else if (z.Im(this.rjX.field_username)) {
            setVisibility(8);
            AppMethodBeat.o(31233);
            return false;
        } else {
            String str3 = this.rjX.field_contactLabelIds;
            ArrayList arrayList2 = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCJ(str3);
            if (Util.isNullOrNil(str3) || arrayList2 == null || arrayList2.size() <= 0) {
                setVisibility(8);
                AppMethodBeat.o(31233);
                return false;
            }
            this.BeG.setText(l.c(getContext(), Util.listToString(arrayList2, getContext().getResources().getString(R.string.b8l))));
            AppMethodBeat.o(31233);
            return true;
        }
    }
}
