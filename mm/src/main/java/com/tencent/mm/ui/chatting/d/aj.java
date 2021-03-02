package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.bbom.k;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.u;
import java.util.Arrays;

@a(gRF = ac.class)
public class aj extends a implements ac {
    boolean KiI = false;
    private boolean PrY = false;
    private Runnable PrZ = new Runnable() {
        /* class com.tencent.mm.ui.chatting.d.aj.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(35446);
            if (aj.this.dom != null) {
                ((aa) aj.this.dom.bh(aa.class)).gQr();
            }
            AppMethodBeat.o(35446);
        }
    };
    private Runnable Psa = new Runnable() {
        /* class com.tencent.mm.ui.chatting.d.aj.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(35447);
            if (aj.this.dom != null) {
                u uVar = (u) aj.this.dom.bh(u.class);
                uVar.gPO().setLbsMode(false);
                uVar.gPO().KiV = false;
                uVar.gPO().gqm();
                ChatFooter gPO = uVar.gPO();
                gPO.KiW = false;
                if (gPO.Kir != null) {
                    gPO.Kir.setVisibility(0);
                }
                gPO.Am(true);
                ChatFooter gPO2 = uVar.gPO();
                if (gPO2.Kin != null) {
                    gPO2.Kin.setVisibility(0);
                }
            }
            AppMethodBeat.o(35447);
        }
    };
    private IListener Psb = new IListener<ls>() {
        /* class com.tencent.mm.ui.chatting.d.aj.AnonymousClass3 */

        {
            AppMethodBeat.i(161531);
            this.__eventId = ls.class.getName().hashCode();
            AppMethodBeat.o(161531);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ls lsVar) {
            AppMethodBeat.i(35448);
            ls lsVar2 = lsVar;
            if ((lsVar2 instanceof ls) && aj.this.KiI && (lsVar2.dRd.dRe == null || lsVar2.dRd.dRe.equals(aj.this.dRe))) {
                if (lsVar2.dRd.type == 1) {
                    MMHandlerThread.postToMainThread(aj.this.PrZ);
                } else if (lsVar2.dRd.type == 2) {
                    aj.this.KiI = false;
                    MMHandlerThread.postToMainThread(aj.this.Psa);
                }
            }
            AppMethodBeat.o(35448);
            return false;
        }
    };
    String dRe = null;
    private String pfa = null;

    public aj() {
        AppMethodBeat.i(35449);
        AppMethodBeat.o(35449);
    }

    private void gOL() {
        AppMethodBeat.i(35450);
        EventCenter.instance.removeListener(this.Psb);
        AppMethodBeat.o(35450);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final boolean gQH() {
        return this.KiI;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final void a(Button button, LinearLayout linearLayout, LinearLayout linearLayout2) {
        AppMethodBeat.i(35452);
        if (this.pfa == null) {
            bx bky = d.bgO().bky(this.dRe);
            if (bky != null) {
                ((TextView) linearLayout.findViewById(R.id.gq)).setText(bky.field_sayhicontent);
                ((Button) linearLayout.findViewById(R.id.aru)).setText(R.string.azw);
                AppMethodBeat.o(35452);
                return;
            }
            linearLayout2.setVisibility(8);
            AppMethodBeat.o(35452);
        } else if (this.PrY) {
            ((TextView) linearLayout.findViewById(R.id.gq)).setText(R.string.azy);
            button.setVisibility(8);
            AppMethodBeat.o(35452);
        } else {
            ((TextView) linearLayout.findViewById(R.id.gq)).setText(R.string.azz);
            ((Button) linearLayout.findViewById(R.id.aru)).setText(R.string.azx);
            AppMethodBeat.o(35452);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final void amD(int i2) {
        AppMethodBeat.i(35453);
        if (this.pfa != null) {
            String format = String.format(this.dom.Pwc.getMMResources().getString(R.string.ack), Util.nullAsNil(z.aUa()));
            com.tencent.mm.pluginsdk.ui.applet.aa aaVar = new com.tencent.mm.pluginsdk.ui.applet.aa(this.dom.Pwc.getContext(), null);
            aaVar.content = format;
            aaVar.z(Arrays.asList(this.dRe), Arrays.asList(18));
            this.PrY = true;
        } else {
            bx bky = d.bgO().bky(this.dRe);
            bg.azz().a(new p(this.dRe, bky.field_ticket, i2), 0);
            bky.field_flag = 2;
            d.bgO().update(bky, new String[0]);
        }
        ((aa) this.dom.bh(aa.class)).gQr();
        AppMethodBeat.o(35453);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final void bD(Intent intent) {
        AppMethodBeat.i(35454);
        intent.putExtra("Contact_IsLBSFriend", true);
        intent.putExtra("Contact_IsLbsChattingProfile", true);
        intent.putExtra("Contact_Scene", 18);
        AppMethodBeat.o(35454);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35461);
        gOL();
        AppMethodBeat.o(35461);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35462);
        super.gOK();
        gOL();
        AppMethodBeat.o(35462);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final boolean gPG() {
        AppMethodBeat.i(35451);
        if (this.KiI) {
            bx bky = d.bgO().bky(this.dRe);
            if (!(this.pfa == null && bky == null)) {
                ((aa) this.dom.bh(aa.class)).gQr();
            }
            AppMethodBeat.o(35451);
            return true;
        }
        AppMethodBeat.o(35451);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final String bmM(String str) {
        String str2;
        AppMethodBeat.i(35455);
        if (this.KiI) {
            Log.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.dRe + ",raw:" + this.dom.getTalkerUserName());
            str2 = Util.isNullOrNil(this.dRe) ? this.dom.getTalkerUserName() : this.dRe;
        } else {
            str2 = str;
        }
        AppMethodBeat.o(35455);
        return str2;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ac
    public final void g(i iVar) {
        bx bky;
        bx bxVar = null;
        AppMethodBeat.i(35456);
        if (this.KiI) {
            String str = this.pfa;
            by bgO = d.bgO();
            String str2 = this.dRe;
            Cursor rawQuery = bgO.db.rawQuery("SELECT * FROM " + bgO.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1", new String[]{str2}, 2);
            if (rawQuery != null) {
                if (!rawQuery.moveToFirst()) {
                    rawQuery.close();
                } else {
                    bxVar = new bx();
                    bxVar.convertFrom(rawQuery);
                    rawQuery.close();
                }
            }
            if (bxVar != null && !Util.isNullOrNil(bxVar.field_ticket)) {
                str = bxVar.field_ticket;
            }
            if (Util.isNullOrNil(str) && (bky = d.bgO().bky(this.dRe)) != null && !Util.isNullOrNil(bky.field_ticket)) {
                str = bky.field_ticket;
            }
            if (str != null) {
                iVar.jcU = new k(str);
            }
        }
        AppMethodBeat.o(35456);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        String str;
        AppMethodBeat.i(35457);
        this.KiI = this.dom.Pwc.getBooleanExtra("lbs_mode", false).booleanValue();
        if (Util.isNullOrNil(this.dom.GUe.field_encryptUsername)) {
            str = this.dom.getTalkerUserName();
        } else {
            str = this.dom.GUe.field_encryptUsername;
        }
        this.dRe = str;
        this.pfa = this.dom.Pwc.getStringExtra("lbs_ticket");
        AppMethodBeat.o(35457);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35458);
        if (this.KiI) {
            u uVar = (u) this.dom.bh(u.class);
            uVar.gPO().setLbsMode(true);
            ChatFooter gPO = uVar.gPO();
            if (gPO.Kir != null) {
                gPO.Kir.setVisibility(8);
            }
            gPO.Am(false);
            ChatFooter gPO2 = uVar.gPO();
            if (gPO2.Kin != null) {
                gPO2.Kin.setVisibility(8);
            }
        }
        AppMethodBeat.o(35458);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35459);
        EventCenter.instance.addListener(this.Psb);
        AppMethodBeat.o(35459);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35460);
        MMHandlerThread.removeRunnable(this.PrZ);
        MMHandlerThread.removeRunnable(this.Psa);
        AppMethodBeat.o(35460);
    }
}
