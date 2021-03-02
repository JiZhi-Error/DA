package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMKeyBoardView extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    private a BoW;
    private View BpA;
    private View BpB;
    private View BpC;
    private View BpD;
    private View BpE;
    private View BpF;
    private boolean BpG;
    private int BpH;
    private int BpI;
    private ColorStateList BpJ;
    private int BpK;
    private int BpL;
    private int BpM;
    private int BpN;
    private int BpO;
    private int BpP;
    private int BpQ;
    private Button Bpp;
    private Button Bpq;
    private Button Bpr;
    private Button Bps;
    private Button Bpt;
    private Button Bpu;
    private Button Bpv;
    private Button Bpw;
    private Button Bpx;
    private Button Bpy;
    private ImageButton Bpz;
    private float gPN;
    private Context mContext;

    public interface a {
        void byC();

        void delete();

        void input(String str);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(27686);
        this.BpG = true;
        this.mContext = context;
        this.BpH = getResources().getDimensionPixelSize(R.dimen.a_b);
        this.BpI = getResources().getDimensionPixelSize(R.dimen.a_c);
        this.gPN = (float) getResources().getDimensionPixelSize(R.dimen.a_d);
        this.BpJ = getResources().getColorStateList(R.color.wg);
        this.BpK = getResources().getColor(R.color.wf);
        this.Bpp = new Button(this.mContext);
        this.Bpq = new Button(this.mContext);
        this.Bpr = new Button(this.mContext);
        this.Bps = new Button(this.mContext);
        this.Bpt = new Button(this.mContext);
        this.Bpu = new Button(this.mContext);
        this.Bpv = new Button(this.mContext);
        this.Bpw = new Button(this.mContext);
        this.Bpx = new Button(this.mContext);
        this.Bpy = new Button(this.mContext);
        this.Bpz = new ImageButton(this.mContext);
        this.BpA = new View(this.mContext);
        this.BpA = new View(this.mContext);
        this.BpB = new View(this.mContext);
        this.BpC = new View(this.mContext);
        this.BpD = new View(this.mContext);
        this.BpE = new View(this.mContext);
        this.BpF = new View(this.mContext);
        this.Bpp.setBackgroundResource(R.drawable.a96);
        this.Bpq.setBackgroundResource(R.drawable.a96);
        this.Bpr.setBackgroundResource(R.drawable.a96);
        this.Bps.setBackgroundResource(R.drawable.a96);
        this.Bpt.setBackgroundResource(R.drawable.a96);
        this.Bpu.setBackgroundResource(R.drawable.a96);
        this.Bpv.setBackgroundResource(R.drawable.a96);
        this.Bpw.setBackgroundResource(R.drawable.a96);
        this.Bpx.setBackgroundResource(R.drawable.a96);
        this.Bpu.setBackgroundResource(R.drawable.a96);
        this.Bpy.setBackgroundResource(R.drawable.a96);
        this.Bpz.setBackgroundResource(R.drawable.a96);
        this.Bpz.setImageResource(R.drawable.a97);
        this.Bpp.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.Bpq.setText("1");
        this.Bpr.setText("2");
        this.Bps.setText(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        this.Bpt.setText("4");
        this.Bpu.setText("5");
        this.Bpv.setText("6");
        this.Bpw.setText("7");
        this.Bpx.setText("8");
        this.Bpy.setText("9");
        this.Bpp.setGravity(17);
        this.Bpq.setGravity(17);
        this.Bpr.setGravity(17);
        this.Bps.setGravity(17);
        this.Bpt.setGravity(17);
        this.Bpu.setGravity(17);
        this.Bpv.setGravity(17);
        this.Bpw.setGravity(17);
        this.Bpx.setGravity(17);
        this.Bpy.setGravity(17);
        this.Bpp.setTextSize(0, this.gPN);
        this.Bpq.setTextSize(0, this.gPN);
        this.Bpr.setTextSize(0, this.gPN);
        this.Bps.setTextSize(0, this.gPN);
        this.Bpt.setTextSize(0, this.gPN);
        this.Bpu.setTextSize(0, this.gPN);
        this.Bpv.setTextSize(0, this.gPN);
        this.Bpw.setTextSize(0, this.gPN);
        this.Bpx.setTextSize(0, this.gPN);
        this.Bpy.setTextSize(0, this.gPN);
        this.Bpp.setTextColor(this.BpJ);
        this.Bpq.setTextColor(this.BpJ);
        this.Bpr.setTextColor(this.BpJ);
        this.Bps.setTextColor(this.BpJ);
        this.Bpt.setTextColor(this.BpJ);
        this.Bpu.setTextColor(this.BpJ);
        this.Bpv.setTextColor(this.BpJ);
        this.Bpw.setTextColor(this.BpJ);
        this.Bpx.setTextColor(this.BpJ);
        this.Bpy.setTextColor(this.BpJ);
        this.Bpp.setOnClickListener(this);
        this.Bpq.setOnClickListener(this);
        this.Bpr.setOnClickListener(this);
        this.Bps.setOnClickListener(this);
        this.Bpt.setOnClickListener(this);
        this.Bpu.setOnClickListener(this);
        this.Bpv.setOnClickListener(this);
        this.Bpw.setOnClickListener(this);
        this.Bpx.setOnClickListener(this);
        this.Bpy.setOnClickListener(this);
        this.Bpz.setOnClickListener(this);
        this.Bpz.setOnLongClickListener(this);
        this.BpA.setBackgroundColor(this.BpK);
        this.BpA.setBackgroundColor(this.BpK);
        this.BpB.setBackgroundColor(this.BpK);
        this.BpC.setBackgroundColor(this.BpK);
        this.BpD.setBackgroundColor(this.BpK);
        this.BpE.setBackgroundColor(this.BpK);
        this.BpF.setBackgroundColor(this.BpK);
        addView(this.Bpp);
        addView(this.Bpq);
        addView(this.Bpr);
        addView(this.Bps);
        addView(this.Bpt);
        addView(this.Bpu);
        addView(this.Bpv);
        addView(this.Bpw);
        addView(this.Bpx);
        addView(this.Bpy);
        addView(this.Bpz);
        addView(this.BpA);
        addView(this.BpB);
        addView(this.BpC);
        addView(this.BpD);
        addView(this.BpE);
        addView(this.BpF);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(27685);
                MMKeyBoardView.this.requestLayout();
                AppMethodBeat.o(27685);
            }
        });
        AppMethodBeat.o(27686);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(27687);
        super.onLayout(z, i2, i3, i4, i5);
        this.BpL = getWidth();
        this.BpM = getHeight();
        int i6 = -this.BpI;
        int i7 = (this.BpP - this.BpI) + 1;
        int i8 = ((this.BpP * 2) - this.BpI) + 2;
        int i9 = this.BpQ + 2;
        int i10 = (this.BpQ * 2) + 3;
        int i11 = (this.BpQ * 3) + 4;
        this.Bpq.layout(i6, 1, this.BpN + i6, this.BpO + 1);
        this.Bpr.layout(i7, 1, this.BpN + i7, this.BpO + 1);
        this.Bps.layout(i8, 1, this.BpN + i8, this.BpO + 1);
        this.Bpt.layout(i6, i9, this.BpN + i6, this.BpO + i9);
        this.Bpu.layout(i7, i9, this.BpN + i7, this.BpO + i9);
        this.Bpv.layout(i8, i9, this.BpN + i8, this.BpO + i9);
        this.Bpw.layout(i6, i10, this.BpN + i6, this.BpO + i10);
        this.Bpx.layout(i7, i10, this.BpN + i7, this.BpO + i10);
        this.Bpy.layout(i8, i10, this.BpN + i8, this.BpO + i10);
        this.Bpp.layout(i7, i11, this.BpN + i7, this.BpO + i11);
        this.Bpz.layout(i8, i11, this.BpN + i8, this.BpO + i11);
        this.BpA.layout(0, this.BpH + 1, this.BpL, this.BpH + 1 + 1);
        this.BpB.layout(0, this.BpH + i9, this.BpL, i9 + this.BpH + 1);
        this.BpC.layout(0, this.BpH + i10, this.BpL, i10 + this.BpH + 1);
        this.BpD.layout(0, this.BpH + i11, this.BpL, this.BpH + i11 + 1);
        this.BpE.layout(this.BpP + 1, this.BpH, this.BpP + 2, this.BpM);
        this.BpF.layout((this.BpP * 2) + 2, this.BpH, (this.BpP * 2) + 3, this.BpM);
        AppMethodBeat.o(27687);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(27688);
        super.onMeasure(i2, i3);
        this.BpL = getWidth();
        this.BpM = getHeight();
        if (!(this.BpL == 0 || this.BpM == 0)) {
            this.BpP = (this.BpL - 2) / 3;
            this.BpQ = ((this.BpM - this.BpH) - 4) / 4;
            this.BpN = this.BpP + (this.BpI * 2);
            this.BpO = this.BpQ + (this.BpH * 2);
        }
        this.Bpq.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpr.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bps.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpt.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpu.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpv.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpw.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpx.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpy.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpp.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.Bpz.measure(View.MeasureSpec.makeMeasureSpec(this.BpN, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpO, 1073741824));
        this.BpA.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.BpB.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.BpC.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.BpD.measure(View.MeasureSpec.makeMeasureSpec(this.BpL, 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.BpE.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpM, 1073741824));
        this.BpF.measure(View.MeasureSpec.makeMeasureSpec(1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.BpM, 1073741824));
        AppMethodBeat.o(27688);
    }

    public void onClick(View view) {
        AppMethodBeat.i(27689);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!this.BpG) {
            Log.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27689);
            return;
        }
        if (view == this.Bpp) {
            input(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else if (view == this.Bpq) {
            input("1");
        } else if (view == this.Bpr) {
            input("2");
        } else if (view == this.Bps) {
            input(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (view == this.Bpt) {
            input("4");
        } else if (view == this.Bpu) {
            input("5");
        } else if (view == this.Bpv) {
            input("6");
        } else if (view == this.Bpw) {
            input("7");
        } else if (view == this.Bpx) {
            input("8");
        } else if (view == this.Bpy) {
            input("9");
        } else if (view == this.Bpz && this.BoW != null && this.BpG) {
            this.BoW.delete();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27689);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(27690);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        if (view == this.Bpz && this.BoW != null && this.BpG) {
            this.BoW.byC();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/pwdgroup/ui/widget/MMKeyBoardView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27690);
        return false;
    }

    public void setKeyBoardEnable(boolean z) {
        AppMethodBeat.i(27691);
        this.BpG = z;
        this.Bpp.setEnabled(z);
        this.Bpq.setEnabled(z);
        this.Bpr.setEnabled(z);
        this.Bps.setEnabled(z);
        this.Bpt.setEnabled(z);
        this.Bpu.setEnabled(z);
        this.Bpv.setEnabled(z);
        this.Bpw.setEnabled(z);
        this.Bpx.setEnabled(z);
        this.Bpy.setEnabled(z);
        this.Bpz.setEnabled(z);
        AppMethodBeat.o(27691);
    }

    public void setOnInputDeleteListener(a aVar) {
        this.BoW = aVar;
    }

    private void input(String str) {
        AppMethodBeat.i(27692);
        if (this.BoW != null && this.BpG) {
            this.BoW.input(str);
        }
        AppMethodBeat.o(27692);
    }
}
