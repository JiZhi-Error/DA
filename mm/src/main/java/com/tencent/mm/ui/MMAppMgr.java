package com.tencent.mm.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Looper;
import android.os.Process;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.ai;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.ah;

public final class MMAppMgr {
    static StringBuffer OHl;
    private static long OHm;
    public Receiver OHn;
    private long jkM;
    private String koi;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        private static boolean bB(Intent intent) {
            AppMethodBeat.i(33419);
            if (!intent.getBooleanExtra("process_is_mm", false)) {
                AppMethodBeat.o(33419);
                return true;
            } else if (intent.getIntExtra("process_id", 0) == Process.myPid()) {
                AppMethodBeat.o(33419);
                return true;
            } else {
                AppMethodBeat.o(33419);
                return false;
            }
        }

        public void onReceive(Context context, Intent intent) {
            b gmM;
            AppMethodBeat.i(33420);
            if (intent == null) {
                AppMethodBeat.o(33420);
            } else if (bg.aVy() || bg.aVA()) {
                AppMethodBeat.o(33420);
            } else {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (!bB(intent)) {
                        Log.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                        AppMethodBeat.o(33420);
                        return;
                    }
                    MMAppMgr.a(this.appMgr, intent, true);
                    AppMethodBeat.o(33420);
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (!bB(intent)) {
                        Log.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                        AppMethodBeat.o(33420);
                        return;
                    }
                    o.report();
                    MMAppMgr.a(this.appMgr, intent, false);
                    if (MMAppMgr.OHl != null && MMAppMgr.OHl.length() > 800) {
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.ui.MMAppMgr.Receiver.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(33417);
                                MMAppMgr.gIT();
                                AppMethodBeat.o(33417);
                            }
                        });
                    }
                    AppMethodBeat.o(33420);
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    String stringExtra = intent.getStringExtra("content");
                    if (Util.isNullOrNil(stringExtra)) {
                        Log.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                    } else {
                        if (MMAppMgr.OHl == null) {
                            MMAppMgr.OHl = new StringBuffer(800);
                        }
                        MMAppMgr.OHl.append(stringExtra);
                        Log.i("MicroMsg.MMAppMgr", "cpan content: %s", stringExtra);
                    }
                    if (MMAppMgr.OHl != null && MMAppMgr.OHl.length() > 800) {
                        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.ui.MMAppMgr.Receiver.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(33418);
                                MMAppMgr.gIT();
                                AppMethodBeat.o(33418);
                            }
                        });
                    }
                    AppMethodBeat.o(33420);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    if (!intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        int intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        Log.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(intExtra)));
                        if (bg.aAc()) {
                            h.INSTANCE.a(10328, Integer.valueOf(intExtra));
                        }
                    } else {
                        int intExtra2 = intent.getIntExtra("intent_extra_opcode", 0);
                        Log.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(intExtra2)));
                        if (bg.aAc()) {
                            if (intExtra2 == 2) {
                                h.INSTANCE.a(11147, Integer.valueOf(intExtra2), Integer.valueOf(intent.getIntExtra("intent_extra_install_dialog_times", 0)));
                            } else {
                                h.INSTANCE.a(11147, Integer.valueOf(intExtra2));
                            }
                            if (intExtra2 == 4 && g.gnu() == 4 && (gmM = b.gmM()) != null) {
                                gmM.gmO();
                            }
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (bg.aAc() && !(longExtra == 0 && longExtra2 == 0)) {
                        Log.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            n.b((long) ((int) longExtra2), (long) ((int) longExtra), 0);
                            AppMethodBeat.o(33420);
                            return;
                        }
                        n.c((long) ((int) longExtra2), (long) ((int) longExtra), 0);
                    }
                    AppMethodBeat.o(33420);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.n(context, true);
                    AppMethodBeat.o(33420);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    String stringExtra2 = intent.getStringExtra("op_type");
                    if ("NOTIFY_RET".equals(stringExtra2)) {
                        a.bq(intent);
                        AppMethodBeat.o(33420);
                        return;
                    }
                    if ("SEND_TO_FRIENDS".equals(stringExtra2)) {
                        Log.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
                        if (!com.tencent.mm.kernel.g.aAc()) {
                            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
                            AppMethodBeat.o(33420);
                            return;
                        }
                        String bpF = com.tencent.mm.cr.a.bpF(intent.getStringExtra("file_path"));
                        String stringExtra3 = intent.getStringExtra("file_name");
                        String stringExtra4 = intent.getStringExtra("to_user");
                        String stringExtra5 = intent.getStringExtra("send_text");
                        if (Util.isNullOrNil(bpF) || Util.isNullOrNil(stringExtra3) || Util.isNullOrNil(stringExtra4)) {
                            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
                            AppMethodBeat.o(33420);
                            return;
                        }
                        WXFileObject wXFileObject = new WXFileObject();
                        wXFileObject.setFilePath(bpF);
                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                        wXMediaMessage.mediaObject = wXFileObject;
                        wXMediaMessage.title = stringExtra3;
                        wXMediaMessage.description = stringExtra3;
                        for (String str : Util.stringsToList(stringExtra4.split(","))) {
                            m.a(wXMediaMessage, "", "", str, 3, (String) null);
                            if (!Util.isNullOrNil(stringExtra5)) {
                                com.tencent.mm.plugin.messenger.a.g.eir().ad(str, stringExtra5, ab.JG(str));
                            }
                        }
                    }
                    AppMethodBeat.o(33420);
                } else {
                    Log.e("MicroMsg.MMAppMgr", "unknown broadcast action");
                    AppMethodBeat.o(33420);
                }
            }
        }
    }

    public static void gIT() {
        AppMethodBeat.i(33421);
        StringBuffer stringBuffer = new StringBuffer(800);
        if (OHl == null) {
            OHl = stringBuffer;
            OHm = Util.nowSecond();
            AppMethodBeat.o(33421);
            return;
        }
        String stringBuffer2 = OHl.toString();
        stringBuffer.append(blS(stringBuffer2));
        OHl = stringBuffer;
        Log.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        h.INSTANCE.kvStat(10508, "1," + OHm + "," + stringBuffer2);
        OHm = Util.nowSecond();
        AppMethodBeat.o(33421);
    }

    private static String blS(String str) {
        AppMethodBeat.i(33422);
        int i2 = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i2++;
            }
            if (i2 == 3) {
                break;
            }
            length--;
        }
        String substring = str.substring(length + 1);
        AppMethodBeat.o(33422);
        return substring;
    }

    public static void cancelNotification(String str) {
        AppMethodBeat.i(33423);
        bg.getNotification().cancelNotification(str);
        AppMethodBeat.o(33423);
    }

    public static void Xc() {
        AppMethodBeat.i(33424);
        bg.getNotification().Xc();
        AppMethodBeat.o(33424);
    }

    public static void bCm() {
        AppMethodBeat.i(185859);
        Bj(true);
        AppMethodBeat.o(185859);
    }

    public static void Bj(boolean z) {
        AppMethodBeat.i(33426);
        Log.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), Util.getStack(), Boolean.valueOf(z));
        d.E(2, 0, "");
        if (z) {
            gIU();
        }
        EventCenter.instance.publish(new com.tencent.mm.g.a.ab());
        ma maVar = new ma();
        maVar.dRA.status = 0;
        maVar.dRA.bDZ = 2;
        EventCenter.instance.publish(maVar);
        gIT();
        if (z) {
            bg.FM(Util.getStack().toString());
            com.tencent.mm.kernel.g.aAi().releaseAll();
        }
        Log.appenderClose();
        Mars.onSingalCrash(0);
        com.tencent.mm.bv.a.f(MMApplicationContext.getContext(), MMApplicationContext.getApplicationId() + ":recovery", MMApplicationContext.getApplicationId() + ":support", MMApplicationContext.getApplicationId() + ":tools", MMApplicationContext.getApplicationId() + ":toolsmp", MMApplicationContext.getApplicationId() + ":appbrand0", MMApplicationContext.getApplicationId() + ":appbrand1", MMApplicationContext.getApplicationId() + ":appbrand2", MMApplicationContext.getApplicationId() + ":appbrand3", MMApplicationContext.getApplicationId() + ":appbrand4", MMApplicationContext.getApplicationId() + ":lite");
        try {
            ah.clearAllWebViewCache(MMApplicationContext.getContext(), true);
            Log.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
        } catch (Exception e2) {
            Log.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", e2);
        }
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33426);
    }

    public static void gIU() {
        AppMethodBeat.i(33427);
        Context context = MMApplicationContext.getContext();
        if (context != null) {
            if (com.tencent.mm.booter.c.akA()) {
                com.tencent.mm.app.g.Wj();
            } else {
                try {
                    context.stopService(new Intent(context, CoreService.class));
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMAppMgr", "killService() Exception:%s", e2.getMessage());
                }
            }
            com.tencent.mm.br.c.bs(new Intent(context, NotifyReceiver.NotifyService.class));
            context.stopService(new Intent(context, CacheService.class));
            com.tencent.mm.br.c.o(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
        }
        AppMethodBeat.o(33427);
    }

    public static void bV(Context context) {
        AppMethodBeat.i(33428);
        n(context, true);
        AppMethodBeat.o(33428);
    }

    public static void n(Context context, boolean z) {
        AppMethodBeat.i(33429);
        com.tencent.mm.kernel.g.aAi().et(z);
        Mars.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        o.Xe();
        if (!(bg.azz() == null || bg.azz().iMw == null)) {
            bg.azz().iMw.fA(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(33429);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMAppMgr", th, "[-] Fail to start launcherUI in suicide.", new Object[0]);
            AppMethodBeat.o(33429);
        }
    }

    public static boolean jN(final Context context) {
        AppMethodBeat.i(33430);
        if (!bg.aAc()) {
            AppMethodBeat.o(33430);
            return false;
        }
        bg.aVF();
        if (Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(61, (Object) null))) {
            AppMethodBeat.o(33430);
            return false;
        } else if (!MMEntryLock.lock("show_wap_adviser")) {
            AppMethodBeat.o(33430);
            return false;
        } else {
            View inflate = View.inflate(context, R.layout.bfs, null);
            ((TextView) inflate.findViewById(R.id.fuy)).setText(R.string.fbu);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.fux);
            checkBox.setText(context.getString(R.string.fpc));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass9 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(33411);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(61, Boolean.valueOf(z));
                    AppMethodBeat.o(33411);
                }
            });
            checkBox.setVisibility(0);
            d.a aVar = new d.a(context);
            aVar.aoO(R.string.zb);
            aVar.hs(inflate);
            aVar.aoV(R.string.fpe).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(33412);
                    try {
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.APN_SETTINGS"));
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMAppMgr$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMAppMgr$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(33412);
                    } catch (Exception e2) {
                        AppMethodBeat.o(33412);
                    }
                }
            });
            aVar.Dk(false);
            aVar.aoW(R.string.fpd);
            aVar.a(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass11 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(33413);
                    MMEntryLock.unlock("show_wap_adviser");
                    AppMethodBeat.o(33413);
                }
            });
            aVar.hbn().show();
            AppMethodBeat.o(33430);
            return true;
        }
    }

    public static void bh(Activity activity) {
        AppMethodBeat.i(33431);
        if (com.tencent.mm.kernel.g.aAh().hqT) {
            com.tencent.mm.br.c.V(activity, "whatsnew", ".ui.WhatsNewUI");
            AppMethodBeat.o(33431);
            return;
        }
        new com.tencent.mm.plugin.whatsnew.ui.d(activity).show();
        AppMethodBeat.o(33431);
    }

    public static void jO(Context context) {
        AppMethodBeat.i(33432);
        SharedPreferences sharedPreferences = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.string.edx));
            intent.putExtra("duplicate", false);
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.b.p(context, intent);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
        AppMethodBeat.o(33432);
    }

    public static boolean a(final Activity activity, final DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(33433);
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        ChannelUtil.isShowingGprsAlert &= z;
        if (z) {
            ai.init(activity.getBaseContext());
            View inflate = View.inflate(activity, R.layout.atl, null);
            String translate = WeChatBrands.Wordings.translate(activity.getString(R.string.fp8));
            String translate2 = WeChatBrands.Wordings.translate(activity.getString(R.string.evb));
            String translate3 = WeChatBrands.Wordings.translate(activity.getString(R.string.eva, new Object[]{translate, translate2}));
            Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(translate3);
            newSpannable.setSpan(new ClickableSpan() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(33414);
                    Util.jump(activity, WeChatBrands.Wordings.translate(MMApplicationContext.getResources().getString(R.string.ee8, LocaleUtil.getCurrentLanguage(activity), LocaleUtil.getCurrentCountryCode(), "setting", 0, 0)));
                    AppMethodBeat.o(33414);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(33415);
                    textPaint.setColor(activity.getResources().getColor(R.color.x0));
                    AppMethodBeat.o(33415);
                }
            }, translate3.indexOf(translate), translate.length() + translate3.indexOf(translate), 33);
            newSpannable.setSpan(new StyleSpan(1), translate3.indexOf(translate2), translate2.length() + translate3.indexOf(translate2), 33);
            TextView textView = (TextView) inflate.findViewById(R.id.f6_);
            textView.setText(newSpannable);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dks);
            com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a((Context) activity, false, (String) null, inflate, activity.getString(R.string.b98), activity.getString(R.string.ev8), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(33416);
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    ChannelUtil.isShowingGprsAlert = false;
                    dialogInterface.dismiss();
                    MMAppMgr.jO(activity);
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i2);
                    }
                    AppMethodBeat.o(33416);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(33404);
                    dialogInterface.dismiss();
                    Activity activity = activity;
                    com.tencent.mm.kernel.g.aAi().et(true);
                    Mars.onSingalCrash(0);
                    MMNativeJpeg.Destroy();
                    o.Xe();
                    if (!(bg.azz() == null || bg.azz().iMw == null)) {
                        bg.azz().iMw.fA(true);
                    }
                    Intent intent = new Intent().setClass(activity, LauncherUI.class);
                    intent.addFlags(32768);
                    intent.putExtra("absolutely_exit_pid", Process.myPid());
                    intent.putExtra("kill_service", true);
                    if (!(activity instanceof Activity)) {
                        intent.addFlags(268435456);
                    } else {
                        activity.finish();
                    }
                    try {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(33404);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.MMAppMgr", th, "[-] Fail to start launcherUI in suicide.", new Object[0]);
                        AppMethodBeat.o(33404);
                    }
                }
            });
            if (a2 == null) {
                AppMethodBeat.o(33433);
                return false;
            }
            a2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(33405);
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                    AppMethodBeat.o(33405);
                }
            });
        }
        AppMethodBeat.o(33433);
        return z;
    }

    public static boolean a(Context context, int i2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        boolean z;
        AppMethodBeat.i(33434);
        View inflate = View.inflate(context, R.layout.bfs, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.fux);
        checkBox.setText(context.getString(R.string.fbj));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(33406);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(16385, Boolean.valueOf(!z));
                AppMethodBeat.o(33406);
            }
        });
        inflate.findViewById(R.id.fuz).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.fuy);
        switch (i2) {
            case 1:
                textView.setText(R.string.fbi);
                z = true;
                break;
            case 2:
            default:
                textView.setText(R.string.fbv);
                z = true;
                break;
            case 3:
                textView.setText(R.string.fbv);
                z = false;
                break;
        }
        if (z) {
            d.a aVar = new d.a(context);
            aVar.aoO(R.string.zb);
            aVar.Dk(false);
            aVar.hs(inflate);
            aVar.aoV(R.string.fbs).c(onClickListener);
            aVar.aoW(R.string.fbj).d(onClickListener2);
            aVar.hbn().show();
            AppMethodBeat.o(33434);
            return true;
        }
        AppMethodBeat.o(33434);
        return false;
    }

    public static com.tencent.mm.ui.widget.a.d bY(final Context context) {
        AppMethodBeat.i(33435);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION);
            if (!NetStatusUtil.isWifi(context) || !locationManager.isProviderEnabled("gps")) {
                bg.aVF();
                Boolean bool = (Boolean) com.tencent.mm.model.c.azQ().get(4105, Boolean.FALSE);
                if (bool == null || !bool.booleanValue()) {
                    View inflate = View.inflate(context, R.layout.azm, null);
                    ((CheckBox) inflate.findViewById(R.id.e_s)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass5 */

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            AppMethodBeat.i(33407);
                            if (z) {
                                bg.aVF();
                                com.tencent.mm.model.c.azQ().set(4105, Boolean.TRUE);
                                AppMethodBeat.o(33407);
                                return;
                            }
                            bg.aVF();
                            com.tencent.mm.model.c.azQ().set(4105, Boolean.FALSE);
                            AppMethodBeat.o(33407);
                        }
                    });
                    AnonymousClass6 r0 = new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.MMAppMgr.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33408);
                            try {
                                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                                Context context = context;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MMAppMgr$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MMAppMgr$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(33408);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MMAppMgr", e2, "showLbsTipsAlert", new Object[0]);
                                AppMethodBeat.o(33408);
                            }
                        }
                    };
                    d.a aVar = new d.a(context);
                    aVar.aoO(R.string.fac);
                    aVar.hs(inflate);
                    aVar.aoV(R.string.yv).c(r0);
                    aVar.aoW(R.string.w4);
                    com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
                    hbn.show();
                    AppMethodBeat.o(33435);
                    return hbn;
                }
                AppMethodBeat.o(33435);
                return null;
            }
            AppMethodBeat.o(33435);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMAppMgr", e2, "showLbsTipsAlert error", new Object[0]);
            AppMethodBeat.o(33435);
            return null;
        }
    }

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        AppMethodBeat.i(33436);
        String stringExtra = intent.getStringExtra("classname");
        if (Util.isNullOrNil(stringExtra)) {
            Log.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            AppMethodBeat.o(33436);
            return;
        }
        String substring = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        CrashReportFactory.setCurrentActivity(substring);
        if (OHl == null) {
            OHl = new StringBuffer(800);
            OHm = Util.nowSecond();
            OHl.append("start:");
            OHl.append(Util.nowSecond());
            OHl.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.koi)) {
                OHl.append("desktop:");
                OHl.append(Util.ticksToNow(mMAppMgr.jkM) + 800);
                OHl.append("|");
            }
            mMAppMgr.jkM = Util.currentTicks();
            mMAppMgr.koi = substring;
        } else {
            OHl.append(mMAppMgr.koi + ":");
            OHl.append(Util.ticksToNow(mMAppMgr.jkM));
            OHl.append("|");
        }
        Log.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", substring, Boolean.valueOf(z));
        AppMethodBeat.o(33436);
    }
}
