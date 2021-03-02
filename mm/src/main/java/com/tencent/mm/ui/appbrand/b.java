package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.List;

public final class b extends i implements DialogInterface {
    private LinearLayout NIA;
    private int OMH;
    private ImageView OMI;
    private ImageView OMJ;
    private Button OMK;
    private ViewGroup OML;
    private TextView OMM;
    private TextView OMN;
    private TextView OMO;
    private TextView OMP;
    public List<C2076b> OMQ = new ArrayList();
    public a OMR;
    CompoundButton.OnCheckedChangeListener OMS = new CompoundButton.OnCheckedChangeListener() {
        /* class com.tencent.mm.ui.appbrand.b.AnonymousClass2 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(232740);
            ((C2076b) compoundButton.getTag()).pWp = z;
            if (z) {
                b.b(b.this);
            } else {
                b.c(b.this);
            }
            b.d(b.this);
            AppMethodBeat.o(232740);
        }
    };
    private View.OnClickListener hEZ = new View.OnClickListener() {
        /* class com.tencent.mm.ui.appbrand.b.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(232739);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int id = view.getId();
            if (b.this.OMR != null) {
                if (id == R.id.ash) {
                    b.this.OMR.gKh();
                } else if (id == R.id.as8 || id == R.id.asc) {
                    b.this.OMR.gKi();
                } else if (id == R.id.as9 || id == R.id.asd) {
                    b.this.OMR.gKj();
                } else if (id == R.id.ase) {
                    b.this.OMR.gKk();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandNoticeMoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232739);
        }
    };
    private int mMode;
    private String mRa;
    private boolean nRM;
    private TextView qMb;

    public interface a {
        void gKh();

        void gKi();

        void gKj();

        void gKk();
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.OMH;
        bVar.OMH = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c(b bVar) {
        int i2 = bVar.OMH;
        bVar.OMH = i2 - 1;
        return i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, int i2, String str) {
        super(context, R.style.zm);
        boolean z = false;
        AppMethodBeat.i(232742);
        this.mMode = i2;
        this.mRa = str;
        this.OMH = 0;
        if (!Util.isNullOrNil(str)) {
            this.nRM = (bj(str, 0) || bj(str, 1) || bj(str, 2)) ? true : z;
        }
        this.NIA = (LinearLayout) aa.jQ(context).inflate(R.layout.q1, (ViewGroup) null);
        this.OMI = (ImageView) this.NIA.findViewById(R.id.as7);
        this.OMI.setColorFilter(context.getResources().getColor(R.color.f3045c));
        this.OMJ = (ImageView) this.NIA.findViewById(R.id.as6);
        this.OMJ.setColorFilter(context.getResources().getColor(R.color.f3045c));
        setCanceledOnTouchOutside(true);
        if (this.mMode == 0) {
            ((ViewStub) this.NIA.findViewById(R.id.asb)).inflate();
            this.OMK = (Button) this.NIA.findViewById(R.id.ash);
            this.OML = (ViewGroup) this.NIA.findViewById(R.id.asa);
            this.OMM = (TextView) this.NIA.findViewById(R.id.as8);
            this.qMb = (TextView) this.NIA.findViewById(R.id.as9);
            this.OMK.setOnClickListener(this.hEZ);
            this.OMM.setOnClickListener(this.hEZ);
            this.qMb.setOnClickListener(this.hEZ);
            ArrayList arrayList = new ArrayList();
            Context context2 = this.NIA.getContext();
            arrayList.add(new C2076b(1, context2.getString(R.string.ax_)));
            arrayList.add(new C2076b(2, context2.getString(R.string.ax9)));
            arrayList.add(new C2076b(3, context2.getString(R.string.axa)));
            jd(arrayList);
            AppMethodBeat.o(232742);
            return;
        }
        ((ViewStub) this.NIA.findViewById(R.id.asf)).inflate();
        this.OMN = (TextView) this.NIA.findViewById(R.id.ase);
        this.OMO = (TextView) this.NIA.findViewById(R.id.asc);
        this.OMP = (TextView) this.NIA.findViewById(R.id.asd);
        if (this.nRM) {
            this.OMN.setOnClickListener(this.hEZ);
        } else {
            this.OMN.setVisibility(8);
        }
        this.OMO.setOnClickListener(this.hEZ);
        this.OMP.setOnClickListener(this.hEZ);
        AppMethodBeat.o(232742);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(232743);
        super.onCreate(bundle);
        setContentView(this.NIA);
        AppMethodBeat.o(232743);
    }

    private void jd(List<C2076b> list) {
        AppMethodBeat.i(232744);
        if (list.isEmpty()) {
            Log.i("MicroMsg.AppBrandNoticeMoreDialog", "has no reason data");
            AppMethodBeat.o(232744);
            return;
        }
        this.OMQ.clear();
        this.OMQ.addAll(list);
        Context context = this.NIA.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        int i2 = 0;
        while (i2 < list.size() / 3) {
            linearLayout.setOrientation(0);
            for (int i3 = 0; i3 < 3; i3++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, context.getResources().getDimensionPixelOffset(R.dimen.ip));
                MMCheckBox a2 = a(context, list.get((i2 * 3) + i3));
                if (i3 != 0) {
                    layoutParams.leftMargin = context.getResources().getDimensionPixelOffset(R.dimen.c5);
                }
                linearLayout.addView(a2, layoutParams);
            }
            i2++;
        }
        this.OML.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        for (int i4 = 0; i4 < list.size() - (i2 * 3); i4++) {
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, context.getResources().getDimensionPixelOffset(R.dimen.ip));
            MMCheckBox a3 = a(context, list.get((i2 * 3) + i4));
            if (i4 != 0) {
                layoutParams2.leftMargin = context.getResources().getDimensionPixelOffset(R.dimen.c5);
            }
            linearLayout2.addView(a3, layoutParams2);
        }
        this.OML.addView(linearLayout2);
        AppMethodBeat.o(232744);
    }

    private MMCheckBox a(Context context, C2076b bVar) {
        AppMethodBeat.i(232745);
        MMCheckBox mMCheckBox = new MMCheckBox(new ContextThemeWrapper(context, (int) R.style.s), null, R.style.s);
        mMCheckBox.setText(bVar.gCv);
        mMCheckBox.setTag(bVar);
        mMCheckBox.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context, R.dimen.k6));
        mMCheckBox.setOnCheckedChangeListener(this.OMS);
        AppMethodBeat.o(232745);
        return mMCheckBox;
    }

    private void Bt(boolean z) {
        AppMethodBeat.i(232746);
        if (z) {
            this.OMI.setVisibility(0);
            this.OMJ.setVisibility(8);
            AppMethodBeat.o(232746);
            return;
        }
        this.OMI.setVisibility(8);
        this.OMJ.setVisibility(0);
        AppMethodBeat.o(232746);
    }

    public final void gv(View view) {
        int aH;
        AppMethodBeat.i(232747);
        Context context = view.getContext();
        Point az = ao.az(context);
        if (this.mMode == 0) {
            aH = com.tencent.mm.cb.a.aH(context, R.dimen.wf) + com.tencent.mm.cb.a.aH(context, R.dimen.wb) + com.tencent.mm.cb.a.aH(context, R.dimen.wa);
        } else {
            aH = com.tencent.mm.cb.a.aH(context, R.dimen.wi) + com.tencent.mm.cb.a.aH(context, R.dimen.wb) + com.tencent.mm.cb.a.aH(context, R.dimen.wa);
            if (!this.nRM) {
                aH -= com.tencent.mm.cb.a.aH(context, R.dimen.wk);
            }
        }
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 8388661;
            attributes.verticalMargin = 0.0f;
            attributes.horizontalMargin = 0.0f;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            attributes.x = (((az.x - iArr[0]) - (view.getMeasuredWidth() / 2)) - com.tencent.mm.cb.a.aH(context, R.dimen.w_)) - (com.tencent.mm.cb.a.aH(context, R.dimen.wb) / 2);
            int jJ = ao.jJ(context);
            int aH2 = com.tencent.mm.cb.a.aH(context, R.dimen.wh);
            int aH3 = com.tencent.mm.cb.a.aH(context, R.dimen.wc);
            if ((((iArr[1] + view.getMeasuredHeight()) + aH) + aH2) - aH3 > az.y - ao.aD(context)) {
                attributes.y = (((iArr[1] - jJ) - aH) - aH2) + aH3;
                Bt(false);
            } else {
                attributes.y = (((iArr[1] - jJ) + view.getMeasuredHeight()) + aH2) - aH3;
                Bt(true);
            }
            window.setAttributes(attributes);
        }
        try {
            super.show();
            AppMethodBeat.o(232747);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNoticeMoreDialog", e2, "", new Object[0]);
            AppMethodBeat.o(232747);
        }
    }

    private static boolean bj(String str, int i2) {
        AppMethodBeat.i(232748);
        boolean bf = ((ag) g.af(ag.class)).bf(str, i2);
        AppMethodBeat.o(232748);
        return bf;
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(232749);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.appbrand.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(232741);
                    b.this.dismiss();
                    AppMethodBeat.o(232741);
                }
            });
            Log.e("MicroMsg.AppBrandNoticeMoreDialog", Util.getStack().toString());
            AppMethodBeat.o(232749);
            return;
        }
        try {
            super.dismiss();
            AppMethodBeat.o(232749);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandNoticeMoreDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(232749);
        }
    }

    /* renamed from: com.tencent.mm.ui.appbrand.b$b  reason: collision with other inner class name */
    public class C2076b {
        public int OMU;
        public String gCv;
        public boolean pWp = false;

        public C2076b(int i2, String str) {
            this.OMU = i2;
            this.gCv = str;
        }
    }

    static /* synthetic */ void d(b bVar) {
        int i2;
        AppMethodBeat.i(232750);
        if (bVar.OMK != null) {
            Button button = bVar.OMK;
            if (Math.max(0, bVar.OMH) == 0) {
                i2 = R.string.axe;
            } else {
                i2 = R.string.z9;
            }
            button.setText(i2);
        }
        AppMethodBeat.o(232750);
    }
}
