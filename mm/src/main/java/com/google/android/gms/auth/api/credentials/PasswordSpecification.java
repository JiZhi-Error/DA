package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

@SafeParcelable.Class(creator = "PasswordSpecificationCreator")
@SafeParcelable.Reserved({1000})
public final class PasswordSpecification extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PasswordSpecification> CREATOR = new zzm();
    public static final PasswordSpecification zzdg = new zzd().zzd(12, 16).zze("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzd("abcdefghijkmnopqrstxyz", 1).zzd("ABCDEFGHJKLMNPQRSTXY", 1).zzd("3456789", 1).zzj();
    private static final PasswordSpecification zzdh = new zzd().zzd(12, 16).zze("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzd("abcdefghijklmnopqrstuvwxyz", 1).zzd("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzd("1234567890", 1).zzj();
    @SafeParcelable.Field(id = 1)
    private final String zzdi;
    @SafeParcelable.Field(id = 2)
    private final List<String> zzdj;
    @SafeParcelable.Field(id = 3)
    private final List<Integer> zzdk;
    @SafeParcelable.Field(id = 4)
    private final int zzdl;
    @SafeParcelable.Field(id = 5)
    private final int zzdm;
    private final int[] zzdn;
    private final Random zzdo;

    public static class zzd {
        private final List<String> zzdj = new ArrayList();
        private final List<Integer> zzdk = new ArrayList();
        private int zzdl = 12;
        private int zzdm = 16;
        private final TreeSet<Character> zzdp = new TreeSet<>();

        public zzd() {
            AppMethodBeat.i(88250);
            AppMethodBeat.o(88250);
        }

        private static TreeSet<Character> zzd(String str, String str2) {
            AppMethodBeat.i(88254);
            if (TextUtils.isEmpty(str)) {
                zze zze = new zze(String.valueOf(str2).concat(" cannot be null or empty"));
                AppMethodBeat.o(88254);
                throw zze;
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            char[] charArray = str.toCharArray();
            for (char c2 : charArray) {
                if (PasswordSpecification.zze(c2, 32, 126)) {
                    zze zze2 = new zze(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                    AppMethodBeat.o(88254);
                    throw zze2;
                }
                treeSet.add(Character.valueOf(c2));
            }
            AppMethodBeat.o(88254);
            return treeSet;
        }

        public final zzd zzd(int i2, int i3) {
            this.zzdl = 12;
            this.zzdm = 16;
            return this;
        }

        public final zzd zzd(String str, int i2) {
            AppMethodBeat.i(88252);
            this.zzdj.add(PasswordSpecification.zze(zzd(str, "requiredChars")));
            this.zzdk.add(1);
            AppMethodBeat.o(88252);
            return this;
        }

        public final zzd zze(String str) {
            AppMethodBeat.i(88251);
            this.zzdp.addAll(zzd(str, "allowedChars"));
            AppMethodBeat.o(88251);
            return this;
        }

        public final PasswordSpecification zzj() {
            AppMethodBeat.i(88253);
            if (this.zzdp.isEmpty()) {
                zze zze = new zze("no allowed characters specified");
                AppMethodBeat.o(88253);
                throw zze;
            }
            int i2 = 0;
            for (Integer num : this.zzdk) {
                i2 = num.intValue() + i2;
            }
            if (i2 > this.zzdm) {
                zze zze2 = new zze("required character count cannot be greater than the max password size");
                AppMethodBeat.o(88253);
                throw zze2;
            }
            boolean[] zArr = new boolean[95];
            for (String str : this.zzdj) {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char c2 = charArray[i3];
                        if (zArr[c2 - ' ']) {
                            zze zze3 = new zze(new StringBuilder(58).append("character ").append(c2).append(" occurs in more than one required character set").toString());
                            AppMethodBeat.o(88253);
                            throw zze3;
                        }
                        zArr[c2 - ' '] = true;
                        i3++;
                    }
                }
            }
            PasswordSpecification passwordSpecification = new PasswordSpecification(PasswordSpecification.zze(this.zzdp), this.zzdj, this.zzdk, this.zzdl, this.zzdm);
            AppMethodBeat.o(88253);
            return passwordSpecification;
        }
    }

    public static class zze extends Error {
        public zze(String str) {
            super(str);
        }
    }

    static {
        AppMethodBeat.i(88260);
        AppMethodBeat.o(88260);
    }

    @SafeParcelable.Constructor
    PasswordSpecification(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) List<String> list, @SafeParcelable.Param(id = 3) List<Integer> list2, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) int i3) {
        AppMethodBeat.i(88255);
        this.zzdi = str;
        this.zzdj = Collections.unmodifiableList(list);
        this.zzdk = Collections.unmodifiableList(list2);
        this.zzdl = i2;
        this.zzdm = i3;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i4 = 0;
        for (String str2 : this.zzdj) {
            char[] charArray = str2.toCharArray();
            int length = charArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                iArr[charArray[i5] - ' '] = i4;
            }
            i4++;
        }
        this.zzdn = iArr;
        this.zzdo = new SecureRandom();
        AppMethodBeat.o(88255);
    }

    private static String zzd(Collection<Character> collection) {
        AppMethodBeat.i(88257);
        char[] cArr = new char[collection.size()];
        int i2 = 0;
        for (Character ch : collection) {
            i2++;
            cArr[i2] = ch.charValue();
        }
        String str = new String(cArr);
        AppMethodBeat.o(88257);
        return str;
    }

    private static boolean zzd(int i2, int i3, int i4) {
        return i2 < 32 || i2 > 126;
    }

    static /* synthetic */ String zze(Collection collection) {
        AppMethodBeat.i(88258);
        String zzd2 = zzd(collection);
        AppMethodBeat.o(88258);
        return zzd2;
    }

    static /* synthetic */ boolean zze(int i2, int i3, int i4) {
        AppMethodBeat.i(88259);
        boolean zzd2 = zzd(i2, 32, 126);
        AppMethodBeat.o(88259);
        return zzd2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88256);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdi, false);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzdj, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.zzdk, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdl);
        SafeParcelWriter.writeInt(parcel, 5, this.zzdm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88256);
    }
}
