package com.tencent.mm.plugin.webview.emojistore.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0'J\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u0001J\u0006\u0010,\u001a\u00020\u001dJ\u0006\u0010-\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020+J,\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u000e\u0010%\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "continueFlag", "", "emojiDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "getEmojiDataList", "()Ljava/util/LinkedList;", "setEmojiDataList", "(Ljava/util/LinkedList;)V", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "getModel", "()Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "setModel", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "offset", "", "getOffset", "()I", "setOffset", "(I)V", "pageNo", "getPageNo", "setPageNo", "searchID", "", "getSearchID", "()Ljava/lang/String;", "setSearchID", "(Ljava/lang/String;)V", "sessionId", "getSessionId", "setSessionId", "totalCount", "enableLoadMore", "", "getHeadData", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getSimilarEmojiList", "", "getTitle", "isSimilarSearch", "onCrate", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-webview_release"})
public final class c implements i {
    public static final a INE = new a((byte) 0);
    SimilarEmojiQueryModel INC;
    LinkedList<h> IND = new LinkedList<>();
    i callback;
    private int gAZ;
    int gYe;
    int offset;
    String rjq = ("Similar" + System.currentTimeMillis());
    String sessionId = "";
    boolean tuG = true;

    static {
        AppMethodBeat.i(82496);
        AppMethodBeat.o(82496);
    }

    public c() {
        AppMethodBeat.i(82495);
        AppMethodBeat.o(82495);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final EmojiInfo gat() {
        AppMethodBeat.i(82492);
        SimilarEmojiQueryModel similarEmojiQueryModel = this.INC;
        if (similarEmojiQueryModel == null) {
            AppMethodBeat.o(82492);
            return null;
        } else if (gau()) {
            com.tencent.mm.kernel.b.a ah = g.ah(d.class);
            p.g(ah, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
            EmojiInfo aml = ((d) ah).getEmojiMgr().aml(similarEmojiQueryModel.emojiMD5);
            if (aml == null) {
                AppMethodBeat.o(82492);
                return null;
            }
            aml.field_catalog = EmojiInfo.VkQ;
            if (this.IND.isEmpty()) {
                this.IND.add(new h(aml, 100));
            }
            AppMethodBeat.o(82492);
            return aml;
        } else {
            EmojiInfo emojiInfo = new EmojiInfo();
            if (this.IND.isEmpty()) {
                this.IND.add(new h(emojiInfo, 107));
            }
            AppMethodBeat.o(82492);
            return emojiInfo;
        }
    }

    public final boolean gau() {
        AppMethodBeat.i(210290);
        SimilarEmojiQueryModel similarEmojiQueryModel = this.INC;
        if (similarEmojiQueryModel != null) {
            boolean gau = similarEmojiQueryModel.gau();
            AppMethodBeat.o(210290);
            return gau;
        }
        AppMethodBeat.o(210290);
        return false;
    }

    public final void f(i iVar) {
        String str;
        AppMethodBeat.i(82493);
        p.h(iVar, "callback");
        Log.i("MicroMsg.SimilarEmoji", "do net request:[" + this.INC + ']');
        this.callback = iVar;
        if (!this.tuG) {
            AppMethodBeat.o(82493);
            return;
        }
        SimilarEmojiQueryModel similarEmojiQueryModel = this.INC;
        if (similarEmojiQueryModel == null) {
            AppMethodBeat.o(82493);
        } else if (gau()) {
            EmojiInfo aml = ((d) g.ah(d.class)).getEmojiMgr().aml(similarEmojiQueryModel.emojiMD5);
            g.azz().b(new com.tencent.mm.plugin.webview.fts.d(similarEmojiQueryModel.emojiMD5, this.offset, this.rjq, this.rjq, 0, this.rjq, 59, aml.field_cdnUrl, aml.field_aeskey));
            AppMethodBeat.o(82493);
        } else {
            v vVar = new v();
            vVar.scene = 78;
            SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INC;
            if (similarEmojiQueryModel2 == null || (str = similarEmojiQueryModel2.query) == null) {
                str = "";
            }
            vVar.dDv = str;
            vVar.businessType = 256;
            vVar.dVS = 1;
            vVar.offset = this.offset;
            vVar.sessionId = this.sessionId;
            vVar.rjq = this.rjq;
            vVar.dPI = this.rjq;
            g.azz().b(new r(vVar));
            AppMethodBeat.o(82493);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(82494);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.webview.fts.d) {
                try {
                    JSONObject jSONObject = new JSONObject(Util.nullAs(((com.tencent.mm.plugin.webview.fts.d) qVar).gay().MaZ, ""));
                    this.offset = jSONObject.optInt("offset", 0);
                    this.gAZ = jSONObject.optInt("totalCount", 0);
                    this.tuG = jSONObject.optBoolean("continueFlag", false);
                    String optString = jSONObject.optString("searchID");
                    p.g(optString, "responseJson.optString(\"searchID\")");
                    this.rjq = optString;
                    JSONArray optJSONArray = jSONObject.optJSONArray("items");
                    if (!this.IND.isEmpty()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && ((h) j.ku(this.IND)).gYc == 104) {
                        this.IND.remove(j.ku(this.IND));
                    }
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    Log.i("MicroMsg.SimilarEmoji", "similar get more emoji size:" + optJSONArray.length());
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        EmojiInfo emojiInfo = new EmojiInfo();
                        b.a("MicroMsg.SimilarEmoji", jSONObject2, emojiInfo);
                        this.IND.add(new h(emojiInfo, 103));
                    }
                    if (this.tuG) {
                        this.IND.add(new h(new EmojiInfo(), 104));
                    }
                } catch (Exception e2) {
                }
            } else if (qVar instanceof r) {
                this.gYe++;
                try {
                    JSONObject jSONObject3 = new JSONObject(((r) qVar).fXM().MaZ);
                    this.offset = jSONObject3.optInt("offset", 0);
                    this.tuG = jSONObject3.optInt("continueFlag", 0) == 1;
                    String optString2 = jSONObject3.optString("searchID", "");
                    p.g(optString2, "responseJson.optString(\"searchID\", \"\")");
                    this.rjq = optString2;
                    JSONObject optJSONObject = jSONObject3.optJSONArray("data").optJSONObject(0);
                    this.gAZ = optJSONObject.optInt("totalCount", 0);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                    if (!this.IND.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && ((h) j.ku(this.IND)).gYc == 104) {
                        this.IND.removeLast();
                    }
                    if (optJSONArray2 == null) {
                        optJSONArray2 = new JSONArray();
                    }
                    Log.i("MicroMsg.SimilarEmoji", "websearch get more emoji size:" + optJSONArray2.length());
                    int length2 = optJSONArray2.length();
                    for (int i5 = 0; i5 < length2; i5++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                        if (optJSONObject2 != null) {
                            EmojiInfo emojiInfo2 = new EmojiInfo();
                            b.a("MicroMsg.SimilarEmoji", optJSONObject2, emojiInfo2);
                            LinkedList<h> linkedList = this.IND;
                            String optString3 = optJSONObject2.optString("docID", "");
                            p.g(optString3, "it.optString(\"docID\", \"\")");
                            linkedList.add(new h(emojiInfo2, 103, optString3, this.gYe));
                        }
                    }
                    if (this.tuG) {
                        this.IND.add(new h(new EmojiInfo(), 104));
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.SimilarEmoji", e3, "resultObj", new Object[0]);
                }
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(82494);
            return;
        }
        AppMethodBeat.o(82494);
    }
}
