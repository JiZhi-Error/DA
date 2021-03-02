package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m {

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value = 0;

        public static b valueOf(String str) {
            AppMethodBeat.i(103429);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(103429);
            return bVar;
        }

        static {
            AppMethodBeat.i(103430);
            AppMethodBeat.o(103430);
        }

        private b(int i2) {
            this.value = i2;
        }
    }

    public static void x(g gVar) {
        AppMethodBeat.i(103437);
        if (gVar.field_favProto.ppH == null || gVar.field_favProto.ppH.isEmpty()) {
            AppMethodBeat.o(103437);
            return;
        }
        aml first = gVar.field_favProto.ppH.getFirst();
        amo amo = first.Lwn;
        if (amo == null) {
            AppMethodBeat.o(103437);
            return;
        }
        com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
        mVar.n("20source_publishid", amo.izg + ",");
        mVar.n("21uxinfo", amo.izf + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        mVar.n("24scene", "5,");
        mVar.n("25scene_chatname", ",");
        mVar.n("26scene_username", gVar.field_fromUser + ",");
        mVar.n("27curr_publishid", ",");
        mVar.n("28curr_msgid", "0,");
        mVar.n("29curr_favid", gVar.field_id + ",");
        mVar.n("30isdownload", "0,");
        mVar.n("31chatroom_membercount", "0,");
        ((j) g.af(j.class)).b(first.ean, mVar);
        Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + mVar.abW());
        h.INSTANCE.a(12989, mVar);
        AppMethodBeat.o(103437);
    }

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value = 0;

        public static a valueOf(String str) {
            AppMethodBeat.i(103426);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(103426);
            return aVar;
        }

        static {
            AppMethodBeat.i(103427);
            AppMethodBeat.o(103427);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static void a(a aVar, g gVar) {
        AppMethodBeat.i(103438);
        if (gVar.field_favProto.ppH == null || gVar.field_favProto.ppH.isEmpty()) {
            AppMethodBeat.o(103438);
            return;
        }
        amo amo = gVar.field_favProto.ppH.getFirst().Lwn;
        if (amo == null) {
            AppMethodBeat.o(103438);
            return;
        }
        com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
        mVar.n("20source_publishid", amo.izg + ",");
        mVar.n("21uxinfo", amo.izf + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23video_statu", ",");
        mVar.n("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        mVar.n("25scene", "5,");
        mVar.n("26action_type", aVar.value + ",");
        mVar.n("27scene_chatname", ",");
        mVar.n("28scene_username", gVar.field_fromUser + ",");
        mVar.n("29curr_publishid", ",");
        mVar.n("30curr_msgid", "0,");
        mVar.n("31curr_favid", gVar.field_id + ",");
        mVar.n("32elapsed_time", "0,");
        mVar.n("33load_time", "0,");
        mVar.n("34is_load_complete", "0,");
        mVar.n("35destination", "0,");
        mVar.n("36chatroom_membercount", "0,");
        Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + mVar.abW());
        ((com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class)).a(12990, mVar);
        AppMethodBeat.o(103438);
    }

    public enum c {
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value = 0;

        public static c valueOf(String str) {
            AppMethodBeat.i(103432);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(103432);
            return cVar;
        }

        static {
            AppMethodBeat.i(103433);
            AppMethodBeat.o(103433);
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
            AppMethodBeat.i(103435);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(103435);
            return dVar;
        }

        static {
            AppMethodBeat.i(103436);
            AppMethodBeat.o(103436);
        }

        private d(int i2) {
            this.value = i2;
        }
    }

    public static void a(c cVar, g gVar, d dVar, int i2) {
        AppMethodBeat.i(103439);
        if (gVar.field_favProto.ppH == null || gVar.field_favProto.ppH.isEmpty()) {
            AppMethodBeat.o(103439);
            return;
        }
        amo amo = gVar.field_favProto.ppH.getFirst().Lwn;
        if (amo == null) {
            AppMethodBeat.o(103439);
            return;
        }
        com.tencent.mm.modelsns.m mVar = new com.tencent.mm.modelsns.m();
        mVar.n("20source_publishid", amo.izg + ",");
        mVar.n("21uxinfo", amo.izf + ",");
        mVar.n("22clienttime", Util.nowMilliSecond() + ",");
        mVar.n("23video_statu", dVar.value + ",");
        mVar.n("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        mVar.n("25scene", "5,");
        mVar.n("26action_type", cVar.value + ",");
        mVar.n("27scene_chatname", ",");
        mVar.n("28scene_username", gVar.field_fromUser + ",");
        mVar.n("29curr_publishid", ",");
        mVar.n("30curr_msgid", "0,");
        mVar.n("31curr_favid", gVar.field_id + ",");
        mVar.n("32chatroom_membercount", "0,");
        mVar.n("33chatroom_toMemberCount", i2 + ",");
        Log.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + mVar.abW());
        h.INSTANCE.a(12991, mVar);
        AppMethodBeat.o(103439);
    }
}
