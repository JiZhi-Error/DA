package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;

public final class bg extends c {
    private ProgressDialog Dav;
    private a PhN;
    private i onSceneEndCallback;

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048189) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37500);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.tp);
            view.setTag(new bm().hh(view));
        }
        AppMethodBeat.o(37500);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTU() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, final int i2, a aVar2, final ca caVar, String str) {
        k.b bVar;
        boolean z;
        AppMethodBeat.i(37501);
        bm bmVar = (bm) aVar;
        this.PhN = aVar2;
        k GL = ao.gnf().GL(caVar.field_msgId);
        String str2 = caVar.field_content;
        if (GL == null || str2 == null) {
            bVar = null;
        } else {
            bVar = k.b.HD(str2);
        }
        boolean z2 = false;
        final e aSK = e.aSK(str2);
        if (!(aSK == null || aSK.FJX == 0)) {
            try {
                String az = f.az(this.PhN.Pwc.getContext(), aSK.FJX);
                if (!(bVar == null || bVar.description == null)) {
                    int indexOf = bVar.description.indexOf(124);
                    if (indexOf <= 0 || bVar.description.length() <= indexOf + 1) {
                        bmVar.jBR.setText("");
                    } else {
                        bmVar.jBR.setText(bVar.description.substring(indexOf + 1));
                    }
                }
                if (az != null && az.length() > 0) {
                    String[] split = az.split(";");
                    bmVar.PQp.setText(split[0]);
                    if (split.length > 1) {
                        bmVar.PQq.setText(split[1]);
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e2, "", new Object[0]);
            }
            z2 = af.uT(aSK.FJX);
        }
        if (z2) {
            bmVar.PQt.setVisibility(0);
            bmVar.jBR.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.add));
            bmVar.PQq.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.add));
            bmVar.PQp.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.add));
        } else {
            bmVar.PQt.setVisibility(8);
            bmVar.jBR.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.adc));
            bmVar.PQq.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.adc));
            bmVar.PQp.setTextColor(this.PhN.Pwc.getMMResources().getColor(R.color.adc));
        }
        bmVar.PQr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37493);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (af.isNullOrNil(caVar.field_imgPath)) {
                    Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37493);
                    return;
                }
                ((aw) bg.this.PhN.bh(aw.class)).gRx().b(i2, caVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37493);
            }
        });
        long j2 = caVar.field_msgId;
        d gRx = ((aw) this.PhN.bh(aw.class)).gRx();
        if (gRx == null || !gRx.isPlaying() || gRx.Pei != j2) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            bmVar.PQr.setBackgroundResource(R.drawable.b2d);
        } else {
            bmVar.PQr.setBackgroundResource(R.drawable.b2e);
        }
        if (aSK != null && !af.isNullOrNil(aSK.FJZ) && aSK.FKa > 0 && af.isNullOrNil(caVar.field_reserved) && bVar != null) {
            String Qv = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
            String cz = h.cz(Qv, false);
            caVar.CA(Qv);
            com.tencent.mm.model.bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            final String a2 = m.a(cz, caVar.field_msgId, bVar.sdkVer, bVar.appId, aSK.FJZ, aSK.FKa, bVar.type, bVar.iwM);
            if (a2 != null) {
                t azz = com.tencent.mm.model.bg.azz();
                AnonymousClass2 r5 = new i() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(37494);
                        Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i2 + " errCode " + i3 + "  scene " + qVar.getType());
                        boolean z = false;
                        if (ay.a.iDt != null) {
                            z = ay.a.iDt.Ac(caVar.field_msgId);
                        }
                        if (!z && i2 == 0 && i3 == 0 && ((com.tencent.mm.plugin.record.b.f) qVar).getMediaId().equals(a2)) {
                            ca aZ = ca.aZ(caVar);
                            aZ.Cz(caVar.field_reserved);
                            aZ.setMsgId(-1);
                            ((aw) bg.this.PhN.bh(aw.class)).gRx().b(i2, aZ);
                        }
                        com.tencent.mm.model.bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, bg.this.onSceneEndCallback);
                        bg.this.onSceneEndCallback = null;
                        AppMethodBeat.o(37494);
                    }
                };
                this.onSceneEndCallback = r5;
                azz.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r5);
                com.tencent.mm.plugin.record.b.f fVar = new com.tencent.mm.plugin.record.b.f(a2);
                fVar.eIm();
                com.tencent.mm.model.bg.azz().a(fVar, 0);
            }
        }
        if (af.isNullOrNil(caVar.field_imgPath) && aSK.FKd > 0) {
            com.tencent.mm.model.bg.aVF();
            ca aJ = com.tencent.mm.model.c.aSQ().aJ(caVar.field_talker, (long) aSK.FKd);
            if (!af.isNullOrNil(aJ.field_imgPath)) {
                String Qv2 = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
                if (s.nw(h.cz(aJ.field_imgPath, false), h.cz(Qv2, false)) >= 0) {
                    caVar.Cz(Qv2);
                    com.tencent.mm.model.bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                }
            }
        }
        if (af.isNullOrNil(caVar.field_imgPath) && aSK != null && !af.isNullOrNil(aSK.dCK) && aSK.iwI > 0 && this.onSceneEndCallback == null) {
            String Qv3 = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
            String cz2 = h.cz(Qv3, false);
            caVar.Cz(Qv3);
            com.tencent.mm.model.bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            final com.tencent.mm.pluginsdk.model.app.c a3 = m.a(cz2, caVar.field_msgId, bVar.sdkVer, bVar.appId, bVar.dCK, bVar.iwI);
            Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a3.field_mediaSvrId);
            if (a3.field_mediaSvrId != null) {
                t azz2 = com.tencent.mm.model.bg.azz();
                AnonymousClass3 r52 = new i() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass3 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(37495);
                        Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i2 + " errCode " + i3 + "  scene " + qVar.getType());
                        if (((com.tencent.mm.plugin.record.b.f) qVar).getMediaId().equals(a3.field_mediaSvrId)) {
                            com.tencent.mm.model.bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, bg.this.onSceneEndCallback);
                            bg.this.onSceneEndCallback = null;
                        }
                        AppMethodBeat.o(37495);
                    }
                };
                this.onSceneEndCallback = r52;
                azz2.a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r52);
                com.tencent.mm.model.bg.azz().a(new com.tencent.mm.plugin.record.b.f(a3), 0);
            }
        }
        bmVar.PQs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(37499);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.base.h.a(bg.this.PhN.Pwc.getContext(), (int) R.string.i01, (int) R.string.i03, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass4.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(37498);
                        com.tencent.mm.model.bg.azz().a(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, bg.this.onSceneEndCallback = new i() {
                            /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                k.b bVar;
                                com.tencent.mm.pluginsdk.model.app.c Mp;
                                AppMethodBeat.i(37496);
                                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i2 + " errCode " + i3 + "  scene " + qVar.getType());
                                if (i2 == 0 && i3 == 0) {
                                    String str2 = caVar.field_content;
                                    if (str2 != null) {
                                        bVar = k.b.HD(str2);
                                    } else {
                                        bVar = null;
                                    }
                                    if (!(bVar == null || (Mp = ao.cgO().Mp(caVar.field_msgId)) == null)) {
                                        Log.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(s.deleteFile(Mp.field_fileFullPath)), Boolean.valueOf(ao.cgO().delete(Mp, "msgInfoId")), Long.valueOf(Mp.field_msgInfoId), Mp.field_mediaSvrId, Mp.field_fileFullPath, Util.getStack());
                                    }
                                    bp.Ad(caVar.field_msgId);
                                    Toast.makeText(bg.this.PhN.Pwc.getContext(), bg.this.PhN.Pwc.getMMResources().getString(R.string.azu), 0).show();
                                }
                                com.tencent.mm.model.bg.azz().b(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, bg.this.onSceneEndCallback);
                                bg.this.onSceneEndCallback = null;
                                if (bg.this.Dav != null) {
                                    bg.this.Dav.dismiss();
                                }
                                AppMethodBeat.o(37496);
                            }
                        });
                        LinkedList linkedList = new LinkedList();
                        esj esj = new esj();
                        esj.KIB = aSK.FJY;
                        linkedList.add(esj);
                        final com.tencent.mm.plugin.subapp.d.a aVar = new com.tencent.mm.plugin.subapp.d.a(linkedList, linkedList.size());
                        com.tencent.mm.model.bg.azz().a(aVar, 0);
                        bg bgVar = bg.this;
                        Activity context = bg.this.PhN.Pwc.getContext();
                        bg.this.PhN.Pwc.getMMResources().getString(R.string.zb);
                        bgVar.Dav = com.tencent.mm.ui.base.h.a((Context) context, bg.this.PhN.Pwc.getMMResources().getString(R.string.azv), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.bg.AnonymousClass4.AnonymousClass1.AnonymousClass2 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(37497);
                                com.tencent.mm.model.bg.azz().a(aVar);
                                com.tencent.mm.model.bg.azz().b(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, bg.this.onSceneEndCallback);
                                bg.this.onSceneEndCallback = null;
                                if (bg.this.Dav != null) {
                                    bg.this.Dav.dismiss();
                                }
                                AppMethodBeat.o(37497);
                            }
                        });
                        AppMethodBeat.o(37498);
                    }
                }, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37499);
            }
        });
        bmVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
        com.tencent.mm.model.bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            bmVar.clickArea.setOnLongClickListener(c(this.PhN));
        }
        AppMethodBeat.o(37501);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
        AppMethodBeat.i(233968);
        int i2 = ((bq) view.getTag()).position;
        int bdI = m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
        k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
        if (HD.iwI <= 0 || (HD.iwI > 0 && bdI >= 100)) {
            mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
        }
        if (!this.PhN.gRN()) {
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
        }
        AppMethodBeat.o(233968);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, a aVar, ca caVar) {
        AppMethodBeat.i(37503);
        switch (menuItem.getItemId()) {
            case 111:
                Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                aVar.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(37503);
                break;
            default:
                AppMethodBeat.o(37503);
                break;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, a aVar, ca caVar) {
        return true;
    }
}
