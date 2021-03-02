package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;

public class GameTabWidget extends LinearLayout {
    public static int lNi = 0;
    private Activity mActivity;
    private a xYV;

    public GameTabWidget(Context context) {
        super(context);
        AppMethodBeat.i(42473);
        bh(context);
        AppMethodBeat.o(42473);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42474);
        bh(context);
        AppMethodBeat.o(42474);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(42475);
        bh(context);
        AppMethodBeat.o(42475);
    }

    private void bh(Context context) {
        AppMethodBeat.i(42476);
        this.mActivity = (Activity) context;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.color.st);
        setOrientation(0);
        AppMethodBeat.o(42476);
    }

    public void setAdapter(a aVar) {
        AppMethodBeat.i(42477);
        this.xYV = aVar;
        aVar.registerDataSetObserver(new DataSetObserver() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameTabWidget.AnonymousClass1 */

            public final void onInvalidated() {
                AppMethodBeat.i(42469);
                GameTabWidget.a(GameTabWidget.this);
                AppMethodBeat.o(42469);
            }

            public final void onChanged() {
                AppMethodBeat.i(42470);
                GameTabWidget.a(GameTabWidget.this);
                AppMethodBeat.o(42470);
            }
        });
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(42477);
    }

    public static void a(Activity activity, GameTabData.TabItem tabItem, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        AppMethodBeat.i(42478);
        if (activity == null || tabItem == null) {
            AppMethodBeat.o(42478);
        } else if (c.aR(activity, tabItem.jumpUrl)) {
            AppMethodBeat.o(42478);
        } else {
            String stringExtra = activity.getIntent().getStringExtra("tab_key");
            if (Util.nullAsNil(tabItem.xHB).equals(stringExtra)) {
                AppMethodBeat.o(42478);
                return;
            }
            Log.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", activity.getClass().getSimpleName(), tabItem.xHI, Boolean.valueOf(z));
            Intent intent = new Intent();
            intent.setClassName(activity, tabItem.xHI);
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            } else {
                extras = new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("tab_key", tabItem.xHB);
            GameTabData gameTabData = (GameTabData) extras.getParcelable("tab_data");
            if (gameTabData != null) {
                GameTabData.TabItem tabItem2 = gameTabData.xHy.get(Util.nullAsNil(stringExtra));
                if (tabItem2 != null) {
                    tabItem2.xHJ = true;
                }
                GameTabData.TabItem tabItem3 = gameTabData.xHy.get(tabItem.xHB);
                if (tabItem3 != null) {
                    z5 = tabItem3.xHJ;
                } else {
                    z5 = false;
                }
                bundle.putParcelable("tab_data", gameTabData);
                z4 = z5;
            } else {
                z4 = false;
            }
            if (!z3) {
                f.a(activity, 18, tabItem.dYu, tabItem.xHK, 2, null, activity.getIntent().getIntExtra("game_report_from_scene", 0), com.tencent.mm.plugin.game.d.a.Fh(tabItem.xEl));
            }
            if (!tabItem.xHD) {
                bundle.putString("rawUrl", tabItem.jumpUrl);
                bundle.putBoolean("KRightBtn", true);
                bundle.putBoolean("isWebwx", true);
                bundle.putBoolean("show_bottom", false);
                bundle.putString("title", activity.getString(R.string.dte));
                bundle.putBoolean("forceHideShare", true);
                bundle.putBoolean("disable_swipe_back", true);
                bundle.putBoolean("show_native_web_view", true);
                bundle.putBoolean("disable_progress_bar", true);
                bundle.putBoolean("disable_bounce_scroll", true);
                bundle.putInt("screen_orientation", 1);
                bundle.putString("KPublisherId", "game_center_entrance");
                bundle.putInt("geta8key_scene", 32);
                if (!(gameTabData == null || gameTabData.xHz == null)) {
                    bundle.putString("status_bar_style", gameTabData.xHz.xHA);
                    bundle.putInt("customize_status_bar_color", gameTabData.xHz.color);
                }
                bundle.putBoolean("game_check_float", z3);
                String string = bundle.getString("rawUrl");
                if (!Util.isNullOrNil(string)) {
                    if (z3) {
                        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
                        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
                        if (booleanExtra) {
                            ((e) g.af(e.class)).dSJ();
                            o dVm = r.dVm();
                            bundle.putString("rawUrl", m.a(string, dVm, null, true));
                            if (dVm != null) {
                                dVm.dVl();
                                if (dVm.xFw.crp) {
                                    bundle.putString("game_transparent_float_url", dVm.xFw.url);
                                }
                                bundle.putInt("game_sourceScene", intExtra);
                            }
                        }
                    } else {
                        bundle.remove("game_transparent_float_url");
                        bundle.remove("game_sourceScene");
                    }
                }
            }
            intent.putExtras(bundle);
            a(activity, intent, z, z2, z4, tabItem.xHD);
            AppMethodBeat.o(42478);
        }
    }

    public static void a(Activity activity, Intent intent, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(42479);
        Object[] objArr = new Object[5];
        objArr[0] = intent.getComponent() == null ? "" : intent.getComponent().getClassName();
        objArr[1] = Boolean.valueOf(z3);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z4);
        Log.i("MicroMsg.GameTabWidget", "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b", objArr);
        Log.i("MicroMsg.GameTabWidget", (z3 || z4) ? "straight to jump" : "jump to bridge");
        if (!z3 && z4) {
            ToolsProcessIPCService.a(a.class, (d) null);
        }
        if (z3 || z4) {
            lNi = 0;
            intent.addFlags(131072);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else {
            Intent intent2 = new Intent(activity, GameTabBridgeUI.class);
            intent2.putExtras(intent.getExtras());
            intent2.putExtra("next_tab_component", intent.getComponent());
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl2.axQ(), "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/game/ui/tab/GameTabWidget", "turnPage", "(Landroid/app/Activity;Landroid/content/Intent;ZZZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        if (z2 && !activity.isDestroyed() && !activity.isFinishing()) {
            activity.finish();
        }
        if (z) {
            activity.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
            AppMethodBeat.o(42479);
            return;
        }
        activity.overridePendingTransition(R.anim.cd, R.anim.cd);
        AppMethodBeat.o(42479);
    }

    public static class a implements b<Bundle, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(42472);
            Bundle bundle2 = bundle;
            if (dVar != null) {
                dVar.bn(bundle2);
            }
            AppMethodBeat.o(42472);
        }
    }

    static /* synthetic */ void a(GameTabWidget gameTabWidget) {
        AppMethodBeat.i(42480);
        int count = gameTabWidget.xYV.getCount();
        if (count != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cb.a.jn(gameTabWidget.mActivity) / count, -1);
            for (int i2 = 0; i2 < count; i2++) {
                View view = gameTabWidget.xYV.getView(i2, null, gameTabWidget);
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.tab.GameTabWidget.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(42471);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/tab/GameTabWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            try {
                                GameTabWidget.a(GameTabWidget.this.mActivity, (GameTabData.TabItem) view.getTag(), false, false, false);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.GameTabWidget", "selectTab err:%s", e2.getMessage());
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/tab/GameTabWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(42471);
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    gameTabWidget.addView(view);
                }
            }
        }
        AppMethodBeat.o(42480);
    }
}
