package com.tencent.mm.plugin.facedetect.ui;

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

public final class FaceHeaderPreference extends Preference {
    private ImageView gBZ;
    private MMActivity gte;
    private String mTitle;
    private int sUb;
    private Button sUc;
    private View sUd;
    private View.OnClickListener sUe;
    private String sUf;
    private String sUg;
    private TextView titleTv;

    public FaceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(104019);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(104019);
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104020);
        this.mTitle = "";
        this.sUb = 255;
        this.sUe = null;
        this.sUf = "";
        this.sUg = "";
        this.gte = (MMActivity) context;
        setLayoutResource(R.layout.a6b);
        AppMethodBeat.o(104020);
    }

    public final void gD(String str, String str2) {
        AppMethodBeat.i(104021);
        this.sUf = str;
        this.sUg = str2;
        if (this.titleTv != null) {
            if (!Util.isNullOrNil(this.sUf)) {
                this.titleTv.setText(this.sUf);
                this.titleTv.setVisibility(0);
                AppMethodBeat.o(104021);
                return;
            }
            this.titleTv.setVisibility(8);
        }
        AppMethodBeat.o(104021);
    }

    public final void b(View.OnClickListener onClickListener) {
        AppMethodBeat.i(104022);
        this.sUe = onClickListener;
        if (this.sUc == null || this.sUd == null) {
            AppMethodBeat.o(104022);
        } else if (this.sUc == null || this.sUe == null) {
            this.sUc.setVisibility(8);
            this.sUd.setVisibility(8);
            AppMethodBeat.o(104022);
        } else {
            this.sUc.setOnClickListener(onClickListener);
            this.sUc.setVisibility(0);
            this.sUd.setVisibility(0);
            AppMethodBeat.o(104022);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(104023);
        super.onBindView(view);
        this.gBZ = (ImageView) view.findViewById(R.id.c__);
        this.titleTv = (TextView) view.findViewById(R.id.c_a);
        this.sUc = (Button) view.findViewById(R.id.h6z);
        this.sUd = view.findViewById(R.id.ah7);
        if (!Util.isNullOrNil(this.sUf)) {
            this.titleTv.setText(this.sUf);
            this.titleTv.setVisibility(0);
        } else {
            this.titleTv.setVisibility(8);
        }
        if (this.sUc == null || this.sUe == null) {
            if (this.sUc != null) {
                this.sUc.setVisibility(8);
            }
            this.sUd.setVisibility(8);
            AppMethodBeat.o(104023);
            return;
        }
        this.sUc.setOnClickListener(this.sUe);
        this.sUc.setVisibility(0);
        this.sUd.setVisibility(0);
        AppMethodBeat.o(104023);
    }
}
