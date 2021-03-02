package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.a.n;
import com.tencent.wecall.talkroom.model.f;
import com.tencent.wecall.talkroom.model.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e implements d {
    private static e Sus = null;
    private a Sur = null;
    private ConnectReceiver Sut = new ConnectReceiver();
    private g.a Suu = new g.a() {
        /* class com.tencent.wecall.talkroom.model.e.AnonymousClass1 */

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void p(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(62663);
            b.w("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
            if (com.tencent.pb.common.a.a.RCj) {
                Toast.makeText(c.Hhs, "onCreateRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (e.this.Sur != null) {
                e.this.Sur.d(multiTalkGroup);
            }
            AppMethodBeat.o(62663);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void asG(int i2) {
            AppMethodBeat.i(62664);
            b.d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i2));
            AppMethodBeat.o(62664);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void bgz() {
            AppMethodBeat.i(62665);
            b.w("TalkRoomSdkApi", "onInitSeccess");
            if (com.tencent.pb.common.a.a.RCj) {
                Toast.makeText(c.Hhs, "onInitSeccess ", 0).show();
            }
            if (e.this.Sur != null) {
                e.this.Sur.enE();
            }
            AppMethodBeat.o(62665);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void f(MultiTalkGroup multiTalkGroup) {
            int i2;
            int i3;
            AppMethodBeat.i(62666);
            String str = a.hqJ().xOr;
            String str2 = null;
            if (multiTalkGroup != null) {
                str2 = multiTalkGroup.zHD;
            }
            b.i("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
            if (com.tencent.pb.common.a.a.RCj) {
                Toast.makeText(c.Hhs, "onMemberChange ".concat(String.valueOf(multiTalkGroup)), 0).show();
            }
            if (f.nG(str2, str)) {
                c.hqY();
                if (c.brl(str) && a.hqJ().state != 3) {
                    c.hqY();
                    int brm = c.brm(str);
                    if (brm == 104) {
                        i2 = -1602;
                        i3 = TbsListener.ErrorCode.THROWABLE_INITX5CORE;
                    } else if (brm == 2) {
                        i2 = -1603;
                        i3 = TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL;
                    } else {
                        i2 = -1604;
                        i3 = TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT;
                    }
                    b.w("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i2), Integer.valueOf(i3), str2, " reason: ", Integer.valueOf(brm));
                    h.asK(i2);
                    a.hqJ().SuY.asO(i3);
                    f hqJ = a.hqJ();
                    int i4 = a.hqJ().yvK;
                    long j2 = a.hqJ().HgX;
                    a.hqJ();
                    hqJ.a(str2, i4, j2, false, false, false);
                }
            }
            if (e.this.Sur != null) {
                e.this.Sur.f(multiTalkGroup);
            }
            AppMethodBeat.o(62666);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void n(int i2, Object obj) {
            AppMethodBeat.i(62667);
            b.w("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i2), " data: ", obj);
            if (e.this.Sur != null) {
                e.this.Sur.n(i2, obj);
            }
            AppMethodBeat.o(62667);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void q(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(62668);
            b.w("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
            if (e.this.Sur != null) {
                e.this.Sur.e(multiTalkGroup);
                if (com.tencent.pb.common.a.a.RCj) {
                    Toast.makeText(c.Hhs, "onEnterRoom ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(62668);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void dH(String str, boolean z) {
            AppMethodBeat.i(62669);
            b.d("TalkRoomSdkApi", "onExitRoom", str, a.hqJ().xOr, Boolean.valueOf(z));
            AppMethodBeat.o(62669);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void onStateChanged(int i2) {
            AppMethodBeat.i(62670);
            b.d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i2));
            AppMethodBeat.o(62670);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void hrc() {
            AppMethodBeat.i(62671);
            b.d("TalkRoomSdkApi", "onSelfHoldOnBegin");
            AppMethodBeat.o(62671);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void hrd() {
            AppMethodBeat.i(62672);
            b.d("TalkRoomSdkApi", "onSelfHoldOnEnd");
            AppMethodBeat.o(62672);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void hK(String str, int i2) {
            AppMethodBeat.i(62673);
            b.d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i2));
            AppMethodBeat.o(62673);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void rv(boolean z) {
            AppMethodBeat.i(62674);
            b.i("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
            if (e.this.Sur != null) {
                e.this.Sur.rv(z);
            }
            AppMethodBeat.o(62674);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void b(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(62675);
            b.w("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
            if (e.this.Sur != null) {
                e.this.Sur.b(multiTalkGroup);
                if (com.tencent.pb.common.a.a.RCj) {
                    Toast.makeText(c.Hhs, "onInviteMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(62675);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void a(int i2, MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(62676);
            b.w("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i2));
            if (e.this.Sur != null) {
                e.this.Sur.c(multiTalkGroup);
                if (com.tencent.pb.common.a.a.RCj) {
                    Toast.makeText(c.Hhs, "onMisscMultiTalk ".concat(String.valueOf(multiTalkGroup)), 0).show();
                }
            }
            AppMethodBeat.o(62676);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void ki(List<MultiTalkGroup> list) {
            AppMethodBeat.i(62677);
            b.i("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
            if (e.this.Sur != null) {
                a unused = e.this.Sur;
            }
            AppMethodBeat.o(62677);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void hre() {
            AppMethodBeat.i(62678);
            b.w("TalkRoomSdkApi", "onSendMsgSucc");
            if (e.this.Sur != null) {
                a unused = e.this.Sur;
            }
            AppMethodBeat.o(62678);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void F(String str, byte[] bArr) {
            int i2 = 0;
            AppMethodBeat.i(62679);
            Object[] objArr = new Object[4];
            objArr[0] = "onRcvMultiTalkMsg groupId: ";
            objArr[1] = str;
            objArr[2] = " datas size: ";
            if (bArr != null) {
                i2 = bArr.length;
            }
            objArr[3] = Integer.valueOf(i2);
            b.w("TalkRoomSdkApi", objArr);
            if (e.this.Sur != null) {
                a unused = e.this.Sur;
            }
            AppMethodBeat.o(62679);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void asH(int i2) {
            AppMethodBeat.i(62680);
            b.d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i2));
            if (e.this.Sur != null) {
                e.this.Sur.enF();
            }
            AppMethodBeat.o(62680);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void Rd(int i2) {
            AppMethodBeat.i(199679);
            b.d("TalkRoomSdkApi", "onSwitchVideoScreenSharingRsp switch_ret: ", Integer.valueOf(i2));
            if (e.this.Sur != null) {
                e.this.Sur.Rd(i2);
            }
            AppMethodBeat.o(199679);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void enG() {
            AppMethodBeat.i(62681);
            b.d("TalkRoomSdkApi", "onSubscribeLargeVideoSuss");
            if (e.this.Sur != null) {
                e.this.Sur.enG();
            }
            AppMethodBeat.o(62681);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void enH() {
            AppMethodBeat.i(183717);
            b.d("TalkRoomSdkApi", "onSubscribeGeneralVideoSuss");
            if (e.this.Sur != null) {
                e.this.Sur.enH();
            }
            AppMethodBeat.o(183717);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void enI() {
            AppMethodBeat.i(199680);
            b.d("TalkRoomSdkApi", "onSubscribeScreenSharingVideoSuss");
            if (e.this.Sur != null) {
                e.this.Sur.enI();
            }
            AppMethodBeat.o(199680);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void fz(List<a.as> list) {
            AppMethodBeat.i(62682);
            b.d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
            if (e.this.Sur != null) {
                e.this.Sur.fz(list);
            }
            AppMethodBeat.o(62682);
        }

        @Override // com.tencent.wecall.talkroom.model.g.a
        public final void Ri(int i2) {
            AppMethodBeat.i(62683);
            b.d("TalkRoomSdkApi", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(i2));
            if (e.this.Sur != null) {
                e.this.Sur.Ri(i2);
            }
            AppMethodBeat.o(62683);
        }
    };
    private final String TAG = "TalkRoomSdkApi";

    public static e hrb() {
        AppMethodBeat.i(62609);
        if (Sus == null) {
            synchronized (e.class) {
                try {
                    if (Sus == null) {
                        Sus = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62609);
                    throw th;
                }
            }
        }
        e eVar = Sus;
        AppMethodBeat.o(62609);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(62610);
        AppMethodBeat.o(62610);
    }

    public static void lw(Context context) {
        AppMethodBeat.i(62611);
        c.Hhs = context;
        i.lq(context);
        AppMethodBeat.o(62611);
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean a(com.tencent.pb.talkroom.sdk.a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        AppMethodBeat.i(62612);
        if (c.Hhs == null) {
            b.w("TalkRoomSdkApi", "init fail context: ", c.Hhs);
            AppMethodBeat.o(62612);
            return false;
        }
        try {
            this.Sur = aVar;
            f.a(eVar);
            f hqJ = a.hqJ();
            hqJ.Svg.a(this.Suu);
            com.tencent.pb.common.b.f.hiZ().RCV = eVar;
            a.hqI();
            a.hqK();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            c.Hhs.registerReceiver(this.Sut, intentFilter);
            b.d("TalkRoomSdkApi", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
            AppMethodBeat.o(62612);
            return true;
        } catch (Exception e2) {
            b.w("TalkRoomSdkApi", "init ", e2);
            AppMethodBeat.o(62612);
            return false;
        }
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final void rK(boolean z) {
        AppMethodBeat.i(62613);
        f hqJ = a.hqJ();
        b.w("TalkRoomService", "setMute isMute: ", Boolean.valueOf(z));
        hqJ.mIsMute = z;
        com.tencent.pb.common.c.g.runOnMainThread(new Runnable(z) {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass17 */
            final /* synthetic */ boolean quk;

            {
                this.quk = r2;
            }

            public final void run() {
                AppMethodBeat.i(199663);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.rv(this.quk);
                        }
                    } finally {
                        AppMethodBeat.o(199663);
                    }
                }
            }
        });
        AppMethodBeat.o(62613);
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final void rJ(boolean z) {
        boolean z2;
        AppMethodBeat.i(62614);
        a.hqJ();
        com.tencent.pb.talkroom.sdk.e hrt = f.hrt();
        if (hrt != null) {
            z2 = hrt.rB(z);
        } else {
            z2 = false;
        }
        b.d("TalkRoomService", "switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(z2), " realret: ", Boolean.valueOf(f.hrs()), " wxCallBack: ", hrt);
        AppMethodBeat.o(62614);
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean hjt() {
        AppMethodBeat.i(62615);
        try {
            b.hjo();
            b.w("TalkRoomSdkApi", "setOpenLog: isOpenSdkLog", Boolean.TRUE, " level: ", 0);
            AppMethodBeat.o(62615);
            return true;
        } catch (Throwable th) {
            b.w("TalkRoomSdkApi", "setOpenLog: ", th);
            AppMethodBeat.o(62615);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0365  */
    @Override // com.tencent.pb.talkroom.sdk.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r11, java.lang.String r12, java.util.List<java.lang.String> r13, int r14) {
        /*
        // Method dump skipped, instructions count: 878
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wecall.talkroom.model.e.a(java.lang.String, java.lang.String, java.util.List, int):boolean");
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean c(String str, int i2, String str2, int i3) {
        AppMethodBeat.i(183714);
        f hqJ = a.hqJ();
        hqJ.SuP = i3;
        f.b a2 = hqJ.a(str, hqJ.yvK, hqJ.HgX, i2, 1, str2, i3);
        b.w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.TRUE, " routId: ", Integer.valueOf(i2), " ret: ", a2);
        if (a2 == f.b.OK) {
            AppMethodBeat.o(183714);
            return true;
        }
        AppMethodBeat.o(183714);
        return false;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean a(String str, int i2, long j2, int i3, String str2, int i4) {
        AppMethodBeat.i(183715);
        f.b a2 = a.hqJ().a(str, i2, j2, i3, 100, str2, i4);
        b.w("TalkRoomSdkApi", "enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2), " routId: ", Integer.valueOf(i3), " wxGroupId: ", str2, " ret: ", a2);
        if (a2 == f.b.OK) {
            AppMethodBeat.o(183715);
            return true;
        }
        AppMethodBeat.o(183715);
        return false;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean Q(String str, List<String> list) {
        boolean z;
        AppMethodBeat.i(62619);
        if (!com.tencent.pb.common.c.f.nG(str, a.hqJ().xOr)) {
            b.w("TalkRoomSdkApi", "addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.hqJ().xOr);
            AppMethodBeat.o(62619);
            return false;
        }
        f hqJ = a.hqJ();
        Object[] objArr = new Object[6];
        objArr[0] = "addrTalkRoomMember";
        objArr[1] = str;
        objArr[2] = Integer.valueOf(hqJ.yvK);
        objArr[3] = Long.valueOf(hqJ.HgX);
        objArr[4] = " users length: ";
        objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
        b.w("TalkRoomService", objArr);
        hqJ.Svm = false;
        if (TextUtils.isEmpty(str) || list == null) {
            z = false;
        } else if (!h.isNetworkConnected()) {
            b.w("TalkRoomService", "addTalkRoomMember isNetworkConnected is false");
            z = false;
        } else {
            String[] kj = f.kj(list);
            if (kj.length <= 0) {
                b.w("TalkRoomService", "addTalkRoomMember users is null");
                z = false;
            } else {
                z = com.tencent.pb.common.b.e.hiW().a(new com.tencent.wecall.talkroom.a.b(str, hqJ.yvK, hqJ.HgX, kj));
                hqJ.SuY.ag("add", "req", String.valueOf(z), String.valueOf(hqJ.state));
            }
        }
        b.w("TalkRoomSdkApi", "addMultiTalkMember ret: ", Boolean.valueOf(z));
        AppMethodBeat.o(62619);
        return z;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean aFM(String str) {
        AppMethodBeat.i(62620);
        if (!com.tencent.pb.common.c.f.nG(str, a.hqJ().xOr)) {
            b.w("TalkRoomSdkApi", "exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.hqJ().xOr);
            if (a.hqJ().brp(str)) {
                f.e bro = a.hqJ().bro(str);
                a.hqJ().c(str, bro == null ? 0 : bro.roomId, bro == null ? 0 : bro.ypH, 1);
            }
            AppMethodBeat.o(62620);
            return false;
        }
        int i2 = a.hqJ().yvK;
        long j2 = a.hqJ().HgX;
        boolean aY = a.hqJ().aY(str, 1, 100);
        b.w("TalkRoomSdkApi", "exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i2), " roomKey: ", Long.valueOf(j2));
        AppMethodBeat.o(62620);
        return aY;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final List<String> bpM(String str) {
        boolean z;
        AppMethodBeat.i(62621);
        if (!com.tencent.pb.common.c.f.nG(str, a.hqJ().xOr)) {
            b.w("TalkRoomSdkApi", "getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.hqJ().xOr);
            AppMethodBeat.o(62621);
            return null;
        }
        TalkRoom brg = c.hqY().brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
            AppMethodBeat.o(62621);
            return null;
        }
        List<d> hqQ = brg.hqQ();
        ArrayList arrayList = new ArrayList();
        for (d dVar : hqQ) {
            if (dVar != null) {
                f hqJ = a.hqJ();
                int memberId = dVar.getMemberId();
                if (hqJ.SuZ != null) {
                    b bVar = hqJ.SuZ;
                    z = (!com.tencent.pb.common.a.a.RCk || bVar.Suj == null) ? false : bVar.Suj.GetVoiceActivity(memberId) > 0;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(dVar.hra());
                }
            }
        }
        AppMethodBeat.o(62621);
        return arrayList;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final Map<String, Integer> bpN(String str) {
        AppMethodBeat.i(199673);
        if (!com.tencent.pb.common.c.f.nG(str, a.hqJ().xOr)) {
            b.w("TalkRoomSdkApi", "getTalkingEnergyMember groupid is not same; multiTalkGroupid: ", str, a.hqJ().xOr);
            AppMethodBeat.o(199673);
            return null;
        }
        TalkRoom brg = c.hqY().brg(str);
        if (brg == null) {
            b.w("TalkRoomManager", "getTalkingMember talkroom is null: groupId: ", str);
            AppMethodBeat.o(199673);
            return null;
        }
        List<d> hqQ = brg.hqQ();
        HashMap hashMap = new HashMap();
        for (d dVar : hqQ) {
            if (dVar != null) {
                f hqJ = a.hqJ();
                int memberId = dVar.getMemberId();
                Integer num = 0;
                if (hqJ.SuZ != null) {
                    b bVar = hqJ.SuZ;
                    if (!com.tencent.pb.common.a.a.RCk || bVar.Suj == null) {
                        num = 0;
                    } else {
                        num = Integer.valueOf(bVar.Suj.GetVoiceActivity(memberId));
                    }
                }
                int intValue = num.intValue();
                if (intValue > 0) {
                    hashMap.put(dVar.hra(), Integer.valueOf(intValue));
                }
            }
        }
        AppMethodBeat.o(199673);
        return hashMap;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean d(int i2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(62622);
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        b.w("TalkRoomSdkApi", objArr);
        if (i2 == 0) {
            com.tencent.pb.common.b.f.hiZ().u(i3, bArr);
        } else {
            com.tencent.pb.common.b.f hiZ = com.tencent.pb.common.b.f.hiZ();
            f.a aqt = hiZ.aqt(i3);
            if (aqt != null) {
                b.w("NETCMD", "CLTRCV FAIL", Integer.valueOf(i3), aqt.RCY, 1, Integer.valueOf(i2));
                hiZ.a(aqt, -1, (byte[]) null);
            }
        }
        AppMethodBeat.o(62622);
        return true;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean cR(byte[] bArr) {
        AppMethodBeat.i(62623);
        com.tencent.pb.common.b.f.hiZ();
        int cQ = com.tencent.pb.common.b.f.cQ(bArr);
        b.w("TalkRoomSdkApi", "handleMultiTalkNotify ret: ", Integer.valueOf(cQ));
        if (cQ == 0) {
            AppMethodBeat.o(62623);
            return true;
        }
        AppMethodBeat.o(62623);
        return false;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean DM(boolean z) {
        AppMethodBeat.i(62624);
        b.w("TalkRoomSdkApi", "holadMultiTalk isHold", Boolean.valueOf(z));
        if (z) {
            f hqJ = a.hqJ();
            b.d("TalkRoomService", "syscall", "startHoldOn");
            hqJ.Svu = true;
            hqJ.rt(false);
            com.tencent.pb.common.c.g.runOnMainThread(new Runnable() {
                /* class com.tencent.wecall.talkroom.model.g.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(62553);
                    synchronized (g.this.callbacks) {
                        try {
                            for (a aVar : g.this.callbacks) {
                                aVar.hrc();
                            }
                        } finally {
                            AppMethodBeat.o(62553);
                        }
                    }
                }
            });
        } else {
            f hqJ2 = a.hqJ();
            b.d("TalkRoomService", "syscall", "endHoldOn");
            hqJ2.Svu = false;
            hqJ2.hrh();
            if (hqJ2.fGt() && hqJ2.yIP) {
                hqJ2.rt(true);
                com.tencent.pb.common.c.g.runOnMainThread(new Runnable() {
                    /* class com.tencent.wecall.talkroom.model.g.AnonymousClass15 */

                    public final void run() {
                        AppMethodBeat.i(62584);
                        synchronized (g.this.callbacks) {
                            try {
                                for (a aVar : g.this.callbacks) {
                                    aVar.hrd();
                                }
                            } finally {
                                AppMethodBeat.o(62584);
                            }
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(62624);
        return true;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final void dr(int i2, String str) {
        AppMethodBeat.i(62626);
        com.tencent.pb.a.a.a.aqu(i2);
        com.tencent.pb.a.a.a.bpL(str);
        b.w("TalkRoomSdkApi", "setWxUinAndUsrName uin: ", Integer.valueOf(i2), " usrname: ", str);
        AppMethodBeat.o(62626);
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean aqv(int i2) {
        AppMethodBeat.i(62627);
        if (!a.hqJ().fGt()) {
            b.w("TalkRoomSdkApi", "switchMultiTalkVideo isWorking is false");
            AppMethodBeat.o(62627);
            return false;
        }
        b.d("TalkRoomSdkApi", "switchMultiTalkVideo action: ", Integer.valueOf(i2));
        f hqJ = a.hqJ();
        if (TextUtils.isEmpty(hqJ.xOr)) {
            b.w("TalkRoomService", "switchMultiTalkVideo mGroupId is null");
            AppMethodBeat.o(62627);
            return false;
        }
        hqJ.SuQ = i2;
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new n(hqJ.xOr, hqJ.yvK, hqJ.HgX, i2));
        b.d("TalkRoomService", "switchMultiTalkVideo ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(62627);
        return a2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean aGe(String str) {
        AppMethodBeat.i(62628);
        if (!a.hqJ().fGt()) {
            b.w("TalkRoomSdkApi", "subscribeLargeVideo isWorking is false");
            AppMethodBeat.o(62628);
            return false;
        }
        b.d("TalkRoomSdkApi", "subscribeLargeVideo ownerUserName: ", str);
        f hqJ = a.hqJ();
        if (TextUtils.isEmpty(hqJ.xOr)) {
            b.w("TalkRoomService", "subscribeLargeVideo mGroupId null ");
            AppMethodBeat.o(62628);
            return false;
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new l(hqJ.xOr, hqJ.yvK, hqJ.HgX, str));
        b.d("TalkRoomService", "subscribeLargeVideo ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(62628);
        return a2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean fB(List<a.ar> list) {
        AppMethodBeat.i(183716);
        if (!a.hqJ().fGt()) {
            b.w("TalkRoomSdkApi", "subscribeGeneralVideo isWorking is false");
            AppMethodBeat.o(183716);
            return false;
        }
        b.d("TalkRoomSdkApi", "subscribeGeneralVideo memberListInfo: ", list);
        f hqJ = a.hqJ();
        if (TextUtils.isEmpty(hqJ.xOr)) {
            b.w("TalkRoomService", "subscribeGeneralVideo mGroupId null ");
            AppMethodBeat.o(183716);
            return false;
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new k(hqJ.xOr, hqJ.yvK, hqJ.HgX, list));
        b.d("TalkRoomService", "subscribeGeneralVideo ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(183716);
        return a2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final boolean kc(List<a.aq> list) {
        AppMethodBeat.i(199674);
        if (!a.hqJ().fGt()) {
            b.w("TalkRoomSdkApi", "subscribeScreenSharingVideoForUserList isWorking is false");
            AppMethodBeat.o(199674);
            return false;
        }
        b.d("TalkRoomSdkApi", "subscribeScreenSharingVideoForUserList memberListInfo: ", list);
        f hqJ = a.hqJ();
        if (TextUtils.isEmpty(hqJ.xOr)) {
            b.w("TalkRoomService", "subscribeScreenSharingVideo mGroupId null ");
            AppMethodBeat.o(199674);
            return false;
        }
        boolean a2 = com.tencent.pb.common.b.e.hiW().a(new m(hqJ.xOr, hqJ.yvK, hqJ.HgX, list));
        b.d("TalkRoomService", "subscribeScreenSharingVideo ret: ", Boolean.valueOf(a2));
        AppMethodBeat.o(199674);
        return a2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final int c(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(199675);
        int c2 = a.hqJ().c(bArr, i2, i3, i4, i5, i6);
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i4);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i5);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i6);
        b.d("TalkRoomSdkApi", objArr);
        AppMethodBeat.o(199675);
        return c2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final com.tencent.pb.talkroom.sdk.f R(int[] iArr) {
        int i2 = 0;
        AppMethodBeat.i(62630);
        com.tencent.pb.talkroom.sdk.f R = a.hqJ().R(iArr);
        Object[] objArr = new Object[4];
        objArr[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i2 = iArr.length;
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " MultiTalkVideoDecodeInfo: ";
        objArr[3] = R;
        b.d("TalkRoomSdkApi", objArr);
        AppMethodBeat.o(62630);
        return R;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final int d(byte[] bArr, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(199676);
        Object[] objArr = new Object[10];
        objArr[0] = "sendScreen buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i4);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i5);
        b.i("TalkRoomSdkApi", objArr);
        int d2 = a.hqJ().d(bArr, i2, i3, i4, i5);
        Object[] objArr2 = new Object[12];
        objArr2[0] = "sendScreen buffer size: ";
        objArr2[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr2[2] = " len: ";
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = " w: ";
        objArr2[5] = Integer.valueOf(i3);
        objArr2[6] = " h: ";
        objArr2[7] = Integer.valueOf(i4);
        objArr2[8] = " format: ";
        objArr2[9] = Integer.valueOf(i5);
        objArr2[10] = " ret: ";
        objArr2[11] = Integer.valueOf(d2);
        b.i("TalkRoomSdkApi", objArr2);
        AppMethodBeat.o(199676);
        return d2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final com.tencent.pb.talkroom.sdk.f a(byte[] bArr, int[] iArr, int i2) {
        int i3 = 0;
        AppMethodBeat.i(199677);
        com.tencent.pb.talkroom.sdk.f a2 = a.hqJ().a(bArr, iArr, i2);
        Object[] objArr = new Object[4];
        objArr[0] = "receiveScreen imgBuffer size: ";
        if (bArr != null) {
            i3 = bArr.length;
        }
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = " MultiTalkVideoDecodeInfo: ";
        objArr[3] = a2;
        b.d("TalkRoomSdkApi", objArr);
        AppMethodBeat.o(199677);
        return a2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final com.tencent.pb.talkroom.sdk.g b(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = 0;
        AppMethodBeat.i(62631);
        com.tencent.pb.talkroom.sdk.g b2 = a.hqJ().b(bArr, i2, i3, i4, i5, iArr);
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " localImg size: ";
        if (iArr != null) {
            i6 = iArr.length;
        }
        objArr[5] = Integer.valueOf(i6);
        objArr[6] = Integer.valueOf(i3);
        objArr[7] = Integer.valueOf(i4);
        objArr[8] = Integer.valueOf(i5);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = b2;
        b.d("TalkRoomSdkApi", objArr);
        AppMethodBeat.o(62631);
        return b2;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final int screenTrans(byte[] bArr, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7) {
        AppMethodBeat.i(199678);
        int screenTrans = a.hqJ().screenTrans(bArr, i2, i3, i4, bArr2, i5, i6, i7);
        AppMethodBeat.o(199678);
        return screenTrans;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final int setAppCmd(int i2, byte[] bArr, int i3) {
        int i4 = -1;
        AppMethodBeat.i(62632);
        f hqJ = a.hqJ();
        if (hqJ.SuZ == null) {
            b.w("TalkRoomService", "setAppCmd type: ", Integer.valueOf(i2), " engine is null");
        } else {
            b bVar = hqJ.SuZ;
            if (bArr == null || bVar.Suj == null) {
                b.w("simon:TalkRoomContext", "steve:setAppCmd null, params:", bArr, ", engine:", bVar.Suj);
            } else {
                i4 = bVar.Suj.setAppCmd(i2, bArr, i3);
            }
        }
        b.d("TalkRoomSdkApi", "setAppCmd type: ", Integer.valueOf(i2), " paramLen: ", Integer.valueOf(i3), " ret: ", Integer.valueOf(i4));
        AppMethodBeat.o(62632);
        return i4;
    }

    @Override // com.tencent.pb.talkroom.sdk.d
    public final String hju() {
        AppMethodBeat.i(62625);
        String str = "client_" + com.tencent.pb.a.a.a.hjq() + "_" + System.currentTimeMillis();
        b.w("TalkRoomSdkApi", "genMultiTalkClientId clientId: ", str);
        AppMethodBeat.o(62625);
        return str;
    }
}
