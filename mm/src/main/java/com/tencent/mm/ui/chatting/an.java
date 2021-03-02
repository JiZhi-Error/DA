package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.LinkedList;
import java.util.List;

public final class an {
    public static void m(final String str, final Context context) {
        AppMethodBeat.i(34907);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
            AppMethodBeat.o(34907);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
            AppMethodBeat.o(34907);
        } else {
            a(jm(ag.bah().sN(1)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(34896);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", sb, str);
                    o.e Pl = com.tencent.mm.modelmulti.o.Pl(sb);
                    Pl.toUser = sb;
                    Pl.content = str;
                    o.e tD = Pl.tD(ab.JG(sb));
                    tD.cSx = 0;
                    tD.jdR = 4;
                    tD.bdQ().execute();
                    h.INSTANCE.a(10424, 1, 1, sb);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34896);
                }
            });
            AppMethodBeat.o(34907);
        }
    }

    public static void b(final ca caVar, final Context context) {
        AppMethodBeat.i(34908);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
            AppMethodBeat.o(34908);
        } else if (caVar == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
            AppMethodBeat.o(34908);
        } else {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.kf(context);
                Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
                AppMethodBeat.o(34908);
                return;
            }
            a(jm(ag.bah().sN(2)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    int i3;
                    AppMethodBeat.i(34899);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    if (Util.isNullOrNil(caVar.field_imgPath)) {
                        Log.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                        AppMethodBeat.o(34899);
                        return;
                    }
                    r Ro = s.Ro(caVar.field_imgPath);
                    String str = caVar.field_imgPath;
                    if (Ro == null) {
                        i3 = 0;
                    } else {
                        i3 = Ro.jvt;
                    }
                    String n = s.n(sb, str, i3);
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", sb, n);
                    bg.azz().a(new f(n, 1), 0);
                    h.INSTANCE.a(10424, 34, 2, sb);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34899);
                }
            });
            AppMethodBeat.o(34908);
        }
    }

    public static void a(final ca caVar, final Context context, final String str, final boolean z) {
        AppMethodBeat.i(34909);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
            AppMethodBeat.o(34909);
        } else if (caVar == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
            AppMethodBeat.o(34909);
        } else {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.kf(context);
                Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
                AppMethodBeat.o(34909);
                return;
            }
            a(jm(ag.bah().sN(4)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    g gVar;
                    g gVar2;
                    String str;
                    Bundle bundle;
                    int i3;
                    int i4 = 1;
                    AppMethodBeat.i(34900);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    if (caVar.field_msgId > 0) {
                        gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                    } else {
                        gVar = null;
                    }
                    if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
                        gVar2 = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                    } else {
                        gVar2 = gVar;
                    }
                    if (gVar2 == null) {
                        Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                        AppMethodBeat.o(34900);
                    } else if (gVar2.offset < gVar2.iKP || gVar2.iKP == 0) {
                        Log.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
                        Intent intent = new Intent(context, ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", caVar.field_msgId);
                        intent.putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", caVar.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", caVar.field_talker);
                        intent.putExtra("img_gallery_is_restransmit_after_download", true);
                        intent.putExtra("img_gallery_directly_send_name", sb);
                        intent.putExtra("start_chatting_ui", false);
                        String str2 = caVar.field_talker;
                        Bundle bundle2 = new Bundle();
                        if (z) {
                            str = "stat_scene";
                            i4 = 2;
                            bundle = bundle2;
                        } else {
                            str = "stat_scene";
                            if (ab.IT(str2)) {
                                i4 = 7;
                                bundle = bundle2;
                            } else {
                                bundle = bundle2;
                            }
                        }
                        bundle.putInt(str, i4);
                        bundle2.putString("stat_msg_id", "msg_" + Long.toString(caVar.field_msgSvrId));
                        bundle2.putString("stat_chat_talker_username", str2);
                        bundle2.putString("stat_send_msg_user", str);
                        intent.putExtra("_stat_obj", bundle2);
                        Context context = context;
                        a bl = new a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/SendToBrandServiceHelper$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(34900);
                    } else {
                        if (caVar.field_isSend == 1) {
                            if (gVar2.bcv()) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                        } else if (!gVar2.bcv()) {
                            i3 = 0;
                        } else if (!com.tencent.mm.vfs.s.YS(com.tencent.mm.av.h.a(gVar2).iXm)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        String aTY = z.aTY();
                        String o = q.bcR().o(com.tencent.mm.av.h.c(gVar2), "", "");
                        if (!Util.isNullOrNil(o)) {
                            Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", sb, o);
                            o.e tc = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
                            tc.dRL = aTY;
                            tc.toUser = sb;
                            tc.iZt = o;
                            tc.iXp = i3;
                            tc.jdS = null;
                            tc.dQd = 0;
                            tc.iXy = "";
                            tc.thumbPath = "";
                            tc.jdV = true;
                            tc.jdU = R.drawable.c3h;
                            tc.jdR = 11;
                            tc.bdQ().execute();
                            cf.aWl().f(cf.iFI, null);
                        }
                        h.INSTANCE.a(10424, 3, 4, sb);
                        com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                        AppMethodBeat.o(34900);
                    }
                }
            });
            AppMethodBeat.o(34909);
        }
    }

    public static void c(final ca caVar, final Context context) {
        AppMethodBeat.i(34910);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
            AppMethodBeat.o(34910);
        } else if (caVar == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
            AppMethodBeat.o(34910);
        } else {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.kf(context);
                Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
                AppMethodBeat.o(34910);
                return;
            }
            a(jm(ag.bah().sN(8)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(34901);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    com.tencent.mm.modelvideo.s QN = com.tencent.mm.modelvideo.u.QN(caVar.field_imgPath);
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", sb, caVar.field_imgPath);
                    final MsgRetransmitUI.a aVar = new MsgRetransmitUI.a();
                    Context context = context;
                    context.getResources().getString(R.string.zb);
                    com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a(context, context.getResources().getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.chatting.an.AnonymousClass6.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            aVar.QyQ = true;
                        }
                    });
                    aVar.context = context;
                    aVar.fileName = caVar.field_imgPath;
                    aVar.tipDialog = a2;
                    aVar.userName = sb;
                    aVar.Qyk = QN.jsr;
                    aVar.iFw = QN.iFw;
                    aVar.execute(new Object[0]);
                    cf.aWl().f(cf.iFJ, null);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34901);
                }
            });
            AppMethodBeat.o(34910);
        }
    }

    public static void n(final String str, final Context context) {
        AppMethodBeat.i(34911);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
            AppMethodBeat.o(34911);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
            AppMethodBeat.o(34911);
        } else {
            a(jm(ag.bah().sN(16)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass7 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(34902);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", sb, str);
                    o.e Pl = com.tencent.mm.modelmulti.o.Pl(sb);
                    Pl.toUser = sb;
                    Pl.content = str;
                    o.e tD = Pl.tD(48);
                    tD.cSx = 0;
                    tD.jdR = 4;
                    tD.bdQ().execute();
                    h.INSTANCE.a(10424, 48, 16, sb);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34902);
                }
            });
            AppMethodBeat.o(34911);
        }
    }

    public static void o(final String str, final Context context) {
        AppMethodBeat.i(34912);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
            AppMethodBeat.o(34912);
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
            AppMethodBeat.o(34912);
        } else {
            a(jm(ag.bah().sN(32)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass8 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    int i3;
                    int i4 = 66;
                    AppMethodBeat.i(34903);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", sb, str);
                    ca.a bkA = ca.a.bkA(str);
                    o.e Pl = com.tencent.mm.modelmulti.o.Pl(sb);
                    Pl.toUser = sb;
                    Pl.content = str;
                    if (as.bjp(bkA.dkU)) {
                        i3 = 66;
                    } else {
                        i3 = 42;
                    }
                    o.e tD = Pl.tD(i3);
                    tD.cSx = 0;
                    tD.jdR = 4;
                    tD.bdQ().execute();
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[3];
                    if (!as.bjp(bkA.dkU)) {
                        i4 = 42;
                    }
                    objArr[0] = Integer.valueOf(i4);
                    objArr[1] = 32;
                    objArr[2] = sb;
                    hVar.a(10424, objArr);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34903);
                }
            });
            AppMethodBeat.o(34912);
        }
    }

    public static void d(final ca caVar, final Context context) {
        AppMethodBeat.i(34913);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
            AppMethodBeat.o(34913);
        } else if (caVar == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
            AppMethodBeat.o(34913);
        } else {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.kf(context);
                Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
                AppMethodBeat.o(34913);
                return;
            }
            a(jm(ag.bah().sN(64)), context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    String str;
                    AppMethodBeat.i(34904);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    String str2 = be.bkr(caVar.field_content).md5;
                    if (str2 == null || str2.endsWith("-1")) {
                        str = caVar.field_imgPath;
                    } else {
                        str = str2;
                    }
                    if (str == null) {
                        Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                        AppMethodBeat.o(34904);
                        return;
                    }
                    Log.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", sb, str);
                    if (((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().u(context, sb, str)) {
                        h.INSTANCE.a(10424, 47, 64, sb);
                        com.tencent.mm.ui.base.h.cD(context, "");
                    }
                    h.INSTANCE.a(10424, 47, 64, sb);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34904);
                }
            });
            AppMethodBeat.o(34913);
        }
    }

    public static void a(ca caVar, String str, Context context) {
        AppMethodBeat.i(34914);
        a(caVar, str, context, 512);
        AppMethodBeat.o(34914);
    }

    public static void b(ca caVar, String str, Context context) {
        AppMethodBeat.i(34915);
        a(caVar, str, context, 256);
        AppMethodBeat.o(34915);
    }

    public static void c(ca caVar, String str, Context context) {
        AppMethodBeat.i(34916);
        a(caVar, str, context, 128);
        AppMethodBeat.o(34916);
    }

    private static void a(final ca caVar, final String str, final Context context, final int i2) {
        AppMethodBeat.i(34917);
        if (context == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
            AppMethodBeat.o(34917);
        } else if (caVar == null) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
            AppMethodBeat.o(34917);
        } else {
            List<String> list = null;
            switch (i2) {
                case 128:
                    list = jm(com.tencent.mm.al.g.aZM());
                    break;
                case 256:
                    list = jm(com.tencent.mm.al.g.aZO());
                    break;
                case 512:
                    list = jm(com.tencent.mm.al.g.aZQ());
                    break;
            }
            a(list, context, new o.g() {
                /* class com.tencent.mm.ui.chatting.an.AnonymousClass10 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(34905);
                    String sb = new StringBuilder().append((Object) menuItem.getTitle()).toString();
                    ca caVar = caVar;
                    k.b HD = k.b.HD(Util.processXml(str));
                    if (HD == null) {
                        Log.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
                    } else {
                        byte[] bArr = null;
                        if (caVar.field_imgPath != null && !caVar.field_imgPath.equals("")) {
                            try {
                                bArr = com.tencent.mm.vfs.s.aW(q.bcR().R(caVar.field_imgPath, true), 0, -1);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", sb, e2.getLocalizedMessage());
                            }
                        }
                        com.tencent.mm.pluginsdk.model.app.c cVar = new com.tencent.mm.pluginsdk.model.app.c();
                        if (!Util.isNullOrNil(HD.dCK)) {
                            long j2 = Util.getLong(HD.dCK, -1);
                            if (j2 != -1) {
                                ao.cgO().get(j2, cVar);
                                if (cVar.systemRowid != j2 && ((cVar = ao.cgO().bdx(HD.dCK)) == null || !cVar.field_mediaSvrId.equals(HD.dCK))) {
                                    cVar = null;
                                }
                            } else {
                                cVar = ao.cgO().bdx(HD.dCK);
                                if (cVar == null || !cVar.field_mediaSvrId.equals(HD.dCK)) {
                                    cVar = null;
                                }
                            }
                        }
                        String str = "";
                        if (!(cVar == null || cVar.field_fileFullPath == null || cVar.field_fileFullPath.equals(""))) {
                            bg.aVF();
                            str = m.aB(c.aTg(), HD.title, HD.iwJ);
                            com.tencent.mm.vfs.s.nw(cVar.field_fileFullPath, str);
                        }
                        k.b a2 = k.b.a(HD);
                        a2.iwL = 3;
                        m.a(a2, HD.appId, HD.appName, sb, str, bArr, (String) null);
                    }
                    switch (i2) {
                        case 128:
                            h.INSTANCE.a(10424, 49, 128, sb);
                            break;
                        case 256:
                            h.INSTANCE.a(10424, 49, 256, sb);
                            break;
                        case 512:
                            h.INSTANCE.a(10424, 49, 512, sb);
                            break;
                    }
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.ym));
                    AppMethodBeat.o(34905);
                }
            });
            AppMethodBeat.o(34917);
        }
    }

    private static List<String> jm(List<String> list) {
        AppMethodBeat.i(34918);
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (!com.tencent.mm.al.g.Ne(str)) {
                linkedList.add(str);
            }
        }
        Log.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(34918);
        return linkedList;
    }

    private static void a(final List<String> list, final Context context, o.g gVar) {
        AppMethodBeat.i(34919);
        if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            AppMethodBeat.o(34919);
            return;
        }
        l lVar = new l(context);
        lVar.HMa = new o.b() {
            /* class com.tencent.mm.ui.chatting.an.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.o.b
            public final void a(ImageView imageView, MenuItem menuItem) {
                AppMethodBeat.i(34906);
                a.b.c(imageView, new StringBuilder().append((Object) menuItem.getTitle()).toString());
                AppMethodBeat.o(34906);
            }
        };
        lVar.HMb = new o.c() {
            /* class com.tencent.mm.ui.chatting.an.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.c
            public final void a(TextView textView, MenuItem menuItem) {
                AppMethodBeat.i(34897);
                if (textView != null) {
                    bg.aVF();
                    as Kn = c.aSN().Kn(new StringBuilder().append((Object) menuItem.getTitle()).toString());
                    if (Kn == null || ((int) Kn.gMZ) <= 0) {
                        textView.setText(new StringBuilder().append((Object) menuItem.getTitle()).toString());
                        AppMethodBeat.o(34897);
                        return;
                    }
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, Kn.arI(), textView.getTextSize()));
                }
                AppMethodBeat.o(34897);
            }
        };
        lVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.an.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(34898);
                for (String str : list) {
                    mVar.add(str);
                }
                AppMethodBeat.o(34898);
            }
        };
        lVar.HLY = gVar;
        lVar.gXI();
        AppMethodBeat.o(34919);
    }
}
