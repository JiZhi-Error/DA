package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.DialPad;
import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class j implements e, a.b {
    private TextView gCd;
    ImageView gyr;
    private String krY;
    private String mCountryCode;
    DialPad ysX;
    private String yvn;
    private String yvo;
    private String yvp;
    private int yvq;
    private int yvr;
    private ImageButton yzA;
    public TextView yzB;
    public View yzC;
    private ImageButton yzD;
    private int yzE = -1;
    String yzF;
    IPCallTalkUI yzG;
    c yzH;
    a yzI;
    private long yzJ;
    long yzK = -1;
    boolean yzL = false;
    boolean yzM = false;
    private AudioManager yzN = null;
    private boolean yzO = false;
    private boolean yzP = true;
    private boolean yzQ = false;
    boolean yzR = false;
    boolean yzS = false;
    Bitmap yzl;
    EditText yzu;
    TextView yzv;
    ImageView yzw;
    private IPCallFuncButton yzx;
    private IPCallFuncButton yzy;
    private IPCallFuncButton yzz;

    public interface a {
        void qC(boolean z);
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        AppMethodBeat.i(26034);
        this.yzG = iPCallTalkUI;
        this.yzH = i.eax();
        this.yzH.yof = this;
        AppMethodBeat.o(26034);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(26035);
        this.yzO = this.yzG.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        Log.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", str, str2, str3, str4, str5, Boolean.valueOf(this.yzO));
        this.yzw = (ImageView) this.yzG.findViewById(R.id.ihz);
        this.gyr = (ImageView) this.yzG.findViewById(R.id.ihx);
        this.yzu = (EditText) this.yzG.findViewById(R.id.ii4);
        this.gCd = (TextView) this.yzG.findViewById(R.id.ii7);
        this.yzv = (TextView) this.yzG.findViewById(R.id.ii5);
        this.yzx = (IPCallFuncButton) this.yzG.findViewById(R.id.ii3);
        this.yzy = (IPCallFuncButton) this.yzG.findViewById(R.id.ii0);
        this.yzz = (IPCallFuncButton) this.yzG.findViewById(R.id.ii6);
        this.yzA = (ImageButton) this.yzG.findViewById(R.id.ii2);
        this.yzD = (ImageButton) this.yzG.findViewById(R.id.e1j);
        this.yzB = (TextView) this.yzG.findViewById(R.id.jbc);
        this.yzC = this.yzG.findViewById(R.id.jbd);
        this.ysX = (DialPad) this.yzG.findViewById(R.id.bqi);
        if (this.yzO) {
            ebD();
            ebz();
            initUI();
            ebE();
            AppMethodBeat.o(26035);
        } else if (i.eaw().eal()) {
            h.a((Context) this.yzG, (int) R.string.e3i, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26022);
                    j.this.yzG.finish();
                    AppMethodBeat.o(26022);
                }
            });
            AppMethodBeat.o(26035);
        } else {
            ebz();
            this.krY = str;
            this.yvn = str2;
            this.yvo = str3;
            this.mCountryCode = str4;
            this.yvq = i2;
            this.yvr = i3;
            if (!Util.isNullOrNil(this.yvn)) {
                this.yvn = com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(this.yvn);
            }
            if (Util.isNullOrNil(this.mCountryCode)) {
                if (com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn)) {
                    String extractCountryCode = com.tencent.mm.plugin.ipcall.a.a.extractCountryCode(this.yvn);
                    if (Util.isNullOrNil(extractCountryCode)) {
                        this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCz(this.yvn);
                    } else {
                        this.yvn = com.tencent.mm.plugin.ipcall.a.a.aCB(this.yvn);
                        this.mCountryCode = extractCountryCode;
                    }
                }
                this.mCountryCode = com.tencent.mm.plugin.ipcall.a.c.ebO();
            }
            Log.i("MicroMsg.TalkUIController", "final mCountryCode: %s", this.mCountryCode);
            com.tencent.mm.plugin.ipcall.model.c.ead().aBS(this.mCountryCode);
            if (Util.isNullOrNil(this.krY)) {
                this.krY = com.tencent.mm.plugin.ipcall.a.a.bb(this.yzG, this.yvn);
            }
            this.yvp = str5;
            eby();
            Log.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", this.yzF);
            if (com.tencent.mm.plugin.ipcall.model.c.ead().OY(Util.getInt(this.mCountryCode, -1))) {
                ebx();
                AppMethodBeat.o(26035);
            } else if (!NetStatusUtil.isNetworkConnected(this.yzG)) {
                Toast.makeText(this.yzG, (int) R.string.i3o, 1).show();
                this.yzG.finish();
                AppMethodBeat.o(26035);
            } else {
                long j2 = this.yzG.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                long currentTimeMillis = System.currentTimeMillis();
                if (j2 <= currentTimeMillis || j2 == -1) {
                    initUI();
                    if (!this.yzO || !i.eaw().eal()) {
                        ebC();
                    }
                    this.yzQ = false;
                    AppMethodBeat.o(26035);
                    return;
                }
                Log.i("MicroMsg.TalkUIController", "onDisasterHappen");
                h.a((Context) this.yzG, this.yzG.getString(R.string.e6c, new Object[]{String.valueOf(((j2 - currentTimeMillis) / 1000) + 1)}), this.yzG.getString(R.string.e63), this.yzG.getString(R.string.e64), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(26026);
                        j.this.yzG.finish();
                        AppMethodBeat.o(26026);
                    }
                });
                AppMethodBeat.o(26035);
            }
        }
    }

    private void ebx() {
        AppMethodBeat.i(26036);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(12058, this.mCountryCode);
        h.a((Context) this.yzG, this.yzG.getString(R.string.ami), this.yzG.getString(R.string.amj), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(26027);
                j.this.yzG.finish();
                j.this.yzG = null;
                AppMethodBeat.o(26027);
            }
        });
        AppMethodBeat.o(26036);
    }

    private void f(String str, String str2, int i2, String str3) {
        String str4;
        AppMethodBeat.i(26037);
        ebH();
        if (!Util.isNullOrNil(str)) {
            str4 = str;
        } else if (Util.isNullOrNil(str3)) {
            str4 = this.yzG.getString(R.string.e63);
        } else {
            str4 = str3;
        }
        if (2 != i2 || str2 == null) {
            if (1 == i2 && str2 != null) {
                h.a((Context) this.yzG, str2, str4, this.yzG.getString(R.string.e64), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(26028);
                        j.this.yzG.finish();
                        AppMethodBeat.o(26028);
                    }
                });
            }
            AppMethodBeat.o(26037);
            return;
        }
        this.gCd.setText(str2);
        AppMethodBeat.o(26037);
    }

    private void eby() {
        AppMethodBeat.i(26038);
        if (Util.isNullOrNil(this.mCountryCode) || com.tencent.mm.plugin.ipcall.a.a.aCy(this.yvn)) {
            this.yzF = this.yvn;
        } else {
            this.yzF = this.mCountryCode + this.yvn;
            if (!this.yzF.startsWith("+")) {
                this.yzF = "+" + this.yzF;
                AppMethodBeat.o(26038);
                return;
            }
        }
        AppMethodBeat.o(26038);
    }

    private void ebz() {
        AppMethodBeat.i(26039);
        i.eav().gte = this.yzG;
        i.eav().eaK();
        i.eav().a((a.b) this);
        i.eav().a(this);
        AppMethodBeat.o(26039);
    }

    private void initUI() {
        AppMethodBeat.i(26040);
        this.yzu.setKeyListener(null);
        this.yzu.setHorizontallyScrolling(true);
        this.ysX.setVisibility(4);
        this.ysX.setTalkUIMode(true);
        ebA();
        ebB();
        AppMethodBeat.o(26040);
    }

    /* access modifiers changed from: package-private */
    public final void aCr(String str) {
        AppMethodBeat.i(26041);
        if (!Util.isNullOrNil(this.krY)) {
            io(this.krY, com.tencent.mm.plugin.ipcall.a.a.aCA(str));
            AppMethodBeat.o(26041);
            return;
        }
        io(com.tencent.mm.plugin.ipcall.a.a.aCA(str), "");
        AppMethodBeat.o(26041);
    }

    private void ebA() {
        AppMethodBeat.i(26042);
        if (!Util.isNullOrNil(this.yzF)) {
            aCr(this.yzF);
        }
        if (d.oD(16)) {
            this.yzu.setTypeface(Typeface.create("sans-serif-light", 0));
            this.yzv.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!Util.isNullOrNil(this.yvo)) {
            this.yzl = com.tencent.mm.plugin.ipcall.a.a.g(this.yzG, this.yvo, true);
        }
        if (this.yzl == null && !Util.isNullOrNil(this.yvn) && com.tencent.mm.plugin.ipcall.a.a.boc()) {
            this.yzl = com.tencent.mm.plugin.ipcall.a.a.be(this.yzG, this.yvn);
        }
        if (this.yzl == null && !Util.isNullOrNil(this.yvp)) {
            this.yzl = com.tencent.mm.aj.c.e(this.yvp, 480, 480, 4);
        }
        if (this.yzl == null) {
            this.yzw.setVisibility(0);
            this.gyr.setVisibility(8);
        }
        if (this.yzl != null) {
            this.yzw.setVisibility(8);
            this.gyr.setVisibility(0);
            this.gyr.setImageBitmap(this.yzl);
        }
        this.yzD.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(26029);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i.eax().dZS();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26029);
            }
        });
        this.yzz.setClickCallback(new IPCallFuncButton.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a
            public final void qA(boolean z) {
                AppMethodBeat.i(26030);
                Log.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", Boolean.valueOf(z));
                if (i.eaw().eam()) {
                    j.this.yzL = z;
                    j.this.yzM = z;
                    i.eav().qw(z);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12057, 0, 1, 0, 0);
                    AppMethodBeat.o(26030);
                    return;
                }
                if (!i.eaC().YZ() && !i.eaw().eao()) {
                    i.eaC().xw(z);
                }
                AppMethodBeat.o(26030);
            }
        });
        this.yzx.setClickCallback(new IPCallFuncButton.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a
            public final void qA(boolean z) {
                int appCmd;
                AppMethodBeat.i(26031);
                if (i.eaw().ean()) {
                    Log.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", Boolean.valueOf(z));
                    com.tencent.mm.plugin.ipcall.model.d.a eat = i.eat();
                    if (z) {
                        appCmd = eat.yqF.setAppCmd(412);
                    } else {
                        appCmd = eat.yqF.setAppCmd(413);
                    }
                    if (appCmd < 0) {
                        Log.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
                    }
                    i.eav().yqo.ypB.setMute(z);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12057, 1, 0, 0, 0);
                }
                AppMethodBeat.o(26031);
            }
        });
        this.yzy.setClickCallback(new IPCallFuncButton.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass11 */

            @Override // com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a
            public final void qA(boolean z) {
                AppMethodBeat.i(26032);
                if (z) {
                    j jVar = j.this;
                    if (jVar.yzl == null) {
                        jVar.gyr.setVisibility(8);
                    } else {
                        jVar.gyr.setVisibility(4);
                    }
                    jVar.gyr.setVisibility(8);
                    jVar.yzw.setVisibility(8);
                    jVar.yzu.setText("");
                    jVar.yzv.setText("");
                    jVar.ysX.setVisibility(0);
                } else {
                    j jVar2 = j.this;
                    if (jVar2.yzl != null) {
                        jVar2.gyr.setVisibility(0);
                        jVar2.yzw.setVisibility(8);
                    } else {
                        jVar2.yzw.setVisibility(0);
                        jVar2.gyr.setVisibility(8);
                    }
                    jVar2.aCr(jVar2.yzF);
                    jVar2.ysX.setVisibility(4);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12057, 0, 0, 1, 0);
                AppMethodBeat.o(26032);
            }
        });
        this.yzA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(26033);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                j.b(j.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/TalkUIController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26033);
            }
        });
        AppMethodBeat.o(26042);
    }

    private void ebB() {
        AppMethodBeat.i(26043);
        this.ysX.setDialButtonClickListener(new DialPad.a() {
            /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ipcall.ui.DialPad.a
            public final void aCc(String str) {
                AppMethodBeat.i(26023);
                String obj = j.this.yzu.getText().toString();
                if (Util.isNullOrNil(obj)) {
                    j.this.yzK = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j.this.yzK >= 3000) {
                    obj = obj + " ";
                }
                j.this.yzK = currentTimeMillis;
                j.this.io(obj + str, "");
                c.aBQ(str);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12057, 0, 0, 0, 1);
                AppMethodBeat.o(26023);
            }

            @Override // com.tencent.mm.plugin.ipcall.ui.DialPad.a
            public final void aCd(String str) {
            }
        });
        AppMethodBeat.o(26043);
    }

    /* access modifiers changed from: package-private */
    public final void io(String str, String str2) {
        AppMethodBeat.i(26044);
        this.yzu.setText(str);
        if (!Util.isNullOrNil(str)) {
            this.yzu.setSelection(this.yzu.getText().length() - 1);
        }
        this.yzv.setText(str2);
        AppMethodBeat.o(26044);
    }

    private void ebC() {
        AppMethodBeat.i(26045);
        this.yzE = com.tencent.mm.plugin.ipcall.a.a.ip(this.yvo, this.yvn);
        Pp(1);
        this.yzH.a(this.krY, this.yvn, this.yvp, this.yzF, this.yvo, this.yzE, this.yvq, this.yvr);
        Log.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", this.yzF);
        i.eau().setCountryCode(this.mCountryCode);
        AppMethodBeat.o(26045);
    }

    private void ebD() {
        AppMethodBeat.i(26046);
        if (i.eas().yoW != null) {
            this.krY = i.eas().yoW.nickname;
            this.yzF = i.eas().yoW.yqi;
            this.yvp = i.eas().yoW.dkV;
            this.yvo = i.eas().yoW.edf;
            this.yvn = i.eas().yoW.yqh;
            this.yzE = i.eas().yoW.phoneType;
            Log.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", this.krY, this.yzF, this.yvp, this.yvo, this.yvn, Integer.valueOf(this.yzE));
        }
        AppMethodBeat.o(26046);
    }

    private void ebE() {
        AppMethodBeat.i(26047);
        i.eaw();
        Log.i("MicroMsg.TalkUIController", f.stateToString(i.eaw().mAT));
        Pp(i.eaw().mAT);
        ebG();
        ebF();
        AppMethodBeat.o(26047);
    }

    private void ebF() {
        AppMethodBeat.i(26048);
        if (i.eaw().eam()) {
            this.yzz.setChecked(i.eav().yqo.isSpeakerphoneOn());
            this.yzx.setChecked(i.eav().yqo.ypB.guh);
        }
        AppMethodBeat.o(26048);
    }

    private void ebG() {
        AppMethodBeat.i(26049);
        String str = i.eas().yoW.yqi;
        String str2 = i.eas().yoW.yqj;
        if (!Util.isNullOrNil(str2)) {
            aCr(str2);
            this.yzv.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(str2));
            AppMethodBeat.o(26049);
            return;
        }
        if (!Util.isNullOrNil(str)) {
            aCr(str);
            this.yzv.setText(com.tencent.mm.plugin.ipcall.a.a.aCA(str));
        }
        AppMethodBeat.o(26049);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void Pp(int i2) {
        AppMethodBeat.i(26050);
        switch (i2) {
            case 1:
                AppMethodBeat.o(26050);
                return;
            case 3:
                String Ps = com.tencent.mm.plugin.ipcall.a.c.Ps(i.eas().yoW.ypW);
                if (this.yzE != -1) {
                    String Pq = com.tencent.mm.plugin.ipcall.a.a.Pq(this.yzE);
                    this.gCd.setText(Ps + this.yzG.getString(R.string.e7u, new Object[]{Pq}));
                    AppMethodBeat.o(26050);
                    return;
                }
                this.gCd.setText(Ps + this.yzG.getString(R.string.e7t));
                AppMethodBeat.o(26050);
                return;
            case 4:
                AppMethodBeat.o(26050);
                return;
            case 5:
                this.gCd.setText(String.format("%02d:%02d", Long.valueOf(this.yzJ / 60), Long.valueOf(this.yzJ % 60)));
                AppMethodBeat.o(26050);
                return;
            case 10:
                this.gCd.setText(R.string.e7x);
                break;
        }
        AppMethodBeat.o(26050);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void dZI() {
        boolean z = false;
        AppMethodBeat.i(26051);
        Log.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.eas().yoW.yqi;
        String str2 = i.eas().yoW.yqj;
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2) && !str.equals(str2)) {
            Log.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", str, str2);
            aCr(str2);
        }
        Log.i("MicroMsg.TalkUIController", "callFlag:" + i.eas().yoW.ypW);
        int i2 = i.eas().yoW.ypW;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            z = true;
        }
        if (z) {
            Log.i("MicroMsg.TalkUIController", "isNotFree");
            h.a((Context) this.yzG, (int) R.string.e89, (int) R.string.e8_, (int) R.string.e88, (int) R.string.e87, true, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26024);
                    Log.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
                    j.b(j.this);
                    AppMethodBeat.o(26024);
                }
            });
        }
        Pp(3);
        AppMethodBeat.o(26051);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void dZJ() {
        AppMethodBeat.i(26052);
        Log.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.eaw().eam()) {
            this.yzL = this.yzz.isChecked();
            this.yzM = this.yzz.isChecked();
            i.eav().qw(this.yzz.isChecked());
        }
        AppMethodBeat.o(26052);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void dZX() {
        AppMethodBeat.i(26053);
        Log.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.eaw().eam()) {
            this.yzL = this.yzz.isChecked();
            this.yzM = this.yzz.isChecked();
            i.eav().qw(this.yzz.isChecked());
        }
        if (i.eaw().ean()) {
            i.eav().yqo.ypB.setMute(this.yzx.isChecked());
        }
        AppMethodBeat.o(26053);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void dZY() {
        AppMethodBeat.i(26054);
        Log.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        ebH();
        Pp(10);
        bg.getNotification().cancel(42);
        if (this.yzI != null) {
            this.yzI.qC(true);
        }
        AppMethodBeat.o(26054);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void g(int i2, String str, String str2, int i3) {
        String str3;
        AppMethodBeat.i(26055);
        Log.d("MicroMsg.TalkUIController", "onError, error: %d", Integer.valueOf(i2));
        if (i3 == 1) {
            this.yzP = false;
        }
        if (i2 != 8) {
            f(str, str2, i3, null);
        } else if (i3 == 1) {
            if (Util.isNullOrNil(str)) {
                str3 = this.yzG.getString(R.string.e63);
            } else {
                str3 = str;
            }
            h.a((Context) this.yzG, str2, str3, this.yzG.getString(R.string.e64), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.ipcall.ui.j.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(26025);
                    j.this.yzG.finish();
                    AppMethodBeat.o(26025);
                }
            });
        } else {
            f(str, str2, i3, this.yzG.getString(R.string.e62));
        }
        bg.getNotification().cancel(42);
        if (this.yzI != null && !this.yzQ) {
            this.yzI.qC(this.yzP);
        }
        AppMethodBeat.o(26055);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.a.a.b
    public final void qu(boolean z) {
        AppMethodBeat.i(26056);
        Log.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (i.eaw().eam()) {
            if (z) {
                this.yzL = i.eav().yqo.isSpeakerphoneOn();
                i.eav().qw(false);
                this.yzz.setEnable(false);
                AppMethodBeat.o(26056);
                return;
            }
            i.eav().qw(this.yzL);
            this.yzz.setEnable(true);
            this.yzz.setChecked(this.yzL);
        }
        AppMethodBeat.o(26056);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.a.a.b
    public final void qv(boolean z) {
        AppMethodBeat.i(26057);
        Log.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (i.eaw().eam()) {
            if (z) {
                this.yzM = i.eav().yqo.isSpeakerphoneOn();
                i.eav().qw(false);
                this.yzz.setEnable(false);
                AppMethodBeat.o(26057);
                return;
            }
            i.eav().qw(this.yzM);
            this.yzz.setEnable(true);
            this.yzz.setChecked(this.yzM);
        }
        AppMethodBeat.o(26057);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void eaa() {
        AppMethodBeat.i(26058);
        this.yzJ = (long) i.eax().dZU();
        Pp(5);
        AppMethodBeat.o(26058);
    }

    @Override // com.tencent.mm.plugin.ipcall.e
    public final void dZZ() {
        AppMethodBeat.i(26059);
        this.yzG.finish();
        AppMethodBeat.o(26059);
    }

    public final void ebH() {
        AppMethodBeat.i(26060);
        if (this.yzB != null) {
            this.yzB.setVisibility(4);
        }
        if (this.yzC != null) {
            this.yzC.setVisibility(4);
        }
        AppMethodBeat.o(26060);
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(26061);
        jVar.yzH.gP(0, 0);
        bg.getNotification().cancel(42);
        jVar.yzG.finish();
        AppMethodBeat.o(26061);
    }
}
