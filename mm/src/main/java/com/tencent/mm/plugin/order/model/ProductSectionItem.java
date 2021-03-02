package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Parcelable.Creator<ProductSectionItem> CREATER = new Parcelable.Creator<ProductSectionItem>() {
        /* class com.tencent.mm.plugin.order.model.ProductSectionItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ProductSectionItem[] newArray(int i2) {
            return new ProductSectionItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ProductSectionItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(66691);
            ProductSectionItem productSectionItem = new ProductSectionItem(parcel);
            AppMethodBeat.o(66691);
            return productSectionItem;
        }
    };
    public List<Skus> APw;
    public String APx;
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public String price;
    public int scene;

    public ProductSectionItem() {
    }

    public ProductSectionItem(Parcel parcel) {
        AppMethodBeat.i(66697);
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.APw = new ArrayList();
            for (int i2 = 0; i2 < readInt; i2++) {
                Skus skus = new Skus();
                skus.key = parcel.readString();
                skus.value = parcel.readString();
                this.APw.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.price = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.APx = parcel.readString();
        this.scene = parcel.readInt();
        AppMethodBeat.o(66697);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(66698);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.APw != null) {
            parcel.writeInt(this.APw.size());
            for (int i3 = 0; i3 < this.APw.size(); i3++) {
                Skus skus = this.APw.get(i3);
                parcel.writeString(skus.key);
                parcel.writeString(skus.value);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.price);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.APx);
        parcel.writeInt(this.scene);
        AppMethodBeat.o(66698);
    }

    static {
        AppMethodBeat.i(66699);
        AppMethodBeat.o(66699);
    }

    public static class Skus implements Parcelable {
        public static final Parcelable.Creator<Skus> CREATER = new Parcelable.Creator<Skus>() {
            /* class com.tencent.mm.plugin.order.model.ProductSectionItem.Skus.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Skus[] newArray(int i2) {
                return new Skus[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Skus createFromParcel(Parcel parcel) {
                AppMethodBeat.i(66692);
                Skus skus = new Skus(parcel);
                AppMethodBeat.o(66692);
                return skus;
            }
        };
        public String key;
        public String value;

        public Skus() {
        }

        public Skus(Parcel parcel) {
            AppMethodBeat.i(66693);
            this.key = parcel.readString();
            this.value = parcel.readString();
            AppMethodBeat.o(66693);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(66694);
            parcel.writeString(this.key);
            parcel.writeString(this.value);
            AppMethodBeat.o(66694);
        }

        static {
            AppMethodBeat.i(66696);
            AppMethodBeat.o(66696);
        }

        public static String fJ(List<Skus> list) {
            AppMethodBeat.i(66695);
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(66695);
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Skus skus = list.get(i2);
                if (i2 != 0) {
                    sb.append("、");
                }
                sb.append(skus.value);
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(66695);
            return sb2;
        }
    }
}
