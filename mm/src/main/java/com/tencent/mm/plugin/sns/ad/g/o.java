package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class o {

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value = 0;

        public static b valueOf(String str) {
            AppMethodBeat.i(95047);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(95047);
            return bVar;
        }

        static {
            AppMethodBeat.i(95048);
            AppMethodBeat.o(95048);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7),
        DetailTimeline(8);
        
        private int value = 0;

        public static a valueOf(String str) {
            AppMethodBeat.i(95044);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(95044);
            return aVar;
        }

        static {
            AppMethodBeat.i(95045);
            AppMethodBeat.o(95045);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static void a(SnsInfo snsInfo, boolean z, boolean z2, int i2) {
        int i3;
        int i4;
        ADInfo adInfo;
        int i5 = 2;
        AppMethodBeat.i(95058);
        if (snsInfo == null) {
            AppMethodBeat.o(95058);
            return;
        }
        TimeLineObject timeLine = snsInfo.getTimeLine();
        LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
        if (linkedList != null && !linkedList.isEmpty() && ((timeLine.ContentObj.LoU == 15 && snsInfo.isAd()) || timeLine.ContentObj.LoU == 18)) {
            linkedList.get(0);
            if (snsInfo.isAd() && timeLine.ContentObj.LoU == 15) {
                if (i2 == 2) {
                    adInfo = snsInfo.getAtAdInfo();
                } else {
                    adInfo = snsInfo.getAdInfo();
                }
                timeLine.streamvideo.izf = adInfo.uxInfo;
                timeLine.streamvideo.izg = timeLine.Id;
            }
            m mVar = new m();
            mVar.n("20source_publishid", timeLine.streamvideo.izg + ",");
            mVar.n("21uxinfo", timeLine.streamvideo.izf + ",");
            mVar.n("22clienttime", Util.nowMilliSecond() + ",");
            StringBuilder sb = new StringBuilder();
            if (timeLine.ContentObj.LoU == 15) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mVar.n("23souce_type", sb.append(i3).append(",").toString());
            StringBuilder sb2 = new StringBuilder();
            if (z) {
                i5 = 6;
            } else if (timeLine.ContentObj.LoU == 15) {
                i5 = 1;
            }
            mVar.n("24scene", sb2.append(i5).append(",").toString());
            mVar.n("25scene_chatname", ",");
            mVar.n("26scene_username", timeLine.UserName + ",");
            mVar.n("27curr_publishid", timeLine.Id + ",");
            mVar.n("28curr_msgid", ",");
            mVar.n("29curr_favid", "0,");
            StringBuilder sb3 = new StringBuilder();
            if (z2) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            mVar.n("30isdownload", sb3.append(i4).append(",").toString());
            mVar.n("31chatroom_membercount", "0,");
            p.a(timeLine.statExtStr, mVar);
            Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + mVar.abW());
            h.INSTANCE.a(12989, mVar);
        }
        AppMethodBeat.o(95058);
    }

    public static void a(b bVar, a aVar, SnsInfo snsInfo, int i2) {
        ADInfo adInfo;
        int i3 = 2;
        AppMethodBeat.i(95059);
        if (snsInfo == null) {
            AppMethodBeat.o(95059);
            return;
        }
        TimeLineObject timeLine = snsInfo.getTimeLine();
        LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
        if (linkedList != null && !linkedList.isEmpty() && ((timeLine.ContentObj.LoU == 15 && snsInfo.isAd()) || timeLine.ContentObj.LoU == 18)) {
            linkedList.get(0);
            if (snsInfo.isAd() && timeLine.ContentObj.LoU == 15) {
                if (i2 == 2) {
                    adInfo = snsInfo.getAtAdInfo();
                } else {
                    adInfo = snsInfo.getAdInfo();
                }
                if (adInfo != null) {
                    timeLine.streamvideo.izf = adInfo.uxInfo;
                }
                timeLine.streamvideo.izg = timeLine.Id;
            }
            m mVar = new m();
            mVar.n("20source_publishid", timeLine.streamvideo.izg + ",");
            mVar.n("21uxinfo", timeLine.streamvideo.izf + ",");
            mVar.n("22clienttime", Util.nowMilliSecond() + ",");
            mVar.n("23video_statu", ",");
            StringBuilder sb = new StringBuilder();
            if (timeLine.ContentObj.LoU == 15) {
                i3 = 1;
            }
            mVar.n("24source_type", sb.append(i3).append(",").toString());
            mVar.n("25scene", bVar.value + ",");
            mVar.n("26action_type", aVar.value + ",");
            mVar.n("27scene_chatname", ",");
            mVar.n("28scene_username", timeLine.UserName + ",");
            mVar.n("29curr_publishid", timeLine.Id + ",");
            mVar.n("30curr_msgid", "0,");
            mVar.n("31curr_favid", "0,");
            mVar.n("32elapsed_time", "0,");
            mVar.n("33load_time", "0,");
            mVar.n("34is_load_complete", "0,");
            mVar.n("35destination", "0,");
            mVar.n("36chatroom_membercount", "0,");
            p.a(timeLine.statExtStr, mVar);
            Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + mVar.abW());
            ((com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class)).a(12990, mVar);
        }
        AppMethodBeat.o(95059);
    }

    public static void a(a aVar, String str, String str2, int i2, int i3, String str3, String str4, String str5, long j2, int i4, int i5) {
        AppMethodBeat.i(95060);
        m mVar = new m();
        mVar.n("20source_publishid", str + ",");
        mVar.n("21uxinfo", str2 + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23video_statu", ",");
        mVar.n("24source_type", i2 + ",");
        mVar.n("25scene", i3 + ",");
        mVar.n("26action_type", aVar.value + ",");
        mVar.n("27scene_chatname", str4 + ",");
        mVar.n("28scene_username", str3 + ",");
        mVar.n("29curr_publishid", str5 + ",");
        mVar.n("30curr_msgid", j2 + ",");
        mVar.n("31curr_favid", i4 + ",");
        mVar.n("32elapsed_time", "0,");
        mVar.n("33load_time", "0,");
        mVar.n("34is_load_complete", "0,");
        mVar.n("35destination", "0,");
        mVar.n("36chatroom_membercount", i5 + ",");
        j.a(str5, mVar);
        Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + mVar.abW());
        h.INSTANCE.a(12990, mVar);
        AppMethodBeat.o(95060);
    }

    public enum d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value = 0;

        public static d valueOf(String str) {
            AppMethodBeat.i(95053);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(95053);
            return dVar;
        }

        static {
            AppMethodBeat.i(95054);
            AppMethodBeat.o(95054);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        public int value = 0;

        public static c valueOf(String str) {
            AppMethodBeat.i(95050);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(95050);
            return cVar;
        }

        static {
            AppMethodBeat.i(95051);
            AppMethodBeat.o(95051);
        }

        private c(int i2) {
            this.value = i2;
        }
    }

    public enum e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value = 0;

        public static e valueOf(String str) {
            AppMethodBeat.i(95056);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(95056);
            return eVar;
        }

        static {
            AppMethodBeat.i(95057);
            AppMethodBeat.o(95057);
        }

        private e(int i2) {
            this.value = i2;
        }
    }

    public static void a(d dVar, c cVar, e eVar, int i2, SnsInfo snsInfo, int i3) {
        ADInfo adInfo;
        AppMethodBeat.i(95061);
        if (snsInfo == null) {
            AppMethodBeat.o(95061);
            return;
        }
        TimeLineObject timeLine = snsInfo.getTimeLine();
        LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
        if (linkedList != null && !linkedList.isEmpty() && ((timeLine.ContentObj.LoU == 15 && snsInfo.isAd()) || timeLine.ContentObj.LoU == 18)) {
            linkedList.get(0);
            if (snsInfo.isAd() && timeLine.ContentObj.LoU == 15) {
                if (i3 == 2) {
                    adInfo = snsInfo.getAtAdInfo();
                } else {
                    adInfo = snsInfo.getAdInfo();
                }
                if (adInfo != null) {
                    timeLine.streamvideo.izf = snsInfo.getAdInfo().uxInfo;
                }
                timeLine.streamvideo.izg = timeLine.Id;
            }
            m mVar = new m();
            mVar.n("20source_publishid", timeLine.streamvideo.izg + ",");
            mVar.n("21uxinfo", timeLine.streamvideo.izf + ",");
            mVar.n("22clienttime", Util.nowMilliSecond() + ",");
            mVar.n("23video_statu", eVar.value + ",");
            mVar.n("24source_type", (timeLine.ContentObj.LoU == 15 ? 1 : 2) + ",");
            mVar.n("25scene", dVar.value + ",");
            mVar.n("26action_type", cVar.value + ",");
            mVar.n("27scene_chatname", ",");
            mVar.n("28scene_username", timeLine.UserName + ",");
            mVar.n("29curr_publishid", timeLine.Id + ",");
            mVar.n("30curr_msgid", "0,");
            mVar.n("31curr_favid", "0,");
            mVar.n("32chatroom_membercount", "0,");
            mVar.n("33chatroom_toMemberCount", i2 + ",");
            p.a(timeLine.statExtStr, mVar);
            Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + mVar.abW());
            h.INSTANCE.a(12991, mVar);
        }
        AppMethodBeat.o(95061);
    }

    public static void a(c cVar, String str, String str2, int i2, int i3, String str3, String str4, String str5, long j2, int i4, int i5, int i6) {
        AppMethodBeat.i(95062);
        m mVar = new m();
        mVar.n("20source_publishid", str + ",");
        mVar.n("21uxinfo", str2 + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23video_statu", "3,");
        mVar.n("24source_type", i2 + ",");
        mVar.n("25scene", i3 + ",");
        mVar.n("26action_type", cVar.value + ",");
        mVar.n("27scene_chatname", str4 + ",");
        mVar.n("28scene_username", str3 + ",");
        mVar.n("29curr_publishid", str5 + ",");
        mVar.n("30curr_msgid", j2 + ",");
        mVar.n("31curr_favid", i4 + ",");
        mVar.n("32chatroom_membercount", i5 + ",");
        mVar.n("33chatroom_toMemberCount", i6 + ",");
        Log.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + mVar.abW());
        j.a(str5, mVar);
        h.INSTANCE.a(12991, mVar);
        AppMethodBeat.o(95062);
    }
}
