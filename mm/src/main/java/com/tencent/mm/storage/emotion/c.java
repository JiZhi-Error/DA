package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class c extends MAutoStorage<EmojiGroupInfo> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(EmojiGroupInfo.info, "EmojiGroupInfo")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(105013);
        boolean c2 = c(emojiGroupInfo);
        AppMethodBeat.o(105013);
        return c2;
    }

    static {
        AppMethodBeat.i(105014);
        AppMethodBeat.o(105014);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, EmojiGroupInfo.info, "EmojiGroupInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean init(Context context) {
        AppMethodBeat.i(104984);
        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        jE(context);
        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        AppMethodBeat.o(104984);
        return true;
    }

    private ArrayList<EmojiGroupInfo> jE(Context context) {
        boolean z;
        AppMethodBeat.i(104985);
        InputStream inputStream = null;
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList<>();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            InputStream open = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(open).getDocumentElement().getElementsByTagName("catalog");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                Element element = (Element) elementsByTagName.item(i2);
                int intValue = Integer.decode(element.getAttribute("id")).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort")));
                    int i3 = EmojiGroupInfo.VkO;
                    if ((intValue & i3) == i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || (gEC() <= 0 && !gEJ())) {
                        emojiGroupInfo.field_sort = i2 + 1;
                    } else {
                        emojiGroupInfo.field_sort = -1;
                        com.tencent.mm.kernel.g.aAh().azQ().set(208912, Boolean.TRUE);
                        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                emojiGroupInfo.field_productID = String.valueOf(intValue);
                emojiGroupInfo.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute("type"))) {
                    emojiGroupInfo.field_type = Integer.decode(element.getAttribute("type")).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    emojiGroupInfo.field_packType = Integer.decode(element.getAttribute("free")).intValue();
                }
                if (emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_SYSTEM || emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                    arrayList.add(emojiGroupInfo);
                }
            }
            if (arrayList.size() > 0) {
                iY(arrayList);
            }
            Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e2, "", new Object[0]);
                }
            }
        } catch (IOException e3) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", Util.stackTraceToString(e3));
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e3.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e4, "", new Object[0]);
                }
            }
        } catch (Exception e5) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", Util.stackTraceToString(e5));
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e5.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e6, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e7) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e7, "", new Object[0]);
                }
            }
            AppMethodBeat.o(104985);
            throw th;
        }
        AppMethodBeat.o(104985);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiGroupInfo di(java.lang.String r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.di(java.lang.String, boolean):com.tencent.mm.storage.emotion.EmojiGroupInfo");
    }

    private int gEC() {
        int i2 = 0;
        AppMethodBeat.i(104987);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select  count(*) from EmojiInfo where catalog=?", new String[]{new StringBuilder().append(EmojiGroupInfo.VkP).toString()}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e2.getMessage());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(104987);
            throw th;
        }
        AppMethodBeat.o(104987);
        return i2;
    }

    public final boolean gED() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(104988);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select * from EmojiGroupInfo where type=?", new String[]{new StringBuilder().append(EmojiGroupInfo.TYPE_SYSTEM).toString()}, 2);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(104988);
                return false;
            }
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.convertFrom(rawQuery);
            if ((emojiGroupInfo.field_flag & 256) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = false;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(104988);
            return z2;
        } catch (Exception e2) {
            Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(104988);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.storage.emotion.EmojiGroupInfo> gEE() {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEE():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.String, com.tencent.mm.storage.emotion.EmojiGroupInfo> gEF() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEF():java.util.HashMap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.EmojiGroupInfo> gEG() {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEG():java.util.ArrayList");
    }

    public final int gEH() {
        Cursor cursor = null;
        int i2 = 0;
        AppMethodBeat.i(104992);
        try {
            Cursor rawQuery = this.db.rawQuery("select count(*) from EmojiGroupInfo where " + gEN() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e2.getMessage());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(104992);
            throw th;
        }
        AppMethodBeat.o(104992);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.String, com.tencent.mm.storage.bh> gEI() {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEI():java.util.HashMap");
    }

    public final boolean blb(String str) {
        Cursor cursor = null;
        boolean z = false;
        AppMethodBeat.i(104994);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            Cursor rawQuery = this.db.rawQuery("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND " + gEO() + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null, 2);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(104994);
                return z;
            }
            if (rawQuery.getInt(0) > 0) {
                z = true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(104994);
            return z;
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e2.getMessage());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(104994);
            throw th;
        }
    }

    public static boolean gEJ() {
        AppMethodBeat.i(104995);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(208912, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(104995);
        return booleanValue;
    }

    public final boolean c(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(104996);
        if (emojiGroupInfo == null) {
            Log.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            AppMethodBeat.o(104996);
            return false;
        }
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        emojiGroupInfo.field_sort = 1;
        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", emojiGroupInfo.field_packName, Long.valueOf(emojiGroupInfo.field_lastUseTime));
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        d(emojiGroupInfo);
        boolean replace = replace(emojiGroupInfo);
        if (replace) {
            doNotify("event_update_group", 0, Util.getStack().toString());
        }
        AppMethodBeat.o(104996);
        return replace;
    }

    public final boolean iY(List<EmojiGroupInfo> list) {
        long j2;
        AppMethodBeat.i(104997);
        if (list == null || list.size() <= 0) {
            Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            AppMethodBeat.o(104997);
            return false;
        }
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", Long.valueOf(j2));
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            EmojiGroupInfo emojiGroupInfo = list.get(i2);
            Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", emojiGroupInfo.field_productID, Long.valueOf(emojiGroupInfo.field_lastUseTime), Integer.valueOf(emojiGroupInfo.field_sort));
            replace(emojiGroupInfo);
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        doNotify("event_update_group", 0, Util.getStack().toString());
        AppMethodBeat.o(104997);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean blc(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.blc(java.lang.String):boolean");
    }

    public final void bj(ArrayList<String> arrayList) {
        long j2;
        AppMethodBeat.i(104999);
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", Long.valueOf(j2));
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                blc(it.next());
            }
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
        AppMethodBeat.o(104999);
    }

    public final boolean gEK() {
        AppMethodBeat.i(105000);
        if (this.db.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", new String[]{"1", new StringBuilder().append(EmojiGroupInfo.VkK).toString(), "7"}) > 0) {
            AppMethodBeat.o(105000);
            return true;
        }
        AppMethodBeat.o(105000);
        return false;
    }

    public final boolean bk(ArrayList<EmojiGroupInfo> arrayList) {
        AppMethodBeat.i(105001);
        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
        boolean iY = iY(arrayList);
        AppMethodBeat.o(105001);
        return iY;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.EmojiGroupInfo> gEL() {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEL():java.util.ArrayList");
    }

    private static boolean d(EmojiGroupInfo emojiGroupInfo) {
        if (emojiGroupInfo == null) {
            return false;
        }
        emojiGroupInfo.field_flag &= -257;
        return true;
    }

    private static String gEM() {
        AppMethodBeat.i(105003);
        String str = ako(EmojiGroupInfo.TYPE_SYSTEM) + " or " + ako(EmojiGroupInfo.TYPE_CUSTOM) + " or " + ako(EmojiGroupInfo.VkK) + " or " + ako(EmojiGroupInfo.VkM);
        AppMethodBeat.o(105003);
        return str;
    }

    private static final String gEN() {
        AppMethodBeat.i(105004);
        String str = " ( " + ako(EmojiGroupInfo.VkK) + " and " + gEO() + " ) ";
        AppMethodBeat.o(105004);
        return str;
    }

    private static final String ako(int i2) {
        AppMethodBeat.i(105005);
        String str = " ( type = '" + i2 + "' ) ";
        AppMethodBeat.o(105005);
        return str;
    }

    private static final String gEO() {
        AppMethodBeat.i(199821);
        String sb = new StringBuilder(" ( status = '7' ) ").toString();
        AppMethodBeat.o(199821);
        return sb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean gEP() {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEP():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> gEQ() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gEQ():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> gER() {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gER():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.EmojiGroupInfo> gES() {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.c.gES():java.util.ArrayList");
    }

    public final void gET() {
        AppMethodBeat.i(105010);
        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        EmojiGroupInfo di = di(String.valueOf(EmojiGroupInfo.VkO), false);
        if (di == null) {
            di = new EmojiGroupInfo();
        } else {
            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", di.toString());
        }
        di.field_productID = String.valueOf(EmojiGroupInfo.VkO);
        di.field_packName = "emoji_custom_group";
        di.field_type = EmojiGroupInfo.TYPE_CUSTOM;
        di.field_status = 0;
        di.field_packStatus = 1;
        di.field_flag = 0;
        replace(di);
        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
        AppMethodBeat.o(105010);
    }

    public final boolean gEU() {
        long j2;
        int i2;
        int bld;
        AppMethodBeat.i(105011);
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        ArrayList<EmojiGroupInfo> gEG = gEG();
        if (!gEG.isEmpty()) {
            Iterator<EmojiGroupInfo> it = gEG.iterator();
            while (it.hasNext()) {
                EmojiGroupInfo next = it.next();
                if (!(next == null || Util.isNullOrNil(next.field_productID) || next.field_count == (bld = bld(next.field_productID)))) {
                    next.field_count = bld;
                    this.db.update("EmojiGroupInfo", next.convertTo(), "productID=?", new String[]{next.field_productID});
                }
            }
        }
        if (hVar != null) {
            i2 = hVar.endTransaction(j2);
        } else {
            i2 = -1;
        }
        doNotify("event_update_group", 0, Util.getStack().toString());
        if (i2 >= 0) {
            AppMethodBeat.o(105011);
            return true;
        }
        AppMethodBeat.o(105011);
        return false;
    }

    private int bld(String str) {
        int i2;
        AppMethodBeat.i(105012);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                i2 = 0;
            } else {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e2.getMessage());
            if (0 != 0) {
                cursor.close();
                i2 = 0;
            } else {
                i2 = 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105012);
            throw th;
        }
        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(105012);
        return i2;
    }
}
