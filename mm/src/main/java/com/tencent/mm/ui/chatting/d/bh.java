package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@a(gRF = av.class)
public class bh extends a implements av {
    private long Pvi = -1;
    private SparseBooleanArray Pvj = new SparseBooleanArray();

    public bh() {
        AppMethodBeat.i(35756);
        AppMethodBeat.o(35756);
    }

    static /* synthetic */ void a(bh bhVar, Intent intent) {
        AppMethodBeat.i(35771);
        bhVar.aL(intent);
        AppMethodBeat.o(35771);
    }

    static /* synthetic */ void a(bh bhVar, ca caVar) {
        AppMethodBeat.i(35770);
        bhVar.ck(caVar);
        AppMethodBeat.o(35770);
    }

    private void he(final String str, final int i2) {
        AppMethodBeat.i(35757);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(35749);
                u.aA(str, i2);
                AppMethodBeat.o(35749);
            }
        });
        AppMethodBeat.o(35757);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.chatting.d.b.av
    public final boolean a(MenuItem menuItem, final ca caVar) {
        AppMethodBeat.i(35758);
        switch (menuItem.getItemId()) {
            case 106:
                s Qq = o.bhj().Qq(caVar.field_imgPath);
                if (Qq == null) {
                    Log.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
                } else if (Qq.status == 199) {
                    o.bhj();
                    String Qw = t.Qw(caVar.field_imgPath);
                    if (Qq != null) {
                        int i2 = 0;
                        if (ab.Eq(Qq.getUser())) {
                            i2 = v.Ie(Qq.getUser());
                        }
                        h.INSTANCE.idkeyStat(106, 215, 1, false);
                        h.INSTANCE.a(12084, Integer.valueOf(Qq.iKP), Integer.valueOf(Qq.iFw * 1000), 0, 2, Qq.getUser(), Integer.valueOf(i2), s.Qn(Qq.bhv()), Long.valueOf(Qq.createTime));
                    }
                    p.b(this.dom.Pwc.getContext(), Qw, new p.a() {
                        /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass5 */

                        @Override // com.tencent.mm.platformtools.p.a
                        public final void bP(String str, String str2) {
                            AppMethodBeat.i(233223);
                            Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getMMResources().getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                            com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, bh.this.dom.Pwc.getContext());
                            AppMethodBeat.o(233223);
                        }

                        @Override // com.tencent.mm.platformtools.p.a
                        public final void bQ(String str, String str2) {
                            AppMethodBeat.i(233224);
                            Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getMMResources().getString(R.string.hwt), 1).show();
                            AppMethodBeat.o(233224);
                        }
                    });
                } else {
                    he(Qq.getFileName(), 6);
                    Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
                    Intent intent = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", caVar.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", caVar.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", caVar.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", u.f(caVar.field_msgId, 2));
                    l.a(this.dom, caVar, intent);
                    BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    this.dom.Pwc.overridePendingTransition(0, 0);
                }
                AppMethodBeat.o(35758);
                return true;
            case 107:
                final String N = br.N(caVar);
                if (Util.isNullOrNil(N) || caVar.field_isSend == 1) {
                    ck(caVar);
                } else {
                    h.INSTANCE.a(17509, 3, N);
                    com.tencent.mm.ui.base.h.a((Context) this.dom.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35750);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", N);
                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                            c.b(bh.this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            h.INSTANCE.a(17509, 1, N);
                            AppMethodBeat.o(35750);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35751);
                            bh.a(bh.this, caVar);
                            h.INSTANCE.a(17509, 2, N);
                            AppMethodBeat.o(35751);
                        }
                    });
                }
                if (br.D(caVar)) {
                    jc jcVar = new jc();
                    jcVar.emN = caVar.field_msgSvrId;
                    jcVar.eLn = (long) caVar.getType();
                    jcVar.eQu = (long) br.C(caVar);
                    jcVar.ejA = 4;
                    jcVar.bfK();
                    break;
                }
                break;
            case 130:
                Intent intent2 = menuItem.getIntent();
                int i3 = 0;
                int i4 = 0;
                int[] iArr = new int[2];
                if (intent2 == null) {
                    Log.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
                } else {
                    i3 = intent2.getIntExtra("img_gallery_width", 0);
                    i4 = intent2.getIntExtra("img_gallery_height", 0);
                    iArr[0] = intent2.getIntExtra("img_gallery_left", 0);
                    iArr[1] = intent2.getIntExtra("img_gallery_top", 0);
                }
                Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
                Intent intent3 = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
                intent3.putExtra("img_gallery_msg_id", caVar.field_msgId);
                intent3.putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId);
                intent3.putExtra("img_gallery_talker", caVar.field_talker);
                intent3.putExtra("img_gallery_chatroom_name", caVar.field_talker);
                intent3.putExtra("img_gallery_left", iArr[0]);
                intent3.putExtra("img_gallery_top", iArr[1]);
                intent3.putExtra("img_gallery_width", i3);
                intent3.putExtra("img_gallery_height", i4);
                intent3.putExtra("img_gallery_enter_video_opcode", u.f(caVar.field_msgId, 3));
                l.a(this.dom, caVar, intent3);
                BaseChattingUIFragment baseChattingUIFragment2 = this.dom.Pwc;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, bl2.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                baseChattingUIFragment2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.dom.Pwc.overridePendingTransition(0, 0);
                AppMethodBeat.o(35758);
                return true;
        }
        AppMethodBeat.o(35758);
        return false;
    }

    private void ck(ca caVar) {
        AppMethodBeat.i(35759);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
            AppMethodBeat.o(35759);
        } else if (caVar.cWK()) {
            Intent intent = new Intent(this.dom.Pwc.getContext(), MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
            intent.putExtra("Retr_Msg_content", caVar.field_content);
            intent.putExtra("Retr_From", "chattingui");
            Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + caVar.getType());
            intent.putExtra("Retr_Msg_Type", 1);
            BaseChattingUIFragment baseChattingUIFragment = this.dom.Pwc;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35759);
        } else {
            s QN = u.QN(caVar.field_imgPath);
            if (QN != null) {
                String bhu = QN.bhu();
                if (!com.tencent.mm.vfs.s.YS(bhu)) {
                    o.bhj();
                    bhu = t.Qw(caVar.field_imgPath);
                }
                if (caVar.gDB()) {
                    Log.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
                    com.tencent.mm.ui.base.h.d(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(R.string.hw4), this.dom.Pwc.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    AppMethodBeat.o(35759);
                } else if (l.h(caVar, bhu)) {
                    Log.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
                    he(QN.getFileName(), 3);
                    Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
                    Intent intent2 = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
                    intent2.putExtra("img_gallery_msg_id", caVar.field_msgId);
                    intent2.putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId);
                    intent2.putExtra("img_gallery_talker", caVar.field_talker);
                    intent2.putExtra("img_gallery_chatroom_name", caVar.field_talker);
                    intent2.putExtra("img_gallery_enter_video_opcode", u.f(caVar.field_msgId, 1));
                    l.a(this.dom, caVar, intent2);
                    BaseChattingUIFragment baseChattingUIFragment2 = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, bl2.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment2, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    this.dom.Pwc.overridePendingTransition(0, 0);
                    if (QN.bhx()) {
                        Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                        u.QT(caVar.field_imgPath);
                        AppMethodBeat.o(35759);
                        return;
                    }
                    Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                    u.QI(caVar.field_imgPath);
                    AppMethodBeat.o(35759);
                } else if (caVar.cWJ() || caVar.cWL()) {
                    Intent intent3 = new Intent(this.dom.Pwc.getContext(), MsgRetransmitUI.class);
                    intent3.putExtra("Retr_length", QN.iFw);
                    intent3.putExtra("Retr_File_Name", caVar.field_imgPath);
                    intent3.putExtra("Retr_video_isexport", QN.jsr);
                    intent3.putExtra("Retr_Msg_Id", caVar.field_msgId);
                    intent3.putExtra("Retr_From", "chattingui");
                    Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + caVar.getType());
                    if (caVar.cWL()) {
                        intent3.putExtra("Retr_Msg_Type", 11);
                    } else {
                        intent3.putExtra("Retr_Msg_Type", 1);
                    }
                    BaseChattingUIFragment baseChattingUIFragment3 = this.dom.Pwc;
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment3, bl3.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    baseChattingUIFragment3.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment3, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(35759);
                } else {
                    Log.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
                    AppMethodBeat.o(35759);
                }
            } else {
                Log.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
                AppMethodBeat.o(35759);
            }
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.av
    public final boolean h(ca caVar, boolean z) {
        AppMethodBeat.i(35760);
        if (caVar.cWJ()) {
            o.bhj();
            if (!com.tencent.mm.vfs.s.YS(t.Qw(caVar.field_imgPath))) {
                z = false;
            }
        } else if (caVar.cWL()) {
            o.bhj();
            if (!com.tencent.mm.vfs.s.YS(t.Qw(caVar.field_imgPath))) {
                z = false;
            }
        }
        AppMethodBeat.o(35760);
        return z;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.av
    public final void bE(Intent intent) {
        AppMethodBeat.i(35761);
        if (intent == null) {
            AppMethodBeat.o(35761);
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            Log.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
            AppMethodBeat.o(35761);
        } else if (!ag.dm(this.dom.Pwc.getContext())) {
            bq(stringArrayListExtra);
            AppMethodBeat.o(35761);
        } else {
            bq(stringArrayListExtra);
            AppMethodBeat.o(35761);
        }
    }

    private void bq(ArrayList<String> arrayList) {
        AppMethodBeat.i(35762);
        Log.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", arrayList.toString());
        final m mVar = new m(this.dom.Pwc.getContext(), arrayList, null, this.dom.getTalkerUserName(), 2, new m.a() {
            /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass7 */

            @Override // com.tencent.mm.pluginsdk.model.m.a
            public final void gmA() {
                AppMethodBeat.i(233225);
                bh.this.dom.dismissDialog();
                AppMethodBeat.o(233225);
            }
        });
        this.dom.b(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.zb), this.dom.Pwc.getMMResources().getString(R.string.a06), new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(233226);
                mVar.gmu();
                AppMethodBeat.o(233226);
            }
        });
        ThreadPool.post(mVar, "ChattingUI_importMultiVideo");
        AppMethodBeat.o(35762);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.av
    public final void aK(final Intent intent) {
        AppMethodBeat.i(35763);
        Log.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
        if (!ag.dm(this.dom.Pwc.getContext())) {
            com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), (int) R.string.hwn, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(233227);
                    bh.a(bh.this, intent);
                    AppMethodBeat.o(233227);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(35763);
            return;
        }
        aL(intent);
        AppMethodBeat.o(35763);
    }

    private void aL(Intent intent) {
        AppMethodBeat.i(35764);
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        cVar.a(this.dom.Pwc.getContext(), intent, this.dom.getTalkerUserName(), new c.a() {
            /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass10 */

            @Override // com.tencent.mm.modelvideo.c.a
            public final void c(int i2, String str, String str2, int i3) {
                AppMethodBeat.i(233228);
                if (i2 == -50002) {
                    Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getContext().getString(R.string.hwm), 0).show();
                } else if (i2 < 0) {
                    Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getContext().getString(R.string.hwl), 0).show();
                } else {
                    u.c(str, i3, bh.this.dom.getTalkerUserName(), str2);
                    u.QG(str);
                }
                bh.this.dom.dismissDialog();
                AppMethodBeat.o(233228);
            }
        });
        this.dom.b(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.zb), this.dom.Pwc.getMMResources().getString(R.string.a06), new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.d.bh.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                cVar.jpO = null;
            }
        });
        AppMethodBeat.o(35764);
    }

    private void bF(Intent intent) {
        AppMethodBeat.i(35765);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
        if (intent == null) {
            Log.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
            AppMethodBeat.o(35765);
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        Log.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (Util.isNullOrNil(stringExtra) || Util.isNullOrNil(stringExtra2) || intExtra < 0) {
            AppMethodBeat.o(35765);
        } else if (!stringExtra.equals("medianote") || (z.aUc() & 16384) != 0) {
            u.c(stringExtra2, intExtra, stringExtra, null);
            u.QG(stringExtra2);
            this.dom.BN(true);
            AppMethodBeat.o(35765);
        } else {
            s sVar = new s();
            sVar.fileName = stringExtra2;
            sVar.iFw = intExtra;
            sVar.dWq = stringExtra;
            sVar.jsh = (String) g.aAh().azQ().get(2, "");
            sVar.createTime = Util.nowSecond();
            sVar.jsm = Util.nowSecond();
            sVar.jsj = intExtra;
            sVar.jqP = intExtra;
            o.bhj();
            int Qy = t.Qy(t.Qw(stringExtra2));
            if (Qy <= 0) {
                Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(stringExtra2)));
                AppMethodBeat.o(35765);
                return;
            }
            sVar.iKP = Qy;
            o.bhj();
            String Qx = t.Qx(stringExtra2);
            int Qy2 = t.Qy(Qx);
            if (Qy2 <= 0) {
                Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + Qx + " size:" + Qy2);
                AppMethodBeat.o(35765);
                return;
            }
            sVar.jsl = Qy2;
            Log.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + sVar.jsl + " videosize:" + sVar.iKP);
            sVar.status = 199;
            ca caVar = new ca();
            caVar.Cy(sVar.getUser());
            caVar.setType(43);
            caVar.nv(1);
            caVar.Cz(stringExtra2);
            caVar.setStatus(2);
            caVar.setCreateTime(bp.Kw(sVar.getUser()));
            sVar.jso = (int) bp.x(caVar);
            o.bhj().b(sVar);
            AppMethodBeat.o(35765);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean b2;
        AppMethodBeat.i(35766);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 208:
                aK(intent);
                AppMethodBeat.o(35766);
                return;
            case 215:
                aK(intent);
                AppMethodBeat.o(35766);
                return;
            case 216:
                bF(intent);
                AppMethodBeat.o(35766);
                return;
            case 218:
                if (intent != null) {
                    if (intent.getBooleanExtra("from_record", false)) {
                        bF(intent);
                        AppMethodBeat.o(35766);
                        return;
                    }
                    aK(intent);
                }
                AppMethodBeat.o(35766);
                return;
            case 226:
                if (intent != null) {
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult != null) {
                        if (sightCaptureResult.zsy) {
                            ((an) this.dom.bh(an.class)).a(sightCaptureResult);
                            break;
                        } else {
                            Log.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", sightCaptureResult.zsA, sightCaptureResult.zsB);
                            o.bhj();
                            String Qw = t.Qw(sightCaptureResult.zsC);
                            if (!sightCaptureResult.zsA.equals(Qw)) {
                                Log.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", sightCaptureResult.zsA, Qw);
                                com.tencent.mm.vfs.s.nx(sightCaptureResult.zsA, Qw);
                            }
                            String str = sightCaptureResult.zsC;
                            int i4 = sightCaptureResult.zsE;
                            String talkerUserName = this.dom.getTalkerUserName();
                            cly cly = sightCaptureResult.zsF;
                            s sVar = new s();
                            sVar.fileName = str;
                            sVar.iFw = i4;
                            sVar.dWq = talkerUserName;
                            sVar.jsh = (String) g.aAh().azQ().get(2, "");
                            sVar.createTime = Util.nowSecond();
                            sVar.jsm = Util.nowSecond();
                            sVar.jsx = cly;
                            sVar.jsr = 0;
                            sVar.jsu = 1;
                            o.bhj();
                            int Qy = t.Qy(t.Qw(str));
                            if (Qy <= 0) {
                                Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
                                b2 = false;
                            } else {
                                sVar.iKP = Qy;
                                o.bhj();
                                String Qx = t.Qx(str);
                                int Qy2 = t.Qy(Qx);
                                if (Qy2 <= 0) {
                                    Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + Qx + " size:" + Qy2);
                                    b2 = false;
                                } else {
                                    sVar.jsl = Qy2;
                                    Log.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + sVar.jsl + " videosize:" + sVar.iKP);
                                    sVar.status = 102;
                                    ca caVar = new ca();
                                    caVar.Cy(sVar.getUser());
                                    caVar.setType(43);
                                    caVar.nv(1);
                                    caVar.Cz(str);
                                    caVar.setStatus(1);
                                    caVar.setCreateTime(bp.Kw(sVar.getUser()));
                                    sVar.jso = (int) bp.x(caVar);
                                    b2 = o.bhj().b(sVar);
                                }
                            }
                            if (b2) {
                                u.QG(sightCaptureResult.zsC);
                                AppMethodBeat.o(35766);
                                return;
                            }
                            Log.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
                            AppMethodBeat.o(35766);
                            return;
                        }
                    } else {
                        Log.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
                        AppMethodBeat.o(35766);
                        return;
                    }
                } else {
                    Log.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
                    AppMethodBeat.o(35766);
                    return;
                }
        }
        AppMethodBeat.o(35766);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35767);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
        o.bhj().a(((k) this.dom.bh(k.class)).gOA(), bg.aAk().getLooper());
        AppMethodBeat.o(35767);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35768);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
        o.bhj().a(((k) this.dom.bh(k.class)).gOA());
        AppMethodBeat.o(35768);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35769);
        b.aRR();
        this.Pvj.clear();
        AppMethodBeat.o(35769);
    }
}
