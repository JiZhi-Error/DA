package com.tencent.mm.ui.chatting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class o {
    public static boolean a(a aVar, List<ca> list, as asVar) {
        AppMethodBeat.i(34482);
        if (aVar == null) {
            Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
            AppMethodBeat.o(34482);
            return false;
        } else if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
            AppMethodBeat.o(34482);
            return false;
        } else if (asVar == null || ((int) asVar.gMZ) <= 0) {
            Log.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
            AppMethodBeat.o(34482);
            return false;
        } else {
            boolean b2 = b(aVar, list, asVar);
            AppMethodBeat.o(34482);
            return b2;
        }
    }

    private static boolean b(final a aVar, List<ca> list, as asVar) {
        String arI;
        String format;
        ArrayList<Uri> arrayList;
        AppMethodBeat.i(34483);
        if (!ab.Eq(asVar.field_username)) {
            String string = aVar.Pwc.getMMResources().getString(R.string.gk3);
            bg.aVF();
            format = String.format(string, asVar.arI(), c.azQ().get(4, (Object) null));
        } else {
            if (Util.isNullOrNil(asVar.field_nickname)) {
                String str = "";
                Iterator<String> it = v.Ic(asVar.field_username).iterator();
                while (it.hasNext()) {
                    str = str + aa.getDisplayName(it.next()) + ", ";
                }
                arI = str.substring(0, str.length() - 2);
            } else {
                arI = asVar.arI();
            }
            format = String.format(aVar.Pwc.getMMResources().getString(R.string.gk4), arI);
        }
        h.INSTANCE.a(10811, 7, Integer.valueOf(list.size()));
        if ((z.aUl() & 1) == 0) {
            Log.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            for (ca caVar : list) {
                if (caVar.cWJ()) {
                    com.tencent.mm.modelvideo.o.bhj();
                    arrayList2.add(t.Qw(caVar.field_imgPath));
                    arrayList3.add(null);
                } else if (caVar.dOQ()) {
                    k.b HD = k.b.HD(caVar.field_content);
                    if (HD != null) {
                        switch (HD.type) {
                            case 4:
                            case 6:
                                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                                if (bdx == null) {
                                    break;
                                } else {
                                    com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(bdx.field_fileFullPath);
                                    if (oVar.exists()) {
                                        arrayList2.add(s.k(com.tencent.mm.vfs.aa.z(oVar.her()), false));
                                        arrayList3.add(HD.title);
                                    }
                                }
                            case 5:
                            default:
                                Log.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + arrayList2 + "file name = " + arrayList3);
                                break;
                        }
                    }
                }
                Log.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + arrayList2 + "file name = " + arrayList3);
            }
            String gOl = new QQMailHistoryExporter(aVar.Pwc.getContext(), list, asVar).gOl();
            Intent intent = new Intent();
            intent.putExtra("mail_mode", 21);
            intent.putExtra("mail_content", gOl);
            intent.putExtra("subject", format);
            intent.putExtra("show_qqmail", true);
            intent.putExtra("mail_edit_mode", true);
            intent.putStringArrayListExtra("mail_attach_file", arrayList2);
            com.tencent.mm.br.c.a(aVar.Pwa, "qqmail", ".ui.ComposeUI", intent, (int) TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, new c.a() {
                /* class com.tencent.mm.ui.chatting.o.AnonymousClass1 */

                @Override // com.tencent.mm.br.c.a
                public final void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(34481);
                    l lVar = (l) aVar.bh(l.class);
                    if (-1 == i3 && lVar != null && lVar.gPB()) {
                        lVar.gPz();
                    }
                    AppMethodBeat.o(34481);
                }
            });
            AppMethodBeat.o(34483);
            return false;
        }
        Log.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
        aj ajVar = new aj(aVar.Pwc.getContext(), list, asVar);
        String gOl2 = ajVar.gOl();
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("message/rfc822");
        intent2.putExtra("android.intent.extra.SUBJECT", format);
        intent2.putExtra("android.intent.extra.TEXT", gOl2);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(ajVar.Pkc == null);
        objArr[1] = Integer.valueOf(ajVar.PgD.size());
        Log.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", objArr);
        if (ajVar.Pkc != null) {
            arrayList = ajVar.Pkd;
        } else {
            Log.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
            ajVar.gOl();
            arrayList = ajVar.Pkd;
        }
        intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        try {
            BaseChattingUIFragment baseChattingUIFragment = aVar.Pwc;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent2, aVar.Pwc.getContext().getString(R.string.gk2)));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/ChattingEditModeSendToMail", "doJob", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Ljava/util/List;Lcom/tencent/mm/storage/Contact;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } catch (ActivityNotFoundException e2) {
            Toast.makeText(aVar.Pwc.getContext(), (int) R.string.gk5, 0).show();
        }
        AppMethodBeat.o(34483);
        return true;
    }
}
