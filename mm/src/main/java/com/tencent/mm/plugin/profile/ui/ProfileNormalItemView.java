package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.Util;

public class ProfileNormalItemView extends ProfileItemView {
    TextView Bau;
    CharSequence Bic;
    View.OnClickListener Bid;
    View Bie;
    private TextView mPa;
    String mTitle;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27381);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.ProfileNormalItemView);
        this.mTitle = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(27381);
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public int getLayout() {
        return R.layout.bjl;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final void init() {
        AppMethodBeat.i(27382);
        this.mPa = (TextView) findViewById(R.id.bck);
        this.Bau = (TextView) findViewById(R.id.bcj);
        this.Bie = findViewById(R.id.h6o);
        AppMethodBeat.o(27382);
    }

    public final ProfileNormalItemView UO(int i2) {
        AppMethodBeat.i(27383);
        this.mTitle = getContext().getString(i2);
        AppMethodBeat.o(27383);
        return this;
    }

    public final ProfileNormalItemView UP(int i2) {
        AppMethodBeat.i(27384);
        this.Bic = getContext().getString(i2);
        AppMethodBeat.o(27384);
        return this;
    }

    public final ProfileNormalItemView UQ(int i2) {
        AppMethodBeat.i(27385);
        this.Bau.setTextColor(i2);
        AppMethodBeat.o(27385);
        return this;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean eEV() {
        AppMethodBeat.i(27386);
        this.mPa.setText(this.mTitle);
        if (Util.isNullOrNil(this.Bic)) {
            setVisibility(8);
            AppMethodBeat.o(27386);
            return false;
        }
        setVisibility(0);
        this.Bau.setText(this.Bic);
        setOnClickListener(this.Bid);
        AppMethodBeat.o(27386);
        return true;
    }
}
