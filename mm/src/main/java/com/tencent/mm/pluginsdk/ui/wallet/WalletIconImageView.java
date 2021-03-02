package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class WalletIconImageView extends WeImageView {
    private int GRb;
    private int Kxi;
    private int Kxj;
    private int Kxk;
    private int Kxl;
    private Drawable Kxm;
    private View.OnClickListener Kxn;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.Kxi = -1;
        this.Kxj = 0;
        this.Kxk = 4;
        this.GRb = -1;
        this.Kxl = -1;
        this.Kxn = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletIconImageView(Context context) {
        super(context);
        this.Kxi = -1;
        this.Kxj = 0;
        this.Kxk = 4;
        this.GRb = -1;
        this.Kxl = -1;
        this.Kxn = null;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageResource(int i2) {
        AppMethodBeat.i(72410);
        this.Kxi = i2;
        if (this.Kxi != -1) {
            super.setImageResource(i2);
        }
        AppMethodBeat.o(72410);
    }

    public void setmUserSetImageIconColor(int i2) {
        AppMethodBeat.i(174532);
        this.Kxj = i2;
        if (i2 != -1) {
            setIconColor(i2);
        }
        AppMethodBeat.o(174532);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(72411);
        this.Kxk = i2;
        super.setVisibility(i2);
        AppMethodBeat.o(72411);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Kxn = onClickListener;
    }

    public final void setClearBtnDrawableId$255f295(int i2) {
        this.GRb = R.raw.icons_filled_close2;
        this.Kxl = i2;
    }

    public void setToClearState(View.OnClickListener onClickListener) {
        AppMethodBeat.i(72412);
        super.setVisibility(0);
        if (this.Kxm != null) {
            if (this.Kxl != -1) {
                super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
                setIconColor(this.Kxl);
            }
            setImageDrawable(this.Kxm);
        } else if (this.GRb != -1) {
            super.setImageResource(this.GRb);
            if (this.Kxl != -1) {
                super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
                setIconColor(this.Kxl);
            }
        } else {
            super.setImageResource(R.drawable.a_5);
            if (this.Kxl != -1) {
                super.setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
                setIconColor(this.Kxl);
            } else {
                super.setColorFilter(getResources().getColor(R.color.FG_2), PorterDuff.Mode.SRC_ATOP);
                setIconColor(getResources().getColor(R.color.FG_2));
            }
        }
        super.setContentDescription(getContext().getString(R.string.b5m));
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(72412);
    }

    public final void gsP() {
        AppMethodBeat.i(72413);
        super.setVisibility(this.Kxk);
        setImageResource(this.Kxi);
        if (this.Kxj != -1) {
            super.setColorFilter(this.Kxj, PorterDuff.Mode.SRC_ATOP);
            setIconColor(this.Kxj);
        }
        if (this.Kxn != null) {
            super.setOnClickListener(this.Kxn);
        }
        AppMethodBeat.o(72413);
    }
}
