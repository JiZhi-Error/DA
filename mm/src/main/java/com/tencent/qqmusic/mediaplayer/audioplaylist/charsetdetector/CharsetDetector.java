package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharsetDetector {
    private static final List<CSRecognizerInfo> ALL_CS_RECOGNIZERS;
    private static final int kBufSize = 8000;
    short[] fByteStats = new short[256];
    boolean fC1Bytes = false;
    String fDeclaredEncoding;
    private boolean[] fEnabledRecognizers;
    byte[] fInputBytes = new byte[8000];
    int fInputLen;
    InputStream fInputStream;
    byte[] fRawInput;
    int fRawLength;
    private boolean fStripTags = false;

    public CharsetDetector() {
        AppMethodBeat.i(76651);
        AppMethodBeat.o(76651);
    }

    public CharsetDetector setDeclaredEncoding(String str) {
        this.fDeclaredEncoding = str;
        return this;
    }

    public CharsetDetector setText(byte[] bArr) {
        this.fRawInput = bArr;
        this.fRawLength = bArr.length;
        return this;
    }

    public CharsetDetector setText(InputStream inputStream) {
        int i2 = 8000;
        AppMethodBeat.i(76652);
        this.fInputStream = inputStream;
        this.fInputStream.mark(8000);
        this.fRawInput = new byte[8000];
        this.fRawLength = 0;
        while (i2 > 0) {
            int read = this.fInputStream.read(this.fRawInput, this.fRawLength, i2);
            if (read <= 0) {
                break;
            }
            this.fRawLength += read;
            i2 -= read;
        }
        this.fInputStream.reset();
        AppMethodBeat.o(76652);
        return this;
    }

    public CharsetMatch detect() {
        AppMethodBeat.i(76653);
        CharsetMatch[] detectAll = detectAll();
        if (detectAll == null || detectAll.length == 0) {
            AppMethodBeat.o(76653);
            return null;
        }
        CharsetMatch charsetMatch = detectAll[0];
        AppMethodBeat.o(76653);
        return charsetMatch;
    }

    public CharsetMatch[] detectAll() {
        CharsetMatch match;
        AppMethodBeat.i(76654);
        ArrayList arrayList = new ArrayList();
        MungeInput();
        for (int i2 = 0; i2 < ALL_CS_RECOGNIZERS.size(); i2++) {
            CSRecognizerInfo cSRecognizerInfo = ALL_CS_RECOGNIZERS.get(i2);
            if ((this.fEnabledRecognizers != null ? this.fEnabledRecognizers[i2] : cSRecognizerInfo.isDefaultEnabled) && (match = cSRecognizerInfo.recognizer.match(this)) != null) {
                arrayList.add(match);
            }
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        CharsetMatch[] charsetMatchArr = (CharsetMatch[]) arrayList.toArray(new CharsetMatch[arrayList.size()]);
        AppMethodBeat.o(76654);
        return charsetMatchArr;
    }

    public Reader getReader(InputStream inputStream, String str) {
        AppMethodBeat.i(76655);
        this.fDeclaredEncoding = str;
        try {
            setText(inputStream);
            CharsetMatch detect = detect();
            if (detect == null) {
                AppMethodBeat.o(76655);
                return null;
            }
            Reader reader = detect.getReader();
            AppMethodBeat.o(76655);
            return reader;
        } catch (IOException e2) {
            AppMethodBeat.o(76655);
            return null;
        }
    }

    public String getString(byte[] bArr, String str) {
        AppMethodBeat.i(76656);
        this.fDeclaredEncoding = str;
        try {
            setText(bArr);
            CharsetMatch detect = detect();
            if (detect == null) {
                AppMethodBeat.o(76656);
                return null;
            }
            String string = detect.getString(-1);
            AppMethodBeat.o(76656);
            return string;
        } catch (IOException e2) {
            AppMethodBeat.o(76656);
            return null;
        }
    }

    public static String[] getAllDetectableCharsets() {
        AppMethodBeat.i(76657);
        String[] strArr = new String[ALL_CS_RECOGNIZERS.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = ALL_CS_RECOGNIZERS.get(i2).recognizer.getName();
        }
        AppMethodBeat.o(76657);
        return strArr;
    }

    public boolean inputFilterEnabled() {
        return this.fStripTags;
    }

    public boolean enableInputFilter(boolean z) {
        boolean z2 = this.fStripTags;
        this.fStripTags = z;
        return z2;
    }

    private void MungeInput() {
        int i2;
        int i3;
        AppMethodBeat.i(76658);
        if (this.fStripTags) {
            i2 = 0;
            i3 = 0;
            boolean z = false;
            int i4 = 0;
            for (int i5 = 0; i5 < this.fRawLength && i4 < this.fInputBytes.length; i5++) {
                byte b2 = this.fRawInput[i5];
                if (b2 == 60) {
                    if (z) {
                        i2++;
                    }
                    i3++;
                    z = true;
                }
                if (!z) {
                    this.fInputBytes[i4] = b2;
                    i4++;
                }
                if (b2 == 62) {
                    z = false;
                }
            }
            this.fInputLen = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i3 < 5 || i3 / 5 < i2 || (this.fInputLen < 100 && this.fRawLength > 600)) {
            int i6 = this.fRawLength;
            if (i6 > 8000) {
                i6 = 8000;
            }
            int i7 = 0;
            while (i7 < i6) {
                this.fInputBytes[i7] = this.fRawInput[i7];
                i7++;
            }
            this.fInputLen = i7;
        }
        Arrays.fill(this.fByteStats, (short) 0);
        for (int i8 = 0; i8 < this.fInputLen; i8++) {
            int i9 = this.fInputBytes[i8] & 255;
            short[] sArr = this.fByteStats;
            sArr[i9] = (short) (sArr[i9] + 1);
        }
        this.fC1Bytes = false;
        for (int i10 = 128; i10 <= 159; i10++) {
            if (this.fByteStats[i10] != 0) {
                this.fC1Bytes = true;
                AppMethodBeat.o(76658);
                return;
            }
        }
        AppMethodBeat.o(76658);
    }

    /* access modifiers changed from: package-private */
    public static class CSRecognizerInfo {
        boolean isDefaultEnabled;
        CharsetRecognizer recognizer;

        CSRecognizerInfo(CharsetRecognizer charsetRecognizer, boolean z) {
            this.recognizer = charsetRecognizer;
            this.isDefaultEnabled = z;
        }
    }

    static {
        AppMethodBeat.i(76661);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF8(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_sjis(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022JP(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022CN(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022KR(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_gb_18030(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_big5(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_1(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_2(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_7_el(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1251(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1256(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_KOI8_R(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr(), false));
        ALL_CS_RECOGNIZERS = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(76661);
    }

    @Deprecated
    public String[] getDetectableCharsets() {
        AppMethodBeat.i(76659);
        ArrayList arrayList = new ArrayList(ALL_CS_RECOGNIZERS.size());
        for (int i2 = 0; i2 < ALL_CS_RECOGNIZERS.size(); i2++) {
            CSRecognizerInfo cSRecognizerInfo = ALL_CS_RECOGNIZERS.get(i2);
            if (this.fEnabledRecognizers == null ? cSRecognizerInfo.isDefaultEnabled : this.fEnabledRecognizers[i2]) {
                arrayList.add(cSRecognizerInfo.recognizer.getName());
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(76659);
        return strArr;
    }

    @Deprecated
    public CharsetDetector setDetectableCharset(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(76660);
        int i2 = 0;
        while (true) {
            if (i2 >= ALL_CS_RECOGNIZERS.size()) {
                z2 = false;
                i2 = -1;
                break;
            }
            CSRecognizerInfo cSRecognizerInfo = ALL_CS_RECOGNIZERS.get(i2);
            if (cSRecognizerInfo.recognizer.getName().equals(str)) {
                z2 = cSRecognizerInfo.isDefaultEnabled == z;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid encoding: \"" + str + "\"");
            AppMethodBeat.o(76660);
            throw illegalArgumentException;
        }
        if (this.fEnabledRecognizers == null && !z2) {
            this.fEnabledRecognizers = new boolean[ALL_CS_RECOGNIZERS.size()];
            for (int i3 = 0; i3 < ALL_CS_RECOGNIZERS.size(); i3++) {
                this.fEnabledRecognizers[i3] = ALL_CS_RECOGNIZERS.get(i3).isDefaultEnabled;
            }
        }
        if (this.fEnabledRecognizers != null) {
            this.fEnabledRecognizers[i2] = z;
        }
        AppMethodBeat.o(76660);
        return this;
    }
}
