package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.z;

@a(gRF = ak.class)
public class au extends a implements i, ak {
    private d Ptj = null;
    private final IListener gnH = new al(al.a.CHATTING_ITEM_VIDEO, null);

    public au() {
        AppMethodBeat.i(35530);
        AppMethodBeat.o(35530);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35531);
        bg.azz().a(594, this);
        AppMethodBeat.o(35531);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35532);
        if (!EventCenter.instance.hadListened(this.gnH)) {
            EventCenter.instance.addListener(this.gnH);
        }
        AppMethodBeat.o(35532);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35533);
        EventCenter.instance.removeListener(this.gnH);
        AppMethodBeat.o(35533);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35534);
        bg.azz().b(594, this);
        AppMethodBeat.o(35534);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35535);
        super.gOK();
        EventCenter.instance.removeListener(this.gnH);
        bg.azz().b(594, this);
        AppMethodBeat.o(35535);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ak
    public final void ce(final ca caVar) {
        AppMethodBeat.i(35536);
        final w wVar = new w(caVar, this.dom.Pwc.getMMResources().getString(R.string.b24));
        this.dom.b(this.dom.Pwc.getContext(), null, this.dom.Pwc.getMMResources().getString(R.string.b23), new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.d.au.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35526);
                Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", Long.valueOf(caVar.field_msgId));
                bg.azz().a(wVar);
                AppMethodBeat.o(35526);
            }
        });
        bg.azz().a(wVar, 0);
        AppMethodBeat.o(35536);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(35537);
        Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " sceneType:" + qVar.getType());
        this.dom.dismissDialog();
        if (this.Ptj != null) {
            this.Ptj.dismiss();
            this.Ptj = null;
        }
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(35537);
        } else if (!Util.isTopActivity(this.dom.Pwc.getContext())) {
            AppMethodBeat.o(35537);
        } else {
            Activity context = this.dom.Pwc.getContext();
            if (z.a.a(context, i2, i3, str, 7)) {
                z = true;
            } else if (com.tencent.mm.plugin.account.ui.a.a(context, i2, i3, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(35537);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    default:
                        AppMethodBeat.o(35537);
                        return;
                    case 594:
                        if (qVar instanceof w) {
                            dpl bfA = ((w) qVar).bfA();
                            if (!Util.isNullOrNil(bfA.MHI)) {
                                h.a(this.dom.Pwc.getContext(), bfA.MHI, "", this.dom.Pwc.getMMResources().getString(R.string.b21), new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.d.au.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(35527);
                                        if (dialogInterface != null) {
                                            dialogInterface.dismiss();
                                        }
                                        AppMethodBeat.o(35527);
                                    }
                                });
                            }
                            AppMethodBeat.o(35537);
                            return;
                        }
                        break;
                }
            } else if (qVar.getType() == 594 && (qVar instanceof w)) {
                dpl bfA2 = ((w) qVar).bfA();
                Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", bfA2.MSL);
                if (i3 == 0 || Util.isNullOrNil(bfA2.MSL)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", bfA2.MSL);
                    this.Ptj = h.a(this.dom.Pwc.getContext(), bfA2.MSL, "", this.dom.Pwc.getMMResources().getString(R.string.b21), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.d.au.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(35528);
                            if (au.this.Ptj != null) {
                                au.this.Ptj.dismiss();
                            }
                            AppMethodBeat.o(35528);
                        }
                    });
                    AppMethodBeat.o(35537);
                    return;
                }
                Log.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i3), bfA2.MSL);
                this.Ptj = h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.b22), "", this.dom.Pwc.getMMResources().getString(R.string.b21), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.au.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(35529);
                        if (au.this.Ptj != null) {
                            au.this.Ptj.dismiss();
                        }
                        AppMethodBeat.o(35529);
                    }
                });
            }
            AppMethodBeat.o(35537);
        }
    }
}
