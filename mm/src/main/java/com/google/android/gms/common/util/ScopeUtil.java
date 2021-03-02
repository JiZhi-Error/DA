package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil {
    private ScopeUtil() {
    }

    public static Set<Scope> fromScopeString(Collection<String> collection) {
        AppMethodBeat.i(5284);
        Preconditions.checkNotNull(collection, "scopeStrings can't be null.");
        Set<Scope> fromScopeString = fromScopeString((String[]) collection.toArray(new String[collection.size()]));
        AppMethodBeat.o(5284);
        return fromScopeString;
    }

    public static Set<Scope> fromScopeString(String... strArr) {
        AppMethodBeat.i(5285);
        Preconditions.checkNotNull(strArr, "scopeStrings can't be null.");
        HashSet hashSet = new HashSet(strArr.length);
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                hashSet.add(new Scope(str));
            }
        }
        AppMethodBeat.o(5285);
        return hashSet;
    }

    public static String[] toScopeString(Set<Scope> set) {
        AppMethodBeat.i(5287);
        Preconditions.checkNotNull(set, "scopes can't be null.");
        String[] scopeString = toScopeString((Scope[]) set.toArray(new Scope[set.size()]));
        AppMethodBeat.o(5287);
        return scopeString;
    }

    public static String[] toScopeString(Scope[] scopeArr) {
        AppMethodBeat.i(5286);
        Preconditions.checkNotNull(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i2 = 0; i2 < scopeArr.length; i2++) {
            strArr[i2] = scopeArr[i2].getScopeUri();
        }
        AppMethodBeat.o(5286);
        return strArr;
    }
}
