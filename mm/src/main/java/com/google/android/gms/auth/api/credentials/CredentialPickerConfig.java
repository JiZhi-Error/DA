package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "CredentialPickerConfigCreator")
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "shouldShowCancelButton", id = 2)
    private final boolean mShowCancelButton;
    @SafeParcelable.Field(getter = "shouldShowAddAccountButton", id = 1)
    private final boolean zzcq;
    @SafeParcelable.Field(getter = "isForNewAccount", id = 3)
    @Deprecated
    private final boolean zzcr;
    @SafeParcelable.Field(getter = "getPromptInternalId", id = 4)
    private final int zzcs;
    @SafeParcelable.Field(id = 1000)
    private final int zzy;

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzcq = false;
        private int zzct = 1;

        public CredentialPickerConfig build() {
            AppMethodBeat.i(88210);
            CredentialPickerConfig credentialPickerConfig = new CredentialPickerConfig(this);
            AppMethodBeat.o(88210);
            return credentialPickerConfig;
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzct = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i2) {
            this.zzct = i2;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzcq = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    static {
        AppMethodBeat.i(88214);
        AppMethodBeat.o(88214);
    }

    @SafeParcelable.Constructor
    CredentialPickerConfig(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i3) {
        int i4 = 3;
        boolean z4 = true;
        AppMethodBeat.i(88211);
        this.zzy = i2;
        this.zzcq = z;
        this.mShowCancelButton = z2;
        if (i2 < 2) {
            this.zzcr = z3;
            this.zzcs = !z3 ? 1 : i4;
            AppMethodBeat.o(88211);
            return;
        }
        this.zzcr = i3 != 3 ? false : z4;
        this.zzcs = i3;
        AppMethodBeat.o(88211);
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzcq, builder.mShowCancelButton, false, builder.zzct);
        AppMethodBeat.i(88212);
        AppMethodBeat.o(88212);
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzcs == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzcq;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88213);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.zzcs);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88213);
    }
}
