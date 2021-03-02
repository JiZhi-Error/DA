package com.tencent.mm.plugin.order.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {
    private List<a> ANW = new ArrayList();
    public List<j> pRP = new ArrayList();

    public c() {
        AppMethodBeat.i(66661);
        loadFromDB();
        eBf();
        eBe();
        eBg();
        AppMethodBeat.o(66661);
    }

    public final void a(j jVar, String str, String str2) {
        AppMethodBeat.i(66662);
        if (jVar == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66662);
            return;
        }
        a aVar = new a();
        aVar.field_msgId = jVar.msgId;
        aVar.field_msgContentXml = str;
        aVar.field_isRead = str2;
        b.eBa();
        if (!b.eBc().a(aVar)) {
            Log.e("MicroMsg.MallPayMsgManager", "insert CommonMsgXml failed! id:" + jVar.msgId);
        }
        this.ANW.add(aVar);
        AppMethodBeat.o(66662);
    }

    private void loadFromDB() {
        AppMethodBeat.i(66663);
        b.eBa();
        Cursor all = b.eBc().getAll();
        if (all != null && all.getCount() > 0) {
            all.moveToFirst();
            int columnIndex = all.getColumnIndex("msgId");
            int columnIndex2 = all.getColumnIndex("msgContentXml");
            int columnIndex3 = all.getColumnIndex("isRead");
            while (!all.isAfterLast()) {
                a aVar = new a();
                aVar.field_msgId = all.getString(columnIndex);
                aVar.field_msgContentXml = all.getString(columnIndex2);
                aVar.field_isRead = all.getString(columnIndex3);
                all.moveToNext();
                this.ANW.add(aVar);
            }
        }
        if (all != null) {
            all.close();
        }
        AppMethodBeat.o(66663);
    }

    private void eBe() {
        int i2;
        AppMethodBeat.i(66664);
        if (this.pRP == null || this.pRP.size() == 0) {
            AppMethodBeat.o(66664);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.pRP);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            j jVar = (j) arrayList.get(i3);
            if (!(jVar.APm == null || !com.tencent.mm.plugin.order.c.c.isNumeric(jVar.APm) || (i2 = Util.getInt(jVar.APm, 0)) == 2 || i2 == 1)) {
                aJB(jVar.msgId);
            }
        }
        AppMethodBeat.o(66664);
    }

    public static j aJA(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(66665);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null) {
            AppMethodBeat.o(66665);
            return null;
        }
        j jVar = new j();
        jVar.APm = parseXml.get(".sysmsg.paymsg.PayMsgType");
        jVar.APn = parseXml.get(".sysmsg.paymsg.Brief.IconUrl");
        jVar.APo = parseXml.get(".sysmsg.paymsg.Brief.CreateTime");
        jVar.APp = parseXml.get(".sysmsg.paymsg.StatusSection.IconUrl");
        jVar.APq = parseXml.get(".sysmsg.paymsg.StatusSection.StatusDesc");
        jVar.dWG = parseXml.get(".sysmsg.paymsg.StatusSection.Content");
        jVar.APr = parseXml.get(".sysmsg.paymsg.StatusSection.JumpUrl");
        jVar.APs = parseXml.get(".sysmsg.paymsg.ContactSection.AppUserName");
        jVar.APc = parseXml.get(".sysmsg.paymsg.ContactSection.AppNickName");
        jVar.APt = parseXml.get(".sysmsg.paymsg.ContactSection.AppTelephone");
        int i2 = 0;
        while (true) {
            if (i2 == 0) {
                str2 = parseXml.get(".sysmsg.paymsg.StatusSection.Button.Name");
                str3 = parseXml.get(".sysmsg.paymsg.StatusSection.Button.JumpUrl");
            } else {
                str2 = parseXml.get(".sysmsg.paymsg.StatusSection.Button" + i2 + ".Name");
                str3 = parseXml.get(".sysmsg.paymsg.StatusSection.Button" + i2 + ".JumpUrl");
            }
            if (TextUtils.isEmpty(str2)) {
                break;
            }
            j.a aVar = new j.a();
            aVar.name = str2;
            aVar.jumpUrl = str3;
            if (jVar.APu == null) {
                jVar.APu = new ArrayList();
            }
            jVar.APu.add(aVar);
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (i3 == 0) {
                str4 = parseXml.get(".sysmsg.paymsg.NormalSection.Name");
                str5 = parseXml.get(".sysmsg.paymsg.NormalSection.Value");
                str6 = parseXml.get(".sysmsg.paymsg.NormalSection.JumpUrl");
            } else {
                str4 = parseXml.get(".sysmsg.paymsg.NormalSection" + i3 + ".Name");
                str5 = parseXml.get(".sysmsg.paymsg.NormalSection" + i3 + ".Value");
                str6 = parseXml.get(".sysmsg.paymsg.NormalSection" + i3 + ".JumpUrl");
            }
            if (!TextUtils.isEmpty(str4)) {
                j.b bVar = new j.b();
                bVar.name = str4;
                bVar.value = str5;
                bVar.jumpUrl = str6;
                if (jVar.APv == null) {
                    jVar.APv = new ArrayList();
                }
                jVar.APv.add(bVar);
                i3++;
            } else {
                AppMethodBeat.o(66665);
                return jVar;
            }
        }
    }

    public final boolean aJB(String str) {
        AppMethodBeat.i(66666);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66666);
            return false;
        }
        j aJD = aJD(str);
        if (aJD != null) {
            this.pRP.remove(aJD);
            a(aJD);
            AppMethodBeat.o(66666);
            return true;
        }
        AppMethodBeat.o(66666);
        return false;
    }

    private boolean a(j jVar) {
        AppMethodBeat.i(66667);
        if (jVar == null) {
            AppMethodBeat.o(66667);
            return false;
        }
        for (int i2 = 0; i2 < this.ANW.size(); i2++) {
            a aVar = this.ANW.get(i2);
            if (jVar.msgId.equals(aVar.field_msgId)) {
                this.ANW.remove(aVar);
                b.eBa();
                boolean delete = b.eBc().delete(aVar, new String[0]);
                AppMethodBeat.o(66667);
                return delete;
            }
        }
        AppMethodBeat.o(66667);
        return false;
    }

    private void eBf() {
        AppMethodBeat.i(66668);
        for (int i2 = 0; i2 < this.ANW.size(); i2++) {
            a aVar = this.ANW.get(i2);
            String str = aVar.field_msgContentXml;
            j aJA = aJA(str);
            aJA.msgId = aVar.field_msgId;
            this.pRP.add(aJA);
            Log.v("MicroMsg.MallPayMsgManager", "parsePayMsgFromMsgXmlList xml:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(66668);
    }

    public final boolean aJC(String str) {
        AppMethodBeat.i(66669);
        if (this.pRP == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66669);
            return false;
        }
        for (int i2 = 0; i2 < this.pRP.size(); i2++) {
            j jVar = this.pRP.get(i2);
            if (jVar != null && jVar.msgId.equals(str)) {
                AppMethodBeat.o(66669);
                return true;
            }
        }
        AppMethodBeat.o(66669);
        return false;
    }

    public final j aJD(String str) {
        AppMethodBeat.i(66670);
        if (this.pRP == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66670);
            return null;
        }
        for (int i2 = 0; i2 < this.pRP.size(); i2++) {
            j jVar = this.pRP.get(i2);
            if (str.equals(jVar.msgId)) {
                AppMethodBeat.o(66670);
                return jVar;
            }
        }
        AppMethodBeat.o(66670);
        return null;
    }

    public final a aJE(String str) {
        AppMethodBeat.i(66671);
        if (this.ANW == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66671);
            return null;
        }
        for (int i2 = 0; i2 < this.ANW.size(); i2++) {
            a aVar = this.ANW.get(i2);
            if (str.equals(aVar.field_msgId)) {
                AppMethodBeat.o(66671);
                return aVar;
            }
        }
        AppMethodBeat.o(66671);
        return null;
    }

    public final void eBg() {
        AppMethodBeat.i(66672);
        int eBh = eBh();
        g.aAi();
        g.aAh().azQ().set(204820, Integer.valueOf(eBh));
        Log.v("MicroMsg.MallPayMsgManager", "save unread msg is :".concat(String.valueOf(eBh)));
        AppMethodBeat.o(66672);
    }

    public final int eBh() {
        AppMethodBeat.i(66673);
        if (this.ANW == null || this.ANW.size() == 0) {
            AppMethodBeat.o(66673);
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.ANW.size(); i3++) {
            a aVar = this.ANW.get(i3);
            if (aVar != null && AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aVar.field_isRead)) {
                i2++;
            }
        }
        Log.v("MicroMsg.MallPayMsgManager", "msg xml unread msg is %s:".concat(String.valueOf(i2)));
        AppMethodBeat.o(66673);
        return i2;
    }
}
