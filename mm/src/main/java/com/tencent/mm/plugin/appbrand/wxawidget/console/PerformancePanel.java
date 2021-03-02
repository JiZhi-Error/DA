package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.plugin.appbrand.collector.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class PerformancePanel extends FrameLayout {
    MMSwitchBtn lpF;
    MMSwitchBtn lpG;
    MMSwitchBtn lpH;

    public PerformancePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121670);
        init();
        AppMethodBeat.o(121670);
    }

    public PerformancePanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121671);
        init();
        AppMethodBeat.o(121671);
    }

    private void init() {
        AppMethodBeat.i(121672);
        LayoutInflater.from(getContext()).inflate(R.layout.bhs, (ViewGroup) this, true);
        final TextView textView = (TextView) findViewById(R.id.fmo);
        final View findViewById = findViewById(R.id.gyi);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(121659);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String sb = com.tencent.mm.plugin.appbrand.collector.c.WL("jsapi_draw_canvas").toString();
                StringBuilder sb2 = new StringBuilder();
                if (sb != null && sb.length() > 0) {
                    sb2.append("data size :").append(com.tencent.mm.plugin.appbrand.collector.c.cR("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append("\n").append(sb);
                }
                IPCString iPCString = (IPCString) h.a(SupportProcessIPCService.dkO, new IPCString("widget_launch"), e.class);
                if (iPCString != null) {
                    sb2.append("\n\n").append(iPCString);
                }
                if (f.bzz()) {
                    sb2.append("\n\n").append(f.bzA());
                }
                textView.setText(sb2.toString());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121659);
            }
        });
        findViewById(R.id.b3g).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(121660);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(SupportProcessIPCService.dkO, null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.WL("jsapi_draw_canvas").toString());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/wxawidget/console/PerformancePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121660);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.g49);
        boolean bzy = com.tencent.mm.plugin.appbrand.collector.c.bzy();
        mMSwitchBtn.setCheck(bzy);
        mMSwitchBtn.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121661);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.gT(z);
                findViewById.setEnabled(z);
                PerformancePanel.this.lpF.setEnabled(z);
                PerformancePanel.this.lpG.setEnabled(z);
                PerformancePanel.this.lpH.setEnabled(z);
                AppMethodBeat.o(121661);
            }
        });
        findViewById.setEnabled(bzy);
        this.lpF = (MMSwitchBtn) findViewById(R.id.b6j);
        this.lpF.setEnabled(bzy);
        this.lpF.setCheck(com.tencent.mm.plugin.appbrand.collector.c.WO("jsapi_draw_canvas"));
        this.lpF.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121662);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.WM("jsapi_draw_canvas");
                    AppMethodBeat.o(121662);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.WN("jsapi_draw_canvas");
                AppMethodBeat.o(121662);
            }
        });
        this.lpG = (MMSwitchBtn) findViewById(R.id.b7z);
        this.lpG.setEnabled(bzy);
        this.lpG.setCheck(com.tencent.mm.plugin.appbrand.collector.c.WO("widget_launch"));
        this.lpG.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121663);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.WM("widget_launch");
                    AppMethodBeat.o(121663);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.WN("widget_launch");
                AppMethodBeat.o(121663);
            }
        });
        this.lpH = (MMSwitchBtn) findViewById(R.id.b7y);
        this.lpH.setEnabled(bzy);
        this.lpH.setCheck(f.bzz());
        this.lpH.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.wxawidget.console.PerformancePanel.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121664);
                f.gU(z);
                AppMethodBeat.o(121664);
            }
        });
        AppMethodBeat.o(121672);
    }

    static class d implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121668);
            com.tencent.mm.plugin.appbrand.collector.c.gT(iPCBoolean.value);
            AppMethodBeat.o(121668);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121666);
            if (iPCBoolean.value) {
                com.tencent.mm.plugin.appbrand.collector.c.WM("jsapi_draw_canvas");
                AppMethodBeat.o(121666);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.WN("jsapi_draw_canvas");
            AppMethodBeat.o(121666);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121667);
            if (iPCBoolean.value) {
                com.tencent.mm.plugin.appbrand.collector.c.WM("widget_launch");
                AppMethodBeat.o(121667);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.WN("widget_launch");
            AppMethodBeat.o(121667);
        }
    }

    static class e implements k<IPCString, IPCString> {
        private e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            AppMethodBeat.i(121669);
            IPCString iPCString2 = new IPCString(com.tencent.mm.plugin.appbrand.collector.c.WL(iPCString.value).toString());
            AppMethodBeat.o(121669);
            return iPCString2;
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121665);
            com.tencent.mm.plugin.appbrand.collector.c.clear();
            AppMethodBeat.o(121665);
        }
    }
}
