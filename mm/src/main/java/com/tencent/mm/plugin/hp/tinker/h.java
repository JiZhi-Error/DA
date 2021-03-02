package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class h {
    public static void gn(Context context) {
        AppMethodBeat.i(117504);
        ai(context, com.tencent.mm.n.h.aqJ().getInt("TinkerCheckUpdateInterval", 12));
        AppMethodBeat.o(117504);
    }

    private static void ai(Context context, int i2) {
        AppMethodBeat.i(117505);
        if (i2 < 0) {
            Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            AppMethodBeat.o(117505);
            return;
        }
        Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", Integer.valueOf(i2));
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i2).apply();
        AppMethodBeat.o(117505);
    }

    public static boolean aU(Context context, String str) {
        AppMethodBeat.i(117502);
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        Log.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", string, str);
        if (WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(117502);
            return false;
        } else if (Util.isNullOrNil(string) || Util.isNullOrNil(str) || !string.equalsIgnoreCase(str)) {
            AppMethodBeat.o(117502);
            return false;
        } else {
            AppMethodBeat.o(117502);
            return true;
        }
    }

    public static void aV(Context context, String str) {
        AppMethodBeat.i(117503);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
        AppMethodBeat.o(117503);
    }

    public static void aW(Context context, String str) {
        AppMethodBeat.i(196797);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", str).apply();
        AppMethodBeat.o(196797);
    }

    public static void aX(Context context, String str) {
        AppMethodBeat.i(196798);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", str).apply();
        AppMethodBeat.o(196798);
    }

    public static int go(Context context) {
        AppMethodBeat.i(117506);
        int i2 = context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
        AppMethodBeat.o(117506);
        return i2;
    }

    public static void aY(Context context, String str) {
        AppMethodBeat.i(117507);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_node", str).apply();
        AppMethodBeat.o(117507);
    }

    public static void aj(Context context, int i2) {
        AppMethodBeat.i(117508);
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("tinker_node_retry_time", i2).apply();
        AppMethodBeat.o(117508);
    }
}
