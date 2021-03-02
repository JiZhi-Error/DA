package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aj;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import java.util.HashMap;
import java.util.Map;

public final class x {
    private static final Map<String, Object> JVH = new HashMap();

    public static final class a {
        private static boolean JVI = false;

        static {
            AppMethodBeat.i(133684);
            Log.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
            aj.a(MMApplicationContext.getContext(), new IXWebLogClient() {
                /* class com.tencent.mm.pluginsdk.model.x.a.AnonymousClass1 */

                @Override // com.tencent.xweb.util.IXWebLogClient
                public final void i(String str, String str2) {
                    AppMethodBeat.i(133671);
                    Log.i(str, str2);
                    AppMethodBeat.o(133671);
                }

                @Override // com.tencent.xweb.util.IXWebLogClient
                public final void e(String str, String str2) {
                    AppMethodBeat.i(133672);
                    Log.e(str, str2);
                    AppMethodBeat.o(133672);
                }

                @Override // com.tencent.xweb.util.IXWebLogClient
                public final void w(String str, String str2) {
                    AppMethodBeat.i(133673);
                    Log.w(str, str2);
                    AppMethodBeat.o(133673);
                }

                @Override // com.tencent.xweb.util.IXWebLogClient
                public final void d(String str, String str2) {
                    AppMethodBeat.i(133674);
                    Log.d(str, str2);
                    AppMethodBeat.o(133674);
                }

                @Override // com.tencent.xweb.util.IXWebLogClient
                public final void v(String str, String str2) {
                    AppMethodBeat.i(133675);
                    Log.v(str, str2);
                    AppMethodBeat.o(133675);
                }
            });
            AppMethodBeat.o(133684);
        }

        public static void iq(final Context context) {
            AppMethodBeat.i(133677);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.pluginsdk.model.x.a.AnonymousClass2 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(133676);
                    Looper.myQueue().removeIdleHandler(this);
                    a.ir(context);
                    AppMethodBeat.o(133676);
                    return false;
                }
            });
            AppMethodBeat.o(133677);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void ir(android.content.Context r14) {
            /*
            // Method dump skipped, instructions count: 347
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.x.a.ir(android.content.Context):void");
        }

        public static void ahJ(int i2) {
            AppMethodBeat.i(133679);
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", i2);
            c.m(intent, "sandbox");
            Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
            AppMethodBeat.o(133679);
        }

        public static void gmH() {
            AppMethodBeat.i(133680);
            zK(false);
            AppMethodBeat.o(133680);
        }

        public static void zK(boolean z) {
            AppMethodBeat.i(182769);
            if (ChannelUtil.isGPVersion()) {
                Log.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
                AppMethodBeat.o(182769);
                return;
            }
            if (f.lE(MMApplicationContext.getContext()) && WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                intent.putExtra("intent_extra_download_ignore_network_type", z);
                c.m(intent, "sandbox");
                Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
            AppMethodBeat.o(182769);
        }

        public static boolean gmI() {
            AppMethodBeat.i(133681);
            boolean isDownloading = f.isDownloading();
            boolean tBSInstalling = d.getTBSInstalling();
            boolean z = JVI;
            if (isDownloading || tBSInstalling || z) {
                AppMethodBeat.o(133681);
                return true;
            }
            AppMethodBeat.o(133681);
            return false;
        }

        public static void zL(boolean z) {
            JVI = z;
        }

        public static int gmJ() {
            AppMethodBeat.i(133682);
            if (com.tencent.mm.compatible.util.d.oD(19) || com.tencent.mm.compatible.util.d.oE(16)) {
                AppMethodBeat.o(133682);
                return 1;
            } else if (WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext()) > 0) {
                AppMethodBeat.o(133682);
                return 4;
            } else if (f.isDownloading()) {
                AppMethodBeat.o(133682);
                return 2;
            } else if (d.getTBSInstalling()) {
                AppMethodBeat.o(133682);
                return 3;
            } else {
                boolean z = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false);
                Log.i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(z));
                if (z) {
                    AppMethodBeat.o(133682);
                    return 2;
                }
                Log.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
                AppMethodBeat.o(133682);
                return 0;
            }
        }

        public static void gmK() {
            AppMethodBeat.i(133683);
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            c.m(intent, "sandbox");
            Log.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
            AppMethodBeat.o(133683);
        }
    }

    static {
        AppMethodBeat.i(133686);
        AppMethodBeat.o(133686);
    }

    public static void E(String str, Object obj) {
        AppMethodBeat.i(133685);
        JVH.put(str, obj);
        d.initTbsSettings(JVH);
        AppMethodBeat.o(133685);
    }

    public static void gmG() {
        AppMethodBeat.i(229795);
        Log.i("MicroMsg.TBSHelper", "checkDisableSensitiveApi uin = %d", Integer.valueOf(com.tencent.mm.kernel.a.azs()));
        AppMethodBeat.o(229795);
    }
}
