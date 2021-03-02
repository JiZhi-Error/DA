package com.tencent.mm.sticker;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020%H\u0016R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, hxF = {"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", MessengerShareContentUtility.ELEMENTS, "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e extends a {
    private static final int NMU = 10;
    private static final int NMV = 11;
    private static final int NMW = 12;
    private static final int NMX = 13;
    private static final int NMY = 14;
    private static final int NMZ = 15;
    private static final int NNa = 16;
    private static final int NNb = 17;
    private static final int NNc = 100;
    private static final int NNd = 101;
    private static final int NNe = 102;
    private static final int NNf = 103;
    private static final int NNg = 104;
    private static final int NNh = 105;
    private static final int NNi = 106;
    private static final int NNj = 107;
    private static final int NNk = 108;
    private static final int NNl = 109;
    private static final int NNm = 110;
    private static final int NNn = 111;
    private static final int NNo = 112;
    private static final int NNp = NNp;
    public static final a NNq = new a((byte) 0);
    private g NMS = new g();
    public HashMap<String, d> NMT = new HashMap<>();
    public String cHM = "";
    public double jgT;
    String rnS = "";
    public String type = "Sticker2D";

    public e() {
        AppMethodBeat.i(105901);
        AppMethodBeat.o(105901);
    }

    public final void setType(String str) {
        AppMethodBeat.i(105894);
        p.h(str, "<set-?>");
        this.type = str;
        AppMethodBeat.o(105894);
    }

    public final void bip(String str) {
        AppMethodBeat.i(105895);
        p.h(str, "<set-?>");
        this.cHM = str;
        AppMethodBeat.o(105895);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(194215);
        p.h(gVar, "<set-?>");
        this.NMS = gVar;
        AppMethodBeat.o(194215);
    }

    public final void s(HashMap<String, d> hashMap) {
        AppMethodBeat.i(105896);
        p.h(hashMap, "<set-?>");
        this.NMT = hashMap;
        AppMethodBeat.o(105896);
    }

    public final boolean gyA() {
        boolean z;
        AppMethodBeat.i(105897);
        Collection<d> values = this.NMT.values();
        p.g(values, "elements.values");
        Collection<d> collection = values;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                int i2 = it.next().NMN;
                if (100 <= i2 && NNp >= i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(105897);
                    return true;
                }
            }
        }
        AppMethodBeat.o(105897);
        return false;
    }

    public final boolean gyB() {
        boolean z;
        AppMethodBeat.i(105898);
        Collection<d> values = this.NMT.values();
        p.g(values, "elements.values");
        Collection<d> collection = values;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                int i2 = it.next().NMN;
                if (10 <= i2 && 17 >= i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(105898);
                    return true;
                }
            }
        }
        AppMethodBeat.o(105898);
        return false;
    }

    @Override // com.tencent.mm.sticker.a
    public final a au(JSONObject jSONObject) {
        AppMethodBeat.i(105899);
        p.h(jSONObject, "jsonObj");
        String optString = jSONObject.optString("id", "");
        p.g(optString, "jsonObj.optString(\"id\", \"\")");
        this.rnS = optString;
        this.jgT = jSONObject.optDouble("version", this.jgT);
        String optString2 = jSONObject.optString("type", this.type);
        p.g(optString2, "jsonObj.optString(\"type\", type)");
        this.type = optString2;
        JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray(MessengerShareContentUtility.ELEMENTS) : null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String string = optJSONArray.getString(i2);
                JSONObject jSONObject2 = optJSONObject.getJSONObject(string);
                d dVar = new d();
                p.g(string, "name");
                dVar.setName(string);
                p.g(jSONObject2, "elementObj");
                dVar.au(jSONObject2);
                this.NMT.put(string, dVar);
            }
        }
        a au = super.au(jSONObject);
        AppMethodBeat.o(105899);
        return au;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    @Override // com.tencent.mm.sticker.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject toJson() {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sticker.e.toJson():org.json.JSONObject");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b-\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0014\u0010-\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0014\u0010/\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006¨\u00061"}, hxF = {"Lcom/tencent/mm/sticker/StickerInfo$Companion;", "", "()V", "ACTION_EYEBROW_UP", "", "getACTION_EYEBROW_UP", "()I", "ACTION_EYE_BLINK", "getACTION_EYE_BLINK", "ACTION_HEAD_NOD", "getACTION_HEAD_NOD", "ACTION_HEAD_SHAKE", "getACTION_HEAD_SHAKE", "ACTION_LEFTEYE_BLINK", "getACTION_LEFTEYE_BLINK", "ACTION_MOUTH_KISS", "getACTION_MOUTH_KISS", "ACTION_MOUTH_OPEN", "getACTION_MOUTH_OPEN", "ACTION_RIGHTEYE_BLINK", "getACTION_RIGHTEYE_BLINK", "HAND_ACTION_EIGHT", "getHAND_ACTION_EIGHT", "HAND_ACTION_FIST", "getHAND_ACTION_FIST", "HAND_ACTION_GOOD_FORTUNE", "getHAND_ACTION_GOOD_FORTUNE", "HAND_ACTION_HEART", "getHAND_ACTION_HEART", "HAND_ACTION_LIFT", "getHAND_ACTION_LIFT", "HAND_ACTION_LIKE", "getHAND_ACTION_LIKE", "HAND_ACTION_LOVE", "getHAND_ACTION_LOVE", "HAND_ACTION_OK", "getHAND_ACTION_OK", "HAND_ACTION_ONE", "getHAND_ACTION_ONE", "HAND_ACTION_PAPER", "getHAND_ACTION_PAPER", "HAND_ACTION_REJECT", "getHAND_ACTION_REJECT", "HAND_ACTION_ROCK", "getHAND_ACTION_ROCK", "HAND_ACTION_SCISSOR", "getHAND_ACTION_SCISSOR", "HAND_ACTION_SIX", "getHAND_ACTION_SIX", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(105902);
        AppMethodBeat.o(105902);
    }
}
