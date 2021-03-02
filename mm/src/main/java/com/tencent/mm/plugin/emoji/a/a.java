package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a {
    private final String TAG;
    protected View kHq;
    Context mContext;
    private LayoutInflater mLayoutInflater;
    protected TextView mPa;
    public int mPosition;
    private View qWE;
    private final int qWF;
    private final int qWG;
    private final int qWH;
    private int[] qWI;
    private int qWJ;
    public f qWK;
    protected View qWL;
    protected ImageView qWM;
    protected ImageView qWN;
    protected View qWO;
    protected TextView qWP;
    protected TextView qWQ;
    protected ProgressBar qWR;
    protected ViewGroup qWS;
    protected View qWT;
    protected TextView qWU;
    protected ImageView qWV;
    protected View qWW;
    protected ProgressBar qWX;
    protected TextView qWY;
    protected TextView qWZ;
    protected FrameLayout qXa;

    /* access modifiers changed from: protected */
    public abstract void cET();

    /* access modifiers changed from: protected */
    public abstract int[] cEU();

    /* access modifiers changed from: protected */
    public abstract int cEV();

    /* access modifiers changed from: protected */
    public abstract boolean cFe();

    /* renamed from: com.tencent.mm.plugin.emoji.a.a$a  reason: collision with other inner class name */
    public enum EnumC0956a {
        LIST,
        GRID_MAIN,
        GRID_RECOMMEND;

        public static EnumC0956a valueOf(String str) {
            AppMethodBeat.i(108293);
            EnumC0956a aVar = (EnumC0956a) Enum.valueOf(EnumC0956a.class, str);
            AppMethodBeat.o(108293);
            return aVar;
        }

        static {
            AppMethodBeat.i(108294);
            AppMethodBeat.o(108294);
        }
    }

    public a(Context context, View view) {
        this(context, view, EnumC0956a.LIST);
    }

    private a(Context context, View view, EnumC0956a aVar) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.qWF = R.layout.a1u;
        this.qWG = R.layout.a2z;
        this.qWH = R.layout.a30;
        this.qWI = new int[]{-1, -1};
        this.qWJ = -1;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (aVar) {
                case LIST:
                    view = FH(this.qWF);
                    break;
                case GRID_MAIN:
                    view = FH(this.qWH);
                    break;
                case GRID_RECOMMEND:
                    view = FH(this.qWG);
                    break;
                default:
                    view = FH(this.qWF);
                    break;
            }
        }
        this.kHq = view;
        if (view != null) {
            this.qWE = view;
            this.qWL = this.qWE.findViewById(R.id.e22);
            this.qWN = (ImageView) this.qWE.findViewById(R.id.e3z);
            this.qWM = (ImageView) this.qWE.findViewById(R.id.e2f);
            this.mPa = (TextView) this.qWE.findViewById(R.id.e38);
            this.qWO = this.qWE.findViewById(R.id.e3_);
            this.qWP = (TextView) this.qWE.findViewById(R.id.e25);
            this.qWQ = (TextView) this.qWE.findViewById(R.id.e2k);
            this.qWR = (ProgressBar) this.qWE.findViewById(R.id.ggy);
            this.qWT = this.qWE.findViewById(R.id.e3c);
            this.qWS = (ViewGroup) this.qWE.findViewById(R.id.e3n);
            this.qWU = (TextView) this.qWE.findViewById(R.id.e3u);
            this.qWV = (ImageView) this.qWE.findViewById(R.id.e3w);
            this.qWW = this.qWE.findViewById(R.id.e3l);
            this.qWX = (ProgressBar) this.qWE.findViewById(R.id.e2b);
            this.qWY = (TextView) this.qWE.findViewById(R.id.e20);
            this.qWZ = (TextView) this.qWE.findViewById(R.id.e3a);
            this.qXa = (FrameLayout) this.qWE.findViewById(R.id.e2w);
        }
        cET();
        if (aVar == EnumC0956a.LIST) {
            int[] cEU = cEU();
            if (this.qWM != null && cEU[0] >= 0 && cEU[1] >= 0 && !(cEU[0] == this.qWI[0] && cEU[1] == this.qWI[1])) {
                ViewGroup.LayoutParams layoutParams = this.qWM.getLayoutParams();
                layoutParams.width = cEU[0];
                layoutParams.height = cEU[1];
                this.qWM.setLayoutParams(layoutParams);
                this.qWI = cEU;
            }
            int cEV = cEV();
            if (!(this.qWE == null || cEV < 0 || this.qWJ == cEV)) {
                this.qWE.setMinimumHeight(cEV);
                if (this.qWL != null) {
                    this.qWL.setMinimumHeight(cEV);
                }
            }
        }
        view.setTag(this);
    }

    private View FH(int i2) {
        if (this.mLayoutInflater == null || i2 <= 0) {
            return null;
        }
        return this.mLayoutInflater.inflate(i2, (ViewGroup) null);
    }

    public final void setTitle(String str) {
        this.mPa.setText(str);
    }

    public final void cEW() {
        this.mPa.setText(R.string.bvz);
    }

    public final ImageView cEX() {
        return this.qWM;
    }

    public final void cEY() {
        this.qWM.setImageResource(R.drawable.icon_002_cover);
    }

    public final ImageView cEZ() {
        return this.qWN;
    }

    public final void FI(int i2) {
        this.qWN.setVisibility(i2);
    }

    public final void cFa() {
        this.qWN.setImageResource(R.drawable.bcz);
    }

    public final void FJ(int i2) {
        this.qWT.setVisibility(i2);
    }

    public final void cFb() {
        this.qWP.setVisibility(8);
        this.qWQ.setVisibility(8);
    }

    public final void alY(String str) {
        this.qWP.setText(str);
    }

    public final void alZ(String str) {
        if (Util.isNullOrNil(str)) {
            this.qWQ.setVisibility(8);
            return;
        }
        this.qWQ.setVisibility(0);
        this.qWQ.setText(str);
    }

    public final void a(final j.a aVar) {
        if (this.qWT != null) {
            this.qWT.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.emoji.a.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(108290);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.a(aVar, view)) {
                        a.this.b(aVar, view);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/adapter/BaseEmojiItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(108290);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(j.a aVar, View view) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(j.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String getProductId() {
        if (this.qWK == null || this.qWK.qYl == null) {
            return null;
        }
        return this.qWK.qYl.ProductID;
    }

    public final int cFc() {
        Integer valueOf;
        if (this.qWK == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(this.qWK.mStatus);
        }
        return valueOf.intValue();
    }

    public final String cFd() {
        if (this.qWK == null || this.qWK.qYl == null) {
            return null;
        }
        return this.qWK.qYl.PackPrice;
    }

    public final int getProgress() {
        if (this.qWK == null) {
            return 0;
        }
        return this.qWK.HH;
    }

    /* access modifiers changed from: protected */
    public final void cFf() {
        this.qWR.setVisibility(8);
        this.qWS.setVisibility(8);
        this.qWT.setEnabled(false);
        this.qWV.setVisibility(8);
        this.qWX.setVisibility(0);
        this.qWX.setProgress(getProgress());
        if (this.qWW == null) {
            this.qWX.setVisibility(0);
        } else {
            this.qWW.setVisibility(0);
        }
    }

    private void cFg() {
        this.qWR.setVisibility(8);
        this.qWS.setBackgroundResource(R.drawable.k7);
        this.qWS.setVisibility(0);
        this.qWT.setEnabled(true);
        this.qWU.setText("");
        if (this.qWW == null) {
            this.qWX.setVisibility(4);
        } else {
            this.qWW.setVisibility(4);
        }
        this.qWU.setVisibility(0);
        this.qWU.setText(R.string.bu7);
        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
        this.qWV.setVisibility(8);
    }

    public void cFh() {
        if (this.qWK != null && cFe()) {
            this.qWU.setVisibility(8);
            this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.fu));
            switch (cFc()) {
                case 0:
                    cFg();
                    return;
                case 1:
                case 2:
                case 5:
                case 9:
                default:
                    Log.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", Integer.valueOf(cFc()));
                    return;
                case 3:
                    cFg();
                    return;
                case 4:
                case 12:
                    this.qWR.setVisibility(8);
                    this.qWS.setBackgroundResource(R.drawable.kd);
                    this.qWS.setVisibility(0);
                    if (this.qWW == null) {
                        this.qWX.setVisibility(4);
                    } else {
                        this.qWW.setVisibility(4);
                    }
                    this.qWT.setEnabled(true);
                    this.qWV.setVisibility(4);
                    this.qWU.setVisibility(0);
                    if (this.qWK.qYl != null) {
                        this.qWU.setText(this.qWK.qYl.PackPrice);
                        return;
                    }
                    return;
                case 6:
                    cFf();
                    return;
                case 7:
                    if (this.qWK.qYp) {
                        Log.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.qWR.setVisibility(8);
                        this.qWS.setBackgroundResource(R.drawable.k7);
                        this.qWS.setVisibility(0);
                        this.qWS.setTag(getProductId());
                        this.qWT.setEnabled(true);
                        this.qWU.setVisibility(0);
                        this.qWU.setText(R.string.bw1);
                        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
                        this.qWV.setVisibility(4);
                        if (this.qWW == null) {
                            this.qWX.setVisibility(4);
                            return;
                        } else {
                            this.qWW.setVisibility(4);
                            return;
                        }
                    } else if (!this.qWK.qYr || !e.fA(this.qWK.qYl.PackFlag, 64)) {
                        this.qWR.setVisibility(8);
                        this.qWS.setVisibility(0);
                        this.qWS.setBackgroundResource(R.drawable.kd);
                        this.qWU.setVisibility(0);
                        this.qWU.setText(R.string.bu9);
                        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.fs));
                        this.qWV.setVisibility(4);
                        this.qWT.setEnabled(false);
                        if (this.qWW == null) {
                            this.qWX.setVisibility(4);
                            return;
                        } else {
                            this.qWW.setVisibility(4);
                            return;
                        }
                    } else {
                        this.qWS.setVisibility(0);
                        this.qWS.setBackgroundResource(R.drawable.kb);
                        this.qWU.setVisibility(0);
                        this.qWU.setText(R.string.bv3);
                        this.qWU.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
                        this.qWV.setVisibility(4);
                        this.qWT.setEnabled(true);
                        if (this.qWW == null) {
                            this.qWX.setVisibility(4);
                            return;
                        } else {
                            this.qWW.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.qWR.setVisibility(8);
                    this.qWS.setBackgroundDrawable(null);
                    this.qWS.setVisibility(0);
                    this.qWT.setEnabled(false);
                    this.qWU.setVisibility(0);
                    this.qWU.setText(R.string.bu_);
                    this.qWV.setVisibility(4);
                    if (this.qWW == null) {
                        this.qWX.setVisibility(4);
                        return;
                    } else {
                        this.qWW.setVisibility(4);
                        return;
                    }
                case 10:
                    this.qWR.setVisibility(8);
                    this.qWS.setBackgroundResource(R.drawable.kd);
                    this.qWS.setVisibility(0);
                    this.qWU.setVisibility(0);
                    this.qWU.setText(R.string.buu);
                    this.qWV.setVisibility(4);
                    this.qWT.setEnabled(true);
                    if (this.qWW == null) {
                        this.qWX.setVisibility(4);
                        return;
                    } else {
                        this.qWW.setVisibility(4);
                        return;
                    }
                case 11:
                    this.qWR.setVisibility(0);
                    this.qWS.setBackgroundResource(R.drawable.kd);
                    this.qWS.setVisibility(0);
                    this.qWU.setVisibility(0);
                    this.qWU.setText("");
                    this.qWT.setEnabled(false);
                    this.qWV.setVisibility(4);
                    if (this.qWW == null) {
                        this.qWX.setVisibility(4);
                        return;
                    } else {
                        this.qWW.setVisibility(4);
                        return;
                    }
            }
        }
    }

    public final View getRoot() {
        return this.kHq;
    }
}
