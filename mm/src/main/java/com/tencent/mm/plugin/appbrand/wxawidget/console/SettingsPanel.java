package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.picker.c;
import java.util.ArrayList;

public class SettingsPanel extends FrameLayout {
    private Button oGd;
    private Button oGe;
    private View.OnClickListener oGf;
    private Runnable oGg;

    static /* synthetic */ void a(SettingsPanel settingsPanel, int i2) {
        AppMethodBeat.i(121688);
        settingsPanel.AJ(i2);
        AppMethodBeat.o(121688);
    }

    static /* synthetic */ void b(SettingsPanel settingsPanel, int i2) {
        AppMethodBeat.i(121689);
        settingsPanel.AK(i2);
        AppMethodBeat.o(121689);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121683);
        init();
        AppMethodBeat.o(121683);
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121684);
        init();
        AppMethodBeat.o(121684);
    }

    private void init() {
        AppMethodBeat.i(121685);
        LayoutInflater.from(getContext()).inflate(R.layout.br5, (ViewGroup) this, true);
        findViewById(R.id.h5i).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(121675);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().restart();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(121674);
                        Toast.makeText(SettingsPanel.this.getContext(), (int) R.string.j6a, 1).show();
                        if (SettingsPanel.this.oGg != null) {
                            SettingsPanel.this.oGg.run();
                        }
                        AppMethodBeat.o(121674);
                    }
                }, 2000);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121675);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.c3k);
        mMSwitchBtn.setCheck(((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXO());
        mMSwitchBtn.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121676);
                ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().fu(z);
                AppMethodBeat.o(121676);
            }
        });
        this.oGd = (Button) findViewById(R.id.bv1);
        AJ(com.tencent.mm.plugin.appbrand.dynamic.widget.b.bCu());
        this.oGd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(121678);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                arrayList.add("MHADrawableView");
                arrayList.add("MTextureView");
                arrayList.add("MSurfaceView");
                arrayList.add("MCanvasView");
                arrayList.add("MDrawableView");
                final c cVar = new c(SettingsPanel.this.getContext(), arrayList);
                cVar.app(((Integer) SettingsPanel.this.oGd.getTag()).intValue());
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(121677);
                        cVar.hide();
                        if (z) {
                            SettingsPanel.this.oGd.setText((CharSequence) obj);
                        }
                        SettingsPanel.a(SettingsPanel.this, cVar.hci());
                        AppMethodBeat.o(121677);
                    }
                };
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121678);
            }
        });
        this.oGe = (Button) findViewById(R.id.e5c);
        AK(h.ayU());
        this.oGe.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(121680);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ArrayList arrayList = new ArrayList();
                arrayList.add("Normal");
                arrayList.add("Minimal-json");
                final c cVar = new c(SettingsPanel.this.getContext(), arrayList);
                cVar.app(((Integer) SettingsPanel.this.oGe.getTag()).intValue());
                cVar.QTc = new c.b() {
                    /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.picker.c.b
                    public final void onResult(boolean z, Object obj, Object obj2) {
                        AppMethodBeat.i(121679);
                        cVar.hide();
                        if (z) {
                            SettingsPanel.this.oGe.setText((CharSequence) obj);
                        }
                        SettingsPanel.b(SettingsPanel.this, cVar.hci());
                        AppMethodBeat.o(121679);
                    }
                };
                cVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121680);
            }
        });
        findViewById(R.id.b49).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(121681);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SettingsPanel.this.oGf != null) {
                    SettingsPanel.this.oGf.onClick(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/SettingsPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121681);
            }
        });
        if (((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXP()) {
            findViewById(R.id.c3l).setVisibility(0);
            findViewById(R.id.bv2).setVisibility(0);
            findViewById(R.id.e5d).setVisibility(0);
        }
        AppMethodBeat.o(121685);
    }

    public void setOnCloseDebuggerClickListener(View.OnClickListener onClickListener) {
        this.oGf = onClickListener;
    }

    public void setOnResetDebuggerRunnable(Runnable runnable) {
        this.oGg = runnable;
    }

    private void AJ(int i2) {
        AppMethodBeat.i(121686);
        this.oGd.setTag(Integer.valueOf(i2));
        switch (i2) {
            case 1:
                this.oGd.setText("MTextureView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(1);
                AppMethodBeat.o(121686);
                return;
            case 2:
                this.oGd.setText("MSurfaceView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(2);
                AppMethodBeat.o(121686);
                return;
            case 3:
                this.oGd.setText("MCanvasView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(3);
                AppMethodBeat.o(121686);
                return;
            case 4:
                this.oGd.setText("MDrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(4);
                AppMethodBeat.o(121686);
                return;
            default:
                this.oGd.setText("MHADrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.wt(0);
                AppMethodBeat.o(121686);
                return;
        }
    }

    private void AK(int i2) {
        String str;
        int i3;
        AppMethodBeat.i(121687);
        this.oGe.setTag(Integer.valueOf(i2));
        switch (i2) {
            case 1:
                str = "Minimal-json";
                i3 = 1;
                break;
            default:
                str = "Normal";
                i3 = 0;
                break;
        }
        this.oGe.setText(str);
        h.qa(i3);
        com.tencent.mm.ipcinvoker.h.a(SupportProcessIPCService.dkO, new IPCInteger(i3), a.class, null);
        AppMethodBeat.o(121687);
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCInteger iPCInteger, d<IPCVoid> dVar) {
            AppMethodBeat.i(121682);
            h.qa(iPCInteger.value);
            AppMethodBeat.o(121682);
        }
    }
}
