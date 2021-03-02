package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    public static void a(MMActivity mMActivity, long j2, h.a aVar) {
        boolean z;
        int i2;
        boolean z2;
        String str;
        String str2;
        AppMethodBeat.i(106778);
        try {
            g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(j2);
            if (DY.field_favProto != null && DY.field_favProto.ppH != null) {
                Iterator<aml> it = DY.field_favProto.ppH.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().LvI > ((long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false))) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                com.tencent.mm.ui.base.h.d(mMActivity, mMActivity.getString(R.string.cbz, new Object[]{Integer.valueOf(((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimitInMB(false))}), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fav.ui.j.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(106777);
                        if (dialogInterface != null) {
                            dialogInterface.cancel();
                        }
                        AppMethodBeat.o(106777);
                    }
                });
                AppMethodBeat.o(106778);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15378, Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_type));
            Log.d("fav.FavNoteConvertLogic", "report 15378, id:%s, type:%s", Integer.valueOf(DY.field_id), Integer.valueOf(DY.field_type));
            DY.field_flag = 0;
            DY.field_updateTime = System.currentTimeMillis();
            DY.field_localId = -1;
            DY.field_sourceType = 6;
            if (DY.field_favProto.Lya != null) {
                DY.field_favProto.Lya.bhh("");
                DY.field_favProto.Lya.ajm(6);
                DY.field_favProto.Lya.bhf(z.aTY());
            }
            DY.field_fromUser = z.aTY();
            if (DY.field_type == 1) {
                DY.field_favProto.bH(new LinkedList<>());
                a(DY, 0, asn(DY.field_favProto.desc));
            } else if (DY.field_favProto.ppH != null) {
                int i3 = 1;
                int i4 = 0;
                while (i4 < DY.field_favProto.ppH.size()) {
                    aml aml = DY.field_favProto.ppH.get(i4);
                    if (DY.field_type != 18 || !aml.Lwp.equals("WeNoteHtmlFile")) {
                        String d2 = b.d(aml);
                        String a2 = b.a(aml);
                        aml.bgs(b.ds(aml.toString(), 18));
                        String d3 = b.d(aml);
                        String a3 = b.a(aml);
                        if (!Util.isNullOrNil(d2) && !Util.isNullOrNil(d3) && s.YS(d2)) {
                            s.nw(d2, d3);
                        }
                        if (!Util.isNullOrNil(a2) && !Util.isNullOrNil(a3) && s.YS(a2)) {
                            s.nw(a2, a3);
                        }
                    }
                    if (DY.field_type == 18) {
                        if (aml.dataType == 20) {
                            aml.bgj("");
                            aml.bgk("");
                        }
                        i2 = i4;
                    } else if (aml.dataType != 1) {
                        int i5 = i3 + 1;
                        aml.bgC("WeNote_" + i3);
                        if (DY.field_type == 14 && aml.Lwj != null) {
                            a(DY, i4, asn(aml.Lwj + ":"));
                            i4++;
                        }
                        int i6 = aml.dataType;
                        if (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 6 || i6 == 8 || i6 == 4 || i6 == 0 || i6 == 22) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            a(mMActivity, DY, i4, aml);
                        } else if (!(aml.dataType != 4 || aml.Lwh == null || aml.Lwh.Lxi == null)) {
                            a(mMActivity, DY, i4, aml);
                        }
                        if (aml.dataType == 3) {
                            aml.ajd(20);
                            i2 = i4;
                            i3 = i5;
                        } else {
                            i2 = i4;
                            i3 = i5;
                        }
                    } else if (DY.field_type == 14) {
                        if (aml.desc == null) {
                            str = "\n";
                        } else {
                            str = aml.desc + "\n";
                        }
                        if (aml.Lwj == null) {
                            str2 = "";
                        } else {
                            str2 = aml.Lwj + ":\n";
                        }
                        aml.bgg(asn(str2 + str + "\n"));
                        i2 = i4;
                    } else {
                        if (!Util.isNullOrNil(aml.desc)) {
                            aml.bgg(asn(aml.desc));
                            i2 = i4;
                        }
                        i2 = i4;
                    }
                    i4 = i2 + 1;
                }
            }
            DY.field_localId = System.currentTimeMillis();
            DY.field_type = 18;
            DY.field_xml = g.t(DY);
            and and = new and();
            if (aVar != null) {
                and.scene = aVar.scene;
                and.pHw = aVar.pHw;
                and.index = aVar.index;
                and.query = aVar.query;
                and.sessionId = aVar.sGF;
                and.tay = aVar.tay;
            }
            oc ocVar = new oc();
            ocVar.dUe.field_localId = DY.field_localId;
            ocVar.dUe.dUn = 5;
            ocVar.dUe.dUg = DY.field_xml;
            ocVar.dUe.context = mMActivity;
            Bundle bundle = new Bundle();
            amv amv = DY.field_favProto.KBr;
            if (amv != null) {
                bundle.putString("noteauthor", amv.LxT);
                bundle.putString("noteeditor", amv.LxU);
            }
            bundle.putLong("edittime", DY.field_updateTime);
            ocVar.dUe.dUl = bundle;
            ocVar.dUe.field_favProto = DY.field_favProto;
            ocVar.dUe.type = 2;
            ocVar.dUe.dUo = true;
            ocVar.dUe.dUp = and;
            EventCenter.instance.publish(ocVar);
            mMActivity.finish();
            AppMethodBeat.o(106778);
        } catch (Throwable th) {
            Toast.makeText(mMActivity, mMActivity.getString(R.string.cbx), 0).show();
            AppMethodBeat.o(106778);
        }
    }

    private static void a(Context context, g gVar, int i2, aml aml) {
        String str;
        AppMethodBeat.i(106779);
        gVar.field_favProto.ppH.remove(i2);
        String a2 = a(context, aml);
        if (a2 == null) {
            str = "\n\n";
        } else {
            str = "\n" + a2 + "\n\n";
        }
        a(gVar, i2, asn(str));
        AppMethodBeat.o(106779);
    }

    private static String asn(String str) {
        AppMethodBeat.i(106780);
        String replaceAll = str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;");
        AppMethodBeat.o(106780);
        return replaceAll;
    }

    private static void a(g gVar, int i2, String str) {
        AppMethodBeat.i(106782);
        aml aml = new aml();
        aml.ajd(1);
        aml.bgg(str);
        gVar.field_favProto.ppH.add(i2, aml);
        AppMethodBeat.o(106782);
    }

    private static String a(Context context, aml aml) {
        String str;
        AppMethodBeat.i(106781);
        switch (aml.dataType) {
            case 4:
                String string = context.getString(R.string.zv);
                AppMethodBeat.o(106781);
                return string;
            case 5:
                String str2 = "";
                if (!(aml.Lwh == null || aml.Lwh.LwO == null)) {
                    str2 = aml.Lwh.LwO.link;
                }
                if (Util.isNullOrNil(str2)) {
                    String str3 = aml.Lvu;
                    AppMethodBeat.o(106781);
                    return str3;
                }
                AppMethodBeat.o(106781);
                return str2;
            case 7:
            case 29:
                String str4 = aml.desc;
                if (!Util.isNullOrNil(aml.title)) {
                    str4 = aml.title + " " + str4;
                }
                AppMethodBeat.o(106781);
                return str4;
            case 16:
                String string2 = context.getString(R.string.vp);
                try {
                    com.tencent.mm.kernel.g.aAi();
                    str = string2 + " " + ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEK(aml.desc).nickname;
                } catch (Exception e2) {
                    str = string2;
                }
                AppMethodBeat.o(106781);
                return str;
            case 17:
                String string3 = context.getString(R.string.yc);
                AppMethodBeat.o(106781);
                return string3;
            case 19:
                String string4 = context.getString(R.string.hc);
                try {
                    string4 = string4 + " " + aml.Lwh.Lxf.Lve;
                } catch (Exception e3) {
                }
                AppMethodBeat.o(106781);
                return string4;
            case 20:
                String str5 = context.getString(R.string.zz) + " " + ((Object) m.J(context, aml.duration / 1000)) + "\n";
                AppMethodBeat.o(106781);
                return str5;
            case 22:
                if (b.cUq()) {
                    AppMethodBeat.o(106781);
                    return "";
                }
                String string5 = context.getString(R.string.vg);
                AppMethodBeat.o(106781);
                return string5;
            default:
                String str6 = aml.desc;
                AppMethodBeat.o(106781);
                return str6;
        }
    }
}
