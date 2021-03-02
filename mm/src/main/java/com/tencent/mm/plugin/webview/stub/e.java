package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface e extends IInterface {
    boolean IS(String str);

    boolean IT(String str);

    boolean JE(String str);

    boolean N(long j2, String str);

    void U(int i2, String str, String str2);

    void a(int i2, Bundle bundle, int i3);

    void a(f fVar, int i2);

    void a(String str, Bundle bundle, int i2);

    void a(String str, String str2, String str3, int i2, int i3, Bundle bundle);

    void a(String str, int[] iArr, int i2, int i3);

    boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i2);

    boolean a(String str, boolean z, Bundle bundle);

    void aL(int i2, int i3, int i4);

    boolean aUM();

    c aY(Bundle bundle);

    boolean aZ(Bundle bundle);

    List<String> aZM();

    boolean aZN();

    String aZQ(String str);

    String aZR(String str);

    void aZS(String str);

    String aZT(String str);

    boolean aZU(String str);

    String aZV(String str);

    void aZW(String str);

    int aZX(String str);

    void aZY(String str);

    void aZZ(String str);

    String aZj(String str);

    void agA(int i2);

    Bundle agv(int i2);

    boolean agw(int i2);

    void agx(int i2);

    void agy(int i2);

    void agz(int i2);

    void an(String str, String str2, int i2);

    boolean apn();

    void b(Bundle bundle, int i2);

    String baa(String str);

    void bm(Intent intent);

    void bs(int i2, boolean z);

    void cP(String str, boolean z);

    String cX(int i2, String str);

    void favEditTag();

    boolean gdW();

    String[] gdX();

    String gdY();

    String gdZ();

    String gea();

    Map geb();

    int gec();

    int ged();

    void gee();

    void gef();

    boolean geg();

    boolean geh();

    boolean gei();

    List<String> gej();

    boolean gek();

    String[] gel();

    String getDisplayName(String str);

    String getLanguage();

    int getPayChannel();

    void gt(String str, int i2);

    String gu(String str, int i2);

    void gv(String str, int i2);

    boolean gw(String str);

    boolean isSDCardAvailable();

    Bundle j(int i2, Bundle bundle);

    int kl(int i2, int i3);

    void km(int i2, int i3);

    void l(String str, boolean z, int i2);

    String md(String str, String str2);

    Bundle u(int i2, Bundle bundle);

    void v(int i2, Bundle bundle);

    void v(int i2, List<String> list);

    Bundle w(int i2, Bundle bundle);

    boolean x(int i2, Bundle bundle);

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        }

        public static e H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C1972a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            Bundle bundle;
            Bundle bundle2;
            Intent intent;
            Bundle bundle3;
            Bundle bundle4;
            Bundle bundle5;
            Bundle bundle6;
            Bundle bundle7;
            Bundle bundle8;
            Bundle bundle9;
            Bundle bundle10;
            Bundle bundle11;
            Bundle bundle12;
            Bundle bundle13;
            Bundle bundle14 = null;
            IBinder iBinder = null;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            boolean z = false;
            int i17 = 0;
            boolean z2 = false;
            int i18 = 0;
            int i19 = 0;
            boolean z3 = false;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            switch (i2) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean aZU = aZU(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(aZU ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String displayName = getDisplayName(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(displayName);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean IS = IS(parcel.readString());
                    parcel2.writeNoException();
                    if (IS) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean JE = JE(parcel.readString());
                    parcel2.writeNoException();
                    if (JE) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean IT = IT(parcel.readString());
                    parcel2.writeNoException();
                    if (IT) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String aZQ = aZQ(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aZQ);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean apn = apn();
                    parcel2.writeNoException();
                    if (apn) {
                        i8 = 1;
                    }
                    parcel2.writeInt(i8);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean isSDCardAvailable = isSDCardAvailable();
                    parcel2.writeNoException();
                    if (isSDCardAvailable) {
                        i9 = 1;
                    }
                    parcel2.writeInt(i9);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean gdW = gdW();
                    parcel2.writeNoException();
                    if (gdW) {
                        i10 = 1;
                    }
                    parcel2.writeInt(i10);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean aUM = aUM();
                    parcel2.writeNoException();
                    if (aUM) {
                        i11 = 1;
                    }
                    parcel2.writeInt(i11);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int kl = kl(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(kl);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    km(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String cX = cX(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(cX);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle13 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle13 = null;
                    }
                    a(readInt, bundle13, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle12 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle12 = null;
                    }
                    c aY = aY(bundle12);
                    parcel2.writeNoException();
                    if (aY != null) {
                        iBinder = aY.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle11 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle11 = null;
                    }
                    boolean aZ = aZ(bundle11);
                    parcel2.writeNoException();
                    if (aZ) {
                        i12 = 1;
                    }
                    parcel2.writeInt(i12);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int aZX = aZX(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(aZX);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    favEditTag();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle10 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle10 = null;
                    }
                    boolean x = x(readInt2, bundle10);
                    parcel2.writeNoException();
                    if (x) {
                        i13 = 1;
                    }
                    parcel2.writeInt(i13);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean N = N(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (N) {
                        i14 = 1;
                    }
                    parcel2.writeInt(i14);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aZY(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean aZN = aZN();
                    parcel2.writeNoException();
                    if (aZN) {
                        i15 = 1;
                    }
                    parcel2.writeInt(i15);
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    List<String> aZM = aZM();
                    parcel2.writeNoException();
                    parcel2.writeStringList(aZM);
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    v(parcel.readInt(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString = parcel.readString();
                    boolean z4 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        bundle9 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle9 = null;
                    }
                    boolean a2 = a(readString, z4, bundle9);
                    parcel2.writeNoException();
                    if (a2) {
                        i16 = 1;
                    }
                    parcel2.writeInt(i16);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String aZR = aZR(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aZR);
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gt(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cP(readString2, z);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean gw = gw(parcel.readString());
                    parcel2.writeNoException();
                    if (gw) {
                        i17 = 1;
                    }
                    parcel2.writeInt(i17);
                    return true;
                case 30:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle8 = null;
                    }
                    Bundle w = w(readInt3, bundle8);
                    parcel2.writeNoException();
                    if (w != null) {
                        parcel2.writeInt(1);
                        w.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 31:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt4 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle7 = null;
                    }
                    Bundle u = u(readInt4, bundle7);
                    parcel2.writeNoException();
                    if (u != null) {
                        parcel2.writeInt(1);
                        u.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    l(readString3, z2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Bundle agv = agv(parcel.readInt());
                    parcel2.writeNoException();
                    if (agv != null) {
                        parcel2.writeInt(1);
                        agv.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean agw = agw(parcel.readInt());
                    parcel2.writeNoException();
                    if (agw) {
                        i18 = 1;
                    }
                    parcel2.writeInt(i18);
                    return true;
                case 35:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    agx(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    String readString6 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle5 = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle6 = null;
                    }
                    boolean a3 = a(readString4, readString5, readString6, bundle5, bundle6, parcel.readInt());
                    parcel2.writeNoException();
                    if (a3) {
                        i19 = 1;
                    }
                    parcel2.writeInt(i19);
                    return true;
                case 37:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    an(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString7 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle4 = null;
                    }
                    a(readString7, bundle4, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aZS(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String aZT = aZT(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aZT);
                    return true;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aL(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    a(f.a.I(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    agy(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String[] gdX = gdX();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(gdX);
                    return true;
                case 45:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String gdY = gdY();
                    parcel2.writeNoException();
                    parcel2.writeString(gdY);
                    return true;
                case 46:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String aZj = aZj(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aZj);
                    return true;
                case 47:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String gdZ = gdZ();
                    parcel2.writeNoException();
                    parcel2.writeString(gdZ);
                    return true;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String aZV = aZV(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aZV);
                    return true;
                case 49:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Map geb = geb();
                    parcel2.writeNoException();
                    parcel2.writeMap(geb);
                    return true;
                case 50:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String md = md(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(md);
                    return true;
                case 51:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aZW(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 52:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String gu = gu(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(gu);
                    return true;
                case 53:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String language = getLanguage();
                    parcel2.writeNoException();
                    parcel2.writeString(language);
                    return true;
                case 54:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String gea = gea();
                    parcel2.writeNoException();
                    parcel2.writeString(gea);
                    return true;
                case 55:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int gec = gec();
                    parcel2.writeNoException();
                    parcel2.writeInt(gec);
                    return true;
                case 56:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int ged = ged();
                    parcel2.writeNoException();
                    parcel2.writeInt(ged);
                    return true;
                case n.CTRL_INDEX:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gee();
                    parcel2.writeNoException();
                    return true;
                case 58:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gef();
                    parcel2.writeNoException();
                    return true;
                case bv.CTRL_INDEX:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    agz(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    agA(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt5 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    }
                    bs(readInt5, z3);
                    parcel2.writeNoException();
                    return true;
                case 62:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gv(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 63:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean geg = geg();
                    parcel2.writeNoException();
                    if (geg) {
                        i20 = 1;
                    }
                    parcel2.writeInt(i20);
                    return true;
                case 64:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String baa = baa(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(baa);
                    return true;
                case 65:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean gei = gei();
                    parcel2.writeNoException();
                    if (gei) {
                        i21 = 1;
                    }
                    parcel2.writeInt(i21);
                    return true;
                case 66:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean geh = geh();
                    parcel2.writeNoException();
                    if (geh) {
                        i22 = 1;
                    }
                    parcel2.writeInt(i22);
                    return true;
                case 67:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    boolean gek = gek();
                    parcel2.writeNoException();
                    if (gek) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 68:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    a(parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 69:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aZZ(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 70:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    String readString10 = parcel.readString();
                    int readInt6 = parcel.readInt();
                    int readInt7 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle14 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    a(readString8, readString9, readString10, readInt6, readInt7, bundle14);
                    parcel2.writeNoException();
                    return true;
                case 71:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt8 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle3 = null;
                    }
                    Bundle j2 = j(readInt8, bundle3);
                    parcel2.writeNoException();
                    if (j2 != null) {
                        parcel2.writeInt(1);
                        j2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 72:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    bm(intent);
                    parcel2.writeNoException();
                    return true;
                case d.CTRL_INDEX:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    U(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 74:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    List<String> gej = gej();
                    parcel2.writeNoException();
                    parcel2.writeStringList(gej);
                    return true;
                case 75:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    b(bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int payChannel = getPayChannel();
                    parcel2.writeNoException();
                    parcel2.writeInt(payChannel);
                    return true;
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    String[] gel = gel();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(gel);
                    return true;
                case h.a.CTRL_INDEX:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    int readInt9 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    v(readInt9, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.webview.stub.e$a$a  reason: collision with other inner class name */
        public static class C1972a implements e {
            public static e JdI;
            private IBinder mRemote;

            C1972a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean aZU(String str) {
                boolean z = true;
                AppMethodBeat.i(79429);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79429);
                    } else {
                        z = a.gem().aZU(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79429);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String getDisplayName(String str) {
                AppMethodBeat.i(79430);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().getDisplayName(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79430);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79430);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean IS(String str) {
                boolean z = false;
                AppMethodBeat.i(79431);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79431);
                    } else {
                        z = a.gem().IS(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79431);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean JE(String str) {
                boolean z = false;
                AppMethodBeat.i(79432);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79432);
                    } else {
                        z = a.gem().JE(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79432);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean IT(String str) {
                boolean z = false;
                AppMethodBeat.i(79433);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79433);
                    } else {
                        z = a.gem().IT(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79433);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String aZQ(String str) {
                AppMethodBeat.i(79434);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZQ(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79434);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79434);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean apn() {
                boolean z = false;
                AppMethodBeat.i(79435);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79435);
                    } else {
                        z = a.gem().apn();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79435);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean isSDCardAvailable() {
                boolean z = false;
                AppMethodBeat.i(79436);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79436);
                    } else {
                        z = a.gem().isSDCardAvailable();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79436);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean gdW() {
                boolean z = false;
                AppMethodBeat.i(79437);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79437);
                    } else {
                        z = a.gem().gdW();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79437);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean aUM() {
                boolean z = false;
                AppMethodBeat.i(79438);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79438);
                    } else {
                        z = a.gem().aUM();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79438);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final int kl(int i2, int i3) {
                AppMethodBeat.i(79439);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().kl(i2, i3);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79439);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79439);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void km(int i2, int i3) {
                AppMethodBeat.i(79440);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79440);
                        return;
                    }
                    a.gem().km(i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79440);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String cX(int i2, String str) {
                AppMethodBeat.i(79441);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().cX(i2, str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79441);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79441);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void a(int i2, Bundle bundle, int i3) {
                AppMethodBeat.i(79442);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79442);
                        return;
                    }
                    a.gem().a(i2, bundle, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79442);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final c aY(Bundle bundle) {
                AppMethodBeat.i(79443);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aY(bundle);
                    }
                    obtain2.readException();
                    c G = c.a.G(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79443);
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79443);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean aZ(Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(79444);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79444);
                    } else {
                        z = a.gem().aZ(bundle);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79444);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final int aZX(String str) {
                AppMethodBeat.i(79445);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZX(str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79445);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79445);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void favEditTag() {
                AppMethodBeat.i(79446);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(18, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79446);
                        return;
                    }
                    a.gem().favEditTag();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79446);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean x(int i2, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(79447);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(19, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79447);
                    } else {
                        z = a.gem().x(i2, bundle);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79447);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean N(long j2, String str) {
                boolean z = false;
                AppMethodBeat.i(79448);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    if (this.mRemote.transact(20, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79448);
                    } else {
                        z = a.gem().N(j2, str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79448);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void aZY(String str) {
                AppMethodBeat.i(79449);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(21, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79449);
                        return;
                    }
                    a.gem().aZY(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79449);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean aZN() {
                boolean z = false;
                AppMethodBeat.i(79450);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(22, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79450);
                    } else {
                        z = a.gem().aZN();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79450);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final List<String> aZM() {
                AppMethodBeat.i(79451);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZM();
                    }
                    obtain2.readException();
                    ArrayList<String> createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79451);
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79451);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void v(int i2, List<String> list) {
                AppMethodBeat.i(79452);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(24, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79452);
                        return;
                    }
                    a.gem().v(i2, list);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79452);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean a(String str, boolean z, Bundle bundle) {
                boolean z2 = true;
                AppMethodBeat.i(79453);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(25, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z2 = false;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79453);
                    } else {
                        z2 = a.gem().a(str, z, bundle);
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79453);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String aZR(String str) {
                AppMethodBeat.i(79454);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZR(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79454);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79454);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void gt(String str, int i2) {
                AppMethodBeat.i(79455);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(27, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79455);
                        return;
                    }
                    a.gem().gt(str, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79455);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void cP(String str, boolean z) {
                int i2 = 0;
                AppMethodBeat.i(79456);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(28, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79456);
                        return;
                    }
                    a.gem().cP(str, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79456);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean gw(String str) {
                boolean z = false;
                AppMethodBeat.i(79457);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(29, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79457);
                    } else {
                        z = a.gem().gw(str);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79457);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final Bundle w(int i2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(79458);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(30, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79458);
                    } else {
                        bundle2 = a.gem().w(i2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79458);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final Bundle u(int i2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(79459);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(31, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79459);
                    } else {
                        bundle2 = a.gem().u(i2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79459);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void l(String str, boolean z, int i2) {
                int i3 = 0;
                AppMethodBeat.i(79460);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(32, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79460);
                        return;
                    }
                    a.gem().l(str, z, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79460);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final Bundle agv(int i2) {
                Bundle bundle;
                AppMethodBeat.i(79461);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(33, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79461);
                    } else {
                        bundle = a.gem().agv(i2);
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79461);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean agw(int i2) {
                boolean z = false;
                AppMethodBeat.i(79462);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(34, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79462);
                    } else {
                        z = a.gem().agw(i2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79462);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void agx(int i2) {
                AppMethodBeat.i(79463);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(35, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79463);
                        return;
                    }
                    a.gem().agx(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79463);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i2) {
                boolean z;
                AppMethodBeat.i(79464);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(36, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        z = obtain2.readInt() != 0;
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79464);
                    } else {
                        z = a.gem().a(str, str2, str3, bundle, bundle2, i2);
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79464);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void an(String str, String str2, int i2) {
                AppMethodBeat.i(79465);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(37, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79465);
                        return;
                    }
                    a.gem().an(str, str2, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79465);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void a(String str, Bundle bundle, int i2) {
                AppMethodBeat.i(79466);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(38, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79466);
                        return;
                    }
                    a.gem().a(str, bundle, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79466);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void aZS(String str) {
                AppMethodBeat.i(79467);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(39, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79467);
                        return;
                    }
                    a.gem().aZS(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79467);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String aZT(String str) {
                AppMethodBeat.i(79468);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZT(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79468);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79468);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void aL(int i2, int i3, int i4) {
                AppMethodBeat.i(79469);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(41, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79469);
                        return;
                    }
                    a.gem().aL(i2, i3, i4);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79469);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void a(f fVar, int i2) {
                AppMethodBeat.i(79470);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(42, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79470);
                        return;
                    }
                    a.gem().a(fVar, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79470);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void agy(int i2) {
                AppMethodBeat.i(79471);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(43, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79471);
                        return;
                    }
                    a.gem().agy(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79471);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String[] gdX() {
                AppMethodBeat.i(79472);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gdX();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79472);
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79472);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String gdY() {
                AppMethodBeat.i(79473);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gdY();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79473);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79473);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String aZj(String str) {
                AppMethodBeat.i(79474);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(46, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZj(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79474);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79474);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String gdZ() {
                AppMethodBeat.i(79475);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(47, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gdZ();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79475);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79475);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String aZV(String str) {
                AppMethodBeat.i(79476);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(48, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().aZV(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79476);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79476);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final Map geb() {
                AppMethodBeat.i(79477);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(49, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().geb();
                    }
                    obtain2.readException();
                    HashMap readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79477);
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79477);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String md(String str, String str2) {
                AppMethodBeat.i(79478);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(50, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().md(str, str2);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79478);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79478);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void aZW(String str) {
                AppMethodBeat.i(79479);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(51, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79479);
                        return;
                    }
                    a.gem().aZW(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79479);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String gu(String str, int i2) {
                AppMethodBeat.i(79480);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(52, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gu(str, i2);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79480);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79480);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String getLanguage() {
                AppMethodBeat.i(79481);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(53, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().getLanguage();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79481);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79481);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String gea() {
                AppMethodBeat.i(79482);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(54, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gea();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79482);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79482);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final int gec() {
                AppMethodBeat.i(79483);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(55, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gec();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79483);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79483);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final int ged() {
                AppMethodBeat.i(79484);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(56, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().ged();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79484);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79484);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void gee() {
                AppMethodBeat.i(79485);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(57, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79485);
                        return;
                    }
                    a.gem().gee();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79485);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void gef() {
                AppMethodBeat.i(79486);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(58, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79486);
                        return;
                    }
                    a.gem().gef();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79486);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void agz(int i2) {
                AppMethodBeat.i(79487);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(59, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79487);
                        return;
                    }
                    a.gem().agz(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79487);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void agA(int i2) {
                AppMethodBeat.i(79488);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(60, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79488);
                        return;
                    }
                    a.gem().agA(i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79488);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void bs(int i2, boolean z) {
                int i3 = 0;
                AppMethodBeat.i(224510);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(61, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(224510);
                        return;
                    }
                    a.gem().bs(i2, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(224510);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void gv(String str, int i2) {
                AppMethodBeat.i(79490);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(62, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79490);
                        return;
                    }
                    a.gem().gv(str, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79490);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean geg() {
                boolean z = false;
                AppMethodBeat.i(79491);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(63, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79491);
                    } else {
                        z = a.gem().geg();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79491);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String baa(String str) {
                AppMethodBeat.i(79492);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(64, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().baa(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79492);
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79492);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean gei() {
                boolean z = false;
                AppMethodBeat.i(79493);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(65, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79493);
                    } else {
                        z = a.gem().gei();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79493);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean geh() {
                boolean z = false;
                AppMethodBeat.i(79494);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(66, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79494);
                    } else {
                        z = a.gem().geh();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79494);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final boolean gek() {
                boolean z = false;
                AppMethodBeat.i(79495);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (this.mRemote.transact(67, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79495);
                    } else {
                        z = a.gem().gek();
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79495);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void a(String str, int[] iArr, int i2, int i3) {
                AppMethodBeat.i(79496);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(68, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79496);
                        return;
                    }
                    a.gem().a(str, iArr, i2, i3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79496);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void aZZ(String str) {
                AppMethodBeat.i(79497);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (this.mRemote.transact(69, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79497);
                        return;
                    }
                    a.gem().aZZ(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79497);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void a(String str, String str2, String str3, int i2, int i3, Bundle bundle) {
                AppMethodBeat.i(79498);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(70, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79498);
                        return;
                    }
                    a.gem().a(str, str2, str3, i2, i3, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79498);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final Bundle j(int i2, Bundle bundle) {
                Bundle bundle2;
                AppMethodBeat.i(79499);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(71, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                        } else {
                            bundle2 = null;
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79499);
                    } else {
                        bundle2 = a.gem().j(i2, bundle);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79499);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void bm(Intent intent) {
                AppMethodBeat.i(79500);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(72, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79500);
                        return;
                    }
                    a.gem().bm(intent);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79500);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void U(int i2, String str, String str2) {
                AppMethodBeat.i(79501);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(73, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79501);
                        return;
                    }
                    a.gem().U(i2, str, str2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79501);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final List<String> gej() {
                AppMethodBeat.i(79502);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(74, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gej();
                    }
                    obtain2.readException();
                    ArrayList<String> createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79502);
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79502);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void b(Bundle bundle, int i2) {
                AppMethodBeat.i(79503);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(75, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79503);
                        return;
                    }
                    a.gem().b(bundle, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79503);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final int getPayChannel() {
                AppMethodBeat.i(79504);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(76, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().getPayChannel();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79504);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79504);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final String[] gel() {
                AppMethodBeat.i(79505);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (!this.mRemote.transact(77, obtain, obtain2, 0) && a.gem() != null) {
                        return a.gem().gel();
                    }
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79505);
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79505);
                }
            }

            @Override // com.tencent.mm.plugin.webview.stub.e
            public final void v(int i2, Bundle bundle) {
                AppMethodBeat.i(79506);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(78, obtain, obtain2, 0) || a.gem() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        AppMethodBeat.o(79506);
                        return;
                    }
                    a.gem().v(i2, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(79506);
                }
            }
        }

        public static e gem() {
            return C1972a.JdI;
        }
    }
}
