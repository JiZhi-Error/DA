package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class HeadImgAndNamePreference extends Preference {
    private View OXG;
    private LinearLayout OXH;
    private String OXI;
    private boolean OXJ;
    private boolean OXK;
    private a OXL;
    private ImageView gBZ;
    private int height;
    private TextView jBR;
    private ImageView qbE;
    private View.OnClickListener zHh;

    public interface a {
        void b(String str, ImageView imageView);
    }

    public HeadImgAndNamePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgAndNamePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164162);
        this.height = -1;
        this.OXK = false;
        this.OXL = null;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(164162);
    }

    public final void a(a aVar) {
        this.OXL = aVar;
    }

    public final void h(View.OnClickListener onClickListener) {
        this.zHh = onClickListener;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(164163);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b92, viewGroup2);
        this.qbE = (ImageView) onCreateView.findViewById(R.id.dvw);
        this.OXG = onCreateView.findViewById(R.id.fa6);
        this.OXH = (LinearLayout) onCreateView.findViewById(R.id.bn3);
        this.gBZ = (ImageView) onCreateView.findViewById(R.id.dt5);
        this.jBR = (TextView) onCreateView.findViewById(R.id.bmr);
        AppMethodBeat.o(164163);
        return onCreateView;
    }

    public final void bmf(String str) {
        AppMethodBeat.i(164164);
        this.OXI = null;
        if (this.qbE == null) {
            this.OXI = str;
        } else if (this.OXL != null) {
            this.OXL.b(str, this.qbE);
        } else if (this.OXJ) {
            com.tencent.mm.ui.g.a.a.d(this.qbE, str);
        } else {
            com.tencent.mm.ui.g.a.a.c(this.qbE, str);
        }
        if (str == null) {
            this.OXK = false;
            AppMethodBeat.o(164164);
            return;
        }
        this.OXK = true;
        AppMethodBeat.o(164164);
    }

    public final void gLE() {
        this.OXJ = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(164165);
        super.onBindView(view);
        if (this.qbE == null) {
            this.qbE = (ImageView) view.findViewById(R.id.dvw);
        }
        if (this.jBR == null) {
            this.jBR = (TextView) view.findViewById(R.id.fzr);
        }
        if (this.OXG == null) {
            this.OXG = view.findViewById(R.id.fa5);
        }
        if (this.zHh != null) {
            this.OXG.setOnClickListener(this.zHh);
        }
        if (this.OXI != null) {
            if (this.OXL != null) {
                this.OXL.b(this.OXI, this.qbE);
            } else if (this.OXJ) {
                com.tencent.mm.ui.g.a.a.d(this.qbE, this.OXI);
            } else {
                com.tencent.mm.ui.g.a.a.c(this.qbE, this.OXI);
            }
            this.OXI = null;
        }
        if (!this.OXK) {
            this.OXG.setVisibility(8);
            this.jBR.setVisibility(0);
        } else {
            this.jBR.setVisibility(8);
            this.OXG.setVisibility(0);
            if (this.OXJ) {
                this.OXG.setBackground(this.mContext.getDrawable(R.drawable.aso));
            } else {
                this.OXG.setBackground(this.mContext.getDrawable(R.drawable.asm));
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fg1);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.o(164165);
    }
}
