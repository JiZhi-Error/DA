package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.emojicapture.api.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class b {
    public static void b(Context context, int i2, String str) {
        AppMethodBeat.i(104403);
        b(context, null, i2, null, str);
        AppMethodBeat.o(104403);
    }

    public static void w(Context context, String str, String str2) {
        AppMethodBeat.i(104404);
        b(context, str, Util.isNullOrNil(str) ? 2 : 1, null, str2);
        AppMethodBeat.o(104404);
    }

    public static void ax(Context context, String str) {
        AppMethodBeat.i(104405);
        b(context, null, 0, str, "");
        AppMethodBeat.o(104405);
    }

    private static void b(final Context context, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(104406);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = !Util.isNullOrNil(str);
        boolean isStickerEnable = ((a) g.ah(a.class)).isStickerEnable();
        int stickerRecommendCount = ((a) g.ah(a.class)).stickerRecommendCount();
        if (i2 == 1 || i2 == 6) {
            h.INSTANCE.a(15982, 2, Long.valueOf(currentTimeMillis), 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(i2), "", 0, 0, 0, "", 0, Integer.valueOf(stickerRecommendCount));
        } else if (i2 == 2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            h.INSTANCE.a(15982, 1, Long.valueOf(currentTimeMillis), 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(i2), "", 0, Long.valueOf(currentTimeMillis2 - g.aAh().azQ().a(ar.a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, currentTimeMillis2)), 0, "", 0, Integer.valueOf(stickerRecommendCount));
        }
        try {
            final Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
            intent.putExtra("key_video_params", e.baZ().bba());
            intent.putExtra("key_enter_time", currentTimeMillis);
            intent.putExtra("enter_scene", i2);
            intent.putExtra("key_capture_max_duration", com.tencent.mm.n.h.aqJ().getInt("EmoticonCameraCaptureMaxDuration", 5));
            if (z) {
                intent.putExtra("key_imitated_md5", str);
            }
            intent.putExtra("sticker_enable", isStickerEnable);
            if (str2 != null) {
                intent.putExtra("lens_id", str2);
            }
            intent.putExtra(ch.COL_USERNAME, str3);
            ((a) g.ah(a.class)).preCheck(context, i2, new a.AbstractC0965a() {
                /* class com.tencent.mm.plugin.emojicapture.api.b.AnonymousClass1 */
                final /* synthetic */ int val$requestCode = 1111;

                @Override // com.tencent.mm.plugin.emojicapture.api.a.AbstractC0965a
                public final void ha(boolean z) {
                    AppMethodBeat.i(104401);
                    if (z) {
                        if (context instanceof Activity) {
                            ((Activity) context).startActivityForResult(intent, this.val$requestCode);
                            AppMethodBeat.o(104401);
                            return;
                        } else if (context instanceof ContextThemeWrapper) {
                            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                            if (baseContext instanceof Activity) {
                                ((Activity) baseContext).startActivityForResult(intent, this.val$requestCode);
                                AppMethodBeat.o(104401);
                                return;
                            }
                            Context context = context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(104401);
                            return;
                        } else {
                            Context context2 = context;
                            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context2.startActivity((Intent) bl2.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    }
                    AppMethodBeat.o(104401);
                }
            });
            AppMethodBeat.o(104406);
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", e2, "takeEmojiCapture failed", new Object[0]);
            AppMethodBeat.o(104406);
        }
    }

    public static void fa(Context context) {
        AppMethodBeat.i(104407);
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI"));
            intent.putExtra("sticker_url", (String) null);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(104407);
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", e2, "start sticker preview failed", new Object[0]);
            AppMethodBeat.o(104407);
        }
    }
}
