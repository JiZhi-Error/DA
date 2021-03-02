package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> ajW(String str) {
        AppMethodBeat.i(113779);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            AppMethodBeat.o(113779);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                AppMethodBeat.o(113779);
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            AppMethodBeat.o(113779);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
            AppMethodBeat.o(113779);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        AppMethodBeat.i(113780);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            AppMethodBeat.o(113780);
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
            AppMethodBeat.o(113780);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
            Log.e("MicroMsg.CardInfoParser", e2.getMessage());
            AppMethodBeat.o(113780);
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        AppMethodBeat.i(113781);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            AppMethodBeat.o(113781);
            return;
        }
        shareCardInfo.field_card_id = ajY(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = ajY(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.pTi = ax(optJSONObject);
        shareCardInfo.pTh = ay(optJSONObject2);
        shareCardInfo.pTj = az(optJSONObject3);
        if (shareCardInfo.pTi != null) {
            shareCardInfo.a(shareCardInfo.pTi);
        }
        if (shareCardInfo.pTh != null) {
            shareCardInfo.a(shareCardInfo.pTh);
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.pTj != null) {
            shareCardInfo.a(shareCardInfo.pTj);
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(113781);
    }

    public static ArrayList<CardInfo> ajX(String str) {
        AppMethodBeat.i(113782);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            AppMethodBeat.o(113782);
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                Log.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                AppMethodBeat.o(113782);
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            AppMethodBeat.o(113782);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
            AppMethodBeat.o(113782);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        AppMethodBeat.i(113783);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            AppMethodBeat.o(113783);
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
            AppMethodBeat.o(113783);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
            AppMethodBeat.o(113783);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        AppMethodBeat.i(113784);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            AppMethodBeat.o(113784);
            return;
        }
        cardInfo.field_card_id = ajY(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = ajY(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.pSa = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.pTi = ax(optJSONObject);
        cardInfo.pTh = ay(optJSONObject2);
        cardInfo.pTj = az(optJSONObject3);
        if (cardInfo.pTh != null) {
            cardInfo.a(cardInfo.pTh);
            cardInfo.field_block_mask = Integer.toString(cardInfo.pTh.LeH);
            cardInfo.field_card_type = cardInfo.pTh.nHh;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.pTh.pRX;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.pTh.Lff != null) {
                cardInfo.field_is_dynamic = cardInfo.pTh.Lff.LrL;
            }
        }
        if (cardInfo.pTi != null) {
            cardInfo.a(cardInfo.pTi);
            cardInfo.field_status = cardInfo.pTi.status;
        }
        if (cardInfo.pTj != null) {
            cardInfo.a(cardInfo.pTj);
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
        AppMethodBeat.o(113784);
    }

    private static String ajY(String str) {
        AppMethodBeat.i(113785);
        if (TextUtils.isEmpty(str) || BuildConfig.COMMAND.equals(str)) {
            AppMethodBeat.o(113785);
            return "";
        }
        AppMethodBeat.o(113785);
        return str;
    }

    private static ty ax(JSONObject jSONObject) {
        LinkedList<String> linkedList = null;
        AppMethodBeat.i(113786);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            AppMethodBeat.o(113786);
            return null;
        }
        ty tyVar = new ty();
        try {
            tyVar.status = jSONObject.optInt("status");
            tyVar.Lck = jSONObject.optInt("init_balance");
            tyVar.Lcl = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                tyVar.Lcm = t(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray2 != null) {
                tyVar.Lcn = t(optJSONArray2);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray3 != null) {
                tyVar.Lco = t(optJSONArray3);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray4 != null) {
                if (!(optJSONArray4 == null || optJSONArray4.length() == 0)) {
                    LinkedList<String> linkedList2 = new LinkedList<>();
                    for (int i2 = 0; i2 < optJSONArray4.length(); i2++) {
                        linkedList2.add((String) optJSONArray4.get(i2));
                    }
                    linkedList = linkedList2;
                }
                tyVar.Lcp = linkedList;
            }
            tyVar.Lcq = jSONObject.optInt("avail_num");
            tyVar.Lcr = jSONObject.optInt("code_type");
            tyVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray5 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray5 != null) {
                tyVar.Lcs = u(optJSONArray5);
            }
            tyVar.Lct = jSONObject.optLong("stock_num");
            tyVar.Lcu = jSONObject.optInt("limit_num");
            tyVar.Lcv = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                tyVar.Lcw = aA(optJSONObject);
            }
            tyVar.Lcx = v(jSONObject.optJSONArray("action_sheets"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject2 != null) {
                tyVar.Lcy = aA(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("operate_field");
            if (optJSONObject3 != null) {
                tyVar.Lcz = aA(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("limit_field");
            if (optJSONObject4 != null) {
                tyVar.LcA = aA(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("detail_table");
            if (optJSONObject5 != null) {
                tyVar.LcB = aE(optJSONObject5);
            }
            tyVar.LcC = jSONObject.optString("background_pic_url");
            JSONObject optJSONObject6 = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject6 != null) {
                tyVar.LcD = aA(optJSONObject6);
            }
            tyVar.LcE = jSONObject.optString("sign_number");
            JSONObject optJSONObject7 = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject7 != null) {
                tyVar.LcF = aA(optJSONObject7);
            }
            tyVar.LcG = jSONObject.optBoolean("is_commom_card");
            tyVar.LcH = jSONObject.optBoolean("is_location_authorized");
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
        }
        AppMethodBeat.o(113786);
        return tyVar;
    }

    private static LinkedList<vj> t(JSONArray jSONArray) {
        AppMethodBeat.i(113787);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(113787);
            return null;
        }
        LinkedList<vj> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            vj vjVar = new vj();
            vjVar.title = jSONObject.optString("title");
            vjVar.pRY = jSONObject.optString("sub_title");
            vjVar.pWf = jSONObject.optString("tips");
            vjVar.url = jSONObject.optString("url");
            vjVar.LfD = jSONObject.optLong("show_flag");
            vjVar.LfE = jSONObject.optString("primary_color");
            vjVar.LfF = jSONObject.optString("secondary_color");
            vjVar.qGB = jSONObject.optString("icon_url");
            vjVar.Leo = jSONObject.optString("app_brand_user_name");
            vjVar.Lep = jSONObject.optString("app_brand_pass");
            linkedList.add(vjVar);
        }
        AppMethodBeat.o(113787);
        return linkedList;
    }

    public static uz ay(JSONObject jSONObject) {
        uo uoVar;
        eol eol;
        bet bet;
        bg bgVar;
        aie aie;
        qr qrVar = null;
        AppMethodBeat.i(113788);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            AppMethodBeat.o(113788);
            return null;
        }
        uz uzVar = new uz();
        try {
            uzVar.pRX = jSONObject.optString("card_tp_id");
            uzVar.iwv = jSONObject.optString("logo_url");
            uzVar.dNI = jSONObject.optString("appid");
            uzVar.KZR = jSONObject.optString("app_username");
            uzVar.LeA = jSONObject.optInt("card_category");
            uzVar.nHh = jSONObject.optInt("card_type");
            uzVar.gTG = jSONObject.optString("brand_name");
            uzVar.title = jSONObject.optString("title");
            uzVar.pRY = jSONObject.optString("sub_title");
            uzVar.ixw = jSONObject.optString("color");
            uzVar.jTx = jSONObject.optString("notice");
            uzVar.LeB = jSONObject.optString("service_phone");
            uzVar.LeE = jSONObject.optString("image_text_url");
            uzVar.Gam = jSONObject.optString("source_icon");
            uzVar.source = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                uzVar.LeC = u(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray2 != null) {
                uzVar.LeD = u(optJSONArray2);
            }
            uzVar.LeF = jSONObject.optInt("shop_count");
            uzVar.lHL = jSONObject.optString("limit_wording");
            uzVar.pTn = jSONObject.optString("card_type_name");
            uzVar.LeG = jSONObject.optString("h5_show_url");
            uzVar.LeH = jSONObject.optInt("block_mask");
            uzVar.LeI = jSONObject.optString("middle_icon");
            uzVar.LeJ = jSONObject.optString("accept_wording");
            uzVar.LeK = jSONObject.optLong("control_flag");
            uzVar.LeL = jSONObject.optString("advertise_wording");
            uzVar.LeM = jSONObject.optString("advertise_url");
            uzVar.LeN = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                Log.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                uoVar = null;
            } else {
                uoVar = new uo();
                uoVar.type = optJSONObject.optInt("type");
                uoVar.text = optJSONObject.optString("text");
                uoVar.url = optJSONObject.optString("url");
                uoVar.DhD = optJSONObject.optInt("endtime");
                uoVar.Gaz = optJSONObject.optInt("create_time");
                uoVar.gTB = optJSONObject.optString("thumb_url");
            }
            uzVar.LeO = uoVar;
            uzVar.LeP = jSONObject.optString("public_service_tip");
            uzVar.LeQ = jSONObject.optString("primary_sub_title");
            uzVar.LeR = jSONObject.optInt("gen_type");
            uzVar.LeS = aC(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                eol = null;
            } else {
                eol = new eol();
                eol.title = optJSONObject2.optString("title");
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    Log.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    eol.Nmk = new LinkedList<>();
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        egi aD = aD(optJSONArray3.optJSONObject(i2));
                        if (aD != null) {
                            eol.Nmk.add(aD);
                        }
                    }
                }
                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                    Log.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    eol.Nml = new LinkedList<>();
                    for (int i3 = 0; i3 < optJSONArray4.length(); i3++) {
                        egi aD2 = aD(optJSONArray4.optJSONObject(i3));
                        if (aD2 != null) {
                            eol.Nml.add(aD2);
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray5 == null || optJSONArray5.length() <= 0) {
                    Log.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    eol.Nmm = u(optJSONArray5);
                }
            }
            uzVar.LeT = eol;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("follow_box");
            if (optJSONObject3 == null) {
                Log.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                bet = null;
            } else {
                bet = new bet();
                bet.text = optJSONObject3.optString("text");
                bet.LOA = optJSONObject3.optInt("follow");
                Log.i("MicroMsg.CardInfoParser", "follow:" + bet.LOA + "　text:" + bet.text);
            }
            uzVar.LeU = bet;
            JSONObject optJSONObject4 = jSONObject.optJSONObject("guidance");
            if (optJSONObject4 == null) {
                Log.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                bgVar = null;
            } else {
                bgVar = new bg();
                bgVar.text = optJSONObject4.optString("text");
                bgVar.url = optJSONObject4.optString("url");
            }
            uzVar.LeV = bgVar;
            uzVar.LeW = jSONObject.optInt("need_direct_jump", 0);
            uzVar.LeX = jSONObject.optInt("is_acceptable", 0);
            uzVar.LeY = jSONObject.optString("unacceptable_wording");
            uzVar.LeZ = jSONObject.optInt("has_hongbao", 0);
            uzVar.Lfa = jSONObject.optString("accept_ui_title");
            uzVar.Lfb = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject5 != null) {
                uzVar.Lfc = aA(optJSONObject5);
            }
            uzVar.Lfd = jSONObject.optString("shop_name");
            JSONObject optJSONObject6 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject6 != null) {
                uzVar.Lfe = aA(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject7 != null) {
                if (optJSONObject7 == null) {
                    Log.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    aie = null;
                } else {
                    aie = new aie();
                    aie.LrL = optJSONObject7.optBoolean("is_dynamic");
                    aie.LrM = optJSONObject7.optBoolean("can_refresh");
                    aie.LrN = optJSONObject7.optString("refresh_wording");
                    Log.i("MicroMsg.CardInfoParser", "is_dynamic:" + aie.LrL + "　can_refresh:" + aie.LrM + "　refresh_wording:" + aie.LrN);
                }
                uzVar.Lff = aie;
            }
            uzVar.Lfg = jSONObject.optBoolean("is_card_code_exposed");
            uzVar.Lfh = jSONObject.optInt("qrcode_correct_level");
            uzVar.Lfi = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            uzVar.Lfj = jSONObject.optBoolean("need_location");
            JSONObject optJSONObject8 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject8 != null) {
                if (optJSONObject8 == null) {
                    Log.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    qrVar = new qr();
                    qrVar.name = optJSONObject8.optString("name");
                    qrVar.KXx = optJSONObject8.optInt("report_time_interval", 0);
                    Log.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", qrVar.name);
                }
                uzVar.Lfk = qrVar;
            }
            uzVar.KUD = jSONObject.optString("biz_nickname");
            uzVar.Lfl = jSONObject.optString("gift_title");
            Log.d("MicroMsg.CardInfoParser", "parse gift title: %s", uzVar.Lfl);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
        }
        AppMethodBeat.o(113788);
        return uzVar;
    }

    private static LinkedList<abz> u(JSONArray jSONArray) {
        AppMethodBeat.i(113789);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(113789);
            return null;
        }
        LinkedList<abz> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            abz aA = aA(jSONArray.getJSONObject(i2));
            if (aA != null) {
                linkedList.add(aA);
            }
        }
        AppMethodBeat.o(113789);
        return linkedList;
    }

    private static dxr az(JSONObject jSONObject) {
        AppMethodBeat.i(113790);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            AppMethodBeat.o(113790);
            return null;
        }
        dxr dxr = new dxr();
        dxr.MXq = jSONObject.optString("gift_msg_title");
        AppMethodBeat.o(113790);
        return dxr;
    }

    private static LinkedList<bg> v(JSONArray jSONArray) {
        AppMethodBeat.i(113791);
        LinkedList<bg> linkedList = new LinkedList<>();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    bg bgVar = new bg();
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    bgVar.text = jSONObject.optString("text");
                    bgVar.url = jSONObject.optString("url");
                    linkedList.add(bgVar);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(113791);
        return linkedList;
    }

    private static abz aA(JSONObject jSONObject) {
        AppMethodBeat.i(113792);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            AppMethodBeat.o(113792);
            return null;
        }
        abz abz = new abz();
        abz.title = jSONObject.optString("title");
        abz.pRZ = jSONObject.optString("aux_title");
        abz.pRY = jSONObject.optString("sub_title");
        abz.url = jSONObject.optString("url");
        abz.LfD = jSONObject.optLong("show_flag");
        abz.LfE = jSONObject.optString("primary_color");
        abz.LfF = jSONObject.optString("secondary_color");
        abz.qGB = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            abz.LmB = aB(optJSONObject);
        }
        abz.Leo = jSONObject.optString("app_brand_user_name");
        abz.Lep = jSONObject.optString("app_brand_pass");
        AppMethodBeat.o(113792);
        return abz;
    }

    private static bzq aB(JSONObject jSONObject) {
        AppMethodBeat.i(113793);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            AppMethodBeat.o(113793);
            return null;
        }
        Log.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", jSONObject);
        bzq bzq = new bzq();
        bzq.KDl = p.fd(jSONObject.optString("biz_uin"));
        bzq.KDm = jSONObject.optString("order_id");
        AppMethodBeat.o(113793);
        return bzq;
    }

    private static agy aC(JSONObject jSONObject) {
        AppMethodBeat.i(113794);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            AppMethodBeat.o(113794);
            return null;
        }
        agy agy = new agy();
        agy.title = jSONObject.optString("title");
        agy.url = jSONObject.optString("url");
        agy.desc = jSONObject.optString("abstract");
        agy.detail = jSONObject.optString("detail");
        agy.LqC = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList<String> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String str = "";
                try {
                    str = optJSONArray.getString(i2);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    Log.e("MicroMsg.CardInfoParser", "getMessage:" + e2.getMessage());
                }
                linkedList.add(str);
            }
            agy.LqB = linkedList;
        }
        AppMethodBeat.o(113794);
        return agy;
    }

    private static egi aD(JSONObject jSONObject) {
        AppMethodBeat.i(113795);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            AppMethodBeat.o(113795);
            return null;
        }
        egi egi = new egi();
        egi.tag = jSONObject.optString("tag");
        egi.ixw = jSONObject.optString("color");
        AppMethodBeat.o(113795);
        return egi;
    }

    private static agz aE(JSONObject jSONObject) {
        AppMethodBeat.i(113796);
        if (jSONObject == null) {
            Log.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            AppMethodBeat.o(113796);
            return null;
        }
        agz agz = new agz();
        agz.title = jSONObject.optString("title");
        agz.pRY = jSONObject.optString("sub_title");
        agz.LqD = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
        } else {
            try {
                agz.LqE = u(optJSONArray);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                Log.e("MicroMsg.CardInfoParser", e2.getMessage());
            }
        }
        AppMethodBeat.o(113796);
        return agz;
    }
}
