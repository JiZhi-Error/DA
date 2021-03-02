package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.sdk.platformtools.Log;

public class ControlBoardPanel extends FrameLayout {
    ConsolePanel lpy;
    a oFR;
    View oFS;
    SettingsPanel oFT;
    View oFU;
    View oFV;
    View oFW;
    View oFX;
    WindowManager oFY;
    WindowManager.LayoutParams oFZ;
    boolean oGa;

    public interface a {
        void a(ControlBoardPanel controlBoardPanel, boolean z);
    }

    public ControlBoardPanel(Context context) {
        super(context);
        AppMethodBeat.i(121649);
        init();
        AppMethodBeat.o(121649);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121650);
        init();
        AppMethodBeat.o(121650);
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121651);
        init();
        AppMethodBeat.o(121651);
    }

    private void init() {
        AppMethodBeat.i(121652);
        Context context = getContext();
        this.oFY = (WindowManager) context.getSystemService("window");
        LayoutInflater.from(context).inflate(R.layout.yc, (ViewGroup) this, true);
        this.oFS = findViewById(R.id.bfh);
        this.lpy = (ConsolePanel) findViewById(R.id.b_v);
        this.oFT = (SettingsPanel) findViewById(R.id.hn2);
        this.oFU = findViewById(R.id.ga4);
        this.oFV = findViewById(R.id.b_t);
        this.oFW = findViewById(R.id.hmc);
        this.oFX = findViewById(R.id.ga3);
        if (!((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXP()) {
            this.oFX.setVisibility(8);
        }
        this.oFV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(121643);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ControlBoardPanel.this.lpy.getVisibility() == 0) {
                    ControlBoardPanel.this.oFS.setVisibility(8);
                    ControlBoardPanel.this.lpy.setVisibility(8);
                    ControlBoardPanel.this.oFV.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                } else {
                    ControlBoardPanel.this.oFS.setVisibility(0);
                    ControlBoardPanel.this.lpy.setVisibility(0);
                    ControlBoardPanel.this.oFT.setVisibility(8);
                    ControlBoardPanel.this.oFU.setVisibility(8);
                    ControlBoardPanel.this.oFV.setSelected(true);
                    ControlBoardPanel.this.oFW.setSelected(false);
                    ControlBoardPanel.this.oFX.setSelected(false);
                    ControlBoardPanel.b(ControlBoardPanel.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121643);
            }
        });
        this.oFW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(121644);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ControlBoardPanel.this.oFT.getVisibility() == 0) {
                    ControlBoardPanel.this.oFS.setVisibility(8);
                    ControlBoardPanel.this.oFT.setVisibility(8);
                    ControlBoardPanel.this.oFW.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                } else {
                    ControlBoardPanel.this.oFS.setVisibility(0);
                    ControlBoardPanel.this.lpy.setVisibility(8);
                    ControlBoardPanel.this.oFT.setVisibility(0);
                    ControlBoardPanel.this.oFU.setVisibility(8);
                    ControlBoardPanel.this.oFV.setSelected(false);
                    ControlBoardPanel.this.oFW.setSelected(true);
                    ControlBoardPanel.this.oFX.setSelected(false);
                    ControlBoardPanel.b(ControlBoardPanel.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121644);
            }
        });
        this.oFX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(121645);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ControlBoardPanel.this.oFU.getVisibility() == 0) {
                    ControlBoardPanel.this.oFS.setVisibility(8);
                    ControlBoardPanel.this.oFU.setVisibility(8);
                    ControlBoardPanel.this.oFX.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                } else {
                    ControlBoardPanel.this.oFS.setVisibility(0);
                    ControlBoardPanel.this.lpy.setVisibility(8);
                    ControlBoardPanel.this.oFT.setVisibility(8);
                    ControlBoardPanel.this.oFU.setVisibility(0);
                    ControlBoardPanel.this.oFV.setSelected(false);
                    ControlBoardPanel.this.oFW.setSelected(false);
                    ControlBoardPanel.this.oFX.setSelected(true);
                    ControlBoardPanel.b(ControlBoardPanel.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121645);
            }
        });
        setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass4 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(121646);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                Log.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", Integer.valueOf(i2), keyEvent);
                if (i2 == 4) {
                    ControlBoardPanel.this.oFS.setVisibility(8);
                    ControlBoardPanel.this.oFU.setVisibility(8);
                    ControlBoardPanel.this.oFU.setVisibility(8);
                    ControlBoardPanel.this.oFX.setSelected(false);
                    ControlBoardPanel.this.oFV.setSelected(false);
                    ControlBoardPanel.this.oFW.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$4", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(121646);
                return false;
            }
        });
        this.oFT.setOnCloseDebuggerClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(121647);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ControlBoardPanel controlBoardPanel = ControlBoardPanel.this;
                if (controlBoardPanel.oGa) {
                    controlBoardPanel.oGa = false;
                    controlBoardPanel.oFY.removeViewImmediate(controlBoardPanel);
                    d.b(controlBoardPanel.lpy);
                    if (controlBoardPanel.oFR != null) {
                        controlBoardPanel.oFR.a(controlBoardPanel, false);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/ControlBoardPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121647);
            }
        });
        this.oFT.setOnResetDebuggerRunnable(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(121648);
                ControlBoardPanel.this.reset();
                AppMethodBeat.o(121648);
            }
        });
        AppMethodBeat.o(121652);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(121653);
        Log.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", Integer.valueOf(i2), keyEvent);
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(121653);
        return onKeyUp;
    }

    public final void reset() {
        AppMethodBeat.i(121654);
        d.b(this.lpy);
        d.a(this.lpy);
        AppMethodBeat.o(121654);
    }

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(121655);
        controlBoardPanel.oFZ.width = -2;
        controlBoardPanel.oFZ.height = -2;
        controlBoardPanel.oFZ.flags = 520;
        controlBoardPanel.oFY.updateViewLayout(controlBoardPanel, controlBoardPanel.oFZ);
        AppMethodBeat.o(121655);
    }

    static /* synthetic */ void b(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(121656);
        controlBoardPanel.oFZ.width = -1;
        controlBoardPanel.oFZ.height = -1;
        controlBoardPanel.oFZ.flags = 544;
        controlBoardPanel.oFY.updateViewLayout(controlBoardPanel, controlBoardPanel.oFZ);
        AppMethodBeat.o(121656);
    }
}
