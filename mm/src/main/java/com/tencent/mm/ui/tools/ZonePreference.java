package com.tencent.mm.ui.tools;

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
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    RegionCodeDecoder.Region Qxt;
    private CharSequence Qxu;
    private TextView Qxv;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(39205);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(39205);
    }

    public final void a(RegionCodeDecoder.Region region) {
        AppMethodBeat.i(39206);
        if (region == null || Util.isNullOrNil(region.getName()) || Util.isNullOrNil(region.getCode())) {
            Log.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            AppMethodBeat.o(39206);
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.Qxt = region;
        AppMethodBeat.o(39206);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(39207);
        this.Qxu = charSequence;
        gXZ();
        AppMethodBeat.o(39207);
    }

    private void gXZ() {
        AppMethodBeat.i(39208);
        if (this.Qxv == null) {
            AppMethodBeat.o(39208);
            return;
        }
        if (this.Qxu == null || Util.isNullOrNil(this.Qxu.toString())) {
            this.Qxv.setVisibility(8);
        } else {
            this.Qxv.setVisibility(0);
        }
        this.Qxv.setText(this.Qxu);
        AppMethodBeat.o(39208);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(39209);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b9s, viewGroup2);
        AppMethodBeat.o(39209);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(39210);
        super.onBindView(view);
        if (this.Qxt == null) {
            AppMethodBeat.o(39210);
            return;
        }
        ((TextView) view.findViewById(R.id.jsn)).setText(this.Qxt.getName());
        this.Qxv = (TextView) view.findViewById(R.id.ien);
        gXZ();
        AppMethodBeat.o(39210);
    }
}
