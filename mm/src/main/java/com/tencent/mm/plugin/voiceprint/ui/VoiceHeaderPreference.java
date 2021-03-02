package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private ImageView gBZ;
    private MMActivity gte;
    private TextView jBS;
    private String mTitle;
    private int sUb;
    private Button sUc;
    private View sUd;
    private View.OnClickListener sUe;
    private String sUf;
    private String sUg;
    private TextView titleTv;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(29867);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(29867);
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(29868);
        this.mTitle = "";
        this.sUb = 255;
        this.sUe = null;
        this.sUf = "";
        this.sUg = "";
        this.gte = (MMActivity) context;
        setLayoutResource(R.layout.c6o);
        AppMethodBeat.o(29868);
    }

    public final void gD(String str, String str2) {
        AppMethodBeat.i(29869);
        this.sUf = str;
        this.sUg = str2;
        if (this.titleTv != null) {
            if (!Util.isNullOrNil(this.sUf)) {
                this.titleTv.setText(this.sUf);
                this.titleTv.setVisibility(0);
            } else {
                this.titleTv.setVisibility(8);
            }
        }
        if (this.jBS != null) {
            if (!Util.isNullOrNil(this.sUg)) {
                this.jBS.setText(this.sUg);
                this.jBS.setVisibility(0);
                AppMethodBeat.o(29869);
                return;
            }
            this.jBS.setVisibility(8);
        }
        AppMethodBeat.o(29869);
    }

    public final void b(View.OnClickListener onClickListener) {
        AppMethodBeat.i(29870);
        this.sUe = onClickListener;
        if (this.sUc == null || this.sUd == null) {
            AppMethodBeat.o(29870);
        } else if (this.sUc == null || this.sUe == null) {
            this.sUc.setVisibility(8);
            this.sUd.setVisibility(8);
            AppMethodBeat.o(29870);
        } else {
            this.sUc.setOnClickListener(onClickListener);
            this.sUc.setVisibility(0);
            this.sUd.setVisibility(0);
            AppMethodBeat.o(29870);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29871);
        super.onBindView(view);
        this.gBZ = (ImageView) view.findViewById(R.id.j_i);
        this.titleTv = (TextView) view.findViewById(R.id.j_j);
        this.jBS = (TextView) view.findViewById(R.id.j_l);
        this.sUc = (Button) view.findViewById(R.id.h6z);
        this.sUd = view.findViewById(R.id.ah7);
        if (!Util.isNullOrNil(this.sUf)) {
            this.titleTv.setText(this.sUf);
            this.titleTv.setVisibility(0);
        } else {
            this.titleTv.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.sUg)) {
            this.jBS.setText(this.sUg);
            this.jBS.setVisibility(0);
        } else {
            this.jBS.setVisibility(8);
        }
        if (this.sUc == null || this.sUe == null) {
            this.sUc.setVisibility(8);
            this.sUd.setVisibility(8);
            AppMethodBeat.o(29871);
            return;
        }
        this.sUc.setOnClickListener(this.sUe);
        this.sUc.setVisibility(0);
        this.sUd.setVisibility(0);
        AppMethodBeat.o(29871);
    }
}
