package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        /* class com.google.android.exoplayer2.metadata.emsg.EventMessage.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EventMessage createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92389);
            EventMessage eventMessage = new EventMessage(parcel);
            AppMethodBeat.o(92389);
            return eventMessage;
        }
    };
    private int aHK;
    public final String buj;
    public final byte[] buk;
    public final long durationMs;
    public final long id;
    public final String value;

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.buj = str;
        this.value = str2;
        this.durationMs = j2;
        this.id = j3;
        this.buk = bArr;
    }

    EventMessage(Parcel parcel) {
        AppMethodBeat.i(92390);
        this.buj = parcel.readString();
        this.value = parcel.readString();
        this.durationMs = parcel.readLong();
        this.id = parcel.readLong();
        this.buk = parcel.createByteArray();
        AppMethodBeat.o(92390);
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(92391);
        if (this.aHK == 0) {
            int hashCode = ((this.buj != null ? this.buj.hashCode() : 0) + JsApiGetABTestConfig.CTRL_INDEX) * 31;
            if (this.value != null) {
                i2 = this.value.hashCode();
            }
            this.aHK = ((((((hashCode + i2) * 31) + ((int) (this.durationMs ^ (this.durationMs >>> 32)))) * 31) + ((int) (this.id ^ (this.id >>> 32)))) * 31) + Arrays.hashCode(this.buk);
        }
        int i3 = this.aHK;
        AppMethodBeat.o(92391);
        return i3;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92392);
        if (this == obj) {
            AppMethodBeat.o(92392);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92392);
            return false;
        } else {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.durationMs != eventMessage.durationMs || this.id != eventMessage.id || !x.j(this.buj, eventMessage.buj) || !x.j(this.value, eventMessage.value) || !Arrays.equals(this.buk, eventMessage.buk)) {
                AppMethodBeat.o(92392);
                return false;
            }
            AppMethodBeat.o(92392);
            return true;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92393);
        parcel.writeString(this.buj);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.buk);
        AppMethodBeat.o(92393);
    }

    static {
        AppMethodBeat.i(92394);
        AppMethodBeat.o(92394);
    }
}
