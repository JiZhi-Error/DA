package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f extends MAutoStorage<EmojiInfo> implements g.a {
    private static int[] OsF = {2, 4, 8};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(EmojiInfo.info, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )", "CREATE INDEX IF NOT EXISTS emojiinfogatalogindex  on EmojiInfo  (  catalog )"};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105103);
        boolean K = K(emojiInfo);
        AppMethodBeat.o(105103);
        return K;
    }

    static {
        AppMethodBeat.i(105104);
        AppMethodBeat.o(105104);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, EmojiInfo.info, "EmojiInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.storagebase.g.a
    public final String getTableName() {
        return "EmojiInfo";
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    public final boolean init(Context context) {
        h hVar;
        AppMethodBeat.i(105058);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo blk = blk("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo blk2 = blk("68f9864ca5c0a5d823ed7184e113a4aa");
        int akr = akr(EmojiInfo.VkT);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", Integer.valueOf(akr));
        if (blk != null || ((blk2 != null && blk2.getContent().length() == 0) || akr <= 2)) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            akv(EmojiInfo.VkS);
            akv(EmojiInfo.VkV);
            akv(EmojiInfo.VkU);
        }
        EmojiInfo blk3 = blk("9bd1281af3a31710a45b84d736363691");
        if (blk3 != null && blk3.field_catalog == EmojiInfo.VkS) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            akv(EmojiInfo.VkS);
            akv(EmojiInfo.VkV);
            akv(EmojiInfo.VkU);
        }
        InputStream inputStream = EmojiInfo.m37do(context, "icon_002_cover.png");
        if (inputStream != null) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            akv(EmojiInfo.VkS);
            akv(EmojiInfo.VkV);
            akv(EmojiInfo.VkU);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e2) {
            }
        }
        if (akr(EmojiInfo.VkS) != 0) {
            AppMethodBeat.o(105058);
            return true;
        }
        InputStream inputStream2 = null;
        try {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            InputStream open = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a2 = a(new InputStream[]{open});
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a2.size() > 0 && a2.size() > 0) {
                long j2 = -1;
                if (this.db instanceof h) {
                    h hVar2 = (h) this.db;
                    j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                }
                Iterator<EmojiInfo> it = a2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (this.db.replace("EmojiInfo", "md5", it.next().convertTo()) < 0) {
                            if (hVar != null) {
                                hVar.endTransaction(j2);
                            }
                        }
                    } else if (hVar != null) {
                        hVar.endTransaction(j2);
                    }
                }
            }
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            Log.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e3) {
                    Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e3));
                }
            }
        } catch (IOException e4) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e4.getMessage());
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e5) {
                    Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e5));
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e6) {
                    Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e6));
                }
            }
            AppMethodBeat.o(105058);
            throw th;
        }
        AppMethodBeat.o(105058);
        return true;
    }

    public final EmojiInfo J(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105059);
        if (emojiInfo == null || Util.isNullOrNil(emojiInfo.getMd5()) || emojiInfo.getMd5().length() <= 0) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(105059);
            return null;
        }
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "create: %s", emojiInfo.field_md5);
        if (K(emojiInfo)) {
            doNotify("create_emoji_info_notify");
            AppMethodBeat.o(105059);
            return emojiInfo;
        }
        AppMethodBeat.o(105059);
        return null;
    }

    public final EmojiInfo d(String str, String str2, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(105060);
        EmojiInfo a2 = a(str, str2, i2, i3, i4, null, null, null, str3);
        AppMethodBeat.o(105060);
        return a2;
    }

    public final EmojiInfo a(String str, String str2, int i2, int i3, int i4, String str3, String str4) {
        AppMethodBeat.i(105061);
        EmojiInfo a2 = a(str, str2, i2, i3, i4, null, null, str3, str4);
        AppMethodBeat.o(105061);
        return a2;
    }

    public final EmojiInfo e(String str, String str2, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(105062);
        EmojiInfo a2 = a(str, str2, i2, i3, i4, null, null, null, str3);
        AppMethodBeat.o(105062);
        return a2;
    }

    public final EmojiInfo a(String str, String str2, int i2, int i3, int i4, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(199823);
        if (str == null || str.length() <= 0) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(199823);
            return null;
        }
        EmojiInfo a2 = a(str, str2, i2, i3, i4, null, null, str5, str6, 1);
        a2.field_state = EmojiInfo.Vle;
        if (K(a2)) {
            doNotify("create_emoji_info_notify");
            AppMethodBeat.o(199823);
            return a2;
        }
        AppMethodBeat.o(199823);
        return null;
    }

    private EmojiInfo a(String str, String str2, int i2, int i3, int i4, String str3, String str4, String str5, String str6, int i5) {
        AppMethodBeat.i(199824);
        if (str == null || str.length() <= 0) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            AppMethodBeat.o(199824);
            return null;
        }
        EmojiInfo blk = blk(str);
        if (blk == null) {
            com.tencent.mm.plugin.emoji.f.cER();
            blk = new EmojiInfo(com.tencent.mm.plugin.emoji.f.cES());
            blk.field_catalog = i2;
        }
        blk.field_md5 = str;
        blk.field_svrid = str2;
        blk.field_type = i3;
        blk.field_size = i4;
        blk.field_state = EmojiInfo.Vlc;
        blk.field_reserved1 = str3;
        blk.field_reserved2 = str4;
        blk.field_app_id = str5;
        blk.field_temp = 1;
        blk.field_reserved4 = 0;
        if (!TextUtils.isEmpty(str6)) {
            blk.field_groupId = str6;
        }
        AppMethodBeat.o(199824);
        return blk;
    }

    public final boolean K(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105065);
        if (emojiInfo == null || !emojiInfo.fYz()) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(105065);
            return false;
        }
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s", emojiInfo.field_md5);
        long replace = this.db.replace("EmojiInfo", "md5", emojiInfo.convertTo());
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert: %s, %s", emojiInfo.field_md5, Long.valueOf(replace));
        if (replace >= 0) {
            AppMethodBeat.o(105065);
            return true;
        }
        AppMethodBeat.o(105065);
        return false;
    }

    public final boolean L(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105066);
        if (emojiInfo == null || !emojiInfo.fYz()) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(105066);
            return false;
        }
        int update = this.db.update("EmojiInfo", emojiInfo.convertTo(), "md5=?", new String[]{emojiInfo.getMd5()});
        if (update > 0) {
            doNotify(emojiInfo.getMd5());
            doNotify("event_update_emoji");
        }
        if (update > 0) {
            AppMethodBeat.o(105066);
            return true;
        }
        AppMethodBeat.o(105066);
        return false;
    }

    public final boolean M(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105067);
        if (emojiInfo == null || !emojiInfo.fYz()) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            AppMethodBeat.o(105067);
            return false;
        }
        if (this.db.update("EmojiInfo", emojiInfo.convertTo(), "md5=?", new String[]{emojiInfo.getMd5()}) > 0) {
            AppMethodBeat.o(105067);
            return true;
        }
        AppMethodBeat.o(105067);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiInfo blk(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.blk(java.lang.String):com.tencent.mm.storage.emotion.EmojiInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiInfo Nl(long r12) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.Nl(long):com.tencent.mm.storage.emotion.EmojiInfo");
    }

    private int akr(int i2) {
        int i3 = 0;
        AppMethodBeat.i(105070);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i2), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i3 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e2.getMessage());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105070);
            throw th;
        }
        AppMethodBeat.o(105070);
        return i3;
    }

    public final int bld(String str) {
        int i2;
        AppMethodBeat.i(105071);
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
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e2.getMessage());
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
            AppMethodBeat.o(105071);
            throw th;
        }
        Log.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(105071);
        return i2;
    }

    public final int aZ(boolean z, boolean z2) {
        String str;
        String[] strArr;
        int i2 = 0;
        AppMethodBeat.i(105072);
        Cursor cursor = null;
        if (z) {
            if (!z2) {
                str = "select count(*) from EmojiInfo where catalog IN (?,?)";
                strArr = new String[]{String.valueOf(EmojiGroupInfo.VkO), String.valueOf(EmojiGroupInfo.VkP)};
            } else {
                str = "select count(*) from EmojiInfo where catalog IN (?,?) AND captureStatus=0";
                strArr = new String[]{String.valueOf(EmojiGroupInfo.VkO), String.valueOf(EmojiGroupInfo.VkP)};
            }
        } else if (!z2) {
            str = "select count(*) from EmojiInfo where catalog=?";
            strArr = new String[]{new StringBuilder().append(EmojiGroupInfo.VkP).toString()};
        } else {
            str = "select count(*) from EmojiInfo where catalog=? AND captureStatus=0";
            strArr = new String[]{new StringBuilder().append(EmojiGroupInfo.VkP).toString()};
        }
        try {
            Cursor rawQuery = this.db.rawQuery(str, strArr, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105072);
            throw th;
        }
        AppMethodBeat.o(105072);
        return i2;
    }

    public final int AM(boolean z) {
        String str;
        String[] strArr;
        int i2 = 0;
        AppMethodBeat.i(105073);
        Cursor cursor = null;
        if (!z) {
            str = "select count(*) from EmojiInfo where groupId=?";
            strArr = new String[]{"capture"};
        } else {
            str = "select count(*) from EmojiInfo where groupId=? AND captureStatus=0";
            strArr = new String[]{"capture"};
        }
        try {
            Cursor rawQuery = this.db.rawQuery(str, strArr, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", e2.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105073);
            throw th;
        }
        AppMethodBeat.o(105073);
        return i2;
    }

    public final List<EmojiInfo> bE(int i2, boolean z) {
        AppMethodBeat.i(105074);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from EmojiInfo where catalog = ").append(i2);
        if (!z) {
            sb.append(" and state != ").append(EmojiInfo.Vlf);
        }
        sb.append(" order by reserved3 asc ");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    EmojiInfo emojiInfo = new EmojiInfo();
                    emojiInfo.convertFrom(rawQuery);
                    arrayList.add(emojiInfo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(105074);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> aks(int r9) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.aks(int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> akt(int r9) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.akt(int):java.util.List");
    }

    public final Cursor aku(int i2) {
        AppMethodBeat.i(105078);
        Cursor query = this.db.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i2), AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null);
        AppMethodBeat.o(105078);
        return query;
    }

    public final boolean bll(String str) {
        AppMethodBeat.i(261732);
        boolean dj = dj(str, true);
        AppMethodBeat.o(261732);
        return dj;
    }

    public final boolean dj(String str, boolean z) {
        AppMethodBeat.i(105080);
        if (str == null || str.length() != 32) {
            Log.f("MicroMsg.emoji.EmojiInfoStorage", "delete by md5 assertion");
            AppMethodBeat.o(105080);
            return false;
        }
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "deleteByMd5: %s", str);
        int delete = this.db.delete("EmojiInfo", "md5=?", new String[]{String.valueOf(str)});
        if (z && delete > 0) {
            doNotify("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.o(105080);
            return true;
        }
        AppMethodBeat.o(105080);
        return false;
    }

    public final boolean Nm(long j2) {
        AppMethodBeat.i(105081);
        if (j2 == 0) {
            AppMethodBeat.o(105081);
            return false;
        }
        int delete = this.db.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(j2)), null);
        if (delete > 0) {
            doNotify("event_update_emoji");
        }
        if (delete > 0) {
            AppMethodBeat.o(105081);
            return true;
        }
        AppMethodBeat.o(105081);
        return false;
    }

    public final boolean akv(int i2) {
        AppMethodBeat.i(105082);
        if (this.db.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i2)}) >= 0) {
            AppMethodBeat.o(105082);
            return true;
        }
        AppMethodBeat.o(105082);
        return false;
    }

    private static List<EmojiInfo> a(InputStream[] inputStreamArr) {
        String str;
        String str2;
        AppMethodBeat.i(105084);
        ArrayList arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i2 = 0; i2 <= 0; i2++) {
                InputStream inputStream = inputStreamArr[i2];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
                        Element element = (Element) elementsByTagName.item(i3);
                        int intValue = Integer.decode(element.getAttribute("id")).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i4 = 0; i4 < elementsByTagName2.getLength(); i4++) {
                            com.tencent.mm.plugin.emoji.f.cER();
                            EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.f.cES());
                            Element element2 = (Element) elementsByTagName2.item(i4);
                            emojiInfo.field_md5 = element2.getAttribute("md5");
                            if (emojiInfo.fYz()) {
                                emojiInfo.field_catalog = intValue;
                                emojiInfo.field_groupId = String.valueOf(intValue);
                                emojiInfo.field_name = element2.getAttribute("name");
                                emojiInfo.field_type = Integer.decode(element2.getAttribute("type")).intValue();
                                Node firstChild = element2.getFirstChild();
                                if (firstChild instanceof CharacterData) {
                                    str = ((CharacterData) firstChild).getData();
                                } else {
                                    str = "";
                                }
                                if (emojiInfo.field_type == EmojiInfo.TYPE_TEXT) {
                                    str2 = new String(Base64.decode(str, 0));
                                } else {
                                    str2 = str;
                                }
                                emojiInfo.field_content = str2;
                                arrayList.add(emojiInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e2.getMessage());
        }
        AppMethodBeat.o(105084);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.storage.emotion.EmojiInfo blm(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.blm(java.lang.String):com.tencent.mm.storage.emotion.EmojiInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.storage.emotion.EmojiInfo> amo(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.amo(java.lang.String):java.util.List");
    }

    public final boolean I(List<String> list, int i2) {
        AppMethodBeat.i(105087);
        if (i2 == 1) {
            boolean ja = ja(list);
            AppMethodBeat.o(105087);
            return ja;
        }
        boolean iZ = iZ(list);
        AppMethodBeat.o(105087);
        return iZ;
    }

    public final boolean iZ(List<String> list) {
        AppMethodBeat.i(105088);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(105088);
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE");
        sb.append(" EmojiInfo ");
        sb.append(" SET ");
        sb.append("catalog");
        sb.append("=");
        sb.append(EmojiInfo.VkQ);
        sb.append(",");
        sb.append("source");
        sb.append("=");
        sb.append(EmojiInfo.Vlh);
        sb.append(",");
        sb.append("needupload");
        sb.append("=");
        sb.append(EmojiInfo.Vlj);
        sb.append(" where ");
        sb.append("md5");
        sb.append(" IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append("'" + list.get(i2) + "'");
            if (i2 < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        Log.d("MicroMsg.emoji.EmojiInfoStorage", sb.toString());
        if (this.db.execSQL("EmojiInfo", sb.toString())) {
            doNotify("delete_emoji_info_notify");
        }
        AppMethodBeat.o(105088);
        return true;
    }

    public final boolean ja(List<String> list) {
        AppMethodBeat.i(105089);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(105089);
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE");
        sb.append(" EmojiInfo ");
        sb.append(" SET ");
        sb.append("groupId");
        sb.append("=");
        sb.append("\"\"");
        sb.append(" where ");
        sb.append("md5");
        sb.append(" IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append("'" + list.get(i2) + "'");
            if (i2 < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        Log.d("MicroMsg.emoji.EmojiInfoStorage", sb.toString());
        if (this.db.execSQL("EmojiInfo", sb.toString())) {
            doNotify("delete_emoji_info_notify");
        }
        AppMethodBeat.o(105089);
        return true;
    }

    public final boolean x(int i2, List<String> list) {
        long j2;
        AppMethodBeat.i(105090);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            AppMethodBeat.o(105090);
            return false;
        }
        List<String> aks = aks(i2);
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        int i3 = 1;
        Iterator<String> it = list.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                String next = it.next();
                EmojiInfo blk = blk(next);
                if (blk != null && !Util.isNullOrNil(blk.getMd5())) {
                    if (i2 == 1) {
                        blk.field_idx = i4;
                    } else {
                        blk.field_reserved3 = i4;
                    }
                    if (!aks.isEmpty()) {
                        aks.remove(next);
                    }
                    i4++;
                    if (this.db.replace("EmojiInfo", "md5", blk.convertTo()) < 0) {
                        if (hVar != null) {
                            hVar.endTransaction(j2);
                        }
                        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(105090);
                        return false;
                    }
                }
                i3 = i4;
            } else {
                if (!aks.isEmpty()) {
                    for (String str : aks) {
                        EmojiInfo blk2 = blk(str);
                        if (blk2 != null && !Util.isNullOrNil(blk2.getMd5())) {
                            if (i2 == 1) {
                                blk2.field_idx = i4;
                            } else {
                                blk2.field_reserved3 = i4;
                            }
                            i4++;
                            if (this.db.replace("EmojiInfo", "md5", blk2.convertTo()) < 0) {
                                if (hVar != null) {
                                    hVar.endTransaction(j2);
                                }
                                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                AppMethodBeat.o(105090);
                                return false;
                            }
                        }
                    }
                }
                if (hVar != null) {
                    hVar.endTransaction(j2);
                }
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d", objArr);
                doNotify("event_update_emoji");
                AppMethodBeat.o(105090);
                return true;
            }
        }
    }

    public final boolean r(List<EmojiInfo> list, String str) {
        long j2;
        AppMethodBeat.i(105091);
        if (list.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            AppMethodBeat.o(105091);
            return false;
        }
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", str, Integer.valueOf(list.size()));
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        List<EmojiInfo> amo = amo(str);
        HashMap hashMap = new HashMap();
        for (EmojiInfo emojiInfo : amo) {
            hashMap.put(emojiInfo.getMd5(), emojiInfo);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            EmojiInfo emojiInfo2 = list.get(i2);
            emojiInfo2.field_temp = 0;
            this.db.replace("EmojiInfo", "md5", emojiInfo2.convertTo());
            hashMap.remove(emojiInfo2.getMd5());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            EmojiInfo emojiInfo3 = (EmojiInfo) entry.getValue();
            emojiInfo3.field_temp = 1;
            this.db.update("EmojiInfo", emojiInfo3.convertTo(), "md5=?", new String[]{(String) entry.getKey()});
            Log.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", emojiInfo3.field_groupId);
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
        }
        AppMethodBeat.o(105091);
        return true;
    }

    public final boolean bln(String str) {
        boolean z = false;
        AppMethodBeat.i(105092);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select * from EmojiInfo where md5=?", new String[]{str}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                z = true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", str, e2.getMessage());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105092);
            throw th;
        }
        AppMethodBeat.o(105092);
        return z;
    }

    public final boolean blo(String str) {
        AppMethodBeat.i(105093);
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.db.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                    AppMethodBeat.o(105093);
                    return true;
                }
                AppMethodBeat.o(105093);
                return false;
            } catch (Exception e2) {
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e2.getMessage());
            }
        }
        AppMethodBeat.o(105093);
        return false;
    }

    public final synchronized boolean y(int i2, List<EmojiInfo> list) {
        boolean z;
        long j2;
        h hVar;
        AppMethodBeat.i(105094);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList %s, %s", Integer.valueOf(i2), Integer.valueOf(list.size()));
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
            z = false;
            AppMethodBeat.o(105094);
        } else {
            if (this.db instanceof h) {
                h hVar2 = (h) this.db;
                j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                j2 = -1;
                hVar = null;
            }
            int i3 = 1;
            Iterator<EmojiInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmojiInfo next = it.next();
                    String md5 = next.getMd5();
                    EmojiInfo blk = blk(md5);
                    if (blk == null || Util.isNullOrNil(blk.getMd5())) {
                        blk = new EmojiInfo();
                        blk.field_md5 = md5;
                        blk.field_source = EmojiInfo.Vli;
                        blk.field_lastUseTime = System.currentTimeMillis();
                    } else {
                        blk.field_source = EmojiInfo.Vli;
                    }
                    if (i2 == 1) {
                        if (blk.field_catalog != EmojiInfo.VkW) {
                            blk.field_catalog = EmojiInfo.VkQ;
                        }
                        blk.field_groupId = "capture";
                        blk.field_idx = i3;
                    } else {
                        blk.field_catalog = EmojiInfo.VkW;
                        blk.field_reserved3 = i3;
                    }
                    if (blk.hYi()) {
                        blk.field_reserved4 |= EmojiInfo.Vll;
                        blk.field_state = EmojiInfo.Vle;
                        blk.field_size = (int) s.boW(blk.hYx());
                    } else {
                        blk.field_state = EmojiInfo.Vlf;
                    }
                    blk.field_cdnUrl = next.field_cdnUrl;
                    blk.field_thumbUrl = next.field_thumbUrl;
                    blk.field_designerID = next.field_designerID;
                    blk.field_encrypturl = next.field_encrypturl;
                    blk.field_aeskey = next.field_aeskey;
                    blk.field_groupId = next.field_groupId;
                    blk.field_externUrl = next.field_externUrl;
                    blk.field_externMd5 = next.field_externMd5;
                    blk.field_activityid = next.field_activityid;
                    blk.field_attachedText = next.field_attachedText;
                    blk.field_attachTextColor = next.field_attachTextColor;
                    blk.field_lensId = next.field_lensId;
                    Log.i("MicroMsg.emoji.EmojiInfoStorage", "preparedDownloadCustomEmojiList: %s, %s, %s", blk.getMd5(), Integer.valueOf(blk.field_state), Integer.valueOf(blk.field_size));
                    i3++;
                    if (this.db.replace("EmojiInfo", "md5", blk.convertTo()) < 0) {
                        if (hVar != null) {
                            hVar.endTransaction(j2);
                        }
                        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        z = false;
                        AppMethodBeat.o(105094);
                    }
                } else {
                    if (hVar != null) {
                        hVar.endTransaction(j2);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                    objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
                    Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d", objArr);
                    z = true;
                    AppMethodBeat.o(105094);
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> akw(int r9) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.akw(int):java.util.List");
    }

    public final List<EmojiInfo> AN(boolean z) {
        AppMethodBeat.i(105096);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from EmojiInfo where groupId = \"capture\"");
        if (!z) {
            sb.append(" and state != ").append(EmojiInfo.Vlf);
        }
        sb.append(" order by idx asc ");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    EmojiInfo emojiInfo = new EmojiInfo();
                    emojiInfo.convertFrom(rawQuery);
                    arrayList.add(emojiInfo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(105096);
        return arrayList;
    }

    public final boolean bJ(LinkedList<String> linkedList) {
        AppMethodBeat.i(105097);
        if (linkedList == null || linkedList.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            AppMethodBeat.o(105097);
            return false;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(164, 12, 1);
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", Integer.valueOf(linkedList.size()));
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE");
        sb.append(" EmojiInfo ");
        sb.append(" SET ");
        sb.append("needupload");
        sb.append("=");
        sb.append(EmojiInfo.Vlk);
        sb.append(" where ");
        sb.append("md5");
        sb.append(" IN (");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            sb.append("'" + linkedList.get(i2) + "'");
            if (i2 < linkedList.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        Log.d("MicroMsg.emoji.EmojiInfoStorage", sb.toString());
        boolean execSQL = this.db.execSQL("EmojiInfo", sb.toString());
        AppMethodBeat.o(105097);
        return execSQL;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> gFn() {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.gFn():java.util.ArrayList");
    }

    public final int gFo() {
        int i2 = 0;
        AppMethodBeat.i(105099);
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.VkP)}, 2);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", Util.stackTraceToString(e2));
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(105099);
            throw th;
        }
        AppMethodBeat.o(105099);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.tencent.mm.storage.emotion.EmojiInfo> gFp() {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.gFp():java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getKey() {
        /*
        // Method dump skipped, instructions count: 224
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.f.getKey():java.lang.String");
    }

    public final boolean jb(List<ait> list) {
        long j2;
        AppMethodBeat.i(105102);
        if (list == null || list.isEmpty()) {
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            AppMethodBeat.o(105102);
            return false;
        }
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", Integer.valueOf(list.size()));
        h hVar = null;
        if (this.db instanceof h) {
            h hVar2 = (h) this.db;
            j2 = hVar2.beginTransaction(Thread.currentThread().getId());
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", Long.valueOf(j2));
            hVar = hVar2;
        } else {
            j2 = -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ait ait = list.get(i2);
            EmojiInfo blk = blk(ait.Md5);
            if (blk == null) {
                blk = new EmojiInfo();
                blk.field_md5 = ait.Md5;
                blk.field_catalog = EmojiInfo.VkQ;
                Log.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            b.a(ait, blk);
            L(blk);
        }
        if (hVar != null) {
            hVar.endTransaction(j2);
            Log.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        AppMethodBeat.o(105102);
        return true;
    }

    public final void a(Context context, EmojiInfo emojiInfo) {
        int i2;
        AppMethodBeat.i(105083);
        if (emojiInfo.field_catalog == EmojiInfo.VkS || emojiInfo.field_catalog == EmojiInfo.VkV || emojiInfo.field_catalog == EmojiInfo.VkU) {
            InputStream inputStream = null;
            try {
                InputStream inputStream2 = EmojiInfo.m37do(context, emojiInfo.getName());
                if (inputStream2 != null) {
                    i2 = inputStream2.available();
                } else {
                    i2 = 0;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e2));
                    }
                }
            } catch (IOException e3) {
                Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e3));
                if (0 != 0) {
                    try {
                        inputStream.close();
                        i2 = 0;
                    } catch (IOException e4) {
                        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e4));
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        Log.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", Util.stackTraceToString(e5));
                    }
                }
                AppMethodBeat.o(105083);
                throw th;
            }
        } else {
            i2 = (int) s.boW(emojiInfo.hYx());
        }
        if (!(i2 == 0 || i2 == emojiInfo.field_size)) {
            emojiInfo.field_size = i2;
            L(emojiInfo);
        }
        AppMethodBeat.o(105083);
    }
}
