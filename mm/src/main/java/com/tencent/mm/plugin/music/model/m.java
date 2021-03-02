package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.plugin.music.h.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class m {
    private static HashMap<Long, Long> pMp = new HashMap<>();
    private static HashMap<Long, String> pMq = new HashMap<>();

    public static boolean a(a aVar) {
        AppMethodBeat.i(63014);
        Log.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl);
        if (!Util.isNullOrNil(aVar.field_songWapLinkUrl) || !Util.isNullOrNil(aVar.field_songWebUrl) || !Util.isNullOrNil(aVar.field_songWifiUrl)) {
            AppMethodBeat.o(63014);
            return true;
        }
        AppMethodBeat.o(63014);
        return false;
    }

    public static boolean iZ(String str, String str2) {
        AppMethodBeat.i(219837);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            AppMethodBeat.o(219837);
            return true;
        }
        AppMethodBeat.o(219837);
        return false;
    }

    public static void a(f fVar, Activity activity) {
        AppMethodBeat.i(63015);
        h.INSTANCE.kvStat(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(5);
        anh.MA(Util.nowMilliSecond());
        if (com.tencent.mm.pluginsdk.model.app.h.bdy(D(fVar))) {
            anh.bhl(D(fVar));
        }
        aml.bgm(fVar.jfb);
        aml.bgn(fVar.jfc);
        aml.bgl(fVar.jfd);
        a aHW = o.euD().aHW(b.S(fVar));
        if (aHW.euN()) {
            aml.bgo(aHW.field_songHAlbumUrl);
        } else {
            aml.bgo(aHW.field_songAlbumUrl);
        }
        aml.As(true);
        String C = C(fVar);
        if (s.YS(C)) {
            aml.bgu(C);
        } else {
            aml.At(true);
        }
        aml.bgf(fVar.jeX);
        aml.bgg(fVar.jeY);
        aml.ajd(7);
        aml.bgL(fVar.jfm);
        aml.bgM(fVar.jfe);
        czVar.dFZ.title = fVar.jeX;
        czVar.dFZ.desc = fVar.jeY;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 7;
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.activity = activity;
        czVar.dFZ.dGf = 3;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(63015);
    }

    public static void a(f fVar, axy axy, Activity activity, css css) {
        AppMethodBeat.i(219838);
        h.INSTANCE.kvStat(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        cz czVar = new cz();
        anb anb = new anb();
        anh anh = new anh();
        aml aml = new aml();
        amm amm = new amm();
        aml.bgf(axy.BPc);
        aml.bgM(axy.LIh);
        aml.bgL(axy.Djf);
        amm.e(css);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        anh.ajm(27);
        anh.MA(Util.nowMilliSecond());
        if (com.tencent.mm.pluginsdk.model.app.h.bdy(D(fVar))) {
            anh.bhl(D(fVar));
        }
        aml.bgm(fVar.jfb);
        aml.bgn(fVar.jfc);
        aml.bgl(fVar.jfd);
        a aHW = o.euD().aHW(b.S(fVar));
        if (aHW.euN()) {
            aml.bgo(aHW.field_songHAlbumUrl);
        } else {
            aml.bgo(aHW.field_songAlbumUrl);
        }
        aml.As(true);
        String C = C(fVar);
        if (s.YS(C)) {
            aml.bgu(C);
        } else {
            aml.At(true);
        }
        aml.bgf(fVar.jeX);
        aml.bgg(fVar.jeY);
        aml.ajd(29);
        aml.bgL(fVar.jfm);
        aml.bgM(fVar.jfe);
        amm.e(css);
        aml.a(amm);
        czVar.dFZ.title = fVar.jeX;
        czVar.dFZ.desc = fVar.jeY;
        czVar.dFZ.dGb = anb;
        czVar.dFZ.type = 21;
        anb.a(anh);
        anb.ppH.add(aml);
        czVar.dFZ.activity = activity;
        czVar.dFZ.dGf = 3;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(219838);
    }

    public static boolean b(f fVar, Activity activity) {
        AppMethodBeat.i(63016);
        h.INSTANCE.kvStat(10910, "4");
        if (fVar == null) {
            AppMethodBeat.o(63016);
            return false;
        }
        String str = fVar.jfd;
        String aIl = e.aIl(str);
        String aIk = e.aIk(str);
        String str2 = "";
        if (TextUtils.isEmpty(aIk) && TextUtils.isEmpty(aIl)) {
            Log.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", str);
            str2 = "qqmusic://qq.com/ui/pageVisibility";
        } else if (!TextUtils.isEmpty(aIk)) {
            Log.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", aIk);
            str2 = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + aIk + "%22%7D%5D%7D";
        } else if (TextUtils.isEmpty(aIl)) {
            str2 = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + aIl + "%22%7D%5D%7D";
        }
        Log.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", str2);
        Uri parse = Uri.parse(str2);
        if (parse == null) {
            Log.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", str2);
            AppMethodBeat.o(63016);
            return false;
        }
        com.tencent.mm.ay.a.bea();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (Util.isIntentAvailable(activity, intent)) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(63016);
            return true;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", str);
        c.b(activity, "webview", ".ui.tools.WebViewUI", intent2);
        AppMethodBeat.o(63016);
        return false;
    }

    public static void av(Activity activity) {
        AppMethodBeat.i(63017);
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("scene_from", 6);
        c.c(activity, ".ui.transmit.SelectConversationUI", intent, 1);
        AppMethodBeat.o(63017);
    }

    public static void a(f fVar, Intent intent, MMActivity mMActivity) {
        AppMethodBeat.i(219839);
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = fVar.jfd;
        wXMusicObject.musicDataUrl = fVar.jfb;
        wXMusicObject.musicLowBandUrl = fVar.jfc;
        wXMusicObject.musicLowBandDataUrl = fVar.jfc;
        wXMusicObject.songAlbumUrl = fVar.jfm;
        wXMusicObject.songLyric = fVar.jfe;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = fVar.jeX;
        wXMediaMessage.description = fVar.jeY;
        Bitmap bitmap = null;
        String C = C(fVar);
        if (C != null && s.YS(C)) {
            int dimension = (int) mMActivity.getResources().getDimension(R.dimen.ij);
            bitmap = BitmapUtil.getBitmapNative(C, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = Util.bmpToByteArray(bitmap, true);
        } else {
            wXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative((int) R.drawable.c5b), true);
        }
        String D = com.tencent.mm.pluginsdk.model.app.h.bdy(D(fVar)) ? D(fVar) : "";
        if (f.jRt != null) {
            f.jRt.a(mMActivity, D, wXMediaMessage, stringExtra, E(fVar));
        }
        Log.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", stringExtra);
        AppMethodBeat.o(219839);
    }

    public static void c(f fVar, Activity activity) {
        AppMethodBeat.i(63018);
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = fVar.jfd;
        wXMusicObject.musicDataUrl = fVar.jfb;
        wXMusicObject.musicLowBandUrl = fVar.jfc;
        wXMusicObject.musicLowBandDataUrl = fVar.jfc;
        wXMusicObject.songAlbumUrl = fVar.jfm;
        wXMusicObject.songLyric = fVar.jfe;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = fVar.jeX;
        wXMediaMessage.description = fVar.jeY;
        Bitmap bitmap = null;
        String C = C(fVar);
        if (C != null && s.YS(C)) {
            int dimension = (int) activity.getResources().getDimension(R.dimen.ij);
            bitmap = BitmapUtil.getBitmapNative(C, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = Util.bmpToByteArray(bitmap, true);
        } else {
            wXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative((int) R.drawable.c5b), true);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", fVar.jeV);
        String D = D(fVar);
        if (com.tencent.mm.pluginsdk.model.app.h.bdy(D)) {
            intent.putExtra("Ksnsupload_appid", D);
        }
        intent.putExtra("Ksnsupload_appname", E(fVar));
        String JX = ad.JX("music_player");
        ad.aVe().G(JX, true).l("prePublishId", "music_player");
        intent.putExtra("reportSessionId", JX);
        intent.putExtra("ksnsis_music", true);
        if (akQ(D)) {
            intent.putExtra("Ksnsupload_type", 25);
        } else {
            com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
            if (com.tencent.mm.plugin.comm.a.cAI()) {
                intent.putExtra("Ksnsupload_type", 26);
            } else {
                intent.putExtra("Ksnsupload_type", 2);
            }
        }
        c.a((MMActivity) activity, ".plugin.sns.ui.SnsUploadUI", intent, 1001, new MMActivity.a() {
            /* class com.tencent.mm.plugin.music.model.m.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
            }
        });
        AppMethodBeat.o(63018);
    }

    public static String C(f fVar) {
        AppMethodBeat.i(63019);
        String str = "";
        a aHW = o.euD().aHW(b.S(fVar));
        if (aHW == null) {
            AppMethodBeat.o(63019);
        } else {
            str = b.bV(aHW.field_musicId, true);
            if (!s.YS(str)) {
                switch (fVar.jeT) {
                    case 0:
                        str = q.bcR().R(fVar.jff, true);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 8:
                    case 9:
                    default:
                        if (o.DCN != null) {
                            cnb cnb = new cnb();
                            cnb.Id = fVar.jfl;
                            cnb.Msz = fVar.jfa;
                            cnb.MsA = fVar.jfj;
                            cnb.Url = cnb.Msz;
                            str = g.r(cnb);
                            break;
                        }
                        break;
                    case 4:
                        mw mwVar = new mw();
                        mwVar.dSw.action = 12;
                        mwVar.dSw.songAlbumUrl = fVar.jfa;
                        EventCenter.instance.publish(mwVar);
                        str = mwVar.dSx.dSD;
                        if (Util.isNullOrNil(str)) {
                            str = fVar.jff;
                        }
                        if (!s.YS(str)) {
                            str = b.bV(aHW.field_musicId, false);
                            break;
                        }
                        break;
                    case 5:
                        if (fVar.jff != null) {
                            str = fVar.jff;
                            break;
                        } else {
                            str = "";
                            break;
                        }
                    case 6:
                        if (fVar.jff != null) {
                            str = fVar.jff;
                            break;
                        } else {
                            str = "";
                            break;
                        }
                    case 7:
                    case 10:
                    case 11:
                        if (fVar.jff != null) {
                            str = fVar.jff;
                            break;
                        } else {
                            str = "";
                            break;
                        }
                }
            }
            Log.i("MicroMsg.Music.MusicUtil", "real album path = %s", str);
            AppMethodBeat.o(63019);
        }
        return str;
    }

    public static String D(f fVar) {
        AppMethodBeat.i(63020);
        String str = fVar.jfi;
        if (Util.isNullOrNil(str)) {
            switch (fVar.jeT) {
                case 4:
                    str = "wx485a97c844086dc9";
                    break;
                case 5:
                    str = "wx482a4001c37e2b74";
                    break;
            }
        }
        AppMethodBeat.o(63020);
        return str;
    }

    public static String E(f fVar) {
        AppMethodBeat.i(63021);
        switch (fVar.jeT) {
            case 0:
            case 1:
            case 8:
                String string = MMApplicationContext.getContext().getString(R.string.h8z);
                AppMethodBeat.o(63021);
                return string;
            case 2:
            case 3:
            case 6:
            case 7:
            default:
                String string2 = MMApplicationContext.getContext().getString(R.string.bl0);
                AppMethodBeat.o(63021);
                return string2;
            case 4:
                String string3 = MMApplicationContext.getContext().getString(R.string.gz4);
                AppMethodBeat.o(63021);
                return string3;
            case 5:
                String string4 = MMApplicationContext.getContext().getString(R.string.gcy);
                AppMethodBeat.o(63021);
                return string4;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void aw(Activity activity) {
        AppMethodBeat.i(219840);
        if (((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(82, Boolean.TRUE)).booleanValue()) {
            com.tencent.mm.kernel.g.aAh().azQ().set(82, Boolean.FALSE);
            switch (((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY().field_musicType) {
                case 0:
                    al(activity, R.string.gy4);
                    AppMethodBeat.o(219840);
                    return;
                case 1:
                case 8:
                    al(activity, R.string.gy7);
                    break;
                case 4:
                    al(activity, R.string.gy6);
                    AppMethodBeat.o(219840);
                    return;
                case 6:
                    al(activity, R.string.gy5);
                    AppMethodBeat.o(219840);
                    return;
            }
            AppMethodBeat.o(219840);
        } else if (((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2) {
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.hk2, 0).show();
            AppMethodBeat.o(219840);
        } else {
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.hk3, 0).show();
            AppMethodBeat.o(219840);
        }
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(219841);
        if (aVar == null) {
            AppMethodBeat.o(219841);
            return false;
        } else if (!TextUtils.isEmpty(aVar.field_songWifiUrl) || !TextUtils.isEmpty(aVar.field_songWapLinkUrl) || !TextUtils.isEmpty(aVar.field_songWebUrl)) {
            AppMethodBeat.o(219841);
            return true;
        } else {
            AppMethodBeat.o(219841);
            return false;
        }
    }

    public static void ag(String str, String str2, int i2) {
        AppMethodBeat.i(63022);
        Log.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", str, str2, Integer.valueOf(i2));
        wq wqVar = new wq();
        wqVar.ecI.appId = str;
        wqVar.ecI.appVersion = -1;
        wqVar.ecI.ecL = i2;
        wqVar.ecI.userName = str2;
        wqVar.ecI.scene = 1056;
        if (i2 == 1) {
            wqVar.ecI.ecP = true;
        }
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(63022);
    }

    private static d al(Context context, int i2) {
        AppMethodBeat.i(63023);
        d.a aVar = new d.a(context);
        aVar.aoO(R.string.zb);
        aVar.aoS(i2);
        aVar.aoV(R.string.j34).c((DialogInterface.OnClickListener) null);
        aVar.Dk(true);
        d hbn = aVar.hbn();
        hbn.show();
        AppMethodBeat.o(63023);
        return hbn;
    }

    public static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(63024);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.valueOf(str).intValue();
                    AppMethodBeat.o(63024);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("MicroMsg.Music.MusicUtil", e2, "getInt", new Object[0]);
                AppMethodBeat.o(63024);
            }
        }
        AppMethodBeat.o(63024);
        return i2;
    }

    static {
        AppMethodBeat.i(219848);
        AppMethodBeat.o(219848);
    }

    private static final void bj(Context context, String str) {
        AppMethodBeat.i(219842);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(219842);
    }

    public static final void bk(Context context, String str) {
        AppMethodBeat.i(219843);
        bj(context, String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s", 69, str));
        AppMethodBeat.o(219843);
    }

    public static final void F(Context context, String str, String str2) {
        AppMethodBeat.i(219844);
        bj(context, String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s&comment_ID=%s", 71, str, str2));
        AppMethodBeat.o(219844);
    }

    public static final boolean cAI() {
        AppMethodBeat.i(261718);
        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
        boolean cAI = com.tencent.mm.plugin.comm.a.cAI();
        AppMethodBeat.o(261718);
        return cAI;
    }

    public static final boolean akQ(String str) {
        AppMethodBeat.i(219846);
        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
        boolean akQ = com.tencent.mm.plugin.comm.a.akQ(str);
        AppMethodBeat.o(219846);
        return akQ;
    }

    public static final boolean cAJ() {
        AppMethodBeat.i(219847);
        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
        boolean cAJ = com.tencent.mm.plugin.comm.a.cAJ();
        AppMethodBeat.o(219847);
        return cAJ;
    }
}
