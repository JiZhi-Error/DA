package com.tencent.mm.br;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.service.ProcessService;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class c {
    private static final Map<String, String> KxX;
    private static HashMap<String, d> KxY = new HashMap<>();
    private static final HashSet<String> KxZ = new HashSet<String>() {
        /* class com.tencent.mm.br.c.AnonymousClass13 */

        {
            AppMethodBeat.i(133708);
            add(".ui.transmit.SelectConversationUI");
            AppMethodBeat.o(133708);
        }
    };

    public interface a {
        void onActivityResult(int i2, int i3, Intent intent);
    }

    public interface b {
        void a(Intent intent, int i2, a aVar);

        Context getContext();
    }

    static {
        AppMethodBeat.i(133750);
        HashMap hashMap = new HashMap();
        KxX = hashMap;
        hashMap.put(FirebaseAnalytics.b.LOCATION, "talkroom");
        KxX.put("talkroom", "voip");
        AppMethodBeat.o(133750);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent) {
        AppMethodBeat.i(133709);
        AnonymousClass1 r0 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass1 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133696);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(MMApplicationContext.getPackageName(), str2.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.ay(context, intent);
                AppMethodBeat.o(133696);
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass6 */
        };
        a(str, r0);
        AppMethodBeat.o(133709);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent, final Intent intent2) {
        AppMethodBeat.i(133710);
        AnonymousClass7 r0 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass7 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133702);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(MMApplicationContext.getPackageName(), str2.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.b(context, intent, intent2);
                AppMethodBeat.o(133702);
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass8 */
        };
        a(str, r0);
        AppMethodBeat.o(133710);
    }

    public static void V(Context context, String str, String str2) {
        AppMethodBeat.i(133711);
        c(context, str, str2, (Intent) null);
        AppMethodBeat.o(133711);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.i(133712);
        a(context, str, str2, intent, (Bundle) null);
        AppMethodBeat.o(133712);
    }

    public static void a(Context context, String str, String str2, Intent intent, Bundle bundle) {
        AppMethodBeat.i(133713);
        if (!com.tencent.mm.compatible.util.d.oE(21)) {
            try {
                if (context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    Log.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(524288);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.PluginHelper", "%s", e2.getMessage());
            }
        }
        b(context, str, str2, intent, bundle);
        AppMethodBeat.o(133713);
    }

    public static void c(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.i(133714);
        b(context, str, str2, intent, (Bundle) null);
        AppMethodBeat.o(133714);
    }

    private static void b(final Context context, final String str, String str2, final Intent intent, final Bundle bundle) {
        final String str3;
        AppMethodBeat.i(133715);
        Log.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", Boolean.TRUE);
        if (context == null) {
            Log.e("MicroMsg.PluginHelper", "start activity error, context is null");
            AppMethodBeat.o(133715);
            return;
        }
        if (intent != null && !Util.isNullOrNil(intent.getStringExtra("rawUrl"))) {
            intent.putExtra("startTime", System.currentTimeMillis());
        }
        if (".ui.tools.WebViewUI".equals(str2) || "com.tencent.mm.plugin.webview.ui.tools.WebViewUI".equals(str2)) {
            Log.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", 902, Integer.valueOf(WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")));
            try {
                String stringExtra = intent.getStringExtra("rawUrl");
                if (!Util.isNullOrNil(stringExtra)) {
                    Uri parse = Uri.parse(stringExtra);
                    if (intent.getLongExtra("start_activity_time", 0) == 0) {
                        intent.putExtra("start_activity_time", System.currentTimeMillis());
                    }
                    if (parse.getHost() != null && parse.getHost().equals("mp.weixin.qq.com") && !WeChatBrands.Business.Entries.SessionOa.checkAvailable(context)) {
                        Log.i("MicroMsg.PluginHelper", "Block mp url %s", stringExtra);
                        AppMethodBeat.o(133715);
                        return;
                    } else if (parse.getHost() != null && parse.getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
                        str3 = a(intent, parse);
                        AnonymousClass9 r0 = new a() {
                            /* class com.tencent.mm.br.c.AnonymousClass9 */

                            @Override // com.tencent.mm.br.a
                            public final void onDone() {
                                AppMethodBeat.i(133704);
                                Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str, str3);
                                try {
                                    Intent intent = intent == null ? new Intent() : intent;
                                    String str = str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3;
                                    intent.setClassName(MMApplicationContext.getPackageName(), str);
                                    Class.forName(str, false, context.getClassLoader());
                                    if (context instanceof Activity) {
                                        Context context = context;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        AppMethodBeat.o(133704);
                                        return;
                                    }
                                    intent.addFlags(268435456);
                                    Context context2 = context;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    context2.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    AppMethodBeat.o(133704);
                                } catch (ClassNotFoundException e2) {
                                    Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e2);
                                    AppMethodBeat.o(133704);
                                }
                            }
                        };
                        new Object() {
                            /* class com.tencent.mm.br.c.AnonymousClass10 */
                        };
                        a(str, r0);
                        AppMethodBeat.o(133715);
                    } else if (parse.getHost() != null && parse.getHost().equals(WeChatHosts.domainString(R.string.e20)) && !ToolsProcessIPCService.ayt()) {
                        str3 = ".ui.tools.WebviewMpUI";
                        AnonymousClass9 r02 = new a() {
                            /* class com.tencent.mm.br.c.AnonymousClass9 */

                            @Override // com.tencent.mm.br.a
                            public final void onDone() {
                                AppMethodBeat.i(133704);
                                Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str, str3);
                                try {
                                    Intent intent = intent == null ? new Intent() : intent;
                                    String str = str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3;
                                    intent.setClassName(MMApplicationContext.getPackageName(), str);
                                    Class.forName(str, false, context.getClassLoader());
                                    if (context instanceof Activity) {
                                        Context context = context;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        AppMethodBeat.o(133704);
                                        return;
                                    }
                                    intent.addFlags(268435456);
                                    Context context2 = context;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    context2.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    AppMethodBeat.o(133704);
                                } catch (ClassNotFoundException e2) {
                                    Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e2);
                                    AppMethodBeat.o(133704);
                                }
                            }
                        };
                        new Object() {
                            /* class com.tencent.mm.br.c.AnonymousClass10 */
                        };
                        a(str, r02);
                        AppMethodBeat.o(133715);
                    } else if (!t.bsh(parse.getHost()) || ToolsProcessIPCService.ayt()) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(ao.isDarkMode());
                        objArr[1] = Boolean.valueOf(!"false".equalsIgnoreCase(com.tencent.xweb.b.nS("dark_to_toolsmp", "tools")));
                        Log.i("MicroMsg.PluginHelper", "other web, isDarkMode:%s, darkToToolsmp:%s", objArr);
                        if (ao.isDarkMode() && !"false".equalsIgnoreCase(com.tencent.xweb.b.nS("dark_to_toolsmp", "tools")) && !t.bsi(parse.getHost())) {
                            str2 = ".ui.tools.WebviewMpUI";
                        }
                    } else {
                        str3 = ".ui.tools.WebviewMpUI";
                        AnonymousClass9 r022 = new a() {
                            /* class com.tencent.mm.br.c.AnonymousClass9 */

                            @Override // com.tencent.mm.br.a
                            public final void onDone() {
                                AppMethodBeat.i(133704);
                                Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str, str3);
                                try {
                                    Intent intent = intent == null ? new Intent() : intent;
                                    String str = str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3;
                                    intent.setClassName(MMApplicationContext.getPackageName(), str);
                                    Class.forName(str, false, context.getClassLoader());
                                    if (context instanceof Activity) {
                                        Context context = context;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
                                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                        AppMethodBeat.o(133704);
                                        return;
                                    }
                                    intent.addFlags(268435456);
                                    Context context2 = context;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    context2.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
                                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                                    AppMethodBeat.o(133704);
                                } catch (ClassNotFoundException e2) {
                                    Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e2);
                                    AppMethodBeat.o(133704);
                                }
                            }
                        };
                        new Object() {
                            /* class com.tencent.mm.br.c.AnonymousClass10 */
                        };
                        a(str, r022);
                        AppMethodBeat.o(133715);
                    }
                }
                str3 = str2;
            } catch (Exception e2) {
                Log.e("MicroMsg.PluginHelper", "parse url failed :" + e2.getMessage());
            }
            AnonymousClass9 r0222 = new a() {
                /* class com.tencent.mm.br.c.AnonymousClass9 */

                @Override // com.tencent.mm.br.a
                public final void onDone() {
                    AppMethodBeat.i(133704);
                    Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str, str3);
                    try {
                        Intent intent = intent == null ? new Intent() : intent;
                        String str = str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3;
                        intent.setClassName(MMApplicationContext.getPackageName(), str);
                        Class.forName(str, false, context.getClassLoader());
                        if (context instanceof Activity) {
                            Context context = context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                            context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                            AppMethodBeat.o(133704);
                            return;
                        }
                        intent.addFlags(268435456);
                        Context context2 = context;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                        context2.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
                        com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                        AppMethodBeat.o(133704);
                    } catch (ClassNotFoundException e2) {
                        Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e2);
                        AppMethodBeat.o(133704);
                    }
                }
            };
            new Object() {
                /* class com.tencent.mm.br.c.AnonymousClass10 */
            };
            a(str, r0222);
            AppMethodBeat.o(133715);
        }
        str3 = str2;
        AnonymousClass9 r02222 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass9 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133704);
                Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str, str3);
                try {
                    Intent intent = intent == null ? new Intent() : intent;
                    String str = str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3;
                    intent.setClassName(MMApplicationContext.getPackageName(), str);
                    Class.forName(str, false, context.getClassLoader());
                    if (context instanceof Activity) {
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                        context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                        AppMethodBeat.o(133704);
                        return;
                    }
                    intent.addFlags(268435456);
                    Context context2 = context;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                    context2.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
                    AppMethodBeat.o(133704);
                } catch (ClassNotFoundException e2) {
                    Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e2);
                    AppMethodBeat.o(133704);
                }
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass10 */
        };
        a(str, r02222);
        AppMethodBeat.o(133715);
    }

    private static String a(Intent intent, Uri uri) {
        String str;
        AppMethodBeat.i(229796);
        String queryParameter = uri.getQueryParameter("not_in_game_luggage");
        int intExtra = intent.getIntExtra("KHalfScreenHeight", 0);
        if (!Util.nullAsNil(queryParameter).equals("1") && ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.game_luggage, true)) {
            if (!t.bsh(uri.getHost()) || ToolsProcessIPCService.ayt()) {
                str = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
            } else {
                str = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewMpUI";
            }
            if (intExtra > 0) {
                str = "com.tencent.mm.plugin.game.luggage.LuggageGameHalfWebViewUI";
            }
        } else if (!t.bsh(uri.getHost()) || ToolsProcessIPCService.ayt()) {
            str = ".ui.tools.game.GameWebViewUI";
        } else {
            str = ".ui.tools.game.GameWebViewMpUI";
        }
        AppMethodBeat.o(229796);
        return str;
    }

    public static boolean ayt() {
        AppMethodBeat.i(263718);
        boolean ayt = ToolsProcessIPCService.ayt();
        AppMethodBeat.o(263718);
        return ayt;
    }

    public static void f(Context context, String str, Intent intent) {
        AppMethodBeat.i(133718);
        c(context, str, intent, (Bundle) null);
        AppMethodBeat.o(133718);
    }

    public static void c(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(133719);
        if (intent == null) {
            intent = new Intent();
        }
        String sourcePackageName = MMApplicationContext.getSourcePackageName();
        if (str.startsWith(".")) {
            str = sourcePackageName + str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str);
        if (context instanceof Activity) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            AppMethodBeat.o(133719);
            return;
        }
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        context.startActivity((Intent) bl2.pG(0), (Bundle) bl2.pG(1));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginstub/PluginHelper", "startAppActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(133719);
    }

    public static void d(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(133720);
        a(context, str, str2, (Intent) null, i2, true);
        AppMethodBeat.o(133720);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i2) {
        AppMethodBeat.i(133721);
        a(context, str, str2, intent, i2, true);
        AppMethodBeat.o(133721);
    }

    public static void a(final Context context, final String str, String str2, final Intent intent, final int i2, boolean z) {
        final String str3;
        AppMethodBeat.i(133722);
        Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(z));
        if (context == null) {
            Log.e("MicroMsg.PluginHelper", "start activity error, context is null");
            AppMethodBeat.o(133722);
            return;
        }
        if (".ui.tools.WebViewUI".equals(str2)) {
            Log.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", 902, Integer.valueOf(WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper")));
            try {
                String stringExtra = intent.getStringExtra("rawUrl");
                if (!Util.isNullOrNil(stringExtra)) {
                    Uri parse = Uri.parse(stringExtra);
                    if (intent.getLongExtra("start_activity_time", 0) == 0) {
                        intent.putExtra("start_activity_time", System.currentTimeMillis());
                    }
                    if (parse.getHost() != null && parse.getHost().equals("mp.weixin.qq.com") && !WeChatBrands.Business.Entries.SessionOa.checkAvailable(context)) {
                        Log.i("MicroMsg.PluginHelper", "Block mp url %s", stringExtra);
                        AppMethodBeat.o(133722);
                        return;
                    } else if (parse.getHost() != null && parse.getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
                        str3 = a(intent, parse);
                        AnonymousClass11 r0 = new a() {
                            /* class com.tencent.mm.br.c.AnonymousClass11 */

                            @Override // com.tencent.mm.br.a
                            public final void onDone() {
                                AppMethodBeat.i(133706);
                                Intent intent = intent == null ? new Intent() : intent;
                                intent.setClassName(MMApplicationContext.getPackageName(), str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3);
                                if (context instanceof Activity) {
                                    ((Activity) context).startActivityForResult(intent, i2);
                                    c.g(context, str3, intent);
                                    AppMethodBeat.o(133706);
                                    return;
                                }
                                Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
                                AppMethodBeat.o(133706);
                            }
                        };
                        new Object() {
                            /* class com.tencent.mm.br.c.AnonymousClass12 */
                        };
                        a(str, r0);
                        AppMethodBeat.o(133722);
                    } else if (t.bsh(parse.getHost()) && !ToolsProcessIPCService.ayt()) {
                        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.brJ("dis_switch_to_mp_start_activity_for_ret"))) {
                            str3 = ".ui.tools.WebviewMpUI";
                            AnonymousClass11 r02 = new a() {
                                /* class com.tencent.mm.br.c.AnonymousClass11 */

                                @Override // com.tencent.mm.br.a
                                public final void onDone() {
                                    AppMethodBeat.i(133706);
                                    Intent intent = intent == null ? new Intent() : intent;
                                    intent.setClassName(MMApplicationContext.getPackageName(), str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3);
                                    if (context instanceof Activity) {
                                        ((Activity) context).startActivityForResult(intent, i2);
                                        c.g(context, str3, intent);
                                        AppMethodBeat.o(133706);
                                        return;
                                    }
                                    Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
                                    AppMethodBeat.o(133706);
                                }
                            };
                            new Object() {
                                /* class com.tencent.mm.br.c.AnonymousClass12 */
                            };
                            a(str, r02);
                            AppMethodBeat.o(133722);
                        }
                        Log.i("MicroMsg.PluginHelper", "dis_switch_to_mp_start_activity_for_ret == true");
                    }
                }
                str3 = str2;
            } catch (Exception e2) {
                Log.e("MicroMsg.PluginHelper", "parse url failed :" + e2.getMessage());
            }
            AnonymousClass11 r022 = new a() {
                /* class com.tencent.mm.br.c.AnonymousClass11 */

                @Override // com.tencent.mm.br.a
                public final void onDone() {
                    AppMethodBeat.i(133706);
                    Intent intent = intent == null ? new Intent() : intent;
                    intent.setClassName(MMApplicationContext.getPackageName(), str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3);
                    if (context instanceof Activity) {
                        ((Activity) context).startActivityForResult(intent, i2);
                        c.g(context, str3, intent);
                        AppMethodBeat.o(133706);
                        return;
                    }
                    Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
                    AppMethodBeat.o(133706);
                }
            };
            new Object() {
                /* class com.tencent.mm.br.c.AnonymousClass12 */
            };
            a(str, r022);
            AppMethodBeat.o(133722);
        }
        str3 = str2;
        AnonymousClass11 r0222 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass11 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133706);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(MMApplicationContext.getPackageName(), str3.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str3 : str3);
                if (context instanceof Activity) {
                    ((Activity) context).startActivityForResult(intent, i2);
                    c.g(context, str3, intent);
                    AppMethodBeat.o(133706);
                    return;
                }
                Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
                AppMethodBeat.o(133706);
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass12 */
        };
        a(str, r0222);
        AppMethodBeat.o(133722);
    }

    public static void g(Context context, String str, Intent intent) {
        AppMethodBeat.i(133724);
        if (intent != null) {
            if (KxZ.contains(str)) {
                intent.putExtra("animation_pop_in", true);
            }
            com.tencent.mm.ui.base.b.az(context, intent);
        }
        AppMethodBeat.o(133724);
    }

    public static void c(Context context, String str, Intent intent, int i2) {
        String str2;
        AppMethodBeat.i(133725);
        Intent intent2 = intent == null ? new Intent() : intent;
        String sourcePackageName = MMApplicationContext.getSourcePackageName();
        if (str.startsWith(".")) {
            str2 = sourcePackageName + str;
        } else {
            str2 = str;
        }
        intent2.setClassName(MMApplicationContext.getPackageName(), str2);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent2, i2);
            g(context, str, intent);
            AppMethodBeat.o(133725);
            return;
        }
        Log.f("MicroMsg.PluginHelper", "context not activity, skipped");
        AppMethodBeat.o(133725);
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i2, MMActivity.a aVar) {
        String str2;
        AppMethodBeat.i(133726);
        String sourcePackageName = MMApplicationContext.getSourcePackageName();
        if (str.startsWith(".")) {
            str2 = sourcePackageName + str;
        } else {
            str2 = str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str2);
        mMActivity.mmStartActivityForResult(aVar, intent, i2);
        g(mMActivity, str, intent);
        AppMethodBeat.o(133726);
    }

    public static void a(MMFragmentActivity mMFragmentActivity, String str, Intent intent, int i2, MMFragmentActivity.b bVar) {
        String str2;
        AppMethodBeat.i(133727);
        String sourcePackageName = MMApplicationContext.getSourcePackageName();
        if (str.startsWith(".")) {
            str2 = sourcePackageName + str;
        } else {
            str2 = str;
        }
        intent.setClassName(MMApplicationContext.getPackageName(), str2);
        mMFragmentActivity.mmStartActivityForResult(bVar, intent, i2);
        g(mMFragmentActivity, str, intent);
        AppMethodBeat.o(133727);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i2) {
        AppMethodBeat.i(133728);
        intent.setClassName(MMApplicationContext.getPackageName(), str.startsWith(".") ? MMApplicationContext.getSourcePackageName() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i2);
            g(fragment.getActivity(), str, intent);
            AppMethodBeat.o(133728);
            return;
        }
        Log.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
        AppMethodBeat.o(133728);
    }

    public static void gsW() {
        AppMethodBeat.i(133730);
        com.tencent.mm.service.c.b("mm", true, bfS("mm"));
        AppMethodBeat.o(133730);
    }

    private static void l(Intent intent, String str) {
        AppMethodBeat.i(133731);
        com.tencent.mm.service.c.a(intent, str, true, bfS(str));
        AppMethodBeat.o(133731);
    }

    public static void startService(Intent intent) {
        AppMethodBeat.i(133732);
        l(intent, "mm");
        AppMethodBeat.o(133732);
    }

    public static void m(Intent intent, String str) {
        AppMethodBeat.i(263719);
        l(intent, str);
        AppMethodBeat.o(263719);
    }

    private static void n(Intent intent, String str) {
        AppMethodBeat.i(133734);
        com.tencent.mm.service.c.b(intent, str, true, bfS(str));
        AppMethodBeat.o(133734);
    }

    public static void bs(Intent intent) {
        AppMethodBeat.i(133735);
        n(intent, "mm");
        AppMethodBeat.o(133735);
    }

    public static void o(Intent intent, String str) {
        AppMethodBeat.i(263720);
        n(intent, str);
        AppMethodBeat.o(263720);
    }

    private static Intent bfS(String str) {
        AppMethodBeat.i(133739);
        Class cls = null;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1854767153:
                if (str.equals("support")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1335091396:
                if (str.equals("dexopt")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1140077378:
                if (str.equals("toolsmp")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3488:
                if (str.equals("mm")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3322030:
                if (str.equals("lite")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    c2 = 1;
                    break;
                }
                break;
            case 110545371:
                if (str.equals("tools")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1865400007:
                if (str.equals("sandbox")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2016254153:
                if (str.equals("exdevice")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                cls = ProcessService.MMProcessService.class;
                break;
            case 1:
                cls = ProcessService.PushProcessServicer.class;
                break;
            case 2:
                cls = ProcessService.DexOptProcessService.class;
                break;
            case 3:
                cls = ProcessService.ToolsProcessService.class;
                break;
            case 4:
                cls = ProcessService.ExDeviceProcessService.class;
                break;
            case 5:
                cls = ProcessService.SupportProcessService.class;
                break;
            case 6:
                cls = ProcessService.ToolsmpProcessService.class;
                break;
            case 7:
                cls = ProcessService.SandBoxProcessService.class;
                break;
            case '\b':
                cls = ProcessService.LiteProcessService.class;
                break;
        }
        Intent intent = new Intent(MMApplicationContext.getContext(), cls);
        AppMethodBeat.o(133739);
        return intent;
    }

    public static bd bfT(String str) {
        AppMethodBeat.i(133740);
        Log.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", str);
        d bfU = bfU(str);
        if (bfU == null) {
            Log.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", str);
            AppMethodBeat.o(133740);
            return null;
        }
        bd createSubCore = bfU.createSubCore();
        if (createSubCore == null) {
            Log.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", str);
            AppMethodBeat.o(133740);
            return null;
        }
        Log.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", str);
        AppMethodBeat.o(133740);
        return createSubCore;
    }

    public static void a(String str, m mVar, l lVar) {
        AppMethodBeat.i(133741);
        Log.d("MicroMsg.PluginHelper", "--> registerApplication: %s", str);
        d bfU = bfU(str);
        if (bfU == null) {
            Log.e("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.o(133741);
            return;
        }
        n createApplication = bfU.createApplication();
        if (createApplication == null) {
            Log.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.o(133741);
            return;
        }
        createApplication.a(lVar);
        createApplication.a(mVar);
        Log.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", str, mVar, lVar);
        AppMethodBeat.o(133741);
    }

    public static com.tencent.mm.pluginsdk.b.a ak(Context context, String str) {
        AppMethodBeat.i(133742);
        com.tencent.mm.pluginsdk.b.a W = W(context, str, null);
        AppMethodBeat.o(133742);
        return W;
    }

    public static com.tencent.mm.pluginsdk.b.a W(Context context, String str, String str2) {
        AppMethodBeat.i(133743);
        d bfU = bfU(str);
        if (bfU == null) {
            Log.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.o(133743);
            return null;
        }
        com.tencent.mm.pluginsdk.b.c contactWidgetFactory = bfU.getContactWidgetFactory();
        if (contactWidgetFactory == null) {
            Log.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.o(133743);
            return null;
        }
        com.tencent.mm.pluginsdk.b.a ak = contactWidgetFactory.ak(context, str2);
        AppMethodBeat.o(133743);
        return ak;
    }

    public static boolean gsX() {
        return false;
    }

    public static synchronized boolean aZU(String str) {
        boolean z;
        synchronized (c.class) {
            AppMethodBeat.i(133744);
            if (KxY.get(str) != null) {
                z = true;
                AppMethodBeat.o(133744);
            } else {
                z = false;
                AppMethodBeat.o(133744);
            }
        }
        return z;
    }

    private static synchronized d bfU(String str) {
        d dVar;
        synchronized (c.class) {
            AppMethodBeat.i(133745);
            try {
                dVar = bfV(str);
                AppMethodBeat.o(133745);
            } catch (ClassNotFoundException e2) {
                Log.e("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", str, e2.toString());
                dVar = null;
                AppMethodBeat.o(133745);
                return dVar;
            } catch (InstantiationException e3) {
                Log.e("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e3.toString());
                dVar = null;
                AppMethodBeat.o(133745);
                return dVar;
            } catch (IllegalAccessException e4) {
                Log.e("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e4.toString());
                dVar = null;
                AppMethodBeat.o(133745);
                return dVar;
            } catch (Exception e5) {
                Log.e("MicroMsg.PluginHelper", "plugin load failed UnknowException , plugin=%s, e:%s", str, e5.toString());
                dVar = null;
                AppMethodBeat.o(133745);
                return dVar;
            }
        }
        return dVar;
    }

    @Deprecated
    public static synchronized d a(String str, a aVar) {
        d dVar;
        synchronized (c.class) {
            AppMethodBeat.i(229800);
            String str2 = KxX.get(str);
            if (str2 != null) {
                Log.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, str2);
            }
            dVar = KxY.get(str);
            if (dVar != null) {
                aVar.onDone();
                AppMethodBeat.o(229800);
            } else {
                try {
                    dVar = bfV(str);
                    if (dVar != null) {
                        aVar.onDone();
                    }
                    AppMethodBeat.o(229800);
                } catch (Exception e2) {
                    try {
                        dVar = bfV(str);
                        if (dVar != null) {
                            aVar.onDone();
                        }
                        AppMethodBeat.o(229800);
                    } catch (ClassNotFoundException e3) {
                        Log.e("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", str, e3.toString());
                        try {
                            Log.w("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                            aVar.onDone();
                        } catch (Exception e4) {
                            Log.printErrStackTrace("MicroMsg.PluginHelper", e4, "", new Object[0]);
                        }
                        dVar = null;
                        AppMethodBeat.o(229800);
                        return dVar;
                    } catch (InstantiationException e5) {
                        Log.e("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e5.toString());
                        Log.w("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        aVar.onDone();
                        dVar = null;
                        AppMethodBeat.o(229800);
                        return dVar;
                    } catch (IllegalAccessException e6) {
                        Log.e("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e6.toString());
                        Log.w("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        aVar.onDone();
                        dVar = null;
                        AppMethodBeat.o(229800);
                        return dVar;
                    }
                }
            }
        }
        return dVar;
    }

    private static d bfV(String str) {
        AppMethodBeat.i(133747);
        d dVar = KxY.get(str);
        if (dVar != null) {
            AppMethodBeat.o(133747);
            return dVar;
        }
        d dVar2 = (d) MMApplicationContext.getContext().getClassLoader().loadClass(MMApplicationContext.getSourcePackageName() + ".plugin." + str + ".Plugin").newInstance();
        KxY.put(str, dVar2);
        AppMethodBeat.o(133747);
        return dVar2;
    }

    public static synchronized Class<?> mI(String str, String str2) {
        Class<?> cls;
        synchronized (c.class) {
            AppMethodBeat.i(133748);
            String str3 = KxX.get(str);
            if (str3 != null) {
                Log.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, str3);
            }
            if (!bfW(str)) {
                Log.e("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                AppMethodBeat.o(133748);
                cls = null;
            } else {
                String str4 = MMApplicationContext.getSourcePackageName() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str4 + str2;
                }
                try {
                    cls = MMApplicationContext.getContext().getClassLoader().loadClass(str2);
                    AppMethodBeat.o(133748);
                } catch (Exception e2) {
                    Log.e("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                    AppMethodBeat.o(133748);
                    cls = null;
                }
            }
        }
        return cls;
    }

    public static synchronized boolean bfW(String str) {
        boolean z;
        synchronized (c.class) {
            AppMethodBeat.i(133749);
            if (bfU(str) != null) {
                z = true;
                AppMethodBeat.o(133749);
            } else {
                z = false;
                AppMethodBeat.o(133749);
            }
        }
        return z;
    }

    public static void a(final Fragment fragment, final String str, final String str2, final Intent intent, final int i2) {
        AppMethodBeat.i(133723);
        Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        AnonymousClass4 r0 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass4 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133699);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(MMApplicationContext.getPackageName(), str2.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str2 : str2);
                fragment.startActivityForResult(intent, i2);
                c.g(fragment.getActivity(), str2, intent);
                AppMethodBeat.o(133699);
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass5 */
        };
        a(str, r0);
        AppMethodBeat.o(133723);
    }

    public static void a(final b bVar, final String str, final String str2, final Intent intent, final int i2, final a aVar) {
        AppMethodBeat.i(133729);
        Log.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        AnonymousClass2 r0 = new a() {
            /* class com.tencent.mm.br.c.AnonymousClass2 */

            @Override // com.tencent.mm.br.a
            public final void onDone() {
                AppMethodBeat.i(133697);
                Intent intent = intent == null ? new Intent() : intent;
                if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str)) {
                    intent.setClassName(MMApplicationContext.getPackageName(), str2.startsWith(".") ? (MMApplicationContext.getSourcePackageName() + ".plugin." + str) + str2 : str2);
                }
                bVar.a(intent, i2, aVar);
                c.g(bVar.getContext(), str2, intent);
                AppMethodBeat.o(133697);
            }
        };
        new Object() {
            /* class com.tencent.mm.br.c.AnonymousClass3 */
        };
        a(str, r0);
        AppMethodBeat.o(133729);
    }

    public static boolean a(Intent intent, ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(133737);
        boolean a2 = com.tencent.mm.service.c.a(intent, serviceConnection, 1, str, true, bfS(str));
        AppMethodBeat.o(133737);
        return a2;
    }

    public static void a(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(133738);
        com.tencent.mm.service.c.a(serviceConnection, str, true, bfS(str));
        AppMethodBeat.o(133738);
    }
}
