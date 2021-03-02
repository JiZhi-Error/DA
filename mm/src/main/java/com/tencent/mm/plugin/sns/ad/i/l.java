package com.tencent.mm.plugin.sns.ad.i;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.k;

public final class l {
    public static k.b XV(int i2) {
        AppMethodBeat.i(202366);
        String str = "1";
        if (i2 == 0) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        a aVar = new a(str, (byte) 0);
        AppMethodBeat.o(202366);
        return aVar;
    }

    static class a extends k.a {
        private String mValue;

        /* synthetic */ a(String str, byte b2) {
            this(str);
        }

        private a(String str) {
            this.mValue = str;
        }

        @Override // com.tencent.mm.plugin.sns.ad.i.k.b
        public final String eYp() {
            return "ONLINE_FILE_COPY_AT_LANDING";
        }

        @Override // com.tencent.mm.plugin.sns.ad.i.k.b
        public final String eYq() {
            AppMethodBeat.i(202365);
            if (TextUtils.isEmpty(this.mValue)) {
                AppMethodBeat.o(202365);
                return "";
            }
            String str = this.mValue;
            AppMethodBeat.o(202365);
            return str;
        }
    }
}
