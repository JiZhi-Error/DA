package com.google.android.exoplayer2.f.a;

import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.d;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends d {
    private static final int[] SK = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] bAu = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] bAv = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] bAw = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 93, TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, d.CTRL_INDEX, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 9632};
    private static final int[] bAx = {TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 189, 191, 8482, TbsListener.ErrorCode.STARTDOWNLOAD_3, TbsListener.ErrorCode.STARTDOWNLOAD_4, 9834, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 32, 232, 226, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, TbsListener.ErrorCode.TPATCH_FAIL, 244, 251};
    private static final int[] bAy = {193, 201, 211, 218, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, 206, 207, TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, 212, 217, cr.CTRL_INDEX, TbsListener.ErrorCode.RENAME_EXCEPTION, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, 187};
    private static final int[] bAz = {195, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.STARTDOWNLOAD_6, TbsListener.ErrorCode.STARTDOWNLOAD_5, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final m bAA = new m();
    private final int bAB;
    private final int bAC;
    private final LinkedList<C0107a> bAD = new LinkedList<>();
    private C0107a bAE = new C0107a(0, 4);
    private List<com.google.android.exoplayer2.f.a> bAF;
    private List<com.google.android.exoplayer2.f.a> bAG;
    private int bAH;
    private int bAI;
    private boolean bAJ;
    private byte bAK;
    private byte bAL;

    @Override // com.google.android.exoplayer2.f.a.d, com.google.android.exoplayer2.f.e
    public final /* bridge */ /* synthetic */ void ah(long j2) {
        AppMethodBeat.i(92748);
        super.ah(j2);
        AppMethodBeat.o(92748);
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(92746);
        super.af(hVar);
        AppMethodBeat.o(92746);
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ i wi() {
        AppMethodBeat.i(92745);
        i wi = super.ug();
        AppMethodBeat.o(92745);
        return wi;
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ h wj() {
        AppMethodBeat.i(92747);
        h wj = super.uf();
        AppMethodBeat.o(92747);
        return wj;
    }

    public a(String str, int i2) {
        AppMethodBeat.i(92738);
        this.bAB = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i2) {
            case 3:
            case 4:
                this.bAC = 2;
                break;
            default:
                this.bAC = 1;
                break;
        }
        eI(0);
        wh();
        AppMethodBeat.o(92738);
    }

    @Override // com.google.android.exoplayer2.b.c, com.google.android.exoplayer2.f.a.d
    public final void flush() {
        AppMethodBeat.i(92739);
        super.flush();
        this.bAF = null;
        this.bAG = null;
        eI(0);
        wh();
        this.bAI = 4;
        this.bAJ = false;
        this.bAK = 0;
        this.bAL = 0;
        AppMethodBeat.o(92739);
    }

    @Override // com.google.android.exoplayer2.b.c, com.google.android.exoplayer2.f.a.d
    public final void release() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final boolean we() {
        return this.bAF != this.bAG;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final com.google.android.exoplayer2.f.d wf() {
        AppMethodBeat.i(92740);
        this.bAG = this.bAF;
        f fVar = new f(this.bAF);
        AppMethodBeat.o(92740);
        return fVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final void a(h hVar) {
        byte readUnsignedByte;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(92741);
        this.bAA.n(hVar.aKP.array(), hVar.aKP.limit());
        boolean z6 = false;
        boolean z7 = false;
        while (this.bAA.xd() >= this.bAB) {
            if (this.bAB == 2) {
                readUnsignedByte = -4;
            } else {
                readUnsignedByte = (byte) this.bAA.readUnsignedByte();
            }
            byte readUnsignedByte2 = (byte) (this.bAA.readUnsignedByte() & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            byte readUnsignedByte3 = (byte) (this.bAA.readUnsignedByte() & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
            if ((readUnsignedByte & 6) == 4 && ((this.bAC != 1 || (readUnsignedByte & 1) == 0) && ((this.bAC != 2 || (readUnsignedByte & 1) == 1) && !(readUnsignedByte2 == 0 && readUnsignedByte3 == 0)))) {
                if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                    this.bAE.append((char) bAx[readUnsignedByte3 & 15]);
                    z7 = true;
                } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                    this.bAE.wk();
                    if ((readUnsignedByte2 & 1) == 0) {
                        this.bAE.append((char) bAy[readUnsignedByte3 & 31]);
                        z7 = true;
                    } else {
                        this.bAE.append((char) bAz[readUnsignedByte3 & 31]);
                        z7 = true;
                    }
                } else if ((readUnsignedByte2 & 224) == 0) {
                    if ((readUnsignedByte2 & 240) == 16) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (this.bAJ && this.bAK == readUnsignedByte2 && this.bAL == readUnsignedByte3) {
                            this.bAJ = false;
                            z6 = true;
                            z7 = true;
                        } else {
                            this.bAJ = true;
                            this.bAK = readUnsignedByte2;
                            this.bAL = readUnsignedByte3;
                        }
                    }
                    if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if ((readUnsignedByte2 & 240) == 16 && (readUnsignedByte3 & 192) == 64) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            if ((readUnsignedByte2 & 247) != 23 || readUnsignedByte3 < 33 || readUnsignedByte3 > 35) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (!z4) {
                                if ((readUnsignedByte2 & 247) == 20 && (readUnsignedByte3 & 240) == 32) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    switch (readUnsignedByte3) {
                                        case 32:
                                            eI(2);
                                            break;
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 40:
                                        default:
                                            if (this.bAH != 0) {
                                                switch (readUnsignedByte3) {
                                                    case 33:
                                                        this.bAE.wk();
                                                        break;
                                                    case 44:
                                                        this.bAF = null;
                                                        if (this.bAH == 1 || this.bAH == 3) {
                                                            wh();
                                                            break;
                                                        }
                                                    case 45:
                                                        if (this.bAH == 1 && !this.bAE.isEmpty()) {
                                                            this.bAE.wl();
                                                            break;
                                                        }
                                                    case 46:
                                                        wh();
                                                        break;
                                                    case 47:
                                                        this.bAF = wg();
                                                        wh();
                                                        break;
                                                }
                                            }
                                            break;
                                        case 37:
                                            this.bAI = 2;
                                            eI(1);
                                            break;
                                        case 38:
                                            this.bAI = 3;
                                            eI(1);
                                            break;
                                        case 39:
                                            this.bAI = 4;
                                            eI(1);
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                                            eI(3);
                                            break;
                                    }
                                }
                            } else {
                                this.bAE.bAQ = readUnsignedByte3 - 32;
                            }
                        } else {
                            int i2 = bAu[readUnsignedByte2 & 7];
                            if ((readUnsignedByte3 & 32) != 0) {
                                i2++;
                            }
                            if (i2 != this.bAE.row) {
                                if (this.bAH != 1 && !this.bAE.isEmpty()) {
                                    this.bAE = new C0107a(this.bAH, this.bAI);
                                    this.bAD.add(this.bAE);
                                }
                                this.bAE.row = i2;
                            }
                            if ((readUnsignedByte3 & 1) == 1) {
                                this.bAE.a(new UnderlineSpan());
                            }
                            int i3 = (readUnsignedByte3 >> 1) & 15;
                            if (i3 > 7) {
                                this.bAE.bai = bAv[i3 & 7];
                            } else if (i3 == 7) {
                                this.bAE.a(new StyleSpan(2));
                                this.bAE.a(new ForegroundColorSpan(-1));
                            } else {
                                this.bAE.a(new ForegroundColorSpan(SK[i3]));
                            }
                        }
                    } else {
                        boolean z8 = (readUnsignedByte3 & 1) == 1;
                        C0107a aVar = this.bAE;
                        if (z8) {
                            aVar.bAR = aVar.bAP.length();
                        } else if (aVar.bAR != -1) {
                            aVar.bAP.setSpan(new UnderlineSpan(), aVar.bAR, aVar.bAP.length(), 33);
                            aVar.bAR = -1;
                        }
                        int i4 = (readUnsignedByte3 >> 1) & 15;
                        if (i4 == 7) {
                            this.bAE.a(new StyleSpan(2), 2);
                            this.bAE.a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.bAE.a(new ForegroundColorSpan(SK[i4]), 1);
                        }
                    }
                    z6 = z;
                    z7 = true;
                } else {
                    this.bAE.append(b(readUnsignedByte2));
                    if ((readUnsignedByte3 & 224) != 0) {
                        this.bAE.append(b(readUnsignedByte3));
                    }
                    z7 = true;
                }
            }
        }
        if (z7) {
            if (!z6) {
                this.bAJ = false;
            }
            if (this.bAH == 1 || this.bAH == 3) {
                this.bAF = wg();
            }
        }
        AppMethodBeat.o(92741);
    }

    private List<com.google.android.exoplayer2.f.a> wg() {
        AppMethodBeat.i(92742);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.bAD.size(); i2++) {
            com.google.android.exoplayer2.f.a wn = this.bAD.get(i2).wn();
            if (wn != null) {
                arrayList.add(wn);
            }
        }
        AppMethodBeat.o(92742);
        return arrayList;
    }

    private void eI(int i2) {
        AppMethodBeat.i(92743);
        if (this.bAH == i2) {
            AppMethodBeat.o(92743);
            return;
        }
        int i3 = this.bAH;
        this.bAH = i2;
        wh();
        if (i3 == 3 || i2 == 1 || i2 == 0) {
            this.bAF = null;
        }
        AppMethodBeat.o(92743);
    }

    private void wh() {
        AppMethodBeat.i(92744);
        this.bAE.reset(this.bAH, this.bAI);
        this.bAD.clear();
        this.bAD.add(this.bAE);
        AppMethodBeat.o(92744);
    }

    private static char b(byte b2) {
        return (char) bAw[(b2 & Byte.MAX_VALUE) - 32];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.f.a.a$a  reason: collision with other inner class name */
    public static class C0107a {
        private int bAH;
        private int bAI;
        private final List<CharacterStyle> bAM = new ArrayList();
        private final List<C0108a> bAN = new ArrayList();
        private final List<SpannableString> bAO = new LinkedList();
        final SpannableStringBuilder bAP = new SpannableStringBuilder();
        int bAQ;
        int bAR;
        int bai;
        int row;

        public C0107a(int i2, int i3) {
            AppMethodBeat.i(92727);
            reset(i2, i3);
            AppMethodBeat.o(92727);
        }

        public final void reset(int i2, int i3) {
            AppMethodBeat.i(92728);
            this.bAM.clear();
            this.bAN.clear();
            this.bAO.clear();
            this.bAP.clear();
            this.row = 15;
            this.bai = 0;
            this.bAQ = 0;
            this.bAH = i2;
            this.bAI = i3;
            this.bAR = -1;
            AppMethodBeat.o(92728);
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(92729);
            if (!this.bAM.isEmpty() || !this.bAN.isEmpty() || !this.bAO.isEmpty() || this.bAP.length() != 0) {
                AppMethodBeat.o(92729);
                return false;
            }
            AppMethodBeat.o(92729);
            return true;
        }

        public final void wk() {
            AppMethodBeat.i(92730);
            int length = this.bAP.length();
            if (length > 0) {
                this.bAP.delete(length - 1, length);
            }
            AppMethodBeat.o(92730);
        }

        public final void wl() {
            AppMethodBeat.i(92731);
            this.bAO.add(wm());
            this.bAP.clear();
            this.bAM.clear();
            this.bAN.clear();
            this.bAR = -1;
            int min = Math.min(this.bAI, this.row);
            while (this.bAO.size() >= min) {
                this.bAO.remove(0);
            }
            AppMethodBeat.o(92731);
        }

        public final void a(CharacterStyle characterStyle) {
            AppMethodBeat.i(92732);
            this.bAM.add(characterStyle);
            AppMethodBeat.o(92732);
        }

        public final void a(CharacterStyle characterStyle, int i2) {
            AppMethodBeat.i(92733);
            this.bAN.add(new C0108a(characterStyle, this.bAP.length(), i2));
            AppMethodBeat.o(92733);
        }

        public final void append(char c2) {
            AppMethodBeat.i(92734);
            this.bAP.append(c2);
            AppMethodBeat.o(92734);
        }

        private SpannableString wm() {
            int i2;
            AppMethodBeat.i(92735);
            int length = this.bAP.length();
            for (int i3 = 0; i3 < this.bAM.size(); i3++) {
                this.bAP.setSpan(this.bAM.get(i3), 0, length, 33);
            }
            for (int i4 = 0; i4 < this.bAN.size(); i4++) {
                C0108a aVar = this.bAN.get(i4);
                if (i4 < this.bAN.size() - aVar.bAT) {
                    i2 = this.bAN.get(aVar.bAT + i4).start;
                } else {
                    i2 = length;
                }
                this.bAP.setSpan(aVar.bAS, aVar.start, i2, 33);
            }
            if (this.bAR != -1) {
                this.bAP.setSpan(new UnderlineSpan(), this.bAR, length, 33);
            }
            SpannableString spannableString = new SpannableString(this.bAP);
            AppMethodBeat.o(92735);
            return spannableString;
        }

        public final com.google.android.exoplayer2.f.a wn() {
            float f2;
            int i2;
            int i3;
            int i4 = 2;
            AppMethodBeat.i(92736);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.bAO.size(); i5++) {
                spannableStringBuilder.append((CharSequence) this.bAO.get(i5));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) wm());
            if (spannableStringBuilder.length() == 0) {
                AppMethodBeat.o(92736);
                return null;
            }
            int i6 = this.bai + this.bAQ;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (this.bAH == 2 && Math.abs(i7) < 3) {
                f2 = 0.5f;
                i2 = 1;
            } else if (this.bAH != 2 || i7 <= 0) {
                f2 = ((((float) i6) / 32.0f) * 0.8f) + 0.1f;
                i2 = 0;
            } else {
                f2 = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.bAH == 1 || this.row > 7) {
                i3 = (this.row - 15) - 2;
            } else {
                i3 = this.row;
                i4 = 0;
            }
            com.google.android.exoplayer2.f.a aVar = new com.google.android.exoplayer2.f.a(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i3, 1, i4, f2, i2, Float.MIN_VALUE);
            AppMethodBeat.o(92736);
            return aVar;
        }

        public final String toString() {
            AppMethodBeat.i(92737);
            String spannableStringBuilder = this.bAP.toString();
            AppMethodBeat.o(92737);
            return spannableStringBuilder;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.android.exoplayer2.f.a.a$a$a  reason: collision with other inner class name */
        public static class C0108a {
            public final CharacterStyle bAS;
            public final int bAT;
            public final int start;

            public C0108a(CharacterStyle characterStyle, int i2, int i3) {
                this.bAS = characterStyle;
                this.start = i2;
                this.bAT = i3;
            }
        }
    }
}
