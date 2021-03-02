package com.tencent.mm.plugin.card.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k {
    private List<WeakReference<a>> pQG = new ArrayList();
    public List<g> pRP = new ArrayList();
    public int pRQ = 0;

    public interface a {
        void a(g gVar);

        void onChange();
    }

    public k() {
        int intValue;
        AppMethodBeat.i(112684);
        loadFromDB();
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(139268, (Object) null);
        if (obj == null) {
            intValue = 0;
        } else {
            intValue = ((Integer) obj).intValue();
        }
        this.pRQ = intValue;
        AppMethodBeat.o(112684);
    }

    public final void a(g gVar) {
        a aVar;
        AppMethodBeat.i(112685);
        if (this.pQG == null) {
            AppMethodBeat.o(112685);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.a(gVar);
            }
        }
        AppMethodBeat.o(112685);
    }

    public final void onChange() {
        a aVar;
        AppMethodBeat.i(112686);
        if (this.pQG == null) {
            AppMethodBeat.o(112686);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.onChange();
            }
        }
        AppMethodBeat.o(112686);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(112687);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(112687);
    }

    public final void b(a aVar) {
        a aVar2;
        AppMethodBeat.i(112688);
        if (this.pQG == null) {
            AppMethodBeat.o(112688);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(112688);
                return;
            }
        }
        AppMethodBeat.o(112688);
    }

    public static void c(g gVar) {
        AppMethodBeat.i(112689);
        if (!am.ctS().insert(gVar)) {
            Log.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
        AppMethodBeat.o(112689);
    }

    private void loadFromDB() {
        AppMethodBeat.i(112690);
        Cursor all = am.ctS().getAll();
        if (all != null && all.getCount() > 0) {
            all.moveToFirst();
            int columnIndex = all.getColumnIndex("card_type");
            int columnIndex2 = all.getColumnIndex("title");
            int columnIndex3 = all.getColumnIndex("description");
            int columnIndex4 = all.getColumnIndex("logo_url");
            int columnIndex5 = all.getColumnIndex("time");
            int columnIndex6 = all.getColumnIndex("card_id");
            int columnIndex7 = all.getColumnIndex("card_tp_id");
            int columnIndex8 = all.getColumnIndex("msg_id");
            int columnIndex9 = all.getColumnIndex("msg_type");
            int columnIndex10 = all.getColumnIndex("jump_type");
            int columnIndex11 = all.getColumnIndex("url");
            int columnIndex12 = all.getColumnIndex("buttonData");
            int columnIndex13 = all.getColumnIndex("operData");
            int columnIndex14 = all.getColumnIndex("report_scene");
            int columnIndex15 = all.getColumnIndex("read_state");
            while (!all.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = all.getInt(columnIndex);
                gVar.field_title = all.getString(columnIndex2);
                gVar.field_description = all.getString(columnIndex3);
                gVar.field_logo_url = all.getString(columnIndex4);
                gVar.field_time = all.getInt(columnIndex5);
                gVar.field_card_id = all.getString(columnIndex6);
                gVar.field_card_tp_id = all.getString(columnIndex7);
                gVar.field_msg_id = all.getString(columnIndex8);
                gVar.field_msg_type = all.getInt(columnIndex9);
                gVar.field_jump_type = all.getInt(columnIndex10);
                gVar.field_url = all.getString(columnIndex11);
                gVar.field_buttonData = all.getBlob(columnIndex12);
                gVar.field_operData = all.getBlob(columnIndex13);
                gVar.field_report_scene = all.getInt(columnIndex14);
                gVar.field_read_state = all.getInt(columnIndex15);
                all.moveToNext();
                this.pRP.add(gVar);
            }
        }
        if (all != null) {
            all.close();
        }
        AppMethodBeat.o(112690);
    }

    public static String h(Map<String, String> map, String str) {
        AppMethodBeat.i(112691);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < 100) {
            String str2 = str + ".jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (Util.isNullOrNil(map.get(str2 + ".title"))) {
                break;
            }
            sb.append("<jump_buttons>");
            sb.append("<title>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".title"))) + "</title>");
            sb.append("<description>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".description"))) + "</description>");
            sb.append("<button_wording>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".button_wording"))) + "</button_wording>");
            sb.append("<jump_url>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".jump_url"))) + "</jump_url>");
            sb.append("</jump_buttons>");
            i2++;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!Util.isNullOrNil(sb.toString())) {
            sb2.append("<jump_buttons_list>");
            sb2.append(sb.toString());
            sb2.append("</jump_buttons_list>");
        }
        String sb3 = sb2.toString();
        AppMethodBeat.o(112691);
        return sb3;
    }

    public static String i(Map<String, String> map, String str) {
        AppMethodBeat.i(112692);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < 100) {
            String str2 = str + ".accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            String str3 = map.get(str2 + ".title");
            if (Util.isNullOrNil(map.get(str2 + ".card_id")) && Util.isNullOrNil(str3)) {
                break;
            }
            sb.append("<accept_buttons>");
            sb.append("<title>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".title"))) + "</title>");
            sb.append("<sub_title>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".sub_title"))) + "</sub_title>");
            sb.append("<card_id>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".card_id"))) + "</card_id>");
            sb.append("<card_ext>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".card_ext"))) + "</card_ext>");
            sb.append("<end_time>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".end_time"))) + "</end_time>");
            sb.append("<action_type>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".action_type"))) + "</action_type>");
            sb.append("</accept_buttons>");
            i2++;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!Util.isNullOrNil(sb.toString())) {
            sb2.append("<accept_buttons_list>");
            sb2.append(sb.toString());
            sb2.append("</accept_buttons_list>");
        }
        String sb3 = sb2.toString();
        AppMethodBeat.o(112692);
        return sb3;
    }

    public static String j(Map<String, String> map, String str) {
        AppMethodBeat.i(112693);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < 100) {
            String str2 = str + ".unavailable_qr_code_list" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (Util.isNullOrNil(map.get(str2 + ".code_id"))) {
                break;
            }
            sb.append("<unavailable_qr_codes>");
            sb.append("<code_id>" + Util.escapeStringForXml(Util.nullAsNil(map.get(str2 + ".code_id"))) + "</code_id>");
            sb.append("</unavailable_qr_codes>");
            i2++;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!Util.isNullOrNil(sb.toString())) {
            sb2.append("<unavailable_qr_code_list>");
            sb2.append(sb.toString());
            sb2.append("</unavailable_qr_code_list>");
        }
        String sb3 = sb2.toString();
        AppMethodBeat.o(112693);
        return sb3;
    }

    public final boolean ajg(String str) {
        AppMethodBeat.i(112694);
        if (this.pRP == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112694);
            return false;
        }
        for (int i2 = 0; i2 < this.pRP.size(); i2++) {
            g gVar = this.pRP.get(i2);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                AppMethodBeat.o(112694);
                return true;
            }
        }
        AppMethodBeat.o(112694);
        return false;
    }

    public final boolean ajh(String str) {
        g gVar;
        AppMethodBeat.i(112695);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112695);
            return false;
        }
        if (this.pRP != null && !TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.pRP.size()) {
                    gVar = null;
                    break;
                }
                gVar = this.pRP.get(i2);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
                i2++;
            }
        } else {
            gVar = null;
        }
        if (gVar != null) {
            this.pRP.remove(gVar);
            d(gVar);
            AppMethodBeat.o(112695);
            return true;
        }
        AppMethodBeat.o(112695);
        return false;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        AppMethodBeat.i(112696);
        if (gVar == null) {
            AppMethodBeat.o(112696);
        } else {
            z = am.ctS().delete(gVar, new String[0]);
            if (!z) {
                Log.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
            AppMethodBeat.o(112696);
        }
        return z;
    }

    public final int getCount() {
        AppMethodBeat.i(112697);
        if (this.pRP == null || this.pRP.isEmpty()) {
            AppMethodBeat.o(112697);
            return 0;
        }
        int size = this.pRP.size();
        AppMethodBeat.o(112697);
        return size;
    }

    public final void ctE() {
        AppMethodBeat.i(112698);
        this.pRQ = 0;
        com.tencent.mm.kernel.g.aAh().azQ().set(139268, Integer.valueOf(this.pRQ));
        AppMethodBeat.o(112698);
    }

    public static void ctF() {
        AppMethodBeat.i(112699);
        Log.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.b.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(112683);
                Log.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, "");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, (Object) 0);
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, "");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, "");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, "");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, "");
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE);
                if (c.axV().cP(262152, 266256)) {
                    c.axV().B(262152, false);
                }
                if (c.axV().cO(262152, 266256)) {
                    c.axV().A(262152, false);
                }
                if (c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC)) {
                    c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                }
                if (c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC)) {
                    c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                }
                Log.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
                AppMethodBeat.o(112683);
            }
        }, "clearRedDotAndWording");
        AppMethodBeat.o(112699);
    }
}
