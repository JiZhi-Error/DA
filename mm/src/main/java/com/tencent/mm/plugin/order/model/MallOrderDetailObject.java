package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MallOrderDetailObject {
    public MallTransactionObject ANI;
    public b ANJ;
    public ArrayList<ProductSectionItem> ANK;
    public List<a> ANL;
    public List<HelpCenter> ANM = new LinkedList();
    int ANN = -1;
    public String ANO;
    public String ANP;
    public int ANQ;
    public String appUserName;
    public String rJd;

    public static class a {
        public int jumpType;
        public String jumpUrl;
        public String name;
        public boolean pSj;
        public int type = 0;
        public String value;
    }

    public static class b {
        public String ANR;
        public String ANS;
        public int hXs;
        public String thumbUrl;
        public String xIy;
    }

    public MallOrderDetailObject() {
        AppMethodBeat.i(66651);
        AppMethodBeat.o(66651);
    }

    public static class HelpCenter implements Parcelable {
        public static final Parcelable.Creator<HelpCenter> CREATOR = new Parcelable.Creator<HelpCenter>() {
            /* class com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ HelpCenter[] newArray(int i2) {
                return new HelpCenter[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ HelpCenter createFromParcel(Parcel parcel) {
                AppMethodBeat.i(66647);
                HelpCenter helpCenter = new HelpCenter(parcel);
                AppMethodBeat.o(66647);
                return helpCenter;
            }
        };
        public boolean dEF;
        public String name;
        public String url;

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            AppMethodBeat.i(66648);
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.dEF = parcel.readByte() != 0;
            AppMethodBeat.o(66648);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(66649);
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.dEF ? 1 : 0));
            AppMethodBeat.o(66649);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(66650);
            AppMethodBeat.o(66650);
        }
    }

    static ArrayList<ProductSectionItem> bf(JSONObject jSONObject) {
        AppMethodBeat.i(66652);
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            AppMethodBeat.o(66652);
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(66652);
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.APw = bg(jSONObject3);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e3, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.price = jSONObject3.optString(FirebaseAnalytics.b.PRICE);
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.APx = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        AppMethodBeat.o(66652);
        return arrayList;
    }

    private static List<ProductSectionItem.Skus> bg(JSONObject jSONObject) {
        AppMethodBeat.i(66653);
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(66653);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            ProductSectionItem.Skus skus = new ProductSectionItem.Skus();
            skus.key = jSONObject2.optString("key");
            skus.value = jSONObject2.optString("value");
            arrayList.add(skus);
        }
        AppMethodBeat.o(66653);
        return arrayList;
    }
}
