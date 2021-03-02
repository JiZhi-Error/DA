package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.f;
import java.util.Date;
import java.util.LinkedList;

public final class g extends b {
    int gCo = -1;

    public g(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final int getType() {
        return 5;
    }

    public static boolean zA(int i2) {
        AppMethodBeat.i(36572);
        if (Util.safeParseInt("1001") == i2 || Util.safeParseInt("1002") == i2 || 419430449 == i2) {
            AppMethodBeat.o(36572);
            return true;
        }
        AppMethodBeat.o(36572);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final void gRY() {
        AppMethodBeat.i(36573);
        this.PEm.gSc();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.g.AnonymousClass1 */
            final /* synthetic */ boolean qoy = true;

            public final void run() {
                ah ahVar;
                long j2;
                a aVar;
                boolean z;
                boolean z2;
                int i2;
                int i3;
                AppMethodBeat.i(36567);
                LinkedList linkedList = new LinkedList();
                bg.aVF();
                Cursor eI = c.aSQ().eI(g.this.gAn, g.this.gCo);
                if (eI == null) {
                    Log.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(36567);
                    return;
                }
                if (ab.Eq(g.this.gAn)) {
                    bg.aVF();
                    ahVar = c.aSX().Kd(g.this.gAn);
                } else {
                    ahVar = null;
                }
                long j3 = 0;
                while (eI.moveToNext()) {
                    try {
                        ca caVar = new ca();
                        caVar.convertFrom(eI);
                        String str = caVar.field_content;
                        if (str != null) {
                            k.b aD = k.b.aD(str, caVar.field_reserved);
                            if (g.zA(Util.safeParseInt(aD.iyq)) || g.zA(caVar.getType())) {
                                String b2 = g.b(caVar, ab.Eq(g.this.gAn));
                                as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(b2);
                                String str2 = "";
                                if (ahVar != null) {
                                    str2 = ahVar.getDisplayName(b2);
                                }
                                if (g.zA(caVar.getType())) {
                                    a aVar2 = new a(caVar.field_createTime, caVar.getType(), aD.ixO, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str2);
                                    aag aag = new aag();
                                    aag.ehb.dQp = aD.ixQ;
                                    EventCenter.instance.publish(aag);
                                    boolean z3 = caVar.field_isSend == 1 ? aag.ehc.ehd : !aag.ehc.ehd;
                                    if (aag.ehc.status == -2) {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        Log.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", Boolean.valueOf(aag.ehc.ehd), Integer.valueOf(aag.ehc.status), Long.valueOf(caVar.field_msgId), g.this.PEn.Cc(aVar2.timestamp), aVar2.toString());
                                    } else {
                                        int i4 = aag.ehc.status;
                                        if (i4 <= 0) {
                                            i4 = aD.ixN;
                                        }
                                        aVar2.nickname = g.this.mContext.getResources().getString(R.string.hek, aVar2.nickname);
                                        switch (i4) {
                                            case 1:
                                            case 7:
                                                i2 = -352966;
                                                break;
                                            case 2:
                                            default:
                                                i2 = -352966;
                                                break;
                                            case 3:
                                                i2 = -470621;
                                                break;
                                            case 4:
                                                i2 = -470621;
                                                break;
                                            case 5:
                                                i2 = -470621;
                                                break;
                                            case 6:
                                                i2 = -470621;
                                                break;
                                        }
                                        aVar2.PEO = i2;
                                        aVar2.desc = g.a(g.this, g.this.mContext, caVar, aD, z3, i4);
                                        Context context = g.this.mContext;
                                        if (aD != null && context != null) {
                                            switch (i4) {
                                                case 1:
                                                case 7:
                                                    i3 = R.raw.c2c_remittance_icon;
                                                    break;
                                                case 2:
                                                default:
                                                    i3 = R.raw.c2c_remittance_icon;
                                                    break;
                                                case 3:
                                                    i3 = R.raw.c2c_remittance_received_icon;
                                                    break;
                                                case 4:
                                                    i3 = R.raw.c2c_remittance_rejected_icon;
                                                    break;
                                                case 5:
                                                    i3 = R.raw.c2c_remittance_received_icon;
                                                    break;
                                                case 6:
                                                    i3 = R.raw.c2c_remittance_cancle_icon;
                                                    break;
                                            }
                                        } else {
                                            i3 = R.raw.c2c_remittance_icon;
                                        }
                                        aVar2.iconRes = i3;
                                        aVar = aVar2;
                                    }
                                } else {
                                    a aVar3 = new a(caVar.field_createTime, caVar.getType(), aD.iyl, caVar.field_msgId, Kn.field_username, Kn.arI(), Kn.field_conRemark, str2);
                                    aVar3.dkT = Util.safeParseInt(aD.iyq);
                                    if (aVar3.dkT == Util.safeParseInt("1001")) {
                                        aVar3.nickname = g.this.mContext.getResources().getString(R.string.hea, aVar3.nickname);
                                        if (caVar.field_isSend == 1) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        aVar3.desc = f.a(aD, z);
                                        if (caVar.field_isSend == 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        aVar3.PEO = f.d(aD, z2);
                                        aVar3.iconRes = f.b(aD, caVar.field_isSend == 1);
                                        aVar = aVar3;
                                    } else {
                                        aaf aaf = new aaf();
                                        aaf.egV.egX = aD.iyr;
                                        EventCenter.instance.publish(aaf);
                                        aVar3.nickname = g.this.mContext.getResources().getString(R.string.hed, aVar3.nickname);
                                        aVar3.desc = f.a(aaf.egW.egY, aaf.egW.egZ, aaf.egW.eha, caVar.field_isSend == 1, ab.Eq(g.this.gAn), g.this.gAn, aD, null);
                                        int identifier = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.ag.c) aD.as(com.tencent.mm.ag.c.class)).ivO, "drawable", MMApplicationContext.getPackageName());
                                        aVar3.iconRes = f.J(aaf.egW.egZ, aaf.egW.eha, caVar.field_isSend == 1);
                                        if (aVar3.iconRes <= 0) {
                                            aVar3.iconRes = identifier;
                                        }
                                        aVar = aVar3;
                                    }
                                }
                                j2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                                if (j3 != j2) {
                                    linkedList.add(new c.C2089c(caVar.field_createTime));
                                }
                                linkedList.add(aVar);
                                j3 = j2;
                            }
                        }
                        j2 = j3;
                        j3 = j2;
                    } catch (Throwable th) {
                        eI.close();
                        AppMethodBeat.o(36567);
                        throw th;
                    }
                }
                eI.close();
                g.this.mDataList.addAll(linkedList);
                g.this.PEo = g.this.mDataList;
                linkedList.clear();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.g.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(36566);
                        if (g.this.PEm != null) {
                            g.this.PEm.D(AnonymousClass1.this.qoy, g.this.mDataList.size());
                        }
                        AppMethodBeat.o(36566);
                    }
                });
                AppMethodBeat.o(36567);
            }
        });
        AppMethodBeat.o(36573);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String bmB() {
        AppMethodBeat.i(36574);
        String string = this.mContext.getString(R.string.gfn);
        AppMethodBeat.o(36574);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String gSb() {
        AppMethodBeat.i(36575);
        String string = this.mContext.getString(R.string.gfn);
        AppMethodBeat.o(36575);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final c.e gRZ() {
        AppMethodBeat.i(36576);
        AnonymousClass2 r0 = new c.e() {
            /* class com.tencent.mm.ui.chatting.k.g.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void a(View view, int i2, c.b bVar) {
                AppMethodBeat.i(36568);
                Context context = g.this.mContext;
                String str = g.this.gAn;
                long j2 = bVar.msgId;
                if (str == null) {
                    Log.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
                    AppMethodBeat.o(36568);
                    return;
                }
                bg.aVF();
                long j3 = com.tencent.mm.model.c.aSQ().Hb(j2).field_msgId;
                Log.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(j3));
                if (ab.Eq(str)) {
                    bg.aVF();
                    if (com.tencent.mm.model.c.aSX().Kd(str) == null) {
                        Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                        h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                        AppMethodBeat.o(36568);
                        return;
                    }
                } else {
                    bg.aVF();
                    as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                    if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        if (Kn == null) {
                            Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                        } else {
                            Log.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                        }
                        h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                        AppMethodBeat.o(36568);
                        return;
                    }
                }
                Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j3);
                putExtra.setClass(context, ChattingUI.class);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/presenter/PayHistoryListPresenter", "goToChattingUI", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(36568);
            }

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void b(View view, int i2, c.b bVar) {
            }
        };
        AppMethodBeat.o(36576);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final RecyclerView.v N(ViewGroup viewGroup) {
        AppMethodBeat.i(36577);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a8s, viewGroup, false));
        AppMethodBeat.o(36577);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final void a(c.a aVar, int i2) {
        AppMethodBeat.i(36578);
        b bVar = (b) aVar;
        a aVar2 = (a) amy(i2);
        if (Util.isNullOrNil(aVar2.desc)) {
            bVar.jBR.setVisibility(8);
        } else {
            bVar.jBR.setVisibility(0);
            bVar.jBR.setText(Util.nullAs(aVar2.desc, ""));
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6);
        bVar.nnL.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        bVar.nnL.setImageResource(aVar2.iconRes);
        bVar.nnL.setBackgroundColor(aVar2.PEO);
        AppMethodBeat.o(36578);
    }

    private boolean gRM() {
        AppMethodBeat.i(233505);
        if (ab.Eq(this.gAn) || ab.Iy(this.gAn)) {
            AppMethodBeat.o(233505);
            return true;
        }
        AppMethodBeat.o(233505);
        return false;
    }

    class a extends c.b {
        public int PEO = 0;
        public String appId;
        public String desc;
        public int dkT;
        public int iconRes;

        public a(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5) {
            super(j2, i2, str, j3, str2, str3, str4, str5);
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            AppMethodBeat.i(36569);
            if (str != null) {
                boolean bmC = super.bmC(str);
                if (!bmC) {
                    bmC = this.title.contains(str);
                }
                AppMethodBeat.o(36569);
                return bmC;
            }
            AppMethodBeat.o(36569);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return this.type;
        }

        public final String toString() {
            AppMethodBeat.i(36570);
            String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.cgo + '\'' + ", nameInRoom='" + this.ogt + '\'' + '}';
            AppMethodBeat.o(36570);
            return str;
        }
    }

    class b extends c.a {
        TextView jBR;
        ImageView nnL;

        public b(View view) {
            super(view);
            AppMethodBeat.i(36571);
            this.nnL = (ImageView) view.findViewById(R.id.cc2);
            this.jVO.setSingleLine(false);
            this.jVO.setMaxLines(2);
            this.jBR = (TextView) view.findViewById(R.id.cbo);
            AppMethodBeat.o(36571);
        }
    }

    static /* synthetic */ String a(g gVar, Context context, ca caVar, k.b bVar, boolean z, int i2) {
        String string;
        String str;
        AppMethodBeat.i(36579);
        if (bVar == null || context == null) {
            AppMethodBeat.o(36579);
            return "";
        }
        switch (i2) {
            case 1:
            case 7:
                bg.aVF();
                as bjK = com.tencent.mm.model.c.aSN().bjK(caVar.field_talker);
                if (bjK != null) {
                    str = bjK.arJ();
                } else {
                    str = caVar.field_talker;
                }
                if (!gVar.gRM()) {
                    if (z) {
                        if (Util.isNullOrNil(bVar.iyX)) {
                            if (caVar.field_isSend == 1) {
                                string = gVar.mContext.getString(R.string.azg, str);
                                break;
                            } else {
                                string = gVar.mContext.getString(R.string.azh);
                                break;
                            }
                        } else {
                            string = bVar.iyX;
                            break;
                        }
                    } else {
                        string = gVar.mContext.getString(R.string.az7);
                        break;
                    }
                } else {
                    string = gVar.mContext.getString(R.string.azf);
                    break;
                }
            case 2:
            default:
                string = bVar.description;
                break;
            case 3:
                if (!gVar.gRM()) {
                    if (z) {
                        if (!Util.isNullOrNil(bVar.iyX)) {
                            string = MMApplicationContext.getContext().getString(R.string.az6) + "-" + bVar.iyX;
                            break;
                        } else {
                            string = MMApplicationContext.getContext().getString(R.string.az6);
                            break;
                        }
                    } else {
                        string = MMApplicationContext.getContext().getString(R.string.az7);
                        break;
                    }
                } else {
                    string = gVar.mContext.getString(R.string.az4);
                    break;
                }
            case 4:
                if (!gVar.gRM()) {
                    if (z) {
                        if (!Util.isNullOrNil(bVar.iyX)) {
                            string = MMApplicationContext.getContext().getString(R.string.azl) + "-" + bVar.iyX;
                            break;
                        } else {
                            string = MMApplicationContext.getContext().getString(R.string.azl);
                            break;
                        }
                    } else {
                        string = MMApplicationContext.getContext().getString(R.string.azk);
                        break;
                    }
                } else {
                    string = gVar.mContext.getString(R.string.azj);
                    break;
                }
            case 5:
                if (!gVar.gRM()) {
                    if (z) {
                        if (!Util.isNullOrNil(bVar.iyX)) {
                            string = MMApplicationContext.getContext().getString(R.string.azc) + "-" + bVar.iyX;
                            break;
                        } else {
                            string = MMApplicationContext.getContext().getString(R.string.azc);
                            break;
                        }
                    } else {
                        string = MMApplicationContext.getContext().getString(R.string.azd);
                        break;
                    }
                } else {
                    string = gVar.mContext.getString(R.string.aze);
                    break;
                }
            case 6:
                string = context.getResources().getString(R.string.az8);
                break;
        }
        AppMethodBeat.o(36579);
        return string;
    }
}
