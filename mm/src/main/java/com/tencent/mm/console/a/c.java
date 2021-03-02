package com.tencent.mm.console.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import java.io.IOException;
import java.util.Iterator;

public final class c implements a {
    static {
        AppMethodBeat.i(20174);
        b.a(new c(), "//fts");
        AppMethodBeat.o(20174);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20172);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(20172);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(20172);
            return true;
        } else {
            String str2 = strArr[1];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1354714445:
                    if (str2.equals("copydb")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1183792455:
                    if (str2.equals("insert")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -1132164145:
                    if (str2.equals("clearconfig")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -926188360:
                    if (str2.equals("setcorrupttime")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -617644996:
                    if (str2.equals("clearunread")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3237038:
                    if (str2.equals("info")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 104187309:
                    if (str2.equals("msbiz")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 648505237:
                    if (str2.equals("dismisskey")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 819712873:
                    if (str2.equals("deletedb")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 955180557:
                    if (str2.equals("corrupt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 967115467:
                    if (str2.equals("inserttest")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 1873247692:
                    if (str2.equals("addchatroomcontact")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    crh fYi = am.fYi();
                    StringBuilder sb = new StringBuilder();
                    Iterator<crg> it = fYi.oTA.iterator();
                    while (it.hasNext()) {
                        crg next = it.next();
                        sb.append(String.format("%s | %.2f | %s", aa.getDisplayName(next.Username), Double.valueOf(next.Mww), f.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, next.Mwx / 1000)));
                        sb.append("\n");
                    }
                    D(context, sb.toString());
                    break;
                case 1:
                    bg.aVF();
                    o oVar = new o(com.tencent.mm.model.c.azM(), "FTS5IndexMicroMsg_encrypt.db");
                    if (oVar.exists()) {
                        oVar.delete();
                    }
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    break;
                case 2:
                    bg.aVF();
                    o oVar2 = new o(com.tencent.mm.model.c.azM(), "FTS5IndexMicroMsg_encrypt.db");
                    o oVar3 = new o("/sdcard/IndexMicroMsg.db");
                    if (oVar3.exists()) {
                        oVar3.delete();
                    }
                    s.nw(com.tencent.mm.vfs.aa.z(oVar2.her()), com.tencent.mm.vfs.aa.z(oVar3.her()));
                    break;
                case 3:
                    try {
                        ((PluginFTS) g.ah(PluginFTS.class)).getDatabaseErrorHandler().onCorruption(null);
                        break;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.CommandTestFTS", e2, "corrupt command", new Object[0]);
                        break;
                    }
                case 4:
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, (Object) 5);
                    break;
                case 5:
                    j jVar = new j();
                    jVar.query = strArr[2];
                    jVar.kXb = 65523;
                    ((n) g.ah(n.class)).search(10000, jVar);
                    break;
                case 6:
                    ar.a[] aVarArr = {ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING, ar.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING};
                    for (int i2 = 0; i2 < 26; i2++) {
                        ar.a aVar = aVarArr[i2];
                        bg.aVF();
                        com.tencent.mm.model.c.azQ().set(aVar, "");
                    }
                    break;
                case 7:
                    o oVar4 = new o(com.tencent.mm.plugin.fts.a.c.wUX, "FTS5IndexMicroMsgInfo.txt");
                    if (oVar4.exists()) {
                        try {
                            D(context, s.boY(com.tencent.mm.vfs.aa.z(oVar4.her())));
                            break;
                        } catch (IOException e3) {
                            break;
                        }
                    }
                    break;
                case '\b':
                    j jVar2 = new j();
                    jVar2.kXb = ShareElfFile.SectionHeader.SHN_ABS;
                    jVar2.wWW = 100;
                    if (strArr.length > 2) {
                        try {
                            jVar2.wWW = Integer.valueOf(strArr[2]).intValue();
                        } catch (Exception e4) {
                        }
                    }
                    if (strArr.length > 3) {
                        jVar2.talker = strArr[3];
                    }
                    ((n) g.ah(n.class)).search(10000, jVar2);
                    break;
                case '\t':
                    j jVar3 = new j();
                    jVar3.kXb = 65524;
                    ((n) g.ah(n.class)).search(10000, jVar3);
                    break;
                case '\n':
                    j jVar4 = new j();
                    jVar4.kXb = 65525;
                    ((n) g.ah(n.class)).search(10000, jVar4);
                    break;
                case 11:
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_ENCRYPT_PWD_STRING_SYNC, "test_key_" + System.currentTimeMillis());
                    com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj2 = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a3.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/console/command/FTSCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    break;
            }
            AppMethodBeat.o(20172);
            return true;
        }
    }

    private static void D(Context context, String str) {
        AppMethodBeat.i(20173);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.FG_0));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(20173);
    }
}
