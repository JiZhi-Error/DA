package com.tencent.mm.plugin.websearch.b.a;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a<m> {
    private List<String> IGB;
    public boolean dDz;
    private List<m> wXb;

    public d(String str, List<String> list) {
        super(str, Integer.MAX_VALUE);
        this.IGB = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<com.tencent.mm.plugin.fts.a.a.m> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.websearch.b.a.a
    public final void ih(List<m> list) {
        AppMethodBeat.i(116560);
        this.wXb = list;
        if (this.wXb != null) {
            ArrayList arrayList = new ArrayList(this.IGB.size());
            Iterator<m> it = this.wXb.iterator();
            while (it.hasNext()) {
                m next = it.next();
                int indexOf = this.IGB.indexOf(((l) g.af(l.class)).aSN().Kn(next.wVX).field_username);
                if (indexOf >= 0) {
                    if (indexOf < arrayList.size()) {
                        arrayList.add(indexOf, next);
                    } else {
                        arrayList.add(next);
                    }
                    it.remove();
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.wXb.add(0, arrayList.get(size));
            }
        }
        this.dDz = true;
        AppMethodBeat.o(116560);
    }

    public final JSONObject kd(int i2, int i3) {
        int i4;
        AppMethodBeat.i(116561);
        JSONObject jSONObject = new JSONObject();
        if (!this.dDz) {
            AppMethodBeat.o(116561);
            return jSONObject;
        } else if (i2 < 0 || i3 <= 0) {
            AppMethodBeat.o(116561);
            return jSONObject;
        } else {
            int i5 = (i2 + i3) - 1;
            if (i5 > this.wXb.size() - 1) {
                i4 = this.wXb.size() - 1;
            } else {
                i4 = i5;
            }
            if (i4 < i2) {
                AppMethodBeat.o(116561);
                return jSONObject;
            }
            try {
                jSONObject.put("continueFlag", i4 == this.wXb.size() + -1 ? 0 : 1);
                jSONObject.put("offset", i4 + 1);
                jSONObject.put(SearchIntents.EXTRA_QUERY, this.query);
                jSONObject.put("ret", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("count", (i4 - i2) + 1);
                jSONObject2.put("totalCount", ab.aVb());
                JSONArray jSONArray = new JSONArray();
                while (i2 <= i4) {
                    m mVar = this.wXb.get(i2);
                    JSONObject jSONObject3 = new JSONObject();
                    as Kn = ((l) g.af(l.class)).aSN().Kn(mVar.wVX);
                    jSONObject3.put("userName", Kn.field_username);
                    jSONObject3.put("nickName", Kn.field_nickname);
                    String str = mVar.content;
                    Context context = MMApplicationContext.getContext();
                    String replaceFirst = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
                    switch (mVar.wVW) {
                        case 1:
                        case 4:
                        case 5:
                            break;
                        case 15:
                            replaceFirst = context.getString(R.string.iy4) + replaceFirst;
                            break;
                        default:
                            replaceFirst = "";
                            break;
                    }
                    try {
                        jSONObject3.put("displayText", replaceFirst);
                    } catch (JSONException e2) {
                        Log.printErrStackTrace("JsapiFtsMatchContact", e2, "", new Object[0]);
                    }
                    String str2 = "";
                    i Mx = p.aYB().Mx(Kn.field_username);
                    if (Mx != null) {
                        str2 = Mx.aYu();
                        if (Util.isNullOrNil(str2)) {
                            str2 = Mx.aYt();
                        }
                    }
                    jSONObject3.put("thumbUrl", str2);
                    jSONArray.put(jSONObject3);
                    i2++;
                }
                jSONObject2.put("items", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject2);
                jSONObject.put("data", jSONArray2);
            } catch (JSONException e3) {
                Log.printErrStackTrace("JsapiFtsMatchContact", e3, "", new Object[0]);
            }
            AppMethodBeat.o(116561);
            return jSONObject;
        }
    }
}
