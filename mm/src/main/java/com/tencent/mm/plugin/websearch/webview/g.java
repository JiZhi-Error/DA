package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000K\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u000f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\bJ\u001c\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\f0\nX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData;", "T", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;)V", "TAG", "", "avatarIdMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "emojiImgMap", "ftsEmojiDownloadedListener", "com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1;", "destroy", "", "getImageUIComponent", "getSearchAvatarList", "data", "getSearchImageList", "requestType", "", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ui-websearch_release"})
public class g<T> extends a<T> implements MStorage.IOnStorageChange {
    private final HashMap<String, HashSet<String>> IHg = new HashMap<>();
    private final HashMap<String, HashSet<String>> IHh = new HashMap<>();
    private final a IHi = new a(this);
    private final String TAG = "MicroMsg.WebSearch.WebSearchImageData";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(c<T> cVar) {
        super(cVar);
        p.h(cVar, "uiComponent");
        AppMethodBeat.i(198069);
        this.IHi.alive();
        com.tencent.mm.aj.p.aYB().add(this);
        AppMethodBeat.o(198069);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/websearch/webview/WebSearchImageData$ftsEmojiDownloadedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FTSEmojiDownloadedEvent;", "callback", "", "event", "ui-websearch_release"})
    public static final class a extends IListener<gr> {
        final /* synthetic */ g IHj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(g gVar) {
            this.IHj = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gr grVar) {
            AppMethodBeat.i(198064);
            boolean a2 = a(grVar);
            AppMethodBeat.o(198064);
            return a2;
        }

        private boolean a(gr grVar) {
            h<T> dQi;
            AppMethodBeat.i(198063);
            if (grVar != null && grVar.dKH.dDe == 2) {
                Log.i(this.IHj.TAG, "emoji download callback %s", grVar.dKH.md5);
                if (this.IHj.IHg.containsKey(grVar.dKH.md5)) {
                    synchronized (this.IHj.IHg) {
                        try {
                            HashSet hashSet = (HashSet) this.IHj.IHg.get(grVar.dKH.md5);
                            JSONArray jSONArray = new JSONArray();
                            if (hashSet == null) {
                                p.hyc();
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/emoji?path=" + grVar.dKI.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e2) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            c<T> fYS = this.IHj.fYS();
                            if (!(fYS == null || (dQi = fYS.dQi()) == null)) {
                                String jSONArray2 = jSONArray.toString();
                                p.g(jSONArray2, "returnArray.toString()");
                                dQi.cQ(0, jSONArray2);
                            }
                            this.IHj.IHg.remove(grVar.dKH.md5);
                        } finally {
                            AppMethodBeat.o(198063);
                        }
                    }
                }
            }
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.webview.a
    public void destroy() {
        AppMethodBeat.i(198065);
        super.destroy();
        this.IHi.dead();
        com.tencent.mm.aj.p.aYB().remove(this);
        AppMethodBeat.o(198065);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00fd, code lost:
        if (r13.IHh.put(r9, r1) == null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x013d, code lost:
        if (r13.IHh.put(r9, r1) == null) goto L_0x013f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aXr(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 450
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.webview.g.aXr(java.lang.String):void");
    }

    public final void cP(int i2, String str) {
        h<T> dQi;
        String str2;
        HashSet<String> hashSet;
        h<T> dQi2;
        AppMethodBeat.i(198067);
        p.h(str, "data");
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        switch (i2) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    JSONArray jSONArray2 = new JSONArray();
                    int i3 = 0;
                    String str3 = null;
                    while (i3 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString("id");
                        if (optInt == 2) {
                            gr grVar = new gr();
                            grVar.dKH.dDe = 3;
                            grVar.dKH.md5 = jSONObject.optString("md5");
                            grVar.dKH.dKJ = jSONObject.optString("designerId");
                            grVar.dKH.aeskey = jSONObject.optString("aesKey");
                            grVar.dKH.dKK = jSONObject.optString("encryptUrl");
                            grVar.dKH.productId = jSONObject.optString("productID");
                            grVar.dKH.name = jSONObject.optString("express");
                            grVar.dKH.thumbUrl = jSONObject.optString("imageUrl");
                            EventCenter.instance.publish(grVar);
                            if (s.YS(grVar.dKI.path)) {
                                str2 = "weixin://fts/emoji?path=" + grVar.dKI.path;
                                Log.i(this.TAG, "path=%s", grVar.dKI.path);
                            } else if (isWifi) {
                                synchronized (this.IHg) {
                                    try {
                                        if (this.IHg.containsKey(grVar.dKH.md5)) {
                                            hashSet = this.IHg.get(grVar.dKH.md5);
                                            if (hashSet == null) {
                                                hashSet = new HashSet<>();
                                            }
                                        } else {
                                            hashSet = new HashSet<>();
                                        }
                                        p.g(hashSet, "if (emojiImgMap.contains…                        }");
                                        hashSet.add(optString);
                                        this.IHg.put(grVar.dKH.md5, hashSet);
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(198067);
                                        throw th;
                                    }
                                }
                                grVar.dKH.dDe = 1;
                                EventCenter.instance.publish(grVar);
                                str2 = str3;
                            } else {
                                str2 = jSONObject.optString("imageUrl");
                            }
                            if (str2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("id", optString);
                                jSONObject2.put("src", str2);
                                jSONArray2.put(jSONObject2);
                                str2 = null;
                            }
                        } else if (optInt == 4) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("id", optString);
                            if (isWifi) {
                                jSONObject3.put("src", jSONObject.optString(ShareConstants.DEXMODE_RAW));
                            } else {
                                jSONObject3.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(jSONObject3);
                            str2 = str3;
                        } else {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("id", optString);
                            jSONObject4.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(jSONObject4);
                            str2 = str3;
                        }
                        i3++;
                        str3 = str2;
                    }
                    if (jSONArray2.length() > 0) {
                        c<T> fYS = fYS();
                        if (fYS == null || (dQi = fYS.dQi()) == null) {
                            AppMethodBeat.o(198067);
                            return;
                        }
                        String jSONArray3 = jSONArray2.toString();
                        p.g(jSONArray3, "returnArray.toString()");
                        dQi.cQ(0, jSONArray3);
                        AppMethodBeat.o(198067);
                        return;
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(198067);
                    return;
                }
                break;
            default:
                try {
                    JSONArray jSONArray4 = new JSONArray(str);
                    JSONArray jSONArray5 = new JSONArray();
                    for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i4);
                        JSONObject jSONObject6 = new JSONObject();
                        String string = jSONObject5.getString("id");
                        String string2 = jSONObject5.getString("imageUrl");
                        jSONObject6.put("id", string);
                        jSONObject6.put("src", string2);
                        jSONArray5.put(jSONObject6);
                    }
                    c<T> fYS2 = fYS();
                    if (fYS2 == null || (dQi2 = fYS2.dQi()) == null) {
                        AppMethodBeat.o(198067);
                        return;
                    }
                    String jSONArray6 = jSONArray5.toString();
                    p.g(jSONArray6, "returnArray.toString()");
                    dQi2.cQ(0, jSONArray6);
                    AppMethodBeat.o(198067);
                    return;
                } catch (JSONException e3) {
                    break;
                }
        }
        AppMethodBeat.o(198067);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        String str2;
        h<T> dQi;
        Object obj;
        String obj2;
        AppMethodBeat.i(198068);
        synchronized (this.IHh) {
            try {
                Log.i(this.TAG, "event %s，eventData %s", str, String.valueOf(mStorageEventData));
                if (mStorageEventData == null || (obj = mStorageEventData.obj) == null || (obj2 = obj.toString()) == null) {
                    str2 = "";
                } else {
                    str2 = obj2;
                }
                if (this.IHh.containsKey(str2)) {
                    Log.i(this.TAG, "notify avatar changed %s", str2);
                    JSONArray jSONArray = new JSONArray();
                    HashSet<String> hashSet = this.IHh.get(str2);
                    if (hashSet != null) {
                        for (T t : hashSet) {
                            com.tencent.mm.aj.p.aYn();
                            String concat = "weixin://fts/avatar?path=".concat(String.valueOf(e.Ml(str2)));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", t);
                                jSONObject.put("src", concat);
                            } catch (Exception e2) {
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    c<T> fYS = fYS();
                    if (!(fYS == null || (dQi = fYS.dQi()) == null)) {
                        String jSONArray2 = jSONArray.toString();
                        p.g(jSONArray2, "returnArray.toString()");
                        dQi.cQ(0, jSONArray2);
                    }
                    this.IHh.remove(str2);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(198068);
            }
        }
    }

    public final c<T> fYS() {
        d<T> dVar = this.IHe;
        if (!(dVar instanceof c)) {
            dVar = null;
        }
        return (c) dVar;
    }
}
