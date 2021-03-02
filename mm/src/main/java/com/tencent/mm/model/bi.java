package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;

public final class bi {
    public static SharedPreferences aVK() {
        AppMethodBeat.i(132249);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            e.INSTANCE.idkeyStat(148, 12, 1, true);
            an anVar = new an(ar.NSe + "autoauth.cfg");
            if (anVar.NRI || anVar.get(3) == null) {
                SharedPreferences sharedPreferences2 = MMApplicationContext.getContext().getSharedPreferences("auto_auth_key_prefs", g.aps());
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (!Util.isNullOrNil(sharedPreferences2.getString("_auth_key", ""))) {
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                    edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                    edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", ""));
                    edit.putString("server_id", MMApplicationContext.getContext().getSharedPreferences("server_id_prefs", g.aps()).getString("server_id", ""));
                    Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(edit.commit()), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                } else {
                    Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", Util.getStack());
                }
            } else {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) anVar.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) anVar.get(2)).intValue());
                edit2.putString("_auth_key", (String) anVar.get(3));
                edit2.putString("server_id", (String) anVar.get(4));
                Log.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(edit2.commit()), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                e.INSTANCE.idkeyStat(148, 51, 1, true);
                AppMethodBeat.o(132249);
                return sharedPreferences;
            }
        }
        AppMethodBeat.o(132249);
        return sharedPreferences;
    }
}
