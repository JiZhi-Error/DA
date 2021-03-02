package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.j;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.x;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import java.nio.charset.Charset;
import java.util.Iterator;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private i BHC;
    private String BHK = "";
    private String BHL = "";
    private c BHZ = null;
    private boolean BIa = false;
    private String BIb = "";
    private String BIc = "";
    private boolean BId;
    IListener<sv> BIe = new IListener<sv>() {
        /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass1 */

        {
            AppMethodBeat.i(232026);
            this.__eventId = sv.class.getName().hashCode();
            AppMethodBeat.o(232026);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sv svVar) {
            AppMethodBeat.i(232027);
            sv svVar2 = svVar;
            if ((svVar2 instanceof sv) && Util.isEqual(svVar2.dZo.msgId, RecordMsgDetailUI.this.msgId)) {
                Log.i("MicroMsg.RecordMsgDetailUI", "msg(%s) history revoked", Long.valueOf(RecordMsgDetailUI.this.msgId));
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232025);
                        com.tencent.mm.ui.base.h.a(RecordMsgDetailUI.this, RecordMsgDetailUI.this.getString(R.string.gio), "", RecordMsgDetailUI.this.getString(R.string.j34), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(232024);
                                Log.i("MicroMsg.RecordMsgDetailUI", "revoke history alert: click i know");
                                RecordMsgDetailUI.this.finish();
                                AppMethodBeat.o(232024);
                            }
                        });
                        AppMethodBeat.o(232025);
                    }
                });
            }
            AppMethodBeat.o(232027);
            return true;
        }
    };
    private ca dCM;
    private boolean dUo = true;
    private String dXH = null;
    private q gxX = null;
    private long msgId = -1;
    private String title = "";

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RecordMsgDetailUI() {
        AppMethodBeat.i(232037);
        AppMethodBeat.o(232037);
    }

    static /* synthetic */ String b(RecordMsgDetailUI recordMsgDetailUI, c cVar) {
        AppMethodBeat.i(27893);
        String a2 = recordMsgDetailUI.a(cVar);
        AppMethodBeat.o(27893);
        return a2;
    }

    static /* synthetic */ void f(RecordMsgDetailUI recordMsgDetailUI) {
        AppMethodBeat.i(27894);
        recordMsgDetailUI.updateView();
        AppMethodBeat.o(27894);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27885);
        super.onCreate(bundle);
        this.BIe.alive();
        AppMethodBeat.o(27885);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void eIs() {
        k.b aD;
        AppMethodBeat.i(27886);
        this.msgId = getIntent().getLongExtra("message_id", -1);
        this.dXH = getIntent().getStringExtra("record_xml");
        this.dUo = getIntent().getBooleanExtra("record_show_share", true);
        this.BIa = getIntent().getBooleanExtra("big_appmsg", false);
        this.BId = getIntent().getBooleanExtra("record_nest", false);
        this.BHK = getIntent().getStringExtra("pre_username");
        if (Util.isNullOrNil(this.BHK)) {
            this.BHK = getIntent().getStringExtra("msgUsername");
        }
        this.BHL = getIntent().getStringExtra("serverMsgID");
        this.BHZ = p.aKY(this.dXH);
        bg.aVF();
        this.dCM = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        if (this.BHZ != null) {
            if (a(this.BHZ) != null) {
                this.title = a(this.BHZ);
            } else {
                this.title = this.BHZ.title;
            }
            if (!Util.isNullOrNil(this.BHZ.iAd)) {
                this.BIb = this.BHZ.iAd.getFirst().Lwl;
                this.BIc = this.BHZ.iAd.getLast().Lwl;
            }
        } else if (!(this.dCM == null || (aD = k.b.aD(this.dCM.field_content, this.dCM.field_reserved)) == null)) {
            this.title = aD.title;
            this.gxX = q.a(this, getString(R.string.ekc), true, 0, null);
        }
        if (this.dXH == null || this.BHZ == null) {
            eIA();
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(232028);
                    RecordMsgDetailUI.this.finish();
                    AppMethodBeat.o(232028);
                    return true;
                }
            });
            if (this.BIa && ao.cgO().Mp(this.msgId) != null) {
                bg.aVF();
                bg.azz().a(new f(this.msgId, com.tencent.mm.model.c.aSQ().Hb(this.msgId).field_msgSvrId, new j() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass3 */

                    @Override // com.tencent.mm.ak.j
                    public final void a(int i2, int i3, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(232029);
                        if (i2 == i3) {
                            if (RecordMsgDetailUI.this.gxX != null) {
                                RecordMsgDetailUI.this.gxX.dismiss();
                                RecordMsgDetailUI.this.gxX = null;
                            }
                            bg.aVF();
                            ca Hb = com.tencent.mm.model.c.aSQ().Hb(RecordMsgDetailUI.this.msgId);
                            String str = Hb.field_content;
                            if (ab.Eq(Hb.field_talker)) {
                                str = bp.Kt(Hb.field_content);
                            }
                            k.b HD = k.b.HD(str);
                            if (HD != null) {
                                RecordMsgDetailUI.this.dXH = HD.ixl;
                                RecordMsgDetailUI.this.BHZ = p.aKY(RecordMsgDetailUI.this.dXH);
                                if (RecordMsgDetailUI.this.BHZ != null) {
                                    if (RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.BHZ) != null) {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.b(RecordMsgDetailUI.this, RecordMsgDetailUI.this.BHZ);
                                    } else {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.this.BHZ.title;
                                    }
                                    RecordMsgDetailUI.this.BIb = RecordMsgDetailUI.this.BHZ.iAd.getFirst().Lwl;
                                    RecordMsgDetailUI.this.BIc = RecordMsgDetailUI.this.BHZ.iAd.getLast().Lwl;
                                }
                                RecordMsgDetailUI.f(RecordMsgDetailUI.this);
                            }
                        }
                        AppMethodBeat.o(232029);
                    }
                }), 0);
            }
            AppMethodBeat.o(27886);
            return;
        }
        updateView();
        AppMethodBeat.o(27886);
    }

    private String a(c cVar) {
        String str;
        String str2;
        AppMethodBeat.i(27887);
        if (cVar != null) {
            Iterator<aml> it = cVar.iAd.iterator();
            boolean z = false;
            String str3 = null;
            String str4 = null;
            str = null;
            while (it.hasNext()) {
                aml next = it.next();
                if (next.Lwh.LwO.LxA != null) {
                    z = true;
                    str = getContext().getString(R.string.fvq);
                } else {
                    if (next.Lwh.LwO.dRL != null) {
                        if (str4 == null) {
                            str4 = next.Lwj;
                        } else if (str4 != next.Lwj) {
                            str2 = next.Lwj;
                            str3 = str2;
                        }
                    }
                    str2 = str3;
                    str3 = str2;
                }
            }
            if (str4 != null && str3 == null && !z) {
                str = getContext().getString(R.string.cb7, new Object[]{str4});
            } else if (str4 != null && str3 != null && !str4.equals(str3) && !z) {
                str = getContext().getString(R.string.cb6, new Object[]{str4, str3});
            }
        } else {
            str = null;
        }
        AppMethodBeat.o(27887);
        return str;
    }

    private void updateView() {
        AppMethodBeat.i(27888);
        f fVar = new f();
        fVar.BHs = this.BHZ.iAd;
        fVar.msgId = this.msgId;
        fVar.dXH = this.dXH;
        fVar.BHK = this.BHK;
        fVar.BHL = this.BHL;
        fVar.BHt = new x();
        if (!(this.dCM == null || this.BId || this.dCM.field_transContent == null)) {
            try {
                fVar.BHt.parseFrom(this.dCM.field_transContent.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.RecordMsgDetailUI", e2, "", new Object[0]);
            }
        }
        super.eIs();
        this.BHV.a(fVar);
        this.BHC = new i(this, this.BHV, fVar);
        this.BHV.BHC = this.BHC;
        ((a) g.ah(a.class)).getRecordMsgCDNStorage().a((e) this.BHV);
        AppMethodBeat.o(27888);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final h eIt() {
        AppMethodBeat.i(27889);
        e eVar = new e(this, new g());
        eVar.fromScene = getIntent().getIntExtra("from_scene", 0);
        eVar.BHK = getIntent().getStringExtra("msgUsername");
        String stringExtra = getIntent().getStringExtra("serverMsgID");
        if (Util.isNullOrNil(stringExtra)) {
            String stringExtra2 = getIntent().getStringExtra("prePublishId");
            if (!Util.isNullOrNil(stringExtra2)) {
                stringExtra = stringExtra2.replace("msg_", "");
            }
        }
        eVar.BHL = stringExtra;
        AppMethodBeat.o(27889);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(232038);
        super.onPause();
        if (this.BHC != null) {
            this.BHC.BID = false;
        }
        AppMethodBeat.o(232038);
    }

    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27890);
        super.onDestroy();
        this.BIe.dead();
        ((a) g.ah(a.class)).getRecordMsgCDNStorage().b((e) this.BHV);
        if (this.BHC != null) {
            byte[] eID = this.BHC.eID();
            if (!this.BId && this.dCM != null && eID != null && eID.length > 0) {
                this.dCM.CB(new String(eID, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                bg.aVF();
                com.tencent.mm.model.c.aSQ().a(this.msgId, this.dCM);
            }
        }
        AppMethodBeat.o(27890);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIu() {
        return this.title;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIv() {
        return this.BIb;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final String eIw() {
        return this.BIc;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void eIx() {
        AppMethodBeat.i(27891);
        if (!this.dUo) {
            AppMethodBeat.o(27891);
            return;
        }
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(232033);
                e eVar = new e((Context) RecordMsgDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(232030);
                        mVar.d(0, RecordMsgDetailUI.this.getString(R.string.cc8));
                        if (RecordMsgDetailUI.this.getIntent().getIntExtra("from_scene", 0) == 0) {
                            mVar.d(2, RecordMsgDetailUI.this.getString(R.string.fn9));
                        }
                        AppMethodBeat.o(232030);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass4.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(232032);
                        switch (menuItem.getItemId()) {
                            case 0:
                                bg.aVF();
                                if (!((Boolean) com.tencent.mm.model.c.azQ().get(327714, Boolean.FALSE)).booleanValue()) {
                                    bg.aVF();
                                    com.tencent.mm.model.c.azQ().set(327714, Boolean.TRUE);
                                    d.a aVar = new d.a(RecordMsgDetailUI.this);
                                    aVar.boo(RecordMsgDetailUI.this.getResources().getString(R.string.fwl));
                                    aVar.bon(RecordMsgDetailUI.this.getResources().getString(R.string.zb));
                                    aVar.aoV(R.string.e2u).c(new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(232031);
                                            Intent intent = new Intent();
                                            intent.putExtra("Select_Conv_Type", 3);
                                            intent.putExtra("select_is_ret", true);
                                            intent.putExtra("mutil_select_is_ret", true);
                                            intent.putExtra("Retr_Msg_Type", 10);
                                            intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.this.msgId);
                                            com.tencent.mm.br.c.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1001);
                                            dialogInterface.dismiss();
                                            AppMethodBeat.o(232031);
                                        }
                                    });
                                    aVar.hbn().show();
                                    AppMethodBeat.o(232032);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("Retr_Msg_Type", 10);
                                intent.putExtra("Retr_Msg_Id", RecordMsgDetailUI.this.msgId);
                                com.tencent.mm.br.c.c(RecordMsgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1001);
                                AppMethodBeat.o(232032);
                                return;
                            case 1:
                                AppMethodBeat.o(232032);
                                return;
                            case 2:
                                cz czVar = new cz();
                                com.tencent.mm.pluginsdk.model.h.a(czVar, RecordMsgDetailUI.this.msgId);
                                czVar.dFZ.dGf = 9;
                                czVar.dFZ.activity = RecordMsgDetailUI.this;
                                EventCenter.instance.publish(czVar);
                                break;
                        }
                        AppMethodBeat.o(232032);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(232033);
                return true;
            }
        });
        AppMethodBeat.o(27891);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.ui.RecordMsgBaseUI
    public final void f(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27892);
        if (-1 != i3) {
            Log.e("MicroMsg.RecordMsgDetailUI", "processResult %d", Integer.valueOf(i3));
            AppMethodBeat.o(27892);
        } else if (1001 == i2) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (Util.isNullOrNil(stringExtra)) {
                Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                AppMethodBeat.o(27892);
                return;
            }
            bg.aVF();
            final ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
            if (Hb.field_msgId != this.msgId) {
                Log.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                AppMethodBeat.o(27892);
                return;
            }
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(232035);
                    p.a(stringExtra, stringExtra2, Hb);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232034);
                            a2.dismiss();
                            AppMethodBeat.o(232034);
                        }
                    });
                    AppMethodBeat.o(232035);
                }

                public final String toString() {
                    AppMethodBeat.i(232036);
                    String str = super.toString() + "|onActivityResult";
                    AppMethodBeat.o(232036);
                    return str;
                }
            });
            AppMethodBeat.o(27892);
        } else {
            if (1002 == i2 && intent.getBooleanExtra("kfavorite", false)) {
                cz czVar = new cz();
                com.tencent.mm.pluginsdk.model.h.a(czVar, intent);
                czVar.dFZ.activity = this;
                czVar.dFZ.dGf = 8;
                EventCenter.instance.publish(czVar);
            }
            AppMethodBeat.o(27892);
        }
    }
}
