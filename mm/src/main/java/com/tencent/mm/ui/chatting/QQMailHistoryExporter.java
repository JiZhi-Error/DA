package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] INVALID = {'<', '>', '\"', '\'', '&', '\n'};
    private static final String Pke = ("<img id=\"%s\" src=\"%s\" height=\"100\" onclick=\"" + z.mH("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private static final String[] VALID = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private List<ca> PgD;
    private String Pkb = null;
    private Context context;
    private as dSh = null;
    private float textSize = 1.0f;

    static {
        AppMethodBeat.i(34858);
        AppMethodBeat.o(34858);
    }

    private static String escapeStringForXml(String str) {
        AppMethodBeat.i(34851);
        if (str == null) {
            AppMethodBeat.o(34851);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            boolean z = true;
            int length2 = INVALID.length - 1;
            while (true) {
                if (length2 < 0) {
                    break;
                } else if (INVALID[length2] == charAt) {
                    stringBuffer.append(VALID[length2]);
                    z = false;
                    break;
                } else {
                    length2--;
                }
            }
            if (z) {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(34851);
        return stringBuffer2;
    }

    public QQMailHistoryExporter(Context context2, List<ca> list, as asVar) {
        this.context = context2;
        this.PgD = list;
        this.dSh = asVar;
    }

    public final String gOl() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(34852);
        Log.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", Integer.valueOf(this.PgD.size()));
        if (a.jk(this.context)) {
            this.textSize = a.ez(this.context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<div id=\"history\">\n");
        sb.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", Float.valueOf(this.textSize), Float.valueOf(this.textSize), gOm()));
        for (ca caVar : this.PgD) {
            if (this.Pkb == null) {
                this.Pkb = Ns(caVar.field_createTime);
                sb.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", Float.valueOf(this.textSize), this.Pkb));
            } else {
                String Ns = Ns(caVar.field_createTime);
                if (!Ns.equals(this.Pkb)) {
                    this.Pkb = Ns;
                    sb.append("<br>");
                    sb.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", Float.valueOf(this.textSize), this.Pkb));
                }
            }
            if (caVar.isText()) {
                if (!caVar.isText()) {
                    str3 = null;
                } else if (caVar.field_isSend == 1) {
                    str3 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), escapeStringForXml(caVar.field_content));
                } else if (!ab.Eq(this.dSh.field_username)) {
                    str3 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), escapeStringForXml(caVar.field_content));
                } else {
                    int Kp = bp.Kp(caVar.field_content);
                    str3 = Kp != -1 ? String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), escapeStringForXml(caVar.field_content.substring(Kp + 1).trim())) : null;
                }
                sb.append(str3);
            } else if (caVar.gAz()) {
                if (caVar.gAz()) {
                    long j2 = caVar.field_msgId;
                    long j3 = caVar.field_msgSvrId;
                    String cf = ad.cf(caVar.field_talker, j2);
                    if (Util.isNullOrNil(cf)) {
                        cf = ad.cg(caVar.field_talker, j3);
                    }
                    String k = s.k(cf, false);
                    Log.i("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", k);
                    if (!Util.isNullOrNil(k)) {
                        str2 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), String.format(Pke, new o(k).getName(), "file://".concat(String.valueOf(k)), k));
                        sb.append(str2);
                    }
                }
                str2 = null;
                sb.append(str2);
            } else if (caVar.dOQ()) {
                k.b HD = k.b.HD(caVar.field_content);
                if (HD == null || !(HD.type == 53 || HD.type == 57)) {
                    sb.append(bD(caVar));
                } else {
                    if (HD == null || !(HD.type == 53 || HD.type == 57)) {
                        str = null;
                    } else {
                        str = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), escapeStringForXml(HD.title));
                    }
                    sb.append(str);
                }
            } else {
                sb.append(bD(caVar));
            }
        }
        sb.append("\n</div>\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(34852);
        return sb2;
    }

    private String gOm() {
        String arI;
        String format;
        AppMethodBeat.i(34853);
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
        AppMethodBeat.o(34853);
        return format;
    }

    private String bD(ca caVar) {
        AppMethodBeat.i(34854);
        String str = null;
        if (caVar.gAy()) {
            str = String.format("[%s]", this.context.getString(R.string.bqz));
        } else if (caVar.gDh()) {
            if (caVar.field_isSend == 1) {
                str = this.context.getString(R.string.bqx);
            } else {
                str = this.context.getString(R.string.bqw);
            }
        } else if (caVar.dOS()) {
            ly lyVar = new ly();
            lyVar.dRv.dRq = 1;
            lyVar.dRv.dCM = caVar;
            EventCenter.instance.publish(lyVar);
            str = String.format("[%s]", lyVar.dRw.dNk);
        } else if (caVar.dOQ()) {
            str = bF(caVar);
        } else if (caVar.gDl()) {
            bg.aVF();
            str = String.format("[%s: %s]", this.context.getString(R.string.bqr), c.aSQ().aEK(caVar.field_content).nickname);
        } else if (caVar.cWJ()) {
            com.tencent.mm.modelvideo.o.bhj();
            str = String.format("[%s: %s(%s)]", this.context.getString(R.string.bqy), new o(t.Qw(caVar.field_imgPath)).getName(), this.context.getString(R.string.bqq));
        } else if (caVar.gDn() || caVar.gDo()) {
            str = String.format("[%s]", this.context.getString(R.string.bqs));
        }
        Log.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
        String format = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", Float.valueOf(this.textSize), bE(caVar), Float.valueOf(this.textSize), str);
        AppMethodBeat.o(34854);
        return format;
    }

    private String bF(ca caVar) {
        String str;
        AppMethodBeat.i(34855);
        String str2 = caVar.field_content;
        if (ab.Eq(this.dSh.field_username)) {
            Log.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
            int Kp = bp.Kp(caVar.field_content);
            if (Kp != -1) {
                str2 = caVar.field_content.substring(Kp + 1).trim();
            }
        }
        k.b HD = k.b.HD(Util.processXml(str2));
        if (HD == null) {
            Log.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
            String format = String.format("[%s]", this.context.getString(R.string.bqp));
            AppMethodBeat.o(34855);
            return format;
        }
        g o = h.o(HD.appId, true, false);
        String a2 = h.a(this.context, o, (o == null || Util.isNullOrNil(o.field_appName)) ? HD.appName : o.field_appName);
        if (!caVar.gDq()) {
            if (!caVar.gDr()) {
                switch (HD.type) {
                    case 1:
                        if (!Util.isNullOrNil(a2)) {
                            str = String.format("[%s: %s]", a2, escapeStringForXml(HD.title));
                            break;
                        } else {
                            str = escapeStringForXml(HD.title);
                            break;
                        }
                    case 2:
                        String b2 = ad.b(caVar, HD);
                        if (!Util.isNullOrNil(b2)) {
                            str = String.format(Pke, new o(b2).getName(), "file://".concat(String.valueOf(b2)), b2);
                            break;
                        }
                        break;
                    case 3:
                        if (!Util.isNullOrNil(HD.description)) {
                            str = String.format("[%s: %s-%s]", this.context.getString(R.string.bqv), escapeStringForXml(HD.title), escapeStringForXml(HD.description));
                            break;
                        } else {
                            str = String.format("[%s: %s]", this.context.getString(R.string.bqv), escapeStringForXml(HD.title));
                            break;
                        }
                    case 4:
                    case 5:
                        str = String.format("[%s: %s]", escapeStringForXml(HD.title), escapeStringForXml(HD.url));
                        break;
                    case 6:
                        if (!Util.isNullOrNil(HD.description)) {
                            str = String.format("[%s: %s-%s(%s)]", this.context.getString(R.string.bqt), escapeStringForXml(HD.title), escapeStringForXml(HD.description), this.context.getString(R.string.bqq));
                            break;
                        } else {
                            str = String.format("[%s: %s]", this.context.getString(R.string.bqt), escapeStringForXml(HD.title));
                            break;
                        }
                    case 7:
                    default:
                        str = String.format("[%s]", this.context.getString(R.string.bqp));
                        break;
                    case 8:
                        str = String.format("[%s]", this.context.getString(R.string.bqs));
                        break;
                }
            } else {
                String b3 = ad.b(caVar, HD);
                if (!Util.isNullOrNil(b3)) {
                    str = String.format(Pke, new o(b3).getName(), "file://".concat(String.valueOf(b3)), b3);
                }
            }
            str = "";
        } else if (Util.isNullOrNil(a2)) {
            str = escapeStringForXml(HD.title);
        } else {
            str = String.format("[%s: %s]", a2, escapeStringForXml(HD.title));
        }
        AppMethodBeat.o(34855);
        return str;
    }

    private String bE(ca caVar) {
        AppMethodBeat.i(34856);
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
            Log.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str = com.tencent.mm.model.z.aUa();
        }
        String str3 = "" + str + "  " + new SimpleDateFormat("HH:mm").format(new Date(caVar.field_createTime));
        AppMethodBeat.o(34856);
        return str3;
    }

    private static String Ns(long j2) {
        AppMethodBeat.i(34857);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(j2));
        AppMethodBeat.o(34857);
        return format;
    }

    public static class ImageSpanData implements Parcelable {
        public static final Parcelable.Creator<ImageSpanData> CREATOR = new Parcelable.Creator<ImageSpanData>() {
            /* class com.tencent.mm.ui.chatting.QQMailHistoryExporter.ImageSpanData.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ImageSpanData[] newArray(int i2) {
                return new ImageSpanData[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ImageSpanData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(34848);
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.bNu = parcel.readInt();
                imageSpanData.endPos = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                AppMethodBeat.o(34848);
                return imageSpanData;
            }
        };
        int bNu;
        int endPos;
        String path;
        private int thumbnail = 0;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(34849);
            parcel.writeInt(this.bNu);
            parcel.writeInt(this.endPos);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
            AppMethodBeat.o(34849);
        }

        static {
            AppMethodBeat.i(34850);
            AppMethodBeat.o(34850);
        }
    }
}
