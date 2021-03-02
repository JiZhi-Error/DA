package com.tencent.mm.sdcard_migrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ExtStorageMigrateConfig implements Parcelable {
    public static final Parcelable.Creator<ExtStorageMigrateConfig> CREATOR = new Parcelable.Creator<ExtStorageMigrateConfig>() {
        /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExtStorageMigrateConfig[] newArray(int i2) {
            return new ExtStorageMigrateConfig[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExtStorageMigrateConfig createFromParcel(Parcel parcel) {
            AppMethodBeat.i(204580);
            ExtStorageMigrateConfig extStorageMigrateConfig = new ExtStorageMigrateConfig(parcel, (byte) 0);
            AppMethodBeat.o(204580);
            return extStorageMigrateConfig;
        }
    };
    public static final ExtStorageMigrateConfig NGK;
    public final String NGH;
    public boolean NGI;
    public final Set<ExtraPathAction> NGJ;
    public final String sourceDir;

    /* synthetic */ ExtStorageMigrateConfig(Parcel parcel, byte b2) {
        this(parcel);
    }

    /* synthetic */ ExtStorageMigrateConfig(String str, String str2, boolean z, Collection collection, byte b2) {
        this(str, str2, z, collection);
    }

    static {
        AppMethodBeat.i(204605);
        a aVar = new a(b.aKI(), b.aKF() + "/MicroMsg/");
        aVar.NGO.add(new ExtraPathAction.Ignore("wxajscahce/", (byte) 0));
        NGK = aVar.mL("wallet/images", "wallet_images").mL("WeChat/", b.aKU()).mL("WeiXin/", b.aKU()).mL("weixin/", b.aKU()).mL("wechat/", b.aKU()).gwJ();
        AppMethodBeat.o(204605);
    }

    public static class a {
        private final String NGL;
        private final String NGM;
        boolean NGN;
        final Set<ExtraPathAction> NGO;

        public a(String str, String str2) {
            AppMethodBeat.i(204581);
            this.NGL = str;
            this.NGM = str2;
            this.NGN = false;
            this.NGO = new HashSet();
            AppMethodBeat.o(204581);
        }

        public a(ExtStorageMigrateConfig extStorageMigrateConfig) {
            AppMethodBeat.i(204582);
            this.NGL = extStorageMigrateConfig.sourceDir;
            this.NGM = extStorageMigrateConfig.NGH;
            this.NGN = extStorageMigrateConfig.NGI;
            this.NGO = Collections.unmodifiableSet(new HashSet(extStorageMigrateConfig.NGJ));
            AppMethodBeat.o(204582);
        }

        public final a mL(String str, String str2) {
            AppMethodBeat.i(204583);
            this.NGO.add(new ExtraPathAction.Remap(str, str2, (byte) 0));
            AppMethodBeat.o(204583);
            return this;
        }

        public final ExtStorageMigrateConfig gwJ() {
            AppMethodBeat.i(204584);
            ExtStorageMigrateConfig extStorageMigrateConfig = new ExtStorageMigrateConfig(this.NGL, this.NGM, this.NGN, this.NGO, (byte) 0);
            AppMethodBeat.o(204584);
            return extStorageMigrateConfig;
        }
    }

    private ExtStorageMigrateConfig(String str, String str2, boolean z, Collection<ExtraPathAction> collection) {
        AppMethodBeat.i(204601);
        this.sourceDir = str;
        this.NGH = str2;
        this.NGI = z;
        this.NGJ = Collections.unmodifiableSet(new HashSet(collection));
        AppMethodBeat.o(204601);
    }

    private ExtStorageMigrateConfig(Parcel parcel) {
        AppMethodBeat.i(204602);
        this.sourceDir = parcel.readString();
        this.NGH = parcel.readString();
        this.NGI = parcel.readInt() != 0;
        HashSet hashSet = new HashSet();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashSet.add((ExtraPathAction) parcel.readParcelable(ExtStorageMigrateConfig.class.getClassLoader()));
        }
        this.NGJ = Collections.unmodifiableSet(hashSet);
        AppMethodBeat.o(204602);
    }

    public static abstract class ExtraPathAction implements Parcelable {
        public int describeContents() {
            return 0;
        }

        public static class Ignore extends ExtraPathAction {
            public static final Parcelable.Creator<Ignore> CREATOR = new Parcelable.Creator<Ignore>() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig.ExtraPathAction.Ignore.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Ignore[] newArray(int i2) {
                    return new Ignore[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Ignore createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(204585);
                    Ignore ignore = new Ignore(parcel, (byte) 0);
                    AppMethodBeat.o(204585);
                    return ignore;
                }
            };
            public final String NGP;

            /* synthetic */ Ignore(Parcel parcel, byte b2) {
                this(parcel);
            }

            /* synthetic */ Ignore(String str, byte b2) {
                this(str);
            }

            private Ignore(String str) {
                AppMethodBeat.i(204586);
                if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP) || str.startsWith("\\")) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str + " is not a relative path.");
                    AppMethodBeat.o(204586);
                    throw illegalArgumentException;
                }
                this.NGP = str;
                AppMethodBeat.o(204586);
            }

            private Ignore(Parcel parcel) {
                AppMethodBeat.i(204587);
                this.NGP = parcel.readString();
                AppMethodBeat.o(204587);
            }

            public boolean equals(Object obj) {
                AppMethodBeat.i(204588);
                if (!(obj instanceof Ignore)) {
                    AppMethodBeat.o(204588);
                    return false;
                }
                boolean equals = this.NGP.equals(((Ignore) obj).NGP);
                AppMethodBeat.o(204588);
                return equals;
            }

            public int hashCode() {
                AppMethodBeat.i(204589);
                int hashCode = this.NGP.hashCode();
                AppMethodBeat.o(204589);
                return hashCode;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(204590);
                parcel.writeString(this.NGP);
                AppMethodBeat.o(204590);
            }

            public String toString() {
                AppMethodBeat.i(204591);
                String str = "Ignore{relPath: " + this.NGP + "}";
                AppMethodBeat.o(204591);
                return str;
            }

            static {
                AppMethodBeat.i(204592);
                AppMethodBeat.o(204592);
            }
        }

        public static class Remap extends ExtraPathAction {
            public static final Parcelable.Creator<Remap> CREATOR = new Parcelable.Creator<Remap>() {
                /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateConfig.ExtraPathAction.Remap.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Remap[] newArray(int i2) {
                    return new Remap[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Remap createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(204593);
                    Remap remap = new Remap(parcel, (byte) 0);
                    AppMethodBeat.o(204593);
                    return remap;
                }
            };
            public final String NGQ;
            public final String jrL;

            /* synthetic */ Remap(Parcel parcel, byte b2) {
                this(parcel);
            }

            /* synthetic */ Remap(String str, String str2, byte b2) {
                this(str, str2);
            }

            private Remap(String str, String str2) {
                AppMethodBeat.i(204594);
                if (str.startsWith(FilePathGenerator.ANDROID_DIR_SEP) || str.startsWith("\\")) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str + " is not a relative path.");
                    AppMethodBeat.o(204594);
                    throw illegalArgumentException;
                }
                this.NGQ = str;
                this.jrL = str2;
                AppMethodBeat.o(204594);
            }

            private Remap(Parcel parcel) {
                AppMethodBeat.i(204595);
                this.NGQ = parcel.readString();
                this.jrL = parcel.readString();
                AppMethodBeat.o(204595);
            }

            public boolean equals(Object obj) {
                AppMethodBeat.i(204596);
                if (!(obj instanceof Remap)) {
                    AppMethodBeat.o(204596);
                    return false;
                } else if (!this.NGQ.equals(((Remap) obj).NGQ)) {
                    AppMethodBeat.o(204596);
                    return false;
                } else {
                    boolean equals = this.jrL.equals(((Remap) obj).jrL);
                    AppMethodBeat.o(204596);
                    return equals;
                }
            }

            public int hashCode() {
                AppMethodBeat.i(204597);
                int hashCode = this.NGQ.hashCode() + this.jrL.hashCode();
                AppMethodBeat.o(204597);
                return hashCode;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(204598);
                parcel.writeString(this.NGQ);
                parcel.writeString(this.jrL);
                AppMethodBeat.o(204598);
            }

            public String toString() {
                AppMethodBeat.i(204599);
                String str = "Remap{old: " + this.NGQ + ", new: " + this.jrL + "}";
                AppMethodBeat.o(204599);
                return str;
            }

            static {
                AppMethodBeat.i(204600);
                AppMethodBeat.o(204600);
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(204603);
        parcel.writeString(this.sourceDir);
        parcel.writeString(this.NGH);
        parcel.writeInt(this.NGI ? 1 : 0);
        parcel.writeInt(this.NGJ.size());
        for (ExtraPathAction extraPathAction : this.NGJ) {
            parcel.writeParcelable(extraPathAction, i2);
        }
        AppMethodBeat.o(204603);
    }

    public String toString() {
        AppMethodBeat.i(204604);
        StringBuilder sb = new StringBuilder();
        sb.append("ExtStorageMigrateConfig{source: ").append(this.sourceDir).append(",dest: ").append(this.NGH).append(",forceCopy: ").append(this.NGI).append(",extraActions: ").append(this.NGJ).append("}");
        String sb2 = sb.toString();
        AppMethodBeat.o(204604);
        return sb2;
    }
}
