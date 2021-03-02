package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public final class c {
    public static void jY(Context context) {
        AppMethodBeat.i(33836);
        new a(context, LayoutInflater.from(context).inflate(R.layout.c4g, (ViewGroup) null)).show();
        AppMethodBeat.o(33836);
    }

    public static final class a {
        FrameLayout ONq;
        WindowManager ONr;
        WindowManager.LayoutParams ONs;
        private ViewGroup.LayoutParams ONt;
        private ImageView dPk;
        private View mView;

        public a(Context context, View view) {
            AppMethodBeat.i(33833);
            if (this.ONq == null || this.ONr == null) {
                view.findViewById(R.id.fsr).setVisibility(8);
                this.dPk = (ImageView) view.findViewById(R.id.agf);
                ((ImageView) view.findViewById(R.id.bmn)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.applet.c.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(33830);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a.this.gKn();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(33830);
                    }
                });
                this.ONs = new WindowManager.LayoutParams();
                this.ONs.height = -2;
                this.ONs.width = -2;
                this.ONr = (WindowManager) context.getSystemService("window");
                this.ONs.x = 0;
                this.ONs.y = 0;
                this.ONs.flags = 40;
                this.ONs.type = 2002;
                this.mView = view;
                this.ONs.gravity = 51;
                this.ONs.format = 1;
                this.ONq = new FrameLayout(context);
                this.ONq.setPadding(4, 4, 4, 4);
                this.ONt = new ViewGroup.LayoutParams(-2, -2);
                this.ONq.addView(this.mView, this.ONt);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.ONq.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.applet.c.a.AnonymousClass2 */
                    int ONv;
                    int ONw;
                    int ONx = ((displayMetrics.widthPixels - a.this.ONs.width) - 1);
                    int ONy = ((displayMetrics.heightPixels - a.this.ONs.height) - 1);
                    long ONz;

                    {
                        AppMethodBeat.i(33831);
                        AppMethodBeat.o(33831);
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(33832);
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.ONv = ((int) motionEvent.getRawX()) - a.this.ONs.x;
                                this.ONw = ((int) motionEvent.getRawY()) - a.this.ONs.y;
                                this.ONz = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.ONz < 300) {
                                    com.tencent.mm.ci.b.gGl();
                                    com.tencent.mm.ci.b.bb(false, true);
                                    a.this.gKn();
                                    break;
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
                        AppMethodBeat.o(33832);
                        return false;
                    }
                });
                AppMethodBeat.o(33833);
                return;
            }
            AppMethodBeat.o(33833);
        }

        public final void show() {
            AppMethodBeat.i(33834);
            this.ONr.addView(this.ONq, this.ONs);
            AppMethodBeat.o(33834);
        }

        public final void gKn() {
            AppMethodBeat.i(33835);
            try {
                if (this.ONr != null) {
                    if (this.ONq != null) {
                        this.ONr.removeView(this.ONq);
                    }
                    this.ONr = null;
                }
                if (this.ONq != null) {
                    this.ONq.removeAllViews();
                    this.ONq = null;
                }
                this.mView = null;
                AppMethodBeat.o(33835);
            } catch (Exception e2) {
                AppMethodBeat.o(33835);
            }
        }
    }
}
