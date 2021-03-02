package com.tencent.mm.plugin.priority.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public static boolean AYj = false;

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        double[] jr;
        AppMethodBeat.i(87797);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(87797);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(87797);
            return true;
        } else {
            String str2 = strArr[1];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1796087539:
                    if (str2.equals("printrate")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1424659792:
                    if (str2.equals("enabledebug")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1354714445:
                    if (str2.equals("copydb")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 66125101:
                    if (str2.equals("outlimit")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 819712873:
                    if (str2.equals("deletedb")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Log.i("MicroMsg.Priority.PriorityCommand", "copydb");
                    g.aAi();
                    String z = aa.z(new o(g.aAh().cachePath, "MicroMsgPriority.db").her());
                    s.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
                    s.nw(z, "/sdcard/tencent/MicroMsg/Download/priority.db");
                    break;
                case 1:
                    Log.i("MicroMsg.Priority.PriorityCommand", "deletedb");
                    g.aAi();
                    s.deleteFile(aa.z(new o(g.aAh().cachePath, "MicroMsgPriority.db").her()));
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    break;
                case 2:
                    Log.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", strArr[2]);
                    try {
                        AYj = strArr[2].equals("1");
                        break;
                    } catch (Exception e2) {
                        AYj = false;
                        break;
                    }
                case 3:
                    if (strArr.length <= 2 || !ab.Eq(str)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        if (ab.Eq(str)) {
                            double[] jr2 = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(str, "@all");
                            for (dou dou : ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().aKe(str)) {
                                stringBuffer.append("\n");
                                stringBuffer.append(((b) g.af(b.class)).getDisplayName(dou.MRZ));
                                stringBuffer.append("[");
                                stringBuffer.append(dou.MRZ);
                                stringBuffer.append("][");
                                stringBuffer.append(f.formatTime("yyyy-MM-dd", dou.MSa / 1000));
                                stringBuffer.append("]");
                                stringBuffer.append(String.format("%.2f %.2f %.2f %d", Float.valueOf(dou.MSh), Float.valueOf(dou.MSi), Float.valueOf(dou.MSj), Integer.valueOf(dou.MSf)));
                            }
                            jr = jr2;
                        } else {
                            jr = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(str, str);
                        }
                        String format = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", Double.valueOf(jr[0]), Double.valueOf(jr[1]), Double.valueOf(jr[2]), stringBuffer.toString());
                        Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", format);
                        D(context, format);
                        break;
                    } else {
                        double[] jr3 = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(str, strArr[2]);
                        String format2 = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", strArr[2], ((b) g.af(b.class)).getDisplayName(strArr[2]), Double.valueOf(jr3[0]), Double.valueOf(jr3[1]), Double.valueOf(jr3[2]));
                        Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", format2);
                        D(context, format2);
                        break;
                    }
                case 4:
                    try {
                        long longValue = Long.valueOf(strArr[2]).longValue();
                        Log.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", Long.valueOf(longValue));
                        g.aAh().azQ().set(ar.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(longValue));
                        break;
                    } catch (Exception e3) {
                        break;
                    }
            }
            AppMethodBeat.o(87797);
            return true;
        }
    }

    private static void D(Context context, String str) {
        AppMethodBeat.i(87798);
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
        AppMethodBeat.o(87798);
    }
}
