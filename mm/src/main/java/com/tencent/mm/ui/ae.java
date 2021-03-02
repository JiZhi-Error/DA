package com.tencent.mm.ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ae {
    private static ae OKb = null;
    private SparseIntArray OKc = new SparseIntArray();
    private SparseArray<af.b> OKd = new SparseArray<>();
    private ArrayList<Integer> OKe = new ArrayList<>();
    public SparseArray<af.c> OKf = new SparseArray<>();
    private boolean OKg = false;
    private int ehp = 0;
    private long timestamp = 0;

    public ae() {
        AppMethodBeat.i(33680);
        AppMethodBeat.o(33680);
    }

    public static ae gJy() {
        AppMethodBeat.i(33681);
        if (OKb == null) {
            OKb = new ae();
        }
        ae aeVar = OKb;
        AppMethodBeat.o(33681);
        return aeVar;
    }

    public final void alk(int i2) {
        af.b bVar;
        AppMethodBeat.i(33682);
        if (!(this.OKd.size() == 0 || (bVar = this.OKd.get(i2)) == null || bVar.OKn != 1)) {
            this.OKc.put(bVar.id, bVar.jlm);
            this.ehp--;
            if (this.OKg) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < this.OKc.size(); i3++) {
                    int keyAt = this.OKc.keyAt(i3);
                    Integer valueOf = Integer.valueOf(this.OKc.get(keyAt));
                    stringBuffer.append(keyAt);
                    stringBuffer.append(":");
                    stringBuffer.append(valueOf);
                    stringBuffer.append("|");
                }
                bg.aVF();
                c.azQ().set(299010, stringBuffer.toString());
            }
        }
        AppMethodBeat.o(33682);
    }

    public final boolean gCH() {
        return this.ehp > 0;
    }

    private void Br(boolean z) {
        AppMethodBeat.i(33683);
        if (!z) {
            if (!(this.OKd.size() == 0 || System.currentTimeMillis() - this.timestamp > Util.MILLSECONDS_OF_HOUR)) {
                AppMethodBeat.o(33683);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<String> El = h.aqJ().El("TopRightMenu\\d*");
        Log.i("MicroMsg.PlusMenaDataManager", "dynaConfigs size %d", Integer.valueOf(El.size()));
        synchronized (this) {
            try {
                this.OKd.clear();
                this.OKe.clear();
                for (String str : El) {
                    Map<String, String> parseXml = XmlParser.parseXml(str, "Menu", null);
                    if (!(parseXml == null || parseXml.size() == 0)) {
                        int safeParseInt = Util.safeParseInt(parseXml.get(".Menu.$id"));
                        int safeParseInt2 = Util.safeParseInt(parseXml.get(".Menu.$shownew"));
                        int safeParseInt3 = Util.safeParseInt(parseXml.get(".Menu.$seq"));
                        int safeParseInt4 = Util.safeParseInt(parseXml.get(".Menu.$order"));
                        this.OKd.put(safeParseInt, new af.b(safeParseInt, safeParseInt2, safeParseInt3, safeParseInt4));
                        int i2 = 0;
                        while (i2 < this.OKe.size() && this.OKd.get(this.OKe.get(i2).intValue()).order <= safeParseInt4) {
                            i2++;
                        }
                        this.OKe.add(i2, Integer.valueOf(safeParseInt));
                    }
                }
                Log.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder size %d", Integer.valueOf(this.OKe.size()));
                if (this.OKe.size() == 0) {
                    this.OKd.clear();
                    this.OKe.clear();
                    String value = h.aqJ().getValue("TopRightMenus");
                    if (!Util.isNullOrNil(value)) {
                        Map<String, String> parseXml2 = XmlParser.parseXml(value, "TopRightMenus", null);
                        if (parseXml2 != null) {
                            int i3 = 0;
                            while (i3 < 100) {
                                String str2 = ".TopRightMenus.Menu" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                String str3 = parseXml2.get(str2 + ".$id");
                                if (str3 == null || Util.isNullOrNil(str3)) {
                                    break;
                                }
                                String str4 = parseXml2.get(str2 + ".$shownew");
                                String str5 = parseXml2.get(str2 + ".$seq");
                                Log.d("MicroMsg.PlusMenaDataManager", "got plus panel configs : %s %s %s", str3, str4, str5);
                                this.OKd.put(Util.safeParseInt(str3), new af.b(Util.safeParseInt(str3), Util.safeParseInt(str4), Util.safeParseInt(str5)));
                                this.OKe.add(Integer.valueOf(Util.safeParseInt(str3)));
                                i3++;
                            }
                        } else {
                            Log.e("MicroMsg.PlusMenaDataManager", "TopRightMenus is not right");
                        }
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(33683);
                throw th;
            }
        }
        if (this.OKd.size() != 0) {
            gJz();
        }
        this.timestamp = System.currentTimeMillis();
        Log.d("MicroMsg.PlusMenaDataManager", " plus menu load data spent time : %s", Long.valueOf(this.timestamp - currentTimeMillis));
        AppMethodBeat.o(33683);
    }

    public final void Bs(boolean z) {
        AppMethodBeat.i(33684);
        try {
            Br(z);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PlusMenaDataManager", e2, "", new Object[0]);
        }
        this.OKf.clear();
        this.ehp = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.OKe.size(); i3++) {
            int intValue = this.OKe.get(i3).intValue();
            af.b bVar = this.OKd.get(intValue);
            af.d all = af.all(intValue);
            if (all != null) {
                af.c cVar = new af.c(all);
                this.OKf.put(i2, cVar);
                int i4 = this.OKc.get(intValue);
                if ((bVar.OKn == 1 && i4 != bVar.jlm) || (intValue == 20 && com.tencent.mm.y.c.axV().cP(262159, 266248))) {
                    cVar.OKo = true;
                    this.ehp++;
                }
                i2++;
            }
        }
        Log.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder.size() %s menuDataMap.size() %s", Integer.valueOf(this.OKe.size()), Integer.valueOf(this.OKf.size()));
        if (this.OKe.size() != 0) {
            if (ChannelUtil.isCrowdTestVersion()) {
                this.OKf.put(i2, new af.c(af.all(2147483645)));
            } else if (!WeChatBrands.Business.Entries.HomeMoreFeedback.banned()) {
                this.OKf.put(i2, new af.c(af.all(Integer.MAX_VALUE)));
                AppMethodBeat.o(33684);
                return;
            }
        }
        AppMethodBeat.o(33684);
    }

    private void gJz() {
        AppMethodBeat.i(33685);
        this.OKc.clear();
        bg.aVF();
        String str = (String) c.azQ().get(299010, (Object) null);
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split("\\|");
            for (String str2 : split) {
                String[] split2 = str2.split("\\:");
                if (split2.length == 2) {
                    this.OKc.put(Util.safeParseInt(split2[0]), Util.safeParseInt(split2[1]));
                }
            }
        }
        this.OKg = true;
        AppMethodBeat.o(33685);
    }
}
