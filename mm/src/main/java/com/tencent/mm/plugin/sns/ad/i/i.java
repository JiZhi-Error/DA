package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class i {

    public interface a {
        String eWH();

        String getContent();
    }

    public static abstract class b implements a {
        /* access modifiers changed from: protected */
        public abstract void bn(JSONObject jSONObject);

        /* access modifiers changed from: protected */
        public abstract void bo(JSONObject jSONObject);

        @Override // com.tencent.mm.plugin.sns.ad.i.i.a
        public String getContent() {
            try {
                JSONObject eYm = eYm();
                if (eYm != null) {
                    JSONObject eYn = eYn();
                    if (eYn != null) {
                        eYm.putOpt(IssueStorage.COLUMN_EXT_INFO, eYn);
                    }
                    return eYm.toString();
                }
            } catch (Throwable th) {
            }
            return "";
        }

        private JSONObject eYm() {
            try {
                JSONObject jSONObject = new JSONObject();
                bn(jSONObject);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }

        private JSONObject eYn() {
            try {
                JSONObject jSONObject = new JSONObject();
                bo(jSONObject);
                return jSONObject;
            } catch (Throwable th) {
                return null;
            }
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(202362);
        if (aVar != null) {
            try {
                report(aVar.eWH(), aVar.getContent());
            } catch (Throwable th) {
                AppMethodBeat.o(202362);
                return;
            }
        }
        AppMethodBeat.o(202362);
    }

    private static void report(String str, String str2) {
        AppMethodBeat.i(202363);
        try {
            Log.d("SnsAdChannelReporter", "Channel: " + str + "; Content: " + str2);
            k.jY(str, str2);
            AppMethodBeat.o(202363);
        } catch (Throwable th) {
            AppMethodBeat.o(202363);
        }
    }
}
