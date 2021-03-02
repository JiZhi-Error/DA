package com.tencent.mm.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiUpdateReceiver extends BroadcastReceiver {
    public static String ACTION = "com.tencent.mm.Emoji_Update";
    public static String KEY_TYPE = "type";
    public static String hdn = "update_all_custom_emoji";
    public static String hdo = "update_download_custom_emoji";
    public static String hdp = "update_store_emoji";
    public static String hdq = "update_group_info";
    public static String hdr = "update_capture_emoji";
    public static String hds = "update_emoji_download";
    public static String hdt = "update_sticker_download";

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(104486);
        String action = intent.getAction();
        if (ACTION.equals(action)) {
            String stringExtra = intent.getStringExtra(KEY_TYPE);
            Log.i("MicroMsg.EmojiUpdateReceiver", "receive %s, %s", action, stringExtra);
            if (hdn.equals(stringExtra)) {
                j.auL().dV(false);
                EventCenter.instance.publish(new rj());
                AppMethodBeat.o(104486);
                return;
            } else if (hdo.equals(stringExtra)) {
                j.auL().dW(false);
                EventCenter.instance.publish(new rj());
                AppMethodBeat.o(104486);
                return;
            } else if (hdp.equals(stringExtra)) {
                j.auL().gXh = true;
                EventCenter.instance.publish(new rj());
                AppMethodBeat.o(104486);
                return;
            } else if (hdq.equals(stringExtra)) {
                j.auL().dX(false);
                EventCenter.instance.publish(new rj());
                AppMethodBeat.o(104486);
                return;
            } else if (hdr.equals(stringExtra)) {
                j.auL().dY(false);
                EventCenter.instance.publish(new rj());
                AppMethodBeat.o(104486);
                return;
            } else if (hds.equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("md5");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                Log.i("MicroMsg.EmojiUpdateReceiver", "onReceive: %s, %s, %s", stringExtra, stringExtra2, Boolean.valueOf(booleanExtra));
                e eVar = e.gVM;
                e.s(stringExtra2, booleanExtra);
                AppMethodBeat.o(104486);
                return;
            } else if (hdt.equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("task_key");
                boolean booleanExtra2 = intent.getBooleanExtra("result", false);
                Log.i("MicroMsg.EmojiUpdateReceiver", "sticker download %s, %s", stringExtra3, Boolean.valueOf(booleanExtra2));
                com.tencent.mm.sticker.loader.e eVar2 = com.tencent.mm.sticker.loader.e.NNN;
                com.tencent.mm.sticker.loader.e.dh(stringExtra3, booleanExtra2);
            }
        }
        AppMethodBeat.o(104486);
    }
}
