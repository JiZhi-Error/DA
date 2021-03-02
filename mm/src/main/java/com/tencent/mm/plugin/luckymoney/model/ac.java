package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ac {
    public static q aY(JSONObject jSONObject) {
        AppMethodBeat.i(65241);
        q qVar = new q();
        if (jSONObject != null) {
            qVar.egY = jSONObject.optInt("hbType");
            qVar.egZ = jSONObject.optInt("hbStatus");
            qVar.yVb = jSONObject.optString("statusMess");
            qVar.yVc = jSONObject.optString("gameMess");
            qVar.yPK = jSONObject.optString("wishing");
            qVar.yVd = jSONObject.optString("sendNick");
            qVar.yVe = jSONObject.optString("sendHeadImg");
            qVar.yQE = jSONObject.optString("sendId");
            qVar.yVf = jSONObject.optString("adMessage");
            qVar.yVg = jSONObject.optString("adUrl");
            qVar.eht = jSONObject.optLong("amount");
            qVar.yVh = jSONObject.optLong("recNum");
            qVar.yVi = jSONObject.optLong("recAmount");
            qVar.qwe = jSONObject.optInt("totalNum");
            qVar.yVj = jSONObject.optLong("totalAmount");
            qVar.yVk = jSONObject.optString("receiveId");
            qVar.yVl = jSONObject.optInt("hasWriteAnswer");
            qVar.yVm = jSONObject.optInt("isSender");
            qVar.yVn = jSONObject.optInt("isContinue");
            qVar.yVo = jSONObject.optString("headTitle");
            qVar.eha = jSONObject.optInt("receiveStatus");
            qVar.yVp = jSONObject.optInt("canShare");
            qVar.yRN = jSONObject.optInt("jumpChange");
            qVar.yRP = jSONObject.optString("changeWording");
            qVar.yRO = jSONObject.optString("changeUrl");
            qVar.yVv = jSONObject.optInt("hbKind");
            qVar.yRQ = jSONObject.optString("externMess");
            qVar.yVy = jSONObject.optString("sendUserName");
            if (Util.isNullOrNil(qVar.yVd)) {
                qVar.UXw = true;
            }
            if (Util.isNullOrNil(qVar.yVd) && !Util.isNullOrNil(qVar.yVy)) {
                qVar.yVd = ((b) g.af(b.class)).getDisplayName(qVar.yVy);
            }
            qVar.UXx = jSONObject.optInt("not_show_avatar", 0);
            qVar.yVF = jSONObject.optString("sendsuffix");
            qVar.yVq = new i();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                qVar.yVq.gGn = optJSONObject.optInt("enable");
                qVar.yVq.yUH = optJSONObject.optString("fissionContent");
                qVar.yVq.yUG = optJSONObject.optString("fissionUrl");
            }
            qVar.yVr = new LinkedList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    qVar.yVr.add(ba(optJSONArray.getJSONObject(i2)));
                }
            }
            qVar.yVt = jSONObject.optString("watermark");
            qVar.yVu = jSONObject.optString("context");
            qVar.yVx = jSONObject.optString("contextMd5");
            qVar.resourceId = jSONObject.optInt("resourceId");
            qVar.yVs = ba(jSONObject.optJSONObject("operationTail"));
            qVar.yVw = aZ(jSONObject);
            qVar.yVz = jSONObject.optInt("jumpChangeType");
            qVar.yVA = jSONObject.optString("changeIconUrl");
            qVar.yVB = jSONObject.optString("showSourceOpen");
        }
        AppMethodBeat.o(65241);
        return qVar;
    }

    public static q a(bfb bfb) {
        AppMethodBeat.i(213305);
        if (bfb == null) {
            AppMethodBeat.o(213305);
            return null;
        }
        q qVar = new q();
        qVar.egY = bfb.egY;
        qVar.egZ = bfb.egZ;
        qVar.yVb = bfb.yVb;
        qVar.yPK = bfb.yPK;
        qVar.yQE = bfb.yQE;
        qVar.eht = bfb.eht;
        qVar.yVC = bfb.yVC;
        qVar.yVh = (long) bfb.yWN;
        qVar.yVi = bfb.yVi;
        qVar.qwe = bfb.qwe;
        qVar.yVj = bfb.yVj;
        qVar.yVk = bfb.yVk;
        qVar.yVm = bfb.yVm;
        qVar.yVn = bfb.yVn;
        qVar.yVo = bfb.yVo;
        qVar.eha = bfb.eha;
        qVar.yRN = bfb.yRN;
        qVar.yRP = bfb.yRP;
        qVar.yRO = bfb.yRO;
        qVar.yVy = bfb.yVy;
        if (!Util.isNullOrNil(qVar.yVy)) {
            qVar.yVd = ((b) g.af(b.class)).getDisplayName(qVar.yVy);
        }
        qVar.yVz = bfb.yVz;
        qVar.yVA = bfb.yVA;
        qVar.yVr = new LinkedList<>();
        if (!bfb.LOI.isEmpty()) {
            Iterator<bfe> it = bfb.LOI.iterator();
            while (it.hasNext()) {
                bfe next = it.next();
                bg bgVar = new bg();
                bgVar.content = next.content;
                bgVar.yXU = next.yXU;
                bgVar.gGn = next.gGn;
                bgVar.iconUrl = next.iconUrl;
                bgVar.name = next.name;
                bgVar.yXT = next.yXT;
                if (next.type == 1) {
                    bgVar.type = "Appid";
                } else if (next.type == 2) {
                    bgVar.type = "Text";
                } else if (next.type == 3) {
                    bgVar.type = "Pic";
                } else if (next.type == 4) {
                    bgVar.type = "Native";
                }
                qVar.yVr.add(bgVar);
            }
        }
        if (bfb.LOJ != null) {
            qVar.yVs = new bg();
            qVar.yVs.content = bfb.LOJ.content;
            qVar.yVs.yXU = bfb.LOJ.yXU;
            qVar.yVs.gGn = bfb.LOJ.gGn;
            qVar.yVs.iconUrl = bfb.LOJ.iconUrl;
            qVar.yVs.name = bfb.LOJ.name;
            qVar.yVs.yXT = bfb.LOJ.yXT;
            if (bfb.LOJ.type == 1) {
                qVar.yVs.type = "Appid";
            } else if (bfb.LOJ.type == 2) {
                qVar.yVs.type = "Text";
            } else if (bfb.LOJ.type == 3) {
                qVar.yVs.type = "Pic";
            } else if (bfb.LOJ.type == 4) {
                qVar.yVs.type = "Native";
            }
        }
        qVar.yVE = a(bfb.LOL);
        qVar.yVw = new LinkedList<>();
        if (!bfb.dkr.isEmpty()) {
            Iterator<bez> it2 = bfb.dkr.iterator();
            while (it2.hasNext()) {
                bez next2 = it2.next();
                ad adVar = new ad();
                adVar.yWG = next2.yWG;
                adVar.yVk = next2.yVk;
                adVar.yWo = next2.yWo;
                adVar.yWp = next2.yWp;
                adVar.userName = next2.userName;
                adVar.yWH = next2.yWH;
                if (Util.isNullOrNil(adVar.yWD) && !Util.isNullOrNil(adVar.userName)) {
                    adVar.yWD = ((b) g.af(b.class)).getDisplayName(adVar.userName);
                }
                qVar.yVw.add(adVar);
            }
        }
        AppMethodBeat.o(213305);
        return qVar;
    }

    public static j a(bey bey) {
        AppMethodBeat.i(213306);
        if (bey == null) {
            AppMethodBeat.o(213306);
            return null;
        }
        j jVar = new j();
        jVar.title = bey.title;
        Iterator<ahq> it = bey.yUI.iterator();
        while (it.hasNext()) {
            ahq next = it.next();
            g gVar = new g();
            gVar.title = next.title;
            gVar.desc = next.desc;
            gVar.yUB = next.yUB;
            jVar.yUI.add(gVar);
        }
        AppMethodBeat.o(213306);
        return jVar;
    }

    private static LinkedList<ad> aZ(JSONObject jSONObject) {
        AppMethodBeat.i(65242);
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList<ad> linkedList = new LinkedList<>();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                ad adVar = new ad();
                if (jSONObject2 != null) {
                    adVar.yWD = jSONObject2.optString("receiveName");
                    adVar.yWE = jSONObject2.optString("receiveHeadImg");
                    adVar.yWo = jSONObject2.optLong("receiveAmount");
                    adVar.yWp = jSONObject2.optString("receiveTime");
                    adVar.yWF = jSONObject2.optString("answer");
                    adVar.yVk = jSONObject2.optString("receiveId");
                    adVar.yWG = jSONObject2.optString("gameTips");
                    adVar.userName = jSONObject2.optString("userName");
                    adVar.yWI = jSONObject2.optString("receivesuffix");
                    if (Util.isNullOrNil(adVar.yWD) && !Util.isNullOrNil(adVar.userName)) {
                        g.aAi();
                        if (!Util.isNullOrNil(((l) g.af(l.class)).aSN().bjK(adVar.userName).field_username)) {
                            adVar.yWD = ((b) g.af(b.class)).getDisplayName(adVar.userName);
                        } else {
                            adVar.UXA = true;
                        }
                    }
                }
                linkedList.add(adVar);
            }
        }
        AppMethodBeat.o(65242);
        return linkedList;
    }

    public static bg ba(JSONObject jSONObject) {
        AppMethodBeat.i(65243);
        bg bgVar = new bg();
        if (jSONObject != null) {
            bgVar.gGn = jSONObject.optInt("enable", 0);
            bgVar.content = jSONObject.optString("content");
            bgVar.iconUrl = jSONObject.optString("iconUrl");
            bgVar.type = jSONObject.optString("type");
            bgVar.name = jSONObject.optString("name");
            bgVar.yXT = jSONObject.optInt("ossKey");
            bgVar.yXU = jSONObject.optInt("focus");
        }
        AppMethodBeat.o(65243);
        return bgVar;
    }

    public static cbe bb(JSONObject jSONObject) {
        AppMethodBeat.i(65244);
        if (jSONObject == null) {
            AppMethodBeat.o(65244);
            return null;
        }
        cbe cbe = new cbe();
        cbe.subType = jSONObject.optInt("subType", -1);
        cbe.MgB = jSONObject.optString("corpName");
        cbe.Lot = jSONObject.optString("materialId");
        cbe.MgD = jSONObject.optString("expire_desc");
        cbe.MgE = jSONObject.optInt("is_expired");
        cbe.MgJ = jSONObject.optInt("detail_link_type");
        cbe.MgK = jSONObject.optString("detail_link_appname");
        cbe.MgL = jSONObject.optString("detail_link_url");
        cbe.MgM = jSONObject.optString("detail_link_title");
        cbe.MgN = jSONObject.optString("exchange_title");
        cbe.MgO = jSONObject.optString("exchange_url");
        cbe.MgP = jSONObject.optInt("has_source");
        cbe.Mbx = jSONObject.optLong("last_obtain_time");
        cbe.dfT = jSONObject.optInt("disable");
        cbe.MgQ = jSONObject.optString("disable_text");
        JSONObject optJSONObject = jSONObject.optJSONObject("sourceObject");
        if (optJSONObject != null) {
            cbf cbf = new cbf();
            cbf.MgU = optJSONObject.optString("bubbleImage");
            cbf.MgW = optJSONObject.optString("bubbleImageMd5");
            cbf.MgT = optJSONObject.optString("corpLogo");
            cbf.MgZ = optJSONObject.optString("corpLogoMd5");
            cbf.igW = optJSONObject.optString("coverImage");
            cbf.MgX = optJSONObject.optString("coverImageMd5");
            cbf.MgV = optJSONObject.optString("detailImage");
            cbf.MgY = optJSONObject.optString("detailImageMd5");
            cbe.MgC = cbf;
        }
        AppMethodBeat.o(65244);
        return cbe;
    }
}
