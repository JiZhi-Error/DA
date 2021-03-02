package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IdentityProviders {
    public static final String FACEBOOK = "https://www.facebook.com";
    public static final String GOOGLE = "https://accounts.google.com";
    public static final String LINKEDIN = "https://www.linkedin.com";
    public static final String MICROSOFT = "https://login.live.com";
    public static final String PAYPAL = "https://www.paypal.com";
    public static final String TWITTER = "https://twitter.com";
    public static final String YAHOO = "https://login.yahoo.com";

    private IdentityProviders() {
    }

    public static final String getIdentityProviderForAccount(Account account) {
        AppMethodBeat.i(88249);
        Preconditions.checkNotNull(account, "account cannot be null");
        if ("com.google".equals(account.type)) {
            AppMethodBeat.o(88249);
            return GOOGLE;
        } else if ("com.facebook.auth.login".equals(account.type)) {
            AppMethodBeat.o(88249);
            return FACEBOOK;
        } else {
            AppMethodBeat.o(88249);
            return null;
        }
    }
}
