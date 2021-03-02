package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.util.Currency;

/* access modifiers changed from: package-private */
public class InternalAppEventsLogger extends AppEventsLogger {
    InternalAppEventsLogger(Context context) {
        this(Utility.getActivityName(context), null, null);
        AppMethodBeat.i(17647);
        AppMethodBeat.o(17647);
    }

    InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        super(str, str2, accessToken);
    }

    @Override // com.facebook.appevents.AppEventsLogger
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17648);
        super.logPurchaseImplicitlyInternal(bigDecimal, currency, bundle);
        AppMethodBeat.o(17648);
    }

    @Override // com.facebook.appevents.AppEventsLogger
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(17649);
        super.logEventImplicitly(str, bigDecimal, currency, bundle);
        AppMethodBeat.o(17649);
    }
}
