package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import com.tencent.mm.plugin.appbrand.jsapi.z.n;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.e;
import com.tencent.pb.common.c.f;
import java.util.ArrayList;

public class h {
    public static h Sws = new h();
    static final String TAG = h.class.getCanonicalName();
    public int HaK = 1;
    public int HaM = 0;
    public int HaN = 0;
    public int HaQ = 0;
    public int HaY = -1;
    int Hre = 0;
    int Hrh = 0;
    int Hrl = 0;
    long Hrm = 0;
    int Hrr = 0;
    public int Hrs = 0;
    private String Hrx = "";
    public String RDo = "";
    long SwA = 0;
    private int SwB;
    private int SwC = -1;
    private String SwD;
    private int SwE;
    private StringBuffer SwF = new StringBuffer();
    private long SwG = 0;
    long SwH = 0;
    long SwI = 0;
    public int Swt = 0;
    int Swu = 0;
    long Swv = 0;
    long Sww = 0;
    int Swx = 0;
    public int Swy = 0;
    int Swz = 0;
    private String deviceModel;
    public String groupId = "";
    public int netType = -1;
    public int qrD = -1;
    public int roomId = 0;
    public long ypH = 0;
    long yqS = 0;
    int yqT = 0;

    public h() {
        AppMethodBeat.i(62634);
        AppMethodBeat.o(62634);
    }

    static {
        AppMethodBeat.i(62655);
        AppMethodBeat.o(62655);
    }

    public final void reset() {
        AppMethodBeat.i(62635);
        b.d(TAG, "reset");
        this.SwI = 0;
        this.SwH = 0;
        this.SwG = 0;
        this.groupId = "";
        this.RDo = "";
        this.HaK = 1;
        this.roomId = 0;
        this.ypH = 0;
        this.qrD = -1;
        this.Hre = 0;
        this.Hrl = 0;
        this.Hrh = 0;
        this.yqT = 0;
        this.Swt = 0;
        this.Swu = 0;
        this.Swv = 0;
        this.Sww = 0;
        this.Swx = 0;
        this.Swy = 0;
        this.Swz = 0;
        this.SwA = 0;
        this.Hrm = 0;
        this.yqS = 0;
        this.Hrr = 0;
        this.Hrs = 0;
        this.netType = -1;
        this.SwB = 0;
        this.SwC = 0;
        this.SwD = "";
        this.deviceModel = "";
        this.SwE = -1;
        this.Hrx = "";
        this.SwF.setLength(0);
        this.HaY = -1;
        this.HaQ = 0;
        this.HaM = 0;
        this.HaN = 0;
        AppMethodBeat.o(62635);
    }

    public final String hru() {
        AppMethodBeat.i(62636);
        b.d(TAG, "collectInfo");
        this.SwD = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.SwE = Build.VERSION.SDK_INT;
        this.Hrx = Build.VERSION.RELEASE;
        this.netType = k.lx(c.Hhs);
        this.SwB = -1;
        this.SwC = -1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.RDo);
        arrayList.add(Integer.valueOf(this.HaK));
        arrayList.add(Integer.valueOf(this.roomId));
        arrayList.add(Long.valueOf(this.ypH));
        arrayList.add(Integer.valueOf(this.qrD));
        arrayList.add(Integer.valueOf(this.Hre));
        arrayList.add(Integer.valueOf(this.Hrl));
        arrayList.add(Integer.valueOf(this.Hrh));
        arrayList.add(Integer.valueOf(this.yqT));
        arrayList.add(Integer.valueOf(this.Swt));
        arrayList.add(Integer.valueOf(this.Swu));
        arrayList.add(Long.valueOf(this.Swv));
        arrayList.add(Long.valueOf(this.Sww));
        arrayList.add(Integer.valueOf(this.Swx));
        arrayList.add(Integer.valueOf(this.Swy));
        arrayList.add(Integer.valueOf(this.Swz));
        arrayList.add(Long.valueOf(this.SwA));
        arrayList.add(Long.valueOf(this.Hrm));
        arrayList.add(Long.valueOf(this.yqS));
        arrayList.add(Integer.valueOf(this.Hrr));
        arrayList.add(Integer.valueOf(this.Hrs));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.SwB));
        arrayList.add(Integer.valueOf(this.SwC));
        arrayList.add(this.SwD);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.SwE));
        arrayList.add(this.Hrx);
        arrayList.add(Integer.valueOf(c.hqY().brk(this.groupId)));
        arrayList.add(this.SwF.toString());
        arrayList.add(Integer.valueOf(this.HaY));
        arrayList.add(Integer.valueOf(this.HaQ));
        arrayList.add(Integer.valueOf(this.HaM));
        arrayList.add(Integer.valueOf(this.HaN));
        String a2 = f.a(arrayList, ",", "_");
        b.d(TAG, "logBuf: ", this.SwF.toString());
        b.d(TAG, "statresult", a2);
        AppMethodBeat.o(62636);
        return a2;
    }

    public static void a(String str, int i2, long j2, String... strArr) {
        AppMethodBeat.i(62637);
        if (TextUtils.isEmpty(str)) {
            b.w(TAG, "uploadTempReport groupId is null");
            AppMethodBeat.o(62637);
            return;
        }
        b.w(TAG, "uploadTempReport: ", str, Integer.valueOf(i2), Long.valueOf(j2));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.roomId = i2;
        hVar.ypH = j2;
        hVar.ag(strArr);
        brq(hVar.hru());
        AppMethodBeat.o(62637);
    }

    public static void a(String str, String str2, int i2, long j2, String... strArr) {
        AppMethodBeat.i(62638);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            b.w(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i2), Long.valueOf(j2));
            h hVar = new h();
            if (str == null) {
                str = "";
            }
            hVar.groupId = str;
            hVar.roomId = i2;
            hVar.ypH = j2;
            if (str2 == null) {
                str2 = "";
            }
            hVar.RDo = str2;
            hVar.ag(strArr);
            brq(hVar.hru());
            e.hjp();
            AppMethodBeat.o(62638);
            return;
        }
        b.w(TAG, "uploadTempReport groupId and clientGroupId is null");
        AppMethodBeat.o(62638);
    }

    public static void a(int i2, long j2, String... strArr) {
        AppMethodBeat.i(62639);
        h hVar = new h();
        hVar.groupId = "";
        hVar.roomId = i2;
        hVar.ypH = j2;
        hVar.RDo = "";
        hVar.ag(strArr);
        brq(hVar.hru());
        e.hjp();
        AppMethodBeat.o(62639);
    }

    public final void ag(String... strArr) {
        AppMethodBeat.i(62640);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(62640);
            return;
        }
        if (this.SwF.length() > 900) {
            this.SwF.setLength(0);
            this.SwF.append("overmaxsize");
        }
        if (this.SwF.length() != 0) {
            this.SwF.append("-");
        }
        for (String str : strArr) {
            this.SwF.append(str);
            this.SwF.append("|");
        }
        AppMethodBeat.o(62640);
    }

    public final void hrv() {
        AppMethodBeat.i(62641);
        this.SwG = System.currentTimeMillis();
        b.d(TAG, "beginCreateOrEnter", Long.valueOf(this.SwG));
        AppMethodBeat.o(62641);
    }

    public final void hrw() {
        AppMethodBeat.i(62642);
        b.d(TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.SwG), Long.valueOf(this.Swv));
        if (this.Swv > 0) {
            AppMethodBeat.o(62642);
            return;
        }
        this.Hrl = 1;
        if (this.SwG == 0) {
            this.Hrm = 0;
            AppMethodBeat.o(62642);
            return;
        }
        this.Hrm = System.currentTimeMillis() - this.SwG;
        AppMethodBeat.o(62642);
    }

    public final void hrx() {
        AppMethodBeat.i(62643);
        b.w(TAG, "beginCreateOrNotify");
        this.SwH = System.currentTimeMillis();
        AppMethodBeat.o(62643);
    }

    public final void hry() {
        AppMethodBeat.i(62644);
        b.d(TAG, "endAnswerTime", Long.valueOf(this.SwI));
        if (this.SwI == 0) {
            this.yqS = 0;
            AppMethodBeat.o(62644);
            return;
        }
        this.yqS = System.currentTimeMillis() - this.SwI;
        AppMethodBeat.o(62644);
    }

    public static void asK(int i2) {
        AppMethodBeat.i(62645);
        b.d(TAG, "sendNetSceneStat", Integer.valueOf(i2));
        e.U(JsApiGetABTestConfig.CTRL_INDEX, 3, String.valueOf(i2));
        AppMethodBeat.o(62645);
    }

    public static void asL(int i2) {
        AppMethodBeat.i(62646);
        b.d(TAG, "sendDeviceStat", Integer.valueOf(i2));
        e.U(528, 3, String.valueOf(i2));
        AppMethodBeat.o(62646);
    }

    public static void asM(int i2) {
        AppMethodBeat.i(62647);
        b.d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i2));
        e.U(530, 3, String.valueOf(i2));
        AppMethodBeat.o(62647);
    }

    public static void hrz() {
        AppMethodBeat.i(62648);
        b.d(TAG, "sendTalkRoomOnDialStat", -5001);
        e.U(531, 3, "-5001");
        AppMethodBeat.o(62648);
    }

    public static void asN(int i2) {
        AppMethodBeat.i(62649);
        b.d(TAG, "sendEngineStat", Integer.valueOf(i2));
        e.U(com.tencent.mm.plugin.appbrand.jsapi.o.f.CTRL_INDEX, 3, String.valueOf(i2));
        AppMethodBeat.o(62649);
    }

    public static void brq(String str) {
        AppMethodBeat.i(62650);
        b.d(TAG, "sendSummaryNetScene", str);
        e.U(com.tencent.mm.plugin.appbrand.jsapi.media.f.CTRL_INDEX, 3, str);
        AppMethodBeat.o(62650);
    }

    public static void brr(String str) {
        AppMethodBeat.i(62651);
        b.d(TAG, "sendEngineRecv", str);
        e.U(an.CTRL_INDEX, 3, str);
        AppMethodBeat.o(62651);
    }

    public static void brs(String str) {
        AppMethodBeat.i(62652);
        b.d(TAG, "sendEngineSend", str);
        e.U(r.CTRL_INDEX, 3, str);
        AppMethodBeat.o(62652);
    }

    public static void brt(String str) {
        AppMethodBeat.i(62653);
        b.d(TAG, "sendChannelStat", str);
        e.U(n.CTRL_INDEX, 3, str);
        AppMethodBeat.o(62653);
    }

    public final void asO(int i2) {
        AppMethodBeat.i(62654);
        b.d(TAG, "stopStatus", Integer.valueOf(i2));
        this.Hre = i2;
        AppMethodBeat.o(62654);
    }
}
