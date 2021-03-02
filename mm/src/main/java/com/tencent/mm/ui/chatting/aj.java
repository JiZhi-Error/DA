package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj {
    List<ca> PgD;
    private String Pkb = null;
    String Pkc = null;
    ArrayList<Uri> Pkd = new ArrayList<>();
    private Context context;
    private as dSh = null;
    private SimpleDateFormat oMZ = new SimpleDateFormat("yyyy-MM-dd");

    public aj(Context context2, List<ca> list, as asVar) {
        AppMethodBeat.i(34842);
        this.context = context2;
        this.PgD = list;
        this.dSh = asVar;
        AppMethodBeat.o(34842);
    }

    public final String gOl() {
        String str;
        String str2;
        AppMethodBeat.i(34843);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.Pkc == null);
        objArr[1] = Integer.valueOf(this.PgD.size());
        Log.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", objArr);
        if (this.Pkc != null) {
            String str3 = this.Pkc;
            AppMethodBeat.o(34843);
            return str3;
        }
        this.Pkd.clear();
        StringBuilder sb = new StringBuilder();
        sb.append(gOm());
        sb.append("\n\n");
        for (ca caVar : this.PgD) {
            if (this.Pkb == null) {
                this.Pkb = Ns(caVar.field_createTime);
                sb.append(String.format("—————  %s  —————\n\n", this.Pkb));
                sb.append("\n");
            } else {
                String Ns = Ns(caVar.field_createTime);
                if (!Ns.equals(this.Pkb)) {
                    this.Pkb = Ns;
                    sb.append(String.format("—————  %s  —————\n\n", this.Pkb));
                    sb.append("\n");
                }
            }
            if (caVar.isText()) {
                if (!caVar.isText()) {
                    str2 = null;
                } else if (caVar.field_isSend == 1) {
                    str2 = String.format("%s\n\n%s\n\n", bE(caVar), caVar.field_content);
                } else if (!ab.Eq(this.dSh.field_username)) {
                    str2 = String.format("%s\n\n%s\n\n", bE(caVar), caVar.field_content);
                } else {
                    int Kp = bp.Kp(caVar.field_content);
                    str2 = Kp != -1 ? String.format("%s\n\n%s\n\n", bE(caVar), caVar.field_content.substring(Kp + 1).trim()) : null;
                }
                sb.append(str2);
            } else if (caVar.gAz()) {
                if (caVar.gAz()) {
                    long j2 = caVar.field_msgId;
                    long j3 = caVar.field_msgSvrId;
                    String cf = ad.cf(caVar.field_talker, j2);
                    if (Util.isNullOrNil(cf)) {
                        cf = ad.cg(caVar.field_talker, j3);
                    }
                    Log.d("MicroMsg.OtherMailHistoryExporter", "imgPath[%s]", cf);
                    if (!Util.isNullOrNil(cf)) {
                        o oVar = new o(cf);
                        this.Pkd.add(FileProviderHelper.getUriForFile(this.context, oVar));
                        str = String.format("%s\n\n%s\n\n", bE(caVar), String.format("[%s: %s(%s)]", this.context.getString(R.string.bqu), oVar.getName(), this.context.getString(R.string.bqq)));
                        sb.append(str);
                    }
                }
                str = null;
                sb.append(str);
            } else if (caVar.dOQ()) {
                k.b HD = k.b.HD(caVar.field_content);
                if (HD == null || !(HD.type == 53 || HD.type == 57)) {
                    sb.append(bD(caVar));
                } else {
                    sb.append((HD == null || !(HD.type == 53 || HD.type == 57)) ? null : String.format("%s\n\n%s\n\n", bE(caVar), HD.title));
                }
            } else {
                sb.append(bD(caVar));
            }
        }
        sb.append("\n\n");
        this.Pkc = sb.toString();
        String str4 = this.Pkc;
        AppMethodBeat.o(34843);
        return str4;
    }

    private String gOm() {
        String arI;
        String format;
        AppMethodBeat.i(34844);
        if (!ab.Eq(this.dSh.field_username)) {
            String string = this.context.getString(R.string.gk0);
            bg.aVF();
            format = String.format(string, this.dSh.arI(), c.azQ().get(4, (Object) null));
        } else {
            if (Util.isNullOrNil(this.dSh.field_nickname)) {
                String str = "";
                Iterator<String> it = v.Ic(this.dSh.field_username).iterator();
                while (it.hasNext()) {
                    str = str + aa.getDisplayName(it.next()) + ", ";
                }
                arI = str.substring(0, str.length() - 2);
            } else {
                arI = this.dSh.arI();
            }
            format = String.format(this.context.getString(R.string.gjz), arI);
        }
        AppMethodBeat.o(34844);
        return format;
    }

    private String bD(ca caVar) {
        AppMethodBeat.i(34845);
        String str = null;
        if (caVar.gAy()) {
            str = String.format("[%s]", this.context.getString(R.string.bqz));
        } else if (caVar.gDh()) {
            str = caVar.field_isSend == 1 ? this.context.getString(R.string.bqx) : this.context.getString(R.string.bqw);
        } else if (caVar.dOS()) {
            ly lyVar = new ly();
            lyVar.dRv.dRq = 1;
            lyVar.dRv.dCM = caVar;
            EventCenter.instance.publish(lyVar);
            str = String.format("[%s]", lyVar.dRw.dNk);
        } else if (caVar.dOQ()) {
            k.b HD = k.b.HD(Util.processXml(caVar.field_content));
            if (HD != null) {
                switch (HD.type) {
                    case 4:
                    case 6:
                        com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                        if (bdx != null) {
                            o oVar = new o(bdx.field_fileFullPath);
                            if (oVar.exists()) {
                                this.Pkd.add(FileProviderHelper.getUriForFile(this.context, oVar));
                                break;
                            }
                        }
                        break;
                }
                g o = h.o(HD.appId, true, false);
                if (o == null) {
                    str = "";
                } else {
                    String str2 = o.field_appName;
                    str = 6 == HD.type ? String.format("[%s: %s(%s)]", this.context.getString(R.string.bqp), str2, this.context.getString(R.string.bqq)) : String.format("[%s: %s]", this.context.getString(R.string.bqp), str2);
                }
            }
        } else if (caVar.gDl()) {
            bg.aVF();
            str = String.format("[%s: %s]", this.context.getString(R.string.bqr), c.aSQ().aEK(caVar.field_content).nickname);
        } else if (caVar.cWJ()) {
            com.tencent.mm.modelvideo.o.bhj();
            str = String.format("[%s: %s(%s)]", this.context.getString(R.string.bqy), new o(t.Qw(caVar.field_imgPath)).getName(), this.context.getString(R.string.bqq));
            com.tencent.mm.modelvideo.o.bhj();
            o oVar2 = new o(t.Qw(caVar.field_imgPath));
            if (oVar2.exists()) {
                this.Pkd.add(FileProviderHelper.getUriForFile(this.context, oVar2));
            }
        } else if (caVar.gDn() || caVar.gDo()) {
            str = String.format("[%s]", this.context.getString(R.string.bqs));
        }
        Log.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
        String format = String.format("%s\n\n%s\n\n", bE(caVar), str);
        AppMethodBeat.o(34845);
        return format;
    }

    private String bE(ca caVar) {
        AppMethodBeat.i(34846);
        String str = null;
        if (!ab.Eq(this.dSh.field_username)) {
            str = aa.getDisplayName(caVar.field_talker);
        } else {
            String str2 = caVar.field_content;
            int Kp = bp.Kp(str2);
            if (Kp != -1) {
                str = aa.getDisplayName(str2.substring(0, Kp).trim());
            }
        }
        if (caVar.field_isSend == 1) {
            Log.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str = z.aUa();
        }
        String str3 = "" + str + "  " + new SimpleDateFormat("HH:mm").format(new Date(caVar.field_createTime));
        AppMethodBeat.o(34846);
        return str3;
    }

    private String Ns(long j2) {
        AppMethodBeat.i(34847);
        String format = this.oMZ.format(new Date(j2));
        AppMethodBeat.o(34847);
        return format;
    }
}
