package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference extends Preference {
    private String PVs;
    private TextView PVt;
    private TextView PVu;
    private TextView PVv;
    private boolean rFe;
    private String title;
    private TextView titleTv;

    public DomainMailListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37816);
        init();
        AppMethodBeat.o(37816);
    }

    public DomainMailListPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(37817);
        init();
        AppMethodBeat.o(37817);
    }

    private void init() {
        this.rFe = false;
        this.title = "";
        this.PVs = "";
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(37818);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b95, viewGroup2);
        AppMethodBeat.o(37818);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(37819);
        this.titleTv = (TextView) view.findViewById(R.id.ipm);
        this.PVt = (TextView) view.findViewById(R.id.d58);
        this.PVu = (TextView) view.findViewById(R.id.hfc);
        this.PVv = (TextView) view.findViewById(R.id.ile);
        this.rFe = true;
        if (!this.rFe) {
            Log.e("MicroMsg.DomainMailPreference", "initView : unbind view");
        } else {
            this.titleTv.setText(Util.nullAsNil(this.title));
            String[] split = this.PVs.split(";");
            if (Util.nullAsNil(this.PVs).length() <= 0) {
                this.PVt.setVisibility(8);
                this.PVu.setVisibility(8);
            } else {
                if (split.length > 0) {
                    this.PVt.setVisibility(0);
                    this.PVt.setText(Util.nullAsNil(split[0]));
                } else {
                    this.PVt.setVisibility(8);
                }
                if (split.length > 1) {
                    this.PVu.setVisibility(0);
                    this.PVu.setText(Util.nullAsNil(split[1]));
                } else {
                    this.PVu.setVisibility(8);
                }
                if (split.length > 2) {
                    this.PVv.setVisibility(0);
                    this.PVv.setText(Util.nullAsNil(split[2]));
                }
            }
            this.PVv.setVisibility(8);
        }
        super.onBindView(view);
        AppMethodBeat.o(37819);
    }
}
