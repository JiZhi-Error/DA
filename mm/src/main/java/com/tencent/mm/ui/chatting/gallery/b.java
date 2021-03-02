package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.app.j;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.webview.ui.tools.media.d;
import com.tencent.mm.plugin.webview.ui.tools.media.e;
import com.tencent.mm.plugin.webview.ui.tools.media.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b extends v {
    public static long ppv = -1;
    public static boolean tca = false;
    public d PwA;
    public j PwB;
    public i PwC;
    public c PwD;
    public boolean PwE = false;
    boolean PwF;
    protected boolean PwG = true;
    private x PwH = null;
    public ImageGalleryUI Pwv;
    protected a Pww;
    private String Pwx;
    boolean Pwy = true;
    public boolean Pwz = false;
    private int fromScene;
    private String gqV = null;
    private ArrayList<ca> tkt = new ArrayList<>();

    public interface c {
        void tf();
    }

    @Override // com.tencent.mm.ui.base.v
    public final /* synthetic */ Object h(int i2, View view) {
        AppMethodBeat.i(35935);
        View e2 = e(i2, view);
        AppMethodBeat.o(35935);
        return e2;
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.b$b  reason: collision with other inner class name */
    public enum EnumC2096b {
        unkown,
        image,
        video,
        sight,
        appimage;

        public static EnumC2096b valueOf(String str) {
            AppMethodBeat.i(35890);
            EnumC2096b bVar = (EnumC2096b) Enum.valueOf(EnumC2096b.class, str);
            AppMethodBeat.o(35890);
            return bVar;
        }

        static {
            AppMethodBeat.i(35891);
            AppMethodBeat.o(35891);
        }
    }

    public b(ImageGalleryUI imageGalleryUI, long j2, String str, boolean z, long j3, boolean z2, String str2, Boolean bool, int i2) {
        AppMethodBeat.i(35892);
        this.PwE = imageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
        if (!this.PwE) {
            Assert.assertTrue("MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j2 + ", talker = " + str + ", stack = " + Util.getStack(), j2 > 0 && str != null && str.length() > 0);
        }
        this.Pwv = imageGalleryUI;
        tca = z;
        ppv = j3;
        this.gqV = str;
        this.fromScene = i2;
        this.Pww = new a(j2, str, this, bool, i2);
        this.Pwz = z2;
        this.Pwx = str2;
        this.PwA = new d(this);
        this.PwB = new j(this);
        this.PwC = new i(this);
        AppMethodBeat.o(35892);
    }

    public final p gSe() {
        boolean z;
        AppMethodBeat.i(233285);
        ca gSg = gSg();
        if (gSg == null) {
            Log.w("MicroMsg.ImageGalleryAdapter", "getCurResourceState, msgInfo is null");
            AppMethodBeat.o(233285);
            return null;
        }
        EnumC2096b cr = cr(gSg);
        Log.i("MicroMsg.ImageGalleryAdapter", "getCurResourceState, type: ".concat(String.valueOf(cr)));
        switch (cr) {
            case image:
                p gSe = this.PwA.gSe();
                AppMethodBeat.o(233285);
                return gSe;
            case sight:
                p gSe2 = this.PwC.gSe();
                AppMethodBeat.o(233285);
                return gSe2;
            case video:
                p gSe3 = this.PwB.gSe();
                AppMethodBeat.o(233285);
                return gSe3;
            case appimage:
                if (gSg.gDB()) {
                    p pVar = p.EXPIRED;
                    AppMethodBeat.o(233285);
                    return pVar;
                }
                k.b HD = k.b.HD(gSg.field_content);
                if (HD == null || HD.dCK == null || HD.dCK.length() <= 0) {
                    AppMethodBeat.o(233285);
                    return null;
                }
                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                if (bdx == null || !new o(bdx.field_fileFullPath).exists()) {
                    z = false;
                } else {
                    z = bdx.deQ() || (gSg.field_isSend == 1 && bdx.field_isUpload);
                }
                if (z) {
                    p pVar2 = p.DOWNLOADED;
                    AppMethodBeat.o(233285);
                    return pVar2;
                }
                p pVar3 = p.NOT_DOWNLOADED;
                AppMethodBeat.o(233285);
                return pVar3;
            default:
                AppMethodBeat.o(233285);
                return null;
        }
    }

    public final void onPageSelected(int i2) {
        AppMethodBeat.i(35893);
        if (this.PwA != null && j(amt(i2))) {
            this.PwA.PxQ.onPageSelected(i2);
        }
        AppMethodBeat.o(35893);
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        a aVar = this.Pww;
        return (aVar.gAZ - aVar.PwP) + a.PwO + 1;
    }

    public final int getRealCount() {
        return this.Pww.gAZ;
    }

    public final ca amt(int i2) {
        AppMethodBeat.i(35894);
        ca amY = this.Pww.amY(i2);
        AppMethodBeat.o(35894);
        return amY;
    }

    public final void gSf() {
        AppMethodBeat.i(35895);
        this.Pww.gSf();
        AppMethodBeat.o(35895);
    }

    public final g i(ca caVar, boolean z) {
        AppMethodBeat.i(35896);
        g i2 = this.PwA.i(caVar, z);
        AppMethodBeat.o(35896);
        return i2;
    }

    public static boolean j(ca caVar) {
        AppMethodBeat.i(35897);
        if (caVar == null) {
            AppMethodBeat.o(35897);
            return false;
        } else if (caVar.getType() == 3 || caVar.getType() == 39 || caVar.getType() == 13) {
            AppMethodBeat.o(35897);
            return true;
        } else {
            AppMethodBeat.o(35897);
            return false;
        }
    }

    public static boolean m(ca caVar) {
        AppMethodBeat.i(35898);
        if (caVar == null) {
            AppMethodBeat.o(35898);
            return false;
        } else if (cs(caVar)) {
            AppMethodBeat.o(35898);
            return false;
        } else if (caVar.getType() == 43 || caVar.getType() == 486539313 || caVar.getType() == 44 || caVar.getType() == 62) {
            AppMethodBeat.o(35898);
            return true;
        } else {
            AppMethodBeat.o(35898);
            return false;
        }
    }

    public static boolean cn(ca caVar) {
        AppMethodBeat.i(35899);
        if (caVar == null) {
            AppMethodBeat.o(35899);
            return false;
        } else if (caVar.getType() == 62) {
            AppMethodBeat.o(35899);
            return true;
        } else {
            AppMethodBeat.o(35899);
            return false;
        }
    }

    public static boolean co(ca caVar) {
        AppMethodBeat.i(35900);
        if (caVar == null) {
            AppMethodBeat.o(35900);
            return false;
        } else if (caVar.getType() == 49) {
            AppMethodBeat.o(35900);
            return true;
        } else {
            AppMethodBeat.o(35900);
            return false;
        }
    }

    public static boolean cp(ca caVar) {
        AppMethodBeat.i(35901);
        if (caVar == null) {
            AppMethodBeat.o(35901);
            return false;
        } else if (caVar.getType() == 268435505) {
            AppMethodBeat.o(35901);
            return true;
        } else {
            AppMethodBeat.o(35901);
            return false;
        }
    }

    public static boolean cq(ca caVar) {
        AppMethodBeat.i(35902);
        if (caVar == null) {
            AppMethodBeat.o(35902);
            return false;
        }
        boolean cWK = caVar.cWK();
        AppMethodBeat.o(35902);
        return cWK;
    }

    public static boolean b(ca caVar, g gVar) {
        AppMethodBeat.i(35903);
        if (caVar == null || gVar == null) {
            AppMethodBeat.o(35903);
            return false;
        }
        boolean a2 = q.bcS().a(gVar.localId, caVar.field_msgId, 1);
        AppMethodBeat.o(35903);
        return a2;
    }

    public final void amO(int i2) {
        AppMethodBeat.i(35904);
        ca amt = amt(i2);
        switch (cr(amt)) {
            case sight:
            case video:
                ct(amt);
                AppMethodBeat.o(35904);
                return;
            case appimage:
                String l = l(amt);
                Intent intent = new Intent(this.Pwv, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", l);
                intent.putExtra("Retr_Msg_Id", amt.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", amt.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                ImageGalleryUI imageGalleryUI = this.Pwv;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                imageGalleryUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(35904);
                return;
            default:
                cu(amt);
                AppMethodBeat.o(35904);
                return;
        }
    }

    public final void amP(int i2) {
        AppMethodBeat.i(35905);
        ca amt = amt(i2);
        switch (cr(amt)) {
            case image:
            case sight:
            case video:
                Intent intent = new Intent(this.Pwv, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", amt.field_msgId);
                ImageGalleryUI imageGalleryUI = this.Pwv;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                imageGalleryUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
        }
        AppMethodBeat.o(35905);
    }

    public static EnumC2096b cr(ca caVar) {
        AppMethodBeat.i(35906);
        EnumC2096b bVar = EnumC2096b.unkown;
        if (caVar == null) {
            EnumC2096b bVar2 = EnumC2096b.unkown;
        }
        if (cp(caVar)) {
            EnumC2096b bVar3 = EnumC2096b.appimage;
            AppMethodBeat.o(35906);
            return bVar3;
        } else if (j(caVar)) {
            EnumC2096b bVar4 = EnumC2096b.image;
            AppMethodBeat.o(35906);
            return bVar4;
        } else if (cs(caVar)) {
            EnumC2096b bVar5 = EnumC2096b.sight;
            AppMethodBeat.o(35906);
            return bVar5;
        } else if (m(caVar)) {
            EnumC2096b bVar6 = EnumC2096b.video;
            AppMethodBeat.o(35906);
            return bVar6;
        } else if (cn(caVar)) {
            EnumC2096b bVar7 = EnumC2096b.video;
            AppMethodBeat.o(35906);
            return bVar7;
        } else {
            EnumC2096b bVar8 = EnumC2096b.unkown;
            AppMethodBeat.o(35906);
            return bVar8;
        }
    }

    public static boolean cs(ca caVar) {
        AppMethodBeat.i(35907);
        if (caVar != null) {
            if (caVar.cWK()) {
                AppMethodBeat.o(35907);
                return false;
            }
            s QN = u.QN(caVar.field_imgPath);
            if (!(QN == null || QN.jsw == null || (Util.isNullOrNil(QN.jsw.iyZ) && QN.jsw.LxJ <= 0 && Util.isNullOrNil(QN.jsw.izc) && Util.isNullOrNil(QN.jsw.izd) && Util.isNullOrNil(QN.jsw.izb) && Util.isNullOrNil(QN.jsw.ize) && Util.isNullOrNil(QN.jsw.izf) && Util.isNullOrNil(QN.jsw.izg)))) {
                AppMethodBeat.o(35907);
                return true;
            }
        }
        AppMethodBeat.o(35907);
        return false;
    }

    public final void ct(ca caVar) {
        int i2 = 1;
        AppMethodBeat.i(35908);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.u.g(this.Pwv, null);
            AppMethodBeat.o(35908);
        } else if (caVar.cWK()) {
            y cG = j.cG(caVar);
            if (cG == null) {
                Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
                AppMethodBeat.o(35908);
                return;
            }
            if (this.Pwv.JjJ == null) {
                this.Pwv.JjJ = new e();
            }
            this.Pwv.JjJ.iwi = cG;
            if (!this.PwE) {
                i2 = 0;
            }
            cG.iAP = this.Pwv.PyB.pHu;
            d dVar = d.Jwx;
            d.a(this.Pwv, cG.iAo, "", cG.title, cG.url, i2);
            AppMethodBeat.o(35908);
        } else {
            s QN = u.QN(caVar.field_imgPath);
            if (QN == null) {
                Log.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                AppMethodBeat.o(35908);
                return;
            }
            Intent intent = new Intent(this.Pwv, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", QN.iFw);
            intent.putExtra("Retr_File_Name", caVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", QN.jsr);
            if (cn(caVar)) {
                i2 = 11;
            }
            intent.putExtra("Retr_Msg_Type", i2);
            intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            ImageGalleryUI imageGalleryUI = this.Pwv;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            imageGalleryUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35908);
        }
    }

    private void K(String str, int i2, long j2) {
        AppMethodBeat.i(35909);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
            AppMethodBeat.o(35909);
        } else if (Util.isNullOrNil(this.Pwx)) {
            Log.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            Intent intent = new Intent(this.Pwv, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", str);
            intent.putExtra("Retr_Msg_Id", j2);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", i2);
            ImageGalleryUI imageGalleryUI = this.Pwv;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            imageGalleryUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35909);
        } else {
            Log.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", this.Pwx);
            if (!Util.isNullOrNil(str)) {
                o.e tc = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
                tc.dRL = z.aTY();
                tc.toUser = this.Pwx;
                tc.iZt = str;
                tc.iXp = i2;
                tc.jdS = null;
                tc.jdR = 6;
                tc.bdQ().execute();
                cf.aWl().f(cf.iFI, null);
            }
            if (this.Pwy) {
                Intent intent2 = new Intent(this.Pwv, ChattingUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", this.Pwx);
                ImageGalleryUI imageGalleryUI2 = this.Pwv;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI2, bl2.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                imageGalleryUI2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI2, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                h.cD(this.Pwv, this.Pwv.getString(R.string.ym));
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10424, 3, 4, this.Pwx);
            AppMethodBeat.o(35909);
        }
    }

    public static void f(final Context context, final List<ca> list) {
        AppMethodBeat.i(233286);
        if (context == null || list == null || list.size() <= 0) {
            AppMethodBeat.o(233286);
            return;
        }
        p.a(context, new Callable<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                boolean d2;
                boolean z = false;
                AppMethodBeat.i(233274);
                boolean z2 = list.size() <= 1;
                for (ca caVar : list) {
                    if (b.m(caVar)) {
                        d2 = b.b(context, caVar, z2);
                    } else {
                        d2 = b.d(context, caVar, z2);
                    }
                    z = (z || !d2) ? z : true;
                }
                if (z2) {
                    AppMethodBeat.o(233274);
                    return "";
                } else if (z) {
                    AppMethodBeat.o(233274);
                    return "Success";
                } else {
                    AppMethodBeat.o(233274);
                    return null;
                }
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(233276);
                String str2 = str;
                if (str2 == null) {
                    p.I(context, context.getString(R.string.gap));
                    AppMethodBeat.o(233276);
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    p.I(context, context.getString(R.string.c2z, AndroidMediaUtil.getSysCameraDirPath()));
                }
                AppMethodBeat.o(233276);
            }
        });
        AppMethodBeat.o(233286);
    }

    public static void a(final Context context, final ca caVar) {
        AppMethodBeat.i(233287);
        if (context == null || caVar == null) {
            AppMethodBeat.o(233287);
            return;
        }
        p.a(context, new Callable<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass4 */
            final /* synthetic */ boolean PwK = true;

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                AppMethodBeat.i(233277);
                if (b.b(context, caVar, this.PwK)) {
                    AppMethodBeat.o(233277);
                    return "Success";
                }
                AppMethodBeat.o(233277);
                return "Fail";
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass5 */
            final /* synthetic */ boolean PwK = true;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(233278);
                String str2 = str;
                if (this.PwK && str2 == null) {
                    context.getString(R.string.c2z, context.getString(R.string.hwt));
                }
                AppMethodBeat.o(233278);
            }
        });
        AppMethodBeat.o(233287);
    }

    public static boolean b(Context context, final ca caVar, boolean z) {
        AppMethodBeat.i(35912);
        if (caVar == null) {
            AppMethodBeat.o(35912);
            return false;
        }
        final s Qq = com.tencent.mm.modelvideo.o.bhj().Qq(caVar.field_imgPath);
        boolean z2 = false;
        if (Qq != null) {
            int i2 = 0;
            if (ab.Eq(Qq.getUser())) {
                i2 = com.tencent.mm.model.v.Ie(Qq.getUser());
            }
            boolean bhy = Qq.bhy();
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(106, 216, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12084, Integer.valueOf(Qq.iKP), Integer.valueOf(Qq.iFw * 1000), 0, 2, Qq.getUser(), Integer.valueOf(i2), s.Qn(Qq.bhv()), Long.valueOf(Qq.createTime));
            z2 = bhy;
        }
        if (!z2) {
            Log.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
            if (z) {
                p.I(context, context.getString(R.string.hwt));
            }
            AppMethodBeat.o(35912);
            return false;
        }
        com.tencent.mm.modelvideo.o.bhj();
        final String Qw = t.Qw(caVar.field_imgPath);
        String L = p.L(context, Qw);
        if (Util.isNullOrNil(L)) {
            if (z) {
                p.I(context, context.getString(R.string.hwt));
            }
            AppMethodBeat.o(35912);
            return false;
        }
        if (z) {
            p.I(context, context.getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(L)));
        }
        String bhK = com.tencent.mm.vfs.s.bhK(L);
        com.tencent.mm.platformtools.v vVar = com.tencent.mm.platformtools.v.jNy;
        com.tencent.mm.platformtools.v.bR(bhK, br.KB(caVar.fqK));
        AndroidMediaUtil.refreshMediaScannerAsync(L, context);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass6 */

            public final void run() {
                j.b bVar;
                Map<String, String> emptyMap;
                int i2;
                AppMethodBeat.i(233279);
                try {
                    if (ab.Eq(caVar.field_talker)) {
                        j.b b2 = j.b(j.a.dkR);
                        if (caVar.field_isSend == 1) {
                            b2.dkU = z.aTY();
                            b2.dkV = caVar.field_talker;
                            bVar = b2;
                        } else {
                            b2.dkU = bp.Ks(caVar.field_content);
                            b2.dkV = caVar.field_talker;
                            bVar = b2;
                        }
                    } else {
                        j.b a2 = j.a(j.a.dkR);
                        if (caVar.field_isSend == 1) {
                            a2.dkU = z.aTY();
                            a2.dkV = caVar.field_talker;
                            bVar = a2;
                        } else {
                            a2.dkU = caVar.field_talker;
                            a2.dkV = z.aTY();
                            bVar = a2;
                        }
                    }
                    MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(Qw);
                    if (aTV == null) {
                        Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get video data info, skip reporting. msgId:%s, msgSvrId:%s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                        AppMethodBeat.o(233279);
                        return;
                    }
                    if (Qq != null) {
                        emptyMap = XmlParser.parseXml(Qq.bhv(), "msg", null);
                    } else {
                        emptyMap = Collections.emptyMap();
                    }
                    if (emptyMap == null) {
                        Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse recv xml. msgId:%s, msgSvrId:%s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                        AppMethodBeat.o(233279);
                        return;
                    }
                    bVar.msgId = caVar.field_msgSvrId;
                    bVar.dkW = Util.nullAsNil(emptyMap.get(".msg.videomsg.$cdnvideourl"));
                    bVar.dkX = aTV.width;
                    bVar.dkY = aTV.height;
                    bVar.dkZ = Util.nullAsNil(emptyMap.get(".msg.videomsg.$cdnthumburl"));
                    bVar.dla = (int) aTV.duration;
                    bVar.fileId = Util.nullAsNil(emptyMap.get(".msg.videomsg.$cdnvideourl"));
                    bVar.fileKey = Util.nullAsNil(emptyMap.get(".msg.videomsg.$aeskey"));
                    bVar.md5 = Util.nullAsNil(emptyMap.get(".msg.videomsg.$md5"));
                    if (ab.Eq(caVar.field_talker)) {
                        List<String> Kh = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(caVar.field_talker);
                        if (Kh != null) {
                            i2 = Kh.size();
                        } else {
                            i2 = 0;
                        }
                        bVar.dlc = i2;
                    }
                    j.a(bVar);
                    AppMethodBeat.o(233279);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", th, "[-] Exception was thrown when report.", new Object[0]);
                    AppMethodBeat.o(233279);
                }
            }
        }, "MsgVideoExportReport");
        AppMethodBeat.o(35912);
        return true;
    }

    public static void c(final Context context, final ca caVar, final boolean z) {
        AppMethodBeat.i(233288);
        if (context == null || caVar == null) {
            AppMethodBeat.o(233288);
            return;
        }
        p.a(context, new Callable<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                AppMethodBeat.i(233280);
                if (b.d(context, caVar, z)) {
                    AppMethodBeat.o(233280);
                    return "Success";
                }
                AppMethodBeat.o(233280);
                return "Fail";
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(233281);
                String str2 = str;
                if (z && str2 == null) {
                    p.I(context, context.getString(R.string.gao));
                }
                AppMethodBeat.o(233281);
            }
        });
        AppMethodBeat.o(233288);
    }

    public static boolean d(Context context, final ca caVar, boolean z) {
        final String a2;
        AppMethodBeat.i(35913);
        final g gVar = null;
        if (cp(caVar)) {
            a2 = l(caVar);
        } else if (caVar == null || caVar.field_msgId == 0) {
            Log.e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                p.I(context, context.getString(R.string.gao));
            }
            AppMethodBeat.o(35913);
            return false;
        } else {
            gVar = d.k(caVar);
            if (gVar == null || gVar.localId == 0) {
                Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (caVar == null ? BuildConfig.COMMAND : Long.valueOf(caVar.field_msgId)) + ", imgLocalId = " + (gVar == null ? BuildConfig.COMMAND : Long.valueOf(gVar.localId)));
                if (z) {
                    p.I(context, context.getString(R.string.gao));
                }
                AppMethodBeat.o(35913);
                return false;
            }
            a2 = d.a(caVar, gVar);
        }
        if (a2 == null || a2.length() == 0) {
            Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + caVar.field_msgId);
            if (z) {
                p.I(context, context.getString(R.string.gao));
            }
            AppMethodBeat.o(35913);
            return false;
        }
        String J = p.J(context, a2);
        if (!Util.isNullOrNil(J)) {
            if (z) {
                p.I(context, context.getString(R.string.bjr, AndroidMediaUtil.getToastSysCameraPath()));
            }
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass9 */

                public final void run() {
                    j.b bVar;
                    String str;
                    Map<String, String> emptyMap;
                    String str2;
                    int i2;
                    AppMethodBeat.i(233282);
                    try {
                        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(a2);
                        if (imageOptions == null) {
                            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get bmp opts. msgId:%s, msgSvrId:%s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                            AppMethodBeat.o(233282);
                            return;
                        }
                        if (ab.Eq(caVar.field_talker)) {
                            j.b b2 = j.b(j.a.dkQ);
                            if (caVar.field_isSend == 1) {
                                b2.dkU = z.aTY();
                                b2.dkV = caVar.field_talker;
                                bVar = b2;
                            } else {
                                b2.dkU = bp.Ks(caVar.field_content);
                                b2.dkV = caVar.field_talker;
                                bVar = b2;
                            }
                        } else {
                            j.b a2 = j.a(j.a.dkQ);
                            if (caVar.field_isSend == 1) {
                                a2.dkU = z.aTY();
                                a2.dkV = caVar.field_talker;
                                bVar = a2;
                            } else {
                                a2.dkU = caVar.field_talker;
                                a2.dkV = z.aTY();
                                bVar = a2;
                            }
                        }
                        String[] aIU = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIU(a2);
                        if (aIU != null) {
                            str = aIU[0];
                        } else {
                            str = "";
                        }
                        if (gVar != null) {
                            emptyMap = XmlParser.parseXml(gVar.iXy, "msg", null);
                        } else {
                            emptyMap = Collections.emptyMap();
                        }
                        if (emptyMap == null) {
                            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse cdn info. msgId:%s, msgSvrId:%s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                            AppMethodBeat.o(233282);
                            return;
                        }
                        if (gVar.iXp == 1) {
                            str2 = emptyMap.get(".msg.img.$cdnbigimgurl");
                        } else {
                            str2 = emptyMap.get(".msg.img.$cdnmidimgurl");
                        }
                        bVar.msgId = caVar.field_msgSvrId;
                        bVar.dkW = Util.nullAsNil(str2);
                        bVar.dkX = imageOptions.outWidth;
                        bVar.dkY = imageOptions.outHeight;
                        bVar.dkZ = Util.nullAsNil(emptyMap.get(".msg.img.$cdnthumburl"));
                        bVar.fileId = Util.nullAsNil(str2);
                        bVar.fileKey = Util.nullAsNil(emptyMap.get(".msg.img.$aeskey"));
                        bVar.md5 = com.tencent.mm.b.g.getMD5(a2);
                        bVar.dlb = str;
                        if (ab.Eq(caVar.field_talker)) {
                            List<String> Kh = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(caVar.field_talker);
                            if (Kh != null) {
                                i2 = Kh.size();
                            } else {
                                i2 = 0;
                            }
                            bVar.dlc = i2;
                        }
                        j.a(bVar);
                        AppMethodBeat.o(233282);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", th, "[-] Exception was thrown when report.", new Object[0]);
                        AppMethodBeat.o(233282);
                    }
                }
            }, "MsgImgExportReport");
            String bhK = com.tencent.mm.vfs.s.bhK(J);
            com.tencent.mm.platformtools.v vVar = com.tencent.mm.platformtools.v.jNy;
            com.tencent.mm.platformtools.v.bR(bhK, br.KB(caVar.fqK));
            AppMethodBeat.o(35913);
            return true;
        }
        if (z) {
            p.I(context, context.getString(R.string.gao));
        }
        AppMethodBeat.o(35913);
        return false;
    }

    public final void amQ(int i2) {
        AppMethodBeat.i(35914);
        ca amt = amt(i2);
        if (this.PwE) {
            y cG = j.cG(amt);
            if (cG == null) {
                Log.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
                AppMethodBeat.o(35914);
                return;
            }
            f fVar = f.JwB;
            f.b(cG);
            h.cD(this.Pwv, this.Pwv.getString(R.string.caf));
            AppMethodBeat.o(35914);
            return;
        }
        cz czVar = new cz();
        com.tencent.mm.pluginsdk.model.h.d(czVar, amt);
        czVar.dFZ.activity = this.Pwv;
        czVar.dFZ.dGf = 44;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0) {
            if (amt.cWL()) {
                com.tencent.mm.ui.chatting.a.a(a.c.Fav, a.d.Full, amt, 0);
            }
            com.tencent.mm.modelstat.b.jmd.ac(amt);
        }
        AppMethodBeat.o(35914);
    }

    public final View e(int i2, View view) {
        final k kVar;
        Bitmap Sq;
        AppMethodBeat.i(35915);
        final ca amt = amt(i2);
        if (view == null) {
            view = View.inflate(this.Pwv, R.layout.avk, null);
            k kVar2 = new k(this, view);
            view.setTag(kVar2);
            kVar = kVar2;
        } else {
            kVar = (k) view.getTag();
        }
        EnumC2096b cr = cr(amt);
        kVar.mPosition = i2;
        kVar.PAD = cr;
        k.ai(kVar.convertView, 0);
        switch (k.AnonymousClass5.PwJ[cr.ordinal()]) {
            case 1:
                k.ai(kVar.PAL, 8);
                k.ai(kVar.PAF, 8);
                break;
            case 2:
                kVar.gTe();
                float I = br.I(amt);
                kVar.PAM.setScaleX(I);
                kVar.PAM.setScaleY(I);
                ((View) kVar.PAO).setScaleX(I);
                ((View) kVar.PAO).setScaleY(I);
                k.ai(kVar.PAL, 0);
                k.ai(kVar.PAF, 8);
                if (kVar.PAF != null) {
                    k.ai(kVar.PAH, 8);
                    break;
                }
                break;
            case 3:
                kVar.gTd();
                k.ai(kVar.PAL, 8);
                k.ai(kVar.PAF, 0);
                break;
            case 4:
                k.ai(kVar.convertView, 8);
                k.ai(kVar.PAL, 8);
                k.ai(kVar.PAF, 8);
                break;
        }
        k.ai(kVar.PBc, 8);
        k.ai(kVar.PBd, 8);
        k.ai(kVar.PAT, 8);
        k.ai(kVar.PAZ, 8);
        k.ai(kVar.PAY, 8);
        Log.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", Integer.valueOf(i2), cr);
        switch (cr) {
            case image:
                this.PwA.a(kVar, amt, i2);
                if (i2 == a.PwO) {
                    ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).as(amt);
                    break;
                }
                break;
            case sight:
                this.PwC.a(kVar, amt, i2);
                break;
            case video:
                this.PwB.a(kVar, amt, i2);
                break;
            case appimage:
                k.ai(kVar.PBc, 0);
                k.ai(kVar.PAT, 8);
                k.ai(kVar.PAY, 8);
                k.ai(kVar.PAZ, 8);
                k.ai(kVar.PAP, 8);
                final String l = l(amt);
                try {
                    Sq = com.tencent.mm.platformtools.u.Sr(l);
                } catch (OutOfMemoryError e2) {
                    Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", l);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    Sq = com.tencent.mm.platformtools.u.Sq(l);
                }
                if (Sq == null) {
                    Sq = com.tencent.mm.platformtools.u.Sq(q.bcR().R(amt.field_imgPath, true));
                    k.ai(kVar.PAY, 0);
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass10 */

                        public final void run() {
                            AppMethodBeat.i(233284);
                            m.a(amt, new m.a() {
                                /* class com.tencent.mm.ui.chatting.gallery.b.AnonymousClass10.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.model.app.m.a
                                public final void kA(int i2, int i3) {
                                    Bitmap Sq;
                                    AppMethodBeat.i(233283);
                                    if (i2 == i3) {
                                        Log.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", Long.valueOf(amt.field_msgId));
                                        k.ai(kVar.PAY, 8);
                                        try {
                                            Sq = com.tencent.mm.platformtools.u.Sr(l);
                                        } catch (OutOfMemoryError e2) {
                                            Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", l);
                                            Runtime.getRuntime().gc();
                                            Runtime.getRuntime().runFinalization();
                                            Sq = com.tencent.mm.platformtools.u.Sq(l);
                                        }
                                        if (Sq != null) {
                                            kVar.PBc.setEnableHorLongBmpMode(false);
                                            ForceGpuUtil.decideLayerType(kVar.PBc, Sq.getWidth(), Sq.getHeight());
                                            kVar.PBc.cN(Sq.getWidth(), Sq.getHeight());
                                            kVar.PBc.setImageBitmap(Sq);
                                            kVar.PBc.invalidate();
                                        }
                                    }
                                    AppMethodBeat.o(233283);
                                }
                            });
                            AppMethodBeat.o(233284);
                        }
                    });
                }
                if (Sq == null) {
                    Log.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                    kVar.PBc.setVisibility(8);
                    kVar.gTc().PAZ.setVisibility(0);
                    kVar.gTc().PBb.setImageResource(R.raw.image_download_fail_icon);
                    kVar.gTc().PBa.setText(this.Pwv.getString(R.string.e35));
                } else {
                    kVar.PBc.setEnableHorLongBmpMode(false);
                    ForceGpuUtil.decideLayerType(kVar.PBc, Sq.getWidth(), Sq.getHeight());
                    kVar.PBc.cN(Sq.getWidth(), Sq.getHeight());
                    kVar.PBc.setImageBitmap(Sq);
                    kVar.PBc.invalidate();
                }
                if (i2 == a.PwO) {
                    ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).as(amt);
                    break;
                }
                break;
        }
        this.PwG = false;
        AppMethodBeat.o(35915);
        return view;
    }

    @Override // com.tencent.mm.ui.base.v
    public final void detach() {
        AppMethodBeat.i(35917);
        this.PwA.detach();
        this.PwB.detach();
        this.PwC.detach();
        if (this.PwH != null) {
            x acc = this.PwH.acc();
            acc.emV = x.a.cancel;
            acc.bfK();
        }
        super.detach();
        AppMethodBeat.o(35917);
    }

    public static class a {
        public static int PwO = 100000;
        int PwP;
        protected int PwQ;
        protected int PwR;
        protected int PwS;
        protected long PwT;
        private b PwU;
        public HashMap<Long, g> PwV = new HashMap<>();
        public HashMap<Long, g> PwW = new HashMap<>();
        protected boolean bcY = false;
        private int fromScene;
        int gAZ;
        private MMHandler handler = new MMHandler();
        private int min;
        private String talker;
        private List<ca> uDs;

        public a(final long j2, String str, final b bVar, final Boolean bool, int i2) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(35881);
            this.talker = str;
            this.uDs = new LinkedList();
            this.PwU = bVar;
            this.fromScene = i2;
            if (bVar.PwE) {
                this.uDs.add(j.f(str, bVar.Pwv));
                PwO = 0;
                AppMethodBeat.o(35881);
                return;
            }
            PwO = 100000;
            bg.aVF();
            ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
            if (Hb.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j2 + ", stack = " + Util.getStack(), false);
                AppMethodBeat.o(35881);
                return;
            }
            this.uDs.add(Hb);
            if (this.fromScene == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (!(this.fromScene != 2 ? false : z2)) {
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.b.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(35879);
                            a.a(a.this, j2);
                            if (bool.booleanValue()) {
                                a.this.handler.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.gallery.b.a.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(35878);
                                        a.a(a.this);
                                        if (bVar.PwD != null) {
                                            bVar.PwD.tf();
                                        }
                                        AppMethodBeat.o(35878);
                                    }
                                }, 0);
                            }
                            AppMethodBeat.o(35879);
                        }
                    });
                    bVar.Pwv.Pzw = new ImageGalleryUI.b() {
                        /* class com.tencent.mm.ui.chatting.gallery.b.a.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.b
                        public final void t(Boolean bool) {
                            AppMethodBeat.i(35880);
                            Log.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(bool)));
                            if (!bool.booleanValue()) {
                                a.a(a.this);
                                if (bVar.PwD != null) {
                                    bVar.PwD.tf();
                                }
                            }
                            AppMethodBeat.o(35880);
                        }
                    };
                    AppMethodBeat.o(35881);
                    return;
                }
            }
            AppMethodBeat.o(35881);
        }

        private void js(List<ca> list) {
            AppMethodBeat.i(35882);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (b.j(list.get(i2))) {
                    arrayList.add(Long.valueOf(list.get(i2).field_msgSvrId));
                    if (list.get(i2).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(list.get(i2).field_msgId));
                    }
                }
            }
            this.PwV.putAll(q.bcR().a((Long[]) arrayList.toArray(new Long[0])));
            this.PwW.putAll(q.bcR().b((Long[]) arrayList2.toArray(new Long[0])));
            AppMethodBeat.o(35882);
        }

        public final void a(long j2, g gVar, boolean z) {
            AppMethodBeat.i(35883);
            if (z) {
                this.PwV.put(Long.valueOf(j2), gVar);
                AppMethodBeat.o(35883);
                return;
            }
            this.PwW.put(Long.valueOf(j2), gVar);
            AppMethodBeat.o(35883);
        }

        public final int amX(int i2) {
            return (i2 - PwO) + this.PwP;
        }

        public final ca amY(int i2) {
            AppMethodBeat.i(35884);
            int amX = amX(i2);
            int size = (this.min + this.uDs.size()) - 1;
            if (amX < this.min || amX > size) {
                Log.e("MicroMsg.AutoList", "get, invalid pos " + amX + ", min = " + this.min + ", max = " + size);
                AppMethodBeat.o(35884);
                return null;
            }
            Log.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(amX)));
            if (amX == this.min) {
                ca caVar = this.uDs.get(0);
                if (this.bcY) {
                    R(caVar.field_msgId, false);
                }
                AppMethodBeat.o(35884);
                return caVar;
            } else if (amX != size || size >= this.gAZ - 1) {
                ca caVar2 = this.uDs.get(amX - this.min);
                AppMethodBeat.o(35884);
                return caVar2;
            } else {
                ca caVar3 = this.uDs.get(this.uDs.size() - 1);
                if (this.bcY) {
                    R(caVar3.field_msgId, true);
                }
                AppMethodBeat.o(35884);
                return caVar3;
            }
        }

        public final void gSf() {
            this.bcY = false;
        }

        private void R(long j2, boolean z) {
            List<ca> f2;
            AppMethodBeat.i(35885);
            Log.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j2 + ", forward = " + z);
            if (b.tca) {
                bg.aVF();
                f2 = com.tencent.mm.model.c.aSR().b(this.talker, b.ppv, j2, z);
            } else {
                bg.aVF();
                f2 = com.tencent.mm.model.c.aSQ().f(this.talker, j2, z);
            }
            if (f2 == null || f2.size() == 0) {
                Log.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(z)));
                AppMethodBeat.o(35885);
                return;
            }
            Log.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + f2.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            js(f2);
            Log.i("MicroMsg.AutoList", "loadImgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (z) {
                this.uDs.addAll(f2);
                AppMethodBeat.o(35885);
                return;
            }
            this.uDs.addAll(0, f2);
            this.min -= f2.size();
            if (this.min < 0) {
                Log.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
                AppMethodBeat.o(35885);
                return;
            }
            Log.i("MicroMsg.AutoList", "min from " + (f2.size() + this.min) + " to " + this.min);
            AppMethodBeat.o(35885);
        }

        public final String toString() {
            AppMethodBeat.i(35886);
            StringBuilder sb = new StringBuilder();
            sb.append("AutoList, Size = " + this.uDs.size());
            sb.append("; Content = {");
            for (ca caVar : this.uDs) {
                sb.append(caVar.field_msgId);
                sb.append(",");
            }
            sb.append("}");
            String sb2 = sb.toString();
            AppMethodBeat.o(35886);
            return sb2;
        }

        static /* synthetic */ void a(a aVar, long j2) {
            AppMethodBeat.i(35887);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.AutoList", "isBizChat = " + b.tca);
            if (b.tca) {
                bg.aVF();
                aVar.PwQ = com.tencent.mm.model.c.aSR().cd(aVar.talker, b.ppv);
            } else {
                bg.aVF();
                aVar.PwQ = com.tencent.mm.model.c.aSQ().aEN(aVar.talker);
            }
            Log.i("MicroMsg.AutoList", "<init>, totalCount = " + aVar.PwQ);
            Log.i("MicroMsg.AutoList", "totalCount spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b.tca) {
                bg.aVF();
                aVar.PwR = com.tencent.mm.model.c.aSR().M(aVar.talker, b.ppv, j2);
            } else {
                bg.aVF();
                aVar.PwR = com.tencent.mm.model.c.aSQ().aV(aVar.talker, j2);
            }
            Log.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                bg.aVF();
                Log.w("MicroMsg.AutoList", "explain : %s", com.tencent.mm.model.c.aSQ().aW(aVar.talker, j2));
            }
            aVar.PwS = aVar.PwR;
            aVar.PwT = j2;
            AppMethodBeat.o(35887);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(35888);
            aVar.bcY = true;
            aVar.gAZ = aVar.PwQ;
            aVar.min = aVar.PwR;
            aVar.PwP = aVar.PwS;
            Log.i("MicroMsg.AutoList", "totalCount %s min %s start %s", Integer.valueOf(aVar.gAZ), Integer.valueOf(aVar.min), Integer.valueOf(aVar.PwP));
            Log.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - System.currentTimeMillis()));
            long currentTimeMillis = System.currentTimeMillis();
            aVar.R(aVar.PwT, true);
            Log.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar.R(aVar.PwT, false);
            Log.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            aVar.PwU.notifyDataSetChanged();
            if (!aVar.PwU.Pwv.isFinishing() && PwO > 0) {
                aVar.PwU.e(PwO - 1, (View) aVar.PwU.OUA.get(PwO - 1));
            }
            AppMethodBeat.o(35888);
        }
    }

    @Override // com.tencent.mm.ui.base.v
    public final int firstItemPosForDetermine() {
        AppMethodBeat.i(233289);
        int i2 = a.PwO - this.Pww.PwP;
        AppMethodBeat.o(233289);
        return i2;
    }

    @Override // com.tencent.mm.ui.base.v
    public final int lastItemPosForDetermine() {
        AppMethodBeat.i(233290);
        int i2 = ((a.PwO - this.Pww.PwP) + this.Pww.gAZ) - 1;
        AppMethodBeat.o(233290);
        return i2;
    }

    public final void bH(int i2, boolean z) {
        AppMethodBeat.i(35919);
        this.PwA.bH(i2, z);
        AppMethodBeat.o(35919);
    }

    @Override // com.tencent.mm.ui.base.v
    public final MultiTouchImageView NQ(int i2) {
        AppMethodBeat.i(35920);
        View abm = super.abm(i2);
        if (abm == null) {
            Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i2));
            AppMethodBeat.o(35920);
            return null;
        }
        View findViewById = abm.findViewById(R.id.dup);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            AppMethodBeat.o(35920);
            return null;
        }
        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) findViewById;
        AppMethodBeat.o(35920);
        return multiTouchImageView;
    }

    @Override // com.tencent.mm.ui.base.v
    public final WxImageView NR(int i2) {
        AppMethodBeat.i(35921);
        View abm = super.abm(i2);
        if (abm == null) {
            AppMethodBeat.o(35921);
            return null;
        }
        View findViewById = abm.findViewById(R.id.jrc);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            AppMethodBeat.o(35921);
            return null;
        }
        WxImageView wxImageView = (WxImageView) findViewById;
        AppMethodBeat.o(35921);
        return wxImageView;
    }

    public final View amR(int i2) {
        AppMethodBeat.i(35922);
        View abm = super.abm(i2);
        if (abm == null) {
            Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", Integer.valueOf(i2));
            AppMethodBeat.o(35922);
            return null;
        }
        View findViewById = abm.findViewById(R.id.j46);
        if (findViewById == null) {
            findViewById = abm.findViewById(R.id.j44);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            AppMethodBeat.o(35922);
            return null;
        }
        AppMethodBeat.o(35922);
        return findViewById;
    }

    public final void amS(int i2) {
        AppMethodBeat.i(35923);
        this.PwB.j(amt(i2), i2);
        AppMethodBeat.o(35923);
    }

    public final void amT(int i2) {
        AppMethodBeat.i(35924);
        this.PwB.k(amt(i2), i2);
        AppMethodBeat.o(35924);
    }

    public final ca gSg() {
        AppMethodBeat.i(35925);
        ca amt = amt(this.Pwv.getCurrentItem());
        AppMethodBeat.o(35925);
        return amt;
    }

    public final k gSh() {
        AppMethodBeat.i(35926);
        k amM = this.PwA.amM(this.Pwv.getCurrentItem());
        if (amM == null) {
            amM = this.PwB.amM(this.Pwv.getCurrentItem());
        }
        if (amM == null) {
            amM = this.PwC.amM(this.Pwv.getCurrentItem());
        }
        AppMethodBeat.o(35926);
        return amM;
    }

    public final void amU(int i2) {
        AppMethodBeat.i(35927);
        this.PwB.amN(i2);
        AppMethodBeat.o(35927);
    }

    @Override // android.support.v4.view.q
    public final void notifyDataSetChanged() {
        AppMethodBeat.i(35928);
        super.notifyDataSetChanged();
        AppMethodBeat.o(35928);
    }

    public final void gSi() {
        AppMethodBeat.i(35929);
        this.PwB.onResume();
        AppMethodBeat.o(35929);
    }

    public final void amV(int i2) {
        AppMethodBeat.i(35930);
        ca amt = amt(i2);
        if (amt == null || !j(amt)) {
            AppMethodBeat.o(35930);
            return;
        }
        this.PwA.cz(amt);
        AppMethodBeat.o(35930);
    }

    public final void amW(int i2) {
        AppMethodBeat.i(35931);
        this.PwC.anb(i2);
        AppMethodBeat.o(35931);
    }

    @Override // com.tencent.mm.ui.base.v, android.support.v4.view.q
    public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        AppMethodBeat.i(35932);
        viewGroup.removeView((View) obj);
        super.destroyItem(viewGroup, i2, obj);
        AppMethodBeat.o(35932);
    }

    public final void j(ca caVar, boolean z) {
        int i2 = 2;
        AppMethodBeat.i(35933);
        if (caVar == null) {
            AppMethodBeat.o(35933);
            return;
        }
        ca gSg = gSg();
        if (gSg == null || gSg.field_msgId != caVar.field_msgId) {
            Log.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", Long.valueOf(gSg.field_msgId), Long.valueOf(caVar.field_msgId));
            AppMethodBeat.o(35933);
            return;
        }
        long j2 = caVar.field_msgSvrId;
        if (!(this.PwH == null || (this.PwH.emN == j2 && this.PwH.emP == z))) {
            x acc = this.PwH.acc();
            acc.emV = x.a.cancel;
            acc.bfK();
        }
        this.PwH = new x();
        this.PwH.acb();
        x xVar = this.PwH;
        xVar.emN = j2;
        xVar.emO = caVar.field_createTime;
        xVar.emP = z;
        if (ab.Eq(this.gqV)) {
            i2 = com.tencent.mm.model.v.Ie(this.gqV);
        }
        x xVar2 = this.PwH;
        xVar2.emL = xVar2.x("ChatName", this.gqV, true);
        xVar2.emM = (long) i2;
        AppMethodBeat.o(35933);
    }

    public final void a(ca caVar, g gVar, int i2, x.a aVar) {
        AppMethodBeat.i(35934);
        if (caVar == null) {
            AppMethodBeat.o(35934);
        } else if (this.PwH == null) {
            AppMethodBeat.o(35934);
        } else {
            this.PwH.acc().emV = aVar;
            long j2 = caVar.field_msgSvrId;
            boolean z = i2 == 1;
            if (this.PwH.emN == j2 || this.PwH.emP == z) {
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long currentTicks = Util.currentTicks();
                if (aVar == x.a.ok) {
                    String a2 = d.a(caVar, gVar);
                    if (!Util.isNullOrNil(a2)) {
                        j3 = com.tencent.mm.vfs.s.boW(a2);
                        BitmapFactory.Options bmT = d.bmT(a2);
                        j5 = (long) bmT.outWidth;
                        j4 = (long) bmT.outHeight;
                    }
                }
                x xVar = this.PwH;
                xVar.emQ = j3;
                xVar.emS = j4;
                xVar.emR = j5;
                this.PwH.bfK();
                Log.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", Long.valueOf(Util.ticksToNow(currentTicks)), this.PwH.abV());
                this.PwH = null;
                AppMethodBeat.o(35934);
                return;
            }
            Log.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", Long.valueOf(this.PwH.emN), Long.valueOf(j2));
            x xVar2 = this.PwH;
            xVar2.emV = x.a.cancel;
            xVar2.bfK();
            AppMethodBeat.o(35934);
        }
    }

    public final void cu(ca caVar) {
        AppMethodBeat.i(35910);
        g k = d.k(caVar);
        if (caVar == null || caVar.field_msgId == 0 || k == null || k.localId == 0) {
            Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (caVar == null ? BuildConfig.COMMAND : Long.valueOf(caVar.field_msgId)) + ", imgLocalId = " + (k == null ? BuildConfig.COMMAND : Long.valueOf(k.localId)));
            AppMethodBeat.o(35910);
            return;
        }
        String a2 = d.a(caVar, k);
        if (Util.isNullOrNil(a2)) {
            Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + caVar.field_msgId + ", imgLocalId = " + k.localId);
            AppMethodBeat.o(35910);
            return;
        }
        K(a2, c(caVar, k), caVar.field_msgId);
        AppMethodBeat.o(35910);
    }

    public static String l(ca caVar) {
        com.tencent.mm.pluginsdk.model.app.c bdx;
        String str = null;
        AppMethodBeat.i(35916);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null) {
            AppMethodBeat.o(35916);
        } else {
            if (!(HD.dCK == null || HD.dCK.length() <= 0 || (bdx = ao.cgO().bdx(HD.dCK)) == null)) {
                str = bdx.field_fileFullPath;
            }
            AppMethodBeat.o(35916);
        }
        return str;
    }

    public static int c(ca caVar, g gVar) {
        g a2;
        g a3;
        AppMethodBeat.i(35918);
        if (caVar.field_isSend == 1) {
            if (!gVar.bcv() || (a3 = com.tencent.mm.av.h.a(gVar)) == null || a3.localId <= 0 || !a3.bcu() || !com.tencent.mm.vfs.s.YS(q.bcR().o(a3.iXm, "", ""))) {
                AppMethodBeat.o(35918);
                return 0;
            }
            AppMethodBeat.o(35918);
            return 1;
        } else if (!gVar.bcu()) {
            AppMethodBeat.o(35918);
            return 0;
        } else if (!gVar.bcv() || (a2 = com.tencent.mm.av.h.a(gVar)) == null || a2.localId <= 0 || !a2.bcu() || !com.tencent.mm.vfs.s.YS(q.bcR().o(a2.iXm, "", ""))) {
            AppMethodBeat.o(35918);
            return 0;
        } else {
            AppMethodBeat.o(35918);
            return 1;
        }
    }
}
