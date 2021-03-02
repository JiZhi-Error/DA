package com.tencent.mm.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class a {
    private ImageView Gmy;
    private View JoP;
    private ImageView OwD;
    public ViewGroup OwE;
    public WeImageView OwF;
    public TextView OwG;
    public ViewGroup OwH;
    public WeImageView OwI;
    public ImageView OwK;
    private ImageView OwL;
    public ImageView OwM;
    private View OwN;
    private ImageView hNZ;
    public TextView jVO;

    public a(View view) {
        AppMethodBeat.i(141266);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.jVO = (TextView) view.findViewById(R.id.ipt);
        this.OwD = (ImageView) view.findViewById(R.id.iqo);
        this.OwE = (ViewGroup) view.findViewById(R.id.ipv);
        this.OwF = (WeImageView) view.findViewById(R.id.ipu);
        this.OwG = (TextView) view.findViewById(R.id.id2);
        this.OwH = (ViewGroup) view.findViewById(R.id.id4);
        this.OwI = (WeImageView) view.findViewById(R.id.id3);
        this.Gmy = (ImageView) view.findViewById(R.id.fqt);
        this.OwK = (ImageView) view.findViewById(R.id.gab);
        this.OwL = (ImageView) view.findViewById(R.id.gmg);
        this.JoP = view.findViewById(R.id.un);
        this.hNZ = (ImageView) view.findViewById(R.id.uo);
        this.OwM = (ImageView) view.findViewById(R.id.gzr);
        this.OwN = view;
        AppMethodBeat.o(141266);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(141267);
        this.jVO.setText(charSequence);
        if (com.tencent.mm.cb.a.jk(this.jVO.getContext())) {
            this.jVO.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.jVO.getContext(), R.dimen.f3058c)) * com.tencent.mm.cb.a.ji(this.jVO.getContext()));
        }
        AppMethodBeat.o(141267);
    }

    public final void ap(CharSequence charSequence) {
        AppMethodBeat.i(205098);
        if (charSequence == null || Util.isNullOrNil(charSequence.toString())) {
            this.OwG.setVisibility(8);
            AppMethodBeat.o(205098);
            return;
        }
        this.OwG.setVisibility(0);
        this.OwG.setText(charSequence);
        if (com.tencent.mm.cb.a.jk(this.OwG.getContext())) {
            this.OwG.setTextSize(1, 14.0f);
            this.jVO.setTextSize(1, 18.0f);
        }
        AppMethodBeat.o(205098);
    }

    public final void AR(boolean z) {
        AppMethodBeat.i(141268);
        this.Gmy.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(141268);
    }

    public final void AS(boolean z) {
        AppMethodBeat.i(141269);
        this.OwL.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(141269);
    }

    public final void setClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(141270);
        this.JoP.setOnClickListener(onClickListener);
        AppMethodBeat.o(141270);
    }

    public final void gGI() {
        AppMethodBeat.i(205099);
        if (this.hNZ != null) {
            this.hNZ.setImageResource(R.raw.actionbar_icon_dark_back);
        }
        AppMethodBeat.o(205099);
    }
}
