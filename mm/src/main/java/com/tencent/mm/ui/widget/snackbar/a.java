package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.snackbar.SnackContainer;

public final class a {
    SnackContainer QVt;
    b QVu;
    c QVv;
    private final View.OnClickListener QVw = new View.OnClickListener() {
        /* class com.tencent.mm.ui.widget.snackbar.a.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(159701);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (a.this.QVu != null && a.this.QVt.isShowing()) {
                a.this.QVu.bDZ();
            }
            a.this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.widget.snackbar.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(159700);
                    a.this.QVt.hide();
                    AppMethodBeat.o(159700);
                }
            }, 100);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/snackbar/SnackBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159701);
        }
    };
    Handler mHandler = new Handler();
    View mParentView;

    public interface b {
        void bDZ();
    }

    public interface c {
        void bDY();

        void onHide();

        void onShow();
    }

    public a(Activity activity, int i2) {
        AppMethodBeat.i(159708);
        View findViewById = activity.findViewById(16908290);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.btp, (ViewGroup) findViewById);
        a((ViewGroup) findViewById, layoutInflater.inflate(R.layout.btq, (ViewGroup) findViewById, false), i2, activity);
        AppMethodBeat.o(159708);
    }

    public a(Context context, View view, int i2) {
        View view2;
        AppMethodBeat.i(159709);
        if (view != null || !(context instanceof Activity)) {
            view2 = view;
        } else {
            view2 = ((Activity) context).findViewById(16908290);
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(R.layout.btp, (ViewGroup) view2);
        a((ViewGroup) view2, layoutInflater.inflate(R.layout.btq, (ViewGroup) view2, false), i2, context);
        AppMethodBeat.o(159709);
    }

    private void a(ViewGroup viewGroup, View view, int i2, Context context) {
        AppMethodBeat.i(159710);
        if (viewGroup == null) {
            AppMethodBeat.o(159710);
            return;
        }
        this.QVt = (SnackContainer) viewGroup.findViewById(R.id.hts);
        if (this.QVt == null) {
            this.QVt = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i2 == 36) {
            this.QVt.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.widget.snackbar.a.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(159703);
                    if (b.bJw() && a.this.QVt.isShowing()) {
                        b.Dt(false);
                        a.this.mHandler.postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.widget.snackbar.a.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(159702);
                                a.this.QVt.hide();
                                AppMethodBeat.o(159702);
                            }
                        }, 100);
                    }
                    AppMethodBeat.o(159703);
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(R.id.htr)).setOnClickListener(this.QVw);
        boolean aA = au.aA(context);
        int aD = au.aD(context);
        as.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", Boolean.valueOf(aA), Integer.valueOf(aD));
        boolean bu = bu((Activity) context);
        as.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(bu));
        if (bu && aA) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.htq);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            marginLayoutParams.bottomMargin = aD;
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(159710);
    }

    private static boolean bu(Activity activity) {
        AppMethodBeat.i(159711);
        if (Build.VERSION.SDK_INT >= 19) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                AppMethodBeat.o(159711);
                return true;
            }
        }
        AppMethodBeat.o(159711);
        return false;
    }

    /* renamed from: com.tencent.mm.ui.widget.snackbar.a$a  reason: collision with other inner class name */
    public static class C2146a {
        private int QD = -1;
        private a QVA;
        String QVo;
        private int QVp = 0;
        private Parcelable QVq;
        private short QVr = 3500;
        private Context mContext;
        String mMessage;
        private int mbM = 0;

        public C2146a(Activity activity) {
            AppMethodBeat.i(159704);
            this.mContext = activity.getApplicationContext();
            this.QVA = new a(activity, this.mbM);
            AppMethodBeat.o(159704);
        }

        public C2146a(Context context, View view) {
            AppMethodBeat.i(159705);
            this.mContext = context;
            this.QVA = new a(context, view, this.mbM);
            AppMethodBeat.o(159705);
        }

        public final C2146a a(Short sh) {
            AppMethodBeat.i(159706);
            this.QVr = sh.shortValue();
            AppMethodBeat.o(159706);
            return this;
        }

        public final C2146a a(b bVar) {
            this.QVA.QVu = bVar;
            return this;
        }

        public final C2146a a(c cVar) {
            this.QVA.QVv = cVar;
            return this;
        }

        public final a hcA() {
            int color;
            AppMethodBeat.i(159707);
            String str = this.mMessage;
            String upperCase = this.QVo != null ? this.QVo.toUpperCase() : null;
            int i2 = this.QVp;
            Parcelable parcelable = this.QVq;
            short s = this.QVr;
            if (this.QD != -1) {
                color = this.QD;
            } else {
                color = this.mContext.getResources().getColor(R.color.afp);
            }
            Snack snack = new Snack(str, upperCase, i2, parcelable, s, color);
            a aVar = this.QVA;
            if (aVar.QVt != null) {
                SnackContainer snackContainer = aVar.QVt;
                View view = aVar.mParentView;
                c cVar = aVar.QVv;
                if (!(view.getParent() == null || view.getParent() == snackContainer)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                SnackContainer.a aVar2 = new SnackContainer.a(snack, view, cVar, (byte) 0);
                snackContainer.QVC.offer(aVar2);
                if (snackContainer.QVC.size() == 1) {
                    snackContainer.a(aVar2);
                }
            }
            a aVar3 = this.QVA;
            AppMethodBeat.o(159707);
            return aVar3;
        }
    }
}
