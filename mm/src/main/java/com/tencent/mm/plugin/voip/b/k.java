package com.tencent.mm.plugin.voip.b;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class k {
    private static Map<Integer, String> Hhq;

    static {
        AppMethodBeat.i(115526);
        HashMap hashMap = new HashMap();
        Hhq = hashMap;
        hashMap.put(0, "CALLING_STATE_VIDEO_INVITING");
        Hhq.put(1, "CALLING_STATE_VOICE_INVITING");
        Hhq.put(2, "CALLING_STATE_VIDEO_WAITTING_ACCEPT");
        Hhq.put(3, "CALLING_STATE_VOICE_WAITTING_ACCEPT");
        Hhq.put(4, "CALLING_STATE_VIDEO_CONNECTING");
        Hhq.put(5, "CALLING_STATE_VOICE_CONNECTING");
        Hhq.put(6, "CALLING_STATE_VIDEO_TALKING");
        Hhq.put(7, "CALLING_STATE_VOICE_TALKING");
        Hhq.put(8, "CALLING_STATE_FINISH");
        Hhq.put(256, "CALLED_STATE_VIDEO_INVITING");
        Hhq.put(Integer.valueOf((int) CdnLogic.kAppTypeFestivalImage), "CALLED_STATE_VOICE_INVITING");
        Hhq.put(Integer.valueOf((int) CdnLogic.kAppTypeFestivalVideo), "CALLED_STATE_VIDEO_CONNECTING");
        Hhq.put(259, "CALLED_STATE_VOICE_CONNECTING");
        Hhq.put(260, "CALLED_STATE_VIDEO_TALKING");
        Hhq.put(261, "CALLED_STATE_VOICE_TALKING");
        Hhq.put(262, "CALLED_STATE_FINISH");
        Hhq.put(4096, "ACTION_NOP");
        Hhq.put(4097, "ACTION_INVITE_RESPOND");
        Hhq.put(4098, "ACTION_CANCEL_INVITE");
        Hhq.put(4099, "ACTION_REJECT_INVITE");
        Hhq.put(4100, "ACTION_ACCEPT_INVITE");
        Hhq.put(4101, "ACTION_CLOSE_CAMERA");
        Hhq.put(4102, "ACTION_CONNECT_SUCC");
        Hhq.put(4103, "ACTION_SELF_HANGUP");
        Hhq.put(4104, "ACTION_ANOTHER_HANGUP");
        Hhq.put(4105, "ACTION_INVITE_TIMEOUT");
        Hhq.put(4106, "ACTION_SO_SHUTDOWN");
        Hhq.put(4107, "ACTION_PHONE_COMING");
        Hhq.put(4108, "ACTION_IGNORE_INVITE");
        Hhq.put(4109, "ACTION_ON_ERROR");
        Hhq.put(4110, "ACTION_SESSION_CALLED");
        AppMethodBeat.o(115526);
    }

    public static String adM(int i2) {
        AppMethodBeat.i(115523);
        if (Hhq.containsKey(Integer.valueOf(i2))) {
            String str = Hhq.get(Integer.valueOf(i2));
            AppMethodBeat.o(115523);
            return str;
        }
        AppMethodBeat.o(115523);
        return "no found value";
    }

    public static l adN(int i2) {
        AppMethodBeat.i(115524);
        l lVar = new l(i2);
        lVar.aD(256, 4098, 262);
        lVar.aD(256, 4099, 262);
        lVar.aD(256, 4105, 262);
        lVar.aD(256, 4106, 262);
        lVar.aD(256, 4107, 262);
        lVar.aD(256, 4108, 262);
        lVar.aD(256, 4109, 262);
        lVar.aD(256, 4100, CdnLogic.kAppTypeFestivalVideo);
        lVar.aD(256, 4101, CdnLogic.kAppTypeFestivalImage);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4100, 259);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4098, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4099, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4105, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4106, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4107, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4108, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalImage, 4109, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4098, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4106, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4107, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4103, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4109, 262);
        lVar.aD(CdnLogic.kAppTypeFestivalVideo, 4102, 260);
        lVar.aD(259, 4102, 261);
        lVar.aD(259, 4098, 262);
        lVar.aD(259, 4106, 262);
        lVar.aD(259, 4107, 262);
        lVar.aD(259, 4103, 262);
        lVar.aD(259, 4109, 262);
        lVar.aD(260, 4101, 261);
        lVar.aD(260, 4103, 262);
        lVar.aD(260, 4104, 262);
        lVar.aD(260, 4106, 262);
        lVar.aD(260, 4107, 262);
        lVar.aD(260, 4109, 262);
        lVar.aD(261, 4103, 262);
        lVar.aD(261, 4104, 262);
        lVar.aD(261, 4106, 262);
        lVar.aD(261, 4107, 262);
        lVar.aD(261, 4109, 262);
        AppMethodBeat.o(115524);
        return lVar;
    }

    public static l adO(int i2) {
        AppMethodBeat.i(115525);
        l lVar = new l(i2);
        lVar.aD(0, 4098, 8);
        lVar.aD(0, 4106, 8);
        lVar.aD(0, 4107, 8);
        lVar.aD(0, 4109, 8);
        lVar.aD(0, 4097, 2);
        lVar.aD(0, 4101, 1);
        lVar.aD(1, 4097, 3);
        lVar.aD(1, 4098, 8);
        lVar.aD(1, 4106, 8);
        lVar.aD(1, 4107, 8);
        lVar.aD(1, 4109, 8);
        lVar.aD(2, 4098, 8);
        lVar.aD(2, 4099, 8);
        lVar.aD(2, 4105, 8);
        lVar.aD(2, 4106, 8);
        lVar.aD(2, 4107, 8);
        lVar.aD(2, 4109, 8);
        lVar.aD(2, 4100, 4);
        lVar.aD(2, 4101, 3);
        lVar.aD(3, 4100, 5);
        lVar.aD(3, 4098, 8);
        lVar.aD(3, 4099, 8);
        lVar.aD(3, 4105, 8);
        lVar.aD(3, 4106, 8);
        lVar.aD(3, 4107, 8);
        lVar.aD(3, 4109, 8);
        lVar.aD(4, 4102, 6);
        lVar.aD(4, 4101, 5);
        lVar.aD(5, 4102, 7);
        lVar.aD(6, 4103, 8);
        lVar.aD(6, 4104, 8);
        lVar.aD(6, 4106, 8);
        lVar.aD(6, 4107, 8);
        lVar.aD(6, 4109, 8);
        lVar.aD(6, 4101, 7);
        lVar.aD(7, 4103, 8);
        lVar.aD(7, 4104, 8);
        lVar.aD(7, 4106, 8);
        lVar.aD(7, 4107, 8);
        lVar.aD(7, 4109, 8);
        lVar.aD(4, 4098, 8);
        lVar.aD(4, 4099, 8);
        lVar.aD(4, 4106, 8);
        lVar.aD(4, 4107, 8);
        lVar.aD(4, 4103, 8);
        lVar.aD(4, 4109, 8);
        lVar.aD(5, 4098, 8);
        lVar.aD(5, 4099, 8);
        lVar.aD(5, 4106, 8);
        lVar.aD(5, 4107, 8);
        lVar.aD(5, 4103, 8);
        lVar.aD(5, 4109, 8);
        lVar.aD(0, 4110, 4);
        lVar.aD(1, 4110, 5);
        AppMethodBeat.o(115525);
        return lVar;
    }

    public static boolean adP(int i2) {
        return 260 == i2 || 261 == i2 || 6 == i2 || 7 == i2;
    }

    public static boolean adQ(int i2) {
        return i2 == 0 || 2 == i2 || 4 == i2 || 6 == i2 || 256 == i2 || 258 == i2 || 260 == i2;
    }

    public static boolean adR(int i2) {
        return 1 == i2 || i2 == 0 || 2 == i2 || 3 == i2;
    }

    public static int aQ(boolean z, boolean z2) {
        if (true == z && true == z2) {
            return 0;
        }
        if (true == z && !z2) {
            return 1;
        }
        if (z || true != z2) {
            return CdnLogic.kAppTypeFestivalImage;
        }
        return 256;
    }

    public static boolean adS(int i2) {
        return i2 == 256 || i2 == 257;
    }
}
