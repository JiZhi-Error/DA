package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.br.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24567);
        super.onCreate(bundle);
        Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.layout.yq);
        Intent intent = new Intent();
        int Q = u.Q(u.PWR, 64, 16384);
        u.ll(Q, 1);
        intent.putExtra("list_attr", Q);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.string.g4));
        intent.putExtra("block_contact", z.aTY());
        c.c(this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(24567);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(24568);
        super.onActivityResult(i2, i3, intent);
        Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", Integer.valueOf(i3));
        if (i3 != -1) {
            finish();
            AppMethodBeat.o(24568);
            return;
        }
        switch (i2) {
            case 1:
                if (intent != null) {
                    if (bg.aAc()) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        ArrayList<String> stringsToList = !Util.isNullOrNil(stringExtra) ? Util.stringsToList(stringExtra.split(",")) : null;
                        if (stringsToList == null || stringsToList.size() <= 0) {
                            Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                            break;
                        } else {
                            Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + stringsToList.size());
                            String aTY = z.aTY();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[stringsToList.size()];
                                for (int i4 = 0; i4 < stringsToList.size(); i4++) {
                                    bg.aVF();
                                    as Kn = com.tencent.mm.model.c.aSN().Kn(stringsToList.get(i4));
                                    if (Kn == null || ((int) Kn.gMZ) <= 0) {
                                        Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        AppMethodBeat.o(24568);
                                        return;
                                    }
                                    String agZ = b.agZ(stringsToList.get(i4));
                                    if (Util.isNullOrNil(agZ)) {
                                        Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        AppMethodBeat.o(24568);
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", b.SOURCE_KEY);
                                    contentValues.put("owner_id", b.agZ(aTY));
                                    contentValues.put("unique_id", agZ);
                                    contentValues.put("container", (Integer) 1);
                                    contentValues.put("item_type", Integer.valueOf(b.Q(Kn)));
                                    contentValues.put("name", aa.b(Kn, stringsToList.get(i4)));
                                    p.aYn();
                                    contentValues.put("icon_path", e.M(stringsToList.get(i4), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", agZ);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i4] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.sPa, contentValuesArr);
                                Toast.makeText(this, (int) R.string.c3y, 0).show();
                                com.tencent.mm.plugin.extqlauncher.b.cSI().cSJ();
                                break;
                            } catch (Exception e2) {
                                Log.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", e2.getMessage());
                                Log.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e2, "", new Object[0]);
                                Toast.makeText(this, (int) R.string.c3x, 0).show();
                                break;
                            }
                        }
                    } else {
                        Log.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                        Toast.makeText(this, (int) R.string.c3x, 0).show();
                        finish();
                        AppMethodBeat.o(24568);
                        return;
                    }
                }
                break;
        }
        finish();
        AppMethodBeat.o(24568);
    }
}
