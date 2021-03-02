package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR = new Parcelable.Creator<JsapiPermissionWrapper>() {
        /* class com.tencent.mm.protocal.JsapiPermissionWrapper.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsapiPermissionWrapper[] newArray(int i2) {
            return new JsapiPermissionWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsapiPermissionWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(152450);
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(parcel, (byte) 0);
            AppMethodBeat.o(152450);
            return jsapiPermissionWrapper;
        }
    };
    public static final JsapiPermissionWrapper Kzm = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper Kzn = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper Kzo = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper Kzp = new JsapiPermissionWrapper(4);
    public byte[] Kzq;
    public int Kzr;
    private Set<Integer> Kzs;
    private Set<Integer> Kzt;

    /* synthetic */ JsapiPermissionWrapper(Parcel parcel, byte b2) {
        this(parcel);
    }

    @Override // java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(223879);
        JsapiPermissionWrapper gtN = gtN();
        AppMethodBeat.o(223879);
        return gtN;
    }

    static {
        AppMethodBeat.i(152466);
        AppMethodBeat.o(152466);
    }

    public JsapiPermissionWrapper() {
        this.Kzq = null;
        this.Kzr = 0;
        this.Kzq = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        AppMethodBeat.i(152451);
        this.Kzq = null;
        this.Kzr = 0;
        if (bArr == null) {
            this.Kzq = null;
            AppMethodBeat.o(152451);
            return;
        }
        this.Kzq = bArr;
        AppMethodBeat.o(152451);
    }

    public JsapiPermissionWrapper(int i2) {
        AppMethodBeat.i(152452);
        this.Kzq = null;
        this.Kzr = 0;
        this.Kzr = i2;
        this.Kzq = new byte[0];
        AppMethodBeat.o(152452);
    }

    public final int aiW(int i2) {
        AppMethodBeat.i(223877);
        if (aiY(i2)) {
            AppMethodBeat.o(223877);
            return 1;
        } else if (aiX(i2)) {
            AppMethodBeat.o(223877);
            return 0;
        } else if (this.Kzr == 1) {
            if (i2 == 34 || i2 == 75) {
                Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i2));
                AppMethodBeat.o(223877);
                return 0;
            }
            AppMethodBeat.o(223877);
            return 1;
        } else if (this.Kzr == 2) {
            if (i2 == -3) {
                AppMethodBeat.o(223877);
                return 1;
            }
            AppMethodBeat.o(223877);
            return 0;
        } else if (this.Kzr == 3) {
            if (i2 == 34 || i2 == 75 || i2 == 23) {
                Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", Integer.valueOf(i2));
                AppMethodBeat.o(223877);
                return 0;
            }
            AppMethodBeat.o(223877);
            return 1;
        } else if (this.Kzr == 4) {
            if (i2 == 34 || i2 == 75) {
                Log.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", Integer.valueOf(i2));
                AppMethodBeat.o(223877);
                return 0;
            }
            AppMethodBeat.o(223877);
            return 1;
        } else if (i2 == -2 || i2 == -3) {
            AppMethodBeat.o(223877);
            return 1;
        } else if (this.Kzq == null || i2 < 0 || i2 >= this.Kzq.length) {
            AppMethodBeat.o(223877);
            return 0;
        } else {
            byte b2 = this.Kzq[i2];
            AppMethodBeat.o(223877);
            return b2;
        }
    }

    public final synchronized void a(int i2, byte b2) {
        AppMethodBeat.i(152454);
        if (this.Kzq == null || i2 < 0) {
            Log.e("MicroMsg.JsapiPermissionWrapper", "setPermission pos out of range, %s", Integer.valueOf(i2));
            AppMethodBeat.o(152454);
        } else {
            if (i2 >= this.Kzq.length) {
                Log.w("MicroMsg.JsapiPermissionWrapper", "setPermission append pos out of range, %s, %s", Integer.valueOf(i2), Integer.valueOf(this.Kzq.length));
                byte[] bArr = new byte[(i2 + 1)];
                Arrays.fill(bArr, (byte) 2);
                System.arraycopy(this.Kzq, 0, bArr, 0, this.Kzq.length);
                this.Kzq = bArr;
            }
            this.Kzq[i2] = b2;
            AppMethodBeat.o(152454);
        }
    }

    public final boolean pP(int i2) {
        AppMethodBeat.i(152455);
        if (aiW(i2) == 1) {
            AppMethodBeat.o(152455);
            return true;
        }
        AppMethodBeat.o(152455);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(152456);
        if (this.Kzq == null) {
            AppMethodBeat.o(152456);
            return BuildConfig.COMMAND;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder((int) TXLiveConstants.RENDER_ROTATION_180);
        for (byte b2 : this.Kzq) {
            sb.append((int) b2);
        }
        String sb2 = sb.toString();
        Log.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(152456);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(152457);
        parcel.writeByteArray(this.Kzq);
        parcel.writeInt(this.Kzr);
        parcel.writeIntArray(gtL());
        parcel.writeIntArray(gtM());
        AppMethodBeat.o(152457);
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        AppMethodBeat.i(152458);
        this.Kzq = null;
        this.Kzr = 0;
        this.Kzq = parcel.createByteArray();
        this.Kzr = parcel.readInt();
        O(parcel.createIntArray());
        P(parcel.createIntArray());
        AppMethodBeat.o(152458);
    }

    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(152459);
        this.Kzq = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.Kzr = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        O(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        P(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
        AppMethodBeat.o(152459);
    }

    public final int[] gtL() {
        AppMethodBeat.i(152460);
        if (this.Kzs != null) {
            int[] iArr = new int[this.Kzs.size()];
            Iterator<Integer> it = this.Kzs.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Integer next = it.next();
                int i3 = i2 + 1;
                iArr[i2] = next == null ? 0 : next.intValue();
                i2 = i3;
            }
            AppMethodBeat.o(152460);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.o(152460);
        return iArr2;
    }

    private void O(int[] iArr) {
        AppMethodBeat.i(152461);
        if (this.Kzs == null) {
            this.Kzs = new HashSet();
        } else {
            this.Kzs.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                this.Kzs.add(Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(152461);
    }

    private boolean aiX(int i2) {
        AppMethodBeat.i(152462);
        if (this.Kzs == null || !this.Kzs.contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(152462);
            return false;
        }
        AppMethodBeat.o(152462);
        return true;
    }

    public final int[] gtM() {
        AppMethodBeat.i(152463);
        if (this.Kzt != null) {
            int[] iArr = new int[this.Kzt.size()];
            Iterator<Integer> it = this.Kzt.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Integer next = it.next();
                int i3 = i2 + 1;
                iArr[i2] = next == null ? 0 : next.intValue();
                i2 = i3;
            }
            AppMethodBeat.o(152463);
            return iArr;
        }
        int[] iArr2 = new int[0];
        AppMethodBeat.o(152463);
        return iArr2;
    }

    private void P(int[] iArr) {
        AppMethodBeat.i(152464);
        if (this.Kzt == null) {
            this.Kzt = new HashSet();
        } else {
            this.Kzt.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                this.Kzt.add(Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(152464);
    }

    private boolean aiY(int i2) {
        AppMethodBeat.i(152465);
        if (this.Kzt == null || !this.Kzt.contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(152465);
            return false;
        }
        AppMethodBeat.o(152465);
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.Kzq == jsapiPermissionWrapper.Kzq) {
            return true;
        }
        if (this.Kzq == null || jsapiPermissionWrapper.Kzq == null || this.Kzq.length != jsapiPermissionWrapper.Kzq.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.Kzq.length; i2++) {
            if (this.Kzq[i2] != jsapiPermissionWrapper.Kzq[i2]) {
                return false;
            }
        }
        return true;
    }

    public final JsapiPermissionWrapper gtN() {
        AppMethodBeat.i(223878);
        Parcel parcel = null;
        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable(this, 0);
            parcel.setDataPosition(0);
            return (JsapiPermissionWrapper) parcel.readParcelable(JsapiPermissionWrapper.class.getClassLoader());
        } finally {
            parcel.recycle();
            AppMethodBeat.o(223878);
        }
    }
}
