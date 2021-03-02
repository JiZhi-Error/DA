package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ugc.TXRecordCommon;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WaveWriter {
    private static final int OUTPUT_STREAM_BUFFER = 16384;
    private static final String TAG = "WaveWriter";
    private int mBytesWritten = 0;
    private int mChannels;
    private File mOutFile;
    private BufferedOutputStream mOutStream;
    private int mSampleBits;
    private int mSampleRate;
    private ByteArrayOutputStream mTmpStream;

    public WaveWriter(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(76421);
        this.mOutFile = new File(str + File.separator + str2);
        this.mSampleRate = i2;
        this.mChannels = i3;
        this.mSampleBits = i4;
        AppMethodBeat.o(76421);
    }

    public WaveWriter(File file, int i2, int i3, int i4) {
        this.mOutFile = file;
        this.mSampleRate = i2;
        this.mChannels = i3;
        this.mSampleBits = i4;
    }

    private static void writeUnsignedShortLE(ByteArrayOutputStream byteArrayOutputStream, short s) {
        AppMethodBeat.i(76422);
        byteArrayOutputStream.write(s);
        byteArrayOutputStream.write(s >> 8);
        AppMethodBeat.o(76422);
    }

    public void setSampleByte(int i2) {
        this.mSampleBits = i2;
    }

    public boolean createWaveFile() {
        AppMethodBeat.i(76423);
        if (this.mOutFile.exists()) {
            this.mOutFile.delete();
        }
        this.mOutFile.getParentFile().mkdirs();
        if (this.mOutFile.createNewFile()) {
            this.mOutStream = new BufferedOutputStream(new FileOutputStream(this.mOutFile), 16384);
            this.mTmpStream = new ByteArrayOutputStream();
            this.mOutStream.write(new byte[44]);
            AppMethodBeat.o(76423);
            return true;
        }
        AppMethodBeat.o(76423);
        return false;
    }

    public void write(short[] sArr, int i2, int i3) {
        AppMethodBeat.i(76424);
        if (i2 > i3) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            AppMethodBeat.o(76424);
            throw indexOutOfBoundsException;
        }
        while (i2 < i3) {
            writeUnsignedShortLE(this.mTmpStream, sArr[i2]);
            this.mBytesWritten += 2;
            i2++;
        }
        AppMethodBeat.o(76424);
    }

    public void write(short[] sArr, short[] sArr2, int i2, int i3) {
        AppMethodBeat.i(76425);
        if (this.mChannels != 2) {
            AppMethodBeat.o(76425);
        } else if (i2 > i3) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            AppMethodBeat.o(76425);
            throw indexOutOfBoundsException;
        } else {
            while (i2 < i3) {
                writeUnsignedShortLE(this.mTmpStream, sArr[i2]);
                writeUnsignedShortLE(this.mTmpStream, sArr2[i2]);
                this.mBytesWritten += 4;
                i2++;
            }
            AppMethodBeat.o(76425);
        }
    }

    public void closeWaveFile() {
        AppMethodBeat.i(76426);
        if (this.mOutStream != null) {
            this.mOutStream.flush();
            this.mOutStream.close();
        }
        if (this.mTmpStream != null) {
            this.mTmpStream.flush();
            this.mTmpStream.close();
        }
        writeWaveHeader();
        AppMethodBeat.o(76426);
    }

    private void writeWaveHeader() {
        AppMethodBeat.i(76427);
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mOutFile, "rw");
        randomAccessFile.seek(0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i2 = (this.mSampleBits + 7) / 8;
        try {
            dataOutputStream.writeBytes("RIFF");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten + 36));
            dataOutputStream.writeBytes("WAVE");
            dataOutputStream.writeBytes("fmt ");
            dataOutputStream.writeInt(Integer.reverseBytes(16));
            dataOutputStream.writeShort(Short.reverseBytes(1));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mChannels));
            dataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate));
            dataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate * this.mChannels * i2));
            dataOutputStream.writeShort(Short.reverseBytes((short) (i2 * this.mChannels)));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mSampleBits));
            dataOutputStream.writeBytes("data");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten));
            byteArrayOutputStream.flush();
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
        } finally {
            byteArrayOutputStream.close();
            dataOutputStream.close();
            randomAccessFile.close();
            AppMethodBeat.o(76427);
        }
    }

    public int getChannels() {
        return this.mChannels;
    }

    public byte[] changeStereoToMono(byte[] bArr) {
        if (this.mChannels != 2) {
            return bArr;
        }
        int i2 = this.mSampleBits / 8;
        long length = (long) ((bArr.length / this.mChannels) / i2);
        byte[] bArr2 = new byte[((int) (((long) i2) * length))];
        for (int i3 = 0; ((long) i3) < length; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[(i3 * i2) + i4] = (byte) ((bArr[((this.mChannels * i3) * i2) + i4] + bArr[(((this.mChannels * i3) + 1) * i2) + i4]) / 2);
            }
        }
        this.mChannels = 1;
        return bArr2;
    }

    public void writeDone() {
        AppMethodBeat.i(76428);
        try {
            this.mOutStream.write(this.mTmpStream.toByteArray());
            AppMethodBeat.o(76428);
        } catch (IOException e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(76428);
        }
    }

    public boolean reSampler() {
        AppMethodBeat.i(76429);
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, TXRecordCommon.AUDIO_SAMPLERATE_8000);
            if (reSample == null) {
                AppMethodBeat.o(76429);
                return false;
            }
            Logger.d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            byte[] changeStereoToMono = changeStereoToMono(reSample);
            Logger.d(TAG, "monoData length = " + changeStereoToMono.length);
            byte[] reSample2 = reSample(changeStereoToMono, this.mSampleBits, TXRecordCommon.AUDIO_SAMPLERATE_8000, 4000);
            if (reSample2 == null) {
                AppMethodBeat.o(76429);
                return false;
            }
            Logger.d(TAG, "resultData length = " + reSample2.length);
            this.mBytesWritten = reSample2.length;
            this.mOutStream.write(reSample2);
            AppMethodBeat.o(76429);
            return true;
        } catch (Throwable th) {
            Logger.e(TAG, th);
            AppMethodBeat.o(76429);
            return false;
        }
    }

    public boolean reSamplerTo8K() {
        AppMethodBeat.i(76430);
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, TXRecordCommon.AUDIO_SAMPLERATE_8000);
            if (reSample == null) {
                AppMethodBeat.o(76430);
                return false;
            }
            Logger.d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            byte[] changeStereoToMono = changeStereoToMono(reSample);
            Logger.d(TAG, "resultData length = " + changeStereoToMono.length);
            this.mBytesWritten = changeStereoToMono.length;
            this.mOutStream.write(changeStereoToMono);
            AppMethodBeat.o(76430);
            return true;
        } catch (Throwable th) {
            Logger.e(TAG, th);
            AppMethodBeat.o(76430);
            return false;
        }
    }

    private byte[] reSample(byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2;
        int i5 = 0;
        AppMethodBeat.i(76431);
        int i6 = i2 / 8;
        if (i6 <= 0) {
            AppMethodBeat.o(76431);
            return null;
        }
        int length = bArr.length / i6;
        short[] sArr = new short[length];
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = 0;
            short s = 0;
            while (i9 < i6) {
                s = (short) (s | ((short) ((bArr[i7] & 255) << (i9 * 8))));
                i9++;
                i7++;
            }
            sArr[i8] = s;
        }
        short[] interpolate = interpolate(i3, i4, sArr);
        int length2 = interpolate.length;
        if (i6 == 1) {
            byte[] bArr3 = new byte[length2];
            while (i5 < length2) {
                bArr3[i5] = (byte) interpolate[i5];
                i5++;
            }
            bArr2 = bArr3;
        } else {
            byte[] bArr4 = new byte[(length2 * 2)];
            while (i5 < interpolate.length) {
                bArr4[i5 * 2] = (byte) (interpolate[i5] & 255);
                bArr4[(i5 * 2) + 1] = (byte) ((interpolate[i5] >> 8) & 255);
                i5++;
            }
            bArr2 = bArr4;
        }
        this.mSampleRate = i4;
        AppMethodBeat.o(76431);
        return bArr2;
    }

    private short[] interpolate(int i2, int i3, short[] sArr) {
        AppMethodBeat.i(76432);
        if (i2 == i3) {
            AppMethodBeat.o(76432);
            return sArr;
        }
        int round = Math.round((((float) sArr.length) / ((float) i2)) * ((float) i3));
        float length = ((float) round) / ((float) sArr.length);
        short[] sArr2 = new short[round];
        for (int i4 = 0; i4 < round; i4++) {
            float f2 = ((float) i4) / length;
            int i5 = (int) f2;
            int i6 = i5 + 1;
            if (i6 >= sArr.length) {
                i6 = sArr.length - 1;
            }
            sArr2[i4] = (short) ((int) ((((float) (sArr[i6] - sArr[i5])) * (f2 - ((float) i5))) + ((float) sArr[i5])));
        }
        AppMethodBeat.o(76432);
        return sArr2;
    }
}
