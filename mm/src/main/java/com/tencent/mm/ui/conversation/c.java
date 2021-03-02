package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.as.b;
import com.tencent.mm.ba.e;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public final class c {
    public static void a(final String str, final Context context, final az azVar, final Runnable runnable, final boolean z, final boolean z2) {
        AppMethodBeat.i(38287);
        final PBool pBool = new PBool();
        if (ab.Eq(str)) {
            String str2 = null;
            bg.aVF();
            ca aEw = com.tencent.mm.model.c.aSQ().aEw(str);
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new e(str, aEw.field_msgSvrId));
            pBool.value = false;
            context.getString(R.string.zb);
            final q a2 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            if (!pBool.value) {
                str2 = d.bfO(str);
            }
            if (!Util.isNullOrNil(str2)) {
                a2.dismiss();
                h.a(context, false, context.getString(R.string.iap, str2), null, context.getString(R.string.dvh), context.getString(R.string.bl3), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38279);
                        pBool.value = true;
                        c.c(context, z2, str);
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 1, 4, str);
                        }
                        AppMethodBeat.o(38279);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass12 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38280);
                        a2.show();
                        pBool.value = false;
                        c.a(str, pBool, a2);
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 1, 3, str);
                        }
                        if (runnable != null) {
                            runnable.run();
                        }
                        AppMethodBeat.o(38280);
                    }
                }, -1, R.color.cd);
            } else {
                a2.dismiss();
                h.a(context, context.getString(R.string.del), "", context.getString(R.string.tf), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38281);
                        c.a(str, pBool, a2);
                        if (runnable != null) {
                            runnable.run();
                        }
                        AppMethodBeat.o(38281);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            }
        } else if (ab.Jj(str)) {
            bg.aVF();
            com.tencent.mm.model.c.aST().bjX(str);
            qn qnVar = new qn();
            qnVar.dWV.opType = 4;
            qnVar.dWV.dXa = 20;
            EventCenter.instance.publish(qnVar);
        } else if (ab.IZ(str)) {
            bg.aVF();
            com.tencent.mm.model.c.aST().bjX(str);
        } else if (ab.Jc(str)) {
            bg.aVF();
            com.tencent.mm.model.c.aST().bjW(str);
        } else if (g.Ng(str)) {
            bg.aVF();
            ca aEw2 = com.tencent.mm.model.c.aSQ().aEw(str);
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new e(str, aEw2.field_msgSvrId));
            pBool.value = false;
            context.getString(R.string.zb);
            final q a3 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass14 */

                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            ag.bah();
            final String MX = f.MX(str);
            final AnonymousClass15 r4 = new Runnable() {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(234110);
                    c.a(str, azVar, pBool, a3);
                    if (runnable != null) {
                        runnable.run();
                    }
                    if (g.Nb(str)) {
                        ag.bat().Np(str);
                    }
                    AppMethodBeat.o(234110);
                }
            };
            a3.dismiss();
            if (Util.isNullOrNil(MX)) {
                h.a(context, context.getString(ab.Js(str) ? R.string.dek : R.string.dej), "", context.getString(R.string.tf), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass16 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(234111);
                        r4.run();
                        AppMethodBeat.o(234111);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            } else {
                h.a(context, context.getString(R.string.dej), "", context.getString(R.string.tf), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass17 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(38285);
                        r4.run();
                        bp.a(str, new bp.a() {
                            /* class com.tencent.mm.ui.conversation.c.AnonymousClass17.AnonymousClass1 */

                            @Override // com.tencent.mm.model.bp.a
                            public final boolean amG() {
                                AppMethodBeat.i(234112);
                                if (pBool.value || a3 == null || !a3.isShowing()) {
                                    AppMethodBeat.o(234112);
                                    return true;
                                }
                                AppMethodBeat.o(234112);
                                return false;
                            }

                            @Override // com.tencent.mm.model.bp.a
                            public final void amH() {
                                AppMethodBeat.i(234113);
                                com.tencent.mm.al.a.e.P(MX, false);
                                if (a3 != null) {
                                    a3.dismiss();
                                }
                                AppMethodBeat.o(234113);
                            }
                        });
                        AppMethodBeat.o(38285);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            }
        } else if (g.DQ(str)) {
            pBool.value = false;
            context.getString(R.string.zb);
            final q a4 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass18 */

                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            a4.dismiss();
            h.a(context, context.getString(R.string.dej), "", context.getString(R.string.tf), context.getString(R.string.sz), new DialogInterface.OnClickListener(str) {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass2 */
                final /* synthetic */ String gMw;

                {
                    this.gMw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38273);
                    bp.a(this.gMw, new bp.a() {
                        /* class com.tencent.mm.ui.conversation.c.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.model.bp.a
                        public final boolean amG() {
                            AppMethodBeat.i(234100);
                            if (pBool.value || a4 == null || !a4.isShowing()) {
                                AppMethodBeat.o(234100);
                                return true;
                            }
                            AppMethodBeat.o(234100);
                            return false;
                        }

                        @Override // com.tencent.mm.model.bp.a
                        public final void amH() {
                            AppMethodBeat.i(234101);
                            com.tencent.mm.al.a.e.P(str, false);
                            if (a4 != null) {
                                a4.dismiss();
                            }
                            AppMethodBeat.o(234101);
                        }
                    });
                    AppMethodBeat.o(38273);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        } else {
            bg.aVF();
            ca aEw3 = com.tencent.mm.model.c.aSQ().aEw(str);
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new e(str, aEw3.field_msgSvrId));
            pBool.value = false;
            context.getString(R.string.zb);
            final q a5 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.conversation.c.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            String str3 = null;
            if (!pBool.value) {
                str3 = d.bfO(str);
            }
            if (!Util.isNullOrNil(str3)) {
                a5.dismiss();
                h.a(context, false, context.getString(R.string.iap, str3), null, context.getString(R.string.dvh), context.getString(R.string.bl3), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(234102);
                        pBool.value = true;
                        c.c(context, z2, str);
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 0, 4, str);
                        }
                        AppMethodBeat.o(234102);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(234103);
                        a5.show();
                        pBool.value = false;
                        c.a(str, azVar, pBool, a5);
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 0, 3, str);
                        }
                        AppMethodBeat.o(234103);
                    }
                }, -1, R.color.cd);
            } else {
                a5.dismiss();
                h.a(context, context.getString(ab.Js(str) ? R.string.dek : R.string.dej), "", context.getString(R.string.tf), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.conversation.c.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(234104);
                        c.a(str, azVar, pBool, a5);
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (g.Nb(str)) {
                            ag.bat().Np(str);
                        }
                        if (ab.Js(str)) {
                            com.tencent.mm.storage.ab.gAZ();
                        }
                        AppMethodBeat.o(234104);
                    }
                }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
            }
        }
        if (ab.Ja(str)) {
            Log.i("MicroMsg.ConvDelLogic", "del all qmessage");
            bp.aVS();
            bg.aVF();
            com.tencent.mm.model.c.aST().bjX("@qqim");
            AppMethodBeat.o(38287);
            return;
        }
        if (ab.IY(str)) {
            Log.i("MicroMsg.ConvDelLogic", "del all tmessage");
            bp.aVT();
            bg.aVF();
            com.tencent.mm.model.c.aST().bjX("@t.qq.com");
        }
        AppMethodBeat.o(38287);
    }

    private static void report(String str) {
        AppMethodBeat.i(234114);
        bg.aVF();
        az bjY = com.tencent.mm.model.c.aST().bjY(str);
        if (bjY != null) {
            fd fdVar = new fd();
            fdVar.enl = 15;
            fdVar.sa(str);
            fdVar.eFa = (long) ac.JT(str);
            fdVar.enE = (long) bjY.field_unReadCount;
            fdVar.bfK();
        }
        AppMethodBeat.o(234114);
    }

    static /* synthetic */ void c(Context context, boolean z, String str) {
        AppMethodBeat.i(38288);
        if (!z) {
            LauncherUI instance = LauncherUI.getInstance();
            if (instance != null) {
                instance.startChatting(str, null, true);
            }
            AppMethodBeat.o(38288);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("chat_from_scene", 4);
        com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(38288);
    }

    static /* synthetic */ void a(final String str, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.i(38289);
        report(str);
        aa.Dy(str);
        a.jRt.cancelNotification(str);
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.ui.conversation.c.AnonymousClass8 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(234107);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.o(234107);
                    return true;
                }
                AppMethodBeat.o(234107);
                return false;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(234108);
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                Kn.aqX();
                if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    ab.F(Kn.field_username, false);
                } else {
                    bg.aVF();
                    com.tencent.mm.model.c.aSN().c(str, Kn);
                }
                bg.aVF();
                com.tencent.mm.model.c.aST().bjW(str);
                b.bch();
                b.Om(str);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(234108);
            }
        });
        AppMethodBeat.o(38289);
    }

    static /* synthetic */ void a(String str, az azVar, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.i(38290);
        report(str);
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.ui.conversation.c.AnonymousClass7 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(234105);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.o(234105);
                    return true;
                }
                AppMethodBeat.o(234105);
                return false;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(234106);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(234106);
            }
        });
        a.jRt.cancelNotification(str);
        bg.aVF();
        as bjH = com.tencent.mm.model.c.aSN().bjH(str);
        if (bjH == null || !bjH.gBM()) {
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(str);
            Kn.aqX();
            Kn.aqY();
            if (Kn.gBM() && g.Nb(str)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13773, 0, Integer.valueOf(azVar.field_unReadCount), 1, azVar.field_username);
            }
            cpl cpl = new cpl();
            Log.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", Kn.field_username, Kn.field_conRemark, Integer.valueOf(Kn.field_type));
            cpl.Lqk = new dqi().bhy(Util.nullAsNil(Kn.field_username));
            cpl.Mjj = new dqi().bhy(Util.nullAsNil(Kn.field_nickname));
            cpl.LpA = new dqi().bhy(Util.nullAsNil(Kn.ajz()));
            cpl.LpB = new dqi().bhy(Util.nullAsNil(Kn.ajA()));
            cpl.kdY = Kn.fuA;
            cpl.LoG = 176787327;
            cpl.LoH = Kn.field_type;
            cpl.MuI = new dqi().bhy(Util.nullAsNil(Kn.field_conRemark));
            cpl.MuJ = new dqi().bhy(Util.nullAsNil(Kn.field_conRemarkPYShort));
            cpl.MuK = new dqi().bhy(Util.nullAsNil(Kn.field_conRemarkPYFull));
            cpl.LoM = Kn.fuE;
            cpl.Mvh = new dqi().bhy(Util.nullAsNil(Kn.field_domainList));
            cpl.LoQ = Kn.fuH;
            cpl.kec = Kn.fuI;
            cpl.keb = Util.nullAsNil(Kn.signature);
            cpl.kea = Util.nullAsNil(Kn.getCityCode());
            cpl.kdZ = Util.nullAsNil(Kn.gBR());
            cpl.MmM = Util.nullAsNil(Kn.fuM);
            cpl.MmO = Kn.field_weiboFlag;
            cpl.Mvd = 0;
            cpl.KHp = new SKBuiltinBuffer_t();
            cpl.keh = Util.nullAsNil(Kn.getCountryCode());
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new k.a(2, cpl));
            bg.aVF();
            com.tencent.mm.model.c.aSN().c(str, Kn);
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY(str);
            bg.aVF();
            com.tencent.mm.model.c.aST().bjW(str);
            if (bjY != null && (bjY.oV(4194304) || (Kn.gBM() && !com.tencent.mm.contact.c.oR(Kn.field_type) && bjY.field_conversationTime < ag.baw()))) {
                bg.azz().a(new i(str), 0);
            }
            AppMethodBeat.o(38290);
            return;
        }
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(str);
        bg.aVF();
        com.tencent.mm.model.c.aSN().aNa(str);
        AppMethodBeat.o(38290);
    }
}
