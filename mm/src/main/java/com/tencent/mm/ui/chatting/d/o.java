package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.booter.z;
import com.tencent.mm.ci.d;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ai;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

@a(gRF = m.class)
public class o extends a implements m {
    private static String Pow = "100134";
    private boolean Pnm = false;
    private String PoA = null;
    private long PoB = 0;
    private int PoC = 0;
    private int PoD = 0;
    private int PoE;
    private HashSet<Long> Poq = new HashSet<>();
    private int Por;
    private HashSet<Long> Pos = new HashSet<>();
    private HashSet<Long> Pot = new HashSet<>();
    private int Pou = 0;
    private boolean Pov = false;
    private e.c Pox = new e.c() {
        /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.a.e.c
        public final void a(Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(233087);
            gs gsVar = new gs();
            gsVar.uu(o.this.dom.Pwh);
            gsVar.uv(o.this.dom.getTalkerUserName());
            gsVar.eKO = 1;
            gsVar.eKP = 1;
            gsVar.eKT = 1;
            gsVar.bfK();
            AppMethodBeat.o(233087);
        }

        @Override // com.tencent.mm.plugin.messenger.a.e.c
        public final void b(String str, Map<String, String> map, Bundle bundle) {
        }
    };
    private long Poy = 0;
    private boolean Poz = false;
    private long enterTime;
    private long peJ = 0;

    public o() {
        AppMethodBeat.i(35241);
        AppMethodBeat.o(35241);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.m
    public final void bY(final ca caVar) {
        AppMethodBeat.i(35243);
        if (this.Pos.contains(Long.valueOf(caVar.field_msgSvrId))) {
            AppMethodBeat.o(35243);
            return;
        }
        this.Pos.add(Long.valueOf(caVar.field_msgSvrId));
        com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass2 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "ChattingUI.expExposeReport";
            }

            public final void run() {
                AppMethodBeat.i(35235);
                com.tencent.mm.modelstat.a.a(caVar, a.EnumC0456a.Expose);
                AppMethodBeat.o(35235);
            }
        });
        AppMethodBeat.o(35243);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.m
    public final void amA(int i2) {
        this.Por = i2;
    }

    private void gPE() {
        long j2;
        AppMethodBeat.i(35245);
        z.gmQ.CU(this.dom.getTalkerUserName());
        b.jmd.report();
        bg bgVar = new bg();
        bgVar.dEu.dEv = false;
        EventCenter.instance.publish(bgVar);
        ((e) g.af(e.class)).b("tmpl_type_succeed_contact", this.Pox);
        String talkerUserName = this.dom.getTalkerUserName();
        if (this.enterTime != 0) {
            fa faVar = new fa();
            if (this.dom.Pwc.getIntExtra("chat_from_scene", 0) == 5) {
                faVar.etp = 1;
            } else {
                faVar.etp = 2;
            }
            faVar.emL = faVar.x("ChatName", talkerUserName, true);
            faVar.eEP = this.enterTime;
            faVar.eEQ = System.currentTimeMillis();
            faVar.eER = (long) this.PoE;
            faVar.eES = (long) ac.JT(talkerUserName);
            com.tencent.mm.model.bg.aVF();
            az bjY = c.aST().bjY(talkerUserName);
            if (bjY != null) {
                if ("hidden_conv_parent".equalsIgnoreCase(bjY.field_parentRef)) {
                    faVar.eET = 1;
                } else if (bjY.field_conversationTime > this.enterTime) {
                    if (Util.isNullOrNil(bjY.field_digestUser)) {
                        j2 = 2;
                    } else {
                        j2 = 3;
                    }
                    faVar.eET = j2;
                } else if (!Util.isNullOrNil(bjY.field_editingMsg) || bjY.field_editingQuoteMsgId != 0) {
                    faVar.eET = 4;
                }
            }
            faVar.bfK();
            this.enterTime = 0;
        }
        AppMethodBeat.o(35245);
    }

    private void gPF() {
        int i2 = 0;
        AppMethodBeat.i(35246);
        if (this.Poz) {
            long currentTimeMillis = System.currentTimeMillis() - this.Poy;
            this.Poy = 0;
            this.Poz = false;
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            long[] jArr = {0, 200, 400, 600, 800, 1000, 1500, 2000};
            while (true) {
                if (i2 < 8) {
                    if (currentTimeMillis < jArr[i2]) {
                        break;
                    } else if (i2 == 7) {
                        i2 = 8;
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            hVar.idkeyStat(109, (long) i2, 1, true);
        }
        AppMethodBeat.o(35246);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(35247);
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            d.gGm().gV(ChattingUI.class.getName() + ".Listview", 4);
        }
        AppMethodBeat.o(35247);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35248);
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(110, 0, 1, true);
        }
        String talkerUserName = this.dom.getTalkerUserName();
        this.enterTime = 0;
        if (!Util.isNullOrNil(talkerUserName)) {
            com.tencent.mm.model.bg.aVF();
            az bjY = c.aST().bjY(talkerUserName);
            if (bjY != null && "hidden_conv_parent".equalsIgnoreCase(bjY.field_parentRef)) {
                this.enterTime = System.currentTimeMillis();
                this.PoE = ac.JT(talkerUserName);
            }
        }
        AppMethodBeat.o(35248);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35250);
        ai.gOk().amq(2);
        if (!this.Pnm) {
            report();
        }
        this.Pnm = false;
        AppMethodBeat.o(35250);
    }

    private void report() {
        AppMethodBeat.i(35251);
        this.PoA = null;
        if (com.tencent.mm.model.z.aTY() == null) {
            Log.e("MicroMsg.ChattingUI.ChattingReportComponent", "getUsernameFromUserInfo is null!");
            AppMethodBeat.o(35251);
            return;
        }
        if (!com.tencent.mm.model.z.aTY().equals(this.dom.getTalkerUserName()) && this.dom.gRL()) {
            this.PoA = this.dom.getTalkerUserName();
            this.peJ = (bp.aVP() / 1000) * 1000;
            this.PoC = 0;
            final String str = this.PoA;
            com.tencent.mm.model.bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass6 */

                public final void run() {
                    boolean z = false;
                    AppMethodBeat.i(35239);
                    if (!Util.isNullOrNil(str)) {
                        o.this.PoC = ac.aI(str, ab.iCF);
                        Log.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", str, Integer.valueOf(o.this.PoC), Util.unixTimeMsToTime(o.this.peJ), Long.valueOf(o.this.peJ));
                        if (o.this.dom.gRL() && o.this.dom.GUe.fuH == 0) {
                            z = true;
                        }
                        ((com.tencent.mm.plugin.expt.roomexpt.d) g.af(com.tencent.mm.plugin.expt.roomexpt.d.class)).aZ(str, z);
                    }
                    AppMethodBeat.o(35239);
                }
            });
        }
        gPF();
        AppMethodBeat.o(35251);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        final int i2;
        AppMethodBeat.i(35252);
        ai.gOk().amq(3);
        if (!TextUtils.isEmpty(this.PoA) && this.dom.gRL()) {
            this.PoB = bp.aVP();
            final String str = this.PoA;
            this.PoA = "";
            final int gQE = ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQE();
            if (gQE == 2) {
                ((com.tencent.mm.ui.chatting.d.b.ab) this.dom.bh(com.tencent.mm.ui.chatting.d.b.ab.class)).gQD();
            }
            if (!this.dom.gRL() || this.dom.GUe.fuH != 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (5 == this.dom.Pwc.getIntExtra("chat_from_scene", 0)) {
                Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "from_scene_gobal_search");
                this.PoD = 2;
            } else {
                this.PoD = this.dom.Pwc.getIntExtra("chat_from_scene_for_group_chats", 0);
            }
            final int i3 = this.PoD;
            Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "enterSceneForGroupChats : " + this.PoD);
            this.PoD = 0;
            com.tencent.mm.model.bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass7 */

                public final void run() {
                    int i2;
                    int i3;
                    boolean z = false;
                    AppMethodBeat.i(35240);
                    if (!Util.isNullOrNil(str)) {
                        int Ie = v.Ie(str);
                        com.tencent.mm.model.bg.aVF();
                        Cursor I = c.aSQ().I(str, o.this.peJ, o.this.PoB);
                        if (I == null || !I.moveToFirst()) {
                            i2 = 0;
                            i3 = 0;
                        } else {
                            ca caVar = new ca();
                            i2 = 0;
                            int i4 = 0;
                            do {
                                caVar.convertFrom(I);
                                if (caVar.field_isSend == 1) {
                                    i4++;
                                } else {
                                    i2++;
                                }
                            } while (I.moveToNext());
                            i3 = i4;
                        }
                        if (I != null) {
                            I.close();
                        }
                        Log.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s ,enterSceneForGroupChatsState:%d", str, Long.valueOf(o.this.PoB - o.this.peJ), Integer.valueOf(Ie), Integer.valueOf(o.this.PoC + i2), Integer.valueOf(i3), Integer.valueOf(o.this.PoC), Integer.valueOf(gQE), Integer.valueOf(i2), o.this.dom.bul(), Integer.valueOf(i3));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12077, str, Long.valueOf(o.this.PoB - o.this.peJ), Integer.valueOf(Ie), Integer.valueOf(i2 + o.this.PoC), Integer.valueOf(i3), Integer.valueOf(o.this.PoC), Integer.valueOf(gQE), Integer.valueOf(i2), o.this.dom.bul(), Integer.valueOf(o.this.Por), Integer.valueOf(i3));
                        String displayName = aa.getDisplayName(str);
                        com.tencent.mm.plugin.expt.roomexpt.d dVar = (com.tencent.mm.plugin.expt.roomexpt.d) g.af(com.tencent.mm.plugin.expt.roomexpt.d.class);
                        String str = str;
                        long j2 = o.this.PoB - o.this.peJ;
                        int i5 = o.this.PoC;
                        if (i2 == 1) {
                            z = true;
                        }
                        dVar.a(str, displayName, j2, i5, i3, z);
                    }
                    AppMethodBeat.o(35240);
                }
            });
        }
        AppMethodBeat.o(35252);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35253);
        gPE();
        boolean aEf = ((l) g.af(l.class)).eit().aEf(this.dom.getTalkerUserName());
        com.tencent.mm.ui.chatting.l.b bVar = com.tencent.mm.ui.chatting.l.b.PEW;
        boolean gRM = this.dom.gRM();
        ArrayList<IDKey> arrayList = new ArrayList<>();
        if (gRM && !aEf) {
            if (bVar.PEX[0] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 0, bVar.PEX[0]));
            }
            if (bVar.PEX[1] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 1, bVar.PEX[1]));
            }
            if (bVar.PEX[2] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 2, bVar.PEX[2]));
            }
            if (bVar.PEX[3] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 3, bVar.PEX[3]));
            }
            if (bVar.PEX[4] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 4, bVar.PEX[4]));
            }
            arrayList.add(new IDKey((int) w.CTRL_INDEX, 19, 1));
        } else if (!gRM || !aEf) {
            if (bVar.PEX[0] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 20, bVar.PEX[0]));
            }
            if (bVar.PEX[1] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 21, bVar.PEX[1]));
            }
            if (bVar.PEX[2] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 22, bVar.PEX[2]));
            }
            if (bVar.PEX[3] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 23, bVar.PEX[3]));
            }
            if (bVar.PEX[4] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 24, bVar.PEX[4]));
            }
            arrayList.add(new IDKey((int) w.CTRL_INDEX, 39, 1));
        } else {
            if (bVar.PEX[0] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 40, bVar.PEX[0]));
            }
            if (bVar.PEX[1] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 41, bVar.PEX[1]));
            }
            if (bVar.PEX[2] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 42, bVar.PEX[2]));
            }
            if (bVar.PEX[3] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 43, bVar.PEX[3]));
            }
            if (bVar.PEX[4] > 0) {
                arrayList.add(new IDKey((int) w.CTRL_INDEX, 44, bVar.PEX[4]));
            }
            arrayList.add(new IDKey((int) w.CTRL_INDEX, 59, 1));
        }
        com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, true);
        com.tencent.mm.ui.chatting.l.c cVar = com.tencent.mm.ui.chatting.l.c.PEZ;
        Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", this.dom.getTalkerUserName(), Integer.valueOf(cVar.mCount), Integer.valueOf(cVar.PFa), Integer.valueOf(cVar.PFb), Integer.valueOf(cVar.IvL), Integer.valueOf(cVar.mSuccessCount), Integer.valueOf(cVar.PFc));
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(403, 60, (long) cVar.mCount, true);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(403, 61, (long) cVar.PFa, true);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(403, 62, (long) cVar.PFb, true);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(403, 63, (long) cVar.IvL, true);
        ArrayList<IDKey> arrayList2 = new ArrayList<>();
        arrayList2.add(new IDKey(403, 64, cVar.mSuccessCount));
        arrayList2.add(new IDKey(403, 65, cVar.PFc));
        com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList2, true);
        ai.gOk().amq(4);
        AppMethodBeat.o(35253);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35254);
        super.gOK();
        gPE();
        AppMethodBeat.o(35254);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.m
    public final void bX(final ca caVar) {
        AppMethodBeat.i(35242);
        if (!this.Poq.contains(Long.valueOf(caVar.field_msgSvrId))) {
            this.Poq.add(Long.valueOf(caVar.field_msgSvrId));
            com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass1 */
                final /* synthetic */ boolean PoF = false;

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "ChattingUI.adVideoExposeReport";
                }

                public final void run() {
                    String Ks;
                    int i2;
                    int i3;
                    AppMethodBeat.i(35234);
                    ((j) g.af(j.class)).aO(caVar);
                    ca caVar = caVar;
                    boolean z = this.PoF;
                    PString pString = new PString();
                    PString pString2 = new PString();
                    if (com.tencent.mm.ui.chatting.a.a(caVar, pString, pString2)) {
                        String str = pString.value;
                        String str2 = pString2.value;
                        String str3 = caVar.field_talker;
                        boolean Iw = ab.Iw(str3);
                        if (caVar.field_isSend == 1) {
                            Ks = com.tencent.mm.model.z.aTY();
                        } else {
                            Ks = Iw ? bp.Ks(caVar.field_content) : str3;
                        }
                        com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
                        mVar.n("20source_publishid", str + ",");
                        mVar.n("21uxinfo", str2 + ",");
                        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
                        mVar.n("23source_type", (caVar.getType() == 62 ? 1 : 2) + ",");
                        mVar.n("24scene", (Iw ? 4 : 3) + ",");
                        mVar.n("25scene_chatname", str3 + ",");
                        mVar.n("26scene_username", Ks + ",");
                        mVar.n("27curr_publishid", ",");
                        mVar.n("28curr_msgid", caVar.field_msgSvrId + ",");
                        mVar.n("29curr_favid", "0,");
                        StringBuilder sb = new StringBuilder();
                        if (z) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        mVar.n("30isdownload", sb.append(i2).append(",").toString());
                        StringBuilder sb2 = new StringBuilder();
                        if (Iw) {
                            i3 = v.Ie(str3);
                        } else {
                            i3 = 0;
                        }
                        mVar.n("31chatroom_membercount", sb2.append(i3).append(",").toString());
                        ((j) g.af(j.class)).b(((j) g.af(j.class)).ag(caVar), mVar);
                        Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + mVar.abW());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12989, mVar);
                    }
                    AppMethodBeat.o(35234);
                }
            });
        }
        AppMethodBeat.o(35242);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.m
    public final void bZ(final ca caVar) {
        AppMethodBeat.i(35244);
        if (!this.Pov) {
            this.Pov = true;
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu(Pow);
            if (Fu.isValid()) {
                this.Pou = af.getInt(Fu.gzz().get("needUploadData"), 0);
            }
        }
        if (this.Pou == 0) {
            AppMethodBeat.o(35244);
        } else if (this.Pot.contains(Long.valueOf(caVar.field_msgSvrId))) {
            AppMethodBeat.o(35244);
        } else {
            com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass3 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "ChattingUI.appExposeReport";
                }

                public final void run() {
                    AppMethodBeat.i(35236);
                    o.a(o.this, caVar);
                    AppMethodBeat.o(35236);
                }
            });
            AppMethodBeat.o(35244);
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        int i2;
        int i3;
        final int i4;
        int i5;
        final int i6 = 0;
        AppMethodBeat.i(35249);
        this.Poy = System.currentTimeMillis();
        this.Poz = true;
        if (!(this.dom.GUe == null || this.dom.getTalkerUserName() == null || com.tencent.mm.model.z.aTY() == null)) {
            b.jmd.fP(this.dom.getTalkerUserName());
            if (!com.tencent.mm.model.z.aTY().equals(this.dom.getTalkerUserName())) {
                bg bgVar = new bg();
                bgVar.dEu.dEv = true;
                EventCenter.instance.publish(bgVar);
            }
            ai.gOk().amq(1);
            if (ab.Eq(this.dom.getTalkerUserName())) {
                am.USY.awT(2);
            } else {
                am.USY.awT(1);
            }
            boolean Zx = ((aw) this.dom.bh(aw.class)).Zx();
            if ("notification_messages".equals(this.dom.getTalkerUserName())) {
                i4 = 1;
                i5 = 8;
            } else {
                if (ab.IT(this.dom.getTalkerUserName())) {
                    com.tencent.mm.ui.chatting.d.b.d dVar = (com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
                    if (dVar.gOP()) {
                        int i7 = Zx ? 0 : 1;
                        if (dVar.gOQ()) {
                            dVar.gON().bax().size();
                            i4 = i7;
                            i5 = 5;
                        } else {
                            i4 = i7;
                            i5 = 4;
                        }
                    } else if (com.tencent.mm.al.g.Nf(this.dom.getTalkerUserName())) {
                        i4 = Zx ? 0 : 1;
                        i5 = 3;
                    } else if (com.tencent.mm.al.g.Ng(this.dom.getTalkerUserName())) {
                        i4 = 1;
                        i5 = 0;
                    } else if (com.tencent.mm.al.g.Nb(this.dom.getTalkerUserName())) {
                        i3 = 6;
                        i2 = 0;
                    } else {
                        i3 = 7;
                        i2 = 0;
                    }
                } else if (this.dom.gRL()) {
                    i4 = Zx ? 0 : 1;
                    i5 = 2;
                } else if (Zx) {
                    i2 = 0;
                    i3 = 1;
                } else {
                    i2 = 1;
                    i3 = 1;
                }
                i4 = i2;
                i5 = i3;
            }
            if (!this.dom.gRK()) {
                int i8 = i5;
                for (String str : ab.iCO) {
                    if (str.equals(this.dom.getTalkerUserName())) {
                        i8 = 0;
                    }
                }
                i6 = i8;
            }
            if (i6 != 0) {
                if (!((com.tencent.mm.ui.chatting.d.b.h) this.dom.bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu() && !((i) this.dom.bh(i.class)).gPw()) {
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.o.AnonymousClass4 */

                        public final void run() {
                            int i2;
                            int i3;
                            AppMethodBeat.i(35237);
                            if (i6 == 2) {
                                i2 = v.Ie(o.this.dom.getTalkerUserName());
                            } else {
                                i2 = 0;
                            }
                            com.tencent.mm.model.bg.aVF();
                            az bjY = c.aST().bjY(o.this.dom.getTalkerUserName());
                            if (bjY == null) {
                                i3 = 0;
                            } else {
                                i3 = bjY.field_unReadCount;
                            }
                            z zVar = z.gmQ;
                            String talkerUserName = o.this.dom.getTalkerUserName();
                            int i4 = i6;
                            int i5 = i4;
                            if (zVar.gna == null) {
                                zVar.gna = com.tencent.mm.model.z.aTY();
                            }
                            if (!zVar.gna.equals(talkerUserName)) {
                                if (zVar.gmU != null) {
                                    Log.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", zVar.gmU.gnh);
                                    zVar.CU(zVar.gmU.gnh);
                                }
                                if (zVar.gmR.ake(6) == 0) {
                                    zVar.gmR.setLong(4, Util.nowSecond());
                                }
                                EventCenter.instance.add(zVar.gmS);
                                EventCenter.instance.add(zVar.gmT);
                                zVar.appForegroundListener.alive();
                                zVar.gmU = new z.a();
                                zVar.gmU.gnl = zVar.gmV;
                                zVar.gmV = 0;
                                zVar.gmU.gnh = talkerUserName;
                                zVar.gmY = Util.currentTicks();
                                zVar.gmU.type = i4;
                                zVar.gmU.gni = i5;
                                zVar.gmU.dCm = i3;
                                zVar.gmU.gnj = i2;
                                zVar.gmU.enterTime = Util.nowSecond();
                                Log.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", talkerUserName, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(i2));
                            }
                            AppMethodBeat.o(35237);
                        }
                    }, "MicroMsg.ChattingUI.ChattingReportComponent");
                }
            }
            ((e) g.af(e.class)).a("tmpl_type_succeed_contact", this.Pox);
        }
        this.Pnm = true;
        report();
        AppMethodBeat.o(35249);
    }

    static /* synthetic */ void a(o oVar, ca caVar) {
        int Kp;
        AppMethodBeat.i(35255);
        oVar.Pot.add(Long.valueOf(caVar.field_msgSvrId));
        com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
        mVar.n("20MessageID", caVar.field_msgSvrId + ",");
        mVar.n("21MessageInnerType", caVar.getType() + ",");
        mVar.n("22currChatName", caVar.field_talker + ",");
        String str = "";
        if (caVar.field_isSend == 1) {
            str = com.tencent.mm.model.z.aTY();
        } else if (!oVar.dom.gRL()) {
            str = caVar.field_talker;
        } else if (!(caVar.field_content == null || (Kp = bp.Kp(caVar.field_content)) == -1)) {
            str = caVar.field_content.substring(0, Kp).trim();
        }
        mVar.n("23msgPostUserName", str + ",");
        k.b HD = k.b.HD(caVar.field_content);
        if (HD != null) {
            mVar.n("24AppId", HD.appId + ",");
            if (HD.ean != null) {
                eco eco = new eco();
                try {
                    eco.parseFrom(Base64.decode(HD.ean, 0));
                } catch (Exception e2) {
                }
                if (eco.NcJ != null) {
                    mVar.n("25SourceAppId", eco.NcJ.xEN + ",");
                }
            }
            Log.v("MicroMsg.ChattingUI.ChattingReportComponent", "appExposeReport report logbuffer(13634): " + mVar.abW());
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13634, mVar);
        }
        AppMethodBeat.o(35255);
    }
}
