package com.tencent.mm.ui.applet;

import android.content.Context;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ci.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;

public final class d {
    private static int ONJ = 0;

    static /* synthetic */ int gKo() {
        int i2 = ONJ;
        ONJ = i2 - 1;
        return i2;
    }

    public static void jZ(Context context) {
        AppMethodBeat.i(33846);
        if (ONJ > 0) {
            AppMethodBeat.o(33846);
            return;
        }
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.layout.c4g, (ViewGroup) null));
        aVar.ONr.addView(aVar.ONq, aVar.ONs);
        ONJ++;
        AppMethodBeat.o(33846);
    }

    public static final class a {
        boolean ONK = false;
        d.b ONL = new d.b() {
            /* class com.tencent.mm.ui.applet.d.a.AnonymousClass1 */

            @Override // com.tencent.mm.ci.d.b
            public final void gGo() {
                AppMethodBeat.i(33838);
                a.this.ka(a.this.context);
                Toast.makeText(a.this.context, "trace file has saved ", 0).show();
                AppMethodBeat.o(33838);
            }
        };
        d.a ONM;
        MMHandler ONN = new MMHandler() {
            /* class com.tencent.mm.ui.applet.d.a.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(33842);
                if (a.this.pwO.getVisibility() != 0) {
                    a.this.vDO = 0;
                    AppMethodBeat.o(33842);
                    return;
                }
                a.this.vDO++;
                a.this.gKp();
                super.handleMessage(message);
                AppMethodBeat.o(33842);
            }
        };
        FrameLayout ONq;
        WindowManager ONr;
        WindowManager.LayoutParams ONs;
        private ViewGroup.LayoutParams ONt;
        Context context;
        ImageView dPk;
        ProgressBar dPm;
        View mView;
        TextView pwO;
        int vDO = 0;

        public a(Context context2, View view) {
            AppMethodBeat.i(33843);
            if (this.ONq == null || this.ONr == null) {
                com.tencent.mm.ci.d.gGm().Owi = new WeakReference<>(this.ONL);
                this.pwO = (TextView) view.findViewById(R.id.imo);
                this.dPk = (ImageView) view.findViewById(R.id.agf);
                ((ImageView) view.findViewById(R.id.bmn)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.applet.d.a.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(33839);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (a.this.ONK && a.this.dPm.getVisibility() != 0) {
                            com.tencent.mm.ci.d.gGm().b(a.this.ONM);
                        }
                        a aVar = a.this;
                        try {
                            if (aVar.ONr != null) {
                                if (aVar.ONq != null) {
                                    aVar.ONr.removeView(aVar.ONq);
                                }
                                aVar.ONr = null;
                            }
                            if (aVar.ONq != null) {
                                aVar.ONq.removeAllViews();
                                aVar.ONq = null;
                            }
                            aVar.mView = null;
                        } catch (Exception e2) {
                        }
                        d.gKo();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33839);
                    }
                });
                this.dPm = (ProgressBar) view.findViewById(R.id.fsr);
                this.dPm.setVisibility(8);
                this.context = context2;
                this.ONs = new WindowManager.LayoutParams();
                this.ONs.height = -2;
                this.ONs.width = -2;
                this.ONr = (WindowManager) context2.getSystemService("window");
                this.ONs.x = 0;
                this.ONs.y = 0;
                this.ONs.flags = 40;
                this.ONs.type = 2002;
                this.mView = view;
                this.pwO.setVisibility(8);
                this.ONs.gravity = 51;
                this.ONs.format = 1;
                this.ONq = new FrameLayout(context2);
                this.ONq.setPadding(4, 4, 4, 4);
                this.ONt = new ViewGroup.LayoutParams(-2, -2);
                this.ONq.addView(this.mView, this.ONt);
                final DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                this.ONq.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.applet.d.a.AnonymousClass3 */
                    int ONv;
                    int ONw;
                    int ONx = ((displayMetrics.widthPixels - a.this.ONs.width) - 1);
                    int ONy = ((displayMetrics.heightPixels - a.this.ONs.height) - 1);
                    long ONz;

                    {
                        AppMethodBeat.i(33840);
                        AppMethodBeat.o(33840);
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean z;
                        AppMethodBeat.i(33841);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.ONv = ((int) motionEvent.getRawX()) - a.this.ONs.x;
                                this.ONw = ((int) motionEvent.getRawY()) - a.this.ONs.y;
                                this.ONz = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.ONz < 300) {
                                    a aVar = a.this;
                                    aVar.ONN.removeMessages(0);
                                    aVar.vDO = 0;
                                    if (!aVar.ONK) {
                                        aVar.dPk.setVisibility(0);
                                        aVar.dPk.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.drawable.bp_));
                                        if (!aVar.ONK) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        aVar.ONK = z;
                                        aVar.ONM = new d.a(null, 6, 8, 0);
                                        com.tencent.mm.ci.d.gGm().c(aVar.ONM);
                                        aVar.gKp();
                                        break;
                                    } else {
                                        aVar.dPm.setVisibility(0);
                                        aVar.dPk.setVisibility(4);
                                        if (!com.tencent.mm.ci.d.gGm().b(aVar.ONM)) {
                                            aVar.ka(aVar.context);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2:
                                this.ONx = (displayMetrics.widthPixels - a.this.ONs.width) - 1;
                                this.ONy = (displayMetrics.heightPixels - a.this.ONs.height) - 1;
                                a.this.ONs.x = ((int) motionEvent.getRawX()) - this.ONv;
                                a.this.ONs.y = ((int) motionEvent.getRawY()) - this.ONw;
                                a.this.ONs.x = a.this.ONs.x < 0 ? 0 : a.this.ONs.x;
                                a.this.ONs.x = a.this.ONs.x > this.ONx ? this.ONx : a.this.ONs.x;
                                a.this.ONs.y = a.this.ONs.y < 0 ? 0 : a.this.ONs.y;
                                a.this.ONs.y = a.this.ONs.y > this.ONy ? this.ONy : a.this.ONs.y;
                                a.this.ONr.updateViewLayout(a.this.ONq, a.this.ONs);
                                break;
                        }
                        AppMethodBeat.o(33841);
                        return false;
                    }
                });
                AppMethodBeat.o(33843);
                return;
            }
            AppMethodBeat.o(33843);
        }

        /* access modifiers changed from: package-private */
        public final void ka(Context context2) {
            boolean z = false;
            AppMethodBeat.i(33844);
            this.dPk.setVisibility(0);
            this.dPm.setVisibility(4);
            if (!this.ONK) {
                z = true;
            }
            this.ONK = z;
            this.dPk.setBackgroundDrawable(context2.getResources().getDrawable(R.drawable.bp9));
            this.pwO.setVisibility(8);
            AppMethodBeat.o(33844);
        }

        /* access modifiers changed from: package-private */
        public final void gKp() {
            AppMethodBeat.i(33845);
            this.pwO.setText(new StringBuilder().append(this.vDO).toString());
            this.ONN.sendEmptyMessageDelayed(0, 1000);
            AppMethodBeat.o(33845);
        }
    }
}
