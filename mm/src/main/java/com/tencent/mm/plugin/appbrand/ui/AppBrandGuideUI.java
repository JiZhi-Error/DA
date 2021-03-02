package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI extends MMActivity implements f {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static final class a implements Application.ActivityLifecycleCallbacks, f {
        public boolean nTE = false;
        String nTF;

        public static Application bWY() {
            AppMethodBeat.i(48614);
            Application application = (Application) MMApplicationContext.getContext().getApplicationContext();
            AppMethodBeat.o(48614);
            return application;
        }

        public final void afr(String str) {
            this.nTE = true;
            this.nTF = str;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppBrandGuideUI) {
                this.nTE = false;
            }
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            boolean z;
            AppMethodBeat.i(48615);
            if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
                this.nTE = false;
            }
            if (g.aAc() && this.nTE) {
                ActivityManager.RunningTaskInfo currentTaskInfo = Util.getCurrentTaskInfo(activity, activity.getTaskId());
                if (currentTaskInfo == null || currentTaskInfo.baseActivity == null) {
                    z = false;
                } else if (currentTaskInfo.baseActivity.getClassName().endsWith(".LauncherUI") || !currentTaskInfo.baseActivity.getClassName().contains(".AppBrandUI")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.nTE = false;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(activity, AppBrandGuideUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$AppBrandGuideController", "onActivityResumed", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            }
            AppMethodBeat.o(48615);
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
        public final void bJ(String str, int i2) {
            this.nTE = false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(48616);
        setTheme(R.style.q6);
        super.onCreate(bundle);
        ao.e(getWindow());
        a buB = n.buB();
        if (buB == null) {
            super.finish();
            AppMethodBeat.o(48616);
            return;
        }
        AppBrandStickyBannerLogic.b.d(this);
        d.a aVar = new d.a(this);
        aVar.aoO(R.string.ko);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.bxt);
        TextView textView = new TextView(this);
        textView.setText(R.string.m3);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this, 16);
        aVar.hs(linearLayout);
        aVar.a(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(48610);
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(48610);
            }
        });
        aVar.aoW(R.string.b5x);
        aVar.d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48611);
                o.a(o.a.GUIDE_CLOSE, "");
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(48611);
            }
        });
        aVar.aoV(R.string.m2);
        aVar.a(false, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48612);
                AppBrandGuideUI appBrandGuideUI = AppBrandGuideUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(AppBrandGuideUI.this, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
                com.tencent.mm.hellhoundlib.a.a.a(appBrandGuideUI, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                appBrandGuideUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(appBrandGuideUI, "com/tencent/mm/plugin/appbrand/ui/AppBrandGuideUI$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                o.a(o.a.TO_APP_LAUNCHER, "");
                AppBrandGuideUI.this.finish();
                AppMethodBeat.o(48612);
            }
        });
        aVar.Dk(false);
        aVar.Dl(true);
        d hbn = aVar.hbn();
        hbn.setOnKeyListener(new DialogInterface.OnKeyListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.AnonymousClass4 */

            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(48613);
                if (4 == i2) {
                    if (1 == keyEvent.getAction()) {
                        o.a(o.a.GUIDE_CLOSE_BY_BACK, "");
                        AppBrandGuideUI.this.finish();
                    }
                    AppMethodBeat.o(48613);
                    return true;
                }
                AppMethodBeat.o(48613);
                return false;
            }
        });
        hbn.show();
        o.a(o.a.GUIDE_EXPOSE, buB.nTF);
        buB.nTE = false;
        buB.nTF = null;
        AppMethodBeat.o(48616);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48617);
        super.onDestroy();
        AppBrandStickyBannerLogic.b.c(this);
        AppMethodBeat.o(48617);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
    public final void bJ(String str, int i2) {
        AppMethodBeat.i(48618);
        finish();
        AppMethodBeat.o(48618);
    }
}
