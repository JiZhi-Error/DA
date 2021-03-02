package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a gpc;
    public Map<Integer, Long> gpd = new HashMap();
    public Map<Long, a> gpe = new HashMap();
    public IListener gpf = new IListener<ar>() {
        /* class com.tencent.mm.h.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161274);
            this.__eventId = ar.class.getName().hashCode();
            AppMethodBeat.o(161274);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ar arVar) {
            yg ygVar;
            AppMethodBeat.i(20094);
            ar arVar2 = arVar;
            ar.a aVar = arVar2.dDD;
            switch (aVar.type) {
                case 1:
                    b bVar = b.this;
                    String str = aVar.event;
                    long j2 = Util.getLong(str, 0);
                    int i2 = aVar.position;
                    Log.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", str, Integer.valueOf(i2), bVar.gpc, Integer.valueOf(bVar.gpe.size()));
                    if (bVar.gpe.size() > 0 && j2 > 0) {
                        a aVar2 = bVar.gpe.get(Long.valueOf(j2));
                        if (aVar2 != null) {
                            Log.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", aVar2);
                            if (i2 <= 0) {
                                Collection<yg> values = aVar2.gpm.values();
                                if (!(values == null || (r1 = values.iterator()) == null)) {
                                    for (yg ygVar2 : values) {
                                        if (ygVar2 != null && ygVar2.eeB.visible) {
                                            Log.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Long.valueOf(j2), Boolean.valueOf(ygVar2.eeB.visible));
                                            ygVar2.eeB.visible = false;
                                            EventCenter.instance.publish(ygVar2);
                                        }
                                    }
                                    break;
                                }
                            } else {
                                yg ygVar3 = aVar2.gpm.get(Integer.valueOf(i2));
                                if (ygVar3 != null) {
                                    Log.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Integer.valueOf(i2), Boolean.valueOf(ygVar3.eeB.visible));
                                    if (ygVar3.eeB.visible) {
                                        ygVar3.eeB.visible = false;
                                        EventCenter.instance.publish(ygVar3);
                                        h.INSTANCE.a(13939, 2);
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", Integer.valueOf(i2));
                                }
                            }
                        } else {
                            Log.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                        }
                    }
                    if (bVar.gpc != null) {
                        if (!Util.isNullOrNil(str) && !str.equals(bVar.gpc.gpj)) {
                            Log.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", bVar.gpc.gpj, str);
                            break;
                        } else {
                            yg ygVar4 = bVar.gpc.gpm.get(0);
                            if (ygVar4 != null && ygVar4.eeB.visible) {
                                h.INSTANCE.a(13939, 2);
                                ygVar4.eeB.visible = false;
                                EventCenter.instance.publish(ygVar4);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    b bVar2 = b.this;
                    int i3 = arVar2.dDD.position;
                    Log.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", Integer.valueOf(i3), bVar2.gpc, Integer.valueOf(bVar2.gpd.size()));
                    if (i3 <= 0 || bVar2.gpd.size() <= 0) {
                        if (!(bVar2.gpc == null || (ygVar = bVar2.gpc.gpm.get(0)) == null)) {
                            arVar2.dDE.desc = ygVar.eeB.desc;
                            arVar2.dDE.dDF = ygVar.eeB.dDF;
                            arVar2.dDE.dDG = ygVar.eeB.dDG;
                            arVar2.dDE.url = ygVar.eeB.url;
                            arVar2.dDE.visible = ygVar.eeB.visible;
                            arVar2.dDE.dDI = ygVar.eeB.dDI;
                            arVar2.dDE.dDH = ygVar.eeB.dDH;
                            arVar2.dDE.Title = ygVar.eeB.Title;
                            arVar2.dDE.dDJ = ygVar.eeB.dDJ;
                            arVar2.dDE.position = ygVar.eeB.position;
                            if (ygVar.eeB.visible) {
                                h.INSTANCE.a(13936, Integer.valueOf(i3));
                            }
                            bVar2.alz();
                            break;
                        }
                    } else {
                        long nullAs = Util.nullAs(bVar2.gpd.get(Integer.valueOf(i3)), 0);
                        Log.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", Integer.valueOf(i3), Long.valueOf(nullAs));
                        if (nullAs > 0) {
                            a aVar3 = bVar2.gpe.get(Long.valueOf(nullAs));
                            if (aVar3 == null) {
                                bVar2.gpd.remove(Integer.valueOf(i3));
                                break;
                            } else {
                                yg ygVar5 = aVar3.gpm.get(Integer.valueOf(i3));
                                if (ygVar5 != null) {
                                    arVar2.dDE.desc = ygVar5.eeB.desc;
                                    arVar2.dDE.dDF = ygVar5.eeB.dDF;
                                    arVar2.dDE.dDG = ygVar5.eeB.dDG;
                                    arVar2.dDE.url = ygVar5.eeB.url;
                                    arVar2.dDE.visible = ygVar5.eeB.visible;
                                    arVar2.dDE.dDI = ygVar5.eeB.dDI;
                                    arVar2.dDE.dDH = ygVar5.eeB.dDH;
                                    arVar2.dDE.Title = ygVar5.eeB.Title;
                                    arVar2.dDE.dDJ = ygVar5.eeB.dDJ;
                                    arVar2.dDE.position = ygVar5.eeB.position;
                                    if (ygVar5.eeB.visible) {
                                        h.INSTANCE.a(13936, Integer.valueOf(i3));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    b.this.Dl(aVar.event);
                    break;
                case 5:
                    b.this.a(arVar2);
                    break;
            }
            AppMethodBeat.o(20094);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(20099);
        AppMethodBeat.o(20099);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String gpj = null;
        long gpk = 0;
        String gpl = null;
        Map<Integer, yg> gpm = new HashMap();

        a() {
            AppMethodBeat.i(20097);
            AppMethodBeat.o(20097);
        }

        public final String toString() {
            String str;
            AppMethodBeat.i(20098);
            String str2 = "";
            Iterator<Integer> it = this.gpm.keySet().iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str + it.next() + ",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            String format = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", Integer.valueOf(hashCode()), this.gpj, Long.valueOf(this.gpk), this.gpl, str);
            AppMethodBeat.o(20098);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ar arVar) {
        a aVar;
        String str;
        String str2;
        String str3;
        final yg ygVar;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        AppMethodBeat.i(20100);
        String str8 = arVar.dDD.event;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str8 == null ? -1 : str8.length());
        Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", objArr);
        Map<String, String> parseXml = XmlParser.parseXml(str8, "e", null);
        if (parseXml == null) {
            Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            AppMethodBeat.o(20100);
            return false;
        }
        Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", parseXml);
        long j2 = Util.getLong(parseXml.get(".e.NoticeId"), 0);
        if (j2 <= 0) {
            Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!ac.jPN) {
            try {
                long j3 = Util.getLong(parseXml.get(".e.ExpiredTime"), 0);
                if (Util.secondsToNow(j3) > 0) {
                    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", Long.valueOf(j3));
                    AppMethodBeat.o(20100);
                    return false;
                }
            } catch (Exception e2) {
                Log.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e2);
            }
        }
        a aVar2 = new a();
        aVar2.gpj = String.valueOf(j2);
        String string = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aps()).getString("disaster_noticeid_list_key", "");
        if (ac.jPO || !string.contains(aVar2.gpj)) {
            if (this.gpe.size() > 0) {
                a aVar3 = this.gpe.get(Long.valueOf(j2));
                if (aVar3 != null) {
                    Log.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", aVar3);
                    aVar = aVar3;
                } else {
                    this.gpe.put(Long.valueOf(j2), aVar2);
                    aVar = aVar2;
                }
            } else {
                this.gpe.put(Long.valueOf(j2), aVar2);
                aVar = aVar2;
            }
            String str9 = parseXml.get(".e.Position");
            if (Util.isNullOrNil(str9)) {
                Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                AppMethodBeat.o(20100);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = str9.split(",");
            if (split == null || split.length <= 0) {
                Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                AppMethodBeat.o(20100);
                return false;
            }
            boolean z2 = false;
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = Util.getInt(split[i2], 0);
                if (i3 > 0) {
                    if (i3 == 1) {
                        z = true;
                        Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", Integer.valueOf(i3));
                        i2++;
                        z2 = z;
                    } else {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2 || arrayList.size() != 0) {
                String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", currentLanguage);
                String str10 = null;
                String str11 = null;
                String str12 = null;
                int i4 = 0;
                while (true) {
                    String str13 = ".e.Item" + (i4 == 0 ? "" : Integer.valueOf(i4));
                    String str14 = parseXml.get(str13 + ".Language");
                    if (str14 == null && i4 > 3) {
                        str3 = null;
                        str2 = null;
                        str = null;
                        break;
                    } else if (currentLanguage.equalsIgnoreCase(str14)) {
                        str3 = parseXml.get(str13 + ".Content");
                        str2 = parseXml.get(str13 + ".Url");
                        str = parseXml.get(str13 + ".Tips");
                        break;
                    } else {
                        if (LocaleUtil.ENGLISH.equalsIgnoreCase(str14)) {
                            str7 = parseXml.get(str13 + ".Content");
                            str6 = parseXml.get(str13 + ".Url");
                            str5 = parseXml.get(str13 + ".Tips");
                        } else {
                            str5 = str12;
                            str6 = str11;
                            str7 = str10;
                        }
                        i4++;
                        str12 = str5;
                        str11 = str6;
                        str10 = str7;
                    }
                }
                Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", str3, str);
                if (Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
                } else {
                    str10 = str3;
                    str11 = str2;
                    str12 = str;
                }
                if (Util.isNullOrNil(str11)) {
                    str11 = MMApplicationContext.getContext().getString(R.string.bn2);
                }
                if (z2) {
                    if (Util.isNullOrNil(str10)) {
                        str10 = MMApplicationContext.getContext().getString(R.string.bmw);
                    }
                    if (Util.isNullOrNil(str12)) {
                        str12 = MMApplicationContext.getContext().getString(R.string.bn0);
                    }
                    arVar.dDE.desc = str10;
                    arVar.dDE.dDF = 30;
                    arVar.dDE.dDG = 0;
                    arVar.dDE.url = str11;
                    arVar.dDE.visible = true;
                    arVar.dDE.dDI = 0;
                    arVar.dDE.dDH = 6;
                    arVar.dDE.Title = "";
                    arVar.dDE.dDJ = String.valueOf(j2);
                    arVar.dDE.position = 1;
                }
                if (arrayList.size() == 0) {
                    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                    AppMethodBeat.o(20100);
                    return false;
                } else if (aVar.gpk == 0 || Util.ticksToNow(aVar.gpk) >= 1800000) {
                    aVar.gpk = Util.currentTicks();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        Long valueOf = Long.valueOf(Util.nullAs(this.gpd.get(num), 0));
                        if (valueOf.longValue() <= 0 || valueOf.longValue() < j2) {
                            yg ygVar2 = aVar.gpm.get(num);
                            if (ygVar2 == null) {
                                yg ygVar3 = new yg();
                                ygVar3.eeB.dDG = 0;
                                ygVar3.eeB.dDF = 30;
                                ygVar3.eeB.Title = "";
                                ygVar3.eeB.dDI = R.layout.bap;
                                ygVar3.eeB.position = num.intValue();
                                aVar.gpm.put(num, ygVar3);
                                ygVar = ygVar3;
                            } else {
                                ygVar = ygVar2;
                            }
                            if (Util.isNullOrNil(str12)) {
                                str4 = str10;
                            } else {
                                str4 = str12;
                            }
                            if (Util.isNullOrNil(str4)) {
                                int i5 = R.string.bmz;
                                switch (num.intValue()) {
                                    case 2:
                                        i5 = R.string.bn1;
                                        break;
                                    case 3:
                                    case 4:
                                        i5 = R.string.bmy;
                                        break;
                                }
                                str4 = MMApplicationContext.getContext().getString(i5);
                            }
                            ygVar.eeB.desc = str4;
                            ygVar.eeB.url = str11;
                            ygVar.eeB.visible = true;
                            ygVar.eeB.dDH = 2;
                            ygVar.eeB.dDJ = aVar.gpj;
                            this.gpd.put(num, Long.valueOf(j2));
                            if (!z2) {
                                arVar.dDE.desc = str4;
                                arVar.dDE.dDF = 30;
                                arVar.dDE.dDG = 0;
                                arVar.dDE.url = str11;
                                arVar.dDE.visible = true;
                                arVar.dDE.dDI = R.layout.bap;
                                arVar.dDE.dDH = 2;
                                arVar.dDE.Title = "";
                                arVar.dDE.dDJ = String.valueOf(j2);
                                arVar.dDE.position = num.intValue();
                            }
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.h.b.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(20095);
                                    EventCenter.instance.publish(ygVar);
                                    AppMethodBeat.o(20095);
                                }
                            });
                            str12 = str4;
                        } else {
                            Log.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", num, valueOf, Long.valueOf(j2));
                        }
                    }
                    AppMethodBeat.o(20100);
                    return true;
                } else {
                    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                    AppMethodBeat.o(20100);
                    return false;
                }
            } else {
                Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                AppMethodBeat.o(20100);
                return false;
            }
        } else {
            Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", string, aVar2.gpj);
            AppMethodBeat.o(20100);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Dl(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        AppMethodBeat.i(20101);
        Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", this.gpc, str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(20101);
            return false;
        } else if (str.indexOf("<") < 0) {
            AppMethodBeat.o(20101);
            return false;
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml == null) {
                Log.e("MicroMsg.BroadcastController", "this is not errmsg");
                AppMethodBeat.o(20101);
                return false;
            }
            if (this.gpc == null) {
                this.gpc = new a();
                yg ygVar = new yg();
                this.gpc.gpm.put(0, ygVar);
                ygVar.eeB.desc = "";
                ygVar.eeB.url = "";
                ygVar.eeB.dDG = 0;
                ygVar.eeB.dDF = 30;
                ygVar.eeB.visible = false;
                ygVar.eeB.Title = "";
                ygVar.eeB.dDH = 0;
                ygVar.eeB.dDI = R.layout.bap;
                ygVar.eeB.dDJ = "";
                ygVar.eeB.position = 0;
            }
            if (!ac.jPM) {
                if (this.gpc.gpk == 0 || Util.ticksToNow(this.gpc.gpk) >= 1800000) {
                    this.gpc.gpk = Util.currentTicks();
                } else {
                    Log.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                    AppMethodBeat.o(20101);
                    return false;
                }
            }
            if (!ac.jPN) {
                try {
                    long j2 = Util.getLong(parseXml.get(".e.ExpiredTime"), 0);
                    if (Util.secondsToNow(j2) > 0) {
                        Log.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", Long.valueOf(j2));
                        AppMethodBeat.o(20101);
                        return false;
                    }
                } catch (Exception e2) {
                    Log.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e2);
                }
            }
            this.gpc.gpj = parseXml.get(".e.NoticeId");
            String string = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aps()).getString("disaster_noticeid_list_key", "");
            if (ac.jPO || !string.contains(this.gpc.gpj)) {
                String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                String str8 = null;
                String str9 = null;
                String str10 = null;
                int i2 = 0;
                while (true) {
                    String str11 = ".e.Item" + (i2 == 0 ? "" : Integer.valueOf(i2));
                    String str12 = parseXml.get(str11 + ".Language");
                    if (str12 == null && i2 > 3) {
                        str3 = null;
                        str4 = null;
                        str2 = null;
                        break;
                    } else if (currentLanguage.equalsIgnoreCase(str12)) {
                        str4 = parseXml.get(str11 + ".Content");
                        str3 = parseXml.get(str11 + ".Url");
                        str2 = parseXml.get(str11 + ".Tips");
                        break;
                    } else {
                        if (LocaleUtil.ENGLISH.equalsIgnoreCase(str12)) {
                            str7 = parseXml.get(str11 + ".Content");
                            str6 = parseXml.get(str11 + ".Url");
                            str5 = parseXml.get(str11 + ".Tips");
                        } else {
                            str5 = str8;
                            str6 = str9;
                            str7 = str10;
                        }
                        i2++;
                        str8 = str5;
                        str9 = str6;
                        str10 = str7;
                    }
                }
                if (Util.isNullOrNil(str4)) {
                    Log.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
                } else {
                    str9 = str3;
                    str10 = str4;
                    str8 = str2;
                }
                if (Util.isNullOrNil(str9)) {
                    str9 = MMApplicationContext.getContext().getString(R.string.bn2);
                }
                if (Util.isNullOrNil(str10)) {
                    Log.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                    str10 = MMApplicationContext.getContext().getString(R.string.bmv);
                }
                if (Util.isNullOrNil(str8)) {
                    if (Util.isNullOrNil(str10)) {
                        str8 = MMApplicationContext.getContext().getString(R.string.bmz);
                    } else {
                        str8 = str10;
                    }
                }
                final yg ygVar2 = this.gpc.gpm.get(0);
                ygVar2.eeB.desc = str8;
                ygVar2.eeB.url = str9;
                ygVar2.eeB.visible = true;
                ygVar2.eeB.dDH = 2;
                ygVar2.eeB.dDJ = this.gpc.gpj;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.h.b.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(20096);
                        Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
                        EventCenter.instance.publish(ygVar2);
                        AppMethodBeat.o(20096);
                    }
                });
                this.gpc.gpl = str10;
                if (bg.azz().foreground) {
                    alz();
                }
                AppMethodBeat.o(20101);
                return true;
            }
            Log.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", string, this.gpc.gpj);
            AppMethodBeat.o(20101);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void alz() {
        AppMethodBeat.i(20102);
        if (this.gpc == null || this.gpc.gpm.get(0) == null || Util.isNullOrNil(this.gpc.gpl)) {
            AppMethodBeat.o(20102);
            return;
        }
        Log.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", this.gpc.gpl);
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", this.gpc.gpl);
        intent.putExtra("key_disaster_url", this.gpc.gpm.get(0).eeB.url);
        intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
        Context context = MMApplicationContext.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.gpc.gpl = null;
        AppMethodBeat.o(20102);
    }
}
