package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Process;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.x.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.snackbar.a;
import java.util.ArrayList;

public final class c {

    public interface a {
        void d(boolean z, String str, int i2);
    }

    public interface b {
        void cjO();

        void cjP();
    }

    public static String ahb(String str) {
        AppMethodBeat.i(151465);
        String eX = eX(str, q.dr(true));
        AppMethodBeat.o(151465);
        return eX;
    }

    public static String eX(String str, String str2) {
        String substring;
        AppMethodBeat.i(151466);
        if (str == null || str.length() <= 0 || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(151466);
            return null;
        }
        Log.i("MicroMsg.ShortcutUtil", "process name: %s", Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()));
        if (!str.startsWith("shortcut_") || str.length() <= 9 || (substring = str.substring(9)) == null || substring.length() <= 0) {
            AppMethodBeat.o(151466);
            return str;
        }
        String eW = b.eW(new String(b.aha(substring)), str2);
        AppMethodBeat.o(151466);
        return eW;
    }

    public static String eY(String str, String str2) {
        AppMethodBeat.i(151467);
        String messageDigest = g.getMessageDigest((g.getMessageDigest(str.getBytes()) + b.eW(str2, str)).getBytes());
        AppMethodBeat.o(151467);
        return messageDigest;
    }

    public static String aG(String str, boolean z) {
        AppMethodBeat.i(151468);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(151468);
            return null;
        }
        Log.i("MicroMsg.ShortcutUtil", "process name: %s", Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()));
        String eW = b.eW(str, z ? q.getAndroidId() : q.dr(true));
        if (Util.isNullOrNil(eW)) {
            AppMethodBeat.o(151468);
            return null;
        }
        String str2 = "shortcut_" + b.toHexString(eW.getBytes());
        AppMethodBeat.o(151468);
        return str2;
    }

    public static void a(final Context context, final b bVar) {
        AppMethodBeat.i(223692);
        Log.i("MicroMsg.ShortcutUtil", "addShortCut()");
        final boolean z = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("no_more_show_add_short_cut_dialog", false);
        final Pair<Integer, Integer> a2 = a(context, (String) null, z, false, (a) new a() {
            /* class com.tencent.mm.plugin.base.model.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.base.model.c.a
            public final void d(boolean z, String str, int i2) {
                AppMethodBeat.i(151454);
                if (z) {
                    context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).commit();
                }
                AppMethodBeat.o(151454);
            }
        });
        bVar.cjO();
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.base.model.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(151458);
                try {
                    bVar.cjP();
                    c.a(context, ((Integer) a2.first).intValue(), ((Integer) a2.second).intValue(), z, null, false);
                    AppMethodBeat.o(151458);
                } catch (IllegalStateException e2) {
                    Log.w("MicroMsg.ShortcutUtil", e2.toString());
                    AppMethodBeat.o(151458);
                }
            }
        });
        AppMethodBeat.o(223692);
    }

    public static Pair<Integer, Integer> a(final Context context, final String str, boolean z, final boolean z2, final a aVar) {
        int i2;
        AppMethodBeat.i(151469);
        final a.AbstractC2012a eVl = com.tencent.mm.plugin.x.a.a.eVl();
        int eVm = eVl.eVm();
        boolean eVn = eVl.eVn();
        final f.a aVar2 = new f.a(context);
        Resources resources = context.getResources();
        if (eVm == -1) {
            aVar2.boz(resources.getString(R.string.h1e));
            String string = resources.getString(R.string.h1g);
            String string2 = resources.getString(R.string.h1d);
            aVar2.aC(string);
            if (eVn) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.cc, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.e6p);
                ((TextView) linearLayout.findViewById(R.id.ll)).setText(string2);
                textView.setText(R.string.h1b);
                aVar2.hu(linearLayout);
                aVar2.apa(R.string.h1a);
                aVar2.boB(resources.getString(R.string.he));
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass6 */
                    final /* synthetic */ int neO = 2;

                    public final void onClick(View view) {
                        AppMethodBeat.i(151459);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        c.a(context, false, this.neO, str, z2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(151459);
                    }
                });
                aVar2.a(new f.b() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass7 */
                    final /* synthetic */ int neO = 2;

                    @Override // com.tencent.mm.ui.widget.a.f.b
                    public final void D(boolean z, boolean z2) {
                        AppMethodBeat.i(151460);
                        if (z) {
                            eVl.gX(context);
                            if (z2) {
                                h.INSTANCE.a(15783, Integer.valueOf(this.neO), 0, str);
                            }
                        } else {
                            c.a(aVar2, this.neO, str, z2);
                        }
                        aVar.d(z2, str, this.neO);
                        AppMethodBeat.o(151460);
                    }
                });
                i2 = 2;
            } else {
                aVar2.bow(string2);
                aVar2.apa(R.string.h1b);
                aVar2.boB(resources.getString(R.string.he));
                aVar2.a(new f.b() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass8 */
                    final /* synthetic */ int neO = 4;

                    @Override // com.tencent.mm.ui.widget.a.f.b
                    public final void D(boolean z, boolean z2) {
                        AppMethodBeat.i(151461);
                        if (z) {
                            c.a(context, false, this.neO, str, z2);
                        } else {
                            c.a(aVar2, this.neO, str, z2);
                        }
                        aVar.d(z2, str, this.neO);
                        AppMethodBeat.o(151461);
                    }
                });
                i2 = 4;
            }
        } else if (eVm == 1) {
            String string3 = resources.getString(R.string.h1f);
            String string4 = resources.getString(R.string.h1c);
            aVar2.boB(resources.getString(R.string.sz));
            aVar2.aC(string3);
            if (eVn) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.cc, (ViewGroup) null);
                TextView textView2 = (TextView) linearLayout2.findViewById(R.id.e6p);
                ((TextView) linearLayout2.findViewById(R.id.ll)).setText(string4);
                textView2.setText(R.string.h1b);
                aVar2.hu(linearLayout2);
                aVar2.apa(R.string.h1a);
                textView2.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass9 */
                    final /* synthetic */ int neO = 1;

                    public final void onClick(View view) {
                        AppMethodBeat.i(151462);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        c.a(context, false, this.neO, str, z2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(151462);
                    }
                });
                aVar2.a(new f.c() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass10 */
                    final /* synthetic */ int neO = 1;

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(151463);
                        c.a(aVar2, this.neO, str, z2);
                        AppMethodBeat.o(151463);
                    }
                }, new f.c() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass11 */
                    final /* synthetic */ int neO = 1;

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(151464);
                        eVl.gX(context);
                        if (z2) {
                            h.INSTANCE.a(15783, Integer.valueOf(this.neO), 0, str);
                        }
                        AppMethodBeat.o(151464);
                    }
                });
                i2 = 1;
            } else {
                aVar2.bow(string4);
                aVar2.apa(R.string.h1b);
                aVar2.boB(resources.getString(R.string.sz));
                aVar2.a(new f.c() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass2 */
                    final /* synthetic */ int neO = 3;

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(151455);
                        c.a(aVar2, this.neO, str, z2);
                        AppMethodBeat.o(151455);
                    }
                }, new f.c() {
                    /* class com.tencent.mm.plugin.base.model.c.AnonymousClass3 */
                    final /* synthetic */ int neO = 3;

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(151456);
                        c.a(context, false, this.neO, str, z2);
                        AppMethodBeat.o(151456);
                    }
                });
                i2 = 3;
            }
        } else {
            i2 = -1;
        }
        if (eVm == 0 || z) {
            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(eVm), Integer.valueOf(i2));
            AppMethodBeat.o(151469);
            return pair;
        }
        aVar2.show();
        if (z2) {
            h.INSTANCE.a(15788, Integer.valueOf(i2), 0, str);
        }
        Log.i("MicroMsg.ShortcutUtil", "permissionJumpStatus = ".concat(String.valueOf(i2)));
        Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(eVm), Integer.valueOf(i2));
        AppMethodBeat.o(151469);
        return pair2;
    }

    public static void a(final Context context, int i2, final int i3, boolean z, final String str, final boolean z2) {
        AppMethodBeat.i(151470);
        Resources resources = context.getResources();
        if (i2 == 0) {
            com.tencent.mm.ui.widget.snackbar.b.r((Activity) context, resources.getString(R.string.h1i));
            if (z2) {
                h.INSTANCE.a(15787, Integer.valueOf(i3), 0, str);
                AppMethodBeat.o(151470);
                return;
            }
        } else if (z && (i3 == 2 || i3 == 4)) {
            Resources resources2 = context.getResources();
            com.tencent.mm.ui.widget.snackbar.b.a((Activity) context, resources2.getString(R.string.h1i), resources2.getString(R.string.h1b), new a.b() {
                /* class com.tencent.mm.plugin.base.model.c.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.snackbar.a.b
                public final void bDZ() {
                    AppMethodBeat.i(151457);
                    c.a(context, true, i3, str, z2);
                    AppMethodBeat.o(151457);
                }
            });
            if (z2) {
                h.INSTANCE.a(15787, Integer.valueOf(i3), 0, str);
            }
        }
        AppMethodBeat.o(151470);
    }

    public static void cjL() {
        AppMethodBeat.i(223693);
        if (d.oD(25)) {
            b.a aVar = b.a.clicfg_app_shortcut;
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdh()) == 1) {
                Log.i("MicroMsg.ShortcutUtil", "need addShortCuts");
                cjM();
                AppMethodBeat.o(223693);
                return;
            }
            Log.i("MicroMsg.ShortcutUtil", "switch is close , remove all shortcut");
            cjN();
        }
        AppMethodBeat.o(223693);
    }

    private static void cjM() {
        AppMethodBeat.i(223694);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_scan_qrcode").setShortLabel(MMApplicationContext.getContext().getString(R.string.cey)).setLongLabel(MMApplicationContext.getContext().getString(R.string.cey)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), (int) R.drawable.cns)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_scan_qrcode")).build());
        int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) -1)).intValue();
        Log.i("MicroMsg.ShortcutUtil", "offline shorcut walletRegion : %s", Integer.valueOf(intValue));
        if (intValue == 0 || intValue == 1 || intValue == 8) {
            arrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_offline_wallet").setShortLabel(MMApplicationContext.getContext().getString(R.string.h1_)).setLongLabel(MMApplicationContext.getContext().getString(R.string.h1_)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), (int) R.drawable.cnr)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_offline_wallet")).build());
        }
        arrayList.add(new ShortcutInfo.Builder(MMApplicationContext.getContext(), "launch_type_my_qrcode").setShortLabel(MMApplicationContext.getContext().getString(R.string.h19)).setLongLabel(MMApplicationContext.getContext().getString(R.string.h19)).setIcon(Icon.createWithResource(MMApplicationContext.getContext(), (int) R.drawable.cnq)).setIntent(new Intent("com.tencent.mm.action.BIZSHORTCUT").addFlags(67108864).putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_my_qrcode")).build());
        try {
            ShortcutManager shortcutManager = (ShortcutManager) MMApplicationContext.getContext().getSystemService(ShortcutManager.class);
            shortcutManager.removeDynamicShortcuts(Util.stringsToList(new String[]{"launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode"}));
            shortcutManager.addDynamicShortcuts(arrayList);
            AppMethodBeat.o(223694);
        } catch (Exception e2) {
            Log.i("MicroMsg.ShortcutUtil", "remove error : %s", e2.getMessage());
            AppMethodBeat.o(223694);
        }
    }

    private static void cjN() {
        AppMethodBeat.i(223695);
        try {
            ((ShortcutManager) MMApplicationContext.getContext().getSystemService(ShortcutManager.class)).removeDynamicShortcuts(Util.stringsToList(new String[]{"launch_type_scan_qrcode", "launch_type_offline_wallet", "launch_type_my_qrcode"}));
            AppMethodBeat.o(223695);
        } catch (Exception e2) {
            Log.i("MicroMsg.ShortcutUtil", "remove error : %s", e2.getMessage());
            AppMethodBeat.o(223695);
        }
    }

    static /* synthetic */ void a(Context context, boolean z, int i2, String str, boolean z2) {
        String string;
        AppMethodBeat.i(151471);
        Intent intent = new Intent();
        if (z2) {
            string = context.getResources().getString(R.string.a3k);
        } else {
            string = context.getResources().getString(R.string.h1h);
        }
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("extra_app_id", str);
        intent.putExtra("extra_permission_and_jump_status", i2);
        com.tencent.mm.br.c.b(context, "appbrand", ".ui.ShortCutPermissionDetailUI", intent);
        if (z2) {
            if (z) {
                h.INSTANCE.a(15785, Integer.valueOf(i2), 0, str);
                AppMethodBeat.o(151471);
                return;
            }
            h.INSTANCE.a(15784, Integer.valueOf(i2), 0, str);
        }
        AppMethodBeat.o(151471);
    }

    static /* synthetic */ void a(f.a aVar, int i2, String str, boolean z) {
        AppMethodBeat.i(151472);
        aVar.kdo.dismiss();
        if (z) {
            h.INSTANCE.a(15790, Integer.valueOf(i2), 0, str);
        }
        AppMethodBeat.o(151472);
    }
}
