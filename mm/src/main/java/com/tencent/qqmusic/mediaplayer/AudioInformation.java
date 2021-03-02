package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;

public class AudioInformation implements Parcelable {
    public static final int CBR = 1;
    public static final int CORRECT = 1;
    public static final Parcelable.Creator<AudioInformation> CREATOR = new Parcelable.Creator<AudioInformation>() {
        /* class com.tencent.qqmusic.mediaplayer.AudioInformation.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final AudioInformation createFromParcel(Parcel parcel) {
            AppMethodBeat.i(87752);
            AudioInformation audioInformation = new AudioInformation(parcel);
            AppMethodBeat.o(87752);
            return audioInformation;
        }

        @Override // android.os.Parcelable.Creator
        public final AudioInformation[] newArray(int i2) {
            return new AudioInformation[i2];
        }
    };
    public static final int INCORRECT = 2;
    public static final int VBR_VBRI = 3;
    public static final int VBR_XING = 2;
    private int bitDept = 0;
    private int bitrate;
    private int channels;
    private long duration = 0;
    private int durationIsCorrect = 2;
    private int isCbr = 0;
    private int mAudioTypeValue;
    private long mPlaySample = 0;
    private long sampleRate;

    static {
        AppMethodBeat.i(87764);
        AppMethodBeat.o(87764);
    }

    public AudioInformation() {
    }

    public AudioInformation(Parcel parcel) {
        AppMethodBeat.i(87758);
        readFromParcel(parcel);
        AppMethodBeat.o(87758);
    }

    public long getPlaySample() {
        if (this.mPlaySample == 0) {
            this.mPlaySample = this.sampleRate;
        }
        return this.mPlaySample;
    }

    public void setPlaySample(long j2) {
        this.mPlaySample = j2;
    }

    public boolean durationIsCorrect() {
        return this.durationIsCorrect == 1;
    }

    public boolean isCbr() {
        return this.isCbr == 1;
    }

    public void setCbr(int i2) {
        this.isCbr = i2;
    }

    public boolean isVbr() {
        return this.isCbr == 2 || this.isCbr == 3;
    }

    public int getVbrType() {
        return this.isCbr;
    }

    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(87759);
        AudioFormat.AudioType audioType = AudioFormat.getAudioType(this.mAudioTypeValue);
        AppMethodBeat.o(87759);
        return audioType;
    }

    public void setAudioType(AudioFormat.AudioType audioType) {
        AppMethodBeat.i(87760);
        this.mAudioTypeValue = audioType.getValue();
        AppMethodBeat.o(87760);
    }

    public int getBitDepth() {
        return this.bitDept;
    }

    public void setBitDept(int i2) {
        this.bitDept = i2;
        if (i2 >= 3) {
            this.bitDept = 3;
        }
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(long j2) {
        this.sampleRate = j2;
    }

    public int getChannels() {
        return this.channels;
    }

    public void setChannels(int i2) {
        this.channels = i2;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(87761);
        parcel.writeLong(this.sampleRate);
        parcel.writeInt(this.channels);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.bitDept);
        parcel.writeInt(this.mAudioTypeValue);
        parcel.writeLong(this.mPlaySample);
        parcel.writeInt(this.isCbr);
        parcel.writeInt(this.durationIsCorrect);
        AppMethodBeat.o(87761);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(87762);
        this.sampleRate = parcel.readLong();
        this.channels = parcel.readInt();
        this.duration = parcel.readLong();
        this.bitrate = parcel.readInt();
        this.bitDept = parcel.readInt();
        this.mAudioTypeValue = parcel.readInt();
        this.mPlaySample = parcel.readLong();
        this.isCbr = parcel.readInt();
        this.durationIsCorrect = parcel.readInt();
        AppMethodBeat.o(87762);
    }

    public String toString() {
        AppMethodBeat.i(87763);
        String str = "[ sampleRate = " + this.sampleRate + ",channels = " + this.channels + ",bitrate = " + this.bitrate + ",bitDept = " + this.bitDept + ",isCbr = " + this.isCbr + ",durationIsCorrect = " + this.durationIsCorrect + ",duration = " + this.duration + "]";
        AppMethodBeat.o(87763);
        return str;
    }
}
