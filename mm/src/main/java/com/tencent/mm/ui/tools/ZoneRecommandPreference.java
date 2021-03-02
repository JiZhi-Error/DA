package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference extends Preference {
    private ImageView QxA;
    RegionCodeDecoder.Region Qxw;
    RegionCodeDecoder.Region Qxx;
    RegionCodeDecoder.Region Qxy;
    private TextView Qxz;
    private TextView gCd;
    int status;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39211);
        this.status = 0;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(39211);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(39212);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9t, viewGroup2);
        this.Qxz = (TextView) onCreateView.findViewById(R.id.jsn);
        this.gCd = (TextView) onCreateView.findViewById(R.id.i56);
        this.QxA = (ImageView) onCreateView.findViewById(R.id.i5f);
        AppMethodBeat.o(39212);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(39213);
        super.onBindView(view);
        gYa();
        AppMethodBeat.o(39213);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void gYa() {
        AppMethodBeat.i(39214);
        if (this.Qxz == null || this.gCd == null) {
            AppMethodBeat.o(39214);
            return;
        }
        switch (this.status) {
            case 0:
                this.Qxz.setVisibility(8);
                this.gCd.setVisibility(0);
                this.gCd.setText(R.string.gmo);
                this.QxA.setImageResource(R.raw.get_location_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.o(39214);
                return;
            case 1:
                this.Qxz.setVisibility(0);
                this.gCd.setVisibility(8);
                this.QxA.setImageResource(R.raw.get_location_icon);
                String str = "";
                if (this.Qxw != null && !Util.isNullOrNil(this.Qxw.getName())) {
                    str = str + this.Qxw.getName();
                }
                if (this.Qxx != null && !Util.isNullOrNil(this.Qxx.getName())) {
                    str = str + " " + this.Qxx.getName();
                }
                if (this.Qxy != null && !Util.isNullOrNil(this.Qxy.getName())) {
                    str = str + " " + this.Qxy.getName();
                }
                this.Qxz.setText(str);
                setEnabled(true);
                setSelectable(true);
                break;
            case 2:
                this.Qxz.setVisibility(8);
                this.gCd.setVisibility(0);
                this.gCd.setText(R.string.gml);
                this.QxA.setImageResource(R.raw.get_location_failed_icon);
                setEnabled(false);
                setSelectable(false);
                AppMethodBeat.o(39214);
                return;
        }
        AppMethodBeat.o(39214);
    }

    public final void gYb() {
        AppMethodBeat.i(39215);
        this.status = 2;
        gYa();
        AppMethodBeat.o(39215);
    }
}
