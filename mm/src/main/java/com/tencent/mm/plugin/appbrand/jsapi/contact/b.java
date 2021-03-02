package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.MenuItem;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.aa;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class b extends d {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(137492);
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiAddPhoneContact", "data is null");
            AppMethodBeat.o(137492);
        } else if (Util.isNullOrNil(jSONObject.optString("firstName"))) {
            fVar.i(i2, h("fail:firstName is null", null));
            Log.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
            AppMethodBeat.o(137492);
        } else {
            final Context context = fVar.getContext();
            if (context == null || !(context instanceof Activity)) {
                fVar.i(i2, h("fail", null));
                Log.e("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
                AppMethodBeat.o(137492);
                return;
            }
            final a aVar = new a();
            aVar.lRD = jSONObject.optString("photoFilePath");
            aVar.nickName = jSONObject.optString("nickName");
            aVar.lRC = new a.b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            aVar.remark = jSONObject.optString("remark");
            aVar.lRH = jSONObject.optString("mobilePhoneNumber");
            aVar.lRO = jSONObject.optString("weChatNumber");
            aVar.lRG = e(jSONObject, "address");
            aVar.lRL = jSONObject.optString("organization");
            aVar.title = jSONObject.optString("title");
            aVar.lRM = jSONObject.optString("workFaxNumber");
            aVar.lRK = jSONObject.optString("workPhoneNumber");
            aVar.lRJ = jSONObject.optString("hostNumber");
            aVar.fuD = jSONObject.optString(Scopes.EMAIL);
            aVar.url = jSONObject.optString("url");
            aVar.lRF = e(jSONObject, "workAddress");
            aVar.lRN = jSONObject.optString("homeFaxNumber");
            aVar.lRI = jSONObject.optString("homePhoneNumber");
            aVar.lRE = e(jSONObject, "homeAddress");
            fVar.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.contact.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(186004);
                    b bVar = b.this;
                    Activity activity = (Activity) context;
                    a aVar = aVar;
                    f fVar = fVar;
                    int i2 = i2;
                    String[] strArr = {activity.getString(R.string.etp), activity.getString(R.string.eto)};
                    e eVar = new e((Context) activity, 1, false);
                    eVar.HLX = new o.f(strArr) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.b.AnonymousClass2 */
                        final /* synthetic */ String[] lRU;

                        {
                            this.lRU = r2;
                        }

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(186005);
                            mVar.d(0, this.lRU[0]);
                            mVar.d(1, this.lRU[1]);
                            AppMethodBeat.o(186005);
                        }
                    };
                    eVar.HLY = new o.g(aVar, activity, fVar, i2) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.b.AnonymousClass3 */
                        final /* synthetic */ int cvP;
                        final /* synthetic */ f czN;
                        final /* synthetic */ a lRS;
                        final /* synthetic */ Activity val$activity;

                        {
                            this.lRS = r2;
                            this.val$activity = r3;
                            this.czN = r4;
                            this.cvP = r5;
                        }

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(186008);
                            switch (i2) {
                                case 0:
                                    Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
                                    b.a(intent, this.lRS, this.val$activity, this.czN);
                                    Activity activity = this.val$activity;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/contact/JsApiAddPhoneContact$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    activity.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/appbrand/jsapi/contact/JsApiAddPhoneContact$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    AnonymousClass1 r1 = new f.b() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.b.AnonymousClass3.AnonymousClass1 */

                                        @Override // com.tencent.luggage.h.f.b
                                        public final void a(int i2, Intent intent) {
                                            AppMethodBeat.i(186006);
                                            AnonymousClass3.this.czN.i(AnonymousClass3.this.cvP, b.this.h("ok", null));
                                            AppMethodBeat.o(186006);
                                        }
                                    };
                                    try {
                                        com.tencent.luggage.h.f.aK(this.val$activity).b(intent, r1);
                                        AppMethodBeat.o(186008);
                                        return;
                                    } catch (RemoteException e2) {
                                        Log.e("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case0, get RemoteException[%s] retry", e2);
                                        b.D(intent);
                                        com.tencent.luggage.h.f.aK(this.val$activity).a(intent, r1);
                                        AppMethodBeat.o(186008);
                                        return;
                                    }
                                case 1:
                                    Intent intent2 = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
                                    intent2.setType("vnd.android.cursor.item/person");
                                    b.a(intent2, this.lRS, this.val$activity, this.czN);
                                    AnonymousClass2 r2 = new f.b() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.b.AnonymousClass3.AnonymousClass2 */

                                        @Override // com.tencent.luggage.h.f.b
                                        public final void a(int i2, Intent intent) {
                                            AppMethodBeat.i(186007);
                                            AnonymousClass3.this.czN.i(AnonymousClass3.this.cvP, b.this.h("ok", null));
                                            AppMethodBeat.o(186007);
                                        }
                                    };
                                    try {
                                        com.tencent.luggage.h.f.aK(this.val$activity).b(intent2, r2);
                                        AppMethodBeat.o(186008);
                                        return;
                                    } catch (RemoteException e3) {
                                        Log.e("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case1, get RemoteException[%s] retry", e3);
                                        com.tencent.luggage.h.f.aK(this.val$activity).a(intent2, r2);
                                        break;
                                    }
                            }
                            AppMethodBeat.o(186008);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(186004);
                }
            });
            AppMethodBeat.o(137492);
        }
    }

    private static a.C0656a e(JSONObject jSONObject, String str) {
        AppMethodBeat.i(137493);
        a.C0656a aVar = new a.C0656a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
        AppMethodBeat.o(137493);
        return aVar;
    }

    private static Bitmap S(Bitmap bitmap) {
        Bitmap createScaledBitmap;
        AppMethodBeat.i(176172);
        if (bitmap.getByteCount() <= 819200) {
            AppMethodBeat.o(176172);
            return bitmap;
        }
        while (true) {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
            try {
                bitmap.recycle();
            } catch (Throwable th) {
            }
            if (createScaledBitmap == null || createScaledBitmap.getByteCount() <= 819200) {
                AppMethodBeat.o(176172);
            } else {
                bitmap = createScaledBitmap;
            }
        }
        AppMethodBeat.o(176172);
        return createScaledBitmap;
    }

    private static void a(ArrayList<ContentValues> arrayList, a.C0656a aVar, int i2) {
        AppMethodBeat.i(137494);
        if (aVar != null && aVar.bGg().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", aVar.bGg());
            contentValues.put("data9", aVar.lRQ);
            contentValues.put("data2", Integer.valueOf(i2));
            arrayList.add(contentValues);
        }
        AppMethodBeat.o(137494);
    }

    private static void a(ArrayList<ContentValues> arrayList, String str, int i2) {
        AppMethodBeat.i(137495);
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i2));
        arrayList.add(contentValues);
        AppMethodBeat.o(137495);
    }

    static /* synthetic */ void a(Intent intent, a aVar, Activity activity, com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        Bitmap S;
        AppMethodBeat.i(186009);
        intent.setFlags(268435456);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        a.b bVar = aVar.lRC;
        StringBuilder sb = new StringBuilder();
        if (Util.isChinese(bVar.firstName) || Util.isChinese(bVar.middleName) || Util.isChinese(bVar.lastName)) {
            if (bVar.lastName.trim().length() > 0) {
                sb.append(bVar.lastName);
            }
            if (bVar.middleName.trim().length() > 0) {
                sb.append(bVar.middleName);
            }
            if (bVar.firstName.trim().length() > 0) {
                sb.append(bVar.firstName);
            }
        } else {
            if (bVar.firstName.trim().length() > 0) {
                sb.append(bVar.firstName);
            }
            if (bVar.middleName.trim().length() > 0) {
                sb.append(" ");
                sb.append(bVar.middleName);
            }
            if (bVar.lastName.trim().length() > 0) {
                sb.append(" ");
                sb.append(bVar.lastName);
            }
        }
        String sb2 = sb.toString();
        if (!Util.isNullOrNil(sb2)) {
            intent.putExtra("name", sb2);
        } else {
            Log.e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        }
        if (!Util.isNullOrNil(aVar.nickName)) {
            String str = aVar.nickName;
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", str);
            contentValues.put("data2", (Integer) 1);
            arrayList.add(contentValues);
        }
        if (!Util.isNullOrNil(aVar.remark)) {
            String str2 = aVar.remark;
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/note");
            contentValues2.put("data1", str2);
            arrayList.add(contentValues2);
        }
        if (!Util.isNullOrNil(aVar.lRL) || !Util.isNullOrNil(aVar.title)) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/organization");
            if (!Util.isNullOrNil(aVar.lRL)) {
                contentValues3.put("data1", aVar.lRL);
            }
            if (!Util.isNullOrNil(aVar.title)) {
                contentValues3.put("data4", aVar.title);
            }
            contentValues3.put("data2", (Integer) 1);
            arrayList.add(contentValues3);
        }
        if (!Util.isNullOrNil(aVar.url)) {
            String str3 = aVar.url;
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/website");
            contentValues4.put("data1", str3);
            contentValues4.put("data2", (Integer) 1);
            arrayList.add(contentValues4);
        }
        if (!Util.isNullOrNil(aVar.fuD)) {
            intent.putExtra(Scopes.EMAIL, aVar.fuD);
        }
        if (!Util.isNullOrNil(aVar.lRH)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRH, 2);
        }
        if (!Util.isNullOrNil(aVar.lRI)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRI, 1);
        }
        if (!Util.isNullOrNil(aVar.lRK)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRK, 3);
        }
        if (!Util.isNullOrNil(aVar.lRJ)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRJ, 10);
        }
        if (!Util.isNullOrNil(aVar.lRN)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRN, 5);
        }
        if (!Util.isNullOrNil(aVar.lRM)) {
            a((ArrayList<ContentValues>) arrayList, aVar.lRM, 4);
        }
        a((ArrayList<ContentValues>) arrayList, aVar.lRG, 3);
        a((ArrayList<ContentValues>) arrayList, aVar.lRF, 2);
        a((ArrayList<ContentValues>) arrayList, aVar.lRE, 1);
        if (!Util.isNullOrNil(aVar.lRO)) {
            String str4 = aVar.lRO;
            String string = activity.getString(R.string.wx);
            ContentValues contentValues5 = new ContentValues();
            contentValues5.put("mimetype", "vnd.android.cursor.item/im");
            contentValues5.put("data1", str4);
            contentValues5.put("data5", (Integer) -1);
            contentValues5.put("data6", string);
            arrayList.add(contentValues5);
        }
        com.tencent.mm.vfs.o VY = fVar.getFileSystem().VY(aVar.lRD);
        if (VY != null && VY.exists()) {
            try {
                Bitmap decodeFile = MMBitmapFactory.decodeFile(aa.z(VY.her()));
                if (!(decodeFile == null || (S = S(decodeFile)) == null)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    S.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ContentValues contentValues6 = new ContentValues();
                    contentValues6.put("mimetype", "vnd.android.cursor.item/photo");
                    contentValues6.put("data15", byteArray);
                    arrayList.add(contentValues6);
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", th, "processContactIntent, close avatar stream", new Object[0]);
                    }
                    try {
                        S.recycle();
                    } catch (Throwable th2) {
                    }
                }
            } catch (OutOfMemoryError e2) {
                Log.e("MicroMsg.JsApiAddPhoneContact", "processContactIntent, put avatar bitmap oom, file=%s", VY);
            }
        }
        intent.putParcelableArrayListExtra("data", arrayList);
        AppMethodBeat.o(186009);
    }

    static /* synthetic */ void D(Intent intent) {
        ContentValues contentValues;
        AppMethodBeat.i(186010);
        try {
            ArrayList<? extends Parcelable> parcelableArrayListExtra = intent.getParcelableArrayListExtra("data");
            Iterator<? extends Parcelable> it = parcelableArrayListExtra.iterator();
            while (true) {
                if (!it.hasNext()) {
                    contentValues = null;
                    break;
                }
                contentValues = (ContentValues) it.next();
                if (contentValues.containsKey("data15")) {
                    break;
                }
            }
            if (contentValues != null) {
                parcelableArrayListExtra.remove(contentValues);
            }
            intent.putParcelableArrayListExtra("data", parcelableArrayListExtra);
            AppMethodBeat.o(186010);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.JsApiAddPhoneContact", th, "removeContactAvatarDataFromIntent", new Object[0]);
            AppMethodBeat.o(186010);
        }
    }
}
