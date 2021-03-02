package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.plugin.base.stub.MMPluginProvider;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.util.HashMap;
import java.util.Map;

public final class c extends MMPluginProvider.a {
    private static final Map<String, Object> pdq;

    static {
        AppMethodBeat.i(22176);
        HashMap hashMap = new HashMap();
        pdq = hashMap;
        hashMap.put("_build_info_sdk_int_", Integer.valueOf(d.KyO));
        pdq.put("_build_info_sdk_name_", Build.SDK_VERSION_NAME);
        pdq.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
        AppMethodBeat.o(22176);
    }

    @Override // com.tencent.mm.plugin.base.stub.MMPluginProvider.a
    public final boolean eI(Context context) {
        AppMethodBeat.i(22174);
        super.eI(context);
        AppMethodBeat.o(22174);
        return true;
    }

    public static Cursor b(String[] strArr, String[] strArr2) {
        String str = null;
        AppMethodBeat.i(22175);
        String str2 = strArr2[0];
        Object obj = pdq.get(str2);
        if (obj == null) {
            Log.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(22175);
            return null;
        }
        int type = MMPluginProviderConstants.Resolver.getType(obj);
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Object[] objArr = new Object[4];
        objArr[0] = 0;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(type);
        if (obj != null) {
            str = obj.toString();
        }
        objArr[3] = str;
        matrixCursor.addRow(objArr);
        AppMethodBeat.o(22175);
        return matrixCursor;
    }
}
