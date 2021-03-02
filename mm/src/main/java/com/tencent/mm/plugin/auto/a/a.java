package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.s;
import android.support.v4.app.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BroadcastHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

public final class a {
    IListener oID = new IListener<aa>() {
        /* class com.tencent.mm.plugin.auto.a.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161287);
            this.__eventId = aa.class.getName().hashCode();
            AppMethodBeat.o(161287);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aa aaVar) {
            AppMethodBeat.i(21155);
            boolean a2 = a(aaVar);
            AppMethodBeat.o(21155);
            return a2;
        }

        private static boolean a(aa aaVar) {
            s.d dVar;
            String str;
            String string;
            boolean z;
            String trim;
            AppMethodBeat.i(21154);
            if (aaVar instanceof aa) {
                try {
                    aa.a aVar = aaVar.dCY;
                    String str2 = aaVar.dCY.username;
                    String str3 = aaVar.dCY.title;
                    if (!a.ceB()) {
                        dVar = null;
                    } else if (!a.ceC()) {
                        Log.i("MicroMsg.auto.AutoLogic", "not open car mode");
                        dVar = null;
                    } else if (!a.ceD()) {
                        Log.i("MicroMsg.auto.AutoLogic", "not install auto app");
                        dVar = null;
                    } else {
                        b bVar = b.oIG;
                        b.Bt(0);
                        Intent putExtra = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str2);
                        BroadcastHelper.setIntentPackageName(putExtra);
                        PendingIntent broadcast = PendingIntent.getBroadcast(MMApplicationContext.getContext(), str2.hashCode(), putExtra, 134217728);
                        Intent putExtra2 = new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str2);
                        BroadcastHelper.setIntentPackageName(putExtra2);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(MMApplicationContext.getContext(), str2.hashCode(), putExtra2, 134217728);
                        x.a aVar2 = new x.a("key_voice_reply_text");
                        aVar2.IJ = MMApplicationContext.getContext().getString(R.string.yf);
                        x xVar = new x(aVar2.II, aVar2.IJ, aVar2.IK, aVar2.IL, aVar2.mExtras, aVar2.IM);
                        s.d.a.C0018a aVar3 = new s.d.a.C0018a(str3);
                        aVar3.Ie = broadcast;
                        aVar3.Ib = xVar;
                        aVar3.Ic = broadcast2;
                        int Eo = g.Eo(str2);
                        if (Eo > 10) {
                            Eo = 10;
                        }
                        bg.aVF();
                        List<ca> ew = c.aSQ().ew(str2, Eo);
                        for (int size = ew.size() - 1; size >= 0; size--) {
                            ca caVar = ew.get(size);
                            if (ab.Eq(caVar.field_talker)) {
                                String str4 = caVar.field_talker;
                                int Kp = bp.Kp(caVar.field_content);
                                if (!(Kp == -1 || (trim = caVar.field_content.substring(0, Kp).trim()) == null || trim.length() <= 0)) {
                                    str4 = trim;
                                }
                                bg.aVF();
                                as Kn = c.aSN().Kn(str4);
                                String b2 = com.tencent.mm.model.aa.b(Kn, str4);
                                if (ab.Eq(str4) && (Kn.field_username.equals(b2) || Util.isNullOrNil(b2))) {
                                    b2 = MMApplicationContext.getContext().getString(R.string.b25);
                                }
                                str = b2;
                            } else {
                                str = null;
                            }
                            if (caVar.gAz()) {
                                string = MMApplicationContext.getContext().getString(R.string.ffo);
                            } else if (caVar.isText()) {
                                if (!ab.Eq(caVar.field_talker) || caVar.field_isSend == 1) {
                                    string = caVar.field_content;
                                } else {
                                    int Kp2 = bp.Kp(caVar.field_content);
                                    string = Kp2 != -1 ? caVar.field_content.substring(Kp2 + 1).trim() : caVar.field_content;
                                }
                            } else if (caVar.gAy()) {
                                string = MMApplicationContext.getContext().getString(R.string.fgn);
                            } else if (caVar.cWJ()) {
                                string = MMApplicationContext.getContext().getString(R.string.fgm);
                            } else if (caVar.cWL()) {
                                string = MMApplicationContext.getContext().getString(R.string.fgd);
                            } else {
                                if (caVar.dOQ()) {
                                    k.b HD = k.b.HD(caVar.field_content);
                                    if (HD != null) {
                                        switch (HD.type) {
                                            case 2:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.ffo), new Object[0]);
                                                break;
                                            case 3:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.fex), Util.nullAs(HD.title, ""));
                                                break;
                                            case 4:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.ff1), Util.nullAs(HD.title, ""));
                                                break;
                                            case 5:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.feu), Util.nullAs(HD.title, ""));
                                                break;
                                            case 6:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.fet), Util.nullAs(HD.title, ""));
                                                break;
                                            case 8:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.ff6), Util.nullAs(HD.title, ""));
                                                break;
                                            case 10:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.fey), Util.nullAs(HD.title, ""));
                                                break;
                                            case 13:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.few), Util.nullAs(HD.title, ""));
                                                break;
                                            case 15:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.fes), Util.nullAs(HD.title, ""));
                                                break;
                                            case 16:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.ff5), Util.nullAs(HD.title, ""));
                                                break;
                                            case 19:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.fez), Util.nullAs(HD.title, ""));
                                                break;
                                            case 20:
                                                string = String.format(MMApplicationContext.getContext().getString(R.string.ff0), Util.nullAs(HD.title, ""));
                                                break;
                                            case 24:
                                                string = MMApplicationContext.getContext().getString(R.string.cd7);
                                                break;
                                        }
                                    }
                                } else if (caVar.gDn()) {
                                    String string2 = MMApplicationContext.getContext().getString(R.string.ffd);
                                    d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                                    if (emojiMgr != null) {
                                        EmojiInfo aml = emojiMgr.aml(caVar.field_imgPath);
                                        string = (aml == null || Util.isNullOrNil(emojiMgr.amp(aml.getMd5()))) ? MMApplicationContext.getContext().getString(R.string.ffd) : "[" + emojiMgr.amp(aml.getMd5()) + "]";
                                    } else {
                                        string = string2;
                                    }
                                } else if (caVar.dOS()) {
                                    string = MMApplicationContext.getContext().getString(R.string.ffp);
                                } else if (caVar.gDh() || caVar.gDi()) {
                                    if (!caVar.field_content.equals(ca.OqB)) {
                                        String str5 = caVar.field_content;
                                        zj zjVar = new zj();
                                        zjVar.efx.dKy = 1;
                                        zjVar.efx.content = str5;
                                        EventCenter.instance.publish(zjVar);
                                        if (zjVar.efy.type == 3) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            string = MMApplicationContext.getContext().getString(R.string.fgq);
                                        }
                                    }
                                    string = MMApplicationContext.getContext().getString(R.string.fgr);
                                } else if (caVar.gDl()) {
                                    bg.aVF();
                                    string = String.format(MMApplicationContext.getContext().getString(R.string.ff5), c.aSQ().aEK(caVar.field_content).getDisplayName());
                                } else if (caVar.getType() == -1879048186) {
                                    string = MMApplicationContext.getContext().getString(R.string.fev);
                                }
                                string = null;
                            }
                            if (string == null) {
                                string = MMApplicationContext.getContext().getString(R.string.fge);
                            }
                            if (str != null) {
                                string = String.format("%s: %s", str, string);
                            }
                            aVar3.Ih.add(string);
                            if (size == 0) {
                                aVar3.Ig = caVar.field_createTime;
                            }
                        }
                        s.d dVar2 = new s.d();
                        dVar2.HZ = new s.d.a((String[]) aVar3.Ih.toArray(new String[aVar3.Ih.size()]), aVar3.Ib, aVar3.Ic, aVar3.Ie, new String[]{aVar3.Ii}, aVar3.Ig);
                        dVar = dVar2;
                    }
                    aVar.dCZ = dVar;
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            AppMethodBeat.o(21154);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(21156);
        AppMethodBeat.o(21156);
    }

    public static boolean ceB() {
        AppMethodBeat.i(231584);
        if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_auto, 1) == 1) {
            AppMethodBeat.o(231584);
            return true;
        }
        AppMethodBeat.o(231584);
        return false;
    }

    public static boolean ceC() {
        AppMethodBeat.i(231585);
        if (((UiModeManager) MMApplicationContext.getContext().getSystemService("uimode")).getCurrentModeType() == 3) {
            AppMethodBeat.o(231585);
            return true;
        }
        AppMethodBeat.o(231585);
        return false;
    }

    public static boolean ceD() {
        boolean z;
        AppMethodBeat.i(21157);
        try {
            MMApplicationContext.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (PackageManager.NameNotFoundException e2) {
            z = false;
        }
        Log.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", Boolean.valueOf(z));
        AppMethodBeat.o(21157);
        return z;
    }
}
