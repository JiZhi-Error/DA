package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.offline.PluginFavOffline;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.o;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    private static int[] tnn = {R.id.axp, R.id.axq, R.id.axr, R.id.axs, R.id.axt};

    static /* synthetic */ boolean b(Context context, aml aml) {
        AppMethodBeat.i(231716);
        boolean a2 = a(context, aml, true);
        AppMethodBeat.o(231716);
        return a2;
    }

    static /* synthetic */ void f(Context context, g gVar, and and) {
        AppMethodBeat.i(24598);
        c(context, gVar, false, and);
        AppMethodBeat.o(24598);
    }

    static /* synthetic */ void g(Context context, g gVar, and and) {
        AppMethodBeat.i(24599);
        d(context, gVar, false, and);
        AppMethodBeat.o(24599);
    }

    static /* synthetic */ void h(Context context, g gVar, and and) {
        AppMethodBeat.i(24600);
        a(context, gVar, false, and);
        AppMethodBeat.o(24600);
    }

    static /* synthetic */ void i(Context context, g gVar, and and) {
        AppMethodBeat.i(24602);
        b(context, gVar, false, and);
        AppMethodBeat.o(24602);
    }

    public static void b(Context context, g gVar, and and) {
        String z;
        css css;
        String str;
        String z2;
        String str2;
        String displayName;
        long j2;
        AppMethodBeat.i(24581);
        if (context == null) {
            Log.w("MicroMsg.FavItemLogic", "Context is null");
            AppMethodBeat.o(24581);
        } else if (gVar == null) {
            Log.w("MicroMsg.FavItemLogic", "Fav item is null");
            AppMethodBeat.o(24581);
        } else {
            Log.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type));
            switch (gVar.field_type) {
                case -2:
                    Toast.makeText(context, (int) R.string.ccy, 0).show();
                    AppMethodBeat.o(24581);
                    return;
                case -1:
                case 0:
                case 9:
                case 13:
                case 19:
                case 20:
                default:
                    Log.w("MicroMsg.FavItemLogic", "Do not match any type %d", Integer.valueOf(gVar.field_type));
                    break;
                case 1:
                    Intent intent = new Intent();
                    intent.putExtra("key_detail_text", gVar.field_favProto.desc);
                    intent.putExtra("key_detail_info_id", gVar.field_localId);
                    intent.putExtra("key_detail_can_share_to_friend", gVar.cUu());
                    intent.putExtra("key_detail_time", gVar.field_updateTime);
                    if (gVar.field_sourceCreateTime <= 0) {
                        j2 = gVar.field_updateTime;
                    } else {
                        j2 = gVar.field_sourceCreateTime;
                    }
                    intent.putExtra("key_detail_create_time", j2);
                    a(and, intent);
                    i.gF("FavoriteTextDetailUI", and.sessionId);
                    b.b(context, ".ui.detail.FavoriteTextDetailUI", intent);
                    AppMethodBeat.o(24581);
                    return;
                case 2:
                    e(context, gVar, and);
                    AppMethodBeat.o(24581);
                    return;
                case 3:
                    Intent intent2 = new Intent();
                    a(gVar, and, intent2);
                    intent2.putExtra("key_detail_create_time", gVar.field_favProto.Lya.createTime);
                    i.gF("FavoriteVoiceDetailUI", and.sessionId);
                    b.b(context, ".ui.detail.FavoriteVoiceDetailUI", intent2);
                    AppMethodBeat.o(24581);
                    return;
                case 4:
                    d(context, gVar, and);
                    AppMethodBeat.o(24581);
                    return;
                case 5:
                    d(context, gVar, true, and);
                    AppMethodBeat.o(24581);
                    return;
                case 6:
                    if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(context)) {
                        AppMethodBeat.o(24581);
                        return;
                    }
                    ams ams = gVar.field_favProto.LwQ;
                    String str3 = gVar.field_favProto.remark;
                    anh anh = gVar.field_favProto.Lya;
                    if (anh == null || Util.isNullOrNil(anh.LxA)) {
                        displayName = aa.getDisplayName(gVar.field_fromUser);
                    } else {
                        displayName = aa.getDisplayName(anh.LxA);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (gVar.field_tagProto.Lyo != null) {
                        arrayList.addAll(gVar.field_tagProto.Lyo);
                    }
                    i.gF("RedirectUI", and.sessionId);
                    b.a(gVar.field_localId, ams, displayName, str3, arrayList, context);
                    AppMethodBeat.o(24581);
                    return;
                case 7:
                    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(context)) {
                        AppMethodBeat.o(24581);
                        return;
                    }
                    anh anh2 = gVar.field_favProto.Lya;
                    aml c2 = b.c(gVar);
                    o oVar = new o(b.a(c2));
                    if (oVar.exists()) {
                        z2 = com.tencent.mm.vfs.aa.z(oVar.her());
                    } else if (c2.dFN == null) {
                        z2 = "";
                    } else {
                        o oVar2 = new o(b.cUf() + com.tencent.mm.b.g.getMessageDigest(c2.dFN.getBytes()));
                        if (oVar2.exists()) {
                            str2 = com.tencent.mm.vfs.aa.z(oVar2.her());
                        } else {
                            str2 = "";
                        }
                        z2 = str2;
                    }
                    f a2 = com.tencent.mm.ay.i.a(6, null, c2.title, c2.desc, c2.Lvu, c2.Lvy, c2.Lvw, c2.dLl, b.cUl(), z2, "", anh2.appId);
                    a2.jfm = c2.songAlbumUrl;
                    a2.jfe = c2.songLyric;
                    a2.jfw = c2.dLl;
                    if (!b.f(c2)) {
                        Log.i("MicroMsg.FavItemLogic", " start play music");
                        a.c(a2);
                    } else {
                        Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
                    }
                    a2.jft = String.valueOf(gVar.field_localId);
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_scene", 2);
                    intent3.setFlags(268435456);
                    c.b(context, "music", ".ui.MusicMainUI", intent3);
                    AppMethodBeat.o(24581);
                    return;
                case 8:
                    c(context, gVar, true, and);
                    AppMethodBeat.o(24581);
                    return;
                case 10:
                    Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    long j3 = gVar.field_localId;
                    String str4 = gVar.field_favProto.LwU.info;
                    Intent intent4 = new Intent();
                    intent4.putExtra("key_is_favorite_item", true);
                    intent4.putExtra("key_favorite_local_id", j3);
                    intent4.putExtra("key_Product_xml", str4);
                    intent4.putExtra("key_can_delete_favorite_item", true);
                    intent4.putExtra("key_ProductUI_getProductInfoScene", 3);
                    c.b(context, "scanner", ".ui.ProductUI", intent4);
                    AppMethodBeat.o(24581);
                    return;
                case 11:
                    Log.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    Intent intent5 = new Intent();
                    intent5.putExtra("key_product_scene", 4);
                    intent5.putExtra("key_product_info", gVar.field_favProto.LwU.info);
                    c.b(context, "product", ".ui.MallProductUI", intent5);
                    AppMethodBeat.o(24581);
                    return;
                case 12:
                case 15:
                    Log.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                    long j4 = gVar.field_localId;
                    String str5 = gVar.field_favProto.LwW.info;
                    Intent intent6 = new Intent();
                    intent6.putExtra("key_TV_getProductInfoScene", 3);
                    intent6.putExtra("key_is_favorite_item", true);
                    intent6.putExtra("key_favorite_local_id", j4);
                    intent6.putExtra("key_TV_xml", str5);
                    intent6.putExtra("key_can_delete_favorite_item", true);
                    c.b(context, "shake", ".ui.TVInfoUI", intent6);
                    AppMethodBeat.o(24581);
                    return;
                case 14:
                    a(context, gVar, true, and);
                    AppMethodBeat.o(24581);
                    return;
                case 16:
                    aml c3 = b.c(gVar);
                    if (c3 == null || c3.Lwn == null || (Util.isNullOrNil(c3.Lwn.iyZ) && Util.isNullOrNil(c3.Lwn.izd))) {
                        d(context, gVar, and);
                        AppMethodBeat.o(24581);
                        return;
                    }
                    Log.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    c(context, gVar, and);
                    AppMethodBeat.o(24581);
                    return;
                case 17:
                    String str6 = b.c(gVar).desc;
                    bg.aVF();
                    ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(str6);
                    if (aEK != null) {
                        if (!ab.IT(aEK.dkU) || WeChatBrands.Business.Entries.SessionOa.checkAvailable(context)) {
                            Intent intent7 = new Intent();
                            intent7.putExtra("Contact_User", aEK.dkU);
                            intent7.putExtra("Contact_Alias", aEK.fMb);
                            intent7.putExtra("Contact_Nick", aEK.nickname);
                            intent7.putExtra("Contact_QuanPin", aEK.kfR);
                            intent7.putExtra("Contact_PyInitial", aEK.kfQ);
                            intent7.putExtra("Contact_Uin", aEK.Bge);
                            intent7.putExtra("Contact_Mobile_MD5", aEK.OqK);
                            intent7.putExtra("Contact_full_Mobile_MD5", aEK.OqL);
                            intent7.putExtra("Contact_QQNick", aEK.gDZ());
                            intent7.putExtra("User_From_Fmessage", false);
                            intent7.putExtra("Contact_Scene", aEK.scene);
                            intent7.putExtra("Contact_FMessageCard", true);
                            intent7.putExtra("Contact_RemarkName", aEK.kfV);
                            intent7.putExtra("Contact_VUser_Info_Flag", aEK.IOs);
                            intent7.putExtra("Contact_VUser_Info", aEK.fuN);
                            intent7.putExtra("Contact_BrandIconURL", aEK.BdC);
                            intent7.putExtra("Contact_Province", aEK.getProvince());
                            intent7.putExtra("Contact_City", aEK.getCity());
                            intent7.putExtra("Contact_Sex", aEK.fuA);
                            intent7.putExtra("Contact_Signature", aEK.signature);
                            intent7.putExtra("Contact_ShowUserName", false);
                            intent7.putExtra("Contact_KSnsIFlag", 0);
                            i.gF("ContactInfoUI", and.sessionId);
                            c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent7);
                            com.tencent.mm.bs.a.aiT(aEK.scene);
                        }
                        AppMethodBeat.o(24581);
                        return;
                    }
                    break;
                case 18:
                    b(context, gVar, true, and);
                    AppMethodBeat.o(24581);
                    return;
                case 21:
                    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(context)) {
                        AppMethodBeat.o(24581);
                        return;
                    }
                    if (((aj) com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast()) {
                        anh anh3 = gVar.field_favProto.Lya;
                        aml c4 = b.c(gVar);
                        o oVar3 = new o(b.a(c4));
                        if (oVar3.exists()) {
                            z = com.tencent.mm.vfs.aa.z(oVar3.her());
                        } else if (c4.dFN == null) {
                            z = "";
                        } else {
                            o oVar4 = new o(b.cUf() + com.tencent.mm.b.g.getMessageDigest(c4.dFN.getBytes()));
                            if (oVar4.exists()) {
                                str = com.tencent.mm.vfs.aa.z(oVar4.her());
                            } else {
                                str = "";
                            }
                            z = str;
                        }
                        if (c4 == null || c4.Lwh == null) {
                            css = null;
                        } else {
                            css = c4.Lwh.Lxs;
                        }
                        f a3 = com.tencent.mm.ay.i.a(6, null, c4.title, c4.desc, c4.Lvu, c4.Lvy, c4.Lvw, c4.dLl, b.cUl(), z, "", anh3.appId, h.a(c4.dLl, css));
                        a3.jfm = c4.songAlbumUrl;
                        a3.jfe = c4.songLyric;
                        a3.jfw = c4.dLl;
                        if (!b.f(c4)) {
                            Log.i("MicroMsg.FavItemLogic", " start play music");
                            a.c(a3);
                        } else {
                            Log.i("MicroMsg.FavItemLogic", "The music is playing, stop music");
                        }
                        a3.jft = String.valueOf(gVar.field_localId);
                        Intent intent8 = new Intent();
                        intent8.putExtra("key_scene", 2);
                        intent8.setFlags(268435456);
                        if (css != null) {
                            intent8.putExtra("key_mv_feed_id", css.Ktn);
                            intent8.putExtra("key_mv_nonce_id", css.Kto);
                            intent8.putExtra("key_mv_cover_url", css.Ktp);
                            intent8.putExtra("key_mv_poster", css.Ktq);
                            intent8.putExtra("key_mv_song_name", c4.title);
                            intent8.putExtra("key_mv_song_lyric", c4.songLyric);
                            intent8.putExtra("key_mv_album_cover_url", c4.songAlbumUrl);
                            intent8.putExtra("key_mv_singer_name", css.singerName);
                            intent8.putExtra("key_mv_album_name", css.albumName);
                            intent8.putExtra("key_mv_music_genre", css.musicGenre);
                            intent8.putExtra("key_mv_issue_date", String.valueOf(css.issueDate));
                            intent8.putExtra("key_mv_identification", css.identification);
                            intent8.putExtra("key_mv_extra_info", css.extraInfo);
                            intent8.putExtra("key_mv_music_duration", css.Alz);
                            intent8.putExtra("key_mv_thumb_path", css.jfz);
                        }
                        SecDataUIC.a aVar = SecDataUIC.CWq;
                        cst cst = (cst) SecDataUIC.a.a(context, "MusicMvMainUI", 7, cst.class);
                        cst.scene = 9;
                        com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                        cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                        cst.MxI = 84;
                        cst.MxJ = c4.dLl;
                        c.b(context, "mv", ".ui.MusicMvMainUI", intent8);
                    }
                    AppMethodBeat.o(24581);
                    return;
            }
            AppMethodBeat.o(24581);
        }
    }

    private static void a(Context context, g gVar, boolean z, and and) {
        AppMethodBeat.i(24582);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("prePublishId", "msgrecord_detail");
        intent.putExtra("preChatTYPE", 15);
        a(and, intent);
        i.gF("FavRecordDetailUI", and.sessionId);
        c.b(context, "record", ".ui.FavRecordDetailUI", intent);
        AppMethodBeat.o(24582);
    }

    private static void b(Context context, g gVar, boolean z, and and) {
        boolean z2;
        AppMethodBeat.i(24583);
        Log.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        oc ocVar = new oc();
        ocVar.dUe.field_localId = gVar.field_localId;
        if (!Util.isNullOrNil(gVar.taf) && gVar.field_favProto != null && gVar.field_favProto.ppH != null && gVar.field_favProto.ppH.size() > 0) {
            Iterator<aml> it = gVar.field_favProto.ppH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else if (Util.isEqual(it.next().dLl, gVar.taf)) {
                    z2 = true;
                    break;
                } else {
                    ocVar.dUe.dUh++;
                }
            }
            Log.d("MicroMsg.FavItemLogic", "handleWNNoteItem include:%s position:%s", Boolean.valueOf(z2), Integer.valueOf(ocVar.dUe.dUh));
            if (!z2) {
                ocVar.dUe.dUh = 0;
            } else if (gVar.field_type == 18) {
                oc.a aVar = ocVar.dUe;
                aVar.dUh--;
            }
        }
        if (gVar.field_localId == -1) {
            ocVar.dUe.dUn = 4;
        } else {
            ocVar.dUe.dUg = gVar.field_xml;
        }
        ocVar.dUe.context = context;
        Bundle bundle = new Bundle();
        amv amv = gVar.field_favProto.KBr;
        if (amv != null) {
            bundle.putString("noteauthor", amv.LxT);
            bundle.putString("noteeditor", amv.LxU);
        }
        bundle.putLong("edittime", gVar.field_updateTime);
        ocVar.dUe.dUl = bundle;
        ocVar.dUe.field_favProto = gVar.field_favProto;
        ocVar.dUe.type = 2;
        ocVar.dUe.dUo = z;
        ocVar.dUe.dUp = and;
        EventCenter.instance.publish(ocVar);
        i.gF("NoteEditorUI", and.sessionId);
        AppMethodBeat.o(24583);
    }

    private static void c(Context context, g gVar, boolean z, and and) {
        String str;
        AppMethodBeat.i(24584);
        aml c2 = b.c(gVar);
        if (and != null && and.ecL == 1) {
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", gVar.field_localId);
            intent.putExtra("show_share", z);
            if (!Util.isNullOrNil(gVar.taf)) {
                intent.putExtra("key_detail_data_id", gVar.taf);
                intent.putExtra("key_detail_open_way", 2);
            } else {
                intent.putExtra("key_detail_open_way", 1);
            }
            a(and, intent);
            i.gF("FavoriteFileDetailUI", and.sessionId);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent);
            AppMethodBeat.o(24584);
        } else if (and == null || and.ecL != 2) {
            if (b.g(c2)) {
                if (b.h(c2)) {
                    e(context, gVar, and);
                    AppMethodBeat.o(24584);
                    return;
                }
                if (gVar != null) {
                    str = String.valueOf(gVar.field_id);
                } else {
                    str = null;
                }
                ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromFavItem(c2, str, null, b.d(c2)));
                if (!com.tencent.mm.pluginsdk.ui.tools.a.bl(b.d(c2), c2.LvC, c2.title)) {
                    AppMethodBeat.o(24584);
                    return;
                }
            }
            Intent intent2 = new Intent();
            intent2.putExtra("key_detail_info_id", gVar.field_localId);
            intent2.putExtra("key_detail_data_id", c2.dLl);
            intent2.putExtra("show_share", z);
            a(and, intent2);
            i.gF("FavoriteFileDetailUI", and.sessionId);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent2);
            AppMethodBeat.o(24584);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.c((Activity) context, b.d(c2), c2.LvC, 2);
            AppMethodBeat.o(24584);
        }
    }

    private static String J(g gVar) {
        AppMethodBeat.i(24585);
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(24585);
            return null;
        } else if (gVar.field_favProto.LwS == null || Util.isNullOrNil(gVar.field_favProto.LwS.canvasPageXml)) {
            LinkedList<aml> linkedList = gVar.field_favProto.ppH;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.o(24585);
                return null;
            }
            String str = linkedList.get(0).canvasPageXml;
            AppMethodBeat.o(24585);
            return str;
        } else {
            String str2 = gVar.field_favProto.LwS.canvasPageXml;
            AppMethodBeat.o(24585);
            return str2;
        }
    }

    private static String K(g gVar) {
        AppMethodBeat.i(24586);
        if (gVar.field_favProto == null) {
            AppMethodBeat.o(24586);
            return null;
        } else if (gVar.field_favProto.LwS == null || Util.isNullOrNil(gVar.field_favProto.LwS.thumbUrl)) {
            LinkedList<aml> linkedList = gVar.field_favProto.ppH;
            if (linkedList == null || linkedList.size() != 1) {
                AppMethodBeat.o(24586);
                return null;
            }
            String str = linkedList.get(0).iwX;
            AppMethodBeat.o(24586);
            return str;
        } else {
            String str2 = gVar.field_favProto.LwS.thumbUrl;
            AppMethodBeat.o(24586);
            return str2;
        }
    }

    private static void d(Context context, g gVar, boolean z, and and) {
        String str;
        String str2;
        AppMethodBeat.i(24587);
        if (gVar == null || gVar.field_favProto == null) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(gVar == null);
            Log.e("MicroMsg.FavItemLogic", "handleWebPageItem, null == favItemInfo(%b) || null == favItemInfo.field_favProto", objArr);
            AppMethodBeat.o(24587);
            return;
        }
        String J = J(gVar);
        if (!Util.isNullOrNil(J)) {
            Intent intent = new Intent();
            intent.putExtra("sns_landing_pages_xml", J);
            intent.putExtra("sns_landig_pages_from_source", 7);
            intent.putExtra("sns_landing_pages_share_thumb_url", K(gVar));
            intent.putExtra("sns_landing_favid", z.aTY() + "_" + gVar.field_id);
            intent.addFlags(268435456);
            c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
            AppMethodBeat.o(24587);
            return;
        }
        anq anq = gVar.field_favProto.LwS;
        if (anq == null || !anq.LyI || Util.isNullOrNil(anq.LyH)) {
            String str3 = "";
            String str4 = "";
            if (anq != null) {
                str3 = anq.LyC;
                str4 = anq.title;
                str = anq.desc;
            } else {
                str = "";
            }
            anh anh = gVar.field_favProto.Lya;
            if (anh != null && Util.isNullOrNil(str3)) {
                str3 = anh.link;
            }
            if (Util.isNullOrNil(str3)) {
                if (gVar.field_favProto.ppH.size() > 0) {
                    str2 = gVar.field_favProto.ppH.get(0).Lvu;
                } else {
                    str2 = null;
                }
                str3 = str2;
            }
            if (Util.isNullOrNil(str3)) {
                Log.w("MicroMsg.FavItemLogic", "go to web page error, url null, dataid[%s]", gVar.taf);
                AppMethodBeat.o(24587);
            } else if (((PluginFavOffline) com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).useOffline(str3, gVar.field_localId)) {
                Log.i("MicroMsg.FavItemLogic", "url(%s) use offline read!", str3);
                AppMethodBeat.o(24587);
            } else {
                ((PluginFavOffline) com.tencent.mm.kernel.g.ah(PluginFavOffline.class)).getFavOfflineService().ash(str3);
                aml c2 = b.c(gVar);
                if (c2 != null) {
                    if (Util.isNullOrNil(str4)) {
                        str4 = c2.title;
                    }
                    if (Util.isNullOrNil(str)) {
                        str = c2.desc;
                    }
                }
                Log.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("showShare", z);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", gVar.field_localId);
                intent2.putExtra("favorite_control_argument", gVar.cUw());
                intent2.putExtra("sentUsername", gVar.field_fromUser);
                intent2.putExtra("webpageTitle", str4);
                if (anh != null && !Util.isNullOrNil(anh.dCl)) {
                    intent2.putExtra("srcDisplayname", aa.getDisplayName(anh.dCl));
                }
                intent2.putExtra("mode", 1);
                intent2.putExtra("geta8key_scene", 14);
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", b.c(gVar).ean);
                bundle.putLong("favlocalid", gVar.field_localId);
                intent2.putExtra("jsapiargs", bundle);
                intent2.putExtra("from_scence", 4);
                String str5 = "fav_" + z.aTY() + "_" + gVar.field_id;
                intent2.putExtra("KPublisherId", str5);
                intent2.putExtra("pre_username", gVar.field_fromUser);
                intent2.putExtra("prePublishId", str5);
                intent2.putExtra("preChatTYPE", 14);
                intent2.putExtra("share_report_pre_msg_url", str3);
                intent2.putExtra("share_report_pre_msg_title", str4);
                intent2.putExtra("share_report_pre_msg_desc", str);
                intent2.putExtra("share_report_pre_msg_icon_url", K(gVar));
                intent2.putExtra("share_report_pre_msg_appid", "");
                intent2.putExtra("share_report_from_scene", 4);
                Bundle PV = com.tencent.mm.modelstat.a.c.PV(com.tencent.mm.pluginsdk.model.g.class.getName());
                PV.putInt("mm_rpt_fav_id", gVar.field_id);
                PV.putInt("key_detail_fav_scene", and.scene);
                PV.putInt("key_detail_fav_sub_scene", and.pHw);
                PV.putInt("key_detail_fav_index", and.index);
                PV.putString("key_detail_fav_query", and.query);
                PV.putString("key_detail_fav_sessionid", and.sessionId);
                PV.putString("key_detail_fav_tags", and.tay);
                i.gF("WebViewUI", and.sessionId);
                intent2.putExtra("mm_report_bundle", PV);
                intent2.putExtra("geta8key_scene", 14);
                intent2.putExtra("key_enable_teen_mode_check", true);
                if (gVar.field_favProto.IXu == null || gVar.field_favProto.IXu.iwe != 1 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(gVar.field_favProto.IXu.iwc)) {
                    c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                    AppMethodBeat.o(24587);
                    return;
                }
                a(context, gVar, and, intent2);
                AppMethodBeat.o(24587);
            }
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(anq.LyH, "websearch", null);
            if (parseXml == null) {
                Log.e("MicroMsg.FavItemLogic", "XmlParser.parseXml fail, values is null");
                AppMethodBeat.o(24587);
                return;
            }
            fat fat = new fat();
            fat.IEy = parseXml.get(".websearch.relevant_vid");
            fat.IEz = parseXml.get(".websearch.relevant_expand");
            fat.IEA = parseXml.get(".websearch.relevant_pre_searchid");
            fat.IEB = parseXml.get(".websearch.relevant_shared_openid");
            fat.IEC = (long) Util.getInt(parseXml.get(".websearch.rec_category"), -1);
            fat.rCq = parseXml.get(".websearch.shareUrl");
            fat.msN = parseXml.get(".websearch.shareTitle");
            fat.xDQ = parseXml.get(".websearch.shareDesc");
            fat.IED = parseXml.get(".websearch.shareImgUrl");
            fat.IEE = parseXml.get(".websearch.shareString");
            fat.IEF = parseXml.get(".websearch.shareStringUrl");
            fat.source = parseXml.get(".websearch.source");
            fat.eby = parseXml.get(".websearch.sourceUrl");
            fat.IEG = parseXml.get(".websearch.strPlayCount");
            fat.IEH = parseXml.get(".websearch.titleUrl");
            fat.IEI = parseXml.get(".websearch.extReqParams");
            fat.IEJ = parseXml.get(".websearch.tagList");
            fat.IEK = Util.getLong(parseXml.get(".websearch.channelId"), -1);
            fat.thumbUrl = parseXml.get(".websearch.thumbUrl");
            fat.IEL = parseXml.get(".websearch.shareTag");
            ai.a(context, com.tencent.mm.plugin.topstory.a.h.a(fat, TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL, context.getString(R.string.hr6)));
            AppMethodBeat.o(24587);
        }
    }

    private static void a(Context context, g gVar, and and, Intent intent) {
        AppMethodBeat.i(24588);
        intent.putExtra(e.b.OyQ, and.scene);
        intent.putExtra(e.b.OyR, and.pHw);
        intent.putExtra("biz_video_session_id", com.tencent.mm.storage.ab.getSessionId());
        amt amt = gVar.field_favProto.IXu;
        x xVar = new x();
        xVar.dHc = amt.dHc;
        xVar.iAg = amt.iAg;
        xVar.iAi.url = intent.getStringExtra("rawUrl");
        xVar.iAi.title = Util.nullAsNil(intent.getStringExtra("share_report_pre_msg_title"));
        xVar.iAi.iAq = intent.getStringExtra("share_report_pre_msg_desc");
        xVar.iAi.iAo = amt.iAo;
        xVar.iAi.type = amt.iwc;
        xVar.iAi.iwf = amt.iwf;
        xVar.iAi.time = (long) amt.iwd;
        xVar.iAi.iAs = amt.duration;
        xVar.iAi.videoWidth = amt.videoWidth;
        xVar.iAi.videoHeight = amt.videoHeight;
        xVar.iAi.vid = amt.vid;
        xVar.t(intent);
        Log.i("MicroMsg.FavItemLogic", "jump to native video");
        if (amt.LxS != null) {
            intent.putExtra("img_gallery_width", amt.LxS.width).putExtra("img_gallery_height", amt.LxS.height).putExtra("img_gallery_left", amt.LxS.left).putExtra("img_gallery_top", amt.LxS.top);
        }
        intent.addFlags(268435456);
        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(context, ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(xVar.iAi.url, 24, 10000, (int) (System.currentTimeMillis() / 1000)), xVar.iAi.type, 24, 10000, intent)) {
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(24588);
    }

    private static boolean a(Context context, aml aml, boolean z) {
        AppMethodBeat.i(231715);
        if (aml == null || aml.Lwh == null || aml.Lwh.Lxi == null) {
            Log.w("MicroMsg.FavItemLogic", "handleMpVideoItem favMpMsgItem is null");
            AppMethodBeat.o(231715);
            return false;
        }
        boolean a2 = s.a(context, aml.Lwh.Lxi, aml, z);
        AppMethodBeat.o(231715);
        return a2;
    }

    private static void c(Context context, g gVar, and and) {
        AppMethodBeat.i(24590);
        m.a(m.a.PlayIcon, gVar);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        a(and, intent);
        b.b(context, ".ui.detail.FavoriteSightDetailUI", intent);
        AppMethodBeat.o(24590);
    }

    private static void d(Context context, g gVar, and and) {
        AppMethodBeat.i(24592);
        aml c2 = b.c(gVar);
        if (a(context, c2, gVar)) {
            AppMethodBeat.o(24592);
        } else if (a(context, c2, false)) {
            AppMethodBeat.o(24592);
        } else if (Util.isNullOrNil(c2.LvE) || c2.LvI <= 0) {
            Log.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", c2.LvE, Long.valueOf(c2.LvI));
            String str = b.c(gVar).Lvu;
            if (Util.isNullOrNil(str)) {
                str = b.c(gVar).Lvy;
            }
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                c(context, gVar, and);
                AppMethodBeat.o(24592);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("key_snsad_statextstr", c2.ean);
            bundle.putLong("favlocalid", gVar.field_localId);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", str);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", gVar.field_localId);
            intent.putExtra("geta8key_scene", 14);
            Log.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId));
            intent.putExtra("geta8key_scene", 14);
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(24592);
        } else {
            Intent intent2 = new Intent();
            a(gVar, and, intent2);
            i.gF("FavoriteSightDetailUI", and.sessionId);
            b.b(context, ".ui.detail.FavoriteSightDetailUI", intent2);
            AppMethodBeat.o(24592);
        }
    }

    private static void e(Context context, g gVar, and and) {
        AppMethodBeat.i(24593);
        Intent intent = new Intent();
        a(gVar, and, intent);
        i.gF("FavoriteImgDetailUI", and.sessionId);
        b.b(context, ".ui.detail.FavoriteImgDetailUI", intent);
        AppMethodBeat.o(24593);
    }

    private static void a(g gVar, and and, Intent intent) {
        AppMethodBeat.i(24594);
        a(and, intent);
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        intent.putExtra("key_detail_data_id", gVar.taf);
        AppMethodBeat.o(24594);
    }

    private static void a(and and, Intent intent) {
        AppMethodBeat.i(24595);
        intent.putExtra("key_detail_fav_scene", and.scene);
        intent.putExtra("key_detail_fav_sub_scene", and.pHw);
        intent.putExtra("key_detail_fav_index", and.index);
        intent.putExtra("key_detail_fav_query", and.query);
        intent.putExtra("key_detail_fav_sessionid", and.sessionId);
        intent.putExtra("key_detail_fav_tags", and.tay);
        AppMethodBeat.o(24595);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0236, code lost:
        if (r4.exists() == false) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0238, code lost:
        r0 = com.tencent.mm.vfs.aa.z(r4.her());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0242, code lost:
        r2 = com.tencent.mm.plugin.fav.a.b.arM(r0.dFN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x024c, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2) == false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0250, code lost:
        switch(r0.dataType) {
            case 2: goto L_0x025c;
            case 7: goto L_0x0265;
            case 29: goto L_0x0265;
            default: goto L_0x0253;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0253, code lost:
        r0 = java.lang.Integer.valueOf((int) com.tencent.mm.R.raw.app_attach_file_icon_video);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x025c, code lost:
        r0 = java.lang.Integer.valueOf((int) com.tencent.mm.R.drawable.bxc);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0265, code lost:
        r0 = java.lang.Integer.valueOf((int) com.tencent.mm.R.raw.app_attach_file_icon_music);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026e, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0497 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.pluginsdk.ui.applet.o.a r10, final android.content.Context r11, final com.tencent.mm.plugin.fav.a.g r12) {
        /*
        // Method dump skipped, instructions count: 1356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.d.a(com.tencent.mm.pluginsdk.ui.applet.o$a, android.content.Context, com.tencent.mm.plugin.fav.a.g):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(o.a aVar, final Context context, final g gVar) {
        AppMethodBeat.i(24597);
        if (gVar == null || context == null) {
            Log.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            AppMethodBeat.o(24597);
            return;
        }
        final aml c2 = b.c(gVar);
        switch (gVar.field_type) {
            case 1:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24575);
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", gVar.field_favProto.desc);
                        c.f(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        com.tencent.mm.ui.base.b.kc(context);
                        AppMethodBeat.o(24575);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 2:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass9 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24579);
                        Intent intent = new Intent();
                        intent.putExtra("key_detail_info_id", gVar.field_localId);
                        intent.putExtra("key_detail_data_id", c2.dLl);
                        intent.putExtra("show_share", false);
                        b.b(context, ".ui.FavImgGalleryUI", intent);
                        AppMethodBeat.o(24579);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 4:
            case 16:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass10 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24580);
                        aml c2 = b.c(gVar);
                        if (c2 == null) {
                            Log.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                            AppMethodBeat.o(24580);
                        } else if (d.b(context, c2)) {
                            AppMethodBeat.o(24580);
                        } else if (c2.Lwn == null || (Util.isNullOrNil(c2.Lwn.iyZ) && Util.isNullOrNil(c2.Lwn.izd))) {
                            Intent intent = new Intent();
                            intent.putExtra("key_detail_info_id", gVar.field_localId);
                            intent.putExtra("key_detail_fav_path", b.d(c2));
                            intent.putExtra("key_detail_fav_thumb_path", b.a(c2));
                            intent.putExtra("key_detail_fav_video_duration", c2.duration);
                            intent.putExtra("key_detail_statExtStr", c2.ean);
                            intent.putExtra("key_detail_msg_uuid", c2.jsz);
                            intent.putExtra("show_share", false);
                            b.b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
                            AppMethodBeat.o(24580);
                        } else {
                            Log.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_detail_info_id", gVar.field_localId);
                            intent2.putExtra("key_detail_data_id", c2.dLl);
                            intent2.putExtra("key_detail_can_delete", false);
                            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent2);
                            AppMethodBeat.o(24580);
                        }
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 5:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass7 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24577);
                        d.g(context, gVar, new and());
                        AppMethodBeat.o(24577);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 6:
                final ams ams = gVar.field_favProto.LwQ;
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass6 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24576);
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        if (ams != null) {
                            intent.putExtra("kwebmap_slat", ams.lat);
                            intent.putExtra("kwebmap_lng", ams.lng);
                            intent.putExtra("Kwebmap_locaion", ams.label);
                        }
                        intent.putExtra("kShowshare", false);
                        c.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
                        AppMethodBeat.o(24576);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 8:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24574);
                        d.f(context, gVar, new and());
                        AppMethodBeat.o(24574);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 14:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass8 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24578);
                        d.h(context, gVar, new and());
                        AppMethodBeat.o(24578);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 18:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(24572);
                        d.i(context, gVar, new and());
                        AppMethodBeat.o(24572);
                    }
                });
                AppMethodBeat.o(24597);
                return;
            case 20:
                aVar.a(new d.a.b() {
                    /* class com.tencent.mm.plugin.favorite.d.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.d.a.b
                    public final void cXd() {
                        AppMethodBeat.i(163190);
                        bcj bcj = gVar.field_favProto.Lxk;
                        if (bcj != null) {
                            com.tencent.mm.plugin.fav.ui.f fVar = com.tencent.mm.plugin.fav.ui.f.teu;
                            com.tencent.mm.plugin.fav.ui.f.a(context, bcj);
                        }
                        AppMethodBeat.o(163190);
                    }
                });
                break;
        }
        AppMethodBeat.o(24597);
    }

    private static boolean a(Context context, aml aml, g gVar) {
        AppMethodBeat.i(24591);
        amo amo = aml.Lwn;
        if (amo == null || Util.isNullOrNil(amo.iyZ)) {
            AppMethodBeat.o(24591);
            return false;
        }
        m.a(m.a.EnterCompleteVideo, gVar);
        String a2 = b.a(aml);
        Intent intent = new Intent();
        intent.putExtra("KFromTimeLine", false);
        intent.putExtra("KStremVideoUrl", amo.iyZ);
        intent.putExtra("StreamWording", amo.izc);
        intent.putExtra("StremWebUrl", amo.izd);
        intent.putExtra("KThumUrl", amo.ize);
        intent.putExtra("KSta_StremVideoAduxInfo", amo.izf);
        intent.putExtra("KSta_StremVideoPublishId", amo.izg);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", m.b.Fav.value);
        intent.putExtra("KSta_FromUserName", gVar.field_fromUser);
        intent.putExtra("KSta_FavID", gVar.field_id);
        intent.putExtra("KSta_SnsStatExtStr", aml.ean);
        intent.putExtra("KBlockFav", true);
        intent.putExtra("KMediaId", "fakeid_" + gVar.field_id);
        intent.putExtra("KThumbPath", a2);
        intent.putExtra("KMediaVideoTime", amo.LxJ);
        intent.putExtra("KMediaTitle", amo.izb);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
            c.b(context, "sns", ".ui.SnsAdStreamVideoPlayUI", intent);
            Log.i("MicroMsg.FavItemLogic", "use new stream video play UI");
        } else {
            c.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
        }
        AppMethodBeat.o(24591);
        return true;
    }
}
