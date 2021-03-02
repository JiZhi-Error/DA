package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ToolsProfile;
import com.tencent.mm.booter.MMReceivers;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ah;
import com.tencent.xweb.x5.sdk.d;
import java.util.Locale;

public final class e {

    public static class c implements MMReceivers.a {
        @Override // com.tencent.mm.booter.MMReceivers.a
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19878);
            if (context == null || intent == null) {
                AppMethodBeat.o(19878);
                return;
            }
            String stringExtra = intent.getStringExtra("tools_process_action_code_key");
            Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(stringExtra)));
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(19878);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                Log.appenderFlushSync();
                boolean isLocked = ToolsProfile.a.isLocked();
                Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(isLocked));
                if (!isLocked) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/booter/MMProcessReceivers$ToolsProcessReceiverImpl", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/booter/MMProcessReceivers$ToolsProcessReceiverImpl", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                }
                AppMethodBeat.o(19878);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES")) {
                String stringExtra2 = intent.getStringExtra("tools_language");
                if (stringExtra2 == null) {
                    AppMethodBeat.o(19878);
                    return;
                }
                Log.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", stringExtra2);
                Locale transLanguageToLocale = LocaleUtil.transLanguageToLocale(stringExtra2);
                if (LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(stringExtra2)) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        transLanguageToLocale = LocaleUtil.sysDefaultLocale;
                        Locale.setDefault(transLanguageToLocale);
                    } else {
                        transLanguageToLocale = Locale.getDefault();
                    }
                }
                LocaleUtil.updateApplicationResourceLocale(context.getApplicationContext(), transLanguageToLocale);
                MMApplicationContext.setResources(com.tencent.mm.cc.b.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
                AppMethodBeat.o(19878);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                try {
                    ah.clearAllWebViewCache(context.getApplicationContext(), true);
                    AppMethodBeat.o(19878);
                } catch (Exception e2) {
                    Log.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e2.getMessage());
                    AppMethodBeat.o(19878);
                }
            } else {
                if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        boolean booleanExtra = intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true);
                        Log.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(booleanExtra));
                        ah.clearAllWebViewCache(context.getApplicationContext(), booleanExtra);
                        AppMethodBeat.o(19878);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        Log.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                        AppMethodBeat.o(19878);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        Log.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                        AppMethodBeat.o(19878);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        String stringExtra3 = intent.getStringExtra("file_path");
                        String stringExtra4 = intent.getStringExtra("file_ext");
                        String stringExtra5 = intent.getStringExtra("file_name");
                        byte[] byteArrayExtra = intent.getByteArrayExtra("key_multi_task_common_info");
                        int intExtra = intent.getIntExtra("sence", 0);
                        if (System.currentTimeMillis() - w.JVG >= 1000 && !Util.isNullOrNil(stringExtra3)) {
                            w.JVG = System.currentTimeMillis();
                            Intent intent2 = new Intent();
                            intent2.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
                            intent2.putExtra("file_path", stringExtra3);
                            intent2.putExtra("file_ext", stringExtra4);
                            intent2.putExtra("file_name", stringExtra5);
                            intent2.putExtra("sence", intExtra);
                            intent2.putExtra("key_multi_task_common_info", byteArrayExtra);
                            intent2.addFlags(268435456);
                            Context context2 = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[B)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context2.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginsdk/model/TBSFileBrowseHelper", "loadByMiniQB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[B)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    }
                }
                AppMethodBeat.o(19878);
            }
        }
    }

    public static class a extends c {
        @Override // com.tencent.mm.booter.e.c, com.tencent.mm.booter.MMReceivers.a
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19875);
            if (context == null || intent == null) {
                AppMethodBeat.o(19875);
                return;
            }
            super.onReceive(context, intent);
            String stringExtra = intent.getStringExtra("toolsmp_process_action_code_key");
            if (!Util.isNullOrNil(stringExtra) && stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
                String stringExtra2 = intent.getStringExtra("toolsmp_param_preload_url");
                int intExtra = intent.getIntExtra("toolsmp_param_preload_search_biz", -1);
                boolean booleanExtra = intent.getBooleanExtra("toolsmp_param_preload_search_biz_need_reset", false);
                com.tencent.mm.plugin.webview.ui.tools.fts.preload.b bVar = com.tencent.mm.plugin.webview.ui.tools.fts.preload.b.JpB;
                com.tencent.mm.plugin.webview.ui.tools.fts.preload.b.k(intExtra, stringExtra2, booleanExtra);
            }
            AppMethodBeat.o(19875);
        }
    }

    public static class b implements MMReceivers.a {
        @Override // com.tencent.mm.booter.MMReceivers.a
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(19877);
            if (context == null || intent == null) {
                AppMethodBeat.o(19877);
                return;
            }
            Log.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
            d.reset(context);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.booter.e.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(19876);
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/booter/MMProcessReceivers$SandBoxProcessReceiverImpl$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    AppMethodBeat.o(19876);
                }
            }, 5000);
            AppMethodBeat.o(19877);
        }
    }
}
