package com.google.android.exoplayer2.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends b {
    private static final int bDj = x.bJ("styl");
    private static final int bDk = x.bJ("tbox");
    private final m bDl = new m();
    private boolean bDm;
    private int bDn;
    private int bDo;
    private String bDp;
    private float bDq;
    private int bDr;

    static {
        AppMethodBeat.i(92870);
        AppMethodBeat.o(92870);
    }

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        boolean z;
        AppMethodBeat.i(92865);
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.bDn = bArr[24];
            this.bDo = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.bDp = "Serif".equals(new String(bArr, 43, bArr.length + -43)) ? "serif" : "sans-serif";
            this.bDr = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.bDm = z;
            if (this.bDm) {
                this.bDq = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.bDr);
                this.bDq = x.k(this.bDq, 0.0f, 0.95f);
                AppMethodBeat.o(92865);
                return;
            }
            this.bDq = 0.85f;
            AppMethodBeat.o(92865);
            return;
        }
        this.bDn = 0;
        this.bDo = -1;
        this.bDp = "sans-serif";
        this.bDm = false;
        this.bDq = 0.85f;
        AppMethodBeat.o(92865);
    }

    @Override // com.google.android.exoplayer2.f.b
    public final d b(byte[] bArr, int i2, boolean z) {
        String a2;
        char c2;
        float f2;
        AppMethodBeat.i(92866);
        this.bDl.n(bArr, i2);
        m mVar = this.bDl;
        assertTrue(mVar.xd() >= 2);
        int readUnsignedShort = mVar.readUnsignedShort();
        if (readUnsignedShort == 0) {
            a2 = "";
        } else if (mVar.xd() < 2 || !((c2 = (char) (((mVar.data[mVar.position] & 255) << 8) | (mVar.data[mVar.position + 1] & 255))) == 65279 || c2 == 65534)) {
            a2 = mVar.a(readUnsignedShort, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } else {
            a2 = mVar.a(readUnsignedShort, Charset.forName("UTF-16"));
        }
        if (a2.isEmpty()) {
            b bVar = b.bDs;
            AppMethodBeat.o(92866);
            return bVar;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        a(spannableStringBuilder, this.bDn, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.bDo, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.bDp;
        int length = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f3 = this.bDq;
        while (this.bDl.xd() >= 8) {
            int i3 = this.bDl.position;
            int readInt = this.bDl.readInt();
            int readInt2 = this.bDl.readInt();
            if (readInt2 == bDj) {
                assertTrue(this.bDl.xd() >= 2);
                int readUnsignedShort2 = this.bDl.readUnsignedShort();
                for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
                    m mVar2 = this.bDl;
                    assertTrue(mVar2.xd() >= 12);
                    int readUnsignedShort3 = mVar2.readUnsignedShort();
                    int readUnsignedShort4 = mVar2.readUnsignedShort();
                    mVar2.eZ(2);
                    int readUnsignedByte = mVar2.readUnsignedByte();
                    mVar2.eZ(1);
                    int readInt3 = mVar2.readInt();
                    a(spannableStringBuilder, readUnsignedByte, this.bDn, readUnsignedShort3, readUnsignedShort4, 0);
                    b(spannableStringBuilder, readInt3, this.bDo, readUnsignedShort3, readUnsignedShort4, 0);
                }
                f2 = f3;
            } else if (readInt2 != bDk || !this.bDm) {
                f2 = f3;
            } else {
                assertTrue(this.bDl.xd() >= 2);
                f2 = x.k(((float) this.bDl.readUnsignedShort()) / ((float) this.bDr), 0.0f, 0.95f);
            }
            this.bDl.setPosition(i3 + readInt);
            f3 = f2;
        }
        b bVar2 = new b(new com.google.android.exoplayer2.f.a(spannableStringBuilder, null, f3, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
        AppMethodBeat.o(92866);
        return bVar2;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92867);
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z3 = (i2 & 1) != 0;
            if ((i2 & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z3) {
                if (z) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            if ((i2 & 4) == 0) {
                z2 = false;
            }
            if (z2) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (!z2 && !z3 && !z) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
        AppMethodBeat.o(92867);
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(92868);
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i2 & 255) << 24) | (i2 >>> 8)), i4, i5, i6 | 33);
        }
        AppMethodBeat.o(92868);
    }

    private static void assertTrue(boolean z) {
        AppMethodBeat.i(92869);
        if (!z) {
            f fVar = new f("Unexpected subtitle format.");
            AppMethodBeat.o(92869);
            throw fVar;
        }
        AppMethodBeat.o(92869);
    }
}
