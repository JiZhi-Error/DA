package com.tencent.mm.plugin.textstatus.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/jump/MusicPlayerJumper;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "Companion", "plugin-textstatus_release"})
public final class d implements b {
    public static final a FXZ = new a((byte) 0);

    static {
        AppMethodBeat.i(216127);
        AppMethodBeat.o(216127);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/jump/MusicPlayerJumper$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.c.b
    public final boolean F(String str, List<? extends r> list) {
        boolean z;
        String str2;
        String str3;
        String str4;
        Integer buA;
        Long buB;
        AppMethodBeat.i(258382);
        p.h(str, "textStatusID");
        p.h(list, "jumpInfos");
        boolean z2 = false;
        for (T t : list) {
            if (p.j(t.GaO, "1")) {
                Map<String, String> parseXml = XmlParser.parseXml(t.GaQ, "MusicVideoStatusOpenParams", null);
                if (parseXml != null) {
                    try {
                        axy axy = new axy();
                        String concat = ".".concat(String.valueOf("MusicVideoStatusOpenParams"));
                        p.h(axy, "$this$parseFromXml");
                        p.h(concat, "prefix");
                        p.h(parseXml, "values");
                        try {
                            String str5 = concat + ".FinderMVSongInfo";
                            String str6 = parseXml.get(str5 + ".songName");
                            if (str6 == null) {
                                str6 = "";
                            }
                            axy.BPc = str6;
                            String str7 = parseXml.get(str5 + ".singer");
                            if (str7 == null) {
                                str7 = "";
                            }
                            axy.lDR = str7;
                            String str8 = parseXml.get(str5 + ".musicDataUrl");
                            if (str8 == null) {
                                str8 = "";
                            }
                            axy.musicDataUrl = str8;
                            String str9 = parseXml.get(str5 + ".musicAppId");
                            if (str9 == null) {
                                str9 = "";
                            }
                            axy.LIf = str9;
                            String str10 = parseXml.get(str5 + ".musicWebUrl");
                            if (str10 == null) {
                                str10 = "";
                            }
                            axy.LIg = str10;
                            String str11 = parseXml.get(str5 + ".songId");
                            if (str11 == null) {
                                str11 = "";
                            }
                            axy.AqO = str11;
                            String str12 = parseXml.get(str5 + ".lyric");
                            if (str12 == null) {
                                str12 = "";
                            }
                            axy.LIh = str12;
                            String str13 = parseXml.get(str5 + ".albumName");
                            if (str13 == null) {
                                str13 = "";
                            }
                            axy.albumName = str13;
                            String str14 = parseXml.get(str5 + ".albumUrl");
                            if (str14 == null) {
                                str14 = "";
                            }
                            axy.Djf = str14;
                            String str15 = parseXml.get(str5 + ".genre");
                            if (str15 == null) {
                                str15 = "";
                            }
                            axy.LIi = str15;
                            String str16 = parseXml.get(str5 + ".publicTime");
                            if (str16 == null) {
                                str16 = "";
                            }
                            axy.LIj = str16;
                            String str17 = parseXml.get(str5 + ".publicTimeS");
                            axy.LIk = (str17 == null || (buB = n.buB(str17)) == null) ? 0 : buB.longValue();
                            String str18 = parseXml.get(str5 + ".extraInfo");
                            if (str18 == null) {
                                str18 = "";
                            }
                            axy.extraInfo = str18;
                            String str19 = parseXml.get(str5 + ".identification");
                            if (str19 == null) {
                                str19 = "";
                            }
                            axy.identification = str19;
                            String str20 = parseXml.get(str5 + ".duration");
                            axy.duration = (str20 == null || (buA = n.buA(str20)) == null) ? 0 : buA.intValue();
                        } catch (Exception e2) {
                            Log.e("FinderMVSongInfo", "parse FinderMVSongInfo from xml fail:" + e2.getLocalizedMessage());
                        }
                        css C = ak.C(".".concat(String.valueOf("MusicVideoStatusOpenParams")), parseXml);
                        Log.i("MusicPlayerJumper", "alvinluo jumpToMv ext: %s, %s, identification: %s, %s, xml: %s", axy.extraInfo, C.extraInfo, axy.identification, C.identification, t.GaQ);
                        String str21 = C.Ktp;
                        if (!(str21 == null || str21.length() == 0)) {
                            String str22 = C.Ktp;
                            p.g(str22, "musicShareObject.mvCoverUrl");
                            str2 = str22;
                        } else {
                            String str23 = axy.Djf;
                            str2 = str23 == null ? "" : str23;
                        }
                        ac acVar = ac.vER;
                        String str24 = axy.AqO;
                        if (str24 == null) {
                            str24 = String.valueOf(System.currentTimeMillis());
                        }
                        ac.a(axy, str24, 0, str2);
                        Intent intent = new Intent();
                        String str25 = C.Ktn;
                        if (str25 == null) {
                            str3 = "";
                        } else {
                            str3 = str25;
                        }
                        String str26 = C.Kto;
                        if (str26 == null) {
                            str4 = "";
                        } else {
                            str4 = str26;
                        }
                        String str27 = C.Ktq;
                        if (str27 == null) {
                            str27 = "";
                        }
                        intent.putExtra("key_mv_feed_id", str3);
                        intent.putExtra("key_mv_nonce_id", str4);
                        intent.putExtra("key_mv_cover_url", str2);
                        intent.putExtra("key_mv_poster", str27);
                        intent.putExtra("key_mv_song_name", axy.BPc);
                        intent.putExtra("key_mv_song_lyric", axy.LIh);
                        intent.putExtra("key_mv_singer_name", axy.lDR);
                        intent.putExtra("key_mv_album_name", axy.albumName);
                        intent.putExtra("key_mv_music_genre", axy.LIi);
                        intent.putExtra("key_mv_issue_date", String.valueOf(axy.LIk));
                        intent.putExtra("key_mv_album_cover_url", axy.Djf);
                        intent.putExtra("key_mv_identification", axy.identification);
                        intent.putExtra("key_mv_extra_info", axy.extraInfo);
                        intent.putExtra("key_mv_music_duration", axy.duration);
                        intent.putExtra("key_need_update_music_ball_url", true);
                        cst cst = new cst();
                        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                        cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                        cst.MxJ = str;
                        cst.scene = 6;
                        intent.putExtra("key_mv_report_data", cst.toByteArray());
                        intent.setFlags(268435456);
                        c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", intent);
                    } catch (Exception e3) {
                        Log.e("MusicPlayerJumper", "process TextStatusJumpInfo fail:" + e3.getLocalizedMessage());
                    }
                }
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        AppMethodBeat.o(258382);
        return z2;
    }
}
