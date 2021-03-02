package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.l;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements g.a, n, MMActivity.a {
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    boolean dLD = false;
    private View jBN;
    View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.e.AnonymousClass4 */

        /* JADX WARNING: Removed duplicated region for block: B:55:0x01b1  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0205  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0281  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x02c8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r12) {
            /*
            // Method dump skipped, instructions count: 3090
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.e.AnonymousClass4.onClick(android.view.View):void");
        }
    };
    ListView mListView;
    com.tencent.mm.plugin.card.base.b pQV;
    MMActivity pQZ;
    List<com.tencent.mm.plugin.card.model.b> pRa = new ArrayList();
    ArrayList<us> pRc;
    public int pXh = 0;
    String pXi = "";
    String pXj = "";
    public ArrayList<String> pXk = new ArrayList<>();
    public ArrayList<String> pXl = new ArrayList<>();
    m pZA;
    i pZB;
    i pZC;
    i pZD;
    i pZE;
    i pZF;
    i pZG;
    i pZH;
    i pZI;
    com.tencent.mm.plugin.card.ui.view.d pZJ;
    i pZK;
    j pZL;
    boolean pZM = true;
    f pZN;
    public String pZO = "";
    public String pZP = "";
    HashMap<Integer, String> pZQ = new HashMap<>();
    HashMap<String, String> pZR = new HashMap<>();
    ArrayList<String> pZS = new ArrayList<>();
    d pZT;
    a pZU;
    private MMHandler pZV = new MMHandler() {
        /* class com.tencent.mm.plugin.card.ui.e.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(113264);
            if (message.obj != null && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.qag == b.onGetCodeFail) {
                    if (e.this.pZz != null) {
                        com.tencent.mm.plugin.card.d.d.a(e.this.pQZ, cVar.errMsg, false);
                        e.this.pZz.cxz();
                        AppMethodBeat.o(113264);
                        return;
                    }
                } else if (cVar.qag == b.onShowTimeExpired) {
                    if (e.this.pZz != null) {
                        e.this.pZz.d(com.tencent.mm.plugin.card.d.c.CARDCODEREFRESHACTION_SHOWING_TIMEOUT);
                        AppMethodBeat.o(113264);
                        return;
                    }
                } else if (e.this.pZz != null) {
                    e.this.pZz.d(cVar.qah);
                }
            }
            AppMethodBeat.o(113264);
        }
    };
    IListener pZW = new IListener<cm>() {
        /* class com.tencent.mm.plugin.card.ui.e.AnonymousClass7 */

        {
            AppMethodBeat.i(161198);
            this.__eventId = cm.class.getName().hashCode();
            AppMethodBeat.o(161198);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cm cmVar) {
            AppMethodBeat.i(113271);
            cm cmVar2 = cmVar;
            if (com.tencent.mm.kernel.g.aAc()) {
                Log.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (cmVar2 instanceof cm) {
                    if (cmVar2.dFH.resultCode == 0) {
                        com.tencent.mm.plugin.card.d.d.c(e.this.pQZ, e.this.pQZ.getResources().getString(R.string.aty));
                    }
                    AppMethodBeat.o(113271);
                    return true;
                }
            }
            AppMethodBeat.o(113271);
            return false;
        }
    };
    com.tencent.mm.plugin.card.ui.a.g pZs;
    i pZt;
    boolean pZu = false;
    i pZv;
    i pZw;
    com.tencent.mm.plugin.card.widget.g pZx;
    LinearLayout pZy;
    com.tencent.mm.plugin.card.ui.view.g pZz;

    public static class a {
        public int gwE = 3;
        public String pQH = "";
        public boolean pSh = false;
        public int pWG = -1;
        public String pYJ = "";
        public String pYK = "";
        public String pZc = "";
        public String pZd = "";
        public String pZe = "";
        public int qaa = 0;
    }

    public interface d {
        void ajF(String str);

        void b(com.tencent.mm.plugin.card.base.b bVar);

        void cvj();

        void cvk();

        void cvl();

        void cvm();

        void cvn();

        void cvo();

        void cvp();

        void kx(boolean z);
    }

    public e(MMActivity mMActivity, View view) {
        AppMethodBeat.i(113275);
        this.pQZ = mMActivity;
        this.jBN = view;
        AppMethodBeat.o(113275);
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, a aVar, ArrayList<us> arrayList) {
        this.pQV = bVar;
        this.pZU = aVar;
        this.pRc = arrayList;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final View findViewById(int i2) {
        AppMethodBeat.i(113276);
        View findViewById = this.jBN.findViewById(i2);
        AppMethodBeat.o(113276);
        return findViewById;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final com.tencent.mm.plugin.card.base.b cvq() {
        return this.pQV;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final void b(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113277);
        if (bVar != null) {
            this.pQV = bVar;
            if (this.pZT != null) {
                this.pZT.b(bVar);
            }
            cuE();
        }
        AppMethodBeat.o(113277);
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final boolean cvr() {
        return this.pZu;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final void cvs() {
        this.pZu = false;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final MMActivity cvt() {
        return this.pQZ;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final View.OnClickListener cvu() {
        return this.kuO;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final com.tencent.mm.plugin.card.ui.a.g cvv() {
        return this.pZs;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final d cvw() {
        return this.pZT;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final a cvx() {
        return this.pZU;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final f cvy() {
        return this.pZN;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final j cvz() {
        return this.pZL;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final String getString(int i2) {
        AppMethodBeat.i(113278);
        String string = this.pQZ.getString(i2);
        AppMethodBeat.o(113278);
        return string;
    }

    @Override // com.tencent.mm.plugin.card.ui.n
    public final void cuE() {
        AppMethodBeat.i(113280);
        if (this.pQV == null) {
            Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.pZT != null) {
                this.pZT.cvn();
            }
            AppMethodBeat.o(113280);
        } else if (this.pQV.csQ() == null) {
            Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.pZT != null) {
                this.pZT.cvn();
            }
            AppMethodBeat.o(113280);
        } else if (this.pQV.csR() == null) {
            Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.pZT != null) {
                this.pZT.cvn();
            }
            AppMethodBeat.o(113280);
        } else if (!this.pQV.csC()) {
            Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", Integer.valueOf(this.pQV.csQ().nHh));
            if (!TextUtils.isEmpty(this.pQV.csQ().LeG)) {
                com.tencent.mm.plugin.card.d.b.a(this.pQZ, this.pQV.csQ().LeG, 0);
                if (this.pZT != null) {
                    this.pZT.cvn();
                    AppMethodBeat.o(113280);
                    return;
                }
            } else {
                h.a((Context) this.pQZ, getString(R.string.arp), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.card.ui.e.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(113263);
                        dialogInterface.dismiss();
                        if (e.this.pZT != null) {
                            e.this.pZT.cvn();
                        }
                        AppMethodBeat.o(113263);
                    }
                });
            }
            AppMethodBeat.o(113280);
        } else {
            Log.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            Log.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.pQV.csQ().Lfb);
            this.pZN.a(this.pQV, this.pRc, this.pZU.gwE);
            cvA();
            this.pZs.cwW();
            Log.i("MicroMsg.CardDetailUIContoller", "");
            updateTitle();
            cvE();
            if (this.pZs.cwF()) {
                Log.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.pZt.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.pZt.cxw();
            }
            if (this.pZs.cww()) {
                if (this.pZK == null) {
                    this.pZK = new com.tencent.mm.plugin.card.ui.view.b();
                    this.pZK.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.pZK.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.pZK != null) {
                    this.pZK.cxw();
                }
            }
            this.pQZ.showOptionMenu(this.pZs.cwA());
            if (this.pZs.cwB()) {
                cvK();
            }
            if (this.pZs.cwC()) {
                cvL();
            }
            if (this.pZs.cwD()) {
                cvM();
            }
            cvI();
            H(this.pZs.cwy(), this.pZs.cwz());
            if (!this.pQV.csx() && this.pZs.cwH()) {
                Log.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.pZv.update();
            } else if (this.pQV.csx() && this.pZs.cwH()) {
                Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.pZw.update();
            } else if (this.pZs.cwI()) {
                Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.pZw.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.pZw.cxw();
                this.pZv.cxw();
            }
            if (this.pZx != null) {
                this.pZx.kE(this.pZs.cvO());
            }
            cvC();
            if (this.pZs.cwM()) {
                if (this.pZC == null) {
                    this.pZC = new y();
                    this.pZC.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.pZC.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.pZC != null) {
                    this.pZC.cxw();
                }
            }
            if (this.pZs.cwV()) {
                if (this.pZB == null) {
                    this.pZB = new com.tencent.mm.plugin.card.ui.view.c();
                    this.pZB.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.pZB.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.pZB != null) {
                    this.pZB.cxw();
                }
            }
            if (this.pZs.cwN()) {
                if (this.pZD == null) {
                    this.pZD = new k();
                    this.pZD.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.pZD.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.pZD != null) {
                    this.pZD.cxw();
                }
            }
            if (this.pZs.cwO()) {
                if (this.pZE == null) {
                    this.pZE = new w();
                    this.pZE.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.pZE.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.pZE != null) {
                    this.pZE.cxw();
                }
            }
            if (this.pZs.cwP()) {
                if (this.pZF == null) {
                    this.pZF = new l();
                    this.pZF.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.pZF.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.pZF != null) {
                    this.pZF.cxw();
                }
            }
            if (this.pZs.cwQ()) {
                if (this.pZG == null) {
                    this.pZG = new z();
                    this.pZG.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.pZG.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.pZG != null) {
                    this.pZG.cxw();
                }
            }
            if (this.pZs.cwS()) {
                if (this.pZH == null) {
                    this.pZH = new com.tencent.mm.plugin.card.ui.view.e();
                    this.pZH.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.pZH.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.pZH != null) {
                    this.pZH.cxw();
                }
            }
            if (this.pZs.cwR()) {
                if (this.pZI == null) {
                    this.pZI = new u();
                    this.pZI.a(this);
                }
                Log.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.pZI.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.pZI != null) {
                    this.pZI.cxw();
                }
            }
            cvD();
            if (this.pZs.cwK()) {
                cvJ();
                if (this.pZs.cwL()) {
                    if (this.pZz == null) {
                        cvB();
                        this.pZz.a(this);
                        this.pZz.update();
                    } else if (this.pZz.f(this.pQV)) {
                        this.pZz.b(this.pQV);
                        this.pZz.update();
                    }
                } else if (this.pZz != null) {
                    this.pZz.cxA();
                }
                if (this.pZx != null) {
                    this.pZx.kD(true);
                }
            } else {
                Log.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.pZz != null) {
                    this.pZz.cxA();
                }
                if (this.pZx != null) {
                    this.pZx.kD(false);
                }
            }
            if (this.pZs.cwT()) {
                Log.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.pZJ.update();
            } else {
                Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.pZJ.cxw();
            }
            this.pZL.pQV = this.pQV;
            AppMethodBeat.o(113280);
        }
    }

    public enum b {
        onGetCodeSuccess,
        onShowTimeExpired,
        onReceiveCodeUnavailable,
        onGetCodeFail;

        public static b valueOf(String str) {
            AppMethodBeat.i(113273);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(113273);
            return bVar;
        }

        static {
            AppMethodBeat.i(113274);
            AppMethodBeat.o(113274);
        }
    }

    static class c {
        int errCode;
        String errMsg;
        b qag;
        com.tencent.mm.plugin.card.d.c qah;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.card.b.g.a
    public final void c(com.tencent.mm.plugin.card.d.c cVar) {
        AppMethodBeat.i(113281);
        Log.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.qag = b.onGetCodeSuccess;
        cVar2.qah = cVar;
        obtain.obj = cVar2;
        this.pZV.sendMessage(obtain);
        AppMethodBeat.o(113281);
    }

    @Override // com.tencent.mm.plugin.card.b.g.a
    public final void aM(int i2, String str) {
        String string;
        AppMethodBeat.i(113282);
        Log.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", Integer.valueOf(i2), str);
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.qag = b.onGetCodeFail;
        cVar.errCode = i2;
        if (i2 == -1) {
            string = getString(R.string.aor);
        } else if (i2 == 2) {
            string = getString(R.string.anx);
        } else {
            string = getString(R.string.aoq);
        }
        cVar.errMsg = string;
        obtain.obj = cVar;
        this.pZV.sendMessage(obtain);
        AppMethodBeat.o(113282);
    }

    @Override // com.tencent.mm.plugin.card.b.g.a
    public final void ctv() {
        AppMethodBeat.i(113283);
        Log.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.qag = b.onShowTimeExpired;
        obtain.obj = cVar;
        this.pZV.sendMessage(obtain);
        AppMethodBeat.o(113283);
    }

    @Override // com.tencent.mm.plugin.card.b.g.a
    public final void b(com.tencent.mm.plugin.card.d.c cVar) {
        AppMethodBeat.i(113284);
        Log.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.qag = b.onReceiveCodeUnavailable;
        cVar2.qah = cVar;
        obtain.obj = cVar2;
        this.pZV.sendMessage(obtain);
        AppMethodBeat.o(113284);
    }

    private void cvB() {
        AppMethodBeat.i(113285);
        if (this.pQV.csQ().Lff != null && this.pQV.csQ().Lff.LrL) {
            this.pZz = new m();
            am.cug().a(this);
            AppMethodBeat.o(113285);
        } else if (this.pQV.csQ().nHh == 10) {
            this.pZz = new q();
            AppMethodBeat.o(113285);
        } else {
            this.pZz = new j();
            AppMethodBeat.o(113285);
        }
    }

    private void cvC() {
        AppMethodBeat.i(113286);
        if (this.dLD) {
            Log.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            AppMethodBeat.o(113286);
            return;
        }
        if (!this.pQV.csv() || !this.pQV.csx()) {
            int ake = com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw);
            this.jBN.findViewById(R.id.am3).setBackgroundColor(ake);
            this.pQZ.setActionbarColor(ake);
        } else {
            this.jBN.findViewById(R.id.am3).setBackgroundColor(this.pQZ.getResources().getColor(R.color.afz));
            this.pQZ.setActionbarColor(this.pQZ.getResources().getColor(R.color.afz));
        }
        View findViewById = this.jBN.findViewById(R.id.bo7);
        View findViewById2 = this.jBN.findViewById(R.id.dp1);
        View findViewById3 = this.jBN.findViewById(R.id.bo2);
        if (!this.pQV.csv() || !this.pZs.cwH()) {
            if (this.pQV.csw()) {
                if (this.pZs.cwF() && this.pZu) {
                    findViewById.setBackgroundResource(R.drawable.c2m);
                    findViewById3.setBackgroundResource(0);
                } else if (!this.pZs.cwF() || this.pZu) {
                    findViewById.setBackgroundResource(0);
                    if (this.pZs.cvO()) {
                        findViewById3.setBackgroundResource(R.drawable.c2l);
                    } else {
                        findViewById3.setBackgroundResource(R.drawable.c2m);
                    }
                } else {
                    findViewById.setBackgroundResource(R.drawable.c2l);
                    findViewById3.setBackgroundResource(0);
                }
            } else if (this.pQV.csy()) {
                findViewById.setBackgroundResource(0);
                if (this.pZs.cvO()) {
                    findViewById3.setBackgroundResource(R.drawable.c2l);
                } else {
                    findViewById3.setBackgroundResource(R.drawable.c2m);
                }
            } else if (this.pQV.csz()) {
                findViewById.setBackgroundResource(R.drawable.m6);
                findViewById3.setBackgroundResource(0);
            } else {
                findViewById.setBackgroundResource(0);
                findViewById3.setBackgroundColor(this.pQZ.getResources().getColor(R.color.afz));
            }
        } else if (this.pQV.csy()) {
            findViewById.setBackgroundResource(R.drawable.c2m);
            this.jBN.findViewById(R.id.db2).setBackgroundResource(R.drawable.lb);
            findViewById3.setBackgroundResource(0);
        } else if (this.pQV.csx()) {
            this.jBN.findViewById(R.id.db2).setBackgroundResource(0);
            findViewById3.setBackgroundColor(this.pQZ.getResources().getColor(R.color.afz));
        } else if (this.pQV.csz()) {
            findViewById.setBackgroundResource(R.drawable.c2m);
            this.jBN.findViewById(R.id.db2).setBackgroundResource(R.drawable.lb);
            findViewById3.setBackgroundResource(0);
        } else if (!this.pQV.csA() && this.pQV.csB()) {
            findViewById3.setBackgroundColor(this.pQZ.getResources().getColor(R.color.afz));
        }
        if (this.pQV.csB()) {
            TextView textView = (TextView) this.jBN.findViewById(R.id.abm);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapUtil.getBitmapNative((int) R.drawable.c2k));
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            textView.setBackgroundDrawable(bitmapDrawable);
            textView.setVisibility(0);
        }
        Rect rect = new Rect(0, 0, 0, 0);
        findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById.invalidate();
        findViewById3.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        findViewById3.invalidate();
        if (this.pQV.csw() && this.pZs.cwF() && this.pZu) {
            View findViewById4 = this.jBN.findViewById(R.id.hq5);
            findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById4.invalidate();
        }
        if (this.pQV.csv() && this.pZs.cwH()) {
            View findViewById5 = this.jBN.findViewById(R.id.db2);
            rect.left = this.pQZ.getResources().getDimensionPixelOffset(R.dimen.hs);
            rect.right = this.pQZ.getResources().getDimensionPixelOffset(R.dimen.hs);
            findViewById5.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            findViewById5.invalidate();
            if (this.pQV.csz()) {
                View findViewById6 = this.jBN.findViewById(R.id.db3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById6.getLayoutParams();
                int dimensionPixelSize = this.pQZ.getResources().getDimensionPixelSize(R.dimen.k5);
                layoutParams.rightMargin = dimensionPixelSize;
                layoutParams.leftMargin = dimensionPixelSize;
                findViewById6.setLayoutParams(layoutParams);
            }
        }
        if (this.pZs.cwH() || this.pZs.cwF()) {
            if (this.pZx != null && ((this.pQV.csv() && this.pQV.csy()) || this.pQV.csw())) {
                this.pZx.EK(0);
            }
        } else if (this.pZx != null && ((this.pQV.csv() && this.pQV.csy()) || this.pQV.csw())) {
            if (this.pZs.cvO()) {
                this.pZx.EK(R.drawable.c2n);
            } else {
                this.pZx.EK(R.drawable.m3);
            }
        }
        if (this.pZx != null && this.pQV.csv() && this.pQV.csx()) {
            this.pZx.a(com.tencent.mm.plugin.card.d.l.fi(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw), this.pQZ.getResources().getDimensionPixelOffset(R.dimen.vm)));
        }
        if (this.pQV.csv() && this.pQV.csx()) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams2.bottomMargin = 0;
            layoutParams2.topMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.leftMargin = 0;
            if (!TextUtils.isEmpty(this.pQV.csQ().LeL)) {
                layoutParams2.weight = 0.0f;
                layoutParams2.height = -2;
            } else {
                layoutParams2.height = 0;
                layoutParams2.weight = 1.0f;
            }
            findViewById.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
            int dimensionPixelSize2 = this.pQZ.getResources().getDimensionPixelSize(R.dimen.ib);
            layoutParams3.rightMargin = dimensionPixelSize2;
            layoutParams3.leftMargin = dimensionPixelSize2;
            if (this.pQV.csx()) {
                layoutParams3.topMargin = this.pQZ.getResources().getDimensionPixelSize(R.dimen.i1);
                layoutParams3.bottomMargin = this.pQZ.getResources().getDimensionPixelSize(R.dimen.i2);
                int dimensionPixelSize3 = this.pQZ.getResources().getDimensionPixelSize(R.dimen.hv);
                layoutParams3.rightMargin = dimensionPixelSize3;
                layoutParams3.leftMargin = dimensionPixelSize3;
            } else {
                int dimensionPixelSize4 = this.pQZ.getResources().getDimensionPixelSize(R.dimen.r);
                layoutParams3.bottomMargin = dimensionPixelSize4;
                layoutParams3.topMargin = dimensionPixelSize4;
            }
            findViewById2.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
            layoutParams4.bottomMargin = 0;
            layoutParams4.topMargin = 0;
            layoutParams4.rightMargin = 0;
            layoutParams4.leftMargin = 0;
            if (this.pQV.csx()) {
                layoutParams4.bottomMargin = this.pQZ.getResources().getDimensionPixelSize(R.dimen.hv);
            }
            if (!TextUtils.isEmpty(this.pQV.csQ().LeL)) {
                layoutParams4.weight = 0.0f;
                layoutParams4.height = -2;
            } else {
                layoutParams4.height = 0;
                layoutParams4.weight = 1.0f;
            }
            findViewById3.setLayoutParams(layoutParams4);
            if (!TextUtils.isEmpty(this.pQV.csQ().LeL)) {
                View findViewById7 = findViewById(R.id.i5);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) findViewById7.getLayoutParams();
                layoutParams5.height = 0;
                layoutParams5.weight = 1.0f;
                findViewById7.setLayoutParams(layoutParams5);
            }
        }
        this.jBN.invalidate();
        AppMethodBeat.o(113286);
    }

    public final void a(boolean z, j.b bVar, boolean z2) {
        int i2 = 1;
        AppMethodBeat.i(113287);
        if (z) {
            abz abz = this.pQV.csR().Lcz;
            if (this.pQV.csJ()) {
                com.tencent.mm.plugin.card.d.b.a(this.pQZ, bVar.pRN, bVar.pRO, z2, this.pQV);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11941, 17, this.pQV.csU(), this.pQV.csV(), "", this.pQV.csR().Lcz.title);
                AppMethodBeat.o(113287);
            } else if (abz != null && !TextUtils.isEmpty(abz.Leo) && !TextUtils.isEmpty(abz.Lep)) {
                com.tencent.mm.plugin.card.d.b.a(this.pQV.csU(), abz, this.pZU.pWG, this.pZU.qaa);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = 6;
                objArr[1] = this.pQV.csU();
                objArr[2] = this.pQV.csV();
                objArr[3] = "";
                objArr[4] = abz.title != null ? abz.title : "";
                hVar.a(11941, objArr);
                AppMethodBeat.o(113287);
            } else if (abz == null || TextUtils.isEmpty(abz.url)) {
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr2 = new Object[9];
                objArr2[0] = "CardConsumedCodeUI";
                objArr2[1] = Integer.valueOf(this.pQV.csQ().nHh);
                objArr2[2] = this.pQV.csV();
                objArr2[3] = this.pQV.csU();
                objArr2[4] = 0;
                objArr2[5] = Integer.valueOf(this.pZU.pWG);
                objArr2[6] = this.pZU.pZc;
                if (!this.pQV.csO()) {
                    i2 = 0;
                }
                objArr2[7] = Integer.valueOf(i2);
                objArr2[8] = "";
                hVar2.a(11324, objArr2);
                ajG(bVar.pRK);
                AppMethodBeat.o(113287);
            } else {
                com.tencent.mm.plugin.card.d.b.a(this.pQZ, com.tencent.mm.plugin.card.d.l.Y(abz.url, abz.LfD), 1);
                com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr3 = new Object[5];
                objArr3[0] = 6;
                objArr3[1] = this.pQV.csU();
                objArr3[2] = this.pQV.csV();
                objArr3[3] = "";
                objArr3[4] = abz.title != null ? abz.title : "";
                hVar3.a(11941, objArr3);
                AppMethodBeat.o(113287);
            }
        } else {
            com.tencent.mm.plugin.report.service.h hVar4 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr4 = new Object[9];
            objArr4[0] = "CardConsumedCodeUI";
            objArr4[1] = Integer.valueOf(this.pQV.csQ().nHh);
            objArr4[2] = this.pQV.csV();
            objArr4[3] = this.pQV.csU();
            objArr4[4] = 0;
            objArr4[5] = Integer.valueOf(this.pZU.pWG);
            objArr4[6] = this.pZU.pZc;
            if (!this.pQV.csO()) {
                i2 = 0;
            }
            objArr4[7] = Integer.valueOf(i2);
            objArr4[8] = "";
            hVar4.a(11324, objArr4);
            ajG(bVar.pRK);
            AppMethodBeat.o(113287);
        }
    }

    private void H(boolean z, boolean z2) {
        AppMethodBeat.i(113288);
        if (this.pZx != null) {
            this.pZx.H(z, z2);
        }
        AppMethodBeat.o(113288);
    }

    private void updateTitle() {
        AppMethodBeat.i(113289);
        if (!this.pZs.cwE()) {
            this.pQZ.setMMTitle("");
            AppMethodBeat.o(113289);
            return;
        }
        this.pQZ.setMMTitle(this.pZN.getTitle());
        AppMethodBeat.o(113289);
    }

    private void cvD() {
        AppMethodBeat.i(113290);
        if (!this.pZs.cwJ()) {
            Log.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            AppMethodBeat.o(113290);
            return;
        }
        this.pRa.clear();
        this.pRa.addAll(this.pZN.ctr());
        this.pZA.setData(this.pRa);
        this.pZA.qeu = this.pQV.csB();
        this.pZA.notifyDataSetChanged();
        AppMethodBeat.o(113290);
    }

    private void cvE() {
        AppMethodBeat.i(113291);
        if (this.pQV == null) {
            Log.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            AppMethodBeat.o(113291);
            return;
        }
        if (cvF()) {
            cvH();
        }
        if (this.pZx == null) {
            cvG();
        }
        if (this.pZx != null) {
            if (this.pQV.csz()) {
                ((com.tencent.mm.plugin.card.widget.f) this.pZx).pRc = this.pRc;
            }
            this.pZx.d(this.pQV);
        }
        AppMethodBeat.o(113291);
    }

    private boolean cvF() {
        AppMethodBeat.i(113292);
        if (this.pZx == null) {
            AppMethodBeat.o(113292);
            return false;
        } else if (this.pQV.csx()) {
            if (this.pZx instanceof com.tencent.mm.plugin.card.widget.e) {
                AppMethodBeat.o(113292);
                return false;
            }
            AppMethodBeat.o(113292);
            return true;
        } else if (this.pQV.csA()) {
            if (this.pZx instanceof com.tencent.mm.plugin.card.widget.c) {
                AppMethodBeat.o(113292);
                return false;
            }
            AppMethodBeat.o(113292);
            return true;
        } else if (this.pQV.csy()) {
            if (this.pZx instanceof com.tencent.mm.plugin.card.widget.b) {
                AppMethodBeat.o(113292);
                return false;
            }
            AppMethodBeat.o(113292);
            return true;
        } else if (this.pQV.csz()) {
            if (this.pZx instanceof com.tencent.mm.plugin.card.widget.f) {
                AppMethodBeat.o(113292);
                return false;
            }
            AppMethodBeat.o(113292);
            return true;
        } else if (!this.pQV.csB()) {
            AppMethodBeat.o(113292);
            return false;
        } else if (this.pZx instanceof com.tencent.mm.plugin.card.widget.d) {
            AppMethodBeat.o(113292);
            return false;
        } else {
            AppMethodBeat.o(113292);
            return true;
        }
    }

    private void cvG() {
        AppMethodBeat.i(113293);
        if (this.pQV.csx()) {
            this.pZx = new com.tencent.mm.plugin.card.widget.e(this.pQZ);
        } else if (this.pQV.csA()) {
            this.pZx = new com.tencent.mm.plugin.card.widget.c(this.pQZ);
        } else if (this.pQV.csy()) {
            this.pZx = new com.tencent.mm.plugin.card.widget.b(this.pQZ);
        } else if (this.pQV.csz()) {
            this.pZx = new com.tencent.mm.plugin.card.widget.f(this.pQZ);
        } else if (this.pQV.csB()) {
            this.pZx = new com.tencent.mm.plugin.card.widget.d(this.pQZ);
        } else {
            this.pZx = new com.tencent.mm.plugin.card.widget.b(this.pQZ);
        }
        this.pZx.i(this.pQV);
        View jz = this.pZx.jz();
        if (jz != null) {
            n.a(jz, this.pZy);
        }
        this.pZy.invalidate();
        this.pZx.setOnClickListener(this.kuO);
        H(false, false);
        AppMethodBeat.o(113293);
    }

    private void cvH() {
        AppMethodBeat.i(113294);
        View jz = this.pZx.jz();
        if (jz != null) {
            this.pZy.removeView(jz);
        }
        this.pZy.removeAllViews();
        this.pZy.invalidate();
        this.pZx.release();
        this.pZx = null;
        AppMethodBeat.o(113294);
    }

    private void cvI() {
        AppMethodBeat.i(113295);
        if (this.pZx != null && (this.pZx instanceof com.tencent.mm.plugin.card.widget.b)) {
            ((com.tencent.mm.plugin.card.widget.b) this.pZx).cvI();
        }
        AppMethodBeat.o(113295);
    }

    private void cvJ() {
        AppMethodBeat.i(113296);
        this.pQV.a(this.pQV.csR());
        com.tencent.mm.plugin.card.d.l.h(this.pQV);
        AppMethodBeat.o(113296);
    }

    private void cvK() {
        int i2 = 0;
        AppMethodBeat.i(113297);
        this.pZQ.clear();
        this.pZS.clear();
        if (this.pQV.csE()) {
            this.pZS.add(getString(R.string.atx));
            this.pZQ.put(0, "menu_func_share_friend");
            this.pZS.add(getString(R.string.atw));
            this.pZQ.put(1, "menu_func_share_timeline");
            i2 = 2;
        }
        if (!TextUtils.isEmpty(this.pQV.csR().Lcv)) {
            this.pZS.add(getString(R.string.arg));
            this.pZQ.put(Integer.valueOf(i2), "menu_func_report");
            i2++;
        }
        Es(i2);
        if (this.pZS.size() > 0) {
            this.pQZ.showOptionMenu(true);
        }
        AppMethodBeat.o(113297);
    }

    private void cvL() {
        int i2 = 0;
        AppMethodBeat.i(113298);
        this.pZQ.clear();
        this.pZS.clear();
        if (this.pQV.csv() && this.pQV.csD()) {
            if (!Util.isNullOrNil(this.pQV.csQ().Lfl)) {
                this.pZS.add(this.pQV.csQ().Lfl);
            } else if (this.pQV.csB()) {
                this.pZS.add(getString(R.string.arf));
            } else {
                this.pZS.add(getString(R.string.are));
            }
            this.pZQ.put(0, "menu_func_gift");
            i2 = 1;
        }
        if (!TextUtils.isEmpty(this.pQV.csR().Lcv)) {
            this.pZS.add(getString(R.string.arg));
            this.pZQ.put(Integer.valueOf(i2), "menu_func_report");
            i2++;
        }
        if (this.pQV.csv()) {
            this.pZS.add(getString(R.string.tf));
            this.pZQ.put(Integer.valueOf(i2), "menu_func_delete");
            i2++;
        } else if (this.pQV.csw()) {
            String aTY = com.tencent.mm.model.z.aTY();
            String csW = this.pQV.csW();
            if (aTY == null || !aTY.equals(csW)) {
                Log.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
            } else {
                this.pZS.add(getString(R.string.tf));
                this.pZQ.put(Integer.valueOf(i2), "menu_func_delete_share_card");
                i2++;
            }
        }
        Es(i2);
        if (this.pZS.size() > 0) {
            this.pQZ.showOptionMenu(true);
        }
        AppMethodBeat.o(113298);
    }

    private void cvM() {
        int i2 = 0;
        AppMethodBeat.i(113299);
        this.pZQ.clear();
        this.pZS.clear();
        if (!TextUtils.isEmpty(this.pQV.csR().Lcv)) {
            this.pZS.add(getString(R.string.arg));
            this.pZQ.put(0, "menu_func_report");
            i2 = 1;
        }
        Es(i2);
        if (this.pZS.size() > 0) {
            this.pQZ.showOptionMenu(true);
        }
        AppMethodBeat.o(113299);
    }

    private void Es(int i2) {
        AppMethodBeat.i(113300);
        LinkedList<bg> linkedList = this.pQV.csR().Lcx;
        if (linkedList == null) {
            AppMethodBeat.o(113300);
            return;
        }
        this.pZR.clear();
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            bg bgVar = linkedList.get(i3);
            if (!Util.isNullOrNil(bgVar.text) && !Util.isNullOrNil(bgVar.url)) {
                this.pZS.add(bgVar.text);
                this.pZQ.put(Integer.valueOf(i2), bgVar.text);
                this.pZR.put(bgVar.text, bgVar.url);
                i2++;
            }
        }
        AppMethodBeat.o(113300);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(final int i2, int i3, Intent intent) {
        AppMethodBeat.i(113301);
        switch (i2) {
            case 0:
            case 1:
            case 4:
                if (i3 == -1 && intent != null) {
                    this.pZO = intent.getStringExtra("Select_Conv_User");
                    final String str = this.pZO;
                    if (this.pQV == null || this.pQV.csQ() == null) {
                        Log.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        AppMethodBeat.o(113301);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (i2 == 0) {
                        if (TextUtils.isEmpty(this.pQV.csS().MXq) || this.pQV.csB()) {
                            sb.append(getString(R.string.h9u));
                        } else {
                            sb.append(this.pQV.csS().MXq);
                        }
                    } else if (i2 == 1) {
                        sb.append(getString(R.string.asz) + this.pZN.getTitle());
                    } else if (i2 == 4) {
                        sb.append(getString(R.string.arx) + this.pZN.getTitle());
                    }
                    ab.a.Kgn.a(this.pQZ.getController(), sb.toString(), this.pQV.csQ().iwv, this.pQV.csQ().title + "\n" + this.pQV.csQ().gTG, true, this.pQZ.getResources().getString(R.string.yq), new y.a() {
                        /* class com.tencent.mm.plugin.card.ui.e.AnonymousClass6 */

                        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                        public final void a(boolean z, String str, int i2) {
                            AppMethodBeat.i(113270);
                            if (z) {
                                e.this.pZP = str;
                                if (i2 == 0) {
                                    if (e.this.pZT != null) {
                                        e.this.pZT.ajF(str);
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11582, "OperGift", 1, Integer.valueOf(e.this.pQV.csQ().nHh), e.this.pQV.csV(), e.this.pQV.csU(), e.this.pZO);
                                    h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(R.string.apl));
                                    AppMethodBeat.o(113270);
                                    return;
                                } else if (i2 == 1) {
                                    e eVar = e.this;
                                    eVar.pQV.csS().MXq = eVar.getString(R.string.asz) + eVar.pZN.getTitle();
                                    com.tencent.mm.plugin.card.d.l.a(eVar.pQV, eVar.pZO, eVar.pZU.pZe, 2);
                                    com.tencent.mm.plugin.card.d.l.fB(eVar.pZP, eVar.pZO);
                                    h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(R.string.apl));
                                    AppMethodBeat.o(113270);
                                    return;
                                } else if (i2 == 4) {
                                    e eVar2 = e.this;
                                    if (TextUtils.isEmpty(eVar2.pQV.csW())) {
                                        eVar2.pQV.aiY(com.tencent.mm.model.z.aTY());
                                    }
                                    eVar2.pQV.csS().MXq = eVar2.getString(R.string.arx) + eVar2.pZN.getTitle();
                                    com.tencent.mm.plugin.card.d.l.a(eVar2.pQV, eVar2.pZO, eVar2.pZU.pZe, 23);
                                    com.tencent.mm.plugin.card.d.l.fB(eVar2.pZP, eVar2.pZO);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11582, "OpeRecommendCard", Integer.valueOf(e.this.pZU.gwE), Integer.valueOf(e.this.pQV.csQ().nHh), e.this.pQV.csV(), e.this.pQV.csU(), e.this.pZO);
                                    h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(R.string.apl));
                                }
                            }
                            AppMethodBeat.o(113270);
                        }
                    });
                    AppMethodBeat.o(113301);
                    return;
                }
                break;
            case 2:
                if (i3 != -1) {
                    AppMethodBeat.o(113301);
                    return;
                }
                this.pXh = intent.getIntExtra("Ktag_range_index", 0);
                Log.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", Integer.valueOf(this.pXh));
                if (this.pXh >= 2) {
                    this.pXi = intent.getStringExtra("Klabel_name_list");
                    this.pXj = intent.getStringExtra("Kother_user_name_list");
                    Log.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.pXh), this.pXi);
                    if (!TextUtils.isEmpty(this.pXi) || !TextUtils.isEmpty(this.pXj)) {
                        List asList = Arrays.asList(this.pXi.split(","));
                        this.pXl = com.tencent.mm.plugin.card.d.l.cZ(asList);
                        this.pXk = com.tencent.mm.plugin.card.d.l.cY(asList);
                        if (this.pXj != null && this.pXj.length() > 0) {
                            this.pXk.addAll(Arrays.asList(this.pXj.split(",")));
                        }
                        if (this.pXl != null) {
                            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.pXl.size());
                        }
                        if (this.pXk != null) {
                            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.pXk.size());
                            Iterator<String> it = this.pXk.iterator();
                            while (it.hasNext()) {
                                Log.d("MicroMsg.CardDetailUIContoller", "username : %s", it.next());
                            }
                        }
                        if (this.pXh == 2) {
                            this.pZJ.ajU(this.pQZ.getString(R.string.asn, new Object[]{cuG()}));
                            AppMethodBeat.o(113301);
                            return;
                        } else if (this.pXh == 3) {
                            this.pZJ.ajU(this.pQZ.getString(R.string.asm, new Object[]{cuG()}));
                            AppMethodBeat.o(113301);
                            return;
                        } else {
                            this.pZJ.ajU(this.pQZ.getString(R.string.asl));
                            AppMethodBeat.o(113301);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                        AppMethodBeat.o(113301);
                        return;
                    }
                } else {
                    this.pZJ.ajU(this.pQZ.getString(R.string.asl));
                    AppMethodBeat.o(113301);
                    return;
                }
            case 3:
                if (this.pZT != null) {
                    this.pZT.cvp();
                    break;
                }
                break;
        }
        AppMethodBeat.o(113301);
    }

    private String cuG() {
        AppMethodBeat.i(113302);
        if (!TextUtils.isEmpty(this.pXi) && !TextUtils.isEmpty(this.pXj)) {
            String str = this.pXi + "," + com.tencent.mm.plugin.card.d.l.akh(this.pXj);
            AppMethodBeat.o(113302);
            return str;
        } else if (!TextUtils.isEmpty(this.pXi)) {
            String str2 = this.pXi;
            AppMethodBeat.o(113302);
            return str2;
        } else if (!TextUtils.isEmpty(this.pXj)) {
            String akh = com.tencent.mm.plugin.card.d.l.akh(this.pXj);
            AppMethodBeat.o(113302);
            return akh;
        } else {
            AppMethodBeat.o(113302);
            return "";
        }
    }

    private void ajG(String str) {
        AppMethodBeat.i(113303);
        Intent intent = new Intent();
        if (this.pQV instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.pQV);
        } else if (this.pQV instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.pQV);
        }
        intent.setClass(this.pQZ, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.pZU.gwE);
        intent.putExtra("key_previous_scene", this.pZU.pWG);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.pZU.qaa);
        this.pQZ.startActivityForResult(intent, 3);
        this.pQZ.mmSetOnActivityResultCallback(this);
        AppMethodBeat.o(113303);
    }

    public final int cvN() {
        AppMethodBeat.i(113304);
        if (this.pZN == null) {
            AppMethodBeat.o(113304);
            return 0;
        } else if (this.pZN.ctt()) {
            AppMethodBeat.o(113304);
            return 1;
        } else {
            AppMethodBeat.o(113304);
            return 0;
        }
    }

    public final boolean cvO() {
        AppMethodBeat.i(113305);
        if (this.pZs == null) {
            AppMethodBeat.o(113305);
            return false;
        }
        boolean cvO = this.pZs.cvO();
        AppMethodBeat.o(113305);
        return cvO;
    }

    private void cvA() {
        boolean z;
        AppMethodBeat.i(113279);
        if (this.pZs == null) {
            z = false;
        } else if (this.pQV.csw()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.h) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pQV.csx()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.e) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pQV.csA()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.b) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pQV.csy()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.c) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pQV.csz()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.f) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pQV.csB()) {
            if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.d) {
                z = false;
            } else {
                z = true;
            }
        } else if (this.pZs instanceof com.tencent.mm.plugin.card.ui.a.a) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.pZs.release();
            this.pZs = null;
            Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", Integer.valueOf(this.pQV.csQ().nHh));
        }
        if (this.pZs == null) {
            Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", Integer.valueOf(this.pQV.csQ().nHh));
            Log.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", Integer.valueOf(this.pQV.csQ().nHh));
            if (!this.pQV.csw()) {
                switch (this.pQV.csQ().nHh) {
                    case 0:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.c(this.pQZ);
                        break;
                    case 10:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.e(this.pQZ);
                        break;
                    case 11:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.b(this.pQZ);
                        break;
                    case 20:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.f(this.pQZ);
                        break;
                    case 30:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.d(this.pQZ);
                        break;
                    default:
                        this.pZs = new com.tencent.mm.plugin.card.ui.a.a(this.pQZ);
                        break;
                }
            } else {
                this.pZs = new com.tencent.mm.plugin.card.ui.a.h(this.pQZ);
            }
        }
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", Integer.valueOf(this.pQV.csQ().nHh));
        this.pZs.a(this.pQV, this.pZU);
        AppMethodBeat.o(113279);
    }

    static /* synthetic */ void a(e eVar) {
        int i2;
        AppMethodBeat.i(113306);
        Intent intent = new Intent();
        if (eVar.pQV instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) eVar.pQV);
        } else if (eVar.pQV instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) eVar.pQV);
        }
        intent.putExtra("key_from_appbrand_type", eVar.pZU.qaa);
        intent.setClass(eVar.pQZ, CardShopUI.class);
        MMActivity mMActivity = eVar.pQZ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller", "goToCardShopUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller", "goToCardShopUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(eVar.pQV.csQ().nHh);
        objArr[2] = eVar.pQV.csV();
        objArr[3] = eVar.pQV.csU();
        objArr[4] = 0;
        objArr[5] = Integer.valueOf(eVar.pZU.pWG);
        objArr[6] = eVar.pZU.pZc;
        if (eVar.pQV.csO()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = "";
        hVar.a(11324, objArr);
        AppMethodBeat.o(113306);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(113307);
        com.tencent.mm.plugin.card.d.b.a(eVar.pQZ, 0, eVar);
        eVar.pQZ.mmSetOnActivityResultCallback(eVar);
        AppMethodBeat.o(113307);
    }
}
