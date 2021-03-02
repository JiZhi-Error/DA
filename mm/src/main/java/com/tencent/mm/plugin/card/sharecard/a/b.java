package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean gYQ = false;
    public static boolean pVM = false;
    private Context mContext;
    public b.a pVL = null;

    public b(Context context) {
        this.mContext = context;
        pVM = false;
    }

    public static int cuv() {
        int i2 = 0;
        AppMethodBeat.i(112924);
        c ctQ = am.ctQ();
        StringBuilder sb = new StringBuilder();
        sb.append(" where (status=0 OR status=5) AND ").append("card_type=10");
        Cursor rawQuery = ctQ.db.rawQuery("select count(*) from UserCardInfo" + sb.toString(), null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(112924);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(112924);
        }
        return i2;
    }

    public final void aL(String str, boolean z) {
        AppMethodBeat.i(112925);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            AppMethodBeat.o(112925);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l akn = t.akn(str);
        l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
        if (akn == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(akn, lVar, z);
            am.ctV().putValue("key_share_card_layout_data", akn);
            AppMethodBeat.o(112925);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.d.l.akf(str);
        }
        a(akn, z);
        a(akn, lVar, z);
        am.ctV().putValue("key_share_card_layout_data", akn);
        int i2 = 0;
        if (akn.pVZ != null && akn.pVZ.size() > 0) {
            i2 = akn.pVZ.size();
        }
        if (akn.pWa != null && akn.pWa.size() > 0) {
            i2 += akn.pWa.size();
        }
        if (i2 > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(281);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i2);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(281);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i2));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            h.INSTANCE.b(arrayList, true);
        }
        AppMethodBeat.o(112925);
    }

    private void a(l lVar, boolean z) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        AppMethodBeat.i(112926);
        if (lVar == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            AppMethodBeat.o(112926);
            return;
        }
        Log.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) am.ctV().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        Map map2 = (Map) am.ctV().getValue("key_share_card_count_map");
        if (map2 == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map2;
        }
        Map map3 = (Map) am.ctV().getValue("key_share_card_username_map");
        if (map3 == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map3;
        }
        ArrayList arrayList4 = (ArrayList) am.ctV().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        ArrayList arrayList5 = (ArrayList) am.ctV().getValue("key_share_card_other_city_ids");
        if (arrayList5 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList5;
        }
        ArrayList arrayList6 = (ArrayList) am.ctV().getValue("key_share_card_other_city_top_info_list");
        if (arrayList6 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList6;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList7 = new ArrayList();
        if (lVar.pVZ != null && lVar.pVZ.size() > 0) {
            for (int i2 = 0; i2 < lVar.pVZ.size(); i2++) {
                m mVar = lVar.pVZ.get(i2);
                if (!TextUtils.isEmpty(mVar.pWh)) {
                    hashMap.put(mVar.pRX, mVar.pWh);
                }
                hashMap2.put(mVar.pRX, Integer.valueOf(am.ctY().ajx(mVar.pRX)));
                hashMap3.put(mVar.pRX, O(am.ctY().ajw(mVar.pRX)));
                if (!arrayList7.contains(mVar.pRX)) {
                    String ajy = am.ctY().ajy(mVar.pRX);
                    if (!TextUtils.isEmpty(ajy) && !arrayList.contains(ajy)) {
                        arrayList.add(ajy);
                    } else if (!arrayList.contains(mVar.eaO)) {
                        arrayList.add(mVar.eaO);
                    }
                    arrayList7.add(mVar.pRX);
                    p pVar = new p();
                    pVar.pRX = mVar.pRX;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
            }
        }
        arrayList7.clear();
        if (lVar.pWa != null && lVar.pWa.size() > 0) {
            for (int i3 = 0; i3 < lVar.pWa.size(); i3++) {
                m mVar2 = lVar.pWa.get(i3);
                if (!TextUtils.isEmpty(mVar2.pWh)) {
                    hashMap.put(mVar2.pRX, mVar2.pWh);
                }
                hashMap2.put(mVar2.pRX, Integer.valueOf(am.ctY().ajx(mVar2.pRX)));
                hashMap3.put(mVar2.pRX, O(am.ctY().ajw(mVar2.pRX)));
                if (!arrayList7.contains(mVar2.pRX)) {
                    String ajy2 = am.ctY().ajy(mVar2.pRX);
                    if (!TextUtils.isEmpty(ajy2) && !arrayList2.contains(ajy2)) {
                        arrayList2.add(ajy2);
                    } else if (!arrayList2.contains(mVar2.eaO)) {
                        arrayList2.add(mVar2.eaO);
                    }
                    arrayList7.add(mVar2.pRX);
                    p pVar2 = new p();
                    pVar2.pRX = mVar2.pRX;
                    pVar2.top = mVar2.top;
                    arrayList3.add(pVar2);
                }
            }
        }
        am.ctV().putValue("key_share_card_annoucement_map", hashMap);
        am.ctV().putValue("key_share_card_count_map", hashMap2);
        am.ctV().putValue("key_share_card_username_map", hashMap3);
        am.ctV().putValue("key_share_card_local_city", lVar.pWb);
        am.ctV().putValue("key_share_card_local_city_ids", arrayList);
        am.ctV().putValue("key_share_card_other_city_ids", arrayList2);
        am.ctV().putValue("key_share_card_other_city_top_info_list", arrayList3);
        AppMethodBeat.o(112926);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        AppMethodBeat.i(112927);
        if (lVar == null && lVar2 == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
            AppMethodBeat.o(112927);
        } else if (lVar != null && lVar.pWa == null && lVar.pVZ == null && lVar2 != null && lVar2.pWa == null && lVar2.pVZ == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
            AppMethodBeat.o(112927);
        } else {
            Log.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) am.ctV().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            ArrayList arrayList4 = (ArrayList) am.ctV().getValue("key_share_card_other_city_category_info_list");
            if (arrayList4 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList4;
            }
            int i2 = 0;
            if (z) {
                am.ctY().El(10);
                arrayList.clear();
                am.ctY().El(0);
                arrayList2.clear();
                size = 0;
            } else {
                if (!(lVar2 == null || lVar2.pVZ == null || lVar2.pVZ.size() < 0)) {
                    i2 = lVar2.pVZ.size();
                }
                size = (lVar2 == null || lVar2.pWa == null || lVar2.pWa.size() < 0) ? 0 : lVar2.pWa.size();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            if (lVar != null && lVar.pVZ != null && lVar.pVZ.size() > 0) {
                for (int i3 = 0; i3 < lVar.pVZ.size(); i3++) {
                    m mVar = lVar.pVZ.get(i3);
                    am.ctY().W(mVar.pRX, 10, i3 + i2);
                    i iVar = new i();
                    iVar.pRX = mVar.pRX;
                    iVar.pVV = i3 + i2;
                    arrayList.add(iVar);
                }
                if (!(z || lVar2 == null || lVar2.pVZ == null)) {
                    lVar.pVZ.addAll(lVar2.pVZ);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.pVZ == null)) {
                lVar.pVZ = lVar2.pVZ;
            }
            am.ctV().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.pWa != null && lVar.pWa.size() > 0) {
                for (int i4 = 0; i4 < lVar.pWa.size(); i4++) {
                    m mVar2 = lVar.pWa.get(i4);
                    am.ctY().W(mVar2.pRX, 0, i4 + size);
                    i iVar2 = new i();
                    iVar2.pRX = mVar2.pRX;
                    iVar2.pVV = i4 + size;
                    arrayList2.add(iVar2);
                }
                if (!(z || lVar2 == null || lVar2.pWa == null)) {
                    lVar.pWa.addAll(lVar2.pWa);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.pWa == null)) {
                lVar.pWa = lVar2.pWa;
            }
            am.ctV().putValue("key_share_card_other_city_category_info_list", arrayList2);
            g.aAh().hqK.endTransaction(beginTransaction);
            Log.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(112927);
        }
    }

    public static void cuw() {
        ArrayList arrayList;
        ArrayList arrayList2;
        AppMethodBeat.i(112928);
        long currentTimeMillis = System.currentTimeMillis();
        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        Log.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) am.ctV().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        ArrayList arrayList4 = (ArrayList) am.ctV().getValue("key_share_card_other_city_category_info_list");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            i iVar = (i) arrayList.get(i2);
            am.ctY().W(iVar.pRX, 10, iVar.pVV);
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            i iVar2 = (i) arrayList2.get(i3);
            am.ctY().W(iVar2.pRX, 0, iVar2.pVV);
        }
        g.aAh().hqK.endTransaction(beginTransaction);
        Log.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(112928);
    }

    private String O(ArrayList<String> arrayList) {
        AppMethodBeat.i(112929);
        String b2 = b(this.mContext, arrayList);
        AppMethodBeat.o(112929);
        return b2;
    }

    private static String b(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(112930);
        if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            AppMethodBeat.o(112930);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < arrayList.size() && i2 < 2) {
            if (i2 != 0) {
                sb.append("、");
            }
            String Is = aa.Is(arrayList.get(i2));
            String displayName = aa.getDisplayName(arrayList.get(i2));
            if (!TextUtils.isEmpty(Is)) {
                sb.append(Is);
            } else {
                sb.append(displayName);
            }
            i2++;
        }
        if (context == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "context == null");
            AppMethodBeat.o(112930);
            return "";
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            String string = context.getString(R.string.asv, sb.toString());
            AppMethodBeat.o(112930);
            return string;
        } else {
            String string2 = context.getString(R.string.asc, sb.toString(), Integer.valueOf(arrayList.size()));
            AppMethodBeat.o(112930);
            return string2;
        }
    }

    public static void ajq(final String str) {
        AppMethodBeat.i(112931);
        Log.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            AppMethodBeat.o(112931);
            return;
        }
        final MMHandler mMHandler = new MMHandler(Looper.getMainLooper());
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.sharecard.a.b.AnonymousClass1 */

            public final void run() {
                final ArrayList arrayList = null;
                AppMethodBeat.i(112921);
                Log.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                k ctY = am.ctY();
                String str = str;
                Log.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder sb = new StringBuilder();
                sb.append(" where ( status=0) ");
                sb.append(" AND (card_tp_id = '" + str + "' )");
                sb.append(" order by share_time desc ");
                Cursor rawQuery = ctY.db.rawQuery("select * from ShareCardInfo" + sb.toString(), null, 2);
                if (rawQuery == null) {
                    Log.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (rawQuery.moveToNext()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.convertFrom(rawQuery);
                        if (!arrayList3.contains(shareCardInfo.field_from_username)) {
                            r rVar = new r();
                            rVar.pRX = shareCardInfo.field_card_tp_id;
                            rVar.pWm = shareCardInfo.field_from_username;
                            rVar.pWo = new ArrayList<>();
                            rVar.pWo.add(shareCardInfo.field_card_id);
                            rVar.pWn = 1;
                            arrayList2.add(rVar);
                            arrayList3.add(shareCardInfo.field_from_username);
                        } else {
                            int i2 = 0;
                            r rVar2 = null;
                            while (true) {
                                if (i2 >= arrayList2.size()) {
                                    i2 = 0;
                                    break;
                                }
                                rVar2 = (r) arrayList2.get(i2);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar2.pWm)) {
                                    break;
                                }
                                i2++;
                            }
                            if (rVar2 != null) {
                                rVar2.pWo.add(0, shareCardInfo.field_card_id);
                                rVar2.pWn++;
                                arrayList2.set(i2, rVar2);
                            }
                        }
                    }
                    rawQuery.close();
                    arrayList = arrayList2;
                }
                Log.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    Log.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    AppMethodBeat.o(112921);
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((r) arrayList.get(0)).pWp = true;
                }
                Log.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                mMHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.card.sharecard.a.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(112920);
                        Map map = (Map) am.ctV().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        am.ctV().putValue("key_share_user_info_map", map);
                        AppMethodBeat.o(112920);
                    }
                });
                AppMethodBeat.o(112921);
            }
        }, "updateShareUserInfo_thread");
        AppMethodBeat.o(112931);
    }

    public static ArrayList<String> Eh(int i2) {
        AppMethodBeat.i(112932);
        if (i2 == 1) {
            ArrayList<String> arrayList = (ArrayList) am.ctV().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                Log.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i2)));
                ArrayList<String> Ei = Ei(i2);
                AppMethodBeat.o(112932);
                return Ei;
            }
            AppMethodBeat.o(112932);
            return arrayList;
        } else if (i2 == 2) {
            ArrayList<String> arrayList2 = (ArrayList) am.ctV().getValue("key_share_card_other_city_ids");
            if (arrayList2 == null || arrayList2.size() == 0) {
                Log.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i2)));
                ArrayList<String> Ei2 = Ei(i2);
                AppMethodBeat.o(112932);
                return Ei2;
            }
            AppMethodBeat.o(112932);
            return arrayList2;
        } else {
            AppMethodBeat.o(112932);
            return null;
        }
    }

    private static ArrayList<String> Ei(int i2) {
        int i3 = 0;
        AppMethodBeat.i(112933);
        l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
        if (lVar == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(112933);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (i2 == 1) {
            if (lVar.pVZ != null && lVar.pVZ.size() > 0) {
                while (i3 < lVar.pVZ.size()) {
                    m mVar = lVar.pVZ.get(i3);
                    if (!arrayList2.contains(mVar.pRX)) {
                        String ajy = am.ctY().ajy(mVar.pRX);
                        if (!TextUtils.isEmpty(ajy) && !arrayList.contains(ajy)) {
                            arrayList.add(ajy);
                        } else if (!arrayList.contains(mVar.eaO)) {
                            arrayList.add(mVar.eaO);
                        }
                        arrayList2.add(mVar.pRX);
                    }
                    i3++;
                }
                am.ctV().putValue("key_share_card_local_city_ids", arrayList);
            }
            AppMethodBeat.o(112933);
            return arrayList;
        } else if (i2 == 2) {
            if (lVar.pWa != null && lVar.pWa.size() > 0) {
                while (i3 < lVar.pWa.size()) {
                    m mVar2 = lVar.pWa.get(i3);
                    if (!arrayList2.contains(mVar2.pRX)) {
                        String ajy2 = am.ctY().ajy(mVar2.pRX);
                        if (!TextUtils.isEmpty(ajy2) && !arrayList.contains(ajy2)) {
                            arrayList.add(ajy2);
                        } else if (!arrayList.contains(mVar2.eaO)) {
                            arrayList.add(mVar2.eaO);
                        }
                        arrayList2.add(mVar2.pRX);
                    }
                    i3++;
                }
                am.ctV().putValue("key_share_card_other_city_ids", arrayList);
            }
            AppMethodBeat.o(112933);
            return arrayList;
        } else {
            AppMethodBeat.o(112933);
            return null;
        }
    }

    public static void fs(String str, String str2) {
        AppMethodBeat.i(112934);
        if (gYQ) {
            Log.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            AppMethodBeat.o(112934);
            return;
        }
        Log.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        gYQ = true;
        ArrayList<String> Eh = Eh(1);
        if (Eh != null && Eh.contains(str)) {
            Eh.remove(str);
            String fv = am.ctY().fv(str, str2);
            if (!TextUtils.isEmpty(fv)) {
                Eh.add(fv);
            }
            am.ctV().putValue("key_share_card_local_city_ids", Eh);
        }
        ArrayList<String> Eh2 = Eh(2);
        if (Eh2 != null && Eh2.contains(str)) {
            Eh2.remove(str);
            String fv2 = am.ctY().fv(str, str2);
            if (!TextUtils.isEmpty(fv2)) {
                Eh2.add(fv2);
            }
            am.ctV().putValue("key_share_card_other_city_ids", Eh2);
        }
        gYQ = false;
        AppMethodBeat.o(112934);
    }

    public static void ft(String str, String str2) {
        AppMethodBeat.i(112935);
        Log.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList<String> Eh = Eh(1);
        if (Eh == null || !Eh.contains(str)) {
            ArrayList<String> Eh2 = Eh(2);
            if (Eh2 == null || !Eh2.contains(str)) {
                l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    Log.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    AppMethodBeat.o(112935);
                    return;
                }
                int ajx = am.ctY().ajx(str2);
                int ajs = ajs(str2);
                Log.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + ajx + " cacheCount:" + ajs);
                if (lVar.pVZ == null || lVar.pVZ.size() <= 0 || (ajs > 0 && ajx != 1)) {
                    Log.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                } else {
                    for (int i2 = 0; i2 < lVar.pVZ.size(); i2++) {
                        m mVar = lVar.pVZ.get(i2);
                        if (str2 != null && str2.contains(mVar.pRX)) {
                            Eh.add(str);
                            am.ctV().putValue("key_share_card_local_city_ids", Eh);
                            Log.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is ".concat(String.valueOf(str)));
                            AppMethodBeat.o(112935);
                            return;
                        }
                    }
                }
                if (Eh2 == null || (ajs > 0 && ajx != 1)) {
                    Log.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    AppMethodBeat.o(112935);
                    return;
                }
                Eh2.add(str);
                am.ctV().putValue("key_share_card_other_city_ids", Eh2);
                Log.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is ".concat(String.valueOf(str)));
                AppMethodBeat.o(112935);
                return;
            }
            AppMethodBeat.o(112935);
            return;
        }
        AppMethodBeat.o(112935);
    }

    public static int cux() {
        AppMethodBeat.i(112936);
        if (cuz()) {
            AppMethodBeat.o(112936);
            return 1;
        } else if (!cuy()) {
            AppMethodBeat.o(112936);
            return 0;
        } else if (pVM) {
            AppMethodBeat.o(112936);
            return 3;
        } else {
            AppMethodBeat.o(112936);
            return 4;
        }
    }

    public static boolean cuy() {
        AppMethodBeat.i(112937);
        ArrayList arrayList = (ArrayList) am.ctV().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(112937);
            return false;
        }
        AppMethodBeat.o(112937);
        return true;
    }

    public static boolean cuz() {
        AppMethodBeat.i(112938);
        ArrayList arrayList = (ArrayList) am.ctV().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(112938);
            return false;
        }
        AppMethodBeat.o(112938);
        return true;
    }

    public static String ajr(String str) {
        AppMethodBeat.i(112939);
        Map map = (Map) am.ctV().getValue("key_share_card_annoucement_map");
        if (map == null) {
            AppMethodBeat.o(112939);
            return "";
        }
        String str2 = (String) map.get(str);
        AppMethodBeat.o(112939);
        return str2;
    }

    public static int ajs(String str) {
        AppMethodBeat.i(112940);
        Map map = (Map) am.ctV().getValue("key_share_card_count_map");
        if (map == null) {
            AppMethodBeat.o(112940);
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            AppMethodBeat.o(112940);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(112940);
        return intValue;
    }

    public static String NH(String str) {
        AppMethodBeat.i(112941);
        Map map = (Map) am.ctV().getValue("key_share_card_username_map");
        if (map == null) {
            AppMethodBeat.o(112941);
            return "";
        }
        String str2 = (String) map.get(str);
        AppMethodBeat.o(112941);
        return str2;
    }

    public static ArrayList<r> ajt(String str) {
        AppMethodBeat.i(112942);
        Map map = (Map) am.ctV().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            ArrayList<r> arrayList2 = new ArrayList<>();
            AppMethodBeat.o(112942);
            return arrayList2;
        }
        AppMethodBeat.o(112942);
        return arrayList;
    }

    private static void U(String str, String str2, String str3) {
        HashMap hashMap;
        ArrayList arrayList;
        AppMethodBeat.i(112943);
        Map map = (Map) am.ctV().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            r rVar = (r) arrayList.get(i2);
            if (str3 != null && str3.equals(rVar.pWm)) {
                rVar.pWp = false;
                rVar.pWn--;
                rVar.pWo.remove(str);
                arrayList.set(i2, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        am.ctV().putValue("key_share_user_info_map", hashMap);
        AppMethodBeat.o(112943);
    }

    public static void cuA() {
        AppMethodBeat.i(112944);
        Log.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.sharecard.a.b.AnonymousClass2 */

            public final void run() {
                int i2;
                AppMethodBeat.i(112922);
                Log.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
                k ctY = am.ctY();
                StringBuilder sb = new StringBuilder();
                sb.append(" where (status=1 OR status=2 OR status").append("=3 OR status=4 OR status=6)");
                boolean execSQL = ctY.db.execSQL("ShareCardInfo", "delete from ShareCardInfo" + sb.toString());
                StringBuilder sb2 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
                if (execSQL) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                Log.i("MicroMsg.ShareCardInfoStorage", sb2.append(i2).toString());
                Log.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
                AppMethodBeat.o(112922);
            }
        }, "delelteAllIllegalStatusCard");
        AppMethodBeat.o(112944);
    }

    public static void al(Context context, String str) {
        HashMap hashMap;
        AppMethodBeat.i(112945);
        Log.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:".concat(String.valueOf(str)));
        Map map = (Map) am.ctV().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        Map map2 = (Map) am.ctV().getValue("key_share_card_username_map");
        if (map2 == null) {
            map2 = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(am.ctY().ajx(str)));
        map2.put(str, b(context, am.ctY().ajw(str)));
        am.ctV().putValue("key_share_card_count_map", hashMap);
        am.ctV().putValue("key_share_card_username_map", map2);
        AppMethodBeat.o(112945);
    }

    public static boolean Ej(int i2) {
        AppMethodBeat.i(112946);
        Integer num = (Integer) am.ctV().getValue("key_share_card_show_type");
        if (num == null) {
            AppMethodBeat.o(112946);
            return false;
        } else if (num.intValue() == 0) {
            AppMethodBeat.o(112946);
            return false;
        } else if (i2 == 0) {
            ArrayList arrayList = (ArrayList) am.ctV().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.o(112946);
                return false;
            }
            AppMethodBeat.o(112946);
            return true;
        } else if (i2 == 10) {
            ArrayList arrayList2 = (ArrayList) am.ctV().getValue("key_share_card_local_city_ids");
            if (arrayList2 == null || arrayList2.size() == 0) {
                AppMethodBeat.o(112946);
                return false;
            }
            AppMethodBeat.o(112946);
            return true;
        } else {
            AppMethodBeat.o(112946);
            return false;
        }
    }

    public static boolean aju(String str) {
        AppMethodBeat.i(112947);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112947);
            return false;
        }
        ArrayList arrayList = (ArrayList) am.ctV().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.pRX) && pVar.top == 1) {
                AppMethodBeat.o(112947);
                return true;
            }
        }
        AppMethodBeat.o(112947);
        return false;
    }

    public static void ajv(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(112948);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112948);
            return;
        }
        ArrayList arrayList2 = (ArrayList) am.ctV().getValue("key_share_card_other_city_top_info_list");
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            p pVar = (p) arrayList.get(i2);
            if (pVar != null && str.equals(pVar.pRX) && pVar.top == 1) {
                pVar.pWl = true;
                arrayList.set(i2, pVar);
                am.ctV().putValue("key_share_card_other_city_top_info_list", arrayList);
                AppMethodBeat.o(112948);
                return;
            }
        }
        AppMethodBeat.o(112948);
    }

    public static String fu(String str, String str2) {
        AppMethodBeat.i(112949);
        Log.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList<r> ajt = ajt(str2);
            if (ajt == null || ajt.size() <= 0) {
                Log.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
            } else {
                r rVar = ajt.get(0);
                if (rVar == null || rVar.pWo == null || rVar.pWo.size() <= 0 || str.equals(rVar.pWo.get(0))) {
                    Log.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                } else {
                    Log.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
                    str = rVar.pWo.get(0);
                }
            }
        } else {
            Log.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        }
        AppMethodBeat.o(112949);
        return str;
    }

    public static boolean cuB() {
        AppMethodBeat.i(112950);
        l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
        if (lVar == null) {
            AppMethodBeat.o(112950);
            return true;
        }
        boolean z = lVar.pWc;
        AppMethodBeat.o(112950);
        return z;
    }

    public static boolean cuC() {
        AppMethodBeat.i(112951);
        l lVar = (l) am.ctV().getValue("key_share_card_layout_data");
        if (lVar == null) {
            AppMethodBeat.o(112951);
            return true;
        }
        boolean z = lVar.pWd;
        AppMethodBeat.o(112951);
        return z;
    }

    public static boolean cuD() {
        AppMethodBeat.i(112952);
        Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, (Object) 0);
        if (num == null || num.intValue() != 1) {
            g.aAh().azQ().set(ar.a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, (Object) 1);
            Cursor a2 = am.ctQ().a(n.a.NORMAL_TYPE);
            if (a2 == null || a2.getCount() <= 0) {
                if (a2 != null) {
                    a2.close();
                }
                Log.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                AppMethodBeat.o(112952);
                return false;
            }
            a2.moveToFirst();
            while (!a2.isAfterLast()) {
                CardInfo cardInfo = new CardInfo();
                cardInfo.convertFrom(a2);
                if (cardInfo.field_card_type == -1) {
                    if (cardInfo.csQ() == null) {
                        Log.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                    } else {
                        cardInfo.field_card_type = cardInfo.csQ().nHh;
                        if (!am.ctQ().update(cardInfo, new String[0])) {
                            Log.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", cardInfo.field_card_id);
                        }
                    }
                }
                a2.moveToNext();
            }
            a2.close();
            AppMethodBeat.o(112952);
            return true;
        }
        AppMethodBeat.o(112952);
        return false;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(112953);
        Log.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        Log.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.csU() + " cardtpid:" + bVar.csV());
        fs(bVar.csU(), bVar.csV());
        if (context != null) {
            al(context, bVar.csV());
        }
        U(bVar.csU(), bVar.csV(), bVar.csW());
        ajq(bVar.csV());
        AppMethodBeat.o(112953);
    }

    public final void init() {
        AppMethodBeat.i(112923);
        if (((l) am.ctV().getValue("key_share_card_layout_data")) == null) {
            Log.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            String cxI = com.tencent.mm.plugin.card.d.l.cxI();
            if (TextUtils.isEmpty(cxI)) {
                Log.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                AppMethodBeat.o(112923);
                return;
            }
            l akn = t.akn(cxI);
            if (akn != null) {
                Log.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                am.ctV().putValue("key_share_card_layout_data", akn);
                a(akn, true);
                AppMethodBeat.o(112923);
                return;
            }
            Log.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            AppMethodBeat.o(112923);
            return;
        }
        Log.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
        AppMethodBeat.o(112923);
    }
}
