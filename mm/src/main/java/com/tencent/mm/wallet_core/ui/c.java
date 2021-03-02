package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.da;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public final class c {
    private String AII;
    public Bitmap AKT;
    public Bitmap AKU;
    private String ALA;
    ViewGroup Rvu;
    private boolean Rvv;
    public p kuK;
    private ImageView kuL;
    private View kuM;
    private View.OnClickListener kuO;
    MMActivity pQZ;
    public boolean pZM;
    private Bitmap qdH;
    private View qdK;
    private ImageView qdL;
    private MMVerticalTextView qdM;
    private ArrayList<Bitmap> qdO;

    public c(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(72952);
        this.AKT = null;
        this.AKU = null;
        this.qdH = null;
        this.ALA = "";
        this.AII = "";
        this.pZM = true;
        this.qdO = new ArrayList<>();
        this.kuK = null;
        this.Rvv = false;
        this.kuO = new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72948);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if ((view.getId() == R.id.gel || view.getId() == R.id.geh) && c.this.kuK != null && c.this.kuK.isShowing()) {
                    c.this.kuK.dismiss();
                }
                a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72948);
            }
        };
        this.pQZ = mMActivity;
        this.Rvv = z;
        AppMethodBeat.o(72952);
    }

    public c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    public final void nC(String str, String str2) {
        this.ALA = str;
        this.AII = str2;
    }

    public final void release() {
        AppMethodBeat.i(72953);
        if (this.kuK != null && this.kuK.isShowing()) {
            this.kuK.dismiss();
        }
        f.Z(this.qdH);
        f.bu(this.qdO);
        this.qdO.clear();
        this.pQZ = null;
        AppMethodBeat.o(72953);
    }

    public final void hhP() {
        View view;
        AppMethodBeat.i(72954);
        if (this.kuK != null) {
            AppMethodBeat.o(72954);
            return;
        }
        if (this.Rvv) {
            View inflate = View.inflate(this.pQZ, R.layout.c_2, null);
            MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(R.id.fa7);
            mMVerticalTextView.setMediumBold(true);
            this.Rvu = (ViewGroup) inflate.findViewById(R.id.gek);
            mMVerticalTextView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.c.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72949);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.OfflinePopupWindow", "on click know");
                    c.this.Rvu.setVisibility(8);
                    da daVar = new da();
                    daVar.dGj.dGk = 1;
                    EventCenter.instance.publish(daVar);
                    a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72949);
                }
            });
            inflate.findViewById(R.id.gej).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.c.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72950);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.d("MicroMsg.OfflinePopupWindow", "root on click");
                    if (c.this.kuK != null && c.this.kuK.isShowing()) {
                        c.this.kuK.dismiss();
                    }
                    a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72950);
                }
            });
            view = inflate;
        } else {
            View inflate2 = View.inflate(this.pQZ, R.layout.c_5, null);
            inflate2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.wallet_core.ui.c.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(72951);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (c.this.kuK != null && c.this.kuK.isShowing()) {
                        c.this.kuK.dismiss();
                    }
                    a.a(this, "com/tencent/mm/wallet_core/ui/OfflinePopupWindow$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72951);
                }
            });
            view = inflate2;
        }
        this.kuM = view.findViewById(R.id.gem);
        this.kuL = (ImageView) view.findViewById(R.id.gel);
        this.qdK = view.findViewById(R.id.gei);
        this.qdL = (ImageView) view.findViewById(R.id.geh);
        this.qdM = (MMVerticalTextView) view.findViewById(R.id.j3c);
        this.kuK = new p(view, -1, -1, true);
        this.kuK.setClippingEnabled(false);
        this.kuK.update();
        this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
        this.kuK.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class com.tencent.mm.wallet_core.ui.c.AnonymousClass5 */

            public final void onDismiss() {
                AppMethodBeat.i(214336);
                c.this.pQZ.getWindow().clearFlags(1024);
                AppMethodBeat.o(214336);
            }
        });
        AppMethodBeat.o(72954);
    }

    public final void aa(View view, boolean z) {
        AppMethodBeat.i(72955);
        this.pZM = z;
        if (this.kuK != null && !this.kuK.isShowing()) {
            this.kuK.showAtLocation(view.getRootView(), 17, 0, 0);
            this.kuK.setFocusable(true);
            this.kuK.setTouchable(true);
            this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
            this.kuK.setOutsideTouchable(true);
            if (this.pZM) {
                hhR();
            }
            hhS();
            this.pQZ.getWindow().addFlags(1024);
        }
        AppMethodBeat.o(72955);
    }

    public final void hhQ() {
        AppMethodBeat.i(72956);
        if (this.kuK != null && this.kuK.isShowing()) {
            hhS();
        }
        AppMethodBeat.o(72956);
    }

    public final void hhR() {
        AppMethodBeat.i(72957);
        if (this.Rvu != null) {
            this.Rvu.setVisibility(0);
        }
        AppMethodBeat.o(72957);
    }

    private void hhS() {
        AppMethodBeat.i(72958);
        if (this.pZM) {
            this.qdL.setOnClickListener(this.kuO);
            Bitmap bitmap = this.qdH;
            if (this.AKU != null) {
                this.qdH = f.Y(this.AKU);
                Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.qdH = null;
                Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.qdL.setImageBitmap(this.qdH);
            this.qdO.add(0, bitmap);
            recycleBmpList();
            this.kuM.setVisibility(8);
            this.qdK.setVisibility(0);
            this.qdM.setText(f.bpx(this.AII));
        } else {
            this.kuL.setOnClickListener(this.kuO);
            this.kuL.setImageBitmap(this.AKT);
            if (this.AKT != null) {
                Log.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                Log.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.kuM.setVisibility(0);
            this.qdK.setVisibility(8);
        }
        this.kuK.update();
        AppMethodBeat.o(72958);
    }

    private void recycleBmpList() {
        AppMethodBeat.i(72959);
        if (this.qdO.size() >= 2) {
            for (int size = this.qdO.size() - 1; size > 1; size--) {
                f.Z(this.qdO.remove(size));
            }
        }
        AppMethodBeat.o(72959);
    }

    public final void dismiss() {
        AppMethodBeat.i(72960);
        if (this.kuK != null && this.kuK.isShowing()) {
            this.kuK.dismiss();
        }
        AppMethodBeat.o(72960);
    }
}
