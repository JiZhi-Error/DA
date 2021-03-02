package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements BaseColumns {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f1495a = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");

    static {
        AppMethodBeat.i(190416);
        AppMethodBeat.o(190416);
    }
}
