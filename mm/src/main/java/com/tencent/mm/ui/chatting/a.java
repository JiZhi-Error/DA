package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class a {

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value = 0;

        public static b valueOf(String str) {
            AppMethodBeat.i(34102);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(34102);
            return bVar;
        }

        static {
            AppMethodBeat.i(34103);
            AppMethodBeat.o(34103);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a$a  reason: collision with other inner class name */
    public enum EnumC2087a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value = 0;

        public static EnumC2087a valueOf(String str) {
            AppMethodBeat.i(34099);
            EnumC2087a aVar = (EnumC2087a) Enum.valueOf(EnumC2087a.class, str);
            AppMethodBeat.o(34099);
            return aVar;
        }

        static {
            AppMethodBeat.i(34100);
            AppMethodBeat.o(34100);
        }

        private EnumC2087a(int i2) {
            this.value = i2;
        }
    }

    public static void a(EnumC2087a aVar, ca caVar) {
        AppMethodBeat.i(34110);
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(caVar, pString, pString2)) {
            a(aVar, caVar, pString.value, pString2.value);
        }
        AppMethodBeat.o(34110);
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value = 0;

        public static c valueOf(String str) {
            AppMethodBeat.i(34105);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(34105);
            return cVar;
        }

        static {
            AppMethodBeat.i(34106);
            AppMethodBeat.o(34106);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value = 0;

        public static d valueOf(String str) {
            AppMethodBeat.i(34108);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(34108);
            return dVar;
        }

        static {
            AppMethodBeat.i(34109);
            AppMethodBeat.o(34109);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    public static void a(c cVar, d dVar, ca caVar, int i2) {
        String Ks;
        int i3;
        AppMethodBeat.i(34112);
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(caVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = caVar.field_talker;
            boolean Iw = ab.Iw(str3);
            if (caVar.field_isSend == 1) {
                Ks = z.aTY();
            } else {
                Ks = Iw ? bp.Ks(caVar.field_content) : str3;
            }
            m mVar = new m();
            mVar.n("20source_publishid", str + ",");
            mVar.n("21uxinfo", str2 + ",");
            mVar.n("22clienttime", Util.nowMilliSecond() + ",");
            mVar.n("23video_statu", dVar.value + ",");
            mVar.n("24source_type", (caVar.getType() == 62 ? 1 : 2) + ",");
            mVar.n("25scene", (Iw ? 4 : 3) + ",");
            mVar.n("26action_type", cVar.value + ",");
            mVar.n("27scene_chatname", str3 + ",");
            mVar.n("28scene_username", Ks + ",");
            mVar.n("29curr_publishid", ",");
            mVar.n("30curr_msgid", caVar.field_msgSvrId + ",");
            mVar.n("31curr_favid", "0,");
            StringBuilder sb = new StringBuilder();
            if (Iw) {
                i3 = v.Ie(str3);
            } else {
                i3 = 0;
            }
            mVar.n("32chatroom_membercount", sb.append(i3).append(",").toString());
            mVar.n("33chatroom_toMemberCount", i2 + ",");
            Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + mVar.abW());
            h.INSTANCE.a(12991, mVar);
        }
        AppMethodBeat.o(34112);
    }

    public static boolean a(ca caVar, PString pString, PString pString2) {
        AppMethodBeat.i(34113);
        if (caVar.getType() == 62) {
            s QN = u.QN(caVar.field_imgPath);
            if (QN == null) {
                AppMethodBeat.o(34113);
                return false;
            }
            eeq eeq = QN.jsw;
            if (eeq == null || Util.isNullOrNil(eeq.izf)) {
                AppMethodBeat.o(34113);
                return false;
            }
            pString.value = eeq.izg;
            pString2.value = eeq.izf;
            AppMethodBeat.o(34113);
            return true;
        } else if (caVar.getType() == 49) {
            boolean Eq = ab.Eq(caVar.field_talker);
            String str = caVar.field_content;
            if (Eq && caVar.field_content != null && caVar.field_isSend == 0) {
                str = bp.Kt(caVar.field_content);
            }
            k.b HD = k.b.HD(str);
            if (HD == null || HD.type != 4 || Util.isNullOrNil(HD.iyZ)) {
                AppMethodBeat.o(34113);
                return false;
            }
            pString.value = HD.izg;
            pString2.value = HD.izf;
            AppMethodBeat.o(34113);
            return true;
        } else {
            AppMethodBeat.o(34113);
            return false;
        }
    }

    public static void a(EnumC2087a aVar, ca caVar, String str, String str2) {
        String Ks;
        AppMethodBeat.i(34111);
        String str3 = caVar.field_talker;
        boolean Iw = ab.Iw(str3);
        if (caVar.field_isSend == 1) {
            Ks = z.aTY();
        } else {
            Ks = Iw ? bp.Ks(caVar.field_content) : str3;
        }
        m mVar = new m();
        mVar.n("20source_publishid", str + ",");
        mVar.n("21uxinfo", str2 + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23video_statu", ",");
        mVar.n("24source_type", (caVar.getType() == 62 ? 1 : 2) + ",");
        mVar.n("25scene", (Iw ? 4 : 3) + ",");
        mVar.n("26action_type", aVar.value + ",");
        mVar.n("27scene_chatname", str3 + ",");
        mVar.n("28scene_username", Ks + ",");
        mVar.n("29curr_publishid", ",");
        mVar.n("30curr_msgid", caVar.field_msgSvrId + ",");
        mVar.n("31curr_favid", "0,");
        mVar.n("32elapsed_time", "0,");
        mVar.n("33load_time", "0,");
        mVar.n("34is_load_complete", "0,");
        mVar.n("35destination", "0,");
        mVar.n("36chatroom_membercount", (Iw ? v.Ie(str3) : 0) + ",");
        Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + mVar.abW());
        ((com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class)).a(12990, mVar);
        AppMethodBeat.o(34111);
    }
}
