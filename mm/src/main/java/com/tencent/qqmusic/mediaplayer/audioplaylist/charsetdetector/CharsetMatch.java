package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharsetMatch implements Comparable<CharsetMatch> {
    private String fCharsetName;
    private int fConfidence;
    private InputStream fInputStream = null;
    private String fLang;
    private byte[] fRawInput = null;
    private int fRawLength;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CharsetMatch charsetMatch) {
        AppMethodBeat.i(76637);
        int compareTo = compareTo(charsetMatch);
        AppMethodBeat.o(76637);
        return compareTo;
    }

    public Reader getReader() {
        ByteArrayInputStream byteArrayInputStream;
        AppMethodBeat.i(76632);
        InputStream inputStream = this.fInputStream;
        if (inputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(this.fRawInput, 0, this.fRawLength);
        } else {
            byteArrayInputStream = inputStream;
        }
        try {
            byteArrayInputStream.reset();
            InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, getName());
            AppMethodBeat.o(76632);
            return inputStreamReader;
        } catch (IOException e2) {
            AppMethodBeat.o(76632);
            return null;
        }
    }

    public String getString() {
        AppMethodBeat.i(76633);
        String string = getString(-1);
        AppMethodBeat.o(76633);
        return string;
    }

    public String getString(int i2) {
        AppMethodBeat.i(76634);
        if (this.fInputStream != null) {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[1024];
            Reader reader = getReader();
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = reader.read(cArr, 0, Math.min(i2, 1024));
                if (read >= 0) {
                    sb.append(cArr, 0, read);
                    i2 -= read;
                } else {
                    reader.close();
                    String sb2 = sb.toString();
                    AppMethodBeat.o(76634);
                    return sb2;
                }
            }
        } else {
            String name = getName();
            int indexOf = name.indexOf("_rtl") < 0 ? name.indexOf("_ltr") : name.indexOf("_rtl");
            if (indexOf > 0) {
                name = name.substring(0, indexOf);
            }
            String str = new String(this.fRawInput, name);
            AppMethodBeat.o(76634);
            return str;
        }
    }

    public int getConfidence() {
        return this.fConfidence;
    }

    public String getName() {
        return this.fCharsetName;
    }

    public String getLanguage() {
        return this.fLang;
    }

    public int compareTo(CharsetMatch charsetMatch) {
        if (this.fConfidence > charsetMatch.fConfidence) {
            return 1;
        }
        if (this.fConfidence < charsetMatch.fConfidence) {
            return -1;
        }
        return 0;
    }

    CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i2) {
        AppMethodBeat.i(76635);
        this.fConfidence = i2;
        if (charsetDetector.fInputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = charsetDetector.fInputStream;
        this.fCharsetName = charsetRecognizer.getName();
        this.fLang = charsetRecognizer.getLanguage();
        AppMethodBeat.o(76635);
    }

    CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i2, String str, String str2) {
        AppMethodBeat.i(76636);
        this.fConfidence = i2;
        if (charsetDetector.fInputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = charsetDetector.fInputStream;
        this.fCharsetName = str;
        this.fLang = str2;
        AppMethodBeat.o(76636);
    }
}
