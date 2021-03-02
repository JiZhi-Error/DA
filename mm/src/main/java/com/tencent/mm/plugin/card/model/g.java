package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends aq {
    protected static IAutoDBItem.MAutoDBInfo info;
    public tw pTA;
    public uo pTB;
    public List<a> pTC = null;
    public List<b> pTD = null;
    public int pTE = 0;
    public int pTF = 0;
    public boolean pTG;
    public List<c> pTH = null;
    public String pTu = "";
    public String pTv = "";
    public String pTw;
    public String pTx;
    public String pTy;
    public boolean pTz = false;

    public class a {
        public String cardExt;
        public String cardId;
        public int iqg;
        public String oqZ;
        public int pTI;
        public String title;

        public a() {
        }
    }

    public class b {
        public String description;
        public String pTK;
        public String pTL;
        public String title;

        public b() {
        }
    }

    public class c {
        public String pTM;

        public c() {
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final tw ctH() {
        AppMethodBeat.i(112771);
        if (this.pTA != null) {
            tw twVar = this.pTA;
            AppMethodBeat.o(112771);
            return twVar;
        }
        try {
            this.pTA = (tw) new tw().parseFrom(this.field_buttonData);
            tw twVar2 = this.pTA;
            AppMethodBeat.o(112771);
            return twVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
            tw twVar3 = new tw();
            AppMethodBeat.o(112771);
            return twVar3;
        }
    }

    public final uo ctI() {
        AppMethodBeat.i(112772);
        if (this.pTB != null) {
            uo uoVar = this.pTB;
            AppMethodBeat.o(112772);
            return uoVar;
        }
        try {
            this.pTB = (uo) new uo().parseFrom(this.field_operData);
            uo uoVar2 = this.pTB;
            AppMethodBeat.o(112772);
            return uoVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
            uo uoVar3 = new uo();
            AppMethodBeat.o(112772);
            return uoVar3;
        }
    }

    public final void ctJ() {
        AppMethodBeat.i(112773);
        if (this.pTC == null) {
            this.pTC = new ArrayList();
            if (!Util.isNullOrNil(this.field_accept_buttons)) {
                Map<String, String> parseXml = XmlParser.parseXml(this.field_accept_buttons, "accept_buttons_list", null);
                if (parseXml != null) {
                    int i2 = 0;
                    while (i2 < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        String str2 = parseXml.get(str + ".title");
                        if (Util.isNullOrNil(parseXml.get(str + ".card_id")) && Util.isNullOrNil(str2)) {
                            break;
                        }
                        int i3 = Util.getInt(parseXml.get(str + ".end_time"), 0);
                        if (i3 == 0 || ((long) i3) > Util.nowSecond()) {
                            a aVar = new a();
                            aVar.title = parseXml.get(str + ".title");
                            aVar.oqZ = parseXml.get(str + ".sub_title");
                            aVar.cardExt = parseXml.get(str + ".card_ext");
                            aVar.cardId = parseXml.get(str + ".card_id");
                            aVar.pTI = Util.getInt(parseXml.get(str + ".action_type"), 0);
                            aVar.iqg = i3;
                            this.pTC.add(aVar);
                        }
                        i2++;
                    }
                } else {
                    AppMethodBeat.o(112773);
                    return;
                }
            } else {
                AppMethodBeat.o(112773);
                return;
            }
        }
        AppMethodBeat.o(112773);
    }

    public final void ctK() {
        AppMethodBeat.i(112774);
        if (this.pTD == null) {
            this.pTD = new ArrayList();
            if (!Util.isNullOrNil(this.field_jump_buttons)) {
                Map<String, String> parseXml = XmlParser.parseXml(this.field_jump_buttons, "jump_buttons_list", null);
                if (parseXml != null) {
                    int i2 = 0;
                    while (i2 < 100) {
                        String str = ".jump_buttons_list.jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (Util.isNullOrNil(parseXml.get(str + ".title"))) {
                            break;
                        }
                        b bVar = new b();
                        bVar.title = parseXml.get(str + ".title");
                        bVar.description = parseXml.get(str + ".description");
                        bVar.pTK = parseXml.get(str + ".button_wording");
                        bVar.pTL = parseXml.get(str + ".jump_url");
                        this.pTD.add(bVar);
                        i2++;
                    }
                } else {
                    AppMethodBeat.o(112774);
                    return;
                }
            } else {
                AppMethodBeat.o(112774);
                return;
            }
        }
        AppMethodBeat.o(112774);
    }

    public final void ctL() {
        AppMethodBeat.i(112775);
        if (this.pTH == null) {
            this.pTH = new ArrayList();
            if (!Util.isNullOrNil(this.field_unavailable_qr_code_list)) {
                Map<String, String> parseXml = XmlParser.parseXml(this.field_unavailable_qr_code_list, "unavailable_qr_code_list", null);
                if (parseXml != null) {
                    int i2 = 0;
                    while (i2 < 100) {
                        String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i2 > 0 ? Integer.valueOf(i2) : "");
                        if (Util.isNullOrNil(parseXml.get(str + ".code_id"))) {
                            break;
                        }
                        c cVar = new c();
                        cVar.pTM = parseXml.get(str + ".code_id");
                        this.pTH.add(cVar);
                        i2++;
                    }
                } else {
                    AppMethodBeat.o(112775);
                    return;
                }
            } else {
                AppMethodBeat.o(112775);
                return;
            }
        }
        AppMethodBeat.o(112775);
    }

    static {
        AppMethodBeat.i(112776);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[22];
        mAutoDBInfo.columns = new String[23];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "card_type";
        mAutoDBInfo.colsMap.put("card_type", "INTEGER");
        sb.append(" card_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "title";
        mAutoDBInfo.colsMap.put("title", "TEXT");
        sb.append(" title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "description";
        mAutoDBInfo.colsMap.put("description", "TEXT");
        sb.append(" description TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "logo_url";
        mAutoDBInfo.colsMap.put("logo_url", "TEXT");
        sb.append(" logo_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "time";
        mAutoDBInfo.colsMap.put("time", "INTEGER");
        sb.append(" time INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "card_id";
        mAutoDBInfo.colsMap.put("card_id", "TEXT");
        sb.append(" card_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "card_tp_id";
        mAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
        sb.append(" card_tp_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "msg_id";
        mAutoDBInfo.colsMap.put("msg_id", "TEXT PRIMARY KEY ");
        sb.append(" msg_id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "msg_id";
        mAutoDBInfo.columns[8] = "msg_type";
        mAutoDBInfo.colsMap.put("msg_type", "INTEGER");
        sb.append(" msg_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "jump_type";
        mAutoDBInfo.colsMap.put("jump_type", "INTEGER");
        sb.append(" jump_type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "url";
        mAutoDBInfo.colsMap.put("url", "TEXT");
        sb.append(" url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "buttonData";
        mAutoDBInfo.colsMap.put("buttonData", "BLOB");
        sb.append(" buttonData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "operData";
        mAutoDBInfo.colsMap.put("operData", "BLOB");
        sb.append(" operData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "report_scene";
        mAutoDBInfo.colsMap.put("report_scene", "INTEGER");
        sb.append(" report_scene INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "read_state";
        mAutoDBInfo.colsMap.put("read_state", "INTEGER default '0' ");
        sb.append(" read_state INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "accept_buttons";
        mAutoDBInfo.colsMap.put("accept_buttons", "TEXT");
        sb.append(" accept_buttons TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "consumed_box_id";
        mAutoDBInfo.colsMap.put("consumed_box_id", "TEXT");
        sb.append(" consumed_box_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "jump_buttons";
        mAutoDBInfo.colsMap.put("jump_buttons", "TEXT");
        sb.append(" jump_buttons TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "logo_color";
        mAutoDBInfo.colsMap.put("logo_color", "TEXT");
        sb.append(" logo_color TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "unavailable_qr_code_list";
        mAutoDBInfo.colsMap.put("unavailable_qr_code_list", "TEXT");
        sb.append(" unavailable_qr_code_list TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "all_unavailable";
        mAutoDBInfo.colsMap.put("all_unavailable", "INTEGER default 'false' ");
        sb.append(" all_unavailable INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "need_pull_card_entrance";
        mAutoDBInfo.colsMap.put("need_pull_card_entrance", "INTEGER default 'false' ");
        sb.append(" need_pull_card_entrance INTEGER default 'false' ");
        mAutoDBInfo.columns[22] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(112776);
    }
}
