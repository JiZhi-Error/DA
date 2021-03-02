package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;

public interface ICommLibReader extends Parcelable, com.tencent.luggage.a.b, o, Closeable, Comparable<ICommLibReader> {

    public static class a extends RuntimeException {
    }

    String UN(String str);

    public static class b {
        public static void a(ICommLibReader iCommLibReader, Parcel parcel, int i2) {
            AppMethodBeat.i(178572);
            if (iCommLibReader == null) {
                parcel.writeString(null);
                AppMethodBeat.o(178572);
                return;
            }
            parcel.writeString(iCommLibReader.getClass().getName());
            parcel.writeParcelable(iCommLibReader, i2);
            AppMethodBeat.o(178572);
        }

        public static ICommLibReader h(Parcel parcel) {
            AppMethodBeat.i(178573);
            String readString = parcel.readString();
            if (TextUtils.isEmpty(readString)) {
                AppMethodBeat.o(178573);
                return null;
            }
            try {
                ICommLibReader iCommLibReader = (ICommLibReader) parcel.readParcelable(Class.forName(readString).getClassLoader());
                AppMethodBeat.o(178573);
                return iCommLibReader;
            } catch (Exception e2) {
                Log.e("Luggage.WXA.ICommLibReader.ParcelHelper", "readFromParcel e=%s", e2);
                AppMethodBeat.o(178573);
                return null;
            }
        }
    }
}
