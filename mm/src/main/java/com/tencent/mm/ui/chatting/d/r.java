package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.d.b.h;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;

@com.tencent.mm.ui.chatting.d.a.a(gRF = ar.class)
public class r extends a implements ar {
    private boolean PoQ = false;
    private boolean PoR = false;
    private String PoS;
    private String PoT;
    private long PoU;
    private long PoV = -1;
    private a PoW = a.PoX;

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35268);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 212:
                if (intent != null) {
                    u uVar = (u) this.dom.bh(u.class);
                    String stringExtra = intent.getStringExtra("select_raw_user_name");
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra2)) {
                        Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", stringExtra2);
                        uVar.gPO().setAtSomebody(stringExtra2);
                        uVar.gPO().bj(this.dom.getTalkerUserName(), stringExtra, stringExtra2);
                        this.PoQ = true;
                        break;
                    } else {
                        Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", "[nobody]");
                        uVar.gPO().setAtSomebody("");
                        this.PoQ = false;
                        AppMethodBeat.o(35268);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(35268);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
    }

    /* access modifiers changed from: package-private */
    public enum a {
        PoX,
        show;

        public static a valueOf(String str) {
            AppMethodBeat.i(35266);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(35266);
            return aVar;
        }

        static {
            AppMethodBeat.i(35267);
            AppMethodBeat.o(35267);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ar
    public final void gPJ() {
        AppMethodBeat.i(35273);
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(35273);
            return;
        }
        u uVar = (u) this.dom.bh(u.class);
        if (uVar.gPO() != null) {
            if (!Util.isNullOrNil(this.PoS) || this.PoU != 0) {
                boolean z = uVar.gPO().getMode() == 1 && Util.isNullOrNil(uVar.gPR());
                boolean gRb = ((am) this.dom.bh(am.class)).gRb();
                if (!z || gRb) {
                    gPK();
                } else {
                    gPL();
                }
                if (this.PoU != 0) {
                    uVar.gPO().setLastQuoteMsgId(this.PoU);
                }
                boolean gOQ = ((d) this.dom.bh(d.class)).gOQ();
                if ((this.dom.gRL() || gOQ) && this.PoQ) {
                    this.PoQ = false;
                    String atSomebody = uVar.gPO().getAtSomebody();
                    if (!Util.isNullOrNil(atSomebody)) {
                        int insertPos = uVar.gPO().getInsertPos();
                        if (insertPos > this.PoS.length()) {
                            insertPos = this.PoS.length();
                        }
                        StringBuilder append = new StringBuilder().append(this.PoS.substring(0, insertPos)).append(atSomebody).append((char) 8197);
                        String str = this.PoS;
                        String sb = append.append(str.substring(insertPos, str.length())).toString();
                        uVar.gPO().setLastContent(sb);
                        uVar.gPO().z(sb, insertPos + atSomebody.length() + 1, false);
                        uVar.gPO().setAtSomebody(null);
                        gPL();
                    }
                } else {
                    uVar.gPO().setLastContent(this.PoS);
                    uVar.gPO().setLastText(this.PoS);
                    if ((!Util.isNullOrNil(this.PoS) || this.PoU != 0) && !gRb && Util.isNullOrNil(uVar.gPR())) {
                        uVar.gPY();
                    }
                }
                uVar.gPU();
                AppMethodBeat.o(35273);
                return;
            } else if (((ac) this.dom.bh(ac.class)).gQH()) {
                uVar.gPO().setLastText(this.PoS);
                uVar.gPO().setHint(this.dom.Pwc.getMMResources().getString(R.string.b36));
                uVar.gPO().setLastQuoteMsgId(this.PoU);
                AppMethodBeat.o(35273);
                return;
            } else if (uVar.gPO().getIsVoiceInputPanleShow()) {
                uVar.gPU();
                AppMethodBeat.o(35273);
                return;
            } else {
                gPK();
            }
        }
        AppMethodBeat.o(35273);
    }

    private void gPK() {
        AppMethodBeat.i(35274);
        u uVar = (u) this.dom.bh(u.class);
        if (uVar.gPO() == null) {
            AppMethodBeat.o(35274);
            return;
        }
        uVar.gPO().Aj(this.PoW == a.show);
        AppMethodBeat.o(35274);
    }

    private void gPL() {
        AppMethodBeat.i(35275);
        u uVar = (u) this.dom.bh(u.class);
        if (uVar.gPO() == null) {
            AppMethodBeat.o(35275);
            return;
        }
        uVar.gPO().gqK();
        AppMethodBeat.o(35275);
    }

    @Override // com.tencent.mm.ui.l
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(35269);
        if (keyEvent.getKeyCode() == 67) {
            u uVar = (u) this.dom.bh(u.class);
            if (keyEvent.getAction() == 0) {
                if (uVar.gPO().getCharAtCursor() == 8197) {
                    this.PoR = true;
                } else {
                    this.PoR = false;
                }
            }
            if (keyEvent.getAction() == 1 && this.PoR) {
                this.PoR = false;
                ChatFooter gPO = uVar.gPO();
                int selectionStart = gPO.getSelectionStart();
                String substring = gPO.getLastText().substring(0, selectionStart);
                int lastIndexOf = substring.lastIndexOf(64);
                if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                    String substring2 = substring.substring(0, lastIndexOf);
                    String substring3 = gPO.getLastText().substring(selectionStart);
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring2).append(substring3);
                    gPO.setLastText(sb.toString());
                    gPO.ECK.setSelection(lastIndexOf);
                }
            }
        }
        AppMethodBeat.o(35269);
        return false;
    }

    @Override // com.tencent.mm.ui.l
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(35270);
        u uVar = (u) this.dom.bh(u.class);
        this.PoS = uVar.gPO().getLastText();
        this.PoU = uVar.gPO().getLastQuoteMsgId();
        gPJ();
        AppMethodBeat.o(35270);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35271);
        Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
        this.PoW = a.PoX;
        if (this.dom.GUe != null) {
            d dVar = (d) this.dom.bh(d.class);
            if (dVar.gOP()) {
                String str = ag.bak().Al(dVar.gPc()).field_editingMsg;
                this.PoS = str;
                this.PoT = str;
                AppMethodBeat.o(35271);
                return;
            } else if (((h) this.dom.bh(h.class)).gPu()) {
                String avh = ((n) g.af(n.class)).avh(this.dom.getTalkerUserName());
                this.PoS = avh;
                this.PoT = avh;
                AppMethodBeat.o(35271);
                return;
            } else if (((i) this.dom.bh(i.class)).gPw()) {
                String avh2 = ((c) g.af(c.class)).avh(this.dom.getTalkerUserName());
                this.PoS = avh2;
                this.PoT = avh2;
                AppMethodBeat.o(35271);
                return;
            } else {
                bg.aVF();
                az bjY = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
                if (bjY != null) {
                    String str2 = bjY.field_editingMsg;
                    this.PoS = str2;
                    this.PoT = str2;
                    long j2 = bjY.field_editingQuoteMsgId;
                    this.PoU = j2;
                    this.PoV = j2;
                }
            }
        }
        AppMethodBeat.o(35271);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        az azVar;
        boolean z;
        long currentTimeMillis;
        AppMethodBeat.i(35272);
        u uVar = (u) this.dom.bh(u.class);
        if (uVar.gPO() != null) {
            if (uVar.gPO().xfU) {
                this.PoW = a.show;
                Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
            } else {
                this.PoW = a.PoX;
                Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
            }
            this.PoS = uVar.gPO().getLastText();
            this.PoU = uVar.gPO().getLastQuoteMsgId();
        }
        u uVar2 = (u) this.dom.bh(u.class);
        d dVar = (d) this.dom.bh(d.class);
        if (dVar.gOP()) {
            com.tencent.mm.al.a.a Al = ag.bak().Al(dVar.gPc());
            if (uVar2.gPO() != null && (this.PoT == null || !uVar2.gPO().getLastText().trim().equals(this.PoT))) {
                this.PoT = uVar2.gPO().getLastText().trim();
                Al.field_editingMsg = this.PoT;
                Al.field_flag = b.a(Al, 1, Util.isNullOrNil(Al.field_editingMsg) ? Al.field_lastMsgTime : System.currentTimeMillis());
                ag.bak().b(Al);
                Log.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
            }
            AppMethodBeat.o(35272);
            return;
        }
        if (((h) this.dom.bh(h.class)).gPu()) {
            if (uVar2.gPO() != null && (this.PoT == null || !uVar2.gPO().getLastText().trim().equals(this.PoT))) {
                this.PoT = uVar2.gPO().getLastText().trim();
                ((n) g.af(n.class)).gT(this.dom.getTalkerUserName(), this.PoT);
                AppMethodBeat.o(35272);
                return;
            }
        } else if (!((i) this.dom.bh(i.class)).gPw()) {
            az azVar2 = null;
            if (g.aAf().azp()) {
                bg.aVF();
                azVar2 = com.tencent.mm.model.c.aST().bjY(this.dom.getTalkerUserName());
            }
            if (azVar2 != null || uVar2.gPO() == null || Util.isNullOrNil(uVar2.gPO().getLastText().trim())) {
                azVar = azVar2;
            } else {
                azVar = new az(this.dom.GUe.field_username);
                azVar.yA(System.currentTimeMillis());
                if (((ae) this.dom.bh(ae.class)).gQM()) {
                    azVar.oT(4194304);
                }
                bg.aVF();
                com.tencent.mm.model.c.aST().e(azVar);
            }
            if (!(azVar == null || uVar2.gPO() == null)) {
                if (this.PoT == null || !uVar2.gPO().getLastText().trim().equals(this.PoT)) {
                    this.PoT = uVar2.gPO().getLastText().trim();
                    azVar.Cp(uVar2.gPO().getLastText().trim());
                    if ("hidden_conv_parent".equalsIgnoreCase(azVar.field_parentRef)) {
                        azVar.Co(null);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21170, 4, azVar.field_username, Integer.valueOf(com.tencent.mm.model.ac.JT(azVar.field_username)));
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (this.PoV == -1 || !Util.isEqual(uVar2.gPO().getLastQuoteMsgId(), this.PoV)) {
                    this.PoV = uVar2.gPO().getLastQuoteMsgId();
                    azVar.field_editingQuoteMsgId = this.PoV;
                    azVar.fvI = true;
                    if ("hidden_conv_parent".equalsIgnoreCase(azVar.field_parentRef)) {
                        azVar.Co(null);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21170, 4, azVar.field_username, Integer.valueOf(com.tencent.mm.model.ac.JT(azVar.field_username)));
                    }
                    z = true;
                }
                if (z) {
                    if (!Util.isNullOrNil(azVar.field_editingMsg) || azVar.field_editingQuoteMsgId != 0) {
                        currentTimeMillis = System.currentTimeMillis();
                    } else {
                        currentTimeMillis = azVar.field_conversationTime;
                    }
                    azVar.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 1, currentTimeMillis));
                    bg.aVF();
                    com.tencent.mm.model.c.aST().a(azVar, azVar.field_username, false);
                }
            }
            Log.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", Util.secPrint(this.PoT), Long.valueOf(this.PoV), this.dom.getTalkerUserName());
        } else if (uVar2.gPO() != null && (this.PoT == null || !uVar2.gPO().getLastText().trim().equals(this.PoT))) {
            this.PoT = uVar2.gPO().getLastText().trim();
            ((c) g.af(c.class)).gT(this.dom.getTalkerUserName(), this.PoT);
            AppMethodBeat.o(35272);
            return;
        }
        AppMethodBeat.o(35272);
    }
}
