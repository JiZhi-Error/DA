package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class LabelPreference extends Preference {
    private TextView BeG;
    public cn BzG;
    private TextView KcS;
    public as rjX;
    private View zlc;

    public LabelPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public LabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31856);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            LayoutInflater.from(this.mContext).inflate(R.layout.bji, viewGroup2);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(31856);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31857);
        super.onBindView(view);
        if (this.rjX == null) {
            view.setVisibility(8);
            AppMethodBeat.o(31857);
            return;
        }
        view.setVisibility(0);
        if (this.BeG == null) {
            this.BeG = (TextView) view.findViewById(R.id.baw);
        }
        if (this.KcS == null) {
            this.KcS = (TextView) view.findViewById(R.id.bax);
        }
        if (this.KcS != null) {
            ViewGroup.LayoutParams layoutParams = this.KcS.getLayoutParams();
            layoutParams.width = a.aG(this.mContext, R.dimen.em);
            this.KcS.setLayoutParams(layoutParams);
        }
        this.BeG.setVisibility(0);
        if (c.oR(this.rjX.field_type)) {
            String str = this.rjX.field_contactLabelIds;
            ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCJ(str);
            if (!Util.isNullOrNil(str) && arrayList != null && arrayList.size() > 0) {
                this.BeG.setText(l.c(this.mContext, Util.listToString(arrayList, this.mContext.getResources().getString(R.string.b8l))));
            }
            AppMethodBeat.o(31857);
            return;
        }
        if (this.BzG != null) {
            String str2 = this.BzG.field_contactLabels;
            ArrayList arrayList2 = (ArrayList) com.tencent.mm.plugin.label.a.a.ecg().aCI(str2);
            if (!Util.isNullOrNil(str2) && arrayList2 != null && arrayList2.size() > 0) {
                this.BeG.setText(l.c(this.mContext, Util.listToString(arrayList2, this.mContext.getResources().getString(R.string.b8l))));
            }
        }
        AppMethodBeat.o(31857);
    }
}
