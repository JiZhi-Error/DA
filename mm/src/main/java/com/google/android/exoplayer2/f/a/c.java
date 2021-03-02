package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c extends d {
    private final m bAA = new m();
    private List<com.google.android.exoplayer2.f.a> bAF;
    private List<com.google.android.exoplayer2.f.a> bAG;
    private final l bAU = new l();
    private final int bAV;
    private final a[] bAW;
    private a bAX;
    private b bAY;
    private int bAZ;

    @Override // com.google.android.exoplayer2.f.a.d, com.google.android.exoplayer2.f.e
    public final /* bridge */ /* synthetic */ void ah(long j2) {
        AppMethodBeat.i(92783);
        super.ah(j2);
        AppMethodBeat.o(92783);
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(92781);
        super.af(hVar);
        AppMethodBeat.o(92781);
    }

    @Override // com.google.android.exoplayer2.b.c, com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ void release() {
        AppMethodBeat.i(92779);
        super.release();
        AppMethodBeat.o(92779);
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ i wi() {
        AppMethodBeat.i(92780);
        i wi = super.ug();
        AppMethodBeat.o(92780);
        return wi;
    }

    @Override // com.google.android.exoplayer2.f.a.d
    public final /* bridge */ /* synthetic */ h wj() {
        AppMethodBeat.i(92782);
        h wj = super.uf();
        AppMethodBeat.o(92782);
        return wj;
    }

    public c(int i2) {
        AppMethodBeat.i(92763);
        this.bAV = i2 == -1 ? 1 : i2;
        this.bAW = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.bAW[i3] = new a();
        }
        this.bAX = this.bAW[0];
        wh();
        AppMethodBeat.o(92763);
    }

    @Override // com.google.android.exoplayer2.b.c, com.google.android.exoplayer2.f.a.d
    public final void flush() {
        AppMethodBeat.i(92764);
        super.flush();
        this.bAF = null;
        this.bAG = null;
        this.bAZ = 0;
        this.bAX = this.bAW[this.bAZ];
        wh();
        this.bAY = null;
        AppMethodBeat.o(92764);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final boolean we() {
        return this.bAF != this.bAG;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final d wf() {
        AppMethodBeat.i(92765);
        this.bAG = this.bAF;
        f fVar = new f(this.bAF);
        AppMethodBeat.o(92765);
        return fVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.f.a.d
    public final void a(h hVar) {
        AppMethodBeat.i(92766);
        this.bAA.n(hVar.aKP.array(), hVar.aKP.limit());
        while (this.bAA.xd() >= 3) {
            int readUnsignedByte = this.bAA.readUnsignedByte() & 7;
            int i2 = readUnsignedByte & 3;
            boolean z = (readUnsignedByte & 4) == 4;
            byte readUnsignedByte2 = (byte) this.bAA.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.bAA.readUnsignedByte();
            if ((i2 == 2 || i2 == 3) && z) {
                if (i2 == 3) {
                    wo();
                    int i3 = (readUnsignedByte2 & 192) >> 6;
                    int i4 = readUnsignedByte2 & 63;
                    if (i4 == 0) {
                        i4 = 64;
                    }
                    this.bAY = new b(i3, i4);
                    byte[] bArr = this.bAY.bBz;
                    b bVar = this.bAY;
                    int i5 = bVar.currentIndex;
                    bVar.currentIndex = i5 + 1;
                    bArr[i5] = readUnsignedByte3;
                } else {
                    com.google.android.exoplayer2.i.a.checkArgument(i2 == 2);
                    if (this.bAY != null) {
                        byte[] bArr2 = this.bAY.bBz;
                        b bVar2 = this.bAY;
                        int i6 = bVar2.currentIndex;
                        bVar2.currentIndex = i6 + 1;
                        bArr2[i6] = readUnsignedByte2;
                        byte[] bArr3 = this.bAY.bBz;
                        b bVar3 = this.bAY;
                        int i7 = bVar3.currentIndex;
                        bVar3.currentIndex = i7 + 1;
                        bArr3[i7] = readUnsignedByte3;
                    }
                }
                if (this.bAY.currentIndex == (this.bAY.bBy * 2) - 1) {
                    wo();
                }
            }
        }
        AppMethodBeat.o(92766);
    }

    private void wo() {
        AppMethodBeat.i(92767);
        if (this.bAY == null) {
            AppMethodBeat.o(92767);
            return;
        }
        wp();
        this.bAY = null;
        AppMethodBeat.o(92767);
    }

    private void wp() {
        AppMethodBeat.i(92768);
        if (this.bAY.currentIndex != (this.bAY.bBy * 2) - 1) {
            new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.bAY.bBy * 2) - 1).append(", but current index is ").append(this.bAY.currentIndex).append(" (sequence number ").append(this.bAY.bBx).append("); ignoring packet");
            AppMethodBeat.o(92768);
            return;
        }
        this.bAU.n(this.bAY.bBz, this.bAY.currentIndex);
        int em = this.bAU.em(3);
        int em2 = this.bAU.em(5);
        if (em == 7) {
            this.bAU.en(2);
            em += this.bAU.em(6);
        }
        if (em2 == 0) {
            if (em != 0) {
                new StringBuilder("serviceNumber is non-zero (").append(em).append(") when blockSize is 0");
            }
            AppMethodBeat.o(92768);
        } else if (em != this.bAV) {
            AppMethodBeat.o(92768);
        } else {
            boolean z = false;
            while (this.bAU.wZ() > 0) {
                int em3 = this.bAU.em(8);
                if (em3 == 16) {
                    int em4 = this.bAU.em(8);
                    if (em4 <= 31) {
                        eL(em4);
                    } else if (em4 <= 127) {
                        eP(em4);
                        z = true;
                    } else if (em4 <= 159) {
                        eM(em4);
                    } else if (em4 <= 255) {
                        eQ(em4);
                        z = true;
                    }
                } else if (em3 <= 31) {
                    eJ(em3);
                } else if (em3 <= 127) {
                    eN(em3);
                    z = true;
                } else if (em3 <= 159) {
                    eK(em3);
                    z = true;
                } else if (em3 <= 255) {
                    eO(em3);
                    z = true;
                }
            }
            if (z) {
                this.bAF = wg();
            }
            AppMethodBeat.o(92768);
        }
    }

    private void eJ(int i2) {
        AppMethodBeat.i(92769);
        switch (i2) {
            case 0:
                AppMethodBeat.o(92769);
                return;
            case 3:
                this.bAF = wg();
                AppMethodBeat.o(92769);
                return;
            case 8:
                this.bAX.wk();
                AppMethodBeat.o(92769);
                return;
            case 12:
                wh();
                AppMethodBeat.o(92769);
                return;
            case 13:
                this.bAX.append('\n');
                AppMethodBeat.o(92769);
                return;
            case 14:
                AppMethodBeat.o(92769);
                return;
            default:
                if (i2 >= 17 && i2 <= 23) {
                    this.bAU.en(8);
                    AppMethodBeat.o(92769);
                    return;
                } else if (i2 < 24 || i2 > 31) {
                    AppMethodBeat.o(92769);
                    return;
                } else {
                    this.bAU.en(16);
                    AppMethodBeat.o(92769);
                    return;
                }
        }
    }

    private void eK(int i2) {
        boolean z;
        AppMethodBeat.i(92770);
        switch (i2) {
            case 128:
            case 129:
            case 130:
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
            case 132:
            case 133:
            case g.CTRL_INDEX /*{ENCODED_INT: 134}*/:
            case com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX /*{ENCODED_INT: 135}*/:
                int i3 = i2 - 128;
                if (this.bAZ != i3) {
                    this.bAZ = i3;
                    this.bAX = this.bAW[i3];
                    AppMethodBeat.o(92770);
                    return;
                }
                break;
            case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.bAU.uI()) {
                        this.bAW[8 - i4].clear();
                    }
                }
                AppMethodBeat.o(92770);
                return;
            case 137:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.bAU.uI()) {
                        this.bAW[8 - i5].visible = true;
                    }
                }
                AppMethodBeat.o(92770);
                return;
            case 138:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.bAU.uI()) {
                        this.bAW[8 - i6].visible = false;
                    }
                }
                AppMethodBeat.o(92770);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX /*{ENCODED_INT: 139}*/:
                for (int i7 = 1; i7 <= 8; i7++) {
                    if (this.bAU.uI()) {
                        a aVar = this.bAW[8 - i7];
                        if (!aVar.visible) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar.visible = z;
                    }
                }
                AppMethodBeat.o(92770);
                return;
            case 140:
                for (int i8 = 1; i8 <= 8; i8++) {
                    if (this.bAU.uI()) {
                        this.bAW[8 - i8].reset();
                    }
                }
                AppMethodBeat.o(92770);
                return;
            case 141:
                this.bAU.en(8);
                AppMethodBeat.o(92770);
                return;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                AppMethodBeat.o(92770);
                return;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                wh();
                AppMethodBeat.o(92770);
                return;
            case 144:
                if (!this.bAX.bBl) {
                    this.bAU.en(16);
                    AppMethodBeat.o(92770);
                    return;
                }
                this.bAU.em(4);
                this.bAU.em(2);
                this.bAU.em(2);
                boolean uI = this.bAU.uI();
                boolean uI2 = this.bAU.uI();
                this.bAU.em(3);
                this.bAU.em(3);
                this.bAX.h(uI, uI2);
                AppMethodBeat.o(92770);
                return;
            case 145:
                if (!this.bAX.bBl) {
                    this.bAU.en(24);
                    AppMethodBeat.o(92770);
                    return;
                }
                int m = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
                int m2 = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
                this.bAU.en(2);
                a.q(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
                this.bAX.bf(m, m2);
                AppMethodBeat.o(92770);
                return;
            case 146:
                if (!this.bAX.bBl) {
                    this.bAU.en(16);
                    AppMethodBeat.o(92770);
                    return;
                }
                this.bAU.en(4);
                int em = this.bAU.em(4);
                this.bAU.en(2);
                this.bAU.em(6);
                a aVar2 = this.bAX;
                if (aVar2.row != em) {
                    aVar2.append('\n');
                }
                aVar2.row = em;
                AppMethodBeat.o(92770);
                return;
            case 151:
                if (!this.bAX.bBl) {
                    this.bAU.en(32);
                    AppMethodBeat.o(92770);
                    return;
                }
                int m3 = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
                this.bAU.em(2);
                a.q(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
                this.bAU.uI();
                this.bAU.uI();
                this.bAU.em(2);
                this.bAU.em(2);
                int em2 = this.bAU.em(2);
                this.bAU.en(8);
                this.bAX.be(m3, em2);
                AppMethodBeat.o(92770);
                return;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case JsApiGetBackgroundAudioState.CTRL_INDEX /*{ENCODED_INT: 159}*/:
                int i9 = i2 - 152;
                a aVar3 = this.bAW[i9];
                this.bAU.en(2);
                boolean uI3 = this.bAU.uI();
                boolean uI4 = this.bAU.uI();
                this.bAU.uI();
                int em3 = this.bAU.em(3);
                boolean uI5 = this.bAU.uI();
                int em4 = this.bAU.em(7);
                int em5 = this.bAU.em(8);
                int em6 = this.bAU.em(4);
                int em7 = this.bAU.em(4);
                this.bAU.en(2);
                this.bAU.em(6);
                this.bAU.en(2);
                int em8 = this.bAU.em(3);
                int em9 = this.bAU.em(3);
                aVar3.bBl = true;
                aVar3.visible = uI3;
                aVar3.bBq = uI4;
                aVar3.priority = em3;
                aVar3.bBm = uI5;
                aVar3.bBn = em4;
                aVar3.bBo = em5;
                aVar3.bBp = em6;
                if (aVar3.rowCount != em7 + 1) {
                    aVar3.rowCount = em7 + 1;
                    while (true) {
                        if ((uI4 && aVar3.bAO.size() >= aVar3.rowCount) || aVar3.bAO.size() >= 15) {
                            aVar3.bAO.remove(0);
                        }
                    }
                }
                if (!(em8 == 0 || aVar3.bBr == em8)) {
                    aVar3.bBr = em8;
                    int i10 = em8 - 1;
                    aVar3.be(a.bBh[i10], a.bBd[i10]);
                }
                if (!(em9 == 0 || aVar3.bBs == em9)) {
                    aVar3.bBs = em9;
                    aVar3.h(false, false);
                    aVar3.bf(a.bBa, a.bBk[em9 - 1]);
                }
                if (this.bAZ != i9) {
                    this.bAZ = i9;
                    this.bAX = this.bAW[i9];
                    AppMethodBeat.o(92770);
                    return;
                }
                break;
        }
        AppMethodBeat.o(92770);
    }

    private void eL(int i2) {
        AppMethodBeat.i(92771);
        if (i2 > 7) {
            if (i2 <= 15) {
                this.bAU.en(8);
                AppMethodBeat.o(92771);
                return;
            } else if (i2 <= 23) {
                this.bAU.en(16);
                AppMethodBeat.o(92771);
                return;
            } else if (i2 <= 31) {
                this.bAU.en(24);
            }
        }
        AppMethodBeat.o(92771);
    }

    private void eM(int i2) {
        AppMethodBeat.i(92772);
        if (i2 <= 135) {
            this.bAU.en(32);
            AppMethodBeat.o(92772);
        } else if (i2 <= 143) {
            this.bAU.en(40);
            AppMethodBeat.o(92772);
        } else {
            if (i2 <= 159) {
                this.bAU.en(2);
                this.bAU.en(this.bAU.em(6) * 8);
            }
            AppMethodBeat.o(92772);
        }
    }

    private void eN(int i2) {
        AppMethodBeat.i(92773);
        if (i2 == 127) {
            this.bAX.append(9835);
            AppMethodBeat.o(92773);
            return;
        }
        this.bAX.append((char) (i2 & 255));
        AppMethodBeat.o(92773);
    }

    private void eO(int i2) {
        AppMethodBeat.i(92774);
        this.bAX.append((char) (i2 & 255));
        AppMethodBeat.o(92774);
    }

    private void eP(int i2) {
        AppMethodBeat.i(92775);
        switch (i2) {
            case 32:
                this.bAX.append(' ');
                AppMethodBeat.o(92775);
                return;
            case 33:
                this.bAX.append(160);
                AppMethodBeat.o(92775);
                return;
            case 37:
                this.bAX.append(8230);
                AppMethodBeat.o(92775);
                return;
            case 42:
                this.bAX.append(352);
                AppMethodBeat.o(92775);
                return;
            case 44:
                this.bAX.append(338);
                AppMethodBeat.o(92775);
                return;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                this.bAX.append(9608);
                AppMethodBeat.o(92775);
                return;
            case 49:
                this.bAX.append(8216);
                AppMethodBeat.o(92775);
                return;
            case 50:
                this.bAX.append(8217);
                AppMethodBeat.o(92775);
                return;
            case 51:
                this.bAX.append(8220);
                AppMethodBeat.o(92775);
                return;
            case 52:
                this.bAX.append(8221);
                AppMethodBeat.o(92775);
                return;
            case 53:
                this.bAX.append(8226);
                AppMethodBeat.o(92775);
                return;
            case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                this.bAX.append(8482);
                AppMethodBeat.o(92775);
                return;
            case 58:
                this.bAX.append(353);
                AppMethodBeat.o(92775);
                return;
            case 60:
                this.bAX.append(339);
                AppMethodBeat.o(92775);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                this.bAX.append(8480);
                AppMethodBeat.o(92775);
                return;
            case 63:
                this.bAX.append(376);
                AppMethodBeat.o(92775);
                return;
            case 118:
                this.bAX.append(8539);
                AppMethodBeat.o(92775);
                return;
            case 119:
                this.bAX.append(8540);
                AppMethodBeat.o(92775);
                return;
            case 120:
                this.bAX.append(8541);
                AppMethodBeat.o(92775);
                return;
            case 121:
                this.bAX.append(8542);
                AppMethodBeat.o(92775);
                return;
            case 122:
                this.bAX.append(9474);
                AppMethodBeat.o(92775);
                return;
            case 123:
                this.bAX.append(9488);
                AppMethodBeat.o(92775);
                return;
            case 124:
                this.bAX.append(9492);
                AppMethodBeat.o(92775);
                return;
            case 125:
                this.bAX.append(9472);
                AppMethodBeat.o(92775);
                return;
            case 126:
                this.bAX.append(9496);
                AppMethodBeat.o(92775);
                return;
            case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                this.bAX.append(9484);
                AppMethodBeat.o(92775);
                return;
            default:
                AppMethodBeat.o(92775);
                return;
        }
    }

    private void eQ(int i2) {
        AppMethodBeat.i(92776);
        if (i2 == 160) {
            this.bAX.append(13252);
            AppMethodBeat.o(92776);
            return;
        }
        this.bAX.append('_');
        AppMethodBeat.o(92776);
    }

    private List<com.google.android.exoplayer2.f.a> wg() {
        AppMethodBeat.i(92777);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.bAW[i2].isEmpty() && this.bAW[i2].visible) {
                arrayList.add(this.bAW[i2].wq());
            }
        }
        Collections.sort(arrayList);
        List<com.google.android.exoplayer2.f.a> unmodifiableList = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(92777);
        return unmodifiableList;
    }

    private void wh() {
        AppMethodBeat.i(92778);
        for (int i2 = 0; i2 < 8; i2++) {
            this.bAW[i2].reset();
        }
        AppMethodBeat.o(92778);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public final int bBx;
        public final int bBy;
        public final byte[] bBz;
        int currentIndex = 0;

        public b(int i2, int i3) {
            AppMethodBeat.i(92762);
            this.bBx = i2;
            this.bBy = i3;
            this.bBz = new byte[((i3 * 2) - 1)];
            AppMethodBeat.o(92762);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public static final int bBa = m(2, 2, 2, 0);
        public static final int bBb = m(0, 0, 0, 0);
        public static final int bBc = m(0, 0, 0, 3);
        static final int[] bBd = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] bBe = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] bBf = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] bBg = {false, false, false, true, true, true, false};
        static final int[] bBh = {bBb, bBc, bBb, bBb, bBc, bBb, bBb};
        private static final int[] bBi = {0, 1, 2, 3, 4, 3, 4};
        private static final int[] bBj = {0, 0, 0, 0, 0, 3, 3};
        static final int[] bBk = {bBb, bBb, bBb, bBb, bBb, bBc, bBc};
        final List<SpannableString> bAO = new LinkedList();
        private final SpannableStringBuilder bAP = new SpannableStringBuilder();
        private int bAR;
        boolean bBl;
        boolean bBm;
        int bBn;
        int bBo;
        int bBp;
        boolean bBq;
        int bBr;
        int bBs;
        private int bBt;
        private int bBu;
        private int bBv;
        private int bBw;
        private int backgroundColor;
        private int foregroundColor;
        private int justification;
        int priority;
        int row;
        int rowCount;
        boolean visible;

        static {
            AppMethodBeat.i(92761);
            AppMethodBeat.o(92761);
        }

        public a() {
            AppMethodBeat.i(92749);
            reset();
            AppMethodBeat.o(92749);
        }

        public final void reset() {
            AppMethodBeat.i(92751);
            clear();
            this.bBl = false;
            this.visible = false;
            this.priority = 4;
            this.bBm = false;
            this.bBn = 0;
            this.bBo = 0;
            this.bBp = 0;
            this.rowCount = 15;
            this.bBq = true;
            this.justification = 0;
            this.bBr = 0;
            this.bBs = 0;
            this.bBt = bBb;
            this.foregroundColor = bBa;
            this.backgroundColor = bBb;
            AppMethodBeat.o(92751);
        }

        public final void clear() {
            AppMethodBeat.i(92752);
            this.bAO.clear();
            this.bAP.clear();
            this.bBu = -1;
            this.bAR = -1;
            this.bBv = -1;
            this.bBw = -1;
            this.row = 0;
            AppMethodBeat.o(92752);
        }

        public final void be(int i2, int i3) {
            this.bBt = i2;
            this.justification = i3;
        }

        public final void h(boolean z, boolean z2) {
            AppMethodBeat.i(92753);
            if (this.bBu != -1) {
                if (!z) {
                    this.bAP.setSpan(new StyleSpan(2), this.bBu, this.bAP.length(), 33);
                    this.bBu = -1;
                }
            } else if (z) {
                this.bBu = this.bAP.length();
            }
            if (this.bAR != -1) {
                if (!z2) {
                    this.bAP.setSpan(new UnderlineSpan(), this.bAR, this.bAP.length(), 33);
                    this.bAR = -1;
                    AppMethodBeat.o(92753);
                    return;
                }
            } else if (z2) {
                this.bAR = this.bAP.length();
            }
            AppMethodBeat.o(92753);
        }

        public final void bf(int i2, int i3) {
            AppMethodBeat.i(92754);
            if (!(this.bBv == -1 || this.foregroundColor == i2)) {
                this.bAP.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBv, this.bAP.length(), 33);
            }
            if (i2 != bBa) {
                this.bBv = this.bAP.length();
                this.foregroundColor = i2;
            }
            if (!(this.bBw == -1 || this.backgroundColor == i3)) {
                this.bAP.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBw, this.bAP.length(), 33);
            }
            if (i3 != bBb) {
                this.bBw = this.bAP.length();
                this.backgroundColor = i3;
            }
            AppMethodBeat.o(92754);
        }

        public final void wk() {
            AppMethodBeat.i(92755);
            int length = this.bAP.length();
            if (length > 0) {
                this.bAP.delete(length - 1, length);
            }
            AppMethodBeat.o(92755);
        }

        public final void append(char c2) {
            AppMethodBeat.i(92756);
            if (c2 == '\n') {
                this.bAO.add(wm());
                this.bAP.clear();
                if (this.bBu != -1) {
                    this.bBu = 0;
                }
                if (this.bAR != -1) {
                    this.bAR = 0;
                }
                if (this.bBv != -1) {
                    this.bBv = 0;
                }
                if (this.bBw != -1) {
                    this.bBw = 0;
                }
                while (true) {
                    if ((!this.bBq || this.bAO.size() < this.rowCount) && this.bAO.size() < 15) {
                        break;
                    }
                    this.bAO.remove(0);
                }
            } else {
                this.bAP.append(c2);
            }
            AppMethodBeat.o(92756);
        }

        private SpannableString wm() {
            AppMethodBeat.i(92757);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.bAP);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.bBu != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.bBu, length, 33);
                }
                if (this.bAR != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.bAR, length, 33);
                }
                if (this.bBv != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBv, length, 33);
                }
                if (this.bBw != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBw, length, 33);
                }
            }
            SpannableString spannableString = new SpannableString(spannableStringBuilder);
            AppMethodBeat.o(92757);
            return spannableString;
        }

        public final b wq() {
            Layout.Alignment alignment;
            float f2;
            float f3;
            int i2;
            int i3;
            boolean z = false;
            AppMethodBeat.i(92758);
            if (isEmpty()) {
                AppMethodBeat.o(92758);
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.bAO.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.bAO.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) wm());
            switch (this.justification) {
                case 0:
                case 3:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected justification value: " + this.justification);
                    AppMethodBeat.o(92758);
                    throw illegalArgumentException;
            }
            if (this.bBm) {
                f2 = ((float) this.bBo) / 99.0f;
                f3 = ((float) this.bBn) / 99.0f;
            } else {
                f2 = ((float) this.bBo) / 209.0f;
                f3 = ((float) this.bBn) / 74.0f;
            }
            float f4 = (f2 * 0.9f) + 0.05f;
            float f5 = (f3 * 0.9f) + 0.05f;
            if (this.bBp % 3 == 0) {
                i2 = 0;
            } else if (this.bBp % 3 == 1) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (this.bBp / 3 == 0) {
                i3 = 0;
            } else if (this.bBp / 3 == 1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            if (this.bBt != bBb) {
                z = true;
            }
            b bVar = new b(spannableStringBuilder, alignment, f5, i2, f4, i3, z, this.bBt, this.priority);
            AppMethodBeat.o(92758);
            return bVar;
        }

        public static int q(int i2, int i3, int i4) {
            AppMethodBeat.i(92759);
            int m = m(i2, i3, i4, 0);
            AppMethodBeat.o(92759);
            return m;
        }

        public static int m(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9 = 255;
            AppMethodBeat.i(92760);
            com.google.android.exoplayer2.i.a.bh(i2, 4);
            com.google.android.exoplayer2.i.a.bh(i3, 4);
            com.google.android.exoplayer2.i.a.bh(i4, 4);
            com.google.android.exoplayer2.i.a.bh(i5, 4);
            switch (i5) {
                case 0:
                case 1:
                    i6 = 255;
                    break;
                case 2:
                    i6 = 127;
                    break;
                case 3:
                    i6 = 0;
                    break;
                default:
                    i6 = 255;
                    break;
            }
            if (i2 > 1) {
                i7 = 255;
            } else {
                i7 = 0;
            }
            if (i3 > 1) {
                i8 = 255;
            } else {
                i8 = 0;
            }
            if (i4 <= 1) {
                i9 = 0;
            }
            int argb = Color.argb(i6, i7, i8, i9);
            AppMethodBeat.o(92760);
            return argb;
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(92750);
            if (!this.bBl || (this.bAO.isEmpty() && this.bAP.length() == 0)) {
                AppMethodBeat.o(92750);
                return true;
            }
            AppMethodBeat.o(92750);
            return false;
        }
    }
}
