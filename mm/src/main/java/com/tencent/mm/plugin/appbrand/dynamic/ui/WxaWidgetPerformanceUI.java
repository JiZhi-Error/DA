package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn lpF;
    MMSwitchBtn lpG;
    MMSwitchBtn lpH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(121510);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(121498);
                WxaWidgetPerformanceUI.this.finish();
                AppMethodBeat.o(121498);
                return false;
            }
        });
        setMMTitle(R.string.j69);
        final TextView textView = (TextView) findViewById(R.id.fmo);
        final View findViewById = findViewById(R.id.gyi);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(121499);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
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
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121499);
            }
        });
        findViewById(R.id.b3g).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(121500);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(SupportProcessIPCService.dkO, null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.WL("jsapi_draw_canvas").toString());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/dynamic/ui/WxaWidgetPerformanceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(121500);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.id.g49);
        boolean bzy = com.tencent.mm.plugin.appbrand.collector.c.bzy();
        mMSwitchBtn.setCheck(bzy);
        mMSwitchBtn.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121501);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.gT(z);
                findViewById.setEnabled(z);
                WxaWidgetPerformanceUI.this.lpF.setEnabled(z);
                WxaWidgetPerformanceUI.this.lpG.setEnabled(z);
                WxaWidgetPerformanceUI.this.lpH.setEnabled(z);
                AppMethodBeat.o(121501);
            }
        });
        findViewById.setEnabled(bzy);
        this.lpF = (MMSwitchBtn) findViewById(R.id.b6j);
        this.lpF.setEnabled(bzy);
        this.lpF.setCheck(com.tencent.mm.plugin.appbrand.collector.c.WO("jsapi_draw_canvas"));
        this.lpF.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121502);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.WM("jsapi_draw_canvas");
                    AppMethodBeat.o(121502);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.WN("jsapi_draw_canvas");
                AppMethodBeat.o(121502);
            }
        });
        this.lpG = (MMSwitchBtn) findViewById(R.id.b7z);
        this.lpG.setEnabled(bzy);
        this.lpG.setCheck(com.tencent.mm.plugin.appbrand.collector.c.WO("widget_launch"));
        this.lpG.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121503);
                h.a(SupportProcessIPCService.dkO, new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.WM("widget_launch");
                    AppMethodBeat.o(121503);
                    return;
                }
                com.tencent.mm.plugin.appbrand.collector.c.WN("widget_launch");
                AppMethodBeat.o(121503);
            }
        });
        this.lpH = (MMSwitchBtn) findViewById(R.id.b7y);
        this.lpH.setEnabled(bzy);
        this.lpH.setCheck(f.bzz());
        this.lpH.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetPerformanceUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(121504);
                f.gU(z);
                AppMethodBeat.o(121504);
            }
        });
        AppMethodBeat.o(121510);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(121511);
        if (isFinishing() || activityHasDestroyed()) {
            AppMethodBeat.o(121511);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        overridePendingTransition(resourceId, resourceId2);
        AppMethodBeat.o(121511);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cd3;
    }

    static class d implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121508);
            com.tencent.mm.plugin.appbrand.collector.c.gT(iPCBoolean.value);
            AppMethodBeat.o(121508);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121506);
            if (iPCBoolean.value) {
                com.tencent.mm.plugin.appbrand.collector.c.WM("jsapi_draw_canvas");
                AppMethodBeat.o(121506);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.WN("jsapi_draw_canvas");
            AppMethodBeat.o(121506);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121507);
            if (iPCBoolean.value) {
                com.tencent.mm.plugin.appbrand.collector.c.WM("widget_launch");
                AppMethodBeat.o(121507);
                return;
            }
            com.tencent.mm.plugin.appbrand.collector.c.WN("widget_launch");
            AppMethodBeat.o(121507);
        }
    }

    static class e implements k<IPCString, IPCString> {
        private e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            AppMethodBeat.i(121509);
            IPCString iPCString2 = new IPCString(com.tencent.mm.plugin.appbrand.collector.c.WL(iPCString.value).toString());
            AppMethodBeat.o(121509);
            return iPCString2;
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(121505);
            com.tencent.mm.plugin.appbrand.collector.c.clear();
            AppMethodBeat.o(121505);
        }
    }
}
