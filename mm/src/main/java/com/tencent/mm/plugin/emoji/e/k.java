package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k {
    public static void a(Context context, EmotionSummary emotionSummary, int i2, int i3, int i4, String str, int i5) {
        AppMethodBeat.i(108534);
        a(context, emotionSummary, i2, i3, i4, str, i5, null);
        AppMethodBeat.o(108534);
    }

    public static void a(Context context, EmotionSummary emotionSummary, int i2, int i3, int i4, String str, int i5, as asVar) {
        AppMethodBeat.i(108535);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (emotionSummary != null) {
            intent.putExtra("extra_id", emotionSummary.ProductID);
            intent.putExtra("extra_name", emotionSummary.PackName);
            intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
            intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
            intent.putExtra("extra_description", emotionSummary.PackDesc);
            intent.putExtra("extra_price", emotionSummary.PackPrice);
            intent.putExtra("extra_type", emotionSummary.PackType);
            intent.putExtra("extra_flag", emotionSummary.PackFlag);
            intent.putExtra("preceding_scence", i5);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i2);
            if (asVar != null) {
                intent.putExtra("action_report", asVar.abV());
            }
            if (i3 != -1) {
                intent.putExtra("extra_status", i3);
            }
            if (i4 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!Util.isNullOrNil(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailBySummary", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionSummary;ZIIILjava/lang/String;ILcom/tencent/mm/autogen/mmdata/rpt/EmoticonStoreActionStruct;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108535);
    }

    private static void a(Context context, EmotionBannerSet emotionBannerSet, int i2, int i3) {
        AppMethodBeat.i(108536);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", emotionBannerSet.ProductID);
        intent.putExtra("extra_name", emotionBannerSet.Title);
        intent.putExtra("extra_description", emotionBannerSet.Desc);
        intent.putExtra("preceding_scence", i3);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i2);
        intent.putExtra("check_clickflag", true);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startDetailByBannerSet", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;ZII)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108536);
    }

    public static void a(Context context, EmotionBannerSet emotionBannerSet, boolean z) {
        AppMethodBeat.i(108537);
        if (emotionBannerSet == null) {
            Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            AppMethodBeat.o(108537);
            return;
        }
        switch (emotionBannerSet.SetType) {
            case 0:
                Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                h.INSTANCE.a(13223, 1, Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, 0, 0);
                AppMethodBeat.o(108537);
                return;
            case 1:
                if (z) {
                    a(context, emotionBannerSet, 15, 8);
                } else {
                    a(context, emotionBannerSet, 3, 5);
                }
                h.INSTANCE.a(13223, 1, Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, 0, 4);
                AppMethodBeat.o(108537);
                return;
            case 2:
                v(context, emotionBannerSet.LocateUrl, emotionBannerSet.Title);
                h.INSTANCE.a(13223, 1, Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, 0, 3);
                AppMethodBeat.o(108537);
                return;
            case 3:
                a(context, emotionBannerSet.ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl, z);
                h.INSTANCE.a(13223, 1, Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, 0, 2);
                AppMethodBeat.o(108537);
                return;
            case 4:
                a(context, emotionBannerSet.ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl);
                h.INSTANCE.a(13223, 1, Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, 0, 1);
                AppMethodBeat.o(108537);
                return;
            default:
                Log.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", Integer.valueOf(emotionBannerSet.SetType));
                AppMethodBeat.o(108537);
                return;
        }
    }

    private static void a(Context context, int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(108538);
        Intent intent = new Intent();
        intent.putExtra("set_id", i2);
        intent.putExtra("headurl", str4);
        intent.putExtra("set_title", str);
        intent.putExtra("set_iconURL", str3);
        intent.putExtra("set_desc", str2);
        intent.setClass(context, EmojiStoreV2SingleProductUI.class);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmojiList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmojiList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108538);
    }

    private static void a(Context context, int i2, String str, String str2, String str3, String str4, boolean z) {
        AppMethodBeat.i(108539);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreTopicUI.class);
        intent.putExtra("topic_id", i2);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_desc", str2);
        if (z) {
            intent.putExtra("extra_scence", 15);
        } else {
            intent.putExtra("extra_scence", 3);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiUINavigatorMgr", "startEmotionList", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108539);
    }

    private static void v(Context context, String str, String str2) {
        AppMethodBeat.i(108540);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        c.jRt.i(intent, context);
        AppMethodBeat.o(108540);
    }
}
