package com.tencent.mm.ca;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a implements e {
    public static C0285a NCM = new C0285a();
    public static b NCN = new b();
    public static c NCO = new c();
    private String NCH;
    private ArrayList<EmojiInfo> NCI = new ArrayList<>();
    private ArrayList<EmojiInfo> NCJ = new ArrayList<>();
    private HashMap<String, ArrayList<EmojiInfo>> NCK = new HashMap<>();
    private ArrayList<EmojiGroupInfo> NCL = new ArrayList<>();

    /* renamed from: com.tencent.mm.ca.a$a  reason: collision with other inner class name */
    public static class C0285a {
    }

    public a() {
        AppMethodBeat.i(104851);
        AppMethodBeat.o(104851);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String amp(String str) {
        AppMethodBeat.i(104852);
        if (g.aAe().azG().aBb()) {
            String amp = ((d) g.ah(d.class)).getEmojiMgr().amp(str);
            AppMethodBeat.o(104852);
            return amp;
        }
        String string = call(getUri(), "getCurLangDesc", str, null).getString("data", "");
        AppMethodBeat.o(104852);
        return string;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo l(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(104853);
        if (g.aAe().azG().aBb()) {
            EmojiInfo a2 = ((d) g.ah(d.class)).getEmojiMgr().a(str, "", i2, i3, i4, "");
            AppMethodBeat.o(104853);
            return a2;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        bundle.putInt("key_group", i2);
        bundle.putInt("key_type", i3);
        bundle.putInt("key_size", i4);
        Bundle call = call(getUri(), "createEmojiInfo", null, bundle);
        if (call != null) {
            call.setClassLoader(EmojiInfo.class.getClassLoader());
            EmojiInfo emojiInfo = (EmojiInfo) call.getParcelable("key_emoji_info");
            AppMethodBeat.o(104853);
            return emojiInfo;
        }
        AppMethodBeat.o(104853);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104854);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.o(104854);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("key_emoji_info", emojiInfo);
        call(getUri(), "updateEmojiInfo", null, bundle);
        AppMethodBeat.o(104854);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void h(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(104861);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().h(iOnStorageChange);
        }
        AppMethodBeat.o(104861);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final byte[] a(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104862);
        if (g.aAe().azG().aBb()) {
            byte[] a2 = ((d) g.ah(d.class)).getEmojiMgr().a(emojiInfo);
            AppMethodBeat.o(104862);
            return a2;
        }
        byte[] D = D(emojiInfo);
        AppMethodBeat.o(104862);
        return D;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void i(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(104863);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().i(iOnStorageChange);
        }
        AppMethodBeat.o(104863);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void j(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(104864);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().j(iOnStorageChange);
        }
        AppMethodBeat.o(104864);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void k(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(104865);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().k(iOnStorageChange);
        }
        AppMethodBeat.o(104865);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo amm(String str) {
        AppMethodBeat.i(104866);
        if (g.aAe().azG().aBb()) {
            EmojiInfo amm = ((d) g.ah(d.class)).getEmojiMgr().amm(str);
            AppMethodBeat.o(104866);
            return amm;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        Bundle call = call(getUri(), "getEmojiByMd5", null, bundle);
        if (call != null) {
            call.setClassLoader(EmojiInfo.class.getClassLoader());
            EmojiInfo emojiInfo = (EmojiInfo) call.getParcelable("key_emoji_info");
            AppMethodBeat.o(104866);
            return emojiInfo;
        }
        AppMethodBeat.o(104866);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo p(EmojiInfo emojiInfo) {
        boolean z;
        AppMethodBeat.i(104867);
        if (g.aAe().azG().aBb()) {
            EmojiInfo p = ((d) g.ah(d.class)).getEmojiMgr().p(emojiInfo);
            AppMethodBeat.o(104867);
            return p;
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        Bundle call = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getRandomEmoji", (String) null, bundle);
        if (call == null) {
            Log.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
            AppMethodBeat.o(104867);
            return null;
        }
        call.setClassLoader(EmojiInfo.class.getClassLoader());
        if (call.containsKey("data")) {
            EmojiInfo emojiInfo2 = (EmojiInfo) call.getParcelable("data");
            AppMethodBeat.o(104867);
            return emojiInfo2;
        }
        Object[] objArr = new Object[1];
        if (call == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bundle is null?", objArr);
        AppMethodBeat.o(104867);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] D(com.tencent.mm.storage.emotion.EmojiInfo r13) {
        /*
        // Method dump skipped, instructions count: 239
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ca.a.D(com.tencent.mm.storage.emotion.EmojiInfo):byte[]");
    }

    private static boolean a(EmojiInfo emojiInfo, byte[] bArr) {
        String str;
        boolean z;
        AppMethodBeat.i(104869);
        if (ImgUtil.isWXGF(bArr)) {
            str = emojiInfo.field_externMd5;
        } else {
            str = emojiInfo.field_md5;
        }
        String mD5String = MD5Util.getMD5String(bArr);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(mD5String) || !Util.isEqual(str, mD5String)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.w("MicroMsg.EmotionStorageResolver", "checkFileMd5: %s", emojiInfo.field_md5);
        }
        AppMethodBeat.o(104869);
        return z;
    }

    private static String aun() {
        AppMethodBeat.i(104870);
        String string = call(getUri(), "getEmojiKey", null, null).getString("key", "");
        AppMethodBeat.o(104870);
        return string;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String getAccPath() {
        AppMethodBeat.i(104871);
        if (g.aAe().azG().aBb()) {
            this.NCH = ((d) g.ah(d.class)).getEmojiMgr().getAccPath();
        } else if (Util.isNullOrNil(this.NCH)) {
            this.NCH = call(getUri(), "getAccPath", null, null).getString("path");
        }
        String str = this.NCH;
        AppMethodBeat.o(104871);
        return str;
    }

    public static Uri getUri() {
        AppMethodBeat.i(185735);
        Uri parse = Uri.parse("content://" + com.tencent.mm.api.g.AUTHORITY + FilePathGenerator.ANDROID_DIR_SEP);
        AppMethodBeat.o(185735);
        return parse;
    }

    static {
        AppMethodBeat.i(104893);
        AppMethodBeat.o(104893);
    }

    public static C0285a gvc() {
        return NCM;
    }

    public static class b {
        public static String dg(int i2, String str) {
            AppMethodBeat.i(104848);
            Bundle bundle = new Bundle();
            bundle.putInt("key", i2);
            String string = a.call(getUri(), "ConfigStorage.getString", null, bundle).getString("key", str);
            AppMethodBeat.o(104848);
            return string;
        }

        public static void bhD(String str) {
            AppMethodBeat.i(104849);
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", (Integer) -29414086);
            contentValues.put("value", str);
            a.a(getUri(), contentValues);
            AppMethodBeat.o(104849);
        }

        private static Uri getUri() {
            AppMethodBeat.i(199811);
            Uri parse = Uri.parse("content://" + com.tencent.mm.api.g.AUTHORITY + "/userinfo/");
            AppMethodBeat.o(199811);
            return parse;
        }
    }

    public static class c extends f {
        @Override // com.tencent.mm.n.f
        public final synchronized void vC() {
            AppMethodBeat.i(104850);
            this.gMm = true;
            a.gvc();
            b bVar = a.NCN;
            r(b.dg(278529, null), false);
            a.gvc();
            b bVar2 = a.NCN;
            r(b.dg(278530, null), false);
            AppMethodBeat.o(104850);
        }
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void onDestroy() {
        AppMethodBeat.i(104873);
        this.NCL.clear();
        AppMethodBeat.o(104873);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean cFP() {
        AppMethodBeat.i(104874);
        if (g.aAe().azG().aBb()) {
            boolean cFP = ((d) g.ah(d.class)).getEmojiMgr().cFP();
            AppMethodBeat.o(104874);
            return cFP;
        }
        Bundle call = call(getUri(), "isEnableHEVCDecode", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(104874);
            return false;
        }
        AppMethodBeat.o(104874);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean ave() {
        AppMethodBeat.i(104875);
        if (g.aAe().azG().aBb()) {
            boolean ave = ((d) g.ah(d.class)).getEmojiMgr().ave();
            AppMethodBeat.o(104875);
            return ave;
        }
        Bundle call = call(getUri(), "isEnableHevcUpload", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(104875);
            return false;
        }
        AppMethodBeat.o(104875);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean avf() {
        AppMethodBeat.i(104876);
        if (g.aAe().azG().aBb()) {
            boolean avf = ((d) g.ah(d.class)).getEmojiMgr().avf();
            AppMethodBeat.o(104876);
            return avf;
        }
        AppMethodBeat.o(104876);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amy(String str) {
        AppMethodBeat.i(177033);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().amy(str);
        }
        AppMethodBeat.o(177033);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final List<v> cFQ() {
        AppMethodBeat.i(104878);
        if (g.aAe().azG().aBb()) {
            List<v> cFQ = ((d) g.ah(d.class)).getEmojiMgr().cFQ();
            AppMethodBeat.o(104878);
            return cFQ;
        }
        AppMethodBeat.o(104878);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void cFR() {
        AppMethodBeat.i(104879);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().cFR();
        }
        AppMethodBeat.o(104879);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final <T> T c(ar.a aVar, T t) {
        T t2;
        AppMethodBeat.i(104880);
        if (g.aAe().azG().aBb()) {
            T t3 = (T) ((d) g.ah(d.class)).getEmojiMgr().c(aVar, t);
            AppMethodBeat.o(104880);
            return t3;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", aVar);
        Bundle call = call(getUri(), "getConfig", null, bundle);
        if (call == null || (t2 = (T) call.get("key_config_value")) == null) {
            AppMethodBeat.o(104880);
            return t;
        }
        AppMethodBeat.o(104880);
        return t2;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void d(ar.a aVar, Object obj) {
        AppMethodBeat.i(104881);
        if (g.aAe().azG().aBb()) {
            ((d) g.ah(d.class)).getEmojiMgr().d(aVar, obj);
            AppMethodBeat.o(104881);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", aVar);
        bundle.putSerializable("key_config_value", (Serializable) obj);
        call(getUri(), "setConfig", null, bundle);
        AppMethodBeat.o(104881);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean amz(String str) {
        AppMethodBeat.i(104882);
        if (g.aAe().azG().aBb()) {
            boolean amz = ((d) g.ah(d.class)).getEmojiMgr().amz(str);
            AppMethodBeat.o(104882);
            return amz;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_path", str);
        Bundle call = call(getUri(), "checkGifFile", null, bundle);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(104882);
            return false;
        }
        AppMethodBeat.o(104882);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean amA(String str) {
        AppMethodBeat.i(199812);
        if (g.aAe().azG().aBb()) {
            boolean amA = ((d) g.ah(d.class)).getEmojiMgr().amA(str);
            AppMethodBeat.o(199812);
            return amA;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_path", str);
        Bundle call = call(getUri(), "checkGifFile", null, bundle);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(199812);
            return false;
        }
        AppMethodBeat.o(199812);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean cFS() {
        AppMethodBeat.i(104883);
        if (g.aAe().azG().aBb()) {
            boolean cFS = ((d) g.ah(d.class)).getEmojiMgr().cFS();
            AppMethodBeat.o(104883);
            return cFS;
        }
        AppMethodBeat.o(104883);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final ArrayList<SmileyInfo> cFJ() {
        AppMethodBeat.i(104884);
        if (!g.aAe().azG().aBb()) {
            Bundle call = call(getUri(), "getSmileyInfoList", null, null);
            if (call != null) {
                call.setClassLoader(SmileyInfo.class.getClassLoader());
                Serializable serializable = call.getSerializable("key_data");
                if (serializable instanceof ArrayList) {
                    ArrayList<SmileyInfo> arrayList = (ArrayList) serializable;
                    AppMethodBeat.o(104884);
                    return arrayList;
                }
            }
        } else if (g.aAf().azp()) {
            ArrayList<SmileyInfo> cFJ = ((d) g.ah(d.class)).getEmojiMgr().cFJ();
            AppMethodBeat.o(104884);
            return cFJ;
        }
        AppMethodBeat.o(104884);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void cFO() {
        AppMethodBeat.i(104885);
        if (g.aAe().azG().aBb() && g.aAf().azp()) {
            ((d) g.ah(d.class)).getEmojiMgr().cFO();
        }
        AppMethodBeat.o(104885);
    }

    public static Bundle call(Uri uri, String str, String str2, Bundle bundle) {
        Bundle bundle2;
        AppMethodBeat.i(104886);
        try {
            bundle2 = MMApplicationContext.getContext().getContentResolver().call(uri, str, str2, bundle);
        } catch (IllegalArgumentException | NullPointerException | SecurityException e2) {
            Log.printErrStackTrace("MicroMsg.EmotionStorageResolver", e2, "", new Object[0]);
            bundle2 = null;
        }
        if (bundle2 != null) {
            AppMethodBeat.o(104886);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        AppMethodBeat.o(104886);
        return bundle3;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amB(String str) {
        AppMethodBeat.i(104887);
        if (!g.aAe().azG().aBb()) {
            MMApplicationContext.getContext().getContentResolver().call(getUri(), "deleteLoadingCaptureEmoji", str, (Bundle) null);
        } else if (g.aAf().azp()) {
            ((d) g.ah(d.class)).getEmojiMgr().amB(str);
            AppMethodBeat.o(104887);
            return;
        }
        AppMethodBeat.o(104887);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void t(EmojiInfo emojiInfo) {
        AppMethodBeat.i(104888);
        if (!g.aAe().azG().aBb()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("emojiInfo", emojiInfo);
            MMApplicationContext.getContext().getContentResolver().call(getUri(), "showCaptureEmojiInPanel", (String) null, bundle);
        } else if (g.aAf().azp()) {
            ((d) g.ah(d.class)).getEmojiMgr().t(emojiInfo);
            AppMethodBeat.o(104888);
            return;
        }
        AppMethodBeat.o(104888);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amC(String str) {
        AppMethodBeat.i(104889);
        if (!g.aAe().azG().aBb()) {
            Bundle bundle = new Bundle();
            bundle.putString("key_md5", str);
            MMApplicationContext.getContext().getContentResolver().call(getUri(), "addCaptureEmojiUploadTask", (String) null, bundle);
        } else if (g.aAf().azp()) {
            ((d) g.ah(d.class)).getEmojiMgr().amC(str);
            AppMethodBeat.o(104889);
            return;
        }
        AppMethodBeat.o(104889);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final ArrayList<SmileyPanelConfigInfo> cFK() {
        AppMethodBeat.i(104890);
        if (g.aAe().azG().aBb()) {
            ArrayList<SmileyPanelConfigInfo> cFK = ((d) g.ah(d.class)).getEmojiMgr().cFK();
            AppMethodBeat.o(104890);
            return cFK;
        }
        Bundle call = call(getUri(), "getSmileyPanelInfoList", null, null);
        call.setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
        ArrayList<SmileyPanelConfigInfo> parcelableArrayList = call.getParcelableArrayList("smiley_panel_info");
        AppMethodBeat.o(104890);
        return parcelableArrayList;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String cFN() {
        AppMethodBeat.i(104891);
        if (g.aAe().azG().aBb()) {
            String cFN = ((d) g.ah(d.class)).getEmojiMgr().cFN();
            AppMethodBeat.o(104891);
            return cFN;
        }
        Bundle call = call(getUri(), "getPanelConfigName", null, null);
        call.setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
        String string = call.getString("key_data");
        AppMethodBeat.o(104891);
        return string;
    }

    static /* synthetic */ void a(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(104892);
        try {
            MMApplicationContext.getContext().getContentResolver().update(uri, contentValues, null, null);
            AppMethodBeat.o(104892);
        } catch (IllegalArgumentException e2) {
            Log.printErrStackTrace("MicroMsg.EmotionStorageResolver", e2, "", new Object[0]);
            AppMethodBeat.o(104892);
        }
    }
}
