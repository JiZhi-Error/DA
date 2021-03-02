package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.d.m;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n {
    private static a PgF;
    private static q Pgl = null;

    /* access modifiers changed from: package-private */
    public static class a {
        boolean Pdm;
        List<ca> PgD;
        d PgE;
        boolean PgM;
        cz dWX;
        String from;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void a(final com.tencent.mm.ui.chatting.e.a aVar, final List<ca> list, boolean z, final m mVar, final as asVar) {
        final List<String> gNu;
        AppMethodBeat.i(34476);
        if (aVar == null) {
            Log.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
            AppMethodBeat.o(34476);
        } else if (list == null || list.isEmpty()) {
            Log.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
            AppMethodBeat.o(34476);
        } else {
            a aVar2 = new a((byte) 0);
            PgF = aVar2;
            aVar2.PgD = new LinkedList(list);
            PgF.Pdm = z;
            PgF.from = asVar.field_username;
            PgF.PgM = true;
            final Activity context = aVar.Pwc.getContext();
            if (context == null) {
                AppMethodBeat.o(34476);
                return;
            }
            l lVar = new l(context);
            lVar.HMa = new o.b() {
                /* class com.tencent.mm.ui.chatting.n.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.b
                public final void a(ImageView imageView, MenuItem menuItem) {
                    AppMethodBeat.i(34461);
                    a.b.A(imageView, new StringBuilder().append((Object) menuItem.getTitle()).toString());
                    AppMethodBeat.o(34461);
                }
            };
            lVar.HMb = new o.c() {
                /* class com.tencent.mm.ui.chatting.n.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.c
                public final void a(TextView textView, MenuItem menuItem) {
                    AppMethodBeat.i(34462);
                    if (textView != null) {
                        bg.aVF();
                        as Kn = c.aSN().Kn(new StringBuilder().append((Object) menuItem.getTitle()).toString());
                        if (Kn == null || ((int) Kn.gMZ) <= 0) {
                            textView.setText(new StringBuilder().append((Object) menuItem.getTitle()).toString());
                            AppMethodBeat.o(34462);
                            return;
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, Kn.arI()));
                    }
                    AppMethodBeat.o(34462);
                }
            };
            if (com.tencent.mm.pluginsdk.model.app.q.s(context, "com.tencent.wework")) {
                gNu = k.gNv();
            } else {
                gNu = k.gNu();
            }
            lVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.chatting.n.AnonymousClass3 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(34463);
                    mVar.aS(1193046, R.string.ezy, R.drawable.mi);
                    for (String str : gNu) {
                        mVar.add(str);
                    }
                    AppMethodBeat.o(34463);
                }
            };
            lVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.chatting.n.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(final MenuItem menuItem, int i2) {
                    boolean z;
                    g gVar;
                    g gVar2;
                    AppMethodBeat.i(34467);
                    if (menuItem.getItemId() == 1193046) {
                        if (k.jj(list)) {
                            h.a(context, context.getString(R.string.bin), "", context.getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(34467);
                        } else if (k.jk(list)) {
                            h.a(context, context.getString(R.string.bio), "", context.getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(34467);
                        } else if (k.ji(list)) {
                            h.a(context, context.getString(R.string.bip), "", new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(34467);
                        } else {
                            if (o.a(aVar, list, asVar) && mVar != null) {
                                mVar.gPz();
                            }
                            AppMethodBeat.o(34467);
                        }
                    } else if (k.jj(list)) {
                        h.a(context, context.getString(R.string.bin), "", context.getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(34467);
                    } else if (k.jk(list)) {
                        h.a(context, context.getString(R.string.bio), "", context.getString(R.string.f3148e), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(34467);
                    } else {
                        List list = list;
                        if (list == null) {
                            Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                        } else {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ca caVar = (ca) it.next();
                                if (caVar.field_isSend == 1) {
                                    break;
                                } else if (caVar.gAz()) {
                                    if (caVar.field_msgId > 0) {
                                        gVar = com.tencent.mm.av.q.bcR().H(caVar.field_talker, caVar.field_msgId);
                                    } else {
                                        gVar = null;
                                    }
                                    if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
                                        gVar2 = com.tencent.mm.av.q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                                    } else {
                                        gVar2 = gVar;
                                    }
                                    if (gVar2 != null && (gVar2.offset < gVar2.iKP || gVar2.iKP == 0)) {
                                        z = true;
                                    }
                                } else if (caVar.cWJ()) {
                                    s Qq = com.tencent.mm.modelvideo.o.bhj().Qq(caVar.field_imgPath);
                                    if (!(Qq == null || Qq.status == 199 || Qq.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (caVar.cWL()) {
                                    s QN = u.QN(caVar.field_imgPath);
                                    if (!(QN == null || QN.status == 199 || QN.status == 199)) {
                                        z = true;
                                        break;
                                    }
                                } else if (caVar.gDo()) {
                                    z = !k.bi(caVar);
                                }
                            }
                            if (!z || k.ji(list)) {
                                h.a(context, context.getString(R.string.bip), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass6 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(34467);
                            }
                            final String str = (String) menuItem.getTitle();
                            if (com.tencent.mm.al.g.Ne(str)) {
                                if (list.size() <= 1) {
                                    n.PgF.PgM = true;
                                    n.a(str, aVar, list);
                                    AppMethodBeat.o(34467);
                                    return;
                                }
                                e eVar = new e(context, 1, false);
                                eVar.HLX = new o.f() {
                                    /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass7 */

                                    @Override // com.tencent.mm.ui.base.o.f
                                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                        AppMethodBeat.i(34464);
                                        mVar.kV(0, R.string.f52);
                                        mVar.kV(1, R.string.f53);
                                        AppMethodBeat.o(34464);
                                    }
                                };
                                eVar.HLY = new o.g() {
                                    /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass8 */

                                    @Override // com.tencent.mm.ui.base.o.g
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                        AppMethodBeat.i(34465);
                                        switch (menuItem.getItemId()) {
                                            case 0:
                                                n.PgF.PgM = true;
                                                n.a(str, aVar, list);
                                                AppMethodBeat.o(34465);
                                                return;
                                            case 1:
                                                n.PgF.PgM = false;
                                                n.a(str, aVar, list);
                                                break;
                                        }
                                        AppMethodBeat.o(34465);
                                    }
                                };
                                eVar.dGm();
                                AppMethodBeat.o(34467);
                                return;
                            } else if (k.jg(list)) {
                                h.a(context, context.getString(R.string.e3t), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass9 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        boolean z;
                                        AppMethodBeat.i(34466);
                                        List list = list;
                                        if (list != null && !list.isEmpty()) {
                                            Iterator it = list.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                ca caVar = (ca) it.next();
                                                if (!k.bm(caVar)) {
                                                    if (!caVar.gAy() && !k.bh(caVar) && !caVar.gDl() && !k.bj(caVar) && !k.bk(caVar) && caVar.getType() != -1879048186 && !k.br(caVar) && !k.bl(caVar) && !k.bq(caVar) && !k.bw(caVar)) {
                                                        z = false;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            Log.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                        }
                                        z = true;
                                        if (z) {
                                            Log.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                            if (mVar != null) {
                                                mVar.gPz();
                                            }
                                            AppMethodBeat.o(34466);
                                            return;
                                        }
                                        Context context = context;
                                        context.getString(R.string.zb);
                                        q unused = n.Pgl = h.a(context, context.getString(R.string.gkk), false, (DialogInterface.OnCancelListener) null);
                                        m.PnZ.add(new b(aVar, context, new StringBuilder().append((Object) menuItem.getTitle()).toString(), -1, n.PgF));
                                        if (mVar != null) {
                                            mVar.gPz();
                                        }
                                        AppMethodBeat.o(34466);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(34467);
                                return;
                            } else {
                                Context context = context;
                                context.getString(R.string.zb);
                                q unused = n.Pgl = h.a(context, context.getString(R.string.gkk), false, (DialogInterface.OnCancelListener) null);
                                m.PnZ.add(new b(aVar, context, new StringBuilder().append((Object) menuItem.getTitle()).toString(), -1, n.PgF));
                                if (mVar != null) {
                                    mVar.gPz();
                                }
                                AppMethodBeat.o(34467);
                                return;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                        h.a(context, context.getString(R.string.bip), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.n.AnonymousClass4.AnonymousClass6 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(34467);
                    }
                }
            };
            lVar.gXI();
            AppMethodBeat.o(34476);
        }
    }

    public static void a(String str, final com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(34478);
        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(str);
        if (fJ == null) {
            AppMethodBeat.o(34478);
        } else if (fJ.UH()) {
            Intent intent = new Intent(aVar.Pwc.getContext(), BizChatSelectConversationUI.class);
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("biz_chat_scene", 2);
            intent.putExtra("enterprise_extra_params", PgF.PgM);
            aVar.a(intent, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, new c.a() {
                /* class com.tencent.mm.ui.chatting.n.AnonymousClass6 */

                @Override // com.tencent.mm.br.c.a
                public final void onActivityResult(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(34469);
                    if (intent == null) {
                        Log.w("MicroMsg.ChattingEditModeSendToBrand", "[onActivityResult] data is null!");
                        AppMethodBeat.o(34469);
                        return;
                    }
                    if (i2 == 225) {
                        n.a(aVar, intent.getStringExtra("enterprise_biz_name"), intent.getLongExtra("key_biz_chat_id", -1));
                    }
                    AppMethodBeat.o(34469);
                }
            });
            AppMethodBeat.o(34478);
        } else {
            if (fJ.UF()) {
                Intent intent2 = new Intent();
                intent2.putExtra("enterprise_biz_name", str);
                intent2.putExtra("enterprise_scene", 1);
                com.tencent.mm.br.c.a(aVar.Pwc, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2, (int) TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR);
            }
            AppMethodBeat.o(34478);
        }
    }

    public static rc cI(Context context, String str) {
        AppMethodBeat.i(34479);
        rc rcVar = new rc();
        rcVar.dXF.type = 6;
        rcVar.dXF.dXK = PgF.PgD;
        rcVar.dXF.toUser = str;
        rcVar.dXF.from = PgF.from;
        rcVar.dXF.context = context;
        EventCenter.instance.publish(rcVar);
        PgF.dWX = rcVar.dXG.dWX;
        PgF.PgE = rcVar.dXG.dXM;
        AppMethodBeat.o(34479);
        return rcVar;
    }

    /* access modifiers changed from: package-private */
    public static class b implements QueueWorkerThread.ThreadObject {
        private a PgN;
        private Context context;
        private com.tencent.mm.ui.chatting.e.a dom;
        private String iNV;
        private long ppv;
        private boolean tca;

        public b(com.tencent.mm.ui.chatting.e.a aVar, Context context2, String str, long j2, a aVar2) {
            AppMethodBeat.i(34470);
            this.dom = aVar;
            this.context = context2;
            this.iNV = str;
            this.ppv = j2;
            this.PgN = aVar2;
            this.tca = com.tencent.mm.al.g.DQ(str);
            AppMethodBeat.o(34470);
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(34471);
            if (this.tca) {
                com.tencent.mm.al.a.c bs = ag.baj().bs(this.ppv);
                synchronized (com.tencent.mm.al.a.e.iPQ) {
                    try {
                        String ajw = com.tencent.mm.al.a.e.ajw();
                        com.tencent.mm.al.a.e.d(bs);
                        if (this.PgN.PgM) {
                            gNC();
                        } else {
                            gND();
                        }
                        com.tencent.mm.al.a.e.NL(ajw);
                    } finally {
                        AppMethodBeat.o(34471);
                    }
                }
            } else {
                if (this.PgN.PgM) {
                    gNC();
                } else {
                    gND();
                }
                AppMethodBeat.o(34471);
            }
            return true;
        }

        private void a(Context context2, ca caVar, boolean z, String str) {
            AppMethodBeat.i(34472);
            if (caVar.isText()) {
                k.a(context2, str, caVar, z);
                AppMethodBeat.o(34472);
            } else if (caVar.gAz()) {
                k.b(context2, str, caVar);
                AppMethodBeat.o(34472);
            } else if (caVar.cWJ() && !this.tca) {
                k.c(context2, str, caVar);
                AppMethodBeat.o(34472);
            } else if (caVar.dOS()) {
                k.c(context2, str, caVar, z);
                AppMethodBeat.o(34472);
            } else {
                if ((caVar.gDn() || caVar.gDo()) && !this.tca) {
                    if (!k.bh(caVar)) {
                        k.a(context2, str, caVar);
                        AppMethodBeat.o(34472);
                        return;
                    }
                } else if (caVar.dOQ()) {
                    if (this.tca && !k.bp(caVar)) {
                        AppMethodBeat.o(34472);
                        return;
                    } else if (k.bq(caVar)) {
                        AppMethodBeat.o(34472);
                        return;
                    } else if (caVar.getType() == 318767153) {
                        AppMethodBeat.o(34472);
                        return;
                    } else if (k.bw(caVar)) {
                        AppMethodBeat.o(34472);
                        return;
                    } else if (!k.bj(caVar)) {
                        k.b(context2, str, caVar, z);
                    }
                }
                AppMethodBeat.o(34472);
            }
        }

        private void gNC() {
            AppMethodBeat.i(34473);
            for (ca caVar : this.PgN.PgD) {
                a(this.context, caVar, this.PgN.Pdm, this.iNV);
            }
            AppMethodBeat.o(34473);
        }

        private void gND() {
            AppMethodBeat.i(34474);
            n.cI(this.context, this.iNV);
            rc rcVar = new rc();
            rcVar.dXF.type = 5;
            rcVar.dXF.dXK = this.PgN.PgD;
            rcVar.dXF.toUser = this.iNV;
            rcVar.dXF.from = this.PgN.from;
            rcVar.dXF.context = this.context;
            rcVar.dXF.dWX = this.PgN.dWX;
            rcVar.dXF.dXM = this.PgN.PgE;
            EventCenter.instance.publish(rcVar);
            AppMethodBeat.o(34474);
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(34475);
            if (n.Pgl != null) {
                n.Pgl.dismiss();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(this.context, this.dom.findViewById(R.id.ffv), this.context.getString(R.string.dc_), (a.c) null);
            AppMethodBeat.o(34475);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final java.lang.String r8, final com.tencent.mm.ui.chatting.e.a r9, java.util.List<com.tencent.mm.storage.ca> r10) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.n.a(java.lang.String, com.tencent.mm.ui.chatting.e.a, java.util.List):void");
    }

    public static void a(com.tencent.mm.ui.chatting.e.a aVar, String str, long j2) {
        AppMethodBeat.i(34480);
        Activity context = aVar.Pwc.getContext();
        if (!Util.isNullOrNil(str) && str.length() > 0) {
            context.getString(R.string.zb);
            Pgl = h.a((Context) context, context.getString(R.string.gkk), false, (DialogInterface.OnCancelListener) null);
            m.PnZ.add(new b(aVar, context, str, j2, PgF));
        }
        ((com.tencent.mm.ui.chatting.d.b.l) aVar.bh(com.tencent.mm.ui.chatting.d.b.l.class)).gPz();
        AppMethodBeat.o(34480);
    }
}
