package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.wxmm.v2encoder;
import java.io.IOException;

public class FLACRecognition implements IAudioRecognition {
    public static final String TAG = "FLACRecognition";

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(114336);
        if (bArr != null && bArr.length > 0 && new String(bArr).startsWith("flaC")) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.FLAC;
            AppMethodBeat.o(114336);
            return audioType;
        } else if (checkFormatBySoftDecoder(str)) {
            AudioFormat.AudioType audioType2 = AudioFormat.AudioType.FLAC;
            AppMethodBeat.o(114336);
            return audioType2;
        } else {
            AudioFormat.AudioType audioType3 = AudioFormat.AudioType.UNSUPPORT;
            AppMethodBeat.o(114336);
            return audioType3;
        }
    }

    private boolean checkFormatBySoftDecoder(String str) {
        boolean z = false;
        AppMethodBeat.i(114337);
        NativeDecoder nativeDecoder = new NativeDecoder();
        try {
            if (nativeDecoder.init(str, false) == 0) {
                AudioInformation audioInformation = nativeDecoder.getAudioInformation();
                if (audioInformation != null && audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
                    z = true;
                }
                try {
                    nativeDecoder.release();
                } catch (Throwable th) {
                    Logger.e(TAG, th);
                }
                AppMethodBeat.o(114337);
                return z;
            }
            try {
                nativeDecoder.release();
            } catch (Throwable th2) {
                Logger.e(TAG, th2);
            }
            AppMethodBeat.o(114337);
            return z;
        } catch (Throwable th3) {
            Logger.e(TAG, th3);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        AppMethodBeat.i(114338);
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().contains(".flac")) {
                AudioFormat.AudioType audioType = AudioFormat.AudioType.FLAC;
                AppMethodBeat.o(114338);
                return audioType;
            }
            FileDataSource fileDataSource = new FileDataSource(str);
            boolean z = false;
            try {
                fileDataSource.open();
                z = isFlac(fileDataSource);
                fileDataSource.close();
            } catch (IOException e2) {
            }
            if (z) {
                AudioFormat.AudioType audioType2 = AudioFormat.AudioType.FLAC;
                AppMethodBeat.o(114338);
                return audioType2;
            }
        }
        AudioFormat.AudioType audioType3 = AudioFormat.AudioType.UNSUPPORT;
        AppMethodBeat.o(114338);
        return audioType3;
    }

    public static boolean isFlac(IDataSource iDataSource) {
        int i2;
        int i3;
        boolean z;
        int i4;
        AppMethodBeat.i(114339);
        byte[] bArr = new byte[10];
        try {
            iDataSource.readAt(0, bArr, 0, 10);
        } catch (IOException e2) {
        }
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            int i5 = ((bArr[6] & Byte.MAX_VALUE) << 21) + ((bArr[7] & Byte.MAX_VALUE) << 14) + ((bArr[8] & Byte.MAX_VALUE) << 7) + (bArr[9] & Byte.MAX_VALUE);
            if ((bArr[5] & v2encoder.enumCODEC_vcodec2) > 0) {
                i3 = i5 + 20;
                z = true;
            } else {
                i3 = i5 + 10;
                z = false;
            }
            if (!z) {
                byte[] bArr2 = new byte[1];
                try {
                    i4 = iDataSource.readAt((long) i3, bArr2, 0, 1);
                } catch (IOException e3) {
                    i4 = 0;
                }
                while (true) {
                    i2 = i3;
                    if (bArr2[0] != 0 || i4 != 1) {
                        break;
                    }
                    i3 = i2 + 1;
                    try {
                        i4 = iDataSource.readAt((long) i3, bArr2, 0, 1);
                    } catch (IOException e4) {
                    }
                }
            } else {
                i2 = i3;
            }
        } else {
            i2 = 0;
        }
        byte[] bArr3 = new byte[4];
        try {
            iDataSource.readAt((long) i2, bArr3, 0, 4);
        } catch (IOException e5) {
        }
        if (bArr3[0] == 102 && bArr3[1] == 76 && bArr3[2] == 97 && bArr3[3] == 67) {
            AppMethodBeat.o(114339);
            return true;
        }
        AppMethodBeat.o(114339);
        return false;
    }
}
