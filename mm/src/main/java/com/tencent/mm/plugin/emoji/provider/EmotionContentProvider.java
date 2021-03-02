package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.decode.a;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.r;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher rdr;

    static {
        AppMethodBeat.i(108743);
        UriMatcher uriMatcher = new UriMatcher(-1);
        rdr = uriMatcher;
        uriMatcher.addURI(g.AUTHORITY, "EmojiGroupInfo", 1);
        rdr.addURI(g.AUTHORITY, "userinfo", 2);
        rdr.addURI(g.AUTHORITY, "GetEmotionListCache", 3);
        rdr.addURI(g.AUTHORITY, "EmojiInfo", 4);
        rdr.addURI(g.AUTHORITY, "EmojiInfoDesc", 5);
        AppMethodBeat.o(108743);
    }

    public boolean onCreate() {
        AppMethodBeat.i(108737);
        Log.i("MicroMsg.EmotionContentProvider", "[onCreate]");
        AppMethodBeat.o(108737);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(108738);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            Log.i("MicroMsg.EmotionContentProvider", "[query] kernel or account not init.");
            AppMethodBeat.o(108738);
            return null;
        }
        Log.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        switch (rdr.match(uri)) {
            case 1:
                Cursor rawQuery = com.tencent.mm.kernel.g.aAh().hqK.rawQuery(str, strArr2, 2);
                AppMethodBeat.o(108738);
                return rawQuery;
            case 2:
            default:
                AppMethodBeat.o(108738);
                return null;
            case 3:
                Cursor rawQuery2 = com.tencent.mm.kernel.g.aAh().hqK.rawQuery(str, strArr2, 2);
                AppMethodBeat.o(108738);
                return rawQuery2;
            case 4:
                Cursor rawQuery3 = com.tencent.mm.kernel.g.aAh().hqK.rawQuery(str, strArr2, 2);
                AppMethodBeat.o(108738);
                return rawQuery3;
            case 5:
                Cursor rawQuery4 = com.tencent.mm.kernel.g.aAh().hqK.rawQuery(str, strArr2, 2);
                AppMethodBeat.o(108738);
                return rawQuery4;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(108739);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            Log.i("MicroMsg.EmotionContentProvider", "[insert] kernel or account not init.");
            AppMethodBeat.o(108739);
            return uri;
        }
        switch (rdr.match(uri)) {
            case 3:
                Uri withAppendedPath = Uri.withAppendedPath(uri, String.valueOf(com.tencent.mm.kernel.g.aAh().hqK.insert("GetEmotionListCache", r.info.primaryKey, contentValues)));
                AppMethodBeat.o(108739);
                return withAppendedPath;
            default:
                AppMethodBeat.o(108739);
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(108740);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            Log.i("MicroMsg.EmotionContentProvider", "[delete] kernel or account not init.");
            AppMethodBeat.o(108740);
            return 0;
        }
        switch (rdr.match(uri)) {
            case 3:
                int delete = com.tencent.mm.kernel.g.aAh().hqK.delete("GetEmotionListCache", str, strArr);
                AppMethodBeat.o(108740);
                return delete;
            default:
                AppMethodBeat.o(108740);
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(108741);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            Log.i("MicroMsg.EmotionContentProvider", "[update] kernel or account not init.");
            AppMethodBeat.o(108741);
            return -1;
        }
        switch (rdr.match(uri)) {
            case 1:
                int update = com.tencent.mm.kernel.g.aAh().hqK.update("EmojiGroupInfo", contentValues, str, strArr);
                AppMethodBeat.o(108741);
                return update;
            case 2:
                com.tencent.mm.kernel.g.aAh().azQ().set(((Integer) contentValues.get("type")).intValue(), contentValues.get("value"));
                AppMethodBeat.o(108741);
                return 0;
            default:
                AppMethodBeat.o(108741);
                return -1;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(108742);
        Log.d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        if (!com.tencent.mm.kernel.g.aAi().hrr || !com.tencent.mm.kernel.g.aAf().azp()) {
            Log.i("MicroMsg.EmotionContentProvider", "[call] method:%s, but kernel or account not init.", str);
            AppMethodBeat.o(108742);
            return null;
        } else if (str.equals("getAccPath")) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("path", com.tencent.mm.kernel.g.aAh().hqG);
            AppMethodBeat.o(108742);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("key", a.aum().aun());
            AppMethodBeat.o(108742);
            return bundle3;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean("key", ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(bundle.getInt("key"), Boolean.FALSE)).booleanValue());
            AppMethodBeat.o(108742);
            return bundle4;
        } else if (str.equals("ConfigStorage.getString")) {
            Bundle bundle5 = new Bundle();
            bundle5.putString("key", (String) com.tencent.mm.kernel.g.aAh().azQ().get(bundle.getInt("key"), ""));
            AppMethodBeat.o(108742);
            return bundle5;
        } else if (str.equals("getAllCustomEmoji")) {
            Bundle bundle6 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle6.putParcelableArrayList("data", k.getEmojiStorageMgr().Oqb.dT(false));
            AppMethodBeat.o(108742);
            return bundle6;
        } else {
            if (str.equals("getRandomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    Bundle bundle7 = new Bundle(EmojiInfo.class.getClassLoader());
                    bundle7.putParcelable("data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().p((EmojiInfo) bundle.getParcelable("emoji")));
                    AppMethodBeat.o(108742);
                    return bundle7;
                }
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.e("MicroMsg.EmotionContentProvider", "[getRandomEmoji] extras:%s", objArr);
            } else if (str.equals("getCurLangDesc")) {
                Bundle bundle8 = new Bundle();
                bundle8.putString("data", k.getEmojiDescMgr().amp(str2));
                AppMethodBeat.o(108742);
                return bundle8;
            } else if (str.equals("countCustomEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("withSystem");
                    z2 = bundle.getBoolean("onlySuccess");
                }
                Bundle bundle9 = new Bundle();
                bundle9.putInt("data", k.getEmojiStorageMgr().OpN.aZ(z, z2));
                AppMethodBeat.o(108742);
                return bundle9;
            } else if (str.equals("countCaptureEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("onlySuccess");
                }
                Bundle bundle10 = new Bundle();
                bundle10.putInt("data", k.getEmojiStorageMgr().OpN.AM(z));
                AppMethodBeat.o(108742);
                return bundle10;
            } else if (str.equals("countProductId")) {
                Bundle bundle11 = new Bundle();
                bundle11.putInt("data", k.getEmojiStorageMgr().OpN.bld(str2));
                AppMethodBeat.o(108742);
                return bundle11;
            } else if (str.equals("getDownloadedCount")) {
                Bundle bundle12 = new Bundle();
                bj emojiStorageMgr = k.getEmojiStorageMgr();
                if (bj.eii == -1 || bj.Oqc) {
                    bj.eii = emojiStorageMgr.OpO.gEH();
                }
                bundle12.putInt("data", bj.eii);
                AppMethodBeat.o(108742);
                return bundle12;
            } else if (str.equals("getEmojiListByGroupId")) {
                Bundle bundle13 = new Bundle(EmojiInfo.class.getClassLoader());
                bundle13.putParcelableArrayList("data", (ArrayList) ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amo(str2));
                AppMethodBeat.o(108742);
                return bundle13;
            } else if (str.equals("getDesignerInfo")) {
                Bundle bundle14 = new Bundle();
                l blt = bj.gCJ().OpR.blt(str2);
                if (blt != null) {
                    bundle14.putByteArray("buffer", blt.field_content);
                }
                AppMethodBeat.o(108742);
                return bundle14;
            } else if (str.equals("getEmojiGroupInfoList")) {
                Bundle bundle15 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle15.putParcelableArrayList("data", k.getEmojiStorageMgr().Oqb.auP());
                AppMethodBeat.o(108742);
                return bundle15;
            } else if (str.equals("createEmojiInfo")) {
                if (bundle != null) {
                    EmojiInfo l = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().l(bundle.getString("key_md5"), bundle.getInt("key_group"), bundle.getInt("key_type"), bundle.getInt("key_size"));
                    Bundle bundle16 = new Bundle();
                    bundle16.putParcelable("key_emoji_info", l);
                    AppMethodBeat.o(108742);
                    return bundle16;
                }
            } else if (str.equals("updateEmojiInfo")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().updateEmojiInfo((EmojiInfo) bundle.get("key_emoji_info"));
                }
            } else if (str.equals("isEnableHEVCDecode")) {
                Bundle bundle17 = new Bundle();
                bundle17.putBoolean("key_data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().cFP());
                AppMethodBeat.o(108742);
                return bundle17;
            } else if (str.equals("isEnableHevcUpload")) {
                Bundle bundle18 = new Bundle();
                bundle18.putBoolean("key_data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().ave());
                AppMethodBeat.o(108742);
                return bundle18;
            } else if (str.equals("getEmojiByMd5")) {
                if (bundle != null) {
                    String string = bundle.getString("key_md5");
                    Bundle bundle19 = new Bundle();
                    bundle19.putParcelable("key_emoji_info", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amm(string));
                    AppMethodBeat.o(108742);
                    return bundle19;
                }
            } else if (str.equals("getConfig")) {
                if (bundle != null) {
                    Object c2 = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().c((ar.a) bundle.get("key_config_key"), null);
                    Bundle bundle20 = new Bundle();
                    bundle20.putSerializable("key_config_value", (Serializable) c2);
                    AppMethodBeat.o(108742);
                    return bundle20;
                }
            } else if (str.equals("setConfig")) {
                if (bundle != null) {
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().d((ar.a) bundle.get("key_config_key"), bundle.get("key_config_value"));
                }
            } else if (str.equals("checkGifFile")) {
                if (bundle != null) {
                    Bundle bundle21 = new Bundle();
                    bundle21.putBoolean("key_data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amz(bundle.getString("key_path")));
                    AppMethodBeat.o(108742);
                    return bundle21;
                }
            } else if (str.equals("getSmileyInfoList")) {
                Bundle bundle22 = new Bundle();
                try {
                    bundle22.putParcelableArrayList("key_data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().cFJ());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.EmotionContentProvider", e2, "", new Object[0]);
                }
                AppMethodBeat.o(108742);
                return bundle22;
            } else if (str.equals("deleteLoadingCaptureEmoji")) {
                if (!Util.isNullOrNil(str2)) {
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amB(str2);
                }
            } else if (str.equals("showCaptureEmojiInPanel")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().t((EmojiInfo) bundle.getParcelable("emojiInfo"));
                }
            } else if (str.equals("addCaptureEmojiUploadTask")) {
                if (bundle != null) {
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amC(bundle.getString("key_md5"));
                }
            } else if (str.equals("getCaptureEmoji")) {
                Bundle bundle23 = new Bundle();
                bundle23.putParcelableArrayList("key_data", j.auL().dU(false));
                AppMethodBeat.o(108742);
                return bundle23;
            } else if (str.equals("getSmileyPanelInfoList")) {
                Bundle bundle24 = new Bundle();
                bundle24.putParcelableArrayList("smiley_panel_info", ((PluginEmoji) com.tencent.mm.kernel.g.ah(PluginEmoji.class)).getEmojiMgr().cFK());
                AppMethodBeat.o(108742);
                return bundle24;
            } else if (str.equals("getPanelConfigName")) {
                Bundle bundle25 = new Bundle();
                bundle25.putString("key_data", ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().cFN());
                AppMethodBeat.o(108742);
                return bundle25;
            }
            AppMethodBeat.o(108742);
            return null;
        }
    }
}
