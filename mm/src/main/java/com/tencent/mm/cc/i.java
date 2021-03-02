package com.tencent.mm.cc;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class i {
    SparseIntArray NDG;
    byte[] NDH;

    private i(SparseIntArray sparseIntArray, byte[] bArr) {
        this.NDG = sparseIntArray;
        this.NDH = bArr;
    }

    public static i a(SparseIntArray sparseIntArray, InputStream inputStream, int i2) {
        AppMethodBeat.i(141264);
        byte[] bArr = new byte[i2];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                Log.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            i iVar = new i(sparseIntArray, bArr);
            AppMethodBeat.o(141264);
            return iVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(141264);
            return null;
        }
    }

    public final String getString(int i2) {
        String str;
        int length;
        AppMethodBeat.i(141265);
        try {
            int indexOfKey = this.NDG.indexOfKey(i2);
            if (indexOfKey < 0) {
                AppMethodBeat.o(141265);
                return null;
            }
            int valueAt = this.NDG.valueAt(indexOfKey);
            if (indexOfKey < this.NDG.size() - 1) {
                length = this.NDG.valueAt(indexOfKey + 1) - valueAt;
            } else {
                length = this.NDH.length - valueAt;
            }
            str = new String(this.NDH, valueAt, length, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(141265);
            return str;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", Util.stackTraceToString(e2));
            str = null;
        } catch (Exception e3) {
            Log.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", Util.stackTraceToString(e3));
            str = null;
        }
    }
}
