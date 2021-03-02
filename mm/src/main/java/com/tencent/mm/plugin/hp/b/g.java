package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.d;
import com.tencent.mm.plugin.hp.net.e;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements a {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, final String[] strArr, String str) {
        AppMethodBeat.i(117439);
        if (strArr.length < 2) {
            Log.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            AppMethodBeat.o(117439);
            return false;
        }
        String str2 = strArr[1];
        if (CrashReportFactory.hasDebuger()) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -838846263:
                    if (str2.equals("update")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -309518737:
                    if (str2.equals("process")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3510:
                    if (str2.equals("nd")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3083269:
                    if (str2.equals("diff")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3089570:
                    if (str2.equals("down")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3529469:
                    if (str2.equals("show")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 2067292548:
                    if (str2.equals("showall")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Log.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    new LinkedList();
                    LinkedList<cxu> dZe = e.dZe();
                    StringBuilder sb = new StringBuilder();
                    Iterator<cxu> it = dZe.iterator();
                    while (it.hasNext()) {
                        cxu next = it.next();
                        sb.append(next.key).append(":").append(next.value).append("\n");
                    }
                    Log.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", "tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", sb.toString());
                    com.tencent.mm.kernel.g.azz().a(new d("tinker_id_2468c5efe7670b901f7738f7a699d3843acc3651_arm64-v8a", "", dZe), 0);
                    AppMethodBeat.o(117439);
                    return true;
                case 1:
                    i.a(MMApplicationContext.getContext().getString(R.string.dgd), MMApplicationContext.getContext().getString(R.string.dgd), MMApplicationContext.getContext().getString(R.string.e3o), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.hp.b.g.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(117437);
                            Toast.makeText(MMApplicationContext.getContext(), "OK", 0).show();
                            AppMethodBeat.o(117437);
                        }
                    }, MMApplicationContext.getContext().getString(R.string.hsi), null);
                    AppMethodBeat.o(117439);
                    return true;
                case 2:
                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.hp.b.g.AnonymousClass2 */

                        public final void run() {
                            int i2;
                            AppMethodBeat.i(117438);
                            String str = b.aKJ() + "/Download/2017-07-28_19-43-39.apk";
                            String str2 = b.aKJ() + "/Download/39-50-diff.apk";
                            String str3 = b.aKJ() + "/Download/new_50.apk";
                            String str4 = "ab099f75f740be5d88e178d662a36779";
                            if (strArr.length >= 3 && !Util.isNullOrNil(strArr[2])) {
                                str = strArr[2];
                            }
                            if (strArr.length >= 4 && !Util.isNullOrNil(strArr[3])) {
                                str2 = strArr[3];
                            }
                            if (strArr.length >= 5 && !Util.isNullOrNil(strArr[4])) {
                                str3 = strArr[4];
                            }
                            if (strArr.length >= 6 && !Util.isNullOrNil(strArr[5])) {
                                str4 = strArr[5];
                            }
                            if (!s.YS(str3)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                i2 = com.tencent.mm.plugin.hp.a.b.a(str, str2, str3, str4);
                                Log.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk use :%d retCode：%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(i2));
                            } else {
                                i2 = 0;
                            }
                            if (i2 == 0) {
                                Log.i("MicroMsg.Tinker.TinkerBootsCommand", "show dialog for install");
                                Log.i("MicroMsg.Tinker.TinkerBootsCommand", "New Apk md5:%s", s.bhK(str3));
                                com.tencent.mm.plugin.hp.d.d.aZ(MMApplicationContext.getContext(), str3);
                                Log.i("MicroMsg.Tinker.TinkerBootsCommand", "md5 is equal.");
                                AppMethodBeat.o(117438);
                                return;
                            }
                            Log.i("MicroMsg.Tinker.TinkerBootsCommand", "merge apk failed.");
                            AppMethodBeat.o(117438);
                        }
                    });
                    AppMethodBeat.o(117439);
                    return true;
                case 3:
                    cxz cxz = new cxz();
                    cxz.MCU = 1000;
                    cxz.MCR = 2;
                    cxz.MCS = 2;
                    cxz.state = 2;
                    cxz.APx = "android_tinker_id_123123131231231";
                    doy doy = new doy();
                    doy.MD5 = "c3282ad2467fad9561227bc9b5b6712c";
                    doy.FileSize = 118617;
                    doy.Url = HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1g) + "/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
                    cxz.MCR = 3;
                    doy.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
                    doy.FileSize = 33338711;
                    doy.Url = HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1g) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    cxz.MCT = doy;
                    new e(new com.tencent.mm.plugin.hp.d.b(cxz)).qk(false);
                    AppMethodBeat.o(117439);
                    return true;
                case 4:
                    if (strArr.length >= 6) {
                        Util.safeParseLong(strArr[5]);
                    }
                    AppMethodBeat.o(117439);
                    return true;
                case 5:
                    h.aV(MMApplicationContext.getContext(), "");
                    h.aY(MMApplicationContext.getContext(), "");
                    h.aj(MMApplicationContext.getContext(), 0);
                    MMApplicationContext.getContext();
                    com.tencent.mm.plugin.hp.d.d.dZA();
                    AppMethodBeat.o(117439);
                    return true;
                case 6:
                    cxz cxz2 = new cxz();
                    cxz2.MCU = 1000;
                    cxz2.MCR = 3;
                    cxz2.MCS = 2;
                    cxz2.state = 2;
                    cxz2.APx = "android_tinker_id_123123131231231";
                    doy doy2 = new doy();
                    doy2.MD5 = "3ba62fdbd98df2bdf5da7d726010d867";
                    doy2.FileSize = 33338711;
                    doy2.Url = HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1g) + "/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    cxz2.MCT = doy2;
                    cxx cxx = new cxx();
                    cxx.key = "clientVersion";
                    cxx.value = "0x26060510";
                    cxz2.MCV.add(cxx);
                    cxx cxx2 = new cxx();
                    cxx2.key = "alphaTitle";
                    cxx2.value = "叫你更新你就更新";
                    cxz2.MCV.add(cxx2);
                    cxx cxx3 = new cxx();
                    cxx3.key = "alphaContent";
                    cxx3.value = "这个包可以抢到的红包最大，抢红包速度最快。";
                    cxz2.MCV.add(cxx3);
                    cxx cxx4 = new cxx();
                    cxx4.key = "alphaUrl";
                    cxx4.value = "www.qq.com";
                    cxz2.MCV.add(cxx4);
                    new e(new com.tencent.mm.plugin.hp.d.b(cxz2)).qk(true);
                    AppMethodBeat.o(117439);
                    return true;
                case 7:
                    dZc();
                    AppMethodBeat.o(117439);
                    return true;
                default:
                    Log.d("MicroMsg.Tinker.TinkerBootsCommand", "%s i not a debugger command.", str2);
                    break;
            }
        }
        char c3 = 65535;
        switch (str2.hashCode()) {
            case 94627080:
                if (str2.equals("check")) {
                    c3 = 0;
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
                try {
                    com.tinkerboots.sdk.a.hvX().Ey(true);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e2, "", new Object[0]);
                }
                AppMethodBeat.o(117439);
                return true;
            default:
                Log.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str2);
                AppMethodBeat.o(117439);
                return false;
        }
    }

    private static void dZc() {
        AppMethodBeat.i(117440);
        List<com.tencent.mm.plugin.boots.a.a> ckR = ((c) com.tencent.mm.kernel.g.af(c.class)).ckR();
        if (!ckR.isEmpty()) {
            Log.e("MicroMsg.Tinker.TinkerBootsCommand", "start day active keys");
            for (com.tencent.mm.plugin.boots.a.a aVar : ckR) {
                Log.i("MicroMsg.Tinker.TinkerBootsCommand", "key:%s active:%d", Integer.toHexString(aVar.field_key), Integer.valueOf(aVar.field_dau));
            }
        }
        AppMethodBeat.o(117440);
    }

    public static void dZd() {
        AppMethodBeat.i(196774);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.hp.b.g.AnonymousClass3 */

            /* renamed from: com.tencent.mm.plugin.hp.b.g$3$a */
            class a implements SimpleHttpLogic.TaskCallback {
                a() {
                }

                @Override // com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback
                public final void onCompleted(int i2, int i3, byte[] bArr) {
                    AppMethodBeat.i(196772);
                    Log.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(bArr.length));
                    try {
                        PByteArray pByteArray = new PByteArray();
                        boolean unpackResponse = SimpleHttpLogic.unpackResponse(bArr, pByteArray);
                        Log.e("simple", "unpack result ".concat(String.valueOf(unpackResponse)));
                        if (unpackResponse) {
                            cxw cxw = new cxw();
                            cxw.parseFrom(pByteArray.value);
                            if (!(cxw.BaseResponse == null || cxw.MCI == null || cxw.APx == null)) {
                                Log.e("simple", "response is " + cxw.BaseResponse.Ret + " error msg " + cxw.BaseResponse.ErrMsg);
                                Log.e("simple", "response base id is " + cxw.MCI + " error msg " + cxw.APx);
                            }
                        }
                        AppMethodBeat.o(196772);
                    } catch (Exception e2) {
                        Log.e("simple", "unpack failed. " + e2.getLocalizedMessage());
                        AppMethodBeat.o(196772);
                    }
                }
            }

            public final void run() {
                AppMethodBeat.i(196773);
                SimpleHttpLogic.Request request = new SimpleHttpLogic.Request();
                request.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
                request.host = "short.weixin.qq.com";
                cxv cxv = new cxv();
                cxv.MCI = "tinker_id_834582c31727099da72312e81eb61c550d05bdfa_arm64-v8a-Test";
                cxu cxu = new cxu();
                cxu.key = "";
                cxu.value = "";
                cxv.MCJ.add(cxu);
                cxv.APx = "";
                PByteArray pByteArray = new PByteArray();
                try {
                    Log.i("simple", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(cxv.toByteArray(), pByteArray))));
                } catch (Exception e2) {
                    Log.e("simple", "pack failed " + e2.getLocalizedMessage());
                }
                try {
                    request.body = pByteArray.value;
                } catch (Exception e3) {
                    Log.e("simple", e3.getLocalizedMessage());
                }
                SimpleHttpLogic.startRequest(request, new a(), "101.227.131.113");
                AppMethodBeat.o(196773);
            }
        });
        AppMethodBeat.o(196774);
    }
}
