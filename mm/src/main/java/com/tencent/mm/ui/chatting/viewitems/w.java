package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.av;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class w {

    public static final class b extends c {
        private final long PKT = 259200000;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 268435505) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36970);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rl);
                view.setTag(new a().gT(view));
            }
            AppMethodBeat.o(36970);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            int indexOf;
            AppMethodBeat.i(36971);
            final a aVar3 = (a) aVar;
            this.PhN = aVar2;
            ((m) aVar2.bh(m.class)).bZ(caVar);
            k.b bVar = null;
            String str2 = caVar.field_content;
            if (aVar2.gRM() && (indexOf = caVar.field_content.indexOf(58)) != -1) {
                str2 = caVar.field_content.substring(indexOf + 1);
            }
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                g gE = h.gE(bVar.appId, bVar.appVersion);
                if (gE != null) {
                    b(aVar2, bVar, caVar);
                }
                String str3 = (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? bVar.appName : gE.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !h.gp(str3)) {
                    aVar3.tln.setVisibility(8);
                } else {
                    aVar3.tln.setText(h.a(aVar2.Pwc.getContext(), gE, str3));
                    aVar3.tln.setVisibility(0);
                    if (gE == null || !gE.NA()) {
                        a(aVar2, (View) aVar3.tln, bVar.appId);
                    } else {
                        a(aVar2, aVar3.tln, caVar, bVar, gE.field_packageName, caVar.field_msgSvrId);
                    }
                    a(aVar2, aVar3.tln, bVar.appId);
                }
                if (bVar.fQR == null || bVar.fQR.length() == 0) {
                    aVar3.PHZ.setVisibility(8);
                } else {
                    aVar3.PHZ.setVisibility(0);
                    b(aVar2, aVar3.PHZ, bq.bnn(bVar.fQR));
                }
                switch (bVar.type) {
                    case 2:
                        aVar3.xdY.setVisibility(0);
                        com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(bVar.dCK);
                        String str4 = caVar.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (bdx != null) {
                            str4 = bdx.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!q.bcR().a(aVar3.xdY, str4, bool.booleanValue(), com.tencent.mm.cb.a.getDensity(aVar2.Pwc.getContext()), bVar.ixa, bVar.iwZ, aVar3.xnz, R.drawable.f3080me, 1, (View) null)) {
                            if (this.qoo) {
                                aVar3.xdY.setImageResource(R.raw.chatfrom_bg_pic);
                            } else {
                                aVar3.xdY.setImageBitmap(BitmapFactory.decodeResource(aVar2.Pwc.getMMResources(), R.drawable.f3080me));
                            }
                            aVar3.xdY.post(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.viewitems.w.b.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(36966);
                                    aVar3.xdY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                                    aVar3.xnz.setLayoutParams(new FrameLayout.LayoutParams(aVar3.xdY.getWidth(), aVar3.xdY.getHeight()));
                                    AppMethodBeat.o(36966);
                                }
                            });
                            break;
                        }
                        break;
                }
                if (aVar2.gRM()) {
                    aVar3.PKS.setVisibility(8);
                } else if (h.k(gE)) {
                    aVar3.PKS.setVisibility(0);
                    aVar3.PHZ.setVisibility(8);
                    c(aVar2, aVar3.PKS, bq.a(bVar, caVar));
                } else {
                    aVar3.PKS.setVisibility(8);
                }
            }
            aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            aVar3.clickArea.setOnClickListener(d(aVar2));
            if (this.qoo) {
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            AppMethodBeat.o(36971);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            int i2;
            int i3;
            AppMethodBeat.i(233727);
            if (view == null || caVar == null) {
                AppMethodBeat.o(233727);
            } else {
                int i4 = ((bq) view.getTag()).position;
                com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
                if (h.l(h.o(k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend)).appId, false, false))) {
                    mVar.a(i4, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i4, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (caVar.field_status != 5) {
                    MenuItem a2 = mVar.a(i4, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, view.getContext().getString(R.string.ayz), R.raw.icons_filled_pencil);
                    int[] iArr = new int[2];
                    if (view != null) {
                        i3 = view.getWidth();
                        i2 = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i2).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    a2.setIntent(intent);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                boolean s = h.s(this.PhN.Pwc.getContext(), 2);
                if (efVar.dHz.dGX || s) {
                    mVar.a(i4, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (br.B(caVar)) {
                    mVar.clear();
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i4, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                }
                AppMethodBeat.o(233727);
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            int i2;
            int i3;
            String str;
            int i4;
            String str2;
            int i5;
            Bundle bundle;
            AppMethodBeat.i(36974);
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(aVar.Pwc.getContext(), aVar.Pwc.getContentView());
                AppMethodBeat.o(36974);
                return true;
            }
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            k.b bVar = null;
            String b2 = bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend);
            if (b2 != null) {
                bVar = k.b.HD(b2);
            }
            if (bVar == null) {
                Log.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                AppMethodBeat.o(36974);
                return true;
            }
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                i2 = view.getHeight();
                i3 = width;
            } else {
                i2 = 0;
                i3 = 0;
            }
            g o = h.o(bVar.appId, true, false);
            if (o != null && o.NA()) {
                a(aVar, bVar, d(aVar, caVar), o, caVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            if (bVar.dCK != null && bVar.dCK.length() > 0) {
                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(bVar.dCK);
                if (bdx != null && bdx.deQ()) {
                    String str3 = bdx.field_fileFullPath;
                    if (!s.YS(str3)) {
                        Log.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", str3, Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                        Intent intent = new Intent();
                        intent.setClassName(aVar.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent.putExtra("clean_view_type", 1);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(36974);
                        return true;
                    } else if (str3 == null || str3.equals("") || !s.YS(str3)) {
                        Log.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                    } else {
                        long j2 = caVar.field_msgId;
                        long j3 = caVar.field_msgSvrId;
                        String str4 = caVar.field_talker;
                        Log.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
                        Intent intent2 = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", j2);
                        intent2.putExtra("img_gallery_talker", str4);
                        intent2.putExtra("img_gallery_left", iArr[0]);
                        intent2.putExtra("img_gallery_top", iArr[1]);
                        intent2.putExtra("img_gallery_width", i3);
                        intent2.putExtra("img_gallery_height", i2);
                        String talkerUserName = this.PhN.getTalkerUserName();
                        String a2 = a(this.PhN, caVar);
                        Bundle bundle2 = new Bundle();
                        if (this.PhN.gRM()) {
                            str2 = "stat_scene";
                            i5 = 2;
                            bundle = bundle2;
                        } else {
                            str2 = "stat_scene";
                            if (ab.IT(talkerUserName)) {
                                i5 = 7;
                                bundle = bundle2;
                            } else {
                                i5 = 1;
                                bundle = bundle2;
                            }
                        }
                        bundle.putInt(str2, i5);
                        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j3));
                        bundle2.putString("stat_chat_talker_username", talkerUserName);
                        bundle2.putString("stat_send_msg_user", a2);
                        intent2.putExtra("_stat_obj", bundle2);
                        com.tencent.mm.ui.chatting.e.a aVar2 = this.PhN;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar2, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar2.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                } else if (caVar.field_isSend == 0) {
                    long j4 = caVar.field_msgId;
                    Intent intent3 = new Intent();
                    intent3.setClassName(this.PhN.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent3.putExtra("app_msg_id", j4);
                    com.tencent.mm.ui.chatting.e.a aVar3 = this.PhN;
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar3, bl3.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar3.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar3, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else if (bVar.url != null && bVar.url.length() > 0) {
                String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, "message");
                PackageInfo packageInfo = getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                if (packageInfo == null) {
                    str = null;
                } else {
                    str = packageInfo.versionName;
                }
                if (packageInfo == null) {
                    i4 = 0;
                } else {
                    i4 = packageInfo.versionCode;
                }
                a(aVar, R, R, str, i4, bVar.appId, false, caVar.field_msgId, caVar.field_msgSvrId, caVar);
            }
            AppMethodBeat.o(36974);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            boolean z;
            com.tencent.mm.pluginsdk.model.app.c bdx;
            AppMethodBeat.i(36973);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.HD(str);
            }
            switch (menuItem.getItemId()) {
                case 111:
                    final String str2 = null;
                    if (!(bVar == null || bVar.dCK == null || bVar.dCK.length() <= 0 || (bdx = ao.cgO().bdx(bVar.dCK)) == null)) {
                        str2 = bdx.field_fileFullPath;
                    }
                    if (!caVar.gDB()) {
                        if (System.currentTimeMillis() - caVar.field_createTime <= 259200000 || (!Util.isNullOrNil(str2) && s.YS(str2))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            new MMHandler().post(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.viewitems.w.b.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(36967);
                                    com.tencent.mm.pluginsdk.model.app.m.a(caVar, (m.a) null);
                                    AppMethodBeat.o(36967);
                                }
                            });
                            final String N = br.N(caVar);
                            if (Util.isNullOrNil(N)) {
                                Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                                intent.putExtra("Retr_File_Name", str2);
                                intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                                intent.putExtra("Retr_Msg_Type", 16);
                                intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                aVar.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 3, N);
                                com.tencent.mm.ui.base.h.a((Context) aVar.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.w.b.AnonymousClass4 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(36968);
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", N);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 1, N);
                                        AppMethodBeat.o(36968);
                                    }
                                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.w.b.AnonymousClass5 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(36969);
                                        Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                                        intent.putExtra("Retr_File_Name", str2);
                                        intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                                        intent.putExtra("Retr_Msg_Type", 16);
                                        intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                                        com.tencent.mm.ui.chatting.e.a aVar = aVar;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        aVar.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 2, N);
                                        AppMethodBeat.o(36969);
                                    }
                                });
                            }
                            AppMethodBeat.o(36973);
                            return false;
                        }
                    }
                    Log.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                    com.tencent.mm.ui.base.h.d(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.e35), aVar.Pwc.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.w.b.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(36973);
                    return false;
                case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                    w.a(aVar, menuItem, caVar);
                    AppMethodBeat.o(36973);
                    return false;
                default:
                    AppMethodBeat.o(36973);
                    return false;
            }
        }
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 268435505) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36976);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sz);
                view.setTag(new a().gT(view));
            }
            AppMethodBeat.o(36976);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(36977);
            final a aVar3 = (a) aVar;
            this.PhN = aVar2;
            ((com.tencent.mm.ui.chatting.d.b.m) aVar2.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(caVar);
            k.b bVar = null;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                g gE = h.gE(bVar.appId, bVar.appVersion);
                String str3 = (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? bVar.appName : gE.field_appName;
                if (bVar.appId == null || bVar.appId.length() <= 0 || !h.gp(str3)) {
                    aVar3.tln.setVisibility(8);
                } else {
                    aVar3.tln.setText(h.a(aVar2.Pwc.getContext(), gE, str3));
                    aVar3.tln.setVisibility(0);
                    if (gE == null || !gE.NA()) {
                        a(aVar2, (View) aVar3.tln, bVar.appId);
                    } else {
                        a(aVar2, aVar3.tln, caVar, bVar, gE.field_packageName, caVar.field_msgSvrId);
                    }
                    a(aVar2, aVar3.tln, bVar.appId);
                }
                switch (bVar.type) {
                    case 2:
                        aVar3.xdY.setVisibility(0);
                        com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(bVar.dCK);
                        String str4 = caVar.field_imgPath;
                        Boolean bool = Boolean.FALSE;
                        if (bdx != null) {
                            str4 = bdx.field_fileFullPath;
                            bool = Boolean.TRUE;
                        }
                        if (!q.bcR().a(aVar3.xdY, str4, bool.booleanValue(), com.tencent.mm.cb.a.getDensity(aVar2.Pwc.getContext()), bVar.thumbWidth, bVar.thumbHeight, aVar3.xnz, R.drawable.f3080me, 0, (View) null)) {
                            if (this.qoo) {
                                aVar3.xdY.setImageResource(R.raw.chatfrom_bg_pic);
                            } else {
                                aVar3.xdY.setImageBitmap(BitmapFactory.decodeResource(aVar2.Pwc.getMMResources(), R.drawable.f3080me));
                            }
                            aVar3.xdY.post(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.viewitems.w.c.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(36975);
                                    aVar3.xdY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                                    aVar3.xnz.setLayoutParams(new FrameLayout.LayoutParams(aVar3.xdY.getWidth(), aVar3.xdY.getHeight()));
                                    AppMethodBeat.o(36975);
                                }
                            });
                            break;
                        }
                        break;
                }
            }
            aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            aVar3.clickArea.setOnClickListener(d(aVar2));
            if (this.qoo) {
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            int bdI = com.tencent.mm.pluginsdk.model.app.m.bdI(str2);
            if (bdI == -1 || bdI >= 100 || bVar.iwI <= 0 || caVar.field_status == 5) {
                aVar3.thM.setVisibility(8);
                aVar3.xdY.setAlpha(255);
                aVar3.xdY.setBackgroundDrawable(null);
            } else {
                aVar3.thM.setVisibility(0);
                aVar3.PKR.setText(bdI + "%");
                aVar3.xdY.setAlpha(64);
                aVar3.xdY.setBackgroundResource(R.drawable.bmy);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(36977);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            int i2;
            int i3;
            AppMethodBeat.i(233728);
            if (view == null) {
                Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
                AppMethodBeat.o(233728);
                return false;
            }
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
                AppMethodBeat.o(233728);
                return false;
            }
            int i4 = bqVar.position;
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD != null && h.l(h.o(HD.appId, false, false))) {
                mVar.a(i4, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            if (com.tencent.mm.br.c.aZU("favorite")) {
                mVar.a(i4, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
            }
            if (caVar.field_status != 5) {
                MenuItem a2 = mVar.a(i4, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, view.getContext().getString(R.string.ayz), R.raw.icons_filled_pencil);
                int[] iArr = new int[2];
                if (view != null) {
                    i3 = view.getWidth();
                    i2 = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i2).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                a2.setIntent(intent);
            }
            ef efVar = new ef();
            efVar.dHy.msgId = caVar.field_msgId;
            EventCenter.instance.publish(efVar);
            boolean s = h.s(this.PhN.Pwc.getContext(), 2);
            if (efVar.dHz.dGX || s) {
                mVar.a(i4, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
            }
            if (!caVar.gAt() && caVar.gDr() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                mVar.a(i4, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i4, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233728);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int i2;
            String str2;
            int i3;
            Bundle bundle;
            AppMethodBeat.i(36980);
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(aVar.Pwc.getContext(), aVar.Pwc.getContentView());
                AppMethodBeat.o(36980);
                return true;
            } else if (view == null) {
                AppMethodBeat.o(36980);
                return true;
            } else {
                view.getTag();
                k.b bVar = null;
                String str3 = caVar.field_content;
                if (str3 != null) {
                    bVar = k.b.HD(str3);
                }
                if (bVar == null) {
                    Log.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                    AppMethodBeat.o(36980);
                    return true;
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                g o = h.o(bVar.appId, false, false);
                if (o != null) {
                    a(aVar, bVar, z.aTY(), o, caVar.field_msgSvrId, aVar.getTalkerUserName());
                }
                if (bVar.dCK != null && bVar.dCK.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(bVar.dCK);
                    if (bdx != null) {
                        bg.aVF();
                        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                            u.g(aVar.Pwc.getContext(), aVar.Pwc.getContentView());
                        } else if (caVar.field_isSend == 1) {
                            String str4 = bdx.field_fileFullPath;
                            if (!s.YS(str4)) {
                                Log.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", str4, Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
                                Intent intent = new Intent();
                                intent.setClassName(aVar.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                intent.putExtra("clean_view_type", 1);
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                aVar.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(36980);
                                return true;
                            } else if (str4 == null || str4.equals("") || !s.YS(str4)) {
                                Log.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                            } else {
                                long j2 = caVar.field_msgId;
                                long j3 = caVar.field_msgSvrId;
                                String str5 = caVar.field_talker;
                                Log.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
                                Intent intent2 = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
                                intent2.putExtra("img_gallery_msg_id", j2);
                                intent2.putExtra("img_gallery_talker", str5);
                                intent2.putExtra("img_gallery_left", iArr[0]);
                                intent2.putExtra("img_gallery_top", iArr[1]);
                                intent2.putExtra("img_gallery_width", width);
                                intent2.putExtra("img_gallery_height", height);
                                String talkerUserName = this.PhN.getTalkerUserName();
                                String a2 = a(this.PhN, caVar);
                                Bundle bundle2 = new Bundle();
                                if (this.PhN.gRM()) {
                                    str2 = "stat_scene";
                                    i3 = 2;
                                    bundle = bundle2;
                                } else {
                                    str2 = "stat_scene";
                                    if (ab.IT(talkerUserName)) {
                                        i3 = 7;
                                        bundle = bundle2;
                                    } else {
                                        i3 = 1;
                                        bundle = bundle2;
                                    }
                                }
                                bundle.putInt(str2, i3);
                                bundle2.putString("stat_msg_id", "msg_" + Long.toString(j3));
                                bundle2.putString("stat_chat_talker_username", talkerUserName);
                                bundle2.putString("stat_send_msg_user", a2);
                                intent2.putExtra("_stat_obj", bundle2);
                                com.tencent.mm.ui.chatting.e.a aVar2 = this.PhN;
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(aVar2, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                aVar2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(aVar2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                        }
                        AppMethodBeat.o(36980);
                        return true;
                    }
                } else if (bVar.url != null && bVar.url.length() > 0) {
                    String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, "message");
                    PackageInfo packageInfo = getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                    if (packageInfo == null) {
                        str = null;
                    } else {
                        str = packageInfo.versionName;
                    }
                    if (packageInfo == null) {
                        i2 = 0;
                    } else {
                        i2 = packageInfo.versionCode;
                    }
                    a(aVar, R, R, str, i2, bVar.appId, false, caVar.field_msgId, caVar.field_msgSvrId, caVar);
                }
                AppMethodBeat.o(36980);
                return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233729);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233729);
                return;
            }
            AppMethodBeat.o(233729);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b bVar;
            com.tencent.mm.pluginsdk.model.app.c bdx;
            String str = null;
            AppMethodBeat.i(36979);
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.HD(str2);
            } else {
                bVar = null;
            }
            switch (menuItem.getItemId()) {
                case 111:
                    if (!(bVar == null || bVar.dCK == null || bVar.dCK.length() <= 0 || (bdx = ao.cgO().bdx(bVar.dCK)) == null)) {
                        str = bdx.field_fileFullPath;
                    }
                    Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", caVar.field_content);
                    intent.putExtra("Retr_File_Name", str);
                    intent.putExtra("Retr_Msg_Type", 16);
                    intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    aVar.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(36979);
                    break;
                case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                    w.a(aVar, menuItem, caVar);
                    AppMethodBeat.o(36979);
                    break;
                default:
                    AppMethodBeat.o(36979);
                    break;
            }
            return false;
        }
    }

    static class a extends c.a {
        protected TextView PHZ;
        protected TextView PKR;
        protected ImageView PKS;
        protected View thM;
        protected TextView tln;
        protected ImageView xdY;
        protected ImageView xnz;

        a() {
        }

        public final a gT(View view) {
            AppMethodBeat.i(36965);
            super.create(view);
            this.xdY = (ImageView) view.findViewById(R.id.att);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PKR = (TextView) view.findViewById(R.id.ati);
            this.thM = view.findViewById(R.id.atj);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PKS = (ImageView) view.findViewById(R.id.atl);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.xnz = (ImageView) view.findViewById(R.id.aun);
            AppMethodBeat.o(36965);
            return this;
        }
    }

    static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.e.a aVar, MenuItem menuItem, ca caVar) {
        com.tencent.mm.av.g gVar;
        AppMethodBeat.i(36982);
        switch (menuItem.getItemId()) {
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                Log.i("MicroMsg.ChattingItemAppMsgImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    Log.e("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.o(36982);
                    return true;
                }
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = {intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (aVar.gRL() || ((d) aVar.bh(d.class)).gOQ()) {
                    str = caVar.field_talker;
                }
                com.tencent.mm.av.g gVar2 = null;
                if (caVar.field_msgId > 0) {
                    gVar2 = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                }
                if ((gVar2 == null || gVar2.localId <= 0) && caVar.field_msgSvrId > 0) {
                    gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                } else {
                    gVar = gVar2;
                }
                String o = gVar == null ? "" : q.bcR().o(gVar.iXm, "", "");
                if (gVar == null || gVar.status == -1 || caVar.field_status == 5) {
                    Log.e("MicroMsg.ChattingItemAppMsgImg", "raw img not get successfully ,msgId:%s", Long.valueOf(caVar.field_msgId));
                } else {
                    Log.i("MicroMsg.ChattingItemAppMsgImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(caVar.field_msgId), o);
                    av.c.a(aVar, caVar, caVar.field_msgId, caVar.field_msgSvrId, caVar.field_talker, str, iArr, intExtra, intExtra2);
                }
                AppMethodBeat.o(36982);
                return true;
            default:
                AppMethodBeat.o(36982);
                return false;
        }
    }
}
