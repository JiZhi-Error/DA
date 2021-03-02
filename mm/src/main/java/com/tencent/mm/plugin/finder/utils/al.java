package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J\u0010\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u000201J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010>\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u0006\u0010F\u001a\u00020\u0004J\u0006\u0010G\u001a\u00020\u0004J\u0016\u0010H\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u0004J\u0006\u0010M\u001a\u00020\u0004J\u0016\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020P2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004J\u0016\u0010S\u001a\u00020\u00042\u0006\u0010>\u001a\u00020T2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0004J\u0016\u0010W\u001a\u00020\u00042\u0006\u0010O\u001a\u00020P2\u0006\u0010I\u001a\u00020\u0004J\u000e\u0010X\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0004J\u0006\u0010Y\u001a\u00020\u0004J$\u0010Z\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010]\u001a\u0004\u0018\u00010\u0004J\u000e\u0010^\u001a\u00020\u00042\u0006\u0010>\u001a\u00020_J\u000e\u0010`\u001a\u00020\u00042\u0006\u0010>\u001a\u00020_J\u000e\u0010a\u001a\u00020\u00042\u0006\u0010>\u001a\u00020TJ\u000e\u0010b\u001a\u00020\u00042\u0006\u0010O\u001a\u00020PJ$\u0010b\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010]\u001a\u0004\u0018\u00010\u0004J\u0006\u0010c\u001a\u00020\u0004J\u000e\u0010c\u001a\u00020\u00042\u0006\u0010O\u001a\u00020PJ\u000e\u0010d\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020\u00042\u0006\u0010>\u001a\u00020AR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/PathRouter;", "", "()V", "finderAccDataPath", "", "finderAccPath", "getFinderAccPath", "()Ljava/lang/String;", "finderAvatarPath", "getFinderAvatarPath", "finderCapturePath", "getFinderCapturePath", "finderConstantsDataPath", "getFinderConstantsDataPath", "finderConstantsPath", "getFinderConstantsPath", "finderCoverImagePath", "getFinderCoverImagePath", "finderImgPath", "getFinderImgPath", "finderLivePath", "getFinderLivePath", "finderPostPath", "getFinderPostPath", "finderTmpPath", "getFinderTmpPath", "finderVideoPath", "getFinderVideoPath", "folderArray", "", "Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "getFolderArray", "()[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "[Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "checkToCreateDir", "", "path", "noMedia", "", "cleanFile", "dumpCacheDir", "genPostVideoTmpPath", ch.COL_USERNAME, "getAvatarFilePath", "avatar", "Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "getAvatarFileTmpPath", "getBgmExoTempPath", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getBgmTempPath", "getCaptureFilePath", "getConstantsDataPath", "getConstantsPath", "getCoverImageFilePath", "cover", "Lcom/tencent/mm/plugin/finder/loader/FinderCoverImage;", "getExifRotatedFilePath", "origFilePath", "getFeedAudioTackPath", "feedId", "getImageFilePath", "image", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getImageFileTmpPath", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "getLiveGiftPagPath", "pagFile", "Lcom/tencent/mm/plugin/finder/loader/FinderLivePag;", "getMyFinderAvatarTempPath", "getNormalFileTmpPath", "getNormalJpegTmpPath", "getPostImagePath", "suffix", "getPostImageThumbPath", "imagePath", "getPostMediaDir", "getPostMediaTmpDir", "getPostMediaTmpPath", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPostPath", DownloadInfo.FILENAME, "getPostVideoCoverPath", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "getPostVideoHalfThumbPath", "videoPath", "getPostVideoPath", "getPostVideoThumbPath", "getTmpTextImagePath", "getUniqueValue", "finderMediaType", "mediaId", "mediaUrl", "getUrlImageFilePath", "Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "getUrlImageTmpPath", "getVideoCoverFilePath", "getVideoFilePath", "getVideoFileTmpPath", "inPostDir", "makeImageFilePath", "plugin-finder_release"})
public final class al {
    private static final String waA = (waq + "live/");
    public static final i[] waB;
    public static final al waC = new al();
    private static String wap = "";
    private static final String waq;
    public static final String war = (dEx() + "image/");
    private static final String was = (dEx() + "avatar/");
    private static final String wat = (dEx() + "cover/");
    public static final String wau = (dEx() + "video/");
    private static final String wav = (dEx() + "tmp/");
    public static final String waw = (dEx() + "capture/");
    private static final String wax = (dEx() + "post/");
    private static final String way = (dEx() + "constants/");
    private static final String waz = (waq + "constants/");

    static {
        AppMethodBeat.i(167988);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        waq = sb.append(aAh.azM()).append("finder/").toString();
        String str = war;
        c cVar = c.vCb;
        String str2 = was;
        c cVar2 = c.vCb;
        String str3 = wat;
        c cVar3 = c.vCb;
        String str4 = wau;
        c cVar4 = c.vCb;
        String str5 = wav;
        c cVar5 = c.vCb;
        String str6 = waw;
        c cVar6 = c.vCb;
        String dEG = dEG();
        c cVar7 = c.vCb;
        i[] iVarArr = {new i(dEx(), "finderAccPath", 0L, true, false), new i(wax, "finderPostPath", 0L, true, false), new i(way, "finderConstantsPath", 0L, true, false), new i(str, "finderImgPath", c.drj(), false, 24), new i(str2, "finderAvatarPath", c.drk(), false, 24), new i(str3, "finderCoverImagePath", c.drl(), false, 24), new i(str4, "finderVideoPath", c.drm(), false, 24), new i(str5, "finderTmpPath", c.drn(), false, 24), new i(str6, "finderCapturePath", c.dro(), false, 24), new i(dEH(), "finderPostMediaDir", 0L, false, 8), new i(dEG, "finderPostMediaTmpDir", c.drp(), false, 24)};
        waB = iVarArr;
        for (int i2 = 0; i2 < 11; i2++) {
            iVarArr[i2].dBE();
        }
        Log.i("Finder.Loader", "finderAccPath:" + dEx() + " finderImgPath:" + war + " finderVideoPath:" + wau + " finderCapturePath:" + waw);
        AppMethodBeat.o(167988);
    }

    private al() {
    }

    public static String dEx() {
        AppMethodBeat.i(253804);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("finder/").toString();
        AppMethodBeat.o(253804);
        return sb2;
    }

    public static String dEy() {
        return war;
    }

    public static String dEz() {
        return wau;
    }

    public static String dEA() {
        return wav;
    }

    public static i[] dEB() {
        return waB;
    }

    public static String c(s sVar) {
        AppMethodBeat.i(253805);
        p.h(sVar, "video");
        String str = wau + sVar.auA();
        AppMethodBeat.o(253805);
        return str;
    }

    public static String am(String str, String str2, String str3) {
        AppMethodBeat.i(253806);
        String str4 = wau + an(str, str2, str3);
        AppMethodBeat.o(253806);
        return str4;
    }

    public static String an(String str, String str2, String str3) {
        AppMethodBeat.i(253807);
        StringBuilder append = new StringBuilder("finder_video_").append(str).append('_');
        if (Util.isNullOrNil(str2)) {
            if (str3 == null) {
                str3 = "";
            }
            str2 = MD5Util.getMD5String(str3);
        }
        String sb = append.append(str2).toString();
        AppMethodBeat.o(253807);
        return sb;
    }

    public static String a(com.tencent.mm.plugin.finder.loader.p pVar) {
        AppMethodBeat.i(167975);
        p.h(pVar, "image");
        String str = war + pVar.auA();
        AppMethodBeat.o(167975);
        return str;
    }

    public static String a(k kVar) {
        AppMethodBeat.i(253808);
        p.h(kVar, "image");
        String str = war + kVar.auA();
        AppMethodBeat.o(253808);
        return str;
    }

    public static String a(q qVar) {
        AppMethodBeat.i(253809);
        p.h(qVar, "image");
        String str = war + qVar.auA();
        AppMethodBeat.o(253809);
        return str;
    }

    public static String a(o oVar) {
        AppMethodBeat.i(167977);
        p.h(oVar, "image");
        String str = wav + oVar.auA();
        AppMethodBeat.o(167977);
        return str;
    }

    public static String dEC() {
        AppMethodBeat.i(167978);
        StringBuilder append = new StringBuilder().append(waw);
        String valueOf = String.valueOf(System.currentTimeMillis());
        Charset charset = d.UTF_8;
        if (valueOf == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(167978);
            throw tVar;
        }
        byte[] bytes = valueOf.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String sb = append.append(com.tencent.mm.b.g.getMessageDigest(bytes)).toString();
        AppMethodBeat.o(167978);
        return sb;
    }

    public static String a(a aVar) {
        AppMethodBeat.i(167979);
        p.h(aVar, "avatar");
        String str = was + aVar.uId;
        AppMethodBeat.o(167979);
        return str;
    }

    public static String a(com.tencent.mm.plugin.finder.loader.g gVar) {
        AppMethodBeat.i(167980);
        p.h(gVar, "cover");
        String str = wat + gVar.uId;
        AppMethodBeat.o(167980);
        return str;
    }

    public static String dED() {
        AppMethodBeat.i(253810);
        String str = wav + System.nanoTime() + ".jpg";
        AppMethodBeat.o(253810);
        return str;
    }

    public static String a(com.tencent.mm.plugin.finder.loader.l lVar) {
        AppMethodBeat.i(253811);
        p.h(lVar, "pagFile");
        String str = waA + lVar.auA() + ".pag";
        AppMethodBeat.o(253811);
        return str;
    }

    public static String awA(String str) {
        AppMethodBeat.i(167982);
        p.h(str, "origFilePath");
        String str2 = wav + MD5Util.getMD5String(str).toString() + "_" + com.tencent.mm.vfs.s.boX(str) + "_rotated";
        AppMethodBeat.o(167982);
        return str2;
    }

    public static String b(azk azk) {
        AppMethodBeat.i(253812);
        p.h(azk, "musicInfo");
        String str = wav + azk.wWb;
        AppMethodBeat.o(253812);
        return str;
    }

    public static String c(azk azk) {
        AppMethodBeat.i(253813);
        p.h(azk, "musicInfo");
        String str = wav + "/exo/" + azk.wWb;
        AppMethodBeat.o(253813);
        return str;
    }

    public static String awB(String str) {
        AppMethodBeat.i(253814);
        p.h(str, "feedId");
        String str2 = wax + str;
        AppMethodBeat.o(253814);
        return str2;
    }

    public static String a(s sVar, String str) {
        AppMethodBeat.i(253815);
        p.h(sVar, "video");
        p.h(str, "suffix");
        String str2 = dEH() + sVar.auA() + "_" + str;
        AppMethodBeat.o(253815);
        return str2;
    }

    public static String awC(String str) {
        AppMethodBeat.i(253816);
        p.h(str, DownloadInfo.FILENAME);
        String str2 = dEH() + str;
        AppMethodBeat.o(253816);
        return str2;
    }

    public static String dEE() {
        return way;
    }

    public static String dEF() {
        return waz;
    }

    public static String awD(String str) {
        AppMethodBeat.i(167984);
        p.h(str, "videoPath");
        String str2 = dEH() + "video_" + MD5Util.getMD5String(str) + "_" + com.tencent.mm.vfs.s.boX(str) + "_thumb";
        AppMethodBeat.o(167984);
        return str2;
    }

    public static String awE(String str) {
        AppMethodBeat.i(253817);
        p.h(str, "videoPath");
        String str2 = dEH() + "video_" + MD5Util.getMD5String(str) + "_" + com.tencent.mm.vfs.s.boX(str) + "_half_thumb";
        AppMethodBeat.o(253817);
        return str2;
    }

    public static String a(k kVar, String str) {
        AppMethodBeat.i(253818);
        p.h(kVar, "image");
        p.h(str, "suffix");
        String str2 = dEH() + kVar.auA() + "_" + str;
        AppMethodBeat.o(253818);
        return str2;
    }

    public static String a(q qVar, String str) {
        AppMethodBeat.i(253819);
        p.h(qVar, "image");
        p.h(str, "suffix");
        String str2 = dEH() + qVar.auA() + "_" + str;
        AppMethodBeat.o(253819);
        return str2;
    }

    public static String dEG() {
        AppMethodBeat.i(167985);
        String str = wax + "media_tmp/";
        AppMethodBeat.o(167985);
        return str;
    }

    public static String dEH() {
        AppMethodBeat.i(167986);
        String str = wax + "posting/";
        AppMethodBeat.o(167986);
        return str;
    }
}
