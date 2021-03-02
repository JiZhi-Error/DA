package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class HeadImgNewPreference extends Preference {
    private View KgF;
    private String OXI;
    private boolean OXJ;
    private boolean OXK;
    private TextView OXM;
    private a OXN;
    private int height;
    private ImageView kc;
    public View.OnClickListener zHh;

    public interface a {
        void b(String str, ImageView imageView);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164166);
        this.height = -1;
        this.OXK = false;
        this.OXN = null;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(164166);
    }

    public final void a(a aVar) {
        this.OXN = aVar;
    }

    public final void h(View.OnClickListener onClickListener) {
        this.zHh = onClickListener;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(164167);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b91, viewGroup2);
        this.kc = (ImageView) onCreateView.findViewById(R.id.dvw);
        this.OXM = (TextView) onCreateView.findViewById(R.id.fzr);
        this.KgF = onCreateView.findViewById(R.id.fa5);
        AppMethodBeat.o(164167);
        return onCreateView;
    }

    public final void bmf(String str) {
        AppMethodBeat.i(164168);
        this.OXI = null;
        if (this.kc == null) {
            this.OXI = str;
        } else if (this.OXN != null) {
            this.OXN.b(str, this.kc);
        } else if (this.OXJ) {
            com.tencent.mm.ui.g.a.a.d(this.kc, str);
        } else {
            com.tencent.mm.ui.g.a.a.c(this.kc, str);
        }
        if (str == null) {
            this.OXK = false;
            AppMethodBeat.o(164168);
            return;
        }
        this.OXK = true;
        AppMethodBeat.o(164168);
    }

    public final void gLE() {
        this.OXJ = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(164169);
        super.onBindView(view);
        if (this.kc == null) {
            this.kc = (ImageView) view.findViewById(R.id.dvw);
        }
        if (this.OXM == null) {
            this.OXM = (TextView) view.findViewById(R.id.fzr);
        }
        if (this.KgF == null) {
            this.KgF = view.findViewById(R.id.fa5);
        }
        if (this.zHh != null) {
            this.KgF.setOnClickListener(this.zHh);
        }
        if (this.OXI != null) {
            if (this.OXN != null) {
                this.OXN.b(this.OXI, this.kc);
            } else if (this.OXJ) {
                com.tencent.mm.ui.g.a.a.d(this.kc, this.OXI);
            } else {
                com.tencent.mm.ui.g.a.a.c(this.kc, this.OXI);
            }
            this.OXI = null;
        }
        if (!this.OXK) {
            this.KgF.setVisibility(8);
            this.OXM.setVisibility(0);
        } else {
            this.OXM.setVisibility(8);
            this.KgF.setVisibility(0);
            if (this.OXJ) {
                this.KgF.setBackground(this.mContext.getDrawable(R.drawable.aso));
            } else {
                this.KgF.setBackground(this.mContext.getDrawable(R.drawable.asm));
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fg1);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.o(164169);
    }
}
